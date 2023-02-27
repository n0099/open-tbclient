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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.a05;
import com.baidu.tieba.a25;
import com.baidu.tieba.af5;
import com.baidu.tieba.ag5;
import com.baidu.tieba.ag8;
import com.baidu.tieba.ah8;
import com.baidu.tieba.b25;
import com.baidu.tieba.b55;
import com.baidu.tieba.b69;
import com.baidu.tieba.ba5;
import com.baidu.tieba.bf5;
import com.baidu.tieba.bm5;
import com.baidu.tieba.bs5;
import com.baidu.tieba.c05;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cb5;
import com.baidu.tieba.cl5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cq5;
import com.baidu.tieba.cr5;
import com.baidu.tieba.df5;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.ed9;
import com.baidu.tieba.eg8;
import com.baidu.tieba.ej;
import com.baidu.tieba.ej8;
import com.baidu.tieba.fa7;
import com.baidu.tieba.fd5;
import com.baidu.tieba.ff5;
import com.baidu.tieba.fm5;
import com.baidu.tieba.fv8;
import com.baidu.tieba.fy4;
import com.baidu.tieba.g09;
import com.baidu.tieba.g15;
import com.baidu.tieba.g55;
import com.baidu.tieba.gh;
import com.baidu.tieba.gj8;
import com.baidu.tieba.h16;
import com.baidu.tieba.hd8;
import com.baidu.tieba.hd9;
import com.baidu.tieba.hj8;
import com.baidu.tieba.hl5;
import com.baidu.tieba.ho;
import com.baidu.tieba.hx4;
import com.baidu.tieba.id5;
import com.baidu.tieba.id8;
import com.baidu.tieba.ie8;
import com.baidu.tieba.ii8;
import com.baidu.tieba.ij8;
import com.baidu.tieba.jc5;
import com.baidu.tieba.jc8;
import com.baidu.tieba.jd5;
import com.baidu.tieba.je8;
import com.baidu.tieba.jh8;
import com.baidu.tieba.jj8;
import com.baidu.tieba.jk8;
import com.baidu.tieba.jz4;
import com.baidu.tieba.k55;
import com.baidu.tieba.kd5;
import com.baidu.tieba.l05;
import com.baidu.tieba.lc8;
import com.baidu.tieba.lh8;
import com.baidu.tieba.lx8;
import com.baidu.tieba.m25;
import com.baidu.tieba.m59;
import com.baidu.tieba.m95;
import com.baidu.tieba.me8;
import com.baidu.tieba.mi8;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n59;
import com.baidu.tieba.nc8;
import com.baidu.tieba.nf8;
import com.baidu.tieba.oc5;
import com.baidu.tieba.oh8;
import com.baidu.tieba.oj8;
import com.baidu.tieba.ol6;
import com.baidu.tieba.ol8;
import com.baidu.tieba.on;
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
import com.baidu.tieba.pj8;
import com.baidu.tieba.pl6;
import com.baidu.tieba.pu5;
import com.baidu.tieba.q15;
import com.baidu.tieba.qb5;
import com.baidu.tieba.qh8;
import com.baidu.tieba.qi8;
import com.baidu.tieba.qu4;
import com.baidu.tieba.ra5;
import com.baidu.tieba.rc5;
import com.baidu.tieba.rg8;
import com.baidu.tieba.rh8;
import com.baidu.tieba.ri8;
import com.baidu.tieba.rr4;
import com.baidu.tieba.s15;
import com.baidu.tieba.s55;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sf8;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sr4;
import com.baidu.tieba.su5;
import com.baidu.tieba.t55;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tg8;
import com.baidu.tieba.tk8;
import com.baidu.tieba.ug;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ux4;
import com.baidu.tieba.uy4;
import com.baidu.tieba.v59;
import com.baidu.tieba.vd8;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w65;
import com.baidu.tieba.w9;
import com.baidu.tieba.wb;
import com.baidu.tieba.we6;
import com.baidu.tieba.x15;
import com.baidu.tieba.x45;
import com.baidu.tieba.x9;
import com.baidu.tieba.xa5;
import com.baidu.tieba.xd8;
import com.baidu.tieba.xe5;
import com.baidu.tieba.xp5;
import com.baidu.tieba.y39;
import com.baidu.tieba.ya5;
import com.baidu.tieba.yc5;
import com.baidu.tieba.ye5;
import com.baidu.tieba.yq5;
import com.baidu.tieba.yv5;
import com.baidu.tieba.z15;
import com.baidu.tieba.z69;
import com.baidu.tieba.za5;
import com.baidu.tieba.zd8;
import com.baidu.tieba.zi5;
import com.baidu.tieba.zl5;
import com.baidu.tieba.zu4;
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
public class PbFragment extends BaseFragment implements su5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, q15.e, TbRichTextView.u, TbPageContextSupport, tk8, ol8.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final pl6.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public ug<TbImageView> A;
    public qu4 A0;
    public CustomMessageListener A1;
    public final BdListView.p A2;
    public ug<ImageView> B;
    public ForumManageModel B0;
    public CustomMessageListener B1;
    public int B2;
    public ug<View> C;
    public ba5 C0;
    public CustomMessageListener C1;
    public final TbRichTextView.a0 C2;
    public ug<TiebaPlusRecommendCard> D;
    public zd8 D0;
    public final CustomMessageListener D1;
    public boolean D2;
    public ug<LinearLayout> E;
    public PollingModel E0;
    public CustomMessageListener E1;
    public PostData E2;
    public ug<RelativeLayout> F;
    public ShareSuccessReplyToServerModel F0;
    public CustomMessageListener F1;
    public final s15.c F2;
    public ug<ItemCardView> G;
    public lh8 G0;
    public View.OnClickListener G1;
    public final s15.c G2;
    public ug<FestivalTipView> H;
    public boolean H0;
    public CustomMessageListener H1;
    public final AdapterView.OnItemClickListener H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public final View.OnLongClickListener I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public final View.OnClickListener J2;
    public boolean K;
    public oh8 K0;
    public CustomMessageListener K1;
    public final ItemCardHelper.c K2;
    public ug<GifView> L;
    public z15 L0;
    public CustomMessageListener L1;
    public final NoNetworkView.b L2;
    public String M;
    public b25 M0;
    public SuggestEmotionModel.c M1;
    public View.OnTouchListener M2;
    public boolean N;
    public String N0;
    public CustomMessageListener N1;
    public ol6.b N2;
    public boolean O;
    public boolean O0;
    public GetSugMatchWordsModel.b O1;
    public final ag8.b O2;
    public String P;
    public boolean P0;
    public boolean P1;
    public int P2;
    public LikeModel Q;
    public boolean Q0;
    public PraiseModel Q1;
    public int Q2;
    public View R;
    public String R0;
    public ri8.h R1;
    public String R2;
    public View S;
    public boolean S0;
    public CustomMessageListener S1;
    public uy4 S2;
    public View T;
    public n59 T0;
    public zi5 T1;
    public View U;
    public df5 U0;
    public zi5 U1;
    public String V;
    public bf5 V0;
    public CheckRealNameModel.b V1;
    public int W;
    public boolean W0;
    public je8 W1;
    public boolean X;
    public PermissionJudgePolicy X0;
    public final Runnable X1;
    public int[] Y;
    public ReplyPrivacyCheckController Y0;
    public CustomMessageListener Y1;
    public int Z;
    public ye5 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public xe5 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public xe5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public l05 c0;
    public int c1;
    public CustomMessageListener c2;
    public pl6 d;
    public BdUniqueId d0;
    public Object d1;
    public CustomMessageListener d2;
    public ri8 e;
    public x45 e0;
    public x9 e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public g55 f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public BdUniqueId g1;
    public q15.e g2;
    public boolean h;
    public Object h0;
    public Runnable h1;
    public h3 h2;
    public boolean i;
    public m59 i0;
    public qh8 i1;
    public b25.f i2;
    public VoiceManager j;
    public ya5 j0;
    public on j1;
    public SortSwitchButton.f j2;
    public int k;
    public String k1;
    public final View.OnClickListener k2;
    public s15 l;
    public TbRichTextImageInfo l1;
    public CustomMessageListener l2;
    public long m;
    public TbRichTextMemeInfo m1;
    public final NewWriteModel.d m2;
    public long n;
    public boolean n1;
    public Boolean n2;
    public long o;
    public int o1;
    public NewWriteModel.d o2;
    public long p;
    public int p1;
    public wb p2;
    public long q;
    public List<f3> q1;
    public final PbModel.h q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public CustomMessageListener r2;
    public boolean s;
    public boolean s0;
    public String s1;
    public HttpMessageListener s2;
    public zl5 t;
    @NonNull
    public TiePlusEventController.f t0;
    public we6 t1;
    public final qu4.a t2;
    public long u;
    public ej8 u0;
    public final f3 u1;
    public final AbsListView.OnScrollListener u2;
    public boolean v;
    public PushPermissionController v0;
    public final rg8.b v1;
    public final w9 v2;
    public long w;
    public PbInterviewStatusView.f w0;
    public final CustomMessageListener w1;
    public final i3 w2;
    public int x;
    public final Handler x0;
    public CustomMessageListener x1;
    public final k55.g x2;
    public String y;
    public PbModel y0;
    public CustomMessageListener y1;
    public final View.OnClickListener y2;
    public ug<TextView> z;
    public pj8 z0;
    public CustomMessageListener z1;
    public boolean z2;

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
    @Override // com.baidu.tieba.tk8
    /* renamed from: O5 */
    public VideoPbFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public void V(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.su5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048667, this, context, str) == null) {
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

    @Override // com.baidu.tieba.tk8
    public PbFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class h2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ h2 b;

            public a(h2 h2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = h2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    me8.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                gh.a().postDelayed(new a(this, customDialogData), 1000L);
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
                oh8 oh8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (oh8Var = this.a.c.K0) != null && oh8Var.g() != null) {
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
                int j = ej.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = ej.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = ej.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.G0 != null && this.c.G0.Z0() != null) {
                    this.c.G0.Z0().smoothScrollBy(i3, 50);
                }
                if (this.c.K5().j1() != null) {
                    this.c.V0.b().setVisibility(8);
                    this.c.K5().j1().t(this.a, this.b, this.c.K5().l1(), (this.c.y0 == null || this.c.y0.s1() == null || this.c.y0.s1().Q() == null || !this.c.y0.s1().Q().isBjh()) ? false : false);
                    ff5 f = this.c.K5().j1().f();
                    if (f != null && this.c.y0 != null && this.c.y0.s1() != null) {
                        f.H(this.c.y0.s1().d());
                        f.d0(this.c.y0.s1().Q());
                    }
                    if (this.c.K0.f() == null && this.c.K5().j1().f().u() != null) {
                        this.c.K5().j1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.K0.n(pbFragment2.K5().j1().f().u().i());
                        this.c.K5().j1().f().N(this.c.b1);
                    }
                }
                this.c.K5().v1();
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
                oh8 oh8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (oh8Var = this.a.c.K0) != null && oh8Var.g() != null) {
                    if (!this.a.c.K0.g().e()) {
                        this.a.c.K0.b(false);
                    }
                    this.a.c.K0.g().l(false);
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
                int j = ej.j(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = j / 2;
                    g = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.G0 != null && this.c.G0.Z0() != null) {
                    this.c.G0.Z0().smoothScrollBy(i3, 50);
                }
                if (this.c.K5().j1() != null) {
                    this.c.V0.b().setVisibility(8);
                    this.c.K5().j1().t(this.a, this.b, this.c.K5().l1(), (this.c.y0 == null || this.c.y0.s1() == null || this.c.y0.s1().Q() == null || !this.c.y0.s1().Q().isBjh()) ? false : false);
                    ff5 f = this.c.K5().j1().f();
                    if (f != null && this.c.y0 != null && this.c.y0.s1() != null) {
                        f.H(this.c.y0.s1().d());
                        f.d0(this.c.y0.s1().Q());
                    }
                    if (this.c.K0.f() == null && this.c.K5().j1().f().u() != null) {
                        this.c.K5().j1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.K0.n(pbFragment2.K5().j1().f().u().i());
                        this.c.K5().j1().f().N(this.c.b1);
                    }
                }
                this.c.K5().v1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:784:0x1e9a, code lost:
            if (r9 == (r32.a.G0.k1().c().getHeight() - r32.a.G0.k1().e())) goto L830;
         */
        /* JADX WARN: Code restructure failed: missing block: B:822:0x201c, code lost:
            if (r32.a.G0.e1.c.getView().getTop() <= ((r32.a.G0.k1() == null || r32.a.G0.k1().c() == null) ? 0 : r32.a.G0.k1().c().getBottom())) goto L759;
         */
        /* JADX WARN: Code restructure failed: missing block: B:823:0x201e, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:825:0x202b, code lost:
            if (r0 >= com.baidu.tieba.ii8.d(r32.a.E5())) goto L759;
         */
        /* JADX WARN: Code restructure failed: missing block: B:847:0x20d2, code lost:
            if ((r32.a.G0.e1.c.getView().getTop() - r32.a.G0.h.a.getBottom()) < (r32.a.G0.e1.c.g.getHeight() + 10)) goto L759;
         */
        /* JADX WARN: Removed duplicated region for block: B:1116:0x2a82  */
        /* JADX WARN: Removed duplicated region for block: B:1117:0x2a98  */
        /* JADX WARN: Removed duplicated region for block: B:1120:0x2ad4  */
        /* JADX WARN: Removed duplicated region for block: B:1362:0x347b  */
        /* JADX WARN: Removed duplicated region for block: B:1363:0x3480  */
        /* JADX WARN: Removed duplicated region for block: B:1366:0x348f  */
        /* JADX WARN: Removed duplicated region for block: B:1400:0x353d  */
        /* JADX WARN: Removed duplicated region for block: B:1403:0x354c  */
        /* JADX WARN: Removed duplicated region for block: B:1406:0x355f  */
        /* JADX WARN: Removed duplicated region for block: B:1409:0x3570  */
        /* JADX WARN: Removed duplicated region for block: B:1412:0x3586  */
        /* JADX WARN: Removed duplicated region for block: B:1414:0x358f  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            hd8 s1;
            int i;
            int i2;
            PostData Z;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            x15 x15Var;
            x15 x15Var2;
            x15 x15Var3;
            PbFragment pbFragment;
            int i3;
            boolean z;
            x15 x15Var4;
            x15 x15Var5;
            x15 x15Var6;
            x15 x15Var7;
            String name;
            int i4;
            boolean z2;
            int fixedNavHeight;
            int i5;
            int i6;
            g15 g15Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.s0 && (view2 == this.a.G0.h.c || view2 == this.a.G0.h.d || view2.getId() == R.id.obfuscated_res_0x7f0919ab || view2.getId() == R.id.obfuscated_res_0x7f090ae0 || view2.getId() == R.id.obfuscated_res_0x7f091d5f || view2.getId() == R.id.obfuscated_res_0x7f091948)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.G0.c1() && this.a.getPageContext().getPageActivity() != null && this.a.y0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.M1(), this.a.y0.f2(), this.a.y0.e2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.y0.getForumId());
                        statisticItem2.param("fname", this.a.y0.R0());
                        statisticItem2.param("tid", this.a.y0.M1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.G0.e1()) {
                        if (this.a.h) {
                            return;
                        }
                        if (this.a.y0.q2(true)) {
                            this.a.h = true;
                            this.a.G0.A3();
                        }
                    } else if (view2 == this.a.G0.h.n()) {
                        String string = StringUtils.string(view2.getTag(R.id.forum_name));
                        String string2 = StringUtils.string(view2.getTag(R.id.forum_id));
                        String string3 = StringUtils.string(view2.getTag(R.id.thread_id));
                        if (this.a.Q != null) {
                            this.a.Q.f0(string, string2);
                        }
                        TbPageTag l = hl5.l(this.a.getContext());
                        jj8.a("c14278", string2, string3, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    } else if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().s()) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.G0.v0();
                        this.a.l7();
                        this.a.G0.z3();
                        this.a.G0.V3();
                        if (this.a.G0.h1() != null) {
                            this.a.G0.h1().setVisibility(8);
                        }
                        this.a.y0.j3(1);
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().l()) {
                        if (view2 == this.a.G0.h.f) {
                            if (!this.a.G0.j0(this.a.y0.f1())) {
                                this.a.i = false;
                                ej.z(this.a.a, this.a.G0.h.f);
                                this.a.a.finish();
                            } else {
                                this.a.l7();
                                return;
                            }
                        } else if (view2 == this.a.G0.L0() || (this.a.G0.h.o() != null && (view2 == this.a.G0.h.o().t() || view2 == this.a.G0.h.o().u()))) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            } else if (this.a.y0.s1() == null || this.a.B0.g0()) {
                                return;
                            } else {
                                this.a.G0.v0();
                                int i9 = (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().u()) ? (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().t()) ? view2 == this.a.G0.L0() ? 2 : 0 : this.a.y0.s1().Q().getIs_good() == 1 ? 3 : 6 : this.a.y0.s1().Q().getIs_top() == 1 ? 5 : 4;
                                ForumData l2 = this.a.y0.s1().l();
                                String name3 = l2.getName();
                                String id = l2.getId();
                                String id2 = this.a.y0.s1().Q().getId();
                                this.a.G0.p4();
                                this.a.B0.k0(id, name3, id2, i9, this.a.G0.M0());
                            }
                        } else if (view2 == this.a.G0.S0()) {
                            if (this.a.y0 != null) {
                                zu4.s(this.a.getPageContext().getPageActivity(), this.a.y0.s1().Q().getTopicData().b());
                            }
                        } else if (view2 == this.a.G0.h.c) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            if (this.a.y0.s1() != null && this.a.y0.s1().Q() != null && this.a.y0.s1().Q().isVideoThreadType() && this.a.y0.s1().Q().getThreadVideoInfo() != null) {
                                TiebaStatic.log(new StatisticItem("c11922"));
                            }
                            if (this.a.y0.getErrorNo() == 4) {
                                if (!StringUtils.isNull(this.a.y0.R0()) || this.a.y0.H0() == null) {
                                    this.a.a.finish();
                                    return;
                                }
                                name2 = this.a.y0.H0().b;
                            } else {
                                name2 = this.a.y0.s1().l().getName();
                            }
                            if (StringUtils.isNull(name2)) {
                                this.a.a.finish();
                                return;
                            }
                            String R0 = this.a.y0.R0();
                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                            if (!this.a.y0.X0() || R0 == null || !R0.equals(name2)) {
                                this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                            } else {
                                this.a.a.finish();
                            }
                        } else if (view2 == this.a.G0.h.d) {
                            if (xp5.a()) {
                                return;
                            }
                            if (this.a.y0 == null || this.a.y0.s1() == null) {
                                ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eb8));
                                return;
                            }
                            ArrayList<PostData> H = this.a.y0.s1().H();
                            if ((H == null || H.size() <= 0) && this.a.y0.K1()) {
                                ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eb8));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.y0.M1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y0.getForumId()));
                            if (!this.a.G0.Z1()) {
                                this.a.G0.U2();
                            }
                            this.a.v6();
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09196c) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.G0.j3(true);
                            this.a.G0.U2();
                            if (this.a.h) {
                                return;
                            }
                            this.a.h = true;
                            this.a.G0.f4();
                            this.a.l7();
                            this.a.G0.z3();
                            this.a.y0.n3(this.a.x5());
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091943) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.G0.v0();
                            if (view2.getId() != R.id.obfuscated_res_0x7f091943 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                if (!jh8.c(this.a.getPageContext(), 11009) || this.a.y0.I0(this.a.G0.Y0()) == null) {
                                    return;
                                }
                                this.a.o6();
                                if (this.a.y0.s1() != null && this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.s1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getAuthor() != null && this.a.y0.s1().Q().getAuthor().getUserId() != null && this.a.A0 != null) {
                                    int w = jh8.w(this.a.y0.s1());
                                    ThreadData Q = this.a.y0.s1().Q();
                                    if (Q.isBJHArticleThreadType()) {
                                        i8 = 2;
                                    } else if (Q.isBJHVideoThreadType()) {
                                        i8 = 3;
                                    } else if (Q.isBJHNormalThreadType()) {
                                        i8 = 4;
                                    } else {
                                        i8 = Q.isBJHVideoDynamicThreadType() ? 5 : 1;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 1).param("obj_id", this.a.y0.s1().Q().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", w).param("obj_param1", i8));
                                }
                            } else {
                                this.a.U = view2;
                                return;
                            }
                        } else if ((this.a.G0.h.o() != null && view2 == this.a.G0.h.o().q()) || view2.getId() == R.id.obfuscated_res_0x7f090ae0 || view2.getId() == R.id.obfuscated_res_0x7f091d5f) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.G0.v0();
                            if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().q() && !this.a.G0.Z1()) {
                                this.a.G0.U2();
                            }
                            if (this.a.h) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.l7();
                            this.a.G0.z3();
                            boolean o3 = view2.getId() == R.id.obfuscated_res_0x7f090ae0 ? this.a.y0.o3(true, this.a.x5()) : view2.getId() == R.id.obfuscated_res_0x7f091d5f ? this.a.y0.o3(false, this.a.x5()) : this.a.y0.n3(this.a.x5());
                            view2.setTag(Boolean.valueOf(o3));
                            if (o3) {
                                i7 = 1;
                                this.a.G0.j3(true);
                                this.a.G0.f4();
                                this.a.h = true;
                                this.a.G0.n3(true);
                            } else {
                                i7 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                        } else if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().m()) {
                            if (view2.getId() == R.id.share_num_container) {
                                if (!jh8.c(this.a.getPageContext(), 11009)) {
                                    return;
                                }
                                jh8.x(this.a.getContext(), 3, this.a.t5(), this.a.y0);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091948 || view2.getId() == R.id.share_more_container) {
                                if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (s1 = this.a.y0.s1()) == null) {
                                    return;
                                }
                                ThreadData Q2 = s1.Q();
                                if (Q2 != null && Q2.getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", s1.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                    statisticItem3.param("tid", this.a.y0.M1());
                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem3.param("fid", this.a.y0.getForumId());
                                    if (view2.getId() != R.id.share_num_container) {
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
                                                if (Q2.getBaijiahaoData() != null && !dj.isEmpty(Q2.getBaijiahaoData().oriUgcVid)) {
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
                                    if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    }
                                    if (this.a.N() != null) {
                                        hl5.e(this.a.N(), statisticItem3);
                                    }
                                    if (this.a.G0 != null) {
                                        statisticItem3.param("obj_param1", this.a.G0.V0());
                                    }
                                    TiebaStatic.log(statisticItem3);
                                    if (ej.F()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d11);
                                        return;
                                    } else if (s1 == null) {
                                        ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eb8));
                                        return;
                                    } else {
                                        ArrayList<PostData> H2 = this.a.y0.s1().H();
                                        if ((H2 == null || H2.size() <= 0) && this.a.y0.K1()) {
                                            ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eb8));
                                            return;
                                        }
                                        this.a.G0.v0();
                                        this.a.l7();
                                        if (s1.B() != null && !StringUtils.isNull(s1.B().a(), true)) {
                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.y0.s1().m()));
                                        }
                                        TiebaStatic.log(new StatisticItem("c11939"));
                                        if (AntiHelper.e(this.a.getContext(), Q2)) {
                                            return;
                                        }
                                        if (this.a.G0 != null) {
                                            this.a.G0.x0();
                                            this.a.G0.w4(s1);
                                        }
                                        if (ShareSwitch.isOn()) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091948) {
                                                i2 = 2;
                                            } else {
                                                i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                            }
                                            if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.G0.b2() && !s1.q0()) {
                                                if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                    if (ra5.c() > 0) {
                                                        jh8.G(this.a.getContext(), this.a.y0.s1());
                                                    } else {
                                                        int V0 = this.a.G0.V0();
                                                        this.a.G0.i0();
                                                        this.a.Y5(ra5.a(), V0);
                                                    }
                                                } else {
                                                    this.a.f7(i2);
                                                }
                                            } else {
                                                this.a.f7(i2);
                                            }
                                        } else {
                                            this.a.G0.V3();
                                            this.a.y0.M0().P(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                        }
                                    }
                                }
                                i = 1;
                                StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem32.param("tid", this.a.y0.M1());
                                statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem32.param("fid", this.a.y0.getForumId());
                                if (view2.getId() != R.id.share_num_container) {
                                }
                                statisticItem32.param("obj_name", i);
                                statisticItem32.param("obj_type", 1);
                                if (Q2 != null) {
                                }
                                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                }
                                if (this.a.N() != null) {
                                }
                                if (this.a.G0 != null) {
                                }
                                TiebaStatic.log(statisticItem32);
                                if (ej.F()) {
                                }
                            } else if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().r()) {
                                if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().y()) {
                                    if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().x()) {
                                        if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().v()) {
                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                            UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                            this.a.onChangeSkinType(skinType);
                                            UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                            if (skinType == 0) {
                                                TbadkCoreApplication.getInst().setSkinType(4);
                                            } else {
                                                b55.m().w("key_is_follow_system_mode", false);
                                                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                            }
                                            this.a.G0.h.l();
                                        } else if (this.a.G0.W0() == view2) {
                                            if (!this.a.G0.W0().getIndicateStatus()) {
                                                b69.d("c10725", null);
                                            } else {
                                                hd8 s12 = this.a.y0.s1();
                                                if (s12 != null && s12.Q() != null && s12.Q().getTaskInfoData() != null) {
                                                    String d = s12.Q().getTaskInfoData().d();
                                                    if (StringUtils.isNull(d)) {
                                                        d = s12.Q().getTaskInfoData().g();
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                }
                                            }
                                            this.a.Q5();
                                        } else if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().o()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            this.a.G0.v0();
                                            SparseArray<Object> a1 = this.a.G0.a1(this.a.y0.s1(), this.a.y0.K1(), 1);
                                            if (a1 == null) {
                                                return;
                                            }
                                            this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.s1().l().getId(), this.a.y0.s1().l().getName(), this.a.y0.s1().Q().getId(), StringUtils.string(this.a.y0.s1().X().getUserId()), StringUtils.string(a1.get(R.id.tag_forbid_user_name)), StringUtils.string(a1.get(R.id.tag_forbid_user_name_show)), StringUtils.string(a1.get(R.id.tag_forbid_user_post_id)), StringUtils.string(a1.get(R.id.tag_forbid_user_portrait)))));
                                        } else if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().k()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> a12 = this.a.G0.a1(this.a.y0.s1(), this.a.y0.K1(), 1);
                                            if (a12 != null) {
                                                this.a.G0.A2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
                                            }
                                            this.a.G0.h.k();
                                            if (this.a.M() != null && this.a.M().s1() != null && this.a.M().s1().Q() != null) {
                                                ThreadData Q3 = this.a.M().s1().Q();
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
                                        } else if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().n()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> a13 = this.a.G0.a1(this.a.y0.s1(), this.a.y0.K1(), 1);
                                            if (a13 != null) {
                                                if (StringUtils.isNull((String) a13.get(R.id.tag_del_multi_forum))) {
                                                    this.a.G0.x2(((Integer) a13.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a13.get(R.id.tag_del_post_id)), ((Integer) a13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a13.get(R.id.tag_del_post_is_self)).booleanValue());
                                                } else {
                                                    this.a.G0.y2(((Integer) a13.get(R.id.tag_del_post_type)).intValue(), (String) a13.get(R.id.tag_del_post_id), ((Integer) a13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a13.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(a13.get(R.id.tag_del_multi_forum)));
                                                }
                                            }
                                            this.a.G0.h.k();
                                        } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09212c && view2.getId() != R.id.obfuscated_res_0x7f09195c && view2.getId() != R.id.obfuscated_res_0x7f0917e6) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0919be) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f0919bc && view2.getId() != R.id.obfuscated_res_0x7f091b9c && view2.getId() != R.id.obfuscated_res_0x7f091956) {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09195a) {
                                                        try {
                                                            sparseArray = (SparseArray) view2.getTag();
                                                        } catch (ClassCastException e) {
                                                            e.printStackTrace();
                                                            sparseArray = null;
                                                        }
                                                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                        if (postData == null) {
                                                            return;
                                                        }
                                                        if (this.a.M0 == null) {
                                                            PbFragment pbFragment2 = this.a;
                                                            pbFragment2.M0 = new b25(pbFragment2.getContext());
                                                            this.a.M0.p(this.a.i2);
                                                        }
                                                        ArrayList arrayList = new ArrayList();
                                                        boolean z3 = this.a.M().s1() != null && this.a.M().s1().l0();
                                                        if (view2 != null && sparseArray != null) {
                                                            boolean booleanValue = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                            boolean booleanValue3 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                            boolean booleanValue4 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                            boolean booleanValue5 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                                                            boolean booleanValue6 = sparseArray.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                            if (postData.o() != null) {
                                                                boolean z4 = postData.o().hasAgree;
                                                                int q = postData.q();
                                                                if (z4 && q == 5) {
                                                                    pbFragment = this.a;
                                                                    i3 = R.string.action_cancel_dislike;
                                                                } else {
                                                                    pbFragment = this.a;
                                                                    i3 = R.string.action_dislike;
                                                                }
                                                                x15 x15Var8 = new x15(8, pbFragment.getString(i3), this.a.M0);
                                                                SparseArray sparseArray2 = new SparseArray();
                                                                sparseArray2.put(R.id.tag_clip_board, postData);
                                                                x15Var8.d.setTag(sparseArray2);
                                                                arrayList.add(x15Var8);
                                                            }
                                                            if (this.a.mIsLogin) {
                                                                if (!gj8.j(this.a.y0) && !booleanValue3 && booleanValue2) {
                                                                    x15 x15Var9 = new x15(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bf3), this.a.M0);
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
                                                                    x15Var9.d.setTag(sparseArray3);
                                                                    arrayList.add(x15Var9);
                                                                } else if ((jh8.C(this.a.y0.s1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                                    x15 x15Var10 = new x15(5, this.a.getString(R.string.report_text), this.a.M0);
                                                                    x15Var10.d.setTag(str);
                                                                    arrayList.add(x15Var10);
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
                                                                            x15 x15Var11 = new x15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
                                                                            x15Var11.d.setTag(sparseArray4);
                                                                            x15Var2 = x15Var11;
                                                                            x15Var = new x15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
                                                                            x15Var.d.setTag(sparseArray4);
                                                                        }
                                                                    } else {
                                                                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                    }
                                                                    x15Var2 = null;
                                                                    x15Var = new x15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
                                                                    x15Var.d.setTag(sparseArray4);
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
                                                                    if (this.a.y0.s1().Y() == 1002 && !booleanValue) {
                                                                        x15Var3 = new x15(6, this.a.getString(R.string.report_text), this.a.M0);
                                                                    } else {
                                                                        x15Var3 = new x15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
                                                                    }
                                                                    x15Var3.d.setTag(sparseArray5);
                                                                    x15Var2 = x15Var3;
                                                                    x15Var = null;
                                                                } else {
                                                                    x15Var = null;
                                                                    x15Var2 = null;
                                                                }
                                                                if (x15Var2 != null) {
                                                                    arrayList.add(x15Var2);
                                                                }
                                                                if (x15Var != null) {
                                                                    arrayList.add(x15Var);
                                                                }
                                                            }
                                                            this.a.M0.k(arrayList);
                                                            this.a.L0 = new z15(this.a.getPageContext(), this.a.M0);
                                                            this.a.L0.k();
                                                        }
                                                    } else if (view2 == this.a.G0.U0()) {
                                                        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                            this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, dh.g(this.a.y0.s1().m(), 0L), dh.g(this.a.y0.M1(), 0L), dh.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.y0.s1().Q().getPushStatusData())));
                                                        }
                                                    } else if (view2 == this.a.G0.h.p()) {
                                                        this.a.G0.J3();
                                                    } else if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().w()) {
                                                        if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().p()) {
                                                            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                            if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.y0.M1())) != null) {
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                this.a.G0.h.k();
                                                                TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                            }
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f090814 && view2.getId() != R.id.obfuscated_res_0x7f090add) {
                                                            int id3 = view2.getId();
                                                            if (id3 == R.id.pb_u9_text_view) {
                                                                if (!this.a.checkUpIsLogin() || (g15Var = (g15) view2.getTag()) == null || StringUtils.isNull(g15Var.p1())) {
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{g15Var.p1()});
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091d62 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    return;
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 != null && view2.getTag() != null) {
                                                                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                    PostData postData2 = (PostData) sparseArray6.get(R.id.tag_load_sub_data);
                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                        TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.y0.b));
                                                                    }
                                                                    if (this.a.M0 == null) {
                                                                        PbFragment pbFragment3 = this.a;
                                                                        pbFragment3.M0 = new b25(pbFragment3.getContext());
                                                                        this.a.M0.p(this.a.i2);
                                                                    }
                                                                    ArrayList arrayList2 = new ArrayList();
                                                                    jh8.y(view2);
                                                                    if (jh8.y(view2) && this.a.j1 != null) {
                                                                        this.a.j1.t();
                                                                    }
                                                                    if (sparseArray6.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                        ((Boolean) sparseArray6.get(R.id.tag_is_subpb)).booleanValue();
                                                                    }
                                                                    boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                    boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                    boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                    boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                    boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                    String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                    boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                    if (postData2 != null) {
                                                                        if (postData2.Z() != null && postData2.Z().toString().length() > 0) {
                                                                            x15 x15Var12 = new x15(3, this.a.getString(R.string.obfuscated_res_0x7f0f0478), this.a.M0);
                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                            sparseArray7.put(R.id.tag_clip_board, postData2);
                                                                            x15Var12.d.setTag(sparseArray7);
                                                                            arrayList2.add(x15Var12);
                                                                        }
                                                                        this.a.E2 = postData2;
                                                                    }
                                                                    if (this.a.y0.s1().r()) {
                                                                        String v = this.a.y0.s1().v();
                                                                        if (postData2 != null && !dj.isEmpty(v) && v.equals(postData2.O())) {
                                                                            z = true;
                                                                            if (!z) {
                                                                                x15Var4 = new x15(4, this.a.getString(R.string.remove_mark), this.a.M0);
                                                                            } else {
                                                                                x15Var4 = new x15(4, this.a.getString(R.string.obfuscated_res_0x7f0f0b4f), this.a.M0);
                                                                            }
                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                            sparseArray8.put(R.id.tag_clip_board, this.a.E2);
                                                                            sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                            x15Var4.d.setTag(sparseArray8);
                                                                            arrayList2.add(x15Var4);
                                                                            if (this.a.mIsLogin) {
                                                                                if (!gj8.j(this.a.y0) && !booleanValue9 && booleanValue8) {
                                                                                    x15 x15Var13 = new x15(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bf3), this.a.M0);
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
                                                                                    x15Var4.d.setTag(sparseArray9);
                                                                                    arrayList2.add(x15Var13);
                                                                                } else if (jh8.C(this.a.y0.s1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                    x15 x15Var14 = new x15(5, this.a.getString(R.string.report_text), this.a.M0);
                                                                                    x15Var14.d.setTag(str2);
                                                                                    arrayList2.add(x15Var14);
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
                                                                                            x15 x15Var15 = new x15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
                                                                                            x15Var15.d.setTag(sparseArray10);
                                                                                            x15Var6 = x15Var15;
                                                                                            x15Var5 = new x15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
                                                                                            x15Var5.d.setTag(sparseArray10);
                                                                                        }
                                                                                    } else {
                                                                                        sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                    }
                                                                                    x15Var6 = null;
                                                                                    x15Var5 = new x15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
                                                                                    x15Var5.d.setTag(sparseArray10);
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
                                                                                    if (this.a.y0.s1().Y() == 1002 && !booleanValue7) {
                                                                                        x15Var7 = new x15(6, this.a.getString(R.string.report_text), this.a.M0);
                                                                                    } else {
                                                                                        x15Var7 = new x15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
                                                                                    }
                                                                                    x15Var7.d.setTag(sparseArray11);
                                                                                    x15Var6 = x15Var7;
                                                                                    x15Var5 = null;
                                                                                } else {
                                                                                    x15Var5 = null;
                                                                                    x15Var6 = null;
                                                                                }
                                                                                if (x15Var6 != null) {
                                                                                    arrayList2.add(x15Var6);
                                                                                }
                                                                                if (x15Var5 != null) {
                                                                                    arrayList2.add(x15Var5);
                                                                                }
                                                                            }
                                                                            this.a.M0.k(arrayList2);
                                                                            this.a.L0 = new z15(this.a.getPageContext(), this.a.M0);
                                                                            this.a.L0.k();
                                                                        }
                                                                    }
                                                                    z = false;
                                                                    if (!z) {
                                                                    }
                                                                    SparseArray sparseArray82 = new SparseArray();
                                                                    sparseArray82.put(R.id.tag_clip_board, this.a.E2);
                                                                    sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                    x15Var4.d.setTag(sparseArray82);
                                                                    arrayList2.add(x15Var4);
                                                                    if (this.a.mIsLogin) {
                                                                    }
                                                                    this.a.M0.k(arrayList2);
                                                                    this.a.L0 = new z15(this.a.getPageContext(), this.a.M0);
                                                                    this.a.L0.k();
                                                                }
                                                            } else if (id3 == R.id.pb_act_btn) {
                                                                if (this.a.y0.s1() != null && this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getActUrl() != null) {
                                                                    zu4.s(this.a.getActivity(), this.a.y0.s1().Q().getActUrl());
                                                                    if (this.a.y0.s1().Q().getActInfoType() == 1) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    } else if (this.a.y0.s1().Q().getActInfoType() == 2) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.lottery_tail) {
                                                                if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                    String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                    TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.y0.s1().m()).param("tid", this.a.y0.s1().S()).param("lotterytail", StringUtils.string(string4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                    if (!this.a.y0.s1().S().equals(string4)) {
                                                                        this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string4, (String) null, (String) null, (String) null)));
                                                                    } else {
                                                                        this.a.G0.D3(0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091986 || id3 == R.id.obfuscated_res_0x7f091950) {
                                                                if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                    String string5 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                    String s = b55.m().s("tail_link", "");
                                                                    String string6 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                    if (!StringUtils.isNull(s)) {
                                                                        TiebaStatic.log("c10056");
                                                                        zu4.x(view2.getContext(), string5, UtilHelper.urlAddParam(s, "page_from=1&tailSkinId=" + string6), true, true, true);
                                                                    }
                                                                    this.a.G0.U2();
                                                                    TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string6));
                                                                }
                                                            } else if (id3 == R.id.join_vote_tv) {
                                                                if (view2 != null) {
                                                                    zu4.s(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                    if (this.a.t5() == 1 && this.a.y0 != null && this.a.y0.s1() != null) {
                                                                        jk8.u("c10397", this.a.y0.s1().m(), this.a.y0.s1().S(), currentAccount);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.look_all_tv) {
                                                                if (view2 != null) {
                                                                    String string7 = StringUtils.string(view2.getTag());
                                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                    zu4.s(this.a.getActivity(), string7);
                                                                    if (this.a.t5() == 1 && this.a.y0 != null && this.a.y0.s1() != null) {
                                                                        jk8.u("c10507", this.a.y0.s1().m(), this.a.y0.s1().S(), currentAccount2);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0915e4) {
                                                                this.a.k6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0915e3) {
                                                                this.a.h6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0928a1) {
                                                                if (this.a.y0 != null && this.a.y0.s1() != null && this.a.y0.s1().B() != null) {
                                                                    hd8 s13 = this.a.y0.s1();
                                                                    TiebaStatic.log(new StatisticItem("c11679").param("fid", s13.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{s13.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09289e) {
                                                                if (this.a.y0 != null && this.a.y0.s1() != null && this.a.y0.s1().B() != null) {
                                                                    hd8 s14 = this.a.y0.s1();
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", s14.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{s14.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09257b) {
                                                                if (this.a.o1 >= 0) {
                                                                    if (this.a.y0 != null) {
                                                                        this.a.y0.Q2();
                                                                    }
                                                                    if (this.a.y0 == null || this.a.G0.J0() == null) {
                                                                        i6 = 0;
                                                                    } else {
                                                                        i6 = 0;
                                                                        this.a.G0.J0().h0(this.a.y0.s1(), false);
                                                                    }
                                                                    this.a.o1 = i6;
                                                                    if (this.a.y0 != null) {
                                                                        if (this.a.G0.Z0() != null) {
                                                                            this.a.G0.Z0().setSelection(this.a.y0.l1());
                                                                        }
                                                                        this.a.y0.U2(0, 0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.qq_share_container) {
                                                                if (!jh8.c(this.a.getPageContext(), 11009)) {
                                                                    return;
                                                                }
                                                                jh8.x(this.a.getContext(), 8, this.a.t5(), this.a.y0);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0917e6) {
                                                                SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                if (sparseArray12 == null) {
                                                                    return;
                                                                }
                                                                this.a.j7(sparseArray12);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091945) {
                                                                if (this.a.G0.Z0() == null || this.a.y0 == null || this.a.y0.s1() == null) {
                                                                    return;
                                                                }
                                                                int firstVisiblePosition = this.a.G0.Z0().getFirstVisiblePosition();
                                                                View childAt = this.a.G0.Z0().getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                boolean y0 = this.a.y0.s1().y0();
                                                                boolean z5 = this.a.G0.k1() != null && this.a.G0.k1().g();
                                                                boolean X1 = this.a.G0.X1();
                                                                boolean z6 = firstVisiblePosition == 0 && top == 0;
                                                                if (!y0 || this.a.G0.k1() == null || this.a.G0.k1().c() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    int l3 = ((int) (ej.l(this.a.getContext()) * 0.5625d)) - this.a.G0.k1().e();
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
                                                                jh8.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.y0.s1());
                                                                if ((this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getReply_num() <= 0) || (X1 && z6)) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    if (!this.a.checkUpIsLogin()) {
                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                        return;
                                                                    }
                                                                    this.a.z6();
                                                                    if (this.a.y0.s1().Q().getAuthor() != null) {
                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.s1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                    }
                                                                } else {
                                                                    int j = (int) (ej.j(this.a.getContext()) * 0.6d);
                                                                    if (y0) {
                                                                        if (this.a.G0.e1 != null && this.a.G0.e1.c != null && this.a.G0.e1.c.getView() != null) {
                                                                            if (this.a.G0.e1.c.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    } else {
                                                                        if (this.a.G0.h1() != null) {
                                                                            z2 = this.a.G0.h1().getVisibility() == 0;
                                                                            if (!z2 && this.a.G0.e1 != null && this.a.G0.e1.c != null && this.a.G0.e1.c.getView() != null && this.a.G0.e1.c.getView().getParent() != null && this.a.G0.h != null && this.a.G0.h.a != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    }
                                                                    if (z2 || X1) {
                                                                        this.a.a0 = firstVisiblePosition;
                                                                        this.a.b0 = top;
                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                            this.a.G0.Z0().setSelectionFromTop(0, i11 - j);
                                                                            this.a.G0.Z0().smoothScrollBy(-j, 500);
                                                                        } else {
                                                                            this.a.G0.Z0().E(0, i11, 500);
                                                                        }
                                                                    } else if (this.a.a0 <= 0) {
                                                                        int d2 = ii8.d(this.a.getListView());
                                                                        if (ii8.e(this.a.getListView()) != -1) {
                                                                            d2--;
                                                                        }
                                                                        int g = ej.g(this.a.getContext(), R.dimen.tbds100);
                                                                        if (d2 < 0) {
                                                                            d2 = (ListUtils.getCount(this.a.G0.Z0().getData()) - 1) + this.a.G0.Z0().getHeaderViewsCount();
                                                                            g = 0;
                                                                        }
                                                                        if (z5) {
                                                                            fixedNavHeight = (int) (ej.l(this.a.getContext()) * 0.5625d);
                                                                        } else if (!y0 || this.a.G0.k1() == null) {
                                                                            if (this.a.G0.h != null && this.a.G0.h.a != null) {
                                                                                fixedNavHeight = this.a.G0.h.a.getFixedNavHeight() - 10;
                                                                            }
                                                                            if (this.a.G0.e1 != null || this.a.G0.e1.c == null || this.a.G0.e1.c.getView() == null || this.a.G0.e1.c.getView().getParent() == null) {
                                                                                this.a.G0.Z0().setSelectionFromTop(d2, g + j);
                                                                                this.a.G0.Z0().smoothScrollBy(j, 500);
                                                                            } else if (z5) {
                                                                                this.a.G0.Z0().smoothScrollBy(this.a.G0.e1.c.getView().getTop() - ((int) (ej.l(this.a.getContext()) * 0.5625d)), 500);
                                                                            } else {
                                                                                this.a.G0.Z0().E(d2, g, 200);
                                                                            }
                                                                        } else {
                                                                            fixedNavHeight = this.a.G0.k1().d();
                                                                        }
                                                                        g += fixedNavHeight;
                                                                        if (this.a.G0.e1 != null) {
                                                                        }
                                                                        this.a.G0.Z0().setSelectionFromTop(d2, g + j);
                                                                        this.a.G0.Z0().smoothScrollBy(j, 500);
                                                                    } else if (this.a.G0.Z0().getChildAt(this.a.a0) != null) {
                                                                        this.a.G0.Z0().E(this.a.a0, this.a.b0, 200);
                                                                    } else {
                                                                        this.a.G0.Z0().setSelectionFromTop(this.a.a0, this.a.b0 + j);
                                                                        this.a.G0.Z0().smoothScrollBy(j, 500);
                                                                    }
                                                                }
                                                                if (this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.s1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0919aa || id3 == R.id.obfuscated_res_0x7f0919ab) {
                                                                if (this.a.y0 == null || this.a.y0.s1() == null || this.a.y0.s1().l() == null || dj.isEmpty(this.a.y0.s1().l().getName())) {
                                                                    return;
                                                                }
                                                                if (this.a.y0.getErrorNo() == 4) {
                                                                    if (!StringUtils.isNull(this.a.y0.R0()) || this.a.y0.H0() == null) {
                                                                        this.a.a.finish();
                                                                        return;
                                                                    }
                                                                    name = this.a.y0.H0().b;
                                                                } else {
                                                                    name = this.a.y0.s1().l().getName();
                                                                }
                                                                if (StringUtils.isNull(name)) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                String R02 = this.a.y0.R0();
                                                                if (!this.a.y0.X0() || R02 == null || !R02.equals(name)) {
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.y0.s1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                } else {
                                                                    this.a.a.finish();
                                                                }
                                                                StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                statisticItem6.param("tid", this.a.y0.M1());
                                                                statisticItem6.param("fid", this.a.y0.getForumId());
                                                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                if (this.a.y0.s1().Q() != null) {
                                                                    statisticItem6.param("nid", this.a.y0.s1().Q().getNid());
                                                                }
                                                                TiebaStatic.log(statisticItem6);
                                                            } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                                if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                    if (this.a.y0 == null) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                    statisticItem7.param("tid", this.a.y0.M1());
                                                                    statisticItem7.param("fid", this.a.y0.getForumId());
                                                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem7.param("obj_locate", 2);
                                                                    TiebaStatic.log(statisticItem7);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0919d1) {
                                                                    if (this.a.y0 == null || this.a.y0.s1() == null) {
                                                                        return;
                                                                    }
                                                                    hd8 s15 = this.a.y0.s1();
                                                                    if (this.a.D0 == null) {
                                                                        PbFragment pbFragment4 = this.a;
                                                                        pbFragment4.D0 = new zd8(pbFragment4.getPageContext());
                                                                    }
                                                                    long g2 = dh.g(s15.S(), 0L);
                                                                    long g3 = dh.g(s15.m(), 0L);
                                                                    jk8.w("c13446", g3);
                                                                    PbFragment pbFragment5 = this.a;
                                                                    pbFragment5.registerListener(pbFragment5.p2);
                                                                    this.a.D0.a(g2, g3);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0919f6) {
                                                                    if (view2.getTag() instanceof SmartApp) {
                                                                        SmartApp smartApp = (SmartApp) view2.getTag();
                                                                        if (!h16.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                            if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                return;
                                                                            }
                                                                            zu4.s(this.a.getActivity(), smartApp.h5_url);
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.y0.M1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090f62) {
                                                                    if (!(view2.getTag() instanceof ThreadData)) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090f5f) {
                                                                    if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.Q != null) {
                                                                        this.a.Q.f0(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09195e || id3 == R.id.obfuscated_res_0x7f0919b6) {
                                                                    if (this.a.s0) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.y0.M1());
                                                                    statisticItem8.param("fid", this.a.y0.getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                    if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                        jk8.s(6);
                                                                    }
                                                                    PbFragment pbFragment6 = this.a;
                                                                    pbFragment6.b = false;
                                                                    pbFragment6.g5(view2);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f092599) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        jk8.s(5);
                                                                    }
                                                                    this.a.N6(false);
                                                                    this.a.k7((PostData) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                }
                                                            } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                return;
                                                            } else {
                                                                ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                if (this.a.y0.r1() != 3 || !this.a.v0() || this.a.y0.s1() == null || !ListUtils.isEmpty(this.a.y0.s1().p())) {
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
                                                            if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                return;
                                                            }
                                                            PostData postData3 = (PostData) sparseArray14.get(R.id.tag_load_sub_data);
                                                            View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                            if (postData3 == null || view3 == null) {
                                                                return;
                                                            }
                                                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090815);
                                                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090816);
                                                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090add);
                                                            if (postData3.v0()) {
                                                                postData3.W0(false);
                                                                hj8.e(postData3);
                                                            } else if (this.a.M() != null ? hj8.c(this.a.M().s1(), postData3) : false) {
                                                                postData3.W0(true);
                                                            }
                                                            SkinManager.setBackgroundColor(findViewById, postData3.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                            SkinManager.setViewTextColor(eMTextView, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                            WebPManager.setPureDrawable(imageView, postData3.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        }
                                                    } else {
                                                        this.a.G0.h.l();
                                                        this.a.G0.c4(this.a.H2);
                                                    }
                                                } else if (this.a.y0 == null) {
                                                    return;
                                                } else {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0919bc) {
                                                        StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                        statisticItem10.param("tid", this.a.y0.M1());
                                                        statisticItem10.param("fid", this.a.y0.getForumId());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("obj_locate", 6);
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091b9c) {
                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                            this.a.T = view2;
                                                            return;
                                                        }
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0919bc && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.T = view2;
                                                        return;
                                                    }
                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                        return;
                                                    }
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (!(sparseArray15.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                        return;
                                                    }
                                                    PostData postData4 = (PostData) sparseArray15.get(R.id.tag_load_sub_data);
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0919bc && (statisticItem = postData4.e0) != null) {
                                                        StatisticItem copy = statisticItem.copy();
                                                        copy.delete("obj_locate");
                                                        copy.param("obj_locate", 8);
                                                        TiebaStatic.log(copy);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091b9c || view2.getId() == R.id.obfuscated_res_0x7f091956) {
                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.y0.N1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.O()).param("obj_source", 1).param("obj_type", 3));
                                                    }
                                                    if (this.a.y0 == null || this.a.y0.s1() == null || this.a.K5().i1() == null || postData4.r() == null || postData4.F() == 1) {
                                                        return;
                                                    }
                                                    if (this.a.K5().j1() != null) {
                                                        this.a.K5().j1().g();
                                                    }
                                                    xd8 xd8Var = new xd8();
                                                    xd8Var.A(this.a.y0.s1().l());
                                                    xd8Var.E(this.a.y0.s1().Q());
                                                    xd8Var.C(postData4);
                                                    this.a.K5().i1().j0(xd8Var);
                                                    this.a.K5().i1().setPostId(postData4.O());
                                                    this.a.l6(view2, postData4.r().getUserId(), "", postData4);
                                                    if (this.a.V0 != null) {
                                                        this.a.G0.c3(this.a.V0.y());
                                                    }
                                                }
                                            } else if (this.a.y0 == null) {
                                                return;
                                            } else {
                                                StatisticItem statisticItem11 = new StatisticItem("c13398");
                                                statisticItem11.param("tid", this.a.y0.M1());
                                                statisticItem11.param("fid", this.a.y0.getForumId());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("obj_locate", 5);
                                                TiebaStatic.log(statisticItem11);
                                                if (view2.getId() != R.id.obfuscated_res_0x7f0919be || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                        return;
                                                    }
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (!(sparseArray16.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                        return;
                                                    }
                                                    PostData postData5 = (PostData) sparseArray16.get(R.id.tag_load_sub_data);
                                                    StatisticItem statisticItem12 = postData5.e0;
                                                    if (statisticItem12 != null) {
                                                        StatisticItem copy2 = statisticItem12.copy();
                                                        copy2.delete("obj_locate");
                                                        copy2.param("obj_locate", 8);
                                                        TiebaStatic.log(copy2);
                                                    }
                                                    if (this.a.y0 == null || this.a.y0.s1() == null) {
                                                        return;
                                                    }
                                                    String M1 = this.a.y0.M1();
                                                    String O = postData5.O();
                                                    int Y = this.a.y0.s1() != null ? this.a.y0.s1().Y() : 0;
                                                    AbsPbActivity.e A6 = this.a.A6(O);
                                                    if (A6 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M1, O, "pb", true, false, null, false, null, Y, postData5.g0(), this.a.y0.s1().d(), false, postData5.r().getIconInfo(), 5).addBigImageData(A6.a, A6.b, A6.g, A6.j);
                                                    addBigImageData.setKeyPageStartFrom(this.a.y0.r1());
                                                    addBigImageData.setFromFrsForumId(this.a.y0.getFromForumId());
                                                    addBigImageData.setWorksInfoData(this.a.y0.R1());
                                                    addBigImageData.setKeyFromForumId(this.a.y0.getForumId());
                                                    addBigImageData.setTiebaPlusData(this.a.y0.W(), this.a.y0.S(), this.a.y0.T(), this.a.y0.R(), this.a.y0.X());
                                                    addBigImageData.setBjhData(this.a.y0.K0());
                                                    if (this.a.y0.s1().o() != null) {
                                                        addBigImageData.setHasForumRule(this.a.y0.s1().o().has_forum_rule.intValue());
                                                    }
                                                    if (this.a.y0.s1().X() != null) {
                                                        addBigImageData.setIsManager(this.a.y0.s1().X().getIs_manager());
                                                    }
                                                    if (this.a.y0.s1().l().getDeletedReasonInfo() != null) {
                                                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.y0.s1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.y0.s1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                    }
                                                    if (this.a.y0.s1().l() != null) {
                                                        addBigImageData.setForumHeadUrl(this.a.y0.s1().l().getImage_url());
                                                        addBigImageData.setUserLevel(this.a.y0.s1().l().getUser_level());
                                                    }
                                                    if (this.a.G0 != null && this.a.y0.G != null) {
                                                        addBigImageData.setMainPostMaskVisibly(this.a.y0.G.Z().S || postData5.S);
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                } else {
                                                    this.a.S = view2;
                                                    return;
                                                }
                                            }
                                        } else {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0917e6) {
                                                StatisticItem statisticItem13 = new StatisticItem("c13398");
                                                statisticItem13.param("tid", this.a.y0.M1());
                                                statisticItem13.param("fid", this.a.y0.getForumId());
                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem13.param("obj_locate", 4);
                                                TiebaStatic.log(statisticItem13);
                                            }
                                            if (view2.getId() != R.id.obfuscated_res_0x7f09195c || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (!this.a.checkUpIsLogin()) {
                                                    jk8.r("c10517", this.a.y0.s1().m(), 3);
                                                    return;
                                                } else if (this.a.y0 == null || this.a.y0.s1() == null) {
                                                    return;
                                                } else {
                                                    this.a.G0.v0();
                                                    SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                    PostData postData6 = (PostData) sparseArray17.get(R.id.tag_load_sub_data);
                                                    PostData postData7 = (PostData) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                    View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                    if (postData6 == null || view4 == null) {
                                                        return;
                                                    }
                                                    if (postData6.J() == 1) {
                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                    }
                                                    StatisticItem statisticItem14 = postData6.e0;
                                                    if (statisticItem14 != null) {
                                                        StatisticItem copy3 = statisticItem14.copy();
                                                        copy3.delete("obj_locate");
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0917e6) {
                                                            copy3.param("obj_locate", 6);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09195c) {
                                                            copy3.param("obj_locate", 8);
                                                        }
                                                        TiebaStatic.log(copy3);
                                                    }
                                                    String M12 = this.a.y0.M1();
                                                    String O2 = postData6.O();
                                                    String O3 = postData7 != null ? postData7.O() : "";
                                                    int Y2 = this.a.y0.s1() != null ? this.a.y0.s1().Y() : 0;
                                                    this.a.l7();
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091d62) {
                                                        TiebaStatic.log("c11742");
                                                        AbsPbActivity.e A62 = this.a.A6(O2);
                                                        if (postData6 == null || this.a.y0 == null || this.a.y0.s1() == null || A62 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M12, O2, "pb", true, false, null, false, O3, Y2, postData6.g0(), this.a.y0.s1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(A62.a, A62.b, A62.g, A62.j);
                                                        if (!dj.isEmpty(O3)) {
                                                            addBigImageData2.setHighLightPostId(O3);
                                                            addBigImageData2.setKeyIsUseSpid(true);
                                                        }
                                                        addBigImageData2.setKeyFromForumId(this.a.y0.getForumId());
                                                        addBigImageData2.setTiebaPlusData(this.a.y0.W(), this.a.y0.S(), this.a.y0.T(), this.a.y0.R(), this.a.y0.X());
                                                        addBigImageData2.setBjhData(this.a.y0.K0());
                                                        addBigImageData2.setKeyPageStartFrom(this.a.y0.r1());
                                                        addBigImageData2.setFromFrsForumId(this.a.y0.getFromForumId());
                                                        addBigImageData2.setWorksInfoData(this.a.y0.R1());
                                                        if (this.a.G0 != null && this.a.y0.G != null && (Z = this.a.y0.G.Z()) != null) {
                                                            addBigImageData2.setMainPostMaskVisibly(Z.S || postData6.S);
                                                        }
                                                        if (this.a.y0.s1() != null && this.a.y0.s1().o() != null) {
                                                            addBigImageData2.setHasForumRule(this.a.y0.s1().o().has_forum_rule.intValue());
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    } else {
                                                        AbsPbActivity.e A63 = this.a.A6(O2);
                                                        if (this.a.y0 == null || this.a.y0.s1() == null || A63 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M12, O2, "pb", true, false, null, true, null, Y2, postData6.g0(), this.a.y0.s1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(A63.a, A63.b, A63.g, A63.j);
                                                        addBigImageData3.setKeyPageStartFrom(this.a.y0.r1());
                                                        addBigImageData3.setFromFrsForumId(this.a.y0.getFromForumId());
                                                        addBigImageData3.setWorksInfoData(this.a.y0.R1());
                                                        addBigImageData3.setKeyFromForumId(this.a.y0.getForumId());
                                                        addBigImageData3.setBjhData(this.a.y0.K0());
                                                        addBigImageData3.setTiebaPlusData(this.a.y0.W(), this.a.y0.S(), this.a.y0.T(), this.a.y0.R(), this.a.y0.X());
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                    }
                                                }
                                            } else {
                                                this.a.S = view2;
                                                return;
                                            }
                                        }
                                    } else if (this.a.y0 == null || this.a.y0.s1() == null || this.a.y0.s1().Q() == null) {
                                        return;
                                    } else {
                                        this.a.G0.h.k();
                                        TiebaStatic.log(new StatisticItem("c13062"));
                                        PbFragment pbFragment7 = this.a;
                                        pbFragment7.U5(pbFragment7.y0.s1().Q().getFirstPostId());
                                    }
                                } else {
                                    this.a.G0.v0();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.h) {
                                        view2.setTag(Integer.valueOf(this.a.y0.I1()));
                                        return;
                                    } else {
                                        this.a.l7();
                                        this.a.G0.z3();
                                        z15 z15Var = new z15(this.a.getPageContext());
                                        if (this.a.y0.s1().f == null || this.a.y0.s1().f.size() <= 0) {
                                            strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                        } else {
                                            strArr = new String[this.a.y0.s1().f.size()];
                                            for (int i12 = 0; i12 < this.a.y0.s1().f.size(); i12++) {
                                                strArr[i12] = this.a.y0.s1().f.get(i12).sort_name + this.a.getResources().getString(R.string.sort_static);
                                            }
                                        }
                                        z15Var.i(null, strArr, new a(this, z15Var, view2));
                                        z15Var.k();
                                    }
                                }
                            } else {
                                this.a.G0.v0();
                                if (this.a.M().s1().g == 2) {
                                    this.a.showToast(R.string.hot_sort_jump_hint);
                                    return;
                                }
                                if (this.a.y0.q1() != null) {
                                    this.a.G0.j4(this.a.y0.q1(), this.a.g2);
                                }
                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            }
                        } else {
                            this.a.G0.h.k();
                        }
                    } else {
                        this.a.G0.h.l();
                        if (this.a.y0 != null) {
                            this.a.t1.f(this.a.y0.M1());
                        }
                        if (this.a.y0 != null && this.a.y0.isPrivacy()) {
                            this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (this.a.M() == null || this.a.M().s1() == null) {
                                return;
                            }
                            this.a.t1.d(3, 3, this.a.M().s1().S());
                            return;
                        }
                        this.a.t1.b();
                        int i13 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().s1() == null || this.a.M().s1().S() == null || !this.a.M().s1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                        if (this.a.M() != null && this.a.M().s1() != null) {
                            this.a.t1.d(3, i13, this.a.M().s1().S());
                        }
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea9).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091d52) {
                        String w5 = this.a.w5();
                        if (TextUtils.isEmpty(w5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{w5});
                    }
                } else if (!this.a.s0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.y0.M1());
                    statisticItem15.param("fid", this.a.y0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                        jk8.s(2);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (!this.a.v) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (!(obj instanceof PostData)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        PostData postData8 = (PostData) obj;
                        if (this.a.y0 != null && this.a.y0.s1() != null && this.a.K5().i1() != null && postData8.r() != null && postData8.F() != 1) {
                            if (!this.a.checkUpIsLogin()) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                return;
                            }
                            if (this.a.K5().j1() != null) {
                                this.a.K5().j1().g();
                            }
                            xd8 xd8Var2 = new xd8();
                            xd8Var2.A(this.a.y0.s1().l());
                            xd8Var2.E(this.a.y0.s1().Q());
                            xd8Var2.C(postData8);
                            this.a.K5().i1().j0(xd8Var2);
                            this.a.K5().i1().setPostId(postData8.O());
                            this.a.l6(view2, postData8.r().getUserId(), "", postData8);
                            TiebaStatic.log("c11743");
                            jk8.b(this.a.y0.s1(), postData8, postData8.d0, 8, 1);
                            if (this.a.V0 != null) {
                                this.a.G0.c3(this.a.V0.y());
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
        public class a implements b25.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z15 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ k1 c;

            public a(k1 k1Var, z15 z15Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var, z15Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = k1Var;
                this.a = z15Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.y0.J1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.b25.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void J0(b25 b25Var, int i, View view2) {
                boolean p3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, b25Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.y0.J1() != 1 || i != 1) {
                        if (this.c.a.y0.J1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.y0.J1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f0919cc) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.y0.s1().f != null && this.c.a.y0.s1().f.size() > i) {
                            i = this.c.a.y0.s1().f.get(i).sort_type.intValue();
                        }
                        p3 = this.c.a.y0.p3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.y0.I1()));
                        if (p3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.G0.n3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f0919cc) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.y0.s1().f != null) {
                        i = this.c.a.y0.s1().f.get(i).sort_type.intValue();
                    }
                    p3 = this.c.a.y0.p3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.y0.I1()));
                    if (p3) {
                    }
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
                    this.b.a.G0.F2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    q15Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    q15Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m95 m95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m95Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0.s1() != null) {
                        statisticItem.param("fid", this.a.y0.s1().m());
                    }
                    statisticItem.param("tid", this.a.y0.M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (dj.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.l7();
                this.a.G0.x3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.E0 != null) {
                    this.a.E0.u0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    gh.a().postDelayed(this.a.X1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.V0.x() || this.a.V0.z()) {
                            this.a.V0.w(false, postWriteCallBackData);
                        }
                        this.a.K0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Y0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        q15 q15Var = new q15(this.a.getActivity());
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            q15Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            q15Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new b(this));
                        q15Var.setPositiveButton(R.string.open_now, new c(this));
                        q15Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ed9.d(i) || m95Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.U6(i, antiData, str);
                        return;
                    }
                }
                this.a.e7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.V6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.G0.N1(this.a.y0.s1());
                    }
                } else if (this.a.y0.V0()) {
                    hd8 s1 = this.a.y0.s1();
                    if (s1 != null && s1.Q() != null && s1.Q().getAuthor() != null && (userId = s1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.y0.m3()) {
                        this.a.G0.z3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.y0.m3()) {
                    this.a.G0.z3();
                }
                if (this.a.y0.Z0()) {
                    jk8.p("c10369", this.a.y0.M1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.y0 != null) {
                    Context context = this.a.getContext();
                    hd8 s12 = this.a.y0.s1();
                    String forumId = this.a.y0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    jh8.a(context, s12, forumId, z2, this.a.y0.x1(), this.a.y0.A1(), this.a.y0.z1(), this.a.y0.y1(), this.a.y0.E1(), this.a.y0.F1());
                }
                if (writeData != null) {
                    w65.b(writeData.getContent(), "1");
                }
                if (this.a.d6()) {
                    this.a.o7();
                }
                this.a.c7();
            }
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.G0 != null && this.a != null) {
                    this.b.a.G0.F2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    q15Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    q15Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m95 m95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m95Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0 != null && this.a.y0.s1() != null) {
                        statisticItem.param("fid", this.a.y0.s1().m());
                    }
                    if (this.a.y0 != null) {
                        statisticItem.param("tid", this.a.y0.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.C5()) {
                        this.a.N6(false);
                        lc8.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12ed));
                    }
                    oh8 oh8Var = this.a.K0;
                    if (oh8Var != null) {
                        oh8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        cb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        w65.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.d6()) {
                        this.a.o7();
                    }
                    this.a.c7();
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
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    q15 q15Var = new q15(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        q15Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        q15Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new b(this));
                    q15Var.setPositiveButton(R.string.open_now, new c(this));
                    q15Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.K0 != null) {
                        if (pbFragment.G0 != null && this.a.G0.j1() != null && this.a.G0.j1().f() != null && this.a.G0.j1().f().y()) {
                            this.a.G0.j1().f().w(postWriteCallBackData);
                        }
                        this.a.K0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q1 a;

            public a(q1 q1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                s55 s55Var = new s55();
                s55Var.b = R.raw.lottie_bubble_breath_tip;
                s55Var.a = BreatheTipWidget.PointType.LOTTIE;
                s55Var.c = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                t55 t55Var = new t55();
                t55Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f0531);
                t55Var.b = this.a.a.getString(R.string.agree_tip_content);
                t55Var.e = R.drawable.pic_guidecard;
                t55Var.f = ej.g(this.a.a.getContext(), R.dimen.tbds156);
                t55Var.g = ej.g(this.a.a.getContext(), R.dimen.tbds489);
                t55Var.h = ej.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.G0.n1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.G0.n1()));
                breatheTipWidget.f(t55Var, s55Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    b55 m = b55.m();
                    m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    xa5.a("c14828");
                }
            }
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(hd8 hd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hd8Var) == null) {
                this.a.G0.N1(hd8Var);
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
            fm5 fm5Var = new fm5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            fm5Var.c();
            if (z2) {
                j3 = j4;
                fm5Var.B = j3;
                fm5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.y0 != null && this.a.y0.s1() != null && this.a.y0.s1().Q() != null) {
                int threadType = this.a.y0.s1().Q().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        bm5 bm5Var = new bm5();
                        bm5Var.F = 1;
                        bm5Var.a(1005);
                        bm5Var.D = j3;
                        bm5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        fm5 fm5Var2 = new fm5();
                        fm5Var2.a(1000);
                        fm5Var2.D = j3;
                        fm5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, hd8 hd8Var, String str, int i4) {
            ArrayList<PostData> arrayList;
            int i5;
            fd5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), hd8Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090755));
                }
                if (z && hd8Var != null && hd8Var.a0() == null && ListUtils.getCount(hd8Var.H()) < 1) {
                    this.a.y0.j3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.G0 != null) {
                        this.a.G0.g4();
                        return;
                    }
                    return;
                }
                if (!this.a.g0) {
                    this.a.g0 = true;
                } else if (this.a.M() != null) {
                    this.a.M().z0();
                }
                this.a.g = true;
                if (this.a.G0 == null) {
                    return;
                }
                this.a.G0.y3();
                if (hd8Var == null || !hd8Var.t0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.G0.t1());
                }
                this.a.G0.B1();
                if (!this.a.J && !this.a.G0.Z1()) {
                    if (!this.a.G0.S1()) {
                        this.a.G0.N3(false);
                    }
                } else {
                    this.a.G0.v1();
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && hd8Var != null) {
                    this.a.O0 = true;
                }
                if (hd8Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.G0.t1());
                    this.a.G0.I3();
                }
                String str2 = null;
                if (z && hd8Var != null) {
                    ThreadData Q = hd8Var.Q();
                    if (Q != null && Q.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.Q6(pbFragment3.U0);
                    }
                    this.a.G0.j1().r(hd8Var);
                    this.a.G0.U3();
                    if (Q != null && Q.getCartoonThreadData() != null) {
                        this.a.s7(Q.getCartoonThreadData());
                    }
                    if (this.a.V0 != null) {
                        this.a.G0.c3(this.a.V0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(hd8Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(hd8Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(hd8Var.X().getBimg_end_time());
                    if (hd8Var.H() != null && hd8Var.H().size() >= 1 && hd8Var.H().get(0) != null) {
                        this.a.y0.V2(hd8Var.H().get(0).O());
                    } else if (hd8Var.a0() != null) {
                        this.a.y0.V2(hd8Var.a0().O());
                    }
                    if (this.a.V0 != null) {
                        this.a.V0.H(hd8Var.d());
                        this.a.V0.I(hd8Var.l(), hd8Var.X());
                        this.a.V0.k0(Q);
                        this.a.V0.J(this.a.y0.U0(), this.a.y0.M1(), this.a.y0.Q0());
                        if (Q != null) {
                            this.a.V0.Z(Q.isMutiForumThread());
                        }
                    }
                    if (this.a.A0 != null) {
                        this.a.A0.h(hd8Var.r());
                    }
                    if (hd8Var.s() == 1) {
                        this.a.r = true;
                    } else {
                        this.a.r = false;
                    }
                    if (hd8Var.l0()) {
                        this.a.r = true;
                    }
                    this.a.G0.d3(this.a.r);
                    if (this.a.u0.f.size() > 0) {
                        hd8Var.S0(this.a.u0.f);
                    }
                    this.a.G0.Y3(hd8Var, i2, i3, this.a.y0.K1(), i4, this.a.y0.b1());
                    this.a.G0.n4(hd8Var, this.a.y0.K1());
                    this.a.G0.s4(this.a.y0.V0());
                    AntiData d = hd8Var.d();
                    if (d != null) {
                        this.a.y = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.V0 != null && this.a.V0.b() != null && (o = this.a.V0.b().o(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) o).setOnClickListener(this.a.G1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.y0.s1().H()) && !this.a.y0.g2()) {
                        this.a.X = true;
                        this.a.Z4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.R0)) {
                        ii8.i(this.a.y0.r1(), this.a.getListView(), this.a.R0);
                        this.a.R0 = null;
                    } else if (this.a.Q0) {
                        this.a.Q0 = false;
                        ii8.g(this.a.getListView());
                    } else if (this.a.S0) {
                        this.a.S0 = false;
                        ii8.j(this.a.getListView());
                    } else if (!TextUtils.isEmpty(this.a.y0.i1())) {
                        ii8.f(this.a.getListView(), this.a.y0.i1());
                        this.a.y0.o2();
                    } else {
                        this.a.G0.T3();
                    }
                    this.a.y0.p2(hd8Var.l(), this.a.M1);
                    this.a.y0.v2(this.a.O1);
                    if (this.a.Y0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.Y0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.y0 != null && this.a.y0.d2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.G0 != null) {
                        str2 = this.a.G0.l1();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.V0.c0(TbSingleton.getInstance().getAdVertiComment(hd8Var.r0(), hd8Var.s0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.O0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.y0.H0() != null && !StringUtils.isNull(this.a.y0.H0().c)) {
                                    this.a.G0.u4(this.a.y0.H0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.G0.t1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    g09.a("pb", false);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.G0.t1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                g09.a("pb", false);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                            }
                            this.a.G0.v1();
                            this.a.G0.u1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.y0.M1());
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
                        if (this.a.y0 != null && this.a.y0.s1() != null) {
                            arrayList = this.a.y0.s1().H();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                            this.a.G0.Y2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.f6()) {
                                this.a.G0.Z2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eb9));
                            } else {
                                this.a.G0.Z2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eba));
                            }
                            this.a.G0.N1(this.a.y0.s1());
                        }
                    } else {
                        this.a.G0.Y2("");
                    }
                    this.a.G0.D0();
                }
                if (hd8Var != null && hd8Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (!this.a.M().K1() || this.a.M().s1().z().c() != 0 || this.a.M().a2()) {
                    this.a.W0 = true;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (hd8Var != null) {
                        i5 = hd8Var.g();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.Z1(i5, this.a.G0);
                }
                int n = b55.m().n(b55.q("key_reaction_guide_show_number_pb"), 0);
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
            af5 af5Var = new af5();
            this.a.Q6(af5Var);
            PbFragment pbFragment = this.a;
            pbFragment.V0 = (bf5) af5Var.a(pbFragment.getContext());
            this.a.V0.W(this.a.a.getPageContext());
            this.a.V0.f0(this.a.m2);
            this.a.V0.g0(this.a.Z0);
            bf5 bf5Var = this.a.V0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            bf5Var.A(pageContext, extras);
            this.a.V0.b().E(true);
            this.a.G0.X2(this.a.V0.b());
            if (!this.a.y0.f1()) {
                this.a.V0.q(this.a.y0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.y0.d2()) {
                this.a.V0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.G0 != null) {
                this.a.V0.c0(this.a.G0.l1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                b55 m = b55.m();
                if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    gh.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ol6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.ol6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ol6.b
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

        @Override // com.baidu.tieba.ol6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.G0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.B5()) {
                    this.b.G0.A1();
                    this.b.G0.W2();
                }
            }
        }

        @Override // com.baidu.tieba.ol6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.G0 != null && this.b.e != null) {
                this.b.G0.d4();
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
            this.a.j5();
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
                this.a.n1 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 extends w9 {
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

        @Override // com.baidu.tieba.w9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.B0.getLoadDataMode()) {
                    case 0:
                        this.a.y0.X1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.p5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.G0.F0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.q5(pbFragment.B0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.G0.F0(this.a.B0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.G0.w2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.G0.F0(this.a.B0.getLoadDataMode(), false, null, false);
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
    public static class b implements pl6.b {
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

        @Override // com.baidu.tieba.pl6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ie8.d();
                } else {
                    ie8.c();
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
        public void a(mi8 mi8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, mi8Var) != null) || mi8Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, mi8Var.c()));
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
        public void onNavigationButtonClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q15Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) && q15Var != null) {
                q15Var.dismiss();
            }
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
        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.y0.h1()) {
                    this.a.G6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ag8.b {
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

        @Override // com.baidu.tieba.ag8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f15fa);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d11);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.G0.t0(str);
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
                if (!this.a.r0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.w6();
                        return;
                    } else {
                        this.a.I6();
                        return;
                    }
                }
                this.a.r0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                this.a.W5();
                a05 q1 = this.a.y0.q1();
                int g1 = this.a.G0.g1();
                if (g1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ebc);
                } else if (q1 != null && g1 > q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ebc);
                } else {
                    this.a.G0.v0();
                    this.a.l7();
                    this.a.G0.z3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.y0.j3(this.a.G0.g1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d11);
                    }
                    q15Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements i3 {
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
    }

    /* loaded from: classes5.dex */
    public class c3 implements vg<LinearLayout> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
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
    public class d implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    q15Var.dismiss();
                    ((TbPageContext) this.a.e1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                q15Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.e1.getPageActivity(), 2, true, 4);
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.G0 != null) {
                this.a.G0.E3(list);
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
                    this.a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.y0.s1().X().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.s1().l().getId(), this.a.y0.s1().l().getName(), this.a.y0.s1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements k55.g {
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

        @Override // com.baidu.tieba.k55.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.y0.u2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.G0.E0();
                }
            }
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
    public class e implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
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
            this.a.P1 = false;
            if (this.a.Q1 != null && str != null) {
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.P1 = false;
                if (this.a.Q1 == null) {
                    return;
                }
                hd8 s1 = this.a.y0.s1();
                if (s1.Q().getPraise().getIsLike() == 1) {
                    this.a.t7(0);
                } else {
                    this.a.t7(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, s1.Q()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements b25.f {
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

        @Override // com.baidu.tieba.b25.f
        public void J0(b25 b25Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b25Var, i, view2) == null) {
                if (this.a.L0 != null) {
                    this.a.L0.dismiss();
                }
                this.a.q7(i);
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
                                                    ag5.a aVar = new ag5.a();
                                                    aVar.a = this.a.k1;
                                                    String str = "";
                                                    if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.m1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.X4();
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
                                                    pbFragment.i1 = new qh8(pbFragment.getPageContext());
                                                }
                                                this.a.i1.b(this.a.k1, this.a.j1.n());
                                                this.a.j1 = null;
                                                this.a.k1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.E2;
                                            if (postData != null) {
                                                postData.H0();
                                                this.a.E2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.p6(view2);
                                            if (this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getAuthor() != null && this.a.y0.s1().Q().getAuthor().getUserId() != null && this.a.A0 != null) {
                                                int w = jh8.w(this.a.y0.s1());
                                                ThreadData Q = this.a.y0.s1().Q();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 2).param("obj_id", this.a.y0.s1().Q().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", w).param("obj_param1", i2));
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
                                                this.a.U5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.b5(sparseArray2);
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
                                                boolean E = this.a.N().E(TbadkCoreApplication.getCurrentAccount());
                                                if (E) {
                                                    if (booleanValue2) {
                                                        this.a.G0.z2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, E);
                                                        return;
                                                    } else {
                                                        this.a.W6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.G0.x2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
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
                                                    this.a.b5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.G0.C2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.G0.x2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                            if (postData2.o() == null) {
                                                return;
                                            }
                                            this.a.e5(postData2.o());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.y0 != null && this.a.y0.s1() != null) {
                                                this.a.a.S1(ed9.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.y0 != null && this.a.y0.s1() != null) {
                                    this.a.G0.z4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.C6(view3);
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
                            this.a.C6(view4);
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
                    this.a.C6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            if (((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue()) {
                                this.a.N6(true);
                            } else {
                                this.a.N6(false);
                            }
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.C6(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.y0.u2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.G0.E0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements rg8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.rg8.b
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

        @Override // com.baidu.tieba.rg8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.G0.o4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
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
                this.a.G0.k4(!this.a.N);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                if (q15Var != null) {
                    q15Var.dismiss();
                }
                this.d.m5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.z2 && this.a.B5()) {
                    this.a.h6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.f0 && this.a.G0 != null && this.a.G0.k0() && this.a.y0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.y0.M1());
                    statisticItem.param("fid", this.a.y0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.y0.X0()) {
                        i = 4;
                    } else if (this.a.y0.Y0()) {
                        i = 3;
                    } else if (this.a.y0.a1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.y0.q2(false)) {
                    this.a.G0.A3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if ((this.a.u0 == null || !this.a.y0.k2() || !this.a.u0.d()) && this.a.y0.s1() != null) {
                    this.a.G0.P2();
                }
                this.a.z2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                this.b.G0.V3();
                MessageManager.getInstance().sendMessage(this.a);
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements ri8.h {
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

        @Override // com.baidu.tieba.ri8.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.P6(z);
                if (this.a.G0.W0() != null && z) {
                    this.a.G0.k4(false);
                }
                this.a.G0.o2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y0 != null) {
                this.a.y0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<lh8> a;
        public WeakReference<PbFragment> b;

        public g3(lh8 lh8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(lh8Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                lh8 lh8Var = this.a.get();
                if (lh8Var != null) {
                    lh8Var.z1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.f7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        fa7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0d11);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements b25.f {
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

        @Override // com.baidu.tieba.b25.f
        public void J0(b25 b25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b25Var, i, view2) == null) {
                if (this.e.L0 != null) {
                    this.e.L0.dismiss();
                }
                if (i == 0) {
                    this.e.G0.x2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.g1);
                    this.e.h7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.G0.v0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.y0 != null && !this.a.y0.isLoading) {
                    this.a.l7();
                    this.a.G0.z3();
                    z = true;
                    if (this.a.y0.s1() != null && this.a.y0.s1().f != null && this.a.y0.s1().f.size() > i) {
                        int intValue = this.a.y0.s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.y0.N1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.y0.p3(intValue)) {
                            this.a.h = true;
                            this.a.G0.n3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i extends yq5<ShareItem> {
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
        @Override // com.baidu.tieba.yq5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.X2(this.a);
                }
                return ij8.d(this.b.t5(), 2, M);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.T2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().r() != null && this.a.u5().r().getGodUserData() != null) {
                        this.a.u5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.y0 != null && this.a.y0.s1() != null && this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getAuthor() != null) {
                        this.a.y0.s1().Q().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements xe5 {
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

        @Override // com.baidu.tieba.xe5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                oh8 oh8Var = this.a.K0;
                if (oh8Var != null && oh8Var.g() != null && this.a.K0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.K0.g().c());
                    if (this.a.G0 != null && this.a.G0.j1() != null && this.a.G0.j1().f() != null && this.a.G0.j1().f().y()) {
                        this.a.G0.j1().f().w(this.a.K0.h());
                    }
                    this.a.K0.b(true);
                    return true;
                } else if (!this.a.d5(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements cq5<ShareItem> {
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
        @Override // com.baidu.tieba.cq5
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
    public class j0 extends zi5<TipEvent> {
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
        @Override // com.baidu.tieba.si5
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
    public class j2 implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ q15 c;
        public final /* synthetic */ PbFragment d;

        public j2(PbFragment pbFragment, MarkData markData, MarkData markData2, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, q15Var};
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
            this.c = q15Var;
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
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
                this.d.m7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.y0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.V0 != null) {
                    this.a.G0.c3(this.a.V0.y());
                }
                this.a.G0.U2();
                this.a.G0.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends zi5<TopToastEvent> {
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
        @Override // com.baidu.tieba.si5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.G0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.G0.t1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ q15 b;
        public final /* synthetic */ PbFragment c;

        public k2(PbFragment pbFragment, MarkData markData, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, q15Var};
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
            this.b = q15Var;
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                q15Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.m7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
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
            this.a.y0.r3((UserPendantData) customResponsedMessage.getData());
            if (this.a.G0 != null && this.a.y0 != null) {
                this.a.G0.N2(this.a.y0.s1(), this.a.y0.K1(), this.a.y0.C1(), this.a.G0.p1());
            }
            if (this.a.G0 != null && this.a.G0.J0() != null) {
                this.a.G0.J0().Z();
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
            lh8 lh8Var = this.b.G0;
            lh8Var.C3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
            this.a.e7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ q15 b;
        public final /* synthetic */ PbFragment c;

        public l2(PbFragment pbFragment, MarkData markData, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, q15Var};
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
            this.b = q15Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.G0 != null && this.c.G0.t1() != null) {
                    this.c.G0.t1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.m7();
                }
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
                if (this.a.G0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.G0.f4();
                } else {
                    this.a.G0.B1();
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
                    this.a.V0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.G0 != null && this.a.G0.j1() != null && this.a.G0.j1().f() != null) {
                    this.a.G0.j1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements ye5 {
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

        @Override // com.baidu.tieba.ye5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements vg<ImageView> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
                    if (hx4.c().g()) {
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
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = hx4.c().g();
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
            if (this.a.V0 != null) {
                this.a.G0.c3(this.a.V0.y());
            }
            this.a.G0.N3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends w9 {
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

        @Override // com.baidu.tieba.w9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements vg<GifView> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
                if (hx4.c().g()) {
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
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = hx4.c().g();
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
                nc8 nc8Var = (nc8) customResponsedMessage.getData();
                int type = nc8Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (nc8Var.a() == null) {
                                this.a.E6(false, null);
                                return;
                            } else {
                                this.a.E6(true, (MarkData) nc8Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.p5((ForumManageModel.b) nc8Var.a(), false);
                    return;
                }
                this.a.F6((xd8) nc8Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements jc8.d {
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

        @Override // com.baidu.tieba.jc8.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements vg<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.G0 != null && this.a.G0.J0() != null) {
                this.a.G0.J0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements je8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.je8.a
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

        @Override // com.baidu.tieba.je8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091d80) {
                        if (this.a.J6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09014b) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof PostData)) {
                                return false;
                            }
                            PostData postData = (PostData) obj;
                            if (postData.getType() != PostData.T0 && !TextUtils.isEmpty(postData.t()) && hx4.c().g()) {
                                return this.a.r6(postData);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09195b) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.j7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.G0.T1() && view2.getId() == R.id.obfuscated_res_0x7f09197a) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.F0() != null && this.a.F0().b != null) {
                                this.a.F0().b.onClick(view2);
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
                        this.a.j7(sparseArray);
                    }
                }
                if (this.a.V0 != null) {
                    this.a.G0.c3(this.a.V0.y());
                }
                this.a.G0.U2();
                this.a.G0.v0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.je8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.n5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p1 extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p1(PbFragment pbFragment, int i, int i2) {
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

        @Override // com.baidu.tieba.wb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView r1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        ej.P(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.G0 != null && (r1 = this.a.G0.r1()) != null && this.a.G0.Z0() != null) {
                            this.a.G0.Z0().removeHeaderView(r1);
                            return;
                        }
                        return;
                    }
                    ej.Q(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements vg<View> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.u0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pu5.a)) {
                pu5.a aVar = (pu5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.R5(aVar.b);
                }
                pu5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.y0 != null && this.a.y0.d1()) {
                    this.a.m6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements vg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
            this.a.i7();
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements s15.c {
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

        @Override // com.baidu.tieba.s15.c
        public void a(s15 s15Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, s15Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.N0 = pbFragment.N0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new nf8(this.a.y0.M1(), this.a.N0, "1").start();
                    s15Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.N0 = pbFragment2.N0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new nf8(this.a.y0.M1(), this.a.N0, "2").start();
                    s15Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.N0 = pbFragment3.N0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.N0);
                    s15Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
            this.a.r7();
        }
    }

    /* loaded from: classes5.dex */
    public class r2 implements vg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
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
                bdTopToast.g(this.a.getString(R.string.novel_thread_mask_click_tip));
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
    public class s1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s1(PbFragment pbFragment, int i, boolean z) {
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
                    pbFragment.hideLoadingView(pbFragment.G0.t1());
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
                    this.a.R6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d11);
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
    public class s2 implements TbRichTextView.a0 {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            sf8 J0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.G0.l2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.y0.M1());
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
                        boolean w = ((TbImageView) view2).w();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                        }
                        this.a.R = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.y6(str, i, eVar);
                    if (this.a.y0.G.l0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().R() != null) {
                            ArrayList<TbRichTextImageInfo> R = tbRichTextView.getRichText().R();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < R.size()) {
                                if (R.get(i5) != null) {
                                    arrayList.add(R.get(i5).S());
                                    if (i6 == i4 && str != null && (str.equals(R.get(i5).S()) || str.equals(R.get(i5).O()) || str.equals(R.get(i5).N()) || str.equals(R.get(i5).getBigSrc()) || str.equals(R.get(i5).Q()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = R.get(i5).S();
                                    imageUrlData.originalUrl = R.get(i5).S();
                                    imageUrlData.isLongPic = R.get(i5).V();
                                    concurrentHashMap.put(R.get(i5).S(), imageUrlData);
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
                        this.a.r5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.y0.D1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.f6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.y0 != null) {
                            builder.D(this.a.y0.getFromForumId());
                            if (this.a.y0.s1() != null) {
                                builder.Q(this.a.y0.s1().Q());
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
                        builder2.I(this.a.y0.D1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.f6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.y0 != null) {
                            builder2.D(this.a.y0.getFromForumId());
                            if (this.a.y0.s1() != null) {
                                builder2.Q(this.a.y0.s1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText u7 = this.a.u7(str, i);
                        if (u7 != null && this.a.B2 >= 0 && this.a.B2 < u7.P().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = id8.a(u7.P().get(this.a.B2));
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
                            if (u7.getPostId() != 0 && (J0 = this.a.G0.J0()) != null) {
                                ArrayList<Cdo> t = J0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<Cdo> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Cdo next = it.next();
                                        if ((next instanceof PostData) && u7.getPostId() == dh.g(((PostData) next).O(), 0L)) {
                                            int i8 = 8;
                                            if (u7.getPostId() == dh.g(this.a.y0.Q0(), 0L)) {
                                                i8 = 1;
                                            }
                                            jk8.b(this.a.y0.s1(), (PostData) next, ((PostData) next).d0, i8, 3);
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
                            builder3.I(this.a.y0.D1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.f6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.y0 != null) {
                                builder3.D(this.a.y0.getFromForumId());
                                if (this.a.y0.s1() != null) {
                                    builder3.Q(this.a.y0.s1().Q());
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.A0 == null || this.a.A0.e()) {
                    return;
                }
                this.a.o6();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.G0.z1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                hd8 s1 = this.a.y0.s1();
                if (s1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    s1.w().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.g7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (dj.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.f1.c(errorString2);
                } else {
                    this.a.Z6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements qu4.a {
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

        @Override // com.baidu.tieba.qu4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.G0.y3();
                if (z) {
                    if (this.a.A0 != null) {
                        this.a.A0.h(z2);
                    }
                    this.a.y0.l3(z2);
                    if (!this.a.y0.d1()) {
                        this.a.G0.N1(this.a.y0.s1());
                    } else {
                        this.a.m6();
                    }
                    if (z2) {
                        boolean q0 = this.a.y0.s1().q0();
                        if (this.a.A0 != null && !q0) {
                            if (this.a.A0.f() != null && this.a.y0 != null && this.a.y0.s1() != null && this.a.y0.s1().Q() != null && this.a.y0.s1().Q().getAuthor() != null) {
                                MarkData f = this.a.A0.f();
                                MetaData author = this.a.y0.s1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d5);
                                        this.a.d7();
                                    } else {
                                        this.a.Y6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.W4();
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
                if (this.a.G0 != null && this.a.G0.j1() != null) {
                    eg8 j1 = this.a.G0.j1();
                    if (j1.j()) {
                        j1.h();
                        return true;
                    }
                }
                if (this.a.G0 != null && this.a.G0.c2()) {
                    this.a.G0.D1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.G0.z1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (dj.isEmpty(muteMessage)) {
                    muteMessage = this.a.e1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.f1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                q15Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u2 implements s15.c {
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

        @Override // com.baidu.tieba.s15.c
        public void a(s15 s15Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, s15Var, i, view2) == null) {
                if (s15Var != null) {
                    s15Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.E2;
                if (postData != null) {
                    if (i == 0) {
                        postData.H0();
                        this.a.E2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.q6(pbFragment2.E2);
                    }
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
                if (!this.a.d6() || this.a.a == null || this.a.a.H1() == null || !str.equals(this.a.a.H1().getTopicId())) {
                    return;
                }
                this.a.p7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements q15.e {
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

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                q15Var.dismiss();
                this.b.C0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.y0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements s15.c {
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

        @Override // com.baidu.tieba.s15.c
        public void a(s15 s15Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, s15Var, i, view2) == null) {
                if (s15Var != null) {
                    s15Var.e();
                }
                if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                    if (i == 0) {
                        if (this.a.m1 != null) {
                            ag5.a aVar = new ag5.a();
                            aVar.a = this.a.k1;
                            String str = "";
                            if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.m1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.X4();
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
                            pbFragment.i1 = new qh8(pbFragment.getPageContext());
                        }
                        this.a.i1.b(this.a.k1, this.a.j1.n());
                    }
                    this.a.j1 = null;
                    this.a.k1 = null;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof jz4)) {
                jz4 jz4Var = (jz4) customResponsedMessage.getData();
                c05.a aVar = new c05.a();
                int i = jz4Var.a;
                String str = jz4Var.b;
                aVar.a = jz4Var.d;
                hd8 s1 = this.a.y0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.y0.U0() != null && this.a.y0.U0().getUserIdLong() == jz4Var.p) {
                    this.a.G0.M2(jz4Var.l, this.a.y0.s1(), this.a.y0.K1(), this.a.y0.C1());
                }
                if (s1.H() != null && s1.H().size() >= 1 && s1.H().get(0) != null) {
                    long g = dh.g(s1.H().get(0).O(), 0L);
                    long g2 = dh.g(this.a.y0.M1(), 0L);
                    if (g == jz4Var.n && g2 == jz4Var.m) {
                        c05 M = s1.H().get(0).M();
                        if (M == null) {
                            M = new c05();
                        }
                        ArrayList<c05.a> a = M.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        M.e(M.b() + jz4Var.l);
                        M.d(a);
                        s1.H().get(0).N0(M);
                        this.a.G0.J0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hd9) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                hd9 hd9Var = (hd9) customResponsedMessage.getData();
                this.a.G0.z1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = hd9Var.a;
                boolean z = false;
                if (hd9Var.c == 0 && dataRes != null) {
                    int e = dh.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (dj.isEmpty(str)) {
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
                        this.a.G0.B2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.a7(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> H;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.y0 != null && this.a.y0.s1() != null && this.a.G0 != null && this.a.G0.J0() != null) {
                this.a.G0.u2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.y0.h2() && (H = this.a.y0.s1().H()) != null && !H.isEmpty()) {
                    int w = ((i + i2) - this.a.G0.J0().w()) - 1;
                    hd8 s1 = this.a.y0.s1();
                    if (s1 == null) {
                        return;
                    }
                    if (s1.E() != null && s1.E().p1()) {
                        w--;
                    }
                    if (s1.F() != null && s1.F().p1()) {
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
                if (!jh8.B(this.a.c1) && jh8.B(i)) {
                    if (this.a.G0 != null) {
                        this.a.r0 = true;
                        this.a.G0.v0();
                        if (this.a.V0 != null && !this.a.G0.P1()) {
                            this.a.G0.c3(this.a.V0.y());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.G0.U2();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.G0 != null) {
                    this.a.G0.v2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new zl5();
                    this.a.t.a(1001);
                }
                if (i == 0) {
                    this.a.t.e();
                    if (this.a.h0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.h0);
                        this.a.h0 = null;
                    }
                } else {
                    if (this.a.h0 == null) {
                        this.a.h0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.t.d();
                }
                this.a.c1 = i;
                if (i == 0) {
                    y39.g().h(this.a.getUniqueId(), true);
                    this.a.Z4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.y0 == null || this.a.y0.B1() == i + 1) {
                return;
            }
            this.a.M6(jh8.q(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yv5)) {
                yv5 yv5Var = (yv5) customResponsedMessage.getData();
                hd8 s1 = this.a.y0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.y0.s1() != null && this.a.y0.s1().Z().r() != null && this.a.y0.s1().Z().r().getPortrait() != null && this.a.y0.s1().Z().r().getPortrait().equals(yv5Var.a)) {
                    if (this.a.y0.s1().Z().r().getUserWorldCupData() != null) {
                        this.a.y0.s1().Z().r().getUserWorldCupData().d(yv5Var.b);
                    }
                    this.a.G0.N2(this.a.y0.s1(), this.a.y0.K1(), this.a.y0.C1(), this.a.G0.p1());
                }
                if (s1.H() != null && s1.H().size() >= 0) {
                    Iterator<PostData> it = s1.H().iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(yv5Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(yv5Var.b);
                        }
                    }
                    this.a.G0.J0().Z();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.G0.P1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.n5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements xe5 {
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

        @Override // com.baidu.tieba.xe5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                oh8 oh8Var = this.a.K0;
                if (oh8Var != null && oh8Var.e() != null && this.a.K0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.K0.e().c());
                    if (this.a.V0 != null && (this.a.V0.x() || this.a.V0.z())) {
                        this.a.V0.w(false, this.a.K0.h());
                    }
                    this.a.K0.a(true);
                    return true;
                } else if (this.a.d5(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x2 implements b25.d {
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

        @Override // com.baidu.tieba.b25.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.M0 != null) {
                this.a.M0.q(gj8.h(this.a.E2));
                ArrayList arrayList = new ArrayList();
                for (a25 a25Var : this.a.M0.g()) {
                    if (a25Var instanceof x15) {
                        arrayList.add((x15) a25Var);
                    }
                }
                gj8.f(arrayList);
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && this.a.y0.s1() != null) {
                this.a.y0.s1().a();
                this.a.y0.X1();
                if (this.a.G0.J0() != null) {
                    this.a.G0.N1(this.a.y0.s1());
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
            m59 m59Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m59) && (m59Var = (m59) customResponsedMessage.getData()) != null && (agreeData = m59Var.b) != null) {
                if (this.a.G0 != null) {
                    this.a.G0.h2(m59Var);
                }
                if (agreeData.agreeType == 2 && this.a.G0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !ij8.k(this.a.y0.b)) {
                    this.a.G0.i4();
                    ij8.b(this.a.y0.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements Comparator<qb5> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(qb5 qb5Var, qb5 qb5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qb5Var, qb5Var2)) == null) {
                return qb5Var.compareTo(qb5Var2);
            }
            return invokeLL.intValue;
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
                return pbFragment.g5(view2);
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
            v59 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && this.a.y0.s1() != null) {
                String str = (String) customResponsedMessage.getData();
                v59 v59Var = null;
                if (!TextUtils.isEmpty(str) && this.a.y0.s1().H() != null) {
                    ArrayList<PostData> H = this.a.y0.s1().H();
                    Iterator<PostData> it = H.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (next instanceof v59) {
                            v59 v59Var2 = (v59) next;
                            if (str.equals(v59Var2.q1())) {
                                v59Var = v59Var2;
                                break;
                            }
                        }
                    }
                    if (v59Var != null) {
                        H.remove(v59Var);
                    }
                }
                if (this.a.G0.J0() != null && !ListUtils.isEmpty(this.a.G0.J0().t())) {
                    ArrayList<Cdo> t = this.a.G0.J0().t();
                    if (v59Var != null) {
                        i = v59Var;
                    } else {
                        i = jh8.i(this.a.y0.s1(), str);
                    }
                    jh8.e(t, i);
                }
                if (this.a.G0.Z0() != null && !ListUtils.isEmpty(this.a.G0.Z0().getData())) {
                    List<Cdo> data = this.a.G0.Z0().getData();
                    if (v59Var == null) {
                        v59Var = jh8.i(this.a.y0.s1(), str);
                    }
                    jh8.e(data, v59Var);
                }
                this.a.i5(str);
                this.a.y0.X1();
                if (this.a.G0.J0() != null) {
                    this.a.G0.J0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.K5() != null) {
                this.a.K5().r2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q15Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
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
        T2 = new b1();
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        U2 = new b();
    }

    public final void K6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (pbModel = this.y0) != null && pbModel.s1() != null && this.y0.s1().Q() != null && this.y0.s1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void L6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (pbModel = this.y0) != null && pbModel.s1() != null && this.y0.s1().Q() != null && this.y0.s1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void W5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            ej.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean X6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || !pbModel.K1()) {
                return false;
            }
            if (this.y0.q1() != null && this.y0.q1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && za5.g(TbadkCoreApplication.getInst(), 0) && !this.G0.E2()) {
            this.j0 = za5.k(getPageContext(), "collect", 0L);
        }
    }

    public final void i7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbModel = this.y0) != null && !dj.isEmpty(pbModel.M1())) {
            sr4.w().P(rr4.Z, dh.g(this.y0.M1(), 0L));
        }
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (this.y0.s1() != null && this.y0.s1().Q() != null) {
                return this.y0.s1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void t6() {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (list = this.q1) != null && !list.isEmpty()) {
            int size = this.q1.size();
            while (true) {
                size--;
                if (size <= -1 || this.q1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.G0.v0();
            if (this.h) {
                return;
            }
            l7();
            this.G0.z3();
            if (this.y0.loadData()) {
                this.G0.f4();
            }
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
        this.t0 = new u(this);
        this.w0 = new f0(this);
        this.x0 = new Handler(new q0(this));
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
        this.Z0 = new m1(this);
        this.a1 = new x1(this);
        this.b1 = new i2(this);
        this.c1 = 0;
        this.n1 = false;
        this.o1 = 0;
        this.p1 = -1;
        this.r1 = 0;
        this.u1 = new t2(this);
        this.v1 = new e3(this);
        this.w1 = new k(this, 2004016);
        this.x1 = new l(this, 2016485);
        this.y1 = new m(this, 2001269);
        this.z1 = new n(this, 2004008);
        this.A1 = new o(this, 2004007);
        this.B1 = new p(this, 2004005);
        this.C1 = new q(this, 2001332);
        this.D1 = new r(this, 2921391);
        this.E1 = new s(this, 2921606);
        this.F1 = new t(this, 2921658);
        this.G1 = new v(this);
        this.H1 = new w(this, 2001369);
        this.I1 = new x(this, 2921787);
        this.J1 = new y(this, 2016488);
        this.K1 = new z(this, 2016331);
        this.L1 = new a0(this, 2921746);
        this.M1 = new b0(this);
        this.N1 = new c0(this, 2010045);
        this.O1 = new d0(this);
        this.Q1 = new PraiseModel(getPageContext(), new e0(this));
        this.R1 = new g0(this);
        this.S1 = new i0(this, 2001115);
        this.T1 = new j0(this);
        this.U1 = new k0(this);
        this.W1 = new je8(new p0(this));
        this.X1 = new s0(this);
        this.Y1 = new t0(this, 2001427);
        this.Z1 = new u0(this, 2001428);
        this.a2 = new v0(this, 2921634);
        this.b2 = new w0(this, 2001426);
        this.c2 = new x0(this, 2004021);
        this.d2 = new y0(this, 2016528);
        this.e2 = new z0(this, 2921724);
        this.f2 = new a1(this, 2921033);
        this.g2 = new c1(this);
        this.h2 = new d1(this);
        this.i2 = new e1(this);
        this.j2 = new h1(this);
        this.k2 = new k1(this);
        this.l2 = new l1(this, 2921480);
        this.m2 = new n1(this);
        this.n2 = Boolean.FALSE;
        this.o2 = new o1(this);
        this.p2 = new p1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.q2 = new q1(this);
        this.r2 = new r1(this, 2016450);
        this.s2 = new s1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.t2 = new t1(this);
        this.u2 = new w1(this);
        this.v2 = new a2(this);
        this.w2 = new c2(this);
        this.x2 = new d2(this);
        this.y2 = new e2(this);
        this.A2 = new f2(this);
        this.B2 = 0;
        this.C2 = new s2(this);
        this.D2 = false;
        this.E2 = null;
        this.F2 = new u2(this);
        this.G2 = new v2(this);
        this.H2 = new w2(this);
        this.I2 = new y2(this);
        this.J2 = new z2(this);
        this.K2 = new a3(this);
        this.L2 = new b3(this);
        this.M2 = new d3(this);
        this.N2 = new a(this);
        this.O2 = new c(this);
        this.P2 = -1;
        this.Q2 = -1;
    }

    @Override // com.baidu.tieba.su5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.su5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
            rh8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    public final void Y5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048648, this, i4, i5) == null) {
            cr5.b(new i(this, i5), new j(this, i5, i4));
        }
    }

    @Override // com.baidu.tieba.su5
    public void g0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048675, this, context, str) == null) {
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048717, this, i4, keyEvent)) == null) {
            if (keyEvent == null || (lh8Var = this.G0) == null || !lh8Var.m2(i4)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void H6(f3 f3Var) {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, f3Var) == null) && f3Var != null && (list = this.q1) != null) {
            list.remove(f3Var);
        }
    }

    public final void M6(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i4) == null) && this.y0 != null) {
            b7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.y0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z3) == null) {
            this.n2 = Boolean.valueOf(z3);
        }
    }

    public void O6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z3) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048627, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void T6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z3) == null) {
            this.V0.X(z3);
            this.V0.a0(z3);
            this.V0.i0(z3);
        }
    }

    public void U4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, f3Var) == null) && f3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(f3Var)) {
                this.q1.add(f3Var);
            }
        }
    }

    public void V4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, f3Var) == null) && f3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(f3Var)) {
                this.q1.add(0, f3Var);
            }
        }
    }

    public final void V5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, intent) == null) {
            ij8.j(this, intent);
        }
    }

    public final void f7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i4) == null) {
            ij8.n(this, t5(), i4);
        }
    }

    @Override // com.baidu.tieba.ol8.b
    public void g1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z3) == null) {
            this.P0 = z3;
        }
    }

    public final void g6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
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

    @Override // com.baidu.tieba.q15.e
    public void onClick(q15 q15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, q15Var) == null) {
            l5(q15Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ca
    public void onPreLoad(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, hoVar) == null) {
            PreLoadImageHelper.load(hoVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(hoVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.y0.R2(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.V0.F(bundle);
        }
    }

    public final void p6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            q6(postData);
        }
    }

    public final void s7(uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, uy4Var) == null) && uy4Var != null) {
            this.S2 = uy4Var;
            this.c = true;
            this.G0.R2();
            this.G0.m3(this.R2);
        }
    }

    public static PbFragment s6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65690, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public PbInterviewStatusView.f A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.w0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<TiebaPlusRecommendCard> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.D == null) {
                this.D = new ug<>(new o2(this), 5, 0);
            }
            return this.D;
        }
        return (ug) invokeV.objValue;
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.c && this.P2 == -1 && this.Q2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean B6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ya5 ya5Var = this.j0;
            if (ya5Var != null && ya5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.su5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            lh8 lh8Var = this.G0;
            if (lh8Var == null) {
                return 0;
            }
            return lh8Var.n1();
        }
        return invokeV.intValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    public boolean C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.su5
    /* renamed from: E5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            lh8 lh8Var = this.G0;
            if (lh8Var == null) {
                return null;
            }
            return lh8Var.Z0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public qi8 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.F0();
        }
        return (qi8) invokeV.objValue;
    }

    public int F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ug<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tk8
    public PbModel.h G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.q2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            hideNetRefreshView(this.G0.t1());
            b7();
            if (this.y0.w2()) {
                this.G0.z3();
            }
            this.G0.I3();
        }
    }

    public bf5 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.V0;
        }
        return (bf5) invokeV.objValue;
    }

    public ri8 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.e;
        }
        return (ri8) invokeV.objValue;
    }

    public void I6() {
        ya5 ya5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (ya5Var = this.j0) != null) {
            ya5Var.x();
        }
    }

    public ej8 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.u0;
        }
        return (ej8) invokeV.objValue;
    }

    public lh8 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.G0;
        }
        return (lh8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tk8
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.y0;
        }
        return (PbModel) invokeV.objValue;
    }

    public l05 M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.c0;
        }
        return (l05) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tk8
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public String N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<RelativeLayout> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new q2(this), 10, 0);
            this.F = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public String P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.P;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<FestivalTipView> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<ImageView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.B == null) {
                this.B = new ug<>(new m2(this), 8, 0);
            }
            return this.B;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<View> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.C == null) {
                this.C = new ug<>(new p2(this), 8, 0);
            }
            return this.C;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.H(getContext(), 8);
            }
            return this.z;
        }
        return (ug) invokeV.objValue;
    }

    public void X5() {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (lh8Var = this.G0) != null) {
            lh8Var.x1();
            W5();
        }
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new n0(this));
        }
    }

    public boolean c6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && za5.g(TbadkCoreApplication.getInst(), 0) && !this.G0.E2()) {
            this.j0 = za5.k(getPageContext(), "reply_pb", 0L);
        }
    }

    public final boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.H1() != null && this.a.H1().r1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<ItemCardView> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            if (this.G == null) {
                this.G = new ug<>(new r2(this), 10, 0);
            }
            return this.G;
        }
        return (ug) invokeV.objValue;
    }

    public final void l7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            hd8 s12 = this.y0.s1();
            this.y0.l3(true);
            qu4 qu4Var = this.A0;
            if (qu4Var != null) {
                s12.L0(qu4Var.g());
            }
            this.G0.N1(s12);
        }
    }

    public final void m7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048699, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.T1();
        }
    }

    public void n6() {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048701, this) != null) || (lh8Var = this.G0) == null) {
            return;
        }
        lh8Var.e2();
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
    public ho onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (ho) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            G6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public AntiData s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null) {
                return this.y0.s1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (pbModel = this.y0) != null && !dj.isEmpty(pbModel.M1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public PostData u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            hd8 hd8Var = this.y0.G;
            if (hd8Var != null) {
                return hd8Var.Z();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.su5
    public ug<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.L == null) {
                this.L = new ug<>(new n2(this), 20, 0);
            }
            return this.L;
        }
        return (ug) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    public String v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public final String w5() {
        InterceptResult invokeV;
        hd8 s12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || (s12 = pbModel.s1()) == null) {
                return null;
            }
            return s12.V().c;
        }
        return (String) invokeV.objValue;
    }

    public void w6() {
        ya5 ya5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && (ya5Var = this.j0) != null) {
            ya5Var.q();
        }
    }

    @Override // com.baidu.tieba.su5
    public ug<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.E == null) {
                this.E = new ug<>(new c3(this), 15, 0);
            }
            return this.E;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (pu5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), pu5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (rh8.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new bs5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.su5
    public void W(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048639, this, context, str, z3) == null) {
            if (rh8.c(str) && (pbModel = this.y0) != null && pbModel.M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.y0.M1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    jc5 jc5Var = new jc5();
                    jc5Var.a = str;
                    jc5Var.b = 3;
                    jc5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, jc5Var));
                }
            } else {
                rh8.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    public final AbsPbActivity.e A6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = null;
            if (this.y0.s1() != null && this.y0.s1().H() != null && this.y0.s1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.y0.s1().H().size()) {
                        if (str.equals(this.y0.s1().H().get(i4).O())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                PostData postData = this.y0.s1().H().get(i4);
                if (postData.Z() != null && postData.Z().P() != null) {
                    Iterator<TbRichTextData> it = postData.Z().P().iterator();
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
                    y6(str2, 0, eVar);
                    id8.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void F6(xd8 xd8Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, xd8Var) != null) || xd8Var.i() == null) {
            return;
        }
        String O = xd8Var.i().O();
        ArrayList<PostData> H = this.y0.s1().H();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= H.size()) {
                break;
            }
            PostData postData = H.get(i4);
            if (postData.O() != null && postData.O().equals(O)) {
                ArrayList<PostData> k3 = xd8Var.k();
                postData.d1(xd8Var.m());
                if (postData.d0() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.l0() != null && next != null && next.r() != null && (metaData = postData.l0().get(next.r().getUserId())) != null) {
                            next.G0(metaData);
                            next.T0(true);
                            next.m1(getPageContext(), this.y0.n2(metaData.getUserId()));
                        }
                    }
                    if (k3.size() == postData.d0().size()) {
                        z3 = false;
                    }
                    if (!postData.s0(false)) {
                        postData.d0().clear();
                        postData.d0().addAll(k3);
                    }
                }
                if (postData.y() != null) {
                    postData.E0();
                }
            } else {
                i4++;
            }
        }
        if (!this.y0.b1() && z3) {
            this.G0.N1(this.y0.s1());
        }
        if (z3) {
            D6(xd8Var);
        }
    }

    public void Z4(boolean z3) {
        lh8 lh8Var;
        int i4;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) && (lh8Var = this.G0) != null && lh8Var.Z0() != null) {
            int firstVisiblePosition = this.G0.Z0().getFirstVisiblePosition();
            int lastVisiblePosition = this.G0.Z0().getLastVisiblePosition();
            sf8 J0 = this.G0.J0();
            if (J0 != null && this.y0.s1() != null) {
                if (lastVisiblePosition <= J0.w()) {
                    i4 = 0;
                    w3 = 1;
                } else {
                    if (firstVisiblePosition > J0.w()) {
                        i4 = firstVisiblePosition - J0.w();
                    } else {
                        i4 = 0;
                    }
                    w3 = (lastVisiblePosition - J0.w()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (w3 > i4) {
                    while (i4 < w3) {
                        if (this.G0.Z0().G(i4) != null && (this.G0.Z0().G(i4) instanceof PostData) && (postData = (PostData) this.G0.Z0().G(i4)) != null) {
                            PostData postData2 = (PostData) ListUtils.getItem(this.y0.s1().H(), postData.F() - 1);
                            if (postData.n() == null && postData2 != null) {
                                postData.F0(postData2.n());
                            }
                            if (postData.n() != null) {
                                postData.n().q(postData.F());
                                arrayList.add(postData.n());
                            }
                        }
                        i4++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new y1(this));
                    qb5 qb5Var = (qb5) ListUtils.getItem(arrayList, 0);
                    if (qb5Var != null && qb5Var.e() == 1) {
                        if (!z3) {
                            this.G0.F2(qb5Var, 0);
                            return;
                        }
                        return;
                    }
                    this.G0.F2(qb5Var, 1);
                }
            }
        }
    }

    public final boolean r6(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048734, this, postData)) == null) {
            if (postData == null) {
                return false;
            }
            String O = postData.O();
            if (StringUtils.isNull(O) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s3 = b55.m().s("bubble_link", "");
            if (StringUtils.isNull(s3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = postData.i0().getJumpUrl();
            int packageId = postData.i0().getPackageId();
            int propsId = postData.i0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                zu4.s(getPageContext().getPageActivity(), z69.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                zu4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s3 + "?props_id=" + O, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void t7(int i4) {
        PbModel pbModel;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048740, this, i4) != null) || (pbModel = this.y0) == null || pbModel.s1() == null || (Q = this.y0.s1().Q()) == null) {
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
        if (this.y0.K1()) {
            this.G0.J0().Z();
        } else {
            this.G0.A4(this.y0.s1());
        }
    }

    public final void C6(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || view2 == null) {
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

    public final void R5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void g7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, str) == null) {
            if (str == null) {
                str = "";
            }
            x9 x9Var = this.e1;
            if (x9Var == null) {
                return;
            }
            q15 q15Var = new q15(x9Var.getPageActivity());
            q15Var.setMessage(str);
            q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a59, new f(this));
            q15Var.create(this.e1).show();
        }
    }

    public void i6(String str) {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, str) == null) && this.y0 != null && !StringUtils.isNull(str) && (lh8Var = this.G0) != null) {
            lh8Var.h3(true);
            this.y0.s2(str);
            this.I = true;
            this.G0.v0();
            this.G0.v1();
        }
    }

    public final void j7(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048689, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        k7(postData, false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i4 = configuration.orientation;
            if (i4 == this.x) {
                return;
            }
            this.x = i4;
            if (i4 == 2) {
                this.J = true;
            } else {
                this.J = false;
            }
            lh8 lh8Var = this.G0;
            if (lh8Var != null) {
                lh8Var.j2(configuration);
            }
            z15 z15Var = this.L0;
            if (z15Var != null) {
                z15Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z3) == null) {
            super.onUserChanged(z3);
            this.G0.t4(z3);
            z15 z15Var = this.L0;
            if (z15Var != null) {
                z15Var.dismiss();
            }
            if (z3 && this.P0) {
                this.G0.A3();
                this.y0.q2(true);
            }
            if (this.G0.J0() != null) {
                this.G0.J0().d0(z3);
            }
        }
    }

    public final void q7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048732, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.y0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(gj8.n(i4))));
        }
    }

    public final void r5(Rect rect) {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048733, this, rect) == null) && rect != null && (lh8Var = this.G0) != null && lh8Var.s1() != null && rect.top <= this.G0.s1().getHeight()) {
            rect.top += this.G0.s1().getHeight() - rect.top;
        }
    }

    public void D6(xd8 xd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xd8Var) == null) {
            String O = xd8Var.i().O();
            List<PostData> list = this.y0.s1().V().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.O() != null && postData.O().equals(O)) {
                    ArrayList<PostData> k3 = xd8Var.k();
                    postData.d1(xd8Var.m());
                    if (postData.d0() != null) {
                        postData.d0().clear();
                        postData.d0().addAll(k3);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.y0.b1()) {
                this.G0.N1(this.y0.s1());
            }
        }
    }

    public final void U5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null && this.y0.s1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.y0.M1(), str);
                ThreadData Q = this.y0.s1().Q();
                if (Q.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                g6(format);
                return;
            }
            this.z0.a(str);
        }
    }

    public final void Y6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048649, this, metaData) != null) || metaData == null) {
            return;
        }
        q15 q15Var = new q15(getActivity());
        q15Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b51));
        q15Var.setTitleShowCenter(true);
        q15Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b52));
        q15Var.setMessageShowCenter(true);
        q15Var.setCancelable(false);
        q15Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b53), new u1(this, metaData));
        q15Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b54), new v1(this, metaData));
        q15Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void e7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                M().A0(postWriteCallBackData.getPostId());
                int N0 = this.G0.N0();
                this.o1 = N0;
                this.y0.U2(N0, this.G0.T0());
            }
            this.G0.v0();
            this.K0.c();
            bf5 bf5Var = this.V0;
            if (bf5Var != null) {
                this.G0.c3(bf5Var.y());
            }
            this.G0.x1();
            this.G0.N3(true);
            this.y0.X1();
        }
    }

    public final void i5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048684, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.y0) != null && pbModel.s1() != null) {
            v59 A = this.y0.s1().A();
            if (A != null && str.equals(A.q1())) {
                if (A.getAdvertAppInfo() != null) {
                    A.getAdvertAppInfo().h = null;
                }
                this.y0.s1().b();
            }
            v59 L0 = this.y0.L0();
            if (L0 != null && str.equals(L0.q1())) {
                this.y0.x0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048709, this, i4) != null) || this.W == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.G0.i2(i4);
        bf5 bf5Var = this.V0;
        if (bf5Var != null && bf5Var.b() != null) {
            this.V0.b().y(i4);
        }
        if (this.G0.a() != null) {
            this.G0.a().d(getPageContext(), i4);
        }
        this.K0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.W = i4;
        l7();
        ya5 ya5Var = this.j0;
        if (ya5Var != null) {
            ya5Var.w();
        }
    }

    public void q6(PostData postData) {
        PostData u5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048731, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.O() != null && postData.O().equals(this.y0.n1())) {
            z3 = true;
        }
        MarkData m12 = this.y0.m1(postData);
        if (this.y0.s1() != null && this.y0.s1().l0() && (u5 = u5()) != null) {
            m12 = this.y0.m1(u5);
        }
        if (m12 == null) {
            return;
        }
        this.G0.z3();
        qu4 qu4Var = this.A0;
        if (qu4Var != null) {
            qu4Var.i(m12);
            if (!z3) {
                this.A0.a();
            } else {
                this.A0.d();
            }
        }
    }

    public void E6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z3, markData) == null) {
            this.G0.y3();
            this.y0.l3(z3);
            qu4 qu4Var = this.A0;
            if (qu4Var != null) {
                qu4Var.h(z3);
                if (markData != null) {
                    this.A0.i(markData);
                }
            }
            if (this.y0.d1()) {
                m6();
            } else {
                this.G0.N1(this.y0.s1());
            }
        }
    }

    public final boolean J6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (postData.getType() != PostData.T0 && !TextUtils.isEmpty(postData.t()) && hx4.c().g()) {
                return r6(postData);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null) {
                if (K5().j1() != null) {
                    K5().j1().g();
                }
                xd8 xd8Var = new xd8();
                xd8Var.A(this.y0.s1().l());
                xd8Var.E(this.y0.s1().Q());
                xd8Var.C(postData);
                K5().i1().j0(xd8Var);
                K5().i1().setPostId(postData.O());
                l6(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                bf5 bf5Var = this.V0;
                if (bf5Var != null) {
                    this.G0.c3(bf5Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.E0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.E0 = pollingModel;
                pollingModel.E0(m25.e);
            }
            this.E0.u0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            gh.a().postDelayed(this.X1, 10000L);
        }
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (this.l1 != null) {
                ag5.b bVar = new ag5.b();
                bVar.a = this.l1.Q();
                bVar.b = this.l1.O();
                bVar.c = String.valueOf(this.l1.R());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.k1));
        }
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            q15 q15Var = new q15(getPageContext().getPageActivity());
            q15Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            q15Var.setPositiveButton(R.string.open_now, new d(this));
            q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new e(this));
            q15Var.create(this.e1).show();
        }
    }

    public final boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData Q = this.y0.s1().Q();
            AntiData d4 = this.y0.s1().d();
            if (!AntiHelper.b(getPageContext(), Q) && !AntiHelper.d(getPageContext(), d4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            showLoadingView(this.G0.t1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bc));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.G0.s1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if ((this.y0.s1() != null && (this.y0.s1().l0() || ThreadCardUtils.isSelf(this.y0.s1().Q()))) || this.Y0 == null || this.y0.s1() == null || this.y0.s1().d() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.y0.s1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final boolean e6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            PostData c4 = id8.c(this.y0.s1(), this.y0.K1(), this.y0.C1());
            if (c4 != null && c4.r() != null && c4.r().getGodUserData() != null && c4.r().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            if (this.y0.X0() || this.y0.a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.y0.M1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.y0.M1()));
            if (n7()) {
                this.a.finish();
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && this.S2 != null) {
            if (this.Q2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0eb6);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.Q2, 0)));
                this.a.finish();
            }
        }
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && this.S2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0eb7);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.P2, 0)));
                this.a.finish();
            }
        }
    }

    public void o5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && this.G0 != null && (pbModel = this.y0) != null && pbModel.s1() != null && this.y0.s1().U() != null && checkUpIsLogin() && this.G0.J0() != null && this.G0.J0().z() != null) {
            this.G0.J0().z().v(this.y0.M1(), this.y0.getFromForumId());
        }
    }

    public final void o7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && (absPbActivity = this.a) != null && absPbActivity.H1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.H1().M1()).param("topic_id", this.a.H1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.H1().Q1()));
        }
    }

    public final void r7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048735, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(this.y0.getForumId()) && this.y0.s1() != null && this.y0.s1().l() != null) {
            boolean z3 = true;
            if (this.y0.s1().l().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.y0.F0().R(this.y0.getForumId(), this.y0.M1());
            }
        }
    }

    public void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.y0.s1() != null && this.y0.s1().Q() != null && this.y0.s1().Q().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.y0.s1().Q().getTaskInfoData().i(), this.y0.s1().Q().getTaskInfoData().g(), this.y0.s1().Q().getTaskInfoData().b(), this.y0.s1().Q().getTaskInfoData().c(), this.y0.s1().Q().getIs_top(), this.y0.s1().Q().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null) {
                v59 A = this.y0.s1().A();
                if (A != null) {
                    if (A.getAdvertAppInfo() != null) {
                        A.getAdvertAppInfo().h = null;
                    }
                    this.y0.s1().b();
                }
                if (this.y0.L0() != null) {
                    this.y0.x0();
                }
                this.y0.X1();
            }
            if (this.y0.s1().H() != null) {
                Iterator<PostData> it = this.y0.s1().H().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof v59) {
                        it.remove();
                    }
                }
            }
            if (this.G0.J0() != null && !ListUtils.isEmpty(this.G0.J0().t())) {
                jh8.d(this.G0.J0().t());
            }
            if (this.G0.Z0() != null && !ListUtils.isEmpty(this.G0.Z0().getData())) {
                jh8.d(this.G0.Z0().getData());
            }
            if (this.G0.J0() != null) {
                this.G0.J0().Z();
            }
        }
    }

    public final boolean n7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.s1() != null && this.y0.s1().l0()) {
                return true;
            }
            if (this.y0.d1()) {
                MarkData O0 = this.y0.O0();
                if (O0 != null && this.y0.b1()) {
                    MarkData I0 = this.y0.I0(this.G0.Q0());
                    if (I0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", O0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                        q15 q15Var = new q15(getPageContext().getPageActivity());
                        q15Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        q15Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045b, new j2(this, I0, O0, q15Var));
                        q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new k2(this, O0, q15Var));
                        q15Var.setOnCalcelListener(new l2(this, O0, q15Var));
                        q15Var.create(getPageContext());
                        q15Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", O0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.y0.s1() != null && this.y0.s1().H() != null && this.y0.s1().H().size() > 0 && this.y0.b1()) {
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
                Q5();
            }
            if (e6()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            lh8 lh8Var = this.G0;
            if (lh8Var != null && lh8Var.t1() != null) {
                if (!this.g) {
                    b7();
                } else {
                    hideLoadingView(this.G0.t1());
                }
                this.G0.s2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            lh8 lh8Var2 = this.G0;
            if (lh8Var2 != null) {
                noNetworkView = lh8Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.C1);
            this.P0 = false;
            L6();
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.b2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.n1) {
                G6();
                this.n1 = false;
            }
            i7();
            ItemCardHelper.w(this.K2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                rc5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onStop();
            if (this.u > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.u;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.u = 0L;
            }
            if (K5().j1() != null) {
                K5().j1().n();
            }
            oj8 oj8Var = this.G0.h;
            if (oj8Var != null && !oj8Var.v()) {
                this.G0.h.z();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null && this.y0.s1().l() != null && this.y0.s1().Q() != null) {
                oc5.j().x(getPageContext().getPageActivity(), "pb", this.y0.s1().l().getId(), dh.g(this.y0.s1().Q().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            y39.g().h(getUniqueId(), false);
        }
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.s1() == null || this.y0.s1().H() == null || (count = ListUtils.getCount((H = this.y0.s1().H()))) == 0) {
                return "";
            }
            if (this.y0.D1()) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        return next.O();
                    }
                }
            }
            int Q0 = this.G0.Q0();
            PostData postData = (PostData) ListUtils.getItem(H, Q0);
            if (postData != null && postData.r() != null) {
                if (this.y0.n2(postData.r().getUserId())) {
                    return postData.O();
                }
                for (int i4 = Q0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i4);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (this.y0.n2(postData2.r().getUserId())) {
                        return postData2.O();
                    }
                }
                for (int i5 = Q0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i5);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (this.y0.n2(postData3.r().getUserId())) {
                        return postData3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null && this.y0.s1().l() != null) {
                if (a5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.y0.s1().l0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.G0.m0();
                    return;
                } else {
                    bf5 bf5Var = this.V0;
                    if (bf5Var != null && bf5Var.b() != null) {
                        this.V0.b().C(new yc5(45, 27, null));
                    }
                    this.G0.m0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void Q6(df5 df5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, df5Var) == null) && df5Var != null && (pbModel = this.y0) != null) {
            df5Var.p(pbModel.R0());
            if (this.y0.s1() != null && this.y0.s1().l() != null) {
                df5Var.o(this.y0.s1().l());
            }
            df5Var.q("pb");
            df5Var.r(this.y0);
        }
    }

    public final void R6(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i4) != null) || (pbModel = this.y0) == null) {
            return;
        }
        int B1 = pbModel.B1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.y0.f3(1);
                } else {
                    this.y0.f3(4);
                }
            } else {
                this.y0.f3(3);
            }
        } else {
            this.y0.f3(2);
        }
        int B12 = this.y0.B1();
        if (B1 == 4 || B12 == 4) {
            u6();
        }
    }

    public final void Z5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            qu4 c4 = qu4.c(this.a);
            this.A0 = c4;
            if (c4 != null) {
                c4.j(this.t2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.B0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v2);
            this.C0 = new ba5(getPageContext());
            L5();
            this.Q1.setUniqueId(getUniqueId());
            this.Q1.registerListener();
        }
    }

    public void b5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.G0.V3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = dh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = dh.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.d1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean d5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048664, this, i4)) == null) {
            if (this.Y0 != null && this.y0.s1() != null && !ThreadCardUtils.isSelf(this.y0.s1().Q()) && this.y0.s1().d() != null) {
                return this.Y0.checkPrivacyBeforeSend(this.y0.s1().d().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void j6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, bundle) == null) {
            PbModel H1 = this.a.H1();
            this.y0 = H1;
            if (H1 != null) {
                if (H1.N0() != null) {
                    this.y0.N0().c(this.O2);
                }
                if (this.y0.o1() != null) {
                    this.y0.o1().f(this.v1);
                }
                if (StringUtils.isNull(this.y0.M1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.y0.c3(6);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090755));
            hd8 d4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d();
            if (d4 != null) {
                this.q2.c(true, 0, 3, 0, d4, "", 1);
            }
            this.a.J1().d(this.t0);
        }
    }

    public final void p7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048729, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.H1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.H1().M1()).param("topic_id", this.a.H1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.H1().Q1()));
        }
    }

    public void x6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048755, this, animatorListener) == null) && this.G0 != null && (pbModel = this.y0) != null && pbModel.s1() != null && this.y0.s1().U() != null && checkUpIsLogin() && this.G0.J0() != null && this.G0.J0().z() != null) {
            this.G0.J0().z().F(animatorListener);
        }
    }

    public final void S5(int i4, Intent intent) {
        kd5 kd5Var;
        kd5 kd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048626, this, i4, intent) == null) {
            if (i4 == 0) {
                this.G0.x1();
                this.G0.j1().g();
                this.G0.N3(false);
            }
            this.G0.U2();
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
                if (editorType == 1 && this.G0.j1() != null && this.G0.j1().f() != null) {
                    ff5 f4 = this.G0.j1().f();
                    f4.d0(this.y0.s1().Q());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    jd5 p3 = f4.b().p(6);
                    if (p3 != null && (kd5Var2 = p3.m) != null) {
                        kd5Var2.A(new yc5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.V0.L();
            this.V0.m0(pbEditorData.getVoiceModel());
            this.V0.B(writeData);
            jd5 p4 = this.V0.b().p(6);
            if (p4 != null && (kd5Var = p4.m) != null) {
                kd5Var.A(new yc5(52, 0, pbEditorData.getVoiceModel()));
            }
            this.V0.h0(pbEditorData.isShowCustomFigure());
            if (i4 == -1) {
                this.V0.G(null, null);
            }
        }
    }

    public final void V6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048638, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (K5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        cb5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            lc8.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            lc8.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            lc8.e(getResources().getString(R.string.obfuscated_res_0x7f0f12ed));
                            return;
                        } else {
                            lc8.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.y0.f1()) {
                antiData.setBlock_forum_name(this.y0.s1().l().getName());
                antiData.setBlock_forum_id(this.y0.s1().l().getId());
                antiData.setUser_name(this.y0.s1().X().getUserName());
                antiData.setUser_id(this.y0.s1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void a7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048655, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            z15 z15Var = this.L0;
            if (z15Var != null && z15Var.isShowing()) {
                this.L0.dismiss();
                this.L0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            b25 b25Var = new b25(getContext());
            b25Var.p(new h0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new x15(0, getResources().getString(R.string.obfuscated_res_0x7f0f04d8), b25Var));
            }
            if (z3) {
                arrayList.add(new x15(1, getResources().getString(R.string.un_mute), b25Var));
            } else {
                arrayList.add(new x15(1, getResources().getString(R.string.obfuscated_res_0x7f0f0bef), b25Var));
            }
            b25Var.k(arrayList);
            z15 z15Var2 = new z15(getPageContext(), b25Var);
            this.L0 = z15Var2;
            z15Var2.k();
        }
    }

    public void k5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(lh8.o2)).intValue();
            if (intValue == lh8.p2) {
                if (this.B0.g0()) {
                    return;
                }
                this.G0.p4();
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
                    this.B0.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.B0.j0(this.y0.s1().l().getId(), this.y0.s1().l().getName(), this.y0.s1().Q().getId(), str, intValue3, intValue2, booleanValue, this.y0.s1().Q().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == lh8.q2 || intValue == lh8.s2) {
                PbModel pbModel = this.y0;
                if (pbModel != null && pbModel.N0() != null) {
                    this.y0.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == lh8.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void k7(PostData postData, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048692, this, postData, z3) == null) {
            N6(false);
            if (postData == null || (pbModel = this.y0) == null || pbModel.s1() == null || postData.F() == 1) {
                return;
            }
            String M1 = this.y0.M1();
            String O = postData.O();
            if (this.y0.s1() != null) {
                i4 = this.y0.s1().Y();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e A6 = A6(O);
            if (A6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo g02 = postData.g0();
            AntiData d4 = this.y0.s1().d();
            if (postData.r() != null) {
                arrayList = postData.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, O, "pb", true, false, null, false, null, i4, g02, d4, false, arrayList, 5).addBigImageData(A6.a, A6.b, A6.g, A6.j);
            addBigImageData.setKeyPageStartFrom(this.y0.r1());
            addBigImageData.setFromFrsForumId(this.y0.getFromForumId());
            addBigImageData.setWorksInfoData(this.y0.R1());
            addBigImageData.setKeyFromForumId(this.y0.getForumId());
            addBigImageData.setBjhData(this.y0.K0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void n5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048700, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            lh8 lh8Var = this.G0;
            if (lh8Var != null && this.y0 != null) {
                if ((lh8Var == null || lh8Var.P1()) && this.y0.s1() != null && this.y0.s1().U() != null) {
                    lh8 lh8Var2 = this.G0;
                    if (lh8Var2 != null && lh8Var2.P0() != null && this.G0.P0().t()) {
                        return;
                    }
                    vd8 U = this.y0.s1().U();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!U.f() || U.a() != 2) && this.G0.J0() != null && this.G0.J0().z() != null) {
                        this.G0.J0().z().v(this.y0.M1(), this.y0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        jc8 jc8Var = new jc8(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.y0;
                        jc8Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        jc8Var.l(new o0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void T5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            h7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void U6(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048634, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new z1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                g7(str);
            } else {
                this.G0.o4(str);
            }
        }
    }

    @Override // com.baidu.tieba.su5
    public void c0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048659, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.N0 = str;
            if (this.l == null) {
                b6();
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

    public final void W4() {
        PbModel pbModel;
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (pbModel = this.y0) != null && (hd8Var = pbModel.G) != null && hd8Var.Q() != null) {
            ThreadData Q = this.y0.G.Q();
            Q.mRecomAbTag = this.y0.x1();
            Q.mRecomWeight = this.y0.A1();
            Q.mRecomSource = this.y0.z1();
            Q.mRecomExtra = this.y0.y1();
            Q.isSubPb = this.y0.f1();
            if (Q.getFid() == 0) {
                Q.setFid(dh.g(this.y0.getForumId(), 0L));
            }
            StatisticItem i4 = hl5.i(getContext(), Q, "c13562");
            TbPageTag l3 = hl5.l(getContext());
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

    public final void o6() {
        MarkData I0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && this.A0 != null) {
            if (this.y0.s1() != null && this.y0.s1().l0()) {
                I0 = this.y0.I0(0);
            } else {
                I0 = this.y0.I0(this.G0.Y0());
            }
            if (I0 == null) {
                return;
            }
            if (I0.isApp() && (I0 = this.y0.I0(this.G0.Y0() + 1)) == null) {
                return;
            }
            this.G0.z3();
            this.A0.i(I0);
            if (!this.A0.e()) {
                if (this.G0 != null && this.y0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !ij8.k(this.y0.b)) {
                    this.G0.i4();
                    ij8.b(this.y0.b);
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
            hj8.a();
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
            lh8 lh8Var = this.G0;
            if (lh8Var != null) {
                lh8Var.p2();
            }
            if (!this.y0.f1()) {
                this.V0.N(this.y0.M1());
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.y2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            sr4.w().E();
            MessageManager.getInstance().unRegisterListener(this.C1);
            K6();
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            ya5 ya5Var = this.j0;
            if (ya5Var != null) {
                ya5Var.q();
                this.j0.p();
            }
        }
    }

    public final void W6(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            gj8.e(getActivity(), getPageContext(), new f1(this, sparseArray, i4, z3), new g1(this));
        }
    }

    public final void Y4(hd8 hd8Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048647, this, hd8Var, arrayList) == null) && hd8Var != null && hd8Var.V() != null && hd8Var.V().a != null && (list = hd8Var.V().a) != null && arrayList != null) {
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
                            if (postData != null && !TextUtils.isEmpty(next.O()) && !TextUtils.isEmpty(postData.O()) && next.O().equals(postData.O())) {
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

    public final void q5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048730, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.G0.F0(this.B0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.H0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.I0 = false;
                    this.J0 = true;
                }
            } else {
                this.I0 = true;
                this.J0 = false;
            }
            if (i4 == 2) {
                this.y0.s1().Q().setIs_good(1);
                this.y0.Y2(1);
            } else if (i4 == 3) {
                this.y0.s1().Q().setIs_good(0);
                this.y0.Y2(0);
            } else if (i4 == 4) {
                this.y0.s1().Q().setIs_top(1);
                this.y0.Z2(1);
            } else if (i4 == 5) {
                this.y0.s1().Q().setIs_top(0);
                this.y0.Z2(0);
            }
            this.G0.x4(this.y0.s1(), this.y0.K1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        ej.Q(getPageContext().getPageActivity(), string);
    }

    public final void b6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048657, this) != null) || this.l != null) {
            return;
        }
        this.l = new s15(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        s15 s15Var = this.l;
        s15Var.j(strArr, new r0(this));
        s15Var.g(s15.b.a);
        s15Var.h(17);
        s15Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e5(AgreeData agreeData) {
        cl5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new x45();
        }
        if (this.i0 == null) {
            m59 m59Var = new m59();
            this.i0 = m59Var;
            m59Var.a = getUniqueId();
        }
        fy4 fy4Var = new fy4();
        fy4Var.b = 5;
        fy4Var.h = 8;
        fy4Var.g = 2;
        if (M() != null) {
            fy4Var.f = M().r1();
        }
        fy4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fy4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i4, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.y0;
                if (pbModel == null && pbModel.s1() != null) {
                    this.e0.b(N(), fy4Var, agreeData, this.y0.s1().Q());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fy4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fy4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.e0.c(agreeData, i4, getUniqueId(), false);
        this.e0.d(agreeData, this.i0);
        pbModel = this.y0;
        if (pbModel == null) {
        }
    }

    @Override // com.baidu.tieba.tk8
    public void finish() {
        lh8 lh8Var;
        boolean z3;
        CardHListViewData q3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            lh8 lh8Var2 = this.G0;
            if (lh8Var2 != null) {
                lh8Var2.v0();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.s1() != null && !this.y0.s1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.y0.s1().Q().getId();
                if (this.y0.isShareThread() && this.y0.s1().Q().originalThreadData != null) {
                    historyMessage.threadName = this.y0.s1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.y0.s1().Q().getTitle();
                }
                if (this.y0.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.y0.s1().l().getName();
                }
                ArrayList<PostData> H = this.y0.s1().H();
                lh8 lh8Var3 = this.G0;
                if (lh8Var3 != null) {
                    i4 = lh8Var3.Q0();
                } else {
                    i4 = 0;
                }
                if (H != null && i4 >= 0 && i4 < H.size()) {
                    historyMessage.postID = H.get(i4).O();
                }
                historyMessage.isHostOnly = this.y0.V0();
                historyMessage.isSquence = this.y0.K1();
                historyMessage.isShareThread = this.y0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            bf5 bf5Var = this.V0;
            if (bf5Var != null) {
                bf5Var.D();
            }
            if (this.i && K5() != null) {
                K5().A0();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && (pbModel2.X0() || this.y0.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.y0.M1());
                if (this.H0) {
                    if (this.J0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.y0.g1());
                    }
                    if (this.I0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.y0.c1());
                    }
                }
                if (this.y0.s1() != null && System.currentTimeMillis() - this.o >= 40000 && (q3 = this.y0.s1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.p1);
                }
                this.a.setResult(-1, intent);
            }
            if (n7()) {
                if (this.y0 != null && (lh8Var = this.G0) != null && lh8Var.Z0() != null) {
                    hd8 s12 = this.y0.s1();
                    if (s12 != null) {
                        if (s12.X() != null) {
                            s12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!s12.t0() && !this.I && s12.h == null) {
                            ah8 b4 = ah8.b();
                            hd8 t12 = this.y0.t1();
                            Parcelable onSaveInstanceState = this.G0.Z0().onSaveInstanceState();
                            boolean K1 = this.y0.K1();
                            boolean V0 = this.y0.V0();
                            if (this.G0.h1() != null && this.G0.h1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.n(t12, onSaveInstanceState, K1, V0, z3);
                            if (this.o1 >= 0 || this.y0.O1() != null) {
                                ah8.b().q(this.y0.O1());
                                ah8.b().r(this.y0.P1());
                                ah8.b().o(this.y0.l1());
                            }
                        }
                    }
                } else {
                    ah8.b().m();
                }
                m7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            y39.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.y0.s1().m());
                statisticItem.param("tid", this.y0.M1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.G0 != null) {
                this.s = true;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.y0.destory();
                if (this.y0.o1() != null) {
                    this.y0.o1().d();
                }
            }
            bf5 bf5Var = this.V0;
            if (bf5Var != null) {
                bf5Var.D();
            }
            ForumManageModel forumManageModel = this.B0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.b0();
            }
            lh8 lh8Var = this.G0;
            if (lh8Var != null) {
                lh8Var.k2();
                oj8 oj8Var2 = this.G0.h;
                if (oj8Var2 != null) {
                    oj8Var2.z();
                }
            }
            zl5 zl5Var = this.t;
            if (zl5Var != null) {
                zl5Var.c();
            }
            ri8 ri8Var = this.e;
            if (ri8Var != null) {
                ri8Var.k();
            }
            ug<TextView> ugVar = this.z;
            if (ugVar != null) {
                ugVar.c();
            }
            ug<FestivalTipView> ugVar2 = this.H;
            if (ugVar2 != null) {
                ugVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            lh8 lh8Var2 = this.G0;
            if (lh8Var2 != null) {
                lh8Var2.v0();
            }
            if (this.X1 != null) {
                gh.a().removeCallbacks(this.X1);
            }
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.f2);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.p2);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.e2);
            this.e1 = null;
            this.f1 = null;
            lx8.e().g();
            if (this.h1 != null) {
                gh.a().removeCallbacks(this.h1);
            }
            lh8 lh8Var3 = this.G0;
            if (lh8Var3 != null && (oj8Var = lh8Var3.h) != null) {
                oj8Var.r();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            oh8 oh8Var = this.K0;
            if (oh8Var != null) {
                oh8Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && pbModel2.F0() != null) {
                this.y0.F0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            lh8 lh8Var4 = this.G0;
            if (lh8Var4 != null) {
                lh8Var4.q4();
            }
            ej8 ej8Var = this.u0;
            if (ej8Var != null) {
                ej8Var.e();
            }
        }
    }

    public void v6() {
        PbModel pbModel;
        hd8 s12;
        ThreadData Q;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        hd8 hd8Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048751, this) == null) && (pbModel = this.y0) != null && pbModel.s1() != null && (Q = (s12 = this.y0.s1()).Q()) != null && Q.getAuthor() != null) {
            this.G0.x1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q.getAuthor().getUserId());
            tg8 tg8Var = new tg8();
            int Y = this.y0.s1().Y();
            if (Y != 1 && Y != 3) {
                tg8Var.g = false;
            } else {
                tg8Var.g = true;
                if (Q.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                tg8Var.s = z3;
            }
            if (jh8.z(this.y0.s1(), Y)) {
                tg8Var.h = true;
                if (Q.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                tg8Var.r = z8;
            } else {
                tg8Var.h = false;
            }
            if (Y == 1002 && !equals) {
                tg8Var.u = true;
            }
            tg8Var.n = jh8.J(Q.isBlocked(), s12.o0(), equals, Y, Q.isWorksInfo(), Q.isScoreThread());
            tg8Var.e = jh8.H(s12, equals, s12.o0(), this.y0.V());
            tg8Var.i = X6();
            tg8Var.f = jh8.I(this.y0.s1(), equals, this.y0.V());
            if (equals && s12.X() != null && s12.X().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            tg8Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                tg8Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            tg8Var.t = equals;
            tg8Var.q = this.y0.K1();
            tg8Var.b = true;
            tg8Var.a = jh8.C(this.y0.s1(), equals);
            if (equals) {
                this.G0.O1();
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            tg8Var.p = z5;
            tg8Var.j = true;
            tg8Var.o = this.y0.V0();
            tg8Var.d = true;
            if (Q.getThreadVideoInfo() == null) {
                tg8Var.c = true;
            } else {
                tg8Var.c = false;
            }
            if (s12.l0()) {
                tg8Var.b = false;
                tg8Var.d = false;
                tg8Var.c = false;
                tg8Var.g = false;
                tg8Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !s12.l0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            tg8Var.v = z6;
            if (this.G0 != null && (hd8Var = this.y0.G) != null) {
                PostData Z = hd8Var.Z();
                if (Z != null) {
                    z7 = Z.S;
                } else {
                    z7 = false;
                }
                tg8Var.w = z7;
            }
            tg8Var.m = true;
            if (Q.isBlocked()) {
                tg8Var.n = false;
                tg8Var.g = false;
                tg8Var.h = false;
            }
            this.G0.h.G(tg8Var);
        }
    }

    public final boolean g5(View view2) {
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
        List<x15> c4;
        int i4;
        boolean z20;
        x15 x15Var;
        x15 x15Var2;
        x15 x15Var3;
        x15 x15Var4;
        x15 x15Var5;
        x15 x15Var6;
        on onVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            lh8 lh8Var = this.G0;
            if (lh8Var != null) {
                if (lh8Var.R1()) {
                    return true;
                }
                this.G0.G0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (jh8.y(view2)) {
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
                        this.G0.a4(this.G2, this.j1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.E2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.F() == 1 && jh8.y(view2)) {
                this.G0.a4(this.G2, this.j1.t());
                return true;
            }
            qu4 qu4Var = this.A0;
            if (qu4Var == null) {
                return true;
            }
            if (qu4Var.e() && this.E2.O() != null && this.E2.O().equals(this.y0.n1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (M().s1() != null && M().s1().l0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (M().s1() != null && M().s1().q0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (M().s1() != null && M().s1().p0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.E2.F() == 1) {
                if (!z4) {
                    this.G0.b4(this.F2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.M0 == null) {
                b25 b25Var = new b25(getContext());
                this.M0 = b25Var;
                b25Var.p(this.i2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (jh8.y(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (jh8.y(view2) && (onVar = this.j1) != null && !onVar.t()) {
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
                    arrayList.add(new x15(1, getString(R.string.save_to_emotion), this.M0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new x15(2, getString(R.string.save_to_local), this.M0));
                }
                if (!z7 && !z8) {
                    x15 x15Var7 = new x15(3, getString(R.string.obfuscated_res_0x7f0f0478), this.M0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.E2);
                    x15Var7.d.setTag(sparseArray3);
                    arrayList.add(x15Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        x15Var6 = new x15(4, getString(R.string.remove_mark), this.M0);
                    } else {
                        x15Var6 = new x15(4, getString(R.string.obfuscated_res_0x7f0f0b4f), this.M0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.E2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    x15Var6.d.setTag(sparseArray4);
                    arrayList.add(x15Var6);
                }
                if (this.mIsLogin) {
                    if (!gj8.j(this.y0) && !z12 && z11) {
                        x15 x15Var8 = new x15(5, getString(R.string.obfuscated_res_0x7f0f0bf3), this.M0);
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
                        x15Var8.d.setTag(sparseArray5);
                        arrayList.add(x15Var8);
                    } else {
                        if (jh8.C(this.y0.s1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            x15 x15Var9 = new x15(5, getString(R.string.report_text), this.M0);
                            x15Var9.d.setTag(str);
                            arrayList.add(x15Var9);
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
                        if (!gj8.j(this.y0) && z18) {
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
                                x15Var5 = new x15(6, getString(R.string.obfuscated_res_0x7f0f04d8), this.M0);
                                x15Var5.d.setTag(sparseArray6);
                                x15Var2 = new x15(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.M0);
                                x15Var2.d.setTag(sparseArray6);
                                x15Var3 = x15Var5;
                                x15Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        x15Var5 = null;
                        x15Var2 = new x15(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.M0);
                        x15Var2.d.setTag(sparseArray6);
                        x15Var3 = x15Var5;
                        x15Var = null;
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
                        if (this.y0.s1().Y() == 1002 && !z10) {
                            x15Var4 = new x15(6, getString(R.string.report_text), this.M0);
                        } else {
                            x15Var4 = new x15(6, getString(R.string.obfuscated_res_0x7f0f04d8), this.M0);
                        }
                        x15Var4.d.setTag(sparseArray7);
                        if (z17) {
                            x15Var = new x15(13, getString(R.string.multi_delete), this.M0);
                            x15Var3 = x15Var4;
                        } else {
                            x15Var3 = x15Var4;
                            x15Var = null;
                        }
                        x15Var2 = null;
                    } else {
                        x15Var = null;
                        x15Var2 = null;
                        x15Var3 = null;
                    }
                    if (x15Var3 != null) {
                        arrayList.add(x15Var3);
                    }
                    if (x15Var != null) {
                        arrayList.add(x15Var);
                    }
                    if (x15Var2 != null) {
                        arrayList.add(x15Var2);
                    }
                    gj8.b(arrayList, this.M0, this.E2, this.y0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = gj8.d(arrayList, this.E2.o(), sparseArray, this.M0);
                } else {
                    c4 = gj8.c(arrayList, this.E2.o(), sparseArray, this.M0);
                }
                gj8.m(c4, this.b);
                gj8.f(c4);
                this.M0.q(gj8.h(this.E2));
                this.M0.l(c4, !UbsABTestHelper.isPBPlanA());
                this.L0 = new z15(getPageContext(), this.M0);
                this.M0.o(new x2(this));
                this.L0.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.y0.b).param("fid", this.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.y0.P());
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

    public void h5(ForumManageModel.b bVar, lh8 lh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048681, this, bVar, lh8Var) == null) {
            List<PostData> list = this.y0.s1().V().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).d0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).d0().get(i5).O())) {
                        list.get(i4).d0().remove(i5);
                        list.get(i4).j();
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                list.get(i4).l(bVar.g);
            }
            if (z3) {
                lh8Var.N1(this.y0.s1());
            }
        }
    }

    public final void h7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.G0.V3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            q15 q15Var = new q15(this.e1.getPageActivity());
            if (!dj.isEmpty(str)) {
                q15Var.setMessage(str);
            } else {
                q15Var.setMessage(this.e1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            q15Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045b, new g(this, userMuteAddAndDelCustomMessage));
            q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new h(this));
            q15Var.create(this.e1).show();
        }
    }

    public void l5(q15 q15Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, q15Var, jSONArray) == null) {
            q15Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(q15Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                k5((SparseArray) q15Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText u7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048746, this, str, i4)) == null) {
            PbModel pbModel = this.y0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.s1() == null || str == null || i4 < 0) {
                return null;
            }
            hd8 s12 = this.y0.s1();
            if (s12.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(s12.j());
                tbRichText = y5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> H = s12.H();
                Y4(s12, H);
                return y5(H, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final void l6(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048695, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (a5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!c5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Y);
                        this.Z = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (K5().j1() != null && postData != null) {
                        if (postData.Z() != null) {
                            str3 = postData.Z().toString();
                        } else {
                            str3 = "";
                        }
                        K5().j1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.r().getName_show(), str3));
                    }
                    if (this.y0.s1() != null && this.y0.s1().l0()) {
                        gh.a().postDelayed(new i1(this, str, str2), 0L);
                        return;
                    } else {
                        gh.a().postDelayed(new j1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void m5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(lh8.o2, Integer.valueOf(lh8.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                k5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.V0.C(i4, i5, intent);
            if (K5().j1() != null) {
                K5().j1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                S5(i5, intent);
            }
            if (i5 == -1) {
                if (i4 != 11009) {
                    if (i4 != 13008) {
                        if (i4 != 13011) {
                            if (i4 != 23007) {
                                if (i4 != 25012) {
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
                                                        View view3 = this.T;
                                                        if (view3 != null) {
                                                            view3.performClick();
                                                            return;
                                                        }
                                                        return;
                                                    case 25057:
                                                        lh8 lh8Var = this.G0;
                                                        if (lh8Var != null && lh8Var.K0() != null) {
                                                            this.G0.K0().performClick();
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
                                            this.G0.B3(false);
                                            if (this.y0.s1() != null && this.y0.s1().Q() != null && this.y0.s1().Q().getPushStatusData() != null) {
                                                this.y0.s1().Q().getPushStatusData().setStatus(2);
                                                return;
                                            }
                                            return;
                                        }
                                        int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                        if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                            fv8.g().m(getPageContext());
                                            r7();
                                            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
                                            if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                                shareSuccessReplyToServerModel.N(str, intExtra, new h2(this));
                                            }
                                            if (d6()) {
                                                p7(true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    View view5 = this.R;
                                    if (view5 != null) {
                                        this.G0.S3(view5);
                                        return;
                                    }
                                    return;
                                }
                                intent.getLongExtra("KEY_FORUM_ID", 0L);
                                intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                                return;
                            }
                            V5(intent);
                            return;
                        }
                        fv8.g().m(getPageContext());
                        return;
                    }
                    ah8.b().m();
                    this.x0.postDelayed(new g2(this), 1000L);
                    return;
                }
                o6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048713, this, layoutInflater, viewGroup, bundle)) == null) {
            this.G0 = new lh8(this, this.k2, this.W1);
            pl6 pl6Var = new pl6(getActivity());
            this.d = pl6Var;
            pl6Var.i(U2);
            this.d.d(this.N2);
            this.G0.s3(this.u2);
            this.G0.r3(this.A2);
            this.G0.k3(this.x2);
            this.G0.l3(this.y2);
            this.G0.i3(hx4.c().g());
            this.G0.p3(this.C2);
            this.G0.v3(this.I2);
            this.G0.t3(this.J2);
            this.G0.q3(this.L2);
            this.G0.o3(this.w2);
            this.G0.t4(this.mIsLogin);
            this.G0.f3(this.y0.b2());
            if (this.a.getIntent() != null) {
                this.G0.g3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.G0.i1().setFromForumId(this.y0.getFromForumId());
            this.G0.X2(this.V0.b());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.V0.c0(this.G0.l1());
            }
            this.G0.b3(this.h2);
            this.G0.e3(this.y0.a1());
            this.G0.u3(this.y0.r1());
            this.u0.f(this.G0, this.y0);
            if ("1".equals(M().showReplyPanel)) {
                this.G0.r2();
            }
            return this.G0.t1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        lh8 lh8Var;
        lh8 lh8Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.e1 = getPageContext();
            Intent intent = this.a.getIntent();
            if (intent != null) {
                this.m = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.M = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.M)) {
                        this.M = data.getQueryParameter("from");
                    }
                }
                this.V = intent.getStringExtra("st_type");
                this.P2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.Q2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.R2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.Q0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.R0 = intent.getStringExtra("high_light_post_id");
                this.S0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (B5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (dj.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.p1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                l05 l05Var = new l05();
                this.c0 = l05Var;
                l05Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.r1 = intExtra;
                if (intExtra == 0) {
                    this.r1 = intent.getIntExtra("key_start_from", 0);
                }
                this.s1 = intent.getStringExtra("last_tid");
            } else {
                this.m = System.currentTimeMillis();
            }
            this.q = this.o - this.m;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.k = 0;
            j6(bundle);
            if (this.y0.s1() != null) {
                this.y0.s1().U0(this.P);
            }
            a6();
            if (intent != null && (lh8Var2 = this.G0) != null) {
                lh8Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new l0(this, intent);
                    }
                    gh.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.y0.s1() != null) {
                    this.y0.d3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            Z5(bundle);
            df5 df5Var = new df5();
            this.U0 = df5Var;
            Q6(df5Var);
            bf5 bf5Var = (bf5) this.U0.a(getActivity());
            this.V0 = bf5Var;
            bf5Var.W(this.a.getPageContext());
            this.V0.f0(this.m2);
            this.V0.g0(this.Z0);
            this.V0.Y(1);
            this.V0.A(this.a.getPageContext(), bundle);
            this.V0.b().b(new id5(getActivity()));
            this.V0.b().E(true);
            T6(true);
            this.V0.J(this.y0.U0(), this.y0.M1(), this.y0.Q0());
            registerListener(this.z1);
            if (!this.y0.f1()) {
                this.V0.q(this.y0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.y0.d2()) {
                this.V0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                lh8 lh8Var3 = this.G0;
                if (lh8Var3 != null) {
                    this.V0.c0(lh8Var3.l1());
                }
            }
            registerListener(this.y1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.x1);
            registerListener(this.c2);
            registerListener(this.d2);
            registerListener(this.s2);
            registerListener(this.w1);
            n59 n59Var = new n59("pb", n59.d);
            this.T0 = n59Var;
            n59Var.d();
            registerListener(this.H1);
            registerListener(this.S1);
            this.y0.z2();
            registerListener(this.r2);
            registerListener(this.f2);
            registerListener(this.l2);
            registerListener(this.N1);
            registerListener(this.e2);
            registerListener(this.I1);
            lh8 lh8Var4 = this.G0;
            if (lh8Var4 != null && lh8Var4.s1() != null && this.G0.q1() != null) {
                ri8 ri8Var = new ri8(getActivity(), this.G0.s1(), this.G0.q1(), this.G0.h1());
                this.e = ri8Var;
                ri8Var.t(this.R1);
            }
            if (this.c && (lh8Var = this.G0) != null && lh8Var.q1() != null) {
                this.G0.q1().setVisibility(8);
            }
            g55 g55Var = new g55();
            this.f1 = g55Var;
            g55Var.a = 1000L;
            registerListener(this.b2);
            registerListener(this.a2);
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.K1);
            registerListener(this.L1);
            registerListener(this.D1);
            registerListener(this.E1);
            registerListener(this.F1);
            this.J1.setSelfListener(true);
            this.J1.setTag(this.a.getUniqueId());
            this.J1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.J1);
            registerResponsedEventListener(TipEvent.class, this.T1);
            registerResponsedEventListener(TopToastEvent.class, this.U1);
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
            this.V1 = new g3(this.G0, this);
            this.y0.M0().R(this.V1);
            this.K0 = new oh8();
            if (this.V0.s() != null) {
                this.K0.m(this.V0.s().i());
            }
            this.V0.V(this.a1);
            this.F0 = new ShareSuccessReplyToServerModel();
            U4(this.u1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new m0(this));
            pj8 pj8Var = new pj8(getContext());
            this.z0 = pj8Var;
            pj8Var.b(getUniqueId());
            y39.g().i(getUniqueId());
            ux4.b().l("3", "");
            this.t1 = new we6(getPageContext());
            this.u0 = new ej8(this, getUniqueId(), this.G0, this.y0);
            this.v0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
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
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                q15 q15Var = new q15(getPageContext().getPageActivity());
                q15Var.setMessage(string);
                q15Var.setPositiveButton(R.string.dialog_known, new b2(this));
                q15Var.setCancelable(true);
                q15Var.create(getPageContext());
                q15Var.show();
            } else if (bVar.d != 0) {
                this.G0.F0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> H = this.y0.s1().H();
                    int size = H.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(H.get(i4).O())) {
                            H.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.y0.s1().Q().setReply_num(this.y0.s1().Q().getReply_num() - 1);
                    this.G0.N1(this.y0.s1());
                } else if (i5 == 0) {
                    f5();
                } else if (i5 == 2) {
                    ArrayList<PostData> H2 = this.y0.s1().H();
                    int size2 = H2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= H2.get(i6).d0().size()) {
                                break;
                            } else if (bVar.g.equals(H2.get(i6).d0().get(i7).O())) {
                                H2.get(i6).d0().remove(i7);
                                H2.get(i6).j();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        H2.get(i6).l(bVar.g);
                    }
                    if (z4) {
                        this.G0.N1(this.y0.s1());
                    }
                    h5(bVar, this.G0);
                }
            }
        }
    }

    public final TbRichText y5(ArrayList<PostData> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048757, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText Z = arrayList.get(i5).Z();
                    if (Z != null && (P = Z.P()) != null) {
                        int size = P.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (P.get(i7) != null && P.get(i7).getType() == 8) {
                                i6++;
                                if (!P.get(i7).V().O().equals(str) && !P.get(i7).V().P().equals(str)) {
                                    if (i6 > i4) {
                                        break;
                                    }
                                } else {
                                    int i8 = (int) ej.i(TbadkCoreApplication.getInst());
                                    int width = P.get(i7).V().getWidth() * i8;
                                    int height = P.get(i7).V().getHeight() * i8;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.B2 = i7;
                                    return Z;
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

    public final void y6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048758, this, str, i4, eVar) != null) || eVar == null) {
            return;
        }
        hd8 s12 = this.y0.s1();
        TbRichText u7 = u7(str, i4);
        if (u7 == null || (tbRichTextData = u7.P().get(this.B2)) == null) {
            return;
        }
        eVar.f = String.valueOf(u7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.V().U()) {
            eVar.h = false;
            String a4 = id8.a(tbRichTextData);
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
            imageUrlData.originalUrl = jh8.o(tbRichTextData);
            imageUrlData.originalUrl = jh8.o(tbRichTextData);
            imageUrlData.originalSize = jh8.p(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = jh8.l(tbRichTextData);
            imageUrlData.isLongPic = jh8.k(tbRichTextData);
            imageUrlData.postId = u7.getPostId();
            imageUrlData.mIsReserver = this.y0.D1();
            imageUrlData.mIsSeeHost = this.y0.V0();
            eVar.b.put(a4, imageUrlData);
            if (s12 != null) {
                if (s12.l() != null) {
                    eVar.c = s12.l().getName();
                    eVar.d = s12.l().getId();
                }
                if (s12.Q() != null) {
                    eVar.e = s12.Q().getId();
                }
                if (s12.s() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = dh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = s12.H().size();
        this.D2 = false;
        eVar.j = -1;
        if (s12.j() != null) {
            i5 = z5(s12.j().Z(), u7, i4, i4, eVar.a, eVar.b);
        } else {
            i5 = i4;
        }
        int i7 = i5;
        for (int i8 = 0; i8 < size; i8++) {
            PostData postData = s12.H().get(i8);
            if (postData.O() == null || s12.j() == null || s12.j().O() == null || !postData.O().equals(s12.j().O())) {
                i7 = z5(postData.Z(), u7, i7, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (s12 != null) {
            if (s12.l() != null) {
                eVar.c = s12.l().getName();
                eVar.d = s12.l().getId();
            }
            if (s12.Q() != null) {
                eVar.e = s12.Q().getId();
            }
            if (s12.s() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i7;
    }

    public final int z5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo V;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048759, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.D2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.P().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.P().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int i10 = (int) ej.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.V().getWidth() * i10;
                        int height = tbRichTextData.V().getHeight() * i10;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.V().U()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = id8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (V = tbRichTextData.V()) != null) {
                                        String O = V.O();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            O = V.P();
                                        } else {
                                            if (this.r) {
                                                i6 = 17;
                                            } else {
                                                i6 = 18;
                                            }
                                            imageUrlData.urlType = i6;
                                        }
                                        imageUrlData.imageUrl = O;
                                        imageUrlData.originalUrl = jh8.o(tbRichTextData);
                                        imageUrlData.originalSize = jh8.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = jh8.l(tbRichTextData);
                                        imageUrlData.isLongPic = jh8.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = dh.g(this.y0.M1(), -1L);
                                        imageUrlData.mIsReserver = this.y0.D1();
                                        imageUrlData.mIsSeeHost = this.y0.V0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.D2) {
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
