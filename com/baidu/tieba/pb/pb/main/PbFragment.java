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
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
import com.baidu.tieba.a9;
import com.baidu.tieba.ad5;
import com.baidu.tieba.am9;
import com.baidu.tieba.aq4;
import com.baidu.tieba.at4;
import com.baidu.tieba.az8;
import com.baidu.tieba.b95;
import com.baidu.tieba.bc5;
import com.baidu.tieba.bd5;
import com.baidu.tieba.bq4;
import com.baidu.tieba.bq5;
import com.baidu.tieba.bz8;
import com.baidu.tieba.c09;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.ck9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cv5;
import com.baidu.tieba.cw8;
import com.baidu.tieba.d05;
import com.baidu.tieba.dj5;
import com.baidu.tieba.dm5;
import com.baidu.tieba.dr5;
import com.baidu.tieba.en9;
import com.baidu.tieba.ex8;
import com.baidu.tieba.ey8;
import com.baidu.tieba.f05;
import com.baidu.tieba.fm5;
import com.baidu.tieba.fv5;
import com.baidu.tieba.fw4;
import com.baidu.tieba.fx4;
import com.baidu.tieba.fx8;
import com.baidu.tieba.g09;
import com.baidu.tieba.ga9;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gg;
import com.baidu.tieba.gl5;
import com.baidu.tieba.gm9;
import com.baidu.tieba.gq5;
import com.baidu.tieba.h55;
import com.baidu.tieba.hb5;
import com.baidu.tieba.hi;
import com.baidu.tieba.hr5;
import com.baidu.tieba.ht8;
import com.baidu.tieba.hy8;
import com.baidu.tieba.hz8;
import com.baidu.tieba.i55;
import com.baidu.tieba.ia5;
import com.baidu.tieba.ii;
import com.baidu.tieba.in;
import com.baidu.tieba.is5;
import com.baidu.tieba.it8;
import com.baidu.tieba.ix8;
import com.baidu.tieba.iz8;
import com.baidu.tieba.jc5;
import com.baidu.tieba.jg;
import com.baidu.tieba.jl7;
import com.baidu.tieba.jm5;
import com.baidu.tieba.jt4;
import com.baidu.tieba.ju8;
import com.baidu.tieba.jy8;
import com.baidu.tieba.k05;
import com.baidu.tieba.ku8;
import com.baidu.tieba.kx8;
import com.baidu.tieba.ky8;
import com.baidu.tieba.l65;
import com.baidu.tieba.lf9;
import com.baidu.tieba.ll5;
import com.baidu.tieba.ls8;
import com.baidu.tieba.lw5;
import com.baidu.tieba.lx8;
import com.baidu.tieba.m05;
import com.baidu.tieba.m45;
import com.baidu.tieba.mn;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mt9;
import com.baidu.tieba.my4;
import com.baidu.tieba.n05;
import com.baidu.tieba.nc9;
import com.baidu.tieba.ns8;
import com.baidu.tieba.nu8;
import com.baidu.tieba.nw8;
import com.baidu.tieba.o05;
import com.baidu.tieba.oa5;
import com.baidu.tieba.ov8;
import com.baidu.tieba.oy4;
import com.baidu.tieba.p09;
import com.baidu.tieba.pa5;
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
import com.baidu.tieba.pe5;
import com.baidu.tieba.po6;
import com.baidu.tieba.ps8;
import com.baidu.tieba.pt9;
import com.baidu.tieba.pw8;
import com.baidu.tieba.q45;
import com.baidu.tieba.qa5;
import com.baidu.tieba.qc5;
import com.baidu.tieba.qe5;
import com.baidu.tieba.ql9;
import com.baidu.tieba.qo6;
import com.baidu.tieba.qw4;
import com.baidu.tieba.rl9;
import com.baidu.tieba.s95;
import com.baidu.tieba.se5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sf5;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sv4;
import com.baidu.tieba.sv8;
import com.baidu.tieba.sz4;
import com.baidu.tieba.ta5;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.te5;
import com.baidu.tieba.tm;
import com.baidu.tieba.u16;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v45;
import com.baidu.tieba.ve5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vt8;
import com.baidu.tieba.vx4;
import com.baidu.tieba.wt8;
import com.baidu.tieba.ww8;
import com.baidu.tieba.xc5;
import com.baidu.tieba.xe5;
import com.baidu.tieba.xf;
import com.baidu.tieba.xf6;
import com.baidu.tieba.xy4;
import com.baidu.tieba.xy8;
import com.baidu.tieba.yf;
import com.baidu.tieba.yt8;
import com.baidu.tieba.yv8;
import com.baidu.tieba.z05;
import com.baidu.tieba.z45;
import com.baidu.tieba.z8;
import com.baidu.tieba.za;
import com.baidu.tieba.zl9;
import com.baidu.tieba.zy8;
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
public class PbFragment extends BaseFragment implements fv5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, d05.e, TbRichTextView.u, TbPageContextSupport, g09, p09.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k O2;
    public static final qo6.b P2;
    public transient /* synthetic */ FieldHolder $fh;
    public xf<ImageView> A;
    public ForumManageModel A0;
    public final CustomMessageListener A1;
    public final f05.c A2;
    public xf<View> B;
    public s95 B0;
    public CustomMessageListener B1;
    public final f05.c B2;
    public xf<TiebaPlusRecommendCard> C;
    public yt8 C0;
    public CustomMessageListener C1;
    public final AdapterView.OnItemClickListener C2;
    public xf<LinearLayout> D;
    public PollingModel D0;
    public View.OnClickListener D1;
    public final View.OnLongClickListener D2;
    public xf<RelativeLayout> E;
    public ShareSuccessReplyToServerModel E0;
    public CustomMessageListener E1;
    public final View.OnClickListener E2;
    public xf<ItemCardView> F;
    public fx8 F0;
    public CustomMessageListener F1;
    public final ItemCardHelper.c F2;
    public xf<FestivalTipView> G;
    public boolean G0;
    public CustomMessageListener G1;
    public final NoNetworkView.b G2;
    public boolean H;
    public boolean H0;
    public CustomMessageListener H1;
    public View.OnTouchListener H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public po6.b I2;
    public boolean J;
    public ix8 J0;
    public SuggestEmotionModel.c J1;
    public final yv8.b J2;
    public xf<GifView> K;
    public m05 K0;
    public CustomMessageListener K1;
    public int K2;
    public String L;
    public o05 L0;
    public GetSugMatchWordsModel.b L1;
    public int L2;
    public boolean M;
    public String M0;
    public PraiseModel M1;
    public String M2;
    public boolean N;
    public boolean N0;
    public ky8.h N1;
    public fx4 N2;
    public String O;
    public boolean O0;
    public CustomMessageListener O1;
    public LikeModel P;
    public boolean P0;
    public dj5 P1;
    public View Q;
    public String Q0;
    public dj5 Q1;
    public View R;
    public boolean R0;
    public CheckRealNameModel.b R1;
    public View S;
    public rl9 S0;
    public ku8 S1;
    public View T;
    public ve5 T0;
    public final Runnable T1;
    public String U;
    public te5 U0;
    public CustomMessageListener U1;
    public int V;
    public PermissionJudgePolicy V0;
    public CustomMessageListener V1;
    public boolean W;
    public ReplyPrivacyCheckController W0;
    public CustomMessageListener W1;
    public int[] X;
    public qe5 X0;
    public CustomMessageListener X1;
    public int Y;
    public pe5 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public pe5 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public int a1;
    public CustomMessageListener a2;
    public boolean b;
    public xy4 b0;
    public Object b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public a9 c1;
    public d05.e c2;
    public qo6 d;
    public m45 d0;
    public v45 d1;
    public g3 d2;
    public ky8 e;
    public boolean e0;
    public BdUniqueId e1;
    public o05.f e2;
    public boolean f;
    public boolean f0;
    public Runnable f1;
    public final SortSwitchButton.f f2;
    public boolean g;
    public Object g0;
    public kx8 g1;
    public final View.OnClickListener g2;
    public boolean h;
    public ql9 h0;
    public tm h1;
    public CustomMessageListener h2;
    public VoiceManager i;
    public pa5 i0;
    public String i1;
    public final NewWriteModel.d i2;
    public int j;
    public boolean j0;
    public TbRichTextImageInfo j1;
    public Boolean j2;
    public f05 k;
    public TbRichTextMemeInfo k1;
    public NewWriteModel.d k2;
    public long l;
    public boolean l1;
    public za l2;
    public long m;
    public int m1;
    public final PbModel.h m2;
    public long n;
    public int n1;
    public CustomMessageListener n2;
    public long o;
    public List<e3> o1;
    public HttpMessageListener o2;
    public long p;
    public int p1;
    public final at4.a p2;
    public boolean q;
    public xf6 q1;
    public final AbsListView.OnScrollListener q2;
    public boolean r;
    public boolean r0;
    public final e3 r1;
    public final z8 r2;
    public dm5 s;
    @NonNull
    public TiePlusEventController.g s0;
    public final nw8.b s1;
    public final z45.g s2;
    public long t;
    public xy8 t0;
    public final CustomMessageListener t1;
    public final View.OnClickListener t2;
    public boolean u;
    public PushPermissionController u0;
    public CustomMessageListener u1;
    public boolean u2;
    public long v;
    public PbInterviewStatusView.f v0;
    public CustomMessageListener v1;
    public final BdListView.p v2;
    public int w;
    public final Handler w0;
    public CustomMessageListener w1;
    public int w2;
    public String x;
    public PbModel x0;
    public CustomMessageListener x1;
    public final TbRichTextView.a0 x2;
    public xf<TextView> y;
    public iz8 y0;
    public CustomMessageListener y1;
    public boolean y2;
    public xf<TbImageView> z;
    public at4 z0;
    public CustomMessageListener z1;
    public am9 z2;

    /* loaded from: classes5.dex */
    public interface e3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public interface g3 {
        void a(Object obj);
    }

    @Override // com.baidu.tieba.g09
    public AbsVideoPbFragment M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048648, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i d1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fv5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048677, this, context, str) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g09
    public PbFragment w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? this : (PbFragment) invokeV.objValue;
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
                    nu8.a(this.b.a.getPageContext(), this.a).show();
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
                ix8 ix8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ix8Var = this.a.c.J0) != null && ix8Var.g() != null) {
                    if (!this.a.c.J0.g().e()) {
                        this.a.c.J0.b(false);
                    }
                    this.a.c.J0.g().l(false);
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
                if (pbFragment.F0 != null && this.c.F0.W0() != null) {
                    this.c.F0.W0().smoothScrollBy(i3, 50);
                }
                if (this.c.G5().g1() != null) {
                    if (this.c.U0 != null) {
                        this.c.U0.b().setVisibility(8);
                    }
                    this.c.G5().g1().t(this.a, this.b, this.c.G5().h1(), (this.c.x0 == null || this.c.x0.u1() == null || this.c.x0.u1().M() == null || !this.c.x0.u1().M().isBjh()) ? false : false);
                    xe5 f = this.c.G5().g1().f();
                    if (f != null && this.c.x0 != null && this.c.x0.u1() != null) {
                        f.H(this.c.x0.u1().c());
                        f.d0(this.c.x0.u1().M());
                    }
                    if (this.c.J0.f() == null && this.c.G5().g1().f().u() != null) {
                        this.c.G5().g1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.J0.n(pbFragment2.G5().g1().f().u().i());
                        this.c.G5().g1().f().N(this.c.Z0);
                    }
                }
                this.c.G5().q1();
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
                ix8 ix8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ix8Var = this.a.c.J0) != null && ix8Var.g() != null) {
                    if (!this.a.c.J0.g().e()) {
                        this.a.c.J0.b(false);
                    }
                    this.a.c.J0.g().l(false);
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
                if (pbFragment.F0 != null && this.c.F0.W0() != null) {
                    this.c.F0.W0().smoothScrollBy(i3, 50);
                }
                if (this.c.G5().g1() != null) {
                    if (this.c.U0 != null) {
                        this.c.U0.b().setVisibility(8);
                    }
                    this.c.G5().g1().t(this.a, this.b, this.c.G5().h1(), (this.c.x0 == null || this.c.x0.u1() == null || this.c.x0.u1().M() == null || !this.c.x0.u1().M().isBjh()) ? false : false);
                    xe5 f = this.c.G5().g1().f();
                    if (f != null && this.c.x0 != null && this.c.x0.u1() != null) {
                        f.H(this.c.x0.u1().c());
                        f.d0(this.c.x0.u1().M());
                    }
                    if (this.c.J0.f() == null && this.c.G5().g1().f().u() != null) {
                        this.c.G5().g1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.J0.n(pbFragment2.G5().g1().f().u().i());
                        this.c.G5().g1().f().N(this.c.Z0);
                    }
                }
                this.c.G5().q1();
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
            if ((r32.a.F0.b1.a.getView().getTop() - r32.a.F0.h.a.getBottom()) < (r32.a.F0.b1.a.g.getHeight() + 10)) goto L759;
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
            ht8 u1;
            int i;
            int i2;
            am9 V;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            k05 k05Var;
            k05 k05Var2;
            k05 k05Var3;
            String string;
            boolean z;
            k05 k05Var4;
            k05 k05Var5;
            k05 k05Var6;
            k05 k05Var7;
            String name;
            boolean z2;
            int i3;
            int i4;
            sz4 sz4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i5;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || !this.a.isAdded()) {
                return;
            }
            if (this.a.r0 && (view2 == this.a.F0.h.c || view2 == this.a.F0.h.d || view2.getId() == R.id.obfuscated_res_0x7f0919e7 || view2.getId() == R.id.obfuscated_res_0x7f090b0a || view2.getId() == R.id.obfuscated_res_0x7f091d95 || view2.getId() == R.id.obfuscated_res_0x7f091984)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.F0.Z0() && this.a.getPageContext().getPageActivity() != null && this.a.x0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.N1(), this.a.x0.f2(), this.a.x0.e2())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.x0.getForumId());
                    statisticItem2.param("fname", this.a.x0.T0());
                    statisticItem2.param("tid", this.a.x0.N1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.F0.b1()) {
                    if (!this.a.h && this.a.x0.q2(true)) {
                        this.a.h = true;
                        this.a.F0.o3();
                    }
                } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().E()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.F0.t0();
                    this.a.d7();
                    this.a.F0.n3();
                    this.a.F0.I3();
                    if (this.a.F0.e1() != null) {
                        this.a.F0.e1().setVisibility(8);
                    }
                    this.a.x0.g3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().x()) {
                    if (view2 == this.a.F0.h.f) {
                        if (this.a.F0.h0(this.a.x0.h1())) {
                            this.a.d7();
                            return;
                        }
                        ii.z(this.a.a, this.a.F0.h.f);
                        this.a.a.finish();
                    } else if (view2 == this.a.F0.I0() || (this.a.F0.h.h() != null && (view2 == this.a.F0.h.h().F() || view2 == this.a.F0.h.h().G()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.x0.u1() != null && !this.a.A0.j0()) {
                            this.a.F0.t0();
                            int i7 = (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().G()) ? (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().F()) ? view2 == this.a.F0.I0() ? 2 : 0 : this.a.x0.u1().M().getIs_good() == 1 ? 3 : 6 : this.a.x0.u1().M().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.x0.u1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.x0.u1().M().getId();
                            this.a.F0.c4();
                            this.a.A0.n0(id, name3, id2, i7, this.a.F0.J0());
                        }
                    } else if (view2 == this.a.F0.P0()) {
                        if (this.a.x0 != null) {
                            jt4.s(this.a.getPageContext().getPageActivity(), this.a.x0.u1().M().getTopicData().b());
                        }
                    } else if (view2 == this.a.F0.h.c) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.x0.u1() != null && this.a.x0.u1().M() != null && this.a.x0.u1().M().isVideoThreadType() && this.a.x0.u1().M().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.x0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.x0.T0()) || this.a.x0.K0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.x0.K0().b;
                        } else {
                            name2 = this.a.x0.u1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String T0 = this.a.x0.T0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.x0.Z0() || T0 == null || !T0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.F0.h.d) {
                        if (bq5.a()) {
                            return;
                        }
                        if (this.a.x0 == null || this.a.x0.u1() == null) {
                            ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec1));
                            return;
                        }
                        ArrayList<am9> F = this.a.x0.u1().F();
                        if ((F == null || F.size() <= 0) && this.a.x0.M1()) {
                            ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec1));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.x0.N1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x0.getForumId()));
                        this.a.F0.L2();
                        this.a.n6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0919a8) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.F0.Y2(true);
                        this.a.F0.L2();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.F0.S3();
                        this.a.d7();
                        this.a.F0.n3();
                        this.a.x0.k3(this.a.t5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09197f) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.F0.t0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f09197f || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (ex8.c(this.a.getPageContext(), 11009) && this.a.x0.L0(this.a.F0.V0()) != null) {
                                this.a.g6();
                                if (this.a.x0.u1() != null && this.a.x0.u1().M() != null && this.a.x0.u1().M().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.u1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.x0.u1().M() == null || this.a.x0.u1().M().getAuthor() == null || this.a.x0.u1().M().getAuthor().getUserId() == null || this.a.z0 == null) {
                                    return;
                                }
                                int v = ex8.v(this.a.x0.u1());
                                ThreadData M = this.a.x0.u1().M();
                                if (M.isBJHArticleThreadType()) {
                                    i6 = 2;
                                } else if (M.isBJHVideoThreadType()) {
                                    i6 = 3;
                                } else if (M.isBJHNormalThreadType()) {
                                    i6 = 4;
                                } else {
                                    i6 = M.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 1).param("obj_id", this.a.x0.u1().M().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", v).param("obj_param1", i6));
                                return;
                            }
                            return;
                        }
                        this.a.T = view2;
                    } else if ((this.a.F0.h.h() != null && view2 == this.a.F0.h.h().C()) || view2.getId() == R.id.obfuscated_res_0x7f090b0a || view2.getId() == R.id.obfuscated_res_0x7f091d95) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.F0.t0();
                        if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().C()) {
                            this.a.F0.L2();
                        }
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.d7();
                        this.a.F0.n3();
                        boolean l3 = view2.getId() == R.id.obfuscated_res_0x7f090b0a ? this.a.x0.l3(true, this.a.t5()) : view2.getId() == R.id.obfuscated_res_0x7f091d95 ? this.a.x0.l3(false, this.a.t5()) : this.a.x0.k3(this.a.t5());
                        view2.setTag(Boolean.valueOf(l3));
                        if (l3) {
                            i5 = 1;
                            this.a.F0.Y2(true);
                            this.a.F0.S3();
                            this.a.h = true;
                            this.a.F0.c3(true);
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                    } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().y()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (ex8.c(this.a.getPageContext(), 11009)) {
                                ex8.w(this.a.getContext(), 3, this.a.q5(), this.a.x0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091984 || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (u1 = this.a.x0.u1()) == null) {
                                return;
                            }
                            ThreadData M2 = u1.M();
                            if (M2 != null && M2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", u1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                statisticItem3.param("tid", this.a.x0.N1());
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.a.x0.getForumId());
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
                                if (this.a.Q() != null) {
                                    ll5.e(this.a.Q(), statisticItem3);
                                }
                                if (this.a.F0 != null) {
                                    statisticItem3.param("obj_param1", this.a.F0.S0());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (ii.F()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d1b);
                                    return;
                                } else if (u1 == null) {
                                    ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec1));
                                    return;
                                } else {
                                    ArrayList<am9> F2 = this.a.x0.u1().F();
                                    if ((F2 == null || F2.size() <= 0) && this.a.x0.M1()) {
                                        ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec1));
                                        return;
                                    }
                                    this.a.F0.t0();
                                    this.a.d7();
                                    if (u1.A() != null && !StringUtils.isNull(u1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.x0.u1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), M2)) {
                                        return;
                                    }
                                    if (this.a.F0 != null) {
                                        this.a.F0.v0();
                                        this.a.F0.j4(u1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091984) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.F0.T1() && !u1.n0()) {
                                            if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                if (ia5.c() > 0) {
                                                    ex8.E(this.a.getContext(), this.a.x0.u1());
                                                    return;
                                                }
                                                int S0 = this.a.F0.S0();
                                                this.a.F0.g0();
                                                this.a.R5(ia5.a(), S0);
                                                return;
                                            }
                                            this.a.X6(i2);
                                            return;
                                        }
                                        this.a.X6(i2);
                                        return;
                                    }
                                    this.a.F0.I3();
                                    this.a.x0.O0().S(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.x0.N1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.x0.getForumId());
                            if (view2.getId() != R.id.share_num_container) {
                            }
                            statisticItem32.param("obj_name", i);
                            statisticItem32.param("obj_type", 1);
                            if (M2 != null) {
                            }
                            if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            }
                            if (this.a.Q() != null) {
                            }
                            if (this.a.F0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (ii.F()) {
                            }
                        } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().D()) {
                            if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().K()) {
                                if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().J()) {
                                    if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().H()) {
                                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                                        UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                        this.a.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                        if (skinType == 0) {
                                            TbadkCoreApplication.getInst().setSkinType(4);
                                        } else {
                                            q45.m().w("key_is_follow_system_mode", false);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        }
                                        this.a.F0.h.f();
                                        return;
                                    } else if (this.a.F0.T0() == view2) {
                                        if (!this.a.F0.T0().getIndicateStatus()) {
                                            gm9.d("c10725", null);
                                        } else {
                                            ht8 u12 = this.a.x0.u1();
                                            if (u12 != null && u12.M() != null && u12.M().getTaskInfoData() != null) {
                                                String d = u12.M().getTaskInfoData().d();
                                                if (StringUtils.isNull(d)) {
                                                    d = u12.M().getTaskInfoData().g();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                            }
                                        }
                                        this.a.J5();
                                        return;
                                    } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().A()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.F0.t0();
                                        SparseArray<Object> X0 = this.a.F0.X0(this.a.x0.u1(), this.a.x0.M1(), 1);
                                        if (X0 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.u1().k().getId(), this.a.x0.u1().k().getName(), this.a.x0.u1().M().getId(), StringUtils.string(this.a.x0.u1().T().getUserId()), StringUtils.string(X0.get(R.id.tag_forbid_user_name)), StringUtils.string(X0.get(R.id.tag_forbid_user_name_show)), StringUtils.string(X0.get(R.id.tag_forbid_user_post_id)), StringUtils.string(X0.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().u()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> X02 = this.a.F0.X0(this.a.x0.u1(), this.a.x0.M1(), 1);
                                        if (X02 != null) {
                                            this.a.F0.s2(((Integer) X02.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(X02.get(R.id.tag_del_post_id)), ((Integer) X02.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X02.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.F0.h.e();
                                        if (this.a.P() == null || this.a.P().u1() == null || this.a.P().u1().M() == null) {
                                            return;
                                        }
                                        ThreadData M3 = this.a.P().u1().M();
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
                                    } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().z()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> X03 = this.a.F0.X0(this.a.x0.u1(), this.a.x0.M1(), 1);
                                        if (X03 != null) {
                                            if (StringUtils.isNull((String) X03.get(R.id.tag_del_multi_forum))) {
                                                this.a.F0.p2(((Integer) X03.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(X03.get(R.id.tag_del_post_id)), ((Integer) X03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X03.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.F0.q2(((Integer) X03.get(R.id.tag_del_post_type)).intValue(), (String) X03.get(R.id.tag_del_post_id), ((Integer) X03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X03.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(X03.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.F0.h.e();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09216a && view2.getId() != R.id.obfuscated_res_0x7f091998 && view2.getId() != R.id.obfuscated_res_0x7f091827) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0919fa) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0919f8 && view2.getId() != R.id.obfuscated_res_0x7f091bcd && view2.getId() != R.id.obfuscated_res_0x7f091992) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091996) {
                                                    try {
                                                        sparseArray = (SparseArray) view2.getTag();
                                                    } catch (ClassCastException e) {
                                                        e.printStackTrace();
                                                        sparseArray = null;
                                                    }
                                                    am9 am9Var = (am9) sparseArray.get(R.id.tag_clip_board);
                                                    if (am9Var == null) {
                                                        return;
                                                    }
                                                    if (this.a.L0 == null) {
                                                        PbFragment pbFragment = this.a;
                                                        pbFragment.L0 = new o05(pbFragment.getContext());
                                                        this.a.L0.p(this.a.e2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.P().u1() != null && this.a.P().u1().h0();
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
                                                    if (am9Var.n() != null) {
                                                        boolean z4 = am9Var.n().hasAgree;
                                                        int o = am9Var.o();
                                                        if (z4 && o == 5) {
                                                            string = this.a.getString(R.string.action_cancel_dislike);
                                                        } else {
                                                            string = this.a.getString(R.string.action_dislike);
                                                        }
                                                        k05 k05Var8 = new k05(8, string, this.a.L0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, am9Var);
                                                        k05Var8.d.setTag(sparseArray2);
                                                        arrayList.add(k05Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!zy8.j(this.a.x0) && !booleanValue3 && booleanValue2) {
                                                            k05 k05Var9 = new k05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bfc), this.a.L0);
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
                                                            k05Var9.d.setTag(sparseArray3);
                                                            arrayList.add(k05Var9);
                                                        } else if ((ex8.B(this.a.x0.u1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            k05 k05Var10 = new k05(5, this.a.getString(R.string.report_text), this.a.L0);
                                                            k05Var10.d.setTag(str);
                                                            arrayList.add(k05Var10);
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
                                                                    k05 k05Var11 = new k05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d9), this.a.L0);
                                                                    k05Var11.d.setTag(sparseArray4);
                                                                    k05Var2 = k05Var11;
                                                                    k05Var = new k05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                                    k05Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            k05Var2 = null;
                                                            k05Var = new k05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                            k05Var.d.setTag(sparseArray4);
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
                                                            if (this.a.x0.u1().U() == 1002 && !booleanValue) {
                                                                k05Var3 = new k05(6, this.a.getString(R.string.report_text), this.a.L0);
                                                            } else {
                                                                k05Var3 = new k05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d9), this.a.L0);
                                                            }
                                                            k05Var3.d.setTag(sparseArray5);
                                                            k05Var2 = k05Var3;
                                                            k05Var = null;
                                                        } else {
                                                            k05Var = null;
                                                            k05Var2 = null;
                                                        }
                                                        if (k05Var2 != null) {
                                                            arrayList.add(k05Var2);
                                                        }
                                                        if (k05Var != null) {
                                                            arrayList.add(k05Var);
                                                        }
                                                    }
                                                    this.a.L0.k(arrayList);
                                                    this.a.K0 = new m05(this.a.getPageContext(), this.a.L0);
                                                    this.a.K0.k();
                                                    return;
                                                } else if (view2 == this.a.F0.R0()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, gg.g(this.a.x0.u1().l(), 0L), gg.g(this.a.x0.N1(), 0L), gg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.x0.u1().M().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().I()) {
                                                    if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().B()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.x0.N1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.F0.h.e();
                                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f090831 && view2.getId() != R.id.obfuscated_res_0x7f090b07) {
                                                        int id3 = view2.getId();
                                                        if (id3 == R.id.pb_u9_text_view) {
                                                            if (!this.a.checkUpIsLogin() || (sz4Var = (sz4) view2.getTag()) == null || StringUtils.isNull(sz4Var.q1())) {
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{sz4Var.q1()});
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091d98 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                am9 am9Var2 = (am9) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.x0.b));
                                                                }
                                                                if (this.a.L0 == null) {
                                                                    PbFragment pbFragment2 = this.a;
                                                                    pbFragment2.L0 = new o05(pbFragment2.getContext());
                                                                    this.a.L0.p(this.a.e2);
                                                                }
                                                                ArrayList arrayList2 = new ArrayList();
                                                                boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                if (am9Var2 != null) {
                                                                    if (am9Var2.a0() != null && am9Var2.a0().toString().length() > 0) {
                                                                        k05 k05Var12 = new k05(3, this.a.getString(R.string.obfuscated_res_0x7f0f0479), this.a.L0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, am9Var2);
                                                                        k05Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(k05Var12);
                                                                    }
                                                                    this.a.z2 = am9Var2;
                                                                }
                                                                if (this.a.x0.u1().q()) {
                                                                    String u = this.a.x0.u1().u();
                                                                    if (am9Var2 != null && !hi.isEmpty(u) && u.equals(am9Var2.O())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            k05Var4 = new k05(4, this.a.getString(R.string.remove_mark), this.a.L0);
                                                                        } else {
                                                                            k05Var4 = new k05(4, this.a.getString(R.string.obfuscated_res_0x7f0f0b58), this.a.L0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.z2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        k05Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(k05Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!zy8.j(this.a.x0) && !booleanValue9 && booleanValue8) {
                                                                                k05 k05Var13 = new k05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bfc), this.a.L0);
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
                                                                                k05Var4.d.setTag(sparseArray9);
                                                                                arrayList2.add(k05Var13);
                                                                            } else if (ex8.B(this.a.x0.u1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                k05 k05Var14 = new k05(5, this.a.getString(R.string.report_text), this.a.L0);
                                                                                k05Var14.d.setTag(str2);
                                                                                arrayList2.add(k05Var14);
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
                                                                                        k05 k05Var15 = new k05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d9), this.a.L0);
                                                                                        k05Var15.d.setTag(sparseArray10);
                                                                                        k05Var6 = k05Var15;
                                                                                        k05Var5 = new k05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                                                        k05Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                k05Var6 = null;
                                                                                k05Var5 = new k05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                                                k05Var5.d.setTag(sparseArray10);
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
                                                                                if (this.a.x0.u1().U() == 1002 && !booleanValue7) {
                                                                                    k05Var7 = new k05(6, this.a.getString(R.string.report_text), this.a.L0);
                                                                                } else {
                                                                                    k05Var7 = new k05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d9), this.a.L0);
                                                                                }
                                                                                k05Var7.d.setTag(sparseArray11);
                                                                                k05Var6 = k05Var7;
                                                                                k05Var5 = null;
                                                                            } else {
                                                                                k05Var5 = null;
                                                                                k05Var6 = null;
                                                                            }
                                                                            if (k05Var6 != null) {
                                                                                arrayList2.add(k05Var6);
                                                                            }
                                                                            if (k05Var5 != null) {
                                                                                arrayList2.add(k05Var5);
                                                                            }
                                                                        }
                                                                        this.a.L0.k(arrayList2);
                                                                        this.a.K0 = new m05(this.a.getPageContext(), this.a.L0);
                                                                        this.a.K0.k();
                                                                        return;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                }
                                                                SparseArray sparseArray82 = new SparseArray();
                                                                sparseArray82.put(R.id.tag_clip_board, this.a.z2);
                                                                sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                k05Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(k05Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.L0.k(arrayList2);
                                                                this.a.K0 = new m05(this.a.getPageContext(), this.a.L0);
                                                                this.a.K0.k();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.x0.u1() == null || this.a.x0.u1().M() == null || this.a.x0.u1().M().getActUrl() == null) {
                                                                return;
                                                            }
                                                            jt4.s(this.a.getActivity(), this.a.x0.u1().M().getActUrl());
                                                            if (this.a.x0.u1().M().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.x0.u1().M().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string2 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.x0.u1().l()).param("tid", this.a.x0.u1().O()).param("lotterytail", StringUtils.string(string2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.x0.u1().O().equals(string2)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string2, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.F0.r3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0919c2 || id3 == R.id.obfuscated_res_0x7f09198c) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string3 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String s = q45.m().s("tail_link", "");
                                                                String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(s)) {
                                                                    TiebaStatic.log("c10056");
                                                                    jt4.x(view2.getContext(), string3, UtilHelper.urlAddParam(s, "page_from=1&tailSkinId=" + string4), true, true, true);
                                                                }
                                                                this.a.F0.L2();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string4));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                jt4.s(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.q5() != 1 || this.a.x0 == null || this.a.x0.u1() == null) {
                                                                    return;
                                                                }
                                                                c09.u("c10397", this.a.x0.u1().l(), this.a.x0.u1().O(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string5 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                jt4.s(this.a.getActivity(), string5);
                                                                if (this.a.q5() != 1 || this.a.x0 == null || this.a.x0.u1() == null) {
                                                                    return;
                                                                }
                                                                c09.u("c10507", this.a.x0.u1().l(), this.a.x0.u1().O(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091619) {
                                                            this.a.c6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091618) {
                                                            this.a.a6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0925cb) {
                                                            if (this.a.m1 >= 0) {
                                                                if (this.a.x0 != null) {
                                                                    this.a.x0.N2();
                                                                }
                                                                if (this.a.x0 == null || this.a.F0.G0() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    i4 = 0;
                                                                    this.a.F0.G0().i0(this.a.x0.u1(), false);
                                                                }
                                                                this.a.m1 = i4;
                                                                if (this.a.x0 != null) {
                                                                    if (this.a.F0.W0() != null) {
                                                                        this.a.F0.W0().setSelection(this.a.x0.n1());
                                                                    }
                                                                    this.a.x0.R2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (ex8.c(this.a.getPageContext(), 11009)) {
                                                                ex8.w(this.a.getContext(), 8, this.a.q5(), this.a.x0);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091827) {
                                                            SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                            if (sparseArray12 == null) {
                                                                return;
                                                            }
                                                            this.a.b7(sparseArray12);
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091981) {
                                                            if (this.a.F0.W0() == null || this.a.x0 == null || this.a.x0.u1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.F0.W0().getFirstVisiblePosition();
                                                            View childAt = this.a.F0.W0().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean v0 = this.a.x0.u1().v0();
                                                            boolean R1 = this.a.F0.R1();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            ex8.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.x0.u1());
                                                            if ((this.a.x0.u1().M() != null && this.a.x0.u1().M().getReply_num() <= 0) || (R1 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.r6();
                                                                if (this.a.x0.u1().M().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.u1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int j = (int) (ii.j(this.a.getContext()) * 0.6d);
                                                                if (v0) {
                                                                    if (this.a.F0.b1 != null) {
                                                                        if (this.a.F0.b1.a != null && this.a.F0.b1.a.getView() != null) {
                                                                            if (this.a.F0.b1.a.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                } else {
                                                                    if (this.a.F0.e1() != null) {
                                                                        z2 = this.a.F0.e1().getVisibility() == 0;
                                                                        if (!z2 && this.a.F0.b1 != null && this.a.F0.b1.a != null && this.a.F0.b1.a.getView() != null && this.a.F0.b1.a.getView().getParent() != null && this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                }
                                                                if (z2 || R1) {
                                                                    this.a.Z = firstVisiblePosition;
                                                                    this.a.a0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                        int i9 = -j;
                                                                        this.a.F0.W0().setSelectionFromTop(0, i9);
                                                                        this.a.F0.W0().smoothScrollBy(i9, 500);
                                                                    } else {
                                                                        this.a.F0.W0().D(0, 0, 500);
                                                                    }
                                                                } else if (this.a.Z <= 0) {
                                                                    int d2 = ey8.d(this.a.getListView());
                                                                    if (ey8.e(this.a.getListView()) != -1) {
                                                                        d2--;
                                                                    }
                                                                    int g = ii.g(this.a.getContext(), R.dimen.tbds100);
                                                                    if (d2 < 0) {
                                                                        d2 = (ListUtils.getCount(this.a.F0.W0().getData()) - 1) + this.a.F0.W0().getHeaderViewsCount();
                                                                        i3 = 0;
                                                                    } else {
                                                                        i3 = g;
                                                                    }
                                                                    if (this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                        i3 += this.a.F0.h.a.getFixedNavHeight() - 10;
                                                                    }
                                                                    if (this.a.F0.b1 == null || this.a.F0.b1.a == null || this.a.F0.b1.a.getView() == null || this.a.F0.b1.a.getView().getParent() == null) {
                                                                        this.a.F0.W0().setSelectionFromTop(d2, i3 + j);
                                                                        this.a.F0.W0().smoothScrollBy(j, 500);
                                                                    } else {
                                                                        this.a.F0.W0().D(d2, i3, 200);
                                                                    }
                                                                } else if (this.a.F0.W0().getChildAt(this.a.Z) == null) {
                                                                    this.a.F0.W0().setSelectionFromTop(this.a.Z, this.a.a0 + j);
                                                                    this.a.F0.W0().smoothScrollBy(j, 500);
                                                                } else {
                                                                    this.a.F0.W0().D(this.a.Z, this.a.a0, 200);
                                                                }
                                                            }
                                                            if (this.a.x0.u1().M() == null || this.a.x0.u1().M().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.u1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0919e6 || id3 == R.id.obfuscated_res_0x7f0919e7) {
                                                            if (this.a.x0 == null || this.a.x0.u1() == null || this.a.x0.u1().k() == null || hi.isEmpty(this.a.x0.u1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.x0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.x0.T0()) || this.a.x0.K0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.x0.K0().b;
                                                            } else {
                                                                name = this.a.x0.u1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String T02 = this.a.x0.T0();
                                                            if (!this.a.x0.Z0() || T02 == null || !T02.equals(name)) {
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.x0.u1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.x0.N1());
                                                            statisticItem6.param("fid", this.a.x0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.x0.u1().M() != null) {
                                                                statisticItem6.param("nid", this.a.x0.u1().M().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.x0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.x0.N1());
                                                                statisticItem7.param("fid", this.a.x0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091a0c) {
                                                                if (this.a.x0 == null || this.a.x0.u1() == null) {
                                                                    return;
                                                                }
                                                                ht8 u13 = this.a.x0.u1();
                                                                if (this.a.C0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.C0 = new yt8(pbFragment3.getPageContext());
                                                                }
                                                                long g2 = gg.g(u13.O(), 0L);
                                                                long g3 = gg.g(u13.l(), 0L);
                                                                c09.w("c13446", g3);
                                                                PbFragment pbFragment4 = this.a;
                                                                pbFragment4.registerListener(pbFragment4.l2);
                                                                this.a.C0.a(g2, g3);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091a26) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!u16.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        jt4.s(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.x0.N1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090f97) {
                                                                if (view2.getTag() instanceof ThreadData) {
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090f94) {
                                                                if ((view2.getTag() instanceof ThreadData) && this.a.checkUpIsLogin()) {
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.P != null) {
                                                                        this.a.P.i0(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 != R.id.obfuscated_res_0x7f09199a && id3 != R.id.obfuscated_res_0x7f0919f2) {
                                                                if (id3 == R.id.obfuscated_res_0x7f0925e9) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        c09.s(5);
                                                                    }
                                                                    this.a.F6(false);
                                                                    this.a.c7((am9) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.r0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.x0.N1());
                                                                statisticItem8.param("fid", this.a.x0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    c09.s(6);
                                                                }
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.b = false;
                                                                pbFragment5.e5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.x0.t1() != 3 || !this.a.y0() || this.a.x0.u1() == null || !ListUtils.isEmpty(this.a.x0.u1().o())) {
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
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof am9)) {
                                                            return;
                                                        }
                                                        am9 am9Var3 = (am9) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (am9Var3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090832);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090833);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b07);
                                                        if (am9Var3.w0()) {
                                                            am9Var3.X0(false);
                                                            az8.e(am9Var3);
                                                        } else if (this.a.P() != null ? az8.c(this.a.P().u1(), am9Var3) : false) {
                                                            am9Var3.X0(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, am9Var3.w0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, am9Var3.w0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, am9Var3.w0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, am9Var3.w0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.F0.h.f();
                                                    this.a.F0.P3(this.a.C2);
                                                    return;
                                                }
                                            } else if (this.a.x0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0919f8) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.x0.N1());
                                                    statisticItem10.param("fid", this.a.x0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091bcd) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.S = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0919f8 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.S = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof am9) {
                                                        am9 am9Var4 = (am9) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0919f8 && (statisticItem = am9Var4.e0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091bcd || view2.getId() == R.id.obfuscated_res_0x7f091992) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.x0.O1()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", am9Var4.O()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.x0 == null || this.a.x0.u1() == null || this.a.G5().f1() == null || am9Var4.q() == null || am9Var4.E() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.G5().g1() != null) {
                                                            this.a.G5().g1().g();
                                                        }
                                                        wt8 wt8Var = new wt8();
                                                        wt8Var.v(this.a.x0.u1().k());
                                                        wt8Var.z(this.a.x0.u1().M());
                                                        wt8Var.x(am9Var4);
                                                        this.a.G5().f1().m0(wt8Var);
                                                        this.a.G5().f1().setPostId(am9Var4.O());
                                                        this.a.d6(view2, am9Var4.q().getUserId(), "", am9Var4);
                                                        if (this.a.U0 != null) {
                                                            this.a.F0.S2(this.a.U0.y());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (this.a.x0 == null) {
                                            return;
                                        } else {
                                            StatisticItem statisticItem11 = new StatisticItem("c13398");
                                            statisticItem11.param("tid", this.a.x0.N1());
                                            statisticItem11.param("fid", this.a.x0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0919fa || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof am9) {
                                                        am9 am9Var5 = (am9) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = am9Var5.e0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.x0 == null || this.a.x0.u1() == null) {
                                                            return;
                                                        }
                                                        String N1 = this.a.x0.N1();
                                                        String O = am9Var5.O();
                                                        int U = this.a.x0.u1() != null ? this.a.x0.u1().U() : 0;
                                                        AbsPbActivity.e s6 = this.a.s6(O);
                                                        if (s6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(N1, O, "pb", true, false, null, false, null, U, am9Var5.h0(), this.a.x0.u1().c(), false, am9Var5.q().getIconInfo(), 5).addBigImageData(s6.a, s6.b, s6.g, s6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.x0.t1());
                                                        addBigImageData.setFromFrsForumId(this.a.x0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.x0.S1());
                                                        addBigImageData.setKeyFromForumId(this.a.x0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.x0.Z(), this.a.x0.V(), this.a.x0.W(), this.a.x0.U(), this.a.x0.a0());
                                                        addBigImageData.setBjhData(this.a.x0.M0());
                                                        if (this.a.x0.u1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.x0.u1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.x0.u1().T() != null) {
                                                            addBigImageData.setIsManager(this.a.x0.u1().T().getIs_manager());
                                                        }
                                                        if (this.a.x0.u1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.x0.u1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.x0.u1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.x0.u1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.x0.u1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.x0.u1().k().getUser_level());
                                                        }
                                                        if (this.a.F0 != null && this.a.x0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.x0.G.V().S || am9Var5.S);
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
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091827) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.x0.N1());
                                            statisticItem13.param("fid", this.a.x0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091998 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                c09.r("c10517", this.a.x0.u1().l(), 3);
                                                return;
                                            } else if (this.a.x0 == null || this.a.x0.u1() == null) {
                                                return;
                                            } else {
                                                this.a.F0.t0();
                                                SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                am9 am9Var6 = (am9) sparseArray17.get(R.id.tag_load_sub_data);
                                                am9 am9Var7 = (am9) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                if (am9Var6 == null || view4 == null) {
                                                    return;
                                                }
                                                if (am9Var6.I() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem14 = am9Var6.e0;
                                                if (statisticItem14 != null) {
                                                    StatisticItem copy3 = statisticItem14.copy();
                                                    copy3.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091827) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091998) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String N12 = this.a.x0.N1();
                                                String O2 = am9Var6.O();
                                                String O3 = am9Var7 != null ? am9Var7.O() : "";
                                                int U2 = this.a.x0.u1() != null ? this.a.x0.u1().U() : 0;
                                                this.a.d7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091d98) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e s62 = this.a.s6(O2);
                                                    if (am9Var6 == null || this.a.x0 == null || this.a.x0.u1() == null || s62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(N12, O2, "pb", true, false, null, false, O3, U2, am9Var6.h0(), this.a.x0.u1().c(), false, am9Var6.q().getIconInfo(), 5).addBigImageData(s62.a, s62.b, s62.g, s62.j);
                                                    if (!hi.isEmpty(O3)) {
                                                        addBigImageData2.setHighLightPostId(O3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.x0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.x0.Z(), this.a.x0.V(), this.a.x0.W(), this.a.x0.U(), this.a.x0.a0());
                                                    addBigImageData2.setBjhData(this.a.x0.M0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.x0.t1());
                                                    addBigImageData2.setFromFrsForumId(this.a.x0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.x0.S1());
                                                    if (this.a.F0 != null && this.a.x0.G != null && (V = this.a.x0.G.V()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(V.S || am9Var6.S);
                                                    }
                                                    if (this.a.x0.u1() != null && this.a.x0.u1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.x0.u1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e s63 = this.a.s6(O2);
                                                if (this.a.x0 == null || this.a.x0.u1() == null || s63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(N12, O2, "pb", true, false, null, true, null, U2, am9Var6.h0(), this.a.x0.u1().c(), false, am9Var6.q().getIconInfo(), 5).addBigImageData(s63.a, s63.b, s63.g, s63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.x0.t1());
                                                addBigImageData3.setFromFrsForumId(this.a.x0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.x0.S1());
                                                addBigImageData3.setKeyFromForumId(this.a.x0.getForumId());
                                                addBigImageData3.setBjhData(this.a.x0.M0());
                                                addBigImageData3.setTiebaPlusData(this.a.x0.Z(), this.a.x0.V(), this.a.x0.W(), this.a.x0.U(), this.a.x0.a0());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.R = view2;
                                        return;
                                    }
                                } else if (this.a.x0 == null || this.a.x0.u1() == null || this.a.x0.u1().M() == null) {
                                    return;
                                } else {
                                    this.a.F0.h.e();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.N5(pbFragment6.x0.u1().M().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.F0.t0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.x0.K1()));
                            } else {
                                this.a.d7();
                                this.a.F0.n3();
                                m05 m05Var = new m05(this.a.getPageContext());
                                if (this.a.x0.u1().f == null || this.a.x0.u1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.x0.u1().f.size()];
                                    for (int i10 = 0; i10 < this.a.x0.u1().f.size(); i10++) {
                                        strArr[i10] = this.a.x0.u1().f.get(i10).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                m05Var.i(null, strArr, new a(this, m05Var, view2));
                                m05Var.k();
                            }
                        } else {
                            this.a.F0.t0();
                            if (this.a.P().u1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.x0.s1() != null) {
                                this.a.F0.W3(this.a.x0.s1(), this.a.c2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.F0.h.e();
                    }
                } else {
                    this.a.F0.h.f();
                    if (this.a.x0 != null) {
                        this.a.q1.f(this.a.x0.N1());
                    }
                    if (this.a.x0 != null && this.a.x0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.P() == null || this.a.P().u1() == null) {
                            return;
                        }
                        this.a.q1.d(3, 3, this.a.P().u1().O());
                        return;
                    }
                    this.a.q1.b();
                    int i11 = (TbSingleton.getInstance().mCanCallFans || this.a.P() == null || this.a.P().u1() == null || this.a.P().u1().O() == null || !this.a.P().u1().O().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.P() == null || this.a.P().u1() == null) {
                        return;
                    }
                    this.a.q1.d(3, i11, this.a.P().u1().O());
                }
            } else if (!this.a.r0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.x0.N1());
                statisticItem15.param("fid", this.a.x0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    c09.s(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (!(obj instanceof am9)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    am9 am9Var8 = (am9) obj;
                    if (this.a.x0 != null && this.a.x0.u1() != null && this.a.G5().f1() != null && am9Var8.q() != null && am9Var8.E() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.G5().g1() != null) {
                            this.a.G5().g1().g();
                        }
                        wt8 wt8Var2 = new wt8();
                        wt8Var2.v(this.a.x0.u1().k());
                        wt8Var2.z(this.a.x0.u1().M());
                        wt8Var2.x(am9Var8);
                        this.a.G5().f1().m0(wt8Var2);
                        this.a.G5().f1().setPostId(am9Var8.O());
                        this.a.d6(view2, am9Var8.q().getUserId(), "", am9Var8);
                        TiebaStatic.log("c11743");
                        c09.b(this.a.x0.u1(), am9Var8, am9Var8.d0, 8, 1);
                        if (this.a.U0 != null) {
                            this.a.F0.S2(this.a.U0.y());
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
        public class a implements o05.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m05 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ j1 c;

            public a(j1 j1Var, m05 m05Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, m05Var, view2};
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
                this.a = m05Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.x0.L1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.o05.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void M0(o05 o05Var, int i, View view2) {
                boolean m3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, o05Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.x0.L1() != 1 || i != 1) {
                        if (this.c.a.x0.L1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.x0.L1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091a08) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.x0.u1().f != null && this.c.a.x0.u1().f.size() > i) {
                            i = this.c.a.x0.u1().f.get(i).sort_type.intValue();
                        }
                        m3 = this.c.a.x0.m3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.x0.K1()));
                        if (m3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.F0.c3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091a08) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.x0.u1().f != null) {
                        i = this.c.a.x0.u1().f.get(i).sort_type.intValue();
                    }
                    m3 = this.c.a.x0.m3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.x0.K1()));
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.F0 != null && this.a != null) {
                    this.b.a.F0.x2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    d05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    d05Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b95 b95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b95Var, writeData, antiData}) == null) {
                if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0.u1() != null) {
                        statisticItem.param("fid", this.a.x0.u1().l());
                    }
                    statisticItem.param("tid", this.a.x0.N1());
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
                this.a.d7();
                this.a.F0.l3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.D0 != null) {
                    this.a.D0.x0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    jg.a().postDelayed(this.a.T1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.U0 != null && (this.a.U0.x() || this.a.U0.z())) {
                            this.a.U0.w(false, postWriteCallBackData);
                        }
                        this.a.J0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.W0;
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
                        d05 d05Var = new d05(this.a.getActivity());
                        if (hi.isEmpty(postWriteCallBackData.getErrorString())) {
                            d05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            d05Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        d05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new b(this));
                        d05Var.setPositiveButton(R.string.open_now, new c(this));
                        d05Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (b95Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.M6(i, antiData, str);
                        return;
                    }
                }
                this.a.W6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.N6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.F0.I1(this.a.x0.u1());
                    }
                } else if (this.a.x0.X0()) {
                    ht8 u1 = this.a.x0.u1();
                    if (u1 != null && u1.M() != null && u1.M().getAuthor() != null && (userId = u1.M().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.x0.j3()) {
                        this.a.F0.n3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.x0.j3()) {
                    this.a.F0.n3();
                }
                if (this.a.x0.b1()) {
                    c09.p("c10369", this.a.x0.N1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    jg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.x0 != null) {
                    Context context = this.a.getContext();
                    ht8 u12 = this.a.x0.u1();
                    String forumId = this.a.x0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ex8.a(context, u12, forumId, z2, this.a.x0.z1(), this.a.x0.C1(), this.a.x0.B1(), this.a.x0.A1(), this.a.x0.G1(), this.a.x0.H1());
                }
                if (writeData != null) {
                    l65.b(writeData.getContent(), "1");
                }
                if (this.a.W5()) {
                    this.a.g7();
                }
                this.a.U6();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.F0 != null && this.a != null) {
                    this.b.a.F0.x2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    d05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    d05Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b95 b95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b95Var, writeData, antiData}) == null) {
                if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0 != null && this.a.x0.u1() != null) {
                        statisticItem.param("fid", this.a.x0.u1().l());
                    }
                    if (this.a.x0 != null) {
                        statisticItem.param("tid", this.a.x0.N1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.y5()) {
                        this.a.F6(false);
                        ns8.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12f7));
                    }
                    ix8 ix8Var = this.a.J0;
                    if (ix8Var != null) {
                        ix8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        ta5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        l65.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        jg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.W5()) {
                        this.a.g7();
                    }
                    this.a.U6();
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.W0;
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
                    d05 d05Var = new d05(this.a.getActivity());
                    if (hi.isEmpty(postWriteCallBackData.getErrorString())) {
                        d05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        d05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    d05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new b(this));
                    d05Var.setPositiveButton(R.string.open_now, new c(this));
                    d05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.J0 != null) {
                        if (pbFragment.F0 != null && this.a.F0.g1() != null && this.a.F0.g1().f() != null && this.a.F0.g1().f().y()) {
                            this.a.F0.g1().f().w(postWriteCallBackData);
                        }
                        this.a.J0.l(postWriteCallBackData);
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
                h55 h55Var = new h55();
                h55Var.b = R.raw.lottie_bubble_breath_tip;
                h55Var.a = BreatheTipWidget.PointType.LOTTIE;
                h55Var.c = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                i55 i55Var = new i55();
                i55Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f0532);
                i55Var.b = this.a.a.getString(R.string.agree_tip_content);
                i55Var.e = R.drawable.pic_guidecard;
                i55Var.f = ii.g(this.a.a.getContext(), R.dimen.tbds156);
                i55Var.g = ii.g(this.a.a.getContext(), R.dimen.tbds489);
                i55Var.h = ii.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.F0.j1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.F0.j1()));
                breatheTipWidget.f(i55Var, h55Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    q45 m = q45.m();
                    m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    oa5.a("c14828");
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
        public void b(ht8 ht8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ht8Var) == null) {
                this.a.F0.I1(ht8Var);
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
            jm5 jm5Var = new jm5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            jm5Var.c();
            if (z2) {
                j3 = j4;
                jm5Var.B = j3;
                jm5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.x0 != null && this.a.x0.u1() != null && this.a.x0.u1().M() != null) {
                int threadType = this.a.x0.u1().M().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.L, "from_personalize")) {
                        fm5 fm5Var = new fm5();
                        fm5Var.F = 1;
                        fm5Var.a(1005);
                        fm5Var.D = j3;
                        fm5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.L, "from_frs")) {
                        jm5 jm5Var2 = new jm5();
                        jm5Var2.a(1000);
                        jm5Var2.D = j3;
                        jm5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ht8 ht8Var, String str, int i4) {
            ArrayList<am9> arrayList;
            int i5;
            boolean z2;
            xc5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ht8Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090772));
                }
                if (z && ht8Var != null && ht8Var.W() == null && ListUtils.getCount(ht8Var.F()) < 1) {
                    this.a.x0.g3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.F0 != null) {
                        this.a.F0.T3();
                        return;
                    }
                    return;
                }
                if (!this.a.f0) {
                    this.a.f0 = true;
                } else if (this.a.P() != null) {
                    this.a.P().C0();
                }
                this.a.g = true;
                if (this.a.F0 == null) {
                    return;
                }
                this.a.F0.m3();
                if (ht8Var == null || !ht8Var.q0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.F0.o1());
                }
                this.a.F0.w1();
                if (this.a.I) {
                    this.a.F0.q1();
                } else if (!this.a.F0.M1()) {
                    this.a.F0.A3(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && ht8Var != null) {
                    this.a.N0 = true;
                }
                if (ht8Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.F0.o1());
                    this.a.F0.w3();
                }
                String str2 = null;
                if (z && ht8Var != null) {
                    ThreadData M = ht8Var.M();
                    if (M != null && M.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.I6(pbFragment3.T0);
                    }
                    this.a.F0.g1().r(ht8Var);
                    this.a.F0.H3();
                    if (M != null && M.getCartoonThreadData() != null) {
                        this.a.k7(M.getCartoonThreadData());
                    }
                    if (this.a.U0 != null) {
                        this.a.F0.S2(this.a.U0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(ht8Var.T().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(ht8Var.T().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ht8Var.T().getBimg_end_time());
                    if (ht8Var.F() != null && ht8Var.F().size() >= 1 && ht8Var.F().get(0) != null) {
                        this.a.x0.S2(ht8Var.F().get(0).O());
                    } else if (ht8Var.W() != null) {
                        this.a.x0.S2(ht8Var.W().O());
                    }
                    if (this.a.U0 != null) {
                        this.a.U0.H(ht8Var.c());
                        this.a.U0.I(ht8Var.k(), ht8Var.T());
                        this.a.U0.k0(M);
                        this.a.U0.J(this.a.x0.W0(), this.a.x0.N1(), this.a.x0.S0());
                        if (M != null) {
                            this.a.U0.Z(M.isMutiForumThread());
                        }
                    }
                    if (this.a.z0 != null) {
                        this.a.z0.h(ht8Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (ht8Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (ht8Var.h0()) {
                        this.a.q = true;
                    }
                    this.a.F0.T2(this.a.q);
                    if (this.a.t0.f.size() > 0) {
                        ht8Var.P0(this.a.t0.f);
                    }
                    this.a.F0.L3(ht8Var, i2, i3, this.a.x0.M1(), i4, this.a.x0.d1());
                    this.a.F0.a4(ht8Var, this.a.x0.M1());
                    this.a.F0.f4(this.a.x0.X0());
                    AntiData c = ht8Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.U0 != null && this.a.U0.b() != null && (o = this.a.U0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.D1);
                        }
                    }
                    if (!this.a.W && !ListUtils.isEmpty(this.a.x0.u1().F()) && !this.a.x0.h2()) {
                        this.a.W = true;
                        this.a.X4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.Q0)) {
                        ey8.i(this.a.x0.t1(), this.a.getListView(), this.a.Q0);
                        this.a.Q0 = null;
                    } else if (this.a.P0) {
                        this.a.P0 = false;
                        ey8.g(this.a.getListView());
                    } else if (this.a.R0) {
                        this.a.R0 = false;
                        ey8.j(this.a.getListView());
                    } else if (!TextUtils.isEmpty(this.a.x0.k1())) {
                        ey8.f(this.a.getListView(), this.a.x0.k1());
                        this.a.x0.o2();
                    } else {
                        this.a.F0.G3();
                    }
                    this.a.x0.p2(ht8Var.k(), this.a.J1);
                    this.a.x0.t2(this.a.L1);
                    if (this.a.W0 != null && M != null && M.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(M.getAuthor());
                        this.a.W0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.x0 != null && this.a.x0.d2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.F0 != null) {
                        str2 = this.a.F0.h1();
                    }
                    if (this.a.U0 != null && !StringUtils.isNull(str2)) {
                        this.a.U0.c0(TbSingleton.getInstance().getAdVertiComment(ht8Var.o0(), ht8Var.p0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.N0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.x0.K0() != null && !StringUtils.isNull(this.a.x0.K0().c)) {
                                    this.a.F0.h4(this.a.x0.K0());
                                } else {
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.showNetRefreshView(pbFragment5.F0.o1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    lf9.a("pb", false);
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.setNetRefreshViewEmotionMarginTop(ii.g(pbFragment6.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                                }
                            } else {
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.showNetRefreshView(pbFragment7.F0.o1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                lf9.a("pb", false);
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.setNetRefreshViewEmotionMarginTop(ii.g(pbFragment8.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                            }
                            this.a.F0.q1();
                            this.a.F0.p1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.x0.N1());
                            jSONObject.put("fid", this.a.x0.getForumId());
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
                        if (this.a.x0 != null && this.a.x0.u1() != null) {
                            arrayList = this.a.x0.u1().F();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).E() != 1)) {
                            this.a.F0.O2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.Y5()) {
                                this.a.F0.P2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ec2));
                            } else {
                                this.a.F0.P2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ec3));
                            }
                            this.a.F0.I1(this.a.x0.u1());
                        }
                    } else {
                        this.a.F0.O2("");
                    }
                    this.a.F0.A0();
                }
                if (ht8Var != null && ht8Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (ht8Var != null) {
                        i5 = ht8Var.f();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.b2(i5, this.a.F0);
                }
                int n = q45.m().n(q45.q("key_reaction_guide_show_number_pb"), 0);
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
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.x0 == null) {
                return;
            }
            if (this.a.U0 != null && this.a.U0.t) {
                return;
            }
            se5 se5Var = new se5();
            this.a.I6(se5Var);
            PbFragment pbFragment = this.a;
            pbFragment.U0 = (te5) se5Var.a(pbFragment.getContext());
            this.a.U0.W(this.a.a.getPageContext());
            this.a.U0.f0(this.a.i2);
            this.a.U0.g0(this.a.X0);
            te5 te5Var = this.a.U0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            te5Var.A(pageContext, extras);
            this.a.U0.b().E(true);
            this.a.F0.N2(this.a.U0.b());
            if (!this.a.x0.h1()) {
                this.a.U0.q(this.a.x0.N1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.x0.d2()) {
                this.a.U0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.F0 != null) {
                this.a.U0.c0(this.a.F0.h1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                q45 m = q45.m();
                if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    jg.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements qo6.b {
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

        @Override // com.baidu.tieba.qo6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ju8.d();
                } else {
                    ju8.c();
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
        public void a(hy8 hy8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hy8Var) != null) || hy8Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, hy8Var.a()));
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
        public void onNavigationButtonClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) && d05Var != null) {
                d05Var.dismiss();
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
    public class b implements yv8.b {
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

        @Override // com.baidu.tieba.yv8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1606);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d1b);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.F0.r0(str);
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
                        this.a.o6();
                        return;
                    } else {
                        this.a.A6();
                        return;
                    }
                }
                this.a.j0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                this.a.P5();
                my4 s1 = this.a.x0.s1();
                int d1 = this.a.F0.d1();
                if (d1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ec5);
                } else if (s1 != null && d1 > s1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ec5);
                } else {
                    this.a.F0.t0();
                    this.a.d7();
                    this.a.F0.n3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.x0.g3(this.a.F0.d1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d1b);
                    }
                    d05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements z45.g {
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

        @Override // com.baidu.tieba.z45.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.x5()) {
                    this.a.a.finish();
                }
                if (this.a.x0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F0.B0();
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
    public class c implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    d05Var.dismiss();
                    ((TbPageContext) this.a.c1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                d05Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.c1.getPageActivity(), 2, true, 4);
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.F0 != null) {
                this.a.F0.s3(list);
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
                String valueOf = String.valueOf(this.a.x0.u1().T().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.u1().k().getId(), this.a.x0.u1().k().getName(), this.a.x0.u1().M().getId(), valueOf, str, str3, str2, str4)));
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
                if (this.a.x5()) {
                    this.a.a.finish();
                }
                if (this.a.x0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F0.B0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c3 implements po6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.po6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.po6.b
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

        @Override // com.baidu.tieba.po6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.F0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.x5()) {
                    this.b.F0.v1();
                    this.b.F0.M2();
                }
            }
        }

        @Override // com.baidu.tieba.po6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.F0 != null && this.b.e != null) {
                this.b.F0.Q3();
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
    public class d implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.M1 != null && str != null) {
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.M1 == null) {
                return;
            }
            ht8 u1 = this.a.x0.u1();
            if (u1.M().getPraise().getIsLike() == 1) {
                this.a.l7(0);
            } else {
                this.a.l7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, u1.M()));
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements o05.f {
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

        @Override // com.baidu.tieba.o05.f
        public void M0(o05 o05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o05Var, i, view2) == null) {
                if (this.a.K0 != null) {
                    this.a.K0.dismiss();
                }
                this.a.i7(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.h1 != null && !TextUtils.isEmpty(this.a.i1)) {
                                                if (this.a.k1 != null) {
                                                    sf5.a aVar = new sf5.a();
                                                    aVar.a = this.a.i1;
                                                    String str = "";
                                                    if (this.a.k1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.k1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.V4();
                                                }
                                                this.a.h1 = null;
                                                this.a.i1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.h1 != null && !TextUtils.isEmpty(this.a.i1)) {
                                                if (this.a.V0 == null) {
                                                    this.a.V0 = new PermissionJudgePolicy();
                                                }
                                                this.a.V0.clearRequestPermissionList();
                                                this.a.V0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.V0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.g1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.g1 = new kx8(pbFragment.getPageContext());
                                                }
                                                this.a.g1.b(this.a.i1, this.a.h1.n());
                                                this.a.h1 = null;
                                                this.a.i1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            am9 am9Var = this.a.z2;
                                            if (am9Var != null) {
                                                am9Var.I0();
                                                this.a.z2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.h6(view2);
                                            if (this.a.x0.u1().M() != null && this.a.x0.u1().M().getAuthor() != null && this.a.x0.u1().M().getAuthor().getUserId() != null && this.a.z0 != null) {
                                                int v = ex8.v(this.a.x0.u1());
                                                ThreadData M = this.a.x0.u1().M();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 2).param("obj_id", this.a.x0.u1().M().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", v).param("obj_param1", i2));
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
                                                this.a.N5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.Z4(sparseArray2);
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
                                                boolean G = this.a.Q().G(TbadkCoreApplication.getCurrentAccount());
                                                if (G) {
                                                    if (booleanValue2) {
                                                        this.a.F0.r2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                                        return;
                                                    } else {
                                                        this.a.O6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.F0.p2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.O6(sparseArray3, intValue, booleanValue);
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
                                                    this.a.Z4(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.F0.u2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.F0.p2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            am9 am9Var2 = (am9) sparseArray.get(R.id.tag_clip_board);
                                            if (am9Var2.n() == null) {
                                                return;
                                            }
                                            this.a.c5(am9Var2.n());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.x0 != null && this.a.x0.u1() != null) {
                                                this.a.a.S1(mt9.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.x0 != null && this.a.x0.u1() != null) {
                                    this.a.F0.m4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.u6(view3);
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
                            this.a.u6(view4);
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
                    this.a.u6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.F6(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.u6(view6);
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
                if (this.a.u2 && this.a.x5()) {
                    this.a.a6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.e0 && this.a.F0 != null && this.a.F0.i0() && this.a.x0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.x0.N1());
                    statisticItem.param("fid", this.a.x0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.x0.Z0()) {
                        i = 4;
                    } else if (this.a.x0.a1()) {
                        i = 3;
                    } else if (this.a.x0.c1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.e0 = true;
                }
                if (this.a.x0.q2(false)) {
                    this.a.F0.o3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.x0.u1() != null) {
                    this.a.F0.H2();
                }
                this.a.u2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d3 implements nw8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.nw8.b
        public void onSuccess(List<am9> list) {
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

        @Override // com.baidu.tieba.nw8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.F0.b4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
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
                this.a.F0.X3(!this.a.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                if (d05Var != null) {
                    d05Var.dismiss();
                }
                this.d.k5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x0 != null) {
                this.a.x0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                this.b.F0.I3();
                MessageManager.getInstance().sendMessage(this.a);
                d05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements ky8.h {
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

        @Override // com.baidu.tieba.ky8.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.H6(z);
                if (this.a.F0.T0() != null && z) {
                    this.a.F0.X3(false);
                }
                this.a.F0.g2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<fx8> a;
        public WeakReference<PbFragment> b;

        public f3(fx8 fx8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(fx8Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                fx8 fx8Var = this.a.get();
                if (fx8Var != null) {
                    fx8Var.u1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.X6(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        jl7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements o05.f {
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

        @Override // com.baidu.tieba.o05.f
        public void M0(o05 o05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o05Var, i, view2) == null) {
                if (this.e.K0 != null) {
                    this.e.K0.dismiss();
                }
                if (i == 0) {
                    this.e.F0.p2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.e1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.e1);
                    this.e.Z6(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
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
                this.a.F0.t0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.x0 != null && !this.a.x0.isLoading) {
                    this.a.d7();
                    this.a.F0.n3();
                    z = true;
                    if (this.a.x0.u1() != null && this.a.x0.u1().f != null && this.a.x0.u1().f.size() > i) {
                        int intValue = this.a.x0.u1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.x0.O1()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.x0.m3(intValue)) {
                            this.a.h = true;
                            this.a.F0.c3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements d05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ d05 c;
        public final /* synthetic */ PbFragment d;

        public g2(PbFragment pbFragment, MarkData markData, MarkData markData2, d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, d05Var};
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
            this.c = d05Var;
        }

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
                if (this.d.z0 != null) {
                    if (this.d.z0.e()) {
                        this.d.z0.d();
                        this.d.z0.h(false);
                    }
                    this.d.z0.i(this.a);
                    this.d.z0.h(true);
                    this.d.z0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.e7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends dr5<ShareItem> {
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
        @Override // com.baidu.tieba.dr5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel P = this.b.P();
                if (P != null) {
                    P.U2(this.a);
                }
                return bz8.c(this.b.q5(), 2, P);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.O2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.r5().q() != null && this.a.r5().q().getGodUserData() != null) {
                        this.a.r5().q().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.x0 != null && this.a.x0.u1() != null && this.a.x0.u1().M() != null && this.a.x0.u1().M().getAuthor() != null) {
                        this.a.x0.u1().M().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements pe5 {
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

        @Override // com.baidu.tieba.pe5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ix8 ix8Var = this.a.J0;
                if (ix8Var != null && ix8Var.g() != null && this.a.J0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.J0.g().c());
                    if (this.a.F0 != null && this.a.F0.g1() != null && this.a.F0.g1().f() != null && this.a.F0.g1().f().y()) {
                        this.a.F0.g1().f().w(this.a.J0.h());
                    }
                    this.a.J0.b(true);
                    return true;
                }
                return !this.a.b5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements gq5<ShareItem> {
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
        @Override // com.baidu.tieba.gq5
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
    public class i0 extends dj5<TipEvent> {
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
        @Override // com.baidu.tieba.wi5
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
    public class i2 implements d05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ d05 b;
        public final /* synthetic */ PbFragment c;

        public i2(PbFragment pbFragment, MarkData markData, d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, d05Var};
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
            this.b = d05Var;
        }

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.e7();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.x0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.U0 != null) {
                    this.a.F0.S2(this.a.U0.y());
                }
                this.a.F0.L2();
                this.a.F0.t0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends dj5<TopToastEvent> {
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
        @Override // com.baidu.tieba.wi5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.F0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.F0.o1());
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
        public final /* synthetic */ d05 b;
        public final /* synthetic */ PbFragment c;

        public j2(PbFragment pbFragment, MarkData markData, d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, d05Var};
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
            this.b = d05Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.F0 != null && this.c.F0.o1() != null) {
                    this.c.F0.o1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.e7();
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
            this.a.x0.o3((UserPendantData) customResponsedMessage.getData());
            if (this.a.F0 != null && this.a.x0 != null) {
                this.a.F0.F2(this.a.x0.u1(), this.a.x0.M1(), this.a.x0.E1(), this.a.F0.k1());
            }
            if (this.a.F0 != null && this.a.F0.G0() != null) {
                this.a.F0.G0().a0();
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
            fx8 fx8Var = this.b.F0;
            fx8Var.q3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.x0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.x0.b)) {
                return;
            }
            this.a.W6((PostWriteCallBackData) customResponsedMessage.getData());
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
                    if (sv4.c().g()) {
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
                boolean g = sv4.c().g();
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
                if (this.a.F0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.F0.S3();
                } else {
                    this.a.F0.w1();
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
                    if (this.a.U0 != null) {
                        this.a.U0.G(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.F0 != null && this.a.F0.g1() != null && this.a.F0.g1().f() != null) {
                    this.a.F0.g1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements qe5 {
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

        @Override // com.baidu.tieba.qe5
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
                if (sv4.c().g()) {
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
                boolean g = sv4.c().g();
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
            if (this.a.U0 != null) {
                this.a.F0.S2(this.a.U0.y());
            }
            this.a.F0.A3(false);
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
                ps8 ps8Var = (ps8) customResponsedMessage.getData();
                int type = ps8Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (ps8Var.a() == null) {
                                this.a.w6(false, null);
                                return;
                            } else {
                                this.a.w6(true, (MarkData) ps8Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.m5((ForumManageModel.b) ps8Var.a(), false);
                    return;
                }
                this.a.x6((wt8) ps8Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements ls8.d {
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

        @Override // com.baidu.tieba.ls8.d
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
                playVoiceBntNew.setVoiceManager(this.a.x0());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F0 != null && this.a.F0.G0() != null) {
                this.a.F0.G0().a0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements ku8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.ku8.a
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

        @Override // com.baidu.tieba.ku8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091db6) {
                        if (this.a.B6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof am9)) {
                                return false;
                            }
                            am9 am9Var = (am9) obj;
                            if (am9Var.getType() != am9.U0 && !TextUtils.isEmpty(am9Var.s()) && sv4.c().g()) {
                                return this.a.j6(am9Var);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091997) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.b7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.F0.N1() && view2.getId() == R.id.obfuscated_res_0x7f0919b6) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.I0() != null && this.a.I0().b != null) {
                                this.a.I0().b.onClick(view2);
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
                        this.a.b7(sparseArray);
                    }
                }
                if (this.a.U0 != null) {
                    this.a.F0.S2(this.a.U0.y());
                }
                this.a.F0.L2();
                this.a.F0.t0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ku8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.l5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
                        if (this.a.F0 != null && (m1 = this.a.F0.m1()) != null && this.a.F0.W0() != null) {
                            this.a.F0.W0().removeHeaderView(m1);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cv5.a)) {
                cv5.a aVar = (cv5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.K5(aVar.b);
                }
                cv5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.x0 != null && this.a.x0.f1()) {
                    this.a.e6();
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
            this.a.a7();
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements f05.c {
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

        @Override // com.baidu.tieba.f05.c
        public void a(f05 f05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, f05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.M0 = pbFragment.M0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new ov8(this.a.x0.N1(), this.a.M0, "1").start();
                    f05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.M0 = pbFragment2.M0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new ov8(this.a.x0.N1(), this.a.M0, "2").start();
                    f05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.M0 = pbFragment3.M0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.M0);
                    f05Var.e();
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
            this.a.j7();
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
            sv8 G0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.F0.d2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.x0.N1());
                    statisticItem.param("fid", this.a.x0.getForumId());
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
                    this.a.q6(str, i, eVar);
                    if (this.a.x0.G.h0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().U() != null) {
                            ArrayList<TbRichTextImageInfo> U = tbRichTextView.getRichText().U();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < U.size()) {
                                if (U.get(i5) != null) {
                                    arrayList.add(U.get(i5).getSrc());
                                    if (i6 == i4 && str != null && (str.equals(U.get(i5).getSrc()) || str.equals(U.get(i5).R()) || str.equals(U.get(i5).Q()) || str.equals(U.get(i5).getBigSrc()) || str.equals(U.get(i5).T()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = U.get(i5).getSrc();
                                    imageUrlData.originalUrl = U.get(i5).getSrc();
                                    imageUrlData.isLongPic = U.get(i5).X();
                                    concurrentHashMap.put(U.get(i5).getSrc(), imageUrlData);
                                }
                                i5++;
                                i4 = -1;
                            }
                            i3 = i6;
                        } else {
                            i3 = -1;
                        }
                        Rect rect = new Rect();
                        view2.getGlobalVisibleRect(rect);
                        this.a.o5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.x0.F1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.Y5());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.x0 != null) {
                            builder.D(this.a.x0.getFromForumId());
                            if (this.a.x0.u1() != null) {
                                builder.Q(this.a.x0.u1().M());
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
                        builder2.I(this.a.x0.F1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.Y5());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.x0 != null) {
                            builder2.D(this.a.x0.getFromForumId());
                            if (this.a.x0.u1() != null) {
                                builder2.Q(this.a.x0.u1().M());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText m7 = this.a.m7(str, i);
                        if (m7 != null && this.a.w2 >= 0 && this.a.w2 < m7.S().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = it8.a(m7.S().get(this.a.w2));
                            int i7 = 0;
                            while (true) {
                                if (i7 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i7).equals(a)) {
                                    eVar.j = i7;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (m7.getPostId() != 0 && (G0 = this.a.F0.G0()) != null) {
                                ArrayList<in> t = G0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<in> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        in next = it.next();
                                        if ((next instanceof am9) && m7.getPostId() == gg.g(((am9) next).O(), 0L)) {
                                            int i8 = 8;
                                            if (m7.getPostId() == gg.g(this.a.x0.S0(), 0L)) {
                                                i8 = 1;
                                            }
                                            c09.b(this.a.x0.u1(), (am9) next, ((am9) next).d0, i8, 3);
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
                            this.a.o5(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.x0.F1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.Y5());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.x0 != null) {
                                builder3.D(this.a.x0.getFromForumId());
                                if (this.a.x0.u1() != null) {
                                    builder3.Q(this.a.x0.u1().M());
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
                if (this.a.F0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.F0.o1());
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
                    this.a.J6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
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
    public class r2 implements f05.c {
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

        @Override // com.baidu.tieba.f05.c
        public void a(f05 f05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, f05Var, i, view2) == null) {
                if (f05Var != null) {
                    f05Var.e();
                }
                PbFragment pbFragment = this.a;
                am9 am9Var = pbFragment.z2;
                if (am9Var != null) {
                    if (i == 0) {
                        am9Var.I0();
                        this.a.z2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.i6(pbFragment2.z2);
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.z0 == null || this.a.z0.e()) {
                    return;
                }
                this.a.g6();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.e1) {
                this.a.F0.u1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                ht8 u1 = this.a.x0.u1();
                if (u1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    u1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.d1.d(this.a.c1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.c1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.Y6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (hi.isEmpty(errorString2)) {
                        errorString2 = this.a.c1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.d1.c(errorString2);
                } else {
                    this.a.R6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements at4.a {
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

        @Override // com.baidu.tieba.at4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.F0.m3();
                if (z) {
                    if (this.a.z0 != null) {
                        this.a.z0.h(z2);
                    }
                    this.a.x0.i3(z2);
                    if (!this.a.x0.f1()) {
                        this.a.F0.I1(this.a.x0.u1());
                    } else {
                        this.a.e6();
                    }
                    if (z2) {
                        boolean n0 = this.a.x0.u1().n0();
                        if (this.a.z0 != null && !n0) {
                            if (this.a.z0.f() != null && this.a.x0 != null && this.a.x0.u1() != null && this.a.x0.u1().M() != null && this.a.x0.u1().M().getAuthor() != null) {
                                MarkData f = this.a.z0.f();
                                MetaData author = this.a.x0.u1().M().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d5);
                                        this.a.V6();
                                    } else {
                                        this.a.Q6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.U4();
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
                if (this.a.F0 != null && this.a.F0.g1() != null) {
                    cw8 g1 = this.a.F0.g1();
                    if (g1.j()) {
                        g1.h();
                        return true;
                    }
                }
                if (this.a.F0 != null && this.a.F0.U1()) {
                    this.a.F0.y1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.e1) {
                this.a.F0.u1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.d1.d(this.a.c1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (hi.isEmpty(muteMessage)) {
                    muteMessage = this.a.c1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.d1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                d05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t2 implements f05.c {
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

        @Override // com.baidu.tieba.f05.c
        public void a(f05 f05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, f05Var, i, view2) == null) {
                if (f05Var != null) {
                    f05Var.e();
                }
                if (this.a.h1 != null && !TextUtils.isEmpty(this.a.i1)) {
                    if (i == 0) {
                        if (this.a.k1 != null) {
                            sf5.a aVar = new sf5.a();
                            aVar.a = this.a.i1;
                            String str = "";
                            if (this.a.k1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.k1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.V4();
                        }
                    } else if (i == 1) {
                        if (this.a.V0 == null) {
                            this.a.V0 = new PermissionJudgePolicy();
                        }
                        this.a.V0.clearRequestPermissionList();
                        this.a.V0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.V0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.g1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.g1 = new kx8(pbFragment.getPageContext());
                        }
                        this.a.g1.b(this.a.i1, this.a.h1.n());
                    }
                    this.a.h1 = null;
                    this.a.i1 = null;
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
                if (!this.a.W5() || this.a.a == null || this.a.a.I1() == null || !str.equals(this.a.a.I1().getTopicId())) {
                    return;
                }
                this.a.h7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements d05.e {
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

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                d05Var.dismiss();
                this.b.B0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.x0.getForumId(), "0");
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.x0 == null || this.a.x0.D1() == i + 1) {
                return;
            }
            this.a.E6(ex8.p(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vx4)) {
                vx4 vx4Var = (vx4) customResponsedMessage.getData();
                oy4.a aVar = new oy4.a();
                int i = vx4Var.a;
                String str = vx4Var.b;
                aVar.a = vx4Var.d;
                ht8 u1 = this.a.x0.u1();
                if (u1 == null) {
                    return;
                }
                if (this.a.x0.W0() != null && this.a.x0.W0().getUserIdLong() == vx4Var.p) {
                    this.a.F0.E2(vx4Var.l, this.a.x0.u1(), this.a.x0.M1(), this.a.x0.E1());
                }
                if (u1.F() != null && u1.F().size() >= 1 && u1.F().get(0) != null) {
                    long g = gg.g(u1.F().get(0).O(), 0L);
                    long g2 = gg.g(this.a.x0.N1(), 0L);
                    if (g == vx4Var.n && g2 == vx4Var.m) {
                        oy4 M = u1.F().get(0).M();
                        if (M == null) {
                            M = new oy4();
                        }
                        ArrayList<oy4.a> a = M.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        M.e(M.b() + vx4Var.l);
                        M.d(a);
                        u1.F().get(0).O0(M);
                        this.a.F0.G0().a0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pt9) && customResponsedMessage.getOrginalMessage().getTag() == this.a.e1) {
                pt9 pt9Var = (pt9) customResponsedMessage.getData();
                this.a.F0.u1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.b1;
                DataRes dataRes = pt9Var.a;
                boolean z = false;
                if (pt9Var.c == 0 && dataRes != null) {
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
                        this.a.F0.t2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.S6(z, sparseArray);
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
            ArrayList<am9> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.x0 != null && this.a.x0.u1() != null && this.a.F0 != null && this.a.F0.G0() != null) {
                this.a.F0.m2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.x0.i2() && (F = this.a.x0.u1().F()) != null && !F.isEmpty()) {
                    int w = ((i + i2) - this.a.F0.G0().w()) - 1;
                    ht8 u1 = this.a.x0.u1();
                    if (u1 == null) {
                        return;
                    }
                    if (u1.C() != null && u1.C().q1()) {
                        w--;
                    }
                    if (u1.D() != null && u1.D().q1()) {
                        w--;
                    }
                    int size = F.size();
                    if (w < 0 || w >= size) {
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (!ex8.A(this.a.a1) && ex8.A(i)) {
                    if (this.a.F0 != null) {
                        this.a.j0 = true;
                        this.a.F0.t0();
                        if (this.a.U0 != null && !this.a.F0.J1()) {
                            this.a.F0.S2(this.a.U0.y());
                        }
                        if (!this.a.I) {
                            this.a.j0 = true;
                            this.a.F0.L2();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.F0 != null) {
                    this.a.F0.n2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new dm5();
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
                this.a.a1 = i;
                if (i == 0) {
                    ck9.g().h(this.a.getUniqueId(), true);
                    this.a.X4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements o05.d {
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

        @Override // com.baidu.tieba.o05.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.L0 != null) {
                this.a.L0.q(zy8.h(this.a.z2));
                ArrayList arrayList = new ArrayList();
                for (n05 n05Var : this.a.L0.g()) {
                    if (n05Var instanceof k05) {
                        arrayList.add((k05) n05Var);
                    }
                }
                zy8.f(arrayList);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lw5)) {
                lw5 lw5Var = (lw5) customResponsedMessage.getData();
                ht8 u1 = this.a.x0.u1();
                if (u1 == null) {
                    return;
                }
                if (this.a.x0.u1() != null && this.a.x0.u1().V().q() != null && this.a.x0.u1().V().q().getPortrait() != null && this.a.x0.u1().V().q().getPortrait().equals(lw5Var.a)) {
                    if (this.a.x0.u1().V().q().getUserWorldCupData() != null) {
                        this.a.x0.u1().V().q().getUserWorldCupData().d(lw5Var.b);
                    }
                    this.a.F0.F2(this.a.x0.u1(), this.a.x0.M1(), this.a.x0.E1(), this.a.F0.k1());
                }
                if (u1.F() != null && u1.F().size() >= 0) {
                    Iterator<am9> it = u1.F().iterator();
                    while (it.hasNext()) {
                        am9 next = it.next();
                        if (next != null && next.q() != null && next.q().getPortrait() != null && next.q().getPortrait().equals(lw5Var.a) && next.q().getUserWorldCupData() != null) {
                            next.q().getUserWorldCupData().d(lw5Var.b);
                        }
                    }
                    this.a.F0.G0().a0();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.F0.J1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.l5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements pe5 {
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

        @Override // com.baidu.tieba.pe5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ix8 ix8Var = this.a.J0;
                if (ix8Var != null && ix8Var.e() != null && this.a.J0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.J0.e().c());
                    if (this.a.U0 != null && (this.a.U0.x() || this.a.U0.z())) {
                        this.a.U0.w(false, this.a.J0.h());
                    }
                    this.a.J0.a(true);
                    return true;
                }
                return !this.a.b5(ReplyPrivacyCheckController.TYPE_THREAD);
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
                return pbFragment.e5(view2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && this.a.x0.u1() != null) {
                this.a.x0.u1().a();
                this.a.x0.Y1();
                if (this.a.F0.G0() != null) {
                    this.a.F0.I1(this.a.x0.u1());
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
            ql9 ql9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ql9) && (ql9Var = (ql9) customResponsedMessage.getData()) != null && (agreeData = ql9Var.b) != null) {
                if (this.a.F0 != null) {
                    this.a.F0.Z1(ql9Var);
                }
                if (agreeData.agreeType == 2 && this.a.F0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !bz8.h(this.a.x0.b)) {
                    this.a.F0.V3();
                    bz8.b(this.a.x0.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements Comparator<hb5> {
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
        public int compare(hb5 hb5Var, hb5 hb5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hb5Var, hb5Var2)) == null) {
                return hb5Var.compareTo(hb5Var2);
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
            zl9 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && this.a.x0.u1() != null) {
                String str = (String) customResponsedMessage.getData();
                zl9 zl9Var = null;
                if (!TextUtils.isEmpty(str) && this.a.x0.u1().F() != null) {
                    ArrayList<am9> F = this.a.x0.u1().F();
                    Iterator<am9> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        am9 next = it.next();
                        if (next instanceof zl9) {
                            zl9 zl9Var2 = (zl9) next;
                            if (str.equals(zl9Var2.r1())) {
                                zl9Var = zl9Var2;
                                break;
                            }
                        }
                    }
                    if (zl9Var != null) {
                        F.remove(zl9Var);
                    }
                }
                if (this.a.F0.G0() != null && !ListUtils.isEmpty(this.a.F0.G0().t())) {
                    ArrayList<in> t = this.a.F0.G0().t();
                    if (zl9Var != null) {
                        i = zl9Var;
                    } else {
                        i = ex8.i(this.a.x0.u1(), str);
                    }
                    ex8.e(t, i);
                }
                if (this.a.F0.W0() != null && !ListUtils.isEmpty(this.a.F0.W0().getData())) {
                    List<in> data = this.a.F0.W0().getData();
                    if (zl9Var == null) {
                        zl9Var = ex8.i(this.a.x0.u1(), str);
                    }
                    ex8.e(data, zl9Var);
                }
                this.a.g5(str);
                this.a.x0.Y1();
                if (this.a.F0.G0() != null) {
                    this.a.F0.G0().a0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.G5() != null) {
                this.a.G5().j2();
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
        public void onNavigationButtonClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d05Var) == null) {
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
            this.a.h5();
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
                this.a.l1 = true;
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
                switch (this.a.A0.getLoadDataMode()) {
                    case 0:
                        this.a.x0.Y1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.m5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.F0.C0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.n5(pbFragment.A0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.F0.C0(this.a.A0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.F0.o2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.F0.C0(this.a.A0.getLoadDataMode(), false, null, false);
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
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.x0.j1()) {
                    this.a.y6();
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
        O2 = new a1();
        P2 = new a();
    }

    public static PbFragment k6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65662, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv5
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fv5
    /* renamed from: A5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            fx8 fx8Var = this.F0;
            if (fx8Var == null) {
                return null;
            }
            return fx8Var.W0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void A6() {
        pa5 pa5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pa5Var = this.i0) != null) {
            pa5Var.x();
        }
    }

    public int B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.L2;
        }
        return invokeV.intValue;
    }

    public int C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.K2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fv5
    public xf<TiebaPlusRecommendCard> D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.C == null) {
                this.C = new xf<>(new m2(this), 5, 0);
            }
            return this.C;
        }
        return (xf) invokeV.objValue;
    }

    public te5 D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.U0;
        }
        return (te5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            fx8 fx8Var = this.F0;
            if (fx8Var == null) {
                return 0;
            }
            return fx8Var.j1();
        }
        return invokeV.intValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public ky8 E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (ky8) invokeV.objValue;
    }

    public xy8 F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.t0;
        }
        return (xy8) invokeV.objValue;
    }

    public fx8 G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.F0;
        }
        return (fx8) invokeV.objValue;
    }

    public jy8 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.a.I0();
        }
        return (jy8) invokeV.objValue;
    }

    public String I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public xf<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g09
    public PbModel.h J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.m2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g09
    public PbModel P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.x0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g09
    public AbsPbActivity Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void Q5() {
        fx8 fx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (fx8Var = this.F0) != null) {
            fx8Var.s1();
            P5();
        }
    }

    @Override // com.baidu.tieba.fv5
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

    public final void T5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new m0(this));
        }
    }

    @Override // com.baidu.tieba.fv5
    public xf<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.G == null) {
                this.G = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.G;
        }
        return (xf) invokeV.objValue;
    }

    public final void U6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && qa5.g(TbadkCoreApplication.getInst(), 0) && !this.F0.w2()) {
            this.i0 = qa5.k(getPageContext(), "reply_pb", 0L);
        }
    }

    public boolean V5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.Z0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv5
    public xf<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.A == null) {
                this.A = new xf<>(new k2(this), 8, 0);
            }
            return this.A;
        }
        return (xf) invokeV.objValue;
    }

    public final boolean W5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.I1() != null && this.a.I1().t1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv5
    public xf<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.B == null) {
                this.B = new xf<>(new n2(this), 8, 0);
            }
            return this.B;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv5
    public xf<TextView> X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (xf) invokeV.objValue;
    }

    public boolean Y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void e6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            ht8 u12 = this.x0.u1();
            this.x0.i3(true);
            at4 at4Var = this.z0;
            if (at4Var != null) {
                u12.I0(at4Var.g());
            }
            this.F0.I1(u12);
        }
    }

    public final void e7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048671, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.T1();
        }
    }

    public void f6() {
        fx8 fx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048674, this) != null) || (fx8Var = this.F0) == null) {
            return;
        }
        fx8Var.W1();
    }

    @Override // com.baidu.tieba.fv5
    public xf<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            if (this.F == null) {
                this.F = new xf<>(new p2(this), 10, 0);
            }
            return this.F;
        }
        return (xf) invokeV.objValue;
    }

    public void o6() {
        pa5 pa5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && (pa5Var = this.i0) != null) {
            pa5Var.q();
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
            y6();
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

    public AntiData p5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null) {
                return this.x0.u1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public am9 r5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            ht8 ht8Var = this.x0.G;
            if (ht8Var != null) {
                return ht8Var.V();
            }
            return null;
        }
        return (am9) invokeV.objValue;
    }

    public String s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public boolean t6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            pa5 pa5Var = this.i0;
            if (pa5Var != null && pa5Var.t()) {
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
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && (pbModel = this.x0) != null && !hi.isEmpty(pbModel.N1())) {
            super.taskStart();
        }
    }

    public PbInterviewStatusView.f w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return this.v0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv5
    public xf<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            if (this.K == null) {
                this.K = new xf<>(new l2(this), 20, 0);
            }
            return this.K;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            if (!this.c && this.K2 == -1 && this.L2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    public boolean y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.j2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            hideNetRefreshView(this.F0.o1());
            T6();
            if (this.x0.u2()) {
                this.F0.n3();
            }
            this.F0.w3();
        }
    }

    public boolean z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.J;
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
        this.v0 = new e0(this);
        this.w0 = new Handler(new p0(this));
        this.x0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.N0 = false;
        this.P0 = false;
        this.R0 = false;
        this.X0 = new l1(this);
        this.Y0 = new w1(this);
        this.Z0 = new h2(this);
        this.a1 = 0;
        this.l1 = false;
        this.m1 = 0;
        this.n1 = -1;
        this.p1 = 0;
        this.r1 = new s2(this);
        this.s1 = new d3(this);
        this.t1 = new j(this, 2004016);
        this.u1 = new k(this, 2016485);
        this.v1 = new l(this, 2001269);
        this.w1 = new m(this, 2004008);
        this.x1 = new n(this, 2004007);
        this.y1 = new o(this, 2004005);
        this.z1 = new p(this, 2001332);
        this.A1 = new q(this, 2921391);
        this.B1 = new r(this, 2921606);
        this.C1 = new s(this, 2921658);
        this.D1 = new u(this);
        this.E1 = new v(this, 2001369);
        this.F1 = new w(this, 2921787);
        this.G1 = new x(this, 2016488);
        this.H1 = new y(this, 2016331);
        this.I1 = new z(this, 2921746);
        this.J1 = new a0(this);
        this.K1 = new b0(this, 2010045);
        this.L1 = new c0(this);
        this.M1 = new PraiseModel(getPageContext(), new d0(this));
        this.N1 = new f0(this);
        this.O1 = new h0(this, 2001115);
        this.P1 = new i0(this);
        this.Q1 = new j0(this);
        this.S1 = new ku8(new o0(this));
        this.T1 = new r0(this);
        this.U1 = new s0(this, 2001427);
        this.V1 = new t0(this, 2001428);
        this.W1 = new u0(this, 2921634);
        this.X1 = new v0(this, 2001426);
        this.Y1 = new w0(this, 2004021);
        this.Z1 = new x0(this, 2016528);
        this.a2 = new y0(this, 2921724);
        this.b2 = new z0(this, 2921033);
        this.c2 = new b1(this);
        this.d2 = new c1(this);
        this.e2 = new d1(this);
        this.f2 = new g1(this);
        this.g2 = new j1(this);
        this.h2 = new k1(this, 2921480);
        this.i2 = new m1(this);
        this.j2 = Boolean.FALSE;
        this.k2 = new n1(this);
        this.l2 = new o1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.m2 = new p1(this);
        this.n2 = new q1(this, 2016450);
        this.o2 = new r1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.p2 = new s1(this);
        this.q2 = new v1(this);
        this.r2 = new z1(this);
        this.s2 = new b2(this);
        this.t2 = new c2(this);
        this.v2 = new d2(this);
        this.w2 = 0;
        this.x2 = new q2(this);
        this.y2 = false;
        this.z2 = null;
        this.A2 = new r2(this);
        this.B2 = new t2(this);
        this.C2 = new u2(this);
        this.D2 = new w2(this);
        this.E2 = new x2(this);
        this.F2 = new y2(this);
        this.G2 = new z2(this);
        this.H2 = new b3(this);
        this.I2 = new c3(this);
        this.J2 = new b(this);
        this.K2 = -1;
        this.L2 = -1;
    }

    @Override // com.baidu.tieba.fv5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.fv5
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, context, str) == null) {
            lx8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    public final void R5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i3, i4) == null) {
            hr5.b(new h(this, i4), new i(this, i4, i3));
        }
    }

    @Override // com.baidu.tieba.fv5
    public void j0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        fx8 fx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048717, this, i3, keyEvent)) == null) {
            if (keyEvent != null && (fx8Var = this.F0) != null) {
                return fx8Var.e2(i3);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i3) == null) && this.x0 != null) {
            T6();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.x0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void F6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z3) == null) {
            this.j2 = Boolean.valueOf(z3);
        }
    }

    public void G6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z3) == null) {
            this.r0 = z3;
        }
    }

    public void H6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z3) == null) {
            this.M = z3;
        }
    }

    public void K6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z3) == null) {
            this.J = z3;
        }
    }

    public final void L6(boolean z3) {
        te5 te5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048609, this, z3) != null) || (te5Var = this.U0) == null) {
            return;
        }
        te5Var.X(z3);
        this.U0.a0(z3);
        this.U0.i0(z3);
    }

    public final void O5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, intent) == null) {
            bz8.g(this, intent);
        }
    }

    public void S4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, e3Var) == null) && e3Var != null) {
            if (this.o1 == null) {
                this.o1 = new ArrayList();
            }
            if (!this.o1.contains(e3Var)) {
                this.o1.add(e3Var);
            }
        }
    }

    public void T4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, e3Var) == null) && e3Var != null) {
            if (this.o1 == null) {
                this.o1 = new ArrayList();
            }
            if (!this.o1.contains(e3Var)) {
                this.o1.add(0, e3Var);
            }
        }
    }

    public final void X6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i3) == null) {
            bz8.j(this, q5(), i3);
        }
    }

    public final void Z5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void h6(View view2) {
        SparseArray sparseArray;
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (am9Var = (am9) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            i6(am9Var);
        }
    }

    @Override // com.baidu.tieba.p09.b
    public void j1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z3) == null) {
            this.O0 = z3;
        }
    }

    public final void k7(fx4 fx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048694, this, fx4Var) == null) && fx4Var != null) {
            this.N2 = fx4Var;
            this.c = true;
            this.F0.J2();
            this.F0.b3(this.M2);
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

    @Override // com.baidu.tieba.d05.e
    public void onClick(d05 d05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, d05Var) == null) {
            j5(d05Var, null);
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
            this.x0.O2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            te5 te5Var = this.U0;
            if (te5Var != null) {
                te5Var.F(bundle);
            }
        }
    }

    public void z6(e3 e3Var) {
        List<e3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048754, this, e3Var) == null) && e3Var != null && (list = this.o1) != null) {
            list.remove(e3Var);
        }
    }

    public final boolean B6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof am9)) {
                return false;
            }
            am9 am9Var = (am9) obj;
            if (am9Var.getType() != am9.U0 && !TextUtils.isEmpty(am9Var.s()) && sv4.c().g()) {
                return j6(am9Var);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null) {
                if (G5().g1() != null) {
                    G5().g1().g();
                }
                wt8 wt8Var = new wt8();
                wt8Var.v(this.x0.u1().k());
                wt8Var.z(this.x0.u1().M());
                wt8Var.x(am9Var);
                G5().f1().m0(wt8Var);
                G5().f1().setPostId(am9Var.O());
                d6(view2, am9Var.q().getUserId(), "", am9Var);
                TiebaStatic.log("c11743");
                te5 te5Var = this.U0;
                if (te5Var != null) {
                    this.F0.S2(te5Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void C6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pbModel = this.x0) != null && pbModel.u1() != null && this.x0.u1().M() != null && this.x0.u1().M().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void D6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pbModel = this.x0) != null && pbModel.u1() != null && this.x0.u1().M() != null && this.x0.u1().M().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void P5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            ii.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean P6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || !pbModel.M1()) {
                return false;
            }
            if (this.x0.s1() != null && this.x0.s1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && qa5.g(TbadkCoreApplication.getInst(), 0) && !this.F0.w2()) {
            this.i0 = qa5.k(getPageContext(), "collect", 0L);
        }
    }

    public final void a7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048658, this) == null) && (pbModel = this.x0) != null && !hi.isEmpty(pbModel.N1())) {
            bq4.w().Q(aq4.Z, gg.g(this.x0.N1(), 0L));
        }
    }

    public void l6() {
        List<e3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (list = this.o1) != null && !list.isEmpty()) {
            int size = this.o1.size();
            while (true) {
                size--;
                if (size <= -1 || this.o1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.F0.t0();
            if (this.h) {
                return;
            }
            d7();
            this.F0.n3();
            if (this.x0.loadData()) {
                this.F0.S3();
            }
        }
    }

    public final int q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            if (this.x0.u1() != null && this.x0.u1().M() != null) {
                return this.x0.u1().M().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void D0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (cv5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cv5.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (lx8.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new is5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fv5
    public void Z(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048652, this, context, str, z3) == null) {
            if (lx8.c(str) && (pbModel = this.x0) != null && pbModel.N1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.x0.N1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    bc5 bc5Var = new bc5();
                    bc5Var.a = str;
                    bc5Var.b = 3;
                    bc5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, bc5Var));
                }
            } else {
                lx8.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.D0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.D0 = pollingModel;
                pollingModel.H0(z05.e);
            }
            this.D0.x0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            jg.a().postDelayed(this.T1, 10000L);
        }
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            d05 d05Var = new d05(getPageContext().getPageActivity());
            d05Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            d05Var.setPositiveButton(R.string.open_now, new c(this));
            d05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new d(this));
            d05Var.create(this.c1).show();
        }
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            showLoadingView(this.F0.o1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bc));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.F0.n1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (this.j1 != null) {
                sf5.b bVar = new sf5.b();
                bVar.a = this.j1.T();
                bVar.b = this.j1.R();
                bVar.c = String.valueOf(this.j1.U());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.i1));
        }
    }

    public final boolean X5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            am9 c4 = it8.c(this.x0.u1(), this.x0.M1(), this.x0.E1());
            if (c4 != null && c4.q() != null && c4.q().getGodUserData() != null && c4.q().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.u1() == null) {
                return false;
            }
            ThreadData M = this.x0.u1().M();
            AntiData c4 = this.x0.u1().c();
            if (!AntiHelper.b(getPageContext(), M) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if ((this.x0.u1() != null && (this.x0.u1().h0() || ThreadCardUtils.isSelf(this.x0.u1().M()))) || this.W0 == null || this.x0.u1() == null || this.x0.u1().c() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeInvokeEditor(this.x0.u1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && this.N2 != null) {
            if (this.L2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0ebf);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.N2.a(), this.L2, 0)));
                this.a.finish();
            }
        }
    }

    public final void c6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && this.N2 != null) {
            if (this.K2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0ec0);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.N2.a(), this.K2, 0)));
                this.a.finish();
            }
        }
    }

    public final void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            if (this.x0.Z0() || this.x0.c1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.x0.N1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.x0.N1()));
            if (f7()) {
                this.a.finish();
            }
        }
    }

    public final void g7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && (absPbActivity = this.a) != null && absPbActivity.I1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.I1().N1()).param("topic_id", this.a.I1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.I1().R1()));
        }
    }

    public final void j7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048692, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.V(this.x0.getForumId()) && this.x0.u1() != null && this.x0.u1().k() != null) {
            boolean z3 = true;
            if (this.x0.u1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.x0.I0().U(this.x0.getForumId(), this.x0.N1());
            }
        }
    }

    public final void I6(ve5 ve5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, ve5Var) == null) && ve5Var != null && (pbModel = this.x0) != null) {
            ve5Var.p(pbModel.T0());
            if (this.x0.u1() != null && this.x0.u1().k() != null) {
                ve5Var.o(this.x0.u1().k());
            }
            ve5Var.q("pb");
            ve5Var.r(this.x0);
        }
    }

    public final void J6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048604, this, i3) != null) || (pbModel = this.x0) == null) {
            return;
        }
        int D1 = pbModel.D1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.x0.c3(1);
                } else {
                    this.x0.c3(4);
                }
            } else {
                this.x0.c3(3);
            }
        } else {
            this.x0.c3(2);
        }
        int D12 = this.x0.D1();
        if (D1 == 4 || D12 == 4) {
            m6();
        }
    }

    public final void S5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            at4 c4 = at4.c(this.a);
            this.z0 = c4;
            if (c4 != null) {
                c4.j(this.p2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.A0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.r2);
            this.B0 = new s95(getPageContext());
            H5();
            this.M1.setUniqueId(getUniqueId());
            this.M1.registerListener();
        }
    }

    public void Z4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.F0.I3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = gg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = gg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.e1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.b1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean b5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048659, this, i3)) == null) {
            if (this.W0 != null && this.x0.u1() != null && !ThreadCardUtils.isSelf(this.x0.u1().M()) && this.x0.u1().c() != null) {
                return this.W0.checkPrivacyBeforeSend(this.x0.u1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void b6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, bundle) == null) {
            PbModel I1 = this.a.I1();
            this.x0 = I1;
            if (I1 != null) {
                if (I1.P0() != null) {
                    this.x0.P0().c(this.J2);
                }
                if (this.x0.q1() != null) {
                    this.x0.q1().f(this.s1);
                }
                if (StringUtils.isNull(this.x0.N1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.L) && this.L != null) {
                    this.x0.Z2(6);
                }
            }
        }
    }

    public final void h7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048684, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.I1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.I1().N1()).param("topic_id", this.a.I1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.I1().R1()));
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        fx8 fx8Var;
        hz8 hz8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (fx8Var = this.F0) != null && (hz8Var = fx8Var.h) != null && hz8Var.h() != null) {
                this.F0.h.h().P(configuration);
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
            fx8 fx8Var2 = this.F0;
            if (fx8Var2 != null) {
                fx8Var2.b2(configuration);
            }
            m05 m05Var = this.K0;
            if (m05Var != null) {
                m05Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public void p6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048728, this, animatorListener) == null) && this.F0 != null && (pbModel = this.x0) != null && pbModel.u1() != null && this.x0.u1().Q() != null && checkUpIsLogin() && this.F0.G0() != null && this.F0.G0().z() != null) {
            this.F0.G0().z().H(animatorListener);
        }
    }

    public void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.x0.u1() != null && this.x0.u1().M() != null && this.x0.u1().M().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.x0.u1().M().getTaskInfoData().i(), this.x0.u1().M().getTaskInfoData().g(), this.x0.u1().M().getTaskInfoData().b(), this.x0.u1().M().getTaskInfoData().c(), this.x0.u1().M().getIs_top(), this.x0.u1().M().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final boolean f7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.u1() != null && this.x0.u1().h0()) {
                return true;
            }
            if (this.x0.f1()) {
                MarkData Q0 = this.x0.Q0();
                if (Q0 == null || !this.x0.d1()) {
                    return true;
                }
                MarkData L0 = this.x0.L0(this.F0.N0());
                if (L0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", Q0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (L0.getPostId() != null && !L0.getPostId().equals(Q0.getPostId())) {
                    d05 d05Var = new d05(getPageContext().getPageActivity());
                    d05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                    d05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045d, new g2(this, L0, Q0, d05Var));
                    d05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new i2(this, Q0, d05Var));
                    d05Var.setOnCalcelListener(new j2(this, Q0, d05Var));
                    d05Var.create(getPageContext());
                    d05Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", Q0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.x0.u1() != null && this.x0.u1().F() != null && this.x0.u1().F().size() > 0 && this.x0.d1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null) {
                zl9 z3 = this.x0.u1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.x0.u1().b();
                }
                if (this.x0.N0() != null) {
                    this.x0.A0();
                }
                this.x0.Y1();
            }
            if (this.x0.u1().F() != null) {
                Iterator<am9> it = this.x0.u1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof zl9) {
                        it.remove();
                    }
                }
            }
            if (this.F0.G0() != null && !ListUtils.isEmpty(this.F0.G0().t())) {
                ex8.d(this.F0.G0().t());
            }
            if (this.F0.W0() != null && !ListUtils.isEmpty(this.F0.W0().getData())) {
                ex8.d(this.F0.W0().getData());
            }
            if (this.F0.G0() != null) {
                this.F0.G0().a0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.f = false;
            super.onResume();
            if (this.N) {
                this.N = false;
                J5();
            }
            if (X5()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            fx8 fx8Var = this.F0;
            if (fx8Var != null && fx8Var.o1() != null) {
                if (!this.g) {
                    T6();
                } else {
                    hideLoadingView(this.F0.o1());
                }
                this.F0.k2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            fx8 fx8Var2 = this.F0;
            if (fx8Var2 != null) {
                noNetworkView = fx8Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.z1);
            this.O0 = false;
            D6();
            registerListener(this.U1);
            registerListener(this.V1);
            registerListener(this.X1);
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.l1) {
                y6();
                this.l1 = false;
            }
            a7();
            ItemCardHelper.w(this.F2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                jc5.q().w(downloadData);
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
            if (G5().g1() != null) {
                G5().g1().n();
            }
            hz8 hz8Var = this.F0.h;
            if (hz8Var != null && !hz8Var.m()) {
                this.F0.h.o();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null && this.x0.u1().k() != null && this.x0.u1().M() != null) {
                gc5.j().x(getPageContext().getPageActivity(), "pb", this.x0.u1().k().getId(), gg.g(this.x0.u1().M().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            ck9.g().h(getUniqueId(), false);
        }
    }

    public void r6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null && this.x0.u1().k() != null) {
                if (Y4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.x0.u1().h0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.F0.k0();
                    return;
                } else {
                    te5 te5Var = this.U0;
                    if (te5Var != null && te5Var.b() != null) {
                        this.U0.b().C(new qc5(45, 27, null));
                    }
                    this.F0.k0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final String t5() {
        InterceptResult invokeV;
        ArrayList<am9> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.u1() == null || this.x0.u1().F() == null || (count = ListUtils.getCount((F = this.x0.u1().F()))) == 0) {
                return "";
            }
            if (this.x0.F1()) {
                Iterator<am9> it = F.iterator();
                while (it.hasNext()) {
                    am9 next = it.next();
                    if (next != null && next.E() == 1) {
                        return next.O();
                    }
                }
            }
            int N0 = this.F0.N0();
            am9 am9Var = (am9) ListUtils.getItem(F, N0);
            if (am9Var != null && am9Var.q() != null) {
                if (this.x0.n2(am9Var.q().getUserId())) {
                    return am9Var.O();
                }
                for (int i3 = N0 - 1; i3 != 0; i3--) {
                    am9 am9Var2 = (am9) ListUtils.getItem(F, i3);
                    if (am9Var2 == null || am9Var2.q() == null || am9Var2.q().getUserId() == null) {
                        break;
                    } else if (this.x0.n2(am9Var2.q().getUserId())) {
                        return am9Var2.O();
                    }
                }
                for (int i4 = N0 + 1; i4 < count; i4++) {
                    am9 am9Var3 = (am9) ListUtils.getItem(F, i4);
                    if (am9Var3 == null || am9Var3.q() == null || am9Var3.q().getUserId() == null) {
                        break;
                    } else if (this.x0.n2(am9Var3.q().getUserId())) {
                        return am9Var3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void K5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void Y6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            if (str == null) {
                str = "";
            }
            a9 a9Var = this.c1;
            if (a9Var == null) {
                return;
            }
            d05 d05Var = new d05(a9Var.getPageActivity());
            d05Var.setMessage(str);
            d05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a62, new e(this));
            d05Var.create(this.c1).show();
        }
    }

    public final void b7(SparseArray<Object> sparseArray) {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048661, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof am9) || (am9Var = (am9) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        c7(am9Var, false);
    }

    public final void i7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.x0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(zy8.n(i3))));
        }
    }

    public final void o5(Rect rect) {
        fx8 fx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048704, this, rect) == null) && rect != null && (fx8Var = this.F0) != null && fx8Var.n1() != null && rect.top <= this.F0.n1().getHeight()) {
            rect.top += this.F0.n1().getHeight() - rect.top;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ht8 u12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090772));
            PbModel pbModel = this.x0;
            if (pbModel != null && (u12 = pbModel.u1()) != null) {
                this.m2.c(true, 0, 3, 0, u12, "", 1);
            }
            this.a.K1().j(this.s0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z3) == null) {
            super.onUserChanged(z3);
            this.F0.g4(z3);
            m05 m05Var = this.K0;
            if (m05Var != null) {
                m05Var.dismiss();
            }
            if (z3 && this.O0) {
                this.F0.o3();
                this.x0.q2(true);
            }
            if (this.F0.G0() != null) {
                this.F0.G0().e0(z3);
            }
        }
    }

    public final void u6(View view2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048740, this, view2) != null) || view2 == null) {
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

    public final void L5(int i3, Intent intent) {
        cd5 cd5Var;
        cd5 cd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i3, intent) == null) {
            if (i3 == 0) {
                this.F0.s1();
                this.F0.g1().g();
                this.F0.A3(false);
            }
            this.F0.L2();
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
                if (editorType == 1 && this.F0.g1() != null && this.F0.g1().f() != null) {
                    xe5 f4 = this.F0.g1().f();
                    f4.d0(this.x0.u1().M());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    bd5 p3 = f4.b().p(6);
                    if (p3 != null && (cd5Var2 = p3.m) != null) {
                        cd5Var2.C(new qc5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            te5 te5Var = this.U0;
            if (te5Var != null) {
                te5Var.L();
                this.U0.m0(pbEditorData.getVoiceModel());
                this.U0.B(writeData);
                bd5 p4 = this.U0.b().p(6);
                if (p4 != null && (cd5Var = p4.m) != null) {
                    cd5Var.C(new qc5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.U0.h0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.U0.G(null, null);
                }
            }
        }
    }

    public final void N6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048614, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (G5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        ta5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            ns8.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            ns8.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            ns8.e(getResources().getString(R.string.obfuscated_res_0x7f0f12f7));
                            return;
                        } else {
                            ns8.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.x0.h1()) {
                antiData.setBlock_forum_name(this.x0.u1().k().getName());
                antiData.setBlock_forum_id(this.x0.u1().k().getId());
                antiData.setUser_name(this.x0.u1().T().getUserName());
                antiData.setUser_id(this.x0.u1().T().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void S6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048628, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            m05 m05Var = this.K0;
            if (m05Var != null && m05Var.isShowing()) {
                this.K0.dismiss();
                this.K0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            o05 o05Var = new o05(getContext());
            o05Var.p(new g0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i3 == 1) {
                arrayList.add(new k05(0, getResources().getString(R.string.obfuscated_res_0x7f0f04d9), o05Var));
            }
            if (z3) {
                arrayList.add(new k05(1, getResources().getString(R.string.un_mute), o05Var));
            } else {
                arrayList.add(new k05(1, getResources().getString(R.string.obfuscated_res_0x7f0f0bf8), o05Var));
            }
            o05Var.k(arrayList);
            m05 m05Var2 = new m05(getPageContext(), o05Var);
            this.K0 = m05Var2;
            m05Var2.k();
        }
    }

    public final void c7(am9 am9Var, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048664, this, am9Var, z3) == null) {
            F6(false);
            if (am9Var == null || (pbModel = this.x0) == null || pbModel.u1() == null || am9Var.E() == 1) {
                return;
            }
            String N1 = this.x0.N1();
            String O = am9Var.O();
            if (this.x0.u1() != null) {
                i3 = this.x0.u1().U();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e s6 = s6(O);
            if (s6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo h02 = am9Var.h0();
            AntiData c4 = this.x0.u1().c();
            if (am9Var.q() != null) {
                arrayList = am9Var.q().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(N1, O, "pb", true, false, null, false, null, i3, h02, c4, false, arrayList, 5).addBigImageData(s6.a, s6.b, s6.g, s6.j);
            addBigImageData.setKeyPageStartFrom(this.x0.t1());
            addBigImageData.setFromFrsForumId(this.x0.getFromForumId());
            addBigImageData.setWorksInfoData(this.x0.S1());
            addBigImageData.setKeyFromForumId(this.x0.getForumId());
            addBigImageData.setBjhData(this.x0.M0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void i5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(fx8.c2)).intValue();
            if (intValue == fx8.d2) {
                if (this.A0.j0()) {
                    return;
                }
                this.F0.c4();
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
                    this.A0.l0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.A0.m0(this.x0.u1().k().getId(), this.x0.u1().k().getName(), this.x0.u1().M().getId(), str, intValue3, intValue2, booleanValue, this.x0.u1().M().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == fx8.e2 || intValue == fx8.g2) {
                PbModel pbModel = this.x0;
                if (pbModel != null && pbModel.P0() != null) {
                    this.x0.P0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == fx8.e2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void l5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048695, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            fx8 fx8Var = this.F0;
            if (fx8Var != null && this.x0 != null) {
                if ((fx8Var == null || fx8Var.J1()) && this.x0.u1() != null && this.x0.u1().Q() != null) {
                    fx8 fx8Var2 = this.F0;
                    if (fx8Var2 != null && fx8Var2.M0() != null && this.F0.M0().t()) {
                        return;
                    }
                    vt8 Q = this.x0.u1().Q();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!Q.d() || Q.a() != 2) && this.F0.G0() != null && this.F0.G0().z() != null) {
                        this.F0.G0().z().x(this.x0.N1(), this.x0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        ls8 ls8Var = new ls8(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.x0;
                        ls8Var.m(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        ls8Var.l(new n0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void M5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.e1);
            userMuteAddAndDelCustomMessage.setTag(this.e1);
            Z6(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void M6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048612, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new y1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                Y6(str);
            } else {
                this.F0.b4(str);
            }
        }
    }

    @Override // com.baidu.tieba.fv5
    public void f0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048672, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.M0 = str;
            if (this.k == null) {
                U5();
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

    public final void N5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null && this.x0.u1().h0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.x0.N1(), str);
                ThreadData M = this.x0.u1().M();
                if (M.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (M.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (M.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                Z5(format);
                return;
            }
            this.y0.a(str);
        }
    }

    public final void Q6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, metaData) != null) || metaData == null) {
            return;
        }
        d05 d05Var = new d05(getActivity());
        d05Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b5a));
        d05Var.setTitleShowCenter(true);
        d05Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b5b));
        d05Var.setMessageShowCenter(true);
        d05Var.setCancelable(false);
        d05Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b5c), new t1(this, metaData));
        d05Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b5d), new u1(this, metaData));
        d05Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void W6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && P() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                P().D0(postWriteCallBackData.getPostId());
                int K0 = this.F0.K0();
                this.m1 = K0;
                this.x0.R2(K0, this.F0.Q0());
            }
            this.F0.t0();
            this.J0.c();
            te5 te5Var = this.U0;
            if (te5Var != null) {
                this.F0.S2(te5Var.y());
            }
            this.F0.s1();
            this.F0.A3(true);
            this.x0.Y1();
        }
    }

    public final void g5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048678, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.x0) != null && pbModel.u1() != null) {
            zl9 z3 = this.x0.u1().z();
            if (z3 != null && str.equals(z3.r1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.x0.u1().b();
            }
            zl9 N0 = this.x0.N0();
            if (N0 != null && str.equals(N0.r1())) {
                this.x0.A0();
            }
        }
    }

    public void i6(am9 am9Var) {
        boolean z3;
        am9 r5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048686, this, am9Var) != null) || am9Var == null) {
            return;
        }
        if (am9Var.O() != null && am9Var.O().equals(this.x0.p1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData o12 = this.x0.o1(am9Var);
        if (this.x0.u1() != null && this.x0.u1().h0() && (r5 = r5()) != null) {
            o12 = this.x0.o1(r5);
        }
        if (o12 == null) {
            return;
        }
        this.F0.n3();
        at4 at4Var = this.z0;
        if (at4Var != null) {
            at4Var.i(o12);
            if (!z3) {
                this.z0.a();
            } else {
                this.z0.d();
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
        this.F0.a2(i3);
        te5 te5Var = this.U0;
        if (te5Var != null && te5Var.b() != null) {
            this.U0.b().y(i3);
        }
        if (this.F0.a() != null) {
            this.F0.a().d(getPageContext(), i3);
        }
        this.J0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.V = i3;
        d7();
        pa5 pa5Var = this.i0;
        if (pa5Var != null) {
            pa5Var.w();
        }
    }

    public void v6(wt8 wt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, wt8Var) == null) {
            String O = wt8Var.g().O();
            List<am9> list = this.x0.u1().R().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                am9 am9Var = list.get(i3);
                if (am9Var.O() != null && am9Var.O().equals(O)) {
                    ArrayList<am9> i4 = wt8Var.i();
                    am9Var.e1(wt8Var.k());
                    if (am9Var.e0() != null) {
                        am9Var.e0().clear();
                        am9Var.e0().addAll(i4);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.x0.d1()) {
                this.F0.I1(this.x0.u1());
            }
        }
    }

    public final void O6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            zy8.e(getActivity(), getPageContext(), new e1(this, sparseArray, i3, z3), new f1(this));
        }
    }

    public final void U4() {
        PbModel pbModel;
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (pbModel = this.x0) != null && (ht8Var = pbModel.G) != null && ht8Var.M() != null) {
            ThreadData M = this.x0.G.M();
            M.mRecomAbTag = this.x0.z1();
            M.mRecomWeight = this.x0.C1();
            M.mRecomSource = this.x0.B1();
            M.mRecomExtra = this.x0.A1();
            M.isSubPb = this.x0.h1();
            if (M.getFid() == 0) {
                M.setFid(gg.g(this.x0.getForumId(), 0L));
            }
            StatisticItem i3 = ll5.i(getContext(), M, "c13562");
            TbPageTag l3 = ll5.l(getContext());
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

    public final void g6() {
        MarkData L0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && this.z0 != null) {
            if (this.x0.u1() != null && this.x0.u1().h0()) {
                L0 = this.x0.L0(0);
            } else {
                L0 = this.x0.L0(this.F0.V0());
            }
            if (L0 == null) {
                return;
            }
            if (L0.isApp() && (L0 = this.x0.L0(this.F0.V0() + 1)) == null) {
                return;
            }
            this.F0.n3();
            this.z0.i(L0);
            if (!this.z0.e()) {
                if (this.F0 != null && this.x0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !bz8.h(this.x0.b)) {
                    this.F0.V3();
                    bz8.b(this.x0.b);
                }
                this.z0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.z0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.f = true;
            super.onPause();
            az8.a();
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
            fx8 fx8Var = this.F0;
            if (fx8Var != null) {
                fx8Var.h2();
            }
            if (this.U0 != null && !this.x0.h1()) {
                this.U0.N(this.x0.N1());
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.w2();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            bq4.w().E();
            MessageManager.getInstance().unRegisterListener(this.z1);
            C6();
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            pa5 pa5Var = this.i0;
            if (pa5Var != null) {
                pa5Var.q();
                this.i0.p();
            }
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048634, this) != null) || this.k != null) {
            return;
        }
        this.k = new f05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        f05 f05Var = this.k;
        f05Var.j(strArr, new q0(this));
        f05Var.g(f05.b.a);
        f05Var.h(17);
        f05Var.c(getPageContext());
    }

    public final void W4(ht8 ht8Var, ArrayList<am9> arrayList) {
        List<am9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048640, this, ht8Var, arrayList) == null) && ht8Var != null && ht8Var.R() != null && ht8Var.R().a != null && (list = ht8Var.R().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<am9> it = arrayList.iterator();
                while (it.hasNext()) {
                    am9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            am9 am9Var = (am9) it2.next();
                            if (am9Var != null && !TextUtils.isEmpty(next.O()) && !TextUtils.isEmpty(am9Var.O()) && next.O().equals(am9Var.O())) {
                                arrayList2.add(am9Var);
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

    public final void n5(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048701, this, i3, gVar) != null) || gVar == null) {
            return;
        }
        this.F0.C0(this.A0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.G0 = true;
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4 || i3 == 5) {
                    this.H0 = false;
                    this.I0 = true;
                }
            } else {
                this.H0 = true;
                this.I0 = false;
            }
            if (i3 == 2) {
                this.x0.u1().M().setIs_good(1);
                this.x0.V2(1);
            } else if (i3 == 3) {
                this.x0.u1().M().setIs_good(0);
                this.x0.V2(0);
            } else if (i3 == 4) {
                this.x0.u1().M().setIs_top(1);
                this.x0.W2(1);
            } else if (i3 == 5) {
                this.x0.u1().M().setIs_top(0);
                this.x0.W2(0);
            }
            this.F0.k4(this.x0.u1(), this.x0.M1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        ii.Q(getPageContext().getPageActivity(), string);
    }

    public void X4(boolean z3) {
        fx8 fx8Var;
        int i3;
        int w3;
        am9 am9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z3) == null) && (fx8Var = this.F0) != null && fx8Var.W0() != null) {
            int firstVisiblePosition = this.F0.W0().getFirstVisiblePosition();
            int lastVisiblePosition = this.F0.W0().getLastVisiblePosition();
            sv8 G0 = this.F0.G0();
            if (G0 != null && this.x0.u1() != null) {
                if (lastVisiblePosition <= G0.w()) {
                    i3 = 0;
                    w3 = 1;
                } else {
                    if (firstVisiblePosition > G0.w()) {
                        i3 = firstVisiblePosition - G0.w();
                    } else {
                        i3 = 0;
                    }
                    w3 = (lastVisiblePosition - G0.w()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (w3 > i3) {
                    while (i3 < w3) {
                        if (this.F0.W0().F(i3) != null && (this.F0.W0().F(i3) instanceof am9) && (am9Var = (am9) this.F0.W0().F(i3)) != null) {
                            am9 am9Var2 = (am9) ListUtils.getItem(this.x0.u1().F(), am9Var.E() - 1);
                            if (am9Var.m() == null && am9Var2 != null) {
                                am9Var.G0(am9Var2.m());
                            }
                            if (am9Var.m() != null) {
                                am9Var.m().r(am9Var.E());
                                arrayList.add(am9Var.m());
                            }
                        }
                        i3++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new x1(this));
                    hb5 hb5Var = (hb5) ListUtils.getItem(arrayList, 0);
                    if (hb5Var != null && hb5Var.e() == 1) {
                        if (!z3) {
                            this.F0.x2(hb5Var, 0);
                            return;
                        }
                        return;
                    }
                    this.F0.x2(hb5Var, 1);
                }
            }
        }
    }

    public final boolean j6(am9 am9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, am9Var)) == null) {
            if (am9Var == null) {
                return false;
            }
            String O = am9Var.O();
            if (StringUtils.isNull(O) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s3 = q45.m().s("bubble_link", "");
            if (StringUtils.isNull(s3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = am9Var.j0().getJumpUrl();
            int packageId = am9Var.j0().getPackageId();
            int propsId = am9Var.j0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                jt4.s(getPageContext().getPageActivity(), en9.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                jt4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s3 + "?props_id=" + O, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void l7(int i3) {
        PbModel pbModel;
        ThreadData M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048697, this, i3) != null) || (pbModel = this.x0) == null || pbModel.u1() == null || (M = this.x0.u1().M()) == null) {
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
        if (this.x0.M1()) {
            this.F0.G0().a0();
        } else {
            this.F0.n4(this.x0.u1());
        }
    }

    public final AbsPbActivity.e s6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048734, this, str)) == null) {
            String str2 = null;
            if (this.x0.u1() != null && this.x0.u1().F() != null && this.x0.u1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.x0.u1().F().size()) {
                        if (str.equals(this.x0.u1().F().get(i3).O())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                am9 am9Var = this.x0.u1().F().get(i3);
                if (am9Var.a0() != null && am9Var.a0().S() != null) {
                    Iterator<TbRichTextData> it = am9Var.a0().S().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.Y() != null) {
                                str2 = next.Y().R();
                            }
                        }
                    }
                    q6(str2, 0, eVar);
                    it8.b(am9Var, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void x6(wt8 wt8Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048749, this, wt8Var) != null) || wt8Var.g() == null) {
            return;
        }
        String O = wt8Var.g().O();
        ArrayList<am9> F = this.x0.u1().F();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= F.size()) {
                break;
            }
            am9 am9Var = F.get(i3);
            if (am9Var.O() != null && am9Var.O().equals(O)) {
                ArrayList<am9> i4 = wt8Var.i();
                am9Var.e1(wt8Var.k());
                if (am9Var.e0() != null && i4 != null) {
                    Iterator<am9> it = i4.iterator();
                    while (it.hasNext()) {
                        am9 next = it.next();
                        if (am9Var.m0() != null && next != null && next.q() != null && (metaData = am9Var.m0().get(next.q().getUserId())) != null) {
                            next.H0(metaData);
                            next.U0(true);
                            next.n1(getPageContext(), this.x0.n2(metaData.getUserId()));
                        }
                    }
                    if (i4.size() == am9Var.e0().size()) {
                        z3 = false;
                    }
                    if (!am9Var.t0(false)) {
                        am9Var.e0().clear();
                        am9Var.e0().addAll(i4);
                    }
                }
                if (am9Var.y() != null) {
                    am9Var.F0();
                }
            } else {
                i3++;
            }
        }
        if (!this.x0.d1() && z3) {
            this.F0.I1(this.x0.u1());
        }
        if (z3) {
            v6(wt8Var);
        }
    }

    public final void Z6(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.F0.I3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            d05 d05Var = new d05(this.c1.getPageActivity());
            if (!hi.isEmpty(str)) {
                d05Var.setMessage(str);
            } else {
                d05Var.setMessage(this.c1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            d05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045d, new f(this, userMuteAddAndDelCustomMessage));
            d05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new g(this));
            d05Var.create(this.c1).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c5(AgreeData agreeData) {
        gl5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048662, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new m45();
        }
        if (this.h0 == null) {
            ql9 ql9Var = new ql9();
            this.h0 = ql9Var;
            ql9Var.a = getUniqueId();
        }
        qw4 qw4Var = new qw4();
        qw4Var.b = 5;
        qw4Var.h = 8;
        qw4Var.g = 2;
        if (P() != null) {
            qw4Var.f = P().t1();
        }
        qw4Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                qw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i3, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.x0;
                if (pbModel == null && pbModel.u1() != null) {
                    this.d0.b(Q(), qw4Var, agreeData, this.x0.u1().M());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            qw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            qw4Var.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.d0.c(agreeData, i3, getUniqueId(), false);
        this.d0.d(agreeData, this.h0);
        pbModel = this.x0;
        if (pbModel == null) {
        }
    }

    public final void d6(View view2, String str, String str2, am9 am9Var) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048667, this, view2, str, str2, am9Var) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (Y4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!a5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.X);
                        this.Y = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (G5().g1() != null && am9Var != null) {
                        if (am9Var.a0() != null) {
                            str3 = am9Var.a0().toString();
                        } else {
                            str3 = "";
                        }
                        G5().g1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), am9Var.q().getName_show(), str3));
                    }
                    if (this.x0.u1() != null && this.x0.u1().h0()) {
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

    public final boolean e5(View view2) {
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
        List<k05> c4;
        int i3;
        boolean z20;
        k05 k05Var;
        k05 k05Var2;
        k05 k05Var3;
        k05 k05Var4;
        k05 k05Var5;
        k05 k05Var6;
        tm tmVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            fx8 fx8Var = this.F0;
            if (fx8Var != null) {
                if (fx8Var.L1()) {
                    return true;
                }
                this.F0.D0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (ex8.x(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.h1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.i1 = url;
                        if (this.h1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.j1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.j1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.k1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.k1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.h1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.i1 = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.k1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.k1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.h1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.i1 = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.k1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.k1 = null;
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
                        this.F0.N3(this.B2, this.h1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            am9 am9Var = (am9) sparseArray.get(R.id.tag_clip_board);
            this.z2 = am9Var;
            if (am9Var == null) {
                return true;
            }
            if (am9Var.E() == 1 && ex8.x(view2)) {
                this.F0.N3(this.B2, this.h1.t());
                return true;
            }
            at4 at4Var = this.z0;
            if (at4Var == null) {
                return true;
            }
            if (at4Var.e() && this.z2.O() != null && this.z2.O().equals(this.x0.p1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (P().u1() != null && P().u1().h0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (P().u1() != null && P().u1().n0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (P().u1() != null && P().u1().m0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.z2.E() == 1) {
                if (!z4) {
                    this.F0.O3(this.A2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.L0 == null) {
                o05 o05Var = new o05(getContext());
                this.L0 = o05Var;
                o05Var.p(this.e2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (ex8.x(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (ex8.x(view2) && (tmVar = this.h1) != null && !tmVar.t()) {
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
                    arrayList.add(new k05(1, getString(R.string.save_to_emotion), this.L0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new k05(2, getString(R.string.save_to_local), this.L0));
                }
                if (!z7 && !z8) {
                    k05 k05Var7 = new k05(3, getString(R.string.obfuscated_res_0x7f0f0479), this.L0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.z2);
                    k05Var7.d.setTag(sparseArray3);
                    arrayList.add(k05Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        k05Var6 = new k05(4, getString(R.string.remove_mark), this.L0);
                    } else {
                        k05Var6 = new k05(4, getString(R.string.obfuscated_res_0x7f0f0b58), this.L0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.z2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    k05Var6.d.setTag(sparseArray4);
                    arrayList.add(k05Var6);
                }
                if (this.mIsLogin) {
                    if (!zy8.j(this.x0) && !z12 && z11) {
                        k05 k05Var8 = new k05(5, getString(R.string.obfuscated_res_0x7f0f0bfc), this.L0);
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
                        k05Var8.d.setTag(sparseArray5);
                        arrayList.add(k05Var8);
                    } else {
                        if (ex8.B(this.x0.u1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            k05 k05Var9 = new k05(5, getString(R.string.report_text), this.L0);
                            k05Var9.d.setTag(str);
                            arrayList.add(k05Var9);
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
                        if (!zy8.j(this.x0) && z18) {
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
                                k05Var5 = new k05(6, getString(R.string.obfuscated_res_0x7f0f04d9), this.L0);
                                k05Var5.d.setTag(sparseArray6);
                                k05Var2 = new k05(7, getString(R.string.obfuscated_res_0x7f0f02f1), this.L0);
                                k05Var2.d.setTag(sparseArray6);
                                k05Var3 = k05Var5;
                                k05Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        k05Var5 = null;
                        k05Var2 = new k05(7, getString(R.string.obfuscated_res_0x7f0f02f1), this.L0);
                        k05Var2.d.setTag(sparseArray6);
                        k05Var3 = k05Var5;
                        k05Var = null;
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
                        if (this.x0.u1().U() == 1002 && !z10) {
                            k05Var4 = new k05(6, getString(R.string.report_text), this.L0);
                        } else {
                            k05Var4 = new k05(6, getString(R.string.obfuscated_res_0x7f0f04d9), this.L0);
                        }
                        k05Var4.d.setTag(sparseArray7);
                        if (z17) {
                            k05Var = new k05(13, getString(R.string.multi_delete), this.L0);
                            k05Var3 = k05Var4;
                        } else {
                            k05Var3 = k05Var4;
                            k05Var = null;
                        }
                        k05Var2 = null;
                    } else {
                        k05Var = null;
                        k05Var2 = null;
                        k05Var3 = null;
                    }
                    if (k05Var3 != null) {
                        arrayList.add(k05Var3);
                    }
                    if (k05Var != null) {
                        arrayList.add(k05Var);
                    }
                    if (k05Var2 != null) {
                        arrayList.add(k05Var2);
                    }
                    zy8.b(arrayList, this.L0, this.z2, this.x0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = zy8.d(arrayList, this.z2.n(), sparseArray, this.L0);
                } else {
                    c4 = zy8.c(arrayList, this.z2.n(), sparseArray, this.L0);
                }
                zy8.m(c4, this.b);
                zy8.f(c4);
                this.L0.q(zy8.h(this.z2));
                this.L0.l(c4, !UbsABTestHelper.isPBPlanA());
                this.K0 = new m05(getPageContext(), this.L0);
                this.L0.o(new v2(this));
                this.K0.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.x0.b).param("fid", this.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.x0.S());
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

    public void f5(ForumManageModel.b bVar, fx8 fx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048673, this, bVar, fx8Var) == null) {
            List<am9> list = this.x0.u1().R().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).e0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).e0().get(i4).O())) {
                        list.get(i3).e0().remove(i4);
                        list.get(i3).i();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).k(bVar.g);
            }
            if (z3) {
                fx8Var.I1(this.x0.u1());
            }
        }
    }

    @Override // com.baidu.tieba.g09
    public void finish() {
        fx8 fx8Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            fx8 fx8Var2 = this.F0;
            if (fx8Var2 != null) {
                fx8Var2.t0();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.u1() != null && !this.x0.u1().h0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.x0.u1().M().getId();
                if (this.x0.isShareThread() && this.x0.u1().M().originalThreadData != null) {
                    historyMessage.threadName = this.x0.u1().M().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.x0.u1().M().getTitle();
                }
                if (this.x0.isShareThread() && !y0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.x0.u1().k().getName();
                }
                ArrayList<am9> F = this.x0.u1().F();
                fx8 fx8Var3 = this.F0;
                if (fx8Var3 != null) {
                    i3 = fx8Var3.N0();
                } else {
                    i3 = 0;
                }
                if (F != null && i3 >= 0 && i3 < F.size()) {
                    historyMessage.postID = F.get(i3).O();
                }
                historyMessage.isHostOnly = this.x0.X0();
                historyMessage.isSquence = this.x0.M1();
                historyMessage.isShareThread = this.x0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            te5 te5Var = this.U0;
            if (te5Var != null) {
                te5Var.D();
                this.U0 = null;
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && (pbModel2.Z0() || this.x0.c1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.x0.N1());
                if (this.G0) {
                    if (this.I0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.x0.i1());
                    }
                    if (this.H0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.x0.e1());
                    }
                }
                if (this.x0.u1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.x0.u1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.n1);
                }
                this.a.setResult(-1, intent);
            }
            if (f7()) {
                if (this.x0 != null && (fx8Var = this.F0) != null && fx8Var.W0() != null) {
                    ht8 u12 = this.x0.u1();
                    if (u12 != null) {
                        if (u12.T() != null) {
                            u12.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            u12.T().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!u12.q0() && !this.H && u12.h == null) {
                            ww8 b4 = ww8.b();
                            ht8 v12 = this.x0.v1();
                            Parcelable onSaveInstanceState = this.F0.W0().onSaveInstanceState();
                            boolean M1 = this.x0.M1();
                            boolean X0 = this.x0.X0();
                            if (this.F0.e1() != null && this.F0.e1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(v12, onSaveInstanceState, M1, X0, z3);
                            if (this.m1 >= 0 || this.x0.P1() != null) {
                                ww8.b().o(this.x0.P1());
                                ww8.b().p(this.x0.Q1());
                                ww8.b().m(this.x0.n1());
                            }
                        }
                    }
                } else {
                    ww8.b().k();
                }
                e7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        hz8 hz8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            ck9.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.x0.u1().l());
                statisticItem.param("tid", this.x0.N1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.r && this.F0 != null) {
                this.r = true;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.x0.destory();
                if (this.x0.q1() != null) {
                    this.x0.q1().d();
                }
            }
            te5 te5Var = this.U0;
            if (te5Var != null) {
                te5Var.D();
                this.U0 = null;
            }
            ForumManageModel forumManageModel = this.A0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.e0();
            }
            fx8 fx8Var = this.F0;
            if (fx8Var != null) {
                fx8Var.c2();
                hz8 hz8Var2 = this.F0.h;
                if (hz8Var2 != null) {
                    hz8Var2.o();
                }
            }
            dm5 dm5Var = this.s;
            if (dm5Var != null) {
                dm5Var.c();
            }
            ky8 ky8Var = this.e;
            if (ky8Var != null) {
                ky8Var.k();
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
            fx8 fx8Var2 = this.F0;
            if (fx8Var2 != null) {
                fx8Var2.t0();
            }
            if (this.T1 != null) {
                jg.a().removeCallbacks(this.T1);
            }
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.l2);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            this.c1 = null;
            this.d1 = null;
            nc9.e().g();
            if (this.f1 != null) {
                jg.a().removeCallbacks(this.f1);
            }
            fx8 fx8Var3 = this.F0;
            if (fx8Var3 != null && (hz8Var = fx8Var3.h) != null) {
                hz8Var.j();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            ix8 ix8Var = this.J0;
            if (ix8Var != null) {
                ix8Var.j();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && pbModel2.I0() != null) {
                this.x0.I0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.W0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            fx8 fx8Var4 = this.F0;
            if (fx8Var4 != null) {
                fx8Var4.d4();
            }
            xy8 xy8Var = this.t0;
            if (xy8Var != null) {
                xy8Var.e();
            }
        }
    }

    public void j5(d05 d05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, d05Var, jSONArray) == null) {
            d05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(d05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                i5((SparseArray) d05Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText m7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048700, this, str, i3)) == null) {
            PbModel pbModel = this.x0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.u1() == null || str == null || i3 < 0) {
                return null;
            }
            ht8 u12 = this.x0.u1();
            if (u12.i() != null) {
                ArrayList<am9> arrayList = new ArrayList<>();
                arrayList.add(u12.i());
                tbRichText = u5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<am9> F = u12.F();
                W4(u12, F);
                return u5(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void k5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048693, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(fx8.c2, Integer.valueOf(fx8.d2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                i5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void m5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048698, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                d05 d05Var = new d05(getPageContext().getPageActivity());
                d05Var.setMessage(string);
                d05Var.setPositiveButton(R.string.dialog_known, new a2(this));
                d05Var.setCancelable(true);
                d05Var.create(getPageContext());
                d05Var.show();
            } else if (bVar.d != 0) {
                this.F0.C0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<am9> F = this.x0.u1().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i3).O())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.x0.u1().M().setReply_num(this.x0.u1().M().getReply_num() - 1);
                    this.F0.I1(this.x0.u1());
                } else if (i4 == 0) {
                    d5();
                } else if (i4 == 2) {
                    ArrayList<am9> F2 = this.x0.u1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).e0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i5).e0().get(i6).O())) {
                                F2.get(i5).e0().remove(i6);
                                F2.get(i5).i();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).k(bVar.g);
                    }
                    if (z4) {
                        this.F0.I1(this.x0.u1());
                    }
                    f5(bVar, this.F0);
                }
            }
        }
    }

    public void n6() {
        PbModel pbModel;
        ht8 u12;
        ThreadData M;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        ht8 ht8Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && (pbModel = this.x0) != null && pbModel.u1() != null && (M = (u12 = this.x0.u1()).M()) != null && M.getAuthor() != null) {
            this.F0.s1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), M.getAuthor().getUserId());
            pw8 pw8Var = new pw8();
            int U = this.x0.u1().U();
            if (U != 1 && U != 3) {
                pw8Var.g = false;
            } else {
                pw8Var.g = true;
                if (M.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                pw8Var.s = z3;
            }
            if (ex8.y(this.x0.u1(), U)) {
                pw8Var.h = true;
                if (M.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                pw8Var.r = z9;
            } else {
                pw8Var.h = false;
            }
            if (U == 1002 && !equals) {
                pw8Var.u = true;
            }
            pw8Var.n = ex8.H(M.isBlocked(), u12.l0(), equals, U, M.isWorksInfo(), M.isScoreThread());
            pw8Var.e = ex8.F(u12, equals, u12.l0(), this.x0.Y());
            pw8Var.i = P6();
            pw8Var.f = ex8.G(this.x0.u1(), equals, this.x0.Y());
            if (equals && u12.T() != null && u12.T().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            pw8Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                pw8Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            pw8Var.t = equals;
            pw8Var.q = this.x0.M1();
            pw8Var.b = true;
            pw8Var.a = ex8.B(this.x0.u1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            pw8Var.p = z5;
            pw8Var.j = true;
            pw8Var.o = this.x0.X0();
            pw8Var.d = true;
            if (M.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            pw8Var.c = z6;
            if (u12.h0()) {
                pw8Var.b = false;
                pw8Var.d = false;
                pw8Var.c = false;
                pw8Var.g = false;
                pw8Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !u12.h0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            pw8Var.v = z7;
            if (this.F0 != null && (ht8Var = this.x0.G) != null) {
                am9 V = ht8Var.V();
                if (V != null) {
                    z8 = V.S;
                } else {
                    z8 = false;
                }
                pw8Var.w = z8;
            }
            pw8Var.m = true;
            if (M.isBlocked()) {
                pw8Var.n = false;
                pw8Var.g = false;
                pw8Var.h = false;
            }
            this.F0.h.u(pw8Var);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            te5 te5Var = this.U0;
            if (te5Var != null) {
                te5Var.C(i3, i4, intent);
            }
            if (G5().g1() != null) {
                G5().g1().k(i3, i4, intent);
            }
            if (i3 == 25035) {
                L5(i4, intent);
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
                                                    fx8 fx8Var = this.F0;
                                                    if (fx8Var != null && fx8Var.H0() != null) {
                                                        this.F0.H0().performClick();
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
                                        this.F0.p3(false);
                                        if (this.x0.u1() != null && this.x0.u1().M() != null && this.x0.u1().M().getPushStatusData() != null) {
                                            this.x0.u1().M().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        ga9.g().m(getPageContext());
                                        j7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                            shareSuccessReplyToServerModel.Q(str, intExtra, new f2(this));
                                        }
                                        if (W5()) {
                                            h7(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.Q;
                                if (view5 != null) {
                                    this.F0.F3(view5);
                                    return;
                                }
                                return;
                            }
                            O5(intent);
                            return;
                        }
                        ga9.g().m(getPageContext());
                        return;
                    }
                    ww8.b().k();
                    this.w0.postDelayed(new e2(this), 1000L);
                    return;
                }
                g6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        fx8 fx8Var;
        fx8 fx8Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.c1 = getPageContext();
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
                this.K2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.L2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.M2 = intent.getStringExtra("key_manga_title");
                this.P0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.Q0 = intent.getStringExtra("high_light_post_id");
                this.R0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (x5()) {
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
                this.n1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                xy4 xy4Var = new xy4();
                this.b0 = xy4Var;
                xy4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.p1 = intExtra;
                if (intExtra == 0) {
                    this.p1 = intent.getIntExtra("key_start_from", 0);
                }
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            b6(bundle);
            if (this.x0.u1() != null) {
                this.x0.u1().R0(this.O);
            }
            T5();
            if (intent != null && (fx8Var2 = this.F0) != null) {
                fx8Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.f1 == null) {
                        this.f1 = new k0(this, intent);
                    }
                    jg.a().postDelayed(this.f1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.x0.u1() != null) {
                    this.x0.a3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            S5(bundle);
            ve5 ve5Var = new ve5();
            this.T0 = ve5Var;
            I6(ve5Var);
            te5 te5Var = (te5) this.T0.a(getActivity());
            this.U0 = te5Var;
            te5Var.W(this.a.getPageContext());
            this.U0.f0(this.i2);
            this.U0.g0(this.X0);
            this.U0.Y(1);
            this.U0.A(this.a.getPageContext(), bundle);
            this.U0.b().b(new ad5(getActivity()));
            this.U0.b().E(true);
            L6(true);
            this.U0.J(this.x0.W0(), this.x0.N1(), this.x0.S0());
            registerListener(this.w1);
            if (!this.x0.h1()) {
                this.U0.q(this.x0.N1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.x0.d2()) {
                this.U0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                fx8 fx8Var3 = this.F0;
                if (fx8Var3 != null) {
                    this.U0.c0(fx8Var3.h1());
                }
            }
            registerListener(this.v1);
            registerListener(this.x1);
            registerListener(this.y1);
            registerListener(this.u1);
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.o2);
            registerListener(this.t1);
            rl9 rl9Var = new rl9("pb", rl9.d);
            this.S0 = rl9Var;
            rl9Var.d();
            registerListener(this.E1);
            registerListener(this.O1);
            this.x0.x2();
            registerListener(this.n2);
            registerListener(this.b2);
            registerListener(this.h2);
            registerListener(this.K1);
            registerListener(this.a2);
            registerListener(this.F1);
            fx8 fx8Var4 = this.F0;
            if (fx8Var4 != null && fx8Var4.n1() != null && this.F0.l1() != null) {
                ky8 ky8Var = new ky8(getActivity(), this.F0.n1(), this.F0.l1(), this.F0.e1());
                this.e = ky8Var;
                ky8Var.t(this.N1);
            }
            if (this.c && (fx8Var = this.F0) != null && fx8Var.l1() != null) {
                this.F0.l1().setVisibility(8);
            }
            v45 v45Var = new v45();
            this.d1 = v45Var;
            v45Var.a = 1000L;
            registerListener(this.X1);
            registerListener(this.W1);
            registerListener(this.U1);
            registerListener(this.V1);
            registerListener(this.H1);
            registerListener(this.I1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.C1);
            this.G1.setSelfListener(true);
            this.G1.setTag(this.a.getUniqueId());
            this.G1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.G1);
            registerResponsedEventListener(TipEvent.class, this.P1);
            registerResponsedEventListener(TopToastEvent.class, this.Q1);
            this.e1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.e1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.e1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.R1 = new f3(this.F0, this);
            this.x0.O0().U(this.R1);
            this.J0 = new ix8();
            if (this.U0.s() != null) {
                this.J0.m(this.U0.s().i());
            }
            this.U0.V(this.Y0);
            this.E0 = new ShareSuccessReplyToServerModel();
            S4(this.r1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.W0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new l0(this));
            iz8 iz8Var = new iz8(getContext());
            this.y0 = iz8Var;
            iz8Var.b(getUniqueId());
            ck9.g().i(getUniqueId());
            fw4.b().l("3", "");
            this.q1 = new xf6(getPageContext());
            this.t0 = new xy8(this, getUniqueId(), this.F0, this.x0);
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
            this.F0 = new fx8(this, this.g2, this.S1, this.f2);
            qo6 qo6Var = new qo6(getActivity());
            this.d = qo6Var;
            qo6Var.i(P2);
            this.d.d(this.I2);
            this.F0.g3(this.q2);
            this.F0.f3(this.v2);
            this.F0.Z2(this.s2);
            this.F0.a3(this.t2);
            this.F0.X2(sv4.c().g());
            this.F0.d3(this.x2);
            this.F0.j3(this.D2);
            this.F0.h3(this.E2);
            this.F0.e3(this.G2);
            this.F0.g4(this.mIsLogin);
            this.F0.V2(this.x0.b2());
            if (this.a.getIntent() != null) {
                this.F0.W2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.F0.f1().setFromForumId(this.x0.getFromForumId());
            te5 te5Var = this.U0;
            if (te5Var != null) {
                this.F0.N2(te5Var.b());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.U0.c0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.U0.c0(this.F0.h1());
                }
            }
            this.F0.R2(this.d2);
            this.F0.U2(this.x0.c1());
            this.F0.i3(this.x0.t1());
            this.t0.f(this.F0, this.x0);
            if ("1".equals(P().showReplyPanel)) {
                this.F0.j2();
            }
            return this.F0.o1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText u5(ArrayList<am9> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048739, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText a02 = arrayList.get(i4).a0();
                    if (a02 != null && (S = a02.S()) != null) {
                        int size = S.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (S.get(i6) != null && S.get(i6).getType() == 8) {
                                i5++;
                                if (!S.get(i6).Y().R().equals(str) && !S.get(i6).Y().S().equals(str)) {
                                    if (i5 > i3) {
                                        break;
                                    }
                                } else {
                                    int i7 = (int) ii.i(TbadkCoreApplication.getInst());
                                    int width = S.get(i6).Y().getWidth() * i7;
                                    int height = S.get(i6).Y().getHeight() * i7;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.w2 = i6;
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

    public final void q6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048730, this, str, i3, eVar) != null) || eVar == null) {
            return;
        }
        ht8 u12 = this.x0.u1();
        TbRichText m7 = m7(str, i3);
        if (m7 == null || (tbRichTextData = m7.S().get(this.w2)) == null) {
            return;
        }
        eVar.f = String.valueOf(m7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.Y().W()) {
            eVar.h = false;
            String a4 = it8.a(tbRichTextData);
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
            imageUrlData.originalUrl = ex8.n(tbRichTextData);
            imageUrlData.originalUrl = ex8.n(tbRichTextData);
            imageUrlData.originalSize = ex8.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = ex8.k(tbRichTextData);
            imageUrlData.isLongPic = ex8.j(tbRichTextData);
            imageUrlData.postId = m7.getPostId();
            imageUrlData.mIsReserver = this.x0.F1();
            imageUrlData.mIsSeeHost = this.x0.X0();
            eVar.b.put(a4, imageUrlData);
            if (u12 != null) {
                if (u12.k() != null) {
                    eVar.c = u12.k().getName();
                    eVar.d = u12.k().getId();
                }
                if (u12.M() != null) {
                    eVar.e = u12.M().getId();
                }
                if (u12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = gg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = u12.F().size();
        this.y2 = false;
        eVar.j = -1;
        if (u12.i() != null) {
            i4 = v5(u12.i().a0(), m7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            am9 am9Var = u12.F().get(i7);
            if (am9Var.O() == null || u12.i() == null || u12.i().O() == null || !am9Var.O().equals(u12.i().O())) {
                i6 = v5(am9Var.a0(), m7, i6, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (u12 != null) {
            if (u12.k() != null) {
                eVar.c = u12.k().getName();
                eVar.d = u12.k().getId();
            }
            if (u12.M() != null) {
                eVar.e = u12.M().getId();
            }
            if (u12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i6;
    }

    public final int v5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo Y;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048741, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.y2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.S().size();
                int i6 = i3;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.S().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int i9 = (int) ii.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.Y().getWidth() * i9;
                        int height = tbRichTextData.Y().getHeight() * i9;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.Y().W()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = it8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (Y = tbRichTextData.Y()) != null) {
                                        String R = Y.R();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            R = Y.S();
                                        } else {
                                            if (this.q) {
                                                i5 = 17;
                                            } else {
                                                i5 = 18;
                                            }
                                            imageUrlData.urlType = i5;
                                        }
                                        imageUrlData.imageUrl = R;
                                        imageUrlData.originalUrl = ex8.n(tbRichTextData);
                                        imageUrlData.originalSize = ex8.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = ex8.k(tbRichTextData);
                                        imageUrlData.isLongPic = ex8.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = gg.g(this.x0.N1(), -1L);
                                        imageUrlData.mIsReserver = this.x0.F1();
                                        imageUrlData.mIsSeeHost = this.x0.X0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.y2) {
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

    public void w6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048745, this, z3, markData) == null) {
            this.F0.m3();
            this.x0.i3(z3);
            at4 at4Var = this.z0;
            if (at4Var != null) {
                at4Var.h(z3);
                if (markData != null) {
                    this.z0.i(markData);
                }
            }
            if (this.x0.f1()) {
                e6();
            } else {
                this.F0.I1(this.x0.u1());
            }
        }
    }
}
