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
import com.baidu.tieba.a15;
import com.baidu.tieba.a25;
import com.baidu.tieba.a49;
import com.baidu.tieba.a55;
import com.baidu.tieba.a69;
import com.baidu.tieba.ai5;
import com.baidu.tieba.ak5;
import com.baidu.tieba.b49;
import com.baidu.tieba.b79;
import com.baidu.tieba.c55;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cb9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d49;
import com.baidu.tieba.da9;
import com.baidu.tieba.dh5;
import com.baidu.tieba.di5;
import com.baidu.tieba.du4;
import com.baidu.tieba.dx4;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ea9;
import com.baidu.tieba.ei5;
import com.baidu.tieba.en6;
import com.baidu.tieba.eu4;
import com.baidu.tieba.eu7;
import com.baidu.tieba.ey9;
import com.baidu.tieba.fi5;
import com.baidu.tieba.fw5;
import com.baidu.tieba.g69;
import com.baidu.tieba.gb5;
import com.baidu.tieba.gl9;
import com.baidu.tieba.gn;
import com.baidu.tieba.gw9;
import com.baidu.tieba.gx5;
import com.baidu.tieba.h55;
import com.baidu.tieba.h95;
import com.baidu.tieba.hp5;
import com.baidu.tieba.hs5;
import com.baidu.tieba.i35;
import com.baidu.tieba.i79;
import com.baidu.tieba.ih5;
import com.baidu.tieba.iz9;
import com.baidu.tieba.j39;
import com.baidu.tieba.j55;
import com.baidu.tieba.j9;
import com.baidu.tieba.jb;
import com.baidu.tieba.jg5;
import com.baidu.tieba.js5;
import com.baidu.tieba.jw6;
import com.baidu.tieba.k35;
import com.baidu.tieba.k39;
import com.baidu.tieba.k55;
import com.baidu.tieba.k9;
import com.baidu.tieba.kf5;
import com.baidu.tieba.kg;
import com.baidu.tieba.kr5;
import com.baidu.tieba.kw5;
import com.baidu.tieba.kw6;
import com.baidu.tieba.kx5;
import com.baidu.tieba.ky9;
import com.baidu.tieba.l15;
import com.baidu.tieba.l55;
import com.baidu.tieba.l86;
import com.baidu.tieba.l95;
import com.baidu.tieba.lb9;
import com.baidu.tieba.lg;
import com.baidu.tieba.lh5;
import com.baidu.tieba.m99;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n05;
import com.baidu.tieba.n29;
import com.baidu.tieba.ns5;
import com.baidu.tieba.o49;
import com.baidu.tieba.o69;
import com.baidu.tieba.o99;
import com.baidu.tieba.oe5;
import com.baidu.tieba.on9;
import com.baidu.tieba.p16;
import com.baidu.tieba.p29;
import com.baidu.tieba.p45;
import com.baidu.tieba.p49;
import com.baidu.tieba.p99;
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
import com.baidu.tieba.pr5;
import com.baidu.tieba.q95;
import com.baidu.tieba.qx4;
import com.baidu.tieba.qy5;
import com.baidu.tieba.r25;
import com.baidu.tieba.r29;
import com.baidu.tieba.r79;
import com.baidu.tieba.r99;
import com.baidu.tieba.rf5;
import com.baidu.tieba.s16;
import com.baidu.tieba.s49;
import com.baidu.tieba.s79;
import com.baidu.tieba.s99;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sf5;
import com.baidu.tieba.sh5;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sj5;
import com.baidu.tieba.t35;
import com.baidu.tieba.t89;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tg;
import com.baidu.tieba.tj5;
import com.baidu.tieba.u95;
import com.baidu.tieba.ui;
import com.baidu.tieba.uq9;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ux9;
import com.baidu.tieba.v59;
import com.baidu.tieba.v79;
import com.baidu.tieba.vf5;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vj5;
import com.baidu.tieba.vn;
import com.baidu.tieba.vx9;
import com.baidu.tieba.w55;
import com.baidu.tieba.w5a;
import com.baidu.tieba.w89;
import com.baidu.tieba.wg;
import com.baidu.tieba.wj5;
import com.baidu.tieba.wl5;
import com.baidu.tieba.x79;
import com.baidu.tieba.xd5;
import com.baidu.tieba.y26;
import com.baidu.tieba.y79;
import com.baidu.tieba.y89;
import com.baidu.tieba.ya9;
import com.baidu.tieba.yj5;
import com.baidu.tieba.z5a;
import com.baidu.tieba.z69;
import com.baidu.tieba.z89;
import com.baidu.tieba.zn;
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
public class PbFragment extends BaseFragment implements s16, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a55.e, TbRichTextView.u, TbPageContextSupport, cb9, lb9.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k R2;
    public static final kw6.b S2;
    public transient /* synthetic */ FieldHolder $fh;
    public kg<ImageView> A;
    public ea9 A0;
    public CustomMessageListener A1;
    public boolean A2;
    public kg<View> B;
    public dx4 B0;
    public CustomMessageListener B1;
    public ey9 B2;
    public kg<TiebaPlusRecommendCard> C;
    public ForumManageModel C0;
    public final CustomMessageListener C1;
    public final c55.c C2;
    public kg<LinearLayout> D;
    public oe5 D0;
    public CustomMessageListener D1;
    public final c55.c D2;
    public kg<RelativeLayout> E;
    public d49 E0;
    public CustomMessageListener E1;
    public final AdapterView.OnItemClickListener E2;
    public kg<ItemCardView> F;
    public PollingModel F0;
    public View.OnClickListener F1;
    public final View.OnLongClickListener F2;
    @NonNull
    public PbGodGuideController G;
    public ShareSuccessReplyToServerModel G0;
    public CustomMessageListener G1;
    public final View.OnClickListener G2;
    public kg<FestivalTipView> H;
    public s79 H0;
    public CustomMessageListener H1;
    public final ItemCardHelper.c H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public final NoNetworkView.b I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public View.OnTouchListener J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public jw6.b K2;
    public kg<GifView> L;
    public v79 L0;
    public SuggestEmotionModel.c L1;
    public final g69.b L2;
    public String M;
    public j55 M0;
    public CustomMessageListener M1;
    public int M2;
    public boolean N;
    public l55 N0;
    public GetSugMatchWordsModel.b N1;
    public int N2;
    public boolean O;
    public String O0;
    public PraiseModel O1;
    public String O2;
    public String P;
    public boolean P0;
    public z89.h P1;
    public a25 P2;
    public LikeModel Q;
    public boolean Q0;
    public CustomMessageListener Q1;
    public int Q2;
    public View R;
    public boolean R0;
    public hp5 R1;
    public View S;
    public String S0;
    public hp5 S1;

    /* renamed from: T  reason: collision with root package name */
    public View f1148T;
    public boolean T0;
    public CheckRealNameModel.b T1;
    public View U;
    public vx9 U0;
    public p49 U1;
    public String V;
    public yj5 V0;
    public final Runnable V1;
    public int W;
    public wj5 W0;
    public CustomMessageListener W1;
    public boolean X;
    public PermissionJudgePolicy X0;
    public CustomMessageListener X1;
    public int[] Y;
    public ReplyPrivacyCheckController Y0;
    public CustomMessageListener Y1;
    public int Z;
    public tj5 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public sj5 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public sj5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public t35 c0;
    public int c1;
    public CustomMessageListener c2;
    public kw6 d;
    public BdUniqueId d0;
    public Object d1;
    public CustomMessageListener d2;
    public z89 e;
    public h95 e0;
    public k9 e1;
    public a55.e e2;
    public boolean f;
    public boolean f0;
    public q95 f1;
    public g3 f2;
    public boolean g;
    public boolean g0;
    public BdUniqueId g1;
    public l55.f g2;
    public boolean h;
    public Object h0;
    public Runnable h1;
    public final SortSwitchButton.f h2;
    public VoiceManager i;
    public ux9 i0;
    public x79 i1;
    public final View.OnClickListener i2;
    public int j;
    public rf5 j0;
    public gn j1;
    public CustomMessageListener j2;
    public c55 k;
    public String k1;
    public final NewWriteModel.d k2;
    public long l;
    public TbRichTextImageInfo l1;
    public Boolean l2;
    public long m;
    public TbRichTextMemeInfo m1;
    public NewWriteModel.d m2;
    public long n;
    public boolean n1;
    public jb n2;
    public long o;
    public int o1;
    public final PbModel.h o2;
    public long p;
    public int p1;
    public CustomMessageListener p2;
    public boolean q;
    public List<e3> q1;
    public HttpMessageListener q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public final dx4.a r2;
    public hs5 s;
    public boolean s0;
    public en6 s1;
    public final AbsListView.OnScrollListener s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public final e3 t1;
    public final j9 t2;
    public boolean u;
    public m99 u0;
    public final z69.b u1;
    public final u95.g u2;
    public long v;
    public PushPermissionController v0;
    public final CustomMessageListener v1;
    public final View.OnClickListener v2;
    public int w;
    public boolean w0;
    public CustomMessageListener w1;
    public boolean w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public CustomMessageListener x1;
    public final BdListView.p x2;
    public kg<TextView> y;
    public final Handler y0;
    public CustomMessageListener y1;
    public int y2;
    public kg<TbImageView> z;
    public PbModel z0;
    public CustomMessageListener z1;
    public final TbRichTextView.a0 z2;

    /* loaded from: classes7.dex */
    public interface e3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface g3 {
        void callback(Object obj);
    }

    @Override // com.baidu.tieba.cb9
    public AbsVideoPbFragment N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s16
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s16
    public void i1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048681, this, context, str) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb9
    public PbFragment z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this : (PbFragment) invokeV.objValue;
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
                    s49.a(this.b.a.getPageContext(), this.a).show();
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
                wg.a().postDelayed(new a(this, customDialogData), 1000L);
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
                v79 v79Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (v79Var = this.a.c.L0) != null && v79Var.g() != null) {
                    if (!this.a.c.L0.g().e()) {
                        this.a.c.L0.b(false);
                    }
                    this.a.c.L0.g().l(false);
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
                int j = vi.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = vi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = vi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.H0 != null && this.c.H0.a1() != null) {
                    this.c.H0.a1().smoothScrollBy(i3, 50);
                }
                if (this.c.L5().k1() != null) {
                    if (this.c.W0 != null) {
                        this.c.W0.b().setVisibility(8);
                    }
                    this.c.L5().k1().t(this.a, this.b, this.c.L5().l1(), (this.c.z0 == null || this.c.z0.y1() == null || this.c.z0.y1().N() == null || !this.c.z0.y1().N().isBjh()) ? false : false);
                    ak5 f = this.c.L5().k1().f();
                    if (f != null && this.c.z0 != null && this.c.z0.y1() != null) {
                        f.H(this.c.z0.y1().c());
                        f.d0(this.c.z0.y1().N());
                    }
                    if (this.c.L0.f() == null && this.c.L5().k1().f().u() != null) {
                        this.c.L5().k1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.L0.n(pbFragment2.L5().k1().f().u().i());
                        this.c.L5().k1().f().N(this.c.b1);
                    }
                }
                this.c.L5().u1();
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
                v79 v79Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (v79Var = this.a.c.L0) != null && v79Var.g() != null) {
                    if (!this.a.c.L0.g().e()) {
                        this.a.c.L0.b(false);
                    }
                    this.a.c.L0.g().l(false);
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
                int j = vi.j(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = j / 2;
                    g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.H0 != null && this.c.H0.a1() != null) {
                    this.c.H0.a1().smoothScrollBy(i3, 50);
                }
                if (this.c.L5().k1() != null) {
                    if (this.c.W0 != null) {
                        this.c.W0.b().setVisibility(8);
                    }
                    this.c.L5().k1().t(this.a, this.b, this.c.L5().l1(), (this.c.z0 == null || this.c.z0.y1() == null || this.c.z0.y1().N() == null || !this.c.z0.y1().N().isBjh()) ? false : false);
                    ak5 f = this.c.L5().k1().f();
                    if (f != null && this.c.z0 != null && this.c.z0.y1() != null) {
                        f.H(this.c.z0.y1().c());
                        f.d0(this.c.z0.y1().N());
                    }
                    if (this.c.L0.f() == null && this.c.L5().k1().f().u() != null) {
                        this.c.L5().k1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.L0.n(pbFragment2.L5().k1().f().u().i());
                        this.c.L5().k1().f().N(this.c.b1);
                    }
                }
                this.c.L5().u1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:759:0x1e02, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:783:0x1eb6, code lost:
            if ((r32.a.H0.g1.a.getView().getTop() - r32.a.H0.k.a.getBottom()) < (r32.a.H0.g1.a.g.getHeight() + 10)) goto L759;
         */
        /* JADX WARN: Removed duplicated region for block: B:1033:0x27c0  */
        /* JADX WARN: Removed duplicated region for block: B:1034:0x27d6  */
        /* JADX WARN: Removed duplicated region for block: B:1037:0x2812  */
        /* JADX WARN: Removed duplicated region for block: B:1279:0x31b9  */
        /* JADX WARN: Removed duplicated region for block: B:1280:0x31be  */
        /* JADX WARN: Removed duplicated region for block: B:1283:0x31cd  */
        /* JADX WARN: Removed duplicated region for block: B:1317:0x327b  */
        /* JADX WARN: Removed duplicated region for block: B:1320:0x328a  */
        /* JADX WARN: Removed duplicated region for block: B:1323:0x329d  */
        /* JADX WARN: Removed duplicated region for block: B:1326:0x32ae  */
        /* JADX WARN: Removed duplicated region for block: B:1329:0x32c4  */
        /* JADX WARN: Removed duplicated region for block: B:1331:0x32cd  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            j39 y1;
            int i;
            int i2;
            ey9 W;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            h55 h55Var;
            h55 h55Var2;
            h55 h55Var3;
            String string;
            boolean z;
            h55 h55Var4;
            h55 h55Var5;
            h55 h55Var6;
            h55 h55Var7;
            String name;
            boolean z2;
            int i3;
            int i4;
            p45 p45Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i5;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || !this.a.isAdded()) {
                return;
            }
            if (this.a.s0 && (view2 == this.a.H0.k.e || view2 == this.a.H0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091a6d || view2.getId() == R.id.obfuscated_res_0x7f090b4f || view2.getId() == R.id.obfuscated_res_0x7f091e2d || view2.getId() == R.id.obfuscated_res_0x7f091a08)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.H0.d1() && this.a.getPageContext().getPageActivity() != null && this.a.z0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.R1(), this.a.z0.j2(), this.a.z0.i2())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.z0.getForumId());
                    statisticItem2.param("fname", this.a.z0.X0());
                    statisticItem2.param("tid", this.a.z0.R1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.H0.f1()) {
                    if (!this.a.h && this.a.z0.u2(true)) {
                        this.a.h = true;
                        this.a.H0.y3();
                    }
                } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().E()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.H0.v0();
                    this.a.k7();
                    this.a.H0.x3();
                    this.a.H0.S3();
                    if (this.a.H0.i1() != null) {
                        this.a.H0.i1().setVisibility(8);
                    }
                    this.a.z0.k3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().x()) {
                    if (view2 == this.a.H0.k.h) {
                        if (this.a.H0.j0(this.a.z0.l1())) {
                            this.a.k7();
                            return;
                        }
                        vi.z(this.a.a, this.a.H0.k.h);
                        this.a.a.finish();
                    } else if (view2 == this.a.H0.L0() || (this.a.H0.k.i() != null && (view2 == this.a.H0.k.i().F() || view2 == this.a.H0.k.i().G()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.z0.y1() != null && !this.a.C0.n0()) {
                            this.a.H0.v0();
                            int i7 = (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().G()) ? (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().F()) ? view2 == this.a.H0.L0() ? 2 : 0 : this.a.z0.y1().N().getIs_good() == 1 ? 3 : 6 : this.a.z0.y1().N().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.z0.y1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.z0.y1().N().getId();
                            this.a.H0.n4();
                            this.a.C0.r0(id, name3, id2, i7, this.a.H0.M0());
                        }
                    } else if (view2 == this.a.H0.T0()) {
                        if (this.a.z0 != null) {
                            qx4.s(this.a.getPageContext().getPageActivity(), this.a.z0.y1().N().getTopicData().b());
                        }
                    } else if (view2 == this.a.H0.k.e) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.z0.y1() != null && this.a.z0.y1().N() != null && this.a.z0.y1().N().isVideoThreadType() && this.a.z0.y1().N().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.z0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.z0.X0()) || this.a.z0.O0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.z0.O0().b;
                        } else {
                            name2 = this.a.z0.y1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String X0 = this.a.z0.X0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.z0.d1() || X0 == null || !X0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.H0.k.f) {
                        if (fw5.a()) {
                            return;
                        }
                        if (this.a.z0 == null || this.a.z0.y1() == null) {
                            vi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fae));
                            return;
                        }
                        ArrayList<ey9> F = this.a.z0.y1().F();
                        if ((F == null || F.size() <= 0) && this.a.z0.Q1()) {
                            vi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fae));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.z0.R1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.z0.getForumId()));
                        this.a.H0.U2();
                        this.a.s6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a2c) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.H0.i3(true);
                        this.a.H0.U2();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.H0.c4();
                        this.a.k7();
                        this.a.H0.x3();
                        this.a.z0.o3(this.a.x5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a03) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.H0.v0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091a03 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (r79.c(this.a.getPageContext(), 11009) && this.a.z0.P0(this.a.H0.Z0()) != null) {
                                this.a.l6();
                                if (this.a.z0.y1() != null && this.a.z0.y1().N() != null && this.a.z0.y1().N().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.y1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.z0.y1().N() == null || this.a.z0.y1().N().getAuthor() == null || this.a.z0.y1().N().getAuthor().getUserId() == null || this.a.B0 == null) {
                                    return;
                                }
                                int v = r79.v(this.a.z0.y1());
                                ThreadData N = this.a.z0.y1().N();
                                if (N.isBJHArticleThreadType()) {
                                    i6 = 2;
                                } else if (N.isBJHVideoThreadType()) {
                                    i6 = 3;
                                } else if (N.isBJHNormalThreadType()) {
                                    i6 = 4;
                                } else {
                                    i6 = N.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.z0.b).param("obj_locate", 1).param("obj_id", this.a.z0.y1().N().getAuthor().getUserId()).param("obj_type", !this.a.B0.e()).param("obj_source", v).param("obj_param1", i6));
                                return;
                            }
                            return;
                        }
                        this.a.U = view2;
                    } else if ((this.a.H0.k.i() != null && view2 == this.a.H0.k.i().C()) || view2.getId() == R.id.obfuscated_res_0x7f090b4f || view2.getId() == R.id.obfuscated_res_0x7f091e2d) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.H0.v0();
                        if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().C()) {
                            this.a.H0.U2();
                        }
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.k7();
                        this.a.H0.x3();
                        boolean p3 = view2.getId() == R.id.obfuscated_res_0x7f090b4f ? this.a.z0.p3(true, this.a.x5()) : view2.getId() == R.id.obfuscated_res_0x7f091e2d ? this.a.z0.p3(false, this.a.x5()) : this.a.z0.o3(this.a.x5());
                        view2.setTag(Boolean.valueOf(p3));
                        if (p3) {
                            i5 = 1;
                            this.a.H0.i3(true);
                            this.a.H0.c4();
                            this.a.h = true;
                            this.a.H0.m3(true);
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                    } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().y()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (r79.c(this.a.getPageContext(), 11009)) {
                                r79.w(this.a.getContext(), 3, this.a.t5(), this.a.z0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a08 || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (y1 = this.a.z0.y1()) == null) {
                                return;
                            }
                            ThreadData N2 = y1.N();
                            if (N2 != null && N2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", y1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            if (N2 != null) {
                                if (N2.isBJHArticleThreadType()) {
                                    i = 2;
                                } else if (N2.isBJHVideoThreadType()) {
                                    i = 3;
                                } else if (N2.isBJHNormalThreadType()) {
                                    i = 4;
                                } else if (N2.isBJHVideoDynamicThreadType()) {
                                    i = 5;
                                }
                                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem3.param("tid", this.a.z0.R1());
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.a.z0.getForumId());
                                if (view2.getId() != R.id.share_num_container) {
                                    statisticItem3.param("obj_locate", 5);
                                } else {
                                    statisticItem3.param("obj_locate", 6);
                                }
                                statisticItem3.param("obj_name", i);
                                statisticItem3.param("obj_type", 1);
                                if (N2 != null) {
                                    if (N2.isBJHArticleThreadType()) {
                                        statisticItem3.param("obj_type", 10);
                                    } else if (N2.isBJHVideoThreadType()) {
                                        statisticItem3.param("obj_type", 9);
                                    } else if (N2.isBJHVideoDynamicThreadType()) {
                                        statisticItem3.param("obj_type", 8);
                                    } else if (N2.isBJHNormalThreadType()) {
                                        statisticItem3.param("obj_type", 7);
                                    } else if (N2.isShareThread) {
                                        statisticItem3.param("obj_type", 6);
                                    } else {
                                        int i8 = N2.threadType;
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
                                            statisticItem3.param("card_type", N2.getRecomCardType());
                                            statisticItem3.param("recom_source", N2.mRecomSource);
                                            statisticItem3.param("ab_tag", N2.mRecomAbTag);
                                            statisticItem3.param("weight", N2.mRecomWeight);
                                            statisticItem3.param("extra", N2.mRecomExtra);
                                            statisticItem3.param("nid", N2.getNid());
                                            if (N2.getBaijiahaoData() != null && !ui.isEmpty(N2.getBaijiahaoData().oriUgcVid)) {
                                                statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, N2.getBaijiahaoData().oriUgcVid);
                                            }
                                        }
                                    }
                                    statisticItem3.param("card_type", N2.getRecomCardType());
                                    statisticItem3.param("recom_source", N2.mRecomSource);
                                    statisticItem3.param("ab_tag", N2.mRecomAbTag);
                                    statisticItem3.param("weight", N2.mRecomWeight);
                                    statisticItem3.param("extra", N2.mRecomExtra);
                                    statisticItem3.param("nid", N2.getNid());
                                    if (N2.getBaijiahaoData() != null) {
                                        statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, N2.getBaijiahaoData().oriUgcVid);
                                    }
                                }
                                if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                }
                                if (this.a.V() != null) {
                                    pr5.e(this.a.V(), statisticItem3);
                                }
                                if (this.a.H0 != null) {
                                    statisticItem3.param("obj_param1", this.a.H0.W0());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (vi.F()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
                                    return;
                                } else if (y1 == null) {
                                    vi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fae));
                                    return;
                                } else {
                                    ArrayList<ey9> F2 = this.a.z0.y1().F();
                                    if ((F2 == null || F2.size() <= 0) && this.a.z0.Q1()) {
                                        vi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fae));
                                        return;
                                    }
                                    this.a.H0.v0();
                                    this.a.k7();
                                    if (y1.A() != null && !StringUtils.isNull(y1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.z0.y1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), N2)) {
                                        return;
                                    }
                                    if (this.a.H0 != null) {
                                        this.a.H0.x0();
                                        this.a.H0.u4(y1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a08) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.H0.c2() && !y1.o0()) {
                                            if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                if (kf5.c() > 0) {
                                                    r79.J(this.a.getContext(), this.a.z0.y1());
                                                    return;
                                                }
                                                int W0 = this.a.H0.W0();
                                                this.a.H0.i0();
                                                this.a.W5(kf5.a(), W0);
                                                return;
                                            }
                                            this.a.e7(i2);
                                            return;
                                        }
                                        this.a.e7(i2);
                                        return;
                                    }
                                    this.a.H0.S3();
                                    this.a.z0.S0().W(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.z0.R1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.z0.getForumId());
                            if (view2.getId() != R.id.share_num_container) {
                            }
                            statisticItem32.param("obj_name", i);
                            statisticItem32.param("obj_type", 1);
                            if (N2 != null) {
                            }
                            if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            }
                            if (this.a.V() != null) {
                            }
                            if (this.a.H0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (vi.F()) {
                            }
                        } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().D()) {
                            if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().K()) {
                                if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().J()) {
                                    if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().H()) {
                                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                                        UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                        this.a.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                        if (skinType == 0) {
                                            TbadkCoreApplication.getInst().setSkinType(4);
                                        } else {
                                            l95.m().w("key_is_follow_system_mode", false);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        }
                                        this.a.H0.k.g();
                                        return;
                                    } else if (this.a.H0.X0() == view2) {
                                        if (!this.a.H0.X0().getIndicateStatus()) {
                                            ky9.d("c10725", null);
                                        } else {
                                            j39 y12 = this.a.z0.y1();
                                            if (y12 != null && y12.N() != null && y12.N().getTaskInfoData() != null) {
                                                String e = y12.N().getTaskInfoData().e();
                                                if (StringUtils.isNull(e)) {
                                                    e = y12.N().getTaskInfoData().h();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e));
                                            }
                                        }
                                        this.a.O5();
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().A()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.H0.v0();
                                        SparseArray<Object> b1 = this.a.H0.b1(this.a.z0.y1(), this.a.z0.Q1(), 1);
                                        if (b1 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.y1().k().getId(), this.a.z0.y1().k().getName(), this.a.z0.y1().N().getId(), StringUtils.string(this.a.z0.y1().U().getUserId()), StringUtils.string(b1.get(R.id.tag_forbid_user_name)), StringUtils.string(b1.get(R.id.tag_forbid_user_name_show)), StringUtils.string(b1.get(R.id.tag_forbid_user_post_id)), StringUtils.string(b1.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().u()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> b12 = this.a.H0.b1(this.a.z0.y1(), this.a.z0.Q1(), 1);
                                        if (b12 != null) {
                                            this.a.H0.B2(((Integer) b12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(b12.get(R.id.tag_del_post_id)), ((Integer) b12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b12.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.H0.k.f();
                                        if (this.a.Q() == null || this.a.Q().y1() == null || this.a.Q().y1().N() == null) {
                                            return;
                                        }
                                        ThreadData N3 = this.a.Q().y1().N();
                                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem4.param("tid", N3.getId());
                                        statisticItem4.param("fid", N3.getFid());
                                        statisticItem4.param("fname", N3.getForum_name());
                                        TiebaStatic.log(statisticItem4);
                                        StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem5.param("tid", N3.getId());
                                        statisticItem5.param("fid", N3.getFid());
                                        statisticItem5.param("fname", N3.getForum_name());
                                        statisticItem5.param("obj_source", 3);
                                        TiebaStatic.log(statisticItem5);
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().z()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> b13 = this.a.H0.b1(this.a.z0.y1(), this.a.z0.Q1(), 1);
                                        if (b13 != null) {
                                            if (StringUtils.isNull((String) b13.get(R.id.tag_del_multi_forum))) {
                                                this.a.H0.y2(((Integer) b13.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(b13.get(R.id.tag_del_post_id)), ((Integer) b13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b13.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.H0.z2(((Integer) b13.get(R.id.tag_del_post_type)).intValue(), (String) b13.get(R.id.tag_del_post_id), ((Integer) b13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b13.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(b13.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.H0.k.f();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092214 && view2.getId() != R.id.obfuscated_res_0x7f091a1c && view2.getId() != R.id.obfuscated_res_0x7f0918a7) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091a82) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091a80 && view2.getId() != R.id.obfuscated_res_0x7f091c5d && view2.getId() != R.id.obfuscated_res_0x7f091a16) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091a1a) {
                                                    try {
                                                        sparseArray = (SparseArray) view2.getTag();
                                                    } catch (ClassCastException e2) {
                                                        e2.printStackTrace();
                                                        sparseArray = null;
                                                    }
                                                    ey9 ey9Var = (ey9) sparseArray.get(R.id.tag_clip_board);
                                                    if (ey9Var == null) {
                                                        return;
                                                    }
                                                    if (this.a.N0 == null) {
                                                        PbFragment pbFragment = this.a;
                                                        pbFragment.N0 = new l55(pbFragment.getContext());
                                                        this.a.N0.q(this.a.g2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.Q().y1() != null && this.a.Q().y1().i0();
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
                                                    if (ey9Var.n() != null) {
                                                        boolean z4 = ey9Var.n().hasAgree;
                                                        int o = ey9Var.o();
                                                        if (z4 && o == 5) {
                                                            string = this.a.getString(R.string.action_cancel_dislike);
                                                        } else {
                                                            string = this.a.getString(R.string.action_dislike);
                                                        }
                                                        h55 h55Var8 = new h55(8, string, this.a.N0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, ey9Var);
                                                        h55Var8.d.setTag(sparseArray2);
                                                        arrayList.add(h55Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!o99.j(this.a.z0) && !booleanValue3 && booleanValue2) {
                                                            h55 h55Var9 = new h55(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cd0), this.a.N0);
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
                                                            h55Var9.d.setTag(sparseArray3);
                                                            arrayList.add(h55Var9);
                                                        } else if ((r79.C(this.a.z0.y1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            h55 h55Var10 = new h55(5, this.a.getString(R.string.report_text), this.a.N0);
                                                            h55Var10.d.setTag(str);
                                                            arrayList.add(h55Var10);
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
                                                                    h55 h55Var11 = new h55(6, this.a.getString(R.string.obfuscated_res_0x7f0f053f), this.a.N0);
                                                                    h55Var11.d.setTag(sparseArray4);
                                                                    h55Var2 = h55Var11;
                                                                    h55Var = new h55(7, this.a.getString(R.string.obfuscated_res_0x7f0f031f), this.a.N0);
                                                                    h55Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            h55Var2 = null;
                                                            h55Var = new h55(7, this.a.getString(R.string.obfuscated_res_0x7f0f031f), this.a.N0);
                                                            h55Var.d.setTag(sparseArray4);
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
                                                            if (this.a.z0.y1().V() == 1002 && !booleanValue) {
                                                                h55Var3 = new h55(6, this.a.getString(R.string.report_text), this.a.N0);
                                                            } else {
                                                                h55Var3 = new h55(6, this.a.getString(R.string.obfuscated_res_0x7f0f053f), this.a.N0);
                                                            }
                                                            h55Var3.d.setTag(sparseArray5);
                                                            h55Var2 = h55Var3;
                                                            h55Var = null;
                                                        } else {
                                                            h55Var = null;
                                                            h55Var2 = null;
                                                        }
                                                        if (h55Var2 != null) {
                                                            arrayList.add(h55Var2);
                                                        }
                                                        if (h55Var != null) {
                                                            arrayList.add(h55Var);
                                                        }
                                                    }
                                                    this.a.N0.l(arrayList);
                                                    this.a.M0 = new j55(this.a.getPageContext(), this.a.N0);
                                                    this.a.M0.l();
                                                    return;
                                                } else if (view2 == this.a.H0.V0()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, tg.g(this.a.z0.y1().l(), 0L), tg.g(this.a.z0.R1(), 0L), tg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.z0.y1().N().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().I()) {
                                                    if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().B()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.z0.R1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.H0.k.f();
                                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f09085c && view2.getId() != R.id.obfuscated_res_0x7f090b4c) {
                                                        int id3 = view2.getId();
                                                        if (id3 == R.id.pb_u9_text_view) {
                                                            if (!this.a.checkUpIsLogin() || (p45Var = (p45) view2.getTag()) == null || StringUtils.isNull(p45Var.s1())) {
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{p45Var.s1()});
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091e30 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                ey9 ey9Var2 = (ey9) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.z0.b));
                                                                }
                                                                if (this.a.N0 == null) {
                                                                    PbFragment pbFragment2 = this.a;
                                                                    pbFragment2.N0 = new l55(pbFragment2.getContext());
                                                                    this.a.N0.q(this.a.g2);
                                                                }
                                                                ArrayList arrayList2 = new ArrayList();
                                                                boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                if (ey9Var2 != null) {
                                                                    if (ey9Var2.a0() != null && ey9Var2.a0().toString().length() > 0) {
                                                                        h55 h55Var12 = new h55(3, this.a.getString(R.string.obfuscated_res_0x7f0f04db), this.a.N0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, ey9Var2);
                                                                        h55Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(h55Var12);
                                                                    }
                                                                    this.a.B2 = ey9Var2;
                                                                }
                                                                if (this.a.z0.y1().q()) {
                                                                    String u = this.a.z0.y1().u();
                                                                    if (ey9Var2 != null && !ui.isEmpty(u) && u.equals(ey9Var2.O())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            h55Var4 = new h55(4, this.a.getString(R.string.remove_mark), this.a.N0);
                                                                        } else {
                                                                            h55Var4 = new h55(4, this.a.getString(R.string.obfuscated_res_0x7f0f0c27), this.a.N0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.B2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        h55Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(h55Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!o99.j(this.a.z0) && !booleanValue9 && booleanValue8) {
                                                                                h55 h55Var13 = new h55(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cd0), this.a.N0);
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
                                                                                h55Var4.d.setTag(sparseArray9);
                                                                                arrayList2.add(h55Var13);
                                                                            } else if (r79.C(this.a.z0.y1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                h55 h55Var14 = new h55(5, this.a.getString(R.string.report_text), this.a.N0);
                                                                                h55Var14.d.setTag(str2);
                                                                                arrayList2.add(h55Var14);
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
                                                                                        h55 h55Var15 = new h55(6, this.a.getString(R.string.obfuscated_res_0x7f0f053f), this.a.N0);
                                                                                        h55Var15.d.setTag(sparseArray10);
                                                                                        h55Var6 = h55Var15;
                                                                                        h55Var5 = new h55(7, this.a.getString(R.string.obfuscated_res_0x7f0f031f), this.a.N0);
                                                                                        h55Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                h55Var6 = null;
                                                                                h55Var5 = new h55(7, this.a.getString(R.string.obfuscated_res_0x7f0f031f), this.a.N0);
                                                                                h55Var5.d.setTag(sparseArray10);
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
                                                                                if (this.a.z0.y1().V() == 1002 && !booleanValue7) {
                                                                                    h55Var7 = new h55(6, this.a.getString(R.string.report_text), this.a.N0);
                                                                                } else {
                                                                                    h55Var7 = new h55(6, this.a.getString(R.string.obfuscated_res_0x7f0f053f), this.a.N0);
                                                                                }
                                                                                h55Var7.d.setTag(sparseArray11);
                                                                                h55Var6 = h55Var7;
                                                                                h55Var5 = null;
                                                                            } else {
                                                                                h55Var5 = null;
                                                                                h55Var6 = null;
                                                                            }
                                                                            if (h55Var6 != null) {
                                                                                arrayList2.add(h55Var6);
                                                                            }
                                                                            if (h55Var5 != null) {
                                                                                arrayList2.add(h55Var5);
                                                                            }
                                                                        }
                                                                        this.a.N0.l(arrayList2);
                                                                        this.a.M0 = new j55(this.a.getPageContext(), this.a.N0);
                                                                        this.a.M0.l();
                                                                        return;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                }
                                                                SparseArray sparseArray82 = new SparseArray();
                                                                sparseArray82.put(R.id.tag_clip_board, this.a.B2);
                                                                sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                h55Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(h55Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.N0.l(arrayList2);
                                                                this.a.M0 = new j55(this.a.getPageContext(), this.a.N0);
                                                                this.a.M0.l();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.z0.y1() == null || this.a.z0.y1().N() == null || this.a.z0.y1().N().getActUrl() == null) {
                                                                return;
                                                            }
                                                            qx4.s(this.a.getActivity(), this.a.z0.y1().N().getActUrl());
                                                            if (this.a.z0.y1().N().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.z0.y1().N().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string2 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.z0.y1().l()).param("tid", this.a.z0.y1().P()).param("lotterytail", StringUtils.string(string2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.z0.y1().P().equals(string2)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string2, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.H0.B3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091a46 || id3 == R.id.obfuscated_res_0x7f091a10) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string3 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String s = l95.m().s("tail_link", "");
                                                                String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(s)) {
                                                                    TiebaStatic.log("c10056");
                                                                    qx4.x(view2.getContext(), string3, UtilHelper.urlAddParam(s, "page_from=1&tailSkinId=" + string4), true, true, true);
                                                                }
                                                                this.a.H0.U2();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string4));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                qx4.s(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.t5() != 1 || this.a.z0 == null || this.a.z0.y1() == null) {
                                                                    return;
                                                                }
                                                                ya9.u("c10397", this.a.z0.y1().l(), this.a.z0.y1().P(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string5 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                qx4.s(this.a.getActivity(), string5);
                                                                if (this.a.t5() != 1 || this.a.z0 == null || this.a.z0.y1() == null) {
                                                                    return;
                                                                }
                                                                ya9.u("c10507", this.a.z0.y1().l(), this.a.z0.y1().P(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09168b) {
                                                            this.a.h6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09168a) {
                                                            this.a.f6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f092687) {
                                                            if (this.a.o1 >= 0) {
                                                                if (this.a.z0 != null) {
                                                                    this.a.z0.R2();
                                                                }
                                                                if (this.a.z0 == null || this.a.H0.I0() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    i4 = 0;
                                                                    this.a.H0.I0().n0(this.a.z0.y1(), false);
                                                                }
                                                                this.a.o1 = i4;
                                                                if (this.a.z0 != null) {
                                                                    if (this.a.H0.a1() != null) {
                                                                        this.a.H0.a1().setSelection(this.a.z0.r1());
                                                                    }
                                                                    this.a.z0.V2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (r79.c(this.a.getPageContext(), 11009)) {
                                                                r79.w(this.a.getContext(), 8, this.a.t5(), this.a.z0);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0918a7) {
                                                            SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                            if (sparseArray12 == null) {
                                                                return;
                                                            }
                                                            this.a.i7(sparseArray12);
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091a05) {
                                                            if (this.a.H0.a1() == null || this.a.z0 == null || this.a.z0.y1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.H0.a1().getFirstVisiblePosition();
                                                            View childAt = this.a.H0.a1().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean w0 = this.a.z0.y1().w0();
                                                            boolean Z1 = this.a.H0.Z1();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            r79.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.z0.y1());
                                                            if ((this.a.z0.y1().N() != null && this.a.z0.y1().N().getReply_num() <= 0) || (Z1 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.w6();
                                                                if (this.a.z0.y1().N().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.y1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int j = (int) (vi.j(this.a.getContext()) * 0.6d);
                                                                if (w0) {
                                                                    if (this.a.H0.g1 != null) {
                                                                        if (this.a.H0.g1.a != null && this.a.H0.g1.a.getView() != null) {
                                                                            if (this.a.H0.g1.a.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                } else {
                                                                    if (this.a.H0.i1() != null) {
                                                                        z2 = this.a.H0.i1().getVisibility() == 0;
                                                                        if (!z2 && this.a.H0.g1 != null && this.a.H0.g1.a != null && this.a.H0.g1.a.getView() != null && this.a.H0.g1.a.getView().getParent() != null && this.a.H0.k != null && this.a.H0.k.a != null) {
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                }
                                                                if (!z2 && !Z1) {
                                                                    if (this.a.a0 <= 0) {
                                                                        int d = t89.d(this.a.getListView());
                                                                        if (t89.e(this.a.getListView()) != -1) {
                                                                            d--;
                                                                        }
                                                                        int g = vi.g(this.a.getContext(), R.dimen.tbds100);
                                                                        if (d < 0) {
                                                                            d = (ListUtils.getCount(this.a.H0.a1().getData()) - 1) + this.a.H0.a1().getHeaderViewsCount();
                                                                            i3 = 0;
                                                                        } else {
                                                                            i3 = g;
                                                                        }
                                                                        if (this.a.H0.k != null && this.a.H0.k.a != null) {
                                                                            i3 += this.a.H0.k.a.getFixedNavHeight() - 10;
                                                                        }
                                                                        if (this.a.H0.g1 == null || this.a.H0.g1.a == null || this.a.H0.g1.a.getView() == null || this.a.H0.g1.a.getView().getParent() == null) {
                                                                            this.a.H0.a1().setSelectionFromTop(d, i3 + j);
                                                                            this.a.H0.a1().smoothScrollBy(j, 500);
                                                                        } else {
                                                                            this.a.H0.a1().D(d, i3, 200);
                                                                        }
                                                                    } else if (this.a.H0.a1().getChildAt(this.a.a0) == null) {
                                                                        this.a.H0.a1().setSelectionFromTop(this.a.a0, this.a.b0 + j);
                                                                        this.a.H0.a1().smoothScrollBy(j, 500);
                                                                    } else {
                                                                        this.a.H0.a1().D(this.a.a0, this.a.b0, 200);
                                                                    }
                                                                } else {
                                                                    this.a.a0 = firstVisiblePosition;
                                                                    this.a.b0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                        int i9 = -j;
                                                                        this.a.H0.a1().setSelectionFromTop(0, i9);
                                                                        this.a.H0.a1().smoothScrollBy(i9, 500);
                                                                    } else {
                                                                        this.a.H0.a1().D(0, 0, 500);
                                                                    }
                                                                }
                                                            }
                                                            if (this.a.z0.y1().N() == null || this.a.z0.y1().N().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.y1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091a6d) {
                                                            if (this.a.z0 == null || this.a.z0.y1() == null || this.a.z0.y1().k() == null || ui.isEmpty(this.a.z0.y1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.z0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.z0.X0()) || this.a.z0.O0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.z0.O0().b;
                                                            } else {
                                                                name = this.a.z0.y1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String X02 = this.a.z0.X0();
                                                            if (!this.a.z0.d1() || X02 == null || !X02.equals(name)) {
                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.z0.y1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                createNormalCfg2.setCallFrom(2);
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.z0.R1());
                                                            statisticItem6.param("fid", this.a.z0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.z0.y1().N() != null) {
                                                                statisticItem6.param("nid", this.a.z0.y1().N().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.z0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.z0.R1());
                                                                statisticItem7.param("fid", this.a.z0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091a94) {
                                                                if (this.a.z0 == null || this.a.z0.y1() == null) {
                                                                    return;
                                                                }
                                                                j39 y13 = this.a.z0.y1();
                                                                if (this.a.E0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.E0 = new d49(pbFragment3.getPageContext());
                                                                }
                                                                long g2 = tg.g(y13.P(), 0L);
                                                                long g3 = tg.g(y13.l(), 0L);
                                                                ya9.w("c13446", g3);
                                                                PbFragment pbFragment4 = this.a;
                                                                pbFragment4.registerListener(pbFragment4.n2);
                                                                this.a.E0.a(g2, g3);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091aae) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!l86.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        qx4.s(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.z0.R1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090fed) {
                                                                if (view2.getTag() instanceof ThreadData) {
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg3.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090fea) {
                                                                if ((view2.getTag() instanceof ThreadData) && this.a.checkUpIsLogin()) {
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.Q != null) {
                                                                        this.a.Q.m0(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 != R.id.obfuscated_res_0x7f091a1e && id3 != R.id.obfuscated_res_0x7f091a7a) {
                                                                if (id3 == R.id.obfuscated_res_0x7f0926a5) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        ya9.s(5);
                                                                    }
                                                                    this.a.L6(false);
                                                                    this.a.j7((ey9) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.s0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.z0.R1());
                                                                statisticItem8.param("fid", this.a.z0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    ya9.s(6);
                                                                }
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.b = false;
                                                                pbFragment5.h5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.z0.x1() != 3 || !this.a.z0() || this.a.z0.y1() == null || !ListUtils.isEmpty(this.a.z0.y1().o())) {
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
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof ey9)) {
                                                            return;
                                                        }
                                                        ey9 ey9Var3 = (ey9) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (ey9Var3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09085d);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f09085e);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b4c);
                                                        if (ey9Var3.x0()) {
                                                            ey9Var3.Y0(false);
                                                            r99.e(ey9Var3);
                                                        } else if (this.a.Q() != null ? r99.c(this.a.Q().y1(), ey9Var3) : false) {
                                                            ey9Var3.Y0(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, ey9Var3.x0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, ey9Var3.x0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, ey9Var3.x0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, ey9Var3.x0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.H0.k.g();
                                                    this.a.H0.Z3(this.a.E2);
                                                    return;
                                                }
                                            } else if (this.a.z0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091a80) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.z0.R1());
                                                    statisticItem10.param("fid", this.a.z0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091c5d) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.f1148T = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a80 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.f1148T = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof ey9) {
                                                        ey9 ey9Var4 = (ey9) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a80 && (statisticItem = ey9Var4.e0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091c5d || view2.getId() == R.id.obfuscated_res_0x7f091a16) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.z0.S1()).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ey9Var4.O()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.z0 == null || this.a.z0.y1() == null || this.a.L5().j1() == null || ey9Var4.p() == null || ey9Var4.D() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.L5().k1() != null) {
                                                            this.a.L5().k1().g();
                                                        }
                                                        b49 b49Var = new b49();
                                                        b49Var.v(this.a.z0.y1().k());
                                                        b49Var.z(this.a.z0.y1().N());
                                                        b49Var.x(ey9Var4);
                                                        this.a.L5().j1().q0(b49Var);
                                                        this.a.L5().j1().setPostId(ey9Var4.O());
                                                        this.a.i6(view2, ey9Var4.p().getUserId(), "", ey9Var4);
                                                        if (this.a.W0 != null) {
                                                            this.a.H0.c3(this.a.W0.z());
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
                                            statisticItem11.param("tid", this.a.z0.R1());
                                            statisticItem11.param("fid", this.a.z0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091a82 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof ey9) {
                                                        ey9 ey9Var5 = (ey9) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = ey9Var5.e0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.z0 == null || this.a.z0.y1() == null) {
                                                            return;
                                                        }
                                                        String R1 = this.a.z0.R1();
                                                        String O = ey9Var5.O();
                                                        int V = this.a.z0.y1() != null ? this.a.z0.y1().V() : 0;
                                                        AbsPbActivity.e x6 = this.a.x6(O);
                                                        if (x6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(R1, O, "pb", true, false, null, false, null, V, ey9Var5.h0(), this.a.z0.y1().c(), false, ey9Var5.p().getIconInfo(), 5).addBigImageData(x6.a, x6.b, x6.g, x6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.z0.x1());
                                                        addBigImageData.setFromFrsForumId(this.a.z0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.z0.W1());
                                                        addBigImageData.setKeyFromForumId(this.a.z0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.z0.d0(), this.a.z0.Z(), this.a.z0.a0(), this.a.z0.Y(), this.a.z0.e0());
                                                        addBigImageData.setBjhData(this.a.z0.Q0());
                                                        if (this.a.z0.y1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.z0.y1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.z0.y1().U() != null) {
                                                            addBigImageData.setIsManager(this.a.z0.y1().U().getIs_manager());
                                                        }
                                                        if (this.a.z0.y1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.z0.y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.z0.y1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.z0.y1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.z0.y1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.z0.y1().k().getUser_level());
                                                        }
                                                        if (this.a.H0 != null && this.a.z0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.z0.G.W().S || ey9Var5.S);
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
                                        if (view2.getId() == R.id.obfuscated_res_0x7f0918a7) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.z0.R1());
                                            statisticItem13.param("fid", this.a.z0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091a1c || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                ya9.r("c10517", this.a.z0.y1().l(), 3);
                                                return;
                                            } else if (this.a.z0 == null || this.a.z0.y1() == null) {
                                                return;
                                            } else {
                                                this.a.H0.v0();
                                                SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                ey9 ey9Var6 = (ey9) sparseArray17.get(R.id.tag_load_sub_data);
                                                ey9 ey9Var7 = (ey9) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                if (ey9Var6 == null || view4 == null) {
                                                    return;
                                                }
                                                if (ey9Var6.I() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem14 = ey9Var6.e0;
                                                if (statisticItem14 != null) {
                                                    StatisticItem copy3 = statisticItem14.copy();
                                                    copy3.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918a7) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a1c) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String R12 = this.a.z0.R1();
                                                String O2 = ey9Var6.O();
                                                String O3 = ey9Var7 != null ? ey9Var7.O() : "";
                                                int V2 = this.a.z0.y1() != null ? this.a.z0.y1().V() : 0;
                                                this.a.k7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091e30) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e x62 = this.a.x6(O2);
                                                    if (ey9Var6 == null || this.a.z0 == null || this.a.z0.y1() == null || x62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(R12, O2, "pb", true, false, null, false, O3, V2, ey9Var6.h0(), this.a.z0.y1().c(), false, ey9Var6.p().getIconInfo(), 5).addBigImageData(x62.a, x62.b, x62.g, x62.j);
                                                    if (!ui.isEmpty(O3)) {
                                                        addBigImageData2.setHighLightPostId(O3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.z0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.z0.d0(), this.a.z0.Z(), this.a.z0.a0(), this.a.z0.Y(), this.a.z0.e0());
                                                    addBigImageData2.setBjhData(this.a.z0.Q0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.z0.x1());
                                                    addBigImageData2.setFromFrsForumId(this.a.z0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.z0.W1());
                                                    if (this.a.H0 != null && this.a.z0.G != null && (W = this.a.z0.G.W()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(W.S || ey9Var6.S);
                                                    }
                                                    if (this.a.z0.y1() != null && this.a.z0.y1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.z0.y1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e x63 = this.a.x6(O2);
                                                if (this.a.z0 == null || this.a.z0.y1() == null || x63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(R12, O2, "pb", true, false, null, true, null, V2, ey9Var6.h0(), this.a.z0.y1().c(), false, ey9Var6.p().getIconInfo(), 5).addBigImageData(x63.a, x63.b, x63.g, x63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.z0.x1());
                                                addBigImageData3.setFromFrsForumId(this.a.z0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.z0.W1());
                                                addBigImageData3.setKeyFromForumId(this.a.z0.getForumId());
                                                addBigImageData3.setBjhData(this.a.z0.Q0());
                                                addBigImageData3.setTiebaPlusData(this.a.z0.d0(), this.a.z0.Z(), this.a.z0.a0(), this.a.z0.Y(), this.a.z0.e0());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.S = view2;
                                        return;
                                    }
                                } else if (this.a.z0 == null || this.a.z0.y1() == null || this.a.z0.y1().N() == null) {
                                    return;
                                } else {
                                    this.a.H0.k.f();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.S5(pbFragment6.z0.y1().N().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.H0.v0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.z0.O1()));
                            } else {
                                this.a.k7();
                                this.a.H0.x3();
                                j55 j55Var = new j55(this.a.getPageContext());
                                if (this.a.z0.y1().f == null || this.a.z0.y1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.z0.y1().f.size()];
                                    for (int i10 = 0; i10 < this.a.z0.y1().f.size(); i10++) {
                                        strArr[i10] = this.a.z0.y1().f.get(i10).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                j55Var.i(null, strArr, new a(this, j55Var, view2));
                                j55Var.l();
                            }
                        } else {
                            this.a.H0.v0();
                            if (this.a.Q().y1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.z0.w1() != null) {
                                this.a.H0.g4(this.a.z0.w1(), this.a.e2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.H0.k.f();
                    }
                } else {
                    this.a.H0.k.g();
                    if (this.a.z0 != null) {
                        this.a.s1.f(this.a.z0.R1());
                    }
                    if (this.a.z0 != null && this.a.z0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.Q() == null || this.a.Q().y1() == null) {
                            return;
                        }
                        this.a.s1.d(3, 3, this.a.Q().y1().P());
                        return;
                    }
                    this.a.s1.b();
                    int i11 = (TbSingleton.getInstance().mCanCallFans || this.a.Q() == null || this.a.Q().y1() == null || this.a.Q().y1().P() == null || !this.a.Q().y1().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.Q() == null || this.a.Q().y1() == null) {
                        return;
                    }
                    this.a.s1.d(3, i11, this.a.Q().y1().P());
                }
            } else if (!this.a.s0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.z0.R1());
                statisticItem15.param("fid", this.a.z0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    ya9.s(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (!(obj instanceof ey9)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    ey9 ey9Var8 = (ey9) obj;
                    if (this.a.z0 != null && this.a.z0.y1() != null && this.a.L5().j1() != null && ey9Var8.p() != null && ey9Var8.D() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.L5().k1() != null) {
                            this.a.L5().k1().g();
                        }
                        b49 b49Var2 = new b49();
                        b49Var2.v(this.a.z0.y1().k());
                        b49Var2.z(this.a.z0.y1().N());
                        b49Var2.x(ey9Var8);
                        this.a.L5().j1().q0(b49Var2);
                        this.a.L5().j1().setPostId(ey9Var8.O());
                        this.a.i6(view2, ey9Var8.p().getUserId(), "", ey9Var8);
                        TiebaStatic.log("c11743");
                        ya9.b(this.a.z0.y1(), ey9Var8, ey9Var8.d0, 8, 1);
                        if (this.a.W0 != null) {
                            this.a.H0.c3(this.a.W0.z());
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

        /* loaded from: classes7.dex */
        public class a implements l55.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j55 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ j1 c;

            public a(j1 j1Var, j55 j55Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, j55Var, view2};
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
                this.a = j55Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.z0.P1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.l55.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void M0(l55 l55Var, int i, View view2) {
                boolean q3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, l55Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.z0.P1() != 1 || i != 1) {
                        if (this.c.a.z0.P1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.z0.P1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091a90) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.z0.y1().f != null && this.c.a.z0.y1().f.size() > i) {
                            i = this.c.a.z0.y1().f.get(i).sort_type.intValue();
                        }
                        q3 = this.c.a.z0.q3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.z0.O1()));
                        if (q3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.H0.m3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091a90) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.z0.y1().f != null) {
                        i = this.c.a.z0.y1().f.get(i).sort_type.intValue();
                    }
                    q3 = this.c.a.z0.q3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.z0.O1()));
                    if (q3) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.H0 != null && this.a != null) {
                    this.b.a.H0.G2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a55.e {
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

            @Override // com.baidu.tieba.a55.e
            public void onClick(a55 a55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                    a55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements a55.e {
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

            @Override // com.baidu.tieba.a55.e
            public void onClick(a55 a55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                    a55Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, xd5 xd5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, xd5Var, writeData, antiData}) == null) {
                if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.z0.y1() != null) {
                        statisticItem.param("fid", this.a.z0.y1().l());
                    }
                    statisticItem.param("tid", this.a.z0.R1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (ui.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.k7();
                this.a.H0.v3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.F0 != null) {
                    this.a.F0.C0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    wg.a().postDelayed(this.a.V1, 300000L);
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
                        if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        a55 a55Var = new a55(this.a.getActivity());
                        if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                            a55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            a55Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new b(this));
                        a55Var.setPositiveButton(R.string.open_now, new c(this));
                        a55Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (xd5Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.S6(i, antiData, str);
                        return;
                    }
                }
                this.a.d7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.T6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.H0.Q1(this.a.z0.y1());
                    }
                } else if (this.a.z0.b1()) {
                    j39 y1 = this.a.z0.y1();
                    if (y1 != null && y1.N() != null && y1.N().getAuthor() != null && (userId = y1.N().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.z0.n3()) {
                        this.a.H0.x3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.z0.n3()) {
                    this.a.H0.x3();
                }
                if (this.a.z0.f1()) {
                    ya9.p("c10369", this.a.z0.R1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    wg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.z0 != null) {
                    Context context = this.a.getContext();
                    j39 y12 = this.a.z0.y1();
                    String forumId = this.a.z0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    r79.a(context, y12, forumId, z2, this.a.z0.D1(), this.a.z0.G1(), this.a.z0.F1(), this.a.z0.E1(), this.a.z0.K1(), this.a.z0.L1());
                }
                if (writeData != null) {
                    gb5.b(writeData.getContent(), "1");
                }
                if (this.a.b6()) {
                    this.a.n7();
                }
                this.a.b7();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.H0 != null && this.a != null) {
                    this.b.a.H0.G2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a55.e {
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

            @Override // com.baidu.tieba.a55.e
            public void onClick(a55 a55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                    a55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements a55.e {
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

            @Override // com.baidu.tieba.a55.e
            public void onClick(a55 a55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                    a55Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, xd5 xd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, xd5Var, writeData, antiData}) == null) {
                if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.z0 != null && this.a.z0.y1() != null) {
                        statisticItem.param("fid", this.a.z0.y1().l());
                    }
                    if (this.a.z0 != null) {
                        statisticItem.param("tid", this.a.z0.R1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.C5()) {
                        this.a.L6(false);
                        p29.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1434));
                    }
                    v79 v79Var = this.a.L0;
                    if (v79Var != null) {
                        v79Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        vf5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        gb5.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        wg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.b6()) {
                        this.a.n7();
                    }
                    this.a.b7();
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
                    if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    a55 a55Var = new a55(this.a.getActivity());
                    if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                        a55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        a55Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new b(this));
                    a55Var.setPositiveButton(R.string.open_now, new c(this));
                    a55Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.L0 != null) {
                        if (pbFragment.H0 != null && this.a.H0.k1() != null && this.a.H0.k1().f() != null && this.a.H0.k1().f().y()) {
                            this.a.H0.k1().f().w(postWriteCallBackData);
                        }
                        this.a.L0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements kw6.b {
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

        @Override // com.baidu.tieba.kw6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    o49.d();
                } else {
                    o49.c();
                }
            }
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
        public void a(w89 w89Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, w89Var) != null) || w89Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, w89Var.a()));
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
        public void onNavigationButtonClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) && a55Var != null) {
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements lg<LinearLayout> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
    public class b implements g69.b {
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

        @Override // com.baidu.tieba.g69.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1764);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.H0.t0(str);
                } else {
                    this.a.showToast(str);
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
                        this.a.t6();
                        return;
                    } else {
                        this.a.F6();
                        return;
                    }
                }
                this.a.r0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                this.a.U5();
                i35 w1 = this.a.z0.w1();
                int h1 = this.a.H0.h1();
                if (h1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fb2);
                } else if (w1 != null && h1 > w1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fb2);
                } else {
                    this.a.H0.v0();
                    this.a.k7();
                    this.a.H0.x3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.z0.k3(this.a.H0.h1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
                    }
                    a55Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 implements u95.g {
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

        @Override // com.baidu.tieba.u95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.z0.w2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H0.D0();
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
    public class c implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    a55Var.dismiss();
                    ((TbPageContext) this.a.e1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                a55Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.e1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.H0 != null) {
                this.a.H0.C3(list);
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
                String valueOf = String.valueOf(this.a.z0.y1().U().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.y1().k().getId(), this.a.z0.y1().k().getName(), this.a.z0.y1().N().getId(), valueOf, str, str3, str2, str4)));
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
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.z0.w2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H0.D0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c3 implements jw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.jw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.jw6.b
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

        @Override // com.baidu.tieba.jw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.H0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.B5()) {
                    this.b.H0.z1();
                    this.b.H0.V2();
                }
            }
        }

        @Override // com.baidu.tieba.jw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.H0 != null && this.b.e != null) {
                this.b.H0.a4();
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
    public class d implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.O1 != null && str != null) {
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.O1 == null) {
                return;
            }
            j39 y1 = this.a.z0.y1();
            if (y1.N().getPraise().getIsLike() == 1) {
                this.a.s7(0);
            } else {
                this.a.s7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, y1.N()));
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements l55.f {
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

        @Override // com.baidu.tieba.l55.f
        public void M0(l55 l55Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l55Var, i, view2) == null) {
                if (this.a.M0 != null) {
                    this.a.M0.dismiss();
                }
                this.a.p7(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                                                if (this.a.m1 != null) {
                                                    wl5.a aVar = new wl5.a();
                                                    aVar.a = this.a.k1;
                                                    String str = "";
                                                    if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.m1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.Y4();
                                                }
                                                this.a.j1 = null;
                                                this.a.k1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                                                if (this.a.X0 == null) {
                                                    this.a.X0 = new PermissionJudgePolicy();
                                                }
                                                this.a.X0.clearRequestPermissionList();
                                                this.a.X0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.X0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.i1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.i1 = new x79(pbFragment.getPageContext());
                                                }
                                                this.a.i1.b(this.a.k1, this.a.j1.n());
                                                this.a.j1 = null;
                                                this.a.k1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            ey9 ey9Var = this.a.B2;
                                            if (ey9Var != null) {
                                                ey9Var.J0();
                                                this.a.B2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.m6(view2);
                                            if (this.a.z0.y1().N() != null && this.a.z0.y1().N().getAuthor() != null && this.a.z0.y1().N().getAuthor().getUserId() != null && this.a.B0 != null) {
                                                int v = r79.v(this.a.z0.y1());
                                                ThreadData N = this.a.z0.y1().N();
                                                if (N.isBJHArticleThreadType()) {
                                                    i2 = 2;
                                                } else if (N.isBJHVideoThreadType()) {
                                                    i2 = 3;
                                                } else if (!N.isBJHNormalThreadType()) {
                                                    if (N.isBJHVideoDynamicThreadType()) {
                                                        i2 = 5;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.z0.b).param("obj_locate", 2).param("obj_id", this.a.z0.y1().N().getAuthor().getUserId()).param("obj_type", !this.a.B0.e()).param("obj_source", v).param("obj_param1", i2));
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
                                                this.a.S5((String) tag);
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
                                                boolean G = this.a.V().G(TbadkCoreApplication.getCurrentAccount());
                                                if (G) {
                                                    if (booleanValue2) {
                                                        this.a.H0.A2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                                        return;
                                                    } else {
                                                        this.a.U6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.H0.y2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.U6(sparseArray3, intValue, booleanValue);
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
                                                this.a.H0.D2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.H0.y2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            ey9 ey9Var2 = (ey9) sparseArray.get(R.id.tag_clip_board);
                                            if (ey9Var2.n() == null) {
                                                return;
                                            }
                                            this.a.f5(ey9Var2.n());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.z0 != null && this.a.z0.y1() != null) {
                                                this.a.a.U1(w5a.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.z0 != null && this.a.z0.y1() != null) {
                                    this.a.H0.x4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.z6(view3);
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
                            this.a.z6(view4);
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
                    this.a.z6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.L6(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.z6(view6);
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
                if (this.a.w2 && this.a.B5()) {
                    this.a.f6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.H0 != null) {
                    this.a.H0.W2();
                }
                if (!this.a.f0 && this.a.H0 != null && this.a.H0.k0() && this.a.z0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.z0.R1());
                    statisticItem.param("fid", this.a.z0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.z0.d1()) {
                        i = 4;
                    } else if (this.a.z0.e1()) {
                        i = 3;
                    } else if (this.a.z0.g1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.z0.u2(false)) {
                    this.a.H0.y3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.z0.y1() != null) {
                    this.a.H0.Q2();
                }
                this.a.w2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d3 implements z69.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.z69.b
        public void onSuccess(List<ey9> list) {
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

        @Override // com.baidu.tieba.z69.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.H0.l4(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.H0.h4(!this.a.N);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                if (a55Var != null) {
                    a55Var.dismiss();
                }
                this.d.n5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z0 != null) {
                this.a.z0.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                this.b.H0.S3();
                MessageManager.getInstance().sendMessage(this.a);
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements z89.h {
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

        @Override // com.baidu.tieba.z89.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.N6(z);
                if (this.a.H0.X0() != null && z) {
                    this.a.H0.h4(false);
                }
                this.a.H0.p2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<s79> a;
        public WeakReference<PbFragment> b;

        public f3(s79 s79Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s79Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(s79Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                s79 s79Var = this.a.get();
                if (s79Var != null) {
                    s79Var.y1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.e7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        eu7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements l55.f {
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

        @Override // com.baidu.tieba.l55.f
        public void M0(l55 l55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l55Var, i, view2) == null) {
                if (this.e.M0 != null) {
                    this.e.M0.dismiss();
                }
                if (i == 0) {
                    this.e.H0.y2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.g1);
                    this.e.g7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
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
                this.a.H0.v0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.z0 != null && !this.a.z0.isLoading) {
                    this.a.k7();
                    this.a.H0.x3();
                    z = true;
                    if (this.a.z0.y1() != null && this.a.z0.y1().f != null && this.a.z0.y1().f.size() > i) {
                        int intValue = this.a.z0.y1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.z0.S1()).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.z0.q3(intValue)) {
                            this.a.h = true;
                            this.a.H0.m3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements a55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ a55 c;
        public final /* synthetic */ PbFragment d;

        public g2(PbFragment pbFragment, MarkData markData, MarkData markData2, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, a55Var};
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
            this.c = a55Var;
        }

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                a55Var.dismiss();
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
                this.d.l7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends gx5<ShareItem> {
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
        @Override // com.baidu.tieba.gx5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel Q = this.b.Q();
                if (Q != null) {
                    Q.Y2(this.a);
                }
                return s99.c(this.b.t5(), 2, Q);
            }
            return (ShareItem) invokeV.objValue;
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
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null) {
                if (updateAttentionMessage.getData().i != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.R2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().p() != null && this.a.u5().p().getGodUserData() != null) {
                        this.a.u5().p().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.z0 != null && this.a.z0.y1() != null && this.a.z0.y1().N() != null && this.a.z0.y1().N().getAuthor() != null) {
                        this.a.z0.y1().N().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements sj5 {
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

        @Override // com.baidu.tieba.sj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                v79 v79Var = this.a.L0;
                if (v79Var != null && v79Var.g() != null && this.a.L0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.L0.g().c());
                    if (this.a.H0 != null && this.a.H0.k1() != null && this.a.H0.k1().f() != null && this.a.H0.k1().f().y()) {
                        this.a.H0.k1().f().w(this.a.L0.h());
                    }
                    this.a.L0.b(true);
                    return true;
                }
                return !this.a.e5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements kw5<ShareItem> {
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
        @Override // com.baidu.tieba.kw5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.r(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 extends hp5<TipEvent> {
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
        @Override // com.baidu.tieba.ap5
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

    /* loaded from: classes7.dex */
    public class i2 implements a55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ a55 b;
        public final /* synthetic */ PbFragment c;

        public i2(PbFragment pbFragment, MarkData markData, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, a55Var};
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
            this.b = a55Var;
        }

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                a55Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.l7();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.z0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.W0 != null) {
                    this.a.H0.c3(this.a.W0.z());
                }
                this.a.H0.U2();
                this.a.H0.v0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 extends hp5<TopToastEvent> {
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
        @Override // com.baidu.tieba.ap5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.H0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.H0.s1());
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
        public final /* synthetic */ a55 b;
        public final /* synthetic */ PbFragment c;

        public j2(PbFragment pbFragment, MarkData markData, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, a55Var};
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
            this.b = a55Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.H0 != null && this.c.H0.s1() != null) {
                    this.c.H0.s1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.l7();
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
            this.a.z0.s3((UserPendantData) customResponsedMessage.getData());
            if (this.a.H0 != null && this.a.z0 != null) {
                this.a.H0.O2(this.a.z0.y1(), this.a.z0.Q1(), this.a.z0.I1(), this.a.H0.o1());
            }
            if (this.a.H0 != null && this.a.H0.I0() != null) {
                this.a.H0.I0().f0();
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
            s79 s79Var = this.b.H0;
            s79Var.A3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.z0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.z0.b)) {
                return;
            }
            this.a.d7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements lg<ImageView> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
                    if (n05.c().g()) {
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
        @Override // com.baidu.tieba.lg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = n05.c().g();
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
                if (this.a.H0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.H0.c4();
                } else {
                    this.a.H0.A1();
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
                    if (this.a.W0 != null) {
                        this.a.W0.H(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.H0 != null && this.a.H0.k1() != null && this.a.H0.k1().f() != null) {
                    this.a.H0.k1().f().G();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements tj5 {
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

        @Override // com.baidu.tieba.tj5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements lg<GifView> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
                if (n05.c().g()) {
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
        @Override // com.baidu.tieba.lg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = n05.c().g();
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
            if (this.a.W0 != null) {
                this.a.H0.c3(this.a.W0.z());
            }
            this.a.H0.K3(false);
        }
    }

    /* loaded from: classes7.dex */
    public class m0 extends j9 {
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

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements lg<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
                r29 r29Var = (r29) customResponsedMessage.getData();
                int type = r29Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (r29Var.a() == null) {
                                this.a.B6(false, null);
                                return;
                            } else {
                                this.a.B6(true, (MarkData) r29Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.p5((ForumManageModel.b) r29Var.a(), false);
                    return;
                }
                this.a.C6((b49) r29Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements n29.d {
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

        @Override // com.baidu.tieba.n29.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements lg<View> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.H0 != null && this.a.H0.I0() != null) {
                this.a.H0.I0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements p49.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.p49.a
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

        @Override // com.baidu.tieba.p49.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091e4e) {
                        if (this.a.G6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015b) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof ey9)) {
                                return false;
                            }
                            ey9 ey9Var = (ey9) obj;
                            if (ey9Var.getType() != ey9.V0 && !TextUtils.isEmpty(ey9Var.s()) && n05.c().g()) {
                                return this.a.o6(ey9Var);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a1b) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.i7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.H0.V1() && view2.getId() == R.id.obfuscated_res_0x7f091a3a) {
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
                        this.a.i7(sparseArray);
                    }
                }
                if (this.a.W0 != null) {
                    this.a.H0.c3(this.a.W0.z());
                }
                this.a.H0.U2();
                this.a.H0.v0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.p49.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.o5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o1 extends jb {
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

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView q1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        vi.P(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.H0 != null && (q1 = this.a.H0.q1()) != null && this.a.H0.a1() != null) {
                            this.a.H0.a1().removeHeaderView(q1);
                            return;
                        }
                        return;
                    }
                    vi.Q(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements lg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof p16.a)) {
                p16.a aVar = (p16.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.P5(aVar.b);
                }
                p16.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (message.what == 2 && this.a.z0 != null && this.a.z0.j1()) {
                    this.a.j6();
                }
                return false;
            }
            return invokeL.booleanValue;
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
        public void b(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j39Var) == null) {
                this.a.H0.Q1(j39Var);
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
            ns5 ns5Var = new ns5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            ns5Var.c();
            if (z2) {
                j3 = j4;
                ns5Var.B = j3;
                ns5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.z0 != null && this.a.z0.y1() != null && this.a.z0.y1().N() != null) {
                int threadType = this.a.z0.y1().N().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        js5 js5Var = new js5();
                        js5Var.F = 1;
                        js5Var.a(1005);
                        js5Var.D = j3;
                        js5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        ns5 ns5Var2 = new ns5();
                        ns5Var2.a(1000);
                        ns5Var2.D = j3;
                        ns5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, j39 j39Var, String str, int i4) {
            boolean z2;
            ai5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), j39Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09079d));
                }
                if (z && j39Var != null && j39Var.X() == null && ListUtils.getCount(j39Var.F()) < 1) {
                    this.a.z0.k3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.H0 != null) {
                        this.a.H0.d4();
                        return;
                    }
                    return;
                }
                if (this.a.g0) {
                    if (this.a.Q() != null) {
                        this.a.Q().G0();
                    }
                } else {
                    this.a.g0 = true;
                }
                this.a.g = true;
                if (this.a.H0 == null) {
                    return;
                }
                this.a.H0.w3();
                if (j39Var == null || !j39Var.r0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.H0.s1());
                }
                this.a.H0.A1();
                int i5 = 0;
                if (this.a.J) {
                    this.a.H0.u1();
                } else if (!this.a.H0.U1()) {
                    this.a.H0.K3(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && j39Var != null) {
                    this.a.P0 = true;
                }
                if (j39Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.H0.s1());
                    this.a.H0.G3();
                }
                ArrayList<ey9> arrayList = null;
                String l1 = null;
                arrayList = null;
                if (z && j39Var != null) {
                    ThreadData N = j39Var.N();
                    if (N != null && N.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.O6(pbFragment3.V0);
                    }
                    this.a.H0.k1().r(j39Var);
                    this.a.H0.R3();
                    if (N != null && N.getCartoonThreadData() != null) {
                        this.a.r7(N.getCartoonThreadData());
                    }
                    if (this.a.W0 != null) {
                        this.a.H0.c3(this.a.W0.z());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(j39Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(j39Var.U().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(j39Var.U().getBimg_end_time());
                    if (j39Var.F() != null && j39Var.F().size() >= 1 && j39Var.F().get(0) != null) {
                        this.a.z0.W2(j39Var.F().get(0).O());
                    } else if (j39Var.X() != null) {
                        this.a.z0.W2(j39Var.X().O());
                    }
                    if (this.a.W0 != null) {
                        this.a.W0.I(j39Var.c());
                        this.a.W0.J(j39Var.k(), j39Var.U());
                        this.a.W0.l0(N);
                        this.a.W0.K(this.a.z0.a1(), this.a.z0.R1(), this.a.z0.W0());
                        if (N != null) {
                            this.a.W0.a0(N.isMutiForumThread());
                        }
                    }
                    if (this.a.B0 != null) {
                        this.a.B0.h(j39Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (j39Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (j39Var.i0()) {
                        this.a.q = true;
                    }
                    this.a.H0.d3(this.a.q);
                    if (this.a.u0.f.size() > 0) {
                        j39Var.Q0(this.a.u0.f);
                    }
                    this.a.H0.V3(j39Var, i2, i3, this.a.z0.Q1(), i4, this.a.z0.h1());
                    this.a.H0.k4(j39Var, this.a.z0.Q1());
                    this.a.H0.q4(this.a.z0.b1());
                    AntiData c = j39Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.W0 != null && this.a.W0.b() != null && (o = this.a.W0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.F1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.z0.y1().F()) && !this.a.z0.l2()) {
                        this.a.X = true;
                        this.a.a5(false);
                    }
                    if (!TextUtils.isEmpty(this.a.S0)) {
                        PbFragment pbFragment5 = this.a;
                        r79.G(pbFragment5, pbFragment5.z0.x1(), this.a.S0);
                        this.a.S0 = null;
                    } else if (!this.a.R0) {
                        if (!this.a.T0) {
                            if (!TextUtils.isEmpty(this.a.z0.o1())) {
                                t89.f(this.a.getListView(), this.a.z0.o1());
                                this.a.z0.s2();
                            } else {
                                this.a.H0.Q3();
                            }
                        } else {
                            this.a.T0 = false;
                            t89.j(this.a.getListView());
                        }
                    } else {
                        this.a.R0 = false;
                        r79.F(this.a);
                    }
                    this.a.z0.t2(j39Var.k(), this.a.L1);
                    this.a.z0.x2(this.a.N1);
                    if (this.a.Y0 != null && N != null && N.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.getAuthor());
                        this.a.Y0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.z0 != null && this.a.z0.h2()) {
                        l1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.H0 != null) {
                        l1 = this.a.H0.l1();
                    }
                    if (this.a.W0 != null && !StringUtils.isNull(l1)) {
                        this.a.W0.d0(TbSingleton.getInstance().getAdVertiComment(j39Var.p0(), j39Var.q0(), l1));
                    }
                } else if (str != null) {
                    if (!this.a.P0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.z0.O0() != null && !StringUtils.isNull(this.a.z0.O0().c)) {
                                    this.a.H0.s4(this.a.z0.O0());
                                } else {
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.showNetRefreshView(pbFragment6.H0.s1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    uq9.a("pb", false);
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.setNetRefreshViewEmotionMarginTop(vi.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c2));
                                }
                            } else {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.H0.s1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                uq9.a("pb", false);
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(vi.g(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c2));
                            }
                            this.a.H0.u1();
                            this.a.H0.t1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.z0.R1());
                            jSONObject.put("fid", this.a.z0.getForumId());
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
                        if (this.a.z0 != null && this.a.z0.y1() != null) {
                            arrayList = this.a.z0.y1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                            this.a.H0.Y2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.d6()) {
                                this.a.H0.Z2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0faf));
                            } else {
                                this.a.H0.Z2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb0));
                            }
                            this.a.H0.Q1(this.a.z0.y1());
                        }
                    } else {
                        this.a.H0.Y2("");
                    }
                    this.a.H0.C0();
                }
                if (j39Var != null && j39Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (j39Var != null) {
                        i5 = j39Var.f();
                    }
                    pbActivity.e2(i5, this.a.H0);
                }
                if (this.a.z0 != null && this.a.z0.y1() != null) {
                    this.a.z0.y1();
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
            vj5 vj5Var = new vj5();
            this.a.O6(vj5Var);
            PbFragment pbFragment = this.a;
            pbFragment.W0 = (wj5) vj5Var.a(pbFragment.getContext());
            this.a.W0.X(this.a.a.getPageContext());
            this.a.W0.g0(this.a.k2);
            this.a.W0.h0(this.a.Z0);
            wj5 wj5Var = this.a.W0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            wj5Var.B(pageContext, extras);
            this.a.W0.b().E(true);
            this.a.H0.X2(this.a.W0.b());
            if (!this.a.z0.l1()) {
                this.a.W0.q(this.a.z0.R1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.W0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.z0.h2()) {
                this.a.W0.d0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.H0 != null) {
                this.a.W0.d0(this.a.H0.l1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements lg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
            this.a.h7();
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements c55.c {
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

        @Override // com.baidu.tieba.c55.c
        public void a(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.O0 = pbFragment.O0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.O0);
                    new v59(this.a.z0.R1(), this.a.O0, "1").start();
                    c55Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.O0 = pbFragment2.O0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.O0);
                    new v59(this.a.z0.R1(), this.a.O0, "2").start();
                    c55Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.O0 = pbFragment3.O0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.O0);
                    c55Var.e();
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
            this.a.q7();
        }
    }

    /* loaded from: classes7.dex */
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
            a69 I0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.H0.m2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.z0.R1());
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
                        boolean y = ((TbImageView) view2).y();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, y)));
                        }
                        this.a.R = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.v6(str, i, eVar);
                    if (this.a.z0.G.i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i5 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Y() != null) {
                            ArrayList<TbRichTextImageInfo> Y = tbRichTextView.getRichText().Y();
                            int i6 = 0;
                            int i7 = -1;
                            while (i6 < Y.size()) {
                                if (Y.get(i6) != null) {
                                    arrayList.add(Y.get(i6).getSrc());
                                    if (i7 == i5 && str != null && (str.equals(Y.get(i6).getSrc()) || str.equals(Y.get(i6).V()) || str.equals(Y.get(i6).U()) || str.equals(Y.get(i6).getBigSrc()) || str.equals(Y.get(i6).X()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String src = Y.get(i6).getSrc();
                                    imageUrlData.imageUrl = src;
                                    imageUrlData.imageThumbUrl = src;
                                    if (this.a.q) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = Y.get(i6).getSrc();
                                    imageUrlData.isLongPic = Y.get(i6).b0();
                                    concurrentHashMap.put(Y.get(i6).getSrc(), imageUrlData);
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
                        this.a.r5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.z0.J1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.d6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.z0 != null) {
                            builder.D(this.a.z0.getFromForumId());
                            if (this.a.z0.y1() != null) {
                                builder.Q(this.a.z0.y1().N());
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
                        builder2.I(this.a.z0.J1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.d6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.z0 != null) {
                            builder2.D(this.a.z0.getFromForumId());
                            if (this.a.z0.y1() != null) {
                                builder2.Q(this.a.z0.y1().N());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText t7 = this.a.t7(str, i);
                        if (t7 != null && this.a.y2 >= 0 && this.a.y2 < t7.W().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = k39.a(t7.W().get(this.a.y2));
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
                            if (t7.getPostId() != 0 && (I0 = this.a.H0.I0()) != null) {
                                ArrayList<vn> v = I0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<vn> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        vn next = it.next();
                                        if ((next instanceof ey9) && t7.getPostId() == tg.g(((ey9) next).O(), 0L)) {
                                            int i9 = 8;
                                            if (t7.getPostId() == tg.g(this.a.z0.W0(), 0L)) {
                                                i9 = 1;
                                            }
                                            ya9.b(this.a.z0.y1(), (ey9) next, ((ey9) next).d0, i9, 3);
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
                            this.a.r5(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.z0.J1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.d6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.z0 != null) {
                                builder3.D(this.a.z0.getFromForumId());
                                if (this.a.z0.y1() != null) {
                                    builder3.Q(this.a.z0.y1().N());
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
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.novel_thread_mask_click_tip));
                bdTopToast.i((ViewGroup) this.a.getView());
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
                if (this.a.H0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.H0.s1());
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
                    this.a.P6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0def);
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

    /* loaded from: classes7.dex */
    public class r2 implements c55.c {
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

        @Override // com.baidu.tieba.c55.c
        public void a(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
                if (c55Var != null) {
                    c55Var.e();
                }
                PbFragment pbFragment = this.a;
                ey9 ey9Var = pbFragment.B2;
                if (ey9Var != null) {
                    if (i == 0) {
                        ey9Var.J0();
                        this.a.B2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.n6(pbFragment2.B2);
                    }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.B0 == null || this.a.B0.e()) {
                    return;
                }
                this.a.l6();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.H0.y1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                j39 y1 = this.a.z0.y1();
                if (y1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    y1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.f7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ui.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.f1.c(errorString2);
                } else {
                    this.a.Y6();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements dx4.a {
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

        @Override // com.baidu.tieba.dx4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.H0.w3();
                if (z) {
                    if (this.a.B0 != null) {
                        this.a.B0.h(z2);
                    }
                    this.a.z0.m3(z2);
                    if (!this.a.z0.j1()) {
                        this.a.H0.Q1(this.a.z0.y1());
                    } else {
                        this.a.j6();
                    }
                    if (z2) {
                        boolean o0 = this.a.z0.y1().o0();
                        if (this.a.B0 != null && !o0) {
                            if (this.a.B0.f() != null && this.a.z0 != null && this.a.z0.y1() != null && this.a.z0.y1().N() != null && this.a.z0.y1().N().getAuthor() != null) {
                                MarkData f = this.a.B0.f();
                                MetaData author = this.a.z0.y1().N().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00fd);
                                        this.a.c7();
                                    } else {
                                        this.a.X6(author);
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
                if (this.a.H0 != null && this.a.H0.k1() != null) {
                    o69 k1 = this.a.H0.k1();
                    if (k1.j()) {
                        k1.h();
                        return true;
                    }
                }
                if (this.a.H0 != null && this.a.H0.d2()) {
                    this.a.H0.C1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.H0.y1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ui.isEmpty(muteMessage)) {
                    muteMessage = this.a.e1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.f1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                a55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements c55.c {
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

        @Override // com.baidu.tieba.c55.c
        public void a(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
                if (c55Var != null) {
                    c55Var.e();
                }
                if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                    if (i == 0) {
                        if (this.a.m1 != null) {
                            wl5.a aVar = new wl5.a();
                            aVar.a = this.a.k1;
                            String str = "";
                            if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.m1.memeInfo.pck_id;
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
                        if (this.a.i1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.i1 = new x79(pbFragment.getPageContext());
                        }
                        this.a.i1.b(this.a.k1, this.a.j1.n());
                    }
                    this.a.j1 = null;
                    this.a.k1 = null;
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
                if (!this.a.b6() || this.a.a == null || this.a.a.K1() == null || !str.equals(this.a.a.K1().getTopicId())) {
                    return;
                }
                this.a.o7(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements a55.e {
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

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                a55Var.dismiss();
                this.b.D0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.z0.getForumId(), "0");
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.z0 == null || this.a.z0.H1() == i + 1) {
                return;
            }
            this.a.J6(r79.p(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof r25)) {
                r25 r25Var = (r25) customResponsedMessage.getData();
                k35.a aVar = new k35.a();
                int i = r25Var.a;
                String str = r25Var.b;
                aVar.a = r25Var.d;
                j39 y1 = this.a.z0.y1();
                if (y1 == null) {
                    return;
                }
                if (this.a.z0.a1() != null && this.a.z0.a1().getUserIdLong() == r25Var.p) {
                    this.a.H0.N2(r25Var.l, this.a.z0.y1(), this.a.z0.Q1(), this.a.z0.I1());
                }
                if (y1.F() != null && y1.F().size() >= 1 && y1.F().get(0) != null) {
                    long g = tg.g(y1.F().get(0).O(), 0L);
                    long g2 = tg.g(this.a.z0.R1(), 0L);
                    if (g == r25Var.n && g2 == r25Var.m) {
                        k35 L = y1.F().get(0).L();
                        if (L == null) {
                            L = new k35();
                        }
                        ArrayList<k35.a> a = L.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        L.e(L.b() + r25Var.l);
                        L.d(a);
                        y1.F().get(0).P0(L);
                        this.a.H0.I0().f0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z5a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                z5a z5aVar = (z5a) customResponsedMessage.getData();
                this.a.H0.y1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = z5aVar.a;
                boolean z = false;
                if (z5aVar.c == 0 && dataRes != null) {
                    int e = tg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (ui.isEmpty(str)) {
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
                        this.a.H0.C2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.Z6(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            ArrayList<ey9> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.z0 != null && this.a.z0.y1() != null && this.a.H0 != null && this.a.H0.I0() != null) {
                this.a.H0.v2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.z0.m2() && (F = this.a.z0.y1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.H0.I0().y()) - 1;
                    j39 y1 = this.a.z0.y1();
                    if (y1 == null) {
                        return;
                    }
                    if (y1.C() != null && y1.C().s1()) {
                        y--;
                    }
                    if (y1.D() != null && y1.D().s1()) {
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
                if (!r79.B(this.a.c1) && r79.B(i)) {
                    if (this.a.H0 != null) {
                        this.a.r0 = true;
                        this.a.H0.v0();
                        if (this.a.W0 != null && !this.a.H0.R1()) {
                            this.a.H0.c3(this.a.W0.z());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.H0.U2();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.H0 != null) {
                    this.a.H0.w2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new hs5();
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
                this.a.c1 = i;
                if (i == 0) {
                    gw9.g().h(this.a.getUniqueId(), true);
                    this.a.a5(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements l55.d {
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

        @Override // com.baidu.tieba.l55.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.N0 != null) {
                this.a.N0.r(o99.h(this.a.B2));
                ArrayList arrayList = new ArrayList();
                for (k55 k55Var : this.a.N0.g()) {
                    if (k55Var instanceof h55) {
                        arrayList.add((h55) k55Var);
                    }
                }
                o99.f(arrayList);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof y26)) {
                y26 y26Var = (y26) customResponsedMessage.getData();
                j39 y1 = this.a.z0.y1();
                if (y1 == null) {
                    return;
                }
                if (this.a.z0.y1() != null && this.a.z0.y1().W().p() != null && this.a.z0.y1().W().p().getPortrait() != null && this.a.z0.y1().W().p().getPortrait().equals(y26Var.a)) {
                    if (this.a.z0.y1().W().p().getUserWorldCupData() != null) {
                        this.a.z0.y1().W().p().getUserWorldCupData().d(y26Var.b);
                    }
                    this.a.H0.O2(this.a.z0.y1(), this.a.z0.Q1(), this.a.z0.I1(), this.a.H0.o1());
                }
                if (y1.F() != null && y1.F().size() >= 0) {
                    Iterator<ey9> it = y1.F().iterator();
                    while (it.hasNext()) {
                        ey9 next = it.next();
                        if (next != null && next.p() != null && next.p().getPortrait() != null && next.p().getPortrait().equals(y26Var.a) && next.p().getUserWorldCupData() != null) {
                            next.p().getUserWorldCupData().d(y26Var.b);
                        }
                    }
                    this.a.H0.I0().f0();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.H0.R1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.o5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements sj5 {
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

        @Override // com.baidu.tieba.sj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                v79 v79Var = this.a.L0;
                if (v79Var != null && v79Var.e() != null && this.a.L0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.L0.e().c());
                    if (this.a.W0 != null && (this.a.W0.y() || this.a.W0.A())) {
                        this.a.W0.w(false, this.a.L0.h());
                    }
                    this.a.L0.a(true);
                    return true;
                }
                return !this.a.e5(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
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
                return pbFragment.h5(view2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.z0 != null && this.a.z0.y1() != null) {
                this.a.z0.y1().a();
                this.a.z0.c2();
                if (this.a.H0.I0() != null) {
                    this.a.H0.Q1(this.a.z0.y1());
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
            ux9 ux9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ux9) && (ux9Var = (ux9) customResponsedMessage.getData()) != null && (agreeData = ux9Var.b) != null) {
                if (this.a.H0 != null) {
                    this.a.H0.i2(ux9Var);
                }
                if (agreeData.agreeType == 2 && this.a.H0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !s99.h(this.a.z0.b)) {
                    this.a.H0.f4();
                    s99.b(this.a.z0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x1 implements Comparator<jg5> {
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
        public int compare(jg5 jg5Var, jg5 jg5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jg5Var, jg5Var2)) == null) {
                return jg5Var.compareTo(jg5Var2);
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
            dy9 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.z0 != null && this.a.z0.y1() != null) {
                String str = (String) customResponsedMessage.getData();
                dy9 dy9Var = null;
                if (!TextUtils.isEmpty(str) && this.a.z0.y1().F() != null) {
                    ArrayList<ey9> F = this.a.z0.y1().F();
                    Iterator<ey9> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ey9 next = it.next();
                        if (next instanceof dy9) {
                            dy9 dy9Var2 = (dy9) next;
                            if (str.equals(dy9Var2.t1())) {
                                dy9Var = dy9Var2;
                                break;
                            }
                        }
                    }
                    if (dy9Var != null) {
                        F.remove(dy9Var);
                    }
                }
                if (this.a.H0.I0() != null && !ListUtils.isEmpty(this.a.H0.I0().v())) {
                    ArrayList<vn> v = this.a.H0.I0().v();
                    if (dy9Var != null) {
                        i = dy9Var;
                    } else {
                        i = r79.i(this.a.z0.y1(), str);
                    }
                    r79.e(v, i);
                }
                if (this.a.H0.a1() != null && !ListUtils.isEmpty(this.a.H0.a1().getData())) {
                    List<vn> data = this.a.H0.a1().getData();
                    if (dy9Var == null) {
                        dy9Var = r79.i(this.a.z0.y1(), str);
                    }
                    r79.e(data, dy9Var);
                }
                this.a.j5(str);
                this.a.z0.c2();
                if (this.a.H0.I0() != null) {
                    this.a.H0.I0().f0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.L5() != null) {
                this.a.L5().s2();
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
        public void onNavigationButtonClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a55Var) == null) {
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
            this.a.k5();
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.n1 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 extends j9 {
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

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.C0.getLoadDataMode()) {
                    case 0:
                        this.a.z0.c2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.p5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.H0.E0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.q5(pbFragment.C0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.H0.E0(this.a.C0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.H0.x2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.H0.E0(this.a.C0.getLoadDataMode(), false, null, false);
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
        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.z0.n1()) {
                    this.a.D6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(vi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c2));
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
        R2 = new a1();
        S2 = new a();
    }

    public static PbFragment p6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65677, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s16
    public kg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.D == null) {
                this.D = new kg<>(new a3(this), 15, 0);
            }
            return this.D;
        }
        return (kg) invokeV.objValue;
    }

    public PbInterviewStatusView.f A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.x0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.c && this.M2 == -1 && this.N2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public final void D6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideNetRefreshView(this.H0.s1());
            a7();
            if (this.z0.y2()) {
                this.H0.x3();
            }
            this.H0.G3();
        }
    }

    @Override // com.baidu.tieba.s16
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            s79 s79Var = this.H0;
            if (s79Var == null) {
                return 0;
            }
            return s79Var.n1();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s16
    /* renamed from: E5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            s79 s79Var = this.H0;
            if (s79Var == null) {
                return null;
            }
            return s79Var.a1();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public int F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.N2;
        }
        return invokeV.intValue;
    }

    public void F6() {
        rf5 rf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (rf5Var = this.j0) != null) {
            rf5Var.x();
        }
    }

    @Override // com.baidu.tieba.s16
    public kg<TiebaPlusRecommendCard> G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.C == null) {
                this.C = new kg<>(new m2(this), 5, 0);
            }
            return this.C;
        }
        return (kg) invokeV.objValue;
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.M2;
        }
        return invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public final j39 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.y1();
            }
            return null;
        }
        return (j39) invokeV.objValue;
    }

    public y89 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.a.I0();
        }
        return (y89) invokeV.objValue;
    }

    public wj5 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.W0;
        }
        return (wj5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public kg<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (kg) invokeV.objValue;
    }

    public z89 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.e;
        }
        return (z89) invokeV.objValue;
    }

    public m99 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.u0;
        }
        return (m99) invokeV.objValue;
    }

    public s79 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.H0;
        }
        return (s79) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb9
    public PbModel.h M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.o2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public String N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb9
    public PbModel Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.z0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s16
    public kg<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            kg<RelativeLayout> kgVar = new kg<>(new o2(this), 10, 0);
            this.E = kgVar;
            return kgVar;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s16
    public kg<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb9
    public AbsPbActivity V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void V5() {
        s79 s79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (s79Var = this.H0) != null) {
            s79Var.w1();
            U5();
        }
    }

    @Override // com.baidu.tieba.s16
    public kg<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.A == null) {
                this.A = new kg<>(new k2(this), 8, 0);
            }
            return this.A;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s16
    public kg<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.B == null) {
                this.B = new kg<>(new n2(this), 8, 0);
            }
            return this.B;
        }
        return (kg) invokeV.objValue;
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new m0(this));
        }
    }

    @Override // com.baidu.tieba.s16
    public kg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (kg) invokeV.objValue;
    }

    public boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.d1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.K1() != null && this.a.K1().x1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048658, this) == null) && sf5.g(TbadkCoreApplication.getInst(), 0) && !this.H0.F2()) {
            this.j0 = sf5.i(getPageContext(), "reply_pb", 0L);
        }
    }

    public boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.b1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            j39 y12 = this.z0.y1();
            this.z0.m3(true);
            dx4 dx4Var = this.B0;
            if (dx4Var != null) {
                y12.J0(dx4Var.g());
            }
            this.H0.Q1(y12);
        }
    }

    public void k6() {
        s79 s79Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048690, this) != null) || (s79Var = this.H0) == null) {
            return;
        }
        s79Var.f2();
    }

    public final void k7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void l7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    @Override // com.baidu.tieba.s16
    public kg<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (this.F == null) {
                this.F = new kg<>(new p2(this), 10, 0);
            }
            return this.F;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.d0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public zn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (zn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            D6();
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

    public AntiData s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null) {
                return this.z0.y1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public void t6() {
        rf5 rf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (rf5Var = this.j0) != null) {
            rf5Var.q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (pbModel = this.z0) != null && !ui.isEmpty(pbModel.R1())) {
            super.taskStart();
        }
    }

    public ey9 u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            j39 j39Var = this.z0.G;
            if (j39Var != null) {
                return j39Var.W();
            }
            return null;
        }
        return (ey9) invokeV.objValue;
    }

    public int v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    public String w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s16
    public kg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            if (this.L == null) {
                this.L = new kg<>(new l2(this), 20, 0);
            }
            return this.L;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            rf5 rf5Var = this.j0;
            if (rf5Var != null && rf5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.q2();
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
        this.t0 = new t(this);
        this.w0 = false;
        this.x0 = new e0(this);
        this.y0 = new Handler(new p0(this));
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
        this.Z0 = new l1(this);
        this.a1 = new w1(this);
        this.b1 = new h2(this);
        this.c1 = 0;
        this.n1 = false;
        this.o1 = 0;
        this.p1 = -1;
        this.r1 = 0;
        this.t1 = new s2(this);
        this.u1 = new d3(this);
        this.v1 = new j(this, 2004016);
        this.w1 = new k(this, 2016485);
        this.x1 = new l(this, 2001269);
        this.y1 = new m(this, 2004008);
        this.z1 = new n(this, 2004007);
        this.A1 = new o(this, 2004005);
        this.B1 = new p(this, 2001332);
        this.C1 = new q(this, 2921391);
        this.D1 = new r(this, 2921606);
        this.E1 = new s(this, 2921658);
        this.F1 = new u(this);
        this.G1 = new v(this, 2001369);
        this.H1 = new w(this, 2921787);
        this.I1 = new x(this, 2016488);
        this.J1 = new y(this, 2016331);
        this.K1 = new z(this, 2921746);
        this.L1 = new a0(this);
        this.M1 = new b0(this, 2010045);
        this.N1 = new c0(this);
        this.O1 = new PraiseModel(getPageContext(), new d0(this));
        this.P1 = new f0(this);
        this.Q1 = new h0(this, 2001115);
        this.R1 = new i0(this);
        this.S1 = new j0(this);
        this.U1 = new p49(new o0(this));
        this.V1 = new r0(this);
        this.W1 = new s0(this, 2001427);
        this.X1 = new t0(this, 2001428);
        this.Y1 = new u0(this, 2921634);
        this.Z1 = new v0(this, 2001426);
        this.a2 = new w0(this, 2004021);
        this.b2 = new x0(this, 2016528);
        this.c2 = new y0(this, 2921724);
        this.d2 = new z0(this, 2921033);
        this.e2 = new b1(this);
        this.f2 = new c1(this);
        this.g2 = new d1(this);
        this.h2 = new g1(this);
        this.i2 = new j1(this);
        this.j2 = new k1(this, 2921480);
        this.k2 = new m1(this);
        this.l2 = Boolean.FALSE;
        this.m2 = new n1(this);
        this.n2 = new o1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.o2 = new p1(this);
        this.p2 = new q1(this, 2016450);
        this.q2 = new r1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.r2 = new s1(this);
        this.s2 = new v1(this);
        this.t2 = new z1(this);
        this.u2 = new b2(this);
        this.v2 = new c2(this);
        this.x2 = new d2(this);
        this.y2 = 0;
        this.z2 = new q2(this);
        this.A2 = false;
        this.B2 = null;
        this.C2 = new r2(this);
        this.D2 = new t2(this);
        this.E2 = new u2(this);
        this.F2 = new w2(this);
        this.G2 = new x2(this);
        this.H2 = new y2(this);
        this.I2 = new z2(this);
        this.J2 = new b3(this);
        this.K2 = new c3(this);
        this.L2 = new b(this);
        this.M2 = -1;
        this.N2 = -1;
        this.Q2 = 0;
    }

    public void E6(e3 e3Var) {
        List<e3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, e3Var) == null) && e3Var != null && (list = this.q1) != null) {
            list.remove(e3Var);
        }
    }

    public final void J6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i3) == null) && this.z0 != null) {
            a7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.z0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void K6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i3) == null) {
            this.Q2 = i3;
        }
    }

    public void L6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z3) == null) {
            this.l2 = Boolean.valueOf(z3);
        }
    }

    public void M6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z3) == null) {
            this.s0 = z3;
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z3) == null) {
            this.N = z3;
        }
    }

    public void Q6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void R6(boolean z3) {
        wj5 wj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048623, this, z3) != null) || (wj5Var = this.W0) == null) {
            return;
        }
        wj5Var.Y(z3);
        this.W0.b0(z3);
        this.W0.j0(z3);
    }

    public final void T5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, intent) == null) {
            s99.g(this, intent);
        }
    }

    public void V4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, e3Var) == null) && e3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(e3Var)) {
                this.q1.add(e3Var);
            }
        }
    }

    public void W4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, e3Var) == null) && e3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(e3Var)) {
                this.q1.add(0, e3Var);
            }
        }
    }

    public final void e6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            qx4.y(getContext(), "", str, false, true, true, bundle);
        }
    }

    public final void e7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i3) == null) {
            s99.j(this, t5(), i3);
        }
    }

    @Override // com.baidu.tieba.lb9.b
    public void l1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z3) == null) {
            this.Q0 = z3;
        }
    }

    public final void m6(View view2) {
        SparseArray sparseArray;
        ey9 ey9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (ey9Var = (ey9) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            n6(ey9Var);
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

    @Override // com.baidu.tieba.a55.e
    public void onClick(a55 a55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, a55Var) == null) {
            m5(a55Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.p9
    public void onPreLoad(zn znVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, znVar) == null) {
            PreLoadImageHelper.load(znVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(znVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.z0.S2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            wj5 wj5Var = this.W0;
            if (wj5Var != null) {
                wj5Var.G(bundle);
            }
        }
    }

    public final void r7(a25 a25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048734, this, a25Var) == null) && a25Var != null) {
            this.P2 = a25Var;
            this.c = true;
            this.H0.S2();
            this.H0.l3(this.O2);
        }
    }

    @Override // com.baidu.tieba.s16
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.s16
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            y79.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    public final void W5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048638, this, i3, i4) == null) {
            kx5.b(new h(this, i4), new i(this, i4, i3));
        }
    }

    @Override // com.baidu.tieba.s16
    public void j0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        s79 s79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048717, this, i3, keyEvent)) == null) {
            if (keyEvent != null && (s79Var = this.H0) != null) {
                return s79Var.n2(i3);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void A6(b49 b49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b49Var) == null) {
            String O = b49Var.g().O();
            List<ey9> list = this.z0.y1().S().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                ey9 ey9Var = list.get(i3);
                if (ey9Var.O() != null && ey9Var.O().equals(O)) {
                    ArrayList<ey9> i4 = b49Var.i();
                    ey9Var.f1(b49Var.k());
                    if (ey9Var.e0() != null) {
                        ey9Var.e0().clear();
                        ey9Var.e0().addAll(i4);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.z0.h1()) {
                this.H0.Q1(this.z0.y1());
            }
        }
    }

    public final void S5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null && this.z0.y1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.z0.R1(), str);
                ThreadData N = this.z0.y1().N();
                if (N.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (N.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (N.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                e6(format);
                return;
            }
            this.A0.a(str);
        }
    }

    public final void X6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048643, this, metaData) != null) || metaData == null) {
            return;
        }
        a55 a55Var = new a55(getActivity());
        a55Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0c29));
        a55Var.setTitleShowCenter(true);
        a55Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0c2a));
        a55Var.setMessageShowCenter(true);
        a55Var.setCancelable(false);
        a55Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c2b), new t1(this, metaData));
        a55Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c2c), new u1(this, metaData));
        a55Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void d7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && Q() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                Q().H0(postWriteCallBackData.getPostId());
                int N0 = this.H0.N0();
                this.o1 = N0;
                this.z0.V2(N0, this.H0.U0());
            }
            this.H0.v0();
            this.L0.c();
            wj5 wj5Var = this.W0;
            if (wj5Var != null) {
                this.H0.c3(wj5Var.z());
            }
            this.H0.w1();
            this.H0.K3(true);
            this.z0.c2();
        }
    }

    public final void j5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048686, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.z0) != null && pbModel.y1() != null) {
            dy9 z3 = this.z0.y1().z();
            if (z3 != null && str.equals(z3.t1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.z0.y1().b();
            }
            dy9 R0 = this.z0.R0();
            if (R0 != null && str.equals(R0.t1())) {
                this.z0.E0();
            }
        }
    }

    public void n6(ey9 ey9Var) {
        boolean z3;
        ey9 u5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048700, this, ey9Var) != null) || ey9Var == null) {
            return;
        }
        if (ey9Var.O() != null && ey9Var.O().equals(this.z0.t1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData s12 = this.z0.s1(ey9Var);
        if (this.z0.y1() != null && this.z0.y1().i0() && (u5 = u5()) != null) {
            s12 = this.z0.s1(u5);
        }
        if (s12 == null) {
            return;
        }
        this.H0.x3();
        dx4 dx4Var = this.B0;
        if (dx4Var != null) {
            dx4Var.i(s12);
            if (!z3) {
                this.B0.a();
            } else {
                this.B0.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        j39 y12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (L5() != null && r79.D(this)) {
                L5().m4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09079d));
            PbModel pbModel = this.z0;
            if (pbModel != null && (y12 = pbModel.y1()) != null) {
                this.o2.c(true, 0, 3, 0, y12, "", 1);
            }
            this.a.M1().j(this.t0);
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && this.G.b(pbModel2.G, getContext(), this.a.findViewById(this.H0.J0()), this.z0.getForumId(), this.z0.R1())) {
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).f2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048709, this, i3) != null) || this.W == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.H0.j2(i3);
        wj5 wj5Var = this.W0;
        if (wj5Var != null && wj5Var.b() != null) {
            this.W0.b().y(i3);
        }
        if (this.H0.a() != null) {
            this.H0.a().d(getPageContext(), i3);
        }
        this.L0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.W = i3;
        k7();
        rf5 rf5Var = this.j0;
        if (rf5Var != null) {
            rf5Var.w();
        }
    }

    public void B6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z3, markData) == null) {
            this.H0.w3();
            this.z0.m3(z3);
            dx4 dx4Var = this.B0;
            if (dx4Var != null) {
                dx4Var.h(z3);
                if (markData != null) {
                    this.B0.i(markData);
                }
            }
            if (this.z0.j1()) {
                j6();
            } else {
                this.H0.Q1(this.z0.y1());
            }
        }
    }

    public void C6(b49 b49Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, b49Var) != null) || b49Var.g() == null) {
            return;
        }
        String O = b49Var.g().O();
        ArrayList<ey9> F = this.z0.y1().F();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= F.size()) {
                break;
            }
            ey9 ey9Var = F.get(i3);
            if (ey9Var.O() != null && ey9Var.O().equals(O)) {
                ArrayList<ey9> i4 = b49Var.i();
                ey9Var.f1(b49Var.k());
                if (ey9Var.e0() != null && i4 != null) {
                    Iterator<ey9> it = i4.iterator();
                    while (it.hasNext()) {
                        ey9 next = it.next();
                        if (ey9Var.n0() != null && next != null && next.p() != null && (metaData = ey9Var.n0().get(next.p().getUserId())) != null) {
                            next.I0(metaData);
                            next.V0(true);
                            next.p1(getPageContext(), this.z0.r2(metaData.getUserId()));
                        }
                    }
                    if (i4.size() == ey9Var.e0().size()) {
                        z3 = false;
                    }
                    if (!ey9Var.u0(false)) {
                        ey9Var.e0().clear();
                        ey9Var.e0().addAll(i4);
                    }
                }
                if (ey9Var.y() != null) {
                    ey9Var.G0();
                }
            } else {
                i3++;
            }
        }
        if (!this.z0.h1() && z3) {
            this.H0.Q1(this.z0.y1());
        }
        if (z3) {
            A6(b49Var);
        }
    }

    public void a5(boolean z3) {
        s79 s79Var;
        int i3;
        int y3;
        ey9 ey9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z3) == null) && (s79Var = this.H0) != null && s79Var.a1() != null) {
            int firstVisiblePosition = this.H0.a1().getFirstVisiblePosition();
            int lastVisiblePosition = this.H0.a1().getLastVisiblePosition();
            a69 I0 = this.H0.I0();
            if (I0 != null && this.z0.y1() != null) {
                if (lastVisiblePosition <= I0.y()) {
                    i3 = 0;
                    y3 = 1;
                } else {
                    if (firstVisiblePosition > I0.y()) {
                        i3 = firstVisiblePosition - I0.y();
                    } else {
                        i3 = 0;
                    }
                    y3 = (lastVisiblePosition - I0.y()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (y3 > i3) {
                    while (i3 < y3) {
                        if (this.H0.a1().G(i3) != null && (this.H0.a1().G(i3) instanceof ey9) && (ey9Var = (ey9) this.H0.a1().G(i3)) != null) {
                            ey9 ey9Var2 = (ey9) ListUtils.getItem(this.z0.y1().F(), ey9Var.D() - 1);
                            if (ey9Var.m() == null && ey9Var2 != null) {
                                ey9Var.H0(ey9Var2.m());
                            }
                            if (ey9Var.m() != null) {
                                ey9Var.m().r(ey9Var.D());
                                arrayList.add(ey9Var.m());
                            }
                        }
                        i3++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new x1(this));
                    jg5 jg5Var = (jg5) ListUtils.getItem(arrayList, 0);
                    if (jg5Var != null && jg5Var.e() == 1) {
                        if (!z3) {
                            this.H0.G2(jg5Var, 0);
                            return;
                        }
                        return;
                    }
                    this.H0.G2(jg5Var, 1);
                }
            }
        }
    }

    public final boolean o6(ey9 ey9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, ey9Var)) == null) {
            if (ey9Var == null) {
                return false;
            }
            String O = ey9Var.O();
            if (StringUtils.isNull(O) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s3 = l95.m().s("bubble_link", "");
            if (StringUtils.isNull(s3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = ey9Var.j0().getJumpUrl();
            int packageId = ey9Var.j0().getPackageId();
            int propsId = ey9Var.j0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                qx4.s(getPageContext().getPageActivity(), iz9.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                qx4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s3 + "?props_id=" + O, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void s7(int i3) {
        PbModel pbModel;
        ThreadData N;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048737, this, i3) != null) || (pbModel = this.z0) == null || pbModel.y1() == null || (N = this.z0.y1().N()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData praise = N.getPraise();
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
                    N.setPraise(praiseData);
                } else {
                    N.getPraise().getUser().add(0, metaData);
                    N.getPraise().setNum(N.getPraise().getNum() + 1);
                    N.getPraise().setIsLike(i3);
                }
            }
        } else if (N.getPraise() != null) {
            N.getPraise().setIsLike(i3);
            N.getPraise().setNum(N.getPraise().getNum() - 1);
            ArrayList<MetaData> user = N.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        N.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
        }
        if (this.z0.Q1()) {
            this.H0.I0().f0();
        } else {
            this.H0.y4(this.z0.y1());
        }
    }

    public final AbsPbActivity.e x6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048751, this, str)) == null) {
            String str2 = null;
            if (this.z0.y1() != null && this.z0.y1().F() != null && this.z0.y1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.z0.y1().F().size()) {
                        if (str.equals(this.z0.y1().F().get(i3).O())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                ey9 ey9Var = this.z0.y1().F().get(i3);
                if (ey9Var.a0() != null && ey9Var.a0().W() != null) {
                    Iterator<TbRichTextData> it = ey9Var.a0().W().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.c0() != null) {
                                str2 = next.c0().V();
                            }
                        }
                    }
                    v6(str2, 0, eVar);
                    k39.b(ey9Var, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void D0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (p16[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), p16.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (y79.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new qy5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.s16
    public void Z(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048648, this, context, str, z3) == null) {
            if (y79.c(str) && (pbModel = this.z0) != null && pbModel.R1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.z0.R1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    dh5 dh5Var = new dh5();
                    dh5Var.a = str;
                    dh5Var.b = 3;
                    dh5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, dh5Var));
                }
            } else {
                y79.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public final boolean G6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof ey9)) {
                return false;
            }
            ey9 ey9Var = (ey9) obj;
            if (ey9Var.getType() != ey9.V0 && !TextUtils.isEmpty(ey9Var.s()) && n05.c().g()) {
                return o6(ey9Var);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null) {
                if (L5().k1() != null) {
                    L5().k1().g();
                }
                b49 b49Var = new b49();
                b49Var.v(this.z0.y1().k());
                b49Var.z(this.z0.y1().N());
                b49Var.x(ey9Var);
                L5().j1().q0(b49Var);
                L5().j1().setPostId(ey9Var.O());
                i6(view2, ey9Var.p().getUserId(), "", ey9Var);
                TiebaStatic.log("c11743");
                wj5 wj5Var = this.W0;
                if (wj5Var != null) {
                    this.H0.c3(wj5Var.z());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (pbModel = this.z0) != null && pbModel.y1() != null && this.z0.y1().N() != null && this.z0.y1().N().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void I6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (pbModel = this.z0) != null && pbModel.y1() != null && this.z0.y1().N() != null && this.z0.y1().N().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            vi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean W6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || !pbModel.Q1()) {
                return false;
            }
            if (this.z0.w1() != null && this.z0.w1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && sf5.g(TbadkCoreApplication.getInst(), 0) && !this.H0.F2()) {
            this.j0 = sf5.i(getPageContext(), "collect", 0L);
        }
    }

    public final void h7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && (pbModel = this.z0) != null && !ui.isEmpty(pbModel.R1())) {
            eu4.w().Q(du4.Z, tg.g(this.z0.R1(), 0L));
        }
    }

    public void q6() {
        List<e3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048730, this) == null) && (list = this.q1) != null && !list.isEmpty()) {
            int size = this.q1.size();
            while (true) {
                size--;
                if (size <= -1 || this.q1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void r6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.H0.v0();
            if (this.h) {
                return;
            }
            k7();
            this.H0.x3();
            if (this.z0.loadData()) {
                this.H0.c4();
            }
        }
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (this.z0.y1() != null && this.z0.y1().N() != null) {
                return this.z0.y1().N().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.F0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.F0 = pollingModel;
                pollingModel.M0(w55.e);
            }
            this.F0.C0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            wg.a().postDelayed(this.V1, 10000L);
        }
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            if (this.l1 != null) {
                wl5.b bVar = new wl5.b();
                bVar.a = this.l1.X();
                bVar.b = this.l1.V();
                bVar.c = String.valueOf(this.l1.Y());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.k1));
        }
    }

    public final void Y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            a55 a55Var = new a55(getPageContext().getPageActivity());
            a55Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            a55Var.setPositiveButton(R.string.open_now, new c(this));
            a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new d(this));
            a55Var.create(this.e1).show();
        }
    }

    public final void a7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            showLoadingView(this.H0.s1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cf));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.H0.r1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final boolean b5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || pbModel.y1() == null) {
                return false;
            }
            ThreadData N = this.z0.y1().N();
            AntiData c4 = this.z0.y1().c();
            if (!AntiHelper.b(getPageContext(), N) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean c6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            ey9 c4 = k39.c(this.z0.y1(), this.z0.Q1(), this.z0.I1());
            if (c4 != null && c4.p() != null && c4.p().getGodUserData() != null && c4.p().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if ((this.z0.y1() != null && (this.z0.y1().i0() || ThreadCardUtils.isSelf(this.z0.y1().N()))) || this.Y0 == null || this.z0.y1() == null || this.z0.y1().c() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.z0.y1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void f6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048671, this) == null) && this.P2 != null) {
            if (this.N2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fac);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.P2.a(), this.N2, 0)));
                this.a.finish();
            }
        }
    }

    public final void g5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            if (this.z0.d1() || this.z0.g1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.z0.R1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.z0.R1()));
            if (m7()) {
                this.a.finish();
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && this.P2 != null) {
            if (this.M2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fad);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.P2.a(), this.M2, 0)));
                this.a.finish();
            }
        }
    }

    public final void n7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (absPbActivity = this.a) != null && absPbActivity.K1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K1().R1()).param("topic_id", this.a.K1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.K1().V1()));
        }
    }

    public final void q7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.Z(this.z0.getForumId()) && this.z0.y1() != null && this.z0.y1().k() != null) {
            boolean z3 = true;
            if (this.z0.y1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.z0.M0().Y(this.z0.getForumId(), this.z0.R1());
            }
        }
    }

    public void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.z0.y1() != null && this.z0.y1().N() != null && this.z0.y1().N().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.z0.y1().N().getTaskInfoData().k(), this.z0.y1().N().getTaskInfoData().h(), this.z0.y1().N().getTaskInfoData().c(), this.z0.y1().N().getTaskInfoData().d(), this.z0.y1().N().getIs_top(), this.z0.y1().N().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null) {
                dy9 z3 = this.z0.y1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.z0.y1().b();
                }
                if (this.z0.R0() != null) {
                    this.z0.E0();
                }
                this.z0.c2();
            }
            if (this.z0.y1().F() != null) {
                Iterator<ey9> it = this.z0.y1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof dy9) {
                        it.remove();
                    }
                }
            }
            if (this.H0.I0() != null && !ListUtils.isEmpty(this.H0.I0().v())) {
                r79.d(this.H0.I0().v());
            }
            if (this.H0.a1() != null && !ListUtils.isEmpty(this.H0.a1().getData())) {
                r79.d(this.H0.a1().getData());
            }
            if (this.H0.I0() != null) {
                this.H0.I0().f0();
            }
        }
    }

    public final boolean m7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.y1() != null && this.z0.y1().i0()) {
                return true;
            }
            if (this.z0.j1()) {
                MarkData U0 = this.z0.U0();
                if (U0 == null || !this.z0.h1()) {
                    return true;
                }
                MarkData P0 = this.z0.P0(this.H0.R0());
                if (P0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", U0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (P0.getPostId() != null && !P0.getPostId().equals(U0.getPostId())) {
                    a55 a55Var = new a55(getPageContext().getPageActivity());
                    a55Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0296));
                    a55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04bb, new g2(this, P0, U0, a55Var));
                    a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new i2(this, U0, a55Var));
                    a55Var.setOnCalcelListener(new j2(this, U0, a55Var));
                    a55Var.create(getPageContext());
                    a55Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", U0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.z0.y1() != null && this.z0.y1().F() != null && this.z0.y1().F().size() > 0 && this.z0.h1()) {
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
            if (this.O) {
                this.O = false;
                O5();
            }
            if (c6()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            s79 s79Var = this.H0;
            if (s79Var != null && s79Var.s1() != null) {
                if (!this.g) {
                    a7();
                } else {
                    hideLoadingView(this.H0.s1());
                }
                this.H0.t2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            s79 s79Var2 = this.H0;
            if (s79Var2 != null) {
                noNetworkView = s79Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.B1);
            this.Q0 = false;
            I6();
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Z1);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.n1) {
                D6();
                this.n1 = false;
            }
            h7();
            ItemCardHelper.w(this.H2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                lh5.q().w(downloadData);
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
            if (L5().k1() != null) {
                L5().k1().n();
            }
            da9 da9Var = this.H0.k;
            if (da9Var != null && !da9Var.n()) {
                this.H0.k.r();
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null && this.z0.y1().k() != null && this.z0.y1().N() != null) {
                ih5.j().x(getPageContext().getPageActivity(), "pb", this.z0.y1().k().getId(), tg.g(this.z0.y1().N().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            gw9.g().h(getUniqueId(), false);
        }
    }

    public void w6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null && this.z0.y1().k() != null) {
                if (b5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.z0.y1().i0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.H0.m0();
                    return;
                } else {
                    wj5 wj5Var = this.W0;
                    if (wj5Var != null && wj5Var.b() != null) {
                        this.W0.b().C(new sh5(45, 27, null));
                    }
                    this.H0.m0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<ey9> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || pbModel.y1() == null || this.z0.y1().F() == null || (count = ListUtils.getCount((F = this.z0.y1().F()))) == 0) {
                return "";
            }
            if (this.z0.J1()) {
                Iterator<ey9> it = F.iterator();
                while (it.hasNext()) {
                    ey9 next = it.next();
                    if (next != null && next.D() == 1) {
                        return next.O();
                    }
                }
            }
            int R0 = this.H0.R0();
            ey9 ey9Var = (ey9) ListUtils.getItem(F, R0);
            if (ey9Var != null && ey9Var.p() != null) {
                if (this.z0.r2(ey9Var.p().getUserId())) {
                    return ey9Var.O();
                }
                for (int i3 = R0 - 1; i3 != 0; i3--) {
                    ey9 ey9Var2 = (ey9) ListUtils.getItem(F, i3);
                    if (ey9Var2 == null || ey9Var2.p() == null || ey9Var2.p().getUserId() == null) {
                        break;
                    } else if (this.z0.r2(ey9Var2.p().getUserId())) {
                        return ey9Var2.O();
                    }
                }
                for (int i4 = R0 + 1; i4 < count; i4++) {
                    ey9 ey9Var3 = (ey9) ListUtils.getItem(F, i4);
                    if (ey9Var3 == null || ey9Var3.p() == null || ey9Var3.p().getUserId() == null) {
                        break;
                    } else if (this.z0.r2(ey9Var3.p().getUserId())) {
                        return ey9Var3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void O6(yj5 yj5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, yj5Var) == null) && yj5Var != null && (pbModel = this.z0) != null) {
            yj5Var.p(pbModel.X0());
            if (this.z0.y1() != null && this.z0.y1().k() != null) {
                yj5Var.o(this.z0.y1().k());
            }
            yj5Var.q("pb");
            yj5Var.r(this.z0);
        }
    }

    public final void P6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048618, this, i3) != null) || (pbModel = this.z0) == null) {
            return;
        }
        int H1 = pbModel.H1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.z0.g3(1);
                } else {
                    this.z0.g3(4);
                }
            } else {
                this.z0.g3(3);
            }
        } else {
            this.z0.g3(2);
        }
        int H12 = this.z0.H1();
        if (H1 == 4 || H12 == 4) {
            r6();
        }
    }

    public void V6(View view2) {
        j39 H5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, view2) == null) {
            int n3 = l95.m().n(l95.q("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.a;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (n3 != 1 && n3 != 2 && n3 != 3)) && (H5 = H5()) != null) {
                p99.d(getContext(), view2, H5);
            }
        }
    }

    public final void X5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, bundle) == null) {
            dx4 c4 = dx4.c(this.a);
            this.B0 = c4;
            if (c4 != null) {
                c4.j(this.r2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.C0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.t2);
            this.D0 = new oe5(getPageContext());
            M5();
            this.O1.setUniqueId(getUniqueId());
            this.O1.registerListener();
        }
    }

    public void c5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.H0.S3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = tg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = tg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.d1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean e5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i3)) == null) {
            if (this.Y0 != null && this.z0.y1() != null && !ThreadCardUtils.isSelf(this.z0.y1().N()) && this.z0.y1().c() != null) {
                return this.Y0.checkPrivacyBeforeSend(this.z0.y1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void g6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            PbModel K1 = this.a.K1();
            this.z0 = K1;
            if (K1 != null) {
                if (K1.T0() != null) {
                    this.z0.T0().c(this.L2);
                }
                if (this.z0.u1() != null) {
                    this.z0.u1().f(this.u1);
                }
                if (StringUtils.isNull(this.z0.R1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.z0.d3(6);
                }
            }
        }
    }

    public final void o7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048705, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.K1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K1().R1()).param("topic_id", this.a.K1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.K1().V1()));
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        s79 s79Var;
        da9 da9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (s79Var = this.H0) != null && (da9Var = s79Var.k) != null && da9Var.n()) {
                this.H0.k.g();
                s6();
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
            s79 s79Var2 = this.H0;
            if (s79Var2 != null) {
                s79Var2.k2(configuration);
            }
            j55 j55Var = this.M0;
            if (j55Var != null) {
                j55Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public void u6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048744, this, animatorListener) == null) && this.H0 != null && (pbModel = this.z0) != null && pbModel.y1() != null && this.z0.y1().R() != null && checkUpIsLogin() && this.H0.I0() != null && this.H0.I0().B() != null) {
            this.H0.I0().B().H(animatorListener);
        }
    }

    public final void P5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void f7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            if (str == null) {
                str = "";
            }
            k9 k9Var = this.e1;
            if (k9Var == null) {
                return;
            }
            a55 a55Var = new a55(k9Var.getPageActivity());
            a55Var.setMessage(str);
            a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b29, new e(this));
            a55Var.create(this.e1).show();
        }
    }

    public final void i7(SparseArray<Object> sparseArray) {
        ey9 ey9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048684, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof ey9) || (ey9Var = (ey9) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        j7(ey9Var, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z3) == null) {
            super.onUserChanged(z3);
            this.H0.r4(z3);
            j55 j55Var = this.M0;
            if (j55Var != null) {
                j55Var.dismiss();
            }
            if (z3 && this.Q0) {
                this.H0.y3();
                this.z0.u2(true);
            }
            if (this.H0.I0() != null) {
                this.H0.I0().j0(z3);
            }
        }
    }

    public final void p7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048728, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.z0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(o99.n(i3))));
        }
    }

    public final void r5(Rect rect) {
        s79 s79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048732, this, rect) == null) && rect != null && (s79Var = this.H0) != null && s79Var.r1() != null && rect.top <= this.H0.r1().getHeight()) {
            rect.top += this.H0.r1().getHeight() - rect.top;
        }
    }

    public final void z6(View view2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048758, this, view2) != null) || view2 == null) {
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

    public final void Q5(int i3, Intent intent) {
        fi5 fi5Var;
        fi5 fi5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048620, this, i3, intent) == null) {
            if (i3 == 0) {
                this.H0.w1();
                this.H0.k1().g();
                this.H0.K3(false);
            }
            this.H0.U2();
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
                if (editorType == 1 && this.H0.k1() != null && this.H0.k1().f() != null) {
                    ak5 f4 = this.H0.k1().f();
                    f4.d0(this.z0.y1().N());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    ei5 p3 = f4.b().p(6);
                    if (p3 != null && (fi5Var2 = p3.m) != null) {
                        fi5Var2.C(new sh5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            wj5 wj5Var = this.W0;
            if (wj5Var != null) {
                wj5Var.M();
                this.W0.n0(pbEditorData.getVoiceModel());
                this.W0.C(writeData);
                ei5 p4 = this.W0.b().p(6);
                if (p4 != null && (fi5Var = p4.m) != null) {
                    fi5Var.C(new sh5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.W0.i0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.W0.H(null, null);
                }
            }
        }
    }

    public final void T6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048628, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (L5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        vf5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            p29.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            p29.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            p29.e(getResources().getString(R.string.obfuscated_res_0x7f0f1434));
                            return;
                        } else {
                            p29.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.z0.l1()) {
                antiData.setBlock_forum_name(this.z0.y1().k().getName());
                antiData.setBlock_forum_id(this.z0.y1().k().getId());
                antiData.setUser_name(this.z0.y1().U().getUserName());
                antiData.setUser_id(this.z0.y1().U().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void Z6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048652, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            j55 j55Var = this.M0;
            if (j55Var != null && j55Var.isShowing()) {
                this.M0.dismiss();
                this.M0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            l55 l55Var = new l55(getContext());
            l55Var.q(new g0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i3 == 1) {
                arrayList.add(new h55(0, getResources().getString(R.string.obfuscated_res_0x7f0f053f), l55Var));
            }
            if (z3) {
                arrayList.add(new h55(1, getResources().getString(R.string.un_mute), l55Var));
            } else {
                arrayList.add(new h55(1, getResources().getString(R.string.obfuscated_res_0x7f0f0ccc), l55Var));
            }
            l55Var.l(arrayList);
            j55 j55Var2 = new j55(getPageContext(), l55Var);
            this.M0 = j55Var2;
            j55Var2.l();
        }
    }

    public final void j7(ey9 ey9Var, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048688, this, ey9Var, z3) == null) {
            L6(false);
            if (ey9Var == null || (pbModel = this.z0) == null || pbModel.y1() == null || ey9Var.D() == 1) {
                return;
            }
            String R1 = this.z0.R1();
            String O = ey9Var.O();
            if (this.z0.y1() != null) {
                i3 = this.z0.y1().V();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e x6 = x6(O);
            if (x6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo h02 = ey9Var.h0();
            AntiData c4 = this.z0.y1().c();
            if (ey9Var.p() != null) {
                arrayList = ey9Var.p().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(R1, O, "pb", true, false, null, false, null, i3, h02, c4, false, arrayList, 5).addBigImageData(x6.a, x6.b, x6.g, x6.j);
            addBigImageData.setKeyPageStartFrom(this.z0.x1());
            addBigImageData.setFromFrsForumId(this.z0.getFromForumId());
            addBigImageData.setWorksInfoData(this.z0.W1());
            addBigImageData.setKeyFromForumId(this.z0.getForumId());
            addBigImageData.setBjhData(this.z0.Q0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void l5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048693, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(s79.j2)).intValue();
            if (intValue == s79.k2) {
                if (this.C0.n0()) {
                    return;
                }
                this.H0.n4();
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
                    this.C0.p0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.C0.q0(this.z0.y1().k().getId(), this.z0.y1().k().getName(), this.z0.y1().N().getId(), str, intValue3, intValue2, booleanValue, this.z0.y1().N().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == s79.l2 || intValue == s79.n2) {
                PbModel pbModel = this.z0;
                if (pbModel != null && pbModel.T0() != null) {
                    this.z0.T0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == s79.l2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void o5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048703, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            s79 s79Var = this.H0;
            if (s79Var != null && this.z0 != null) {
                if ((s79Var == null || s79Var.R1()) && this.z0.y1() != null && this.z0.y1().R() != null) {
                    s79 s79Var2 = this.H0;
                    if (s79Var2 != null && s79Var2.P0() != null && this.H0.P0().t()) {
                        return;
                    }
                    a49 R = this.z0.y1().R();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!R.d() || R.a() != 2) && this.H0.I0() != null && this.H0.I0().B() != null) {
                        this.H0.I0().B().x(this.z0.R1(), this.z0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        n29 n29Var = new n29(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.z0;
                        n29Var.m(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        n29Var.l(new n0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void R5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.g1);
            userMuteAddAndDelCustomMessage.setTag(this.g1);
            g7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void S6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048626, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new y1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                f7(str);
            } else {
                this.H0.l4(str);
            }
        }
    }

    @Override // com.baidu.tieba.s16
    public void e0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048665, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.O0 = str;
            if (this.k == null) {
                Z5();
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

    public final void U6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            o99.e(getActivity(), getPageContext(), new e1(this, sparseArray, i3, z3), new f1(this));
        }
    }

    public final void X4() {
        PbModel pbModel;
        j39 j39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (pbModel = this.z0) != null && (j39Var = pbModel.G) != null && j39Var.N() != null) {
            ThreadData N = this.z0.G.N();
            N.mRecomAbTag = this.z0.D1();
            N.mRecomWeight = this.z0.G1();
            N.mRecomSource = this.z0.F1();
            N.mRecomExtra = this.z0.E1();
            N.isSubPb = this.z0.l1();
            if (N.getFid() == 0) {
                N.setFid(tg.g(this.z0.getForumId(), 0L));
            }
            StatisticItem i3 = pr5.i(getContext(), N, "c13562");
            TbPageTag l3 = pr5.l(getContext());
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

    public final void l6() {
        MarkData P0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048694, this) == null) && this.B0 != null) {
            if (this.z0.y1() != null && this.z0.y1().i0()) {
                P0 = this.z0.P0(0);
            } else {
                P0 = this.z0.P0(this.H0.Z0());
            }
            if (P0 == null) {
                return;
            }
            if (P0.isApp() && (P0 = this.z0.P0(this.H0.Z0() + 1)) == null) {
                return;
            }
            this.H0.x3();
            this.B0.i(P0);
            if (!this.B0.e()) {
                if (this.H0 != null && this.z0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !s99.h(this.z0.b)) {
                    this.H0.f4();
                    s99.b(this.z0.b);
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
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.f = true;
            super.onPause();
            r99.a();
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
            s79 s79Var = this.H0;
            if (s79Var != null) {
                s79Var.q2();
            }
            if (this.W0 != null && !this.z0.l1()) {
                this.W0.O(this.z0.R1());
            }
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                pbModel.A2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            eu4.w().E();
            MessageManager.getInstance().unRegisterListener(this.B1);
            H6();
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            rf5 rf5Var = this.j0;
            if (rf5Var != null) {
                rf5Var.q();
                this.j0.p();
            }
        }
    }

    public final void Z4(j39 j39Var, ArrayList<ey9> arrayList) {
        List<ey9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048650, this, j39Var, arrayList) == null) && j39Var != null && j39Var.S() != null && j39Var.S().a != null && (list = j39Var.S().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<ey9> it = arrayList.iterator();
                while (it.hasNext()) {
                    ey9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            ey9 ey9Var = (ey9) it2.next();
                            if (ey9Var != null && !TextUtils.isEmpty(next.O()) && !TextUtils.isEmpty(ey9Var.O()) && next.O().equals(ey9Var.O())) {
                                arrayList2.add(ey9Var);
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

    public final void q5(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048729, this, i3, gVar) != null) || gVar == null) {
            return;
        }
        this.H0.E0(this.C0.getLoadDataMode(), gVar.a, gVar.b, false);
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
                this.z0.y1().N().setIs_good(1);
                this.z0.Z2(1);
            } else if (i3 == 3) {
                this.z0.y1().N().setIs_good(0);
                this.z0.Z2(0);
            } else if (i3 == 4) {
                this.z0.y1().N().setIs_top(1);
                this.z0.a3(1);
            } else if (i3 == 5) {
                this.z0.y1().N().setIs_top(0);
                this.z0.a3(0);
            }
            this.H0.v4(this.z0.y1(), this.z0.Q1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        vi.Q(getPageContext().getPageActivity(), string);
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048651, this) != null) || this.k != null) {
            return;
        }
        this.k = new c55(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        c55 c55Var = this.k;
        c55Var.j(strArr, new q0(this));
        c55Var.g(c55.b.a);
        c55Var.h(17);
        c55Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f5(AgreeData agreeData) {
        kr5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048670, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new h95();
        }
        if (this.i0 == null) {
            ux9 ux9Var = new ux9();
            this.i0 = ux9Var;
            ux9Var.a = getUniqueId();
        }
        l15 l15Var = new l15();
        l15Var.b = 5;
        l15Var.h = 8;
        l15Var.g = 2;
        if (Q() != null) {
            l15Var.f = Q().x1();
        }
        l15Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                l15Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i3, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.z0;
                if (pbModel == null && pbModel.y1() != null) {
                    this.e0.b(V(), l15Var, agreeData, this.z0.y1().N());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            l15Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            l15Var.i = 1;
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

    @Override // com.baidu.tieba.cb9
    public void finish() {
        s79 s79Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            s79 s79Var2 = this.H0;
            if (s79Var2 != null) {
                s79Var2.v0();
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.y1() != null && !this.z0.y1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.z0.y1().N().getId();
                if (this.z0.isShareThread() && this.z0.y1().N().originalThreadData != null) {
                    historyMessage.threadName = this.z0.y1().N().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.z0.y1().N().getTitle();
                }
                if (this.z0.isShareThread() && !z0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.z0.y1().k().getName();
                }
                ArrayList<ey9> F = this.z0.y1().F();
                s79 s79Var3 = this.H0;
                if (s79Var3 != null) {
                    i3 = s79Var3.R0();
                } else {
                    i3 = 0;
                }
                if (F != null && i3 >= 0 && i3 < F.size()) {
                    historyMessage.postID = F.get(i3).O();
                }
                historyMessage.isHostOnly = this.z0.b1();
                historyMessage.isSquence = this.z0.Q1();
                historyMessage.isShareThread = this.z0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && (pbModel2.d1() || this.z0.g1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.z0.R1());
                if (this.I0) {
                    if (this.K0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.z0.m1());
                    }
                    if (this.J0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.z0.i1());
                    }
                }
                if (this.z0.y1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.z0.y1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.p1);
                }
                this.a.setResult(-1, intent);
            }
            if (m7()) {
                if (this.z0 != null && (s79Var = this.H0) != null && s79Var.a1() != null) {
                    j39 y12 = this.z0.y1();
                    if (y12 != null) {
                        if (y12.U() != null) {
                            y12.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            y12.U().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!y12.r0() && !this.I && y12.h == null) {
                            i79 b4 = i79.b();
                            j39 z12 = this.z0.z1();
                            Parcelable onSaveInstanceState = this.H0.a1().onSaveInstanceState();
                            boolean Q1 = this.z0.Q1();
                            boolean b12 = this.z0.b1();
                            if (this.H0.i1() != null && this.H0.i1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(z12, onSaveInstanceState, Q1, b12, z3);
                            if (this.o1 >= 0 || this.z0.T1() != null) {
                                i79.b().o(this.z0.T1());
                                i79.b().p(this.z0.U1());
                                i79.b().m(this.z0.r1());
                            }
                        }
                    }
                } else {
                    i79.b().k();
                }
                l7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        da9 da9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            gw9.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.z0.y1().l());
                statisticItem.param("tid", this.z0.R1());
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
                if (this.z0.u1() != null) {
                    this.z0.u1().d();
                }
            }
            wj5 wj5Var = this.W0;
            if (wj5Var != null) {
                wj5Var.E();
                this.W0 = null;
            }
            ForumManageModel forumManageModel = this.C0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.i0();
            }
            s79 s79Var = this.H0;
            if (s79Var != null) {
                s79Var.l2();
                da9 da9Var2 = this.H0.k;
                if (da9Var2 != null) {
                    da9Var2.r();
                }
            }
            hs5 hs5Var = this.s;
            if (hs5Var != null) {
                hs5Var.c();
            }
            z89 z89Var = this.e;
            if (z89Var != null) {
                z89Var.k();
            }
            kg<TextView> kgVar = this.y;
            if (kgVar != null) {
                kgVar.c();
            }
            kg<FestivalTipView> kgVar2 = this.H;
            if (kgVar2 != null) {
                kgVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            s79 s79Var2 = this.H0;
            if (s79Var2 != null) {
                s79Var2.v0();
            }
            if (this.V1 != null) {
                wg.a().removeCallbacks(this.V1);
            }
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.n2);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.c2);
            this.e1 = null;
            this.f1 = null;
            on9.e().g();
            if (this.h1 != null) {
                wg.a().removeCallbacks(this.h1);
            }
            s79 s79Var3 = this.H0;
            if (s79Var3 != null && (da9Var = s79Var3.k) != null) {
                da9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.G0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            v79 v79Var = this.L0;
            if (v79Var != null) {
                v79Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && pbModel2.M0() != null) {
                this.z0.M0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            s79 s79Var4 = this.H0;
            if (s79Var4 != null) {
                s79Var4.o4();
            }
            m99 m99Var = this.u0;
            if (m99Var != null) {
                m99Var.e();
            }
        }
    }

    public final void g7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048676, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.H0.S3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            a55 a55Var = new a55(this.e1.getPageActivity());
            if (!ui.isEmpty(str)) {
                a55Var.setMessage(str);
            } else {
                a55Var.setMessage(this.e1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            a55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04bb, new f(this, userMuteAddAndDelCustomMessage));
            a55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new g(this));
            a55Var.create(this.e1).show();
        }
    }

    public final boolean h5(View view2) {
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
        List<h55> c4;
        int i3;
        boolean z20;
        h55 h55Var;
        h55 h55Var2;
        h55 h55Var3;
        h55 h55Var4;
        h55 h55Var5;
        h55 h55Var6;
        gn gnVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            s79 s79Var = this.H0;
            if (s79Var != null) {
                if (s79Var.T1()) {
                    return true;
                }
                this.H0.F0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (r79.y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.j1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.k1 = url;
                        if (this.j1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.l1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.m1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.m1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.j1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.k1 = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.m1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.m1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.j1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.k1 = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.m1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.m1 = null;
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
                        this.H0.X3(this.D2, this.j1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            ey9 ey9Var = (ey9) sparseArray.get(R.id.tag_clip_board);
            this.B2 = ey9Var;
            if (ey9Var == null) {
                return true;
            }
            if (ey9Var.D() == 1 && r79.y(view2)) {
                this.H0.X3(this.D2, this.j1.t());
                return true;
            }
            dx4 dx4Var = this.B0;
            if (dx4Var == null) {
                return true;
            }
            if (dx4Var.e() && this.B2.O() != null && this.B2.O().equals(this.z0.t1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (Q().y1() != null && Q().y1().i0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (Q().y1() != null && Q().y1().o0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (Q().y1() != null && Q().y1().n0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.B2.D() == 1) {
                if (!z4) {
                    this.H0.Y3(this.C2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.N0 == null) {
                l55 l55Var = new l55(getContext());
                this.N0 = l55Var;
                l55Var.q(this.g2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (r79.y(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (r79.y(view2) && (gnVar = this.j1) != null && !gnVar.t()) {
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
                    arrayList.add(new h55(1, getString(R.string.save_to_emotion), this.N0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new h55(2, getString(R.string.save_to_local), this.N0));
                }
                if (!z7 && !z8) {
                    h55 h55Var7 = new h55(3, getString(R.string.obfuscated_res_0x7f0f04db), this.N0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.B2);
                    h55Var7.d.setTag(sparseArray3);
                    arrayList.add(h55Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        h55Var6 = new h55(4, getString(R.string.remove_mark), this.N0);
                    } else {
                        h55Var6 = new h55(4, getString(R.string.obfuscated_res_0x7f0f0c27), this.N0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.B2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    h55Var6.d.setTag(sparseArray4);
                    arrayList.add(h55Var6);
                }
                if (this.mIsLogin) {
                    if (!o99.j(this.z0) && !z12 && z11) {
                        h55 h55Var8 = new h55(5, getString(R.string.obfuscated_res_0x7f0f0cd0), this.N0);
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
                        h55Var8.d.setTag(sparseArray5);
                        arrayList.add(h55Var8);
                    } else {
                        if (r79.C(this.z0.y1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            h55 h55Var9 = new h55(5, getString(R.string.report_text), this.N0);
                            h55Var9.d.setTag(str);
                            arrayList.add(h55Var9);
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
                        if (!o99.j(this.z0) && z18) {
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
                                h55Var5 = new h55(6, getString(R.string.obfuscated_res_0x7f0f053f), this.N0);
                                h55Var5.d.setTag(sparseArray6);
                                h55Var2 = new h55(7, getString(R.string.obfuscated_res_0x7f0f031f), this.N0);
                                h55Var2.d.setTag(sparseArray6);
                                h55Var3 = h55Var5;
                                h55Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        h55Var5 = null;
                        h55Var2 = new h55(7, getString(R.string.obfuscated_res_0x7f0f031f), this.N0);
                        h55Var2.d.setTag(sparseArray6);
                        h55Var3 = h55Var5;
                        h55Var = null;
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
                        if (this.z0.y1().V() == 1002 && !z10) {
                            h55Var4 = new h55(6, getString(R.string.report_text), this.N0);
                        } else {
                            h55Var4 = new h55(6, getString(R.string.obfuscated_res_0x7f0f053f), this.N0);
                        }
                        h55Var4.d.setTag(sparseArray7);
                        if (z17) {
                            h55Var = new h55(13, getString(R.string.multi_delete), this.N0);
                            h55Var3 = h55Var4;
                        } else {
                            h55Var3 = h55Var4;
                            h55Var = null;
                        }
                        h55Var2 = null;
                    } else {
                        h55Var = null;
                        h55Var2 = null;
                        h55Var3 = null;
                    }
                    if (h55Var3 != null) {
                        arrayList.add(h55Var3);
                    }
                    if (h55Var != null) {
                        arrayList.add(h55Var);
                    }
                    if (h55Var2 != null) {
                        arrayList.add(h55Var2);
                    }
                    o99.b(arrayList, this.N0, this.B2, this.z0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = o99.d(arrayList, this.B2.n(), sparseArray, this.N0);
                } else {
                    c4 = o99.c(arrayList, this.B2.n(), sparseArray, this.N0);
                }
                o99.m(c4, this.b);
                o99.f(c4);
                this.N0.r(o99.h(this.B2));
                this.N0.m(c4, !UbsABTestHelper.isPBPlanA());
                this.M0 = new j55(getPageContext(), this.N0);
                this.N0.p(new v2(this));
                this.M0.l();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.z0.b).param("fid", this.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.z0.W());
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

    public void i5(ForumManageModel.b bVar, s79 s79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048682, this, bVar, s79Var) == null) {
            List<ey9> list = this.z0.y1().S().a;
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
                s79Var.Q1(this.z0.y1());
            }
        }
    }

    public final void i6(View view2, String str, String str2, ey9 ey9Var) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048683, this, view2, str, str2, ey9Var) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (b5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!d5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Y);
                        this.Z = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (L5().k1() != null && ey9Var != null) {
                        if (ey9Var.a0() != null) {
                            str3 = ey9Var.a0().toString();
                        } else {
                            str3 = "";
                        }
                        L5().k1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), ey9Var.p().getName_show(), str3));
                    }
                    if (this.z0.y1() != null && this.z0.y1().i0()) {
                        wg.a().postDelayed(new h1(this, str, str2), 0L);
                        return;
                    } else {
                        wg.a().postDelayed(new i1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void m5(a55 a55Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048696, this, a55Var, jSONArray) == null) {
            a55Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(a55Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                l5((SparseArray) a55Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText t7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048740, this, str, i3)) == null) {
            PbModel pbModel = this.z0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.y1() == null || str == null || i3 < 0) {
                return null;
            }
            j39 y12 = this.z0.y1();
            if (y12.i() != null) {
                ArrayList<ey9> arrayList = new ArrayList<>();
                arrayList.add(y12.i());
                tbRichText = y5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<ey9> F = y12.F();
                Z4(y12, F);
                return y5(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void n5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048699, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(s79.j2, Integer.valueOf(s79.k2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                l5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            wj5 wj5Var = this.W0;
            if (wj5Var != null) {
                wj5Var.D(i3, i4, intent);
            }
            if (L5().k1() != null) {
                L5().k1().k(i3, i4, intent);
            }
            if (i3 == 25035) {
                Q5(i4, intent);
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
                                                    View view3 = this.f1148T;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    s79 s79Var = this.H0;
                                                    if (s79Var != null && s79Var.K0() != null) {
                                                        this.H0.K0().performClick();
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
                                        this.H0.z3(false);
                                        if (this.z0.y1() != null && this.z0.y1().N() != null && this.z0.y1().N().getPushStatusData() != null) {
                                            this.z0.y1().N().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        gl9.g().m(getPageContext());
                                        q7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.G0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                            shareSuccessReplyToServerModel.U(str, intExtra, new f2(this));
                                        }
                                        if (b6()) {
                                            o7(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.R;
                                if (view5 != null) {
                                    this.H0.P3(view5);
                                    return;
                                }
                                return;
                            }
                            T5(intent);
                            return;
                        }
                        gl9.g().m(getPageContext());
                        return;
                    }
                    i79.b().k();
                    this.y0.postDelayed(new e2(this), 1000L);
                    return;
                }
                l6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        s79 s79Var;
        s79 s79Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.e1 = getPageContext();
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
                this.M2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.N2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.O2 = intent.getStringExtra("key_manga_title");
                this.R0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.S0 = intent.getStringExtra("high_light_post_id");
                this.T0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (B5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (ui.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.p1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                t35 t35Var = new t35();
                this.c0 = t35Var;
                t35Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.r1 = intExtra;
                if (intExtra == 0) {
                    this.r1 = intent.getIntExtra("key_start_from", 0);
                }
                this.Q2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            g6(bundle);
            if (this.z0.y1() != null) {
                this.z0.y1().S0(this.P);
            }
            Y5();
            if (intent != null && (s79Var2 = this.H0) != null) {
                s79Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new k0(this, intent);
                    }
                    wg.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.z0.y1() != null) {
                    this.z0.e3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            X5(bundle);
            yj5 yj5Var = new yj5();
            this.V0 = yj5Var;
            O6(yj5Var);
            wj5 wj5Var = (wj5) this.V0.a(getActivity());
            this.W0 = wj5Var;
            wj5Var.X(this.a.getPageContext());
            this.W0.g0(this.k2);
            this.W0.h0(this.Z0);
            this.W0.Z(1);
            this.W0.B(this.a.getPageContext(), bundle);
            this.W0.b().b(new di5(getActivity()));
            this.W0.b().E(true);
            R6(true);
            this.W0.K(this.z0.a1(), this.z0.R1(), this.z0.W0());
            registerListener(this.y1);
            if (!this.z0.l1()) {
                this.W0.q(this.z0.R1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.z0.h2()) {
                this.W0.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                s79 s79Var3 = this.H0;
                if (s79Var3 != null) {
                    this.W0.d0(s79Var3.l1());
                }
            }
            this.G = new PbGodGuideController();
            getLifecycle().addObserver(this.G);
            registerListener(this.x1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.w1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.q2);
            registerListener(this.v1);
            vx9 vx9Var = new vx9("pb", vx9.d);
            this.U0 = vx9Var;
            vx9Var.d();
            registerListener(this.G1);
            registerListener(this.Q1);
            this.z0.B2();
            registerListener(this.p2);
            registerListener(this.d2);
            registerListener(this.j2);
            registerListener(this.M1);
            registerListener(this.c2);
            registerListener(this.H1);
            s79 s79Var4 = this.H0;
            if (s79Var4 != null && s79Var4.r1() != null && this.H0.p1() != null) {
                z89 z89Var = new z89(getActivity(), this.H0.r1(), this.H0.p1(), this.H0.i1());
                this.e = z89Var;
                z89Var.t(this.P1);
            }
            if (this.c && (s79Var = this.H0) != null && s79Var.p1() != null) {
                this.H0.p1().setVisibility(8);
            }
            q95 q95Var = new q95();
            this.f1 = q95Var;
            q95Var.a = 1000L;
            registerListener(this.Z1);
            registerListener(this.Y1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.J1);
            registerListener(this.K1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.E1);
            this.I1.setSelfListener(true);
            this.I1.setTag(this.a.getUniqueId());
            this.I1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.I1);
            registerResponsedEventListener(TipEvent.class, this.R1);
            registerResponsedEventListener(TopToastEvent.class, this.S1);
            this.g1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.g1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.T1 = new f3(this.H0, this);
            this.z0.S0().Y(this.T1);
            this.L0 = new v79();
            if (this.W0.s() != null) {
                this.L0.m(this.W0.s().i());
            }
            this.W0.W(this.a1);
            this.G0 = new ShareSuccessReplyToServerModel();
            V4(this.t1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new l0(this));
            ea9 ea9Var = new ea9(getContext());
            this.A0 = ea9Var;
            ea9Var.b(getUniqueId());
            gw9.g().i(getUniqueId());
            a15.b().l("3", "");
            this.s1 = new en6(getPageContext());
            this.u0 = new m99(this, getUniqueId(), this.H0, this.z0);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048713, this, layoutInflater, viewGroup, bundle)) == null) {
            this.H0 = new s79(this, this.i2, this.U1, this.h2);
            kw6 kw6Var = new kw6(getActivity());
            this.d = kw6Var;
            kw6Var.i(S2);
            this.d.d(this.K2);
            this.H0.q3(this.s2);
            this.H0.p3(this.x2);
            this.H0.j3(this.u2);
            this.H0.k3(this.v2);
            this.H0.h3(n05.c().g());
            this.H0.n3(this.z2);
            this.H0.t3(this.F2);
            this.H0.r3(this.G2);
            this.H0.o3(this.I2);
            this.H0.r4(this.mIsLogin);
            this.H0.f3(this.z0.f2());
            if (this.a.getIntent() != null) {
                this.H0.g3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.H0.j1().setFromForumId(this.z0.getFromForumId());
            wj5 wj5Var = this.W0;
            if (wj5Var != null) {
                this.H0.X2(wj5Var.b());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.W0.d0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.W0.d0(this.H0.l1());
                }
            }
            this.H0.b3(this.f2);
            this.H0.e3(this.z0.g1());
            this.H0.s3(this.z0.x1());
            this.u0.f(this.H0, this.z0);
            if ("1".equals(Q().showReplyPanel)) {
                this.H0.s2();
            }
            return this.H0.s1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText y5(ArrayList<ey9> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048753, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText a02 = arrayList.get(i4).a0();
                    if (a02 != null && (W = a02.W()) != null) {
                        int size = W.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (W.get(i6) != null && W.get(i6).getType() == 8) {
                                i5++;
                                if (!W.get(i6).c0().V().equals(str) && !W.get(i6).c0().W().equals(str)) {
                                    if (i5 > i3) {
                                        break;
                                    }
                                } else {
                                    int i7 = (int) vi.i(TbadkCoreApplication.getInst());
                                    int width = W.get(i6).c0().getWidth() * i7;
                                    int height = W.get(i6).c0().getHeight() * i7;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.y2 = i6;
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

    public final void p5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048727, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                a55 a55Var = new a55(getPageContext().getPageActivity());
                a55Var.setMessage(string);
                a55Var.setPositiveButton(R.string.dialog_known, new a2(this));
                a55Var.setCancelable(true);
                a55Var.create(getPageContext());
                a55Var.show();
            } else if (bVar.d != 0) {
                this.H0.E0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<ey9> F = this.z0.y1().F();
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
                    this.z0.y1().N().setReply_num(this.z0.y1().N().getReply_num() - 1);
                    this.H0.Q1(this.z0.y1());
                } else if (i4 == 0) {
                    g5();
                } else if (i4 == 2) {
                    ArrayList<ey9> F2 = this.z0.y1().F();
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
                        this.H0.Q1(this.z0.y1());
                    }
                    i5(bVar, this.H0);
                }
            }
        }
    }

    public void s6() {
        PbModel pbModel;
        j39 y12;
        ThreadData N;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        j39 j39Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && (pbModel = this.z0) != null && pbModel.y1() != null && (N = (y12 = this.z0.y1()).N()) != null && N.getAuthor() != null) {
            this.H0.w1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.getAuthor().getUserId());
            b79 b79Var = new b79();
            int V = this.z0.y1().V();
            if (V != 1 && V != 3) {
                b79Var.g = false;
            } else {
                b79Var.g = true;
                if (N.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                b79Var.s = z3;
            }
            if (r79.z(this.z0.y1(), V)) {
                b79Var.h = true;
                if (N.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                b79Var.r = z9;
            } else {
                b79Var.h = false;
            }
            if (V == 1002 && !equals) {
                b79Var.u = true;
            }
            b79Var.n = r79.M(N.isBlocked(), y12.m0(), equals, V, N.isWorksInfo(), N.isScoreThread());
            b79Var.e = r79.K(y12, equals, y12.m0(), this.z0.c0());
            b79Var.i = W6();
            b79Var.f = r79.L(this.z0.y1(), equals, this.z0.c0());
            if (equals && y12.U() != null && y12.U().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            b79Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                b79Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            b79Var.t = equals;
            b79Var.q = this.z0.Q1();
            b79Var.b = true;
            b79Var.a = r79.C(this.z0.y1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            b79Var.p = z5;
            b79Var.j = true;
            b79Var.o = this.z0.b1();
            b79Var.d = true;
            if (N.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            b79Var.c = z6;
            if (y12.i0()) {
                b79Var.b = false;
                b79Var.d = false;
                b79Var.c = false;
                b79Var.g = false;
                b79Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !y12.i0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            b79Var.v = z7;
            if (this.H0 != null && (j39Var = this.z0.G) != null) {
                ey9 W = j39Var.W();
                if (W != null) {
                    z8 = W.S;
                } else {
                    z8 = false;
                }
                b79Var.w = z8;
            }
            b79Var.m = true;
            if (N.isBlocked()) {
                b79Var.n = false;
                b79Var.g = false;
                b79Var.h = false;
            }
            this.H0.k.x(b79Var);
        }
    }

    public final void v6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048746, this, str, i3, eVar) != null) || eVar == null) {
            return;
        }
        j39 y12 = this.z0.y1();
        TbRichText t7 = t7(str, i3);
        if (t7 == null || (tbRichTextData = t7.W().get(this.y2)) == null) {
            return;
        }
        eVar.f = String.valueOf(t7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.c0().a0()) {
            eVar.h = false;
            String a4 = k39.a(tbRichTextData);
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
            imageUrlData.originalUrl = r79.n(tbRichTextData);
            imageUrlData.originalUrl = r79.n(tbRichTextData);
            imageUrlData.originalSize = r79.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = r79.k(tbRichTextData);
            imageUrlData.isLongPic = r79.j(tbRichTextData);
            imageUrlData.postId = t7.getPostId();
            imageUrlData.mIsReserver = this.z0.J1();
            imageUrlData.mIsSeeHost = this.z0.b1();
            eVar.b.put(a4, imageUrlData);
            if (y12 != null) {
                if (y12.k() != null) {
                    eVar.c = y12.k().getName();
                    eVar.d = y12.k().getId();
                }
                if (y12.N() != null) {
                    eVar.e = y12.N().getId();
                }
                if (y12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = tg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = y12.F().size();
        this.A2 = false;
        eVar.j = -1;
        if (y12.i() != null) {
            i4 = z5(y12.i().a0(), t7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            ey9 ey9Var = y12.F().get(i7);
            if (ey9Var.O() == null || y12.i() == null || y12.i().O() == null || !ey9Var.O().equals(y12.i().O())) {
                i6 = z5(ey9Var.a0(), t7, i6, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (y12 != null) {
            if (y12.k() != null) {
                eVar.c = y12.k().getName();
                eVar.d = y12.k().getId();
            }
            if (y12.N() != null) {
                eVar.e = y12.N().getId();
            }
            if (y12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i6;
    }

    public final int z5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo c02;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048757, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.A2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.W().size();
                int i6 = i3;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.W().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int i9 = (int) vi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.c0().getWidth() * i9;
                        int height = tbRichTextData.c0().getHeight() * i9;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.c0().a0()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = k39.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (c02 = tbRichTextData.c0()) != null) {
                                        String V = c02.V();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            V = c02.W();
                                        } else {
                                            if (this.q) {
                                                i5 = 17;
                                            } else {
                                                i5 = 18;
                                            }
                                            imageUrlData.urlType = i5;
                                        }
                                        imageUrlData.imageUrl = V;
                                        imageUrlData.imageThumbUrl = V;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = r79.n(tbRichTextData);
                                        imageUrlData.originalSize = r79.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = r79.k(tbRichTextData);
                                        imageUrlData.isLongPic = r79.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = tg.g(this.z0.R1(), -1L);
                                        imageUrlData.mIsReserver = this.z0.J1();
                                        imageUrlData.mIsSeeHost = this.z0.b1();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.A2) {
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
}
