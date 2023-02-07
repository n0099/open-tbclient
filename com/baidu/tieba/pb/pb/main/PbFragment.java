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
import com.baidu.tieba.a85;
import com.baidu.tieba.au4;
import com.baidu.tieba.aw4;
import com.baidu.tieba.b98;
import com.baidu.tieba.bb5;
import com.baidu.tieba.bd8;
import com.baidu.tieba.br4;
import com.baidu.tieba.bt5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cr4;
import com.baidu.tieba.cy4;
import com.baidu.tieba.dc8;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.e15;
import com.baidu.tieba.ea5;
import com.baidu.tieba.eb5;
import com.baidu.tieba.ej;
import com.baidu.tieba.ez4;
import com.baidu.tieba.f19;
import com.baidu.tieba.f95;
import com.baidu.tieba.g45;
import com.baidu.tieba.gf8;
import com.baidu.tieba.gh;
import com.baidu.tieba.h45;
import com.baidu.tieba.ho;
import com.baidu.tieba.hu5;
import com.baidu.tieba.ia8;
import com.baidu.tieba.id8;
import com.baidu.tieba.iz8;
import com.baidu.tieba.j05;
import com.baidu.tieba.j29;
import com.baidu.tieba.j77;
import com.baidu.tieba.ja8;
import com.baidu.tieba.jc8;
import com.baidu.tieba.jf8;
import com.baidu.tieba.jo5;
import com.baidu.tieba.k55;
import com.baidu.tieba.k89;
import com.baidu.tieba.kc6;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kf8;
import com.baidu.tieba.kp5;
import com.baidu.tieba.l05;
import com.baidu.tieba.l19;
import com.baidu.tieba.l35;
import com.baidu.tieba.l95;
import com.baidu.tieba.la8;
import com.baidu.tieba.lb5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.lf8;
import com.baidu.tieba.lg8;
import com.baidu.tieba.lk5;
import com.baidu.tieba.m95;
import com.baidu.tieba.mh5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n89;
import com.baidu.tieba.n95;
import com.baidu.tieba.nc8;
import com.baidu.tieba.nd5;
import com.baidu.tieba.ne5;
import com.baidu.tieba.ne8;
import com.baidu.tieba.nk5;
import com.baidu.tieba.nq5;
import com.baidu.tieba.nw4;
import com.baidu.tieba.nx4;
import com.baidu.tieba.od5;
import com.baidu.tieba.on;
import com.baidu.tieba.oo5;
import com.baidu.tieba.op5;
import com.baidu.tieba.p35;
import com.baidu.tieba.p85;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pg8;
import com.baidu.tieba.pj5;
import com.baidu.tieba.pq8;
import com.baidu.tieba.q05;
import com.baidu.tieba.q95;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qd8;
import com.baidu.tieba.qe8;
import com.baidu.tieba.qf8;
import com.baidu.tieba.qv8;
import com.baidu.tieba.qz5;
import com.baidu.tieba.rd8;
import com.baidu.tieba.rf8;
import com.baidu.tieba.rk5;
import com.baidu.tieba.s05;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sd5;
import com.baidu.tieba.se8;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.t05;
import com.baidu.tieba.ta8;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.te8;
import com.baidu.tieba.ty4;
import com.baidu.tieba.u05;
import com.baidu.tieba.u35;
import com.baidu.tieba.u98;
import com.baidu.tieba.ua8;
import com.baidu.tieba.ud8;
import com.baidu.tieba.ug;
import com.baidu.tieba.uj5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v98;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vs8;
import com.baidu.tieba.vy4;
import com.baidu.tieba.w09;
import com.baidu.tieba.w9;
import com.baidu.tieba.wa5;
import com.baidu.tieba.wb;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wd8;
import com.baidu.tieba.x09;
import com.baidu.tieba.x88;
import com.baidu.tieba.x9;
import com.baidu.tieba.xa8;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xd8;
import com.baidu.tieba.y17;
import com.baidu.tieba.y35;
import com.baidu.tieba.yi6;
import com.baidu.tieba.ys5;
import com.baidu.tieba.yw4;
import com.baidu.tieba.z88;
import com.baidu.tieba.zb8;
import com.baidu.tieba.zc8;
import com.baidu.tieba.zg8;
import com.baidu.tieba.zi6;
import com.baidu.tieba.zz4;
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
public class PbFragment extends BaseFragment implements bt5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, j05.e, TbRichTextView.u, TbPageContextSupport, pg8, zg8.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k Q2;
    public static final zi6.b R2;
    public transient /* synthetic */ FieldHolder $fh;
    public ug<ImageView> A;
    public ForumManageModel A0;
    public CustomMessageListener A1;
    public boolean A2;
    public ug<View> B;
    public p85 B0;
    public CustomMessageListener B1;
    public PostData B2;
    public ug<TiebaPlusRecommendCard> C;
    public la8 C0;
    public final CustomMessageListener C1;
    public final l05.c C2;
    public ug<LinearLayout> D;
    public PollingModel D0;
    public CustomMessageListener D1;
    public final l05.c D2;
    public ug<RelativeLayout> E;
    public ShareSuccessReplyToServerModel E0;
    public CustomMessageListener E1;
    public final AdapterView.OnItemClickListener E2;
    public ug<ItemCardView> F;
    public rd8 F0;
    public View.OnClickListener F1;
    public final View.OnLongClickListener F2;
    public ug<FestivalTipView> G;
    public boolean G0;
    public CustomMessageListener G1;
    public final View.OnClickListener G2;
    public boolean H;
    public boolean H0;
    public CustomMessageListener H1;
    public final ItemCardHelper.c H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public final NoNetworkView.b I2;
    public boolean J;
    public ud8 J0;
    public CustomMessageListener J1;
    public View.OnTouchListener J2;
    public ug<GifView> K;
    public s05 K0;
    public CustomMessageListener K1;
    public yi6.b K2;
    public String L;
    public u05 L0;
    public SuggestEmotionModel.c L1;
    public final jc8.b L2;
    public boolean M;
    public String M0;
    public CustomMessageListener M1;
    public int M2;
    public boolean N;
    public boolean N0;
    public GetSugMatchWordsModel.b N1;
    public int N2;
    public String O;
    public boolean O0;
    public PraiseModel O1;
    public String O2;
    public LikeModel P;
    public boolean P0;
    public te8.h P1;
    public nx4 P2;
    public View Q;
    public String Q0;
    public CustomMessageListener Q1;
    public View R;
    public boolean R0;
    public mh5 R1;
    public View S;
    public x09 S0;
    public mh5 S1;
    public View T;
    public qd5 T0;
    public CheckRealNameModel.b T1;
    public String U;
    public od5 U0;
    public ua8 U1;
    public int V;
    public PermissionJudgePolicy V0;
    public final Runnable V1;
    public boolean W;
    public ReplyPrivacyCheckController W0;
    public CustomMessageListener W1;
    public int[] X;
    public y17 X0;
    public CustomMessageListener X1;
    public int Y;
    public y17 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public ld5 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public kd5 a1;
    public CustomMessageListener a2;
    public boolean b;
    public ez4 b0;
    public kd5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public int c1;
    public CustomMessageListener c2;
    public zi6 d;
    public l35 d0;
    public Object d1;
    public CustomMessageListener d2;
    public te8 e;
    public boolean e0;
    public x9 e1;
    public j05.e e2;
    public boolean f;
    public boolean f0;
    public u35 f1;
    public h3 f2;
    public boolean g;
    public Object g0;
    public BdUniqueId g1;
    public u05.f g2;
    public boolean h;
    public w09 h0;
    public Runnable h1;
    public SortSwitchButton.f h2;
    public VoiceManager i;
    public m95 i0;
    public wd8 i1;
    public final View.OnClickListener i2;
    public int j;
    public boolean j0;
    public on j1;
    public CustomMessageListener j2;
    public l05 k;
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
    public wb n2;
    public long o;
    public int o1;
    public final PbModel.h o2;
    public long p;
    public int p1;
    public CustomMessageListener p2;
    public boolean q;
    public List<f3> q1;
    public HttpMessageListener q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public final au4.a r2;
    public lk5 s;
    @NonNull
    public TiePlusEventController.f s0;
    public kc6 s1;
    public final AbsListView.OnScrollListener s2;
    public long t;
    public gf8 t0;
    public final f3 t1;
    public final w9 t2;
    public boolean u;
    public PushPermissionController u0;
    public final zc8.b u1;
    public final y35.g u2;
    public long v;
    public PbInterviewStatusView.f v0;
    public final CustomMessageListener v1;
    public final View.OnClickListener v2;
    public int w;
    public final Handler w0;
    public CustomMessageListener w1;
    public boolean w2;
    public String x;
    public PbModel x0;
    public CustomMessageListener x1;
    public final BdListView.p x2;
    public ug<TextView> y;
    public rf8 y0;
    public CustomMessageListener y1;
    public int y2;
    public ug<TbImageView> z;
    public au4 z0;
    public CustomMessageListener z1;
    public final TbRichTextView.a0 z2;

    /* loaded from: classes5.dex */
    public interface f3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public interface h3 {
        void a(Object obj);
    }

    @Override // com.baidu.tieba.pg8
    public VideoPbCommentFloatFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (VideoPbCommentFloatFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public void V(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, context, str) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048724, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg8
    public PbFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class k1 implements y17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        @Override // com.baidu.tieba.y17.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.y17.d
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
            public class C0388a implements TextWatcher {
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

                public C0388a(a aVar) {
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
                    ud8 ud8Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ud8Var = this.a.a.c.J0) != null && ud8Var.g() != null) {
                        if (!this.a.a.c.J0.g().e()) {
                            this.a.a.c.J0.b(false);
                        }
                        this.a.a.c.J0.g().l(false);
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
                    int j = ej.j(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = j / 2;
                        g = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i2 = j - (i + g);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    int i3 = (pbFragment.X[1] + pbFragment.Y) - i2;
                    if (pbFragment.F0 != null && this.a.c.F0.W0() != null) {
                        this.a.c.F0.W0().smoothScrollBy(i3, 50);
                    }
                    if (this.a.c.E5().g1() != null) {
                        this.a.c.U0.b().setVisibility(8);
                        z = (this.a.c.x0 == null || this.a.c.x0.k1() == null || this.a.c.x0.k1().N() == null || !this.a.c.x0.k1().N().isBjh()) ? false : false;
                        nc8 g1 = this.a.c.E5().g1();
                        k1 k1Var = this.a;
                        g1.t(k1Var.a, k1Var.b, k1Var.c.E5().h1(), z);
                        sd5 f = this.a.c.E5().g1().f();
                        if (f != null && this.a.c.x0 != null && this.a.c.x0.k1() != null) {
                            f.H(this.a.c.x0.k1().c());
                            f.d0(this.a.c.x0.k1().N());
                        }
                        if (this.a.c.J0.f() == null && this.a.c.E5().g1().f().u() != null) {
                            this.a.c.E5().g1().f().u().g(new C0388a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.J0.n(pbFragment2.E5().g1().f().u().i());
                            this.a.c.E5().g1().f().N(this.a.c.b1);
                        }
                    }
                    this.a.c.E5().q1();
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

        @Override // com.baidu.tieba.y17.d
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
                gh.a().postDelayed(new a(this), 200L);
            }
        }
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
                    xa8.a(this.b.a.getPageContext(), this.a).show();
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
                ud8 ud8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ud8Var = this.a.c.J0) != null && ud8Var.g() != null) {
                    if (!this.a.c.J0.g().e()) {
                        this.a.c.J0.b(false);
                    }
                    this.a.c.J0.g().l(false);
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
                int i3 = (pbFragment.X[1] + pbFragment.Y) - i2;
                if (pbFragment.F0 != null && this.c.F0.W0() != null) {
                    this.c.F0.W0().smoothScrollBy(i3, 50);
                }
                if (this.c.E5().g1() != null) {
                    this.c.U0.b().setVisibility(8);
                    this.c.E5().g1().t(this.a, this.b, this.c.E5().h1(), (this.c.x0 == null || this.c.x0.k1() == null || this.c.x0.k1().N() == null || !this.c.x0.k1().N().isBjh()) ? false : false);
                    sd5 f = this.c.E5().g1().f();
                    if (f != null && this.c.x0 != null && this.c.x0.k1() != null) {
                        f.H(this.c.x0.k1().c());
                        f.d0(this.c.x0.k1().N());
                    }
                    if (this.c.J0.f() == null && this.c.E5().g1().f().u() != null) {
                        this.c.E5().g1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.J0.n(pbFragment2.E5().g1().f().u().i());
                        this.c.E5().g1().f().N(this.c.b1);
                    }
                }
                this.c.E5().q1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:761:0x1df1, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:785:0x1ea5, code lost:
            if ((r32.a.F0.b1.a.getView().getTop() - r32.a.F0.h.a.getBottom()) < (r32.a.F0.b1.a.f.getHeight() + 10)) goto L756;
         */
        /* JADX WARN: Removed duplicated region for block: B:1038:0x27b2  */
        /* JADX WARN: Removed duplicated region for block: B:1039:0x27c8  */
        /* JADX WARN: Removed duplicated region for block: B:1042:0x2804  */
        /* JADX WARN: Removed duplicated region for block: B:1284:0x31ab  */
        /* JADX WARN: Removed duplicated region for block: B:1285:0x31b0  */
        /* JADX WARN: Removed duplicated region for block: B:1288:0x31bf  */
        /* JADX WARN: Removed duplicated region for block: B:1322:0x326d  */
        /* JADX WARN: Removed duplicated region for block: B:1325:0x327c  */
        /* JADX WARN: Removed duplicated region for block: B:1328:0x328f  */
        /* JADX WARN: Removed duplicated region for block: B:1331:0x32a0  */
        /* JADX WARN: Removed duplicated region for block: B:1334:0x32b6  */
        /* JADX WARN: Removed duplicated region for block: B:1336:0x32bf  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            u98 k1;
            int i;
            int i2;
            PostData W;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            q05 q05Var;
            q05 q05Var2;
            q05 q05Var3;
            PbFragment pbFragment;
            int i3;
            boolean z;
            q05 q05Var4;
            q05 q05Var5;
            q05 q05Var6;
            q05 q05Var7;
            String name;
            boolean z2;
            int i4;
            int i5;
            zz4 zz4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i6;
            int i7;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || !this.a.isAdded()) {
                return;
            }
            if (this.a.r0 && (view2 == this.a.F0.h.c || view2 == this.a.F0.h.d || view2.getId() == R.id.obfuscated_res_0x7f091947 || view2.getId() == R.id.obfuscated_res_0x7f090a95 || view2.getId() == R.id.obfuscated_res_0x7f091cda || view2.getId() == R.id.obfuscated_res_0x7f0918e4)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.F0.Z0() && this.a.getPageContext().getPageActivity() != null && this.a.x0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.D1(), this.a.x0.V1(), this.a.x0.U1())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.x0.getForumId());
                    statisticItem2.param("fname", this.a.x0.J0());
                    statisticItem2.param("tid", this.a.x0.D1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.F0.b1()) {
                    if (!this.a.h && this.a.x0.f2(true)) {
                        this.a.h = true;
                        this.a.F0.n3();
                    }
                } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().s()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.F0.t0();
                    this.a.b7();
                    this.a.F0.m3();
                    this.a.F0.H3();
                    if (this.a.F0.e1() != null) {
                        this.a.F0.e1().setVisibility(8);
                    }
                    this.a.x0.W2(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().l()) {
                    if (view2 == this.a.F0.h.f) {
                        if (this.a.F0.h0()) {
                            this.a.b7();
                            return;
                        }
                        ej.z(this.a.a, this.a.F0.h.f);
                        this.a.a.finish();
                    } else if (view2 == this.a.F0.I0() || (this.a.F0.h.h() != null && (view2 == this.a.F0.h.h().t() || view2 == this.a.F0.h.h().u()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.x0.k1() != null && !this.a.A0.Z()) {
                            this.a.F0.t0();
                            int i8 = (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().u()) ? (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().t()) ? view2 == this.a.F0.I0() ? 2 : 0 : this.a.x0.k1().N().getIs_good() == 1 ? 3 : 6 : this.a.x0.k1().N().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.x0.k1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.x0.k1().N().getId();
                            this.a.F0.b4();
                            this.a.A0.d0(id, name3, id2, i8, this.a.F0.J0());
                        }
                    } else if (view2 == this.a.F0.P0()) {
                        if (this.a.x0 != null) {
                            BrowserHelper.p(this.a.getPageContext().getPageActivity(), this.a.x0.k1().N().getTopicData().b());
                        }
                    } else if (view2 == this.a.F0.h.c) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.x0.k1() != null && this.a.x0.k1().N() != null && this.a.x0.k1().N().isVideoThreadType() && this.a.x0.k1().N().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.x0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.x0.J0()) || this.a.x0.A0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.x0.A0().b;
                        } else {
                            name2 = this.a.x0.k1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String J0 = this.a.x0.J0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.x0.P0() || J0 == null || !J0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.F0.h.d) {
                        if (jo5.a()) {
                            return;
                        }
                        if (this.a.x0 == null || this.a.x0.k1() == null) {
                            ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea0));
                            return;
                        }
                        ArrayList<PostData> G = this.a.x0.k1().G();
                        if ((G == null || G.size() <= 0) && this.a.x0.C1()) {
                            ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea0));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.x0.D1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x0.getForumId()));
                        this.a.l6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091908) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.F0.X2(true);
                        this.a.F0.K2();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.F0.R3();
                        this.a.b7();
                        this.a.F0.m3();
                        this.a.x0.a3(this.a.r5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918df) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.F0.t0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f0918df || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (qd8.c(this.a.getPageContext(), 11009) && this.a.x0.B0(this.a.F0.V0()) != null) {
                                this.a.d6();
                                if (this.a.x0.k1() != null && this.a.x0.k1().N() != null && this.a.x0.k1().N().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.k1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.x0.k1().N() == null || this.a.x0.k1().N().getAuthor() == null || this.a.x0.k1().N().getAuthor().getUserId() == null || this.a.z0 == null) {
                                    return;
                                }
                                int v = qd8.v(this.a.x0.k1());
                                ThreadData N = this.a.x0.k1().N();
                                if (N.isBJHArticleThreadType()) {
                                    i7 = 2;
                                } else if (N.isBJHVideoThreadType()) {
                                    i7 = 3;
                                } else if (N.isBJHNormalThreadType()) {
                                    i7 = 4;
                                } else {
                                    i7 = N.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 1).param("obj_id", this.a.x0.k1().N().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", v).param("obj_param1", i7));
                                return;
                            }
                            return;
                        }
                        this.a.T = view2;
                    } else if ((this.a.F0.h.h() != null && view2 == this.a.F0.h.h().q()) || view2.getId() == R.id.obfuscated_res_0x7f090a95 || view2.getId() == R.id.obfuscated_res_0x7f091cda) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.F0.t0();
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.b7();
                        this.a.F0.m3();
                        boolean b3 = view2.getId() == R.id.obfuscated_res_0x7f090a95 ? this.a.x0.b3(true, this.a.r5()) : view2.getId() == R.id.obfuscated_res_0x7f091cda ? this.a.x0.b3(false, this.a.r5()) : this.a.x0.a3(this.a.r5());
                        view2.setTag(Boolean.valueOf(b3));
                        if (b3) {
                            i6 = 1;
                            this.a.F0.X2(true);
                            this.a.F0.R3();
                            this.a.h = true;
                            this.a.F0.b3(true);
                        } else {
                            i6 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i6, new Object[0]);
                    } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().m()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (qd8.c(this.a.getPageContext(), 11009)) {
                                qd8.w(this.a.getContext(), 3, this.a.o5(), this.a.x0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918e4 || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (k1 = this.a.x0.k1()) == null) {
                                return;
                            }
                            ThreadData N2 = k1.N();
                            if (N2 != null && N2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", k1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                statisticItem3.param("tid", this.a.x0.D1());
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.a.x0.getForumId());
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
                                        int i9 = N2.threadType;
                                        if (i9 == 0) {
                                            statisticItem3.param("obj_type", 1);
                                        } else {
                                            if (i9 == 40) {
                                                statisticItem3.param("obj_type", 2);
                                            } else if (i9 == 49) {
                                                statisticItem3.param("obj_type", 3);
                                            } else if (i9 == 54) {
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
                                            if (N2.getBaijiahaoData() != null && !dj.isEmpty(N2.getBaijiahaoData().oriUgcVid)) {
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
                                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                }
                                if (this.a.N() != null) {
                                    uj5.e(this.a.N(), statisticItem3);
                                }
                                if (this.a.F0 != null) {
                                    statisticItem3.param("obj_param1", this.a.F0.S0());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (ej.F()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cfe);
                                    return;
                                } else if (k1 == null) {
                                    ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea0));
                                    return;
                                } else {
                                    ArrayList<PostData> G2 = this.a.x0.k1().G();
                                    if ((G2 == null || G2.size() <= 0) && this.a.x0.C1()) {
                                        ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea0));
                                        return;
                                    }
                                    this.a.F0.t0();
                                    this.a.b7();
                                    if (k1.A() != null && !StringUtils.isNull(k1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.x0.k1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), N2)) {
                                        return;
                                    }
                                    if (this.a.F0 != null) {
                                        this.a.F0.v0();
                                        this.a.F0.i4(k1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f0918e4) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.F0.T1() && !k1.n0()) {
                                            if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                if (f95.c() > 0) {
                                                    qd8.E(this.a.getContext(), this.a.x0.k1());
                                                    return;
                                                }
                                                int S0 = this.a.F0.S0();
                                                this.a.F0.g0();
                                                this.a.P5(f95.a(), S0);
                                                return;
                                            }
                                            this.a.V6(i2);
                                            return;
                                        }
                                        this.a.V6(i2);
                                        return;
                                    }
                                    this.a.F0.H3();
                                    this.a.x0.E0().I(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.x0.D1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.x0.getForumId());
                            if (view2.getId() != R.id.share_num_container) {
                            }
                            statisticItem32.param("obj_name", i);
                            statisticItem32.param("obj_type", 1);
                            if (N2 != null) {
                            }
                            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            }
                            if (this.a.N() != null) {
                            }
                            if (this.a.F0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (ej.F()) {
                            }
                        } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().r()) {
                            if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().y()) {
                                if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().x()) {
                                    if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().v()) {
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
                                        this.a.F0.h.f();
                                        return;
                                    } else if (this.a.F0.T0() == view2) {
                                        if (!this.a.F0.T0().getIndicateStatus()) {
                                            l19.d("c10725", null);
                                        } else {
                                            u98 k12 = this.a.x0.k1();
                                            if (k12 != null && k12.N() != null && k12.N().getTaskInfoData() != null) {
                                                String d = k12.N().getTaskInfoData().d();
                                                if (StringUtils.isNull(d)) {
                                                    d = k12.N().getTaskInfoData().g();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                            }
                                        }
                                        this.a.H5();
                                        return;
                                    } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().o()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.F0.t0();
                                        SparseArray<Object> X0 = this.a.F0.X0(this.a.x0.k1(), 1);
                                        if (X0 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.k1().k().getId(), this.a.x0.k1().k().getName(), this.a.x0.k1().N().getId(), StringUtils.string(this.a.x0.k1().U().getUserId()), StringUtils.string(X0.get(R.id.tag_forbid_user_name)), StringUtils.string(X0.get(R.id.tag_forbid_user_name_show)), StringUtils.string(X0.get(R.id.tag_forbid_user_post_id)), StringUtils.string(X0.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().k()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> X02 = this.a.F0.X0(this.a.x0.k1(), 1);
                                        if (X02 != null) {
                                            this.a.F0.r2(((Integer) X02.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(X02.get(R.id.tag_del_post_id)), ((Integer) X02.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X02.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.F0.h.e();
                                        if (this.a.M() == null || this.a.M().k1() == null || this.a.M().k1().N() == null) {
                                            return;
                                        }
                                        ThreadData N3 = this.a.M().k1().N();
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
                                    } else if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().n()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> X03 = this.a.F0.X0(this.a.x0.k1(), 1);
                                        if (X03 != null) {
                                            if (StringUtils.isNull((String) X03.get(R.id.tag_del_multi_forum))) {
                                                this.a.F0.o2(((Integer) X03.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(X03.get(R.id.tag_del_post_id)), ((Integer) X03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X03.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.F0.p2(((Integer) X03.get(R.id.tag_del_post_type)).intValue(), (String) X03.get(R.id.tag_del_post_id), ((Integer) X03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X03.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(X03.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.F0.h.e();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0920a1 && view2.getId() != R.id.obfuscated_res_0x7f0918f8 && view2.getId() != R.id.obfuscated_res_0x7f09178c) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091955) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091953 && view2.getId() != R.id.obfuscated_res_0x7f091b20 && view2.getId() != R.id.obfuscated_res_0x7f0918f2) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0918f6) {
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
                                                    if (this.a.L0 == null) {
                                                        PbFragment pbFragment2 = this.a;
                                                        pbFragment2.L0 = new u05(pbFragment2.getContext());
                                                        this.a.L0.p(this.a.g2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.M().k1() != null && this.a.M().k1().i0();
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
                                                    if (postData.p() != null) {
                                                        boolean z4 = postData.p().hasAgree;
                                                        int q = postData.q();
                                                        if (z4 && q == 5) {
                                                            pbFragment = this.a;
                                                            i3 = R.string.action_cancel_dislike;
                                                        } else {
                                                            pbFragment = this.a;
                                                            i3 = R.string.action_dislike;
                                                        }
                                                        q05 q05Var8 = new q05(8, pbFragment.getString(i3), this.a.L0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, postData);
                                                        q05Var8.d.setTag(sparseArray2);
                                                        arrayList.add(q05Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!jf8.j(this.a.x0) && !booleanValue3 && booleanValue2) {
                                                            q05 q05Var9 = new q05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0be0), this.a.L0);
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
                                                            q05Var9.d.setTag(sparseArray3);
                                                            arrayList.add(q05Var9);
                                                        } else if ((qd8.B(this.a.x0.k1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            q05 q05Var10 = new q05(5, this.a.getString(R.string.report_text), this.a.L0);
                                                            q05Var10.d.setTag(str);
                                                            arrayList.add(q05Var10);
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
                                                                    q05 q05Var11 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d5), this.a.L0);
                                                                    q05Var11.d.setTag(sparseArray4);
                                                                    q05Var2 = q05Var11;
                                                                    q05Var = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                                    q05Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            q05Var2 = null;
                                                            q05Var = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                            q05Var.d.setTag(sparseArray4);
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
                                                            if (this.a.x0.k1().V() == 1002 && !booleanValue) {
                                                                q05Var3 = new q05(6, this.a.getString(R.string.report_text), this.a.L0);
                                                            } else {
                                                                q05Var3 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d5), this.a.L0);
                                                            }
                                                            q05Var3.d.setTag(sparseArray5);
                                                            q05Var2 = q05Var3;
                                                            q05Var = null;
                                                        } else {
                                                            q05Var = null;
                                                            q05Var2 = null;
                                                        }
                                                        if (q05Var2 != null) {
                                                            arrayList.add(q05Var2);
                                                        }
                                                        if (q05Var != null) {
                                                            arrayList.add(q05Var);
                                                        }
                                                    }
                                                    this.a.L0.k(arrayList);
                                                    this.a.K0 = new s05(this.a.getPageContext(), this.a.L0);
                                                    this.a.K0.k();
                                                    return;
                                                } else if (view2 == this.a.F0.R0()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, dh.g(this.a.x0.k1().l(), 0L), dh.g(this.a.x0.D1(), 0L), dh.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.x0.k1().N().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.F0.h.h() == null || view2 != this.a.F0.h.h().w()) {
                                                    if (this.a.F0.h.h() != null && view2 == this.a.F0.h.h().p()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.x0.D1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.F0.h.e();
                                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f0907cb && view2.getId() != R.id.obfuscated_res_0x7f090a92) {
                                                        int id3 = view2.getId();
                                                        if (id3 == R.id.pb_u9_text_view) {
                                                            if (!this.a.checkUpIsLogin() || (zz4Var = (zz4) view2.getTag()) == null || StringUtils.isNull(zz4Var.o1())) {
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{zz4Var.o1()});
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091cdd || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                PostData postData2 = (PostData) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.x0.b));
                                                                }
                                                                if (this.a.L0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.L0 = new u05(pbFragment3.getContext());
                                                                    this.a.L0.p(this.a.g2);
                                                                }
                                                                ArrayList arrayList2 = new ArrayList();
                                                                boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                if (postData2 != null) {
                                                                    if (postData2.Z() != null && postData2.Z().toString().length() > 0) {
                                                                        q05 q05Var12 = new q05(3, this.a.getString(R.string.obfuscated_res_0x7f0f0475), this.a.L0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, postData2);
                                                                        q05Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(q05Var12);
                                                                    }
                                                                    this.a.B2 = postData2;
                                                                }
                                                                if (this.a.x0.k1().q()) {
                                                                    String u = this.a.x0.k1().u();
                                                                    if (postData2 != null && !dj.isEmpty(u) && u.equals(postData2.O())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            q05Var4 = new q05(4, this.a.getString(R.string.remove_mark), this.a.L0);
                                                                        } else {
                                                                            q05Var4 = new q05(4, this.a.getString(R.string.obfuscated_res_0x7f0f0b3c), this.a.L0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.B2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        q05Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(q05Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!jf8.j(this.a.x0) && !booleanValue9 && booleanValue8) {
                                                                                q05 q05Var13 = new q05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0be0), this.a.L0);
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
                                                                                q05Var4.d.setTag(sparseArray9);
                                                                                arrayList2.add(q05Var13);
                                                                            } else if (qd8.B(this.a.x0.k1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                q05 q05Var14 = new q05(5, this.a.getString(R.string.report_text), this.a.L0);
                                                                                q05Var14.d.setTag(str2);
                                                                                arrayList2.add(q05Var14);
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
                                                                                        q05 q05Var15 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d5), this.a.L0);
                                                                                        q05Var15.d.setTag(sparseArray10);
                                                                                        q05Var6 = q05Var15;
                                                                                        q05Var5 = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                                                        q05Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                q05Var6 = null;
                                                                                q05Var5 = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f1), this.a.L0);
                                                                                q05Var5.d.setTag(sparseArray10);
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
                                                                                if (this.a.x0.k1().V() == 1002 && !booleanValue7) {
                                                                                    q05Var7 = new q05(6, this.a.getString(R.string.report_text), this.a.L0);
                                                                                } else {
                                                                                    q05Var7 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d5), this.a.L0);
                                                                                }
                                                                                q05Var7.d.setTag(sparseArray11);
                                                                                q05Var6 = q05Var7;
                                                                                q05Var5 = null;
                                                                            } else {
                                                                                q05Var5 = null;
                                                                                q05Var6 = null;
                                                                            }
                                                                            if (q05Var6 != null) {
                                                                                arrayList2.add(q05Var6);
                                                                            }
                                                                            if (q05Var5 != null) {
                                                                                arrayList2.add(q05Var5);
                                                                            }
                                                                        }
                                                                        this.a.L0.k(arrayList2);
                                                                        this.a.K0 = new s05(this.a.getPageContext(), this.a.L0);
                                                                        this.a.K0.k();
                                                                        return;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                }
                                                                SparseArray sparseArray82 = new SparseArray();
                                                                sparseArray82.put(R.id.tag_clip_board, this.a.B2);
                                                                sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                q05Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(q05Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.L0.k(arrayList2);
                                                                this.a.K0 = new s05(this.a.getPageContext(), this.a.L0);
                                                                this.a.K0.k();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.x0.k1() == null || this.a.x0.k1().N() == null || this.a.x0.k1().N().getActUrl() == null) {
                                                                return;
                                                            }
                                                            BrowserHelper.p(this.a.getActivity(), this.a.x0.k1().N().getActUrl());
                                                            if (this.a.x0.k1().N().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.x0.k1().N().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.x0.k1().l()).param("tid", this.a.x0.k1().P()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.x0.k1().P().equals(string)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.F0.q3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091922 || id3 == R.id.obfuscated_res_0x7f0918ec) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string2 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String s = p35.m().s("tail_link", "");
                                                                String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(s)) {
                                                                    TiebaStatic.log("c10056");
                                                                    BrowserHelper.t(view2.getContext(), string2, UtilHelper.urlAddParam(s, "page_from=1&tailSkinId=" + string3), true, true, true);
                                                                }
                                                                this.a.F0.K2();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                BrowserHelper.p(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.o5() != 1 || this.a.x0 == null || this.a.x0.k1() == null) {
                                                                    return;
                                                                }
                                                                lg8.u("c10397", this.a.x0.k1().l(), this.a.x0.k1().P(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string4 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                BrowserHelper.p(this.a.getActivity(), string4);
                                                                if (this.a.o5() != 1 || this.a.x0 == null || this.a.x0.k1() == null) {
                                                                    return;
                                                                }
                                                                lg8.u("c10507", this.a.x0.k1().l(), this.a.x0.k1().P(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09158d) {
                                                            this.a.Z5();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09158c) {
                                                            this.a.X5();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0924e3) {
                                                            if (this.a.o1 >= 0) {
                                                                if (this.a.x0 != null) {
                                                                    this.a.x0.D2();
                                                                }
                                                                if (this.a.x0 == null || this.a.F0.G0() == null) {
                                                                    i5 = 0;
                                                                } else {
                                                                    i5 = 0;
                                                                    this.a.F0.G0().h0(this.a.x0.k1(), false);
                                                                }
                                                                this.a.o1 = i5;
                                                                if (this.a.x0 != null) {
                                                                    if (this.a.F0.W0() != null) {
                                                                        this.a.F0.W0().setSelection(this.a.x0.d1());
                                                                    }
                                                                    this.a.x0.H2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (qd8.c(this.a.getPageContext(), 11009)) {
                                                                qd8.w(this.a.getContext(), 8, this.a.o5(), this.a.x0);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09178c) {
                                                            SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                            if (sparseArray12 == null) {
                                                                return;
                                                            }
                                                            this.a.Z6(sparseArray12);
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0918e1) {
                                                            if (this.a.F0.W0() == null || this.a.x0 == null || this.a.x0.k1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.F0.W0().getFirstVisiblePosition();
                                                            View childAt = this.a.F0.W0().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean v0 = this.a.x0.k1().v0();
                                                            boolean R1 = this.a.F0.R1();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            qd8.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.x0.k1());
                                                            if ((this.a.x0.k1().N() != null && this.a.x0.k1().N().getReply_num() <= 0) || (R1 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.p6();
                                                                if (this.a.x0.k1().N().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.k1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int j = (int) (ej.j(this.a.getContext()) * 0.6d);
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
                                                                if (!z2 && !R1) {
                                                                    if (this.a.Z <= 0) {
                                                                        int d2 = ne8.d(this.a.getListView());
                                                                        if (ne8.e(this.a.getListView()) != -1) {
                                                                            d2--;
                                                                        }
                                                                        int g = ej.g(this.a.getContext(), R.dimen.tbds100);
                                                                        if (d2 < 0) {
                                                                            d2 = (ListUtils.getCount(this.a.F0.W0().getData()) - 1) + this.a.F0.W0().getHeaderViewsCount();
                                                                            i4 = 0;
                                                                        } else {
                                                                            i4 = g;
                                                                        }
                                                                        if (this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                            i4 += this.a.F0.h.a.getFixedNavHeight() - 10;
                                                                        }
                                                                        if (this.a.F0.b1 == null || this.a.F0.b1.a == null || this.a.F0.b1.a.getView() == null || this.a.F0.b1.a.getView().getParent() == null) {
                                                                            this.a.F0.W0().setSelectionFromTop(d2, i4 + j);
                                                                            this.a.F0.W0().smoothScrollBy(j, 500);
                                                                        } else {
                                                                            this.a.F0.W0().E(d2, i4, 200);
                                                                        }
                                                                    } else if (this.a.F0.W0().getChildAt(this.a.Z) != null) {
                                                                        this.a.F0.W0().E(this.a.Z, this.a.a0, 200);
                                                                    } else {
                                                                        this.a.F0.W0().setSelectionFromTop(this.a.Z, this.a.a0 + j);
                                                                        this.a.F0.W0().smoothScrollBy(j, 500);
                                                                    }
                                                                } else {
                                                                    this.a.Z = firstVisiblePosition;
                                                                    this.a.a0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                        int i10 = -j;
                                                                        this.a.F0.W0().setSelectionFromTop(0, i10);
                                                                        this.a.F0.W0().smoothScrollBy(i10, 500);
                                                                    } else {
                                                                        this.a.F0.W0().E(0, 0, 500);
                                                                    }
                                                                }
                                                            }
                                                            if (this.a.x0.k1().N() == null || this.a.x0.k1().N().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.k1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091946 || id3 == R.id.obfuscated_res_0x7f091947) {
                                                            if (this.a.x0 == null || this.a.x0.k1() == null || this.a.x0.k1().k() == null || dj.isEmpty(this.a.x0.k1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.x0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.x0.J0()) || this.a.x0.A0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.x0.A0().b;
                                                            } else {
                                                                name = this.a.x0.k1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String J02 = this.a.x0.J0();
                                                            if (!this.a.x0.P0() || J02 == null || !J02.equals(name)) {
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.x0.k1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.x0.D1());
                                                            statisticItem6.param("fid", this.a.x0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.x0.k1().N() != null) {
                                                                statisticItem6.param("nid", this.a.x0.k1().N().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.x0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.x0.D1());
                                                                statisticItem7.param("fid", this.a.x0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091967) {
                                                                if (this.a.x0 == null || this.a.x0.k1() == null) {
                                                                    return;
                                                                }
                                                                u98 k13 = this.a.x0.k1();
                                                                if (this.a.C0 == null) {
                                                                    PbFragment pbFragment4 = this.a;
                                                                    pbFragment4.C0 = new la8(pbFragment4.getPageContext());
                                                                }
                                                                long g2 = dh.g(k13.P(), 0L);
                                                                long g3 = dh.g(k13.l(), 0L);
                                                                lg8.w("c13446", g3);
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.registerListener(pbFragment5.n2);
                                                                this.a.C0.a(g2, g3);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09197e) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!qz5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        BrowserHelper.p(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.x0.D1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090f10) {
                                                                if (view2.getTag() instanceof ThreadData) {
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090f0d) {
                                                                if ((view2.getTag() instanceof ThreadData) && this.a.checkUpIsLogin()) {
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.P != null) {
                                                                        this.a.P.Y(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 != R.id.obfuscated_res_0x7f0918fa && id3 != R.id.obfuscated_res_0x7f09194d) {
                                                                if (id3 == R.id.obfuscated_res_0x7f092501) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        lg8.s(5);
                                                                    }
                                                                    this.a.D6(false);
                                                                    this.a.a7((PostData) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.r0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.x0.D1());
                                                                statisticItem8.param("fid", this.a.x0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    lg8.s(6);
                                                                }
                                                                PbFragment pbFragment6 = this.a;
                                                                pbFragment6.b = false;
                                                                pbFragment6.c5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.x0.j1() != 3 || !this.a.v0() || this.a.x0.k1() == null || !ListUtils.isEmpty(this.a.x0.k1().o())) {
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
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                            return;
                                                        }
                                                        PostData postData3 = (PostData) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (postData3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907cc);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907cd);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a92);
                                                        if (postData3.v0()) {
                                                            postData3.V0(false);
                                                            kf8.e(postData3);
                                                        } else if (this.a.M() != null ? kf8.c(this.a.M().k1(), postData3) : false) {
                                                            postData3.V0(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, postData3.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, postData3.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.F0.h.f();
                                                    this.a.F0.O3(this.a.E2);
                                                    return;
                                                }
                                            } else if (this.a.x0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091953) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.x0.D1());
                                                    statisticItem10.param("fid", this.a.x0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091b20) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.S = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091953 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.S = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                        PostData postData4 = (PostData) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091953 && (statisticItem = postData4.e0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b20 || view2.getId() == R.id.obfuscated_res_0x7f0918f2) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.x0.E1()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.O()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.x0 == null || this.a.x0.k1() == null || this.a.E5().f1() == null || postData4.r() == null || postData4.F() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.E5().g1() != null) {
                                                            this.a.E5().g1().g();
                                                        }
                                                        ja8 ja8Var = new ja8();
                                                        ja8Var.x(this.a.x0.k1().k());
                                                        ja8Var.B(this.a.x0.k1().N());
                                                        ja8Var.z(postData4);
                                                        this.a.E5().f1().c0(ja8Var);
                                                        this.a.E5().f1().setPostId(postData4.O());
                                                        this.a.a6(view2, postData4.r().getUserId(), "", postData4);
                                                        if (this.a.U0 != null) {
                                                            this.a.F0.R2(this.a.U0.y());
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
                                            statisticItem11.param("tid", this.a.x0.D1());
                                            statisticItem11.param("fid", this.a.x0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091955 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                        PostData postData5 = (PostData) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = postData5.e0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.x0 == null || this.a.x0.k1() == null) {
                                                            return;
                                                        }
                                                        String D1 = this.a.x0.D1();
                                                        String O = postData5.O();
                                                        int V = this.a.x0.k1() != null ? this.a.x0.k1().V() : 0;
                                                        AbsPbActivity.e q6 = this.a.q6(O);
                                                        if (q6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(D1, O, "pb", true, false, null, false, null, V, postData5.g0(), this.a.x0.k1().c(), false, postData5.r().getIconInfo(), 5).addBigImageData(q6.a, q6.b, q6.g, q6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.x0.j1());
                                                        addBigImageData.setFromFrsForumId(this.a.x0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.x0.I1());
                                                        addBigImageData.setKeyFromForumId(this.a.x0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.x0.P(), this.a.x0.L(), this.a.x0.M(), this.a.x0.K(), this.a.x0.Q());
                                                        addBigImageData.setBjhData(this.a.x0.C0());
                                                        if (this.a.x0.k1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.x0.k1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.x0.k1().U() != null) {
                                                            addBigImageData.setIsManager(this.a.x0.k1().U().getIs_manager());
                                                        }
                                                        if (this.a.x0.k1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.x0.k1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.x0.k1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.x0.k1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.x0.k1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.x0.k1().k().getUser_level());
                                                        }
                                                        if (this.a.F0 != null && this.a.x0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.x0.G.W().S || postData5.S);
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
                                        if (view2.getId() == R.id.obfuscated_res_0x7f09178c) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.x0.D1());
                                            statisticItem13.param("fid", this.a.x0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0918f8 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                lg8.r("c10517", this.a.x0.k1().l(), 3);
                                                return;
                                            } else if (this.a.x0 == null || this.a.x0.k1() == null) {
                                                return;
                                            } else {
                                                this.a.F0.t0();
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
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09178c) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918f8) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String D12 = this.a.x0.D1();
                                                String O2 = postData6.O();
                                                String O3 = postData7 != null ? postData7.O() : "";
                                                int V2 = this.a.x0.k1() != null ? this.a.x0.k1().V() : 0;
                                                this.a.b7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091cdd) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e q62 = this.a.q6(O2);
                                                    if (postData6 == null || this.a.x0 == null || this.a.x0.k1() == null || q62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(D12, O2, "pb", true, false, null, false, O3, V2, postData6.g0(), this.a.x0.k1().c(), false, postData6.r().getIconInfo(), 5).addBigImageData(q62.a, q62.b, q62.g, q62.j);
                                                    if (!dj.isEmpty(O3)) {
                                                        addBigImageData2.setHighLightPostId(O3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.x0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.x0.P(), this.a.x0.L(), this.a.x0.M(), this.a.x0.K(), this.a.x0.Q());
                                                    addBigImageData2.setBjhData(this.a.x0.C0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.x0.j1());
                                                    addBigImageData2.setFromFrsForumId(this.a.x0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.x0.I1());
                                                    if (this.a.F0 != null && this.a.x0.G != null && (W = this.a.x0.G.W()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(W.S || postData6.S);
                                                    }
                                                    if (this.a.x0.k1() != null && this.a.x0.k1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.x0.k1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e q63 = this.a.q6(O2);
                                                if (this.a.x0 == null || this.a.x0.k1() == null || q63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(D12, O2, "pb", true, false, null, true, null, V2, postData6.g0(), this.a.x0.k1().c(), false, postData6.r().getIconInfo(), 5).addBigImageData(q63.a, q63.b, q63.g, q63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.x0.j1());
                                                addBigImageData3.setFromFrsForumId(this.a.x0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.x0.I1());
                                                addBigImageData3.setKeyFromForumId(this.a.x0.getForumId());
                                                addBigImageData3.setBjhData(this.a.x0.C0());
                                                addBigImageData3.setTiebaPlusData(this.a.x0.P(), this.a.x0.L(), this.a.x0.M(), this.a.x0.K(), this.a.x0.Q());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.R = view2;
                                        return;
                                    }
                                } else if (this.a.x0 == null || this.a.x0.k1() == null || this.a.x0.k1().N() == null) {
                                    return;
                                } else {
                                    this.a.F0.h.e();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.L5(pbFragment7.x0.k1().N().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.F0.t0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.x0.A1()));
                            } else {
                                this.a.b7();
                                this.a.F0.m3();
                                s05 s05Var = new s05(this.a.getPageContext());
                                if (this.a.x0.k1().f == null || this.a.x0.k1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.x0.k1().f.size()];
                                    for (int i11 = 0; i11 < this.a.x0.k1().f.size(); i11++) {
                                        strArr[i11] = this.a.x0.k1().f.get(i11).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                s05Var.i(null, strArr, new a(this, s05Var, view2));
                                s05Var.k();
                            }
                        } else {
                            this.a.F0.t0();
                            if (this.a.M().k1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.x0.i1() != null) {
                                this.a.F0.V3(this.a.x0.i1(), this.a.e2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.F0.h.e();
                    }
                } else {
                    this.a.F0.h.f();
                    if (this.a.x0 != null) {
                        this.a.s1.f(this.a.x0.D1());
                    }
                    if (this.a.x0 != null && this.a.x0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.M() == null || this.a.M().k1() == null) {
                            return;
                        }
                        this.a.s1.d(3, 3, this.a.M().k1().P());
                        return;
                    }
                    this.a.s1.b();
                    int i12 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().k1() == null || this.a.M().k1().P() == null || !this.a.M().k1().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.M() == null || this.a.M().k1() == null) {
                        return;
                    }
                    this.a.s1.d(3, i12, this.a.M().k1().P());
                }
            } else if (!this.a.r0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.x0.D1());
                statisticItem15.param("fid", this.a.x0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    lg8.s(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
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
                    if (this.a.x0 != null && this.a.x0.k1() != null && this.a.E5().f1() != null && postData8.r() != null && postData8.F() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.E5().g1() != null) {
                            this.a.E5().g1().g();
                        }
                        ja8 ja8Var2 = new ja8();
                        ja8Var2.x(this.a.x0.k1().k());
                        ja8Var2.B(this.a.x0.k1().N());
                        ja8Var2.z(postData8);
                        this.a.E5().f1().c0(ja8Var2);
                        this.a.E5().f1().setPostId(postData8.O());
                        this.a.a6(view2, postData8.r().getUserId(), "", postData8);
                        TiebaStatic.log("c11743");
                        lg8.b(this.a.x0.k1(), postData8, postData8.d0, 8, 1);
                        if (this.a.U0 != null) {
                            this.a.F0.R2(this.a.U0.y());
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
        public class a implements u05.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s05 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ l1 c;

            public a(l1 l1Var, s05 s05Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, s05Var, view2};
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
                this.a = s05Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.x0.B1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.u05.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void J0(u05 u05Var, int i, View view2) {
                boolean c3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.x0.B1() != 1 || i != 1) {
                        if (this.c.a.x0.B1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.x0.B1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091963) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.x0.k1().f != null && this.c.a.x0.k1().f.size() > i) {
                            i = this.c.a.x0.k1().f.get(i).sort_type.intValue();
                        }
                        c3 = this.c.a.x0.c3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.x0.A1()));
                        if (c3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.F0.b3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091963) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.x0.k1().f != null) {
                        i = this.c.a.x0.k1().f.get(i).sort_type.intValue();
                    }
                    c3 = this.c.a.x0.c3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.x0.A1()));
                    if (c3) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.F0 != null && this.a != null) {
                    this.b.a.F0.w2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
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

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j05.e {
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

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0.k1() != null) {
                        statisticItem.param("fid", this.a.x0.k1().l());
                    }
                    statisticItem.param("tid", this.a.x0.D1());
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
                this.a.b7();
                this.a.F0.k3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.D0 != null) {
                    this.a.D0.n0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    gh.a().postDelayed(this.a.V1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.U0.x() || this.a.U0.z()) {
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
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        j05 j05Var = new j05(this.a.getActivity());
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            j05Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(this));
                        j05Var.setPositiveButton(R.string.open_now, new c(this));
                        j05Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (k89.d(i) || a85Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.K6(i, str);
                        return;
                    }
                }
                this.a.U6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.L6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.F0.I1(this.a.x0.k1());
                    }
                } else if (this.a.x0.N0()) {
                    u98 k1 = this.a.x0.k1();
                    if (k1 != null && k1.N() != null && k1.N().getAuthor() != null && (userId = k1.N().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.x0.Z2()) {
                        this.a.F0.m3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.x0.Z2()) {
                    this.a.F0.m3();
                }
                if (this.a.x0.R0()) {
                    lg8.p("c10369", this.a.x0.D1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.x0 != null) {
                    Context context = this.a.getContext();
                    u98 k12 = this.a.x0.k1();
                    String forumId = this.a.x0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    qd8.a(context, k12, forumId, z2, this.a.x0.p1(), this.a.x0.s1(), this.a.x0.r1(), this.a.x0.q1(), this.a.x0.w1(), this.a.x0.x1());
                }
                if (writeData != null) {
                    k55.b(writeData.getContent(), "1");
                }
                if (this.a.T5()) {
                    this.a.e7();
                }
                this.a.S6();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.F0 != null && this.a != null) {
                    this.b.a.F0.w2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
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

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j05.e {
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

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0 != null && this.a.x0.k1() != null) {
                        statisticItem.param("fid", this.a.x0.k1().l());
                    }
                    if (this.a.x0 != null) {
                        statisticItem.param("tid", this.a.x0.D1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.w5()) {
                        this.a.D6(false);
                        z88.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12d5));
                    }
                    ud8 ud8Var = this.a.J0;
                    if (ud8Var != null) {
                        ud8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        q95.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        k55.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.T5()) {
                        this.a.e7();
                    }
                    this.a.S6();
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
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    j05 j05Var = new j05(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        j05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(this));
                    j05Var.setPositiveButton(R.string.open_now, new c(this));
                    j05Var.create(this.a.getPageContext()).show();
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
                g45 g45Var = new g45();
                g45Var.b = R.raw.lottie_bubble_breath_tip;
                g45Var.a = BreatheTipWidget.PointType.LOTTIE;
                g45Var.c = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                h45 h45Var = new h45();
                h45Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f052e);
                h45Var.b = this.a.a.getString(R.string.agree_tip_content);
                h45Var.e = R.drawable.pic_guidecard;
                h45Var.f = ej.g(this.a.a.getContext(), R.dimen.tbds156);
                h45Var.g = ej.g(this.a.a.getContext(), R.dimen.tbds489);
                h45Var.h = ej.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.F0.j1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.F0.j1()));
                breatheTipWidget.f(h45Var, g45Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    p35 m = p35.m();
                    m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    l95.a("c14828");
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
        public void b(u98 u98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u98Var) == null) {
                this.a.F0.I1(u98Var);
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
            rk5 rk5Var = new rk5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            rk5Var.c();
            if (z2) {
                j3 = j4;
                rk5Var.B = j3;
                rk5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.x0 != null && this.a.x0.k1() != null && this.a.x0.k1().N() != null) {
                int threadType = this.a.x0.k1().N().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.L, "from_personalize")) {
                        nk5 nk5Var = new nk5();
                        nk5Var.F = 1;
                        nk5Var.a(1005);
                        nk5Var.D = j3;
                        nk5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.L, "from_frs")) {
                        rk5 rk5Var2 = new rk5();
                        rk5Var2.a(1000);
                        rk5Var2.D = j3;
                        rk5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, u98 u98Var, String str, int i4) {
            ArrayList<PostData> arrayList;
            int i5;
            sb5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), u98Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09070d));
                }
                if (z && u98Var != null && u98Var.X() == null && ListUtils.getCount(u98Var.G()) < 1) {
                    this.a.x0.W2(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.F0 != null) {
                        this.a.F0.S3();
                        return;
                    }
                    return;
                }
                if (this.a.f0) {
                    if (this.a.M() != null) {
                        this.a.M().s0();
                    }
                } else {
                    this.a.f0 = true;
                }
                this.a.g = true;
                if (this.a.F0 == null) {
                    return;
                }
                this.a.F0.l3();
                if (u98Var == null || !u98Var.q0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.F0.o1());
                }
                this.a.F0.w1();
                if (!this.a.F0.M1()) {
                    this.a.F0.z3(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && u98Var != null) {
                    this.a.N0 = true;
                }
                if (u98Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.F0.o1());
                    this.a.F0.v3();
                }
                String str2 = null;
                if (z && u98Var != null) {
                    ThreadData N = u98Var.N();
                    if (N != null && N.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.G6(pbFragment3.T0);
                    }
                    this.a.F0.g1().r(u98Var);
                    this.a.F0.G3();
                    if (N != null && N.getCartoonThreadData() != null) {
                        this.a.i7(N.getCartoonThreadData());
                    }
                    if (this.a.U0 != null) {
                        this.a.F0.R2(this.a.U0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(u98Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(u98Var.U().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(u98Var.U().getBimg_end_time());
                    if (u98Var.G() != null && u98Var.G().size() >= 1 && u98Var.G().get(0) != null) {
                        this.a.x0.I2(u98Var.G().get(0).O());
                    } else if (u98Var.X() != null) {
                        this.a.x0.I2(u98Var.X().O());
                    }
                    if (this.a.U0 != null) {
                        this.a.U0.H(u98Var.c());
                        this.a.U0.I(u98Var.k(), u98Var.U());
                        this.a.U0.k0(N);
                        this.a.U0.J(this.a.x0.M0(), this.a.x0.D1(), this.a.x0.I0());
                        if (N != null) {
                            this.a.U0.Z(N.isMutiForumThread());
                        }
                    }
                    if (this.a.z0 != null) {
                        this.a.z0.h(u98Var.q());
                    }
                    if (u98Var.r() == 1) {
                        this.a.q = true;
                    } else {
                        this.a.q = false;
                    }
                    if (u98Var.i0()) {
                        this.a.q = true;
                    }
                    this.a.F0.S2(this.a.q);
                    if (this.a.t0.f.size() > 0) {
                        u98Var.P0(this.a.t0.f);
                    }
                    this.a.F0.K3(u98Var, i2, i3, this.a.x0.C1(), i4, this.a.x0.T0());
                    this.a.F0.Z3(u98Var, this.a.x0.C1());
                    this.a.F0.e4(this.a.x0.N0());
                    AntiData c = u98Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.U0 != null && this.a.U0.b() != null && (o = this.a.U0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.F1);
                        }
                    }
                    if (!this.a.W && !ListUtils.isEmpty(this.a.x0.k1().G()) && !this.a.x0.W1()) {
                        this.a.W = true;
                        this.a.V4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.Q0)) {
                        ne8.i(this.a.x0.j1(), this.a.getListView(), this.a.Q0);
                        this.a.Q0 = null;
                    } else if (!this.a.P0) {
                        if (!this.a.R0) {
                            if (!TextUtils.isEmpty(this.a.x0.a1())) {
                                ne8.f(this.a.getListView(), this.a.x0.a1());
                                this.a.x0.d2();
                            } else {
                                this.a.F0.F3();
                            }
                        } else {
                            this.a.R0 = false;
                            ne8.j(this.a.getListView());
                        }
                    } else {
                        this.a.P0 = false;
                        ne8.g(this.a.getListView());
                    }
                    this.a.x0.e2(u98Var.k(), this.a.L1);
                    this.a.x0.i2(this.a.N1);
                    if (this.a.W0 != null && N != null && N.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.getAuthor());
                        this.a.W0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.x0 != null && this.a.x0.T1()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.F0 != null) {
                        str2 = this.a.F0.h1();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.U0.c0(TbSingleton.getInstance().getAdVertiComment(u98Var.o0(), u98Var.p0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.N0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.x0.A0() != null && !StringUtils.isNull(this.a.x0.A0().c)) {
                                    this.a.F0.g4(this.a.x0.A0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.F0.o1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    qv8.a("pb", false);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.F0.o1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                qv8.a("pb", false);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
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
                            jSONObject.put("tid", this.a.x0.D1());
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
                        if (this.a.x0 != null && this.a.x0.k1() != null) {
                            arrayList = this.a.x0.k1().G();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                            this.a.F0.N2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.V5()) {
                                this.a.F0.O2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ea1));
                            } else {
                                this.a.F0.O2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ea2));
                            }
                            this.a.F0.I1(this.a.x0.k1());
                        }
                    } else {
                        this.a.F0.N2("");
                    }
                    this.a.F0.A0();
                }
                if (u98Var != null && u98Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (u98Var != null) {
                        i5 = u98Var.f();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.Z1(i5, this.a.F0);
                }
                int n = p35.m().n(p35.q("key_reaction_guide_show_number_pb"), 0);
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
            nd5 nd5Var = new nd5();
            this.a.G6(nd5Var);
            PbFragment pbFragment = this.a;
            pbFragment.U0 = (od5) nd5Var.a(pbFragment.getContext());
            this.a.U0.W(this.a.a.getPageContext());
            this.a.U0.f0(this.a.k2);
            this.a.U0.g0(this.a.Z0);
            od5 od5Var = this.a.U0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            od5Var.A(pageContext, extras);
            this.a.U0.b().E(true);
            this.a.F0.M2(this.a.U0.b());
            if (!this.a.x0.X0()) {
                this.a.U0.q(this.a.x0.D1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.x0.T1()) {
                this.a.U0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.F0 != null) {
                this.a.U0.c0(this.a.F0.h1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                p35 m = p35.m();
                if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    gh.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements yi6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.yi6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.yi6.b
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

        @Override // com.baidu.tieba.yi6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.F0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.v5()) {
                    this.b.F0.v1();
                    this.b.F0.L2();
                }
            }
        }

        @Override // com.baidu.tieba.yi6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.F0 != null && this.b.e != null) {
                this.b.F0.P3();
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
            this.a.f5();
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
        public void onNavigationButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j05Var) == null) {
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
    public static class b implements zi6.b {
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

        @Override // com.baidu.tieba.zi6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ta8.d();
                } else {
                    ta8.c();
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
        public void a(qe8 qe8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, qe8Var) != null) || qe8Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, qe8Var.a()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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
        public void onNavigationButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 extends w9 {
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

        @Override // com.baidu.tieba.w9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.A0.getLoadDataMode()) {
                    case 0:
                        this.a.x0.O1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.k5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.F0.C0(dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.l5(pbFragment.A0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.F0.C0(gVar.a, gVar.b, false);
                        this.a.F0.n2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.F0.C0(false, null, false);
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
                if (!this.a.f && z && !this.a.x0.Z0()) {
                    this.a.w6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements jc8.b {
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

        @Override // com.baidu.tieba.jc8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f15df);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cfe);
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
                        this.a.m6();
                        return;
                    } else {
                        this.a.y6();
                        return;
                    }
                }
                this.a.j0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.a.N5();
                ty4 i1 = this.a.x0.i1();
                int d1 = this.a.F0.d1();
                if (d1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ea4);
                } else if (i1 != null && d1 > i1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ea4);
                } else {
                    this.a.F0.t0();
                    this.a.b7();
                    this.a.F0.m3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.x0.W2(this.a.F0.d1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cfe);
                    }
                    j05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) && j05Var != null) {
                j05Var.dismiss();
            }
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
    public class d implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    j05Var.dismiss();
                    ((TbPageContext) this.a.e1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                j05Var.dismiss();
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
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                BdLog.e(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.F0 != null) {
                this.a.F0.r3(list);
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
                String valueOf = String.valueOf(this.a.x0.k1().U().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.k1().k().getId(), this.a.x0.k1().k().getName(), this.a.x0.k1().N().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements y35.g {
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

        @Override // com.baidu.tieba.y35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.v5()) {
                    this.a.a.finish();
                }
                if (this.a.x0.h2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F0.B0();
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
    public class e implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
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
            u98 k1 = this.a.x0.k1();
            if (k1.N().getPraise().getIsLike() == 1) {
                this.a.j7(0);
            } else {
                this.a.j7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, k1.N()));
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements u05.f {
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

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                if (this.a.K0 != null) {
                    this.a.K0.dismiss();
                }
                this.a.g7(i);
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
                                                    ne5.a aVar = new ne5.a();
                                                    aVar.a = this.a.k1;
                                                    String str = "";
                                                    if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.m1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.T4();
                                                }
                                                this.a.j1 = null;
                                                this.a.k1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                                                if (this.a.V0 == null) {
                                                    this.a.V0 = new PermissionJudgePolicy();
                                                }
                                                this.a.V0.clearRequestPermissionList();
                                                this.a.V0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.V0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.i1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.i1 = new wd8(pbFragment.getPageContext());
                                                }
                                                this.a.i1.b(this.a.k1, this.a.j1.n());
                                                this.a.j1 = null;
                                                this.a.k1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.B2;
                                            if (postData != null) {
                                                postData.H0();
                                                this.a.B2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.e6(view2);
                                            if (this.a.x0.k1().N() != null && this.a.x0.k1().N().getAuthor() != null && this.a.x0.k1().N().getAuthor().getUserId() != null && this.a.z0 != null) {
                                                int v = qd8.v(this.a.x0.k1());
                                                ThreadData N = this.a.x0.k1().N();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 2).param("obj_id", this.a.x0.k1().N().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", v).param("obj_param1", i2));
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
                                                this.a.L5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.X4(sparseArray2);
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
                                                        this.a.F0.q2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, E);
                                                        return;
                                                    } else {
                                                        this.a.M6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.F0.o2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.M6(sparseArray3, intValue, booleanValue);
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
                                                    this.a.X4(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.F0.t2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.F0.o2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                            if (postData2.p() == null) {
                                                return;
                                            }
                                            this.a.a5(postData2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.x0 != null && this.a.x0.k1() != null) {
                                                this.a.a.S1(k89.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.x0 != null && this.a.x0.k1() != null) {
                                    this.a.F0.l4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.s6(view3);
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
                            this.a.s6(view4);
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
                    this.a.s6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            if (((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue()) {
                                this.a.D6(true);
                            } else {
                                this.a.D6(false);
                            }
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.s6(view6);
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
                if (this.a.v5()) {
                    this.a.a.finish();
                }
                if (this.a.x0.h2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F0.B0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements zc8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.zc8.b
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

        @Override // com.baidu.tieba.zc8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.F0.a4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
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
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.W3(!this.a.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                if (j05Var != null) {
                    j05Var.dismiss();
                }
                this.d.i5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
                if (this.a.w2 && this.a.v5()) {
                    this.a.X5();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.e0 && this.a.F0 != null && this.a.F0.i0() && this.a.x0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.x0.D1());
                    statisticItem.param("fid", this.a.x0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.x0.P0()) {
                        i = 4;
                    } else if (this.a.x0.Q0()) {
                        i = 3;
                    } else if (this.a.x0.S0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.e0 = true;
                }
                if (this.a.x0.f2(false)) {
                    this.a.F0.n3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if ((this.a.t0 == null || !this.a.x0.a2() || !this.a.t0.d()) && this.a.x0.k1() != null) {
                    this.a.F0.G2();
                }
                this.a.w2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.b.F0.H3();
                MessageManager.getInstance().sendMessage(this.a);
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements te8.h {
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

        @Override // com.baidu.tieba.te8.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.F6(z);
                if (this.a.F0.T0() != null && z) {
                    this.a.F0.W3(false);
                }
                this.a.F0.f2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x0 != null) {
                this.a.x0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<rd8> a;
        public WeakReference<PbFragment> b;

        public g3(rd8 rd8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(rd8Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                rd8 rd8Var = this.a.get();
                if (rd8Var != null) {
                    rd8Var.u1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.V6(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        j77.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0cfe);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements u05.f {
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

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                if (this.e.K0 != null) {
                    this.e.K0.dismiss();
                }
                if (i == 0) {
                    this.e.F0.o2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.g1);
                    this.e.X6(this.b, userMuteAddAndDelCustomMessage, this.d, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements y17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.y17.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.y17.d
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

        @Override // com.baidu.tieba.y17.d
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
                    if (this.a.U0 != null && this.a.U0.b() != null) {
                        this.a.U0.b().C(new lb5(45, 27, null));
                    }
                    this.a.F0.k0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends kp5<ShareItem> {
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
        @Override // com.baidu.tieba.kp5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.K2(this.a);
                }
                return lf8.c(this.b.o5(), 2, M);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.Q2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.p5().r() != null && this.a.p5().r().getGodUserData() != null) {
                        this.a.p5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.x0 != null && this.a.x0.k1() != null && this.a.x0.k1().N() != null && this.a.x0.k1().N().getAuthor() != null) {
                        this.a.x0.k1().N().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
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
                this.a.F0.t0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.x0 != null && !this.a.x0.isLoading) {
                    this.a.b7();
                    this.a.F0.m3();
                    z = true;
                    if (this.a.x0.k1() != null && this.a.x0.k1().f != null && this.a.x0.k1().f.size() > i) {
                        int intValue = this.a.x0.k1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.x0.E1()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.x0.c3(intValue)) {
                            this.a.h = true;
                            this.a.F0.b3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements kd5 {
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

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ud8 ud8Var = this.a.J0;
                if (ud8Var != null && ud8Var.g() != null && this.a.J0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.J0.g().c());
                    if (this.a.F0 != null && this.a.F0.g1() != null && this.a.F0.g1().f() != null && this.a.F0.g1().f().y()) {
                        this.a.F0.g1().f().w(this.a.J0.h());
                    }
                    this.a.J0.b(true);
                    return true;
                } else if (!this.a.Z4(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements oo5<ShareItem> {
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
        @Override // com.baidu.tieba.oo5
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
    public class j0 extends mh5<TipEvent> {
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
        @Override // com.baidu.tieba.fh5
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
    public class j2 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ j05 c;
        public final /* synthetic */ PbFragment d;

        public j2(PbFragment pbFragment, MarkData markData, MarkData markData2, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, j05Var};
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
            this.c = j05Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
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
                this.d.c7();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.x0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.U0 != null) {
                    this.a.F0.R2(this.a.U0.y());
                }
                this.a.F0.K2();
                this.a.F0.t0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends mh5<TopToastEvent> {
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
        @Override // com.baidu.tieba.fh5
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
    public class k2 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ j05 b;
        public final /* synthetic */ PbFragment c;

        public k2(PbFragment pbFragment, MarkData markData, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, j05Var};
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
            this.b = j05Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.c7();
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
            this.a.x0.e3((UserPendantData) customResponsedMessage.getData());
            if (this.a.F0 != null && this.a.x0 != null) {
                this.a.F0.E2(this.a.x0.k1(), this.a.F0.k1());
            }
            if (this.a.F0 != null && this.a.F0.G0() != null) {
                this.a.F0.G0().Z();
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
            rd8 rd8Var = this.b.F0;
            rd8Var.p3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ j05 b;
        public final /* synthetic */ PbFragment c;

        public l2(PbFragment pbFragment, MarkData markData, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, j05Var};
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
            this.b = j05Var;
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
                    this.c.c7();
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
                if (this.a.F0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.F0.R3();
                } else {
                    this.a.F0.w1();
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
                    this.a.U0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.F0 != null && this.a.F0.g1() != null && this.a.F0.g1().f() != null) {
                    this.a.F0.g1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements ld5 {
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

        @Override // com.baidu.tieba.ld5
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
                    if (aw4.c().g()) {
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
                boolean g = aw4.c().g();
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
            if (this.a.U0 != null) {
                this.a.F0.R2(this.a.U0.y());
            }
            this.a.F0.z3(false);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.x0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.x0.b)) {
                return;
            }
            this.a.U6((PostWriteCallBackData) customResponsedMessage.getData());
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
                if (aw4.c().g()) {
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
                boolean g = aw4.c().g();
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
                b98 b98Var = (b98) customResponsedMessage.getData();
                int type = b98Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (b98Var.a() == null) {
                                this.a.u6(false, null);
                                return;
                            } else {
                                this.a.u6(true, (MarkData) b98Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.k5((ForumManageModel.b) b98Var.a(), false);
                    return;
                }
                this.a.v6((ja8) b98Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements x88.d {
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

        @Override // com.baidu.tieba.x88.d
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F0 != null && this.a.F0.G0() != null) {
                this.a.F0.G0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ua8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.ua8.a
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

        @Override // com.baidu.tieba.ua8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091cfb) {
                        if (this.a.z6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090149) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof PostData)) {
                                return false;
                            }
                            PostData postData = (PostData) obj;
                            if (postData.getType() != PostData.T0 && !TextUtils.isEmpty(postData.t()) && aw4.c().g()) {
                                return this.a.g6(postData);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918f7) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.Z6((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.F0.N1() && view2.getId() == R.id.obfuscated_res_0x7f091916) {
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
                        this.a.Z6(sparseArray);
                    }
                }
                if (this.a.U0 != null) {
                    this.a.F0.R2(this.a.U0.y());
                }
                this.a.F0.K2();
                this.a.F0.t0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ua8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.j5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ys5.a)) {
                ys5.a aVar = (ys5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.I5(aVar.b);
                }
                ys5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.x0 != null && this.a.x0.V0()) {
                    this.a.b6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q1 extends wb {
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

        @Override // com.baidu.tieba.wb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView m1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        ej.P(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.F0 != null && (m1 = this.a.F0.m1()) != null && this.a.F0.W0() != null) {
                            this.a.F0.W0().removeHeaderView(m1);
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
            this.a.Y6();
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements l05.c {
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

        @Override // com.baidu.tieba.l05.c
        public void a(l05 l05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.M0 = pbFragment.M0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new zb8(this.a.x0.D1(), this.a.M0, "1").start();
                    l05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.M0 = pbFragment2.M0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new zb8(this.a.x0.D1(), this.a.M0, "2").start();
                    l05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.M0 = pbFragment3.M0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.M0);
                    l05Var.e();
                }
            }
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
            this.a.h7();
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
            dc8 G0;
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
                    statisticItem.param("tid", this.a.x0.D1());
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
                        boolean w = ((TbImageView) view2).w();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                        }
                        this.a.Q = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o6(str, i, eVar);
                    if (this.a.x0.G.i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().K() != null) {
                            ArrayList<TbRichTextImageInfo> K = tbRichTextView.getRichText().K();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < K.size()) {
                                if (K.get(i5) != null) {
                                    arrayList.add(K.get(i5).L());
                                    if (i6 == i4 && str != null && (str.equals(K.get(i5).L()) || str.equals(K.get(i5).H()) || str.equals(K.get(i5).G()) || str.equals(K.get(i5).getBigSrc()) || str.equals(K.get(i5).J()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = K.get(i5).L();
                                    imageUrlData.originalUrl = K.get(i5).L();
                                    imageUrlData.isLongPic = K.get(i5).O();
                                    concurrentHashMap.put(K.get(i5).L(), imageUrlData);
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
                        this.a.m5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.x0.v1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.V5());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.x0 != null) {
                            builder.D(this.a.x0.getFromForumId());
                            if (this.a.x0.k1() != null) {
                                builder.Q(this.a.x0.k1().N());
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
                        builder2.I(this.a.x0.v1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.V5());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.x0 != null) {
                            builder2.D(this.a.x0.getFromForumId());
                            if (this.a.x0.k1() != null) {
                                builder2.Q(this.a.x0.k1().N());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText k7 = this.a.k7(str, i);
                        if (k7 != null && this.a.y2 >= 0 && this.a.y2 < k7.I().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = v98.a(k7.I().get(this.a.y2));
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
                            if (k7.getPostId() != 0 && (G0 = this.a.F0.G0()) != null) {
                                ArrayList<Cdo> t = G0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<Cdo> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Cdo next = it.next();
                                        if ((next instanceof PostData) && k7.getPostId() == dh.g(((PostData) next).O(), 0L)) {
                                            int i8 = 8;
                                            if (k7.getPostId() == dh.g(this.a.x0.I0(), 0L)) {
                                                i8 = 1;
                                            }
                                            lg8.b(this.a.x0.k1(), (PostData) next, ((PostData) next).d0, i8, 3);
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
                            this.a.m5(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.x0.v1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.V5());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.x0 != null) {
                                builder3.D(this.a.x0.getFromForumId());
                                if (this.a.x0.k1() != null) {
                                    builder3.Q(this.a.x0.k1().N());
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.z0 == null || this.a.z0.e()) {
                    return;
                }
                this.a.d6();
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
                this.a.F0.u1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                u98 k1 = this.a.x0.k1();
                if (k1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    k1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.W6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (dj.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.f1.c(errorString2);
                } else {
                    this.a.P6();
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
                    this.a.H6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cfe);
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
                if (this.a.F0 != null && this.a.F0.g1() != null) {
                    nc8 g1 = this.a.F0.g1();
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
            this.a.u = true;
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
                this.a.F0.u1();
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
    public class u1 implements au4.a {
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

        @Override // com.baidu.tieba.au4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.F0.l3();
                if (z) {
                    if (this.a.z0 != null) {
                        this.a.z0.h(z2);
                    }
                    this.a.x0.Y2(z2);
                    if (!this.a.x0.V0()) {
                        this.a.F0.I1(this.a.x0.k1());
                    } else {
                        this.a.b6();
                    }
                    if (z2) {
                        boolean n0 = this.a.x0.k1().n0();
                        if (this.a.z0 != null && !n0) {
                            if (this.a.z0.f() != null && this.a.x0 != null && this.a.x0.k1() != null && this.a.x0.k1().N() != null && this.a.x0.k1().N().getAuthor() != null) {
                                MarkData f = this.a.z0.f();
                                MetaData author = this.a.x0.k1().N().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d5);
                                        this.a.T6();
                                    } else {
                                        this.a.O6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.S4();
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
    public class u2 implements l05.c {
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

        @Override // com.baidu.tieba.l05.c
        public void a(l05 l05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l05Var, i, view2) == null) {
                if (l05Var != null) {
                    l05Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.B2;
                if (postData != null) {
                    if (i == 0) {
                        postData.H0();
                        this.a.B2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.f6(pbFragment2.B2);
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
                pbFragment.showToast(pbFragment.x);
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
                if (!this.a.T5() || this.a.a == null || this.a.a.H1() == null || !str.equals(this.a.a.H1().getTopicId())) {
                    return;
                }
                this.a.f7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements l05.c {
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

        @Override // com.baidu.tieba.l05.c
        public void a(l05 l05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l05Var, i, view2) == null) {
                if (l05Var != null) {
                    l05Var.e();
                }
                if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                    if (i == 0) {
                        if (this.a.m1 != null) {
                            ne5.a aVar = new ne5.a();
                            aVar.a = this.a.k1;
                            String str = "";
                            if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.m1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.T4();
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
                        if (this.a.i1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.i1 = new wd8(pbFragment.getPageContext());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cy4)) {
                cy4 cy4Var = (cy4) customResponsedMessage.getData();
                vy4.a aVar = new vy4.a();
                int i = cy4Var.a;
                String str = cy4Var.b;
                aVar.a = cy4Var.d;
                u98 k1 = this.a.x0.k1();
                if (k1 == null) {
                    return;
                }
                if (this.a.x0.M0() != null && this.a.x0.M0().getUserIdLong() == cy4Var.p) {
                    this.a.F0.D2(cy4Var.l, this.a.x0.k1());
                }
                if (k1.G() != null && k1.G().size() >= 1 && k1.G().get(0) != null) {
                    long g = dh.g(k1.G().get(0).O(), 0L);
                    long g2 = dh.g(this.a.x0.D1(), 0L);
                    if (g == cy4Var.n && g2 == cy4Var.m) {
                        vy4 M = k1.G().get(0).M();
                        if (M == null) {
                            M = new vy4();
                        }
                        ArrayList<vy4.a> a = M.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        M.e(M.b() + cy4Var.l);
                        M.d(a);
                        k1.G().get(0).N0(M);
                        this.a.F0.G0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof n89) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                n89 n89Var = (n89) customResponsedMessage.getData();
                this.a.F0.u1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = n89Var.a;
                boolean z = false;
                if (n89Var.c == 0 && dataRes != null) {
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
                        this.a.F0.s2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.Q6(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                j05Var.dismiss();
                this.b.B0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.x0.getForumId(), "0");
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.x0 == null || this.a.x0.t1() == i + 1) {
                return;
            }
            this.a.C6(qd8.p(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hu5)) {
                hu5 hu5Var = (hu5) customResponsedMessage.getData();
                u98 k1 = this.a.x0.k1();
                if (k1 == null) {
                    return;
                }
                if (this.a.x0.k1() != null && this.a.x0.k1().W().r() != null && this.a.x0.k1().W().r().getPortrait() != null && this.a.x0.k1().W().r().getPortrait().equals(hu5Var.a)) {
                    if (this.a.x0.k1().W().r().getUserWorldCupData() != null) {
                        this.a.x0.k1().W().r().getUserWorldCupData().d(hu5Var.b);
                    }
                    this.a.F0.E2(this.a.x0.k1(), this.a.F0.k1());
                }
                if (k1.G() != null && k1.G().size() >= 0) {
                    Iterator<PostData> it = k1.G().iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(hu5Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(hu5Var.b);
                        }
                    }
                    this.a.F0.G0().Z();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.F0.J1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.j5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements kd5 {
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

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ud8 ud8Var = this.a.J0;
                if (ud8Var != null && ud8Var.e() != null && this.a.J0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.J0.e().c());
                    if (this.a.U0 != null && (this.a.U0.x() || this.a.U0.z())) {
                        this.a.U0.w(false, this.a.J0.h());
                    }
                    this.a.J0.a(true);
                    return true;
                } else if (this.a.Z4(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x2 implements u05.d {
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

        @Override // com.baidu.tieba.u05.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.L0 != null) {
                this.a.L0.q(jf8.h(this.a.B2));
                ArrayList arrayList = new ArrayList();
                for (t05 t05Var : this.a.L0.g()) {
                    if (t05Var instanceof q05) {
                        arrayList.add((q05) t05Var);
                    }
                }
                jf8.f(arrayList);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && this.a.x0.k1() != null) {
                this.a.x0.k1().a();
                this.a.x0.O1();
                if (this.a.F0.G0() != null) {
                    this.a.F0.I1(this.a.x0.k1());
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
            w09 w09Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w09) && (w09Var = (w09) customResponsedMessage.getData()) != null && (agreeData = w09Var.b) != null) {
                if (this.a.F0 != null) {
                    this.a.F0.Z1(w09Var);
                }
                if (agreeData.agreeType == 2 && this.a.F0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !lf8.h(this.a.x0.b)) {
                    this.a.F0.U3();
                    lf8.b(this.a.x0.b);
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
            ArrayList<PostData> G;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.x0 != null && this.a.x0.k1() != null && this.a.F0 != null && this.a.F0.G0() != null) {
                this.a.F0.l2(absListView, i, i2);
                if (this.a.e != null) {
                    this.a.e.q(i);
                }
                if (this.a.x0.X1() && (G = this.a.x0.k1().G()) != null && !G.isEmpty()) {
                    int w = ((i + i2) - this.a.F0.G0().w()) - 1;
                    u98 k1 = this.a.x0.k1();
                    if (k1 == null) {
                        return;
                    }
                    if (k1.D() != null && k1.D().o1()) {
                        w--;
                    }
                    if (k1.E() != null && k1.E().o1()) {
                        w--;
                    }
                    int size = G.size();
                    if (w < 0 || w >= size) {
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (!qd8.A(this.a.c1) && qd8.A(i)) {
                    if (this.a.F0 != null) {
                        this.a.j0 = true;
                        this.a.F0.t0();
                        if (this.a.U0 != null && !this.a.F0.J1()) {
                            this.a.F0.R2(this.a.U0.y());
                        }
                        if (!this.a.I) {
                            this.a.j0 = true;
                            this.a.F0.K2();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.F0 != null) {
                    this.a.F0.m2(i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new lk5();
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
                this.a.c1 = i;
                if (i == 0) {
                    iz8.g().h(this.a.getUniqueId(), true);
                    this.a.V4(true);
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
                return pbFragment.c5(view2);
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
            f19 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && this.a.x0.k1() != null) {
                String str = (String) customResponsedMessage.getData();
                f19 f19Var = null;
                if (!TextUtils.isEmpty(str) && this.a.x0.k1().G() != null) {
                    ArrayList<PostData> G = this.a.x0.k1().G();
                    Iterator<PostData> it = G.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (next instanceof f19) {
                            f19 f19Var2 = (f19) next;
                            if (str.equals(f19Var2.p1())) {
                                f19Var = f19Var2;
                                break;
                            }
                        }
                    }
                    if (f19Var != null) {
                        G.remove(f19Var);
                    }
                }
                if (this.a.F0.G0() != null && !ListUtils.isEmpty(this.a.F0.G0().t())) {
                    ArrayList<Cdo> t = this.a.F0.G0().t();
                    if (f19Var != null) {
                        i = f19Var;
                    } else {
                        i = qd8.i(this.a.x0.k1(), str);
                    }
                    qd8.e(t, i);
                }
                if (this.a.F0.W0() != null && !ListUtils.isEmpty(this.a.F0.W0().getData())) {
                    List<Cdo> data = this.a.F0.W0().getData();
                    if (f19Var == null) {
                        f19Var = qd8.i(this.a.x0.k1(), str);
                    }
                    qd8.e(data, f19Var);
                }
                this.a.e5(str);
                this.a.x0.O1();
                if (this.a.F0.G0() != null) {
                    this.a.F0.G0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E5() != null) {
                this.a.E5().i2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<ea5> {
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
        public int compare(ea5 ea5Var, ea5 ea5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ea5Var, ea5Var2)) == null) {
                return ea5Var.compareTo(ea5Var2);
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
        Q2 = new b1();
        R2 = new b();
    }

    public static PbFragment h6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65653, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public int A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.M2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<TiebaPlusRecommendCard> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.C == null) {
                this.C = new ug<>(new o2(this), 5, 0);
            }
            return this.C;
        }
        return (ug) invokeV.objValue;
    }

    public od5 B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.U0;
        }
        return (od5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            rd8 rd8Var = this.F0;
            if (rd8Var == null) {
                return 0;
            }
            return rd8Var.j1();
        }
        return invokeV.intValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public te8 C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (te8) invokeV.objValue;
    }

    public gf8 D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.t0;
        }
        return (gf8) invokeV.objValue;
    }

    public rd8 E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.F0;
        }
        return (rd8) invokeV.objValue;
    }

    public se8 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.F0();
        }
        return (se8) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ug<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (ug) invokeV.objValue;
    }

    public String G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg8
    public PbModel.h H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.o2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg8
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.x0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg8
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void O5() {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (rd8Var = this.F0) != null) {
            rd8Var.s1();
            N5();
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<RelativeLayout> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new q2(this), 10, 0);
            this.E = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new n0(this));
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<FestivalTipView> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.G == null) {
                this.G = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.G;
        }
        return (ug) invokeV.objValue;
    }

    public boolean S5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.P0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void S6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && n95.g(TbadkCoreApplication.getInst(), 0) && !this.F0.v2()) {
            this.i0 = n95.k(getPageContext(), "reply_pb", 0L);
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<ImageView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.A == null) {
                this.A = new ug<>(new m2(this), 8, 0);
            }
            return this.A;
        }
        return (ug) invokeV.objValue;
    }

    public final boolean T5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.H1() != null && this.a.H1().j1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<View> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.B == null) {
                this.B = new ug<>(new p2(this), 8, 0);
            }
            return this.B;
        }
        return (ug) invokeV.objValue;
    }

    public boolean V5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.N0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (ug) invokeV.objValue;
    }

    public final void b6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            u98 k12 = this.x0.k1();
            this.x0.Y2(true);
            au4 au4Var = this.z0;
            if (au4Var != null) {
                k12.I0(au4Var.g());
            }
            this.F0.I1(k12);
        }
    }

    public final void b7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public void c6() {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048666, this) != null) || (rd8Var = this.F0) == null) {
            return;
        }
        rd8Var.W1();
    }

    public final void c7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.T1();
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<ItemCardView> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            if (this.F == null) {
                this.F = new ug<>(new r2(this), 10, 0);
            }
            return this.F;
        }
        return (ug) invokeV.objValue;
    }

    public void m6() {
        m95 m95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (m95Var = this.i0) != null) {
            m95Var.q();
        }
    }

    public AntiData n5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null) {
                return this.x0.k1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
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
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            w6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public PostData p5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            u98 u98Var = this.x0.G;
            if (u98Var != null) {
                return u98Var.W();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public String q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public boolean r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            m95 m95Var = this.i0;
            if (m95Var != null && m95Var.t()) {
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
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && (pbModel = this.x0) != null && !dj.isEmpty(pbModel.D1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public PbInterviewStatusView.f u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return this.v0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            if (this.K == null) {
                this.K = new ug<>(new n2(this), 20, 0);
            }
            return this.K;
        }
        return (ug) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.b2();
        }
        return invokeV.booleanValue;
    }

    public boolean v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            if (!this.c && this.M2 == -1 && this.N2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.l2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void w6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            hideNetRefreshView(this.F0.o1());
            R6();
            if (this.x0.j2()) {
                this.F0.m3();
            }
            this.F0.v3();
        }
    }

    public boolean x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            if (this.D == null) {
                this.D = new ug<>(new c3(this), 15, 0);
            }
            return this.D;
        }
        return (ug) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bt5
    /* renamed from: y5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            rd8 rd8Var = this.F0;
            if (rd8Var == null) {
                return null;
            }
            return rd8Var.W0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void y6() {
        m95 m95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048752, this) == null) && (m95Var = this.i0) != null) {
            m95Var.x();
        }
    }

    public int z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.N2;
        }
        return invokeV.intValue;
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
        this.s0 = new u(this);
        this.v0 = new f0(this);
        this.w0 = new Handler(new q0(this));
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
        this.Z0 = new m1(this);
        this.a1 = new x1(this);
        this.b1 = new i2(this);
        this.c1 = 0;
        this.n1 = false;
        this.o1 = 0;
        this.p1 = -1;
        this.r1 = 0;
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
        this.H1 = new x(this, 2921787);
        this.I1 = new y(this, 2016488);
        this.J1 = new z(this, 2016331);
        this.K1 = new a0(this, 2921746);
        this.L1 = new b0(this);
        this.M1 = new c0(this, 2010045);
        this.N1 = new d0(this);
        this.O1 = new PraiseModel(getPageContext(), new e0(this));
        this.P1 = new g0(this);
        this.Q1 = new i0(this, 2001115);
        this.R1 = new j0(this);
        this.S1 = new k0(this);
        this.U1 = new ua8(new p0(this));
        this.V1 = new s0(this);
        this.W1 = new t0(this, 2001427);
        this.X1 = new u0(this, 2001428);
        this.Y1 = new v0(this, 2921634);
        this.Z1 = new w0(this, 2001426);
        this.a2 = new x0(this, 2004021);
        this.b2 = new y0(this, 2016528);
        this.c2 = new z0(this, 2921724);
        this.d2 = new a1(this, 2921033);
        this.e2 = new c1(this);
        this.f2 = new d1(this);
        this.g2 = new e1(this);
        this.h2 = new i1(this);
        this.i2 = new l1(this);
        this.j2 = new n1(this, 2921480);
        this.k2 = new o1(this);
        this.l2 = Boolean.FALSE;
        this.m2 = new p1(this);
        this.n2 = new q1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.o2 = new r1(this);
        this.p2 = new s1(this, 2016450);
        this.q2 = new t1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.r2 = new u1(this);
        this.s2 = new y1(this);
        this.t2 = new b2(this);
        this.u2 = new d2(this);
        this.v2 = new e2(this);
        this.x2 = new f2(this);
        this.y2 = 0;
        this.z2 = new s2(this);
        this.A2 = false;
        this.B2 = null;
        this.C2 = new u2(this);
        this.D2 = new v2(this);
        this.E2 = new w2(this);
        this.F2 = new y2(this);
        this.G2 = new z2(this);
        this.H2 = new a3(this);
        this.I2 = new b3(this);
        this.J2 = new d3(this);
        this.K2 = new a(this);
        this.L2 = new c(this);
        this.M2 = -1;
        this.N2 = -1;
    }

    public final void C6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i3) == null) && this.x0 != null) {
            R6();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.x0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void D6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z3) == null) {
            this.l2 = Boolean.valueOf(z3);
        }
    }

    public void E6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z3) == null) {
            this.r0 = z3;
        }
    }

    public void F6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z3) == null) {
            this.M = z3;
        }
    }

    public void I6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z3) == null) {
            this.J = z3;
        }
    }

    public final void J6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z3) == null) {
            this.U0.X(z3);
            this.U0.a0(z3);
            this.U0.i0(z3);
        }
    }

    public final void M5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, intent) == null) {
            lf8.g(this, intent);
        }
    }

    public void Q4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, f3Var) == null) && f3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(f3Var)) {
                this.q1.add(f3Var);
            }
        }
    }

    public void R4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, f3Var) == null) && f3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(f3Var)) {
                this.q1.add(0, f3Var);
            }
        }
    }

    public final void V6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i3) == null) {
            lf8.j(this, o5(), i3);
        }
    }

    public final void W5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void e6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            f6(postData);
        }
    }

    @Override // com.baidu.tieba.zg8.b
    public void h1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z3) == null) {
            this.O0 = z3;
        }
    }

    public final void i7(nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048689, this, nx4Var) == null) && nx4Var != null) {
            this.P2 = nx4Var;
            this.c = true;
            this.F0.I2();
            this.F0.a3(this.O2);
        }
    }

    public boolean j6(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, keyEvent)) == null) {
            if (keyEvent == null || this.F0 == null) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.j05.e
    public void onClick(j05 j05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, j05Var) == null) {
            h5(j05Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ca
    public void onPreLoad(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, hoVar) == null) {
            PreLoadImageHelper.load(hoVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(hoVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.x0.E2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.U0.F(bundle);
        }
    }

    public void x6(f3 f3Var) {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048749, this, f3Var) == null) && f3Var != null && (list = this.q1) != null) {
            list.remove(f3Var);
        }
    }

    @Override // com.baidu.tieba.bt5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.bt5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            xd8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    public final void P5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048619, this, i3, i4) == null) {
            op5.b(new i(this, i4), new j(this, i4, i3));
        }
    }

    @Override // com.baidu.tieba.bt5
    public void g0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048679, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (ys5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ys5.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (xd8.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new nq5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.bt5
    public void W(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048643, this, context, str, z3) == null) {
            if (xd8.c(str) && (pbModel = this.x0) != null && pbModel.D1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.x0.D1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    wa5 wa5Var = new wa5();
                    wa5Var.a = str;
                    wa5Var.b = 3;
                    wa5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wa5Var));
                }
            } else {
                xd8.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public final void A6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pbModel = this.x0) != null && pbModel.k1() != null && this.x0.k1().N() != null && this.x0.k1().N().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void B6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (pbModel = this.x0) != null && pbModel.k1() != null && this.x0.k1().N() != null && this.x0.k1().N().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void N5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            ej.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean N6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || !pbModel.C1()) {
                return false;
            }
            if (this.x0.i1() != null && this.x0.i1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && n95.g(TbadkCoreApplication.getInst(), 0) && !this.F0.v2()) {
            this.i0 = n95.k(getPageContext(), "collect", 0L);
        }
    }

    public final boolean U5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            PostData c4 = v98.c(this.x0.k1(), this.x0.C1());
            if (c4 != null && c4.r() != null && c4.r().getGodUserData() != null && c4.r().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (pbModel = this.x0) != null && !dj.isEmpty(pbModel.D1())) {
            cr4.w().P(br4.Z, dh.g(this.x0.D1(), 0L));
        }
    }

    public void i6() {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048688, this) == null) && (list = this.q1) != null && !list.isEmpty()) {
            int size = this.q1.size();
            while (true) {
                size--;
                if (size <= -1 || this.q1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.F0.t0();
            if (this.h) {
                return;
            }
            b7();
            this.F0.m3();
            if (this.x0.loadData()) {
                this.F0.R3();
            }
        }
    }

    public final int o5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (this.x0.k1() != null && this.x0.k1().N() != null) {
                return this.x0.k1().N().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.D0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.D0 = pollingModel;
                pollingModel.x0(e15.e);
            }
            this.D0.n0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            gh.a().postDelayed(this.V1, 10000L);
        }
    }

    public final void P6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            j05 j05Var = new j05(getPageContext().getPageActivity());
            j05Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            j05Var.setPositiveButton(R.string.open_now, new d(this));
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new e(this));
            j05Var.create(this.e1).show();
        }
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            showLoadingView(this.F0.o1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bc));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.F0.n1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.l1 != null) {
                ne5.b bVar = new ne5.b();
                bVar.a = this.l1.J();
                bVar.b = this.l1.H();
                bVar.c = String.valueOf(this.l1.K());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.k1));
        }
    }

    public final boolean W4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.k1() == null) {
                return false;
            }
            ThreadData N = this.x0.k1().N();
            AntiData c4 = this.x0.k1().c();
            if (!AntiHelper.b(getPageContext(), N) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void X5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && this.P2 != null) {
            if (this.N2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e9e);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.P2.a(), this.N2, 0)));
                this.a.finish();
            }
        }
    }

    public boolean Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if ((this.x0.k1() != null && (this.x0.k1().i0() || ThreadCardUtils.isSelf(this.x0.k1().N()))) || this.W0 == null || this.x0.k1() == null || this.x0.k1().c() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeInvokeEditor(this.x0.k1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            PbModel H1 = this.a.H1();
            this.x0 = H1;
            if (H1 != null) {
                if (H1.F0() != null) {
                    this.x0.F0().c(this.L2);
                }
                if (this.x0.g1() != null) {
                    this.x0.g1().f(this.u1);
                }
                if (StringUtils.isNull(this.x0.D1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.L) && this.L != null) {
                    this.x0.P2(6);
                }
            }
        }
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && this.P2 != null) {
            if (this.M2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e9f);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.P2.a(), this.M2, 0)));
                this.a.finish();
            }
        }
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            if (this.x0.P0() || this.x0.S0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.x0.D1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.x0.D1()));
            if (d7()) {
                this.a.finish();
            }
        }
    }

    public final void e7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048674, this) == null) && (absPbActivity = this.a) != null && absPbActivity.H1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.H1().D1()).param("topic_id", this.a.H1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.H1().H1()));
        }
    }

    public final void h7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(this.x0.getForumId()) && this.x0.k1() != null && this.x0.k1().k() != null) {
            boolean z3 = true;
            if (this.x0.k1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.x0.y0().K(this.x0.getForumId(), this.x0.D1());
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            au4 c4 = au4.c(this.a);
            this.z0 = c4;
            if (c4 != null) {
                c4.j(this.r2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.A0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.t2);
            this.B0 = new p85(getPageContext());
            F5();
            this.O1.setUniqueId(getUniqueId());
            this.O1.registerListener();
        }
    }

    public final void G6(qd5 qd5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, qd5Var) == null) && qd5Var != null && (pbModel = this.x0) != null) {
            qd5Var.p(pbModel.J0());
            if (this.x0.k1() != null && this.x0.k1().k() != null) {
                qd5Var.o(this.x0.k1().k());
            }
            qd5Var.q("pb");
            qd5Var.r(this.x0);
        }
    }

    public final void H6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048600, this, i3) != null) || (pbModel = this.x0) == null) {
            return;
        }
        int t12 = pbModel.t1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.x0.S2(1);
                } else {
                    this.x0.S2(4);
                }
            } else {
                this.x0.S2(3);
            }
        } else {
            this.x0.S2(2);
        }
        int t13 = this.x0.t1();
        if (t12 == 4 || t13 == 4) {
            k6();
        }
    }

    public void X4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.F0.H3();
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

    public boolean Z4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i3)) == null) {
            if (this.W0 != null && this.x0.k1() != null && !ThreadCardUtils.isSelf(this.x0.k1().N()) && this.x0.k1().c() != null) {
                return this.W0.checkPrivacyBeforeSend(this.x0.k1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void f7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048677, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.H1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.H1().D1()).param("topic_id", this.a.H1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.H1().H1()));
        }
    }

    public void n6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048703, this, animatorListener) == null) && this.F0 != null && (pbModel = this.x0) != null && pbModel.k1() != null && this.x0.k1().R() != null && checkUpIsLogin() && this.F0.G0() != null && this.F0.G0().z() != null) {
            this.F0.G0().z().F(animatorListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09070d));
            u98 c4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).c();
            if (c4 != null) {
                this.o2.c(true, 0, 3, 0, c4, "", 1);
            }
            this.a.J1().d(this.s0);
        }
    }

    public void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.x0.k1() != null && this.x0.k1().N() != null && this.x0.k1().N().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.x0.k1().N().getTaskInfoData().i(), this.x0.k1().N().getTaskInfoData().g(), this.x0.k1().N().getTaskInfoData().b(), this.x0.k1().N().getTaskInfoData().c(), this.x0.k1().N().getIs_top(), this.x0.k1().N().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final boolean d7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.k1() != null && this.x0.k1().i0()) {
                return true;
            }
            if (this.x0.V0()) {
                MarkData G0 = this.x0.G0();
                if (G0 != null && this.x0.T0()) {
                    MarkData B0 = this.x0.B0(this.F0.N0());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", G0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(G0.getPostId())) {
                        j05 j05Var = new j05(getPageContext().getPageActivity());
                        j05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0459, new j2(this, B0, G0, j05Var));
                        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new k2(this, G0, j05Var));
                        j05Var.setOnCalcelListener(new l2(this, G0, j05Var));
                        j05Var.create(getPageContext());
                        j05Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", G0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.x0.k1() != null && this.x0.k1().G() != null && this.x0.k1().G().size() > 0 && this.x0.T0()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null) {
                f19 z3 = this.x0.k1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.x0.k1().b();
                }
                if (this.x0.D0() != null) {
                    this.x0.q0();
                }
                this.x0.O1();
            }
            if (this.x0.k1().G() != null) {
                Iterator<PostData> it = this.x0.k1().G().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof f19) {
                        it.remove();
                    }
                }
            }
            if (this.F0.G0() != null && !ListUtils.isEmpty(this.F0.G0().t())) {
                qd8.d(this.F0.G0().t());
            }
            if (this.F0.W0() != null && !ListUtils.isEmpty(this.F0.W0().getData())) {
                qd8.d(this.F0.W0().getData());
            }
            if (this.F0.G0() != null) {
                this.F0.G0().Z();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.f = false;
            super.onResume();
            if (this.N) {
                this.N = false;
                H5();
            }
            if (U5()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            rd8 rd8Var = this.F0;
            if (rd8Var != null && rd8Var.o1() != null) {
                if (!this.g) {
                    R6();
                } else {
                    hideLoadingView(this.F0.o1());
                }
                this.F0.j2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            rd8 rd8Var2 = this.F0;
            if (rd8Var2 != null) {
                noNetworkView = rd8Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.B1);
            this.O0 = false;
            B6();
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Z1);
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.n1) {
                w6();
                this.n1 = false;
            }
            Y6();
            ItemCardHelper.w(this.H2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                eb5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.onStop();
            if (this.t > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.t;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.t = 0L;
            }
            if (E5().g1() != null) {
                E5().g1().n();
            }
            qf8 qf8Var = this.F0.h;
            if (qf8Var != null && !qf8Var.m()) {
                this.F0.h.p();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null && this.x0.k1().k() != null && this.x0.k1().N() != null) {
                bb5.j().x(getPageContext().getPageActivity(), "pb", this.x0.k1().k().getId(), dh.g(this.x0.k1().N().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            iz8.g().h(getUniqueId(), false);
        }
    }

    public final String r5() {
        InterceptResult invokeV;
        ArrayList<PostData> G;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.k1() == null || this.x0.k1().G() == null || (count = ListUtils.getCount((G = this.x0.k1().G()))) == 0) {
                return "";
            }
            if (this.x0.v1()) {
                Iterator<PostData> it = G.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        return next.O();
                    }
                }
            }
            int N0 = this.F0.N0();
            PostData postData = (PostData) ListUtils.getItem(G, N0);
            if (postData != null && postData.r() != null) {
                if (this.x0.c2(postData.r().getUserId())) {
                    return postData.O();
                }
                for (int i3 = N0 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(G, i3);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (this.x0.c2(postData2.r().getUserId())) {
                        return postData2.O();
                    }
                }
                for (int i4 = N0 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(G, i4);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (this.x0.c2(postData3.r().getUserId())) {
                        return postData3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void I5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void W6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            if (str == null) {
                str = "";
            }
            x9 x9Var = this.e1;
            if (x9Var == null) {
                return;
            }
            j05 j05Var = new j05(x9Var.getPageActivity());
            j05Var.setMessage(str);
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a46, new f(this));
            j05Var.create(this.e1).show();
        }
    }

    public final void Z6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048656, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        a7(postData, false);
    }

    public final void g7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.x0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(jf8.n(i3))));
        }
    }

    public final void m5(Rect rect) {
        rd8 rd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, rect) == null) && rect != null && (rd8Var = this.F0) != null && rd8Var.n1() != null && rect.top <= this.F0.n1().getHeight()) {
            rect.top += this.F0.n1().getHeight() - rect.top;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.w) {
                return;
            }
            this.w = i3;
            if (i3 == 2) {
                this.I = true;
            } else {
                this.I = false;
            }
            rd8 rd8Var = this.F0;
            if (rd8Var != null) {
                rd8Var.b2(configuration);
            }
            s05 s05Var = this.K0;
            if (s05Var != null) {
                s05Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z3) == null) {
            super.onUserChanged(z3);
            this.F0.f4(z3);
            s05 s05Var = this.K0;
            if (s05Var != null) {
                s05Var.dismiss();
            }
            if (z3 && this.O0) {
                this.F0.n3();
                this.x0.f2(true);
            }
            if (this.F0.G0() != null) {
                this.F0.G0().d0(z3);
            }
        }
    }

    public final void s6(View view2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048733, this, view2) != null) || view2 == null) {
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

    public final void J5(int i3, Intent intent) {
        xb5 xb5Var;
        xb5 xb5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i3, intent) == null) {
            if (i3 == 0) {
                this.F0.s1();
                this.F0.g1().g();
                this.F0.z3(false);
            }
            this.F0.K2();
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
                    sd5 f4 = this.F0.g1().f();
                    f4.d0(this.x0.k1().N());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    wb5 p3 = f4.b().p(6);
                    if (p3 != null && (xb5Var2 = p3.m) != null) {
                        xb5Var2.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.U0.L();
            this.U0.m0(pbEditorData.getVoiceModel());
            this.U0.B(writeData);
            wb5 p4 = this.U0.b().p(6);
            if (p4 != null && (xb5Var = p4.m) != null) {
                xb5Var.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
            }
            this.U0.h0(pbEditorData.isShowCustomFigure());
            if (i3 == -1) {
                this.U0.G(null, null);
            }
        }
    }

    public final void L6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048609, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (E5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        q95.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            z88.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            z88.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            z88.e(getResources().getString(R.string.obfuscated_res_0x7f0f12d5));
                            return;
                        } else {
                            z88.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.x0.X0()) {
                antiData.setBlock_forum_name(this.x0.k1().k().getName());
                antiData.setBlock_forum_id(this.x0.k1().k().getId());
                antiData.setUser_name(this.x0.k1().U().getUserName());
                antiData.setUser_id(this.x0.k1().U().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void Q6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048623, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            s05 s05Var = this.K0;
            if (s05Var != null && s05Var.isShowing()) {
                this.K0.dismiss();
                this.K0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            u05 u05Var = new u05(getContext());
            u05Var.p(new h0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i3 == 1) {
                arrayList.add(new q05(0, getResources().getString(R.string.obfuscated_res_0x7f0f04d5), u05Var));
            }
            if (z3) {
                arrayList.add(new q05(1, getResources().getString(R.string.un_mute), u05Var));
            } else {
                arrayList.add(new q05(1, getResources().getString(R.string.obfuscated_res_0x7f0f0bdc), u05Var));
            }
            u05Var.k(arrayList);
            s05 s05Var2 = new s05(getPageContext(), u05Var);
            this.K0 = s05Var2;
            s05Var2.k();
        }
    }

    public final void a7(PostData postData, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048659, this, postData, z3) == null) {
            D6(false);
            if (postData == null || (pbModel = this.x0) == null || pbModel.k1() == null || postData.F() == 1) {
                return;
            }
            String D1 = this.x0.D1();
            String O = postData.O();
            if (this.x0.k1() != null) {
                i3 = this.x0.k1().V();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e q6 = q6(O);
            if (q6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo g02 = postData.g0();
            AntiData c4 = this.x0.k1().c();
            if (postData.r() != null) {
                arrayList = postData.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(D1, O, "pb", true, false, null, false, null, i3, g02, c4, false, arrayList, 5).addBigImageData(q6.a, q6.b, q6.g, q6.j);
            addBigImageData.setKeyPageStartFrom(this.x0.j1());
            addBigImageData.setFromFrsForumId(this.x0.getFromForumId());
            addBigImageData.setWorksInfoData(this.x0.I1());
            addBigImageData.setKeyFromForumId(this.x0.getForumId());
            addBigImageData.setBjhData(this.x0.C0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void g5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.A0.Z()) {
                    return;
                }
                this.F0.b4();
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
                    this.A0.b0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.A0.c0(this.x0.k1().k().getId(), this.x0.k1().k().getName(), this.x0.k1().N().getId(), str, intValue3, intValue2, booleanValue, this.x0.k1().N().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                PbModel pbModel = this.x0;
                if (pbModel != null && pbModel.F0() != null) {
                    this.x0.F0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void j5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048691, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            rd8 rd8Var = this.F0;
            if (rd8Var != null && this.x0 != null) {
                if ((rd8Var == null || rd8Var.J1()) && this.x0.k1() != null && this.x0.k1().R() != null) {
                    rd8 rd8Var2 = this.F0;
                    if (rd8Var2 != null && rd8Var2.M0() != null && this.F0.M0().t()) {
                        return;
                    }
                    ia8 R = this.x0.k1().R();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!R.f() || R.a() != 2) && this.F0.G0() != null && this.F0.G0().z() != null) {
                        this.F0.G0().z().v(this.x0.D1(), this.x0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        x88 x88Var = new x88(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.x0;
                        x88Var.m(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        x88Var.l(new o0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void K5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            X6(z3, userMuteAddAndDelCustomMessage, str5, str6);
        }
    }

    public final void K6(int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048607, this, i3, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new a2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                W6(str);
            } else {
                this.F0.a4(str);
            }
        }
    }

    public void h5(j05 j05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, j05Var, jSONArray) == null) {
            j05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(j05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                g5((SparseArray) j05Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText k7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048696, this, str, i3)) == null) {
            PbModel pbModel = this.x0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.k1() == null || str == null || i3 < 0) {
                return null;
            }
            u98 k12 = this.x0.k1();
            if (k12.i() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(k12.i());
                tbRichText = s5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> G = k12.G();
                U4(k12, G);
                return s5(G, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final void L5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null && this.x0.k1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.x0.D1(), str);
                ThreadData N = this.x0.k1().N();
                if (N.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (N.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (N.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                W5(format);
                return;
            }
            this.y0.a(str);
        }
    }

    public final void O6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, metaData) != null) || metaData == null) {
            return;
        }
        j05 j05Var = new j05(getActivity());
        j05Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b3e));
        j05Var.setTitleShowCenter(true);
        j05Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b3f));
        j05Var.setMessageShowCenter(true);
        j05Var.setCancelable(false);
        j05Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b40), new v1(this, metaData));
        j05Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b41), new w1(this, metaData));
        j05Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void U6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                M().t0(postWriteCallBackData.getPostId());
                int K0 = this.F0.K0();
                this.o1 = K0;
                this.x0.H2(K0, this.F0.Q0());
            }
            this.F0.t0();
            this.J0.c();
            od5 od5Var = this.U0;
            if (od5Var != null) {
                this.F0.R2(od5Var.y());
            }
            this.F0.s1();
            this.F0.z3(true);
            this.x0.O1();
        }
    }

    public final void e5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048672, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.x0) != null && pbModel.k1() != null) {
            f19 z3 = this.x0.k1().z();
            if (z3 != null && str.equals(z3.p1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.x0.k1().b();
            }
            f19 D0 = this.x0.D0();
            if (D0 != null && str.equals(D0.p1())) {
                this.x0.q0();
            }
        }
    }

    public void f6(PostData postData) {
        PostData p5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048676, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.O() != null && postData.O().equals(this.x0.f1())) {
            z3 = true;
        }
        MarkData e12 = this.x0.e1(postData);
        if (this.x0.k1() != null && this.x0.k1().i0() && (p5 = p5()) != null) {
            e12 = this.x0.e1(p5);
        }
        if (e12 == null) {
            return;
        }
        this.F0.m3();
        au4 au4Var = this.z0;
        if (au4Var != null) {
            au4Var.i(e12);
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
        od5 od5Var = this.U0;
        if (od5Var != null && od5Var.b() != null) {
            this.U0.b().y(i3);
        }
        if (this.F0.a() != null) {
            this.F0.a().d(getPageContext(), i3);
        }
        this.J0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.V = i3;
        b7();
        m95 m95Var = this.i0;
        if (m95Var != null) {
            m95Var.w();
        }
    }

    public void t6(ja8 ja8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, ja8Var) == null) {
            String O = ja8Var.i().O();
            List<PostData> list = this.x0.k1().S().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.O() != null && postData.O().equals(O)) {
                    ArrayList<PostData> k3 = ja8Var.k();
                    postData.c1(ja8Var.m());
                    if (postData.d0() != null) {
                        postData.d0().clear();
                        postData.d0().addAll(k3);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.x0.T0()) {
                this.F0.I1(this.x0.k1());
            }
        }
    }

    public final void M6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            jf8.e(getActivity(), getPageContext(), new f1(this, sparseArray, i3, z3), new g1(this));
        }
    }

    public final void R5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048626, this) != null) || this.k != null) {
            return;
        }
        this.k = new l05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        l05 l05Var = this.k;
        l05Var.j(strArr, new r0(this));
        l05Var.g(l05.b.a);
        l05Var.h(17);
        l05Var.c(getPageContext());
    }

    public final void S4() {
        PbModel pbModel;
        u98 u98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (pbModel = this.x0) != null && (u98Var = pbModel.G) != null && u98Var.N() != null) {
            ThreadData N = this.x0.G.N();
            N.mRecomAbTag = this.x0.p1();
            N.mRecomWeight = this.x0.s1();
            N.mRecomSource = this.x0.r1();
            N.mRecomExtra = this.x0.q1();
            N.isSubPb = this.x0.X0();
            if (N.getFid() == 0) {
                N.setFid(dh.g(this.x0.getForumId(), 0L));
            }
            StatisticItem i3 = uj5.i(getContext(), N, "c13562");
            TbPageTag l3 = uj5.l(getContext());
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

    public final void d6() {
        MarkData B0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && this.z0 != null) {
            if (this.x0.k1() != null && this.x0.k1().i0()) {
                B0 = this.x0.B0(0);
            } else {
                B0 = this.x0.B0(this.F0.V0());
            }
            if (B0 == null) {
                return;
            }
            if (B0.isApp() && (B0 = this.x0.B0(this.F0.V0() + 1)) == null) {
                return;
            }
            this.F0.m3();
            this.z0.i(B0);
            if (!this.z0.e()) {
                if (this.F0 != null && this.x0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !lf8.h(this.x0.b)) {
                    this.F0.U3();
                    lf8.b(this.x0.b);
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
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            this.f = true;
            super.onPause();
            kf8.a();
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
            rd8 rd8Var = this.F0;
            if (rd8Var != null) {
                rd8Var.g2();
            }
            if (!this.x0.X0()) {
                this.U0.N(this.x0.D1());
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.l2();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            cr4.w().E();
            MessageManager.getInstance().unRegisterListener(this.B1);
            A6();
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            m95 m95Var = this.i0;
            if (m95Var != null) {
                m95Var.q();
                this.i0.p();
            }
        }
    }

    public final void U4(u98 u98Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048636, this, u98Var, arrayList) == null) && u98Var != null && u98Var.S() != null && u98Var.S().a != null && (list = u98Var.S().a) != null && arrayList != null) {
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

    public final void l5(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048698, this, i3, gVar) != null) || gVar == null) {
            return;
        }
        this.F0.C0(gVar.a, gVar.b, false);
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
                this.x0.k1().N().setIs_good(1);
                this.x0.L2(1);
            } else if (i3 == 3) {
                this.x0.k1().N().setIs_good(0);
                this.x0.L2(0);
            } else if (i3 == 4) {
                this.x0.k1().N().setIs_top(1);
                this.x0.M2(1);
            } else if (i3 == 5) {
                this.x0.k1().N().setIs_top(0);
                this.x0.M2(0);
            }
            this.F0.j4(this.x0.k1(), this.x0.C1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        ej.Q(getPageContext().getPageActivity(), string);
    }

    public void V4(boolean z3) {
        rd8 rd8Var;
        int i3;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048640, this, z3) == null) && (rd8Var = this.F0) != null && rd8Var.W0() != null) {
            int firstVisiblePosition = this.F0.W0().getFirstVisiblePosition();
            int lastVisiblePosition = this.F0.W0().getLastVisiblePosition();
            dc8 G0 = this.F0.G0();
            if (G0 != null && this.x0.k1() != null) {
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
                        if (this.F0.W0().G(i3) != null && (this.F0.W0().G(i3) instanceof PostData) && (postData = (PostData) this.F0.W0().G(i3)) != null) {
                            PostData postData2 = (PostData) ListUtils.getItem(this.x0.k1().G(), postData.F() - 1);
                            if (postData.o() == null && postData2 != null) {
                                postData.F0(postData2.o());
                            }
                            if (postData.o() != null) {
                                postData.o().q(postData.F());
                                arrayList.add(postData.o());
                            }
                        }
                        i3++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new z1(this));
                    ea5 ea5Var = (ea5) ListUtils.getItem(arrayList, 0);
                    if (ea5Var != null && ea5Var.e() == 1) {
                        if (!z3) {
                            this.F0.w2(ea5Var, 0);
                            return;
                        }
                        return;
                    }
                    this.F0.w2(ea5Var, 1);
                }
            }
        }
    }

    public final boolean g6(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, postData)) == null) {
            if (postData == null) {
                return false;
            }
            String O = postData.O();
            if (StringUtils.isNull(O) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s3 = p35.m().s("bubble_link", "");
            if (StringUtils.isNull(s3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = postData.i0().getJumpUrl();
            int packageId = postData.i0().getPackageId();
            int propsId = postData.i0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.p(getPageContext().getPageActivity(), j29.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                BrowserHelper.t(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s3 + "?props_id=" + O, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void j7(int i3) {
        PbModel pbModel;
        ThreadData N;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048693, this, i3) != null) || (pbModel = this.x0) == null || pbModel.k1() == null || (N = this.x0.k1().N()) == null) {
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
        if (this.x0.C1()) {
            this.F0.G0().Z();
        } else {
            this.F0.m4(this.x0.k1());
        }
    }

    public final AbsPbActivity.e q6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048729, this, str)) == null) {
            String str2 = null;
            if (this.x0.k1() != null && this.x0.k1().G() != null && this.x0.k1().G().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.x0.k1().G().size()) {
                        if (str.equals(this.x0.k1().G().get(i3).O())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                PostData postData = this.x0.k1().G().get(i3);
                if (postData.Z() != null && postData.Z().I() != null) {
                    Iterator<TbRichTextData> it = postData.Z().I().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.O() != null) {
                                str2 = next.O().H();
                            }
                        }
                    }
                    o6(str2, 0, eVar);
                    v98.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void v6(ja8 ja8Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048745, this, ja8Var) != null) || ja8Var.i() == null) {
            return;
        }
        String O = ja8Var.i().O();
        ArrayList<PostData> G = this.x0.k1().G();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= G.size()) {
                break;
            }
            PostData postData = G.get(i3);
            if (postData.O() != null && postData.O().equals(O)) {
                ArrayList<PostData> k3 = ja8Var.k();
                postData.c1(ja8Var.m());
                if (postData.d0() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.l0() != null && next != null && next.r() != null && (metaData = postData.l0().get(next.r().getUserId())) != null) {
                            next.G0(metaData);
                            next.S0(true);
                            next.l1(getPageContext(), this.x0.c2(metaData.getUserId()));
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
                if (postData.z() != null) {
                    postData.E0();
                }
            } else {
                i3++;
            }
        }
        if (!this.x0.T0() && z3) {
            this.F0.I1(this.x0.k1());
        }
        if (z3) {
            t6(ja8Var);
        }
    }

    public final void X6(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2}) == null) {
            if (z3) {
                this.F0.H3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            j05 j05Var = new j05(this.e1.getPageActivity());
            if (!dj.isEmpty(str)) {
                j05Var.setMessage(str);
            } else {
                j05Var.setMessage(this.e1.getResources().getString(R.string.block_mute_message_alert, str2));
            }
            j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0459, new g(this, userMuteAddAndDelCustomMessage));
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new h(this));
            j05Var.create(this.e1).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a5(AgreeData agreeData) {
        pj5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048657, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new l35();
        }
        if (this.h0 == null) {
            w09 w09Var = new w09();
            this.h0 = w09Var;
            w09Var.a = getUniqueId();
        }
        yw4 yw4Var = new yw4();
        yw4Var.b = 5;
        yw4Var.h = 8;
        yw4Var.g = 2;
        if (M() != null) {
            yw4Var.f = M().j1();
        }
        yw4Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                yw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i3, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.x0;
                if (pbModel == null && pbModel.k1() != null) {
                    this.d0.b(N(), yw4Var, agreeData, this.x0.k1().N());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            yw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            yw4Var.i = 1;
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

    public final void a6(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048658, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (W4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!Y4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.X);
                        this.Y = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (E5().g1() != null && postData != null) {
                        if (postData.Z() != null) {
                            str3 = postData.Z().toString();
                        } else {
                            str3 = "";
                        }
                        E5().g1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.r().getName_show(), str3));
                    }
                    if (this.x0.k1() != null && this.x0.k1().i0()) {
                        gh.a().postDelayed(new j1(this, str, str2), 0L);
                        return;
                    }
                    if (this.Y0 == null) {
                        y17 y17Var = new y17(getPageContext());
                        this.Y0 = y17Var;
                        y17Var.j(1);
                        this.Y0.i(new k1(this, str, str2));
                    }
                    PbModel pbModel = this.x0;
                    if (pbModel != null && pbModel.k1() != null && this.x0.k1().k() != null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.Y0.g(this.x0.k1().k().getId(), dh.g(this.x0.D1(), 0L));
                        return;
                    }
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    @Override // com.baidu.tieba.bt5
    public void c0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048663, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.M0 = str;
            if (this.k == null) {
                R5();
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

    public final boolean c5(View view2) {
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
        List<q05> c4;
        int i3;
        boolean z20;
        q05 q05Var;
        q05 q05Var2;
        q05 q05Var3;
        q05 q05Var4;
        q05 q05Var5;
        q05 q05Var6;
        on onVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            rd8 rd8Var = this.F0;
            if (rd8Var != null) {
                if (rd8Var.L1()) {
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
                if (qd8.x(view2)) {
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
                        this.F0.M3(this.D2, this.j1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.B2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.F() == 1 && qd8.x(view2)) {
                this.F0.M3(this.D2, this.j1.t());
                return true;
            }
            au4 au4Var = this.z0;
            if (au4Var == null) {
                return true;
            }
            if (au4Var.e() && this.B2.O() != null && this.B2.O().equals(this.x0.f1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (M().k1() != null && M().k1().i0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (M().k1() != null && M().k1().n0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (M().k1() != null && M().k1().m0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.B2.F() == 1) {
                if (!z4) {
                    this.F0.N3(this.C2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.L0 == null) {
                u05 u05Var = new u05(getContext());
                this.L0 = u05Var;
                u05Var.p(this.g2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (qd8.x(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (qd8.x(view2) && (onVar = this.j1) != null && !onVar.t()) {
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
                    arrayList.add(new q05(1, getString(R.string.save_to_emotion), this.L0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new q05(2, getString(R.string.save_to_local), this.L0));
                }
                if (!z7 && !z8) {
                    q05 q05Var7 = new q05(3, getString(R.string.obfuscated_res_0x7f0f0475), this.L0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.B2);
                    q05Var7.d.setTag(sparseArray3);
                    arrayList.add(q05Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        q05Var6 = new q05(4, getString(R.string.remove_mark), this.L0);
                    } else {
                        q05Var6 = new q05(4, getString(R.string.obfuscated_res_0x7f0f0b3c), this.L0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.B2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    q05Var6.d.setTag(sparseArray4);
                    arrayList.add(q05Var6);
                }
                if (this.mIsLogin) {
                    if (!jf8.j(this.x0) && !z12 && z11) {
                        q05 q05Var8 = new q05(5, getString(R.string.obfuscated_res_0x7f0f0be0), this.L0);
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
                        q05Var8.d.setTag(sparseArray5);
                        arrayList.add(q05Var8);
                    } else {
                        if (qd8.B(this.x0.k1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            q05 q05Var9 = new q05(5, getString(R.string.report_text), this.L0);
                            q05Var9.d.setTag(str);
                            arrayList.add(q05Var9);
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
                        if (!jf8.j(this.x0) && z18) {
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
                                q05Var5 = new q05(6, getString(R.string.obfuscated_res_0x7f0f04d5), this.L0);
                                q05Var5.d.setTag(sparseArray6);
                                q05Var2 = new q05(7, getString(R.string.obfuscated_res_0x7f0f02f1), this.L0);
                                q05Var2.d.setTag(sparseArray6);
                                q05Var3 = q05Var5;
                                q05Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        q05Var5 = null;
                        q05Var2 = new q05(7, getString(R.string.obfuscated_res_0x7f0f02f1), this.L0);
                        q05Var2.d.setTag(sparseArray6);
                        q05Var3 = q05Var5;
                        q05Var = null;
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
                        if (this.x0.k1().V() == 1002 && !z10) {
                            q05Var4 = new q05(6, getString(R.string.report_text), this.L0);
                        } else {
                            q05Var4 = new q05(6, getString(R.string.obfuscated_res_0x7f0f04d5), this.L0);
                        }
                        q05Var4.d.setTag(sparseArray7);
                        if (z17) {
                            q05Var = new q05(13, getString(R.string.multi_delete), this.L0);
                            q05Var3 = q05Var4;
                        } else {
                            q05Var3 = q05Var4;
                            q05Var = null;
                        }
                        q05Var2 = null;
                    } else {
                        q05Var = null;
                        q05Var2 = null;
                        q05Var3 = null;
                    }
                    if (q05Var3 != null) {
                        arrayList.add(q05Var3);
                    }
                    if (q05Var != null) {
                        arrayList.add(q05Var);
                    }
                    if (q05Var2 != null) {
                        arrayList.add(q05Var2);
                    }
                    jf8.b(arrayList, this.L0, this.B2, this.x0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = jf8.d(arrayList, this.B2.p(), sparseArray, this.L0);
                } else {
                    c4 = jf8.c(arrayList, this.B2.p(), sparseArray, this.L0);
                }
                jf8.m(c4, this.b);
                jf8.f(c4);
                this.L0.q(jf8.h(this.B2));
                this.L0.l(c4, !UbsABTestHelper.isPBPlanA());
                this.K0 = new s05(getPageContext(), this.L0);
                this.L0.o(new x2(this));
                this.K0.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.x0.b).param("fid", this.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.x0.I());
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

    public void d5(ForumManageModel.b bVar, rd8 rd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, bVar, rd8Var) == null) {
            List<PostData> list = this.x0.k1().S().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).d0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).d0().get(i4).O())) {
                        list.get(i3).d0().remove(i4);
                        list.get(i3).k();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).l(bVar.g);
            }
            if (z3) {
                rd8Var.I1(this.x0.k1());
            }
        }
    }

    @Override // com.baidu.tieba.pg8
    public void finish() {
        rd8 rd8Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            rd8 rd8Var2 = this.F0;
            if (rd8Var2 != null) {
                rd8Var2.t0();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null && !this.x0.k1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.x0.k1().N().getId();
                if (this.x0.isShareThread() && this.x0.k1().N().originalThreadData != null) {
                    historyMessage.threadName = this.x0.k1().N().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.x0.k1().N().getTitle();
                }
                if (this.x0.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.x0.k1().k().getName();
                }
                ArrayList<PostData> G = this.x0.k1().G();
                rd8 rd8Var3 = this.F0;
                if (rd8Var3 != null) {
                    i3 = rd8Var3.N0();
                } else {
                    i3 = 0;
                }
                if (G != null && i3 >= 0 && i3 < G.size()) {
                    historyMessage.postID = G.get(i3).O();
                }
                historyMessage.isHostOnly = this.x0.N0();
                historyMessage.isSquence = this.x0.C1();
                historyMessage.isShareThread = this.x0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            od5 od5Var = this.U0;
            if (od5Var != null) {
                od5Var.D();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && (pbModel2.P0() || this.x0.S0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.x0.D1());
                if (this.G0) {
                    if (this.I0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.x0.Y0());
                    }
                    if (this.H0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.x0.U0());
                    }
                }
                if (this.x0.k1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.x0.k1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.p1);
                }
                this.a.setResult(-1, intent);
            }
            if (d7()) {
                if (this.x0 != null && (rd8Var = this.F0) != null && rd8Var.W0() != null) {
                    u98 k12 = this.x0.k1();
                    if (k12 != null) {
                        if (k12.U() != null) {
                            k12.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            k12.U().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!k12.q0() && !this.H && k12.h == null) {
                            id8 b4 = id8.b();
                            u98 l12 = this.x0.l1();
                            Parcelable onSaveInstanceState = this.F0.W0().onSaveInstanceState();
                            boolean C1 = this.x0.C1();
                            boolean N0 = this.x0.N0();
                            if (this.F0.e1() != null && this.F0.e1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(l12, onSaveInstanceState, C1, N0, z3);
                            if (this.o1 >= 0 || this.x0.F1() != null) {
                                id8.b().o(this.x0.F1());
                                id8.b().p(this.x0.G1());
                                id8.b().m(this.x0.d1());
                            }
                        }
                    }
                } else {
                    id8.b().k();
                }
                c7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        qf8 qf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            iz8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.x0.k1().l());
                statisticItem.param("tid", this.x0.D1());
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
                if (this.x0.g1() != null) {
                    this.x0.g1().d();
                }
            }
            od5 od5Var = this.U0;
            if (od5Var != null) {
                od5Var.D();
            }
            ForumManageModel forumManageModel = this.A0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.U();
            }
            rd8 rd8Var = this.F0;
            if (rd8Var != null) {
                rd8Var.c2();
                qf8 qf8Var2 = this.F0.h;
                if (qf8Var2 != null) {
                    qf8Var2.p();
                }
            }
            lk5 lk5Var = this.s;
            if (lk5Var != null) {
                lk5Var.c();
            }
            te8 te8Var = this.e;
            if (te8Var != null) {
                te8Var.k();
            }
            ug<TextView> ugVar = this.y;
            if (ugVar != null) {
                ugVar.c();
            }
            ug<FestivalTipView> ugVar2 = this.G;
            if (ugVar2 != null) {
                ugVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            rd8 rd8Var2 = this.F0;
            if (rd8Var2 != null) {
                rd8Var2.t0();
            }
            if (this.V1 != null) {
                gh.a().removeCallbacks(this.V1);
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
            vs8.e().g();
            if (this.h1 != null) {
                gh.a().removeCallbacks(this.h1);
            }
            rd8 rd8Var3 = this.F0;
            if (rd8Var3 != null && (qf8Var = rd8Var3.h) != null) {
                qf8Var.j();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            ud8 ud8Var = this.J0;
            if (ud8Var != null) {
                ud8Var.j();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && pbModel2.y0() != null) {
                this.x0.y0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.W0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            rd8 rd8Var4 = this.F0;
            if (rd8Var4 != null) {
                rd8Var4.c4();
            }
            gf8 gf8Var = this.t0;
            if (gf8Var != null) {
                gf8Var.e();
            }
        }
    }

    public void i5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048687, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                g5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void k5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048694, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            if (bVar.c == 1211066) {
                hideProgressBar();
                j05 j05Var = new j05(getPageContext().getPageActivity());
                j05Var.setMessage(string);
                j05Var.setPositiveButton(R.string.dialog_known, new c2(this));
                j05Var.setCancelable(true);
                j05Var.create(getPageContext());
                j05Var.show();
            } else if (bVar.d != 0) {
                this.F0.C0(bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                int i4 = 0;
                if (i3 == 1) {
                    ArrayList<PostData> G = this.x0.k1().G();
                    int size = G.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(G.get(i4).O())) {
                            G.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.x0.k1().N().setReply_num(this.x0.k1().N().getReply_num() - 1);
                    this.F0.I1(this.x0.k1());
                } else if (i3 == 0) {
                    b5();
                } else if (i3 == 2) {
                    ArrayList<PostData> G2 = this.x0.k1().G();
                    int size2 = G2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= G2.get(i5).d0().size()) {
                                break;
                            } else if (bVar.g.equals(G2.get(i5).d0().get(i6).O())) {
                                G2.get(i5).d0().remove(i6);
                                G2.get(i5).k();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        G2.get(i5).l(bVar.g);
                    }
                    if (z4) {
                        this.F0.I1(this.x0.k1());
                    }
                    d5(bVar, this.F0);
                }
            }
        }
    }

    public void l6() {
        PbModel pbModel;
        u98 k12;
        ThreadData N;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        u98 u98Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048699, this) == null) && (pbModel = this.x0) != null && pbModel.k1() != null && (N = (k12 = this.x0.k1()).N()) != null && N.getAuthor() != null) {
            this.F0.s1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.getAuthor().getUserId());
            bd8 bd8Var = new bd8();
            int V = this.x0.k1().V();
            if (V != 1 && V != 3) {
                bd8Var.g = false;
            } else {
                bd8Var.g = true;
                if (N.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bd8Var.s = z3;
            }
            if (qd8.y(this.x0.k1(), V)) {
                bd8Var.h = true;
                if (N.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                bd8Var.r = z8;
            } else {
                bd8Var.h = false;
            }
            if (V == 1002 && !equals) {
                bd8Var.u = true;
            }
            bd8Var.n = qd8.H(N.isBlocked(), k12.l0(), equals, V, N.isWorksInfo(), N.isScoreThread());
            bd8Var.e = qd8.F(k12, equals, k12.l0(), this.x0.O());
            bd8Var.i = N6();
            bd8Var.f = qd8.G(this.x0.k1(), equals, this.x0.O());
            if (equals && k12.U() != null && k12.U().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            bd8Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                bd8Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            bd8Var.t = equals;
            bd8Var.q = this.x0.C1();
            bd8Var.b = true;
            bd8Var.a = qd8.B(this.x0.k1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            bd8Var.p = z5;
            bd8Var.j = true;
            bd8Var.o = this.x0.N0();
            bd8Var.d = true;
            if (N.getThreadVideoInfo() == null) {
                bd8Var.c = true;
            } else {
                bd8Var.c = false;
            }
            if (k12.i0()) {
                bd8Var.b = false;
                bd8Var.d = false;
                bd8Var.c = false;
                bd8Var.g = false;
                bd8Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !k12.i0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            bd8Var.v = z6;
            if (this.F0 != null && (u98Var = this.x0.G) != null) {
                PostData W = u98Var.W();
                if (W != null) {
                    z7 = W.S;
                } else {
                    z7 = false;
                }
                bd8Var.w = z7;
            }
            bd8Var.m = true;
            if (N.isBlocked()) {
                bd8Var.n = false;
                bd8Var.g = false;
                bd8Var.h = false;
            }
            this.F0.h.v(bd8Var);
        }
    }

    public void p6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null && this.x0.k1().k() != null) {
                if (W4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.x0.k1().i0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.F0.k0();
                    return;
                } else {
                    if (this.X0 == null) {
                        y17 y17Var = new y17(getPageContext());
                        this.X0 = y17Var;
                        y17Var.j(0);
                        this.X0.i(new h1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.X0.g(this.x0.k1().k().getId(), dh.g(this.x0.D1(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void o6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048705, this, str, i3, eVar) != null) || eVar == null) {
            return;
        }
        u98 k12 = this.x0.k1();
        TbRichText k7 = k7(str, i3);
        if (k7 == null || (tbRichTextData = k7.I().get(this.y2)) == null) {
            return;
        }
        eVar.f = String.valueOf(k7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.O().N()) {
            eVar.h = false;
            String a4 = v98.a(tbRichTextData);
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
            imageUrlData.originalUrl = qd8.n(tbRichTextData);
            imageUrlData.originalUrl = qd8.n(tbRichTextData);
            imageUrlData.originalSize = qd8.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = qd8.k(tbRichTextData);
            imageUrlData.isLongPic = qd8.j(tbRichTextData);
            imageUrlData.postId = k7.getPostId();
            imageUrlData.mIsReserver = this.x0.v1();
            imageUrlData.mIsSeeHost = this.x0.N0();
            eVar.b.put(a4, imageUrlData);
            if (k12 != null) {
                if (k12.k() != null) {
                    eVar.c = k12.k().getName();
                    eVar.d = k12.k().getId();
                }
                if (k12.N() != null) {
                    eVar.e = k12.N().getId();
                }
                if (k12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = dh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = k12.G().size();
        this.A2 = false;
        eVar.j = -1;
        if (k12.i() != null) {
            i4 = t5(k12.i().Z(), k7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            PostData postData = k12.G().get(i7);
            if (postData.O() == null || k12.i() == null || k12.i().O() == null || !postData.O().equals(k12.i().O())) {
                i6 = t5(postData.Z(), k7, i6, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (k12 != null) {
            if (k12.k() != null) {
                eVar.c = k12.k().getName();
                eVar.d = k12.k().getId();
            }
            if (k12.N() != null) {
                eVar.e = k12.N().getId();
            }
            if (k12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.U0.C(i3, i4, intent);
            if (E5().g1() != null) {
                E5().g1().k(i3, i4, intent);
            }
            if (i3 == 25035) {
                J5(i4, intent);
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
                                                    rd8 rd8Var = this.F0;
                                                    if (rd8Var != null && rd8Var.H0() != null) {
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
                                        this.F0.o3(false);
                                        if (this.x0.k1() != null && this.x0.k1().N() != null && this.x0.k1().N().getPushStatusData() != null) {
                                            this.x0.k1().N().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        pq8.g().m(getPageContext());
                                        h7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                            shareSuccessReplyToServerModel.G(str, intExtra, new h2(this));
                                        }
                                        if (T5()) {
                                            f7(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.Q;
                                if (view5 != null) {
                                    this.F0.E3(view5);
                                    return;
                                }
                                return;
                            }
                            M5(intent);
                            return;
                        }
                        pq8.g().m(getPageContext());
                        return;
                    }
                    id8.b().k();
                    this.w0.postDelayed(new g2(this), 1000L);
                    return;
                }
                d6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        rd8 rd8Var;
        rd8 rd8Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.e1 = getPageContext();
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
                this.M2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.N2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.O2 = intent.getStringExtra("key_manga_title");
                this.P0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.Q0 = intent.getStringExtra("high_light_post_id");
                this.R0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (v5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O = stringExtra;
                if (dj.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.O;
                }
                this.O = str;
                this.p1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                ez4 ez4Var = new ez4();
                this.b0 = ez4Var;
                ez4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.r1 = intExtra;
                if (intExtra == 0) {
                    this.r1 = intent.getIntExtra("key_start_from", 0);
                }
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            Y5();
            if (this.x0.k1() != null) {
                this.x0.k1().R0(this.O);
            }
            Q5();
            if (intent != null && (rd8Var2 = this.F0) != null) {
                rd8Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new l0(this, intent);
                    }
                    gh.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.x0.k1() != null) {
                    this.x0.Q2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            initData();
            qd5 qd5Var = new qd5();
            this.T0 = qd5Var;
            G6(qd5Var);
            od5 od5Var = (od5) this.T0.a(getActivity());
            this.U0 = od5Var;
            od5Var.W(this.a.getPageContext());
            this.U0.f0(this.k2);
            this.U0.g0(this.Z0);
            this.U0.Y(1);
            this.U0.A(this.a.getPageContext(), bundle);
            this.U0.b().b(new vb5(getActivity()));
            this.U0.b().E(true);
            J6(true);
            this.U0.J(this.x0.M0(), this.x0.D1(), this.x0.I0());
            registerListener(this.y1);
            if (!this.x0.X0()) {
                this.U0.q(this.x0.D1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.x0.T1()) {
                this.U0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                rd8 rd8Var3 = this.F0;
                if (rd8Var3 != null) {
                    this.U0.c0(rd8Var3.h1());
                }
            }
            registerListener(this.x1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.w1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.q2);
            registerListener(this.v1);
            x09 x09Var = new x09("pb", x09.d);
            this.S0 = x09Var;
            x09Var.d();
            registerListener(this.G1);
            registerListener(this.Q1);
            this.x0.m2();
            registerListener(this.p2);
            registerListener(this.d2);
            registerListener(this.j2);
            registerListener(this.M1);
            registerListener(this.c2);
            registerListener(this.H1);
            rd8 rd8Var4 = this.F0;
            if (rd8Var4 != null && rd8Var4.n1() != null && this.F0.l1() != null) {
                te8 te8Var = new te8(this.F0.n1(), this.F0.l1(), this.F0.e1());
                this.e = te8Var;
                te8Var.t(this.P1);
            }
            if (this.c && (rd8Var = this.F0) != null && rd8Var.l1() != null) {
                this.F0.l1().setVisibility(8);
            }
            u35 u35Var = new u35();
            this.f1 = u35Var;
            u35Var.a = 1000L;
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
            this.T1 = new g3(this.F0, this);
            this.x0.E0().K(this.T1);
            this.J0 = new ud8();
            if (this.U0.s() != null) {
                this.J0.m(this.U0.s().i());
            }
            this.U0.V(this.a1);
            this.E0 = new ShareSuccessReplyToServerModel();
            Q4(this.t1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.W0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new m0(this));
            rf8 rf8Var = new rf8(getContext());
            this.y0 = rf8Var;
            rf8Var.b(getUniqueId());
            iz8.g().i(getUniqueId());
            nw4.b().l("3", "");
            this.s1 = new kc6(getPageContext());
            this.t0 = new gf8(this, getUniqueId(), this.F0, this.x0);
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
            this.F0 = new rd8(this, this.i2, this.U1);
            zi6 zi6Var = new zi6(getActivity());
            this.d = zi6Var;
            zi6Var.i(R2);
            this.d.d(this.K2);
            this.F0.f3(this.s2);
            this.F0.e3(this.x2);
            this.F0.Y2(this.u2);
            this.F0.Z2(this.v2);
            this.F0.W2(aw4.c().g());
            this.F0.c3(this.z2);
            this.F0.i3(this.F2);
            this.F0.g3(this.G2);
            this.F0.d3(this.I2);
            this.F0.f4(this.mIsLogin);
            this.F0.U2(this.x0.R1());
            if (this.a.getIntent() != null) {
                this.F0.V2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.F0.f1().setFromForumId(this.x0.getFromForumId());
            this.F0.M2(this.U0.b());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.U0.c0(this.F0.h1());
            }
            this.F0.Q2(this.f2);
            this.F0.T2(this.x0.S0());
            this.F0.h3(this.x0.j1());
            this.t0.f(this.F0, this.x0);
            if ("1".equals(M().showReplyPanel)) {
                this.F0.i2();
            }
            return this.F0.o1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText s5(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048732, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText Z = arrayList.get(i4).Z();
                    if (Z != null && (I = Z.I()) != null) {
                        int size = I.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (I.get(i6) != null && I.get(i6).getType() == 8) {
                                i5++;
                                if (!I.get(i6).O().H().equals(str) && !I.get(i6).O().I().equals(str)) {
                                    if (i5 > i3) {
                                        break;
                                    }
                                } else {
                                    int i7 = (int) ej.i(TbadkCoreApplication.getInst());
                                    int width = I.get(i6).O().getWidth() * i7;
                                    int height = I.get(i6).O().getHeight() * i7;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.y2 = i6;
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

    public final int t5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo O;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048734, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.A2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.I().size();
                int i6 = i3;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.I().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int i9 = (int) ej.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.O().getWidth() * i9;
                        int height = tbRichTextData.O().getHeight() * i9;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.O().N()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = v98.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (O = tbRichTextData.O()) != null) {
                                        String H = O.H();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            H = O.I();
                                        } else {
                                            if (this.q) {
                                                i5 = 17;
                                            } else {
                                                i5 = 18;
                                            }
                                            imageUrlData.urlType = i5;
                                        }
                                        imageUrlData.imageUrl = H;
                                        imageUrlData.originalUrl = qd8.n(tbRichTextData);
                                        imageUrlData.originalSize = qd8.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = qd8.k(tbRichTextData);
                                        imageUrlData.isLongPic = qd8.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = dh.g(this.x0.D1(), -1L);
                                        imageUrlData.mIsReserver = this.x0.v1();
                                        imageUrlData.mIsSeeHost = this.x0.N0();
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

    public void u6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048740, this, z3, markData) == null) {
            this.F0.l3();
            this.x0.Y2(z3);
            au4 au4Var = this.z0;
            if (au4Var != null) {
                au4Var.h(z3);
                if (markData != null) {
                    this.z0.i(markData);
                }
            }
            if (this.x0.V0()) {
                b6();
            } else {
                this.F0.I1(this.x0.k1());
            }
        }
    }

    public final boolean z6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048754, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (postData.getType() != PostData.T0 && !TextUtils.isEmpty(postData.t()) && aw4.c().g()) {
                return g6(postData);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.k1() != null) {
                if (E5().g1() != null) {
                    E5().g1().g();
                }
                ja8 ja8Var = new ja8();
                ja8Var.x(this.x0.k1().k());
                ja8Var.B(this.x0.k1().N());
                ja8Var.z(postData);
                E5().f1().c0(ja8Var);
                E5().f1().setPostId(postData.O());
                a6(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                od5 od5Var = this.U0;
                if (od5Var != null) {
                    this.F0.R2(od5Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }
}
