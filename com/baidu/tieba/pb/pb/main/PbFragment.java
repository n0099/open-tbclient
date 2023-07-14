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
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
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
import com.baidu.tieba.a65;
import com.baidu.tieba.aba;
import com.baidu.tieba.af9;
import com.baidu.tieba.ah5;
import com.baidu.tieba.al5;
import com.baidu.tieba.at5;
import com.baidu.tieba.au4;
import com.baidu.tieba.ax4;
import com.baidu.tieba.ba6;
import com.baidu.tieba.bl5;
import com.baidu.tieba.bn9;
import com.baidu.tieba.bu4;
import com.baidu.tieba.bx9;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ce9;
import com.baidu.tieba.cea;
import com.baidu.tieba.co;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d55;
import com.baidu.tieba.da5;
import com.baidu.tieba.de9;
import com.baidu.tieba.dh5;
import com.baidu.tieba.dl5;
import com.baidu.tieba.dl9;
import com.baidu.tieba.dm9;
import com.baidu.tieba.du5;
import com.baidu.tieba.e5a;
import com.baidu.tieba.ec5;
import com.baidu.tieba.eda;
import com.baidu.tieba.el5;
import com.baidu.tieba.ez6;
import com.baidu.tieba.f0a;
import com.baidu.tieba.f35;
import com.baidu.tieba.f36;
import com.baidu.tieba.fe9;
import com.baidu.tieba.ff5;
import com.baidu.tieba.fg9;
import com.baidu.tieba.fl5;
import com.baidu.tieba.fl9;
import com.baidu.tieba.fn5;
import com.baidu.tieba.ft5;
import com.baidu.tieba.fz6;
import com.baidu.tieba.g06;
import com.baidu.tieba.gg9;
import com.baidu.tieba.gi9;
import com.baidu.tieba.gl9;
import com.baidu.tieba.h45;
import com.baidu.tieba.hj5;
import com.baidu.tieba.hj9;
import com.baidu.tieba.hl5;
import com.baidu.tieba.i36;
import com.baidu.tieba.ij9;
import com.baidu.tieba.jg9;
import com.baidu.tieba.jk9;
import com.baidu.tieba.jl9;
import com.baidu.tieba.jn;
import com.baidu.tieba.jz7;
import com.baidu.tieba.k9;
import com.baidu.tieba.kb;
import com.baidu.tieba.ki5;
import com.baidu.tieba.kj5;
import com.baidu.tieba.kl9;
import com.baidu.tieba.kn9;
import com.baidu.tieba.l65;
import com.baidu.tieba.l9;
import com.baidu.tieba.lj5;
import com.baidu.tieba.lj9;
import com.baidu.tieba.ll9;
import com.baidu.tieba.lu6;
import com.baidu.tieba.mh9;
import com.baidu.tieba.mj5;
import com.baidu.tieba.mk9;
import com.baidu.tieba.ml9;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.ng;
import com.baidu.tieba.nj9;
import com.baidu.tieba.nx4;
import com.baidu.tieba.o15;
import com.baidu.tieba.o25;
import com.baidu.tieba.o46;
import com.baidu.tieba.oa5;
import com.baidu.tieba.oca;
import com.baidu.tieba.og;
import com.baidu.tieba.oj9;
import com.baidu.tieba.ok9;
import com.baidu.tieba.p55;
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
import com.baidu.tieba.pca;
import com.baidu.tieba.pf9;
import com.baidu.tieba.pi5;
import com.baidu.tieba.pi9;
import com.baidu.tieba.pk9;
import com.baidu.tieba.qf9;
import com.baidu.tieba.r55;
import com.baidu.tieba.rh9;
import com.baidu.tieba.ri9;
import com.baidu.tieba.rl5;
import com.baidu.tieba.sa5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sf5;
import com.baidu.tieba.sf9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.si5;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.uo6;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ve5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vka;
import com.baidu.tieba.vx5;
import com.baidu.tieba.w35;
import com.baidu.tieba.w55;
import com.baidu.tieba.wg;
import com.baidu.tieba.wx9;
import com.baidu.tieba.xca;
import com.baidu.tieba.xh9;
import com.baidu.tieba.xi;
import com.baidu.tieba.xl9;
import com.baidu.tieba.xm9;
import com.baidu.tieba.xq5;
import com.baidu.tieba.xt5;
import com.baidu.tieba.y35;
import com.baidu.tieba.y55;
import com.baidu.tieba.yca;
import com.baidu.tieba.yi;
import com.baidu.tieba.yi9;
import com.baidu.tieba.yka;
import com.baidu.tieba.yn;
import com.baidu.tieba.z15;
import com.baidu.tieba.z55;
import com.baidu.tieba.z95;
import com.baidu.tieba.zd9;
import com.baidu.tieba.ze9;
import com.baidu.tieba.zg;
import com.baidu.tieba.zg5;
import com.baidu.tieba.zi5;
import com.baidu.tieba.zl9;
import com.baidu.tieba.zt5;
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
public class PbFragment extends BaseFragment implements i36, VoiceManager.j, UserIconBox.c, View.OnTouchListener, p55.e, TbRichTextView.t, TbPageContextSupport, bn9, kn9.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k S2;
    public static final fz6.b T2;
    public transient /* synthetic */ FieldHolder $fh;
    public ng<ImageView> A;
    public dm9 A0;
    public CustomMessageListener A1;
    public final TbRichTextView.z A2;
    public ng<View> B;
    public ax4 B0;
    public CustomMessageListener B1;
    public boolean B2;
    public ng<TiebaPlusRecommendCard> C;
    public ForumManageModel C0;
    public CustomMessageListener C1;
    public yca C2;
    public ng<LinearLayout> D;
    public sf5 D0;
    public final CustomMessageListener D1;
    public final r55.c D2;
    public ng<RelativeLayout> E;
    public sf9 E0;
    public CustomMessageListener E1;
    public final r55.c E2;
    public ng<ItemCardView> F;
    public PollingModel F0;
    public CustomMessageListener F1;
    public final AdapterView.OnItemClickListener F2;
    @NonNull
    public PbGodGuideController G;
    public ShareSuccessReplyToServerModel G0;
    public View.OnClickListener G1;
    public final View.OnLongClickListener G2;
    public ng<FestivalTipView> H;
    public ij9 H0;
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
    public ng<GifView> L;
    public lj9 L0;
    public CustomMessageListener L1;
    public ez6.b L2;
    public String M;
    public y55 M0;
    public SuggestEmotionModel.c M1;
    public final xh9.b M2;
    public boolean N;
    public a65 N0;
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
    public pk9.h Q1;
    public o25 Q2;
    public View R;
    public boolean R0;
    public CustomMessageListener R1;
    public int R2;
    public View S;
    public String S0;
    public xq5 S1;

    /* renamed from: T  reason: collision with root package name */
    public View f1150T;
    public boolean T0;
    public xq5 T1;
    public View U;
    public pca U0;
    public CheckRealNameModel.b U1;
    public String V;
    public fl5 V0;
    public gg9 V1;
    public int W;
    public el5 W0;
    public final Runnable W1;
    public boolean X;
    public PermissionJudgePolicy X0;
    public CustomMessageListener X1;
    public int[] Y;
    public ReplyPrivacyCheckController Y0;
    public CustomMessageListener Y1;
    public int Z;
    public ll9 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public bl5 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public al5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public h45 c0;
    public al5 c1;
    public CustomMessageListener c2;
    public fz6 d;
    public BdUniqueId d0;
    public int d1;
    public CustomMessageListener d2;
    public pk9 e;
    public z95 e0;
    public Object e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public l9 f1;
    public p55.e f2;
    public boolean g;
    public boolean g0;
    public oa5 g1;
    public e3 g2;
    public boolean h;
    public Object h0;
    public BdUniqueId h1;
    public a65.f h2;
    public VoiceManager i;
    public oca i0;
    public Runnable i1;
    public final SortSwitchButton.f i2;
    public int j;
    public zg5 j0;
    public nj9 j1;
    public final View.OnClickListener j2;
    public r55 k;
    public jn k1;
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
    public kb o2;
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
    public xt5 s;
    public boolean s0;
    public int s1;
    public final ax4.a s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public uo6 t1;
    public final AbsListView.OnScrollListener t2;
    public boolean u;
    public dl9 u0;
    public final c3 u1;
    public final k9 u2;
    public long v;
    public PushPermissionController v0;
    public final pi9.b v1;
    public final sa5.g v2;
    public int w;
    public boolean w0;
    public final CustomMessageListener w1;
    public final View.OnClickListener w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public CustomMessageListener x1;
    public boolean x2;
    public ng<TextView> y;
    public final Handler y0;
    public CustomMessageListener y1;
    public final BdListView.p y2;
    public ng<TbImageView> z;
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

    @Override // com.baidu.tieba.bn9
    public AbsVideoPbFragment N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
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

    @Override // com.baidu.tieba.i36
    public void i1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048682, this, context, str) == null) {
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

    @Override // com.baidu.tieba.bn9
    public PbFragment z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? this : (PbFragment) invokeV.objValue;
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
                    jg9.a(this.b.a.getPageContext(), this.a).show();
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
                zg.a().postDelayed(new a(this, customDialogData), 1000L);
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
                lj9 lj9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (lj9Var = this.a.c.L0) != null && lj9Var.g() != null) {
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
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.H0 != null && this.c.H0.X0() != null) {
                    this.c.H0.X0().smoothScrollBy(i3, 50);
                }
                if (this.c.L5().h1() != null) {
                    if (this.c.W0 != null) {
                        this.c.W0.b().setVisibility(8);
                    }
                    this.c.L5().h1().t(this.a, this.b, this.c.L5().i1(), (this.c.z0 == null || this.c.z0.z1() == null || this.c.z0.z1().N() == null || !this.c.z0.z1().N().isBjh()) ? false : false);
                    hl5 f = this.c.L5().h1().f();
                    if (f != null && this.c.z0 != null && this.c.z0.z1() != null) {
                        f.J(this.c.z0.z1().c());
                        f.f0(this.c.z0.z1().N());
                    }
                    if (this.c.L0.f() == null && this.c.L5().h1().f().u() != null) {
                        this.c.L5().h1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.L0.n(pbFragment2.L5().h1().f().u().i());
                        this.c.L5().h1().f().P(this.c.c1);
                    }
                }
                this.c.L5().r1();
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
                lj9 lj9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (lj9Var = this.a.c.L0) != null && lj9Var.g() != null) {
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
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = yi.j(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = j / 2;
                    g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.H0 != null && this.c.H0.X0() != null) {
                    this.c.H0.X0().smoothScrollBy(i3, 50);
                }
                if (this.c.L5().h1() != null) {
                    if (this.c.W0 != null) {
                        this.c.W0.b().setVisibility(8);
                    }
                    this.c.L5().h1().t(this.a, this.b, this.c.L5().i1(), (this.c.z0 == null || this.c.z0.z1() == null || this.c.z0.z1().N() == null || !this.c.z0.z1().N().isBjh()) ? false : false);
                    hl5 f = this.c.L5().h1().f();
                    if (f != null && this.c.z0 != null && this.c.z0.z1() != null) {
                        f.J(this.c.z0.z1().c());
                        f.f0(this.c.z0.z1().N());
                    }
                    if (this.c.L0.f() == null && this.c.L5().h1().f().u() != null) {
                        this.c.L5().h1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.L0.n(pbFragment2.L5().h1().f().u().i());
                        this.c.L5().h1().f().P(this.c.c1);
                    }
                }
                this.c.L5().r1();
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
            if ((r32.a.H0.e1.a.getView().getTop() - r32.a.H0.k.a.getBottom()) < (r32.a.H0.e1.a.g.getHeight() + 10)) goto L762;
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
            ze9 z1;
            int i;
            int i2;
            yca W;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            w55 w55Var;
            w55 w55Var2;
            w55 w55Var3;
            String string;
            boolean z;
            w55 w55Var4;
            w55 w55Var5;
            w55 w55Var6;
            w55 w55Var7;
            String name;
            boolean z2;
            int i3;
            int i4;
            d55 d55Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i5;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || !this.a.isAdded()) {
                return;
            }
            if (this.a.s0 && (view2 == this.a.H0.k.e || view2 == this.a.H0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091ae5 || view2.getId() == R.id.obfuscated_res_0x7f090b63 || view2.getId() == R.id.obfuscated_res_0x7f091ec1 || view2.getId() == R.id.obfuscated_res_0x7f091a7c)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.H0.a1() && this.a.getPageContext().getPageActivity() != null && this.a.z0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.S1(), this.a.z0.k2(), this.a.z0.j2())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.z0.getForumId());
                    statisticItem2.param("fname", this.a.z0.Y0());
                    statisticItem2.param("tid", this.a.z0.S1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.H0.c1()) {
                    if (!this.a.h && this.a.z0.v2(true)) {
                        this.a.h = true;
                        this.a.H0.v3();
                    }
                } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().G()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.H0.s0();
                    this.a.l7();
                    this.a.H0.u3();
                    this.a.H0.P3();
                    if (this.a.H0.f1() != null) {
                        this.a.H0.f1().setVisibility(8);
                    }
                    this.a.z0.l3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().y()) {
                    if (view2 == this.a.H0.k.h) {
                        if (this.a.H0.h0(this.a.z0.m1())) {
                            this.a.l7();
                            return;
                        }
                        yi.A(this.a.a, this.a.H0.k.h);
                        this.a.a.finish();
                    } else if (view2 == this.a.H0.I0() || (this.a.H0.k.i() != null && (view2 == this.a.H0.k.i().H() || view2 == this.a.H0.k.i().I()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.z0.z1() != null && !this.a.C0.o0()) {
                            this.a.H0.s0();
                            int i7 = (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().I()) ? (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().H()) ? view2 == this.a.H0.I0() ? 2 : 0 : this.a.z0.z1().N().getIs_good() == 1 ? 3 : 6 : this.a.z0.z1().N().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.z0.z1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.z0.z1().N().getId();
                            this.a.H0.k4();
                            this.a.C0.s0(id, name3, id2, i7, this.a.H0.J0());
                        }
                    } else if (view2 == this.a.H0.Q0()) {
                        if (this.a.z0 != null) {
                            nx4.s(this.a.getPageContext().getPageActivity(), this.a.z0.z1().N().getTopicData().b());
                        }
                    } else if (view2 == this.a.H0.k.e) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.z0.z1() != null && this.a.z0.z1().N() != null && this.a.z0.z1().N().isVideoThreadType() && this.a.z0.z1().N().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.z0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.z0.Y0()) || this.a.z0.P0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.z0.P0().b;
                        } else {
                            name2 = this.a.z0.z1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String Y0 = this.a.z0.Y0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.z0.e1() || Y0 == null || !Y0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.H0.k.f) {
                        if (vx5.a()) {
                            return;
                        }
                        if (this.a.z0 == null || this.a.z0.z1() == null) {
                            yi.R(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe0));
                            return;
                        }
                        ArrayList<yca> F = this.a.z0.z1().F();
                        if ((F == null || F.size() <= 0) && this.a.z0.R1()) {
                            yi.R(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe0));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.z0.S1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.z0.getForumId()));
                        this.a.H0.R2();
                        this.a.t6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091aa4) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.H0.f3(true);
                        this.a.H0.R2();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.H0.Z3();
                        this.a.l7();
                        this.a.H0.u3();
                        this.a.z0.p3(this.a.x5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a77) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.H0.s0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091a77 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (hj9.c(this.a.getPageContext(), 11009) && this.a.z0.Q0(this.a.H0.W0()) != null) {
                                this.a.m6();
                                if (this.a.z0.z1() != null && this.a.z0.z1().N() != null && this.a.z0.z1().N().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.z1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.z0.z1().N() == null || this.a.z0.z1().N().getAuthor() == null || this.a.z0.z1().N().getAuthor().getUserId() == null || this.a.B0 == null) {
                                    return;
                                }
                                int v = hj9.v(this.a.z0.z1());
                                ThreadData N = this.a.z0.z1().N();
                                if (N.isBJHArticleThreadType()) {
                                    i6 = 2;
                                } else if (N.isBJHVideoThreadType()) {
                                    i6 = 3;
                                } else if (N.isBJHNormalThreadType()) {
                                    i6 = 4;
                                } else {
                                    i6 = N.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.z0.b).param("obj_locate", 1).param("obj_id", this.a.z0.z1().N().getAuthor().getUserId()).param("obj_type", !this.a.B0.e()).param("obj_source", v).param("obj_param1", i6));
                                return;
                            }
                            return;
                        }
                        this.a.U = view2;
                    } else if ((this.a.H0.k.i() != null && view2 == this.a.H0.k.i().E()) || view2.getId() == R.id.obfuscated_res_0x7f090b63 || view2.getId() == R.id.obfuscated_res_0x7f091ec1) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.H0.s0();
                        if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().E()) {
                            this.a.H0.R2();
                        }
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.l7();
                        this.a.H0.u3();
                        boolean q3 = view2.getId() == R.id.obfuscated_res_0x7f090b63 ? this.a.z0.q3(true, this.a.x5()) : view2.getId() == R.id.obfuscated_res_0x7f091ec1 ? this.a.z0.q3(false, this.a.x5()) : this.a.z0.p3(this.a.x5());
                        view2.setTag(Boolean.valueOf(q3));
                        if (q3) {
                            i5 = 1;
                            this.a.H0.f3(true);
                            this.a.H0.Z3();
                            this.a.h = true;
                            this.a.H0.j3(true);
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                    } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().z()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (hj9.c(this.a.getPageContext(), 11009)) {
                                hj9.w(this.a.getContext(), 3, this.a.t5(), this.a.z0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a7c || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (z1 = this.a.z0.z1()) == null) {
                                return;
                            }
                            ThreadData N2 = z1.N();
                            if (N2 != null && N2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", z1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                statisticItem3.param("tid", this.a.z0.S1());
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
                                            if (N2.getBaijiahaoData() != null && !xi.isEmpty(N2.getBaijiahaoData().oriUgcVid)) {
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
                                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                }
                                if (this.a.X() != null) {
                                    ft5.e(this.a.X(), statisticItem3);
                                }
                                if (this.a.H0 != null) {
                                    statisticItem3.param("obj_param1", this.a.H0.T0());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (yi.G()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e1f);
                                    return;
                                } else if (z1 == null) {
                                    yi.R(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe0));
                                    return;
                                } else {
                                    ArrayList<yca> F2 = this.a.z0.z1().F();
                                    if ((F2 == null || F2.size() <= 0) && this.a.z0.R1()) {
                                        yi.R(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe0));
                                        return;
                                    }
                                    this.a.H0.s0();
                                    this.a.l7();
                                    if (z1.A() != null && !StringUtils.isNull(z1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.z0.z1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), N2)) {
                                        return;
                                    }
                                    if (this.a.H0 != null) {
                                        this.a.H0.u0();
                                        this.a.H0.r4(z1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a7c) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if (!this.a.H0.Z1() || z1.o0()) {
                                            this.a.f7(i2);
                                            return;
                                        } else {
                                            this.a.f7(i2);
                                            return;
                                        }
                                    }
                                    this.a.H0.P3();
                                    this.a.z0.T0().X(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.z0.S1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.z0.getForumId());
                            if (view2.getId() != R.id.share_num_container) {
                            }
                            statisticItem32.param("obj_name", i);
                            statisticItem32.param("obj_type", 1);
                            if (N2 != null) {
                            }
                            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            }
                            if (this.a.X() != null) {
                            }
                            if (this.a.H0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (yi.G()) {
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
                                            da5.p().A("key_is_follow_system_mode", false);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        }
                                        this.a.H0.k.g();
                                        return;
                                    } else if (this.a.H0.U0() == view2) {
                                        if (!this.a.H0.U0().getIndicateStatus()) {
                                            eda.d("c10725", null);
                                        } else {
                                            ze9 z12 = this.a.z0.z1();
                                            if (z12 != null && z12.N() != null && z12.N().getTaskInfoData() != null) {
                                                String e = z12.N().getTaskInfoData().e();
                                                if (StringUtils.isNull(e)) {
                                                    e = z12.N().getTaskInfoData().h();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e));
                                            }
                                        }
                                        this.a.O5();
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().C()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.H0.s0();
                                        SparseArray<Object> Y02 = this.a.H0.Y0(this.a.z0.z1(), this.a.z0.R1(), 1);
                                        if (Y02 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.z1().k().getId(), this.a.z0.z1().k().getName(), this.a.z0.z1().N().getId(), StringUtils.string(this.a.z0.z1().U().getUserId()), StringUtils.string(Y02.get(R.id.tag_forbid_user_name)), StringUtils.string(Y02.get(R.id.tag_forbid_user_name_show)), StringUtils.string(Y02.get(R.id.tag_forbid_user_post_id)), StringUtils.string(Y02.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().x()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> Y03 = this.a.H0.Y0(this.a.z0.z1(), this.a.z0.R1(), 1);
                                        if (Y03 != null) {
                                            this.a.H0.y2(((Integer) Y03.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(Y03.get(R.id.tag_del_post_id)), ((Integer) Y03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) Y03.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.H0.k.f();
                                        if (this.a.Q() == null || this.a.Q().z1() == null || this.a.Q().z1().N() == null) {
                                            return;
                                        }
                                        ThreadData N3 = this.a.Q().z1().N();
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
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().B()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> Y04 = this.a.H0.Y0(this.a.z0.z1(), this.a.z0.R1(), 1);
                                        if (Y04 != null) {
                                            if (StringUtils.isNull((String) Y04.get(R.id.tag_del_multi_forum))) {
                                                this.a.H0.v2(((Integer) Y04.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(Y04.get(R.id.tag_del_post_id)), ((Integer) Y04.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) Y04.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.H0.w2(((Integer) Y04.get(R.id.tag_del_post_type)).intValue(), (String) Y04.get(R.id.tag_del_post_id), ((Integer) Y04.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) Y04.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(Y04.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.H0.k.f();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0922b2 && view2.getId() != R.id.obfuscated_res_0x7f091a90 && view2.getId() != R.id.obfuscated_res_0x7f09190f) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091afa) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091af8 && view2.getId() != R.id.obfuscated_res_0x7f091cdc && view2.getId() != R.id.obfuscated_res_0x7f091a8a) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091a8e) {
                                                    try {
                                                        sparseArray = (SparseArray) view2.getTag();
                                                    } catch (ClassCastException e2) {
                                                        e2.printStackTrace();
                                                        sparseArray = null;
                                                    }
                                                    yca ycaVar = (yca) sparseArray.get(R.id.tag_clip_board);
                                                    if (ycaVar == null) {
                                                        return;
                                                    }
                                                    if (this.a.N0 == null) {
                                                        PbFragment pbFragment = this.a;
                                                        pbFragment.N0 = new a65(pbFragment.getContext());
                                                        this.a.N0.q(this.a.h2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.Q().z1() != null && this.a.Q().z1().i0();
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
                                                    if (ycaVar.o() != null) {
                                                        boolean z4 = ycaVar.o().hasAgree;
                                                        int p = ycaVar.p();
                                                        if (z4 && p == 5) {
                                                            string = this.a.getString(R.string.action_cancel_dislike);
                                                        } else {
                                                            string = this.a.getString(R.string.action_dislike);
                                                        }
                                                        w55 w55Var8 = new w55(8, string, this.a.N0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, ycaVar);
                                                        w55Var8.d.setTag(sparseArray2);
                                                        arrayList.add(w55Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!fl9.i(this.a.z0) && !booleanValue3 && booleanValue2) {
                                                            w55 w55Var9 = new w55(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfb), this.a.N0);
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
                                                            w55Var9.d.setTag(sparseArray3);
                                                            arrayList.add(w55Var9);
                                                        } else if ((hj9.C(this.a.z0.z1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            w55 w55Var10 = new w55(5, this.a.getString(R.string.report_text), this.a.N0);
                                                            w55Var10.d.setTag(str);
                                                            arrayList.add(w55Var10);
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
                                                                    w55 w55Var11 = new w55(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
                                                                    w55Var11.d.setTag(sparseArray4);
                                                                    w55Var2 = w55Var11;
                                                                    w55Var = new w55(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
                                                                    w55Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            w55Var2 = null;
                                                            w55Var = new w55(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
                                                            w55Var.d.setTag(sparseArray4);
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
                                                            if (this.a.z0.z1().V() == 1002 && !booleanValue) {
                                                                w55Var3 = new w55(6, this.a.getString(R.string.report_text), this.a.N0);
                                                            } else {
                                                                w55Var3 = new w55(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
                                                            }
                                                            w55Var3.d.setTag(sparseArray5);
                                                            w55Var2 = w55Var3;
                                                            w55Var = null;
                                                        } else {
                                                            w55Var = null;
                                                            w55Var2 = null;
                                                        }
                                                        if (w55Var2 != null) {
                                                            arrayList.add(w55Var2);
                                                        }
                                                        if (w55Var != null) {
                                                            arrayList.add(w55Var);
                                                        }
                                                    }
                                                    this.a.N0.l(arrayList);
                                                    this.a.M0 = new y55(this.a.getPageContext(), this.a.N0);
                                                    this.a.M0.l();
                                                    return;
                                                } else if (view2 == this.a.H0.S0()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, wg.g(this.a.z0.z1().l(), 0L), wg.g(this.a.z0.S1(), 0L), wg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.z0.z1().N().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().L()) {
                                                    if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().D()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.z0.S1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.H0.k.f();
                                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f090861 && view2.getId() != R.id.obfuscated_res_0x7f090b60) {
                                                        int id3 = view2.getId();
                                                        if (id3 == R.id.pb_u9_text_view) {
                                                            if (!this.a.checkUpIsLogin() || (d55Var = (d55) view2.getTag()) == null || StringUtils.isNull(d55Var.z1())) {
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{d55Var.z1()});
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091ec6 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                yca ycaVar2 = (yca) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.z0.b));
                                                                }
                                                                if (this.a.N0 == null) {
                                                                    PbFragment pbFragment2 = this.a;
                                                                    pbFragment2.N0 = new a65(pbFragment2.getContext());
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
                                                                if (ycaVar2 != null) {
                                                                    if (ycaVar2.e0() != null && ycaVar2.e0().toString().length() > 0) {
                                                                        w55 w55Var12 = new w55(3, this.a.getString(R.string.obfuscated_res_0x7f0f04e1), this.a.N0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, ycaVar2);
                                                                        w55Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(w55Var12);
                                                                    }
                                                                    this.a.C2 = ycaVar2;
                                                                }
                                                                if (this.a.z0.z1().q()) {
                                                                    String u = this.a.z0.z1().u();
                                                                    if (ycaVar2 != null && !xi.isEmpty(u) && u.equals(ycaVar2.S())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            w55Var4 = new w55(4, this.a.getString(R.string.remove_mark), this.a.N0);
                                                                        } else {
                                                                            w55Var4 = new w55(4, this.a.getString(R.string.obfuscated_res_0x7f0f0c3b), this.a.N0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.C2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        w55Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(w55Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!fl9.i(this.a.z0) && !booleanValue9 && booleanValue8) {
                                                                                w55 w55Var13 = new w55(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfb), this.a.N0);
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
                                                                                w55Var4.d.setTag(sparseArray9);
                                                                                arrayList2.add(w55Var13);
                                                                            } else if (hj9.C(this.a.z0.z1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                w55 w55Var14 = new w55(5, this.a.getString(R.string.report_text), this.a.N0);
                                                                                w55Var14.d.setTag(str2);
                                                                                arrayList2.add(w55Var14);
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
                                                                                        w55 w55Var15 = new w55(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
                                                                                        w55Var15.d.setTag(sparseArray10);
                                                                                        w55Var6 = w55Var15;
                                                                                        w55Var5 = new w55(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
                                                                                        w55Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                w55Var6 = null;
                                                                                w55Var5 = new w55(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
                                                                                w55Var5.d.setTag(sparseArray10);
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
                                                                                if (this.a.z0.z1().V() == 1002 && !booleanValue7) {
                                                                                    w55Var7 = new w55(6, this.a.getString(R.string.report_text), this.a.N0);
                                                                                } else {
                                                                                    w55Var7 = new w55(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
                                                                                }
                                                                                w55Var7.d.setTag(sparseArray11);
                                                                                w55Var6 = w55Var7;
                                                                                w55Var5 = null;
                                                                            } else {
                                                                                w55Var5 = null;
                                                                                w55Var6 = null;
                                                                            }
                                                                            if (w55Var6 != null) {
                                                                                arrayList2.add(w55Var6);
                                                                            }
                                                                            if (w55Var5 != null) {
                                                                                arrayList2.add(w55Var5);
                                                                            }
                                                                        }
                                                                        this.a.N0.l(arrayList2);
                                                                        this.a.M0 = new y55(this.a.getPageContext(), this.a.N0);
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
                                                                w55Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(w55Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.N0.l(arrayList2);
                                                                this.a.M0 = new y55(this.a.getPageContext(), this.a.N0);
                                                                this.a.M0.l();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.z0.z1() == null || this.a.z0.z1().N() == null || this.a.z0.z1().N().getActUrl() == null) {
                                                                return;
                                                            }
                                                            nx4.s(this.a.getActivity(), this.a.z0.z1().N().getActUrl());
                                                            if (this.a.z0.z1().N().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.z0.z1().N().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string2 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.z0.z1().l()).param("tid", this.a.z0.z1().P()).param("lotterytail", StringUtils.string(string2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.z0.z1().P().equals(string2)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string2, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.H0.y3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091abe || id3 == R.id.obfuscated_res_0x7f091a84) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string3 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String w = da5.p().w("tail_link", "");
                                                                String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(w)) {
                                                                    TiebaStatic.log("c10056");
                                                                    nx4.x(view2.getContext(), string3, UtilHelper.urlAddParam(w, "page_from=1&tailSkinId=" + string4), true, true, true);
                                                                }
                                                                this.a.H0.R2();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string4));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                nx4.s(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.t5() != 1 || this.a.z0 == null || this.a.z0.z1() == null) {
                                                                    return;
                                                                }
                                                                xm9.w("c10397", this.a.z0.z1().l(), this.a.z0.z1().P(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string5 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                nx4.s(this.a.getActivity(), string5);
                                                                if (this.a.t5() != 1 || this.a.z0 == null || this.a.z0.z1() == null) {
                                                                    return;
                                                                }
                                                                xm9.w("c10507", this.a.z0.z1().l(), this.a.z0.z1().P(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0916b5) {
                                                            this.a.i6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0916b4) {
                                                            this.a.g6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09272a) {
                                                            if (this.a.p1 >= 0) {
                                                                if (this.a.z0 != null) {
                                                                    this.a.z0.S2();
                                                                }
                                                                if (this.a.z0 == null || this.a.H0.F0() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    i4 = 0;
                                                                    this.a.H0.F0().o0(this.a.z0.z1(), false);
                                                                }
                                                                this.a.p1 = i4;
                                                                if (this.a.z0 != null) {
                                                                    if (this.a.H0.X0() != null) {
                                                                        this.a.H0.X0().setSelection(this.a.z0.s1());
                                                                    }
                                                                    this.a.z0.W2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (hj9.c(this.a.getPageContext(), 11009)) {
                                                                hj9.w(this.a.getContext(), 8, this.a.t5(), this.a.z0);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09190f) {
                                                            SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                            if (sparseArray12 == null) {
                                                                return;
                                                            }
                                                            this.a.j7(sparseArray12);
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091a79) {
                                                            if (this.a.H0.X0() == null || this.a.z0 == null || this.a.z0.z1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.H0.X0().getFirstVisiblePosition();
                                                            View childAt = this.a.H0.X0().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean w0 = this.a.z0.z1().w0();
                                                            boolean W1 = this.a.H0.W1();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            hj9.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.z0.z1());
                                                            if ((this.a.z0.z1().N() != null && this.a.z0.z1().N().getReply_num() <= 0) || (W1 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.x6();
                                                                if (this.a.z0.z1().N().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.z1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int j = (int) (yi.j(this.a.getContext()) * 0.6d);
                                                                if (w0) {
                                                                    if (this.a.H0.e1 != null) {
                                                                        if (this.a.H0.e1.a != null && this.a.H0.e1.a.getView() != null) {
                                                                            if (this.a.H0.e1.a.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                } else {
                                                                    if (this.a.H0.f1() != null) {
                                                                        z2 = this.a.H0.f1().getVisibility() == 0;
                                                                        if (!z2 && this.a.H0.e1 != null && this.a.H0.e1.a != null && this.a.H0.e1.a.getView() != null && this.a.H0.e1.a.getView().getParent() != null && this.a.H0.k != null && this.a.H0.k.a != null) {
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                }
                                                                if (z2 || W1) {
                                                                    this.a.a0 = firstVisiblePosition;
                                                                    this.a.b0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                        int i9 = -j;
                                                                        this.a.H0.X0().setSelectionFromTop(0, i9);
                                                                        this.a.H0.X0().smoothScrollBy(i9, 500);
                                                                    } else {
                                                                        this.a.H0.X0().D(0, 0, 500);
                                                                    }
                                                                } else if (this.a.a0 <= 0) {
                                                                    int d = jk9.d(this.a.getListView());
                                                                    if (jk9.e(this.a.getListView()) != -1) {
                                                                        d--;
                                                                    }
                                                                    int g = yi.g(this.a.getContext(), R.dimen.tbds100);
                                                                    if (d < 0) {
                                                                        d = (ListUtils.getCount(this.a.H0.X0().getData()) - 1) + this.a.H0.X0().getHeaderViewsCount();
                                                                        i3 = 0;
                                                                    } else {
                                                                        i3 = g;
                                                                    }
                                                                    if (this.a.H0.k != null && this.a.H0.k.a != null) {
                                                                        i3 += this.a.H0.k.a.getFixedNavHeight() - 10;
                                                                    }
                                                                    if (this.a.H0.e1 == null || this.a.H0.e1.a == null || this.a.H0.e1.a.getView() == null || this.a.H0.e1.a.getView().getParent() == null) {
                                                                        this.a.H0.X0().setSelectionFromTop(d, i3 + j);
                                                                        this.a.H0.X0().smoothScrollBy(j, 500);
                                                                    } else {
                                                                        this.a.H0.X0().D(d, i3, 200);
                                                                    }
                                                                } else if (this.a.H0.X0().getChildAt(this.a.a0) == null) {
                                                                    this.a.H0.X0().setSelectionFromTop(this.a.a0, this.a.b0 + j);
                                                                    this.a.H0.X0().smoothScrollBy(j, 500);
                                                                } else {
                                                                    this.a.H0.X0().D(this.a.a0, this.a.b0, 200);
                                                                }
                                                            }
                                                            if (this.a.z0.z1().N() == null || this.a.z0.z1().N().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.z1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091ae5) {
                                                            if (this.a.z0 == null || this.a.z0.z1() == null || this.a.z0.z1().k() == null || xi.isEmpty(this.a.z0.z1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.z0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.z0.Y0()) || this.a.z0.P0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.z0.P0().b;
                                                            } else {
                                                                name = this.a.z0.z1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String Y05 = this.a.z0.Y0();
                                                            if (!this.a.z0.e1() || Y05 == null || !Y05.equals(name)) {
                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.z0.z1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                createNormalCfg2.setCallFrom(2);
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.z0.S1());
                                                            statisticItem6.param("fid", this.a.z0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.z0.z1().N() != null) {
                                                                statisticItem6.param("nid", this.a.z0.z1().N().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.z0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.z0.S1());
                                                                statisticItem7.param("fid", this.a.z0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b0c) {
                                                                if (this.a.z0 == null || this.a.z0.z1() == null) {
                                                                    return;
                                                                }
                                                                ze9 z13 = this.a.z0.z1();
                                                                if (this.a.E0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.E0 = new sf9(pbFragment3.getPageContext());
                                                                }
                                                                long g2 = wg.g(z13.P(), 0L);
                                                                long g3 = wg.g(z13.l(), 0L);
                                                                xm9.y("c13446", g3);
                                                                PbFragment pbFragment4 = this.a;
                                                                pbFragment4.registerListener(pbFragment4.o2);
                                                                this.a.E0.a(g2, g3);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b26) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!ba6.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        nx4.s(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.z0.S1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09100d) {
                                                                if (view2.getTag() instanceof ThreadData) {
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg3.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09100a) {
                                                                if ((view2.getTag() instanceof ThreadData) && this.a.checkUpIsLogin()) {
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.Q != null) {
                                                                        this.a.Q.n0(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 != R.id.obfuscated_res_0x7f091a92 && id3 != R.id.obfuscated_res_0x7f091af2) {
                                                                if (id3 == R.id.obfuscated_res_0x7f092748) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        xm9.u(5);
                                                                    }
                                                                    this.a.M6(false);
                                                                    this.a.k7((yca) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.s0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.z0.S1());
                                                                statisticItem8.param("fid", this.a.z0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    xm9.u(6);
                                                                }
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.b = false;
                                                                pbFragment5.h5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.z0.y1() != 3 || !this.a.z0() || this.a.z0.z1() == null || !ListUtils.isEmpty(this.a.z0.z1().o())) {
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
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof yca)) {
                                                            return;
                                                        }
                                                        yca ycaVar3 = (yca) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (ycaVar3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090862);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090863);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b60);
                                                        if (ycaVar3.C0()) {
                                                            ycaVar3.f1(false);
                                                            jl9.e(ycaVar3);
                                                        } else if (this.a.Q() != null ? jl9.c(this.a.Q().z1(), ycaVar3) : false) {
                                                            ycaVar3.f1(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, ycaVar3.C0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, ycaVar3.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, ycaVar3.C0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, ycaVar3.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.H0.k.g();
                                                    this.a.H0.W3(this.a.F2);
                                                    return;
                                                }
                                            } else if (this.a.z0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091af8) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.z0.S1());
                                                    statisticItem10.param("fid", this.a.z0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091cdc) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.f1150T = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091af8 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.f1150T = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof yca) {
                                                        yca ycaVar4 = (yca) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091af8 && (statisticItem = ycaVar4.f0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091cdc || view2.getId() == R.id.obfuscated_res_0x7f091a8a) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.z0.T1()).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ycaVar4.S()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.z0 == null || this.a.z0.z1() == null || this.a.L5().g1() == null || ycaVar4.q() == null || ycaVar4.I() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.L5().h1() != null) {
                                                            this.a.L5().h1().g();
                                                        }
                                                        qf9 qf9Var = new qf9();
                                                        qf9Var.v(this.a.z0.z1().k());
                                                        qf9Var.z(this.a.z0.z1().N());
                                                        qf9Var.x(ycaVar4);
                                                        this.a.L5().g1().r0(qf9Var);
                                                        this.a.L5().g1().setPostId(ycaVar4.S());
                                                        this.a.j6(view2, ycaVar4.q().getUserId(), "", ycaVar4);
                                                        if (this.a.W0 != null) {
                                                            this.a.H0.Z2(this.a.W0.z());
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
                                            statisticItem11.param("tid", this.a.z0.S1());
                                            statisticItem11.param("fid", this.a.z0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091afa || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof yca) {
                                                        yca ycaVar5 = (yca) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = ycaVar5.f0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.z0 == null || this.a.z0.z1() == null) {
                                                            return;
                                                        }
                                                        String S1 = this.a.z0.S1();
                                                        String S = ycaVar5.S();
                                                        int V = this.a.z0.z1() != null ? this.a.z0.z1().V() : 0;
                                                        AbsPbActivity.e y6 = this.a.y6(S);
                                                        if (y6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S1, S, "pb", true, false, null, false, null, V, ycaVar5.l0(), this.a.z0.z1().c(), false, ycaVar5.q().getIconInfo(), 5).addBigImageData(y6.a, y6.b, y6.g, y6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.z0.y1());
                                                        addBigImageData.setFromFrsForumId(this.a.z0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.z0.X1());
                                                        addBigImageData.setKeyFromForumId(this.a.z0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.z0.e0(), this.a.z0.a0(), this.a.z0.b0(), this.a.z0.Z(), this.a.z0.f0());
                                                        addBigImageData.setBjhData(this.a.z0.R0());
                                                        if (this.a.z0.z1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.z0.z1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.z0.z1().U() != null) {
                                                            addBigImageData.setIsManager(this.a.z0.z1().U().getIs_manager());
                                                        }
                                                        if (this.a.z0.z1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.z0.z1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.z0.z1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.z0.z1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.z0.z1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.z0.z1().k().getUser_level());
                                                        }
                                                        if (this.a.H0 != null && this.a.z0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.z0.G.W().f1185T || ycaVar5.f1185T);
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
                                        if (view2.getId() == R.id.obfuscated_res_0x7f09190f) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.z0.S1());
                                            statisticItem13.param("fid", this.a.z0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091a90 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                xm9.t("c10517", this.a.z0.z1().l(), 3);
                                                return;
                                            } else if (this.a.z0 == null || this.a.z0.z1() == null) {
                                                return;
                                            } else {
                                                this.a.H0.s0();
                                                SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                yca ycaVar6 = (yca) sparseArray17.get(R.id.tag_load_sub_data);
                                                yca ycaVar7 = (yca) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                if (ycaVar6 == null || view4 == null) {
                                                    return;
                                                }
                                                if (ycaVar6.M() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem14 = ycaVar6.f0;
                                                if (statisticItem14 != null) {
                                                    StatisticItem copy3 = statisticItem14.copy();
                                                    copy3.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09190f) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a90) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String S12 = this.a.z0.S1();
                                                String S2 = ycaVar6.S();
                                                String S3 = ycaVar7 != null ? ycaVar7.S() : "";
                                                int V2 = this.a.z0.z1() != null ? this.a.z0.z1().V() : 0;
                                                this.a.l7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ec6) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e y62 = this.a.y6(S2);
                                                    if (ycaVar6 == null || this.a.z0 == null || this.a.z0.z1() == null || y62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S12, S2, "pb", true, false, null, false, S3, V2, ycaVar6.l0(), this.a.z0.z1().c(), false, ycaVar6.q().getIconInfo(), 5).addBigImageData(y62.a, y62.b, y62.g, y62.j);
                                                    if (!xi.isEmpty(S3)) {
                                                        addBigImageData2.setHighLightPostId(S3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.z0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.z0.e0(), this.a.z0.a0(), this.a.z0.b0(), this.a.z0.Z(), this.a.z0.f0());
                                                    addBigImageData2.setBjhData(this.a.z0.R0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.z0.y1());
                                                    addBigImageData2.setFromFrsForumId(this.a.z0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.z0.X1());
                                                    if (this.a.H0 != null && this.a.z0.G != null && (W = this.a.z0.G.W()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(W.f1185T || ycaVar6.f1185T);
                                                    }
                                                    if (this.a.z0.z1() != null && this.a.z0.z1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.z0.z1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e y63 = this.a.y6(S2);
                                                if (this.a.z0 == null || this.a.z0.z1() == null || y63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S12, S2, "pb", true, false, null, true, null, V2, ycaVar6.l0(), this.a.z0.z1().c(), false, ycaVar6.q().getIconInfo(), 5).addBigImageData(y63.a, y63.b, y63.g, y63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.z0.y1());
                                                addBigImageData3.setFromFrsForumId(this.a.z0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.z0.X1());
                                                addBigImageData3.setKeyFromForumId(this.a.z0.getForumId());
                                                addBigImageData3.setBjhData(this.a.z0.R0());
                                                addBigImageData3.setTiebaPlusData(this.a.z0.e0(), this.a.z0.a0(), this.a.z0.b0(), this.a.z0.Z(), this.a.z0.f0());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.S = view2;
                                        return;
                                    }
                                } else if (this.a.z0 == null || this.a.z0.z1() == null || this.a.z0.z1().N() == null) {
                                    return;
                                } else {
                                    this.a.H0.k.f();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.S5(pbFragment6.z0.z1().N().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.H0.s0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.z0.P1()));
                            } else {
                                this.a.l7();
                                this.a.H0.u3();
                                y55 y55Var = new y55(this.a.getPageContext());
                                if (this.a.z0.z1().f == null || this.a.z0.z1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.z0.z1().f.size()];
                                    for (int i10 = 0; i10 < this.a.z0.z1().f.size(); i10++) {
                                        strArr[i10] = this.a.z0.z1().f.get(i10).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                y55Var.i(null, strArr, new a(this, y55Var, view2));
                                y55Var.l();
                            }
                        } else {
                            this.a.H0.s0();
                            if (this.a.Q().z1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.z0.x1() != null) {
                                this.a.H0.d4(this.a.z0.x1(), this.a.f2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.H0.k.f();
                    }
                } else {
                    this.a.H0.k.g();
                    if (this.a.z0 != null) {
                        this.a.t1.f(this.a.z0.S1());
                    }
                    if (this.a.z0 != null && this.a.z0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.Q() == null || this.a.Q().z1() == null) {
                            return;
                        }
                        this.a.t1.d(3, 3, this.a.Q().z1().P());
                        return;
                    }
                    this.a.t1.b();
                    int i11 = (TbSingleton.getInstance().mCanCallFans || this.a.Q() == null || this.a.Q().z1() == null || this.a.Q().z1().P() == null || !this.a.Q().z1().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.Q() == null || this.a.Q().z1() == null) {
                        return;
                    }
                    this.a.t1.d(3, i11, this.a.Q().z1().P());
                }
            } else if (!this.a.s0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.z0.S1());
                statisticItem15.param("fid", this.a.z0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    xm9.u(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (!(obj instanceof yca)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    yca ycaVar8 = (yca) obj;
                    if (this.a.z0 != null && this.a.z0.z1() != null && this.a.L5().g1() != null && ycaVar8.q() != null && ycaVar8.I() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        } else if (ycaVar8.k() != 0) {
                            return;
                        } else {
                            if (this.a.L5().h1() != null) {
                                this.a.L5().h1().g();
                            }
                            qf9 qf9Var2 = new qf9();
                            qf9Var2.v(this.a.z0.z1().k());
                            qf9Var2.z(this.a.z0.z1().N());
                            qf9Var2.x(ycaVar8);
                            this.a.L5().g1().r0(qf9Var2);
                            this.a.L5().g1().setPostId(ycaVar8.S());
                            this.a.j6(view2, ycaVar8.q().getUserId(), "", ycaVar8);
                            TiebaStatic.log("c11743");
                            xm9.b(this.a.z0.z1(), ycaVar8, ycaVar8.e0, 8, 1);
                            if (this.a.W0 != null) {
                                this.a.H0.Z2(this.a.W0.z());
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
        public class a implements a65.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y55 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ h1 c;

            public a(h1 h1Var, y55 y55Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var, y55Var, view2};
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
                this.a = y55Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.z0.Q1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.a65.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void L0(a65 a65Var, int i, View view2) {
                boolean r3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, a65Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.z0.Q1() != 1 || i != 1) {
                        if (this.c.a.z0.Q1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.z0.Q1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091b08) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.z0.z1().f != null && this.c.a.z0.z1().f.size() > i) {
                            i = this.c.a.z0.z1().f.get(i).sort_type.intValue();
                        }
                        r3 = this.c.a.z0.r3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.z0.P1()));
                        if (r3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.H0.j3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091b08) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.z0.z1().f != null) {
                        i = this.c.a.z0.z1().f.get(i).sort_type.intValue();
                    }
                    r3 = this.c.a.z0.r3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.z0.P1()));
                    if (r3) {
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
                    this.b.a.H0.D2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                    kl9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.z0.z1() != null) {
                        statisticItem.param("fid", this.a.z0.z1().l());
                    }
                    statisticItem.param("tid", this.a.z0.S1());
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
                this.a.l7();
                this.a.H0.s3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.F0 != null) {
                    this.a.F0.D0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    zg.a().postDelayed(this.a.W1, 300000L);
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
                        if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        p55 p55Var = new p55(this.a.getActivity());
                        if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                            p55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            p55Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(this));
                        p55Var.setPositiveButton(R.string.open_now, new c(this));
                        p55Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ve5Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.T6(i, antiData, str);
                        return;
                    }
                }
                this.a.e7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.U6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.H0.N1(this.a.z0.z1());
                    }
                } else if (this.a.z0.c1()) {
                    ze9 z1 = this.a.z0.z1();
                    if (z1 != null && z1.N() != null && z1.N().getAuthor() != null && (userId = z1.N().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.z0.o3()) {
                        this.a.H0.u3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.z0.o3()) {
                    this.a.H0.u3();
                }
                if (this.a.z0.g1()) {
                    xm9.r("c10369", this.a.z0.S1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    zg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.z0 != null) {
                    Context context = this.a.getContext();
                    ze9 z12 = this.a.z0.z1();
                    String forumId = this.a.z0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    hj9.a(context, z12, forumId, z2, this.a.z0.E1(), this.a.z0.H1(), this.a.z0.G1(), this.a.z0.F1(), this.a.z0.L1(), this.a.z0.M1());
                }
                if (writeData != null) {
                    ec5.b(writeData.getContent(), "1");
                }
                if (this.a.b6()) {
                    this.a.o7();
                }
                this.a.c7();
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
                    this.b.a.H0.D2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                    kl9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.z0 != null && this.a.z0.z1() != null) {
                        statisticItem.param("fid", this.a.z0.z1().l());
                    }
                    if (this.a.z0 != null) {
                        statisticItem.param("tid", this.a.z0.S1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.C5()) {
                        this.a.M6(false);
                        de9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f146b));
                    }
                    lj9 lj9Var = this.a.L0;
                    if (lj9Var != null) {
                        lj9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        dh5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        ec5.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        zg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.b6()) {
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
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    p55 p55Var = new p55(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        p55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        p55Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(this));
                    p55Var.setPositiveButton(R.string.open_now, new c(this));
                    p55Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.L0 != null) {
                        if (pbFragment.H0 != null && this.a.H0.h1() != null && this.a.H0.h1().f() != null && this.a.H0.h1().f().z()) {
                            this.a.H0.h1().f().w(postWriteCallBackData);
                        }
                        this.a.L0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements fz6.b {
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

        @Override // com.baidu.tieba.fz6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    fg9.d();
                } else {
                    fg9.c();
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
                this.a.H0.z3(list);
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
                String valueOf = String.valueOf(this.a.z0.z1().U().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.z1().k().getId(), this.a.z0.z1().k().getName(), this.a.z0.z1().N().getId(), valueOf, str, str3, str2, str4)));
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
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.z0.x2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H0.A0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements ez6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.ez6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ez6.b
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

        @Override // com.baidu.tieba.ez6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.H0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.B5()) {
                    this.b.H0.w1();
                    this.b.H0.S2();
                }
            }
        }

        @Override // com.baidu.tieba.ez6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.H0 != null && this.b.e != null) {
                this.b.H0.X3();
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
    public class b implements xh9.b {
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

        @Override // com.baidu.tieba.xh9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f179b);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e1f);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.H0.q0(str);
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
            ze9 z1 = this.a.z0.z1();
            if (z1.N().getPraise().getIsLike() == 1) {
                this.a.t7(0);
            } else {
                this.a.t7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, z1.N()));
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements a65.f {
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

        @Override // com.baidu.tieba.a65.f
        public void L0(a65 a65Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a65Var, i, view2) == null) {
                if (this.a.M0 != null) {
                    this.a.M0.dismiss();
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
                                            if (this.a.k1 != null && !TextUtils.isEmpty(this.a.l1)) {
                                                if (this.a.n1 != null) {
                                                    fn5.a aVar = new fn5.a();
                                                    aVar.a = this.a.l1;
                                                    String str = "";
                                                    if (this.a.n1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.n1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.X4();
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
                                                    pbFragment.j1 = new nj9(pbFragment.getPageContext());
                                                }
                                                this.a.j1.b(this.a.l1, this.a.k1.n());
                                                this.a.k1 = null;
                                                this.a.l1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            yca ycaVar = this.a.C2;
                                            if (ycaVar != null) {
                                                ycaVar.P0();
                                                this.a.C2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.n6(view2);
                                            if (this.a.z0.z1().N() != null && this.a.z0.z1().N().getAuthor() != null && this.a.z0.z1().N().getAuthor().getUserId() != null && this.a.B0 != null) {
                                                int v = hj9.v(this.a.z0.z1());
                                                ThreadData N = this.a.z0.z1().N();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.z0.b).param("obj_locate", 2).param("obj_id", this.a.z0.z1().N().getAuthor().getUserId()).param("obj_type", !this.a.B0.e()).param("obj_source", v).param("obj_param1", i2));
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
                                                boolean F = this.a.X().F(TbadkCoreApplication.getCurrentAccount());
                                                if (F) {
                                                    if (booleanValue2) {
                                                        this.a.H0.x2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, F);
                                                        return;
                                                    } else {
                                                        this.a.V6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.H0.v2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.V6(sparseArray3, intValue, booleanValue);
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
                                                this.a.H0.A2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.H0.v2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            yca ycaVar2 = (yca) sparseArray.get(R.id.tag_clip_board);
                                            if (ycaVar2.o() == null) {
                                                return;
                                            }
                                            this.a.f5(ycaVar2.o());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.z0 != null && this.a.z0.z1() != null) {
                                                this.a.a.U1(vka.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.z0 != null && this.a.z0.z1() != null) {
                                    this.a.H0.u4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.A6(view3);
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
                            this.a.A6(view4);
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
                    this.a.A6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.M6(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.A6(view6);
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
                if (this.a.x2 && this.a.B5()) {
                    this.a.g6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.H0 != null) {
                    this.a.H0.T2();
                }
                if (!this.a.f0 && this.a.H0 != null && this.a.H0.i0() && this.a.z0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.z0.S1());
                    statisticItem.param("fid", this.a.z0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.z0.e1()) {
                        i = 4;
                    } else if (this.a.z0.f1()) {
                        i = 3;
                    } else if (this.a.z0.h1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.z0.v2(false)) {
                    this.a.H0.v3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.z0.z1() != null) {
                    this.a.H0.N2();
                }
                this.a.x2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements pi9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.pi9.b
        public void onSuccess(List<yca> list) {
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

        @Override // com.baidu.tieba.pi9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.H0.i4(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    p55Var.dismiss();
                    ((TbPageContext) this.a.f1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                p55Var.dismiss();
                kl9.a(this.a.getPageContext());
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
                this.a.H0.e4(!this.a.N);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                if (p55Var != null) {
                    p55Var.dismiss();
                }
                this.d.n5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
    public class d implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements pk9.h {
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

        @Override // com.baidu.tieba.pk9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.O6(z);
                if (this.a.H0.U0() != null && z) {
                    this.a.H0.e4(false);
                }
                this.a.H0.m2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<ij9> a;
        public WeakReference<PbFragment> b;

        public d3(ij9 ij9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ij9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                ij9 ij9Var = this.a.get();
                if (ij9Var != null) {
                    ij9Var.v1();
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
                        jz7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e1f);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements a65.f {
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

        @Override // com.baidu.tieba.a65.f
        public void L0(a65 a65Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a65Var, i, view2) == null) {
                if (this.e.M0 != null) {
                    this.e.M0.dismiss();
                }
                if (i == 0) {
                    this.e.H0.v2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.h1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.h1);
                    this.e.h7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
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
                this.a.H0.s0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.z0 != null && !this.a.z0.isLoading) {
                    this.a.l7();
                    this.a.H0.u3();
                    z = true;
                    if (this.a.z0.z1() != null && this.a.z0.z1().f != null && this.a.z0.z1().f.size() > i) {
                        int intValue = this.a.z0.z1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.z0.T1()).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.z0.r3(intValue)) {
                            this.a.h = true;
                            this.a.H0.j3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ p55 c;
        public final /* synthetic */ PbFragment d;

        public e2(PbFragment pbFragment, MarkData markData, MarkData markData2, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, p55Var};
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
            this.c = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
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
                this.d.m7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.b.H0.P3();
                MessageManager.getInstance().sendMessage(this.a);
                p55Var.dismiss();
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
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null) {
                if (updateAttentionMessage.getData().i != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.S2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().q() != null && this.a.u5().q().getGodUserData() != null) {
                        this.a.u5().q().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.z0 != null && this.a.z0.z1() != null && this.a.z0.z1().N() != null && this.a.z0.z1().N().getAuthor() != null) {
                        this.a.z0.z1().N().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements al5 {
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

        @Override // com.baidu.tieba.al5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                lj9 lj9Var = this.a.L0;
                if (lj9Var != null && lj9Var.g() != null && this.a.L0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.L0.g().c());
                    if (this.a.H0 != null && this.a.H0.h1() != null && this.a.H0.h1().f() != null && this.a.H0.h1().f().z()) {
                        this.a.H0.h1().f().w(this.a.L0.h());
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
    public class g implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 extends xq5<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qq5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.c.a.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ p55 b;
        public final /* synthetic */ PbFragment c;

        public g2(PbFragment pbFragment, MarkData markData, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, p55Var};
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
            this.b = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.m7();
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
                    this.a.H0.Z2(this.a.W0.z());
                }
                this.a.H0.R2();
                this.a.H0.s0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 extends xq5<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qq5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.H0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.H0.p1());
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
        public final /* synthetic */ p55 b;
        public final /* synthetic */ PbFragment c;

        public h2(PbFragment pbFragment, MarkData markData, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, p55Var};
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
            this.b = p55Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.H0 != null && this.c.H0.p1() != null) {
                    this.c.H0.p1().getLocationOnScreen(iArr);
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
            this.a.z0.u3((UserPendantData) customResponsedMessage.getData());
            if (this.a.H0 != null && this.a.z0 != null) {
                this.a.H0.L2(this.a.z0.z1(), this.a.z0.R1(), this.a.z0.J1(), this.a.H0.l1());
            }
            if (this.a.H0 != null && this.a.H0.F0() != null) {
                this.a.H0.F0().f0();
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
            ij9 ij9Var = this.b.H0;
            ij9Var.x3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            this.a.e7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements og<ImageView> {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
                    if (a15.c().g()) {
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
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = a15.c().g();
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
                    this.a.H0.Z3();
                } else {
                    this.a.H0.x1();
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
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.H0 != null && this.a.H0.h1() != null && this.a.H0.h1().f() != null) {
                    this.a.H0.h1().f().I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements bl5 {
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

        @Override // com.baidu.tieba.bl5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements og<GifView> {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
                if (a15.c().g()) {
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
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = a15.c().g();
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
                this.a.H0.Z2(this.a.W0.z());
            }
            this.a.H0.H3(false);
        }
    }

    /* loaded from: classes7.dex */
    public class k0 extends k9 {
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

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements og<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
                fe9 fe9Var = (fe9) customResponsedMessage.getData();
                int type = fe9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (fe9Var.a() == null) {
                                this.a.C6(false, null);
                                return;
                            } else {
                                this.a.C6(true, (MarkData) fe9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.p5((ForumManageModel.b) fe9Var.a(), false);
                    return;
                }
                this.a.D6((qf9) fe9Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements ce9.d {
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

        @Override // com.baidu.tieba.ce9.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements og<View> {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.H0 != null && this.a.H0.F0() != null) {
                this.a.H0.F0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements gg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.gg9.a
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

        @Override // com.baidu.tieba.gg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ee7) {
                        if (this.a.H6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015b) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof yca)) {
                                return false;
                            }
                            yca ycaVar = (yca) obj;
                            if (ycaVar.getType() != yca.a1 && !TextUtils.isEmpty(ycaVar.t()) && a15.c().g()) {
                                return this.a.p6(ycaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a8f) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.j7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.H0.S1() && view2.getId() == R.id.obfuscated_res_0x7f091ab1) {
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
                        this.a.j7(sparseArray);
                    }
                }
                if (this.a.W0 != null) {
                    this.a.H0.Z2(this.a.W0.z());
                }
                this.a.H0.R2();
                this.a.H0.s0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.gg9.a
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
    public class m1 extends kb {
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

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView n1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        yi.Q(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.H0 != null && (n1 = this.a.H0.n1()) != null && this.a.H0.X0() != null) {
                            this.a.H0.X0().removeHeaderView(n1);
                            return;
                        }
                        return;
                    }
                    yi.R(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements og<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f36.a)) {
                f36.a aVar = (f36.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.P5(aVar.b);
                }
                f36.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.z0 != null && this.a.z0.k1()) {
                    this.a.k6();
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
        public void b(ze9 ze9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ze9Var) == null) {
                this.a.H0.N1(ze9Var);
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
            du5 du5Var = new du5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            du5Var.c();
            if (z2) {
                j3 = j4;
                du5Var.B = j3;
                du5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.z0 != null && this.a.z0.z1() != null && this.a.z0.z1().N() != null) {
                int threadType = this.a.z0.z1().N().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        zt5 zt5Var = new zt5();
                        zt5Var.F = 1;
                        zt5Var.a(1005);
                        zt5Var.D = j3;
                        zt5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        du5 du5Var2 = new du5();
                        du5Var2.a(1000);
                        du5Var2.D = j3;
                        du5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ze9 ze9Var, String str, int i4) {
            boolean z2;
            hj5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ze9Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907a2));
                }
                if (z && ze9Var != null && ze9Var.X() == null && ListUtils.getCount(ze9Var.F()) < 1) {
                    this.a.z0.l3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.H0 != null) {
                        this.a.H0.a4();
                        return;
                    }
                    return;
                }
                if (this.a.g0) {
                    if (this.a.Q() != null) {
                        this.a.Q().H0();
                    }
                } else {
                    this.a.g0 = true;
                }
                this.a.g = true;
                if (this.a.H0 == null) {
                    return;
                }
                this.a.H0.t3();
                if (ze9Var == null || !ze9Var.r0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.H0.p1());
                }
                this.a.H0.x1();
                int i5 = 0;
                if (this.a.J) {
                    this.a.H0.r1();
                } else if (!this.a.H0.R1()) {
                    this.a.H0.H3(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && ze9Var != null) {
                    this.a.P0 = true;
                }
                if (ze9Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.H0.p1());
                    this.a.H0.D3();
                }
                ArrayList<yca> arrayList = null;
                String i1 = null;
                arrayList = null;
                if (z && ze9Var != null) {
                    ThreadData N = ze9Var.N();
                    if (N != null && N.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.P6(pbFragment3.V0);
                    }
                    this.a.H0.h1().r(ze9Var);
                    this.a.H0.O3();
                    if (N != null && N.getCartoonThreadData() != null) {
                        this.a.s7(N.getCartoonThreadData());
                    }
                    if (this.a.W0 != null) {
                        this.a.H0.Z2(this.a.W0.z());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(ze9Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(ze9Var.U().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ze9Var.U().getBimg_end_time());
                    if (ze9Var.F() != null && ze9Var.F().size() >= 1 && ze9Var.F().get(0) != null) {
                        this.a.z0.X2(ze9Var.F().get(0).S());
                    } else if (ze9Var.X() != null) {
                        this.a.z0.X2(ze9Var.X().S());
                    }
                    if (this.a.W0 != null) {
                        this.a.W0.I(ze9Var.c());
                        this.a.W0.J(ze9Var.k(), ze9Var.U());
                        this.a.W0.l0(N);
                        this.a.W0.K(this.a.z0.b1(), this.a.z0.S1(), this.a.z0.X0());
                        if (N != null) {
                            this.a.W0.a0(N.isMutiForumThread());
                        }
                    }
                    if (this.a.B0 != null) {
                        this.a.B0.h(ze9Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (ze9Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (ze9Var.i0()) {
                        this.a.q = true;
                    }
                    this.a.H0.a3(this.a.q);
                    if (this.a.u0.f.size() > 0) {
                        ze9Var.Q0(this.a.u0.f);
                    }
                    this.a.H0.S3(ze9Var, i2, i3, this.a.z0.R1(), i4, this.a.z0.i1());
                    this.a.H0.h4(ze9Var, this.a.z0.R1());
                    this.a.H0.n4(this.a.z0.c1());
                    AntiData c = ze9Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.W0 != null && this.a.W0.b() != null && (o = this.a.W0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.G1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.z0.z1().F()) && !this.a.z0.m2()) {
                        this.a.X = true;
                        this.a.Z4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.S0)) {
                        PbFragment pbFragment5 = this.a;
                        hj9.G(pbFragment5, pbFragment5.z0.y1(), this.a.S0);
                        this.a.S0 = null;
                    } else if (!this.a.R0) {
                        if (!this.a.T0) {
                            if (!TextUtils.isEmpty(this.a.z0.p1())) {
                                jk9.f(this.a.getListView(), this.a.z0.p1());
                                this.a.z0.t2();
                            } else {
                                this.a.H0.N3();
                            }
                        } else {
                            this.a.T0 = false;
                            jk9.j(this.a.getListView());
                        }
                    } else {
                        this.a.R0 = false;
                        hj9.F(this.a);
                    }
                    this.a.z0.u2(ze9Var.k(), this.a.M1);
                    this.a.z0.y2(this.a.O1);
                    if (this.a.Y0 != null && N != null && N.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.getAuthor());
                        this.a.Y0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.z0 != null && this.a.z0.i2()) {
                        i1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.H0 != null) {
                        i1 = this.a.H0.i1();
                    }
                    if (this.a.W0 != null && !StringUtils.isNull(i1)) {
                        this.a.W0.d0(TbSingleton.getInstance().getAdVertiComment(ze9Var.p0(), ze9Var.q0(), i1));
                    }
                } else if (str != null) {
                    if (!this.a.P0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i == 4) {
                                if (this.a.z0.P0() != null && !StringUtils.isNull(this.a.z0.P0().c)) {
                                    this.a.H0.p4(this.a.z0.P0());
                                } else {
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.showNetRefreshView(pbFragment6.H0.p1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    e5a.a("pb", false);
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                                }
                            } else {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.H0.p1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                e5a.a("pb", false);
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            }
                            this.a.H0.r1();
                            this.a.H0.q1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.z0.S1());
                            jSONObject.put("fid", this.a.z0.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        lu6.b().b(new ff5(this.a.z0.S1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.z0 != null && this.a.z0.z1() != null) {
                            arrayList = this.a.z0.z1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).I() != 1)) {
                            this.a.H0.V2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.d6()) {
                                this.a.H0.W2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fe1));
                            } else {
                                this.a.H0.W2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fe2));
                            }
                            this.a.H0.N1(this.a.z0.z1());
                        }
                    } else {
                        this.a.H0.V2("");
                    }
                    this.a.H0.z0();
                }
                if (ze9Var != null && ze9Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (ze9Var != null) {
                        i5 = ze9Var.f();
                    }
                    pbActivity.e2(i5, this.a.H0);
                }
                if (this.a.z0 != null && this.a.z0.z1() != null) {
                    this.a.z0.z1();
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
            dl5 dl5Var = new dl5();
            this.a.P6(dl5Var);
            PbFragment pbFragment = this.a;
            pbFragment.W0 = (el5) dl5Var.a(pbFragment.getContext());
            this.a.W0.X(this.a.a.getPageContext());
            this.a.W0.g0(this.a.l2);
            this.a.W0.h0(this.a.a1);
            el5 el5Var = this.a.W0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            el5Var.B(pageContext, extras);
            this.a.W0.b().F(true);
            this.a.H0.U2(this.a.W0.b());
            if (!this.a.z0.m1()) {
                this.a.W0.q(this.a.z0.S1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.W0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.z0.i2()) {
                this.a.W0.d0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.H0 != null) {
                this.a.W0.d0(this.a.H0.i1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements og<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
            this.a.i7();
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements r55.c {
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

        @Override // com.baidu.tieba.r55.c
        public void a(r55 r55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, r55Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.O0 = pbFragment.O0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.O0);
                    new mh9(this.a.z0.S1(), this.a.O0, "1").start();
                    r55Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.O0 = pbFragment2.O0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.O0);
                    new mh9(this.a.z0.S1(), this.a.O0, "2").start();
                    r55Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.O0 = pbFragment3.O0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.O0);
                    r55Var.e();
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
            this.a.r7();
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            rh9 F0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.H0.j2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.z0.S1());
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
                    this.a.w6(str, i, eVar);
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
                        this.a.r5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.z0.K1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.d6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.z0 != null) {
                            builder.D(this.a.z0.getFromForumId());
                            if (this.a.z0.z1() != null) {
                                builder.Q(this.a.z0.z1().N());
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
                        builder2.I(this.a.z0.K1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.d6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.z0 != null) {
                            builder2.D(this.a.z0.getFromForumId());
                            if (this.a.z0.z1() != null) {
                                builder2.Q(this.a.z0.z1().N());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText u7 = this.a.u7(str, i);
                        if (u7 != null && this.a.z2 >= 0 && this.a.z2 < u7.X().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = af9.a(u7.X().get(this.a.z2));
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
                            if (u7.getPostId() != 0 && (F0 = this.a.H0.F0()) != null) {
                                ArrayList<yn> v = F0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<yn> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        yn next = it.next();
                                        if ((next instanceof yca) && u7.getPostId() == wg.g(((yca) next).S(), 0L)) {
                                            int i9 = 8;
                                            if (u7.getPostId() == wg.g(this.a.z0.X0(), 0L)) {
                                                i9 = 1;
                                            }
                                            xm9.b(this.a.z0.z1(), (yca) next, ((yca) next).e0, i9, 3);
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
                            builder3.I(this.a.z0.K1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.d6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.z0 != null) {
                                builder3.D(this.a.z0.getFromForumId());
                                if (this.a.z0.z1() != null) {
                                    builder3.Q(this.a.z0.z1().N());
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
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.novel_thread_mask_click_tip));
                bdTopToast.i((ViewGroup) this.a.getView());
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
                    pbFragment.hideLoadingView(pbFragment.H0.p1());
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
                    this.a.Q6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e1f);
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
    public class p2 implements r55.c {
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

        @Override // com.baidu.tieba.r55.c
        public void a(r55 r55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, r55Var, i, view2) == null) {
                if (r55Var != null) {
                    r55Var.e();
                }
                PbFragment pbFragment = this.a;
                yca ycaVar = pbFragment.C2;
                if (ycaVar != null) {
                    if (i == 0) {
                        ycaVar.P0();
                        this.a.C2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.o6(pbFragment2.C2);
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
                this.a.m6();
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
                this.a.H0.v1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                ze9 z1 = this.a.z0.z1();
                if (z1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    z1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.d(this.a.f1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.f1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.g7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (xi.isEmpty(errorString2)) {
                        errorString2 = this.a.f1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.g1.c(errorString2);
                } else {
                    this.a.Z6();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements ax4.a {
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

        @Override // com.baidu.tieba.ax4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.H0.t3();
                if (z) {
                    if (this.a.B0 != null) {
                        this.a.B0.h(z2);
                    }
                    this.a.z0.n3(z2);
                    if (!this.a.z0.k1()) {
                        this.a.H0.N1(this.a.z0.z1());
                    } else {
                        this.a.k6();
                    }
                    if (z2) {
                        boolean o0 = this.a.z0.z1().o0();
                        if (this.a.B0 != null && !o0) {
                            if (this.a.B0.f() != null && this.a.z0 != null && this.a.z0.z1() != null && this.a.z0.z1().N() != null && this.a.z0.z1().N().getAuthor() != null) {
                                MarkData f = this.a.B0.f();
                                MetaData author = this.a.z0.z1().N().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
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
                if (this.a.H0 != null && this.a.H0.h1() != null) {
                    gi9 h1 = this.a.H0.h1();
                    if (h1.j()) {
                        h1.h();
                        return true;
                    }
                }
                if (this.a.H0 != null && this.a.H0.a2()) {
                    this.a.H0.z1();
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
                this.a.H0.v1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.d(this.a.f1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (xi.isEmpty(muteMessage)) {
                    muteMessage = this.a.f1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.g1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements r55.c {
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

        @Override // com.baidu.tieba.r55.c
        public void a(r55 r55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, r55Var, i, view2) == null) {
                if (r55Var != null) {
                    r55Var.e();
                }
                if (this.a.k1 != null && !TextUtils.isEmpty(this.a.l1)) {
                    if (i == 0) {
                        if (this.a.n1 != null) {
                            fn5.a aVar = new fn5.a();
                            aVar.a = this.a.l1;
                            String str = "";
                            if (this.a.n1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.n1.memeInfo.pck_id;
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
                        if (this.a.j1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.j1 = new nj9(pbFragment.getPageContext());
                        }
                        this.a.j1.b(this.a.l1, this.a.k1.n());
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
                if (!this.a.b6() || this.a.a == null || this.a.a.K1() == null || !str.equals(this.a.a.K1().getTopicId())) {
                    return;
                }
                this.a.p7(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                p55Var.dismiss();
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.z0 == null || this.a.z0.I1() == i + 1) {
                return;
            }
            this.a.K6(hj9.p(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f35)) {
                f35 f35Var = (f35) customResponsedMessage.getData();
                y35.a aVar = new y35.a();
                int i = f35Var.a;
                String str = f35Var.b;
                aVar.a = f35Var.d;
                ze9 z1 = this.a.z0.z1();
                if (z1 == null) {
                    return;
                }
                if (this.a.z0.b1() != null && this.a.z0.b1().getUserIdLong() == f35Var.p) {
                    this.a.H0.K2(f35Var.l, this.a.z0.z1(), this.a.z0.R1(), this.a.z0.J1());
                }
                if (z1.F() != null && z1.F().size() >= 1 && z1.F().get(0) != null) {
                    long g = wg.g(z1.F().get(0).S(), 0L);
                    long g2 = wg.g(this.a.z0.S1(), 0L);
                    if (g == f35Var.n && g2 == f35Var.m) {
                        y35 Q = z1.F().get(0).Q();
                        if (Q == null) {
                            Q = new y35();
                        }
                        ArrayList<y35.a> a = Q.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        Q.e(Q.b() + f35Var.l);
                        Q.d(a);
                        z1.F().get(0).W0(Q);
                        this.a.H0.F0().f0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yka) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                yka ykaVar = (yka) customResponsedMessage.getData();
                this.a.H0.v1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.e1;
                DataRes dataRes = ykaVar.a;
                boolean z = false;
                if (ykaVar.c == 0 && dataRes != null) {
                    int e = wg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (xi.isEmpty(str)) {
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
                        this.a.H0.z2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.a7(z, sparseArray);
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
            ArrayList<yca> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.z0 != null && this.a.z0.z1() != null && this.a.H0 != null && this.a.H0.F0() != null) {
                this.a.H0.s2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.z0.n2() && (F = this.a.z0.z1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.H0.F0().y()) - 1;
                    ze9 z1 = this.a.z0.z1();
                    if (z1 == null) {
                        return;
                    }
                    if (z1.C() != null && z1.C().z1()) {
                        y--;
                    }
                    if (z1.D() != null && z1.D().z1()) {
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
                if (!hj9.B(this.a.d1) && hj9.B(i)) {
                    if (this.a.H0 != null) {
                        this.a.r0 = true;
                        this.a.H0.s0();
                        if (this.a.W0 != null && !this.a.H0.O1()) {
                            this.a.H0.Z2(this.a.W0.z());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.H0.R2();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.H0 != null) {
                    this.a.H0.t2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new xt5();
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
                    aba.g().h(this.a.getUniqueId(), true);
                    this.a.Z4(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements a65.d {
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

        @Override // com.baidu.tieba.a65.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.N0 != null) {
                this.a.N0.r(fl9.g(this.a.C2));
                ArrayList arrayList = new ArrayList();
                for (z55 z55Var : this.a.N0.g()) {
                    if (z55Var instanceof w55) {
                        arrayList.add((w55) z55Var);
                    }
                }
                fl9.e(arrayList);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof o46)) {
                o46 o46Var = (o46) customResponsedMessage.getData();
                ze9 z1 = this.a.z0.z1();
                if (z1 == null) {
                    return;
                }
                if (this.a.z0.z1() != null && this.a.z0.z1().W().q() != null && this.a.z0.z1().W().q().getPortrait() != null && this.a.z0.z1().W().q().getPortrait().equals(o46Var.a)) {
                    if (this.a.z0.z1().W().q().getUserWorldCupData() != null) {
                        this.a.z0.z1().W().q().getUserWorldCupData().d(o46Var.b);
                    }
                    this.a.H0.L2(this.a.z0.z1(), this.a.z0.R1(), this.a.z0.J1(), this.a.H0.l1());
                }
                if (z1.F() != null && z1.F().size() >= 0) {
                    Iterator<yca> it = z1.F().iterator();
                    while (it.hasNext()) {
                        yca next = it.next();
                        if (next != null && next.q() != null && next.q().getPortrait() != null && next.q().getPortrait().equals(o46Var.a) && next.q().getUserWorldCupData() != null) {
                            next.q().getUserWorldCupData().d(o46Var.b);
                        }
                    }
                    this.a.H0.F0().f0();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.H0.O1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.o5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements al5 {
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

        @Override // com.baidu.tieba.al5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                lj9 lj9Var = this.a.L0;
                if (lj9Var != null && lj9Var.e() != null && this.a.L0.e().d()) {
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
                return pbFragment.h5(view2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.z0 != null && this.a.z0.z1() != null) {
                this.a.z0.z1().a();
                this.a.z0.d2();
                if (this.a.H0.F0() != null) {
                    this.a.H0.N1(this.a.z0.z1());
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
            oca ocaVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oca) && (ocaVar = (oca) customResponsedMessage.getData()) != null && (agreeData = ocaVar.b) != null) {
                if (this.a.H0 != null) {
                    this.a.H0.f2(ocaVar);
                }
                if (agreeData.agreeType == 2 && this.a.H0 != null && !ml9.h(this.a.z0.b)) {
                    this.a.H0.c4();
                    ml9.b(this.a.z0.b);
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
            xca i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.z0 != null && this.a.z0.z1() != null) {
                String str = (String) customResponsedMessage.getData();
                xca xcaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.z0.z1().F() != null) {
                    ArrayList<yca> F = this.a.z0.z1().F();
                    Iterator<yca> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        yca next = it.next();
                        if (next instanceof xca) {
                            xca xcaVar2 = (xca) next;
                            if (str.equals(xcaVar2.A1())) {
                                xcaVar = xcaVar2;
                                break;
                            }
                        }
                    }
                    if (xcaVar != null) {
                        F.remove(xcaVar);
                    }
                }
                if (this.a.H0.F0() != null && !ListUtils.isEmpty(this.a.H0.F0().v())) {
                    ArrayList<yn> v = this.a.H0.F0().v();
                    if (xcaVar != null) {
                        i = xcaVar;
                    } else {
                        i = hj9.i(this.a.z0.z1(), str);
                    }
                    hj9.e(v, i);
                }
                if (this.a.H0.X0() != null && !ListUtils.isEmpty(this.a.H0.X0().getData())) {
                    List<yn> data = this.a.H0.X0().getData();
                    if (xcaVar == null) {
                        xcaVar = hj9.i(this.a.z0.z1(), str);
                    }
                    hj9.e(data, xcaVar);
                }
                this.a.j5(str);
                this.a.z0.d2();
                if (this.a.H0.F0() != null) {
                    this.a.H0.F0().f0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.L5() != null) {
                this.a.L5().p2();
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
        public void onNavigationButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) == null) {
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
            this.a.k5();
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
    public class x1 extends k9 {
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

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.C0.getLoadDataMode()) {
                    case 0:
                        this.a.z0.d2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.p5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.H0.B0(1, dVar.a, dVar.b, true);
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
                        this.a.H0.B0(this.a.C0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.H0.u2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.H0.B0(this.a.C0.getLoadDataMode(), false, null, false);
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
        public void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.z0.o1()) {
                    this.a.E6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
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
        public void a(mk9 mk9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, mk9Var) != null) || mk9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, mk9Var.a()));
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
        public void onNavigationButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) && p55Var != null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements og<LinearLayout> {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
                        this.a.u6();
                        return;
                    } else {
                        this.a.G6();
                        return;
                    }
                }
                this.a.r0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.U5();
                w35 x1 = this.a.z0.x1();
                int e1 = this.a.H0.e1();
                if (e1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fe4);
                } else if (x1 != null && e1 > x1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fe4);
                } else {
                    this.a.H0.s0();
                    this.a.l7();
                    this.a.H0.u3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.z0.l3(this.a.H0.e1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e1f);
                    }
                    p55Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 implements sa5.g {
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

        @Override // com.baidu.tieba.sa5.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.z0.x2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H0.A0();
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

    public static PbFragment q6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65679, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public PbInterviewStatusView.f A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.x0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.c && this.N2 == -1 && this.O2 == -1) {
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
            return this.m2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.i36
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ij9 ij9Var = this.H0;
            if (ij9Var == null) {
                return 0;
            }
            return ij9Var.k1();
        }
        return invokeV.intValue;
    }

    public boolean D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i36
    /* renamed from: E5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ij9 ij9Var = this.H0;
            if (ij9Var == null) {
                return null;
            }
            return ij9Var.X0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void E6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            hideNetRefreshView(this.H0.p1());
            b7();
            if (this.z0.z2()) {
                this.H0.u3();
            }
            this.H0.D3();
        }
    }

    public int F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<TiebaPlusRecommendCard> G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.C == null) {
                this.C = new ng<>(new k2(this), 5, 0);
            }
            return this.C;
        }
        return (ng) invokeV.objValue;
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.N2;
        }
        return invokeV.intValue;
    }

    public void G6() {
        zg5 zg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (zg5Var = this.j0) != null) {
            zg5Var.x();
        }
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
    public final ze9 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.z1();
            }
            return null;
        }
        return (ze9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (ng) invokeV.objValue;
    }

    public ok9 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.a.I0();
        }
        return (ok9) invokeV.objValue;
    }

    public el5 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.W0;
        }
        return (el5) invokeV.objValue;
    }

    public pk9 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.e;
        }
        return (pk9) invokeV.objValue;
    }

    public dl9 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.u0;
        }
        return (dl9) invokeV.objValue;
    }

    public ij9 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.H0;
        }
        return (ij9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn9
    public PbModel.h M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.p2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public String N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn9
    public PbModel Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.z0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<RelativeLayout> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ng<RelativeLayout> ngVar = new ng<>(new m2(this), 10, 0);
            this.E = ngVar;
            return ngVar;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<ImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.A == null) {
                this.A = new ng<>(new i2(this), 8, 0);
            }
            return this.A;
        }
        return (ng) invokeV.objValue;
    }

    public void V5() {
        ij9 ij9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (ij9Var = this.H0) != null) {
            ij9Var.t1();
            U5();
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<View> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.B == null) {
                this.B = new ng<>(new l2(this), 8, 0);
            }
            return this.B;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn9
    public AbsPbActivity X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final void X5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new k0(this));
        }
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            ll9 ll9Var = new ll9(getPageContext());
            ll9Var.m();
            this.Z0 = ll9Var;
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (ng) invokeV.objValue;
    }

    public boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.e1();
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
            if (absPbActivity != null && absPbActivity.K1() != null && this.a.K1().y1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.c1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            ze9 z12 = this.z0.z1();
            this.z0.n3(true);
            ax4 ax4Var = this.B0;
            if (ax4Var != null) {
                z12.J0(ax4Var.g());
            }
            this.H0.N1(z12);
        }
    }

    public void l6() {
        ij9 ij9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048694, this) != null) || (ij9Var = this.H0) == null) {
            return;
        }
        ij9Var.c2();
    }

    public final void l7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void m7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<ItemCardView> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            if (this.F == null) {
                this.F = new ng<>(new n2(this), 10, 0);
            }
            return this.F;
        }
        return (ng) invokeV.objValue;
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
    public co onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (co) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            E6();
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
            if (pbModel != null && pbModel.z1() != null) {
                return this.z0.z1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (pbModel = this.z0) != null && !xi.isEmpty(pbModel.S1())) {
            super.taskStart();
        }
    }

    public yca u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            ze9 ze9Var = this.z0.G;
            if (ze9Var != null) {
                return ze9Var.W();
            }
            return null;
        }
        return (yca) invokeV.objValue;
    }

    public void u6() {
        zg5 zg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && (zg5Var = this.j0) != null) {
            zg5Var.q();
        }
    }

    public int v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.R2;
        }
        return invokeV.intValue;
    }

    public String w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            if (this.L == null) {
                this.L = new ng<>(new j2(this), 20, 0);
            }
            return this.L;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.D == null) {
                this.D = new ng<>(new y2(this), 15, 0);
            }
            return this.D;
        }
        return (ng) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r2();
        }
        return invokeV.booleanValue;
    }

    public boolean z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            zg5 zg5Var = this.j0;
            if (zg5Var != null && zg5Var.t()) {
                return true;
            }
            return false;
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
        this.V1 = new gg9(new m0(this));
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

    @Override // com.baidu.tieba.bn9
    public void finish() {
        ij9 ij9Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            ij9 ij9Var2 = this.H0;
            if (ij9Var2 != null) {
                ij9Var2.s0();
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null && !this.z0.z1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.z0.z1().N().getId();
                if (this.z0.isShareThread() && this.z0.z1().N().originalThreadData != null) {
                    historyMessage.threadName = this.z0.z1().N().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.z0.z1().N().getTitle();
                }
                if (this.z0.isShareThread() && !z0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.z0.z1().k().getName();
                }
                ArrayList<yca> F = this.z0.z1().F();
                ij9 ij9Var3 = this.H0;
                if (ij9Var3 != null) {
                    i3 = ij9Var3.O0();
                } else {
                    i3 = 0;
                }
                if (F != null && i3 >= 0 && i3 < F.size()) {
                    historyMessage.postID = F.get(i3).S();
                }
                historyMessage.isHostOnly = this.z0.c1();
                historyMessage.isSquence = this.z0.R1();
                historyMessage.isShareThread = this.z0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && (pbModel2.e1() || this.z0.h1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.z0.S1());
                if (this.I0) {
                    if (this.K0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.z0.n1());
                    }
                    if (this.J0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.z0.j1());
                    }
                }
                if (this.z0.h1() && this.z0.z1() != null && this.z0.z1().N() != null) {
                    lu6.b().b(new rl5(this.z0.Y()));
                }
                if (this.z0.z1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.z0.z1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.q1);
                }
                this.a.setResult(-1, intent);
            }
            if (n7()) {
                if (this.z0 != null && (ij9Var = this.H0) != null && ij9Var.X0() != null) {
                    ze9 z12 = this.z0.z1();
                    if (z12 != null) {
                        if (z12.U() != null) {
                            z12.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            z12.U().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!z12.r0() && !this.I && z12.h == null) {
                            yi9 b4 = yi9.b();
                            ze9 A1 = this.z0.A1();
                            Parcelable onSaveInstanceState = this.H0.X0().onSaveInstanceState();
                            boolean R1 = this.z0.R1();
                            boolean c12 = this.z0.c1();
                            if (this.H0.f1() != null && this.H0.f1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(A1, onSaveInstanceState, R1, c12, z3);
                            if (this.p1 >= 0 || this.z0.U1() != null) {
                                yi9.b().o(this.z0.U1());
                                yi9.b().p(this.z0.V1());
                                yi9.b().m(this.z0.s1());
                            }
                        }
                    }
                } else {
                    yi9.b().k();
                }
                m7();
            }
            ll9 ll9Var = this.Z0;
            if (ll9Var != null && !ll9Var.o() && c5() && this.z0.h1() && !TextUtils.isEmpty(this.z0.Y())) {
                this.Z0.n(this.z0.z1().g().l, this.z0.Y());
            }
        }
    }

    @Override // com.baidu.tieba.i36
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.i36
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            oj9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.i36
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048681, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ij9 ij9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048717, this, i3, keyEvent)) == null) {
            if (keyEvent != null && (ij9Var = this.H0) != null) {
                return ij9Var.k2(i3);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void F6(c3 c3Var) {
        List<c3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, c3Var) == null) && c3Var != null && (list = this.r1) != null) {
            list.remove(c3Var);
        }
    }

    public final void K6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i3) == null) && this.z0 != null) {
            b7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.z0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void L6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i3) == null) {
            this.R2 = i3;
        }
    }

    public void M6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z3) == null) {
            this.m2 = Boolean.valueOf(z3);
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z3) == null) {
            this.s0 = z3;
        }
    }

    public void O6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z3) == null) {
            this.N = z3;
        }
    }

    public void R6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void S6(boolean z3) {
        el5 el5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048625, this, z3) != null) || (el5Var = this.W0) == null) {
            return;
        }
        el5Var.Y(z3);
        this.W0.b0(z3);
        this.W0.j0(z3);
    }

    public final void T5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, intent) == null) {
            ml9.g(this, intent);
        }
    }

    public void U4(c3 c3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, c3Var) == null) && c3Var != null) {
            if (this.r1 == null) {
                this.r1 = new ArrayList();
            }
            if (!this.r1.contains(c3Var)) {
                this.r1.add(c3Var);
            }
        }
    }

    public void V4(c3 c3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, c3Var) == null) && c3Var != null) {
            if (this.r1 == null) {
                this.r1 = new ArrayList();
            }
            if (!this.r1.contains(c3Var)) {
                this.r1.add(0, c3Var);
            }
        }
    }

    public final void f6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            nx4.y(getContext(), "", str, false, true, true, bundle);
        }
    }

    public final void f7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i3) == null) {
            ml9.j(this, t5(), i3);
        }
    }

    @Override // com.baidu.tieba.kn9.b
    public void l1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z3) == null) {
            this.Q0 = z3;
        }
    }

    public final void n6(View view2) {
        SparseArray sparseArray;
        yca ycaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (ycaVar = (yca) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            o6(ycaVar);
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

    @Override // com.baidu.tieba.p55.e
    public void onClick(p55 p55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, p55Var) == null) {
            m5(p55Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.q9
    public void onPreLoad(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, coVar) == null) {
            PreLoadImageHelper.load(coVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(coVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.z0.T2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            el5 el5Var = this.W0;
            if (el5Var != null) {
                el5Var.G(bundle);
            }
        }
    }

    public final void s7(o25 o25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, o25Var) == null) && o25Var != null) {
            this.Q2 = o25Var;
            this.c = true;
            this.H0.P2();
            this.H0.i3(this.P2);
        }
    }

    public final void A6(View view2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null) {
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

    public final void P5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void g7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            if (str == null) {
                str = "";
            }
            l9 l9Var = this.f1;
            if (l9Var == null) {
                return;
            }
            p55 p55Var = new p55(l9Var.getPageActivity());
            p55Var.setMessage(str);
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3d, new e(this));
            p55Var.create(this.f1).show();
        }
    }

    public final void j7(SparseArray<Object> sparseArray) {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048688, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof yca) || (ycaVar = (yca) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        k7(ycaVar, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z3) == null) {
            super.onUserChanged(z3);
            this.H0.o4(z3);
            y55 y55Var = this.M0;
            if (y55Var != null) {
                y55Var.dismiss();
            }
            if (z3 && this.Q0) {
                this.H0.v3();
                this.z0.v2(true);
            }
            if (this.H0.F0() != null) {
                this.H0.F0().j0(z3);
            }
        }
    }

    public final void q7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.z0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fl9.m(i3))));
        }
    }

    public final void r5(Rect rect) {
        ij9 ij9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048732, this, rect) == null) && rect != null && (ij9Var = this.H0) != null && ij9Var.o1() != null && rect.top <= this.H0.o1().getHeight()) {
            rect.top += this.H0.o1().getHeight() - rect.top;
        }
    }

    public void B6(qf9 qf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qf9Var) == null) {
            String S = qf9Var.g().S();
            List<yca> list = this.z0.z1().S().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                yca ycaVar = list.get(i3);
                if (ycaVar.S() != null && ycaVar.S().equals(S)) {
                    ArrayList<yca> i4 = qf9Var.i();
                    ycaVar.m1(qf9Var.k());
                    if (ycaVar.i0() != null) {
                        ycaVar.i0().clear();
                        ycaVar.i0().addAll(i4);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.z0.i1()) {
                this.H0.N1(this.z0.z1());
            }
        }
    }

    public final void S5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null && this.z0.z1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.z0.S1(), str);
                ThreadData N = this.z0.z1().N();
                if (N.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (N.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (N.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                f6(format);
                return;
            }
            this.A0.a(str);
        }
    }

    public final void Y6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048647, this, metaData) != null) || metaData == null) {
            return;
        }
        p55 p55Var = new p55(getActivity());
        p55Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0c3d));
        p55Var.setTitleShowCenter(true);
        p55Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0c3e));
        p55Var.setMessageShowCenter(true);
        p55Var.setCancelable(false);
        p55Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c3f), new r1(this, metaData));
        p55Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c40), new s1(this, metaData));
        p55Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void e7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && Q() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                Q().I0(postWriteCallBackData.getPostId());
                int K0 = this.H0.K0();
                this.p1 = K0;
                this.z0.W2(K0, this.H0.R0());
            }
            this.H0.s0();
            this.L0.c();
            el5 el5Var = this.W0;
            if (el5Var != null) {
                this.H0.Z2(el5Var.z());
            }
            this.H0.t1();
            this.H0.H3(true);
            this.z0.d2();
        }
    }

    public final void j5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048686, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.z0) != null && pbModel.z1() != null) {
            xca z3 = this.z0.z1().z();
            if (z3 != null && str.equals(z3.A1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.z0.z1().b();
            }
            xca S0 = this.z0.S0();
            if (S0 != null && str.equals(S0.A1())) {
                this.z0.F0();
            }
        }
    }

    public void o6(yca ycaVar) {
        boolean z3;
        yca u5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048704, this, ycaVar) != null) || ycaVar == null) {
            return;
        }
        if (ycaVar.S() != null && ycaVar.S().equals(this.z0.u1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData t12 = this.z0.t1(ycaVar);
        if (this.z0.z1() != null && this.z0.z1().i0() && (u5 = u5()) != null) {
            t12 = this.z0.t1(u5);
        }
        if (t12 == null) {
            return;
        }
        this.H0.u3();
        ax4 ax4Var = this.B0;
        if (ax4Var != null) {
            ax4Var.i(t12);
            if (!z3) {
                this.B0.a();
            } else {
                this.B0.d();
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
        this.H0.g2(i3);
        el5 el5Var = this.W0;
        if (el5Var != null && el5Var.b() != null) {
            this.W0.b().z(i3);
        }
        if (this.H0.a() != null) {
            this.H0.a().d(getPageContext(), i3);
        }
        this.L0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.W = i3;
        l7();
        zg5 zg5Var = this.j0;
        if (zg5Var != null) {
            zg5Var.w();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (f36[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), f36.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (oj9.c(objArr[i3].f()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new g06(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i36
    public void Z(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048648, this, context, str, z3) == null) {
            if (oj9.c(str) && (pbModel = this.z0) != null && pbModel.S1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.z0.S1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    ki5 ki5Var = new ki5();
                    ki5Var.a = str;
                    ki5Var.b = 3;
                    ki5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, ki5Var));
                }
            } else {
                oj9.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public void C6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z3, markData) == null) {
            this.H0.t3();
            this.z0.n3(z3);
            ax4 ax4Var = this.B0;
            if (ax4Var != null) {
                ax4Var.h(z3);
                if (markData != null) {
                    this.B0.i(markData);
                }
            }
            if (this.z0.k1()) {
                k6();
            } else {
                this.H0.N1(this.z0.z1());
            }
        }
    }

    public void D6(qf9 qf9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, qf9Var) != null) || qf9Var.g() == null) {
            return;
        }
        String S = qf9Var.g().S();
        ArrayList<yca> F = this.z0.z1().F();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= F.size()) {
                break;
            }
            yca ycaVar = F.get(i3);
            if (ycaVar.S() != null && ycaVar.S().equals(S)) {
                ArrayList<yca> i4 = qf9Var.i();
                ycaVar.m1(qf9Var.k());
                if (ycaVar.i0() != null && i4 != null) {
                    Iterator<yca> it = i4.iterator();
                    while (it.hasNext()) {
                        yca next = it.next();
                        if (ycaVar.r0() != null && next != null && next.q() != null && (metaData = ycaVar.r0().get(next.q().getUserId())) != null) {
                            next.N0(metaData);
                            next.c1(true);
                            next.w1(getPageContext(), this.z0.s2(metaData.getUserId()));
                        }
                    }
                    if (i4.size() == ycaVar.i0().size()) {
                        z3 = false;
                    }
                    if (!ycaVar.y0(false)) {
                        ycaVar.i0().clear();
                        ycaVar.i0().addAll(i4);
                    }
                }
                if (ycaVar.C() != null) {
                    ycaVar.L0();
                }
            } else {
                i3++;
            }
        }
        if (!this.z0.i1() && z3) {
            this.H0.N1(this.z0.z1());
        }
        if (z3) {
            B6(qf9Var);
        }
    }

    public void Z4(boolean z3) {
        ij9 ij9Var;
        int i3;
        int y3;
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) && (ij9Var = this.H0) != null && ij9Var.X0() != null) {
            int firstVisiblePosition = this.H0.X0().getFirstVisiblePosition();
            int lastVisiblePosition = this.H0.X0().getLastVisiblePosition();
            rh9 F0 = this.H0.F0();
            if (F0 != null && this.z0.z1() != null) {
                if (lastVisiblePosition <= F0.y()) {
                    i3 = 0;
                    y3 = 1;
                } else {
                    if (firstVisiblePosition > F0.y()) {
                        i3 = firstVisiblePosition - F0.y();
                    } else {
                        i3 = 0;
                    }
                    y3 = (lastVisiblePosition - F0.y()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (y3 > i3) {
                    while (i3 < y3) {
                        if (this.H0.X0().G(i3) != null && (this.H0.X0().G(i3) instanceof yca) && (ycaVar = (yca) this.H0.X0().G(i3)) != null) {
                            yca ycaVar2 = (yca) ListUtils.getItem(this.z0.z1().F(), ycaVar.I() - 1);
                            if (ycaVar.n() == null && ycaVar2 != null) {
                                ycaVar.M0(ycaVar2.n());
                            }
                            if (ycaVar.n() != null) {
                                ycaVar.n().setFloonumber(ycaVar.I());
                                arrayList.add(ycaVar.n());
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
                            this.H0.D2(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.H0.D2(adverSegmentData, 1);
                }
            }
        }
    }

    public final boolean p6(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048728, this, ycaVar)) == null) {
            if (ycaVar == null) {
                return false;
            }
            String S = ycaVar.S();
            if (StringUtils.isNull(S) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String w3 = da5.p().w("bubble_link", "");
            if (StringUtils.isNull(w3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = ycaVar.n0().getJumpUrl();
            int packageId = ycaVar.n0().getPackageId();
            int propsId = ycaVar.n0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                nx4.s(getPageContext().getPageActivity(), cea.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                nx4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), w3 + "?props_id=" + S, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void t7(int i3) {
        PbModel pbModel;
        ThreadData N;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048740, this, i3) != null) || (pbModel = this.z0) == null || pbModel.z1() == null || (N = this.z0.z1().N()) == null) {
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
        if (this.z0.R1()) {
            this.H0.F0().f0();
        } else {
            this.H0.v4(this.z0.z1());
        }
    }

    public final AbsPbActivity.e y6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048755, this, str)) == null) {
            String str2 = null;
            if (this.z0.z1() != null && this.z0.z1().F() != null && this.z0.z1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.z0.z1().F().size()) {
                        if (str.equals(this.z0.z1().F().get(i3).S())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                yca ycaVar = this.z0.z1().F().get(i3);
                if (ycaVar.e0() != null && ycaVar.e0().X() != null) {
                    Iterator<TbRichTextData> it = ycaVar.e0().X().iterator();
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
                    w6(str2, 0, eVar);
                    af9.b(ycaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final boolean H6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof yca)) {
                return false;
            }
            yca ycaVar = (yca) obj;
            if (ycaVar.getType() != yca.a1 && !TextUtils.isEmpty(ycaVar.t()) && a15.c().g()) {
                return p6(ycaVar);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null) {
                if (L5().h1() != null) {
                    L5().h1().g();
                }
                qf9 qf9Var = new qf9();
                qf9Var.v(this.z0.z1().k());
                qf9Var.z(this.z0.z1().N());
                qf9Var.x(ycaVar);
                L5().g1().r0(qf9Var);
                L5().g1().setPostId(ycaVar.S());
                j6(view2, ycaVar.q().getUserId(), "", ycaVar);
                TiebaStatic.log("c11743");
                el5 el5Var = this.W0;
                if (el5Var != null) {
                    this.H0.Z2(el5Var.z());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (pbModel = this.z0) != null && pbModel.z1() != null && this.z0.z1().N() != null && this.z0.z1().N().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void J6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (pbModel = this.z0) != null && pbModel.z1() != null && this.z0.z1().N() != null && this.z0.z1().N().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            yi.A(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean X6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || !pbModel.R1()) {
                return false;
            }
            if (this.z0.x1() != null && this.z0.x1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null && this.z0.z1().g() != null && !TextUtils.isEmpty(this.z0.z1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && zl9.b() && !this.H0.C2()) {
            zg5 i3 = ah5.i(getPageContext(), "reply_pb", 0L);
            this.j0 = i3;
            if (i3 != null) {
                bx9.e().h("reply_pb");
            }
        }
    }

    public final void d7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && zl9.a() && !this.H0.C2()) {
            zg5 i3 = ah5.i(getPageContext(), "collect", 0L);
            this.j0 = i3;
            if (i3 != null) {
                bx9.e().h("collect");
            }
        }
    }

    public final boolean e6() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (zd9.c() && (pbModel = this.z0) != null && pbModel.z1() != null && this.z0.z1().i() != null && this.z0.z1().i().x() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && (pbModel = this.z0) != null && !xi.isEmpty(pbModel.S1())) {
            bu4.w().Q(au4.Z, wg.g(this.z0.S1(), 0L));
        }
    }

    public void r6() {
        List<c3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && (list = this.r1) != null && !list.isEmpty()) {
            int size = this.r1.size();
            while (true) {
                size--;
                if (size <= -1 || this.r1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void s6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.H0.s0();
            if (this.h) {
                return;
            }
            l7();
            this.H0.u3();
            if (this.z0.loadData()) {
                this.H0.Z3();
            }
        }
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (this.z0.z1() != null && this.z0.z1().N() != null) {
                return this.z0.z1().N().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.F0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.F0 = pollingModel;
                pollingModel.N0(l65.e);
            }
            this.F0.D0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            zg.a().postDelayed(this.W1, 10000L);
        }
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.m1 != null) {
                fn5.b bVar = new fn5.b();
                bVar.a = this.m1.Y();
                bVar.b = this.m1.W();
                bVar.c = String.valueOf(this.m1.Z());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l1));
        }
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            p55 p55Var = new p55(getPageContext().getPageActivity());
            p55Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            p55Var.setPositiveButton(R.string.open_now, new c(this));
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new d(this));
            p55Var.create(this.f1).show();
        }
    }

    public final boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || pbModel.z1() == null) {
                return false;
            }
            ThreadData N = this.z0.z1().N();
            AntiData c4 = this.z0.z1().c();
            if (!AntiHelper.b(getPageContext(), N) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            showLoadingView(this.H0.p1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.H0.o1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final boolean c6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            yca c4 = af9.c(this.z0.z1(), this.z0.R1(), this.z0.J1());
            if (c4 != null && c4.q() != null && c4.q().getGodUserData() != null && c4.q().getGodUserData().getType() == 2) {
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
            if ((this.z0.z1() != null && (this.z0.z1().i0() || ThreadCardUtils.isSelf(this.z0.z1().N()))) || this.Y0 == null || this.z0.z1() == null || this.z0.z1().c() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.z0.z1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void g5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            if (this.z0.e1() || this.z0.h1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.z0.S1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.z0.S1()));
            if (n7()) {
                this.a.finish();
            }
        }
    }

    public final void g6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && this.Q2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fde);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.Q2.a(), this.O2, 0)));
                this.a.finish();
            }
        }
    }

    public final void i6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && this.Q2 != null) {
            if (this.N2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fdf);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.Q2.a(), this.N2, 0)));
                this.a.finish();
            }
        }
    }

    public final void o7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && (absPbActivity = this.a) != null && absPbActivity.K1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K1().S1()).param("topic_id", this.a.K1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.K1().W1()));
        }
    }

    public final void r7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.a0(this.z0.getForumId()) && this.z0.z1() != null && this.z0.z1().k() != null) {
            boolean z3 = true;
            if (this.z0.z1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.z0.N0().Z(this.z0.getForumId(), this.z0.S1());
            }
        }
    }

    public void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.z0.z1() != null && this.z0.z1().N() != null && this.z0.z1().N().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.z0.z1().N().getTaskInfoData().k(), this.z0.z1().N().getTaskInfoData().h(), this.z0.z1().N().getTaskInfoData().c(), this.z0.z1().N().getTaskInfoData().d(), this.z0.z1().N().getIs_top(), this.z0.z1().N().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null) {
                xca z3 = this.z0.z1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.z0.z1().b();
                }
                if (this.z0.S0() != null) {
                    this.z0.F0();
                }
                this.z0.d2();
            }
            if (this.z0.z1().F() != null) {
                Iterator<yca> it = this.z0.z1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof xca) {
                        it.remove();
                    }
                }
            }
            if (this.H0.F0() != null && !ListUtils.isEmpty(this.H0.F0().v())) {
                hj9.d(this.H0.F0().v());
            }
            if (this.H0.X0() != null && !ListUtils.isEmpty(this.H0.X0().getData())) {
                hj9.d(this.H0.X0().getData());
            }
            if (this.H0.F0() != null) {
                this.H0.F0().f0();
            }
        }
    }

    public final boolean n7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.z1() != null && this.z0.z1().i0()) {
                return true;
            }
            if (this.z0.k1()) {
                MarkData V0 = this.z0.V0();
                if (V0 == null || !this.z0.i1()) {
                    return true;
                }
                MarkData Q0 = this.z0.Q0(this.H0.O0());
                if (Q0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", V0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (Q0.getPostId() != null && !Q0.getPostId().equals(V0.getPostId())) {
                    p55 p55Var = new p55(getPageContext().getPageActivity());
                    p55Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0298));
                    p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new e2(this, Q0, V0, p55Var));
                    p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new g2(this, V0, p55Var));
                    p55Var.setOnCalcelListener(new h2(this, V0, p55Var));
                    p55Var.create(getPageContext());
                    p55Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", V0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.z0.z1() != null && this.z0.z1().F() != null && this.z0.z1().F().size() > 0 && this.z0.i1()) {
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
            ij9 ij9Var = this.H0;
            if (ij9Var != null && ij9Var.p1() != null) {
                if (!this.g) {
                    b7();
                } else {
                    hideLoadingView(this.H0.p1());
                }
                this.H0.q2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            ij9 ij9Var2 = this.H0;
            if (ij9Var2 != null) {
                noNetworkView = ij9Var2.a();
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
            J6();
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.a2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.o1) {
                E6();
                this.o1 = false;
            }
            i7();
            ItemCardHelper.w(this.I2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                si5.q().w(downloadData);
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
            if (L5().h1() != null) {
                L5().h1().n();
            }
            xl9 xl9Var = this.H0.k;
            if (xl9Var != null && !xl9Var.n()) {
                this.H0.k.r();
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null && this.z0.z1().k() != null && this.z0.z1().N() != null) {
                pi5.j().x(getPageContext().getPageActivity(), "pb", this.z0.z1().k().getId(), wg.g(this.z0.z1().N().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            aba.g().h(getUniqueId(), false);
        }
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<yca> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || pbModel.z1() == null || this.z0.z1().F() == null || (count = ListUtils.getCount((F = this.z0.z1().F()))) == 0) {
                return "";
            }
            if (this.z0.K1()) {
                Iterator<yca> it = F.iterator();
                while (it.hasNext()) {
                    yca next = it.next();
                    if (next != null && next.I() == 1) {
                        return next.S();
                    }
                }
            }
            int O0 = this.H0.O0();
            yca ycaVar = (yca) ListUtils.getItem(F, O0);
            if (ycaVar != null && ycaVar.q() != null) {
                if (this.z0.s2(ycaVar.q().getUserId())) {
                    return ycaVar.S();
                }
                for (int i3 = O0 - 1; i3 != 0; i3--) {
                    yca ycaVar2 = (yca) ListUtils.getItem(F, i3);
                    if (ycaVar2 == null || ycaVar2.q() == null || ycaVar2.q().getUserId() == null) {
                        break;
                    } else if (this.z0.s2(ycaVar2.q().getUserId())) {
                        return ycaVar2.S();
                    }
                }
                for (int i4 = O0 + 1; i4 < count; i4++) {
                    yca ycaVar3 = (yca) ListUtils.getItem(F, i4);
                    if (ycaVar3 == null || ycaVar3.q() == null || ycaVar3.q().getUserId() == null) {
                        break;
                    } else if (this.z0.s2(ycaVar3.q().getUserId())) {
                        return ycaVar3.S();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.z1() != null && this.z0.z1().k() != null) {
                if (a5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.z0.z1().i0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.H0.j0();
                    return;
                } else {
                    el5 el5Var = this.W0;
                    if (el5Var != null && el5Var.b() != null) {
                        this.W0.b().D(new zi5(45, 27, null));
                    }
                    this.H0.j0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void P6(fl5 fl5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, fl5Var) == null) && fl5Var != null && (pbModel = this.z0) != null) {
            fl5Var.p(pbModel.Y0());
            if (this.z0.z1() != null && this.z0.z1().k() != null) {
                fl5Var.o(this.z0.z1().k());
            }
            fl5Var.q("pb");
            fl5Var.r(this.z0);
            fl5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void Q6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048620, this, i3) != null) || (pbModel = this.z0) == null) {
            return;
        }
        int I1 = pbModel.I1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.z0.h3(1);
                } else {
                    this.z0.h3(4);
                }
            } else {
                this.z0.h3(3);
            }
        } else {
            this.z0.h3(2);
        }
        int I12 = this.z0.I1();
        if (I1 == 4 || I12 == 4) {
            s6();
        }
    }

    public final void W5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            ax4 c4 = ax4.c(this.a);
            this.B0 = c4;
            if (c4 != null) {
                c4.j(this.s2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.C0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.u2);
            this.D0 = new sf5(getPageContext());
            M5();
            this.P1.setUniqueId(getUniqueId());
            this.P1.registerListener();
            Y5();
        }
    }

    public void W6(View view2) {
        ze9 H5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, view2) == null) {
            int q3 = da5.p().q(da5.t("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.a;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (q3 != 1 && q3 != 2 && q3 != 3)) && (H5 = H5()) != null) {
                gl9.d(getContext(), view2, H5);
            }
        }
    }

    public void b5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.H0.P3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = wg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = wg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.h1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.e1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean e5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i3)) == null) {
            if (this.Y0 != null && this.z0.z1() != null && !ThreadCardUtils.isSelf(this.z0.z1().N()) && this.z0.z1().c() != null) {
                return this.Y0.checkPrivacyBeforeSend(this.z0.z1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void h6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, bundle) == null) {
            PbModel K1 = this.a.K1();
            this.z0 = K1;
            if (K1 != null) {
                if (K1.U0() != null) {
                    this.z0.U0().c(this.M2);
                }
                if (this.z0.v1() != null) {
                    this.z0.v1().f(this.v1);
                }
                if (StringUtils.isNull(this.z0.S1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.z0.e3(6);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        ij9 ij9Var;
        xl9 xl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (ij9Var = this.H0) != null && (xl9Var = ij9Var.k) != null && xl9Var.n()) {
                this.H0.k.g();
                t6();
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
            ij9 ij9Var2 = this.H0;
            if (ij9Var2 != null) {
                ij9Var2.h2(configuration);
            }
            y55 y55Var = this.M0;
            if (y55Var != null) {
                y55Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public final void p7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048729, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.K1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K1().S1()).param("topic_id", this.a.K1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.K1().W1()));
        }
    }

    public void v6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048747, this, animatorListener) == null) && this.H0 != null && (pbModel = this.z0) != null && pbModel.z1() != null && this.z0.z1().R() != null && checkUpIsLogin() && this.H0.F0() != null && this.H0.F0().B() != null) {
            this.H0.F0().B().U(animatorListener);
        }
    }

    public final void Q5(int i3, Intent intent) {
        mj5 mj5Var;
        mj5 mj5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048619, this, i3, intent) == null) {
            if (i3 == 0) {
                this.H0.t1();
                this.H0.h1().g();
                this.H0.H3(false);
            }
            this.H0.R2();
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
                if (editorType == 1 && this.H0.h1() != null && this.H0.h1().f() != null) {
                    hl5 f3 = this.H0.h1().f();
                    f3.f0(this.z0.z1().N());
                    f3.D(writeData);
                    f3.g0(pbEditorData.getVoiceModel());
                    lj5 p3 = f3.b().p(6);
                    if (p3 != null && (mj5Var2 = p3.m) != null) {
                        mj5Var2.B(new zi5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f3.I();
                        return;
                    }
                    return;
                }
                return;
            }
            el5 el5Var = this.W0;
            if (el5Var != null) {
                el5Var.M();
                this.W0.n0(pbEditorData.getVoiceModel());
                this.W0.C(writeData);
                lj5 p4 = this.W0.b().p(6);
                if (p4 != null && (mj5Var = p4.m) != null) {
                    mj5Var.B(new zi5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.W0.i0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.W0.H(null, null);
                }
            }
        }
    }

    public final void U6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048631, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (L5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        dh5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            de9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            de9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            de9.e(getResources().getString(R.string.obfuscated_res_0x7f0f146b));
                            return;
                        } else {
                            de9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.z0.m1()) {
                antiData.setBlock_forum_name(this.z0.z1().k().getName());
                antiData.setBlock_forum_id(this.z0.z1().k().getId());
                antiData.setUser_name(this.z0.z1().U().getUserName());
                antiData.setUser_id(this.z0.z1().U().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void a7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048655, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            y55 y55Var = this.M0;
            if (y55Var != null && y55Var.isShowing()) {
                this.M0.dismiss();
                this.M0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            a65 a65Var = new a65(getContext());
            a65Var.q(new e0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i3 == 1) {
                arrayList.add(new w55(0, getResources().getString(R.string.obfuscated_res_0x7f0f0546), a65Var));
            }
            if (z3) {
                arrayList.add(new w55(1, getResources().getString(R.string.un_mute), a65Var));
            } else {
                arrayList.add(new w55(1, getResources().getString(R.string.obfuscated_res_0x7f0f0cf7), a65Var));
            }
            a65Var.l(arrayList);
            y55 y55Var2 = new y55(getPageContext(), a65Var);
            this.M0 = y55Var2;
            y55Var2.l();
        }
    }

    public final void k7(yca ycaVar, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048691, this, ycaVar, z3) == null) {
            M6(false);
            if (ycaVar == null || (pbModel = this.z0) == null || pbModel.z1() == null || ycaVar.I() == 1) {
                return;
            }
            String S1 = this.z0.S1();
            String S = ycaVar.S();
            if (this.z0.z1() != null) {
                i3 = this.z0.z1().V();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e y6 = y6(S);
            if (y6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo l02 = ycaVar.l0();
            AntiData c4 = this.z0.z1().c();
            if (ycaVar.q() != null) {
                arrayList = ycaVar.q().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(S1, S, "pb", true, false, null, false, null, i3, l02, c4, false, arrayList, 5).addBigImageData(y6.a, y6.b, y6.g, y6.j);
            addBigImageData.setKeyPageStartFrom(this.z0.y1());
            addBigImageData.setFromFrsForumId(this.z0.getFromForumId());
            addBigImageData.setWorksInfoData(this.z0.X1());
            addBigImageData.setKeyFromForumId(this.z0.getForumId());
            addBigImageData.setBjhData(this.z0.R0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void l5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048693, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(ij9.i2)).intValue();
            if (intValue == ij9.j2) {
                if (this.C0.o0()) {
                    return;
                }
                this.H0.k4();
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
                    this.C0.q0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.C0.r0(this.z0.z1().k().getId(), this.z0.z1().k().getName(), this.z0.z1().N().getId(), str, intValue3, intValue2, booleanValue, this.z0.z1().N().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == ij9.k2 || intValue == ij9.m2) {
                PbModel pbModel = this.z0;
                if (pbModel != null && pbModel.U0() != null) {
                    this.z0.U0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ij9.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void o5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048703, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            ij9 ij9Var = this.H0;
            if (ij9Var != null && this.z0 != null) {
                if ((ij9Var == null || ij9Var.O1()) && this.z0.z1() != null && this.z0.z1().R() != null) {
                    ij9 ij9Var2 = this.H0;
                    if (ij9Var2 != null && ij9Var2.M0() != null && this.H0.M0().t()) {
                        return;
                    }
                    pf9 R = this.z0.z1().R();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!R.d() || R.a() != 2) && this.H0.F0() != null && this.H0.F0().B() != null) {
                        this.H0.F0().B().J(this.z0.S1(), this.z0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        ce9 ce9Var = new ce9(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.z0;
                        ce9Var.m(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        ce9Var.l(new l0(this));
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.h1);
            userMuteAddAndDelCustomMessage.setTag(this.h1);
            h7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void T6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048627, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new w1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                g7(str);
            } else {
                this.H0.i4(str);
            }
        }
    }

    @Override // com.baidu.tieba.i36
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

    public final void V6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            fl9.d(getActivity(), getPageContext(), new c1(this, sparseArray, i3, z3), new d1(this));
        }
    }

    public final void W4() {
        PbModel pbModel;
        ze9 ze9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (pbModel = this.z0) != null && (ze9Var = pbModel.G) != null && ze9Var.N() != null) {
            ThreadData N = this.z0.G.N();
            N.mRecomAbTag = this.z0.E1();
            N.mRecomWeight = this.z0.H1();
            N.mRecomSource = this.z0.G1();
            N.mRecomExtra = this.z0.F1();
            N.isSubPb = this.z0.m1();
            if (N.getFid() == 0) {
                N.setFid(wg.g(this.z0.getForumId(), 0L));
            }
            StatisticItem i3 = ft5.i(getContext(), N, "c13562");
            TbPageTag l3 = ft5.l(getContext());
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

    public final void m6() {
        MarkData Q0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && this.B0 != null) {
            if (this.z0.z1() != null && this.z0.z1().i0()) {
                Q0 = this.z0.Q0(0);
            } else {
                Q0 = this.z0.Q0(this.H0.W0());
            }
            if (Q0 == null) {
                return;
            }
            if (Q0.isApp() && (Q0 = this.z0.Q0(this.H0.W0() + 1)) == null) {
                return;
            }
            this.H0.u3();
            this.B0.i(Q0);
            if (!this.B0.e()) {
                if (this.H0 != null && (pbModel = this.z0) != null && !ml9.h(pbModel.b)) {
                    this.H0.c4();
                    ml9.b(this.z0.b);
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
            jl9.a();
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
            ij9 ij9Var = this.H0;
            if (ij9Var != null) {
                ij9Var.n2();
            }
            if (this.W0 != null && !this.z0.m1()) {
                this.W0.O(this.z0.S1());
            }
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                pbModel.B2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            bu4.w().E();
            MessageManager.getInstance().unRegisterListener(this.C1);
            I6();
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            zg5 zg5Var = this.j0;
            if (zg5Var != null) {
                zg5Var.q();
                this.j0.p();
            }
        }
    }

    public final void Y4(ze9 ze9Var, ArrayList<yca> arrayList) {
        List<yca> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048645, this, ze9Var, arrayList) == null) && ze9Var != null && ze9Var.S() != null && ze9Var.S().a != null && (list = ze9Var.S().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<yca> it = arrayList.iterator();
                while (it.hasNext()) {
                    yca next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            yca ycaVar = (yca) it2.next();
                            if (ycaVar != null && !TextUtils.isEmpty(next.S()) && !TextUtils.isEmpty(ycaVar.S()) && next.S().equals(ycaVar.S())) {
                                arrayList2.add(ycaVar);
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
        if ((interceptable != null && interceptable.invokeIL(1048730, this, i3, gVar) != null) || gVar == null) {
            return;
        }
        this.H0.B0(this.C0.getLoadDataMode(), gVar.a, gVar.b, false);
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
                this.z0.z1().N().setIs_good(1);
                this.z0.a3(1);
            } else if (i3 == 3) {
                this.z0.z1().N().setIs_good(0);
                this.z0.a3(0);
            } else if (i3 == 4) {
                this.z0.z1().N().setIs_top(1);
                this.z0.b3(1);
            } else if (i3 == 5) {
                this.z0.z1().N().setIs_top(0);
                this.z0.b3(0);
            }
            this.H0.s4(this.z0.z1(), this.z0.R1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        yi.R(getPageContext().getPageActivity(), string);
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048651, this) != null) || this.k != null) {
            return;
        }
        this.k = new r55(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        r55 r55Var = this.k;
        r55Var.j(strArr, new o0(this));
        r55Var.g(r55.b.a);
        r55Var.h(17);
        r55Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f5(AgreeData agreeData) {
        at5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048670, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new z95();
        }
        if (this.i0 == null) {
            oca ocaVar = new oca();
            this.i0 = ocaVar;
            ocaVar.a = getUniqueId();
        }
        z15 z15Var = new z15();
        z15Var.b = 5;
        z15Var.h = 8;
        z15Var.g = 2;
        if (Q() != null) {
            z15Var.f = Q().y1();
        }
        z15Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                z15Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i3, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.z0;
                if (pbModel == null && pbModel.z1() != null) {
                    this.e0.b(X(), z15Var, agreeData, this.z0.z1().N());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            z15Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            z15Var.i = 1;
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
        ze9 z12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (L5() != null && hj9.D(this)) {
                L5().j4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907a2));
            PbModel pbModel = this.z0;
            if (pbModel != null && (z12 = pbModel.z1()) != null) {
                this.p2.c(true, 0, 3, 0, z12, "", 1);
            }
            this.a.M1().l(this.t0);
            if (e6()) {
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).f2();
                }
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && this.G.b(pbModel2.G, getContext(), this.a.findViewById(this.H0.G0()), this.z0.getForumId(), this.z0.S1())) {
                AbsPbActivity absPbActivity2 = this.a;
                if (absPbActivity2 instanceof PbActivity) {
                    ((PbActivity) absPbActivity2).f2();
                }
            }
        }
    }

    public final boolean h5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        ax4 ax4Var;
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
        w55 w55Var;
        w55 w55Var2;
        w55 w55Var3;
        w55 w55Var4;
        w55 w55Var5;
        w55 w55Var6;
        jn jnVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            ij9 ij9Var = this.H0;
            if (ij9Var != null) {
                if (ij9Var.Q1()) {
                    return true;
                }
                this.H0.C0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (hj9.y(view2)) {
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
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.l1 = gifView.getBdImage().q();
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
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.l1 = tbMemeImageView.getBdImage().q();
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
                        this.H0.U3(this.E2, this.k1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            yca ycaVar = (yca) sparseArray.get(R.id.tag_clip_board);
            this.C2 = ycaVar;
            if (ycaVar == null) {
                return true;
            }
            if (ycaVar.I() == 1 && hj9.y(view2)) {
                this.H0.U3(this.E2, this.k1.t());
                return true;
            } else if (this.C2.k() != 0 || (ax4Var = this.B0) == null) {
                return true;
            } else {
                if (ax4Var.e() && this.C2.S() != null && this.C2.S().equals(this.z0.u1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (Q().z1() != null && Q().z1().i0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (Q().z1() != null && Q().z1().o0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (Q().z1() != null && Q().z1().n0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.C2.I() == 1) {
                    if (!z4) {
                        this.H0.V3(this.D2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.N0 == null) {
                    a65 a65Var = new a65(getContext());
                    this.N0 = a65Var;
                    a65Var.q(this.h2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (hj9.y(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (hj9.y(view2) && (jnVar = this.k1) != null && !jnVar.t()) {
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
                        arrayList.add(new w55(1, getString(R.string.save_to_emotion), this.N0));
                    } else {
                        z17 = z16;
                        z18 = z13;
                        z19 = z14;
                    }
                    if (z8) {
                        arrayList.add(new w55(2, getString(R.string.save_to_local), this.N0));
                    }
                    if (!z7 && !z8) {
                        w55 w55Var7 = new w55(3, getString(R.string.obfuscated_res_0x7f0f04e1), this.N0);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.C2);
                        w55Var7.d.setTag(sparseArray3);
                        arrayList.add(w55Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            w55Var6 = new w55(4, getString(R.string.remove_mark), this.N0);
                        } else {
                            w55Var6 = new w55(4, getString(R.string.obfuscated_res_0x7f0f0c3b), this.N0);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.C2);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        w55Var6.d.setTag(sparseArray4);
                        arrayList.add(w55Var6);
                    }
                    if (this.mIsLogin) {
                        if (!fl9.i(this.z0) && !z12 && z11) {
                            w55 w55Var8 = new w55(5, getString(R.string.obfuscated_res_0x7f0f0cfb), this.N0);
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
                            w55Var8.d.setTag(sparseArray5);
                            arrayList.add(w55Var8);
                        } else {
                            if (hj9.C(this.z0.z1(), z10) && TbadkCoreApplication.isLogin()) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z20 && !z4) {
                                w55 w55Var9 = new w55(5, getString(R.string.report_text), this.N0);
                                w55Var9.d.setTag(str);
                                arrayList.add(w55Var9);
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
                            if (!fl9.i(this.z0) && z18) {
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
                                    w55Var5 = new w55(6, getString(R.string.obfuscated_res_0x7f0f0546), this.N0);
                                    w55Var5.d.setTag(sparseArray6);
                                    w55Var2 = new w55(7, getString(R.string.obfuscated_res_0x7f0f0322), this.N0);
                                    w55Var2.d.setTag(sparseArray6);
                                    w55Var3 = w55Var5;
                                    w55Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            w55Var5 = null;
                            w55Var2 = new w55(7, getString(R.string.obfuscated_res_0x7f0f0322), this.N0);
                            w55Var2.d.setTag(sparseArray6);
                            w55Var3 = w55Var5;
                            w55Var = null;
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
                            if (this.z0.z1().V() == 1002 && !z10) {
                                w55Var4 = new w55(6, getString(R.string.report_text), this.N0);
                            } else {
                                w55Var4 = new w55(6, getString(R.string.obfuscated_res_0x7f0f0546), this.N0);
                            }
                            w55Var4.d.setTag(sparseArray7);
                            if (z17) {
                                w55Var = new w55(13, getString(R.string.multi_delete), this.N0);
                                w55Var3 = w55Var4;
                            } else {
                                w55Var3 = w55Var4;
                                w55Var = null;
                            }
                            w55Var2 = null;
                        } else {
                            w55Var = null;
                            w55Var2 = null;
                            w55Var3 = null;
                        }
                        if (w55Var3 != null) {
                            arrayList.add(w55Var3);
                        }
                        if (w55Var != null) {
                            arrayList.add(w55Var);
                        }
                        if (w55Var2 != null) {
                            arrayList.add(w55Var2);
                        }
                        fl9.b(arrayList, this.N0, this.C2, this.z0);
                    }
                    List<w55> c4 = fl9.c(arrayList, this.C2.o(), sparseArray, this.N0);
                    fl9.l(c4, this.b);
                    fl9.e(c4);
                    this.N0.r(fl9.g(this.C2));
                    this.N0.m(c4, true);
                    this.M0 = new y55(getPageContext(), this.N0);
                    this.N0.p(new t2(this));
                    this.M0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.z0.b).param("fid", this.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.z0.X());
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

    public final void h7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048680, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.H0.P3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            p55 p55Var = new p55(this.f1.getPageActivity());
            if (!xi.isEmpty(str)) {
                p55Var.setMessage(str);
            } else {
                p55Var.setMessage(this.f1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new f(this, userMuteAddAndDelCustomMessage));
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new g(this));
            p55Var.create(this.f1).show();
        }
    }

    public void i5(ForumManageModel.b bVar, ij9 ij9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, bVar, ij9Var) == null) {
            List<yca> list = this.z0.z1().S().a;
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
                ij9Var.N1(this.z0.z1());
            }
        }
    }

    public final void j6(View view2, String str, String str2, yca ycaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048687, this, view2, str, str2, ycaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (a5()) {
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
                    if (L5().h1() != null && ycaVar != null) {
                        if (ycaVar.e0() != null) {
                            str3 = ycaVar.e0().toString();
                        } else {
                            str3 = "";
                        }
                        L5().h1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), ycaVar.q().getName_show(), str3));
                    }
                    if (this.z0.z1() != null && this.z0.z1().i0()) {
                        zg.a().postDelayed(new f1(this, str, str2), 0L);
                        return;
                    } else {
                        zg.a().postDelayed(new g1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void m5(p55 p55Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048696, this, p55Var, jSONArray) == null) {
            p55Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(p55Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                l5((SparseArray) p55Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText u7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048745, this, str, i3)) == null) {
            PbModel pbModel = this.z0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.z1() == null || str == null || i3 < 0) {
                return null;
            }
            ze9 z12 = this.z0.z1();
            if (z12.i() != null) {
                ArrayList<yca> arrayList = new ArrayList<>();
                arrayList.add(z12.i());
                tbRichText = y5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<yca> F = z12.F();
                Y4(z12, F);
                return y5(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void n5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048700, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(ij9.i2, Integer.valueOf(ij9.j2));
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
            el5 el5Var = this.W0;
            if (el5Var != null) {
                el5Var.D(i3, i4, intent);
            }
            if (L5().h1() != null) {
                L5().h1().k(i3, i4, intent);
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
                                                    View view3 = this.f1150T;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    ij9 ij9Var = this.H0;
                                                    if (ij9Var != null && ij9Var.H0() != null) {
                                                        this.H0.H0().performClick();
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
                                        this.H0.w3(false);
                                        if (this.z0.z1() != null && this.z0.z1().N() != null && this.z0.z1().N().getPushStatusData() != null) {
                                            this.z0.z1().N().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        wx9.g().m(getPageContext());
                                        r7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.G0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                            shareSuccessReplyToServerModel.V(str, intExtra, new d2(this));
                                        }
                                        if (b6()) {
                                            p7(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.R;
                                if (view5 != null) {
                                    this.H0.M3(view5);
                                    return;
                                }
                                return;
                            }
                            T5(intent);
                            return;
                        }
                        wx9.g().m(getPageContext());
                        return;
                    }
                    yi9.b().k();
                    this.y0.postDelayed(new c2(this), 1000L);
                    return;
                }
                m6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ij9 ij9Var;
        ij9 ij9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
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
                if (B5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (xi.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.q1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                h45 h45Var = new h45();
                this.c0 = h45Var;
                h45Var.a(intent);
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
            h6(bundle);
            if (this.z0.z1() != null) {
                this.z0.z1().S0(this.P);
            }
            X5();
            if (intent != null && (ij9Var2 = this.H0) != null) {
                ij9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.i1 == null) {
                        this.i1 = new i0(this, intent);
                    }
                    zg.a().postDelayed(this.i1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.z0.z1() != null) {
                    this.z0.f3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            W5(bundle);
            fl5 fl5Var = new fl5();
            this.V0 = fl5Var;
            P6(fl5Var);
            el5 el5Var = (el5) this.V0.a(getActivity());
            this.W0 = el5Var;
            el5Var.X(this.a.getPageContext());
            this.W0.g0(this.l2);
            this.W0.h0(this.a1);
            this.W0.Z(1);
            this.W0.B(this.a.getPageContext(), bundle);
            this.W0.b().b(new kj5(getActivity()));
            this.W0.b().F(true);
            S6(true);
            this.W0.K(this.z0.b1(), this.z0.S1(), this.z0.X0());
            registerListener(this.z1);
            if (!this.z0.m1()) {
                this.W0.q(this.z0.S1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.z0.i2()) {
                this.W0.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                ij9 ij9Var3 = this.H0;
                if (ij9Var3 != null) {
                    this.W0.d0(ij9Var3.i1());
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
            pca pcaVar = new pca("pb", pca.d);
            this.U0 = pcaVar;
            pcaVar.d();
            registerListener(this.H1);
            registerListener(this.R1);
            this.z0.C2();
            registerListener(this.q2);
            registerListener(this.e2);
            registerListener(this.k2);
            registerListener(this.N1);
            registerListener(this.d2);
            registerListener(this.I1);
            ij9 ij9Var4 = this.H0;
            if (ij9Var4 != null && ij9Var4.o1() != null && this.H0.m1() != null) {
                pk9 pk9Var = new pk9(getActivity(), this.H0.o1(), this.H0.m1(), this.H0.f1());
                this.e = pk9Var;
                pk9Var.t(this.Q1);
            }
            if (this.c && (ij9Var = this.H0) != null && ij9Var.m1() != null) {
                this.H0.m1().setVisibility(8);
            }
            oa5 oa5Var = new oa5();
            this.g1 = oa5Var;
            oa5Var.a = 1000L;
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
            this.z0.T0().Z(this.U1);
            this.L0 = new lj9();
            if (this.W0.s() != null) {
                this.L0.m(this.W0.s().i());
            }
            this.W0.W(this.b1);
            this.G0 = new ShareSuccessReplyToServerModel();
            U4(this.u1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new j0(this));
            dm9 dm9Var = new dm9(getContext());
            this.A0 = dm9Var;
            dm9Var.b(getUniqueId());
            aba.g().i(getUniqueId());
            o15.b().l("3", "");
            this.t1 = new uo6(getPageContext());
            this.u0 = new dl9(this, getUniqueId(), this.H0, this.z0);
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
            this.H0 = new ij9(this, this.j2, this.V1, this.i2);
            fz6 fz6Var = new fz6(getActivity());
            this.d = fz6Var;
            fz6Var.i(T2);
            this.d.d(this.L2);
            this.H0.n3(this.t2);
            this.H0.m3(this.y2);
            this.H0.g3(this.v2);
            this.H0.h3(this.w2);
            this.H0.e3(a15.c().g());
            this.H0.k3(this.A2);
            this.H0.q3(this.G2);
            this.H0.o3(this.H2);
            this.H0.l3(this.J2);
            this.H0.o4(this.mIsLogin);
            this.H0.c3(this.z0.g2());
            if (this.a.getIntent() != null) {
                this.H0.d3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.H0.g1().setFromForumId(this.z0.getFromForumId());
            el5 el5Var = this.W0;
            if (el5Var != null) {
                this.H0.U2(el5Var.b());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.W0.d0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.W0.d0(this.H0.i1());
                }
            }
            this.H0.Y2(this.g2);
            this.H0.b3(this.z0.h1());
            this.H0.p3(this.z0.y1());
            this.u0.f(this.H0, this.z0);
            if ("1".equals(Q().showReplyPanel)) {
                this.H0.p2();
            }
            return this.H0.p1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText y5(ArrayList<yca> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048754, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText e02 = arrayList.get(i4).e0();
                    if (e02 != null && (X = e02.X()) != null) {
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
                                    int i7 = (int) yi.i(TbadkCoreApplication.getInst());
                                    int width = X.get(i6).d0().getWidth() * i7;
                                    int height = X.get(i6).d0().getHeight() * i7;
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
        xl9 xl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            aba.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.z0.z1().l());
                statisticItem.param("tid", this.z0.S1());
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
                if (this.z0.v1() != null) {
                    this.z0.v1().d();
                }
            }
            el5 el5Var = this.W0;
            if (el5Var != null) {
                el5Var.E();
                this.W0 = null;
            }
            ForumManageModel forumManageModel = this.C0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.j0();
            }
            ij9 ij9Var = this.H0;
            if (ij9Var != null) {
                ij9Var.i2();
                xl9 xl9Var2 = this.H0.k;
                if (xl9Var2 != null) {
                    xl9Var2.r();
                }
            }
            xt5 xt5Var = this.s;
            if (xt5Var != null) {
                xt5Var.c();
            }
            pk9 pk9Var = this.e;
            if (pk9Var != null) {
                pk9Var.k();
            }
            ng<TextView> ngVar = this.y;
            if (ngVar != null) {
                ngVar.c();
            }
            ng<FestivalTipView> ngVar2 = this.H;
            if (ngVar2 != null) {
                ngVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            ij9 ij9Var2 = this.H0;
            if (ij9Var2 != null) {
                ij9Var2.s0();
            }
            if (this.W1 != null) {
                zg.a().removeCallbacks(this.W1);
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
            f0a.e().g();
            if (this.i1 != null) {
                zg.a().removeCallbacks(this.i1);
            }
            ij9 ij9Var3 = this.H0;
            if (ij9Var3 != null && (xl9Var = ij9Var3.k) != null) {
                xl9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.G0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            lj9 lj9Var = this.L0;
            if (lj9Var != null) {
                lj9Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && pbModel2.N0() != null) {
                this.z0.N0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ij9 ij9Var4 = this.H0;
            if (ij9Var4 != null) {
                ij9Var4.l4();
            }
            dl9 dl9Var = this.u0;
            if (dl9Var != null) {
                dl9Var.e();
            }
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
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                p55 p55Var = new p55(getPageContext().getPageActivity());
                p55Var.setMessage(string);
                p55Var.setPositiveButton(R.string.dialog_known, new y1(this));
                p55Var.setCancelable(true);
                p55Var.create(getPageContext());
                p55Var.show();
            } else if (bVar.d != 0) {
                this.H0.B0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<yca> F = this.z0.z1().F();
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
                    this.z0.z1().N().setReply_num(this.z0.z1().N().getReply_num() - 1);
                    this.H0.N1(this.z0.z1());
                } else if (i4 == 0) {
                    g5();
                } else if (i4 == 2) {
                    ArrayList<yca> F2 = this.z0.z1().F();
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
                        this.H0.N1(this.z0.z1());
                    }
                    i5(bVar, this.H0);
                }
            }
        }
    }

    public void t6() {
        PbModel pbModel;
        ze9 z12;
        ThreadData N;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        ze9 ze9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (pbModel = this.z0) != null && pbModel.z1() != null && (N = (z12 = this.z0.z1()).N()) != null && N.getAuthor() != null) {
            this.H0.t1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.getAuthor().getUserId());
            ri9 ri9Var = new ri9();
            int V = this.z0.z1().V();
            if (V != 1 && V != 3) {
                ri9Var.g = false;
            } else {
                ri9Var.g = true;
                if (N.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ri9Var.s = z3;
            }
            if (hj9.z(this.z0.z1(), V)) {
                ri9Var.h = true;
                if (N.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                ri9Var.r = z9;
            } else {
                ri9Var.h = false;
            }
            if (V == 1002 && !equals) {
                ri9Var.u = true;
            }
            ri9Var.n = hj9.K(N.isBlocked(), z12.m0(), equals, V, N.isWorksInfo(), N.isScoreThread());
            ri9Var.e = hj9.I(z12, equals, z12.m0(), this.z0.d0());
            ri9Var.i = X6();
            ri9Var.f = hj9.J(this.z0.z1(), equals, this.z0.d0());
            if (equals && z12.U() != null && z12.U().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            ri9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                ri9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            ri9Var.t = equals;
            ri9Var.q = this.z0.R1();
            ri9Var.b = true;
            ri9Var.a = hj9.C(this.z0.z1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            ri9Var.p = z5;
            ri9Var.j = true;
            ri9Var.o = this.z0.c1();
            ri9Var.d = true;
            if (N.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            ri9Var.c = z6;
            if (z12.i0()) {
                ri9Var.b = false;
                ri9Var.d = false;
                ri9Var.c = false;
                ri9Var.g = false;
                ri9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !z12.i0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            ri9Var.v = z7;
            if (this.H0 != null && (ze9Var = this.z0.G) != null) {
                yca W = ze9Var.W();
                if (W != null) {
                    z8 = W.f1185T;
                } else {
                    z8 = false;
                }
                ri9Var.w = z8;
            }
            ri9Var.m = true;
            if (N.isBlocked()) {
                ri9Var.n = false;
                ri9Var.g = false;
                ri9Var.h = false;
            }
            this.H0.k.x(ri9Var);
        }
    }

    public final void w6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048749, this, str, i3, eVar) != null) || eVar == null) {
            return;
        }
        ze9 z12 = this.z0.z1();
        TbRichText u7 = u7(str, i3);
        if (u7 == null || (tbRichTextData = u7.X().get(this.z2)) == null) {
            return;
        }
        eVar.f = String.valueOf(u7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.d0().b0()) {
            eVar.h = false;
            String a4 = af9.a(tbRichTextData);
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
            imageUrlData.originalUrl = hj9.n(tbRichTextData);
            imageUrlData.originalUrl = hj9.n(tbRichTextData);
            imageUrlData.originalSize = hj9.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = hj9.k(tbRichTextData);
            imageUrlData.isLongPic = hj9.j(tbRichTextData);
            imageUrlData.postId = u7.getPostId();
            imageUrlData.mIsReserver = this.z0.K1();
            imageUrlData.mIsSeeHost = this.z0.c1();
            eVar.b.put(a4, imageUrlData);
            if (z12 != null) {
                if (z12.k() != null) {
                    eVar.c = z12.k().getName();
                    eVar.d = z12.k().getId();
                }
                if (z12.N() != null) {
                    eVar.e = z12.N().getId();
                }
                if (z12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = wg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = z12.F().size();
        this.B2 = false;
        eVar.j = -1;
        if (z12.i() != null) {
            i4 = z5(z12.i().e0(), u7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            yca ycaVar = z12.F().get(i7);
            if (ycaVar.S() == null || z12.i() == null || z12.i().S() == null || !ycaVar.S().equals(z12.i().S())) {
                i6 = z5(ycaVar.e0(), u7, i6, i3, eVar.a, eVar.b);
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
            if (z12.N() != null) {
                eVar.e = z12.N().getId();
            }
            if (z12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i6;
    }

    public final int z5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo d02;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048759, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.B2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.X().size();
                int i6 = i3;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.X().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int i9 = (int) yi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.d0().getWidth() * i9;
                        int height = tbRichTextData.d0().getHeight() * i9;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.d0().b0()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = af9.a(tbRichTextData);
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
                                        imageUrlData.originalUrl = hj9.n(tbRichTextData);
                                        imageUrlData.originalSize = hj9.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = hj9.k(tbRichTextData);
                                        imageUrlData.isLongPic = hj9.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = wg.g(this.z0.S1(), -1L);
                                        imageUrlData.mIsReserver = this.z0.K1();
                                        imageUrlData.mIsSeeHost = this.z0.c1();
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
}
