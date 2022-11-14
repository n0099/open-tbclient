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
import androidx.lifecycle.ViewModelProviders;
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
import com.baidu.tbadk.core.atomData.ForumUserLiveActiivtyConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
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
import com.baidu.tieba.a18;
import com.baidu.tieba.a65;
import com.baidu.tieba.aa6;
import com.baidu.tieba.ah;
import com.baidu.tieba.an5;
import com.baidu.tieba.b35;
import com.baidu.tieba.be5;
import com.baidu.tieba.bo;
import com.baidu.tieba.bp8;
import com.baidu.tieba.br4;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp8;
import com.baidu.tieba.ct4;
import com.baidu.tieba.cy6;
import com.baidu.tieba.cy7;
import com.baidu.tieba.d55;
import com.baidu.tieba.d65;
import com.baidu.tieba.eu4;
import com.baidu.tieba.ew4;
import com.baidu.tieba.ey7;
import com.baidu.tieba.g45;
import com.baidu.tieba.go5;
import com.baidu.tieba.gy7;
import com.baidu.tieba.h08;
import com.baidu.tieba.h18;
import com.baidu.tieba.hz4;
import com.baidu.tieba.in;
import com.baidu.tieba.iz4;
import com.baidu.tieba.j36;
import com.baidu.tieba.j85;
import com.baidu.tieba.jf8;
import com.baidu.tieba.jv4;
import com.baidu.tieba.k38;
import com.baidu.tieba.k45;
import com.baidu.tieba.k65;
import com.baidu.tieba.k85;
import com.baidu.tieba.km4;
import com.baidu.tieba.kp4;
import com.baidu.tieba.kp8;
import com.baidu.tieba.l05;
import com.baidu.tieba.l08;
import com.baidu.tieba.l45;
import com.baidu.tieba.l85;
import com.baidu.tieba.l95;
import com.baidu.tieba.lm4;
import com.baidu.tieba.lv4;
import com.baidu.tieba.lw8;
import com.baidu.tieba.ly4;
import com.baidu.tieba.m38;
import com.baidu.tieba.m45;
import com.baidu.tieba.m85;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n38;
import com.baidu.tieba.nj5;
import com.baidu.tieba.nn8;
import com.baidu.tieba.nr4;
import com.baidu.tieba.ns4;
import com.baidu.tieba.o28;
import com.baidu.tieba.o38;
import com.baidu.tieba.o85;
import com.baidu.tieba.og;
import com.baidu.tieba.oi5;
import com.baidu.tieba.oq8;
import com.baidu.tieba.ot5;
import com.baidu.tieba.ow8;
import com.baidu.tieba.ox7;
import com.baidu.tieba.p38;
import com.baidu.tieba.p45;
import com.baidu.tieba.p48;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pg;
import com.baidu.tieba.ph8;
import com.baidu.tieba.pk5;
import com.baidu.tieba.px7;
import com.baidu.tieba.py4;
import com.baidu.tieba.py7;
import com.baidu.tieba.q18;
import com.baidu.tieba.q35;
import com.baidu.tieba.q85;
import com.baidu.tieba.q9;
import com.baidu.tieba.qb;
import com.baidu.tieba.qp8;
import com.baidu.tieba.qv4;
import com.baidu.tieba.qw7;
import com.baidu.tieba.qy7;
import com.baidu.tieba.r65;
import com.baidu.tieba.r9;
import com.baidu.tieba.rj5;
import com.baidu.tieba.s18;
import com.baidu.tieba.s28;
import com.baidu.tieba.se5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.si5;
import com.baidu.tieba.sp4;
import com.baidu.tieba.sv4;
import com.baidu.tieba.sw7;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tt4;
import com.baidu.tieba.ty7;
import com.baidu.tieba.u38;
import com.baidu.tieba.u65;
import com.baidu.tieba.ub5;
import com.baidu.tieba.ue5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uv4;
import com.baidu.tieba.uw7;
import com.baidu.tieba.uz7;
import com.baidu.tieba.v18;
import com.baidu.tieba.v38;
import com.baidu.tieba.v55;
import com.baidu.tieba.v58;
import com.baidu.tieba.v65;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vt4;
import com.baidu.tieba.vy4;
import com.baidu.tieba.w28;
import com.baidu.tieba.w65;
import com.baidu.tieba.wd5;
import com.baidu.tieba.x18;
import com.baidu.tieba.x28;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xm5;
import com.baidu.tieba.xn;
import com.baidu.tieba.y08;
import com.baidu.tieba.y18;
import com.baidu.tieba.ye5;
import com.baidu.tieba.yi;
import com.baidu.tieba.yr4;
import com.baidu.tieba.z48;
import com.baidu.tieba.z96;
import com.baidu.tieba.zs6;
import com.baidu.tieba.zu4;
import com.baidu.tieba.zy4;
import com.baidu.tieba.zz7;
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
public class PbFragment extends BaseFragment implements an5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, jv4.e, TbRichTextView.s, TbPageContextSupport, z48, v58.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k S2;
    public static final aa6.b T2;
    public transient /* synthetic */ FieldHolder $fh;
    public og<TbImageView> A;
    public gy7 A0;
    public CustomMessageListener A1;
    public int A2;
    public og<ImageView> B;
    public PollingModel B0;
    public CustomMessageListener B1;
    public final TbRichTextView.y B2;
    public og<View> C;
    public ShareSuccessReplyToServerModel C0;
    public final CustomMessageListener C1;
    public boolean C2;
    public og<TiebaPlusRecommendCard> D;
    public s18 D0;
    public CustomMessageListener D1;
    public PostData D2;
    public og<LinearLayout> E;
    public boolean E0;
    public CustomMessageListener E1;
    public final lv4.c E2;
    public og<RelativeLayout> F;
    public boolean F0;
    public View.OnClickListener F1;
    public final lv4.c F2;
    public og<ItemCardView> G;
    public boolean G0;
    public CustomMessageListener G1;
    public final AdapterView.OnItemClickListener G2;
    public boolean H;
    public v18 H0;
    public CustomMessageListener H1;
    public final View.OnLongClickListener H2;
    public boolean I;
    public sv4 I0;
    public CustomMessageListener I1;
    public final View.OnClickListener I2;
    public boolean J;
    public uv4 J0;
    public CustomMessageListener J1;
    public final ItemCardHelper.c J2;
    public og<GifView> K;
    public String K0;
    public CustomMessageListener K1;
    public final NoNetworkView.b K2;
    public String L;
    public boolean L0;
    public SuggestEmotionModel.c L1;
    public View.OnTouchListener L2;
    public boolean M;
    public boolean M0;
    public CustomMessageListener M1;
    public z96.b M2;
    public boolean N;
    public boolean N0;
    public GetSugMatchWordsModel.b N1;
    public final h08.b N2;
    public String O;
    public String O0;
    public boolean O1;
    public int O2;
    public LikeModel P;
    public boolean P0;
    public PraiseModel P1;
    public int P2;
    public View Q;
    public cp8 Q0;
    public x28.h Q1;
    public String Q2;
    public View R;
    public o85 R0;
    public CustomMessageListener R1;
    public ns4 R2;
    public View S;
    public m85 S0;
    public ub5 S1;
    public View T;
    public boolean T0;
    public ub5 T1;
    public String U;
    public PermissionJudgePolicy U0;
    public CheckRealNameModel.b U1;
    public int V;
    public ReplyPrivacyCheckController V0;
    public qy7 V1;
    public boolean W;
    public zs6 W0;
    public final Runnable W1;
    public int[] X;
    public zs6 X0;
    public CustomMessageListener X1;
    public int Y;
    public k85 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public j85 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public j85 a1;
    public CustomMessageListener a2;
    public boolean b;
    public eu4 b0;
    public int b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public Object c1;
    public CustomMessageListener c2;
    public aa6 d;
    public ly4 d0;
    public r9 d1;
    public CustomMessageListener d2;
    public x28 e;
    public boolean e0;
    public vy4 e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public BdUniqueId f1;
    public jv4.e f2;
    public boolean g;
    public Object g0;
    public Runnable g1;
    public h3 g2;
    public boolean h;
    public bp8 h0;
    public x18 h1;
    public uv4.e h2;
    public boolean i;
    public l45 i0;
    public in i1;
    public SortSwitchButton.f i2;
    public VoiceManager j;
    public boolean j0;
    public String j1;
    public final View.OnClickListener j2;
    public int k;
    public TbRichTextImageInfo k1;
    public CustomMessageListener k2;
    public lv4 l;
    public TbRichTextMemeInfo l1;
    public final NewWriteModel.d l2;
    public long m;
    public boolean m1;
    public Boolean m2;
    public long n;
    public int n1;
    public NewWriteModel.d n2;
    public long o;
    public int o1;
    public qb o2;
    public long p;
    public List<f3> p1;
    public final PbModel.h p2;
    public long q;
    public boolean q0;
    public int q1;
    public CustomMessageListener q2;
    public boolean r;
    @NonNull
    public TiePlusEventController.f r0;
    public String r1;
    public HttpMessageListener r2;
    public boolean s;
    public k38 s0;
    public j36 s1;
    public final kp4.a s2;
    public se5 t;
    public PbInterviewStatusView.f t0;
    public final f3 t1;
    public final AbsListView.OnScrollListener t2;
    public long u;
    public final Handler u0;
    public final y08.b u1;
    public final q9 u2;
    public boolean v;
    public PbModel v0;
    public final CustomMessageListener v1;
    public final i3 v2;
    public long w;
    public v38 w0;
    public CustomMessageListener w1;
    public final zy4.g w2;
    public int x;
    public kp4 x0;
    public CustomMessageListener x1;
    public final View.OnClickListener x2;
    public String y;
    public ForumManageModel y0;
    public CustomMessageListener y1;
    public boolean y2;
    public og<TextView> z;
    public q35 z0;
    public CustomMessageListener z1;
    public final BdListView.p z2;

    /* loaded from: classes5.dex */
    public interface f3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public interface h3 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public interface i3 {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.z48
    /* renamed from: C5 */
    public VideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.an5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048677, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.z48
    public PbFragment k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048726, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class k1 implements zs6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        @Override // com.baidu.tieba.zs6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.zs6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$k1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0390a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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

                public C0390a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    v18 v18Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (v18Var = this.a.a.c.H0) != null && v18Var.g() != null) {
                        if (!this.a.a.c.H0.g().e()) {
                            this.a.a.c.H0.b(false);
                        }
                        this.a.a.c.H0.g().l(false);
                    }
                }
            }

            public a(k1 k1Var) {
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

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int j = yi.j(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = j / 2;
                        g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i2 = j - (i + g);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.y5().T0().smoothScrollBy((pbFragment.X[1] + pbFragment.Y) - i2, 50);
                    if (this.a.c.y5().d1() != null) {
                        this.a.c.S0.b().setVisibility(8);
                        z = (this.a.c.v0 == null || this.a.c.v0.S1() == null || this.a.c.v0.S1().Q() == null || !this.a.c.v0.S1().Q().isBjh()) ? false : false;
                        l08 d1 = this.a.c.y5().d1();
                        k1 k1Var = this.a;
                        d1.o(k1Var.a, k1Var.b, k1Var.c.y5().f1(), z);
                        q85 b = this.a.c.y5().d1().b();
                        if (b != null && this.a.c.v0 != null && this.a.c.v0.S1() != null) {
                            b.H(this.a.c.v0.S1().d());
                            b.d0(this.a.c.v0.S1().Q());
                        }
                        if (this.a.c.H0.f() == null && this.a.c.y5().d1().b().u() != null) {
                            this.a.c.y5().d1().b().u().g(new C0390a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.H0.n(pbFragment2.y5().d1().b().u().i());
                            this.a.c.y5().d1().b().N(this.a.c.a1);
                        }
                    }
                    this.a.c.y5().p1();
                }
            }
        }

        public k1(PbFragment pbFragment, String str, String str2) {
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

        @Override // com.baidu.tieba.zs6.d
        public void b(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3);
                if (z) {
                    i = 5;
                } else {
                    i = 6;
                }
                TiebaStatic.log(param.param("obj_locate", i).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!z) {
                    return;
                }
                ah.a().postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

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

            public a(j1 j1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                v18 v18Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (v18Var = this.a.c.H0) != null && v18Var.g() != null) {
                    if (!this.a.c.H0.g().e()) {
                        this.a.c.H0.b(false);
                    }
                    this.a.c.H0.g().l(false);
                }
            }
        }

        public j1(PbFragment pbFragment, String str, String str2) {
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
                int j = yi.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.y5().T0().smoothScrollBy((pbFragment.X[1] + pbFragment.Y) - i2, 50);
                if (this.c.y5().d1() != null) {
                    this.c.S0.b().setVisibility(8);
                    this.c.y5().d1().o(this.a, this.b, this.c.y5().f1(), (this.c.v0 == null || this.c.v0.S1() == null || this.c.v0.S1().Q() == null || !this.c.v0.S1().Q().isBjh()) ? false : false);
                    q85 b = this.c.y5().d1().b();
                    if (b != null && this.c.v0 != null && this.c.v0.S1() != null) {
                        b.H(this.c.v0.S1().d());
                        b.d0(this.c.v0.S1().Q());
                    }
                    if (this.c.H0.f() == null && this.c.y5().d1().b().u() != null) {
                        this.c.y5().d1().b().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.H0.n(pbFragment2.y5().d1().b().u().i());
                        this.c.y5().d1().b().N(this.c.a1);
                    }
                }
                this.c.y5().p1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ j2 b;

            public a(j2 j2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = j2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ty7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                ah.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:783:0x1eb3, code lost:
            if (r9 == (r32.a.D0.e1().c().getHeight() - r32.a.D0.e1().e())) goto L829;
         */
        /* JADX WARN: Code restructure failed: missing block: B:821:0x2035, code lost:
            if (r32.a.D0.d1.c.getView().getTop() <= ((r32.a.D0.e1() == null || r32.a.D0.e1().c() == null) ? 0 : r32.a.D0.e1().c().getBottom())) goto L758;
         */
        /* JADX WARN: Code restructure failed: missing block: B:822:0x2037, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:824:0x2044, code lost:
            if (r0 >= com.baidu.tieba.o28.d(r32.a.s5())) goto L758;
         */
        /* JADX WARN: Code restructure failed: missing block: B:846:0x20eb, code lost:
            if ((r32.a.D0.d1.c.getView().getTop() - r32.a.D0.h.a.getBottom()) < (r32.a.D0.d1.c.g.getHeight() + 10)) goto L758;
         */
        /* JADX WARN: Removed duplicated region for block: B:1115:0x2a9b  */
        /* JADX WARN: Removed duplicated region for block: B:1116:0x2ab1  */
        /* JADX WARN: Removed duplicated region for block: B:1119:0x2aed  */
        /* JADX WARN: Removed duplicated region for block: B:1361:0x3494  */
        /* JADX WARN: Removed duplicated region for block: B:1362:0x3499  */
        /* JADX WARN: Removed duplicated region for block: B:1365:0x34a8  */
        /* JADX WARN: Removed duplicated region for block: B:1399:0x3556  */
        /* JADX WARN: Removed duplicated region for block: B:1402:0x3565  */
        /* JADX WARN: Removed duplicated region for block: B:1405:0x3578  */
        /* JADX WARN: Removed duplicated region for block: B:1408:0x3589  */
        /* JADX WARN: Removed duplicated region for block: B:1411:0x359f  */
        /* JADX WARN: Removed duplicated region for block: B:1413:0x35a8  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            ox7 S1;
            int i;
            int i2;
            PostData Z;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            qv4 qv4Var;
            qv4 qv4Var2;
            qv4 qv4Var3;
            PbFragment pbFragment;
            int i3;
            boolean z;
            qv4 qv4Var4;
            qv4 qv4Var5;
            qv4 qv4Var6;
            qv4 qv4Var7;
            String name;
            int i4;
            boolean z2;
            int fixedNavHeight;
            int i5;
            int i6;
            zu4 zu4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.q0 && (view2 == this.a.D0.h.c || view2 == this.a.D0.h.d || view2.getId() == R.id.obfuscated_res_0x7f091899 || view2.getId() == R.id.obfuscated_res_0x7f090a2d || view2.getId() == R.id.obfuscated_res_0x7f091c4a || view2.getId() == R.id.obfuscated_res_0x7f091834)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.D0.W0() && this.a.getPageContext().getPageActivity() != null && this.a.v0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.m2(), this.a.v0.C2(), this.a.v0.B2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.v0.getForumId());
                        statisticItem2.param("fname", this.a.v0.r1());
                        statisticItem2.param("tid", this.a.v0.m2());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.D0.Y0()) {
                        if (this.a.h) {
                            return;
                        }
                        if (this.a.v0.N2(true)) {
                            this.a.h = true;
                            this.a.D0.t3();
                        }
                    } else if (view2 == this.a.D0.h.m()) {
                        String string = StringUtils.string(view2.getTag(R.id.obfuscated_res_0x7f090aac));
                        String string2 = StringUtils.string(view2.getTag(R.id.obfuscated_res_0x7f090a97));
                        String string3 = StringUtils.string(view2.getTag(R.id.obfuscated_res_0x7f0921ed));
                        if (this.a.P != null) {
                            this.a.P.Q(string, string2);
                        }
                        TbPageTag l = be5.l(this.a.getContext());
                        p38.a("c14278", string2, string3, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().r()) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                            return;
                        }
                        this.a.D0.p0();
                        this.a.a7();
                        this.a.D0.s3();
                        this.a.D0.N3();
                        if (this.a.D0.b1() != null) {
                            this.a.D0.b1().setVisibility(8);
                        }
                        this.a.v0.F3(1);
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else if (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().k()) {
                        if (view2 == this.a.D0.h.f) {
                            if (this.a.D0.f0(this.a.v0.F1())) {
                                this.a.a7();
                                return;
                            }
                            this.a.i = false;
                            yi.z(this.a.a, this.a.D0.h.f);
                            this.a.a.finish();
                        } else if (view2 == this.a.D0.F0() || (this.a.D0.h.n() != null && (view2 == this.a.D0.h.n().s() || view2 == this.a.D0.h.n().t()))) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                return;
                            } else if (this.a.v0.S1() == null || this.a.y0.S()) {
                                return;
                            } else {
                                this.a.D0.p0();
                                int i9 = (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().t()) ? (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().s()) ? view2 == this.a.D0.F0() ? 2 : 0 : this.a.v0.S1().Q().getIs_good() == 1 ? 3 : 6 : this.a.v0.S1().Q().getIs_top() == 1 ? 5 : 4;
                                ForumData l2 = this.a.v0.S1().l();
                                String name3 = l2.getName();
                                String id = l2.getId();
                                String id2 = this.a.v0.S1().Q().getId();
                                this.a.D0.h4();
                                this.a.y0.W(id, name3, id2, i9, this.a.D0.G0());
                            }
                        } else if (view2 == this.a.D0.M0()) {
                            if (this.a.v0 != null) {
                                sp4.o(this.a.getPageContext().getPageActivity(), this.a.v0.S1().Q().getTopicData().b());
                            }
                        } else if (view2 == this.a.D0.h.c) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            if (this.a.v0.S1() != null && this.a.v0.S1().Q() != null && this.a.v0.S1().Q().isVideoThreadType() && this.a.v0.S1().Q().getThreadVideoInfo() != null) {
                                TiebaStatic.log(new StatisticItem("c11922"));
                            }
                            if (this.a.v0.getErrorNo() == 4) {
                                if (!StringUtils.isNull(this.a.v0.r1()) || this.a.v0.h1() == null) {
                                    this.a.a.finish();
                                    return;
                                }
                                name2 = this.a.v0.h1().b;
                            } else {
                                name2 = this.a.v0.S1().l().getName();
                            }
                            if (StringUtils.isNull(name2)) {
                                this.a.a.finish();
                                return;
                            }
                            String r1 = this.a.v0.r1();
                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                            if (!this.a.v0.x1() || r1 == null || !r1.equals(name2)) {
                                this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                            } else {
                                this.a.a.finish();
                            }
                        } else if (view2 == this.a.D0.h.d) {
                            if (oi5.a()) {
                                return;
                            }
                            if (this.a.v0 == null || this.a.v0.S1() == null) {
                                yi.P(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e27));
                                return;
                            }
                            ArrayList<PostData> H = this.a.v0.S1().H();
                            if ((H == null || H.size() <= 0) && this.a.v0.k2()) {
                                yi.P(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e27));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.v0.m2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.v0.getForumId()));
                            if (!this.a.D0.R1()) {
                                this.a.D0.N2();
                            }
                            this.a.j6();
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091858) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                return;
                            }
                            this.a.D0.c3(true);
                            this.a.D0.N2();
                            if (this.a.h) {
                                return;
                            }
                            this.a.h = true;
                            this.a.D0.X3();
                            this.a.a7();
                            this.a.D0.s3();
                            this.a.v0.J3(this.a.l5());
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09182f) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                return;
                            }
                            this.a.D0.p0();
                            if (view2.getId() != R.id.obfuscated_res_0x7f09182f || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                if (!q18.c(this.a.getPageContext(), 11009) || this.a.v0.i1(this.a.D0.S0()) == null) {
                                    return;
                                }
                                this.a.b6();
                                if (this.a.v0.S1() != null && this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.S1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getAuthor() != null && this.a.v0.S1().Q().getAuthor().getUserId() != null && this.a.x0 != null) {
                                    int w = q18.w(this.a.v0.S1());
                                    ThreadData Q = this.a.v0.S1().Q();
                                    if (Q.isBJHArticleThreadType()) {
                                        i8 = 2;
                                    } else if (Q.isBJHVideoThreadType()) {
                                        i8 = 3;
                                    } else if (Q.isBJHNormalThreadType()) {
                                        i8 = 4;
                                    } else {
                                        i8 = Q.isBJHVideoDynamicThreadType() ? 5 : 1;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v0.b).param("obj_locate", 1).param("obj_id", this.a.v0.S1().Q().getAuthor().getUserId()).param("obj_type", !this.a.x0.e()).param("obj_source", w).param("obj_param1", i8));
                                }
                            } else {
                                this.a.T = view2;
                                return;
                            }
                        } else if ((this.a.D0.h.n() != null && view2 == this.a.D0.h.n().p()) || view2.getId() == R.id.obfuscated_res_0x7f090a2d || view2.getId() == R.id.obfuscated_res_0x7f091c4a) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.D0.p0();
                            if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().p() && !this.a.D0.R1()) {
                                this.a.D0.N2();
                            }
                            if (this.a.h) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.a7();
                            this.a.D0.s3();
                            boolean K3 = view2.getId() == R.id.obfuscated_res_0x7f090a2d ? this.a.v0.K3(true, this.a.l5()) : view2.getId() == R.id.obfuscated_res_0x7f091c4a ? this.a.v0.K3(false, this.a.l5()) : this.a.v0.J3(this.a.l5());
                            view2.setTag(Boolean.valueOf(K3));
                            if (K3) {
                                i7 = 1;
                                this.a.D0.c3(true);
                                this.a.D0.X3();
                                this.a.h = true;
                                this.a.D0.g3(true);
                            } else {
                                i7 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                        } else if (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().l()) {
                            if (view2.getId() == R.id.obfuscated_res_0x7f091eee) {
                                if (!q18.c(this.a.getPageContext(), 11009)) {
                                    return;
                                }
                                q18.x(this.a.getContext(), 3, this.a.h5(), this.a.v0);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091834 || view2.getId() == R.id.obfuscated_res_0x7f091ee9) {
                                if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (S1 = this.a.v0.S1()) == null) {
                                    return;
                                }
                                ThreadData Q2 = S1.Q();
                                if (Q2 != null && Q2.getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", S1.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (Q2 != null) {
                                    if (Q2.isBJHArticleThreadType()) {
                                        i = 2;
                                    } else if (Q2.isBJHVideoThreadType()) {
                                        i = 3;
                                    } else if (Q2.isBJHNormalThreadType()) {
                                        i = 4;
                                    } else if (Q2.isBJHVideoDynamicThreadType()) {
                                        i = 5;
                                    }
                                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                    statisticItem3.param("tid", this.a.v0.m2());
                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem3.param("fid", this.a.v0.getForumId());
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091eee) {
                                        statisticItem3.param("obj_locate", 5);
                                    } else {
                                        statisticItem3.param("obj_locate", 6);
                                    }
                                    statisticItem3.param("obj_name", i);
                                    statisticItem3.param("obj_type", 1);
                                    if (Q2 != null) {
                                        if (Q2.isBJHArticleThreadType()) {
                                            statisticItem3.param("obj_type", 10);
                                        } else if (Q2.isBJHVideoThreadType()) {
                                            statisticItem3.param("obj_type", 9);
                                        } else if (Q2.isBJHVideoDynamicThreadType()) {
                                            statisticItem3.param("obj_type", 8);
                                        } else if (Q2.isBJHNormalThreadType()) {
                                            statisticItem3.param("obj_type", 7);
                                        } else if (Q2.isShareThread) {
                                            statisticItem3.param("obj_type", 6);
                                        } else {
                                            int i10 = Q2.threadType;
                                            if (i10 == 0) {
                                                statisticItem3.param("obj_type", 1);
                                            } else {
                                                if (i10 == 40) {
                                                    statisticItem3.param("obj_type", 2);
                                                } else if (i10 == 49) {
                                                    statisticItem3.param("obj_type", 3);
                                                } else if (i10 == 54) {
                                                    statisticItem3.param("obj_type", 4);
                                                } else {
                                                    statisticItem3.param("obj_type", 5);
                                                }
                                                statisticItem3.param("card_type", Q2.getRecomCardType());
                                                statisticItem3.param("recom_source", Q2.mRecomSource);
                                                statisticItem3.param("ab_tag", Q2.mRecomAbTag);
                                                statisticItem3.param("weight", Q2.mRecomWeight);
                                                statisticItem3.param("extra", Q2.mRecomExtra);
                                                statisticItem3.param("nid", Q2.getNid());
                                                if (Q2.getBaijiahaoData() != null && !xi.isEmpty(Q2.getBaijiahaoData().oriUgcVid)) {
                                                    statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, Q2.getBaijiahaoData().oriUgcVid);
                                                }
                                            }
                                        }
                                        statisticItem3.param("card_type", Q2.getRecomCardType());
                                        statisticItem3.param("recom_source", Q2.mRecomSource);
                                        statisticItem3.param("ab_tag", Q2.mRecomAbTag);
                                        statisticItem3.param("weight", Q2.mRecomWeight);
                                        statisticItem3.param("extra", Q2.mRecomExtra);
                                        statisticItem3.param("nid", Q2.getNid());
                                        if (Q2.getBaijiahaoData() != null) {
                                            statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, Q2.getBaijiahaoData().oriUgcVid);
                                        }
                                    }
                                    if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    }
                                    if (this.a.P() != null) {
                                        be5.e(this.a.P(), statisticItem3);
                                    }
                                    if (this.a.D0 != null) {
                                        statisticItem3.param("obj_param1", this.a.D0.P0());
                                    }
                                    TiebaStatic.log(statisticItem3);
                                    if (yi.F()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                                        return;
                                    } else if (S1 == null) {
                                        yi.P(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e27));
                                        return;
                                    } else {
                                        ArrayList<PostData> H2 = this.a.v0.S1().H();
                                        if ((H2 == null || H2.size() <= 0) && this.a.v0.k2()) {
                                            yi.P(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e27));
                                            return;
                                        }
                                        this.a.D0.p0();
                                        this.a.a7();
                                        if (S1.B() != null && !StringUtils.isNull(S1.B().a(), true)) {
                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.v0.S1().m()));
                                        }
                                        TiebaStatic.log(new StatisticItem("c11939"));
                                        if (AntiHelper.e(this.a.getContext(), Q2)) {
                                            return;
                                        }
                                        if (this.a.D0 != null) {
                                            this.a.D0.r0();
                                            this.a.D0.o4(S1);
                                        }
                                        if (ShareSwitch.isOn()) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091834) {
                                                i2 = 2;
                                            } else {
                                                i2 = view2.getId() == R.id.obfuscated_res_0x7f091eee ? 1 : 6;
                                            }
                                            if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.D0.T1() && !S1.q0()) {
                                                if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                    if (g45.c() > 0) {
                                                        q18.G(this.a.getContext(), this.a.v0.S1());
                                                    } else {
                                                        int P0 = this.a.D0.P0();
                                                        this.a.D0.e0();
                                                        this.a.L5(g45.a(), P0);
                                                    }
                                                } else {
                                                    this.a.U6(i2);
                                                }
                                            } else {
                                                this.a.U6(i2);
                                            }
                                        } else {
                                            this.a.D0.N3();
                                            this.a.v0.m1().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                        }
                                    }
                                }
                                i = 1;
                                StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem32.param("tid", this.a.v0.m2());
                                statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem32.param("fid", this.a.v0.getForumId());
                                if (view2.getId() != R.id.obfuscated_res_0x7f091eee) {
                                }
                                statisticItem32.param("obj_name", i);
                                statisticItem32.param("obj_type", 1);
                                if (Q2 != null) {
                                }
                                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                }
                                if (this.a.P() != null) {
                                }
                                if (this.a.D0 != null) {
                                }
                                TiebaStatic.log(statisticItem32);
                                if (yi.F()) {
                                }
                            } else if (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().q()) {
                                if (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().x()) {
                                    if (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().w()) {
                                        if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().u()) {
                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                            if (skinType == 1) {
                                                this.a.onChangeSkinType(skinType);
                                                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                            } else if (skinType == 0 || skinType == 4) {
                                                UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                                this.a.onChangeSkinType(skinType);
                                                UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_1));
                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                            }
                                            this.a.D0.h.l();
                                        } else if (this.a.D0.Q0() == view2) {
                                            if (!this.a.D0.Q0().getIndicateStatus()) {
                                                qp8.d("c10725", null);
                                            } else {
                                                ox7 S12 = this.a.v0.S1();
                                                if (S12 != null && S12.Q() != null && S12.Q().getTaskInfoData() != null) {
                                                    String d = S12.Q().getTaskInfoData().d();
                                                    if (StringUtils.isNull(d)) {
                                                        d = S12.Q().getTaskInfoData().g();
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                }
                                            }
                                            this.a.E5();
                                        } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().n()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                                return;
                                            }
                                            this.a.D0.p0();
                                            SparseArray<Object> U0 = this.a.D0.U0(this.a.v0.S1(), this.a.v0.k2(), 1);
                                            if (U0 == null) {
                                                return;
                                            }
                                            this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.S1().l().getId(), this.a.v0.S1().l().getName(), this.a.v0.S1().Q().getId(), StringUtils.string(this.a.v0.S1().X().getUserId()), StringUtils.string(U0.get(R.id.obfuscated_res_0x7f0920a1)), StringUtils.string(U0.get(R.id.obfuscated_res_0x7f0920a2)), StringUtils.string(U0.get(R.id.obfuscated_res_0x7f0920a4)), StringUtils.string(U0.get(R.id.obfuscated_res_0x7f0920a3)))));
                                        } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().j()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                                return;
                                            }
                                            SparseArray<Object> U02 = this.a.D0.U0(this.a.v0.S1(), this.a.v0.k2(), 1);
                                            if (U02 != null) {
                                                this.a.D0.t2(((Integer) U02.get(R.id.obfuscated_res_0x7f092098)).intValue(), StringUtils.string(U02.get(R.id.obfuscated_res_0x7f092096)), ((Integer) U02.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) U02.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                                            }
                                            this.a.D0.h.k();
                                            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().Q() != null) {
                                                ThreadData Q3 = this.a.K().S1().Q();
                                                StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                statisticItem4.param("tid", Q3.getId());
                                                statisticItem4.param("fid", Q3.getFid());
                                                statisticItem4.param("fname", Q3.getForum_name());
                                                TiebaStatic.log(statisticItem4);
                                                StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                statisticItem5.param("tid", Q3.getId());
                                                statisticItem5.param("fid", Q3.getFid());
                                                statisticItem5.param("fname", Q3.getForum_name());
                                                statisticItem5.param("obj_source", 3);
                                                TiebaStatic.log(statisticItem5);
                                            }
                                        } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().m()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                                return;
                                            }
                                            SparseArray<Object> U03 = this.a.D0.U0(this.a.v0.S1(), this.a.v0.k2(), 1);
                                            if (U03 != null) {
                                                if (StringUtils.isNull((String) U03.get(R.id.obfuscated_res_0x7f092095))) {
                                                    this.a.D0.q2(((Integer) U03.get(R.id.obfuscated_res_0x7f092098)).intValue(), StringUtils.string(U03.get(R.id.obfuscated_res_0x7f092096)), ((Integer) U03.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) U03.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                                                } else {
                                                    this.a.D0.r2(((Integer) U03.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) U03.get(R.id.obfuscated_res_0x7f092096), ((Integer) U03.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) U03.get(R.id.obfuscated_res_0x7f092097)).booleanValue(), StringUtils.string(U03.get(R.id.obfuscated_res_0x7f092095)));
                                                }
                                            }
                                            this.a.D0.h.k();
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091ff6 && view2.getId() != R.id.obfuscated_res_0x7f091ff4 && view2.getId() != R.id.obfuscated_res_0x7f091848 && view2.getId() != R.id.obfuscated_res_0x7f0916d6) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0918ac) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f0918aa && view2.getId() != R.id.obfuscated_res_0x7f091a8d && view2.getId() != R.id.obfuscated_res_0x7f091842) {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091846) {
                                                        try {
                                                            sparseArray = (SparseArray) view2.getTag();
                                                        } catch (ClassCastException e) {
                                                            e.printStackTrace();
                                                            sparseArray = null;
                                                        }
                                                        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
                                                        if (postData == null) {
                                                            return;
                                                        }
                                                        if (this.a.J0 == null) {
                                                            PbFragment pbFragment2 = this.a;
                                                            pbFragment2.J0 = new uv4(pbFragment2.getContext());
                                                            this.a.J0.n(this.a.h2);
                                                        }
                                                        ArrayList arrayList = new ArrayList();
                                                        boolean z3 = this.a.K().S1() != null && this.a.K().S1().l0();
                                                        if (view2 != null && sparseArray != null) {
                                                            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue() : false;
                                                            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue() : false;
                                                            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue() : false;
                                                            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue() : false;
                                                            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue() : false;
                                                            String str = sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f0920a4) : null;
                                                            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue() : false;
                                                            if (postData.q() != null) {
                                                                boolean z4 = postData.q().hasAgree;
                                                                int r = postData.r();
                                                                if (z4 && r == 5) {
                                                                    pbFragment = this.a;
                                                                    i3 = R.string.obfuscated_res_0x7f0f0085;
                                                                } else {
                                                                    pbFragment = this.a;
                                                                    i3 = R.string.obfuscated_res_0x7f0f0087;
                                                                }
                                                                qv4 qv4Var8 = new qv4(8, pbFragment.getString(i3), this.a.J0);
                                                                SparseArray sparseArray2 = new SparseArray();
                                                                sparseArray2.put(R.id.obfuscated_res_0x7f092094, postData);
                                                                qv4Var8.d.setTag(sparseArray2);
                                                                arrayList.add(qv4Var8);
                                                            }
                                                            if (this.a.mIsLogin) {
                                                                if (!m38.j(this.a.v0) && !booleanValue3 && booleanValue2) {
                                                                    qv4 qv4Var9 = new qv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b6a), this.a.J0);
                                                                    SparseArray sparseArray3 = new SparseArray();
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                    sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                                                                    qv4Var9.d.setTag(sparseArray3);
                                                                    arrayList.add(qv4Var9);
                                                                } else if ((q18.C(this.a.v0.S1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                                    qv4 qv4Var10 = new qv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f104a), this.a.J0);
                                                                    qv4Var10.d.setTag(str);
                                                                    arrayList.add(qv4Var10);
                                                                }
                                                                if (booleanValue3) {
                                                                    SparseArray sparseArray4 = new SparseArray();
                                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a4, str);
                                                                    if (booleanValue4) {
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                                                                    } else {
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                                                                    }
                                                                    if (booleanValue5) {
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(booleanValue));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                                                                        if (booleanValue6) {
                                                                            qv4 qv4Var11 = new qv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.a.J0);
                                                                            qv4Var11.d.setTag(sparseArray4);
                                                                            qv4Var2 = qv4Var11;
                                                                            qv4Var = new qv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e9), this.a.J0);
                                                                            qv4Var.d.setTag(sparseArray4);
                                                                        }
                                                                    } else {
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                                                                    }
                                                                    qv4Var2 = null;
                                                                    qv4Var = new qv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e9), this.a.J0);
                                                                    qv4Var.d.setTag(sparseArray4);
                                                                } else if (booleanValue5) {
                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(booleanValue));
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                                                                    sparseArray5.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                                                                    if (this.a.v0.S1().Y() == 1002 && !booleanValue) {
                                                                        qv4Var3 = new qv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f104a), this.a.J0);
                                                                    } else {
                                                                        qv4Var3 = new qv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.a.J0);
                                                                    }
                                                                    qv4Var3.d.setTag(sparseArray5);
                                                                    qv4Var2 = qv4Var3;
                                                                    qv4Var = null;
                                                                } else {
                                                                    qv4Var = null;
                                                                    qv4Var2 = null;
                                                                }
                                                                if (qv4Var2 != null) {
                                                                    arrayList.add(qv4Var2);
                                                                }
                                                                if (qv4Var != null) {
                                                                    arrayList.add(qv4Var);
                                                                }
                                                            }
                                                            this.a.J0.j(arrayList);
                                                            this.a.I0 = new sv4(this.a.getPageContext(), this.a.J0);
                                                            this.a.I0.k();
                                                        }
                                                    } else if (view2 == this.a.D0.O0()) {
                                                        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                            this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, xg.g(this.a.v0.S1().m(), 0L), xg.g(this.a.v0.m2(), 0L), xg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.v0.S1().Q().getPushStatusData())));
                                                        }
                                                    } else if (view2 == this.a.D0.h.o()) {
                                                        this.a.D0.B3();
                                                    } else if (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().v()) {
                                                        if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().o()) {
                                                            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                            if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.v0.m2())) != null) {
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                this.a.D0.h.k();
                                                                TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                            }
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f09079e && view2.getId() != R.id.obfuscated_res_0x7f090a2a) {
                                                            int id3 = view2.getId();
                                                            if (id3 == R.id.obfuscated_res_0x7f0918cc) {
                                                                if (!this.a.checkUpIsLogin() || (zu4Var = (zu4) view2.getTag()) == null || StringUtils.isNull(zu4Var.m1())) {
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{zu4Var.m1()});
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091c4d || id3 == R.id.obfuscated_res_0x7f090733 || id3 == R.id.obfuscated_res_0x7f091c4e || id3 == R.id.obfuscated_res_0x7f090734) {
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    return;
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 != null && view2.getTag() != null) {
                                                                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                    PostData postData2 = (PostData) sparseArray6.get(R.id.obfuscated_res_0x7f0920b1);
                                                                    if (id3 == R.id.obfuscated_res_0x7f091c4e || id3 == R.id.obfuscated_res_0x7f090734) {
                                                                        TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.v0.b));
                                                                    }
                                                                    if (this.a.J0 == null) {
                                                                        PbFragment pbFragment3 = this.a;
                                                                        pbFragment3.J0 = new uv4(pbFragment3.getContext());
                                                                        this.a.J0.n(this.a.h2);
                                                                    }
                                                                    ArrayList arrayList2 = new ArrayList();
                                                                    q18.y(view2);
                                                                    if (q18.y(view2) && this.a.i1 != null) {
                                                                        this.a.i1.t();
                                                                    }
                                                                    if (sparseArray6.get(R.id.obfuscated_res_0x7f0920ad) instanceof Boolean) {
                                                                        ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f0920ad)).booleanValue();
                                                                    }
                                                                    boolean booleanValue7 = sparseArray6.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092097)).booleanValue() : false;
                                                                    boolean booleanValue8 = sparseArray6.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue() : false;
                                                                    boolean booleanValue9 = sparseArray6.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue() : false;
                                                                    boolean booleanValue10 = sparseArray6.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue() : false;
                                                                    boolean booleanValue11 = sparseArray6.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f0920db)).booleanValue() : false;
                                                                    String str2 = sparseArray6.get(R.id.obfuscated_res_0x7f0920a4) instanceof String ? (String) sparseArray6.get(R.id.obfuscated_res_0x7f0920a4) : null;
                                                                    boolean booleanValue12 = sparseArray6.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue() : false;
                                                                    if (postData2 != null) {
                                                                        if (postData2.X() != null && postData2.X().toString().length() > 0) {
                                                                            qv4 qv4Var12 = new qv4(3, this.a.getString(R.string.obfuscated_res_0x7f0f045c), this.a.J0);
                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                            sparseArray7.put(R.id.obfuscated_res_0x7f092094, postData2);
                                                                            qv4Var12.d.setTag(sparseArray7);
                                                                            arrayList2.add(qv4Var12);
                                                                        }
                                                                        this.a.D2 = postData2;
                                                                    }
                                                                    if (this.a.v0.S1().r()) {
                                                                        String v = this.a.v0.S1().v();
                                                                        if (postData2 != null && !xi.isEmpty(v) && v.equals(postData2.M())) {
                                                                            z = true;
                                                                            if (!z) {
                                                                                qv4Var4 = new qv4(4, this.a.getString(R.string.obfuscated_res_0x7f0f1025), this.a.J0);
                                                                            } else {
                                                                                qv4Var4 = new qv4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0ac6), this.a.J0);
                                                                            }
                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092094, this.a.D2);
                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
                                                                            qv4Var4.d.setTag(sparseArray8);
                                                                            arrayList2.add(qv4Var4);
                                                                            if (this.a.mIsLogin) {
                                                                                if (!m38.j(this.a.v0) && !booleanValue9 && booleanValue8) {
                                                                                    qv4 qv4Var13 = new qv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b6a), this.a.J0);
                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920ab, sparseArray6.get(R.id.obfuscated_res_0x7f0920ab));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920ed, sparseArray6.get(R.id.obfuscated_res_0x7f0920ed));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920ee, sparseArray6.get(R.id.obfuscated_res_0x7f0920ee));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920ec, sparseArray6.get(R.id.obfuscated_res_0x7f0920ec));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920ef, sparseArray6.get(R.id.obfuscated_res_0x7f0920ef));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920f0, sparseArray6.get(R.id.obfuscated_res_0x7f0920f0));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f092097, sparseArray6.get(R.id.obfuscated_res_0x7f092097));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f092098, sparseArray6.get(R.id.obfuscated_res_0x7f092098));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f092096, sparseArray6.get(R.id.obfuscated_res_0x7f092096));
                                                                                    sparseArray9.put(R.id.obfuscated_res_0x7f0920b4, sparseArray6.get(R.id.obfuscated_res_0x7f0920b4));
                                                                                    qv4Var4.d.setTag(sparseArray9);
                                                                                    arrayList2.add(qv4Var13);
                                                                                } else if (q18.C(this.a.v0.S1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                    qv4 qv4Var14 = new qv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f104a), this.a.J0);
                                                                                    qv4Var14.d.setTag(str2);
                                                                                    arrayList2.add(qv4Var14);
                                                                                }
                                                                                if (booleanValue9) {
                                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                                    sparseArray10.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                                                                                    sparseArray10.put(R.id.obfuscated_res_0x7f0920b4, sparseArray6.get(R.id.obfuscated_res_0x7f0920b4));
                                                                                    sparseArray10.put(R.id.obfuscated_res_0x7f0920a1, sparseArray6.get(R.id.obfuscated_res_0x7f0920a1));
                                                                                    sparseArray10.put(R.id.obfuscated_res_0x7f0920a2, sparseArray6.get(R.id.obfuscated_res_0x7f0920a2));
                                                                                    sparseArray10.put(R.id.obfuscated_res_0x7f0920a3, sparseArray6.get(R.id.obfuscated_res_0x7f0920a3));
                                                                                    sparseArray10.put(R.id.obfuscated_res_0x7f0920a4, str2);
                                                                                    if (booleanValue10) {
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920ab, sparseArray6.get(R.id.obfuscated_res_0x7f0920ab));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920ed, sparseArray6.get(R.id.obfuscated_res_0x7f0920ed));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920ee, sparseArray6.get(R.id.obfuscated_res_0x7f0920ee));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920ec, sparseArray6.get(R.id.obfuscated_res_0x7f0920ec));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920ef, sparseArray6.get(R.id.obfuscated_res_0x7f0920ef));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920f0, sparseArray6.get(R.id.obfuscated_res_0x7f0920f0));
                                                                                    } else {
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                                                                                    }
                                                                                    if (booleanValue11) {
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(booleanValue7));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f092096, sparseArray6.get(R.id.obfuscated_res_0x7f092096));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f092098, sparseArray6.get(R.id.obfuscated_res_0x7f092098));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920a8, sparseArray6.get(R.id.obfuscated_res_0x7f0920a8));
                                                                                        if (booleanValue12) {
                                                                                            qv4 qv4Var15 = new qv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.a.J0);
                                                                                            qv4Var15.d.setTag(sparseArray10);
                                                                                            qv4Var6 = qv4Var15;
                                                                                            qv4Var5 = new qv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e9), this.a.J0);
                                                                                            qv4Var5.d.setTag(sparseArray10);
                                                                                        }
                                                                                    } else {
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                                                                                    }
                                                                                    qv4Var6 = null;
                                                                                    qv4Var5 = new qv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e9), this.a.J0);
                                                                                    qv4Var5.d.setTag(sparseArray10);
                                                                                } else if (booleanValue11) {
                                                                                    SparseArray sparseArray11 = new SparseArray();
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f0920b4, sparseArray6.get(R.id.obfuscated_res_0x7f0920b4));
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(booleanValue7));
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f092096, sparseArray6.get(R.id.obfuscated_res_0x7f092096));
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f092098, sparseArray6.get(R.id.obfuscated_res_0x7f092098));
                                                                                    sparseArray11.put(R.id.obfuscated_res_0x7f0920a8, sparseArray6.get(R.id.obfuscated_res_0x7f0920a8));
                                                                                    if (this.a.v0.S1().Y() == 1002 && !booleanValue7) {
                                                                                        qv4Var7 = new qv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f104a), this.a.J0);
                                                                                    } else {
                                                                                        qv4Var7 = new qv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.a.J0);
                                                                                    }
                                                                                    qv4Var7.d.setTag(sparseArray11);
                                                                                    qv4Var6 = qv4Var7;
                                                                                    qv4Var5 = null;
                                                                                } else {
                                                                                    qv4Var5 = null;
                                                                                    qv4Var6 = null;
                                                                                }
                                                                                if (qv4Var6 != null) {
                                                                                    arrayList2.add(qv4Var6);
                                                                                }
                                                                                if (qv4Var5 != null) {
                                                                                    arrayList2.add(qv4Var5);
                                                                                }
                                                                            }
                                                                            this.a.J0.j(arrayList2);
                                                                            this.a.I0 = new sv4(this.a.getPageContext(), this.a.J0);
                                                                            this.a.I0.k();
                                                                        }
                                                                    }
                                                                    z = false;
                                                                    if (!z) {
                                                                    }
                                                                    SparseArray sparseArray82 = new SparseArray();
                                                                    sparseArray82.put(R.id.obfuscated_res_0x7f092094, this.a.D2);
                                                                    sparseArray82.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
                                                                    qv4Var4.d.setTag(sparseArray82);
                                                                    arrayList2.add(qv4Var4);
                                                                    if (this.a.mIsLogin) {
                                                                    }
                                                                    this.a.J0.j(arrayList2);
                                                                    this.a.I0 = new sv4(this.a.getPageContext(), this.a.J0);
                                                                    this.a.I0.k();
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091812) {
                                                                if (this.a.v0.S1() != null && this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getActUrl() != null) {
                                                                    sp4.o(this.a.getActivity(), this.a.v0.S1().Q().getActUrl());
                                                                    if (this.a.v0.S1().Q().getActInfoType() == 1) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    } else if (this.a.v0.S1().Q().getActInfoType() == 2) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09148a) {
                                                                if (view2.getTag(R.id.obfuscated_res_0x7f0920c3) instanceof String) {
                                                                    String string4 = StringUtils.string(view2.getTag(R.id.obfuscated_res_0x7f0920c3));
                                                                    TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.v0.S1().m()).param("tid", this.a.v0.S1().S()).param("lotterytail", StringUtils.string(string4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                    if (!this.a.v0.S1().S().equals(string4)) {
                                                                        this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string4, (String) null, (String) null, (String) null)));
                                                                    } else {
                                                                        this.a.D0.w3(0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091874 || id3 == R.id.obfuscated_res_0x7f09183c) {
                                                                if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                    String string5 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13c2);
                                                                    String q = py4.k().q("tail_link", "");
                                                                    String string6 = StringUtils.string(view2.getTag(R.id.obfuscated_res_0x7f0920c4));
                                                                    if (!StringUtils.isNull(q)) {
                                                                        TiebaStatic.log("c10056");
                                                                        sp4.s(view2.getContext(), string5, UtilHelper.urlAddParam(q, "page_from=1&tailSkinId=" + string6), true, true, true);
                                                                    }
                                                                    this.a.D0.N2();
                                                                    TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string6));
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091062) {
                                                                if (view2 != null) {
                                                                    sp4.o(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                    if (this.a.h5() == 1 && this.a.v0 != null && this.a.v0.S1() != null) {
                                                                        p48.u("c10397", this.a.v0.S1().m(), this.a.v0.S1().S(), currentAccount);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09147d) {
                                                                if (view2 != null) {
                                                                    String string7 = StringUtils.string(view2.getTag());
                                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                    sp4.o(this.a.getActivity(), string7);
                                                                    if (this.a.h5() == 1 && this.a.v0 != null && this.a.v0.S1() != null) {
                                                                        p48.u("c10507", this.a.v0.S1().m(), this.a.v0.S1().S(), currentAccount2);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0914dd) {
                                                                this.a.X5();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0914dc) {
                                                                this.a.U5();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09273b) {
                                                                if (this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().B() != null) {
                                                                    ox7 S13 = this.a.v0.S1();
                                                                    TiebaStatic.log(new StatisticItem("c11679").param("fid", S13.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S13.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f092738) {
                                                                if (this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().B() != null) {
                                                                    ox7 S14 = this.a.v0.S1();
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", S14.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S14.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09242d) {
                                                                if (this.a.n1 >= 0) {
                                                                    if (this.a.v0 != null) {
                                                                        this.a.v0.m3();
                                                                    }
                                                                    if (this.a.v0 == null || this.a.D0.D0() == null) {
                                                                        i6 = 0;
                                                                    } else {
                                                                        i6 = 0;
                                                                        this.a.D0.D0().h0(this.a.v0.S1(), false);
                                                                    }
                                                                    this.a.n1 = i6;
                                                                    if (this.a.v0 != null) {
                                                                        this.a.D0.T0().setSelection(this.a.v0.L1());
                                                                        this.a.v0.q3(0, 0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b6f) {
                                                                if (!q18.c(this.a.getPageContext(), 11009)) {
                                                                    return;
                                                                }
                                                                q18.x(this.a.getContext(), 8, this.a.h5(), this.a.v0);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0916d6) {
                                                                SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                if (sparseArray12 == null) {
                                                                    return;
                                                                }
                                                                this.a.Y6(sparseArray12);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091831) {
                                                                if (this.a.D0.T0() == null || this.a.v0 == null || this.a.v0.S1() == null) {
                                                                    return;
                                                                }
                                                                int firstVisiblePosition = this.a.D0.T0().getFirstVisiblePosition();
                                                                View childAt = this.a.D0.T0().getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                boolean y0 = this.a.v0.S1().y0();
                                                                boolean z5 = this.a.D0.e1() != null && this.a.D0.e1().g();
                                                                boolean P1 = this.a.D0.P1();
                                                                boolean z6 = firstVisiblePosition == 0 && top == 0;
                                                                if (!y0 || this.a.D0.e1() == null || this.a.D0.e1().c() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    int l3 = ((int) (yi.l(this.a.getContext()) * 0.5625d)) - this.a.D0.e1().e();
                                                                    if (firstVisiblePosition == 0) {
                                                                        if (top != l3) {
                                                                            i5 = l3;
                                                                        } else {
                                                                            i5 = l3;
                                                                        }
                                                                        z6 = true;
                                                                        i4 = i5;
                                                                    } else {
                                                                        i5 = l3;
                                                                    }
                                                                    z6 = false;
                                                                    i4 = i5;
                                                                }
                                                                int i11 = i4;
                                                                q18.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.v0.S1());
                                                                if ((this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getReply_num() <= 0) || (P1 && z6)) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    if (!this.a.checkUpIsLogin()) {
                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                        return;
                                                                    }
                                                                    this.a.n6();
                                                                    if (this.a.v0.S1().Q().getAuthor() != null) {
                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.S1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                    }
                                                                } else {
                                                                    int j = (int) (yi.j(this.a.getContext()) * 0.6d);
                                                                    if (y0) {
                                                                        if (this.a.D0.d1 != null && this.a.D0.d1.c != null && this.a.D0.d1.c.getView() != null) {
                                                                            if (this.a.D0.d1.c.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    } else {
                                                                        if (this.a.D0.b1() != null) {
                                                                            z2 = this.a.D0.b1().getVisibility() == 0;
                                                                            if (!z2 && this.a.D0.d1 != null && this.a.D0.d1.c != null && this.a.D0.d1.c.getView() != null && this.a.D0.d1.c.getView().getParent() != null && this.a.D0.h != null && this.a.D0.h.a != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    }
                                                                    if (!z2 && !P1) {
                                                                        if (this.a.Z <= 0) {
                                                                            int d2 = o28.d(this.a.getListView());
                                                                            if (o28.e(this.a.getListView()) != -1) {
                                                                                d2--;
                                                                            }
                                                                            int g = yi.g(this.a.getContext(), R.dimen.tbds100);
                                                                            if (d2 < 0) {
                                                                                d2 = (ListUtils.getCount(this.a.D0.T0().getData()) - 1) + this.a.D0.T0().getHeaderViewsCount();
                                                                                g = 0;
                                                                            }
                                                                            if (z5) {
                                                                                fixedNavHeight = (int) (yi.l(this.a.getContext()) * 0.5625d);
                                                                            } else if (!y0 || this.a.D0.e1() == null) {
                                                                                if (this.a.D0.h != null && this.a.D0.h.a != null) {
                                                                                    fixedNavHeight = this.a.D0.h.a.getFixedNavHeight() - 10;
                                                                                }
                                                                                if (this.a.D0.d1 != null || this.a.D0.d1.c == null || this.a.D0.d1.c.getView() == null || this.a.D0.d1.c.getView().getParent() == null) {
                                                                                    this.a.D0.T0().setSelectionFromTop(d2, g + j);
                                                                                    this.a.D0.T0().smoothScrollBy(j, 500);
                                                                                } else if (z5) {
                                                                                    this.a.D0.T0().smoothScrollBy(this.a.D0.d1.c.getView().getTop() - ((int) (yi.l(this.a.getContext()) * 0.5625d)), 500);
                                                                                } else {
                                                                                    this.a.D0.T0().E(d2, g, 200);
                                                                                }
                                                                            } else {
                                                                                fixedNavHeight = this.a.D0.e1().d();
                                                                            }
                                                                            g += fixedNavHeight;
                                                                            if (this.a.D0.d1 != null) {
                                                                            }
                                                                            this.a.D0.T0().setSelectionFromTop(d2, g + j);
                                                                            this.a.D0.T0().smoothScrollBy(j, 500);
                                                                        } else if (this.a.D0.T0().getChildAt(this.a.Z) != null) {
                                                                            this.a.D0.T0().E(this.a.Z, this.a.a0, 200);
                                                                        } else {
                                                                            this.a.D0.T0().setSelectionFromTop(this.a.Z, this.a.a0 + j);
                                                                            this.a.D0.T0().smoothScrollBy(j, 500);
                                                                        }
                                                                    } else {
                                                                        this.a.Z = firstVisiblePosition;
                                                                        this.a.a0 = top;
                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                            this.a.D0.T0().setSelectionFromTop(0, i11 - j);
                                                                            this.a.D0.T0().smoothScrollBy(-j, 500);
                                                                        } else {
                                                                            this.a.D0.T0().E(0, i11, 500);
                                                                        }
                                                                    }
                                                                }
                                                                if (this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.S1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091898 || id3 == R.id.obfuscated_res_0x7f091899) {
                                                                if (this.a.v0 == null || this.a.v0.S1() == null || this.a.v0.S1().l() == null || xi.isEmpty(this.a.v0.S1().l().getName())) {
                                                                    return;
                                                                }
                                                                if (this.a.v0.getErrorNo() == 4) {
                                                                    if (!StringUtils.isNull(this.a.v0.r1()) || this.a.v0.h1() == null) {
                                                                        this.a.a.finish();
                                                                        return;
                                                                    }
                                                                    name = this.a.v0.h1().b;
                                                                } else {
                                                                    name = this.a.v0.S1().l().getName();
                                                                }
                                                                if (StringUtils.isNull(name)) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                String r12 = this.a.v0.r1();
                                                                if (!this.a.v0.x1() || r12 == null || !r12.equals(name)) {
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.v0.S1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                } else {
                                                                    this.a.a.finish();
                                                                }
                                                                StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                statisticItem6.param("tid", this.a.v0.m2());
                                                                statisticItem6.param("fid", this.a.v0.getForumId());
                                                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                if (this.a.v0.S1().Q() != null) {
                                                                    statisticItem6.param("nid", this.a.v0.S1().Q().getNid());
                                                                }
                                                                TiebaStatic.log(statisticItem6);
                                                            } else if (id3 != R.id.obfuscated_res_0x7f090aad && id3 != R.id.obfuscated_res_0x7f090a86 && id3 != R.id.obfuscated_res_0x7f090a88 && id3 != R.id.obfuscated_res_0x7f090a87) {
                                                                if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                    if (this.a.v0 == null) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                    statisticItem7.param("tid", this.a.v0.m2());
                                                                    statisticItem7.param("fid", this.a.v0.getForumId());
                                                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem7.param("obj_locate", 2);
                                                                    TiebaStatic.log(statisticItem7);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0918c0) {
                                                                    if (this.a.v0 == null || this.a.v0.S1() == null) {
                                                                        return;
                                                                    }
                                                                    ox7 S15 = this.a.v0.S1();
                                                                    if (this.a.A0 == null) {
                                                                        PbFragment pbFragment4 = this.a;
                                                                        pbFragment4.A0 = new gy7(pbFragment4.getPageContext());
                                                                    }
                                                                    long g2 = xg.g(S15.S(), 0L);
                                                                    long g3 = xg.g(S15.m(), 0L);
                                                                    p48.w("c13446", g3);
                                                                    PbFragment pbFragment5 = this.a;
                                                                    pbFragment5.registerListener(pbFragment5.o2);
                                                                    this.a.A0.a(g2, g3);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0918e5) {
                                                                    if (view2.getTag() instanceof SmartApp) {
                                                                        SmartApp smartApp = (SmartApp) view2.getTag();
                                                                        if (!ot5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                            if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                return;
                                                                            }
                                                                            sp4.o(this.a.getActivity(), smartApp.h5_url);
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.v0.m2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090e6f) {
                                                                    if (!(view2.getTag() instanceof ThreadData)) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090e6c) {
                                                                    if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.P != null) {
                                                                        this.a.P.Q(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09184a || id3 == R.id.obfuscated_res_0x7f0918a4) {
                                                                    if (this.a.q0) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.v0.m2());
                                                                    statisticItem8.param("fid", this.a.v0.getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                    if (sparseArray13 != null && (sparseArray13.get(R.id.obfuscated_res_0x7f0920ae) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.obfuscated_res_0x7f0920ae)).booleanValue()) {
                                                                        p48.s(6);
                                                                    }
                                                                    PbFragment pbFragment6 = this.a;
                                                                    pbFragment6.b = false;
                                                                    pbFragment6.U4(view2);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09244b) {
                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f0920ae) instanceof Boolean) {
                                                                        p48.s(5);
                                                                    }
                                                                    this.a.B6(false);
                                                                    this.a.Z6((PostData) view2.getTag(R.id.obfuscated_res_0x7f0920c5), false);
                                                                }
                                                            } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                return;
                                                            } else {
                                                                ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                if (this.a.v0.R1() != 3 || !this.a.t0() || this.a.v0.S1() == null || !ListUtils.isEmpty(this.a.v0.S1().p())) {
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
                                                            }
                                                        } else {
                                                            SparseArray sparseArray14 = (SparseArray) view2.getTag();
                                                            if (sparseArray14 == null || !(sparseArray14.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData)) {
                                                                return;
                                                            }
                                                            PostData postData3 = (PostData) sparseArray14.get(R.id.obfuscated_res_0x7f0920b1);
                                                            View view3 = (View) sparseArray14.get(R.id.obfuscated_res_0x7f0920b3);
                                                            if (postData3 == null || view3 == null) {
                                                                return;
                                                            }
                                                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09079f);
                                                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907a0);
                                                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a2a);
                                                            if (postData3.t0()) {
                                                                postData3.T0(false);
                                                                n38.e(postData3);
                                                            } else if (this.a.K() != null ? n38.c(this.a.K().S1(), postData3) : false) {
                                                                postData3.T0(true);
                                                            }
                                                            SkinManager.setBackgroundColor(findViewById, postData3.t0() ? R.color.CAM_X0201 : R.color.transparent);
                                                            SkinManager.setViewTextColor(eMTextView, postData3.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                            WebPManager.setPureDrawable(imageView, postData3.t0() ? R.drawable.obfuscated_res_0x7f0809a1 : R.drawable.obfuscated_res_0x7f0809a0, postData3.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        }
                                                    } else {
                                                        this.a.D0.h.l();
                                                        this.a.D0.U3(this.a.G2);
                                                    }
                                                } else if (this.a.v0 == null) {
                                                    return;
                                                } else {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918aa) {
                                                        StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                        statisticItem10.param("tid", this.a.v0.m2());
                                                        statisticItem10.param("fid", this.a.v0.getForumId());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("obj_locate", 6);
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a8d) {
                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                            this.a.S = view2;
                                                            return;
                                                        }
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918aa && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.S = view2;
                                                        return;
                                                    }
                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                        return;
                                                    }
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (!(sparseArray15.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData)) {
                                                        return;
                                                    }
                                                    PostData postData4 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f0920b1);
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918aa && (statisticItem = postData4.e0) != null) {
                                                        StatisticItem copy = statisticItem.copy();
                                                        copy.delete("obj_locate");
                                                        copy.param("obj_locate", 8);
                                                        TiebaStatic.log(copy);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a8d || view2.getId() == R.id.obfuscated_res_0x7f091842) {
                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.v0.n2()).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.M()).param("obj_source", 1).param("obj_type", 3));
                                                    }
                                                    if (this.a.v0 == null || this.a.v0.S1() == null || this.a.y5().c1() == null || postData4.s() == null || postData4.D() == 1) {
                                                        return;
                                                    }
                                                    if (this.a.y5().d1() != null) {
                                                        this.a.y5().d1().c();
                                                    }
                                                    ey7 ey7Var = new ey7();
                                                    ey7Var.A(this.a.v0.S1().l());
                                                    ey7Var.E(this.a.v0.S1().Q());
                                                    ey7Var.C(postData4);
                                                    this.a.y5().c1().V(ey7Var);
                                                    this.a.y5().c1().setPostId(postData4.M());
                                                    this.a.Y5(view2, postData4.s().getUserId(), "", postData4);
                                                    if (this.a.S0 != null) {
                                                        this.a.D0.V2(this.a.S0.y());
                                                    }
                                                }
                                            } else if (this.a.v0 == null) {
                                                return;
                                            } else {
                                                StatisticItem statisticItem11 = new StatisticItem("c13398");
                                                statisticItem11.param("tid", this.a.v0.m2());
                                                statisticItem11.param("fid", this.a.v0.getForumId());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("obj_locate", 5);
                                                TiebaStatic.log(statisticItem11);
                                                if (view2.getId() != R.id.obfuscated_res_0x7f0918ac || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                        return;
                                                    }
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (!(sparseArray16.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData)) {
                                                        return;
                                                    }
                                                    PostData postData5 = (PostData) sparseArray16.get(R.id.obfuscated_res_0x7f0920b1);
                                                    StatisticItem statisticItem12 = postData5.e0;
                                                    if (statisticItem12 != null) {
                                                        StatisticItem copy2 = statisticItem12.copy();
                                                        copy2.delete("obj_locate");
                                                        copy2.param("obj_locate", 8);
                                                        TiebaStatic.log(copy2);
                                                    }
                                                    if (this.a.v0 == null || this.a.v0.S1() == null) {
                                                        return;
                                                    }
                                                    String m2 = this.a.v0.m2();
                                                    String M = postData5.M();
                                                    int Y = this.a.v0.S1() != null ? this.a.v0.S1().Y() : 0;
                                                    AbsPbActivity.e o6 = this.a.o6(M);
                                                    if (o6 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, false, null, false, null, Y, postData5.e0(), this.a.v0.S1().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(o6.a, o6.b, o6.g, o6.j);
                                                    addBigImageData.setKeyPageStartFrom(this.a.v0.R1());
                                                    addBigImageData.setFromFrsForumId(this.a.v0.getFromForumId());
                                                    addBigImageData.setWorksInfoData(this.a.v0.r2());
                                                    addBigImageData.setKeyFromForumId(this.a.v0.getForumId());
                                                    addBigImageData.setTiebaPlusData(this.a.v0.I(), this.a.v0.E(), this.a.v0.F(), this.a.v0.D(), this.a.v0.J());
                                                    addBigImageData.setBjhData(this.a.v0.k1());
                                                    if (this.a.v0.S1().o() != null) {
                                                        addBigImageData.setHasForumRule(this.a.v0.S1().o().has_forum_rule.intValue());
                                                    }
                                                    if (this.a.v0.S1().X() != null) {
                                                        addBigImageData.setIsManager(this.a.v0.S1().X().getIs_manager());
                                                    }
                                                    if (this.a.v0.S1().l().getDeletedReasonInfo() != null) {
                                                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.v0.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.v0.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                    }
                                                    if (this.a.v0.S1().l() != null) {
                                                        addBigImageData.setForumHeadUrl(this.a.v0.S1().l().getImage_url());
                                                        addBigImageData.setUserLevel(this.a.v0.S1().l().getUser_level());
                                                    }
                                                    if (this.a.D0 != null && this.a.v0.G != null) {
                                                        addBigImageData.setMainPostMaskVisibly(this.a.v0.G.Z().S || postData5.S);
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                } else {
                                                    this.a.R = view2;
                                                    return;
                                                }
                                            }
                                        } else {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0916d6) {
                                                StatisticItem statisticItem13 = new StatisticItem("c13398");
                                                statisticItem13.param("tid", this.a.v0.m2());
                                                statisticItem13.param("fid", this.a.v0.getForumId());
                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem13.param("obj_locate", 4);
                                                TiebaStatic.log(statisticItem13);
                                            }
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091848 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (!this.a.checkUpIsLogin()) {
                                                    p48.r("c10517", this.a.v0.S1().m(), 3);
                                                    return;
                                                } else if (this.a.v0 == null || this.a.v0.S1() == null) {
                                                    return;
                                                } else {
                                                    this.a.D0.p0();
                                                    SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                    PostData postData6 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f0920b1);
                                                    PostData postData7 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f0920b2);
                                                    View view4 = (View) sparseArray17.get(R.id.obfuscated_res_0x7f0920b3);
                                                    if (postData6 == null || view4 == null) {
                                                        return;
                                                    }
                                                    if (postData6.H() == 1) {
                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                    }
                                                    StatisticItem statisticItem14 = postData6.e0;
                                                    if (statisticItem14 != null) {
                                                        StatisticItem copy3 = statisticItem14.copy();
                                                        copy3.delete("obj_locate");
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0916d6) {
                                                            copy3.param("obj_locate", 6);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091848) {
                                                            copy3.param("obj_locate", 8);
                                                        }
                                                        TiebaStatic.log(copy3);
                                                    }
                                                    String m22 = this.a.v0.m2();
                                                    String M2 = postData6.M();
                                                    String M3 = postData7 != null ? postData7.M() : "";
                                                    int Y2 = this.a.v0.S1() != null ? this.a.v0.S1().Y() : 0;
                                                    this.a.a7();
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091c4d) {
                                                        TiebaStatic.log("c11742");
                                                        AbsPbActivity.e o62 = this.a.o6(M2);
                                                        if (postData6 == null || this.a.v0 == null || this.a.v0.S1() == null || o62 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, M2, "pb", true, false, null, false, M3, Y2, postData6.e0(), this.a.v0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(o62.a, o62.b, o62.g, o62.j);
                                                        if (!xi.isEmpty(M3)) {
                                                            addBigImageData2.setHighLightPostId(M3);
                                                            addBigImageData2.setKeyIsUseSpid(true);
                                                        }
                                                        addBigImageData2.setKeyFromForumId(this.a.v0.getForumId());
                                                        addBigImageData2.setTiebaPlusData(this.a.v0.I(), this.a.v0.E(), this.a.v0.F(), this.a.v0.D(), this.a.v0.J());
                                                        addBigImageData2.setBjhData(this.a.v0.k1());
                                                        addBigImageData2.setKeyPageStartFrom(this.a.v0.R1());
                                                        addBigImageData2.setFromFrsForumId(this.a.v0.getFromForumId());
                                                        addBigImageData2.setWorksInfoData(this.a.v0.r2());
                                                        if (this.a.D0 != null && this.a.v0.G != null && (Z = this.a.v0.G.Z()) != null) {
                                                            addBigImageData2.setMainPostMaskVisibly(Z.S || postData6.S);
                                                        }
                                                        if (this.a.v0.S1() != null && this.a.v0.S1().o() != null) {
                                                            addBigImageData2.setHasForumRule(this.a.v0.S1().o().has_forum_rule.intValue());
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    } else {
                                                        AbsPbActivity.e o63 = this.a.o6(M2);
                                                        if (this.a.v0 == null || this.a.v0.S1() == null || o63 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, M2, "pb", true, false, null, true, null, Y2, postData6.e0(), this.a.v0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(o63.a, o63.b, o63.g, o63.j);
                                                        addBigImageData3.setKeyPageStartFrom(this.a.v0.R1());
                                                        addBigImageData3.setFromFrsForumId(this.a.v0.getFromForumId());
                                                        addBigImageData3.setWorksInfoData(this.a.v0.r2());
                                                        addBigImageData3.setKeyFromForumId(this.a.v0.getForumId());
                                                        addBigImageData3.setBjhData(this.a.v0.k1());
                                                        addBigImageData3.setTiebaPlusData(this.a.v0.I(), this.a.v0.E(), this.a.v0.F(), this.a.v0.D(), this.a.v0.J());
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                    }
                                                }
                                            } else {
                                                this.a.R = view2;
                                                return;
                                            }
                                        }
                                    } else if (this.a.v0 == null || this.a.v0.S1() == null || this.a.v0.S1().Q() == null) {
                                        return;
                                    } else {
                                        this.a.D0.h.k();
                                        TiebaStatic.log(new StatisticItem("c13062"));
                                        PbFragment pbFragment7 = this.a;
                                        pbFragment7.H5(pbFragment7.v0.S1().Q().getFirstPostId());
                                    }
                                } else {
                                    this.a.D0.p0();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                        return;
                                    } else if (this.a.h) {
                                        view2.setTag(Integer.valueOf(this.a.v0.i2()));
                                        return;
                                    } else {
                                        this.a.a7();
                                        this.a.D0.s3();
                                        sv4 sv4Var = new sv4(this.a.getPageContext());
                                        if (this.a.v0.S1().f == null || this.a.v0.S1().f.size() <= 0) {
                                            strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f120a), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f120b)};
                                        } else {
                                            strArr = new String[this.a.v0.S1().f.size()];
                                            for (int i12 = 0; i12 < this.a.v0.S1().f.size(); i12++) {
                                                strArr[i12] = this.a.v0.S1().f.get(i12).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1208);
                                            }
                                        }
                                        sv4Var.i(null, strArr, new a(this, sv4Var, view2));
                                        sv4Var.k();
                                    }
                                }
                            } else {
                                this.a.D0.p0();
                                if (this.a.K().S1().g == 2) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f089e);
                                    return;
                                }
                                if (this.a.v0.Q1() != null) {
                                    this.a.D0.b4(this.a.v0.Q1(), this.a.f2);
                                }
                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            }
                        } else {
                            this.a.D0.h.k();
                        }
                    } else {
                        this.a.D0.h.l();
                        if (this.a.v0 != null) {
                            this.a.s1.f(this.a.v0.m2());
                        }
                        if (this.a.v0 != null && this.a.v0.isPrivacy()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0f5c);
                            if (this.a.K() == null || this.a.K().S1() == null) {
                                return;
                            }
                            this.a.s1.d(3, 3, this.a.K().S1().S());
                            return;
                        }
                        this.a.s1.b();
                        int i13 = (TbSingleton.getInstance().mCanCallFans || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().S() == null || !this.a.K().S1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                        if (this.a.K() != null && this.a.K().S1() != null) {
                            this.a.s1.d(3, i13, this.a.K().S1().S());
                        }
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e18).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091c3d) {
                        String k5 = this.a.k5();
                        if (TextUtils.isEmpty(k5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{k5});
                    }
                } else if (!this.a.q0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.v0.m2());
                    statisticItem15.param("fid", this.a.v0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.obfuscated_res_0x7f0920ae) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.obfuscated_res_0x7f0920ae)).booleanValue()) {
                        p48.s(2);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (!this.a.v) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f092094);
                        if (!(obj instanceof PostData)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        PostData postData8 = (PostData) obj;
                        if (this.a.v0 != null && this.a.v0.S1() != null && this.a.y5().c1() != null && postData8.s() != null && postData8.D() != 1) {
                            if (!this.a.checkUpIsLogin()) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                return;
                            }
                            if (this.a.y5().d1() != null) {
                                this.a.y5().d1().c();
                            }
                            ey7 ey7Var2 = new ey7();
                            ey7Var2.A(this.a.v0.S1().l());
                            ey7Var2.E(this.a.v0.S1().Q());
                            ey7Var2.C(postData8);
                            this.a.y5().c1().V(ey7Var2);
                            this.a.y5().c1().setPostId(postData8.M());
                            this.a.Y5(view2, postData8.s().getUserId(), "", postData8);
                            TiebaStatic.log("c11743");
                            p48.b(this.a.v0.S1(), postData8, postData8.d0, 8, 1);
                            if (this.a.S0 != null) {
                                this.a.D0.V2(this.a.S0.y());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    this.a.v = false;
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class a implements uv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sv4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ l1 c;

            public a(l1 l1Var, sv4 sv4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, sv4Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = l1Var;
                this.a = sv4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.v0.j2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.uv4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void n0(uv4 uv4Var, int i, View view2) {
                boolean L3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.v0.j2() != 1 || i != 1) {
                        if (this.c.a.v0.j2() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.v0.j2() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f0918bb) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.v0.S1().f != null && this.c.a.v0.S1().f.size() > i) {
                            i = this.c.a.v0.S1().f.get(i).sort_type.intValue();
                        }
                        L3 = this.c.a.v0.L3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.v0.i2()));
                        if (L3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.D0.g3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f0918bb) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.v0.S1().f != null) {
                        i = this.c.a.v0.S1().f.get(i).sort_type.intValue();
                    }
                    L3 = this.c.a.v0.L3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.v0.i2()));
                    if (L3) {
                    }
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
    }

    /* loaded from: classes5.dex */
    public class o1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ o1 b;

            public a(o1 o1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = o1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D0 != null && this.a != null) {
                    this.b.a.D0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(o1 o1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o1 a;

            public c(o1 o1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = o1Var;
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b35 b35Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v0.S1() != null) {
                        statisticItem.param("fid", this.a.v0.S1().m());
                    }
                    statisticItem.param("tid", this.a.v0.m2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (xi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.a7();
                this.a.D0.q3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.B0 != null) {
                    this.a.B0.U(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    ah.a().postDelayed(this.a.W1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.S0.x() || this.a.S0.z()) {
                            this.a.S0.w(false, postWriteCallBackData);
                        }
                        this.a.H0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.V0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f048b), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        jv4 jv4Var = new jv4(this.a.getActivity());
                        if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                            jv4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d3b));
                        } else {
                            jv4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this));
                        jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3d, new c(this));
                        jv4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (lw8.d(i) || b35Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.I6(i, antiData, str);
                        return;
                    }
                }
                this.a.T6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.J6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.D0.G1(this.a.v0.S1());
                    }
                } else if (this.a.v0.v1()) {
                    ox7 S1 = this.a.v0.S1();
                    if (S1 != null && S1.Q() != null && S1.Q().getAuthor() != null && (userId = S1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.v0.I3()) {
                        this.a.D0.s3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.v0.I3()) {
                    this.a.D0.s3();
                }
                if (this.a.v0.z1()) {
                    p48.p("c10369", this.a.v0.m2(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    ah.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.v0 != null) {
                    Context context = this.a.getContext();
                    ox7 S12 = this.a.v0.S1();
                    String forumId = this.a.v0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    q18.a(context, S12, forumId, z2, this.a.v0.X1(), this.a.v0.a2(), this.a.v0.Z1(), this.a.v0.Y1(), this.a.v0.e2(), this.a.v0.f2());
                }
                if (writeData != null) {
                    l05.b(writeData.getContent(), "1");
                }
                if (this.a.Q5()) {
                    this.a.d7();
                }
                this.a.R6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ p1 b;

            public a(p1 p1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = p1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D0 != null && this.a != null) {
                    this.b.a.D0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(p1 p1Var) {
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
                    }
                }
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p1 a;

            public c(p1 p1Var) {
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

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b35 b35Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v0 != null && this.a.v0.S1() != null) {
                        statisticItem.param("fid", this.a.v0.S1().m());
                    }
                    if (this.a.v0 != null) {
                        statisticItem.param("tid", this.a.v0.m2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.q5()) {
                        this.a.B6(false);
                        sw7.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1264));
                    }
                    v18 v18Var = this.a.H0;
                    if (v18Var != null) {
                        v18Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        p45.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        l05.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        ah.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.Q5()) {
                        this.a.d7();
                    }
                    this.a.R6();
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.V0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f048b), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    jv4 jv4Var = new jv4(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        jv4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d3b));
                    } else {
                        jv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this));
                    jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3d, new c(this));
                    jv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.H0 != null) {
                        if (pbFragment.D0 != null && this.a.D0.d1() != null && this.a.D0.d1().b() != null && this.a.D0.d1().b().y()) {
                            this.a.D0.d1().b().w(postWriteCallBackData);
                        }
                        this.a.H0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r1 a;

            public a(r1 r1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = r1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                hz4 hz4Var = new hz4();
                hz4Var.b = R.raw.obfuscated_res_0x7f110028;
                hz4Var.a = BreatheTipWidget.PointType.LOTTIE;
                hz4Var.c = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                iz4 iz4Var = new iz4();
                iz4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f0512);
                iz4Var.b = this.a.a.getString(R.string.obfuscated_res_0x7f0f00eb);
                iz4Var.e = R.drawable.pic_guidecard;
                iz4Var.f = yi.g(this.a.a.getContext(), R.dimen.tbds156);
                iz4Var.g = yi.g(this.a.a.getContext(), R.dimen.tbds489);
                iz4Var.h = yi.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.D0.h1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.D0.h1()));
                breatheTipWidget.f(iz4Var, hz4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    py4 k = py4.k();
                    k.u("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    k45.a("c14828");
                }
            }
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(ox7 ox7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ox7Var) == null) {
                this.a.D0.G1(ox7Var);
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
            ye5 ye5Var = new ye5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            ye5Var.c();
            if (z2) {
                j3 = j4;
                ye5Var.B = j3;
                ye5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().Q() != null) {
                int threadType = this.a.v0.S1().Q().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.L, "from_personalize")) {
                        ue5 ue5Var = new ue5();
                        ue5Var.F = 1;
                        ue5Var.a(1005);
                        ue5Var.D = j3;
                        ue5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.L, "from_frs")) {
                        ye5 ye5Var2 = new ye5();
                        ye5Var2.a(1000);
                        ye5Var2.D = j3;
                        ye5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ox7 ox7Var, String str, int i4) {
            int i5;
            r65 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ox7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906eb));
                }
                if (z && ox7Var != null && ox7Var.a0() == null && ListUtils.getCount(ox7Var.H()) < 1) {
                    this.a.v0.F3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.D0 != null) {
                        this.a.D0.Y3();
                        return;
                    }
                    return;
                }
                if (this.a.f0) {
                    if (this.a.K() != null) {
                        this.a.K().Z0();
                    }
                } else {
                    this.a.f0 = true;
                }
                this.a.g = true;
                if (this.a.D0 == null) {
                    return;
                }
                this.a.D0.r3();
                if (ox7Var == null || !ox7Var.t0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.D0.n1());
                }
                this.a.D0.v1();
                if (!this.a.I && !this.a.D0.R1()) {
                    if (!this.a.D0.L1()) {
                        this.a.D0.F3(false);
                    }
                } else {
                    this.a.D0.p1();
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && ox7Var != null) {
                    this.a.L0 = true;
                }
                if (ox7Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.D0.n1());
                    this.a.D0.A3();
                }
                ArrayList<PostData> arrayList = null;
                String f1 = null;
                arrayList = null;
                if (z && ox7Var != null) {
                    ThreadData Q = ox7Var.Q();
                    if (Q != null && Q.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.E6(pbFragment3.R0);
                    }
                    this.a.D0.d1().m(ox7Var);
                    this.a.D0.M3();
                    if (Q != null && Q.getCartoonThreadData() != null) {
                        this.a.h7(Q.getCartoonThreadData());
                    }
                    if (this.a.S0 != null) {
                        this.a.D0.V2(this.a.S0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(ox7Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(ox7Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ox7Var.X().getBimg_end_time());
                    if (ox7Var.H() != null && ox7Var.H().size() >= 1 && ox7Var.H().get(0) != null) {
                        this.a.v0.r3(ox7Var.H().get(0).M());
                    } else if (ox7Var.a0() != null) {
                        this.a.v0.r3(ox7Var.a0().M());
                    }
                    if (this.a.S0 != null) {
                        this.a.S0.H(ox7Var.d());
                        this.a.S0.I(ox7Var.l(), ox7Var.X());
                        this.a.S0.k0(Q);
                        this.a.S0.J(this.a.v0.u1(), this.a.v0.m2(), this.a.v0.q1());
                        if (Q != null) {
                            this.a.S0.Z(Q.isMutiForumThread());
                        }
                    }
                    if (this.a.x0 != null) {
                        this.a.x0.h(ox7Var.r());
                    }
                    if (ox7Var.s() == 1) {
                        this.a.r = true;
                    } else {
                        this.a.r = false;
                    }
                    if (ox7Var.l0()) {
                        this.a.r = true;
                    }
                    this.a.D0.W2(this.a.r);
                    if (this.a.s0.f.size() > 0) {
                        ox7Var.S0(this.a.s0.f);
                    }
                    this.a.D0.Q3(ox7Var, i2, i3, this.a.v0.k2(), i4, this.a.v0.B1());
                    this.a.D0.f4(ox7Var, this.a.v0.k2());
                    this.a.D0.k4(this.a.v0.v1());
                    AntiData d = ox7Var.d();
                    if (d != null) {
                        this.a.y = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.S0 != null && this.a.S0.b() != null && (m = this.a.S0.b().m(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) m).setOnClickListener(this.a.F1);
                        }
                    }
                    if (!this.a.W && !ListUtils.isEmpty(this.a.v0.S1().H()) && !this.a.v0.D2()) {
                        this.a.W = true;
                        this.a.N4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.O0)) {
                        o28.i(this.a.v0.R1(), this.a.getListView(), this.a.O0);
                        this.a.O0 = null;
                    } else if (!this.a.N0) {
                        if (!this.a.P0) {
                            if (!TextUtils.isEmpty(this.a.v0.I1())) {
                                o28.f(this.a.getListView(), this.a.v0.I1());
                                this.a.v0.L2();
                            } else {
                                this.a.D0.L3();
                            }
                        } else {
                            this.a.P0 = false;
                            o28.j(this.a.getListView());
                        }
                    } else {
                        this.a.N0 = false;
                        o28.g(this.a.getListView());
                    }
                    this.a.v0.M2(ox7Var.l(), this.a.L1);
                    this.a.v0.S2(this.a.N1);
                    if (this.a.V0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.V0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.v0 != null && this.a.v0.A2()) {
                        f1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e37);
                    } else if (this.a.D0 != null) {
                        f1 = this.a.D0.f1();
                    }
                    if (!StringUtils.isNull(f1)) {
                        this.a.S0.c0(TbSingleton.getInstance().getAdVertiComment(ox7Var.r0(), ox7Var.s0(), f1));
                    }
                } else if (str != null) {
                    if (!this.a.L0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.v0.h1() != null && !StringUtils.isNull(this.a.v0.h1().c)) {
                                    this.a.D0.m4(this.a.v0.h1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.D0.n1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c80, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.D0.n1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c80, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                            }
                            this.a.D0.p1();
                            this.a.D0.o1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.v0.m2());
                            jSONObject.put("fid", this.a.v0.getForumId());
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
                        if (this.a.v0 != null && this.a.v0.S1() != null) {
                            arrayList = this.a.v0.S1().H();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                            this.a.D0.R2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1d));
                        } else {
                            if (this.a.S5()) {
                                this.a.D0.S2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e28));
                            } else {
                                this.a.D0.S2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e29));
                            }
                            this.a.D0.G1(this.a.v0.S1());
                        }
                    } else {
                        this.a.D0.R2("");
                    }
                    this.a.D0.x0();
                }
                if (ox7Var != null && ox7Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (!this.a.K().k2() || this.a.K().S1().z().c() != 0 || this.a.K().x2()) {
                    this.a.T0 = true;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (ox7Var != null) {
                        i5 = ox7Var.g();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.C1(i5, this.a.D0);
                }
                int l = py4.k().l(py4.o("key_reaction_guide_show_number_pb"), 0);
                if (this.a.a != null && this.a.a.getIntent() != null && this.a.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false)) {
                    if (l != 1 && l != 2 && l != 3) {
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
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.v0 == null) {
                return;
            }
            if (this.a.S0 != null && this.a.S0.t) {
                return;
            }
            l85 l85Var = new l85();
            this.a.E6(l85Var);
            PbFragment pbFragment = this.a;
            pbFragment.S0 = (m85) l85Var.a(pbFragment.getContext());
            this.a.S0.W(this.a.a.getPageContext());
            this.a.S0.f0(this.a.l2);
            this.a.S0.g0(this.a.Y0);
            m85 m85Var = this.a.S0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            m85Var.A(pageContext, extras);
            this.a.S0.b().C(true);
            this.a.D0.Q2(this.a.S0.b());
            if (!this.a.v0.F1()) {
                this.a.S0.q(this.a.v0.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.S0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.v0.A2()) {
                this.a.S0.c0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e37));
            } else if (this.a.D0 != null) {
                this.a.S0.c0(this.a.D0.f1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                py4 k = py4.k();
                if (!k.h("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    ah.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements z96.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.z96.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.z96.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.z96.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.D0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.p5()) {
                    this.b.D0.u1();
                    this.b.D0.P2();
                }
            }
        }

        @Override // com.baidu.tieba.z96.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.D0 != null && this.b.e != null) {
                this.b.D0.V3();
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.X4();
        }
    }

    /* loaded from: classes5.dex */
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
    public class a2 implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements ItemCardHelper.c {
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
    public static class b implements aa6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tieba.aa6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    py7.d();
                } else {
                    py7.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements SuggestEmotionModel.c {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(s28 s28Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, s28Var) != null) || s28Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, s28Var.c()));
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
    public static class b1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b1() {
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
        public void onNavigationButtonClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.y0.getLoadDataMode()) {
                    case 0:
                        this.a.v0.v2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.d5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.D0.z0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.e5(pbFragment.y0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.D0.z0(this.a.y0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.D0.p2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.D0.z0(this.a.y0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes5.dex */
    public class b3 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.v0.H1()) {
                    this.a.u6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements h08.b {
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

        @Override // com.baidu.tieba.h08.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f152e);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.D0.n0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!this.a.j0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.k6();
                        return;
                    } else {
                        this.a.w6();
                        return;
                    }
                }
                this.a.j0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                this.a.J5();
                tt4 Q1 = this.a.v0.Q1();
                int a1 = this.a.D0.a1();
                if (a1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e2b);
                } else if (Q1 != null && a1 > Q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e2b);
                } else {
                    this.a.D0.p0();
                    this.a.a7();
                    this.a.D0.s3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.v0.F3(this.a.D0.a1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                    }
                    jv4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c3 implements pg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f0918bf);
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
    public class d implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    jv4Var.dismiss();
                    ((TbPageContext) this.a.d1).showToast(R.string.obfuscated_res_0x7f0f0730);
                    return;
                }
                TiebaStatic.log("c10025");
                jv4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.d1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements GetSugMatchWordsModel.b {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.D0 != null) {
                this.a.D0.x3(list);
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
    public class d1 implements h3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.v0.S1().X().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.S1().l().getId(), this.a.v0.S1().l().getName(), this.a.v0.S1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements i3 {
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
    }

    /* loaded from: classes5.dex */
    public class d3 implements View.OnTouchListener {
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
    public class e implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements PraiseModel.b {
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

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.O1 = false;
            if (this.a.P1 != null && str != null) {
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
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            this.a.O1 = false;
            if (this.a.P1 == null) {
                return;
            }
            ox7 S1 = this.a.v0.S1();
            if (S1.Q().getPraise().getIsLike() == 1) {
                this.a.i7(0);
            } else {
                this.a.i7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, S1.Q()));
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements uv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.uv4.e
        public void n0(uv4 uv4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
                if (this.a.I0 != null) {
                    this.a.I0.dismiss();
                }
                this.a.f7(i);
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
                                                    l95.a aVar = new l95.a();
                                                    aVar.a = this.a.j1;
                                                    String str = "";
                                                    if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.l1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.L4();
                                                }
                                                this.a.i1 = null;
                                                this.a.j1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.i1 != null && !TextUtils.isEmpty(this.a.j1)) {
                                                if (this.a.U0 == null) {
                                                    this.a.U0 = new PermissionJudgePolicy();
                                                }
                                                this.a.U0.clearRequestPermissionList();
                                                this.a.U0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.U0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.h1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.h1 = new x18(pbFragment.getPageContext());
                                                }
                                                this.a.h1.b(this.a.j1, this.a.i1.n());
                                                this.a.i1 = null;
                                                this.a.j1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.D2;
                                            if (postData != null) {
                                                postData.F0();
                                                this.a.D2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.c6(view2);
                                            if (this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getAuthor() != null && this.a.v0.S1().Q().getAuthor().getUserId() != null && this.a.x0 != null) {
                                                int w = q18.w(this.a.v0.S1());
                                                ThreadData Q = this.a.v0.S1().Q();
                                                if (Q.isBJHArticleThreadType()) {
                                                    i2 = 2;
                                                } else if (Q.isBJHVideoThreadType()) {
                                                    i2 = 3;
                                                } else if (!Q.isBJHNormalThreadType()) {
                                                    if (Q.isBJHVideoDynamicThreadType()) {
                                                        i2 = 5;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v0.b).param("obj_locate", 2).param("obj_id", this.a.v0.S1().Q().getAuthor().getUserId()).param("obj_type", !this.a.x0.e()).param("obj_source", w).param("obj_param1", i2));
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                                return;
                                            }
                                            Object tag = view2.getTag();
                                            if (tag instanceof String) {
                                                TiebaStatic.log(new StatisticItem("c13079"));
                                                this.a.H5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f0920a7, 0);
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f092090, 2);
                                                    this.a.P4(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092098) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092096) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f0920b4) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f0920a8) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f0920b4)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f0920a8)).booleanValue();
                                                boolean F = this.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                                if (F) {
                                                    if (booleanValue2) {
                                                        this.a.D0.s2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f092096), intValue, booleanValue, null, F);
                                                        return;
                                                    } else {
                                                        this.a.L6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.D0.q2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f092096), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.L6(sparseArray3, intValue, booleanValue);
                                                    return;
                                                }
                                            }
                                            return;
                                        case 7:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                                return;
                                            }
                                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                                            if (sparseArray4.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a7, 1);
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092090, 2);
                                                    this.a.P4(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092090, 2);
                                                }
                                                this.a.D0.v2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.D0.q2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
                                            if (postData2.q() == null) {
                                                return;
                                            }
                                            this.a.S4(postData2.q());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.v0 != null && this.a.v0.S1() != null) {
                                                this.a.a.u1(lw8.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.v0 != null && this.a.v0.S1() != null) {
                                    this.a.D0.r4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09182a);
                            if (view3 == null) {
                                return;
                            }
                            this.a.q6(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09182a);
                        if (view4 != null) {
                            AgreeView agreeView2 = (AgreeView) view4;
                            this.a.q6(view4);
                            if (agreeView2.getImgDisagree() != null) {
                                agreeView2.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SparseArray sparseArray5 = (SparseArray) view2.getTag();
                    View view5 = (View) sparseArray5.get(R.id.obfuscated_res_0x7f091827);
                    this.a.q6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.obfuscated_res_0x7f0920ae) instanceof Boolean)) {
                            if (((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f0920ae)).booleanValue()) {
                                this.a.B6(true);
                            } else {
                                this.a.B6(false);
                            }
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091828);
                this.a.q6(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements zy4.g {
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

        @Override // com.baidu.tieba.zy4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.p5()) {
                    this.a.a.finish();
                }
                if (this.a.v0.R2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.D0.y0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements y08.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.y08.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

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

        @Override // com.baidu.tieba.y08.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.D0.g4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.D0.c4(!this.a.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public f1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                if (jv4Var != null) {
                    jv4Var.dismiss();
                }
                this.d.a5(((Integer) this.a.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f092096), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.p5()) {
                    this.a.a.finish();
                }
                if (this.a.v0.R2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.D0.y0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public g(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                this.b.D0.N3();
                MessageManager.getInstance().sendMessage(this.a);
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements x28.h {
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

        @Override // com.baidu.tieba.x28.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.D6(z);
                if (this.a.D0.Q0() != null && z) {
                    this.a.D0.c4(false);
                }
                this.a.D0.h2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y2 && this.a.p5()) {
                    this.a.U5();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.e0 && this.a.D0 != null && this.a.D0.g0() && this.a.v0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.v0.m2());
                    statisticItem.param("fid", this.a.v0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.v0.x1()) {
                        i = 4;
                    } else if (this.a.v0.y1()) {
                        i = 3;
                    } else if (this.a.v0.A1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.e0 = true;
                }
                if (this.a.v0.N2(false)) {
                    this.a.D0.t3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if ((this.a.s0 == null || !this.a.v0.H2() || !this.a.s0.d()) && this.a.v0.S1() != null) {
                    this.a.D0.I2();
                }
                this.a.y2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<s18> a;
        public WeakReference<PbFragment> b;

        public g3(s18 s18Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s18Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(s18Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                s18 s18Var = this.a.get();
                if (s18Var != null) {
                    s18Var.t1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.U6(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        cy6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements uv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public h0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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

        @Override // com.baidu.tieba.uv4.e
        public void n0(uv4 uv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
                if (this.e.I0 != null) {
                    this.e.I0.dismiss();
                }
                if (i == 0) {
                    this.e.D0.q2(((Integer) this.a.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f092096), ((Integer) this.a.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f0920ee);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f0920f0);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f0920ef);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.f1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.f1);
                    this.e.W6(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f0920ec));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements zs6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.zs6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.zs6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
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

        @Override // com.baidu.tieba.zs6.d
        public void b(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3);
                if (z) {
                    i = 5;
                } else {
                    i = 6;
                }
                TiebaStatic.log(param.param("obj_locate", i).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    if (this.a.S0 != null && this.a.S0.b() != null) {
                        this.a.S0.b().A(new k65(45, 27, null));
                    }
                    this.a.D0.i0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.v0 != null) {
                this.a.v0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends nj5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public i(PbFragment pbFragment, int i) {
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
        @Override // com.baidu.tieba.nj5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.t3(this.a);
                }
                return o38.d(this.b.h5(), 2, K);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.S2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.i5().s() != null && this.a.i5().s().getGodUserData() != null) {
                        this.a.i5().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getAuthor() != null) {
                        this.a.v0.S1().Q().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements SortSwitchButton.f {
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

        public i1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
                this.a.D0.p0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                    return false;
                }
                if (this.a.v0 != null && !this.a.v0.isLoading) {
                    this.a.a7();
                    this.a.D0.s3();
                    z = true;
                    if (this.a.v0.S1() != null && this.a.v0.S1().f != null && this.a.v0.S1().f.size() > i) {
                        int intValue = this.a.v0.S1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.v0.n2()).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.v0.L3(intValue)) {
                            this.a.h = true;
                            this.a.D0.g3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements j85 {
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

        @Override // com.baidu.tieba.j85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                v18 v18Var = this.a.H0;
                if (v18Var != null && v18Var.g() != null && this.a.H0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.H0.g().c());
                    if (this.a.D0 != null && this.a.D0.d1() != null && this.a.D0.d1().b() != null && this.a.D0.d1().b().y()) {
                        this.a.D0.d1().b().w(this.a.H0.h());
                    }
                    this.a.H0.b(true);
                    return true;
                } else if (!this.a.R4(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements si5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public j(PbFragment pbFragment, int i, int i2) {
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
        @Override // com.baidu.tieba.si5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends ub5<TipEvent> {
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
        @Override // com.baidu.tieba.nb5
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.v0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.S0 != null) {
                    this.a.D0.V2(this.a.S0.y());
                }
                this.a.D0.N2();
                this.a.D0.p0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends ub5<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nb5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.D0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.D0.n1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ jv4 c;
        public final /* synthetic */ PbFragment d;

        public k2(PbFragment pbFragment, MarkData markData, MarkData markData2, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, jv4Var};
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
            this.c = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                if (this.d.x0 != null) {
                    if (this.d.x0.e()) {
                        this.d.x0.d();
                        this.d.x0.h(false);
                    }
                    this.d.x0.i(this.a);
                    this.d.x0.h(true);
                    this.d.x0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.b7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData)) {
                return;
            }
            this.a.v0.N3((UserPendantData) customResponsedMessage.getData());
            if (this.a.D0 != null && this.a.v0 != null) {
                this.a.D0.G2(this.a.v0.S1(), this.a.v0.k2(), this.a.v0.c2(), this.a.D0.j1());
            }
            if (this.a.D0 != null && this.a.D0.D0() != null) {
                this.a.D0.D0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public l0(PbFragment pbFragment, Intent intent) {
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
            s18 s18Var = this.b.D0;
            s18Var.v3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ jv4 b;
        public final /* synthetic */ PbFragment c;

        public l2(PbFragment pbFragment, MarkData markData, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, jv4Var};
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
            this.b = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.b7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.D0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.D0.X3();
                } else {
                    this.a.D0.v1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.S0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.D0 != null && this.a.D0.d1() != null && this.a.D0.d1().b() != null) {
                    this.a.D0.d1().b().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements k85 {
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

        @Override // com.baidu.tieba.k85
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ jv4 b;
        public final /* synthetic */ PbFragment c;

        public m2(PbFragment pbFragment, MarkData markData, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, jv4Var};
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
            this.b = jv4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.D0 != null && this.c.D0.n1() != null) {
                    this.c.D0.n1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.b7();
                }
            }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.S0 != null) {
                this.a.D0.V2(this.a.S0.y());
            }
            this.a.D0.F3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.v0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.v0.b)) {
                return;
            }
            this.a.T6((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements pg<ImageView> {
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
                    foreDrawableImageView.O();
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
                    if (br4.c().g()) {
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = br4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                uw7 uw7Var = (uw7) customResponsedMessage.getData();
                int type = uw7Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (uw7Var.a() == null) {
                                this.a.s6(false, null);
                                return;
                            } else {
                                this.a.s6(true, (MarkData) uw7Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.d5((ForumManageModel.b) uw7Var.a(), false);
                    return;
                }
                this.a.t6((ey7) uw7Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements qw7.d {
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

        @Override // com.baidu.tieba.qw7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements pg<GifView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.b0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.e0();
                gifView.b0();
                gifView.setImageDrawable(null);
                gifView.f0();
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
                if (br4.c().g()) {
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = br4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.D0 != null && this.a.D0.D0() != null) {
                this.a.D0.D0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements qy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.qy7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.qy7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091c6b) {
                        if (this.a.x6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090156) {
                        if (!(view2.getTag() instanceof SparseArray)) {
                            return false;
                        }
                        Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f092094);
                        if (!(obj instanceof PostData)) {
                            return false;
                        }
                        PostData postData = (PostData) obj;
                        if (postData.getType() != PostData.Q0 && !TextUtils.isEmpty(postData.v()) && br4.c().g()) {
                            return this.a.e6(postData);
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091847) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f0920a7) instanceof SparseArray) {
                            this.a.Y6((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f0920a7));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f0918a3) {
                        if (this.a.D0.M1() && view2.getId() == R.id.obfuscated_res_0x7f091866) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f0920ea) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f0920ea)));
                            }
                            if (this.a.y0() != null && this.a.y0().b != null) {
                                this.a.y0().b.onClick(view2);
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
                        this.a.Y6(sparseArray);
                    }
                }
                if (this.a.S0 != null) {
                    this.a.D0.V2(this.a.S0.y());
                }
                this.a.D0.N2();
                this.a.D0.p0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.qy7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.b5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements pg<TiebaPlusRecommendCard> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xm5.a)) {
                xm5.a aVar = (xm5.a) customResponsedMessage.getData();
                xm5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.v0 != null && this.a.v0.D1()) {
                    this.a.Z5();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q1 extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q1(PbFragment pbFragment, int i, int i2) {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView l1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        yi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1423);
                        if (this.a.D0 != null && (l1 = this.a.D0.l1()) != null && this.a.D0.T0() != null) {
                            this.a.D0.T0().removeHeaderView(l1);
                            return;
                        }
                        return;
                    }
                    yi.P(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements pg<View> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.s0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.X6();
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements lv4.c {
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

        @Override // com.baidu.tieba.lv4.c
        public void a(lv4 lv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lv4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.K0 = pbFragment.K0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.K0);
                    new uz7(this.a.v0.m2(), this.a.K0, "1").start();
                    lv4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.K0 = pbFragment2.K0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.K0);
                    new uz7(this.a.v0.m2(), this.a.K0, "2").start();
                    lv4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.K0 = pbFragment3.K0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.K0);
                    lv4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r2 implements pg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0d0a));
                bdTopToast.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
            this.a.g7();
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements pg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.x0 == null || this.a.x0.e()) {
                    return;
                }
                this.a.b6();
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.D0.t1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                ox7 S1 = this.a.v0.S1();
                if (S1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S1.w().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.d(this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b6b));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b67);
                    }
                    this.a.V6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (xi.isEmpty(errorString2)) {
                        errorString2 = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b68);
                    }
                    this.a.e1.c(errorString2);
                } else {
                    this.a.O6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t1(PbFragment pbFragment, int i, boolean z) {
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
                if (this.a.D0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.D0.n1());
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
                    bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0328));
                    bdTopToast.i((ViewGroup) this.a.getView());
                    this.a.F6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
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
    public class t2 implements f3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.f3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.D0 != null && this.a.D0.d1() != null) {
                    l08 d1 = this.a.D0.d1();
                    if (d1.f()) {
                        d1.d();
                        return true;
                    }
                }
                if (this.a.D0 != null && this.a.D0.U1()) {
                    this.a.D0.x1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class u implements TiePlusEventController.f {
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

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.v = true;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.D0.t1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.d(this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f14fd));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (xi.isEmpty(muteMessage)) {
                    muteMessage = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f14fc);
                }
                this.a.e1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements kp4.a {
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

        @Override // com.baidu.tieba.kp4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.D0.r3();
                if (z) {
                    if (this.a.x0 != null) {
                        this.a.x0.h(z2);
                    }
                    this.a.v0.H3(z2);
                    if (!this.a.v0.D1()) {
                        this.a.D0.G1(this.a.v0.S1());
                    } else {
                        this.a.Z5();
                    }
                    if (z2) {
                        boolean q0 = this.a.v0.S1().q0();
                        if (this.a.x0 != null && !q0) {
                            if (this.a.x0.f() != null && this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().Q() != null && this.a.v0.S1().Q().getAuthor() != null) {
                                MarkData f = this.a.x0.f();
                                MetaData author = this.a.v0.S1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                        this.a.S6();
                                    } else {
                                        this.a.N6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.K4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f1025));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1524));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u2 implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            zz7 D0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.D0.e2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.v0.m2());
                    statisticItem.param("fid", this.a.v0.getForumId());
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
                        boolean w = ((TbImageView) view2).w();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                        }
                        this.a.Q = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.m6(str, i, eVar);
                    if (this.a.v0.G.l0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().D() != null) {
                            ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < D.size()) {
                                if (D.get(i5) != null) {
                                    arrayList.add(D.get(i5).F());
                                    if (i6 == i4 && str != null && (str.equals(D.get(i5).F()) || str.equals(D.get(i5).B()) || str.equals(D.get(i5).z()) || str.equals(D.get(i5).A()) || str.equals(D.get(i5).D()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = D.get(i5).F();
                                    imageUrlData.originalUrl = D.get(i5).F();
                                    imageUrlData.isLongPic = D.get(i5).I();
                                    concurrentHashMap.put(D.get(i5).F(), imageUrlData);
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
                        this.a.f5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.v0.d2());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.S5());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.v0 != null) {
                            builder.D(this.a.v0.getFromForumId());
                            if (this.a.v0.S1() != null) {
                                builder.Q(this.a.v0.S1().Q());
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
                        builder2.I(this.a.v0.d2());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.S5());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.v0 != null) {
                            builder2.D(this.a.v0.getFromForumId());
                            if (this.a.v0.S1() != null) {
                                builder2.Q(this.a.v0.S1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText j7 = this.a.j7(str, i);
                        if (j7 != null && this.a.A2 >= 0 && this.a.A2 < j7.B().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = px7.a(j7.B().get(this.a.A2));
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
                            if (j7.getPostId() != 0 && (D0 = this.a.D0.D0()) != null) {
                                ArrayList<xn> t = D0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<xn> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        xn next = it.next();
                                        if ((next instanceof PostData) && j7.getPostId() == xg.g(((PostData) next).M(), 0L)) {
                                            int i8 = 8;
                                            if (j7.getPostId() == xg.g(this.a.v0.q1(), 0L)) {
                                                i8 = 1;
                                            }
                                            p48.b(this.a.v0.S1(), (PostData) next, ((PostData) next).d0, i8, 3);
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
                            this.a.f5(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.v0.d2());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.S5());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.v0 != null) {
                                builder3.D(this.a.v0.getFromForumId());
                                if (this.a.v0.S1() != null) {
                                    builder3.Q(this.a.v0.S1().Q());
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
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.Q5() || this.a.a == null || this.a.a.j1() == null || !str.equals(this.a.a.j1().getTopicId())) {
                    return;
                }
                this.a.e7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public v1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements lv4.c {
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

        @Override // com.baidu.tieba.lv4.c
        public void a(lv4 lv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lv4Var, i, view2) == null) {
                if (lv4Var != null) {
                    lv4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.D2;
                if (postData != null) {
                    if (i == 0) {
                        postData.F0();
                        this.a.D2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.d6(pbFragment2.D2);
                    }
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ct4)) {
                ct4 ct4Var = (ct4) customResponsedMessage.getData();
                vt4.a aVar = new vt4.a();
                int i = ct4Var.a;
                String str = ct4Var.b;
                aVar.a = ct4Var.d;
                ox7 S1 = this.a.v0.S1();
                if (S1 == null) {
                    return;
                }
                if (this.a.v0.u1() != null && this.a.v0.u1().getUserIdLong() == ct4Var.p) {
                    this.a.D0.F2(ct4Var.l, this.a.v0.S1(), this.a.v0.k2(), this.a.v0.c2());
                }
                if (S1.H() != null && S1.H().size() >= 1 && S1.H().get(0) != null) {
                    long g = xg.g(S1.H().get(0).M(), 0L);
                    long g2 = xg.g(this.a.v0.m2(), 0L);
                    if (g == ct4Var.n && g2 == ct4Var.m) {
                        vt4 K = S1.H().get(0).K();
                        if (K == null) {
                            K = new vt4();
                        }
                        ArrayList<vt4.a> a = K.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        K.e(K.b() + ct4Var.l);
                        K.d(a);
                        S1.H().get(0).K0(K);
                        this.a.D0.D0().Z();
                    }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ow8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                ow8 ow8Var = (ow8) customResponsedMessage.getData();
                this.a.D0.t1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.c1;
                DataRes dataRes = ow8Var.a;
                boolean z = false;
                if (ow8Var.c == 0 && dataRes != null) {
                    int e = xg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (xi.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920eb, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920eb, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920a7)).intValue();
                if (intValue != 0) {
                    if (intValue == 1) {
                        this.a.D0.u2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.P6(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public w1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                jv4Var.dismiss();
                this.b.z0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.v0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements lv4.c {
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

        @Override // com.baidu.tieba.lv4.c
        public void a(lv4 lv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lv4Var, i, view2) == null) {
                if (lv4Var != null) {
                    lv4Var.e();
                }
                if (this.a.i1 != null && !TextUtils.isEmpty(this.a.j1)) {
                    if (i == 0) {
                        if (this.a.l1 != null) {
                            l95.a aVar = new l95.a();
                            aVar.a = this.a.j1;
                            String str = "";
                            if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.l1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.L4();
                        }
                    } else if (i == 1) {
                        if (this.a.U0 == null) {
                            this.a.U0 = new PermissionJudgePolicy();
                        }
                        this.a.U0.clearRequestPermissionList();
                        this.a.U0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.U0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.h1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.h1 = new x18(pbFragment.getPageContext());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof go5)) {
                go5 go5Var = (go5) customResponsedMessage.getData();
                ox7 S1 = this.a.v0.S1();
                if (S1 == null) {
                    return;
                }
                if (this.a.v0.S1() != null && this.a.v0.S1().Z().s() != null && this.a.v0.S1().Z().s().getPortrait() != null && this.a.v0.S1().Z().s().getPortrait().equals(go5Var.a)) {
                    if (this.a.v0.S1().Z().s().getUserWorldCupData() != null) {
                        this.a.v0.S1().Z().s().getUserWorldCupData().d(go5Var.b);
                    }
                    this.a.D0.G2(this.a.v0.S1(), this.a.v0.k2(), this.a.v0.c2(), this.a.D0.j1());
                }
                if (S1.H() != null && S1.H().size() >= 0) {
                    Iterator<PostData> it = S1.H().iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (next != null && next.s() != null && next.s().getPortrait() != null && next.s().getPortrait().equals(go5Var.a) && next.s().getUserWorldCupData() != null) {
                            next.s().getUserWorldCupData().d(go5Var.b);
                        }
                    }
                    this.a.D0.D0().Z();
                }
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
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.D0.I1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.b5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements j85 {
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

        @Override // com.baidu.tieba.j85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                v18 v18Var = this.a.H0;
                if (v18Var != null && v18Var.e() != null && this.a.H0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.H0.e().c());
                    if (this.a.S0 != null && (this.a.S0.x() || this.a.S0.z())) {
                        this.a.S0.w(false, this.a.H0.h());
                    }
                    this.a.H0.a(true);
                    return true;
                } else if (this.a.R4(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.v0 == null || this.a.v0.b2() == i + 1) {
                return;
            }
            this.a.A6(q18.q(i));
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.v0 != null && this.a.v0.S1() != null) {
                this.a.v0.S1().a();
                this.a.v0.v2();
                if (this.a.D0.D0() != null) {
                    this.a.D0.G1(this.a.v0.S1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
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
            bp8 bp8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bp8) && (bp8Var = (bp8) customResponsedMessage.getData()) != null && (agreeData = bp8Var.b) != null) {
                if (this.a.D0 != null) {
                    this.a.D0.a2(bp8Var);
                }
                if (agreeData.agreeType == 2 && this.a.D0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !o38.k(this.a.v0.b)) {
                    this.a.D0.a4();
                    o38.b(this.a.v0.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> H;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.v0 != null && this.a.v0.S1() != null && this.a.D0 != null && this.a.D0.D0() != null) {
                this.a.D0.n2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.v0.E2() && (H = this.a.v0.S1().H()) != null && !H.isEmpty()) {
                    int w = ((i + i2) - this.a.D0.D0().w()) - 1;
                    ox7 S1 = this.a.v0.S1();
                    if (S1 == null) {
                        return;
                    }
                    if (S1.E() != null && S1.E().m1()) {
                        w--;
                    }
                    if (S1.F() != null && S1.F().m1()) {
                        w--;
                    }
                    int size = H.size();
                    if (w < 0 || w >= size) {
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (!q18.B(this.a.b1) && q18.B(i)) {
                    if (this.a.D0 != null) {
                        this.a.j0 = true;
                        this.a.D0.p0();
                        if (this.a.S0 != null && !this.a.D0.I1()) {
                            this.a.D0.V2(this.a.S0.y());
                        }
                        if (!this.a.I) {
                            this.a.j0 = true;
                            this.a.D0.N2();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.D0 != null) {
                    this.a.D0.o2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new se5();
                    this.a.t.a(1001);
                }
                if (i == 0) {
                    this.a.t.e();
                    if (this.a.g0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.g0);
                        this.a.g0 = null;
                    }
                } else {
                    if (this.a.g0 == null) {
                        this.a.g0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.t.d();
                }
                this.a.b1 = i;
                if (i == 0) {
                    nn8.g().h(this.a.getUniqueId(), true);
                    this.a.N4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y2 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.U4(view2);
            }
            return invokeL.booleanValue;
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
            kp8 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.v0 != null && this.a.v0.S1() != null) {
                String str = (String) customResponsedMessage.getData();
                kp8 kp8Var = null;
                if (!TextUtils.isEmpty(str) && this.a.v0.S1().H() != null) {
                    ArrayList<PostData> H = this.a.v0.S1().H();
                    Iterator<PostData> it = H.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (next instanceof kp8) {
                            kp8 kp8Var2 = (kp8) next;
                            if (str.equals(kp8Var2.n1())) {
                                kp8Var = kp8Var2;
                                break;
                            }
                        }
                    }
                    if (kp8Var != null) {
                        H.remove(kp8Var);
                    }
                }
                if (this.a.D0.D0() != null && !ListUtils.isEmpty(this.a.D0.D0().t())) {
                    ArrayList<xn> t = this.a.D0.D0().t();
                    if (kp8Var != null) {
                        i = kp8Var;
                    } else {
                        i = q18.i(this.a.v0.S1(), str);
                    }
                    q18.e(t, i);
                }
                if (this.a.D0.T0() != null && !ListUtils.isEmpty(this.a.D0.T0().getData())) {
                    List<xn> data = this.a.D0.T0().getData();
                    if (kp8Var == null) {
                        kp8Var = q18.i(this.a.v0.S1(), str);
                    }
                    q18.e(data, kp8Var);
                }
                this.a.W4(str);
                this.a.v0.v2();
                if (this.a.D0.D0() != null) {
                    this.a.D0.D0().Z();
                }
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.y5() != null) {
                this.a.y5().k2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<d55> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d55 d55Var, d55 d55Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d55Var, d55Var2)) == null) {
                return d55Var.compareTo(d55Var2);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
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
        S2 = new b1();
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        T2 = new b();
    }

    public void J5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            yi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean M6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || !pbModel.k2()) {
                return false;
            }
            if (this.v0.Q1() != null && this.v0.Q1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void S6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && m45.g(TbadkCoreApplication.getInst(), 0) && !this.D0.x2()) {
            this.i0 = m45.i(getPageContext(), "collect", 0L);
        }
    }

    public final void X6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && (pbModel = this.v0) != null && !xi.isEmpty(pbModel.m2())) {
            lm4.w().P(km4.Z, xg.g(this.v0.m2(), 0L));
        }
    }

    public void g6() {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && (list = this.p1) != null && !list.isEmpty()) {
            int size = this.p1.size();
            while (true) {
                size--;
                if (size <= -1 || this.p1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final int h5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if (this.v0.S1() != null && this.v0.S1().Q() != null) {
                return this.v0.S1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void i6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c82);
                return;
            }
            this.D0.p0();
            if (this.h) {
                return;
            }
            a7();
            this.D0.s3();
            if (this.v0.loadData()) {
                this.D0.X3();
            }
        }
    }

    public final void y6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048756, this) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().Q() != null && this.v0.S1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void z6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048759, this) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().Q() != null && this.v0.S1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
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
        this.b = true;
        this.c = false;
        this.f = false;
        this.g = false;
        this.i = true;
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
        this.r0 = new u(this);
        this.t0 = new f0(this);
        this.u0 = new Handler(new q0(this));
        this.v0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.L0 = false;
        this.N0 = false;
        this.P0 = false;
        this.Y0 = new m1(this);
        this.Z0 = new x1(this);
        this.a1 = new i2(this);
        this.b1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = -1;
        this.q1 = 0;
        this.t1 = new t2(this);
        this.u1 = new e3(this);
        this.v1 = new k(this, 2004016);
        this.w1 = new l(this, 2016485);
        this.x1 = new m(this, 2001269);
        this.y1 = new n(this, 2004008);
        this.z1 = new o(this, 2004007);
        this.A1 = new p(this, 2004005);
        this.B1 = new q(this, 2001332);
        this.C1 = new r(this, 2921391);
        this.D1 = new s(this, 2921606);
        this.E1 = new t(this, 2921658);
        this.F1 = new v(this);
        this.G1 = new w(this, 2001369);
        this.H1 = new x(this, 2921758);
        this.I1 = new y(this, 2016488);
        this.J1 = new z(this, 2016331);
        this.K1 = new a0(this, 2921746);
        this.L1 = new b0(this);
        this.M1 = new c0(this, 2010045);
        this.N1 = new d0(this);
        this.P1 = new PraiseModel(getPageContext(), new e0(this));
        this.Q1 = new g0(this);
        this.R1 = new i0(this, 2001115);
        this.S1 = new j0(this);
        this.T1 = new k0(this);
        this.V1 = new qy7(new p0(this));
        this.W1 = new s0(this);
        this.X1 = new t0(this, 2001427);
        this.Y1 = new u0(this, 2001428);
        this.Z1 = new v0(this, 2921634);
        this.a2 = new w0(this, 2001426);
        this.b2 = new x0(this, 2004021);
        this.c2 = new y0(this, 2016528);
        this.d2 = new z0(this, 2921724);
        this.e2 = new a1(this, 2921033);
        this.f2 = new c1(this);
        this.g2 = new d1(this);
        this.h2 = new e1(this);
        this.i2 = new i1(this);
        this.j2 = new l1(this);
        this.k2 = new n1(this, 2921480);
        this.l2 = new o1(this);
        this.m2 = Boolean.FALSE;
        this.n2 = new p1(this);
        this.o2 = new q1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.p2 = new r1(this);
        this.q2 = new s1(this, 2016450);
        this.r2 = new t1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.s2 = new u1(this);
        this.t2 = new y1(this);
        this.u2 = new b2(this);
        this.v2 = new d2(this);
        this.w2 = new e2(this);
        this.x2 = new f2(this);
        this.z2 = new g2(this);
        this.A2 = 0;
        this.B2 = new u2(this);
        this.C2 = false;
        this.D2 = null;
        this.E2 = new v2(this);
        this.F2 = new w2(this);
        this.G2 = new x2(this);
        this.H2 = new y2(this);
        this.I2 = new z2(this);
        this.J2 = new a3(this);
        this.K2 = new b3(this);
        this.L2 = new d3(this);
        this.M2 = new a(this);
        this.N2 = new c(this);
        this.O2 = -1;
        this.P2 = -1;
    }

    public final void A6(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4) == null) && this.v0 != null) {
            Q6();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.v0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void B6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z3) == null) {
            this.m2 = Boolean.valueOf(z3);
        }
    }

    public void C6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z3) == null) {
            this.q0 = z3;
        }
    }

    public void D6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z3) == null) {
            this.M = z3;
        }
    }

    public void G6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z3) == null) {
            this.J = z3;
        }
    }

    public final void H6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z3) == null) {
            this.S0.X(z3);
            this.S0.a0(z3);
            this.S0.i0(z3);
        }
    }

    public void I4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, f3Var) == null) && f3Var != null) {
            if (this.p1 == null) {
                this.p1 = new ArrayList();
            }
            if (!this.p1.contains(f3Var)) {
                this.p1.add(f3Var);
            }
        }
    }

    public final void I5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, intent) == null) {
            o38.j(this, intent);
        }
    }

    public void J4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, f3Var) == null) && f3Var != null) {
            if (this.p1 == null) {
                this.p1 = new ArrayList();
            }
            if (!this.p1.contains(f3Var)) {
                this.p1.add(0, f3Var);
            }
        }
    }

    public final void T5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void U6(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i4) == null) {
            o38.o(this, h5(), i4);
        }
    }

    @Override // com.baidu.tieba.v58.b
    public void X0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z3) == null) {
            this.M0 = z3;
        }
    }

    public final void c6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) == null) {
                return;
            }
            d6(postData);
        }
    }

    public final void h7(ns4 ns4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048690, this, ns4Var) == null) && ns4Var != null) {
            this.R2 = ns4Var;
            this.c = true;
            this.D0.K2();
            this.D0.f3(this.Q2);
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

    @Override // com.baidu.tieba.jv4.e
    public void onClick(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, jv4Var) == null) {
            Z4(jv4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.w9
    public void onPreLoad(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, boVar) == null) {
            PreLoadImageHelper.load(boVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(boVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v0.n3(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.S0.F(bundle);
        }
    }

    public void v6(f3 f3Var) {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048747, this, f3Var) == null) && f3Var != null && (list = this.p1) != null) {
            list.remove(f3Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.an5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            y18.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    public final void L5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i4, i5) == null) {
            rj5.b(new i(this, i5), new j(this, i5, i4));
        }
    }

    @Override // com.baidu.tieba.an5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048656, this, context, str) == null) {
            this.v = true;
        }
    }

    public boolean h6(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        s18 s18Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048689, this, i4, keyEvent)) == null) {
            if (keyEvent == null || (s18Var = this.D0) == null || !s18Var.f2(i4)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public final void K6(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            o38.l(this, j3, str, j4);
        }
    }

    public static PbFragment f6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65642, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public eu4 A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b0;
        }
        return (eu4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z48
    public PbModel.h B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public String B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            s18 s18Var = this.D0;
            if (s18Var == null) {
                return 0;
            }
            return s18Var.h1();
        }
        return invokeV.intValue;
    }

    public String D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public og<TbImageView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z48
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.v0;
        }
        return (PbModel) invokeV.objValue;
    }

    public void K5() {
        s18 s18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (s18Var = this.D0) != null) {
            s18Var.r1();
            J5();
        }
    }

    @Override // com.baidu.tieba.an5
    public og<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            og<RelativeLayout> ogVar = new og<>(new r2(this), 10, 0);
            this.F = ogVar;
            return ogVar;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.B == null) {
                this.B = new og<>(new n2(this), 8, 0);
            }
            return this.B;
        }
        return (og) invokeV.objValue;
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new n0(this));
        }
    }

    @Override // com.baidu.tieba.an5
    public og<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.C == null) {
                this.C = new og<>(new q2(this), 8, 0);
            }
            return this.C;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z48
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public boolean P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.x1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.j1() != null && this.a.j1().R1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && m45.g(TbadkCoreApplication.getInst(), 0) && !this.D0.x2()) {
            this.i0 = m45.i(getPageContext(), "reply_pb", 0L);
        }
    }

    public boolean S5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.an5
    public og<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (og) invokeV.objValue;
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            ox7 S1 = this.v0.S1();
            this.v0.H3(true);
            kp4 kp4Var = this.x0;
            if (kp4Var != null) {
                S1.L0(kp4Var.g());
            }
            this.D0.G1(S1);
        }
    }

    public void a6() {
        s18 s18Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048664, this) != null) || (s18Var = this.D0) == null) {
            return;
        }
        s18Var.X1();
    }

    public final void a7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void b7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.v1();
        }
    }

    @Override // com.baidu.tieba.an5
    public og<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.G == null) {
                this.G = new og<>(new s2(this), 10, 0);
            }
            return this.G;
        }
        return (og) invokeV.objValue;
    }

    public AntiData g5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null) {
                return this.v0.S1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public PostData i5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            ox7 ox7Var = this.v0.G;
            if (ox7Var != null) {
                return ox7Var.Z();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public String j5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public final String k5() {
        InterceptResult invokeV;
        ox7 S1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || (S1 = pbModel.S1()) == null) {
                return null;
            }
            return S1.V().c;
        }
        return (String) invokeV.objValue;
    }

    public void k6() {
        l45 l45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048699, this) == null) && (l45Var = this.i0) != null) {
            l45Var.q();
        }
    }

    public PbInterviewStatusView.f o5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.t0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.c0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public bo onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (bo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            u6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public boolean p5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            if (!this.c && this.O2 == -1 && this.P2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean p6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            l45 l45Var = this.i0;
            if (l45Var != null && l45Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.q0;
        }
        return invokeV.booleanValue;
    }

    public boolean q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.m2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean r5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.an5
    /* renamed from: s5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            s18 s18Var = this.D0;
            if (s18Var == null) {
                return null;
            }
            return s18Var.T0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && (pbModel = this.v0) != null && !xi.isEmpty(pbModel.m2())) {
            super.taskStart();
        }
    }

    public int u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            hideNetRefreshView(this.D0.n1());
            Q6();
            if (this.v0.T2()) {
                this.D0.s3();
            }
            this.D0.A3();
        }
    }

    public m85 v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.S0;
        }
        return (m85) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            if (this.K == null) {
                this.K = new og<>(new o2(this), 20, 0);
            }
            return this.K;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<TiebaPlusRecommendCard> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            if (this.D == null) {
                this.D = new og<>(new p2(this), 5, 0);
            }
            return this.D;
        }
        return (og) invokeV.objValue;
    }

    public x28 w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.e;
        }
        return (x28) invokeV.objValue;
    }

    public void w6() {
        l45 l45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048751, this) == null) && (l45Var = this.i0) != null) {
            l45Var.x();
        }
    }

    public k38 x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.s0;
        }
        return (k38) invokeV.objValue;
    }

    public w28 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            return this.a.y0();
        }
        return (w28) invokeV.objValue;
    }

    public s18 y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            return this.D0;
        }
        return (s18) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            if (this.E == null) {
                this.E = new og<>(new c3(this), 15, 0);
            }
            return this.E;
        }
        return (og) invokeV.objValue;
    }

    public void E5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.v0.S1() != null && this.v0.S1().Q() != null && this.v0.S1().Q().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.v0.S1().Q().getTaskInfoData().i(), this.v0.S1().Q().getTaskInfoData().g(), this.v0.S1().Q().getTaskInfoData().b(), this.v0.S1().Q().getTaskInfoData().c(), this.v0.S1().Q().getIs_top(), this.v0.S1().Q().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null) {
                kp8 A = this.v0.S1().A();
                if (A != null) {
                    if (A.getAdvertAppInfo() != null) {
                        A.getAdvertAppInfo().h = null;
                    }
                    this.v0.S1().b();
                }
                if (this.v0.l1() != null) {
                    this.v0.X0();
                }
                this.v0.v2();
            }
            if (this.v0.S1().H() != null) {
                Iterator<PostData> it = this.v0.S1().H().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof kp8) {
                        it.remove();
                    }
                }
            }
            if (this.D0.D0() != null && !ListUtils.isEmpty(this.D0.D0().t())) {
                q18.d(this.D0.D0().t());
            }
            if (this.D0.T0() != null && !ListUtils.isEmpty(this.D0.T0().getData())) {
                q18.d(this.D0.T0().getData());
            }
            if (this.D0.D0() != null) {
                this.D0.D0().Z();
            }
        }
    }

    public final boolean c7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.S1() != null && this.v0.S1().l0()) {
                return true;
            }
            if (this.v0.D1()) {
                MarkData o12 = this.v0.o1();
                if (o12 != null && this.v0.B1()) {
                    MarkData i12 = this.v0.i1(this.D0.K0());
                    if (i12 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", o12);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (i12.getPostId() != null && !i12.getPostId().equals(o12.getPostId())) {
                        jv4 jv4Var = new jv4(getPageContext().getPageActivity());
                        jv4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026a));
                        jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0440, new k2(this, i12, o12, jv4Var));
                        jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new l2(this, o12, jv4Var));
                        jv4Var.setOnCalcelListener(new m2(this, o12, jv4Var));
                        jv4Var.create(getPageContext());
                        jv4Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", o12);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.v0.S1() != null && this.v0.S1().H() != null && this.v0.S1().H().size() > 0 && this.v0.B1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String l5() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.S1() == null || this.v0.S1().H() == null || (count = ListUtils.getCount((H = this.v0.S1().H()))) == 0) {
                return "";
            }
            if (this.v0.d2()) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.D() == 1) {
                        return next.M();
                    }
                }
            }
            int K0 = this.D0.K0();
            PostData postData = (PostData) ListUtils.getItem(H, K0);
            if (postData != null && postData.s() != null) {
                if (this.v0.K2(postData.s().getUserId())) {
                    return postData.M();
                }
                for (int i4 = K0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i4);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.v0.K2(postData2.s().getUserId())) {
                        return postData2.M();
                    }
                }
                for (int i5 = K0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i5);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.v0.K2(postData3.s().getUserId())) {
                        return postData3.M();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            this.f = false;
            super.onResume();
            if (this.N) {
                this.N = false;
                E5();
            }
            if (R5()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            s18 s18Var = this.D0;
            if (s18Var != null && s18Var.n1() != null) {
                if (!this.g) {
                    Q6();
                } else {
                    hideLoadingView(this.D0.n1());
                }
                this.D0.l2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            s18 s18Var2 = this.D0;
            if (s18Var2 != null) {
                noNetworkView = s18Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.B1);
            this.M0 = false;
            z6();
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.a2);
            if (this.m1) {
                u6();
                this.m1 = false;
            }
            X6();
            ItemCardHelper.w(this.J2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                d65.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onStop();
            if (this.u > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.u;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.u = 0L;
            }
            if (y5().d1() != null) {
                y5().d1().i();
            }
            u38 u38Var = this.D0.h;
            if (u38Var != null && !u38Var.u()) {
                this.D0.h.y();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && this.v0.S1().l() != null && this.v0.S1().Q() != null) {
                a65.j().x(getPageContext().getPageActivity(), "pb", this.v0.S1().l().getId(), xg.g(this.v0.S1().Q().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            nn8.g().h(getUniqueId(), false);
        }
    }

    public final void E6(o85 o85Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, o85Var) == null) && o85Var != null && (pbModel = this.v0) != null) {
            o85Var.p(pbModel.r1());
            if (this.v0.S1() != null && this.v0.S1().l() != null) {
                o85Var.o(this.v0.S1().l());
            }
            o85Var.q("pb");
            o85Var.r(this.v0);
        }
    }

    public final void F6(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048590, this, i4) != null) || (pbModel = this.v0) == null) {
            return;
        }
        int b22 = pbModel.b2();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.v0.B3(1);
                } else {
                    this.v0.B3(4);
                }
            } else {
                this.v0.B3(3);
            }
        } else {
            this.v0.B3(2);
        }
        int b23 = this.v0.b2();
        if (b22 == 4 || b23 == 4) {
            i6();
        }
    }

    public final void M5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            kp4 c4 = kp4.c(this.a);
            this.x0 = c4;
            if (c4 != null) {
                c4.j(this.s2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.y0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.u2);
            this.z0 = new q35(getPageContext());
            z5();
            this.P1.setUniqueId(getUniqueId());
            this.P1.registerListener();
        }
    }

    public void P4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.D0.N3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = xg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = xg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed), 0L);
            BdUniqueId bdUniqueId = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.c1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean R4(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i4)) == null) {
            if (this.V0 != null && this.v0.S1() != null && !ThreadCardUtils.isSelf(this.v0.S1().Q()) && this.v0.S1().d() != null) {
                return this.V0.checkPrivacyBeforeSend(this.v0.S1().d().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void W5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, bundle) == null) {
            PbModel j12 = this.a.j1();
            this.v0 = j12;
            if (j12 != null) {
                if (j12.n1() != null) {
                    this.v0.n1().c(this.N2);
                }
                if (this.v0.O1() != null) {
                    this.v0.O1().f(this.u1);
                }
                if (StringUtils.isNull(this.v0.m2())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.L) && this.L != null) {
                    this.v0.y3(6);
                }
            }
        }
    }

    public final void e7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048680, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.j1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.j1().m2()).param("topic_id", this.a.j1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.j1().q2()));
        }
    }

    public void l6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048701, this, animatorListener) == null) && this.D0 != null && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().U() != null && checkUpIsLogin() && this.D0.D0() != null && this.D0.D0().z() != null) {
            this.D0.D0().z().F(animatorListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906eb));
            ox7 d4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d();
            if (d4 != null) {
                this.p2.c(true, 0, 3, 0, d4, "", 1);
            }
            this.a.l1().k(this.r0);
        }
    }

    public final void F5(int i4, Intent intent) {
        w65 w65Var;
        w65 w65Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i4, intent) == null) {
            if (i4 == 0) {
                this.D0.r1();
                this.D0.d1().c();
                this.D0.F3(false);
            }
            this.D0.N2();
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
                if (editorType == 1 && this.D0.d1() != null && this.D0.d1().b() != null) {
                    q85 b4 = this.D0.d1().b();
                    b4.d0(this.v0.S1().Q());
                    b4.C(writeData);
                    b4.e0(pbEditorData.getVoiceModel());
                    v65 n3 = b4.b().n(6);
                    if (n3 != null && (w65Var2 = n3.m) != null) {
                        w65Var2.B(new k65(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        b4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.S0.L();
            this.S0.m0(pbEditorData.getVoiceModel());
            this.S0.B(writeData);
            v65 n4 = this.S0.b().n(6);
            if (n4 != null && (w65Var = n4.m) != null) {
                w65Var.B(new k65(52, 0, pbEditorData.getVoiceModel()));
            }
            this.S0.h0(pbEditorData.isShowCustomFigure());
            if (i4 == -1) {
                this.S0.G(null, null);
            }
        }
    }

    public final void J6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (y5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        p45.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            sw7.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            sw7.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            sw7.e(getResources().getString(R.string.obfuscated_res_0x7f0f1264));
                            return;
                        } else {
                            sw7.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.v0.F1()) {
                antiData.setBlock_forum_name(this.v0.S1().l().getName());
                antiData.setBlock_forum_id(this.v0.S1().l().getId());
                antiData.setUser_name(this.v0.S1().X().getUserName());
                antiData.setUser_id(this.v0.S1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void P6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048626, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f0920ed) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof Integer)) {
            sv4 sv4Var = this.I0;
            if (sv4Var != null && sv4Var.isShowing()) {
                this.I0.dismiss();
                this.I0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920eb);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed);
            if (!((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                return;
            }
            uv4 uv4Var = new uv4(getContext());
            uv4Var.n(new h0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092090)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new qv4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04bb), uv4Var));
            }
            if (z3) {
                arrayList.add(new qv4(1, getResources().getString(R.string.obfuscated_res_0x7f0f14fb), uv4Var));
            } else {
                arrayList.add(new qv4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b66), uv4Var));
            }
            uv4Var.j(arrayList);
            sv4 sv4Var2 = new sv4(getPageContext(), uv4Var);
            this.I0 = sv4Var2;
            sv4Var2.k();
        }
    }

    public void Y4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(s18.l2)).intValue();
            if (intValue == s18.m2) {
                if (this.y0.S()) {
                    return;
                }
                this.D0.h4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092096);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue();
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920aa) != null) {
                    z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920aa)).booleanValue();
                } else {
                    z3 = false;
                }
                if (jSONArray != null) {
                    this.y0.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.y0.V(this.v0.S1().l().getId(), this.v0.S1().l().getName(), this.v0.S1().Q().getId(), str, intValue3, intValue2, booleanValue, this.v0.S1().Q().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == s18.n2 || intValue == s18.p2) {
                PbModel pbModel = this.v0;
                if (pbModel != null && pbModel.n1() != null) {
                    this.v0.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == s18.n2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void Z6(PostData postData, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048662, this, postData, z3) == null) {
            B6(false);
            if (postData == null || (pbModel = this.v0) == null || pbModel.S1() == null || postData.D() == 1) {
                return;
            }
            String m22 = this.v0.m2();
            String M = postData.M();
            if (this.v0.S1() != null) {
                i4 = this.v0.S1().Y();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e o6 = o6(M);
            if (o6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo e02 = postData.e0();
            AntiData d4 = this.v0.S1().d();
            if (postData.s() != null) {
                arrayList = postData.s().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(m22, M, "pb", true, false, null, false, null, i4, e02, d4, false, arrayList, 5).addBigImageData(o6.a, o6.b, o6.g, o6.j);
            addBigImageData.setKeyPageStartFrom(this.v0.R1());
            addBigImageData.setFromFrsForumId(this.v0.getFromForumId());
            addBigImageData.setWorksInfoData(this.v0.r2());
            addBigImageData.setKeyFromForumId(this.v0.getForumId());
            addBigImageData.setBjhData(this.v0.k1());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void b5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048666, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            s18 s18Var = this.D0;
            if (s18Var != null && this.v0 != null) {
                if ((s18Var == null || s18Var.I1()) && this.v0.S1() != null && this.v0.S1().U() != null) {
                    s18 s18Var2 = this.D0;
                    if (s18Var2 != null && s18Var2.J0() != null && this.D0.J0().t()) {
                        return;
                    }
                    cy7 U = this.v0.S1().U();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!U.f() || U.a() != 2) && this.D0.D0() != null && this.D0.D0().z() != null) {
                        this.D0.D0().z().v(this.v0.m2(), this.v0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        qw7 qw7Var = new qw7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.v0;
                        qw7Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        qw7Var.l(new o0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void G5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920ee) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ee);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920f0) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920f0);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920ef) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ef);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920eb) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920eb);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920ec) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ec);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.f1);
            userMuteAddAndDelCustomMessage.setTag(this.f1);
            W6(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void H5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && this.v0.S1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.v0.m2(), str);
                ThreadData Q = this.v0.S1().Q();
                if (Q.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                T5(format);
                return;
            }
            this.w0.a(str);
        }
    }

    public final void N6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, metaData) != null) || metaData == null) {
            return;
        }
        jv4 jv4Var = new jv4(getActivity());
        jv4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0ac8));
        jv4Var.setTitleShowCenter(true);
        jv4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0ac9));
        jv4Var.setMessageShowCenter(true);
        jv4Var.setCancelable(false);
        jv4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0aca), new v1(this, metaData));
        jv4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0acb), new w1(this, metaData));
        jv4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void T6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                K().a1(postWriteCallBackData.getPostId());
                int H0 = this.D0.H0();
                this.n1 = H0;
                this.v0.q3(H0, this.D0.N0());
            }
            this.D0.p0();
            this.H0.c();
            m85 m85Var = this.S0;
            if (m85Var != null) {
                this.D0.V2(m85Var.y());
            }
            this.D0.r1();
            this.D0.F3(true);
            this.v0.v2();
        }
    }

    public final void W4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048649, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.v0) != null && pbModel.S1() != null) {
            kp8 A = this.v0.S1().A();
            if (A != null && str.equals(A.n1())) {
                if (A.getAdvertAppInfo() != null) {
                    A.getAdvertAppInfo().h = null;
                }
                this.v0.S1().b();
            }
            kp8 l12 = this.v0.l1();
            if (l12 != null && str.equals(l12.n1())) {
                this.v0.X0();
            }
        }
    }

    public void d6(PostData postData) {
        PostData i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048674, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.M() != null && postData.M().equals(this.v0.N1())) {
            z3 = true;
        }
        MarkData M1 = this.v0.M1(postData);
        if (this.v0.S1() != null && this.v0.S1().l0() && (i5 = i5()) != null) {
            M1 = this.v0.M1(i5);
        }
        if (M1 == null) {
            return;
        }
        this.D0.s3();
        kp4 kp4Var = this.x0;
        if (kp4Var != null) {
            kp4Var.i(M1);
            if (!z3) {
                this.x0.a();
            } else {
                this.x0.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048711, this, i4) != null) || this.V == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.D0.b2(i4);
        m85 m85Var = this.S0;
        if (m85Var != null && m85Var.b() != null) {
            this.S0.b().w(i4);
        }
        if (this.D0.a() != null) {
            this.D0.a().d(getPageContext(), i4);
        }
        this.H0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.V = i4;
        a7();
        l45 l45Var = this.i0;
        if (l45Var != null) {
            l45Var.w();
        }
    }

    public void r6(ey7 ey7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, ey7Var) == null) {
            String M = ey7Var.i().M();
            List<PostData> list = this.v0.S1().V().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.M() != null && postData.M().equals(M)) {
                    ArrayList<PostData> k3 = ey7Var.k();
                    postData.a1(ey7Var.m());
                    if (postData.b0() != null) {
                        postData.b0().clear();
                        postData.b0().addAll(k3);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.v0.B1()) {
                this.D0.G1(this.v0.S1());
            }
        }
    }

    public final void I6(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048600, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new a2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                V6(str);
            } else {
                this.D0.g4(str);
            }
        }
    }

    @Override // com.baidu.tieba.an5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048644, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.K0 = str;
            if (this.l == null) {
                O5();
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

    public final void K4() {
        PbModel pbModel;
        ox7 ox7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (pbModel = this.v0) != null && (ox7Var = pbModel.G) != null && ox7Var.Q() != null) {
            ThreadData Q = this.v0.G.Q();
            Q.mRecomAbTag = this.v0.X1();
            Q.mRecomWeight = this.v0.a2();
            Q.mRecomSource = this.v0.Z1();
            Q.mRecomExtra = this.v0.Y1();
            Q.isSubPb = this.v0.F1();
            if (Q.getFid() == 0) {
                Q.setFid(xg.g(this.v0.getForumId(), 0L));
            }
            StatisticItem i4 = be5.i(getContext(), Q, "c13562");
            TbPageTag l3 = be5.l(getContext());
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

    public final void b6() {
        MarkData i12;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && this.x0 != null) {
            if (this.v0.S1() != null && this.v0.S1().l0()) {
                i12 = this.v0.i1(0);
            } else {
                i12 = this.v0.i1(this.D0.S0());
            }
            if (i12 == null) {
                return;
            }
            if (i12.isApp() && (i12 = this.v0.i1(this.D0.S0() + 1)) == null) {
                return;
            }
            this.D0.s3();
            this.x0.i(i12);
            if (!this.x0.e()) {
                if (this.D0 != null && this.v0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !o38.k(this.v0.b)) {
                    this.D0.a4();
                    o38.b(this.v0.b);
                }
                this.x0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.x0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.f = true;
            super.onPause();
            n38.a();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.k = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            s18 s18Var = this.D0;
            if (s18Var != null) {
                s18Var.i2();
            }
            if (!this.v0.F1()) {
                this.S0.N(this.v0.m2());
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.V2();
            }
            lm4.w().E();
            MessageManager.getInstance().unRegisterListener(this.B1);
            y6();
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            l45 l45Var = this.i0;
            if (l45Var != null) {
                l45Var.q();
                this.i0.p();
            }
        }
    }

    public final void L4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.k1 != null) {
                l95.b bVar = new l95.b();
                bVar.a = this.k1.D();
                bVar.b = this.k1.B();
                bVar.c = String.valueOf(this.k1.E());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.j1));
        }
    }

    public final boolean O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            ThreadData Q = this.v0.S1().Q();
            AntiData d4 = this.v0.S1().d();
            if (!AntiHelper.b(getPageContext(), Q) && !AntiHelper.d(getPageContext(), d4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            jv4 jv4Var = new jv4(getPageContext().getPageActivity());
            jv4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b69));
            jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3d, new d(this));
            jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new e(this));
            jv4Var.create(this.d1).show();
        }
    }

    public boolean Q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if ((this.v0.S1() != null && (this.v0.S1().l0() || ThreadCardUtils.isSelf(this.v0.S1().Q()))) || this.V0 == null || this.v0.S1() == null || this.v0.S1().d() == null) {
                return true;
            }
            return this.V0.checkPrivacyBeforeInvokeEditor(this.v0.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void Q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            showLoadingView(this.D0.n1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.D0.m1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final boolean R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            PostData c4 = px7.c(this.v0.S1(), this.v0.k2(), this.v0.c2());
            if (c4 != null && c4.s() != null && c4.s().getGodUserData() != null && c4.s().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.v0.x1() || this.v0.A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.v0.m2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.v0.m2()));
            if (c7()) {
                this.a.finish();
            }
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && this.R2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e25);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.P2, 0)));
                this.a.finish();
            }
        }
    }

    public final void X5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && this.R2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e26);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.O2, 0)));
                this.a.finish();
            }
        }
    }

    public void c5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048670, this) == null) && this.D0 != null && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().U() != null && checkUpIsLogin() && this.D0.D0() != null && this.D0.D0().z() != null) {
            this.D0.D0().z().v(this.v0.m2(), this.v0.getFromForumId());
        }
    }

    public final void d7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && (absPbActivity = this.a) != null && absPbActivity.j1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.j1().m2()).param("topic_id", this.a.j1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.j1().q2()));
        }
    }

    public final void g7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.v0.getForumId()) && this.v0.S1() != null && this.v0.S1().l() != null) {
            boolean z3 = true;
            if (this.v0.S1().l().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.v0.f1().D(this.v0.getForumId(), this.v0.m2());
            }
        }
    }

    public final void z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            if (this.B0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.B0 = pollingModel;
                pollingModel.a0(ew4.e);
            }
            this.B0.U(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            ah.a().postDelayed(this.W1, 10000L);
        }
    }

    public final void L6(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            m38.e(getActivity(), getPageContext(), new f1(this, sparseArray, i4, z3), new g1(this));
        }
    }

    public final void M4(ox7 ox7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, ox7Var, arrayList) == null) && ox7Var != null && ox7Var.V() != null && ox7Var.V().a != null && (list = ox7Var.V().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<PostData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData = (PostData) it2.next();
                            if (postData != null && !TextUtils.isEmpty(next.M()) && !TextUtils.isEmpty(postData.M()) && next.M().equals(postData.M())) {
                                arrayList2.add(postData);
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

    public final void e5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048678, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.D0.z0(this.y0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.E0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.F0 = false;
                    this.G0 = true;
                }
            } else {
                this.F0 = true;
                this.G0 = false;
            }
            if (i4 == 2) {
                this.v0.S1().Q().setIs_good(1);
                this.v0.u3(1);
            } else if (i4 == 3) {
                this.v0.S1().Q().setIs_good(0);
                this.v0.u3(0);
            } else if (i4 == 4) {
                this.v0.S1().Q().setIs_top(1);
                this.v0.v3(1);
            } else if (i4 == 5) {
                this.v0.S1().Q().setIs_top(0);
                this.v0.v3(0);
            }
            this.D0.p4(this.v0.S1(), this.v0.k2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0d4c);
        }
        yi.P(getPageContext().getPageActivity(), string);
    }

    public void N4(boolean z3) {
        s18 s18Var;
        int i4;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z3) == null) && (s18Var = this.D0) != null && s18Var.T0() != null) {
            int firstVisiblePosition = this.D0.T0().getFirstVisiblePosition();
            int lastVisiblePosition = this.D0.T0().getLastVisiblePosition();
            zz7 D0 = this.D0.D0();
            if (D0 != null && this.v0.S1() != null) {
                if (lastVisiblePosition <= D0.w()) {
                    i4 = 0;
                    w3 = 1;
                } else {
                    if (firstVisiblePosition > D0.w()) {
                        i4 = firstVisiblePosition - D0.w();
                    } else {
                        i4 = 0;
                    }
                    w3 = (lastVisiblePosition - D0.w()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (w3 > i4) {
                    while (i4 < w3) {
                        if (this.D0.T0().G(i4) != null && (this.D0.T0().G(i4) instanceof PostData) && (postData = (PostData) this.D0.T0().G(i4)) != null) {
                            PostData postData2 = (PostData) ListUtils.getItem(this.v0.S1().H(), postData.D() - 1);
                            if (postData.o() == null && postData2 != null) {
                                postData.D0(postData2.o());
                            }
                            if (postData.o() != null) {
                                postData.o().q(postData.D());
                                arrayList.add(postData.o());
                            }
                        }
                        i4++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new z1(this));
                    d55 d55Var = (d55) ListUtils.getItem(arrayList, 0);
                    if (d55Var != null && d55Var.e() == 1) {
                        if (!z3) {
                            this.D0.y2(d55Var, 0);
                            return;
                        }
                        return;
                    }
                    this.D0.y2(d55Var, 1);
                }
            }
        }
    }

    public final boolean e6(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, postData)) == null) {
            if (postData == null) {
                return false;
            }
            String M = postData.M();
            if (StringUtils.isNull(M) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String q3 = py4.k().q("bubble_link", "");
            if (StringUtils.isNull(q3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = postData.g0().getJumpUrl();
            int packageId = postData.g0().getPackageId();
            int propsId = postData.g0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                sp4.o(getPageContext().getPageActivity(), oq8.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                sp4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0556), q3 + "?props_id=" + M, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void i7(int i4) {
        PbModel pbModel;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048693, this, i4) != null) || (pbModel = this.v0) == null || pbModel.S1() == null || (Q = this.v0.S1().Q()) == null) {
            return;
        }
        if (i4 == 1) {
            PraiseData praise = Q.getPraise();
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
                    Q.setPraise(praiseData);
                } else {
                    Q.getPraise().getUser().add(0, metaData);
                    Q.getPraise().setNum(Q.getPraise().getNum() + 1);
                    Q.getPraise().setIsLike(i4);
                }
            }
        } else if (Q.getPraise() != null) {
            Q.getPraise().setIsLike(i4);
            Q.getPraise().setNum(Q.getPraise().getNum() - 1);
            ArrayList<MetaData> user = Q.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        Q.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
        }
        if (this.v0.k2()) {
            this.D0.D0().Z();
        } else {
            this.D0.s4(this.v0.S1());
        }
    }

    public final AbsPbActivity.e o6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, str)) == null) {
            String str2 = null;
            if (this.v0.S1() != null && this.v0.S1().H() != null && this.v0.S1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.v0.S1().H().size()) {
                        if (str.equals(this.v0.S1().H().get(i4).M())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                PostData postData = this.v0.S1().H().get(i4);
                if (postData.X() != null && postData.X().B() != null) {
                    Iterator<TbRichTextData> it = postData.X().B().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.F() != null) {
                                str2 = next.F().B();
                            }
                        }
                    }
                    m6(str2, 0, eVar);
                    px7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void t6(ey7 ey7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048741, this, ey7Var) != null) || ey7Var.i() == null) {
            return;
        }
        String M = ey7Var.i().M();
        ArrayList<PostData> H = this.v0.S1().H();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= H.size()) {
                break;
            }
            PostData postData = H.get(i4);
            if (postData.M() != null && postData.M().equals(M)) {
                ArrayList<PostData> k3 = ey7Var.k();
                postData.a1(ey7Var.m());
                if (postData.b0() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.j0() != null && next != null && next.s() != null && (metaData = postData.j0().get(next.s().getUserId())) != null) {
                            next.E0(metaData);
                            next.Q0(true);
                            next.j1(getPageContext(), this.v0.K2(metaData.getUserId()));
                        }
                    }
                    if (k3.size() == postData.b0().size()) {
                        z3 = false;
                    }
                    if (!postData.q0(false)) {
                        postData.b0().clear();
                        postData.b0().addAll(k3);
                    }
                }
                if (postData.A() != null) {
                    postData.C0();
                }
            } else {
                i4++;
            }
        }
        if (!this.v0.B1() && z3) {
            this.D0.G1(this.v0.S1());
        }
        if (z3) {
            r6(ey7Var);
        }
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.l != null) {
            return;
        }
        this.l = new lv4(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f036b), getPageContext().getString(R.string.obfuscated_res_0x7f0f1204), getPageContext().getString(R.string.obfuscated_res_0x7f0f1114)};
        lv4 lv4Var = this.l;
        lv4Var.j(strArr, new r0(this));
        lv4Var.g(lv4.b.obfuscated_res_0x7f1003ad);
        lv4Var.h(17);
        lv4Var.c(getPageContext());
    }

    @Override // com.baidu.tieba.an5
    public void R(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048631, this, context, str, z3) == null) {
            if (y18.c(str) && (pbModel = this.v0) != null && pbModel.m2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.v0.m2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    v55 v55Var = new v55();
                    v55Var.a = str;
                    v55Var.b = 3;
                    v55Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, v55Var));
                }
            } else {
                y18.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void p0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048728, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (xm5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), xm5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (y18.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new pk5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S4(AgreeData agreeData) {
        wd5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new ly4();
        }
        if (this.h0 == null) {
            bp8 bp8Var = new bp8();
            this.h0 = bp8Var;
            bp8Var.a = getUniqueId();
        }
        yr4 yr4Var = new yr4();
        yr4Var.b = 5;
        yr4Var.h = 8;
        yr4Var.g = 2;
        if (K() != null) {
            yr4Var.f = K().R1();
        }
        yr4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                yr4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i4, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.v0;
                if (pbModel == null && pbModel.S1() != null) {
                    this.d0.b(P(), yr4Var, agreeData, this.v0.S1().Q());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            yr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            yr4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.d0.c(agreeData, i4, getUniqueId(), false);
        this.d0.d(agreeData, this.h0);
        pbModel = this.v0;
        if (pbModel == null) {
        }
    }

    public final boolean U4(View view2) {
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
        List<qv4> c4;
        int i4;
        boolean z20;
        qv4 qv4Var;
        qv4 qv4Var2;
        qv4 qv4Var3;
        qv4 qv4Var4;
        qv4 qv4Var5;
        qv4 qv4Var6;
        in inVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                return true;
            }
            s18 s18Var = this.D0;
            if (s18Var != null) {
                if (s18Var.K1()) {
                    return true;
                }
                this.D0.A0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (q18.y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.i1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.j1 = url;
                        if (this.i1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f0920d0) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d0) instanceof TbRichTextImageInfo)) {
                            this.k1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d0);
                        } else {
                            this.k1 = null;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
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
                        this.D0.S3(this.F2, this.i1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
            this.D2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.D() == 1 && q18.y(view2)) {
                this.D0.S3(this.F2, this.i1.t());
                return true;
            }
            kp4 kp4Var = this.x0;
            if (kp4Var == null) {
                return true;
            }
            if (kp4Var.e() && this.D2.M() != null && this.D2.M().equals(this.v0.N1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (K().S1() != null && K().S1().l0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (K().S1() != null && K().S1().q0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (K().S1() != null && K().S1().p0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.D2.D() == 1) {
                if (!z4) {
                    this.D0.T3(this.E2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.J0 == null) {
                uv4 uv4Var = new uv4(getContext());
                this.J0 = uv4Var;
                uv4Var.n(this.h2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (q18.y(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (q18.y(view2) && (inVar = this.i1) != null && !inVar.t()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920ad) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ad)).booleanValue();
                } else {
                    z9 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean) {
                    z10 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                } else {
                    z10 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                    z11 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                } else {
                    z11 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean) {
                    z12 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
                } else {
                    z12 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                    z13 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                } else {
                    z13 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean) {
                    z14 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
                } else {
                    z14 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof String) {
                    str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920a4);
                } else {
                    str = null;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean) {
                    z15 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue();
                } else {
                    z15 = false;
                }
                boolean z21 = z15;
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920b5) instanceof Boolean) {
                    z16 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920b5)).booleanValue();
                } else {
                    z16 = false;
                }
                if (z7) {
                    z17 = z16;
                    z19 = z14;
                    z18 = z13;
                    arrayList.add(new qv4(1, getString(R.string.obfuscated_res_0x7f0f10e2), this.J0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new qv4(2, getString(R.string.obfuscated_res_0x7f0f10e3), this.J0));
                }
                if (!z7 && !z8) {
                    qv4 qv4Var7 = new qv4(3, getString(R.string.obfuscated_res_0x7f0f045c), this.J0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092094, this.D2);
                    qv4Var7.d.setTag(sparseArray3);
                    arrayList.add(qv4Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        qv4Var6 = new qv4(4, getString(R.string.obfuscated_res_0x7f0f1025), this.J0);
                    } else {
                        qv4Var6 = new qv4(4, getString(R.string.obfuscated_res_0x7f0f0ac6), this.J0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092094, this.D2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
                    qv4Var6.d.setTag(sparseArray4);
                    arrayList.add(qv4Var6);
                }
                if (this.mIsLogin) {
                    if (!m38.j(this.v0) && !z12 && z11) {
                        qv4 qv4Var8 = new qv4(5, getString(R.string.obfuscated_res_0x7f0f0b6a), this.J0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray5.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                        qv4Var8.d.setTag(sparseArray5);
                        arrayList.add(qv4Var8);
                    } else {
                        if (q18.C(this.v0.S1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            qv4 qv4Var9 = new qv4(5, getString(R.string.obfuscated_res_0x7f0f104a), this.J0);
                            qv4Var9.d.setTag(str);
                            arrayList.add(qv4Var9);
                        }
                    }
                    if (z12) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920a4, str);
                        sparseArray6.put(R.id.obfuscated_res_0x7f0920b5, sparseArray.get(R.id.obfuscated_res_0x7f0920b5));
                        if (!m38.j(this.v0) && z18) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                        }
                        if (z19) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z10));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z21));
                            if (z21) {
                                qv4Var5 = new qv4(6, getString(R.string.obfuscated_res_0x7f0f04bb), this.J0);
                                qv4Var5.d.setTag(sparseArray6);
                                qv4Var2 = new qv4(7, getString(R.string.obfuscated_res_0x7f0f02e9), this.J0);
                                qv4Var2.d.setTag(sparseArray6);
                                qv4Var3 = qv4Var5;
                                qv4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                        }
                        qv4Var5 = null;
                        qv4Var2 = new qv4(7, getString(R.string.obfuscated_res_0x7f0f02e9), this.J0);
                        qv4Var2.d.setTag(sparseArray6);
                        qv4Var3 = qv4Var5;
                        qv4Var = null;
                    } else if (z19) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z10));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                        sparseArray7.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                        if (this.v0.S1().Y() == 1002 && !z10) {
                            qv4Var4 = new qv4(6, getString(R.string.obfuscated_res_0x7f0f104a), this.J0);
                        } else {
                            qv4Var4 = new qv4(6, getString(R.string.obfuscated_res_0x7f0f04bb), this.J0);
                        }
                        qv4Var4.d.setTag(sparseArray7);
                        if (z17) {
                            qv4Var = new qv4(13, getString(R.string.obfuscated_res_0x7f0f0b5a), this.J0);
                            qv4Var3 = qv4Var4;
                        } else {
                            qv4Var3 = qv4Var4;
                            qv4Var = null;
                        }
                        qv4Var2 = null;
                    } else {
                        qv4Var = null;
                        qv4Var2 = null;
                        qv4Var3 = null;
                    }
                    if (qv4Var3 != null) {
                        arrayList.add(qv4Var3);
                    }
                    if (qv4Var != null) {
                        arrayList.add(qv4Var);
                    }
                    if (qv4Var2 != null) {
                        arrayList.add(qv4Var2);
                    }
                    m38.b(arrayList, this.J0, this.D2, this.v0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = m38.d(arrayList, this.D2.q(), sparseArray, this.J0);
                } else {
                    c4 = m38.c(arrayList, this.D2.q(), sparseArray, this.J0);
                }
                m38.m(c4, this.b);
                m38.f(c4);
                this.J0.o(m38.h(this.D2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.J0.k(c4, false);
                } else {
                    this.J0.k(c4, true);
                }
                sv4 sv4Var = new sv4(getPageContext(), this.J0);
                this.I0 = sv4Var;
                sv4Var.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.v0.b).param("fid", this.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.v0.B());
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
        return invokeL.booleanValue;
    }

    public void V4(ForumManageModel.b bVar, s18 s18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, bVar, s18Var) == null) {
            List<PostData> list = this.v0.S1().V().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).b0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).b0().get(i5).M())) {
                        list.get(i4).b0().remove(i5);
                        list.get(i4).k();
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                list.get(i4).l(bVar.g);
            }
            if (z3) {
                s18Var.G1(this.v0.S1());
            }
        }
    }

    public void V5(String str) {
        s18 s18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048646, this, str) == null) && this.v0 != null && !StringUtils.isNull(str) && (s18Var = this.D0) != null) {
            s18Var.a3(true);
            this.v0.P2(str);
            this.H = true;
            this.D0.p0();
            this.D0.p1();
        }
    }

    public final void V6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            if (str == null) {
                str = "";
            }
            r9 r9Var = this.d1;
            if (r9Var == null) {
                return;
            }
            jv4 jv4Var = new jv4(r9Var.getPageActivity());
            jv4Var.setMessage(str);
            jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d4, new f(this));
            jv4Var.create(this.d1).show();
        }
    }

    public final void Y6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048659, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) == null) {
            return;
        }
        Z6(postData, false);
    }

    public final void f5(Rect rect) {
        s18 s18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048681, this, rect) == null) && rect != null && (s18Var = this.D0) != null && s18Var.m1() != null && rect.top <= this.D0.m1().getHeight()) {
            rect.top += this.D0.m1().getHeight() - rect.top;
        }
    }

    public final void f7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.v0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(m38.n(i4))));
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i4 = configuration.orientation;
            if (i4 == this.x) {
                return;
            }
            this.x = i4;
            if (i4 == 2) {
                this.I = true;
            } else {
                this.I = false;
            }
            s18 s18Var = this.D0;
            if (s18Var != null) {
                s18Var.c2(configuration);
            }
            sv4 sv4Var = this.I0;
            if (sv4Var != null) {
                sv4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z3) == null) {
            super.onUserChanged(z3);
            this.D0.l4(z3);
            sv4 sv4Var = this.I0;
            if (sv4Var != null) {
                sv4Var.dismiss();
            }
            if (z3 && this.M0) {
                this.D0.t3();
                this.v0.N2(true);
            }
            if (this.D0.D0() != null) {
                this.D0.D0().d0(z3);
            }
        }
    }

    public final void q6(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048733, this, view2) != null) || view2 == null) {
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
        sparseArray.put(R.id.obfuscated_res_0x7f0918cb, Integer.valueOf(i4));
        view2.setTag(sparseArray);
    }

    public final void W6(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.D0.N3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            jv4 jv4Var = new jv4(this.d1.getPageActivity());
            if (!xi.isEmpty(str)) {
                jv4Var.setMessage(str);
            } else {
                jv4Var.setMessage(this.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0324, str3));
            }
            jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0440, new g(this, userMuteAddAndDelCustomMessage));
            jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new h(this));
            jv4Var.create(this.d1).show();
        }
    }

    public final void Y5(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048658, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (O4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!Q4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.X);
                        this.Y = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (y5().d1() != null && postData != null) {
                        if (postData.X() != null) {
                            str3 = postData.X().toString();
                        } else {
                            str3 = "";
                        }
                        y5().d1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1040), postData.s().getName_show(), str3));
                    }
                    if (this.v0.S1() != null && this.v0.S1().l0()) {
                        ah.a().postDelayed(new j1(this, str, str2), 0L);
                        return;
                    }
                    if (this.X0 == null) {
                        zs6 zs6Var = new zs6(getPageContext());
                        this.X0 = zs6Var;
                        zs6Var.j(1);
                        this.X0.i(new k1(this, str, str2));
                    }
                    PbModel pbModel = this.v0;
                    if (pbModel != null && pbModel.S1() != null && this.v0.S1().l() != null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.X0.g(this.v0.S1().l().getId(), xg.g(this.v0.m2(), 0L));
                        return;
                    }
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void Z4(jv4 jv4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048660, this, jv4Var, jSONArray) == null) {
            jv4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(jv4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                Y4((SparseArray) jv4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText j7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048696, this, str, i4)) == null) {
            PbModel pbModel = this.v0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i4 < 0) {
                return null;
            }
            ox7 S1 = this.v0.S1();
            if (S1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S1.j());
                tbRichText = m5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> H = S1.H();
                M4(S1, H);
                return m5(H, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void a5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i5));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
            sparseArray.put(s18.l2, Integer.valueOf(s18.m2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                Y4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void d5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048673, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f04c0);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                jv4 jv4Var = new jv4(getPageContext().getPageActivity());
                jv4Var.setMessage(string);
                jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04fe, new c2(this));
                jv4Var.setCancelable(true);
                jv4Var.create(getPageContext());
                jv4Var.show();
            } else if (bVar.d != 0) {
                this.D0.z0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> H = this.v0.S1().H();
                    int size = H.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(H.get(i4).M())) {
                            H.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.v0.S1().Q().setReply_num(this.v0.S1().Q().getReply_num() - 1);
                    this.D0.G1(this.v0.S1());
                } else if (i5 == 0) {
                    T4();
                } else if (i5 == 2) {
                    ArrayList<PostData> H2 = this.v0.S1().H();
                    int size2 = H2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= H2.get(i6).b0().size()) {
                                break;
                            } else if (bVar.g.equals(H2.get(i6).b0().get(i7).M())) {
                                H2.get(i6).b0().remove(i7);
                                H2.get(i6).k();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        H2.get(i6).l(bVar.g);
                    }
                    if (z4) {
                        this.D0.G1(this.v0.S1());
                    }
                    V4(bVar, this.D0);
                }
            }
        }
    }

    @Override // com.baidu.tieba.z48
    public void finish() {
        s18 s18Var;
        boolean z3;
        CardHListViewData q3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            s18 s18Var2 = this.D0;
            if (s18Var2 != null) {
                s18Var2.p0();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && !this.v0.S1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.v0.S1().Q().getId();
                if (this.v0.isShareThread() && this.v0.S1().Q().originalThreadData != null) {
                    historyMessage.threadName = this.v0.S1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.v0.S1().Q().getTitle();
                }
                if (this.v0.isShareThread() && !t0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.v0.S1().l().getName();
                }
                ArrayList<PostData> H = this.v0.S1().H();
                s18 s18Var3 = this.D0;
                if (s18Var3 != null) {
                    i4 = s18Var3.K0();
                } else {
                    i4 = 0;
                }
                if (H != null && i4 >= 0 && i4 < H.size()) {
                    historyMessage.postID = H.get(i4).M();
                }
                historyMessage.isHostOnly = this.v0.v1();
                historyMessage.isSquence = this.v0.k2();
                historyMessage.isShareThread = this.v0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            m85 m85Var = this.S0;
            if (m85Var != null) {
                m85Var.D();
            }
            if (this.i && y5() != null) {
                y5().u0();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && (pbModel2.x1() || this.v0.A1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.v0.m2());
                if (this.E0) {
                    if (this.G0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.v0.G1());
                    }
                    if (this.F0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.v0.C1());
                    }
                }
                if (this.v0.S1() != null && System.currentTimeMillis() - this.o >= 40000 && (q3 = this.v0.S1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.o1);
                }
                this.a.setResult(-1, intent);
            }
            if (c7()) {
                if (this.v0 != null && (s18Var = this.D0) != null && s18Var.T0() != null) {
                    ox7 S1 = this.v0.S1();
                    if (S1 != null) {
                        if (S1.X() != null) {
                            S1.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            S1.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!S1.t0() && !this.H && S1.h == null) {
                            h18 b4 = h18.b();
                            ox7 T1 = this.v0.T1();
                            Parcelable onSaveInstanceState = this.D0.T0().onSaveInstanceState();
                            boolean k22 = this.v0.k2();
                            boolean v12 = this.v0.v1();
                            if (this.D0.b1() != null && this.D0.b1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.n(T1, onSaveInstanceState, k22, v12, z3);
                            if (this.n1 >= 0 || this.v0.o2() != null) {
                                h18.b().q(this.v0.o2());
                                h18.b().r(this.v0.p2());
                                h18.b().o(this.v0.L1());
                            }
                        }
                    }
                } else {
                    h18.b().m();
                }
                b7();
            }
        }
    }

    public void j6() {
        PbModel pbModel;
        ox7 S1;
        ThreadData Q;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ox7 ox7Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && (Q = (S1 = this.v0.S1()).Q()) != null && Q.getAuthor() != null) {
            this.D0.r1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q.getAuthor().getUserId());
            a18 a18Var = new a18();
            int Y = this.v0.S1().Y();
            if (Y != 1 && Y != 3) {
                a18Var.g = false;
            } else {
                a18Var.g = true;
                if (Q.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                a18Var.s = z3;
            }
            if (q18.z(this.v0.S1(), Y)) {
                a18Var.h = true;
                if (Q.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                a18Var.r = z8;
            } else {
                a18Var.h = false;
            }
            if (Y == 1002 && !equals) {
                a18Var.u = true;
            }
            a18Var.n = q18.J(Q.isBlocked(), S1.o0(), equals, Y, Q.isWorksInfo(), Q.isScoreThread());
            a18Var.e = q18.H(S1, equals, S1.o0(), this.v0.H());
            a18Var.i = M6();
            a18Var.f = q18.I(this.v0.S1(), equals, this.v0.H());
            if (equals && S1.X() != null && S1.X().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            a18Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                a18Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            a18Var.t = equals;
            a18Var.q = this.v0.k2();
            a18Var.b = true;
            a18Var.a = q18.C(this.v0.S1(), equals);
            if (equals) {
                this.D0.H1();
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            a18Var.p = z5;
            a18Var.j = true;
            a18Var.o = this.v0.v1();
            a18Var.d = true;
            if (Q.getThreadVideoInfo() == null) {
                a18Var.c = true;
            } else {
                a18Var.c = false;
            }
            if (S1.l0()) {
                a18Var.b = false;
                a18Var.d = false;
                a18Var.c = false;
                a18Var.g = false;
                a18Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !S1.l0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            a18Var.v = z6;
            if (this.D0 != null && (ox7Var = this.v0.G) != null) {
                PostData Z = ox7Var.Z();
                if (Z != null) {
                    z7 = Z.S;
                } else {
                    z7 = false;
                }
                a18Var.w = z7;
            }
            a18Var.m = true;
            if (Q.isBlocked()) {
                a18Var.n = false;
                a18Var.g = false;
                a18Var.h = false;
            }
            this.D0.h.F(a18Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        u38 u38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            nn8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.v0.S1().m());
                statisticItem.param("tid", this.v0.m2());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.D0 != null) {
                this.s = true;
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.v0.destory();
                if (this.v0.O1() != null) {
                    this.v0.O1().d();
                }
            }
            m85 m85Var = this.S0;
            if (m85Var != null) {
                m85Var.D();
            }
            ForumManageModel forumManageModel = this.y0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.M();
            }
            s18 s18Var = this.D0;
            if (s18Var != null) {
                s18Var.d2();
                u38 u38Var2 = this.D0.h;
                if (u38Var2 != null) {
                    u38Var2.y();
                }
            }
            se5 se5Var = this.t;
            if (se5Var != null) {
                se5Var.c();
            }
            x28 x28Var = this.e;
            if (x28Var != null) {
                x28Var.k();
            }
            og<TextView> ogVar = this.z;
            if (ogVar != null) {
                ogVar.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            s18 s18Var2 = this.D0;
            if (s18Var2 != null) {
                s18Var2.p0();
            }
            if (this.W1 != null) {
                ah.a().removeCallbacks(this.W1);
            }
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.o2);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.d2);
            this.d1 = null;
            this.e1 = null;
            ph8.e().g();
            if (this.g1 != null) {
                ah.a().removeCallbacks(this.g1);
            }
            s18 s18Var3 = this.D0;
            if (s18Var3 != null && (u38Var = s18Var3.h) != null) {
                u38Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            v18 v18Var = this.H0;
            if (v18Var != null) {
                v18Var.j();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && pbModel2.f1() != null) {
                this.v0.f1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.V0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            s18 s18Var4 = this.D0;
            if (s18Var4 != null) {
                s18Var4.i4();
            }
            k38 k38Var = this.s0;
            if (k38Var != null) {
                k38Var.e();
            }
        }
    }

    public final TbRichText m5(ArrayList<PostData> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048702, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText X = arrayList.get(i5).X();
                    if (X != null && (B = X.B()) != null) {
                        int size = B.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (B.get(i7) != null && B.get(i7).getType() == 8) {
                                i6++;
                                if (!B.get(i7).F().B().equals(str) && !B.get(i7).F().C().equals(str)) {
                                    if (i6 > i4) {
                                        break;
                                    }
                                } else {
                                    int i8 = (int) yi.i(TbadkCoreApplication.getInst());
                                    int width = B.get(i7).F().getWidth() * i8;
                                    int height = B.get(i7).F().getHeight() * i8;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.A2 = i7;
                                    return X;
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

    public final void m6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048703, this, str, i4, eVar) != null) || eVar == null) {
            return;
        }
        ox7 S1 = this.v0.S1();
        TbRichText j7 = j7(str, i4);
        if (j7 == null || (tbRichTextData = j7.B().get(this.A2)) == null) {
            return;
        }
        eVar.f = String.valueOf(j7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a4 = px7.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (this.r) {
                    i6 = 17;
                } else {
                    i6 = 18;
                }
                imageUrlData.urlType = i6;
            }
            imageUrlData.originalUrl = q18.o(tbRichTextData);
            imageUrlData.originalUrl = q18.o(tbRichTextData);
            imageUrlData.originalSize = q18.p(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = q18.l(tbRichTextData);
            imageUrlData.isLongPic = q18.k(tbRichTextData);
            imageUrlData.postId = j7.getPostId();
            imageUrlData.mIsReserver = this.v0.d2();
            imageUrlData.mIsSeeHost = this.v0.v1();
            eVar.b.put(a4, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.Q() != null) {
                    eVar.e = S1.Q().getId();
                }
                if (S1.s() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = xg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.H().size();
        this.C2 = false;
        eVar.j = -1;
        if (S1.j() != null) {
            i5 = n5(S1.j().X(), j7, i4, i4, eVar.a, eVar.b);
        } else {
            i5 = i4;
        }
        int i7 = i5;
        for (int i8 = 0; i8 < size; i8++) {
            PostData postData = S1.H().get(i8);
            if (postData.M() == null || S1.j() == null || S1.j().M() == null || !postData.M().equals(S1.j().M())) {
                i7 = n5(postData.X(), j7, i7, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.Q() != null) {
                eVar.e = S1.Q().getId();
            }
            if (S1.s() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i7;
    }

    public final int n5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo F;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048704, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.C2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int i10 = (int) yi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * i10;
                        int height = tbRichTextData.F().getHeight() * i10;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.F().H()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = px7.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                        String B = F.B();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            B = F.C();
                                        } else {
                                            if (this.r) {
                                                i6 = 17;
                                            } else {
                                                i6 = 18;
                                            }
                                            imageUrlData.urlType = i6;
                                        }
                                        imageUrlData.imageUrl = B;
                                        imageUrlData.originalUrl = q18.o(tbRichTextData);
                                        imageUrlData.originalSize = q18.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = q18.l(tbRichTextData);
                                        imageUrlData.isLongPic = q18.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = xg.g(this.v0.m2(), -1L);
                                        imageUrlData.mIsReserver = this.v0.d2();
                                        imageUrlData.mIsSeeHost = this.v0.v1();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.C2) {
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

    public void n6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && this.v0.S1().l() != null) {
                if (O4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.v0.S1().l0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.D0.i0();
                    return;
                } else {
                    if (this.W0 == null) {
                        zs6 zs6Var = new zs6(getPageContext());
                        this.W0 = zs6Var;
                        zs6Var.j(0);
                        this.W0.i(new h1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.W0.g(this.v0.S1().l().getId(), xg.g(this.v0.m2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048709, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.S0.C(i4, i5, intent);
            if (y5().d1() != null) {
                y5().d1().g(i4, i5, intent);
            }
            if (i4 == 25035) {
                F5(i5, intent);
            }
            if (i5 == -1) {
                if (i4 != 11009) {
                    if (i4 != 13008) {
                        if (i4 != 13011) {
                            if (i4 != 23003) {
                                if (i4 != 23007) {
                                    if (i4 != 25012) {
                                        if (i4 != 25033) {
                                            if (i4 != 24007) {
                                                if (i4 != 24008) {
                                                    switch (i4) {
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
                                                            s18 s18Var = this.D0;
                                                            if (s18Var != null && s18Var.E0() != null) {
                                                                this.D0.E0().performClick();
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
                                                this.D0.u3(false);
                                                if (this.v0.S1() != null && this.v0.S1().Q() != null && this.v0.S1().Q().getPushStatusData() != null) {
                                                    this.v0.S1().Q().getPushStatusData().setStatus(2);
                                                    return;
                                                }
                                                return;
                                            }
                                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                                jf8.g().m(getPageContext());
                                                g7();
                                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
                                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                                    shareSuccessReplyToServerModel.z(str, intExtra, new j2(this));
                                                }
                                                if (Q5()) {
                                                    e7(true);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        View view5 = this.Q;
                                        if (view5 != null) {
                                            this.D0.K3(view5);
                                            return;
                                        }
                                        return;
                                    }
                                    intent.getLongExtra("KEY_FORUM_ID", 0L);
                                    intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                                    return;
                                }
                                I5(intent);
                                return;
                            } else if (intent != null && this.v0 != null) {
                                K6(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                                return;
                            } else {
                                return;
                            }
                        }
                        jf8.g().m(getPageContext());
                        return;
                    }
                    h18.b().m();
                    this.u0.postDelayed(new h2(this), 1000L);
                    return;
                }
                b6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048715, this, layoutInflater, viewGroup, bundle)) == null) {
            this.D0 = new s18(this, this.j2, this.V1);
            aa6 aa6Var = new aa6(getActivity());
            this.d = aa6Var;
            aa6Var.i(T2);
            this.d.d(this.M2);
            this.D0.l3(this.t2);
            this.D0.k3(this.z2);
            this.D0.d3(this.w2);
            this.D0.e3(this.x2);
            this.D0.b3(br4.c().g());
            this.D0.i3(this.B2);
            this.D0.o3(this.H2);
            this.D0.m3(this.I2);
            this.D0.j3(this.K2);
            this.D0.h3(this.v2);
            this.D0.l4(this.mIsLogin);
            this.D0.Y2(this.v0.y2());
            if (this.a.getIntent() != null) {
                this.D0.Z2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.D0.c1().setFromForumId(this.v0.getFromForumId());
            this.D0.Q2(this.S0.b());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.S0.c0(this.D0.f1());
            }
            this.D0.U2(this.g2);
            this.D0.X2(this.v0.A1());
            this.D0.n3(this.v0.R1());
            this.s0.f(this.D0, this.v0);
            if ("1".equals(K().showReplyPanel)) {
                this.D0.k2();
            }
            return this.D0.n1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        s18 s18Var;
        s18 s18Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.d1 = getPageContext();
            Intent intent = this.a.getIntent();
            if (intent != null) {
                this.m = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.L = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.L)) {
                        this.L = data.getQueryParameter("from");
                    }
                }
                this.U = intent.getStringExtra("st_type");
                this.O2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.P2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.Q2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.N0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.O0 = intent.getStringExtra("high_light_post_id");
                this.P0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (p5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O = stringExtra;
                if (xi.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.O;
                }
                this.O = str;
                this.o1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                eu4 eu4Var = new eu4();
                this.b0 = eu4Var;
                eu4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.q1 = intExtra;
                if (intExtra == 0) {
                    this.q1 = intent.getIntExtra("key_start_from", 0);
                }
                this.r1 = intent.getStringExtra("last_tid");
            } else {
                this.m = System.currentTimeMillis();
            }
            this.q = this.o - this.m;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.k = 0;
            W5(bundle);
            if (this.v0.S1() != null) {
                this.v0.S1().U0(this.O);
            }
            N5();
            if (intent != null && (s18Var2 = this.D0) != null) {
                s18Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.g1 == null) {
                        this.g1 = new l0(this, intent);
                    }
                    ah.a().postDelayed(this.g1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.v0.S1() != null) {
                    this.v0.z3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            M5(bundle);
            o85 o85Var = new o85();
            this.R0 = o85Var;
            E6(o85Var);
            m85 m85Var = (m85) this.R0.a(getActivity());
            this.S0 = m85Var;
            m85Var.W(this.a.getPageContext());
            this.S0.f0(this.l2);
            this.S0.g0(this.Y0);
            this.S0.Y(1);
            this.S0.A(this.a.getPageContext(), bundle);
            this.S0.b().b(new u65(getActivity()));
            this.S0.b().C(true);
            H6(true);
            this.S0.J(this.v0.u1(), this.v0.m2(), this.v0.q1());
            registerListener(this.y1);
            if (!this.v0.F1()) {
                this.S0.q(this.v0.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.v0.A2()) {
                this.S0.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e37));
            } else {
                s18 s18Var3 = this.D0;
                if (s18Var3 != null) {
                    this.S0.c0(s18Var3.f1());
                }
            }
            registerListener(this.x1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.w1);
            registerListener(this.b2);
            registerListener(this.c2);
            registerListener(this.r2);
            registerListener(this.v1);
            cp8 cp8Var = new cp8("pb", cp8.d);
            this.Q0 = cp8Var;
            cp8Var.d();
            registerListener(this.G1);
            registerListener(this.R1);
            this.v0.W2();
            registerListener(this.q2);
            registerListener(this.e2);
            registerListener(this.k2);
            registerListener(this.M1);
            registerListener(this.d2);
            registerListener(this.H1);
            s18 s18Var4 = this.D0;
            if (s18Var4 != null && s18Var4.m1() != null && this.D0.k1() != null) {
                x28 x28Var = new x28(getActivity(), this.D0.m1(), this.D0.k1(), this.D0.b1());
                this.e = x28Var;
                x28Var.t(this.Q1);
            }
            if (this.c && (s18Var = this.D0) != null && s18Var.k1() != null) {
                this.D0.k1().setVisibility(8);
            }
            vy4 vy4Var = new vy4();
            this.e1 = vy4Var;
            vy4Var.a = 1000L;
            registerListener(this.a2);
            registerListener(this.Z1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.J1);
            registerListener(this.K1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.E1);
            this.I1.setSelfListener(true);
            this.I1.setTag(this.a.getUniqueId());
            this.I1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.I1);
            registerResponsedEventListener(TipEvent.class, this.S1);
            registerResponsedEventListener(TopToastEvent.class, this.T1);
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
            this.U1 = new g3(this.D0, this);
            this.v0.m1().D(this.U1);
            this.H0 = new v18();
            if (this.S0.s() != null) {
                this.H0.m(this.S0.s().i());
            }
            this.S0.V(this.Z0);
            this.C0 = new ShareSuccessReplyToServerModel();
            I4(this.t1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.V0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new m0(this));
            v38 v38Var = new v38(getContext());
            this.w0 = v38Var;
            v38Var.b(getUniqueId());
            nn8.g().i(getUniqueId());
            nr4.b().l("3", "");
            this.s1 = new j36(getPageContext());
            this.s0 = new k38(this, getUniqueId(), this.D0, this.v0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    public void s6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048738, this, z3, markData) == null) {
            this.D0.r3();
            this.v0.H3(z3);
            kp4 kp4Var = this.x0;
            if (kp4Var != null) {
                kp4Var.h(z3);
                if (markData != null) {
                    this.x0.i(markData);
                }
            }
            if (this.v0.D1()) {
                Z5();
            } else {
                this.D0.G1(this.v0.S1());
            }
        }
    }

    public final boolean x6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f092094);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (postData.getType() != PostData.Q0 && !TextUtils.isEmpty(postData.v()) && br4.c().g()) {
                return e6(postData);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null) {
                if (y5().d1() != null) {
                    y5().d1().c();
                }
                ey7 ey7Var = new ey7();
                ey7Var.A(this.v0.S1().l());
                ey7Var.E(this.v0.S1().Q());
                ey7Var.C(postData);
                y5().c1().V(ey7Var);
                y5().c1().setPostId(postData.M());
                Y5(view2, postData.s().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                m85 m85Var = this.S0;
                if (m85Var != null) {
                    this.D0.V2(m85Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }
}
