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
import com.baidu.tieba.R;
import com.baidu.tieba.a48;
import com.baidu.tieba.a55;
import com.baidu.tieba.a68;
import com.baidu.tieba.a98;
import com.baidu.tieba.ab8;
import com.baidu.tieba.ac8;
import com.baidu.tieba.ag5;
import com.baidu.tieba.ap8;
import com.baidu.tieba.as4;
import com.baidu.tieba.at4;
import com.baidu.tieba.b95;
import com.baidu.tieba.bd5;
import com.baidu.tieba.bh;
import com.baidu.tieba.c45;
import com.baidu.tieba.c48;
import com.baidu.tieba.c95;
import com.baidu.tieba.c98;
import com.baidu.tieba.ca5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cg5;
import com.baidu.tieba.cm5;
import com.baidu.tieba.co;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cz4;
import com.baidu.tieba.d55;
import com.baidu.tieba.d68;
import com.baidu.tieba.da8;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dl5;
import com.baidu.tieba.dw4;
import com.baidu.tieba.e48;
import com.baidu.tieba.e78;
import com.baidu.tieba.e95;
import com.baidu.tieba.ef5;
import com.baidu.tieba.ev5;
import com.baidu.tieba.f98;
import com.baidu.tieba.fb8;
import com.baidu.tieba.fw4;
import com.baidu.tieba.g75;
import com.baidu.tieba.g95;
import com.baidu.tieba.gb8;
import com.baidu.tieba.gd8;
import com.baidu.tieba.gg5;
import com.baidu.tieba.gu4;
import com.baidu.tieba.gw4;
import com.baidu.tieba.h98;
import com.baidu.tieba.ha8;
import com.baidu.tieba.hw4;
import com.baidu.tieba.hx8;
import com.baidu.tieba.hz4;
import com.baidu.tieba.i88;
import com.baidu.tieba.i98;
import com.baidu.tieba.ia8;
import com.baidu.tieba.iu4;
import com.baidu.tieba.j75;
import com.baidu.tieba.j78;
import com.baidu.tieba.jf5;
import com.baidu.tieba.jn;
import com.baidu.tieba.k65;
import com.baidu.tieba.k75;
import com.baidu.tieba.k88;
import com.baidu.tieba.kc8;
import com.baidu.tieba.kv8;
import com.baidu.tieba.l49;
import com.baidu.tieba.l75;
import com.baidu.tieba.ls4;
import com.baidu.tieba.ly8;
import com.baidu.tieba.lz4;
import com.baidu.tieba.m58;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mv4;
import com.baidu.tieba.n35;
import com.baidu.tieba.ne6;
import com.baidu.tieba.no5;
import com.baidu.tieba.np4;
import com.baidu.tieba.nr4;
import com.baidu.tieba.nx6;
import com.baidu.tieba.nx8;
import com.baidu.tieba.o49;
import com.baidu.tieba.o58;
import com.baidu.tieba.oe6;
import com.baidu.tieba.om4;
import com.baidu.tieba.p65;
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
import com.baidu.tieba.pm4;
import com.baidu.tieba.pt4;
import com.baidu.tieba.q58;
import com.baidu.tieba.qg;
import com.baidu.tieba.qo5;
import com.baidu.tieba.r55;
import com.baidu.tieba.r78;
import com.baidu.tieba.r88;
import com.baidu.tieba.r9;
import com.baidu.tieba.rb;
import com.baidu.tieba.ru4;
import com.baidu.tieba.rw4;
import com.baidu.tieba.s45;
import com.baidu.tieba.s65;
import com.baidu.tieba.s9;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tz4;
import com.baidu.tieba.um8;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uz4;
import com.baidu.tieba.v78;
import com.baidu.tieba.va8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vr8;
import com.baidu.tieba.wp5;
import com.baidu.tieba.wv4;
import com.baidu.tieba.x05;
import com.baidu.tieba.xa8;
import com.baidu.tieba.y27;
import com.baidu.tieba.y45;
import com.baidu.tieba.y48;
import com.baidu.tieba.y76;
import com.baidu.tieba.y85;
import com.baidu.tieba.ya8;
import com.baidu.tieba.yg;
import com.baidu.tieba.yi;
import com.baidu.tieba.yj5;
import com.baidu.tieba.yn;
import com.baidu.tieba.yv4;
import com.baidu.tieba.yw8;
import com.baidu.tieba.yy4;
import com.baidu.tieba.z45;
import com.baidu.tieba.z48;
import com.baidu.tieba.z58;
import com.baidu.tieba.z65;
import com.baidu.tieba.z85;
import com.baidu.tieba.z98;
import com.baidu.tieba.za8;
import com.baidu.tieba.zi;
import com.baidu.tieba.zk5;
import com.baidu.tieba.zw8;
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
public class PbFragment extends BaseFragment implements qo5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, wv4.e, TbRichTextView.u, TbPageContextSupport, kc8, gd8.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k U2;
    public static final oe6.b V2;
    public transient /* synthetic */ FieldHolder $fh;
    public pg<TbImageView> A;
    public ForumManageModel A0;
    public CustomMessageListener A1;
    public boolean A2;
    public pg<ImageView> B;
    public c45 B0;
    public CustomMessageListener B1;
    public final BdListView.p B2;
    public pg<View> C;
    public q58 C0;
    public CustomMessageListener C1;
    public int C2;
    public pg<TiebaPlusRecommendCard> D;
    public PollingModel D0;
    public CustomMessageListener D1;
    public final TbRichTextView.a0 D2;
    public pg<LinearLayout> E;
    public ShareSuccessReplyToServerModel E0;
    public final CustomMessageListener E1;
    public boolean E2;
    public pg<RelativeLayout> F;
    public c98 F0;
    public CustomMessageListener F1;
    public PostData F2;
    public pg<ItemCardView> G;
    public boolean G0;
    public CustomMessageListener G1;
    public final yv4.c G2;
    public pg<FestivalTipView> H;
    public boolean H0;
    public View.OnClickListener H1;
    public final yv4.c H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public final AdapterView.OnItemClickListener I2;
    public boolean J;
    public f98 J0;
    public CustomMessageListener J1;
    public final View.OnLongClickListener J2;
    public boolean K;
    public fw4 K0;
    public CustomMessageListener K1;
    public final View.OnClickListener K2;
    public pg<GifView> L;
    public hw4 L0;
    public CustomMessageListener L1;
    public final ItemCardHelper.c L2;
    public String M;
    public String M0;
    public CustomMessageListener M1;
    public final NoNetworkView.b M2;
    public boolean N;
    public boolean N0;
    public SuggestEmotionModel.c N1;
    public View.OnTouchListener N2;
    public boolean O;
    public boolean O0;
    public CustomMessageListener O1;
    public ne6.b O2;
    public String P;
    public boolean P0;
    public GetSugMatchWordsModel.b P1;
    public final r78.b P2;
    public LikeModel Q;
    public String Q0;
    public boolean Q1;
    public int Q2;
    public View R;
    public boolean R0;
    public PraiseModel R1;
    public int R2;
    public View S;
    public zw8 S0;
    public ia8.h S1;
    public String S2;
    public View T;
    public e95 T0;
    public CustomMessageListener T1;
    public at4 T2;
    public View U;
    public c95 U0;
    public bd5 U1;
    public String V;
    public boolean V0;
    public bd5 V1;
    public int W;
    public PermissionJudgePolicy W0;
    public CheckRealNameModel.b W1;
    public boolean X;
    public ReplyPrivacyCheckController X0;
    public a68 X1;
    public int[] Y;
    public nx6 Y0;
    public final Runnable Y1;
    public int Z;
    public nx6 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public z85 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public y85 b1;
    public CustomMessageListener b2;
    public boolean c;
    public ru4 c0;
    public y85 c1;
    public CustomMessageListener c2;
    public oe6 d;
    public BdUniqueId d0;
    public int d1;
    public CustomMessageListener d2;
    public ia8 e;
    public yy4 e0;
    public Object e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public s9 f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public hz4 g1;
    public CustomMessageListener g2;
    public boolean h;
    public Object h0;
    public BdUniqueId h1;
    public wv4.e h2;
    public boolean i;
    public yw8 i0;
    public Runnable i1;
    public i3 i2;
    public VoiceManager j;
    public z45 j0;
    public h98 j1;
    public hw4.f j2;
    public int k;
    public jn k1;
    public SortSwitchButton.f k2;
    public yv4 l;
    public String l1;
    public final View.OnClickListener l2;
    public long m;
    public TbRichTextImageInfo m1;
    public CustomMessageListener m2;
    public long n;
    public TbRichTextMemeInfo n1;
    public final NewWriteModel.d n2;
    public long o;
    public boolean o1;
    public Boolean o2;
    public long p;
    public int p1;
    public NewWriteModel.d p2;
    public long q;
    public boolean q0;
    public int q1;
    public rb q2;
    public boolean r;
    public boolean r0;
    public List<g3> r1;
    public final PbModel.h r2;
    public boolean s;
    @NonNull
    public TiePlusEventController.f s0;
    public int s1;
    public CustomMessageListener s2;
    public ag5 t;
    public va8 t0;
    public String t1;
    public HttpMessageListener t2;
    public long u;
    public PushPermissionController u0;
    public y76 u1;
    public final np4.a u2;
    public boolean v;
    public PbInterviewStatusView.f v0;
    public final g3 v1;
    public final AbsListView.OnScrollListener v2;
    public long w;
    public final Handler w0;
    public final i88.b w1;
    public final r9 w2;
    public int x;
    public PbModel x0;
    public final CustomMessageListener x1;
    public final j3 x2;
    public String y;
    public gb8 y0;
    public CustomMessageListener y1;
    public final lz4.g y2;
    public pg<TextView> z;
    public np4 z0;
    public CustomMessageListener z1;
    public final View.OnClickListener z2;

    /* loaded from: classes5.dex */
    public interface g3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public interface i3 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public interface j3 {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kc8
    /* renamed from: O5 */
    public VideoPbFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public void T(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, context, str) == null) {
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

    @Override // com.baidu.tieba.qo5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048667, this, context, str) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc8
    public PbFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class l1 implements nx6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        @Override // com.baidu.tieba.nx6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.nx6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$l1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0406a implements TextWatcher {
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

                public C0406a(a aVar) {
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
                    f98 f98Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (f98Var = this.a.a.c.J0) != null && f98Var.g() != null) {
                        if (!this.a.a.c.J0.g().e()) {
                            this.a.a.c.J0.b(false);
                        }
                        this.a.a.c.J0.g().l(false);
                    }
                }
            }

            public a(l1 l1Var) {
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

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int j = zi.j(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = j / 2;
                        g = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i2 = j - (i + g);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                    if (pbFragment.F0 != null && this.a.c.F0.Z0() != null) {
                        this.a.c.F0.Z0().smoothScrollBy(i3, 50);
                    }
                    if (this.a.c.K5().j1() != null) {
                        this.a.c.U0.b().setVisibility(8);
                        z = (this.a.c.x0 == null || this.a.c.x0.l1() == null || this.a.c.x0.l1().Q() == null || !this.a.c.x0.l1().Q().isBjh()) ? false : false;
                        v78 j1 = this.a.c.K5().j1();
                        l1 l1Var = this.a;
                        j1.t(l1Var.a, l1Var.b, l1Var.c.K5().l1(), z);
                        g95 f = this.a.c.K5().j1().f();
                        if (f != null && this.a.c.x0 != null && this.a.c.x0.l1() != null) {
                            f.H(this.a.c.x0.l1().d());
                            f.d0(this.a.c.x0.l1().Q());
                        }
                        if (this.a.c.J0.f() == null && this.a.c.K5().j1().f().u() != null) {
                            this.a.c.K5().j1().f().u().g(new C0406a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.J0.n(pbFragment2.K5().j1().f().u().i());
                            this.a.c.K5().j1().f().N(this.a.c.c1);
                        }
                    }
                    this.a.c.K5().v1();
                }
            }
        }

        public l1(PbFragment pbFragment, String str, String str2) {
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

        @Override // com.baidu.tieba.nx6.d
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
                bh.a().postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

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

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                f98 f98Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (f98Var = this.a.c.J0) != null && f98Var.g() != null) {
                    if (!this.a.c.J0.g().e()) {
                        this.a.c.J0.b(false);
                    }
                    this.a.c.J0.g().l(false);
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

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = zi.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = zi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = zi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.F0 != null && this.c.F0.Z0() != null) {
                    this.c.F0.Z0().smoothScrollBy(i3, 50);
                }
                if (this.c.K5().j1() != null) {
                    this.c.U0.b().setVisibility(8);
                    this.c.K5().j1().t(this.a, this.b, this.c.K5().l1(), (this.c.x0 == null || this.c.x0.l1() == null || this.c.x0.l1().Q() == null || !this.c.x0.l1().Q().isBjh()) ? false : false);
                    g95 f = this.c.K5().j1().f();
                    if (f != null && this.c.x0 != null && this.c.x0.l1() != null) {
                        f.H(this.c.x0.l1().d());
                        f.d0(this.c.x0.l1().Q());
                    }
                    if (this.c.J0.f() == null && this.c.K5().j1().f().u() != null) {
                        this.c.K5().j1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.J0.n(pbFragment2.K5().j1().f().u().i());
                        this.c.K5().j1().f().N(this.c.c1);
                    }
                }
                this.c.K5().v1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ k2 b;

            public a(k2 k2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = k2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d68.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                bh.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:786:0x1ebf, code lost:
            if (r9 == (r32.a.F0.k1().c().getHeight() - r32.a.F0.k1().e())) goto L832;
         */
        /* JADX WARN: Code restructure failed: missing block: B:824:0x2041, code lost:
            if (r32.a.F0.e1.c.getView().getTop() <= ((r32.a.F0.k1() == null || r32.a.F0.k1().c() == null) ? 0 : r32.a.F0.k1().c().getBottom())) goto L761;
         */
        /* JADX WARN: Code restructure failed: missing block: B:825:0x2043, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:827:0x2050, code lost:
            if (r0 >= com.baidu.tieba.z98.d(r32.a.E5())) goto L761;
         */
        /* JADX WARN: Code restructure failed: missing block: B:849:0x20f7, code lost:
            if ((r32.a.F0.e1.c.getView().getTop() - r32.a.F0.h.a.getBottom()) < (r32.a.F0.e1.c.g.getHeight() + 10)) goto L761;
         */
        /* JADX WARN: Removed duplicated region for block: B:1118:0x2aa7  */
        /* JADX WARN: Removed duplicated region for block: B:1119:0x2abd  */
        /* JADX WARN: Removed duplicated region for block: B:1122:0x2af9  */
        /* JADX WARN: Removed duplicated region for block: B:1364:0x34a0  */
        /* JADX WARN: Removed duplicated region for block: B:1365:0x34a5  */
        /* JADX WARN: Removed duplicated region for block: B:1368:0x34b4  */
        /* JADX WARN: Removed duplicated region for block: B:1402:0x3562  */
        /* JADX WARN: Removed duplicated region for block: B:1405:0x3571  */
        /* JADX WARN: Removed duplicated region for block: B:1408:0x3584  */
        /* JADX WARN: Removed duplicated region for block: B:1411:0x3595  */
        /* JADX WARN: Removed duplicated region for block: B:1414:0x35ab  */
        /* JADX WARN: Removed duplicated region for block: B:1416:0x35b4  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            y48 l1;
            int i;
            int i2;
            PostData Z;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            dw4 dw4Var;
            dw4 dw4Var2;
            dw4 dw4Var3;
            PbFragment pbFragment;
            int i3;
            boolean z;
            dw4 dw4Var4;
            dw4 dw4Var5;
            dw4 dw4Var6;
            dw4 dw4Var7;
            String name;
            int i4;
            boolean z2;
            int fixedNavHeight;
            int i5;
            int i6;
            mv4 mv4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.r0 && (view2 == this.a.F0.h.c || view2 == this.a.F0.h.d || view2.getId() == R.id.obfuscated_res_0x7f091912 || view2.getId() == R.id.obfuscated_res_0x7f090a4f || view2.getId() == R.id.obfuscated_res_0x7f091cc5 || view2.getId() == R.id.obfuscated_res_0x7f0918ad)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.F0.c1() && this.a.getPageContext().getPageActivity() != null && this.a.x0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.F1(), this.a.x0.V1(), this.a.x0.U1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.x0.getForumId());
                        statisticItem2.param("fname", this.a.x0.K0());
                        statisticItem2.param("tid", this.a.x0.F1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.F0.e1()) {
                        if (this.a.h) {
                            return;
                        }
                        if (this.a.x0.g2(true)) {
                            this.a.h = true;
                            this.a.F0.B3();
                        }
                    } else if (view2 == this.a.F0.h.n()) {
                        String string = StringUtils.string(view2.getTag(R.id.forum_name));
                        String string2 = StringUtils.string(view2.getTag(R.id.forum_id));
                        String string3 = StringUtils.string(view2.getTag(R.id.thread_id));
                        if (this.a.Q != null) {
                            this.a.Q.Y(string, string2);
                        }
                        TbPageTag l = jf5.l(this.a.getContext());
                        ab8.a("c14278", string2, string3, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    } else if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().r()) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.F0.v0();
                        this.a.l7();
                        this.a.F0.A3();
                        this.a.F0.W3();
                        if (this.a.F0.h1() != null) {
                            this.a.F0.h1().setVisibility(8);
                        }
                        this.a.x0.Z2(1);
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else if (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().k()) {
                        if (view2 == this.a.F0.h.f) {
                            if (!this.a.F0.j0(this.a.x0.Y0())) {
                                this.a.i = false;
                                zi.z(this.a.a, this.a.F0.h.f);
                                this.a.a.finish();
                            } else {
                                this.a.l7();
                                return;
                            }
                        } else if (view2 == this.a.F0.L0() || (this.a.F0.h.o() != null && (view2 == this.a.F0.h.o().s() || view2 == this.a.F0.h.o().t()))) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            } else if (this.a.x0.l1() == null || this.a.A0.Z()) {
                                return;
                            } else {
                                this.a.F0.v0();
                                int i9 = (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().t()) ? (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().s()) ? view2 == this.a.F0.L0() ? 2 : 0 : this.a.x0.l1().Q().getIs_good() == 1 ? 3 : 6 : this.a.x0.l1().Q().getIs_top() == 1 ? 5 : 4;
                                ForumData l2 = this.a.x0.l1().l();
                                String name3 = l2.getName();
                                String id = l2.getId();
                                String id2 = this.a.x0.l1().Q().getId();
                                this.a.F0.q4();
                                this.a.A0.d0(id, name3, id2, i9, this.a.F0.M0());
                            }
                        } else if (view2 == this.a.F0.S0()) {
                            if (this.a.x0 != null) {
                                BrowserHelper.p(this.a.getPageContext().getPageActivity(), this.a.x0.l1().Q().getTopicData().b());
                            }
                        } else if (view2 == this.a.F0.h.c) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            if (this.a.x0.l1() != null && this.a.x0.l1().Q() != null && this.a.x0.l1().Q().isVideoThreadType() && this.a.x0.l1().Q().getThreadVideoInfo() != null) {
                                TiebaStatic.log(new StatisticItem("c11922"));
                            }
                            if (this.a.x0.getErrorNo() == 4) {
                                if (!StringUtils.isNull(this.a.x0.K0()) || this.a.x0.A0() == null) {
                                    this.a.a.finish();
                                    return;
                                }
                                name2 = this.a.x0.A0().b;
                            } else {
                                name2 = this.a.x0.l1().l().getName();
                            }
                            if (StringUtils.isNull(name2)) {
                                this.a.a.finish();
                                return;
                            }
                            String K0 = this.a.x0.K0();
                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                            if (!this.a.x0.Q0() || K0 == null || !K0.equals(name2)) {
                                this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                            } else {
                                this.a.a.finish();
                            }
                        } else if (view2 == this.a.F0.h.d) {
                            if (yj5.a()) {
                                return;
                            }
                            if (this.a.x0 == null || this.a.x0.l1() == null) {
                                zi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e77));
                                return;
                            }
                            ArrayList<PostData> H = this.a.x0.l1().H();
                            if ((H == null || H.size() <= 0) && this.a.x0.D1()) {
                                zi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e77));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.x0.F1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x0.getForumId()));
                            if (!this.a.F0.Z1()) {
                                this.a.F0.V2();
                            }
                            this.a.v6();
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918d1) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.F0.k3(true);
                            this.a.F0.V2();
                            if (this.a.h) {
                                return;
                            }
                            this.a.h = true;
                            this.a.F0.g4();
                            this.a.l7();
                            this.a.F0.A3();
                            this.a.x0.d3(this.a.x5());
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918a8) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.F0.v0();
                            if (view2.getId() != R.id.obfuscated_res_0x7f0918a8 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                if (!a98.c(this.a.getPageContext(), 11009) || this.a.x0.B0(this.a.F0.Y0()) == null) {
                                    return;
                                }
                                this.a.o6();
                                if (this.a.x0.l1() != null && this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.l1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getAuthor() != null && this.a.x0.l1().Q().getAuthor().getUserId() != null && this.a.z0 != null) {
                                    int w = a98.w(this.a.x0.l1());
                                    ThreadData Q = this.a.x0.l1().Q();
                                    if (Q.isBJHArticleThreadType()) {
                                        i8 = 2;
                                    } else if (Q.isBJHVideoThreadType()) {
                                        i8 = 3;
                                    } else if (Q.isBJHNormalThreadType()) {
                                        i8 = 4;
                                    } else {
                                        i8 = Q.isBJHVideoDynamicThreadType() ? 5 : 1;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 1).param("obj_id", this.a.x0.l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", w).param("obj_param1", i8));
                                }
                            } else {
                                this.a.U = view2;
                                return;
                            }
                        } else if ((this.a.F0.h.o() != null && view2 == this.a.F0.h.o().p()) || view2.getId() == R.id.obfuscated_res_0x7f090a4f || view2.getId() == R.id.obfuscated_res_0x7f091cc5) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.F0.v0();
                            if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().p() && !this.a.F0.Z1()) {
                                this.a.F0.V2();
                            }
                            if (this.a.h) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.l7();
                            this.a.F0.A3();
                            boolean e3 = view2.getId() == R.id.obfuscated_res_0x7f090a4f ? this.a.x0.e3(true, this.a.x5()) : view2.getId() == R.id.obfuscated_res_0x7f091cc5 ? this.a.x0.e3(false, this.a.x5()) : this.a.x0.d3(this.a.x5());
                            view2.setTag(Boolean.valueOf(e3));
                            if (e3) {
                                i7 = 1;
                                this.a.F0.k3(true);
                                this.a.F0.g4();
                                this.a.h = true;
                                this.a.F0.o3(true);
                            } else {
                                i7 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                        } else if (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().l()) {
                            if (view2.getId() == R.id.share_num_container) {
                                if (!a98.c(this.a.getPageContext(), 11009)) {
                                    return;
                                }
                                a98.x(this.a.getContext(), 3, this.a.t5(), this.a.x0);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918ad || view2.getId() == R.id.share_more_container) {
                                if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (l1 = this.a.x0.l1()) == null) {
                                    return;
                                }
                                ThreadData Q2 = l1.Q();
                                if (Q2 != null && Q2.getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", l1.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                    statisticItem3.param("tid", this.a.x0.F1());
                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem3.param("fid", this.a.x0.getForumId());
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
                                                if (Q2.getBaijiahaoData() != null && !yi.isEmpty(Q2.getBaijiahaoData().oriUgcVid)) {
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
                                    if (!yi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    }
                                    if (this.a.S() != null) {
                                        jf5.e(this.a.S(), statisticItem3);
                                    }
                                    if (this.a.F0 != null) {
                                        statisticItem3.param("obj_param1", this.a.F0.V0());
                                    }
                                    TiebaStatic.log(statisticItem3);
                                    if (zi.F()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                                        return;
                                    } else if (l1 == null) {
                                        zi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e77));
                                        return;
                                    } else {
                                        ArrayList<PostData> H2 = this.a.x0.l1().H();
                                        if ((H2 == null || H2.size() <= 0) && this.a.x0.D1()) {
                                            zi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e77));
                                            return;
                                        }
                                        this.a.F0.v0();
                                        this.a.l7();
                                        if (l1.B() != null && !StringUtils.isNull(l1.B().a(), true)) {
                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.x0.l1().m()));
                                        }
                                        TiebaStatic.log(new StatisticItem("c11939"));
                                        if (AntiHelper.e(this.a.getContext(), Q2)) {
                                            return;
                                        }
                                        if (this.a.F0 != null) {
                                            this.a.F0.x0();
                                            this.a.F0.x4(l1);
                                        }
                                        if (ShareSwitch.isOn()) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0918ad) {
                                                i2 = 2;
                                            } else {
                                                i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                            }
                                            if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.F0.b2() && !l1.q0()) {
                                                if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                    if (s45.c() > 0) {
                                                        a98.G(this.a.getContext(), this.a.x0.l1());
                                                    } else {
                                                        int V0 = this.a.F0.V0();
                                                        this.a.F0.i0();
                                                        this.a.Y5(s45.a(), V0);
                                                    }
                                                } else {
                                                    this.a.f7(i2);
                                                }
                                            } else {
                                                this.a.f7(i2);
                                            }
                                        } else {
                                            this.a.F0.W3();
                                            this.a.x0.F0().I(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                        }
                                    }
                                }
                                i = 1;
                                StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem32.param("tid", this.a.x0.F1());
                                statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem32.param("fid", this.a.x0.getForumId());
                                if (view2.getId() != R.id.share_num_container) {
                                }
                                statisticItem32.param("obj_name", i);
                                statisticItem32.param("obj_type", 1);
                                if (Q2 != null) {
                                }
                                if (!yi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                }
                                if (this.a.S() != null) {
                                }
                                if (this.a.F0 != null) {
                                }
                                TiebaStatic.log(statisticItem32);
                                if (zi.F()) {
                                }
                            } else if (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().q()) {
                                if (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().x()) {
                                    if (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().w()) {
                                        if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().u()) {
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
                                            this.a.F0.h.l();
                                        } else if (this.a.F0.W0() == view2) {
                                            if (!this.a.F0.W0().getIndicateStatus()) {
                                                nx8.d("c10725", null);
                                            } else {
                                                y48 l12 = this.a.x0.l1();
                                                if (l12 != null && l12.Q() != null && l12.Q().getTaskInfoData() != null) {
                                                    String d = l12.Q().getTaskInfoData().d();
                                                    if (StringUtils.isNull(d)) {
                                                        d = l12.Q().getTaskInfoData().g();
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                }
                                            }
                                            this.a.Q5();
                                        } else if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().n()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            this.a.F0.v0();
                                            SparseArray<Object> a1 = this.a.F0.a1(this.a.x0.l1(), this.a.x0.D1(), 1);
                                            if (a1 == null) {
                                                return;
                                            }
                                            this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.l1().l().getId(), this.a.x0.l1().l().getName(), this.a.x0.l1().Q().getId(), StringUtils.string(this.a.x0.l1().X().getUserId()), StringUtils.string(a1.get(R.id.tag_forbid_user_name)), StringUtils.string(a1.get(R.id.tag_forbid_user_name_show)), StringUtils.string(a1.get(R.id.tag_forbid_user_post_id)), StringUtils.string(a1.get(R.id.tag_forbid_user_portrait)))));
                                        } else if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().i()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> a12 = this.a.F0.a1(this.a.x0.l1(), this.a.x0.D1(), 1);
                                            if (a12 != null) {
                                                this.a.F0.B2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
                                            }
                                            this.a.F0.h.k();
                                            if (this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().Q() != null) {
                                                ThreadData Q3 = this.a.M().l1().Q();
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
                                        } else if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().m()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> a13 = this.a.F0.a1(this.a.x0.l1(), this.a.x0.D1(), 1);
                                            if (a13 != null) {
                                                if (StringUtils.isNull((String) a13.get(R.id.tag_del_multi_forum))) {
                                                    this.a.F0.y2(((Integer) a13.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a13.get(R.id.tag_del_post_id)), ((Integer) a13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a13.get(R.id.tag_del_post_is_self)).booleanValue());
                                                } else {
                                                    this.a.F0.z2(((Integer) a13.get(R.id.tag_del_post_type)).intValue(), (String) a13.get(R.id.tag_del_post_id), ((Integer) a13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a13.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(a13.get(R.id.tag_del_multi_forum)));
                                                }
                                            }
                                            this.a.F0.h.k();
                                        } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092090 && view2.getId() != R.id.obfuscated_res_0x7f0918c1 && view2.getId() != R.id.obfuscated_res_0x7f09174b) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091925) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091923 && view2.getId() != R.id.obfuscated_res_0x7f091b06 && view2.getId() != R.id.obfuscated_res_0x7f0918bb) {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918bf) {
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
                                                            pbFragment2.L0 = new hw4(pbFragment2.getContext());
                                                            this.a.L0.p(this.a.j2);
                                                        }
                                                        ArrayList arrayList = new ArrayList();
                                                        boolean z3 = this.a.M().l1() != null && this.a.M().l1().l0();
                                                        if (view2 != null && sparseArray != null) {
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
                                                                dw4 dw4Var8 = new dw4(8, pbFragment.getString(i3), this.a.L0);
                                                                SparseArray sparseArray2 = new SparseArray();
                                                                sparseArray2.put(R.id.tag_clip_board, postData);
                                                                dw4Var8.d.setTag(sparseArray2);
                                                                arrayList.add(dw4Var8);
                                                            }
                                                            if (this.a.mIsLogin) {
                                                                if (!xa8.j(this.a.x0) && !booleanValue3 && booleanValue2) {
                                                                    dw4 dw4Var9 = new dw4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bbb), this.a.L0);
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
                                                                    dw4Var9.d.setTag(sparseArray3);
                                                                    arrayList.add(dw4Var9);
                                                                } else if ((a98.C(this.a.x0.l1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                                    dw4 dw4Var10 = new dw4(5, this.a.getString(R.string.report_text), this.a.L0);
                                                                    dw4Var10.d.setTag(str);
                                                                    arrayList.add(dw4Var10);
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
                                                                            dw4 dw4Var11 = new dw4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c9), this.a.L0);
                                                                            dw4Var11.d.setTag(sparseArray4);
                                                                            dw4Var2 = dw4Var11;
                                                                            dw4Var = new dw4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.L0);
                                                                            dw4Var.d.setTag(sparseArray4);
                                                                        }
                                                                    } else {
                                                                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                    }
                                                                    dw4Var2 = null;
                                                                    dw4Var = new dw4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.L0);
                                                                    dw4Var.d.setTag(sparseArray4);
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
                                                                    if (this.a.x0.l1().Y() == 1002 && !booleanValue) {
                                                                        dw4Var3 = new dw4(6, this.a.getString(R.string.report_text), this.a.L0);
                                                                    } else {
                                                                        dw4Var3 = new dw4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c9), this.a.L0);
                                                                    }
                                                                    dw4Var3.d.setTag(sparseArray5);
                                                                    dw4Var2 = dw4Var3;
                                                                    dw4Var = null;
                                                                } else {
                                                                    dw4Var = null;
                                                                    dw4Var2 = null;
                                                                }
                                                                if (dw4Var2 != null) {
                                                                    arrayList.add(dw4Var2);
                                                                }
                                                                if (dw4Var != null) {
                                                                    arrayList.add(dw4Var);
                                                                }
                                                            }
                                                            this.a.L0.k(arrayList);
                                                            this.a.K0 = new fw4(this.a.getPageContext(), this.a.L0);
                                                            this.a.K0.k();
                                                        }
                                                    } else if (view2 == this.a.F0.U0()) {
                                                        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                            this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, yg.g(this.a.x0.l1().m(), 0L), yg.g(this.a.x0.F1(), 0L), yg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.x0.l1().Q().getPushStatusData())));
                                                        }
                                                    } else if (view2 == this.a.F0.h.p()) {
                                                        this.a.F0.K3();
                                                    } else if (this.a.F0.h.o() == null || view2 != this.a.F0.h.o().v()) {
                                                        if (this.a.F0.h.o() != null && view2 == this.a.F0.h.o().o()) {
                                                            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                            if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.x0.F1())) != null) {
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                this.a.F0.h.k();
                                                                TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                            }
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0907ba && view2.getId() != R.id.obfuscated_res_0x7f090a4c) {
                                                            int id3 = view2.getId();
                                                            if (id3 == R.id.pb_u9_text_view) {
                                                                if (!this.a.checkUpIsLogin() || (mv4Var = (mv4) view2.getTag()) == null || StringUtils.isNull(mv4Var.p1())) {
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{mv4Var.p1()});
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091cc8 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    return;
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 != null && view2.getTag() != null) {
                                                                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                    PostData postData2 = (PostData) sparseArray6.get(R.id.tag_load_sub_data);
                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                        TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.x0.b));
                                                                    }
                                                                    if (this.a.L0 == null) {
                                                                        PbFragment pbFragment3 = this.a;
                                                                        pbFragment3.L0 = new hw4(pbFragment3.getContext());
                                                                        this.a.L0.p(this.a.j2);
                                                                    }
                                                                    ArrayList arrayList2 = new ArrayList();
                                                                    a98.y(view2);
                                                                    if (a98.y(view2) && this.a.k1 != null) {
                                                                        this.a.k1.t();
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
                                                                            dw4 dw4Var12 = new dw4(3, this.a.getString(R.string.obfuscated_res_0x7f0f0469), this.a.L0);
                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                            sparseArray7.put(R.id.tag_clip_board, postData2);
                                                                            dw4Var12.d.setTag(sparseArray7);
                                                                            arrayList2.add(dw4Var12);
                                                                        }
                                                                        this.a.F2 = postData2;
                                                                    }
                                                                    if (this.a.x0.l1().r()) {
                                                                        String v = this.a.x0.l1().v();
                                                                        if (postData2 != null && !yi.isEmpty(v) && v.equals(postData2.O())) {
                                                                            z = true;
                                                                            if (!z) {
                                                                                dw4Var4 = new dw4(4, this.a.getString(R.string.remove_mark), this.a.L0);
                                                                            } else {
                                                                                dw4Var4 = new dw4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0b17), this.a.L0);
                                                                            }
                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                            sparseArray8.put(R.id.tag_clip_board, this.a.F2);
                                                                            sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                            dw4Var4.d.setTag(sparseArray8);
                                                                            arrayList2.add(dw4Var4);
                                                                            if (this.a.mIsLogin) {
                                                                                if (!xa8.j(this.a.x0) && !booleanValue9 && booleanValue8) {
                                                                                    dw4 dw4Var13 = new dw4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bbb), this.a.L0);
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
                                                                                    dw4Var4.d.setTag(sparseArray9);
                                                                                    arrayList2.add(dw4Var13);
                                                                                } else if (a98.C(this.a.x0.l1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                    dw4 dw4Var14 = new dw4(5, this.a.getString(R.string.report_text), this.a.L0);
                                                                                    dw4Var14.d.setTag(str2);
                                                                                    arrayList2.add(dw4Var14);
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
                                                                                            dw4 dw4Var15 = new dw4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c9), this.a.L0);
                                                                                            dw4Var15.d.setTag(sparseArray10);
                                                                                            dw4Var6 = dw4Var15;
                                                                                            dw4Var5 = new dw4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.L0);
                                                                                            dw4Var5.d.setTag(sparseArray10);
                                                                                        }
                                                                                    } else {
                                                                                        sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                    }
                                                                                    dw4Var6 = null;
                                                                                    dw4Var5 = new dw4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.L0);
                                                                                    dw4Var5.d.setTag(sparseArray10);
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
                                                                                    if (this.a.x0.l1().Y() == 1002 && !booleanValue7) {
                                                                                        dw4Var7 = new dw4(6, this.a.getString(R.string.report_text), this.a.L0);
                                                                                    } else {
                                                                                        dw4Var7 = new dw4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c9), this.a.L0);
                                                                                    }
                                                                                    dw4Var7.d.setTag(sparseArray11);
                                                                                    dw4Var6 = dw4Var7;
                                                                                    dw4Var5 = null;
                                                                                } else {
                                                                                    dw4Var5 = null;
                                                                                    dw4Var6 = null;
                                                                                }
                                                                                if (dw4Var6 != null) {
                                                                                    arrayList2.add(dw4Var6);
                                                                                }
                                                                                if (dw4Var5 != null) {
                                                                                    arrayList2.add(dw4Var5);
                                                                                }
                                                                            }
                                                                            this.a.L0.k(arrayList2);
                                                                            this.a.K0 = new fw4(this.a.getPageContext(), this.a.L0);
                                                                            this.a.K0.k();
                                                                        }
                                                                    }
                                                                    z = false;
                                                                    if (!z) {
                                                                    }
                                                                    SparseArray sparseArray82 = new SparseArray();
                                                                    sparseArray82.put(R.id.tag_clip_board, this.a.F2);
                                                                    sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                    dw4Var4.d.setTag(sparseArray82);
                                                                    arrayList2.add(dw4Var4);
                                                                    if (this.a.mIsLogin) {
                                                                    }
                                                                    this.a.L0.k(arrayList2);
                                                                    this.a.K0 = new fw4(this.a.getPageContext(), this.a.L0);
                                                                    this.a.K0.k();
                                                                }
                                                            } else if (id3 == R.id.pb_act_btn) {
                                                                if (this.a.x0.l1() != null && this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getActUrl() != null) {
                                                                    BrowserHelper.p(this.a.getActivity(), this.a.x0.l1().Q().getActUrl());
                                                                    if (this.a.x0.l1().Q().getActInfoType() == 1) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    } else if (this.a.x0.l1().Q().getActInfoType() == 2) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.lottery_tail) {
                                                                if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                    String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                    TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.x0.l1().m()).param("tid", this.a.x0.l1().S()).param("lotterytail", StringUtils.string(string4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                    if (!this.a.x0.l1().S().equals(string4)) {
                                                                        this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string4, (String) null, (String) null, (String) null)));
                                                                    } else {
                                                                        this.a.F0.E3(0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0918ed || id3 == R.id.obfuscated_res_0x7f0918b5) {
                                                                if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                    String string5 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                    String r = cz4.l().r("tail_link", "");
                                                                    String string6 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                    if (!StringUtils.isNull(r)) {
                                                                        TiebaStatic.log("c10056");
                                                                        BrowserHelper.t(view2.getContext(), string5, UtilHelper.urlAddParam(r, "page_from=1&tailSkinId=" + string6), true, true, true);
                                                                    }
                                                                    this.a.F0.V2();
                                                                    TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string6));
                                                                }
                                                            } else if (id3 == R.id.join_vote_tv) {
                                                                if (view2 != null) {
                                                                    BrowserHelper.p(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                    if (this.a.t5() == 1 && this.a.x0 != null && this.a.x0.l1() != null) {
                                                                        ac8.u("c10397", this.a.x0.l1().m(), this.a.x0.l1().S(), currentAccount);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.look_all_tv) {
                                                                if (view2 != null) {
                                                                    String string7 = StringUtils.string(view2.getTag());
                                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                    BrowserHelper.p(this.a.getActivity(), string7);
                                                                    if (this.a.t5() == 1 && this.a.x0 != null && this.a.x0.l1() != null) {
                                                                        ac8.u("c10507", this.a.x0.l1().m(), this.a.x0.l1().S(), currentAccount2);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09154d) {
                                                                this.a.k6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09154c) {
                                                                this.a.h6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0927df) {
                                                                if (this.a.x0 != null && this.a.x0.l1() != null && this.a.x0.l1().B() != null) {
                                                                    y48 l13 = this.a.x0.l1();
                                                                    TiebaStatic.log(new StatisticItem("c11679").param("fid", l13.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{l13.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0927dc) {
                                                                if (this.a.x0 != null && this.a.x0.l1() != null && this.a.x0.l1().B() != null) {
                                                                    y48 l14 = this.a.x0.l1();
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", l14.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{l14.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0924cd) {
                                                                if (this.a.p1 >= 0) {
                                                                    if (this.a.x0 != null) {
                                                                        this.a.x0.G2();
                                                                    }
                                                                    if (this.a.x0 == null || this.a.F0.J0() == null) {
                                                                        i6 = 0;
                                                                    } else {
                                                                        i6 = 0;
                                                                        this.a.F0.J0().h0(this.a.x0.l1(), false);
                                                                    }
                                                                    this.a.p1 = i6;
                                                                    if (this.a.x0 != null) {
                                                                        if (this.a.F0.Z0() != null) {
                                                                            this.a.F0.Z0().setSelection(this.a.x0.e1());
                                                                        }
                                                                        this.a.x0.K2(0, 0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.qq_share_container) {
                                                                if (!a98.c(this.a.getPageContext(), 11009)) {
                                                                    return;
                                                                }
                                                                a98.x(this.a.getContext(), 8, this.a.t5(), this.a.x0);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09174b) {
                                                                SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                if (sparseArray12 == null) {
                                                                    return;
                                                                }
                                                                this.a.j7(sparseArray12);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0918aa) {
                                                                if (this.a.F0.Z0() == null || this.a.x0 == null || this.a.x0.l1() == null) {
                                                                    return;
                                                                }
                                                                int firstVisiblePosition = this.a.F0.Z0().getFirstVisiblePosition();
                                                                View childAt = this.a.F0.Z0().getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                boolean y0 = this.a.x0.l1().y0();
                                                                boolean z5 = this.a.F0.k1() != null && this.a.F0.k1().g();
                                                                boolean X1 = this.a.F0.X1();
                                                                boolean z6 = firstVisiblePosition == 0 && top == 0;
                                                                if (!y0 || this.a.F0.k1() == null || this.a.F0.k1().c() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    int l3 = ((int) (zi.l(this.a.getContext()) * 0.5625d)) - this.a.F0.k1().e();
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
                                                                a98.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.x0.l1());
                                                                if ((this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getReply_num() <= 0) || (X1 && z6)) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    if (!this.a.checkUpIsLogin()) {
                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                        return;
                                                                    }
                                                                    this.a.z6();
                                                                    if (this.a.x0.l1().Q().getAuthor() != null) {
                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                    }
                                                                } else {
                                                                    int j = (int) (zi.j(this.a.getContext()) * 0.6d);
                                                                    if (y0) {
                                                                        if (this.a.F0.e1 != null && this.a.F0.e1.c != null && this.a.F0.e1.c.getView() != null) {
                                                                            if (this.a.F0.e1.c.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    } else {
                                                                        if (this.a.F0.h1() != null) {
                                                                            z2 = this.a.F0.h1().getVisibility() == 0;
                                                                            if (!z2 && this.a.F0.e1 != null && this.a.F0.e1.c != null && this.a.F0.e1.c.getView() != null && this.a.F0.e1.c.getView().getParent() != null && this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    }
                                                                    if (z2 || X1) {
                                                                        this.a.a0 = firstVisiblePosition;
                                                                        this.a.b0 = top;
                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                            this.a.F0.Z0().setSelectionFromTop(0, i11 - j);
                                                                            this.a.F0.Z0().smoothScrollBy(-j, 500);
                                                                        } else {
                                                                            this.a.F0.Z0().E(0, i11, 500);
                                                                        }
                                                                    } else if (this.a.a0 <= 0) {
                                                                        int d2 = z98.d(this.a.getListView());
                                                                        if (z98.e(this.a.getListView()) != -1) {
                                                                            d2--;
                                                                        }
                                                                        int g = zi.g(this.a.getContext(), R.dimen.tbds100);
                                                                        if (d2 < 0) {
                                                                            d2 = (ListUtils.getCount(this.a.F0.Z0().getData()) - 1) + this.a.F0.Z0().getHeaderViewsCount();
                                                                            g = 0;
                                                                        }
                                                                        if (z5) {
                                                                            fixedNavHeight = (int) (zi.l(this.a.getContext()) * 0.5625d);
                                                                        } else if (!y0 || this.a.F0.k1() == null) {
                                                                            if (this.a.F0.h != null && this.a.F0.h.a != null) {
                                                                                fixedNavHeight = this.a.F0.h.a.getFixedNavHeight() - 10;
                                                                            }
                                                                            if (this.a.F0.e1 != null || this.a.F0.e1.c == null || this.a.F0.e1.c.getView() == null || this.a.F0.e1.c.getView().getParent() == null) {
                                                                                this.a.F0.Z0().setSelectionFromTop(d2, g + j);
                                                                                this.a.F0.Z0().smoothScrollBy(j, 500);
                                                                            } else if (z5) {
                                                                                this.a.F0.Z0().smoothScrollBy(this.a.F0.e1.c.getView().getTop() - ((int) (zi.l(this.a.getContext()) * 0.5625d)), 500);
                                                                            } else {
                                                                                this.a.F0.Z0().E(d2, g, 200);
                                                                            }
                                                                        } else {
                                                                            fixedNavHeight = this.a.F0.k1().d();
                                                                        }
                                                                        g += fixedNavHeight;
                                                                        if (this.a.F0.e1 != null) {
                                                                        }
                                                                        this.a.F0.Z0().setSelectionFromTop(d2, g + j);
                                                                        this.a.F0.Z0().smoothScrollBy(j, 500);
                                                                    } else if (this.a.F0.Z0().getChildAt(this.a.a0) != null) {
                                                                        this.a.F0.Z0().E(this.a.a0, this.a.b0, 200);
                                                                    } else {
                                                                        this.a.F0.Z0().setSelectionFromTop(this.a.a0, this.a.b0 + j);
                                                                        this.a.F0.Z0().smoothScrollBy(j, 500);
                                                                    }
                                                                }
                                                                if (this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091911 || id3 == R.id.obfuscated_res_0x7f091912) {
                                                                if (this.a.x0 == null || this.a.x0.l1() == null || this.a.x0.l1().l() == null || yi.isEmpty(this.a.x0.l1().l().getName())) {
                                                                    return;
                                                                }
                                                                if (this.a.x0.getErrorNo() == 4) {
                                                                    if (!StringUtils.isNull(this.a.x0.K0()) || this.a.x0.A0() == null) {
                                                                        this.a.a.finish();
                                                                        return;
                                                                    }
                                                                    name = this.a.x0.A0().b;
                                                                } else {
                                                                    name = this.a.x0.l1().l().getName();
                                                                }
                                                                if (StringUtils.isNull(name)) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                String K02 = this.a.x0.K0();
                                                                if (!this.a.x0.Q0() || K02 == null || !K02.equals(name)) {
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.x0.l1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                } else {
                                                                    this.a.a.finish();
                                                                }
                                                                StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                statisticItem6.param("tid", this.a.x0.F1());
                                                                statisticItem6.param("fid", this.a.x0.getForumId());
                                                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                if (this.a.x0.l1().Q() != null) {
                                                                    statisticItem6.param("nid", this.a.x0.l1().Q().getNid());
                                                                }
                                                                TiebaStatic.log(statisticItem6);
                                                            } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                                if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                    if (this.a.x0 == null) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                    statisticItem7.param("tid", this.a.x0.F1());
                                                                    statisticItem7.param("fid", this.a.x0.getForumId());
                                                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem7.param("obj_locate", 2);
                                                                    TiebaStatic.log(statisticItem7);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091939) {
                                                                    if (this.a.x0 == null || this.a.x0.l1() == null) {
                                                                        return;
                                                                    }
                                                                    y48 l15 = this.a.x0.l1();
                                                                    if (this.a.C0 == null) {
                                                                        PbFragment pbFragment4 = this.a;
                                                                        pbFragment4.C0 = new q58(pbFragment4.getPageContext());
                                                                    }
                                                                    long g2 = yg.g(l15.S(), 0L);
                                                                    long g3 = yg.g(l15.m(), 0L);
                                                                    ac8.w("c13446", g3);
                                                                    PbFragment pbFragment5 = this.a;
                                                                    pbFragment5.registerListener(pbFragment5.q2);
                                                                    this.a.C0.a(g2, g3);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09195e) {
                                                                    if (view2.getTag() instanceof SmartApp) {
                                                                        SmartApp smartApp = (SmartApp) view2.getTag();
                                                                        if (!ev5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                            if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                return;
                                                                            }
                                                                            BrowserHelper.p(this.a.getActivity(), smartApp.h5_url);
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.x0.F1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090ecb) {
                                                                    if (!(view2.getTag() instanceof ThreadData)) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090ec8) {
                                                                    if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.Q != null) {
                                                                        this.a.Q.Y(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0918c3 || id3 == R.id.obfuscated_res_0x7f09191d) {
                                                                    if (this.a.r0) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.x0.F1());
                                                                    statisticItem8.param("fid", this.a.x0.getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                    if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                        ac8.s(6);
                                                                    }
                                                                    PbFragment pbFragment6 = this.a;
                                                                    pbFragment6.b = false;
                                                                    pbFragment6.g5(view2);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0924eb) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        ac8.s(5);
                                                                    }
                                                                    this.a.N6(false);
                                                                    this.a.k7((PostData) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                }
                                                            } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                return;
                                                            } else {
                                                                ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                if (this.a.x0.k1() != 3 || !this.a.u0() || this.a.x0.l1() == null || !ListUtils.isEmpty(this.a.x0.l1().p())) {
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
                                                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907bb);
                                                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907bc);
                                                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a4c);
                                                            if (postData3.v0()) {
                                                                postData3.W0(false);
                                                                ya8.e(postData3);
                                                            } else if (this.a.M() != null ? ya8.c(this.a.M().l1(), postData3) : false) {
                                                                postData3.W0(true);
                                                            }
                                                            SkinManager.setBackgroundColor(findViewById, postData3.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                            SkinManager.setViewTextColor(eMTextView, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                            WebPManager.setPureDrawable(imageView, postData3.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        }
                                                    } else {
                                                        this.a.F0.h.l();
                                                        this.a.F0.d4(this.a.I2);
                                                    }
                                                } else if (this.a.x0 == null) {
                                                    return;
                                                } else {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091923) {
                                                        StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                        statisticItem10.param("tid", this.a.x0.F1());
                                                        statisticItem10.param("fid", this.a.x0.getForumId());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("obj_locate", 6);
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091b06) {
                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                            this.a.T = view2;
                                                            return;
                                                        }
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091923 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
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
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091923 && (statisticItem = postData4.e0) != null) {
                                                        StatisticItem copy = statisticItem.copy();
                                                        copy.delete("obj_locate");
                                                        copy.param("obj_locate", 8);
                                                        TiebaStatic.log(copy);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091b06 || view2.getId() == R.id.obfuscated_res_0x7f0918bb) {
                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.x0.G1()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.O()).param("obj_source", 1).param("obj_type", 3));
                                                    }
                                                    if (this.a.x0 == null || this.a.x0.l1() == null || this.a.K5().i1() == null || postData4.r() == null || postData4.F() == 1) {
                                                        return;
                                                    }
                                                    if (this.a.K5().j1() != null) {
                                                        this.a.K5().j1().g();
                                                    }
                                                    o58 o58Var = new o58();
                                                    o58Var.A(this.a.x0.l1().l());
                                                    o58Var.E(this.a.x0.l1().Q());
                                                    o58Var.C(postData4);
                                                    this.a.K5().i1().c0(o58Var);
                                                    this.a.K5().i1().setPostId(postData4.O());
                                                    this.a.l6(view2, postData4.r().getUserId(), "", postData4);
                                                    if (this.a.U0 != null) {
                                                        this.a.F0.d3(this.a.U0.y());
                                                    }
                                                }
                                            } else if (this.a.x0 == null) {
                                                return;
                                            } else {
                                                StatisticItem statisticItem11 = new StatisticItem("c13398");
                                                statisticItem11.param("tid", this.a.x0.F1());
                                                statisticItem11.param("fid", this.a.x0.getForumId());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("obj_locate", 5);
                                                TiebaStatic.log(statisticItem11);
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091925 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
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
                                                    if (this.a.x0 == null || this.a.x0.l1() == null) {
                                                        return;
                                                    }
                                                    String F1 = this.a.x0.F1();
                                                    String O = postData5.O();
                                                    int Y = this.a.x0.l1() != null ? this.a.x0.l1().Y() : 0;
                                                    AbsPbActivity.e A6 = this.a.A6(O);
                                                    if (A6 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F1, O, "pb", true, false, null, false, null, Y, postData5.g0(), this.a.x0.l1().d(), false, postData5.r().getIconInfo(), 5).addBigImageData(A6.a, A6.b, A6.g, A6.j);
                                                    addBigImageData.setKeyPageStartFrom(this.a.x0.k1());
                                                    addBigImageData.setFromFrsForumId(this.a.x0.getFromForumId());
                                                    addBigImageData.setWorksInfoData(this.a.x0.K1());
                                                    addBigImageData.setKeyFromForumId(this.a.x0.getForumId());
                                                    addBigImageData.setTiebaPlusData(this.a.x0.P(), this.a.x0.L(), this.a.x0.M(), this.a.x0.K(), this.a.x0.Q());
                                                    addBigImageData.setBjhData(this.a.x0.D0());
                                                    if (this.a.x0.l1().o() != null) {
                                                        addBigImageData.setHasForumRule(this.a.x0.l1().o().has_forum_rule.intValue());
                                                    }
                                                    if (this.a.x0.l1().X() != null) {
                                                        addBigImageData.setIsManager(this.a.x0.l1().X().getIs_manager());
                                                    }
                                                    if (this.a.x0.l1().l().getDeletedReasonInfo() != null) {
                                                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.x0.l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.x0.l1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                    }
                                                    if (this.a.x0.l1().l() != null) {
                                                        addBigImageData.setForumHeadUrl(this.a.x0.l1().l().getImage_url());
                                                        addBigImageData.setUserLevel(this.a.x0.l1().l().getUser_level());
                                                    }
                                                    if (this.a.F0 != null && this.a.x0.G != null) {
                                                        addBigImageData.setMainPostMaskVisibly(this.a.x0.G.Z().S || postData5.S);
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                } else {
                                                    this.a.S = view2;
                                                    return;
                                                }
                                            }
                                        } else {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09174b) {
                                                StatisticItem statisticItem13 = new StatisticItem("c13398");
                                                statisticItem13.param("tid", this.a.x0.F1());
                                                statisticItem13.param("fid", this.a.x0.getForumId());
                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem13.param("obj_locate", 4);
                                                TiebaStatic.log(statisticItem13);
                                            }
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0918c1 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (!this.a.checkUpIsLogin()) {
                                                    ac8.r("c10517", this.a.x0.l1().m(), 3);
                                                    return;
                                                } else if (this.a.x0 == null || this.a.x0.l1() == null) {
                                                    return;
                                                } else {
                                                    this.a.F0.v0();
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
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09174b) {
                                                            copy3.param("obj_locate", 6);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918c1) {
                                                            copy3.param("obj_locate", 8);
                                                        }
                                                        TiebaStatic.log(copy3);
                                                    }
                                                    String F12 = this.a.x0.F1();
                                                    String O2 = postData6.O();
                                                    String O3 = postData7 != null ? postData7.O() : "";
                                                    int Y2 = this.a.x0.l1() != null ? this.a.x0.l1().Y() : 0;
                                                    this.a.l7();
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091cc8) {
                                                        TiebaStatic.log("c11742");
                                                        AbsPbActivity.e A62 = this.a.A6(O2);
                                                        if (postData6 == null || this.a.x0 == null || this.a.x0.l1() == null || A62 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F12, O2, "pb", true, false, null, false, O3, Y2, postData6.g0(), this.a.x0.l1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(A62.a, A62.b, A62.g, A62.j);
                                                        if (!yi.isEmpty(O3)) {
                                                            addBigImageData2.setHighLightPostId(O3);
                                                            addBigImageData2.setKeyIsUseSpid(true);
                                                        }
                                                        addBigImageData2.setKeyFromForumId(this.a.x0.getForumId());
                                                        addBigImageData2.setTiebaPlusData(this.a.x0.P(), this.a.x0.L(), this.a.x0.M(), this.a.x0.K(), this.a.x0.Q());
                                                        addBigImageData2.setBjhData(this.a.x0.D0());
                                                        addBigImageData2.setKeyPageStartFrom(this.a.x0.k1());
                                                        addBigImageData2.setFromFrsForumId(this.a.x0.getFromForumId());
                                                        addBigImageData2.setWorksInfoData(this.a.x0.K1());
                                                        if (this.a.F0 != null && this.a.x0.G != null && (Z = this.a.x0.G.Z()) != null) {
                                                            addBigImageData2.setMainPostMaskVisibly(Z.S || postData6.S);
                                                        }
                                                        if (this.a.x0.l1() != null && this.a.x0.l1().o() != null) {
                                                            addBigImageData2.setHasForumRule(this.a.x0.l1().o().has_forum_rule.intValue());
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    } else {
                                                        AbsPbActivity.e A63 = this.a.A6(O2);
                                                        if (this.a.x0 == null || this.a.x0.l1() == null || A63 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F12, O2, "pb", true, false, null, true, null, Y2, postData6.g0(), this.a.x0.l1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(A63.a, A63.b, A63.g, A63.j);
                                                        addBigImageData3.setKeyPageStartFrom(this.a.x0.k1());
                                                        addBigImageData3.setFromFrsForumId(this.a.x0.getFromForumId());
                                                        addBigImageData3.setWorksInfoData(this.a.x0.K1());
                                                        addBigImageData3.setKeyFromForumId(this.a.x0.getForumId());
                                                        addBigImageData3.setBjhData(this.a.x0.D0());
                                                        addBigImageData3.setTiebaPlusData(this.a.x0.P(), this.a.x0.L(), this.a.x0.M(), this.a.x0.K(), this.a.x0.Q());
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                    }
                                                }
                                            } else {
                                                this.a.S = view2;
                                                return;
                                            }
                                        }
                                    } else if (this.a.x0 == null || this.a.x0.l1() == null || this.a.x0.l1().Q() == null) {
                                        return;
                                    } else {
                                        this.a.F0.h.k();
                                        TiebaStatic.log(new StatisticItem("c13062"));
                                        PbFragment pbFragment7 = this.a;
                                        pbFragment7.U5(pbFragment7.x0.l1().Q().getFirstPostId());
                                    }
                                } else {
                                    this.a.F0.v0();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.h) {
                                        view2.setTag(Integer.valueOf(this.a.x0.B1()));
                                        return;
                                    } else {
                                        this.a.l7();
                                        this.a.F0.A3();
                                        fw4 fw4Var = new fw4(this.a.getPageContext());
                                        if (this.a.x0.l1().f == null || this.a.x0.l1().f.size() <= 0) {
                                            strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                        } else {
                                            strArr = new String[this.a.x0.l1().f.size()];
                                            for (int i12 = 0; i12 < this.a.x0.l1().f.size(); i12++) {
                                                strArr[i12] = this.a.x0.l1().f.get(i12).sort_name + this.a.getResources().getString(R.string.sort_static);
                                            }
                                        }
                                        fw4Var.i(null, strArr, new a(this, fw4Var, view2));
                                        fw4Var.k();
                                    }
                                }
                            } else {
                                this.a.F0.v0();
                                if (this.a.M().l1().g == 2) {
                                    this.a.showToast(R.string.hot_sort_jump_hint);
                                    return;
                                }
                                if (this.a.x0.j1() != null) {
                                    this.a.F0.k4(this.a.x0.j1(), this.a.h2);
                                }
                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            }
                        } else {
                            this.a.F0.h.k();
                        }
                    } else {
                        this.a.F0.h.l();
                        if (this.a.x0 != null) {
                            this.a.u1.f(this.a.x0.F1());
                        }
                        if (this.a.x0 != null && this.a.x0.isPrivacy()) {
                            this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (this.a.M() == null || this.a.M().l1() == null) {
                                return;
                            }
                            this.a.u1.d(3, 3, this.a.M().l1().S());
                            return;
                        }
                        this.a.u1.b();
                        int i13 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().S() == null || !this.a.M().l1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                        if (this.a.M() != null && this.a.M().l1() != null) {
                            this.a.u1.d(3, i13, this.a.M().l1().S());
                        }
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e68).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091cb8) {
                        String w5 = this.a.w5();
                        if (TextUtils.isEmpty(w5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{w5});
                    }
                } else if (!this.a.r0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.x0.F1());
                    statisticItem15.param("fid", this.a.x0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                        ac8.s(2);
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
                        if (this.a.x0 != null && this.a.x0.l1() != null && this.a.K5().i1() != null && postData8.r() != null && postData8.F() != 1) {
                            if (!this.a.checkUpIsLogin()) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                return;
                            }
                            if (this.a.K5().j1() != null) {
                                this.a.K5().j1().g();
                            }
                            o58 o58Var2 = new o58();
                            o58Var2.A(this.a.x0.l1().l());
                            o58Var2.E(this.a.x0.l1().Q());
                            o58Var2.C(postData8);
                            this.a.K5().i1().c0(o58Var2);
                            this.a.K5().i1().setPostId(postData8.O());
                            this.a.l6(view2, postData8.r().getUserId(), "", postData8);
                            TiebaStatic.log("c11743");
                            ac8.b(this.a.x0.l1(), postData8, postData8.d0, 8, 1);
                            if (this.a.U0 != null) {
                                this.a.F0.d3(this.a.U0.y());
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
        public class a implements hw4.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fw4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ m1 c;

            public a(m1 m1Var, fw4 fw4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var, fw4Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = m1Var;
                this.a = fw4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.x0.C1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.hw4.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void o0(hw4 hw4Var, int i, View view2) {
                boolean f3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.x0.C1() != 1 || i != 1) {
                        if (this.c.a.x0.C1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.x0.C1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091934) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.x0.l1().f != null && this.c.a.x0.l1().f.size() > i) {
                            i = this.c.a.x0.l1().f.get(i).sort_type.intValue();
                        }
                        f3 = this.c.a.x0.f3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.x0.B1()));
                        if (f3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.F0.o3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091934) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.x0.l1().f != null) {
                        i = this.c.a.x0.l1().f.get(i).sort_type.intValue();
                    }
                    f3 = this.c.a.x0.f3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.x0.B1()));
                    if (f3) {
                    }
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
                    this.b.a.F0.G2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements wv4.e {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    wv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements wv4.e {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    wv4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n35 n35Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n35Var, writeData, antiData}) == null) {
                if (!yi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0.l1() != null) {
                        statisticItem.param("fid", this.a.x0.l1().m());
                    }
                    statisticItem.param("tid", this.a.x0.F1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (yi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.l7();
                this.a.F0.y3(z, postWriteCallBackData);
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
                    bh.a().postDelayed(this.a.Y1, 300000L);
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
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.X0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (yi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        wv4 wv4Var = new wv4(this.a.getActivity());
                        if (yi.isEmpty(postWriteCallBackData.getErrorString())) {
                            wv4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            wv4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new b(this));
                        wv4Var.setPositiveButton(R.string.open_now, new c(this));
                        wv4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (l49.d(i) || n35Var != null || i == 227001) {
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
                        this.a.F0.N1(this.a.x0.l1());
                    }
                } else if (this.a.x0.O0()) {
                    y48 l1 = this.a.x0.l1();
                    if (l1 != null && l1.Q() != null && l1.Q().getAuthor() != null && (userId = l1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.x0.c3()) {
                        this.a.F0.A3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.x0.c3()) {
                    this.a.F0.A3();
                }
                if (this.a.x0.S0()) {
                    ac8.p("c10369", this.a.x0.F1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    bh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.x0 != null) {
                    Context context = this.a.getContext();
                    y48 l12 = this.a.x0.l1();
                    String forumId = this.a.x0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a98.a(context, l12, forumId, z2, this.a.x0.q1(), this.a.x0.t1(), this.a.x0.s1(), this.a.x0.r1(), this.a.x0.x1(), this.a.x0.y1());
                }
                if (writeData != null) {
                    x05.b(writeData.getContent(), "1");
                }
                if (this.a.d6()) {
                    this.a.o7();
                }
                this.a.c7();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ q1 b;

            public a(q1 q1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = q1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.F0 != null && this.a != null) {
                    this.b.a.F0.G2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements wv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(q1 q1Var) {
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
                    }
                }
            }

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    wv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements wv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q1 a;

            public c(q1 q1Var) {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    wv4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n35 n35Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n35Var, writeData, antiData}) == null) {
                if (!yi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0 != null && this.a.x0.l1() != null) {
                        statisticItem.param("fid", this.a.x0.l1().m());
                    }
                    if (this.a.x0 != null) {
                        statisticItem.param("tid", this.a.x0.F1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.C5()) {
                        this.a.N6(false);
                        c48.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12b4));
                    }
                    f98 f98Var = this.a.J0;
                    if (f98Var != null) {
                        f98Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d55.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        x05.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        bh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
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
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.X0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (yi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    wv4 wv4Var = new wv4(this.a.getActivity());
                    if (yi.isEmpty(postWriteCallBackData.getErrorString())) {
                        wv4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        wv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new b(this));
                    wv4Var.setPositiveButton(R.string.open_now, new c(this));
                    wv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.J0 != null) {
                        if (pbFragment.F0 != null && this.a.F0.j1() != null && this.a.F0.j1().f() != null && this.a.F0.j1().f().y()) {
                            this.a.F0.j1().f().w(postWriteCallBackData);
                        }
                        this.a.J0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s1 a;

            public a(s1 s1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = s1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                tz4 tz4Var = new tz4();
                tz4Var.b = R.raw.lottie_bubble_breath_tip;
                tz4Var.a = BreatheTipWidget.PointType.LOTTIE;
                tz4Var.c = zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                uz4 uz4Var = new uz4();
                uz4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f0522);
                uz4Var.b = this.a.a.getString(R.string.agree_tip_content);
                uz4Var.e = R.drawable.pic_guidecard;
                uz4Var.f = zi.g(this.a.a.getContext(), R.dimen.tbds156);
                uz4Var.g = zi.g(this.a.a.getContext(), R.dimen.tbds489);
                uz4Var.h = zi.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.F0.n1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.F0.n1()));
                breatheTipWidget.f(uz4Var, tz4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    cz4 l = cz4.l();
                    l.v("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    y45.a("c14828");
                }
            }
        }

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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(y48 y48Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y48Var) == null) {
                this.a.F0.N1(y48Var);
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
            gg5 gg5Var = new gg5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            gg5Var.c();
            if (z2) {
                j3 = j4;
                gg5Var.B = j3;
                gg5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.x0 != null && this.a.x0.l1() != null && this.a.x0.l1().Q() != null) {
                int threadType = this.a.x0.l1().Q().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        cg5 cg5Var = new cg5();
                        cg5Var.F = 1;
                        cg5Var.a(1005);
                        cg5Var.D = j3;
                        cg5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        gg5 gg5Var2 = new gg5();
                        gg5Var2.a(1000);
                        gg5Var2.D = j3;
                        gg5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, y48 y48Var, String str, int i4) {
            ArrayList<PostData> arrayList;
            int i5;
            g75 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), y48Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906fb));
                }
                if (z && y48Var != null && y48Var.a0() == null && ListUtils.getCount(y48Var.H()) < 1) {
                    this.a.x0.Z2(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.F0 != null) {
                        this.a.F0.h4();
                        return;
                    }
                    return;
                }
                if (!this.a.g0) {
                    this.a.g0 = true;
                } else if (this.a.M() != null) {
                    this.a.M().s0();
                }
                this.a.g = true;
                if (this.a.F0 == null) {
                    return;
                }
                this.a.F0.z3();
                if (y48Var == null || !y48Var.t0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.F0.t1());
                }
                this.a.F0.B1();
                if (!this.a.J && !this.a.F0.Z1()) {
                    if (!this.a.F0.S1()) {
                        this.a.F0.O3(false);
                    }
                } else {
                    this.a.F0.v1();
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && y48Var != null) {
                    this.a.N0 = true;
                }
                if (y48Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.F0.t1());
                    this.a.F0.J3();
                }
                String str2 = null;
                if (z && y48Var != null) {
                    ThreadData Q = y48Var.Q();
                    if (Q != null && Q.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.Q6(pbFragment3.T0);
                    }
                    this.a.F0.j1().r(y48Var);
                    this.a.F0.V3();
                    if (Q != null && Q.getCartoonThreadData() != null) {
                        this.a.s7(Q.getCartoonThreadData());
                    }
                    if (this.a.U0 != null) {
                        this.a.F0.d3(this.a.U0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(y48Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(y48Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(y48Var.X().getBimg_end_time());
                    if (y48Var.H() != null && y48Var.H().size() >= 1 && y48Var.H().get(0) != null) {
                        this.a.x0.L2(y48Var.H().get(0).O());
                    } else if (y48Var.a0() != null) {
                        this.a.x0.L2(y48Var.a0().O());
                    }
                    if (this.a.U0 != null) {
                        this.a.U0.H(y48Var.d());
                        this.a.U0.I(y48Var.l(), y48Var.X());
                        this.a.U0.k0(Q);
                        this.a.U0.J(this.a.x0.N0(), this.a.x0.F1(), this.a.x0.J0());
                        if (Q != null) {
                            this.a.U0.Z(Q.isMutiForumThread());
                        }
                    }
                    if (this.a.z0 != null) {
                        this.a.z0.h(y48Var.r());
                    }
                    if (y48Var.s() == 1) {
                        this.a.r = true;
                    } else {
                        this.a.r = false;
                    }
                    if (y48Var.l0()) {
                        this.a.r = true;
                    }
                    this.a.F0.e3(this.a.r);
                    if (this.a.t0.f.size() > 0) {
                        y48Var.S0(this.a.t0.f);
                    }
                    this.a.F0.Z3(y48Var, i2, i3, this.a.x0.D1(), i4, this.a.x0.U0());
                    this.a.F0.o4(y48Var, this.a.x0.D1());
                    this.a.F0.t4(this.a.x0.O0());
                    AntiData d = y48Var.d();
                    if (d != null) {
                        this.a.y = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.U0 != null && this.a.U0.b() != null && (o = this.a.U0.b().o(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) o).setOnClickListener(this.a.H1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.x0.l1().H()) && !this.a.x0.W1()) {
                        this.a.X = true;
                        this.a.Z4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.Q0)) {
                        z98.i(this.a.x0.k1(), this.a.getListView(), this.a.Q0);
                        this.a.Q0 = null;
                    } else if (this.a.P0) {
                        this.a.P0 = false;
                        z98.g(this.a.getListView());
                    } else if (this.a.R0) {
                        this.a.R0 = false;
                        z98.j(this.a.getListView());
                    } else if (!TextUtils.isEmpty(this.a.x0.b1())) {
                        z98.f(this.a.getListView(), this.a.x0.b1());
                        this.a.x0.e2();
                    } else {
                        this.a.F0.U3();
                    }
                    this.a.x0.f2(y48Var.l(), this.a.N1);
                    this.a.x0.l2(this.a.P1);
                    if (this.a.X0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.X0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.x0 != null && this.a.x0.T1()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.F0 != null) {
                        str2 = this.a.F0.l1();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.U0.c0(TbSingleton.getInstance().getAdVertiComment(y48Var.r0(), y48Var.s0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.N0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.x0.A0() != null && !StringUtils.isNull(this.a.x0.A0().c)) {
                                    this.a.F0.v4(this.a.x0.A0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.F0.t1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    vr8.a("pb", false);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(zi.g(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.F0.t1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                vr8.a("pb", false);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(zi.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                            }
                            this.a.F0.v1();
                            this.a.F0.u1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.x0.F1());
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
                        if (this.a.x0 != null && this.a.x0.l1() != null) {
                            arrayList = this.a.x0.l1().H();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                            this.a.F0.Z2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.f6()) {
                                this.a.F0.a3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e78));
                            } else {
                                this.a.F0.a3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e79));
                            }
                            this.a.F0.N1(this.a.x0.l1());
                        }
                    } else {
                        this.a.F0.Z2("");
                    }
                    this.a.F0.D0();
                }
                if (y48Var != null && y48Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (!this.a.M().D1() || this.a.M().l1().z().c() != 0 || this.a.M().Q1()) {
                    this.a.V0 = true;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (y48Var != null) {
                        i5 = y48Var.g();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.E1(i5, this.a.F0);
                }
                int m = cz4.l().m(cz4.p("key_reaction_guide_show_number_pb"), 0);
                if (this.a.a != null && this.a.a.getIntent() != null && this.a.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false)) {
                    if (m != 1 && m != 2 && m != 3) {
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
            b95 b95Var = new b95();
            this.a.Q6(b95Var);
            PbFragment pbFragment = this.a;
            pbFragment.U0 = (c95) b95Var.a(pbFragment.getContext());
            this.a.U0.W(this.a.a.getPageContext());
            this.a.U0.f0(this.a.n2);
            this.a.U0.g0(this.a.a1);
            c95 c95Var = this.a.U0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            c95Var.A(pageContext, extras);
            this.a.U0.b().E(true);
            this.a.F0.Y2(this.a.U0.b());
            if (!this.a.x0.Y0()) {
                this.a.U0.q(this.a.x0.F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.x0.T1()) {
                this.a.U0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.F0 != null) {
                this.a.U0.c0(this.a.F0.l1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                cz4 l = cz4.l();
                if (!l.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    bh.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
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
            hx8 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && this.a.x0.l1() != null) {
                String str = (String) customResponsedMessage.getData();
                hx8 hx8Var = null;
                if (!TextUtils.isEmpty(str) && this.a.x0.l1().H() != null) {
                    ArrayList<PostData> H = this.a.x0.l1().H();
                    Iterator<PostData> it = H.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (next instanceof hx8) {
                            hx8 hx8Var2 = (hx8) next;
                            if (str.equals(hx8Var2.q1())) {
                                hx8Var = hx8Var2;
                                break;
                            }
                        }
                    }
                    if (hx8Var != null) {
                        H.remove(hx8Var);
                    }
                }
                if (this.a.F0.J0() != null && !ListUtils.isEmpty(this.a.F0.J0().t())) {
                    ArrayList<yn> t = this.a.F0.J0().t();
                    if (hx8Var != null) {
                        i = hx8Var;
                    } else {
                        i = a98.i(this.a.x0.l1(), str);
                    }
                    a98.e(t, i);
                }
                if (this.a.F0.Z0() != null && !ListUtils.isEmpty(this.a.F0.Z0().getData())) {
                    List<yn> data = this.a.F0.Z0().getData();
                    if (hx8Var == null) {
                        hx8Var = a98.i(this.a.x0.l1(), str);
                    }
                    a98.e(data, hx8Var);
                }
                this.a.i5(str);
                this.a.x0.O1();
                if (this.a.F0.J0() != null) {
                    this.a.F0.J0().Z();
                }
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.K5() != null) {
                this.a.K5().s2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements Comparator<r55> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(r55 r55Var, r55 r55Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r55Var, r55Var2)) == null) {
                return r55Var.compareTo(r55Var2);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements View.OnLongClickListener {
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
    public class b implements ne6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.ne6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ne6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.ne6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.F0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.B5()) {
                    this.b.F0.A1();
                    this.b.F0.X2();
                }
            }
        }

        @Override // com.baidu.tieba.ne6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.F0 != null && this.b.e != null) {
                this.b.F0.e4();
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.j5();
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.o1 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b3 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements oe6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.tieba.oe6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    z58.d();
                } else {
                    z58.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements SuggestEmotionModel.c {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(da8 da8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, da8Var) != null) || da8Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, da8Var.c()));
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
    public static class c1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c1() {
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
        public void onNavigationButtonClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 extends r9 {
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

        @Override // com.baidu.tieba.r9
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
                        this.a.p5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.F0.F0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.q5(pbFragment.A0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.F0.F0(this.a.A0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.F0.x2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.F0.F0(this.a.A0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c3 implements ItemCardHelper.c {
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
    public class d implements r78.b {
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

        @Override // com.baidu.tieba.r78.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1580);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.F0.t0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!this.a.q0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.w6();
                        return;
                    } else {
                        this.a.I6();
                        return;
                    }
                }
                this.a.q0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.a.W5();
                gu4 j1 = this.a.x0.j1();
                int g1 = this.a.F0.g1();
                if (g1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e7b);
                } else if (j1 != null && g1 > j1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e7b);
                } else {
                    this.a.F0.v0();
                    this.a.l7();
                    this.a.F0.A3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.x0.Z2(this.a.F0.g1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                    }
                    wv4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) && wv4Var != null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d3 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.x0.a1()) {
                    this.a.G6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(zi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    wv4Var.dismiss();
                    ((TbPageContext) this.a.f1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                wv4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.f1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements GetSugMatchWordsModel.b {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.F0 != null) {
                this.a.F0.F3(list);
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
    public class e1 implements i3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.i3
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
                String valueOf = String.valueOf(this.a.x0.l1().X().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.l1().l().getId(), this.a.x0.l1().l().getName(), this.a.x0.l1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements j3 {
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
    }

    /* loaded from: classes5.dex */
    public class e3 implements qg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
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
    public class f implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements PraiseModel.b {
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

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.Q1 = false;
            if (this.a.R1 != null && str != null) {
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
                this.a.Q1 = false;
                if (this.a.R1 == null) {
                    return;
                }
                y48 l1 = this.a.x0.l1();
                if (l1.Q().getPraise().getIsLike() == 1) {
                    this.a.t7(0);
                } else {
                    this.a.t7(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, l1.Q()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements hw4.f {
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

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
                if (this.a.K0 != null) {
                    this.a.K0.dismiss();
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
                                                    ca5.a aVar = new ca5.a();
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
                                                if (this.a.W0 == null) {
                                                    this.a.W0 = new PermissionJudgePolicy();
                                                }
                                                this.a.W0.clearRequestPermissionList();
                                                this.a.W0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.W0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.j1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.j1 = new h98(pbFragment.getPageContext());
                                                }
                                                this.a.j1.b(this.a.l1, this.a.k1.n());
                                                this.a.k1 = null;
                                                this.a.l1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.F2;
                                            if (postData != null) {
                                                postData.H0();
                                                this.a.F2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.p6(view2);
                                            if (this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getAuthor() != null && this.a.x0.l1().Q().getAuthor().getUserId() != null && this.a.z0 != null) {
                                                int w = a98.w(this.a.x0.l1());
                                                ThreadData Q = this.a.x0.l1().Q();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 2).param("obj_id", this.a.x0.l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", w).param("obj_param1", i2));
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
                                                boolean E = this.a.S().E(TbadkCoreApplication.getCurrentAccount());
                                                if (E) {
                                                    if (booleanValue2) {
                                                        this.a.F0.A2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, E);
                                                        return;
                                                    } else {
                                                        this.a.W6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.F0.y2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
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
                                                this.a.F0.D2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.F0.y2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                            this.a.e5(postData2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.x0 != null && this.a.x0.l1() != null) {
                                                this.a.a.w1(l49.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.x0 != null && this.a.x0.l1() != null) {
                                    this.a.F0.A4(true);
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
    public class f2 implements lz4.g {
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

        @Override // com.baidu.tieba.lz4.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.x0.k2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F0.E0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f3 implements i88.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.i88.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

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

        @Override // com.baidu.tieba.i88.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.F0.p4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.F0.l4(!this.a.N);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public g1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                if (wv4Var != null) {
                    wv4Var.dismiss();
                }
                this.d.m5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.x0.k2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F0.E0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public h(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.b.F0.W3();
                MessageManager.getInstance().sendMessage(this.a);
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements ia8.h {
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

        @Override // com.baidu.tieba.ia8.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.P6(z);
                if (this.a.F0.W0() != null && z) {
                    this.a.F0.l4(false);
                }
                this.a.F0.p2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A2 && this.a.B5()) {
                    this.a.h6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.f0 && this.a.F0 != null && this.a.F0.k0() && this.a.x0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.x0.F1());
                    statisticItem.param("fid", this.a.x0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.x0.Q0()) {
                        i = 4;
                    } else if (this.a.x0.R0()) {
                        i = 3;
                    } else if (this.a.x0.T0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.x0.g2(false)) {
                    this.a.F0.B3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if ((this.a.t0 == null || !this.a.x0.a2() || !this.a.t0.d()) && this.a.x0.l1() != null) {
                    this.a.F0.Q2();
                }
                this.a.A2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<c98> a;
        public WeakReference<PbFragment> b;

        public h3(c98 c98Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(c98Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                c98 c98Var = this.a.get();
                if (c98Var != null) {
                    c98Var.z1();
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
                        y27.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements hw4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public i0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
                if (this.e.K0 != null) {
                    this.e.K0.dismiss();
                }
                if (i == 0) {
                    this.e.F0.y2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
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

    /* loaded from: classes5.dex */
    public class i1 implements nx6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.nx6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.nx6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
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

        @Override // com.baidu.tieba.nx6.d
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
                        this.a.U0.b().C(new z65(45, 27, null));
                    }
                    this.a.F0.m0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x0 != null) {
                this.a.x0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends zk5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public j(PbFragment pbFragment, int i) {
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
        @Override // com.baidu.tieba.zk5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.N2(this.a);
                }
                return za8.d(this.b.t5(), 2, M);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null) {
                if (updateAttentionMessage.getData().i != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.U2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().r() != null && this.a.u5().r().getGodUserData() != null) {
                        this.a.u5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.x0 != null && this.a.x0.l1() != null && this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getAuthor() != null) {
                        this.a.x0.l1().Q().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.F0.v0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.x0 != null && !this.a.x0.isLoading) {
                    this.a.l7();
                    this.a.F0.A3();
                    z = true;
                    if (this.a.x0.l1() != null && this.a.x0.l1().f != null && this.a.x0.l1().f.size() > i) {
                        int intValue = this.a.x0.l1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.x0.G1()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.x0.f3(intValue)) {
                            this.a.h = true;
                            this.a.F0.o3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements y85 {
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

        @Override // com.baidu.tieba.y85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                f98 f98Var = this.a.J0;
                if (f98Var != null && f98Var.g() != null && this.a.J0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.J0.g().c());
                    if (this.a.F0 != null && this.a.F0.j1() != null && this.a.F0.j1().f() != null && this.a.F0.j1().f().y()) {
                        this.a.F0.j1().f().w(this.a.J0.h());
                    }
                    this.a.J0.b(true);
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
                    this.a.F0.d3(this.a.U0.y());
                }
                this.a.F0.V2();
                this.a.F0.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends bd5<TipEvent> {
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
        @Override // com.baidu.tieba.uc5
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
    public class l implements dk5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public l(PbFragment pbFragment, int i, int i2) {
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
        @Override // com.baidu.tieba.dk5
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
    public class l0 extends bd5<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uc5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.F0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.F0.t1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ wv4 c;
        public final /* synthetic */ PbFragment d;

        public l2(PbFragment pbFragment, MarkData markData, MarkData markData2, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, wv4Var};
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
            this.c = wv4Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
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
                this.d.m7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData)) {
                return;
            }
            this.a.x0.h3((UserPendantData) customResponsedMessage.getData());
            if (this.a.F0 != null && this.a.x0 != null) {
                this.a.F0.O2(this.a.x0.l1(), this.a.x0.D1(), this.a.x0.v1(), this.a.F0.p1());
            }
            if (this.a.F0 != null && this.a.F0.J0() != null) {
                this.a.F0.J0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public m0(PbFragment pbFragment, Intent intent) {
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
            c98 c98Var = this.b.F0;
            c98Var.D3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ wv4 b;
        public final /* synthetic */ PbFragment c;

        public m2(PbFragment pbFragment, MarkData markData, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, wv4Var};
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
            this.b = wv4Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.F0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.F0.g4();
                } else {
                    this.a.F0.B1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.U0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.F0 != null && this.a.F0.j1() != null && this.a.F0.j1().f() != null) {
                    this.a.F0.j1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements z85 {
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

        @Override // com.baidu.tieba.z85
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ wv4 b;
        public final /* synthetic */ PbFragment c;

        public n2(PbFragment pbFragment, MarkData markData, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, wv4Var};
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
            this.b = wv4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.F0 != null && this.c.F0.t1() != null) {
                    this.c.F0.t1().getLocationOnScreen(iArr);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.U0 != null) {
                this.a.F0.d3(this.a.U0.y());
            }
            this.a.F0.O3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends r9 {
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

        @Override // com.baidu.tieba.r9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.x0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.x0.b)) {
                return;
            }
            this.a.e7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements qg<ImageView> {
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
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
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
                    if (nr4.c().g()) {
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
        @Override // com.baidu.tieba.qg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = nr4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                e48 e48Var = (e48) customResponsedMessage.getData();
                int type = e48Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (e48Var.a() == null) {
                                this.a.E6(false, null);
                                return;
                            } else {
                                this.a.E6(true, (MarkData) e48Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.p5((ForumManageModel.b) e48Var.a(), false);
                    return;
                }
                this.a.F6((o58) e48Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements a48.d {
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

        @Override // com.baidu.tieba.a48.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements qg<GifView> {
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
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
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
                if (nr4.c().g()) {
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
        @Override // com.baidu.tieba.qg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = nr4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F0 != null && this.a.F0.J0() != null) {
                this.a.F0.J0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements a68.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.a68.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.a68.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ce6) {
                        if (this.a.J6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09014f) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof PostData)) {
                                return false;
                            }
                            PostData postData = (PostData) obj;
                            if (postData.getType() != PostData.S0 && !TextUtils.isEmpty(postData.t()) && nr4.c().g()) {
                                return this.a.r6(postData);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918c0) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.j7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.F0.T1() && view2.getId() == R.id.obfuscated_res_0x7f0918df) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.C0() != null && this.a.C0().b != null) {
                                this.a.C0().b.onClick(view2);
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
                if (this.a.U0 != null) {
                    this.a.F0.d3(this.a.U0.y());
                }
                this.a.F0.V2();
                this.a.F0.v0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.a68.a
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
    public class q2 implements qg<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof no5.a)) {
                no5.a aVar = (no5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.R5(aVar.b);
                }
                no5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.x0 != null && this.a.x0.W0()) {
                    this.a.m6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r1 extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r1(PbFragment pbFragment, int i, int i2) {
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

        @Override // com.baidu.tieba.rb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView r1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        zi.P(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.F0 != null && (r1 = this.a.F0.r1()) != null && this.a.F0.Z0() != null) {
                            this.a.F0.Z0().removeHeaderView(r1);
                            return;
                        }
                        return;
                    }
                    zi.Q(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r2 implements qg<View> {
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
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.t0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.i7();
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements yv4.c {
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

        @Override // com.baidu.tieba.yv4.c
        public void a(yv4 yv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yv4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.M0 = pbFragment.M0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new e78(this.a.x0.F1(), this.a.M0, "1").start();
                    yv4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.M0 = pbFragment2.M0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.M0);
                    new e78(this.a.x0.F1(), this.a.M0, "2").start();
                    yv4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.M0 = pbFragment3.M0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.M0);
                    yv4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements qg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.novel_thread_mask_click_tip));
                bdTopToast.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
    public class t2 implements qg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

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
        @Override // com.baidu.tieba.qg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qg
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
        @Override // com.baidu.tieba.qg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.z0 == null || this.a.z0.e()) {
                    return;
                }
                this.a.o6();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                this.a.F0.z1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                y48 l1 = this.a.x0.l1();
                if (l1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    l1.w().add(muteUser);
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
                    if (yi.isEmpty(errorString2)) {
                        errorString2 = this.a.f1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.g1.c(errorString2);
                } else {
                    this.a.Z6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u1(PbFragment pbFragment, int i, boolean z) {
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
                    pbFragment.hideLoadingView(pbFragment.F0.t1());
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
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
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
    public class u2 implements g3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.g3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.F0 != null && this.a.F0.j1() != null) {
                    v78 j1 = this.a.F0.j1();
                    if (j1.j()) {
                        j1.h();
                        return true;
                    }
                }
                if (this.a.F0 != null && this.a.F0.c2()) {
                    this.a.F0.D1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements TiePlusEventController.f {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                this.a.F0.z1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.d(this.a.f1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (yi.isEmpty(muteMessage)) {
                    muteMessage = this.a.f1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.g1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements np4.a {
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

        @Override // com.baidu.tieba.np4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.F0.z3();
                if (z) {
                    if (this.a.z0 != null) {
                        this.a.z0.h(z2);
                    }
                    this.a.x0.b3(z2);
                    if (!this.a.x0.W0()) {
                        this.a.F0.N1(this.a.x0.l1());
                    } else {
                        this.a.m6();
                    }
                    if (z2) {
                        boolean q0 = this.a.x0.l1().q0();
                        if (this.a.z0 != null && !q0) {
                            if (this.a.z0.f() != null && this.a.x0 != null && this.a.x0.l1() != null && this.a.x0.l1().Q() != null && this.a.x0.l1().Q().getAuthor() != null) {
                                MarkData f = this.a.z0.f();
                                MetaData author = this.a.x0.l1().Q().getAuthor();
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
    public class v2 implements TbRichTextView.a0 {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            j78 J0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.F0.m2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.x0.F1());
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
                        this.a.R = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.y6(str, i, eVar);
                    if (this.a.x0.G.l0()) {
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
                        this.a.r5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.x0.w1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.f6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.x0 != null) {
                            builder.D(this.a.x0.getFromForumId());
                            if (this.a.x0.l1() != null) {
                                builder.Q(this.a.x0.l1().Q());
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
                        builder2.I(this.a.x0.w1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.f6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.x0 != null) {
                            builder2.D(this.a.x0.getFromForumId());
                            if (this.a.x0.l1() != null) {
                                builder2.Q(this.a.x0.l1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText u7 = this.a.u7(str, i);
                        if (u7 != null && this.a.C2 >= 0 && this.a.C2 < u7.I().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = z48.a(u7.I().get(this.a.C2));
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
                            if (u7.getPostId() != 0 && (J0 = this.a.F0.J0()) != null) {
                                ArrayList<yn> t = J0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<yn> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        yn next = it.next();
                                        if ((next instanceof PostData) && u7.getPostId() == yg.g(((PostData) next).O(), 0L)) {
                                            int i8 = 8;
                                            if (u7.getPostId() == yg.g(this.a.x0.J0(), 0L)) {
                                                i8 = 1;
                                            }
                                            ac8.b(this.a.x0.l1(), (PostData) next, ((PostData) next).d0, i8, 3);
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
                            builder3.I(this.a.x0.w1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.f6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.x0 != null) {
                                builder3.D(this.a.x0.getFromForumId());
                                if (this.a.x0.l1() != null) {
                                    builder3.Q(this.a.x0.l1().Q());
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
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.d6() || this.a.a == null || this.a.a.l1() == null || !str.equals(this.a.a.l1().getTopicId())) {
                    return;
                }
                this.a.p7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements yv4.c {
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

        @Override // com.baidu.tieba.yv4.c
        public void a(yv4 yv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yv4Var, i, view2) == null) {
                if (yv4Var != null) {
                    yv4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.F2;
                if (postData != null) {
                    if (i == 0) {
                        postData.H0();
                        this.a.F2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.q6(pbFragment2.F2);
                    }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pt4)) {
                pt4 pt4Var = (pt4) customResponsedMessage.getData();
                iu4.a aVar = new iu4.a();
                int i = pt4Var.a;
                String str = pt4Var.b;
                aVar.a = pt4Var.d;
                y48 l1 = this.a.x0.l1();
                if (l1 == null) {
                    return;
                }
                if (this.a.x0.N0() != null && this.a.x0.N0().getUserIdLong() == pt4Var.p) {
                    this.a.F0.N2(pt4Var.l, this.a.x0.l1(), this.a.x0.D1(), this.a.x0.v1());
                }
                if (l1.H() != null && l1.H().size() >= 1 && l1.H().get(0) != null) {
                    long g = yg.g(l1.H().get(0).O(), 0L);
                    long g2 = yg.g(this.a.x0.F1(), 0L);
                    if (g == pt4Var.n && g2 == pt4Var.m) {
                        iu4 M = l1.H().get(0).M();
                        if (M == null) {
                            M = new iu4();
                        }
                        ArrayList<iu4.a> a = M.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        M.e(M.b() + pt4Var.l);
                        M.d(a);
                        l1.H().get(0).N0(M);
                        this.a.F0.J0().Z();
                    }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof o49) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                o49 o49Var = (o49) customResponsedMessage.getData();
                this.a.F0.z1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.e1;
                DataRes dataRes = o49Var.a;
                boolean z = false;
                if (o49Var.c == 0 && dataRes != null) {
                    int e = yg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (yi.isEmpty(str)) {
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
                        this.a.F0.C2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.a7(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public x1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                wv4Var.dismiss();
                this.b.B0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.x0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x2 implements yv4.c {
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

        @Override // com.baidu.tieba.yv4.c
        public void a(yv4 yv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yv4Var, i, view2) == null) {
                if (yv4Var != null) {
                    yv4Var.e();
                }
                if (this.a.k1 != null && !TextUtils.isEmpty(this.a.l1)) {
                    if (i == 0) {
                        if (this.a.n1 != null) {
                            ca5.a aVar = new ca5.a();
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
                        if (this.a.W0 == null) {
                            this.a.W0 = new PermissionJudgePolicy();
                        }
                        this.a.W0.clearRequestPermissionList();
                        this.a.W0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.W0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.j1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.j1 = new h98(pbFragment.getPageContext());
                        }
                        this.a.j1.b(this.a.l1, this.a.k1.n());
                    }
                    this.a.k1 = null;
                    this.a.l1 = null;
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wp5)) {
                wp5 wp5Var = (wp5) customResponsedMessage.getData();
                y48 l1 = this.a.x0.l1();
                if (l1 == null) {
                    return;
                }
                if (this.a.x0.l1() != null && this.a.x0.l1().Z().r() != null && this.a.x0.l1().Z().r().getPortrait() != null && this.a.x0.l1().Z().r().getPortrait().equals(wp5Var.a)) {
                    if (this.a.x0.l1().Z().r().getUserWorldCupData() != null) {
                        this.a.x0.l1().Z().r().getUserWorldCupData().d(wp5Var.b);
                    }
                    this.a.F0.O2(this.a.x0.l1(), this.a.x0.D1(), this.a.x0.v1(), this.a.F0.p1());
                }
                if (l1.H() != null && l1.H().size() >= 0) {
                    Iterator<PostData> it = l1.H().iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(wp5Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(wp5Var.b);
                        }
                    }
                    this.a.F0.J0().Z();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.F0.P1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.n5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements y85 {
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

        @Override // com.baidu.tieba.y85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                f98 f98Var = this.a.J0;
                if (f98Var != null && f98Var.e() != null && this.a.J0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.J0.e().c());
                    if (this.a.U0 != null && (this.a.U0.x() || this.a.U0.z())) {
                        this.a.U0.w(false, this.a.J0.h());
                    }
                    this.a.J0.a(true);
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
    public class y2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.x0 == null || this.a.x0.u1() == i + 1) {
                return;
            }
            this.a.M6(a98.q(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && this.a.x0.l1() != null) {
                this.a.x0.l1().a();
                this.a.x0.O1();
                if (this.a.F0.J0() != null) {
                    this.a.F0.N1(this.a.x0.l1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
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
            yw8 yw8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yw8) && (yw8Var = (yw8) customResponsedMessage.getData()) != null && (agreeData = yw8Var.b) != null) {
                if (this.a.F0 != null) {
                    this.a.F0.i2(yw8Var);
                }
                if (agreeData.agreeType == 2 && this.a.F0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !za8.k(this.a.x0.b)) {
                    this.a.F0.j4();
                    za8.b(this.a.x0.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> H;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.x0 != null && this.a.x0.l1() != null && this.a.F0 != null && this.a.F0.J0() != null) {
                this.a.F0.v2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.x0.X1() && (H = this.a.x0.l1().H()) != null && !H.isEmpty()) {
                    int w = ((i + i2) - this.a.F0.J0().w()) - 1;
                    y48 l1 = this.a.x0.l1();
                    if (l1 == null) {
                        return;
                    }
                    if (l1.E() != null && l1.E().p1()) {
                        w--;
                    }
                    if (l1.F() != null && l1.F().p1()) {
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
                if (!a98.B(this.a.d1) && a98.B(i)) {
                    if (this.a.F0 != null) {
                        this.a.q0 = true;
                        this.a.F0.v0();
                        if (this.a.U0 != null && !this.a.F0.P1()) {
                            this.a.F0.d3(this.a.U0.y());
                        }
                        if (!this.a.J) {
                            this.a.q0 = true;
                            this.a.F0.V2();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.F0 != null) {
                    this.a.F0.w2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new ag5();
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
                this.a.d1 = i;
                if (i == 0) {
                    kv8.g().h(this.a.getUniqueId(), true);
                    this.a.Z4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z2 implements hw4.d {
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

        @Override // com.baidu.tieba.hw4.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.L0 != null) {
                this.a.L0.q(xa8.h(this.a.F2));
                ArrayList arrayList = new ArrayList();
                for (gw4 gw4Var : this.a.L0.g()) {
                    if (gw4Var instanceof dw4) {
                        arrayList.add((dw4) gw4Var);
                    }
                }
                xa8.f(arrayList);
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
        U2 = new c1();
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        V2 = new c();
    }

    public final void K6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (pbModel = this.x0) != null && pbModel.l1() != null && this.x0.l1().Q() != null && this.x0.l1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void L6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (pbModel = this.x0) != null && pbModel.l1() != null && this.x0.l1().Q() != null && this.x0.l1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void W5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            zi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean X6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || !pbModel.D1()) {
                return false;
            }
            if (this.x0.j1() != null && this.x0.j1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && a55.g(TbadkCoreApplication.getInst(), 0) && !this.F0.F2()) {
            this.j0 = a55.k(getPageContext(), "collect", 0L);
        }
    }

    public final void i7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbModel = this.x0) != null && !yi.isEmpty(pbModel.F1())) {
            pm4.w().P(om4.Z, yg.g(this.x0.F1(), 0L));
        }
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (this.x0.l1() != null && this.x0.l1().Q() != null) {
                return this.x0.l1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void t6() {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (list = this.r1) != null && !list.isEmpty()) {
            int size = this.r1.size();
            while (true) {
                size--;
                if (size <= -1 || this.r1.get(size).onBackPressed()) {
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
            this.F0.v0();
            if (this.h) {
                return;
            }
            l7();
            this.F0.A3();
            if (this.x0.loadData()) {
                this.F0.g4();
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
        this.s0 = new v(this);
        this.v0 = new g0(this);
        this.w0 = new Handler(new r0(this));
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
        this.a1 = new n1(this);
        this.b1 = new y1(this);
        this.c1 = new j2(this);
        this.d1 = 0;
        this.o1 = false;
        this.p1 = 0;
        this.q1 = -1;
        this.s1 = 0;
        this.v1 = new u2(this);
        this.w1 = new f3(this);
        this.x1 = new k(this, 2004016);
        this.y1 = new m(this, 2016485);
        this.z1 = new n(this, 2001269);
        this.A1 = new o(this, 2004008);
        this.B1 = new p(this, 2004007);
        this.C1 = new q(this, 2004005);
        this.D1 = new r(this, 2001332);
        this.E1 = new s(this, 2921391);
        this.F1 = new t(this, 2921606);
        this.G1 = new u(this, 2921658);
        this.H1 = new w(this);
        this.I1 = new x(this, 2001369);
        this.J1 = new y(this, 2921787);
        this.K1 = new z(this, 2016488);
        this.L1 = new a0(this, 2016331);
        this.M1 = new b0(this, 2921746);
        this.N1 = new c0(this);
        this.O1 = new d0(this, 2010045);
        this.P1 = new e0(this);
        this.R1 = new PraiseModel(getPageContext(), new f0(this));
        this.S1 = new h0(this);
        this.T1 = new j0(this, 2001115);
        this.U1 = new k0(this);
        this.V1 = new l0(this);
        this.X1 = new a68(new q0(this));
        this.Y1 = new t0(this);
        this.Z1 = new u0(this, 2001427);
        this.a2 = new v0(this, 2001428);
        this.b2 = new w0(this, 2921634);
        this.c2 = new x0(this, 2001426);
        this.d2 = new y0(this, 2004021);
        this.e2 = new z0(this, 2016528);
        this.f2 = new a1(this, 2921724);
        this.g2 = new b1(this, 2921033);
        this.h2 = new d1(this);
        this.i2 = new e1(this);
        this.j2 = new f1(this);
        this.k2 = new j1(this);
        this.l2 = new m1(this);
        this.m2 = new o1(this, 2921480);
        this.n2 = new p1(this);
        this.o2 = Boolean.FALSE;
        this.p2 = new q1(this);
        this.q2 = new r1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.r2 = new s1(this);
        this.s2 = new t1(this, 2016450);
        this.t2 = new u1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.u2 = new v1(this);
        this.v2 = new z1(this);
        this.w2 = new c2(this);
        this.x2 = new e2(this);
        this.y2 = new f2(this);
        this.z2 = new g2(this);
        this.B2 = new h2(this);
        this.C2 = 0;
        this.D2 = new v2(this);
        this.E2 = false;
        this.F2 = null;
        this.G2 = new w2(this);
        this.H2 = new x2(this);
        this.I2 = new y2(this);
        this.J2 = new a3(this);
        this.K2 = new b3(this);
        this.L2 = new c3(this);
        this.M2 = new d3(this);
        this.N2 = new a(this);
        this.O2 = new b(this);
        this.P2 = new d(this);
        this.Q2 = -1;
        this.R2 = -1;
    }

    @Override // com.baidu.tieba.qo5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.qo5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            i98.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    public final void Y5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048648, this, i4, i5) == null) {
            dl5.b(new j(this, i5), new l(this, i5, i4));
        }
    }

    @Override // com.baidu.tieba.qo5
    public void c0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048659, this, context, str) == null) {
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c98 c98Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048716, this, i4, keyEvent)) == null) {
            if (keyEvent == null || (c98Var = this.F0) == null || !c98Var.n2(i4)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void H6(g3 g3Var) {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, g3Var) == null) && g3Var != null && (list = this.r1) != null) {
            list.remove(g3Var);
        }
    }

    public final void M6(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i4) == null) && this.x0 != null) {
            b7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.x0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z3) == null) {
            this.o2 = Boolean.valueOf(z3);
        }
    }

    public void O6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z3) == null) {
            this.r0 = z3;
        }
    }

    public void P6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z3) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z3) == null) {
            this.U0.X(z3);
            this.U0.a0(z3);
            this.U0.i0(z3);
        }
    }

    public void U4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, g3Var) == null) && g3Var != null) {
            if (this.r1 == null) {
                this.r1 = new ArrayList();
            }
            if (!this.r1.contains(g3Var)) {
                this.r1.add(g3Var);
            }
        }
    }

    public void V4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, g3Var) == null) && g3Var != null) {
            if (this.r1 == null) {
                this.r1 = new ArrayList();
            }
            if (!this.r1.contains(g3Var)) {
                this.r1.add(0, g3Var);
            }
        }
    }

    public final void V5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, intent) == null) {
            za8.j(this, intent);
        }
    }

    public final void f7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i4) == null) {
            za8.n(this, t5(), i4);
        }
    }

    @Override // com.baidu.tieba.gd8.b
    public void g1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z3) == null) {
            this.O0 = z3;
        }
    }

    public final void g6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.wv4.e
    public void onClick(wv4 wv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, wv4Var) == null) {
            l5(wv4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.x9
    public void onPreLoad(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, coVar) == null) {
            PreLoadImageHelper.load(coVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(coVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.x0.H2(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.U0.F(bundle);
        }
    }

    public final void p6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, view2) == null) {
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

    public final void s7(at4 at4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048736, this, at4Var) == null) && at4Var != null) {
            this.T2 = at4Var;
            this.c = true;
            this.F0.S2();
            this.F0.n3(this.S2);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.v0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<TiebaPlusRecommendCard> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.D == null) {
                this.D = new pg<>(new q2(this), 5, 0);
            }
            return this.D;
        }
        return (pg) invokeV.objValue;
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.c && this.Q2 == -1 && this.R2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean B6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            z45 z45Var = this.j0;
            if (z45Var != null && z45Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qo5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c98 c98Var = this.F0;
            if (c98Var == null) {
                return 0;
            }
            return c98Var.n1();
        }
        return invokeV.intValue;
    }

    public ha8 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.C0();
        }
        return (ha8) invokeV.objValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public boolean C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o2.booleanValue();
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
    @Override // com.baidu.tieba.qo5
    /* renamed from: E5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c98 c98Var = this.F0;
            if (c98Var == null) {
                return null;
            }
            return c98Var.Z0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public int F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.R2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pg<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (pg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc8
    public PbModel.h G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.r2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            hideNetRefreshView(this.F0.t1());
            b7();
            if (this.x0.m2()) {
                this.F0.A3();
            }
            this.F0.J3();
        }
    }

    public c95 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.U0;
        }
        return (c95) invokeV.objValue;
    }

    public ia8 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.e;
        }
        return (ia8) invokeV.objValue;
    }

    public void I6() {
        z45 z45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (z45Var = this.j0) != null) {
            z45Var.x();
        }
    }

    public va8 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.t0;
        }
        return (va8) invokeV.objValue;
    }

    public c98 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.F0;
        }
        return (c98) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc8
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.x0;
        }
        return (PbModel) invokeV.objValue;
    }

    public ru4 M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.c0;
        }
        return (ru4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<RelativeLayout> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            pg<RelativeLayout> pgVar = new pg<>(new s2(this), 10, 0);
            this.F = pgVar;
            return pgVar;
        }
        return (pg) invokeV.objValue;
    }

    public String N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<FestivalTipView> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (pg) invokeV.objValue;
    }

    public String P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.P;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<ImageView> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.B == null) {
                this.B = new pg<>(new o2(this), 8, 0);
            }
            return this.B;
        }
        return (pg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<View> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.C == null) {
                this.C = new pg<>(new r2(this), 8, 0);
            }
            return this.C;
        }
        return (pg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc8
    public AbsPbActivity S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (pg) invokeV.objValue;
    }

    public void X5() {
        c98 c98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (c98Var = this.F0) != null) {
            c98Var.x1();
            W5();
        }
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new o0(this));
        }
    }

    public boolean c6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.Q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && a55.g(TbadkCoreApplication.getInst(), 0) && !this.F0.F2()) {
            this.j0 = a55.k(getPageContext(), "reply_pb", 0L);
        }
    }

    public final boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.l1() != null && this.a.l1().k1() == 17) {
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
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.O0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<ItemCardView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.G == null) {
                this.G = new pg<>(new t2(this), 10, 0);
            }
            return this.G;
        }
        return (pg) invokeV.objValue;
    }

    public final void l7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            y48 l12 = this.x0.l1();
            this.x0.b3(true);
            np4 np4Var = this.z0;
            if (np4Var != null) {
                l12.L0(np4Var.g());
            }
            this.F0.N1(l12);
        }
    }

    public final void m7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.x1();
        }
    }

    public void n6() {
        c98 c98Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048700, this) != null) || (c98Var = this.F0) == null) {
            return;
        }
        c98Var.f2();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.d0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public co onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            G6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null) {
                return this.x0.l1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (pbModel = this.x0) != null && !yi.isEmpty(pbModel.F1())) {
            super.taskStart();
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.c2();
        }
        return invokeV.booleanValue;
    }

    public PostData u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            y48 y48Var = this.x0.G;
            if (y48Var != null) {
                return y48Var.Z();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qo5
    public pg<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.L == null) {
                this.L = new pg<>(new p2(this), 20, 0);
            }
            return this.L;
        }
        return (pg) invokeV.objValue;
    }

    public String v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public final String w5() {
        InterceptResult invokeV;
        y48 l12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || (l12 = pbModel.l1()) == null) {
                return null;
            }
            return l12.V().c;
        }
        return (String) invokeV.objValue;
    }

    public void w6() {
        z45 z45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && (z45Var = this.j0) != null) {
            z45Var.q();
        }
    }

    @Override // com.baidu.tieba.qo5
    public pg<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.E == null) {
                this.E = new pg<>(new e3(this), 15, 0);
            }
            return this.E;
        }
        return (pg) invokeV.objValue;
    }

    public final AbsPbActivity.e A6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String str2 = null;
            if (this.x0.l1() != null && this.x0.l1().H() != null && this.x0.l1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.x0.l1().H().size()) {
                        if (str.equals(this.x0.l1().H().get(i4).O())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                PostData postData = this.x0.l1().H().get(i4);
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
                    y6(str2, 0, eVar);
                    z48.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void F6(o58 o58Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, o58Var) != null) || o58Var.i() == null) {
            return;
        }
        String O = o58Var.i().O();
        ArrayList<PostData> H = this.x0.l1().H();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= H.size()) {
                break;
            }
            PostData postData = H.get(i4);
            if (postData.O() != null && postData.O().equals(O)) {
                ArrayList<PostData> k3 = o58Var.k();
                postData.d1(o58Var.m());
                if (postData.d0() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.l0() != null && next != null && next.r() != null && (metaData = postData.l0().get(next.r().getUserId())) != null) {
                            next.G0(metaData);
                            next.T0(true);
                            next.m1(getPageContext(), this.x0.d2(metaData.getUserId()));
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
                i4++;
            }
        }
        if (!this.x0.U0() && z3) {
            this.F0.N1(this.x0.l1());
        }
        if (z3) {
            D6(o58Var);
        }
    }

    public void Z4(boolean z3) {
        c98 c98Var;
        int i4;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) && (c98Var = this.F0) != null && c98Var.Z0() != null) {
            int firstVisiblePosition = this.F0.Z0().getFirstVisiblePosition();
            int lastVisiblePosition = this.F0.Z0().getLastVisiblePosition();
            j78 J0 = this.F0.J0();
            if (J0 != null && this.x0.l1() != null) {
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
                        if (this.F0.Z0().G(i4) != null && (this.F0.Z0().G(i4) instanceof PostData) && (postData = (PostData) this.F0.Z0().G(i4)) != null) {
                            PostData postData2 = (PostData) ListUtils.getItem(this.x0.l1().H(), postData.F() - 1);
                            if (postData.o() == null && postData2 != null) {
                                postData.F0(postData2.o());
                            }
                            if (postData.o() != null) {
                                postData.o().q(postData.F());
                                arrayList.add(postData.o());
                            }
                        }
                        i4++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new a2(this));
                    r55 r55Var = (r55) ListUtils.getItem(arrayList, 0);
                    if (r55Var != null && r55Var.e() == 1) {
                        if (!z3) {
                            this.F0.G2(r55Var, 0);
                            return;
                        }
                        return;
                    }
                    this.F0.G2(r55Var, 1);
                }
            }
        }
    }

    public final boolean r6(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048733, this, postData)) == null) {
            if (postData == null) {
                return false;
            }
            String O = postData.O();
            if (StringUtils.isNull(O) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String r3 = cz4.l().r("bubble_link", "");
            if (StringUtils.isNull(r3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = postData.i0().getJumpUrl();
            int packageId = postData.i0().getPackageId();
            int propsId = postData.i0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.p(getPageContext().getPageActivity(), ly8.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                BrowserHelper.t(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), r3 + "?props_id=" + O, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void t7(int i4) {
        PbModel pbModel;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048740, this, i4) != null) || (pbModel = this.x0) == null || pbModel.l1() == null || (Q = this.x0.l1().Q()) == null) {
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
        if (this.x0.D1()) {
            this.F0.J0().Z();
        } else {
            this.F0.B4(this.x0.l1());
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
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            if (str == null) {
                str = "";
            }
            s9 s9Var = this.f1;
            if (s9Var == null) {
                return;
            }
            wv4 wv4Var = new wv4(s9Var.getPageActivity());
            wv4Var.setMessage(str);
            wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a21, new g(this));
            wv4Var.create(this.f1).show();
        }
    }

    public void i6(String str) {
        c98 c98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, str) == null) && this.x0 != null && !StringUtils.isNull(str) && (c98Var = this.F0) != null) {
            c98Var.i3(true);
            this.x0.i2(str);
            this.I = true;
            this.F0.v0();
            this.F0.v1();
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
        if (interceptable == null || interceptable.invokeL(1048710, this, configuration) == null) {
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
            c98 c98Var = this.F0;
            if (c98Var != null) {
                c98Var.k2(configuration);
            }
            fw4 fw4Var = this.K0;
            if (fw4Var != null) {
                fw4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z3) == null) {
            super.onUserChanged(z3);
            this.F0.u4(z3);
            fw4 fw4Var = this.K0;
            if (fw4Var != null) {
                fw4Var.dismiss();
            }
            if (z3 && this.O0) {
                this.F0.B3();
                this.x0.g2(true);
            }
            if (this.F0.J0() != null) {
                this.F0.J0().d0(z3);
            }
        }
    }

    public final void q7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.x0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(xa8.n(i4))));
        }
    }

    public final void r5(Rect rect) {
        c98 c98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048732, this, rect) == null) && rect != null && (c98Var = this.F0) != null && c98Var.s1() != null && rect.top <= this.F0.s1().getHeight()) {
            rect.top += this.F0.s1().getHeight() - rect.top;
        }
    }

    public void D6(o58 o58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, o58Var) == null) {
            String O = o58Var.i().O();
            List<PostData> list = this.x0.l1().V().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.O() != null && postData.O().equals(O)) {
                    ArrayList<PostData> k3 = o58Var.k();
                    postData.d1(o58Var.m());
                    if (postData.d0() != null) {
                        postData.d0().clear();
                        postData.d0().addAll(k3);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.x0.U0()) {
                this.F0.N1(this.x0.l1());
            }
        }
    }

    public final void U5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null && this.x0.l1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.x0.F1(), str);
                ThreadData Q = this.x0.l1().Q();
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
            this.y0.a(str);
        }
    }

    public final void Y6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048649, this, metaData) != null) || metaData == null) {
            return;
        }
        wv4 wv4Var = new wv4(getActivity());
        wv4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b19));
        wv4Var.setTitleShowCenter(true);
        wv4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b1a));
        wv4Var.setMessageShowCenter(true);
        wv4Var.setCancelable(false);
        wv4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b1b), new w1(this, metaData));
        wv4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b1c), new x1(this, metaData));
        wv4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void e7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                M().t0(postWriteCallBackData.getPostId());
                int N0 = this.F0.N0();
                this.p1 = N0;
                this.x0.K2(N0, this.F0.T0());
            }
            this.F0.v0();
            this.J0.c();
            c95 c95Var = this.U0;
            if (c95Var != null) {
                this.F0.d3(c95Var.y());
            }
            this.F0.x1();
            this.F0.O3(true);
            this.x0.O1();
        }
    }

    public final void i5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048684, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.x0) != null && pbModel.l1() != null) {
            hx8 A = this.x0.l1().A();
            if (A != null && str.equals(A.q1())) {
                if (A.getAdvertAppInfo() != null) {
                    A.getAdvertAppInfo().h = null;
                }
                this.x0.l1().b();
            }
            hx8 E0 = this.x0.E0();
            if (E0 != null && str.equals(E0.q1())) {
                this.x0.q0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048708, this, i4) != null) || this.W == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.F0.j2(i4);
        c95 c95Var = this.U0;
        if (c95Var != null && c95Var.b() != null) {
            this.U0.b().y(i4);
        }
        if (this.F0.a() != null) {
            this.F0.a().d(getPageContext(), i4);
        }
        this.J0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.W = i4;
        l7();
        z45 z45Var = this.j0;
        if (z45Var != null) {
            z45Var.w();
        }
    }

    public void q6(PostData postData) {
        PostData u5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048730, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.O() != null && postData.O().equals(this.x0.g1())) {
            z3 = true;
        }
        MarkData f12 = this.x0.f1(postData);
        if (this.x0.l1() != null && this.x0.l1().l0() && (u5 = u5()) != null) {
            f12 = this.x0.f1(u5);
        }
        if (f12 == null) {
            return;
        }
        this.F0.A3();
        np4 np4Var = this.z0;
        if (np4Var != null) {
            np4Var.i(f12);
            if (!z3) {
                this.z0.a();
            } else {
                this.z0.d();
            }
        }
    }

    public void E6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z3, markData) == null) {
            this.F0.z3();
            this.x0.b3(z3);
            np4 np4Var = this.z0;
            if (np4Var != null) {
                np4Var.h(z3);
                if (markData != null) {
                    this.z0.i(markData);
                }
            }
            if (this.x0.W0()) {
                m6();
            } else {
                this.F0.N1(this.x0.l1());
            }
        }
    }

    public final boolean J6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (postData.getType() != PostData.S0 && !TextUtils.isEmpty(postData.t()) && nr4.c().g()) {
                return r6(postData);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null) {
                if (K5().j1() != null) {
                    K5().j1().g();
                }
                o58 o58Var = new o58();
                o58Var.A(this.x0.l1().l());
                o58Var.E(this.x0.l1().Q());
                o58Var.C(postData);
                K5().i1().c0(o58Var);
                K5().i1().setPostId(postData.O());
                l6(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                c95 c95Var = this.U0;
                if (c95Var != null) {
                    this.F0.d3(c95Var.y());
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
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.D0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.D0 = pollingModel;
                pollingModel.x0(rw4.e);
            }
            this.D0.n0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            bh.a().postDelayed(this.Y1, 10000L);
        }
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (this.m1 != null) {
                ca5.b bVar = new ca5.b();
                bVar.a = this.m1.J();
                bVar.b = this.m1.H();
                bVar.c = String.valueOf(this.m1.K());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l1));
        }
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            wv4 wv4Var = new wv4(getPageContext().getPageActivity());
            wv4Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            wv4Var.setPositiveButton(R.string.open_now, new e(this));
            wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new f(this));
            wv4Var.create(this.f1).show();
        }
    }

    public final boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.l1() == null) {
                return false;
            }
            ThreadData Q = this.x0.l1().Q();
            AntiData d4 = this.x0.l1().d();
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
            showLoadingView(this.F0.t1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j4 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j4.getLayoutParams();
            layoutParams.addRule(3, this.F0.s1().getId());
            j4.setLayoutParams(layoutParams);
        }
    }

    public boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if ((this.x0.l1() != null && (this.x0.l1().l0() || ThreadCardUtils.isSelf(this.x0.l1().Q()))) || this.X0 == null || this.x0.l1() == null || this.x0.l1().d() == null) {
                return true;
            }
            return this.X0.checkPrivacyBeforeInvokeEditor(this.x0.l1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final boolean e6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            PostData c4 = z48.c(this.x0.l1(), this.x0.D1(), this.x0.v1());
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
            if (this.x0.Q0() || this.x0.T0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.x0.F1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.x0.F1()));
            if (n7()) {
                this.a.finish();
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && this.T2 != null) {
            if (this.R2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e75);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.T2.a(), this.R2, 0)));
                this.a.finish();
            }
        }
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && this.T2 != null) {
            if (this.Q2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e76);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.T2.a(), this.Q2, 0)));
                this.a.finish();
            }
        }
    }

    public void o5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && this.F0 != null && (pbModel = this.x0) != null && pbModel.l1() != null && this.x0.l1().U() != null && checkUpIsLogin() && this.F0.J0() != null && this.F0.J0().z() != null) {
            this.F0.J0().z().v(this.x0.F1(), this.x0.getFromForumId());
        }
    }

    public final void o7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && (absPbActivity = this.a) != null && absPbActivity.l1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l1().F1()).param("topic_id", this.a.l1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.l1().J1()));
        }
    }

    public final void r7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(this.x0.getForumId()) && this.x0.l1() != null && this.x0.l1().l() != null) {
            boolean z3 = true;
            if (this.x0.l1().l().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.x0.y0().K(this.x0.getForumId(), this.x0.F1());
            }
        }
    }

    public void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.x0.l1() != null && this.x0.l1().Q() != null && this.x0.l1().Q().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.x0.l1().Q().getTaskInfoData().i(), this.x0.l1().Q().getTaskInfoData().g(), this.x0.l1().Q().getTaskInfoData().b(), this.x0.l1().Q().getTaskInfoData().c(), this.x0.l1().Q().getIs_top(), this.x0.l1().Q().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null) {
                hx8 A = this.x0.l1().A();
                if (A != null) {
                    if (A.getAdvertAppInfo() != null) {
                        A.getAdvertAppInfo().h = null;
                    }
                    this.x0.l1().b();
                }
                if (this.x0.E0() != null) {
                    this.x0.q0();
                }
                this.x0.O1();
            }
            if (this.x0.l1().H() != null) {
                Iterator<PostData> it = this.x0.l1().H().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof hx8) {
                        it.remove();
                    }
                }
            }
            if (this.F0.J0() != null && !ListUtils.isEmpty(this.F0.J0().t())) {
                a98.d(this.F0.J0().t());
            }
            if (this.F0.Z0() != null && !ListUtils.isEmpty(this.F0.Z0().getData())) {
                a98.d(this.F0.Z0().getData());
            }
            if (this.F0.J0() != null) {
                this.F0.J0().Z();
            }
        }
    }

    public final boolean n7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.l1() != null && this.x0.l1().l0()) {
                return true;
            }
            if (this.x0.W0()) {
                MarkData H0 = this.x0.H0();
                if (H0 != null && this.x0.U0()) {
                    MarkData B0 = this.x0.B0(this.F0.Q0());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", H0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(H0.getPostId())) {
                        wv4 wv4Var = new wv4(getPageContext().getPageActivity());
                        wv4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        wv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f044c, new l2(this, B0, H0, wv4Var));
                        wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new m2(this, H0, wv4Var));
                        wv4Var.setOnCalcelListener(new n2(this, H0, wv4Var));
                        wv4Var.create(getPageContext());
                        wv4Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", H0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.x0.l1() != null && this.x0.l1().H() != null && this.x0.l1().H().size() > 0 && this.x0.U0()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
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
            c98 c98Var = this.F0;
            if (c98Var != null && c98Var.t1() != null) {
                if (!this.g) {
                    b7();
                } else {
                    hideLoadingView(this.F0.t1());
                }
                this.F0.t2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            c98 c98Var2 = this.F0;
            if (c98Var2 != null) {
                noNetworkView = c98Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.D1);
            this.O0 = false;
            L6();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.o1) {
                G6();
                this.o1 = false;
            }
            i7();
            ItemCardHelper.w(this.L2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                s65.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
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
            fb8 fb8Var = this.F0.h;
            if (fb8Var != null && !fb8Var.v()) {
                this.F0.h.z();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null && this.x0.l1().l() != null && this.x0.l1().Q() != null) {
                p65.j().x(getPageContext().getPageActivity(), "pb", this.x0.l1().l().getId(), yg.g(this.x0.l1().Q().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            kv8.g().h(getUniqueId(), false);
        }
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.l1() == null || this.x0.l1().H() == null || (count = ListUtils.getCount((H = this.x0.l1().H()))) == 0) {
                return "";
            }
            if (this.x0.w1()) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        return next.O();
                    }
                }
            }
            int Q0 = this.F0.Q0();
            PostData postData = (PostData) ListUtils.getItem(H, Q0);
            if (postData != null && postData.r() != null) {
                if (this.x0.d2(postData.r().getUserId())) {
                    return postData.O();
                }
                for (int i4 = Q0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i4);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (this.x0.d2(postData2.r().getUserId())) {
                        return postData2.O();
                    }
                }
                for (int i5 = Q0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i5);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (this.x0.d2(postData3.r().getUserId())) {
                        return postData3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void Q6(e95 e95Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, e95Var) == null) && e95Var != null && (pbModel = this.x0) != null) {
            e95Var.p(pbModel.K0());
            if (this.x0.l1() != null && this.x0.l1().l() != null) {
                e95Var.o(this.x0.l1().l());
            }
            e95Var.q("pb");
            e95Var.r(this.x0);
        }
    }

    public final void R6(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i4) != null) || (pbModel = this.x0) == null) {
            return;
        }
        int u12 = pbModel.u1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.x0.V2(1);
                } else {
                    this.x0.V2(4);
                }
            } else {
                this.x0.V2(3);
            }
        } else {
            this.x0.V2(2);
        }
        int u13 = this.x0.u1();
        if (u12 == 4 || u13 == 4) {
            u6();
        }
    }

    public final void Z5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            np4 c4 = np4.c(this.a);
            this.z0 = c4;
            if (c4 != null) {
                c4.j(this.u2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.A0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.w2);
            this.B0 = new c45(getPageContext());
            L5();
            this.R1.setUniqueId(getUniqueId());
            this.R1.registerListener();
        }
    }

    public void b5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.F0.W3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = yg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = yg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.h1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.e1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean d5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048664, this, i4)) == null) {
            if (this.X0 != null && this.x0.l1() != null && !ThreadCardUtils.isSelf(this.x0.l1().Q()) && this.x0.l1().d() != null) {
                return this.X0.checkPrivacyBeforeSend(this.x0.l1().d().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void j6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, bundle) == null) {
            PbModel l12 = this.a.l1();
            this.x0 = l12;
            if (l12 != null) {
                if (l12.G0() != null) {
                    this.x0.G0().c(this.P2);
                }
                if (this.x0.h1() != null) {
                    this.x0.h1().f(this.w1);
                }
                if (StringUtils.isNull(this.x0.F1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.x0.S2(6);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906fb));
            y48 d4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d();
            if (d4 != null) {
                this.r2.c(true, 0, 3, 0, d4, "", 1);
            }
            this.a.n1().d(this.s0);
        }
    }

    public final void p7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048728, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.l1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l1().F1()).param("topic_id", this.a.l1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.l1().J1()));
        }
    }

    public void x6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048755, this, animatorListener) == null) && this.F0 != null && (pbModel = this.x0) != null && pbModel.l1() != null && this.x0.l1().U() != null && checkUpIsLogin() && this.F0.J0() != null && this.F0.J0().z() != null) {
            this.F0.J0().z().F(animatorListener);
        }
    }

    public final void S5(int i4, Intent intent) {
        l75 l75Var;
        l75 l75Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048627, this, i4, intent) == null) {
            if (i4 == 0) {
                this.F0.x1();
                this.F0.j1().g();
                this.F0.O3(false);
            }
            this.F0.V2();
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
                if (editorType == 1 && this.F0.j1() != null && this.F0.j1().f() != null) {
                    g95 f4 = this.F0.j1().f();
                    f4.d0(this.x0.l1().Q());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    k75 p3 = f4.b().p(6);
                    if (p3 != null && (l75Var2 = p3.m) != null) {
                        l75Var2.A(new z65(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
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
            k75 p4 = this.U0.b().p(6);
            if (p4 != null && (l75Var = p4.m) != null) {
                l75Var.A(new z65(52, 0, pbEditorData.getVoiceModel()));
            }
            this.U0.h0(pbEditorData.isShowCustomFigure());
            if (i4 == -1) {
                this.U0.G(null, null);
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
                        d55.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            c48.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            c48.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            c48.e(getResources().getString(R.string.obfuscated_res_0x7f0f12b4));
                            return;
                        } else {
                            c48.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.x0.Y0()) {
                antiData.setBlock_forum_name(this.x0.l1().l().getName());
                antiData.setBlock_forum_id(this.x0.l1().l().getId());
                antiData.setUser_name(this.x0.l1().X().getUserName());
                antiData.setUser_id(this.x0.l1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void a7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048655, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            fw4 fw4Var = this.K0;
            if (fw4Var != null && fw4Var.isShowing()) {
                this.K0.dismiss();
                this.K0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            hw4 hw4Var = new hw4(getContext());
            hw4Var.p(new i0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new dw4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04c9), hw4Var));
            }
            if (z3) {
                arrayList.add(new dw4(1, getResources().getString(R.string.un_mute), hw4Var));
            } else {
                arrayList.add(new dw4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0bb7), hw4Var));
            }
            hw4Var.k(arrayList);
            fw4 fw4Var2 = new fw4(getPageContext(), hw4Var);
            this.K0 = fw4Var2;
            fw4Var2.k();
        }
    }

    public void k5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(c98.o2)).intValue();
            if (intValue == c98.p2) {
                if (this.A0.Z()) {
                    return;
                }
                this.F0.q4();
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
                this.A0.c0(this.x0.l1().l().getId(), this.x0.l1().l().getName(), this.x0.l1().Q().getId(), str, intValue3, intValue2, booleanValue, this.x0.l1().Q().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == c98.q2 || intValue == c98.s2) {
                PbModel pbModel = this.x0;
                if (pbModel != null && pbModel.G0() != null) {
                    this.x0.G0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == c98.q2) {
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
            if (postData == null || (pbModel = this.x0) == null || pbModel.l1() == null || postData.F() == 1) {
                return;
            }
            String F1 = this.x0.F1();
            String O = postData.O();
            if (this.x0.l1() != null) {
                i4 = this.x0.l1().Y();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e A6 = A6(O);
            if (A6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo g02 = postData.g0();
            AntiData d4 = this.x0.l1().d();
            if (postData.r() != null) {
                arrayList = postData.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(F1, O, "pb", true, false, null, false, null, i4, g02, d4, false, arrayList, 5).addBigImageData(A6.a, A6.b, A6.g, A6.j);
            addBigImageData.setKeyPageStartFrom(this.x0.k1());
            addBigImageData.setFromFrsForumId(this.x0.getFromForumId());
            addBigImageData.setWorksInfoData(this.x0.K1());
            addBigImageData.setKeyFromForumId(this.x0.getForumId());
            addBigImageData.setBjhData(this.x0.D0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void n5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048699, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            c98 c98Var = this.F0;
            if (c98Var != null && this.x0 != null) {
                if ((c98Var == null || c98Var.P1()) && this.x0.l1() != null && this.x0.l1().U() != null) {
                    c98 c98Var2 = this.F0;
                    if (c98Var2 != null && c98Var2.P0() != null && this.F0.P0().t()) {
                        return;
                    }
                    m58 U = this.x0.l1().U();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!U.f() || U.a() != 2) && this.F0.J0() != null && this.F0.J0().z() != null) {
                        this.F0.J0().z().v(this.x0.F1(), this.x0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        a48 a48Var = new a48(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.x0;
                        a48Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        a48Var.l(new p0(this));
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
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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

    @Override // com.baidu.tieba.qo5
    public void U(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048632, this, context, str, z3) == null) {
            if (i98.c(str) && (pbModel = this.x0) != null && pbModel.F1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.x0.F1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    k65 k65Var = new k65();
                    k65Var.a = str;
                    k65Var.b = 3;
                    k65Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, k65Var));
                }
            } else {
                i98.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void w0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048751, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (no5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), no5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (i98.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new cm5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void U6(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048635, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new b2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                g7(str);
            } else {
                this.F0.p4(str);
            }
        }
    }

    @Override // com.baidu.tieba.qo5
    public void Y(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048646, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.M0 = str;
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
        y48 y48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (pbModel = this.x0) != null && (y48Var = pbModel.G) != null && y48Var.Q() != null) {
            ThreadData Q = this.x0.G.Q();
            Q.mRecomAbTag = this.x0.q1();
            Q.mRecomWeight = this.x0.t1();
            Q.mRecomSource = this.x0.s1();
            Q.mRecomExtra = this.x0.r1();
            Q.isSubPb = this.x0.Y0();
            if (Q.getFid() == 0) {
                Q.setFid(yg.g(this.x0.getForumId(), 0L));
            }
            StatisticItem i4 = jf5.i(getContext(), Q, "c13562");
            TbPageTag l3 = jf5.l(getContext());
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
        MarkData B0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && this.z0 != null) {
            if (this.x0.l1() != null && this.x0.l1().l0()) {
                B0 = this.x0.B0(0);
            } else {
                B0 = this.x0.B0(this.F0.Y0());
            }
            if (B0 == null) {
                return;
            }
            if (B0.isApp() && (B0 = this.x0.B0(this.F0.Y0() + 1)) == null) {
                return;
            }
            this.F0.A3();
            this.z0.i(B0);
            if (!this.z0.e()) {
                if (this.F0 != null && this.x0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !za8.k(this.x0.b)) {
                    this.F0.j4();
                    za8.b(this.x0.b);
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
            ya8.a();
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
            c98 c98Var = this.F0;
            if (c98Var != null) {
                c98Var.q2();
            }
            if (!this.x0.Y0()) {
                this.U0.N(this.x0.F1());
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.o2();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            pm4.w().E();
            MessageManager.getInstance().unRegisterListener(this.D1);
            K6();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            z45 z45Var = this.j0;
            if (z45Var != null) {
                z45Var.q();
                this.j0.p();
            }
        }
    }

    public final void W6(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            xa8.e(getActivity(), getPageContext(), new g1(this, sparseArray, i4, z3), new h1(this));
        }
    }

    public final void Y4(y48 y48Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048647, this, y48Var, arrayList) == null) && y48Var != null && y48Var.V() != null && y48Var.V().a != null && (list = y48Var.V().a) != null && arrayList != null) {
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
        if ((interceptable != null && interceptable.invokeIL(1048729, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.F0.F0(this.A0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.G0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.H0 = false;
                    this.I0 = true;
                }
            } else {
                this.H0 = true;
                this.I0 = false;
            }
            if (i4 == 2) {
                this.x0.l1().Q().setIs_good(1);
                this.x0.O2(1);
            } else if (i4 == 3) {
                this.x0.l1().Q().setIs_good(0);
                this.x0.O2(0);
            } else if (i4 == 4) {
                this.x0.l1().Q().setIs_top(1);
                this.x0.P2(1);
            } else if (i4 == 5) {
                this.x0.l1().Q().setIs_top(0);
                this.x0.P2(0);
            }
            this.F0.y4(this.x0.l1(), this.x0.D1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        zi.Q(getPageContext().getPageActivity(), string);
    }

    public final void b6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048657, this) != null) || this.l != null) {
            return;
        }
        this.l = new yv4(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        yv4 yv4Var = this.l;
        yv4Var.j(strArr, new s0(this));
        yv4Var.g(yv4.b.a);
        yv4Var.h(17);
        yv4Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e5(AgreeData agreeData) {
        ef5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new yy4();
        }
        if (this.i0 == null) {
            yw8 yw8Var = new yw8();
            this.i0 = yw8Var;
            yw8Var.a = getUniqueId();
        }
        ls4 ls4Var = new ls4();
        ls4Var.b = 5;
        ls4Var.h = 8;
        ls4Var.g = 2;
        if (M() != null) {
            ls4Var.f = M().k1();
        }
        ls4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                ls4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i4, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.x0;
                if (pbModel == null && pbModel.l1() != null) {
                    this.e0.b(S(), ls4Var, agreeData, this.x0.l1().Q());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            ls4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            ls4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.e0.c(agreeData, i4, getUniqueId(), false);
        this.e0.d(agreeData, this.i0);
        pbModel = this.x0;
        if (pbModel == null) {
        }
    }

    @Override // com.baidu.tieba.kc8
    public void finish() {
        c98 c98Var;
        boolean z3;
        CardHListViewData q3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            c98 c98Var2 = this.F0;
            if (c98Var2 != null) {
                c98Var2.v0();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null && !this.x0.l1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.x0.l1().Q().getId();
                if (this.x0.isShareThread() && this.x0.l1().Q().originalThreadData != null) {
                    historyMessage.threadName = this.x0.l1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.x0.l1().Q().getTitle();
                }
                if (this.x0.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.x0.l1().l().getName();
                }
                ArrayList<PostData> H = this.x0.l1().H();
                c98 c98Var3 = this.F0;
                if (c98Var3 != null) {
                    i4 = c98Var3.Q0();
                } else {
                    i4 = 0;
                }
                if (H != null && i4 >= 0 && i4 < H.size()) {
                    historyMessage.postID = H.get(i4).O();
                }
                historyMessage.isHostOnly = this.x0.O0();
                historyMessage.isSquence = this.x0.D1();
                historyMessage.isShareThread = this.x0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c95 c95Var = this.U0;
            if (c95Var != null) {
                c95Var.D();
            }
            if (this.i && K5() != null) {
                K5().A0();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && (pbModel2.Q0() || this.x0.T0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.x0.F1());
                if (this.G0) {
                    if (this.I0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.x0.Z0());
                    }
                    if (this.H0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.x0.V0());
                    }
                }
                if (this.x0.l1() != null && System.currentTimeMillis() - this.o >= 40000 && (q3 = this.x0.l1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.q1);
                }
                this.a.setResult(-1, intent);
            }
            if (n7()) {
                if (this.x0 != null && (c98Var = this.F0) != null && c98Var.Z0() != null) {
                    y48 l12 = this.x0.l1();
                    if (l12 != null) {
                        if (l12.X() != null) {
                            l12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            l12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!l12.t0() && !this.I && l12.h == null) {
                            r88 b4 = r88.b();
                            y48 m12 = this.x0.m1();
                            Parcelable onSaveInstanceState = this.F0.Z0().onSaveInstanceState();
                            boolean D1 = this.x0.D1();
                            boolean O0 = this.x0.O0();
                            if (this.F0.h1() != null && this.F0.h1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.n(m12, onSaveInstanceState, D1, O0, z3);
                            if (this.p1 >= 0 || this.x0.H1() != null) {
                                r88.b().q(this.x0.H1());
                                r88.b().r(this.x0.I1());
                                r88.b().o(this.x0.e1());
                            }
                        }
                    }
                } else {
                    r88.b().m();
                }
                m7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        fb8 fb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            kv8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!yi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.x0.l1().m());
                statisticItem.param("tid", this.x0.F1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.F0 != null) {
                this.s = true;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.x0.destory();
                if (this.x0.h1() != null) {
                    this.x0.h1().d();
                }
            }
            c95 c95Var = this.U0;
            if (c95Var != null) {
                c95Var.D();
            }
            ForumManageModel forumManageModel = this.A0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.U();
            }
            c98 c98Var = this.F0;
            if (c98Var != null) {
                c98Var.l2();
                fb8 fb8Var2 = this.F0.h;
                if (fb8Var2 != null) {
                    fb8Var2.z();
                }
            }
            ag5 ag5Var = this.t;
            if (ag5Var != null) {
                ag5Var.c();
            }
            ia8 ia8Var = this.e;
            if (ia8Var != null) {
                ia8Var.k();
            }
            pg<TextView> pgVar = this.z;
            if (pgVar != null) {
                pgVar.c();
            }
            pg<FestivalTipView> pgVar2 = this.H;
            if (pgVar2 != null) {
                pgVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c98 c98Var2 = this.F0;
            if (c98Var2 != null) {
                c98Var2.v0();
            }
            if (this.Y1 != null) {
                bh.a().removeCallbacks(this.Y1);
            }
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.g2);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.q2);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.f2);
            this.f1 = null;
            this.g1 = null;
            ap8.e().g();
            if (this.i1 != null) {
                bh.a().removeCallbacks(this.i1);
            }
            c98 c98Var3 = this.F0;
            if (c98Var3 != null && (fb8Var = c98Var3.h) != null) {
                fb8Var.r();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            f98 f98Var = this.J0;
            if (f98Var != null) {
                f98Var.j();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && pbModel2.y0() != null) {
                this.x0.y0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.X0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            c98 c98Var4 = this.F0;
            if (c98Var4 != null) {
                c98Var4.r4();
            }
            va8 va8Var = this.t0;
            if (va8Var != null) {
                va8Var.e();
            }
        }
    }

    public void v6() {
        PbModel pbModel;
        y48 l12;
        ThreadData Q;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        y48 y48Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048750, this) == null) && (pbModel = this.x0) != null && pbModel.l1() != null && (Q = (l12 = this.x0.l1()).Q()) != null && Q.getAuthor() != null) {
            this.F0.x1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q.getAuthor().getUserId());
            k88 k88Var = new k88();
            int Y = this.x0.l1().Y();
            if (Y != 1 && Y != 3) {
                k88Var.g = false;
            } else {
                k88Var.g = true;
                if (Q.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                k88Var.s = z3;
            }
            if (a98.z(this.x0.l1(), Y)) {
                k88Var.h = true;
                if (Q.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                k88Var.r = z8;
            } else {
                k88Var.h = false;
            }
            if (Y == 1002 && !equals) {
                k88Var.u = true;
            }
            k88Var.n = a98.J(Q.isBlocked(), l12.o0(), equals, Y, Q.isWorksInfo(), Q.isScoreThread());
            k88Var.e = a98.H(l12, equals, l12.o0(), this.x0.O());
            k88Var.i = X6();
            k88Var.f = a98.I(this.x0.l1(), equals, this.x0.O());
            if (equals && l12.X() != null && l12.X().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            k88Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                k88Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            k88Var.t = equals;
            k88Var.q = this.x0.D1();
            k88Var.b = true;
            k88Var.a = a98.C(this.x0.l1(), equals);
            if (equals) {
                this.F0.O1();
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            k88Var.p = z5;
            k88Var.j = true;
            k88Var.o = this.x0.O0();
            k88Var.d = true;
            if (Q.getThreadVideoInfo() == null) {
                k88Var.c = true;
            } else {
                k88Var.c = false;
            }
            if (l12.l0()) {
                k88Var.b = false;
                k88Var.d = false;
                k88Var.c = false;
                k88Var.g = false;
                k88Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !l12.l0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            k88Var.v = z6;
            if (this.F0 != null && (y48Var = this.x0.G) != null) {
                PostData Z = y48Var.Z();
                if (Z != null) {
                    z7 = Z.S;
                } else {
                    z7 = false;
                }
                k88Var.w = z7;
            }
            k88Var.m = true;
            if (Q.isBlocked()) {
                k88Var.n = false;
                k88Var.g = false;
                k88Var.h = false;
            }
            this.F0.h.G(k88Var);
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
        List<dw4> c4;
        int i4;
        boolean z20;
        dw4 dw4Var;
        dw4 dw4Var2;
        dw4 dw4Var3;
        dw4 dw4Var4;
        dw4 dw4Var5;
        dw4 dw4Var6;
        jn jnVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            c98 c98Var = this.F0;
            if (c98Var != null) {
                if (c98Var.R1()) {
                    return true;
                }
                this.F0.G0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (a98.y(view2)) {
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
                        this.F0.b4(this.H2, this.k1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.F2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.F() == 1 && a98.y(view2)) {
                this.F0.b4(this.H2, this.k1.t());
                return true;
            }
            np4 np4Var = this.z0;
            if (np4Var == null) {
                return true;
            }
            if (np4Var.e() && this.F2.O() != null && this.F2.O().equals(this.x0.g1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (M().l1() != null && M().l1().l0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (M().l1() != null && M().l1().q0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (M().l1() != null && M().l1().p0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.F2.F() == 1) {
                if (!z4) {
                    this.F0.c4(this.G2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.L0 == null) {
                hw4 hw4Var = new hw4(getContext());
                this.L0 = hw4Var;
                hw4Var.p(this.j2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (a98.y(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (a98.y(view2) && (jnVar = this.k1) != null && !jnVar.t()) {
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
                    arrayList.add(new dw4(1, getString(R.string.save_to_emotion), this.L0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new dw4(2, getString(R.string.save_to_local), this.L0));
                }
                if (!z7 && !z8) {
                    dw4 dw4Var7 = new dw4(3, getString(R.string.obfuscated_res_0x7f0f0469), this.L0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.F2);
                    dw4Var7.d.setTag(sparseArray3);
                    arrayList.add(dw4Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        dw4Var6 = new dw4(4, getString(R.string.remove_mark), this.L0);
                    } else {
                        dw4Var6 = new dw4(4, getString(R.string.obfuscated_res_0x7f0f0b17), this.L0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.F2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    dw4Var6.d.setTag(sparseArray4);
                    arrayList.add(dw4Var6);
                }
                if (this.mIsLogin) {
                    if (!xa8.j(this.x0) && !z12 && z11) {
                        dw4 dw4Var8 = new dw4(5, getString(R.string.obfuscated_res_0x7f0f0bbb), this.L0);
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
                        dw4Var8.d.setTag(sparseArray5);
                        arrayList.add(dw4Var8);
                    } else {
                        if (a98.C(this.x0.l1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            dw4 dw4Var9 = new dw4(5, getString(R.string.report_text), this.L0);
                            dw4Var9.d.setTag(str);
                            arrayList.add(dw4Var9);
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
                        if (!xa8.j(this.x0) && z18) {
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
                                dw4Var5 = new dw4(6, getString(R.string.obfuscated_res_0x7f0f04c9), this.L0);
                                dw4Var5.d.setTag(sparseArray6);
                                dw4Var2 = new dw4(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.L0);
                                dw4Var2.d.setTag(sparseArray6);
                                dw4Var3 = dw4Var5;
                                dw4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        dw4Var5 = null;
                        dw4Var2 = new dw4(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.L0);
                        dw4Var2.d.setTag(sparseArray6);
                        dw4Var3 = dw4Var5;
                        dw4Var = null;
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
                        if (this.x0.l1().Y() == 1002 && !z10) {
                            dw4Var4 = new dw4(6, getString(R.string.report_text), this.L0);
                        } else {
                            dw4Var4 = new dw4(6, getString(R.string.obfuscated_res_0x7f0f04c9), this.L0);
                        }
                        dw4Var4.d.setTag(sparseArray7);
                        if (z17) {
                            dw4Var = new dw4(13, getString(R.string.multi_delete), this.L0);
                            dw4Var3 = dw4Var4;
                        } else {
                            dw4Var3 = dw4Var4;
                            dw4Var = null;
                        }
                        dw4Var2 = null;
                    } else {
                        dw4Var = null;
                        dw4Var2 = null;
                        dw4Var3 = null;
                    }
                    if (dw4Var3 != null) {
                        arrayList.add(dw4Var3);
                    }
                    if (dw4Var != null) {
                        arrayList.add(dw4Var);
                    }
                    if (dw4Var2 != null) {
                        arrayList.add(dw4Var2);
                    }
                    xa8.b(arrayList, this.L0, this.F2, this.x0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = xa8.d(arrayList, this.F2.p(), sparseArray, this.L0);
                } else {
                    c4 = xa8.c(arrayList, this.F2.p(), sparseArray, this.L0);
                }
                xa8.m(c4, this.b);
                xa8.f(c4);
                this.L0.q(xa8.h(this.F2));
                this.L0.l(c4, !UbsABTestHelper.isPBPlanA());
                this.K0 = new fw4(getPageContext(), this.L0);
                this.L0.o(new z2(this));
                this.K0.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.x0.b).param("fid", this.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.x0.I());
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

    public void h5(ForumManageModel.b bVar, c98 c98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, bVar, c98Var) == null) {
            List<PostData> list = this.x0.l1().V().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).d0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).d0().get(i5).O())) {
                        list.get(i4).d0().remove(i5);
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
                c98Var.N1(this.x0.l1());
            }
        }
    }

    public final void h7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.F0.W3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            wv4 wv4Var = new wv4(this.f1.getPageActivity());
            if (!yi.isEmpty(str)) {
                wv4Var.setMessage(str);
            } else {
                wv4Var.setMessage(this.f1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            wv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f044c, new h(this, userMuteAddAndDelCustomMessage));
            wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new i(this));
            wv4Var.create(this.f1).show();
        }
    }

    public void l5(wv4 wv4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048693, this, wv4Var, jSONArray) == null) {
            wv4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(wv4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                k5((SparseArray) wv4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText u7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048746, this, str, i4)) == null) {
            PbModel pbModel = this.x0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.l1() == null || str == null || i4 < 0) {
                return null;
            }
            y48 l12 = this.x0.l1();
            if (l12.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(l12.j());
                tbRichText = y5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> H = l12.H();
                Y4(l12, H);
                return y5(H, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final void l6(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048694, this, view2, str, str2, postData) == null) {
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
                    if (this.x0.l1() != null && this.x0.l1().l0()) {
                        bh.a().postDelayed(new k1(this, str, str2), 0L);
                        return;
                    }
                    if (this.Z0 == null) {
                        nx6 nx6Var = new nx6(getPageContext());
                        this.Z0 = nx6Var;
                        nx6Var.j(1);
                        this.Z0.i(new l1(this, str, str2));
                    }
                    PbModel pbModel = this.x0;
                    if (pbModel != null && pbModel.l1() != null && this.x0.l1().l() != null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.Z0.g(this.x0.l1().l().getId(), yg.g(this.x0.F1(), 0L));
                        return;
                    }
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void m5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048696, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(c98.o2, Integer.valueOf(c98.p2));
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
        if (interceptable == null || interceptable.invokeIIL(1048706, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.U0.C(i4, i5, intent);
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
                                                        c98 c98Var = this.F0;
                                                        if (c98Var != null && c98Var.K0() != null) {
                                                            this.F0.K0().performClick();
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
                                            this.F0.C3(false);
                                            if (this.x0.l1() != null && this.x0.l1().Q() != null && this.x0.l1().Q().getPushStatusData() != null) {
                                                this.x0.l1().Q().getPushStatusData().setStatus(2);
                                                return;
                                            }
                                            return;
                                        }
                                        int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                        if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                            um8.g().m(getPageContext());
                                            r7();
                                            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
                                            if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                                shareSuccessReplyToServerModel.G(str, intExtra, new k2(this));
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
                                        this.F0.T3(view5);
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
                        um8.g().m(getPageContext());
                        return;
                    }
                    r88.b().m();
                    this.w0.postDelayed(new i2(this), 1000L);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048712, this, layoutInflater, viewGroup, bundle)) == null) {
            this.F0 = new c98(this, this.l2, this.X1);
            oe6 oe6Var = new oe6(getActivity());
            this.d = oe6Var;
            oe6Var.i(V2);
            this.d.d(this.O2);
            this.F0.t3(this.v2);
            this.F0.s3(this.B2);
            this.F0.l3(this.y2);
            this.F0.m3(this.z2);
            this.F0.j3(nr4.c().g());
            this.F0.q3(this.D2);
            this.F0.w3(this.J2);
            this.F0.u3(this.K2);
            this.F0.r3(this.M2);
            this.F0.p3(this.x2);
            this.F0.u4(this.mIsLogin);
            this.F0.g3(this.x0.R1());
            if (this.a.getIntent() != null) {
                this.F0.h3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.F0.i1().setFromForumId(this.x0.getFromForumId());
            this.F0.Y2(this.U0.b());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.U0.c0(this.F0.l1());
            }
            this.F0.c3(this.i2);
            this.F0.f3(this.x0.T0());
            this.F0.v3(this.x0.k1());
            this.t0.f(this.F0, this.x0);
            if ("1".equals(M().showReplyPanel)) {
                this.F0.s2();
            }
            return this.F0.t1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        c98 c98Var;
        c98 c98Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.f1 = getPageContext();
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
                this.Q2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.R2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.S2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.P0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.Q0 = intent.getStringExtra("high_light_post_id");
                this.R0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (B5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (yi.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.q1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                ru4 ru4Var = new ru4();
                this.c0 = ru4Var;
                ru4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.s1 = intExtra;
                if (intExtra == 0) {
                    this.s1 = intent.getIntExtra("key_start_from", 0);
                }
                this.t1 = intent.getStringExtra("last_tid");
            } else {
                this.m = System.currentTimeMillis();
            }
            this.q = this.o - this.m;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.k = 0;
            j6(bundle);
            if (this.x0.l1() != null) {
                this.x0.l1().U0(this.P);
            }
            a6();
            if (intent != null && (c98Var2 = this.F0) != null) {
                c98Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.i1 == null) {
                        this.i1 = new m0(this, intent);
                    }
                    bh.a().postDelayed(this.i1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.x0.l1() != null) {
                    this.x0.T2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            Z5(bundle);
            e95 e95Var = new e95();
            this.T0 = e95Var;
            Q6(e95Var);
            c95 c95Var = (c95) this.T0.a(getActivity());
            this.U0 = c95Var;
            c95Var.W(this.a.getPageContext());
            this.U0.f0(this.n2);
            this.U0.g0(this.a1);
            this.U0.Y(1);
            this.U0.A(this.a.getPageContext(), bundle);
            this.U0.b().b(new j75(getActivity()));
            this.U0.b().E(true);
            T6(true);
            this.U0.J(this.x0.N0(), this.x0.F1(), this.x0.J0());
            registerListener(this.A1);
            if (!this.x0.Y0()) {
                this.U0.q(this.x0.F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.U0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.x0.T1()) {
                this.U0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                c98 c98Var3 = this.F0;
                if (c98Var3 != null) {
                    this.U0.c0(c98Var3.l1());
                }
            }
            registerListener(this.z1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.y1);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.t2);
            registerListener(this.x1);
            zw8 zw8Var = new zw8("pb", zw8.d);
            this.S0 = zw8Var;
            zw8Var.d();
            registerListener(this.I1);
            registerListener(this.T1);
            this.x0.p2();
            registerListener(this.s2);
            registerListener(this.g2);
            registerListener(this.m2);
            registerListener(this.O1);
            registerListener(this.f2);
            registerListener(this.J1);
            c98 c98Var4 = this.F0;
            if (c98Var4 != null && c98Var4.s1() != null && this.F0.q1() != null) {
                ia8 ia8Var = new ia8(getActivity(), this.F0.s1(), this.F0.q1(), this.F0.h1());
                this.e = ia8Var;
                ia8Var.t(this.S1);
            }
            if (this.c && (c98Var = this.F0) != null && c98Var.q1() != null) {
                this.F0.q1().setVisibility(8);
            }
            hz4 hz4Var = new hz4();
            this.g1 = hz4Var;
            hz4Var.a = 1000L;
            registerListener(this.c2);
            registerListener(this.b2);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.L1);
            registerListener(this.M1);
            registerListener(this.E1);
            registerListener(this.F1);
            registerListener(this.G1);
            this.K1.setSelfListener(true);
            this.K1.setTag(this.a.getUniqueId());
            this.K1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.K1);
            registerResponsedEventListener(TipEvent.class, this.U1);
            registerResponsedEventListener(TopToastEvent.class, this.V1);
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
            this.W1 = new h3(this.F0, this);
            this.x0.F0().K(this.W1);
            this.J0 = new f98();
            if (this.U0.s() != null) {
                this.J0.m(this.U0.s().i());
            }
            this.U0.V(this.b1);
            this.E0 = new ShareSuccessReplyToServerModel();
            U4(this.v1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.X0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
            gb8 gb8Var = new gb8(getContext());
            this.y0 = gb8Var;
            gb8Var.b(getUniqueId());
            kv8.g().i(getUniqueId());
            as4.b().l("3", "");
            this.u1 = new y76(getPageContext());
            this.t0 = new va8(this, getUniqueId(), this.F0, this.x0);
            this.u0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    public final void p5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048726, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                wv4 wv4Var = new wv4(getPageContext().getPageActivity());
                wv4Var.setMessage(string);
                wv4Var.setPositiveButton(R.string.dialog_known, new d2(this));
                wv4Var.setCancelable(true);
                wv4Var.create(getPageContext());
                wv4Var.show();
            } else if (bVar.d != 0) {
                this.F0.F0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> H = this.x0.l1().H();
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
                    this.x0.l1().Q().setReply_num(this.x0.l1().Q().getReply_num() - 1);
                    this.F0.N1(this.x0.l1());
                } else if (i5 == 0) {
                    f5();
                } else if (i5 == 2) {
                    ArrayList<PostData> H2 = this.x0.l1().H();
                    int size2 = H2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= H2.get(i6).d0().size()) {
                                break;
                            } else if (bVar.g.equals(H2.get(i6).d0().get(i7).O())) {
                                H2.get(i6).d0().remove(i7);
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
                        this.F0.N1(this.x0.l1());
                    }
                    h5(bVar, this.F0);
                }
            }
        }
    }

    public final TbRichText y5(ArrayList<PostData> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048757, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText Z = arrayList.get(i5).Z();
                    if (Z != null && (I = Z.I()) != null) {
                        int size = I.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (I.get(i7) != null && I.get(i7).getType() == 8) {
                                i6++;
                                if (!I.get(i7).O().H().equals(str) && !I.get(i7).O().I().equals(str)) {
                                    if (i6 > i4) {
                                        break;
                                    }
                                } else {
                                    int i8 = (int) zi.i(TbadkCoreApplication.getInst());
                                    int width = I.get(i7).O().getWidth() * i8;
                                    int height = I.get(i7).O().getHeight() * i8;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.C2 = i7;
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
        y48 l12 = this.x0.l1();
        TbRichText u7 = u7(str, i4);
        if (u7 == null || (tbRichTextData = u7.I().get(this.C2)) == null) {
            return;
        }
        eVar.f = String.valueOf(u7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.O().N()) {
            eVar.h = false;
            String a4 = z48.a(tbRichTextData);
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
            imageUrlData.originalUrl = a98.o(tbRichTextData);
            imageUrlData.originalUrl = a98.o(tbRichTextData);
            imageUrlData.originalSize = a98.p(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = a98.l(tbRichTextData);
            imageUrlData.isLongPic = a98.k(tbRichTextData);
            imageUrlData.postId = u7.getPostId();
            imageUrlData.mIsReserver = this.x0.w1();
            imageUrlData.mIsSeeHost = this.x0.O0();
            eVar.b.put(a4, imageUrlData);
            if (l12 != null) {
                if (l12.l() != null) {
                    eVar.c = l12.l().getName();
                    eVar.d = l12.l().getId();
                }
                if (l12.Q() != null) {
                    eVar.e = l12.Q().getId();
                }
                if (l12.s() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = yg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = l12.H().size();
        this.E2 = false;
        eVar.j = -1;
        if (l12.j() != null) {
            i5 = z5(l12.j().Z(), u7, i4, i4, eVar.a, eVar.b);
        } else {
            i5 = i4;
        }
        int i7 = i5;
        for (int i8 = 0; i8 < size; i8++) {
            PostData postData = l12.H().get(i8);
            if (postData.O() == null || l12.j() == null || l12.j().O() == null || !postData.O().equals(l12.j().O())) {
                i7 = z5(postData.Z(), u7, i7, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (l12 != null) {
            if (l12.l() != null) {
                eVar.c = l12.l().getName();
                eVar.d = l12.l().getId();
            }
            if (l12.Q() != null) {
                eVar.e = l12.Q().getId();
            }
            if (l12.s() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i7;
    }

    public final int z5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo O;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048759, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.E2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.I().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.I().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int i10 = (int) zi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.O().getWidth() * i10;
                        int height = tbRichTextData.O().getHeight() * i10;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.O().N()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = z48.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (O = tbRichTextData.O()) != null) {
                                        String H = O.H();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            H = O.I();
                                        } else {
                                            if (this.r) {
                                                i6 = 17;
                                            } else {
                                                i6 = 18;
                                            }
                                            imageUrlData.urlType = i6;
                                        }
                                        imageUrlData.imageUrl = H;
                                        imageUrlData.originalUrl = a98.o(tbRichTextData);
                                        imageUrlData.originalSize = a98.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = a98.l(tbRichTextData);
                                        imageUrlData.isLongPic = a98.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = yg.g(this.x0.F1(), -1L);
                                        imageUrlData.mIsReserver = this.x0.w1();
                                        imageUrlData.mIsSeeHost = this.x0.O0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.E2) {
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

    public void z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.l1() != null && this.x0.l1().l() != null) {
                if (a5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.x0.l1().l0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.F0.m0();
                    return;
                } else {
                    if (this.Y0 == null) {
                        nx6 nx6Var = new nx6(getPageContext());
                        this.Y0 = nx6Var;
                        nx6Var.j(0);
                        this.Y0.i(new i1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Y0.g(this.x0.l1().l().getId(), yg.g(this.x0.F1(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
