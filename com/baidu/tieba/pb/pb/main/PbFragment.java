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
import com.baidu.tieba.a38;
import com.baidu.tieba.a48;
import com.baidu.tieba.ah;
import com.baidu.tieba.az4;
import com.baidu.tieba.az6;
import com.baidu.tieba.bo;
import com.baidu.tieba.bs4;
import com.baidu.tieba.bs8;
import com.baidu.tieba.bv4;
import com.baidu.tieba.c65;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ci8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp5;
import com.baidu.tieba.cs8;
import com.baidu.tieba.d35;
import com.baidu.tieba.d68;
import com.baidu.tieba.dn8;
import com.baidu.tieba.dr4;
import com.baidu.tieba.e38;
import com.baidu.tieba.f46;
import com.baidu.tieba.f55;
import com.baidu.tieba.f65;
import com.baidu.tieba.f68;
import com.baidu.tieba.ft4;
import com.baidu.tieba.g68;
import com.baidu.tieba.gu4;
import com.baidu.tieba.gw4;
import com.baidu.tieba.h08;
import com.baidu.tieba.h58;
import com.baidu.tieba.h68;
import com.baidu.tieba.hj5;
import com.baidu.tieba.i08;
import com.baidu.tieba.i18;
import com.baidu.tieba.i45;
import com.baidu.tieba.i68;
import com.baidu.tieba.i78;
import com.baidu.tieba.ik5;
import com.baidu.tieba.ik8;
import com.baidu.tieba.in;
import com.baidu.tieba.iz4;
import com.baidu.tieba.j18;
import com.baidu.tieba.j48;
import com.baidu.tieba.jm4;
import com.baidu.tieba.jp4;
import com.baidu.tieba.jz4;
import com.baidu.tieba.jz7;
import com.baidu.tieba.km4;
import com.baidu.tieba.ks8;
import com.baidu.tieba.ku5;
import com.baidu.tieba.l48;
import com.baidu.tieba.l58;
import com.baidu.tieba.l85;
import com.baidu.tieba.lf5;
import com.baidu.tieba.ll5;
import com.baidu.tieba.lv4;
import com.baidu.tieba.lz7;
import com.baidu.tieba.m05;
import com.baidu.tieba.m18;
import com.baidu.tieba.m45;
import com.baidu.tieba.m65;
import com.baidu.tieba.m85;
import com.baidu.tieba.mj5;
import com.baidu.tieba.mk5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n28;
import com.baidu.tieba.n45;
import com.baidu.tieba.n68;
import com.baidu.tieba.n85;
import com.baidu.tieba.n95;
import com.baidu.tieba.nc5;
import com.baidu.tieba.nf5;
import com.baidu.tieba.nq8;
import com.baidu.tieba.nv4;
import com.baidu.tieba.ny4;
import com.baidu.tieba.nz7;
import com.baidu.tieba.o45;
import com.baidu.tieba.o48;
import com.baidu.tieba.o68;
import com.baidu.tieba.o85;
import com.baidu.tieba.o88;
import com.baidu.tieba.og;
import com.baidu.tieba.ot8;
import com.baidu.tieba.oz8;
import com.baidu.tieba.p58;
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
import com.baidu.tieba.pe5;
import com.baidu.tieba.pg;
import com.baidu.tieba.q48;
import com.baidu.tieba.q58;
import com.baidu.tieba.q85;
import com.baidu.tieba.q9;
import com.baidu.tieba.qb;
import com.baidu.tieba.qr4;
import com.baidu.tieba.qs4;
import com.baidu.tieba.qs8;
import com.baidu.tieba.r38;
import com.baidu.tieba.r45;
import com.baidu.tieba.r48;
import com.baidu.tieba.r9;
import com.baidu.tieba.rf5;
import com.baidu.tieba.ry4;
import com.baidu.tieba.rz8;
import com.baidu.tieba.s28;
import com.baidu.tieba.s35;
import com.baidu.tieba.s78;
import com.baidu.tieba.s85;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sp4;
import com.baidu.tieba.sv4;
import com.baidu.tieba.t38;
import com.baidu.tieba.t65;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tn5;
import com.baidu.tieba.ue5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uv4;
import com.baidu.tieba.v08;
import com.baidu.tieba.va6;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vt4;
import com.baidu.tieba.vt6;
import com.baidu.tieba.w65;
import com.baidu.tieba.wa6;
import com.baidu.tieba.wn5;
import com.baidu.tieba.wv4;
import com.baidu.tieba.wy4;
import com.baidu.tieba.x08;
import com.baidu.tieba.x55;
import com.baidu.tieba.x65;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.tieba.xt4;
import com.baidu.tieba.y65;
import com.baidu.tieba.yi;
import com.baidu.tieba.z08;
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
public class PbFragment extends BaseFragment implements wn5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, lv4.e, TbRichTextView.s, TbPageContextSupport, s78, o88.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final wa6.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public og<TbImageView> A;
    public s35 A0;
    public CustomMessageListener A1;
    public final BdListView.p A2;
    public og<ImageView> B;
    public z08 B0;
    public CustomMessageListener B1;
    public int B2;
    public og<View> C;
    public PollingModel C0;
    public CustomMessageListener C1;
    public final TbRichTextView.y C2;
    public og<TiebaPlusRecommendCard> D;
    public ShareSuccessReplyToServerModel D0;
    public final CustomMessageListener D1;
    public boolean D2;
    public og<LinearLayout> E;
    public l48 E0;
    public CustomMessageListener E1;
    public PostData E2;
    public og<RelativeLayout> F;
    public boolean F0;
    public CustomMessageListener F1;
    public final nv4.c F2;
    public og<ItemCardView> G;
    public boolean G0;
    public View.OnClickListener G1;
    public final nv4.c G2;
    public boolean H;
    public boolean H0;
    public CustomMessageListener H1;
    public final AdapterView.OnItemClickListener H2;
    public boolean I;
    public o48 I0;
    public CustomMessageListener I1;
    public final View.OnLongClickListener I2;
    public boolean J;
    public uv4 J0;
    public CustomMessageListener J1;
    public final View.OnClickListener J2;
    public og<GifView> K;
    public wv4 K0;
    public CustomMessageListener K1;
    public final ItemCardHelper.c K2;
    public String L;
    public String L0;
    public CustomMessageListener L1;
    public final NoNetworkView.b L2;
    public boolean M;
    public boolean M0;
    public SuggestEmotionModel.c M1;
    public View.OnTouchListener M2;
    public boolean N;
    public boolean N0;
    public CustomMessageListener N1;
    public va6.b N2;
    public String O;
    public boolean O0;
    public GetSugMatchWordsModel.b O1;
    public final a38.b O2;
    public LikeModel P;
    public String P0;
    public boolean P1;
    public int P2;
    public View Q;
    public boolean Q0;
    public PraiseModel Q1;
    public int Q2;
    public View R;
    public cs8 R0;
    public q58.h R1;
    public String R2;
    public View S;
    public q85 S0;
    public CustomMessageListener S1;
    public qs4 S2;
    public View T;
    public o85 T0;
    public nc5 T1;
    public String U;
    public boolean U0;
    public nc5 U1;
    public int V;
    public PermissionJudgePolicy V0;
    public CheckRealNameModel.b V1;
    public boolean W;
    public ReplyPrivacyCheckController W0;
    public j18 W1;
    public int[] X;
    public vt6 X0;
    public final Runnable X1;
    public int Y;
    public vt6 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public m85 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public l85 a1;
    public CustomMessageListener a2;
    public boolean b;
    public gu4 b0;
    public l85 b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public int c1;
    public CustomMessageListener c2;
    public wa6 d;
    public ny4 d0;
    public Object d1;
    public CustomMessageListener d2;
    public q58 e;
    public boolean e0;
    public r9 e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public wy4 f1;
    public CustomMessageListener f2;
    public boolean g;
    public Object g0;
    public BdUniqueId g1;
    public lv4.e g2;
    public boolean h;
    public bs8 h0;
    public Runnable h1;
    public h3 h2;
    public boolean i;
    public n45 i0;
    public q48 i1;
    public wv4.e i2;
    public VoiceManager j;
    public boolean j0;
    public in j1;
    public SortSwitchButton.f j2;
    public int k;
    public String k1;
    public final View.OnClickListener k2;
    public nv4 l;
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
    public qb p2;
    public long q;
    public boolean q0;
    public List<f3> q1;
    public final PbModel.h q2;
    public boolean r;
    @NonNull
    public TiePlusEventController.f r0;
    public int r1;
    public CustomMessageListener r2;
    public boolean s;
    public d68 s0;
    public String s1;
    public HttpMessageListener s2;
    public lf5 t;
    public PushPermissionController t0;
    public f46 t1;
    public final jp4.a t2;
    public long u;
    public PbInterviewStatusView.f u0;
    public final f3 u1;
    public final AbsListView.OnScrollListener u2;
    public boolean v;
    public final Handler v0;
    public final r38.b v1;
    public final q9 v2;
    public long w;
    public PbModel w0;
    public final CustomMessageListener w1;
    public final i3 w2;
    public int x;
    public o68 x0;
    public CustomMessageListener x1;
    public final az4.g x2;
    public String y;
    public jp4 y0;
    public CustomMessageListener y1;
    public final View.OnClickListener y2;
    public og<TextView> z;
    public ForumManageModel z0;
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
    @Override // com.baidu.tieba.s78
    /* renamed from: J5 */
    public VideoPbFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public void S(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i b1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public void d1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, context, str) == null) {
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

    @Override // com.baidu.tieba.s78
    public PbFragment r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class k1 implements vt6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        @Override // com.baidu.tieba.vt6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.vt6.d
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
            public class C0403a implements TextWatcher {
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

                public C0403a(a aVar) {
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
                    o48 o48Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (o48Var = this.a.a.c.I0) != null && o48Var.g() != null) {
                        if (!this.a.a.c.I0.g().e()) {
                            this.a.a.c.I0.b(false);
                        }
                        this.a.a.c.I0.g().l(false);
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
                    int i3 = (pbFragment.X[1] + pbFragment.Y) - i2;
                    if (pbFragment.E0 != null && this.a.c.E0.T0() != null) {
                        this.a.c.E0.T0().smoothScrollBy(i3, 50);
                    }
                    if (this.a.c.F5().d1() != null) {
                        this.a.c.T0.b().setVisibility(8);
                        z = (this.a.c.w0 == null || this.a.c.w0.l1() == null || this.a.c.w0.l1().Q() == null || !this.a.c.w0.l1().Q().isBjh()) ? false : false;
                        e38 d1 = this.a.c.F5().d1();
                        k1 k1Var = this.a;
                        d1.t(k1Var.a, k1Var.b, k1Var.c.F5().f1(), z);
                        s85 f = this.a.c.F5().d1().f();
                        if (f != null && this.a.c.w0 != null && this.a.c.w0.l1() != null) {
                            f.H(this.a.c.w0.l1().d());
                            f.d0(this.a.c.w0.l1().Q());
                        }
                        if (this.a.c.I0.f() == null && this.a.c.F5().d1().f().u() != null) {
                            this.a.c.F5().d1().f().u().g(new C0403a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.I0.n(pbFragment2.F5().d1().f().u().i());
                            this.a.c.F5().d1().f().N(this.a.c.b1);
                        }
                    }
                    this.a.c.F5().p1();
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

        @Override // com.baidu.tieba.vt6.d
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
                o48 o48Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (o48Var = this.a.c.I0) != null && o48Var.g() != null) {
                    if (!this.a.c.I0.g().e()) {
                        this.a.c.I0.b(false);
                    }
                    this.a.c.I0.g().l(false);
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
                int i3 = (pbFragment.X[1] + pbFragment.Y) - i2;
                if (pbFragment.E0 != null && this.c.E0.T0() != null) {
                    this.c.E0.T0().smoothScrollBy(i3, 50);
                }
                if (this.c.F5().d1() != null) {
                    this.c.T0.b().setVisibility(8);
                    this.c.F5().d1().t(this.a, this.b, this.c.F5().f1(), (this.c.w0 == null || this.c.w0.l1() == null || this.c.w0.l1().Q() == null || !this.c.w0.l1().Q().isBjh()) ? false : false);
                    s85 f = this.c.F5().d1().f();
                    if (f != null && this.c.w0 != null && this.c.w0.l1() != null) {
                        f.H(this.c.w0.l1().d());
                        f.d0(this.c.w0.l1().Q());
                    }
                    if (this.c.I0.f() == null && this.c.F5().d1().f().u() != null) {
                        this.c.F5().d1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.I0.n(pbFragment2.F5().d1().f().u().i());
                        this.c.F5().d1().f().N(this.c.b1);
                    }
                }
                this.c.F5().p1();
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
                    m18.a(this.b.a.getPageContext(), this.a).show();
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

        /* JADX WARN: Code restructure failed: missing block: B:786:0x1ebf, code lost:
            if (r9 == (r32.a.E0.e1().c().getHeight() - r32.a.E0.e1().e())) goto L832;
         */
        /* JADX WARN: Code restructure failed: missing block: B:824:0x2041, code lost:
            if (r32.a.E0.d1.c.getView().getTop() <= ((r32.a.E0.e1() == null || r32.a.E0.e1().c() == null) ? 0 : r32.a.E0.e1().c().getBottom())) goto L761;
         */
        /* JADX WARN: Code restructure failed: missing block: B:825:0x2043, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:827:0x2050, code lost:
            if (r0 >= com.baidu.tieba.h58.d(r32.a.z5())) goto L761;
         */
        /* JADX WARN: Code restructure failed: missing block: B:849:0x20f7, code lost:
            if ((r32.a.E0.d1.c.getView().getTop() - r32.a.E0.h.a.getBottom()) < (r32.a.E0.d1.c.g.getHeight() + 10)) goto L761;
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
            h08 l1;
            int i;
            int i2;
            PostData Z;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            sv4 sv4Var;
            sv4 sv4Var2;
            sv4 sv4Var3;
            PbFragment pbFragment;
            int i3;
            boolean z;
            sv4 sv4Var4;
            sv4 sv4Var5;
            sv4 sv4Var6;
            sv4 sv4Var7;
            String name;
            int i4;
            boolean z2;
            int fixedNavHeight;
            int i5;
            int i6;
            bv4 bv4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.q0 && (view2 == this.a.E0.h.c || view2 == this.a.E0.h.d || view2.getId() == R.id.obfuscated_res_0x7f091903 || view2.getId() == R.id.obfuscated_res_0x7f090a48 || view2.getId() == R.id.obfuscated_res_0x7f091cb5 || view2.getId() == R.id.obfuscated_res_0x7f09189e)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.E0.W0() && this.a.getPageContext().getPageActivity() != null && this.a.w0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.F1(), this.a.w0.V1(), this.a.w0.U1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.w0.getForumId());
                        statisticItem2.param("fname", this.a.w0.K0());
                        statisticItem2.param("tid", this.a.w0.F1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.E0.Y0()) {
                        if (this.a.h) {
                            return;
                        }
                        if (this.a.w0.g2(true)) {
                            this.a.h = true;
                            this.a.E0.t3();
                        }
                    } else if (view2 == this.a.E0.h.m()) {
                        String string = StringUtils.string(view2.getTag(R.id.forum_name));
                        String string2 = StringUtils.string(view2.getTag(R.id.forum_id));
                        String string3 = StringUtils.string(view2.getTag(R.id.thread_id));
                        if (this.a.P != null) {
                            this.a.P.X(string, string2);
                        }
                        TbPageTag l = ue5.l(this.a.getContext());
                        i68.a("c14278", string2, string3, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    } else if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().r()) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.E0.p0();
                        this.a.i7();
                        this.a.E0.s3();
                        this.a.E0.N3();
                        if (this.a.E0.b1() != null) {
                            this.a.E0.b1().setVisibility(8);
                        }
                        this.a.w0.Z2(1);
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().k()) {
                        if (view2 == this.a.E0.h.f) {
                            if (this.a.E0.f0(this.a.w0.Y0())) {
                                this.a.i7();
                                return;
                            }
                            this.a.i = false;
                            yi.z(this.a.a, this.a.E0.h.f);
                            this.a.a.finish();
                        } else if (view2 == this.a.E0.F0() || (this.a.E0.h.n() != null && (view2 == this.a.E0.h.n().s() || view2 == this.a.E0.h.n().t()))) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            } else if (this.a.w0.l1() == null || this.a.z0.Z()) {
                                return;
                            } else {
                                this.a.E0.p0();
                                int i9 = (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().t()) ? (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().s()) ? view2 == this.a.E0.F0() ? 2 : 0 : this.a.w0.l1().Q().getIs_good() == 1 ? 3 : 6 : this.a.w0.l1().Q().getIs_top() == 1 ? 5 : 4;
                                ForumData l2 = this.a.w0.l1().l();
                                String name3 = l2.getName();
                                String id = l2.getId();
                                String id2 = this.a.w0.l1().Q().getId();
                                this.a.E0.h4();
                                this.a.z0.d0(id, name3, id2, i9, this.a.E0.G0());
                            }
                        } else if (view2 == this.a.E0.M0()) {
                            if (this.a.w0 != null) {
                                sp4.o(this.a.getPageContext().getPageActivity(), this.a.w0.l1().Q().getTopicData().b());
                            }
                        } else if (view2 == this.a.E0.h.c) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            if (this.a.w0.l1() != null && this.a.w0.l1().Q() != null && this.a.w0.l1().Q().isVideoThreadType() && this.a.w0.l1().Q().getThreadVideoInfo() != null) {
                                TiebaStatic.log(new StatisticItem("c11922"));
                            }
                            if (this.a.w0.getErrorNo() == 4) {
                                if (!StringUtils.isNull(this.a.w0.K0()) || this.a.w0.A0() == null) {
                                    this.a.a.finish();
                                    return;
                                }
                                name2 = this.a.w0.A0().b;
                            } else {
                                name2 = this.a.w0.l1().l().getName();
                            }
                            if (StringUtils.isNull(name2)) {
                                this.a.a.finish();
                                return;
                            }
                            String K0 = this.a.w0.K0();
                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                            if (!this.a.w0.Q0() || K0 == null || !K0.equals(name2)) {
                                this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                            } else {
                                this.a.a.finish();
                            }
                        } else if (view2 == this.a.E0.h.d) {
                            if (hj5.a()) {
                                return;
                            }
                            if (this.a.w0 == null || this.a.w0.l1() == null) {
                                yi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                                return;
                            }
                            ArrayList<PostData> H = this.a.w0.l1().H();
                            if ((H == null || H.size() <= 0) && this.a.w0.D1()) {
                                yi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.w0.F1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.w0.getForumId()));
                            if (!this.a.E0.R1()) {
                                this.a.E0.N2();
                            }
                            this.a.r6();
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918c2) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.E0.c3(true);
                            this.a.E0.N2();
                            if (this.a.h) {
                                return;
                            }
                            this.a.h = true;
                            this.a.E0.X3();
                            this.a.i7();
                            this.a.E0.s3();
                            this.a.w0.d3(this.a.s5());
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091899) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.E0.p0();
                            if (view2.getId() != R.id.obfuscated_res_0x7f091899 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                if (!j48.c(this.a.getPageContext(), 11009) || this.a.w0.B0(this.a.E0.S0()) == null) {
                                    return;
                                }
                                this.a.j6();
                                if (this.a.w0.l1() != null && this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", this.a.w0.l1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getAuthor() != null && this.a.w0.l1().Q().getAuthor().getUserId() != null && this.a.y0 != null) {
                                    int w = j48.w(this.a.w0.l1());
                                    ThreadData Q = this.a.w0.l1().Q();
                                    if (Q.isBJHArticleThreadType()) {
                                        i8 = 2;
                                    } else if (Q.isBJHVideoThreadType()) {
                                        i8 = 3;
                                    } else if (Q.isBJHNormalThreadType()) {
                                        i8 = 4;
                                    } else {
                                        i8 = Q.isBJHVideoDynamicThreadType() ? 5 : 1;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w0.b).param("obj_locate", 1).param("obj_id", this.a.w0.l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.y0.e()).param("obj_source", w).param("obj_param1", i8));
                                }
                            } else {
                                this.a.T = view2;
                                return;
                            }
                        } else if ((this.a.E0.h.n() != null && view2 == this.a.E0.h.n().p()) || view2.getId() == R.id.obfuscated_res_0x7f090a48 || view2.getId() == R.id.obfuscated_res_0x7f091cb5) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.E0.p0();
                            if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().p() && !this.a.E0.R1()) {
                                this.a.E0.N2();
                            }
                            if (this.a.h) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.i7();
                            this.a.E0.s3();
                            boolean e3 = view2.getId() == R.id.obfuscated_res_0x7f090a48 ? this.a.w0.e3(true, this.a.s5()) : view2.getId() == R.id.obfuscated_res_0x7f091cb5 ? this.a.w0.e3(false, this.a.s5()) : this.a.w0.d3(this.a.s5());
                            view2.setTag(Boolean.valueOf(e3));
                            if (e3) {
                                i7 = 1;
                                this.a.E0.c3(true);
                                this.a.E0.X3();
                                this.a.h = true;
                                this.a.E0.g3(true);
                            } else {
                                i7 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                        } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().l()) {
                            if (view2.getId() == R.id.share_num_container) {
                                if (!j48.c(this.a.getPageContext(), 11009)) {
                                    return;
                                }
                                j48.x(this.a.getContext(), 3, this.a.o5(), this.a.w0);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f09189e || view2.getId() == R.id.share_more_container) {
                                if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (l1 = this.a.w0.l1()) == null) {
                                    return;
                                }
                                ThreadData Q2 = l1.Q();
                                if (Q2 != null && Q2.getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", l1.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                    statisticItem3.param("tid", this.a.w0.F1());
                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem3.param("fid", this.a.w0.getForumId());
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
                                    if (this.a.R() != null) {
                                        ue5.e(this.a.R(), statisticItem3);
                                    }
                                    if (this.a.E0 != null) {
                                        statisticItem3.param("obj_param1", this.a.E0.P0());
                                    }
                                    TiebaStatic.log(statisticItem3);
                                    if (yi.F()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cb8);
                                        return;
                                    } else if (l1 == null) {
                                        yi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                                        return;
                                    } else {
                                        ArrayList<PostData> H2 = this.a.w0.l1().H();
                                        if ((H2 == null || H2.size() <= 0) && this.a.w0.D1()) {
                                            yi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                                            return;
                                        }
                                        this.a.E0.p0();
                                        this.a.i7();
                                        if (l1.B() != null && !StringUtils.isNull(l1.B().a(), true)) {
                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.w0.l1().m()));
                                        }
                                        TiebaStatic.log(new StatisticItem("c11939"));
                                        if (AntiHelper.e(this.a.getContext(), Q2)) {
                                            return;
                                        }
                                        if (this.a.E0 != null) {
                                            this.a.E0.r0();
                                            this.a.E0.o4(l1);
                                        }
                                        if (ShareSwitch.isOn()) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09189e) {
                                                i2 = 2;
                                            } else {
                                                i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                            }
                                            if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.E0.T1() && !l1.q0()) {
                                                if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                    if (i45.c() > 0) {
                                                        j48.G(this.a.getContext(), this.a.w0.l1());
                                                    } else {
                                                        int P0 = this.a.E0.P0();
                                                        this.a.E0.e0();
                                                        this.a.T5(i45.a(), P0);
                                                    }
                                                } else {
                                                    this.a.c7(i2);
                                                }
                                            } else {
                                                this.a.c7(i2);
                                            }
                                        } else {
                                            this.a.E0.N3();
                                            this.a.w0.F0().I(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                        }
                                    }
                                }
                                i = 1;
                                StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem32.param("tid", this.a.w0.F1());
                                statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem32.param("fid", this.a.w0.getForumId());
                                if (view2.getId() != R.id.share_num_container) {
                                }
                                statisticItem32.param("obj_name", i);
                                statisticItem32.param("obj_type", 1);
                                if (Q2 != null) {
                                }
                                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                }
                                if (this.a.R() != null) {
                                }
                                if (this.a.E0 != null) {
                                }
                                TiebaStatic.log(statisticItem32);
                                if (yi.F()) {
                                }
                            } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().q()) {
                                if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().x()) {
                                    if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().w()) {
                                        if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().u()) {
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
                                            this.a.E0.h.l();
                                        } else if (this.a.E0.Q0() == view2) {
                                            if (!this.a.E0.Q0().getIndicateStatus()) {
                                                qs8.d("c10725", null);
                                            } else {
                                                h08 l12 = this.a.w0.l1();
                                                if (l12 != null && l12.Q() != null && l12.Q().getTaskInfoData() != null) {
                                                    String d = l12.Q().getTaskInfoData().d();
                                                    if (StringUtils.isNull(d)) {
                                                        d = l12.Q().getTaskInfoData().g();
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                }
                                            }
                                            this.a.L5();
                                        } else if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().n()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            this.a.E0.p0();
                                            SparseArray<Object> U0 = this.a.E0.U0(this.a.w0.l1(), this.a.w0.D1(), 1);
                                            if (U0 == null) {
                                                return;
                                            }
                                            this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.l1().l().getId(), this.a.w0.l1().l().getName(), this.a.w0.l1().Q().getId(), StringUtils.string(this.a.w0.l1().X().getUserId()), StringUtils.string(U0.get(R.id.tag_forbid_user_name)), StringUtils.string(U0.get(R.id.tag_forbid_user_name_show)), StringUtils.string(U0.get(R.id.tag_forbid_user_post_id)), StringUtils.string(U0.get(R.id.tag_forbid_user_portrait)))));
                                        } else if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().g()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> U02 = this.a.E0.U0(this.a.w0.l1(), this.a.w0.D1(), 1);
                                            if (U02 != null) {
                                                this.a.E0.t2(((Integer) U02.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(U02.get(R.id.tag_del_post_id)), ((Integer) U02.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) U02.get(R.id.tag_del_post_is_self)).booleanValue());
                                            }
                                            this.a.E0.h.k();
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
                                        } else if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().m()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> U03 = this.a.E0.U0(this.a.w0.l1(), this.a.w0.D1(), 1);
                                            if (U03 != null) {
                                                if (StringUtils.isNull((String) U03.get(R.id.tag_del_multi_forum))) {
                                                    this.a.E0.q2(((Integer) U03.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(U03.get(R.id.tag_del_post_id)), ((Integer) U03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) U03.get(R.id.tag_del_post_is_self)).booleanValue());
                                                } else {
                                                    this.a.E0.r2(((Integer) U03.get(R.id.tag_del_post_type)).intValue(), (String) U03.get(R.id.tag_del_post_id), ((Integer) U03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) U03.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(U03.get(R.id.tag_del_multi_forum)));
                                                }
                                            }
                                            this.a.E0.h.k();
                                        } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092063 && view2.getId() != R.id.obfuscated_res_0x7f0918b2 && view2.getId() != R.id.obfuscated_res_0x7f09173b) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091916) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091914 && view2.getId() != R.id.obfuscated_res_0x7f091af8 && view2.getId() != R.id.obfuscated_res_0x7f0918ac) {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918b0) {
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
                                                        if (this.a.K0 == null) {
                                                            PbFragment pbFragment2 = this.a;
                                                            pbFragment2.K0 = new wv4(pbFragment2.getContext());
                                                            this.a.K0.n(this.a.i2);
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
                                                                sv4 sv4Var8 = new sv4(8, pbFragment.getString(i3), this.a.K0);
                                                                SparseArray sparseArray2 = new SparseArray();
                                                                sparseArray2.put(R.id.tag_clip_board, postData);
                                                                sv4Var8.d.setTag(sparseArray2);
                                                                arrayList.add(sv4Var8);
                                                            }
                                                            if (this.a.mIsLogin) {
                                                                if (!f68.j(this.a.w0) && !booleanValue3 && booleanValue2) {
                                                                    sv4 sv4Var9 = new sv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ba1), this.a.K0);
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
                                                                    sv4Var9.d.setTag(sparseArray3);
                                                                    arrayList.add(sv4Var9);
                                                                } else if ((j48.C(this.a.w0.l1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                                    sv4 sv4Var10 = new sv4(5, this.a.getString(R.string.report_text), this.a.K0);
                                                                    sv4Var10.d.setTag(str);
                                                                    arrayList.add(sv4Var10);
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
                                                                            sv4 sv4Var11 = new sv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.K0);
                                                                            sv4Var11.d.setTag(sparseArray4);
                                                                            sv4Var2 = sv4Var11;
                                                                            sv4Var = new sv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ee), this.a.K0);
                                                                            sv4Var.d.setTag(sparseArray4);
                                                                        }
                                                                    } else {
                                                                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                    }
                                                                    sv4Var2 = null;
                                                                    sv4Var = new sv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ee), this.a.K0);
                                                                    sv4Var.d.setTag(sparseArray4);
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
                                                                    if (this.a.w0.l1().Y() == 1002 && !booleanValue) {
                                                                        sv4Var3 = new sv4(6, this.a.getString(R.string.report_text), this.a.K0);
                                                                    } else {
                                                                        sv4Var3 = new sv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.K0);
                                                                    }
                                                                    sv4Var3.d.setTag(sparseArray5);
                                                                    sv4Var2 = sv4Var3;
                                                                    sv4Var = null;
                                                                } else {
                                                                    sv4Var = null;
                                                                    sv4Var2 = null;
                                                                }
                                                                if (sv4Var2 != null) {
                                                                    arrayList.add(sv4Var2);
                                                                }
                                                                if (sv4Var != null) {
                                                                    arrayList.add(sv4Var);
                                                                }
                                                            }
                                                            this.a.K0.j(arrayList);
                                                            this.a.J0 = new uv4(this.a.getPageContext(), this.a.K0);
                                                            this.a.J0.k();
                                                        }
                                                    } else if (view2 == this.a.E0.O0()) {
                                                        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                            this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, xg.g(this.a.w0.l1().m(), 0L), xg.g(this.a.w0.F1(), 0L), xg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.w0.l1().Q().getPushStatusData())));
                                                        }
                                                    } else if (view2 == this.a.E0.h.o()) {
                                                        this.a.E0.B3();
                                                    } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().v()) {
                                                        if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().o()) {
                                                            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                            if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.w0.F1())) != null) {
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                this.a.E0.h.k();
                                                                TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                            }
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0907b6 && view2.getId() != R.id.obfuscated_res_0x7f090a45) {
                                                            int id3 = view2.getId();
                                                            if (id3 == R.id.pb_u9_text_view) {
                                                                if (!this.a.checkUpIsLogin() || (bv4Var = (bv4) view2.getTag()) == null || StringUtils.isNull(bv4Var.m1())) {
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{bv4Var.m1()});
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091cb8 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    return;
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 != null && view2.getTag() != null) {
                                                                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                    PostData postData2 = (PostData) sparseArray6.get(R.id.tag_load_sub_data);
                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                        TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.w0.b));
                                                                    }
                                                                    if (this.a.K0 == null) {
                                                                        PbFragment pbFragment3 = this.a;
                                                                        pbFragment3.K0 = new wv4(pbFragment3.getContext());
                                                                        this.a.K0.n(this.a.i2);
                                                                    }
                                                                    ArrayList arrayList2 = new ArrayList();
                                                                    j48.y(view2);
                                                                    if (j48.y(view2) && this.a.j1 != null) {
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
                                                                        if (postData2.X() != null && postData2.X().toString().length() > 0) {
                                                                            sv4 sv4Var12 = new sv4(3, this.a.getString(R.string.obfuscated_res_0x7f0f0462), this.a.K0);
                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                            sparseArray7.put(R.id.tag_clip_board, postData2);
                                                                            sv4Var12.d.setTag(sparseArray7);
                                                                            arrayList2.add(sv4Var12);
                                                                        }
                                                                        this.a.E2 = postData2;
                                                                    }
                                                                    if (this.a.w0.l1().r()) {
                                                                        String v = this.a.w0.l1().v();
                                                                        if (postData2 != null && !xi.isEmpty(v) && v.equals(postData2.M())) {
                                                                            z = true;
                                                                            if (!z) {
                                                                                sv4Var4 = new sv4(4, this.a.getString(R.string.remove_mark), this.a.K0);
                                                                            } else {
                                                                                sv4Var4 = new sv4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0afc), this.a.K0);
                                                                            }
                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                            sparseArray8.put(R.id.tag_clip_board, this.a.E2);
                                                                            sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                            sv4Var4.d.setTag(sparseArray8);
                                                                            arrayList2.add(sv4Var4);
                                                                            if (this.a.mIsLogin) {
                                                                                if (!f68.j(this.a.w0) && !booleanValue9 && booleanValue8) {
                                                                                    sv4 sv4Var13 = new sv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ba1), this.a.K0);
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
                                                                                    sv4Var4.d.setTag(sparseArray9);
                                                                                    arrayList2.add(sv4Var13);
                                                                                } else if (j48.C(this.a.w0.l1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                    sv4 sv4Var14 = new sv4(5, this.a.getString(R.string.report_text), this.a.K0);
                                                                                    sv4Var14.d.setTag(str2);
                                                                                    arrayList2.add(sv4Var14);
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
                                                                                            sv4 sv4Var15 = new sv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.K0);
                                                                                            sv4Var15.d.setTag(sparseArray10);
                                                                                            sv4Var6 = sv4Var15;
                                                                                            sv4Var5 = new sv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ee), this.a.K0);
                                                                                            sv4Var5.d.setTag(sparseArray10);
                                                                                        }
                                                                                    } else {
                                                                                        sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                    }
                                                                                    sv4Var6 = null;
                                                                                    sv4Var5 = new sv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ee), this.a.K0);
                                                                                    sv4Var5.d.setTag(sparseArray10);
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
                                                                                    if (this.a.w0.l1().Y() == 1002 && !booleanValue7) {
                                                                                        sv4Var7 = new sv4(6, this.a.getString(R.string.report_text), this.a.K0);
                                                                                    } else {
                                                                                        sv4Var7 = new sv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.K0);
                                                                                    }
                                                                                    sv4Var7.d.setTag(sparseArray11);
                                                                                    sv4Var6 = sv4Var7;
                                                                                    sv4Var5 = null;
                                                                                } else {
                                                                                    sv4Var5 = null;
                                                                                    sv4Var6 = null;
                                                                                }
                                                                                if (sv4Var6 != null) {
                                                                                    arrayList2.add(sv4Var6);
                                                                                }
                                                                                if (sv4Var5 != null) {
                                                                                    arrayList2.add(sv4Var5);
                                                                                }
                                                                            }
                                                                            this.a.K0.j(arrayList2);
                                                                            this.a.J0 = new uv4(this.a.getPageContext(), this.a.K0);
                                                                            this.a.J0.k();
                                                                        }
                                                                    }
                                                                    z = false;
                                                                    if (!z) {
                                                                    }
                                                                    SparseArray sparseArray82 = new SparseArray();
                                                                    sparseArray82.put(R.id.tag_clip_board, this.a.E2);
                                                                    sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                    sv4Var4.d.setTag(sparseArray82);
                                                                    arrayList2.add(sv4Var4);
                                                                    if (this.a.mIsLogin) {
                                                                    }
                                                                    this.a.K0.j(arrayList2);
                                                                    this.a.J0 = new uv4(this.a.getPageContext(), this.a.K0);
                                                                    this.a.J0.k();
                                                                }
                                                            } else if (id3 == R.id.pb_act_btn) {
                                                                if (this.a.w0.l1() != null && this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getActUrl() != null) {
                                                                    sp4.o(this.a.getActivity(), this.a.w0.l1().Q().getActUrl());
                                                                    if (this.a.w0.l1().Q().getActInfoType() == 1) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    } else if (this.a.w0.l1().Q().getActInfoType() == 2) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.lottery_tail) {
                                                                if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                    String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                    TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.w0.l1().m()).param("tid", this.a.w0.l1().S()).param("lotterytail", StringUtils.string(string4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                    if (!this.a.w0.l1().S().equals(string4)) {
                                                                        this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string4, (String) null, (String) null, (String) null)));
                                                                    } else {
                                                                        this.a.E0.w3(0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0918de || id3 == R.id.obfuscated_res_0x7f0918a6) {
                                                                if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                    String string5 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                    String r = ry4.l().r("tail_link", "");
                                                                    String string6 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                    if (!StringUtils.isNull(r)) {
                                                                        TiebaStatic.log("c10056");
                                                                        sp4.s(view2.getContext(), string5, UtilHelper.urlAddParam(r, "page_from=1&tailSkinId=" + string6), true, true, true);
                                                                    }
                                                                    this.a.E0.N2();
                                                                    TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string6));
                                                                }
                                                            } else if (id3 == R.id.join_vote_tv) {
                                                                if (view2 != null) {
                                                                    sp4.o(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                    if (this.a.o5() == 1 && this.a.w0 != null && this.a.w0.l1() != null) {
                                                                        i78.u("c10397", this.a.w0.l1().m(), this.a.w0.l1().S(), currentAccount);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.look_all_tv) {
                                                                if (view2 != null) {
                                                                    String string7 = StringUtils.string(view2.getTag());
                                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                    sp4.o(this.a.getActivity(), string7);
                                                                    if (this.a.o5() == 1 && this.a.w0 != null && this.a.w0.l1() != null) {
                                                                        i78.u("c10507", this.a.w0.l1().m(), this.a.w0.l1().S(), currentAccount2);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09153f) {
                                                                this.a.f6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09153e) {
                                                                this.a.c6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0927af) {
                                                                if (this.a.w0 != null && this.a.w0.l1() != null && this.a.w0.l1().B() != null) {
                                                                    h08 l13 = this.a.w0.l1();
                                                                    TiebaStatic.log(new StatisticItem("c11679").param("fid", l13.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{l13.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0927ac) {
                                                                if (this.a.w0 != null && this.a.w0.l1() != null && this.a.w0.l1().B() != null) {
                                                                    h08 l14 = this.a.w0.l1();
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", l14.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{l14.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0924a0) {
                                                                if (this.a.o1 >= 0) {
                                                                    if (this.a.w0 != null) {
                                                                        this.a.w0.G2();
                                                                    }
                                                                    if (this.a.w0 == null || this.a.E0.D0() == null) {
                                                                        i6 = 0;
                                                                    } else {
                                                                        i6 = 0;
                                                                        this.a.E0.D0().h0(this.a.w0.l1(), false);
                                                                    }
                                                                    this.a.o1 = i6;
                                                                    if (this.a.w0 != null) {
                                                                        if (this.a.E0.T0() != null) {
                                                                            this.a.E0.T0().setSelection(this.a.w0.e1());
                                                                        }
                                                                        this.a.w0.K2(0, 0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.qq_share_container) {
                                                                if (!j48.c(this.a.getPageContext(), 11009)) {
                                                                    return;
                                                                }
                                                                j48.x(this.a.getContext(), 8, this.a.o5(), this.a.w0);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09173b) {
                                                                SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                if (sparseArray12 == null) {
                                                                    return;
                                                                }
                                                                this.a.g7(sparseArray12);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09189b) {
                                                                if (this.a.E0.T0() == null || this.a.w0 == null || this.a.w0.l1() == null) {
                                                                    return;
                                                                }
                                                                int firstVisiblePosition = this.a.E0.T0().getFirstVisiblePosition();
                                                                View childAt = this.a.E0.T0().getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                boolean y0 = this.a.w0.l1().y0();
                                                                boolean z5 = this.a.E0.e1() != null && this.a.E0.e1().g();
                                                                boolean P1 = this.a.E0.P1();
                                                                boolean z6 = firstVisiblePosition == 0 && top == 0;
                                                                if (!y0 || this.a.E0.e1() == null || this.a.E0.e1().c() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    int l3 = ((int) (yi.l(this.a.getContext()) * 0.5625d)) - this.a.E0.e1().e();
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
                                                                j48.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.w0.l1());
                                                                if ((this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getReply_num() <= 0) || (P1 && z6)) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    if (!this.a.checkUpIsLogin()) {
                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                        return;
                                                                    }
                                                                    this.a.v6();
                                                                    if (this.a.w0.l1().Q().getAuthor() != null) {
                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", this.a.w0.l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                    }
                                                                } else {
                                                                    int j = (int) (yi.j(this.a.getContext()) * 0.6d);
                                                                    if (y0) {
                                                                        if (this.a.E0.d1 != null && this.a.E0.d1.c != null && this.a.E0.d1.c.getView() != null) {
                                                                            if (this.a.E0.d1.c.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    } else {
                                                                        if (this.a.E0.b1() != null) {
                                                                            z2 = this.a.E0.b1().getVisibility() == 0;
                                                                            if (!z2 && this.a.E0.d1 != null && this.a.E0.d1.c != null && this.a.E0.d1.c.getView() != null && this.a.E0.d1.c.getView().getParent() != null && this.a.E0.h != null && this.a.E0.h.a != null) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                    }
                                                                    if (!z2 && !P1) {
                                                                        if (this.a.Z <= 0) {
                                                                            int d2 = h58.d(this.a.getListView());
                                                                            if (h58.e(this.a.getListView()) != -1) {
                                                                                d2--;
                                                                            }
                                                                            int g = yi.g(this.a.getContext(), R.dimen.tbds100);
                                                                            if (d2 < 0) {
                                                                                d2 = (ListUtils.getCount(this.a.E0.T0().getData()) - 1) + this.a.E0.T0().getHeaderViewsCount();
                                                                                g = 0;
                                                                            }
                                                                            if (z5) {
                                                                                fixedNavHeight = (int) (yi.l(this.a.getContext()) * 0.5625d);
                                                                            } else if (!y0 || this.a.E0.e1() == null) {
                                                                                if (this.a.E0.h != null && this.a.E0.h.a != null) {
                                                                                    fixedNavHeight = this.a.E0.h.a.getFixedNavHeight() - 10;
                                                                                }
                                                                                if (this.a.E0.d1 != null || this.a.E0.d1.c == null || this.a.E0.d1.c.getView() == null || this.a.E0.d1.c.getView().getParent() == null) {
                                                                                    this.a.E0.T0().setSelectionFromTop(d2, g + j);
                                                                                    this.a.E0.T0().smoothScrollBy(j, 500);
                                                                                } else if (z5) {
                                                                                    this.a.E0.T0().smoothScrollBy(this.a.E0.d1.c.getView().getTop() - ((int) (yi.l(this.a.getContext()) * 0.5625d)), 500);
                                                                                } else {
                                                                                    this.a.E0.T0().E(d2, g, 200);
                                                                                }
                                                                            } else {
                                                                                fixedNavHeight = this.a.E0.e1().d();
                                                                            }
                                                                            g += fixedNavHeight;
                                                                            if (this.a.E0.d1 != null) {
                                                                            }
                                                                            this.a.E0.T0().setSelectionFromTop(d2, g + j);
                                                                            this.a.E0.T0().smoothScrollBy(j, 500);
                                                                        } else if (this.a.E0.T0().getChildAt(this.a.Z) != null) {
                                                                            this.a.E0.T0().E(this.a.Z, this.a.a0, 200);
                                                                        } else {
                                                                            this.a.E0.T0().setSelectionFromTop(this.a.Z, this.a.a0 + j);
                                                                            this.a.E0.T0().smoothScrollBy(j, 500);
                                                                        }
                                                                    } else {
                                                                        this.a.Z = firstVisiblePosition;
                                                                        this.a.a0 = top;
                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                            this.a.E0.T0().setSelectionFromTop(0, i11 - j);
                                                                            this.a.E0.T0().smoothScrollBy(-j, 500);
                                                                        } else {
                                                                            this.a.E0.T0().E(0, i11, 500);
                                                                        }
                                                                    }
                                                                }
                                                                if (this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", this.a.w0.l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091902 || id3 == R.id.obfuscated_res_0x7f091903) {
                                                                if (this.a.w0 == null || this.a.w0.l1() == null || this.a.w0.l1().l() == null || xi.isEmpty(this.a.w0.l1().l().getName())) {
                                                                    return;
                                                                }
                                                                if (this.a.w0.getErrorNo() == 4) {
                                                                    if (!StringUtils.isNull(this.a.w0.K0()) || this.a.w0.A0() == null) {
                                                                        this.a.a.finish();
                                                                        return;
                                                                    }
                                                                    name = this.a.w0.A0().b;
                                                                } else {
                                                                    name = this.a.w0.l1().l().getName();
                                                                }
                                                                if (StringUtils.isNull(name)) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                String K02 = this.a.w0.K0();
                                                                if (!this.a.w0.Q0() || K02 == null || !K02.equals(name)) {
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.w0.l1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                } else {
                                                                    this.a.a.finish();
                                                                }
                                                                StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                statisticItem6.param("tid", this.a.w0.F1());
                                                                statisticItem6.param("fid", this.a.w0.getForumId());
                                                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                if (this.a.w0.l1().Q() != null) {
                                                                    statisticItem6.param("nid", this.a.w0.l1().Q().getNid());
                                                                }
                                                                TiebaStatic.log(statisticItem6);
                                                            } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                                if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                    if (this.a.w0 == null) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                    statisticItem7.param("tid", this.a.w0.F1());
                                                                    statisticItem7.param("fid", this.a.w0.getForumId());
                                                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem7.param("obj_locate", 2);
                                                                    TiebaStatic.log(statisticItem7);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09192a) {
                                                                    if (this.a.w0 == null || this.a.w0.l1() == null) {
                                                                        return;
                                                                    }
                                                                    h08 l15 = this.a.w0.l1();
                                                                    if (this.a.B0 == null) {
                                                                        PbFragment pbFragment4 = this.a;
                                                                        pbFragment4.B0 = new z08(pbFragment4.getPageContext());
                                                                    }
                                                                    long g2 = xg.g(l15.S(), 0L);
                                                                    long g3 = xg.g(l15.m(), 0L);
                                                                    i78.w("c13446", g3);
                                                                    PbFragment pbFragment5 = this.a;
                                                                    pbFragment5.registerListener(pbFragment5.p2);
                                                                    this.a.B0.a(g2, g3);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09194f) {
                                                                    if (view2.getTag() instanceof SmartApp) {
                                                                        SmartApp smartApp = (SmartApp) view2.getTag();
                                                                        if (!ku5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                            if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                return;
                                                                            }
                                                                            sp4.o(this.a.getActivity(), smartApp.h5_url);
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.w0.F1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090ebf) {
                                                                    if (!(view2.getTag() instanceof ThreadData)) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090ebc) {
                                                                    if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.P != null) {
                                                                        this.a.P.X(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0918b4 || id3 == R.id.obfuscated_res_0x7f09190e) {
                                                                    if (this.a.q0) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.w0.F1());
                                                                    statisticItem8.param("fid", this.a.w0.getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                    if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                        i78.s(6);
                                                                    }
                                                                    PbFragment pbFragment6 = this.a;
                                                                    pbFragment6.b = false;
                                                                    pbFragment6.b5(view2);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0924be) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        i78.s(5);
                                                                    }
                                                                    this.a.J6(false);
                                                                    this.a.h7((PostData) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                }
                                                            } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                return;
                                                            } else {
                                                                ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                if (this.a.w0.k1() != 3 || !this.a.s0() || this.a.w0.l1() == null || !ListUtils.isEmpty(this.a.w0.l1().p())) {
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
                                                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907b7);
                                                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907b8);
                                                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a45);
                                                            if (postData3.t0()) {
                                                                postData3.T0(false);
                                                                g68.e(postData3);
                                                            } else if (this.a.M() != null ? g68.c(this.a.M().l1(), postData3) : false) {
                                                                postData3.T0(true);
                                                            }
                                                            SkinManager.setBackgroundColor(findViewById, postData3.t0() ? R.color.CAM_X0201 : R.color.transparent);
                                                            SkinManager.setViewTextColor(eMTextView, postData3.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                            WebPManager.setPureDrawable(imageView, postData3.t0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData3.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        }
                                                    } else {
                                                        this.a.E0.h.l();
                                                        this.a.E0.U3(this.a.H2);
                                                    }
                                                } else if (this.a.w0 == null) {
                                                    return;
                                                } else {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091914) {
                                                        StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                        statisticItem10.param("tid", this.a.w0.F1());
                                                        statisticItem10.param("fid", this.a.w0.getForumId());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("obj_locate", 6);
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091af8) {
                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                            this.a.S = view2;
                                                            return;
                                                        }
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091914 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.S = view2;
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
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091914 && (statisticItem = postData4.e0) != null) {
                                                        StatisticItem copy = statisticItem.copy();
                                                        copy.delete("obj_locate");
                                                        copy.param("obj_locate", 8);
                                                        TiebaStatic.log(copy);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091af8 || view2.getId() == R.id.obfuscated_res_0x7f0918ac) {
                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.w0.G1()).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.M()).param("obj_source", 1).param("obj_type", 3));
                                                    }
                                                    if (this.a.w0 == null || this.a.w0.l1() == null || this.a.F5().c1() == null || postData4.r() == null || postData4.D() == 1) {
                                                        return;
                                                    }
                                                    if (this.a.F5().d1() != null) {
                                                        this.a.F5().d1().g();
                                                    }
                                                    x08 x08Var = new x08();
                                                    x08Var.A(this.a.w0.l1().l());
                                                    x08Var.E(this.a.w0.l1().Q());
                                                    x08Var.C(postData4);
                                                    this.a.F5().c1().c0(x08Var);
                                                    this.a.F5().c1().setPostId(postData4.M());
                                                    this.a.g6(view2, postData4.r().getUserId(), "", postData4);
                                                    if (this.a.T0 != null) {
                                                        this.a.E0.V2(this.a.T0.y());
                                                    }
                                                }
                                            } else if (this.a.w0 == null) {
                                                return;
                                            } else {
                                                StatisticItem statisticItem11 = new StatisticItem("c13398");
                                                statisticItem11.param("tid", this.a.w0.F1());
                                                statisticItem11.param("fid", this.a.w0.getForumId());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("obj_locate", 5);
                                                TiebaStatic.log(statisticItem11);
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091916 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
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
                                                    if (this.a.w0 == null || this.a.w0.l1() == null) {
                                                        return;
                                                    }
                                                    String F1 = this.a.w0.F1();
                                                    String M = postData5.M();
                                                    int Y = this.a.w0.l1() != null ? this.a.w0.l1().Y() : 0;
                                                    AbsPbActivity.e w6 = this.a.w6(M);
                                                    if (w6 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F1, M, "pb", true, false, null, false, null, Y, postData5.e0(), this.a.w0.l1().d(), false, postData5.r().getIconInfo(), 5).addBigImageData(w6.a, w6.b, w6.g, w6.j);
                                                    addBigImageData.setKeyPageStartFrom(this.a.w0.k1());
                                                    addBigImageData.setFromFrsForumId(this.a.w0.getFromForumId());
                                                    addBigImageData.setWorksInfoData(this.a.w0.K1());
                                                    addBigImageData.setKeyFromForumId(this.a.w0.getForumId());
                                                    addBigImageData.setTiebaPlusData(this.a.w0.P(), this.a.w0.L(), this.a.w0.M(), this.a.w0.K(), this.a.w0.Q());
                                                    addBigImageData.setBjhData(this.a.w0.D0());
                                                    if (this.a.w0.l1().o() != null) {
                                                        addBigImageData.setHasForumRule(this.a.w0.l1().o().has_forum_rule.intValue());
                                                    }
                                                    if (this.a.w0.l1().X() != null) {
                                                        addBigImageData.setIsManager(this.a.w0.l1().X().getIs_manager());
                                                    }
                                                    if (this.a.w0.l1().l().getDeletedReasonInfo() != null) {
                                                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.w0.l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.w0.l1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                    }
                                                    if (this.a.w0.l1().l() != null) {
                                                        addBigImageData.setForumHeadUrl(this.a.w0.l1().l().getImage_url());
                                                        addBigImageData.setUserLevel(this.a.w0.l1().l().getUser_level());
                                                    }
                                                    if (this.a.E0 != null && this.a.w0.G != null) {
                                                        addBigImageData.setMainPostMaskVisibly(this.a.w0.G.Z().S || postData5.S);
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                } else {
                                                    this.a.R = view2;
                                                    return;
                                                }
                                            }
                                        } else {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09173b) {
                                                StatisticItem statisticItem13 = new StatisticItem("c13398");
                                                statisticItem13.param("tid", this.a.w0.F1());
                                                statisticItem13.param("fid", this.a.w0.getForumId());
                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem13.param("obj_locate", 4);
                                                TiebaStatic.log(statisticItem13);
                                            }
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0918b2 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (!this.a.checkUpIsLogin()) {
                                                    i78.r("c10517", this.a.w0.l1().m(), 3);
                                                    return;
                                                } else if (this.a.w0 == null || this.a.w0.l1() == null) {
                                                    return;
                                                } else {
                                                    this.a.E0.p0();
                                                    SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                    PostData postData6 = (PostData) sparseArray17.get(R.id.tag_load_sub_data);
                                                    PostData postData7 = (PostData) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                    View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
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
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09173b) {
                                                            copy3.param("obj_locate", 6);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b2) {
                                                            copy3.param("obj_locate", 8);
                                                        }
                                                        TiebaStatic.log(copy3);
                                                    }
                                                    String F12 = this.a.w0.F1();
                                                    String M2 = postData6.M();
                                                    String M3 = postData7 != null ? postData7.M() : "";
                                                    int Y2 = this.a.w0.l1() != null ? this.a.w0.l1().Y() : 0;
                                                    this.a.i7();
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091cb8) {
                                                        TiebaStatic.log("c11742");
                                                        AbsPbActivity.e w62 = this.a.w6(M2);
                                                        if (postData6 == null || this.a.w0 == null || this.a.w0.l1() == null || w62 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F12, M2, "pb", true, false, null, false, M3, Y2, postData6.e0(), this.a.w0.l1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(w62.a, w62.b, w62.g, w62.j);
                                                        if (!xi.isEmpty(M3)) {
                                                            addBigImageData2.setHighLightPostId(M3);
                                                            addBigImageData2.setKeyIsUseSpid(true);
                                                        }
                                                        addBigImageData2.setKeyFromForumId(this.a.w0.getForumId());
                                                        addBigImageData2.setTiebaPlusData(this.a.w0.P(), this.a.w0.L(), this.a.w0.M(), this.a.w0.K(), this.a.w0.Q());
                                                        addBigImageData2.setBjhData(this.a.w0.D0());
                                                        addBigImageData2.setKeyPageStartFrom(this.a.w0.k1());
                                                        addBigImageData2.setFromFrsForumId(this.a.w0.getFromForumId());
                                                        addBigImageData2.setWorksInfoData(this.a.w0.K1());
                                                        if (this.a.E0 != null && this.a.w0.G != null && (Z = this.a.w0.G.Z()) != null) {
                                                            addBigImageData2.setMainPostMaskVisibly(Z.S || postData6.S);
                                                        }
                                                        if (this.a.w0.l1() != null && this.a.w0.l1().o() != null) {
                                                            addBigImageData2.setHasForumRule(this.a.w0.l1().o().has_forum_rule.intValue());
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    } else {
                                                        AbsPbActivity.e w63 = this.a.w6(M2);
                                                        if (this.a.w0 == null || this.a.w0.l1() == null || w63 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F12, M2, "pb", true, false, null, true, null, Y2, postData6.e0(), this.a.w0.l1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(w63.a, w63.b, w63.g, w63.j);
                                                        addBigImageData3.setKeyPageStartFrom(this.a.w0.k1());
                                                        addBigImageData3.setFromFrsForumId(this.a.w0.getFromForumId());
                                                        addBigImageData3.setWorksInfoData(this.a.w0.K1());
                                                        addBigImageData3.setKeyFromForumId(this.a.w0.getForumId());
                                                        addBigImageData3.setBjhData(this.a.w0.D0());
                                                        addBigImageData3.setTiebaPlusData(this.a.w0.P(), this.a.w0.L(), this.a.w0.M(), this.a.w0.K(), this.a.w0.Q());
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                    }
                                                }
                                            } else {
                                                this.a.R = view2;
                                                return;
                                            }
                                        }
                                    } else if (this.a.w0 == null || this.a.w0.l1() == null || this.a.w0.l1().Q() == null) {
                                        return;
                                    } else {
                                        this.a.E0.h.k();
                                        TiebaStatic.log(new StatisticItem("c13062"));
                                        PbFragment pbFragment7 = this.a;
                                        pbFragment7.P5(pbFragment7.w0.l1().Q().getFirstPostId());
                                    }
                                } else {
                                    this.a.E0.p0();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.h) {
                                        view2.setTag(Integer.valueOf(this.a.w0.B1()));
                                        return;
                                    } else {
                                        this.a.i7();
                                        this.a.E0.s3();
                                        uv4 uv4Var = new uv4(this.a.getPageContext());
                                        if (this.a.w0.l1().f == null || this.a.w0.l1().f.size() <= 0) {
                                            strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                        } else {
                                            strArr = new String[this.a.w0.l1().f.size()];
                                            for (int i12 = 0; i12 < this.a.w0.l1().f.size(); i12++) {
                                                strArr[i12] = this.a.w0.l1().f.get(i12).sort_name + this.a.getResources().getString(R.string.sort_static);
                                            }
                                        }
                                        uv4Var.i(null, strArr, new a(this, uv4Var, view2));
                                        uv4Var.k();
                                    }
                                }
                            } else {
                                this.a.E0.p0();
                                if (this.a.M().l1().g == 2) {
                                    this.a.showToast(R.string.hot_sort_jump_hint);
                                    return;
                                }
                                if (this.a.w0.j1() != null) {
                                    this.a.E0.b4(this.a.w0.j1(), this.a.g2);
                                }
                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            }
                        } else {
                            this.a.E0.h.k();
                        }
                    } else {
                        this.a.E0.h.l();
                        if (this.a.w0 != null) {
                            this.a.t1.f(this.a.w0.F1());
                        }
                        if (this.a.w0 != null && this.a.w0.isPrivacy()) {
                            this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (this.a.M() == null || this.a.M().l1() == null) {
                                return;
                            }
                            this.a.t1.d(3, 3, this.a.M().l1().S());
                            return;
                        }
                        this.a.t1.b();
                        int i13 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().S() == null || !this.a.M().l1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                        if (this.a.M() != null && this.a.M().l1() != null) {
                            this.a.t1.d(3, i13, this.a.M().l1().S());
                        }
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e4f).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091ca8) {
                        String r5 = this.a.r5();
                        if (TextUtils.isEmpty(r5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{r5});
                    }
                } else if (!this.a.q0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.w0.F1());
                    statisticItem15.param("fid", this.a.w0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                        i78.s(2);
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
                        if (this.a.w0 != null && this.a.w0.l1() != null && this.a.F5().c1() != null && postData8.r() != null && postData8.D() != 1) {
                            if (!this.a.checkUpIsLogin()) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                return;
                            }
                            if (this.a.F5().d1() != null) {
                                this.a.F5().d1().g();
                            }
                            x08 x08Var2 = new x08();
                            x08Var2.A(this.a.w0.l1().l());
                            x08Var2.E(this.a.w0.l1().Q());
                            x08Var2.C(postData8);
                            this.a.F5().c1().c0(x08Var2);
                            this.a.F5().c1().setPostId(postData8.M());
                            this.a.g6(view2, postData8.r().getUserId(), "", postData8);
                            TiebaStatic.log("c11743");
                            i78.b(this.a.w0.l1(), postData8, postData8.d0, 8, 1);
                            if (this.a.T0 != null) {
                                this.a.E0.V2(this.a.T0.y());
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
        public class a implements wv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ uv4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ l1 c;

            public a(l1 l1Var, uv4 uv4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, uv4Var, view2};
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
                this.a = uv4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.w0.C1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.wv4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void n0(wv4 wv4Var, int i, View view2) {
                boolean f3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.w0.C1() != 1 || i != 1) {
                        if (this.c.a.w0.C1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.w0.C1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091925) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.w0.l1().f != null && this.c.a.w0.l1().f.size() > i) {
                            i = this.c.a.w0.l1().f.get(i).sort_type.intValue();
                        }
                        f3 = this.c.a.w0.f3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.w0.B1()));
                        if (f3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.E0.g3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091925) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.w0.l1().f != null) {
                        i = this.c.a.w0.l1().f.get(i).sort_type.intValue();
                    }
                    f3 = this.c.a.w0.f3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.w0.B1()));
                    if (f3) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.E0 != null && this.a != null) {
                    this.b.a.E0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w0.l1() != null) {
                        statisticItem.param("fid", this.a.w0.l1().m());
                    }
                    statisticItem.param("tid", this.a.w0.F1());
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
                this.a.i7();
                this.a.E0.q3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.C0 != null) {
                    this.a.C0.k0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    ah.a().postDelayed(this.a.X1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.T0.x() || this.a.T0.z()) {
                            this.a.T0.w(false, postWriteCallBackData);
                        }
                        this.a.I0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.W0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        lv4 lv4Var = new lv4(this.a.getActivity());
                        if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                            lv4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            lv4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new b(this));
                        lv4Var.setPositiveButton(R.string.open_now, new c(this));
                        lv4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (oz8.d(i) || d35Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.Q6(i, antiData, str);
                        return;
                    }
                }
                this.a.b7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.R6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.E0.G1(this.a.w0.l1());
                    }
                } else if (this.a.w0.O0()) {
                    h08 l1 = this.a.w0.l1();
                    if (l1 != null && l1.Q() != null && l1.Q().getAuthor() != null && (userId = l1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.w0.c3()) {
                        this.a.E0.s3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.w0.c3()) {
                    this.a.E0.s3();
                }
                if (this.a.w0.S0()) {
                    i78.p("c10369", this.a.w0.F1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    ah.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.w0 != null) {
                    Context context = this.a.getContext();
                    h08 l12 = this.a.w0.l1();
                    String forumId = this.a.w0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    j48.a(context, l12, forumId, z2, this.a.w0.q1(), this.a.w0.t1(), this.a.w0.s1(), this.a.w0.r1(), this.a.w0.x1(), this.a.w0.y1());
                }
                if (writeData != null) {
                    m05.b(writeData.getContent(), "1");
                }
                if (this.a.Y5()) {
                    this.a.l7();
                }
                this.a.Z6();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.E0 != null && this.a != null) {
                    this.b.a.E0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w0 != null && this.a.w0.l1() != null) {
                        statisticItem.param("fid", this.a.w0.l1().m());
                    }
                    if (this.a.w0 != null) {
                        statisticItem.param("tid", this.a.w0.F1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.x5()) {
                        this.a.J6(false);
                        lz7.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f129d));
                    }
                    o48 o48Var = this.a.I0;
                    if (o48Var != null) {
                        o48Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        r45.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        m05.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        ah.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.Y5()) {
                        this.a.l7();
                    }
                    this.a.Z6();
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
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    lv4 lv4Var = new lv4(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        lv4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        lv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new b(this));
                    lv4Var.setPositiveButton(R.string.open_now, new c(this));
                    lv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.I0 != null) {
                        if (pbFragment.E0 != null && this.a.E0.d1() != null && this.a.E0.d1().f() != null && this.a.E0.d1().f().y()) {
                            this.a.E0.d1().f().w(postWriteCallBackData);
                        }
                        this.a.I0.l(postWriteCallBackData);
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
                iz4 iz4Var = new iz4();
                iz4Var.b = R.raw.lottie_bubble_breath_tip;
                iz4Var.a = BreatheTipWidget.PointType.LOTTIE;
                iz4Var.c = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                jz4 jz4Var = new jz4();
                jz4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f051a);
                jz4Var.b = this.a.a.getString(R.string.agree_tip_content);
                jz4Var.e = R.drawable.pic_guidecard;
                jz4Var.f = yi.g(this.a.a.getContext(), R.dimen.tbds156);
                jz4Var.g = yi.g(this.a.a.getContext(), R.dimen.tbds489);
                jz4Var.h = yi.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.E0.h1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.E0.h1()));
                breatheTipWidget.f(jz4Var, iz4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    ry4 l = ry4.l();
                    l.v("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    m45.a("c14828");
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
        public void b(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h08Var) == null) {
                this.a.E0.G1(h08Var);
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
            rf5 rf5Var = new rf5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            rf5Var.c();
            if (z2) {
                j3 = j4;
                rf5Var.B = j3;
                rf5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.w0 != null && this.a.w0.l1() != null && this.a.w0.l1().Q() != null) {
                int threadType = this.a.w0.l1().Q().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.L, "from_personalize")) {
                        nf5 nf5Var = new nf5();
                        nf5Var.F = 1;
                        nf5Var.a(1005);
                        nf5Var.D = j3;
                        nf5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.L, "from_frs")) {
                        rf5 rf5Var2 = new rf5();
                        rf5Var2.a(1000);
                        rf5Var2.D = j3;
                        rf5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, h08 h08Var, String str, int i4) {
            ArrayList<PostData> arrayList;
            int i5;
            t65 n;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), h08Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906fd));
                }
                if (z && h08Var != null && h08Var.a0() == null && ListUtils.getCount(h08Var.H()) < 1) {
                    this.a.w0.Z2(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.E0 != null) {
                        this.a.E0.Y3();
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
                if (this.a.E0 == null) {
                    return;
                }
                this.a.E0.r3();
                if (h08Var == null || !h08Var.t0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.E0.n1());
                }
                this.a.E0.v1();
                if (!this.a.I && !this.a.E0.R1()) {
                    if (!this.a.E0.L1()) {
                        this.a.E0.F3(false);
                    }
                } else {
                    this.a.E0.p1();
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && h08Var != null) {
                    this.a.M0 = true;
                }
                if (h08Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.E0.n1());
                    this.a.E0.A3();
                }
                String str2 = null;
                if (z && h08Var != null) {
                    ThreadData Q = h08Var.Q();
                    if (Q != null && Q.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.M6(pbFragment3.S0);
                    }
                    this.a.E0.d1().r(h08Var);
                    this.a.E0.M3();
                    if (Q != null && Q.getCartoonThreadData() != null) {
                        this.a.p7(Q.getCartoonThreadData());
                    }
                    if (this.a.T0 != null) {
                        this.a.E0.V2(this.a.T0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(h08Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(h08Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(h08Var.X().getBimg_end_time());
                    if (h08Var.H() != null && h08Var.H().size() >= 1 && h08Var.H().get(0) != null) {
                        this.a.w0.L2(h08Var.H().get(0).M());
                    } else if (h08Var.a0() != null) {
                        this.a.w0.L2(h08Var.a0().M());
                    }
                    if (this.a.T0 != null) {
                        this.a.T0.H(h08Var.d());
                        this.a.T0.I(h08Var.l(), h08Var.X());
                        this.a.T0.k0(Q);
                        this.a.T0.J(this.a.w0.N0(), this.a.w0.F1(), this.a.w0.J0());
                        if (Q != null) {
                            this.a.T0.Z(Q.isMutiForumThread());
                        }
                    }
                    if (this.a.y0 != null) {
                        this.a.y0.h(h08Var.r());
                    }
                    if (h08Var.s() == 1) {
                        this.a.r = true;
                    } else {
                        this.a.r = false;
                    }
                    if (h08Var.l0()) {
                        this.a.r = true;
                    }
                    this.a.E0.W2(this.a.r);
                    if (this.a.s0.f.size() > 0) {
                        h08Var.S0(this.a.s0.f);
                    }
                    this.a.E0.Q3(h08Var, i2, i3, this.a.w0.D1(), i4, this.a.w0.U0());
                    this.a.E0.f4(h08Var, this.a.w0.D1());
                    this.a.E0.k4(this.a.w0.O0());
                    AntiData d = h08Var.d();
                    if (d != null) {
                        this.a.y = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.T0 != null && this.a.T0.b() != null && (n = this.a.T0.b().n(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) n).setOnClickListener(this.a.G1);
                        }
                    }
                    if (!this.a.W && !ListUtils.isEmpty(this.a.w0.l1().H()) && !this.a.w0.W1()) {
                        this.a.W = true;
                        this.a.U4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.P0)) {
                        h58.i(this.a.w0.k1(), this.a.getListView(), this.a.P0);
                        this.a.P0 = null;
                    } else if (!this.a.O0) {
                        if (!this.a.Q0) {
                            if (!TextUtils.isEmpty(this.a.w0.b1())) {
                                h58.f(this.a.getListView(), this.a.w0.b1());
                                this.a.w0.e2();
                            } else {
                                this.a.E0.L3();
                            }
                        } else {
                            this.a.Q0 = false;
                            h58.j(this.a.getListView());
                        }
                    } else {
                        this.a.O0 = false;
                        h58.g(this.a.getListView());
                    }
                    this.a.w0.f2(h08Var.l(), this.a.M1);
                    this.a.w0.l2(this.a.O1);
                    if (this.a.W0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.W0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.w0 != null && this.a.w0.T1()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.E0 != null) {
                        str2 = this.a.E0.f1();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.T0.c0(TbSingleton.getInstance().getAdVertiComment(h08Var.r0(), h08Var.s0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.M0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.w0.A0() != null && !StringUtils.isNull(this.a.w0.A0().c)) {
                                    this.a.E0.m4(this.a.w0.A0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.E0.n1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    dn8.a("pb", false);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.E0.n1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                dn8.a("pb", false);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                            }
                            this.a.E0.p1();
                            this.a.E0.o1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.w0.F1());
                            jSONObject.put("fid", this.a.w0.getForumId());
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
                        if (this.a.w0 != null && this.a.w0.l1() != null) {
                            arrayList = this.a.w0.l1().H();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                            this.a.E0.R2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.a6()) {
                                this.a.E0.S2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e5f));
                            } else {
                                this.a.E0.S2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e60));
                            }
                            this.a.E0.G1(this.a.w0.l1());
                        }
                    } else {
                        this.a.E0.R2("");
                    }
                    this.a.E0.x0();
                }
                if (h08Var != null && h08Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (!this.a.M().D1() || this.a.M().l1().z().c() != 0 || this.a.M().Q1()) {
                    this.a.U0 = true;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (h08Var != null) {
                        i5 = h08Var.g();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.C1(i5, this.a.E0);
                }
                int m = ry4.l().m(ry4.p("key_reaction_guide_show_number_pb"), 0);
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
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.w0 == null) {
                return;
            }
            if (this.a.T0 != null && this.a.T0.t) {
                return;
            }
            n85 n85Var = new n85();
            this.a.M6(n85Var);
            PbFragment pbFragment = this.a;
            pbFragment.T0 = (o85) n85Var.a(pbFragment.getContext());
            this.a.T0.W(this.a.a.getPageContext());
            this.a.T0.f0(this.a.m2);
            this.a.T0.g0(this.a.Z0);
            o85 o85Var = this.a.T0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            o85Var.A(pageContext, extras);
            this.a.T0.b().D(true);
            this.a.E0.Q2(this.a.T0.b());
            if (!this.a.w0.Y0()) {
                this.a.T0.q(this.a.w0.F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.T0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.w0.T1()) {
                this.a.T0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.E0 != null) {
                this.a.T0.c0(this.a.E0.f1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ry4 l = ry4.l();
                if (!l.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    ah.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements va6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.va6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.va6.b
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

        @Override // com.baidu.tieba.va6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.E0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.w5()) {
                    this.b.E0.u1();
                    this.b.E0.P2();
                }
            }
        }

        @Override // com.baidu.tieba.va6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.E0 != null && this.b.e != null) {
                this.b.E0.V3();
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
            this.a.e5();
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
        public void onNavigationButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lv4Var) == null) {
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
    public static class b implements wa6.b {
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

        @Override // com.baidu.tieba.wa6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    i18.d();
                } else {
                    i18.c();
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
        public void a(l58 l58Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l58Var) != null) || l58Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, l58Var.c()));
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
        public void onNavigationButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lv4Var) == null) {
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
                switch (this.a.z0.getLoadDataMode()) {
                    case 0:
                        this.a.w0.O1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.k5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.E0.z0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.l5(pbFragment.z0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.E0.z0(this.a.z0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.E0.p2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.E0.z0(this.a.z0.getLoadDataMode(), false, null, false);
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
                if (!this.a.f && z && !this.a.w0.a1()) {
                    this.a.C6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(yi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a38.b {
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

        @Override // com.baidu.tieba.a38.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1569);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cb8);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.E0.n0(str);
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
                        this.a.s6();
                        return;
                    } else {
                        this.a.E6();
                        return;
                    }
                }
                this.a.j0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.a.R5();
                vt4 j1 = this.a.w0.j1();
                int a1 = this.a.E0.a1();
                if (a1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e62);
                } else if (j1 != null && a1 > j1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e62);
                } else {
                    this.a.E0.p0();
                    this.a.i7();
                    this.a.E0.s3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.w0.Z2(this.a.E0.a1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0cb8);
                    }
                    lv4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) && lv4Var != null) {
                lv4Var.dismiss();
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
    public class d implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    lv4Var.dismiss();
                    ((TbPageContext) this.a.e1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                lv4Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.E0 != null) {
                this.a.E0.x3(list);
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
                String valueOf = String.valueOf(this.a.w0.l1().X().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.l1().l().getId(), this.a.w0.l1().l().getName(), this.a.w0.l1().Q().getId(), valueOf, str, str3, str2, str4)));
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
    public class e implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
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
        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            this.a.P1 = false;
            if (this.a.Q1 == null) {
                return;
            }
            h08 l1 = this.a.w0.l1();
            if (l1.Q().getPraise().getIsLike() == 1) {
                this.a.q7(0);
            } else {
                this.a.q7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, l1.Q()));
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                if (this.a.J0 != null) {
                    this.a.J0.dismiss();
                }
                this.a.n7(i);
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
                                                    n95.a aVar = new n95.a();
                                                    aVar.a = this.a.k1;
                                                    String str = "";
                                                    if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.m1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.S4();
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
                                                    pbFragment.i1 = new q48(pbFragment.getPageContext());
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
                                                postData.F0();
                                                this.a.E2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.k6(view2);
                                            if (this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getAuthor() != null && this.a.w0.l1().Q().getAuthor().getUserId() != null && this.a.y0 != null) {
                                                int w = j48.w(this.a.w0.l1());
                                                ThreadData Q = this.a.w0.l1().Q();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w0.b).param("obj_locate", 2).param("obj_id", this.a.w0.l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.y0.e()).param("obj_source", w).param("obj_param1", i2));
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
                                                    this.a.W4(sparseArray2);
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
                                                boolean E = this.a.R().E(TbadkCoreApplication.getCurrentAccount());
                                                if (E) {
                                                    if (booleanValue2) {
                                                        this.a.E0.s2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, E);
                                                        return;
                                                    } else {
                                                        this.a.T6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.E0.q2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.T6(sparseArray3, intValue, booleanValue);
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
                                                    this.a.W4(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.E0.v2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.E0.q2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                            this.a.Z4(postData2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.w0 != null && this.a.w0.l1() != null) {
                                                this.a.a.u1(oz8.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.w0 != null && this.a.w0.l1() != null) {
                                    this.a.E0.r4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.y6(view3);
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
                            this.a.y6(view4);
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
                    this.a.y6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            if (((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue()) {
                                this.a.J6(true);
                            } else {
                                this.a.J6(false);
                            }
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.y6(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements az4.g {
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

        @Override // com.baidu.tieba.az4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.w5()) {
                    this.a.a.finish();
                }
                if (this.a.w0.k2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.E0.y0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements r38.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.r38.b
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

        @Override // com.baidu.tieba.r38.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.E0.g4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
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
                this.a.E0.c4(!this.a.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                if (lv4Var != null) {
                    lv4Var.dismiss();
                }
                this.d.h5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
                if (this.a.w5()) {
                    this.a.a.finish();
                }
                if (this.a.w0.k2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.E0.y0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.b.E0.N3();
                MessageManager.getInstance().sendMessage(this.a);
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements q58.h {
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

        @Override // com.baidu.tieba.q58.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.L6(z);
                if (this.a.E0.Q0() != null && z) {
                    this.a.E0.c4(false);
                }
                this.a.E0.h2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
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
                if (this.a.z2 && this.a.w5()) {
                    this.a.c6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.e0 && this.a.E0 != null && this.a.E0.g0() && this.a.w0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.w0.F1());
                    statisticItem.param("fid", this.a.w0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.w0.Q0()) {
                        i = 4;
                    } else if (this.a.w0.R0()) {
                        i = 3;
                    } else if (this.a.w0.T0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.e0 = true;
                }
                if (this.a.w0.g2(false)) {
                    this.a.E0.t3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if ((this.a.s0 == null || !this.a.w0.a2() || !this.a.s0.d()) && this.a.w0.l1() != null) {
                    this.a.E0.I2();
                }
                this.a.z2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<l48> a;
        public WeakReference<PbFragment> b;

        public g3(l48 l48Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(l48Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                l48 l48Var = this.a.get();
                if (l48Var != null) {
                    l48Var.t1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.c7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        az6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements wv4.e {
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

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                if (this.e.J0 != null) {
                    this.e.J0.dismiss();
                }
                if (i == 0) {
                    this.e.E0.q2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.g1);
                    this.e.e7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements vt6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.vt6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.vt6.d
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

        @Override // com.baidu.tieba.vt6.d
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
                    if (this.a.T0 != null && this.a.T0.b() != null) {
                        this.a.T0.b().B(new m65(45, 27, null));
                    }
                    this.a.E0.i0();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w0 != null) {
                this.a.w0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends ik5<ShareItem> {
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
        @Override // com.baidu.tieba.ik5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.N2(this.a);
                }
                return h68.d(this.b.o5(), 2, M);
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
                    if (this.a.p5().r() != null && this.a.p5().r().getGodUserData() != null) {
                        this.a.p5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.w0 != null && this.a.w0.l1() != null && this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getAuthor() != null) {
                        this.a.w0.l1().Q().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
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
                this.a.E0.p0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.w0 != null && !this.a.w0.isLoading) {
                    this.a.i7();
                    this.a.E0.s3();
                    z = true;
                    if (this.a.w0.l1() != null && this.a.w0.l1().f != null && this.a.w0.l1().f.size() > i) {
                        int intValue = this.a.w0.l1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.w0.G1()).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.w0.f3(intValue)) {
                            this.a.h = true;
                            this.a.E0.g3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements l85 {
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

        @Override // com.baidu.tieba.l85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                o48 o48Var = this.a.I0;
                if (o48Var != null && o48Var.g() != null && this.a.I0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.I0.g().c());
                    if (this.a.E0 != null && this.a.E0.d1() != null && this.a.E0.d1().f() != null && this.a.E0.d1().f().y()) {
                        this.a.E0.d1().f().w(this.a.I0.h());
                    }
                    this.a.I0.b(true);
                    return true;
                } else if (!this.a.Y4(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements mj5<ShareItem> {
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
        @Override // com.baidu.tieba.mj5
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
    public class j0 extends nc5<TipEvent> {
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
        @Override // com.baidu.tieba.gc5
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.w0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.T0 != null) {
                    this.a.E0.V2(this.a.T0.y());
                }
                this.a.E0.N2();
                this.a.E0.p0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends nc5<TopToastEvent> {
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
        @Override // com.baidu.tieba.gc5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.E0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.E0.n1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ lv4 c;
        public final /* synthetic */ PbFragment d;

        public k2(PbFragment pbFragment, MarkData markData, MarkData markData2, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, lv4Var};
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
            this.c = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
                if (this.d.y0 != null) {
                    if (this.d.y0.e()) {
                        this.d.y0.d();
                        this.d.y0.h(false);
                    }
                    this.d.y0.i(this.a);
                    this.d.y0.h(true);
                    this.d.y0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.j7();
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
            this.a.w0.h3((UserPendantData) customResponsedMessage.getData());
            if (this.a.E0 != null && this.a.w0 != null) {
                this.a.E0.G2(this.a.w0.l1(), this.a.w0.D1(), this.a.w0.v1(), this.a.E0.j1());
            }
            if (this.a.E0 != null && this.a.E0.D0() != null) {
                this.a.E0.D0().Z();
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
            l48 l48Var = this.b.E0;
            l48Var.v3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ lv4 b;
        public final /* synthetic */ PbFragment c;

        public l2(PbFragment pbFragment, MarkData markData, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, lv4Var};
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
            this.b = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.j7();
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
                if (this.a.E0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.E0.X3();
                } else {
                    this.a.E0.v1();
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
                    this.a.T0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.E0 != null && this.a.E0.d1() != null && this.a.E0.d1().f() != null) {
                    this.a.E0.d1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements m85 {
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

        @Override // com.baidu.tieba.m85
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
        public final /* synthetic */ lv4 b;
        public final /* synthetic */ PbFragment c;

        public m2(PbFragment pbFragment, MarkData markData, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, lv4Var};
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
            this.b = lv4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.E0 != null && this.c.E0.n1() != null) {
                    this.c.E0.n1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.j7();
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
            if (this.a.T0 != null) {
                this.a.E0.V2(this.a.T0.y());
            }
            this.a.E0.F3(false);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.w0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.w0.b)) {
                return;
            }
            this.a.b7((PostWriteCallBackData) customResponsedMessage.getData());
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
                    if (dr4.c().g()) {
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
                boolean g = dr4.c().g();
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
                nz7 nz7Var = (nz7) customResponsedMessage.getData();
                int type = nz7Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (nz7Var.a() == null) {
                                this.a.A6(false, null);
                                return;
                            } else {
                                this.a.A6(true, (MarkData) nz7Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.k5((ForumManageModel.b) nz7Var.a(), false);
                    return;
                }
                this.a.B6((x08) nz7Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements jz7.d {
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

        @Override // com.baidu.tieba.jz7.d
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
                if (dr4.c().g()) {
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
                boolean g = dr4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E0 != null && this.a.E0.D0() != null) {
                this.a.E0.D0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements j18.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.j18.a
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

        @Override // com.baidu.tieba.j18.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091cd6) {
                        if (this.a.F6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090156) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof PostData)) {
                                return false;
                            }
                            PostData postData = (PostData) obj;
                            if (postData.getType() != PostData.Q0 && !TextUtils.isEmpty(postData.t()) && dr4.c().g()) {
                                return this.a.m6(postData);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b1) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.g7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.E0.M1() && view2.getId() == R.id.obfuscated_res_0x7f0918d0) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.A0() != null && this.a.A0().b != null) {
                                this.a.A0().b.onClick(view2);
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
                        this.a.g7(sparseArray);
                    }
                }
                if (this.a.T0 != null) {
                    this.a.E0.V2(this.a.T0.y());
                }
                this.a.E0.N2();
                this.a.E0.p0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.j18.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.i5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof tn5.a)) {
                tn5.a aVar = (tn5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.M5(aVar.b);
                }
                tn5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.w0 != null && this.a.w0.W0()) {
                    this.a.h6();
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
                        yi.P(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.E0 != null && (l1 = this.a.E0.l1()) != null && this.a.E0.T0() != null) {
                            this.a.E0.T0().removeHeaderView(l1);
                            return;
                        }
                        return;
                    }
                    yi.Q(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
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
                playVoiceBntNew.setVoiceManager(this.a.r0());
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
            this.a.f7();
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements nv4.c {
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

        @Override // com.baidu.tieba.nv4.c
        public void a(nv4 nv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nv4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.L0 = pbFragment.L0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new n28(this.a.w0.F1(), this.a.L0, "1").start();
                    nv4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.L0 = pbFragment2.L0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new n28(this.a.w0.F1(), this.a.L0, "2").start();
                    nv4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.L0 = pbFragment3.L0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.L0);
                    nv4Var.e();
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
            this.a.o7();
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.y0 == null || this.a.y0.e()) {
                    return;
                }
                this.a.j6();
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
                this.a.E0.t1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                h08 l1 = this.a.w0.l1();
                if (l1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    l1.w().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.d7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (xi.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.f1.c(errorString2);
                } else {
                    this.a.W6();
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
                if (this.a.E0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.E0.n1());
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
                    this.a.N6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
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
                if (this.a.E0 != null && this.a.E0.d1() != null) {
                    e38 d1 = this.a.E0.d1();
                    if (d1.j()) {
                        d1.h();
                        return true;
                    }
                }
                if (this.a.E0 != null && this.a.E0.U1()) {
                    this.a.E0.x1();
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
                this.a.E0.t1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (xi.isEmpty(muteMessage)) {
                    muteMessage = this.a.e1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.f1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements jp4.a {
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

        @Override // com.baidu.tieba.jp4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.E0.r3();
                if (z) {
                    if (this.a.y0 != null) {
                        this.a.y0.h(z2);
                    }
                    this.a.w0.b3(z2);
                    if (!this.a.w0.W0()) {
                        this.a.E0.G1(this.a.w0.l1());
                    } else {
                        this.a.h6();
                    }
                    if (z2) {
                        boolean q0 = this.a.w0.l1().q0();
                        if (this.a.y0 != null && !q0) {
                            if (this.a.y0.f() != null && this.a.w0 != null && this.a.w0.l1() != null && this.a.w0.l1().Q() != null && this.a.w0.l1().Q().getAuthor() != null) {
                                MarkData f = this.a.y0.f();
                                MetaData author = this.a.w0.l1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d6);
                                        this.a.a7();
                                    } else {
                                        this.a.V6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.R4();
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
            s28 D0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.E0.e2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.w0.F1());
                    statisticItem.param("fid", this.a.w0.getForumId());
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
                    this.a.u6(str, i, eVar);
                    if (this.a.w0.G.l0()) {
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
                        builder.I(this.a.w0.w1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.a6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.w0 != null) {
                            builder.D(this.a.w0.getFromForumId());
                            if (this.a.w0.l1() != null) {
                                builder.Q(this.a.w0.l1().Q());
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
                        builder2.I(this.a.w0.w1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.a6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.w0 != null) {
                            builder2.D(this.a.w0.getFromForumId());
                            if (this.a.w0.l1() != null) {
                                builder2.Q(this.a.w0.l1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText r7 = this.a.r7(str, i);
                        if (r7 != null && this.a.B2 >= 0 && this.a.B2 < r7.I().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = i08.a(r7.I().get(this.a.B2));
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
                            if (r7.getPostId() != 0 && (D0 = this.a.E0.D0()) != null) {
                                ArrayList<xn> t = D0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<xn> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        xn next = it.next();
                                        if ((next instanceof PostData) && r7.getPostId() == xg.g(((PostData) next).M(), 0L)) {
                                            int i8 = 8;
                                            if (r7.getPostId() == xg.g(this.a.w0.J0(), 0L)) {
                                                i8 = 1;
                                            }
                                            i78.b(this.a.w0.l1(), (PostData) next, ((PostData) next).d0, i8, 3);
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
                            builder3.I(this.a.w0.w1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.a6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.w0 != null) {
                                builder3.D(this.a.w0.getFromForumId());
                                if (this.a.w0.l1() != null) {
                                    builder3.Q(this.a.w0.l1().Q());
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
                if (!this.a.Y5() || this.a.a == null || this.a.a.j1() == null || !str.equals(this.a.a.j1().getTopicId())) {
                    return;
                }
                this.a.m7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements nv4.c {
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

        @Override // com.baidu.tieba.nv4.c
        public void a(nv4 nv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nv4Var, i, view2) == null) {
                if (nv4Var != null) {
                    nv4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.E2;
                if (postData != null) {
                    if (i == 0) {
                        postData.F0();
                        this.a.E2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.l6(pbFragment2.E2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ft4)) {
                ft4 ft4Var = (ft4) customResponsedMessage.getData();
                xt4.a aVar = new xt4.a();
                int i = ft4Var.a;
                String str = ft4Var.b;
                aVar.a = ft4Var.d;
                h08 l1 = this.a.w0.l1();
                if (l1 == null) {
                    return;
                }
                if (this.a.w0.N0() != null && this.a.w0.N0().getUserIdLong() == ft4Var.p) {
                    this.a.E0.F2(ft4Var.l, this.a.w0.l1(), this.a.w0.D1(), this.a.w0.v1());
                }
                if (l1.H() != null && l1.H().size() >= 1 && l1.H().get(0) != null) {
                    long g = xg.g(l1.H().get(0).M(), 0L);
                    long g2 = xg.g(this.a.w0.F1(), 0L);
                    if (g == ft4Var.n && g2 == ft4Var.m) {
                        xt4 K = l1.H().get(0).K();
                        if (K == null) {
                            K = new xt4();
                        }
                        ArrayList<xt4.a> a = K.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        K.e(K.b() + ft4Var.l);
                        K.d(a);
                        l1.H().get(0).K0(K);
                        this.a.E0.D0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rz8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                rz8 rz8Var = (rz8) customResponsedMessage.getData();
                this.a.E0.t1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = rz8Var.a;
                boolean z = false;
                if (rz8Var.c == 0 && dataRes != null) {
                    int e = xg.e(dataRes.is_mute, 0);
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
                        this.a.E0.u2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.X6(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                lv4Var.dismiss();
                this.b.A0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.w0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements nv4.c {
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

        @Override // com.baidu.tieba.nv4.c
        public void a(nv4 nv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nv4Var, i, view2) == null) {
                if (nv4Var != null) {
                    nv4Var.e();
                }
                if (this.a.j1 != null && !TextUtils.isEmpty(this.a.k1)) {
                    if (i == 0) {
                        if (this.a.m1 != null) {
                            n95.a aVar = new n95.a();
                            aVar.a = this.a.k1;
                            String str = "";
                            if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.m1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.S4();
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
                            pbFragment.i1 = new q48(pbFragment.getPageContext());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cp5)) {
                cp5 cp5Var = (cp5) customResponsedMessage.getData();
                h08 l1 = this.a.w0.l1();
                if (l1 == null) {
                    return;
                }
                if (this.a.w0.l1() != null && this.a.w0.l1().Z().r() != null && this.a.w0.l1().Z().r().getPortrait() != null && this.a.w0.l1().Z().r().getPortrait().equals(cp5Var.a)) {
                    if (this.a.w0.l1().Z().r().getUserWorldCupData() != null) {
                        this.a.w0.l1().Z().r().getUserWorldCupData().d(cp5Var.b);
                    }
                    this.a.E0.G2(this.a.w0.l1(), this.a.w0.D1(), this.a.w0.v1(), this.a.E0.j1());
                }
                if (l1.H() != null && l1.H().size() >= 0) {
                    Iterator<PostData> it = l1.H().iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(cp5Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(cp5Var.b);
                        }
                    }
                    this.a.E0.D0().Z();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.E0.I1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.i5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements l85 {
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

        @Override // com.baidu.tieba.l85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                o48 o48Var = this.a.I0;
                if (o48Var != null && o48Var.e() != null && this.a.I0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.I0.e().c());
                    if (this.a.T0 != null && (this.a.T0.x() || this.a.T0.z())) {
                        this.a.T0.w(false, this.a.I0.h());
                    }
                    this.a.I0.a(true);
                    return true;
                } else if (this.a.Y4(ReplyPrivacyCheckController.TYPE_THREAD)) {
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.w0 == null || this.a.w0.u1() == i + 1) {
                return;
            }
            this.a.I6(j48.q(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.w0 != null && this.a.w0.l1() != null) {
                this.a.w0.l1().a();
                this.a.w0.O1();
                if (this.a.E0.D0() != null) {
                    this.a.E0.G1(this.a.w0.l1());
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
            bs8 bs8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bs8) && (bs8Var = (bs8) customResponsedMessage.getData()) != null && (agreeData = bs8Var.b) != null) {
                if (this.a.E0 != null) {
                    this.a.E0.a2(bs8Var);
                }
                if (agreeData.agreeType == 2 && this.a.E0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !h68.k(this.a.w0.b)) {
                    this.a.E0.a4();
                    h68.b(this.a.w0.b);
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
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.w0 != null && this.a.w0.l1() != null && this.a.E0 != null && this.a.E0.D0() != null) {
                this.a.E0.n2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.w0.X1() && (H = this.a.w0.l1().H()) != null && !H.isEmpty()) {
                    int w = ((i + i2) - this.a.E0.D0().w()) - 1;
                    h08 l1 = this.a.w0.l1();
                    if (l1 == null) {
                        return;
                    }
                    if (l1.E() != null && l1.E().m1()) {
                        w--;
                    }
                    if (l1.F() != null && l1.F().m1()) {
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
                if (!j48.B(this.a.c1) && j48.B(i)) {
                    if (this.a.E0 != null) {
                        this.a.j0 = true;
                        this.a.E0.p0();
                        if (this.a.T0 != null && !this.a.E0.I1()) {
                            this.a.E0.V2(this.a.T0.y());
                        }
                        if (!this.a.I) {
                            this.a.j0 = true;
                            this.a.E0.N2();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.E0 != null) {
                    this.a.E0.o2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new lf5();
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
                this.a.c1 = i;
                if (i == 0) {
                    nq8.g().h(this.a.getUniqueId(), true);
                    this.a.U4(true);
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
                return pbFragment.b5(view2);
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
            ks8 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.w0 != null && this.a.w0.l1() != null) {
                String str = (String) customResponsedMessage.getData();
                ks8 ks8Var = null;
                if (!TextUtils.isEmpty(str) && this.a.w0.l1().H() != null) {
                    ArrayList<PostData> H = this.a.w0.l1().H();
                    Iterator<PostData> it = H.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (next instanceof ks8) {
                            ks8 ks8Var2 = (ks8) next;
                            if (str.equals(ks8Var2.n1())) {
                                ks8Var = ks8Var2;
                                break;
                            }
                        }
                    }
                    if (ks8Var != null) {
                        H.remove(ks8Var);
                    }
                }
                if (this.a.E0.D0() != null && !ListUtils.isEmpty(this.a.E0.D0().t())) {
                    ArrayList<xn> t = this.a.E0.D0().t();
                    if (ks8Var != null) {
                        i = ks8Var;
                    } else {
                        i = j48.i(this.a.w0.l1(), str);
                    }
                    j48.e(t, i);
                }
                if (this.a.E0.T0() != null && !ListUtils.isEmpty(this.a.E0.T0().getData())) {
                    List<xn> data = this.a.E0.T0().getData();
                    if (ks8Var == null) {
                        ks8Var = j48.i(this.a.w0.l1(), str);
                    }
                    j48.e(data, ks8Var);
                }
                this.a.d5(str);
                this.a.w0.O1();
                if (this.a.E0.D0() != null) {
                    this.a.E0.D0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F5() != null) {
                this.a.F5().k2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<f55> {
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
        public int compare(f55 f55Var, f55 f55Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f55Var, f55Var2)) == null) {
                return f55Var.compareTo(f55Var2);
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
        T2 = new b1();
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        U2 = new b();
    }

    public final void G6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (pbModel = this.w0) != null && pbModel.l1() != null && this.w0.l1().Q() != null && this.w0.l1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void H6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (pbModel = this.w0) != null && pbModel.l1() != null && this.w0.l1().Q() != null && this.w0.l1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void R5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            yi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean U6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || !pbModel.D1()) {
                return false;
            }
            if (this.w0.j1() != null && this.w0.j1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void a7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && o45.g(TbadkCoreApplication.getInst(), 0) && !this.E0.x2()) {
            this.i0 = o45.k(getPageContext(), "collect", 0L);
        }
    }

    public final void f7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && (pbModel = this.w0) != null && !xi.isEmpty(pbModel.F1())) {
            km4.w().P(jm4.Z, xg.g(this.w0.F1(), 0L));
        }
    }

    public final int o5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            if (this.w0.l1() != null && this.w0.l1().Q() != null) {
                return this.w0.l1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void o6() {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && (list = this.q1) != null && !list.isEmpty()) {
            int size = this.q1.size();
            while (true) {
                size--;
                if (size <= -1 || this.q1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.E0.p0();
            if (this.h) {
                return;
            }
            i7();
            this.E0.s3();
            if (this.w0.loadData()) {
                this.E0.X3();
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
        this.u0 = new f0(this);
        this.v0 = new Handler(new q0(this));
        this.w0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = false;
        this.G0 = false;
        this.H0 = false;
        this.M0 = false;
        this.O0 = false;
        this.Q0 = false;
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
        this.I1 = new x(this, 2921776);
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
        this.W1 = new j18(new p0(this));
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
        this.j2 = new i1(this);
        this.k2 = new l1(this);
        this.l2 = new n1(this, 2921480);
        this.m2 = new o1(this);
        this.n2 = Boolean.FALSE;
        this.o2 = new p1(this);
        this.p2 = new q1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.q2 = new r1(this);
        this.r2 = new s1(this, 2016450);
        this.s2 = new t1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.t2 = new u1(this);
        this.u2 = new y1(this);
        this.v2 = new b2(this);
        this.w2 = new d2(this);
        this.x2 = new e2(this);
        this.y2 = new f2(this);
        this.A2 = new g2(this);
        this.B2 = 0;
        this.C2 = new u2(this);
        this.D2 = false;
        this.E2 = null;
        this.F2 = new v2(this);
        this.G2 = new w2(this);
        this.H2 = new x2(this);
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

    public void D6(f3 f3Var) {
        List<f3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, f3Var) == null) && f3Var != null && (list = this.q1) != null) {
            list.remove(f3Var);
        }
    }

    public final void I6(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i4) == null) && this.w0 != null) {
            Y6();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.w0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void J6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z3) == null) {
            this.n2 = Boolean.valueOf(z3);
        }
    }

    public void K6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z3) == null) {
            this.q0 = z3;
        }
    }

    public void L6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z3) == null) {
            this.M = z3;
        }
    }

    public void O6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z3) == null) {
            this.J = z3;
        }
    }

    public void P4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, f3Var) == null) && f3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(f3Var)) {
                this.q1.add(f3Var);
            }
        }
    }

    public final void P6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z3) == null) {
            this.T0.X(z3);
            this.T0.a0(z3);
            this.T0.i0(z3);
        }
    }

    public void Q4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, f3Var) == null) && f3Var != null) {
            if (this.q1 == null) {
                this.q1 = new ArrayList();
            }
            if (!this.q1.contains(f3Var)) {
                this.q1.add(0, f3Var);
            }
        }
    }

    public final void Q5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, intent) == null) {
            h68.j(this, intent);
        }
    }

    public final void b6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void c7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i4) == null) {
            h68.o(this, o5(), i4);
        }
    }

    @Override // com.baidu.tieba.o88.b
    public void e1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z3) == null) {
            this.N0 = z3;
        }
    }

    public final void k6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            l6(postData);
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

    @Override // com.baidu.tieba.lv4.e
    public void onClick(lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, lv4Var) == null) {
            g5(lv4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.w9
    public void onPreLoad(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, boVar) == null) {
            PreLoadImageHelper.load(boVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(boVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.w0.H2(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.T0.F(bundle);
        }
    }

    public final void p7(qs4 qs4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048728, this, qs4Var) == null) && qs4Var != null) {
            this.S2 = qs4Var;
            this.c = true;
            this.E0.K2();
            this.E0.f3(this.R2);
        }
    }

    @Override // com.baidu.tieba.wn5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.wn5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, context, str) == null) {
            r48.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    public final void T5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i4, i5) == null) {
            mk5.b(new i(this, i5), new j(this, i5, i4));
        }
    }

    @Override // com.baidu.tieba.wn5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, context, str) == null) {
            this.v = true;
        }
    }

    public boolean p6(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        l48 l48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048727, this, i4, keyEvent)) == null) {
            if (keyEvent == null || (l48Var = this.E0) == null || !l48Var.f2(i4)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public final void S6(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            h68.l(this, j3, str, j4);
        }
    }

    public static PbFragment n6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65673, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public p58 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.A0();
        }
        return (p58) invokeV.objValue;
    }

    public int A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    public int B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wn5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            l48 l48Var = this.E0;
            if (l48Var == null) {
                return 0;
            }
            return l48Var.h1();
        }
        return invokeV.intValue;
    }

    public o85 C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.T0;
        }
        return (o85) invokeV.objValue;
    }

    public final void C6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideNetRefreshView(this.E0.n1());
            Y6();
            if (this.w0.m2()) {
                this.E0.s3();
            }
            this.E0.A3();
        }
    }

    public q58 D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (q58) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s78
    public PbModel.h E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public d68 E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.s0;
        }
        return (d68) invokeV.objValue;
    }

    public void E6() {
        n45 n45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (n45Var = this.i0) != null) {
            n45Var.x();
        }
    }

    public l48 F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.E0;
        }
        return (l48) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public og<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (og) invokeV.objValue;
    }

    public gu4 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b0;
        }
        return (gu4) invokeV.objValue;
    }

    public String I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    public String K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s78
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.w0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<RelativeLayout> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            og<RelativeLayout> ogVar = new og<>(new r2(this), 10, 0);
            this.F = ogVar;
            return ogVar;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<ImageView> P() {
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

    @Override // com.baidu.tieba.wn5
    public og<View> Q() {
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

    @Override // com.baidu.tieba.s78
    public AbsPbActivity R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void S5() {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (l48Var = this.E0) != null) {
            l48Var.r1();
            R5();
        }
    }

    @Override // com.baidu.tieba.wn5
    public og<TextView> V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.D(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (og) invokeV.objValue;
    }

    public final void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new n0(this));
        }
    }

    public boolean X5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                return pbModel.Q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.j1() != null && this.a.j1().k1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && o45.g(TbadkCoreApplication.getInst(), 0) && !this.E0.x2()) {
            this.i0 = o45.k(getPageContext(), "reply_pb", 0L);
        }
    }

    public boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                return pbModel.O0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<ItemCardView> h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (this.G == null) {
                this.G = new og<>(new s2(this), 10, 0);
            }
            return this.G;
        }
        return (og) invokeV.objValue;
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            h08 l12 = this.w0.l1();
            this.w0.b3(true);
            jp4 jp4Var = this.y0;
            if (jp4Var != null) {
                l12.L0(jp4Var.g());
            }
            this.E0.G1(l12);
        }
    }

    public void i6() {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048687, this) != null) || (l48Var = this.E0) == null) {
            return;
        }
        l48Var.X1();
    }

    public final void i7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048688, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void j7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.v1();
        }
    }

    public AntiData n5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null) {
                return this.w0.l1().d();
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
    public bo onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            C6();
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

    public PostData p5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            h08 h08Var = this.w0.G;
            if (h08Var != null) {
                return h08Var.Z();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public String q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final String r5() {
        InterceptResult invokeV;
        h08 l12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || (l12 = pbModel.l1()) == null) {
                return null;
            }
            return l12.V().c;
        }
        return (String) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.c2();
        }
        return invokeV.booleanValue;
    }

    public void s6() {
        n45 n45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (n45Var = this.i0) != null) {
            n45Var.q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && (pbModel = this.w0) != null && !xi.isEmpty(pbModel.F1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.wn5
    public og<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.K == null) {
                this.K = new og<>(new o2(this), 20, 0);
            }
            return this.K;
        }
        return (og) invokeV.objValue;
    }

    public PbInterviewStatusView.f v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.u0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<TiebaPlusRecommendCard> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            if (this.D == null) {
                this.D = new og<>(new p2(this), 5, 0);
            }
            return this.D;
        }
        return (og) invokeV.objValue;
    }

    public boolean w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            if (!this.c && this.P2 == -1 && this.Q2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.q0;
        }
        return invokeV.booleanValue;
    }

    public boolean x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            return this.n2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean x6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            n45 n45Var = this.i0;
            if (n45Var != null && n45Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.E == null) {
                this.E = new og<>(new c3(this), 15, 0);
            }
            return this.E;
        }
        return (og) invokeV.objValue;
    }

    public boolean y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wn5
    /* renamed from: z5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            l48 l48Var = this.E0;
            if (l48Var == null) {
                return null;
            }
            return l48Var.T0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void A6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z3, markData) == null) {
            this.E0.r3();
            this.w0.b3(z3);
            jp4 jp4Var = this.y0;
            if (jp4Var != null) {
                jp4Var.h(z3);
                if (markData != null) {
                    this.y0.i(markData);
                }
            }
            if (this.w0.W0()) {
                h6();
            } else {
                this.E0.G1(this.w0.l1());
            }
        }
    }

    public void B6(x08 x08Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, x08Var) != null) || x08Var.i() == null) {
            return;
        }
        String M = x08Var.i().M();
        ArrayList<PostData> H = this.w0.l1().H();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= H.size()) {
                break;
            }
            PostData postData = H.get(i4);
            if (postData.M() != null && postData.M().equals(M)) {
                ArrayList<PostData> k3 = x08Var.k();
                postData.a1(x08Var.m());
                if (postData.b0() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.j0() != null && next != null && next.r() != null && (metaData = postData.j0().get(next.r().getUserId())) != null) {
                            next.E0(metaData);
                            next.Q0(true);
                            next.j1(getPageContext(), this.w0.d2(metaData.getUserId()));
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
                if (postData.z() != null) {
                    postData.C0();
                }
            } else {
                i4++;
            }
        }
        if (!this.w0.U0() && z3) {
            this.E0.G1(this.w0.l1());
        }
        if (z3) {
            z6(x08Var);
        }
    }

    public void U4(boolean z3) {
        l48 l48Var;
        int i4;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z3) == null) && (l48Var = this.E0) != null && l48Var.T0() != null) {
            int firstVisiblePosition = this.E0.T0().getFirstVisiblePosition();
            int lastVisiblePosition = this.E0.T0().getLastVisiblePosition();
            s28 D0 = this.E0.D0();
            if (D0 != null && this.w0.l1() != null) {
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
                        if (this.E0.T0().G(i4) != null && (this.E0.T0().G(i4) instanceof PostData) && (postData = (PostData) this.E0.T0().G(i4)) != null) {
                            PostData postData2 = (PostData) ListUtils.getItem(this.w0.l1().H(), postData.D() - 1);
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
                    f55 f55Var = (f55) ListUtils.getItem(arrayList, 0);
                    if (f55Var != null && f55Var.e() == 1) {
                        if (!z3) {
                            this.E0.y2(f55Var, 0);
                            return;
                        }
                        return;
                    }
                    this.E0.y2(f55Var, 1);
                }
            }
        }
    }

    public final boolean m6(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, postData)) == null) {
            if (postData == null) {
                return false;
            }
            String M = postData.M();
            if (StringUtils.isNull(M) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String r3 = ry4.l().r("bubble_link", "");
            if (StringUtils.isNull(r3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = postData.g0().getJumpUrl();
            int packageId = postData.g0().getPackageId();
            int propsId = postData.g0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                sp4.o(getPageContext().getPageActivity(), ot8.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                sp4.s(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), r3 + "?props_id=" + M, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void q7(int i4) {
        PbModel pbModel;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048731, this, i4) != null) || (pbModel = this.w0) == null || pbModel.l1() == null || (Q = this.w0.l1().Q()) == null) {
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
        if (this.w0.D1()) {
            this.E0.D0().Z();
        } else {
            this.E0.s4(this.w0.l1());
        }
    }

    public final AbsPbActivity.e w6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048752, this, str)) == null) {
            String str2 = null;
            if (this.w0.l1() != null && this.w0.l1().H() != null && this.w0.l1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.w0.l1().H().size()) {
                        if (str.equals(this.w0.l1().H().get(i4).M())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                PostData postData = this.w0.l1().H().get(i4);
                if (postData.X() != null && postData.X().I() != null) {
                    Iterator<TbRichTextData> it = postData.X().I().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.M() != null) {
                                str2 = next.M().H();
                            }
                        }
                    }
                    u6(str2, 0, eVar);
                    i08.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final boolean F6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (postData.getType() != PostData.Q0 && !TextUtils.isEmpty(postData.t()) && dr4.c().g()) {
                return m6(postData);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null) {
                if (F5().d1() != null) {
                    F5().d1().g();
                }
                x08 x08Var = new x08();
                x08Var.A(this.w0.l1().l());
                x08Var.E(this.w0.l1().Q());
                x08Var.C(postData);
                F5().c1().c0(x08Var);
                F5().c1().setPostId(postData.M());
                g6(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                o85 o85Var = this.T0;
                if (o85Var != null) {
                    this.E0.V2(o85Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.C0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.C0 = pollingModel;
                pollingModel.s0(gw4.e);
            }
            this.C0.k0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            ah.a().postDelayed(this.X1, 10000L);
        }
    }

    public final void S4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.l1 != null) {
                n95.b bVar = new n95.b();
                bVar.a = this.l1.J();
                bVar.b = this.l1.H();
                bVar.c = String.valueOf(this.l1.K());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.k1));
        }
    }

    public final boolean V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.l1() == null) {
                return false;
            }
            ThreadData Q = this.w0.l1().Q();
            AntiData d4 = this.w0.l1().d();
            if (!AntiHelper.b(getPageContext(), Q) && !AntiHelper.d(getPageContext(), d4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void W6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            lv4 lv4Var = new lv4(getPageContext().getPageActivity());
            lv4Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            lv4Var.setPositiveButton(R.string.open_now, new d(this));
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new e(this));
            lv4Var.create(this.e1).show();
        }
    }

    public boolean X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if ((this.w0.l1() != null && (this.w0.l1().l0() || ThreadCardUtils.isSelf(this.w0.l1().Q()))) || this.W0 == null || this.w0.l1() == null || this.w0.l1().d() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeInvokeEditor(this.w0.l1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void Y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            showLoadingView(this.E0.n1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.E0.m1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final boolean Z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PostData c4 = i08.c(this.w0.l1(), this.w0.D1(), this.w0.v1());
            if (c4 != null && c4.r() != null && c4.r().getGodUserData() != null && c4.r().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            if (this.w0.Q0() || this.w0.T0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.w0.F1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.w0.F1()));
            if (k7()) {
                this.a.finish();
            }
        }
    }

    public final void c6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && this.S2 != null) {
            if (this.Q2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e5c);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.Q2, 0)));
                this.a.finish();
            }
        }
    }

    public final void f6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && this.S2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e5d);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.P2, 0)));
                this.a.finish();
            }
        }
    }

    public void j5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && this.E0 != null && (pbModel = this.w0) != null && pbModel.l1() != null && this.w0.l1().U() != null && checkUpIsLogin() && this.E0.D0() != null && this.E0.D0().z() != null) {
            this.E0.D0().z().v(this.w0.F1(), this.w0.getFromForumId());
        }
    }

    public final void l7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && (absPbActivity = this.a) != null && absPbActivity.j1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.j1().F1()).param("topic_id", this.a.j1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.j1().J1()));
        }
    }

    public final void o7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(this.w0.getForumId()) && this.w0.l1() != null && this.w0.l1().l() != null) {
            boolean z3 = true;
            if (this.w0.l1().l().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.w0.y0().K(this.w0.getForumId(), this.w0.F1());
            }
        }
    }

    public void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.w0.l1() != null && this.w0.l1().Q() != null && this.w0.l1().Q().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.w0.l1().Q().getTaskInfoData().i(), this.w0.l1().Q().getTaskInfoData().g(), this.w0.l1().Q().getTaskInfoData().b(), this.w0.l1().Q().getTaskInfoData().c(), this.w0.l1().Q().getIs_top(), this.w0.l1().Q().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null) {
                ks8 A = this.w0.l1().A();
                if (A != null) {
                    if (A.getAdvertAppInfo() != null) {
                        A.getAdvertAppInfo().h = null;
                    }
                    this.w0.l1().b();
                }
                if (this.w0.E0() != null) {
                    this.w0.q0();
                }
                this.w0.O1();
            }
            if (this.w0.l1().H() != null) {
                Iterator<PostData> it = this.w0.l1().H().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof ks8) {
                        it.remove();
                    }
                }
            }
            if (this.E0.D0() != null && !ListUtils.isEmpty(this.E0.D0().t())) {
                j48.d(this.E0.D0().t());
            }
            if (this.E0.T0() != null && !ListUtils.isEmpty(this.E0.T0().getData())) {
                j48.d(this.E0.T0().getData());
            }
            if (this.E0.D0() != null) {
                this.E0.D0().Z();
            }
        }
    }

    public final boolean k7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.l1() != null && this.w0.l1().l0()) {
                return true;
            }
            if (this.w0.W0()) {
                MarkData H0 = this.w0.H0();
                if (H0 != null && this.w0.U0()) {
                    MarkData B0 = this.w0.B0(this.E0.K0());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", H0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(H0.getPostId())) {
                        lv4 lv4Var = new lv4(getPageContext().getPageActivity());
                        lv4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026f));
                        lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0446, new k2(this, B0, H0, lv4Var));
                        lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new l2(this, H0, lv4Var));
                        lv4Var.setOnCalcelListener(new m2(this, H0, lv4Var));
                        lv4Var.create(getPageContext());
                        lv4Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", H0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.w0.l1() != null && this.w0.l1().H() != null && this.w0.l1().H().size() > 0 && this.w0.U0()) {
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
            if (this.N) {
                this.N = false;
                L5();
            }
            if (Z5()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            l48 l48Var = this.E0;
            if (l48Var != null && l48Var.n1() != null) {
                if (!this.g) {
                    Y6();
                } else {
                    hideLoadingView(this.E0.n1());
                }
                this.E0.l2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            l48 l48Var2 = this.E0;
            if (l48Var2 != null) {
                noNetworkView = l48Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.C1);
            this.N0 = false;
            H6();
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.b2);
            PushPermissionController pushPermissionController = this.t0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.n1) {
                C6();
                this.n1 = false;
            }
            f7();
            ItemCardHelper.w(this.K2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                f65.q().w(downloadData);
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
            if (F5().d1() != null) {
                F5().d1().n();
            }
            n68 n68Var = this.E0.h;
            if (n68Var != null && !n68Var.u()) {
                this.E0.h.y();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null && this.w0.l1().l() != null && this.w0.l1().Q() != null) {
                c65.j().x(getPageContext().getPageActivity(), "pb", this.w0.l1().l().getId(), xg.g(this.w0.l1().Q().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            nq8.g().h(getUniqueId(), false);
        }
    }

    public final String s5() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.l1() == null || this.w0.l1().H() == null || (count = ListUtils.getCount((H = this.w0.l1().H()))) == 0) {
                return "";
            }
            if (this.w0.w1()) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.D() == 1) {
                        return next.M();
                    }
                }
            }
            int K0 = this.E0.K0();
            PostData postData = (PostData) ListUtils.getItem(H, K0);
            if (postData != null && postData.r() != null) {
                if (this.w0.d2(postData.r().getUserId())) {
                    return postData.M();
                }
                for (int i4 = K0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i4);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (this.w0.d2(postData2.r().getUserId())) {
                        return postData2.M();
                    }
                }
                for (int i5 = K0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i5);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (this.w0.d2(postData3.r().getUserId())) {
                        return postData3.M();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void M5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public void d6(String str) {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048668, this, str) == null) && this.w0 != null && !StringUtils.isNull(str) && (l48Var = this.E0) != null) {
            l48Var.a3(true);
            this.w0.i2(str);
            this.H = true;
            this.E0.p0();
            this.E0.p1();
        }
    }

    public final void d7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            if (str == null) {
                str = "";
            }
            r9 r9Var = this.e1;
            if (r9Var == null) {
                return;
            }
            lv4 lv4Var = new lv4(r9Var.getPageActivity());
            lv4Var.setMessage(str);
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a07, new f(this));
            lv4Var.create(this.e1).show();
        }
    }

    public final void g7(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048680, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        h7(postData, false);
    }

    public final void m5(Rect rect) {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048698, this, rect) == null) && rect != null && (l48Var = this.E0) != null && l48Var.m1() != null && rect.top <= this.E0.m1().getHeight()) {
            rect.top += this.E0.m1().getHeight() - rect.top;
        }
    }

    public final void n7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.w0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(f68.n(i4))));
        }
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
                this.I = true;
            } else {
                this.I = false;
            }
            l48 l48Var = this.E0;
            if (l48Var != null) {
                l48Var.c2(configuration);
            }
            uv4 uv4Var = this.J0;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z3) == null) {
            super.onUserChanged(z3);
            this.E0.l4(z3);
            uv4 uv4Var = this.J0;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
            if (z3 && this.N0) {
                this.E0.t3();
                this.w0.g2(true);
            }
            if (this.E0.D0() != null) {
                this.E0.D0().d0(z3);
            }
        }
    }

    public final void y6(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048758, this, view2) != null) || view2 == null) {
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

    public final void M6(q85 q85Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, q85Var) == null) && q85Var != null && (pbModel = this.w0) != null) {
            q85Var.p(pbModel.K0());
            if (this.w0.l1() != null && this.w0.l1().l() != null) {
                q85Var.o(this.w0.l1().l());
            }
            q85Var.q("pb");
            q85Var.r(this.w0);
        }
    }

    public final void N6(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048612, this, i4) != null) || (pbModel = this.w0) == null) {
            return;
        }
        int u12 = pbModel.u1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.w0.V2(1);
                } else {
                    this.w0.V2(4);
                }
            } else {
                this.w0.V2(3);
            }
        } else {
            this.w0.V2(2);
        }
        int u13 = this.w0.u1();
        if (u12 == 4 || u13 == 4) {
            q6();
        }
    }

    public final void U5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
            jp4 c4 = jp4.c(this.a);
            this.y0 = c4;
            if (c4 != null) {
                c4.j(this.t2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.z0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v2);
            this.A0 = new s35(getPageContext());
            G5();
            this.Q1.setUniqueId(getUniqueId());
            this.Q1.registerListener();
        }
    }

    public void W4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.E0.N3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = xg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = xg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.d1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean Y4(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i4)) == null) {
            if (this.W0 != null && this.w0.l1() != null && !ThreadCardUtils.isSelf(this.w0.l1().Q()) && this.w0.l1().d() != null) {
                return this.W0.checkPrivacyBeforeSend(this.w0.l1().d().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void e6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, bundle) == null) {
            PbModel j12 = this.a.j1();
            this.w0 = j12;
            if (j12 != null) {
                if (j12.G0() != null) {
                    this.w0.G0().c(this.O2);
                }
                if (this.w0.h1() != null) {
                    this.w0.h1().f(this.v1);
                }
                if (StringUtils.isNull(this.w0.F1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.L) && this.L != null) {
                    this.w0.S2(6);
                }
            }
        }
    }

    public final void m7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048700, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.j1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.j1().F1()).param("topic_id", this.a.j1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.j1().J1()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906fd));
            h08 d4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d();
            if (d4 != null) {
                this.q2.c(true, 0, 3, 0, d4, "", 1);
            }
            this.a.l1().d(this.r0);
        }
    }

    public void t6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048741, this, animatorListener) == null) && this.E0 != null && (pbModel = this.w0) != null && pbModel.l1() != null && this.w0.l1().U() != null && checkUpIsLogin() && this.E0.D0() != null && this.E0.D0().z() != null) {
            this.E0.D0().z().F(animatorListener);
        }
    }

    public final void N5(int i4, Intent intent) {
        y65 y65Var;
        y65 y65Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i4, intent) == null) {
            if (i4 == 0) {
                this.E0.r1();
                this.E0.d1().g();
                this.E0.F3(false);
            }
            this.E0.N2();
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
                if (editorType == 1 && this.E0.d1() != null && this.E0.d1().f() != null) {
                    s85 f4 = this.E0.d1().f();
                    f4.d0(this.w0.l1().Q());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    x65 o3 = f4.b().o(6);
                    if (o3 != null && (y65Var2 = o3.m) != null) {
                        y65Var2.A(new m65(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.T0.L();
            this.T0.m0(pbEditorData.getVoiceModel());
            this.T0.B(writeData);
            x65 o4 = this.T0.b().o(6);
            if (o4 != null && (y65Var = o4.m) != null) {
                y65Var.A(new m65(52, 0, pbEditorData.getVoiceModel()));
            }
            this.T0.h0(pbEditorData.isShowCustomFigure());
            if (i4 == -1) {
                this.T0.G(null, null);
            }
        }
    }

    public final void R6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048626, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (F5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        r45.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            lz7.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            lz7.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            lz7.e(getResources().getString(R.string.obfuscated_res_0x7f0f129d));
                            return;
                        } else {
                            lz7.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.w0.Y0()) {
                antiData.setBlock_forum_name(this.w0.l1().l().getName());
                antiData.setBlock_forum_id(this.w0.l1().l().getId());
                antiData.setUser_name(this.w0.l1().X().getUserName());
                antiData.setUser_id(this.w0.l1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void X6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048648, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            uv4 uv4Var = this.J0;
            if (uv4Var != null && uv4Var.isShowing()) {
                this.J0.dismiss();
                this.J0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            wv4 wv4Var = new wv4(getContext());
            wv4Var.n(new h0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new sv4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04c1), wv4Var));
            }
            if (z3) {
                arrayList.add(new sv4(1, getResources().getString(R.string.un_mute), wv4Var));
            } else {
                arrayList.add(new sv4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b9d), wv4Var));
            }
            wv4Var.j(arrayList);
            uv4 uv4Var2 = new uv4(getPageContext(), wv4Var);
            this.J0 = uv4Var2;
            uv4Var2.k();
        }
    }

    public void f5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048674, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(l48.m2)).intValue();
            if (intValue == l48.n2) {
                if (this.z0.Z()) {
                    return;
                }
                this.E0.h4();
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
                    this.z0.b0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.z0.c0(this.w0.l1().l().getId(), this.w0.l1().l().getName(), this.w0.l1().Q().getId(), str, intValue3, intValue2, booleanValue, this.w0.l1().Q().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == l48.o2 || intValue == l48.q2) {
                PbModel pbModel = this.w0;
                if (pbModel != null && pbModel.G0() != null) {
                    this.w0.G0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == l48.o2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void h7(PostData postData, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048685, this, postData, z3) == null) {
            J6(false);
            if (postData == null || (pbModel = this.w0) == null || pbModel.l1() == null || postData.D() == 1) {
                return;
            }
            String F1 = this.w0.F1();
            String M = postData.M();
            if (this.w0.l1() != null) {
                i4 = this.w0.l1().Y();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e w6 = w6(M);
            if (w6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo e02 = postData.e0();
            AntiData d4 = this.w0.l1().d();
            if (postData.r() != null) {
                arrayList = postData.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(F1, M, "pb", true, false, null, false, null, i4, e02, d4, false, arrayList, 5).addBigImageData(w6.a, w6.b, w6.g, w6.j);
            addBigImageData.setKeyPageStartFrom(this.w0.k1());
            addBigImageData.setFromFrsForumId(this.w0.getFromForumId());
            addBigImageData.setWorksInfoData(this.w0.K1());
            addBigImageData.setKeyFromForumId(this.w0.getForumId());
            addBigImageData.setBjhData(this.w0.D0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void i5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048686, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            l48 l48Var = this.E0;
            if (l48Var != null && this.w0 != null) {
                if ((l48Var == null || l48Var.I1()) && this.w0.l1() != null && this.w0.l1().U() != null) {
                    l48 l48Var2 = this.E0;
                    if (l48Var2 != null && l48Var2.J0() != null && this.E0.J0().t()) {
                        return;
                    }
                    v08 U = this.w0.l1().U();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!U.f() || U.a() != 2) && this.E0.D0() != null && this.E0.D0().z() != null) {
                        this.E0.D0().z().v(this.w0.F1(), this.w0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        jz7 jz7Var = new jz7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.w0;
                        jz7Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        jz7Var.l(new o0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
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
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            e7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void P5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null && this.w0.l1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.w0.F1(), str);
                ThreadData Q = this.w0.l1().Q();
                if (Q.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                b6(format);
                return;
            }
            this.x0.a(str);
        }
    }

    public final void V6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048641, this, metaData) != null) || metaData == null) {
            return;
        }
        lv4 lv4Var = new lv4(getActivity());
        lv4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0afe));
        lv4Var.setTitleShowCenter(true);
        lv4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0aff));
        lv4Var.setMessageShowCenter(true);
        lv4Var.setCancelable(false);
        lv4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b00), new v1(this, metaData));
        lv4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b01), new w1(this, metaData));
        lv4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void b7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                M().t0(postWriteCallBackData.getPostId());
                int H0 = this.E0.H0();
                this.o1 = H0;
                this.w0.K2(H0, this.E0.N0());
            }
            this.E0.p0();
            this.I0.c();
            o85 o85Var = this.T0;
            if (o85Var != null) {
                this.E0.V2(o85Var.y());
            }
            this.E0.r1();
            this.E0.F3(true);
            this.w0.O1();
        }
    }

    public final void d5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048667, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.w0) != null && pbModel.l1() != null) {
            ks8 A = this.w0.l1().A();
            if (A != null && str.equals(A.n1())) {
                if (A.getAdvertAppInfo() != null) {
                    A.getAdvertAppInfo().h = null;
                }
                this.w0.l1().b();
            }
            ks8 E0 = this.w0.E0();
            if (E0 != null && str.equals(E0.n1())) {
                this.w0.q0();
            }
        }
    }

    public void l6(PostData postData) {
        PostData p5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048696, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.M() != null && postData.M().equals(this.w0.g1())) {
            z3 = true;
        }
        MarkData f12 = this.w0.f1(postData);
        if (this.w0.l1() != null && this.w0.l1().l0() && (p5 = p5()) != null) {
            f12 = this.w0.f1(p5);
        }
        if (f12 == null) {
            return;
        }
        this.E0.s3();
        jp4 jp4Var = this.y0;
        if (jp4Var != null) {
            jp4Var.i(f12);
            if (!z3) {
                this.y0.a();
            } else {
                this.y0.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048709, this, i4) != null) || this.V == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.E0.b2(i4);
        o85 o85Var = this.T0;
        if (o85Var != null && o85Var.b() != null) {
            this.T0.b().x(i4);
        }
        if (this.E0.a() != null) {
            this.E0.a().d(getPageContext(), i4);
        }
        this.I0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.V = i4;
        i7();
        n45 n45Var = this.i0;
        if (n45Var != null) {
            n45Var.w();
        }
    }

    public void z6(x08 x08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, x08Var) == null) {
            String M = x08Var.i().M();
            List<PostData> list = this.w0.l1().V().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.M() != null && postData.M().equals(M)) {
                    ArrayList<PostData> k3 = x08Var.k();
                    postData.a1(x08Var.m());
                    if (postData.b0() != null) {
                        postData.b0().clear();
                        postData.b0().addAll(k3);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.w0.U0()) {
                this.E0.G1(this.w0.l1());
            }
        }
    }

    public final void Q6(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048622, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new a2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                d7(str);
            } else {
                this.E0.g4(str);
            }
        }
    }

    @Override // com.baidu.tieba.wn5
    public void X(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048645, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.L0 = str;
            if (this.l == null) {
                W5();
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

    public final void R4() {
        PbModel pbModel;
        h08 h08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (pbModel = this.w0) != null && (h08Var = pbModel.G) != null && h08Var.Q() != null) {
            ThreadData Q = this.w0.G.Q();
            Q.mRecomAbTag = this.w0.q1();
            Q.mRecomWeight = this.w0.t1();
            Q.mRecomSource = this.w0.s1();
            Q.mRecomExtra = this.w0.r1();
            Q.isSubPb = this.w0.Y0();
            if (Q.getFid() == 0) {
                Q.setFid(xg.g(this.w0.getForumId(), 0L));
            }
            StatisticItem i4 = ue5.i(getContext(), Q, "c13562");
            TbPageTag l3 = ue5.l(getContext());
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

    public final void j6() {
        MarkData B0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && this.y0 != null) {
            if (this.w0.l1() != null && this.w0.l1().l0()) {
                B0 = this.w0.B0(0);
            } else {
                B0 = this.w0.B0(this.E0.S0());
            }
            if (B0 == null) {
                return;
            }
            if (B0.isApp() && (B0 = this.w0.B0(this.E0.S0() + 1)) == null) {
                return;
            }
            this.E0.s3();
            this.y0.i(B0);
            if (!this.y0.e()) {
                if (this.E0 != null && this.w0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !h68.k(this.w0.b)) {
                    this.E0.a4();
                    h68.b(this.w0.b);
                }
                this.y0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.y0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            this.f = true;
            super.onPause();
            g68.a();
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
            l48 l48Var = this.E0;
            if (l48Var != null) {
                l48Var.i2();
            }
            if (!this.w0.Y0()) {
                this.T0.N(this.w0.F1());
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.o2();
            }
            PushPermissionController pushPermissionController = this.t0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            km4.w().E();
            MessageManager.getInstance().unRegisterListener(this.C1);
            G6();
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            n45 n45Var = this.i0;
            if (n45Var != null) {
                n45Var.q();
                this.i0.p();
            }
        }
    }

    @Override // com.baidu.tieba.wn5
    public void T(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048631, this, context, str, z3) == null) {
            if (r48.c(str) && (pbModel = this.w0) != null && pbModel.F1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.w0.F1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    x55 x55Var = new x55();
                    x55Var.a = str;
                    x55Var.b = 3;
                    x55Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, x55Var));
                }
            } else {
                r48.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void u0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048744, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (tn5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), tn5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (r48.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new ll5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void T4(h08 h08Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048632, this, h08Var, arrayList) == null) && h08Var != null && h08Var.V() != null && h08Var.V().a != null && (list = h08Var.V().a) != null && arrayList != null) {
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

    public final void l5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048695, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.E0.z0(this.z0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.F0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.G0 = false;
                    this.H0 = true;
                }
            } else {
                this.G0 = true;
                this.H0 = false;
            }
            if (i4 == 2) {
                this.w0.l1().Q().setIs_good(1);
                this.w0.O2(1);
            } else if (i4 == 3) {
                this.w0.l1().Q().setIs_good(0);
                this.w0.O2(0);
            } else if (i4 == 4) {
                this.w0.l1().Q().setIs_top(1);
                this.w0.P2(1);
            } else if (i4 == 5) {
                this.w0.l1().Q().setIs_top(0);
                this.w0.P2(0);
            }
            this.E0.p4(this.w0.l1(), this.w0.D1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        yi.Q(getPageContext().getPageActivity(), string);
    }

    public final void T6(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            f68.e(getActivity(), getPageContext(), new f1(this, sparseArray, i4, z3), new g1(this));
        }
    }

    public final void W5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048643, this) != null) || this.l != null) {
            return;
        }
        this.l = new nv4(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        nv4 nv4Var = this.l;
        nv4Var.j(strArr, new r0(this));
        nv4Var.g(nv4.b.a);
        nv4Var.h(17);
        nv4Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z4(AgreeData agreeData) {
        pe5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048652, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new ny4();
        }
        if (this.h0 == null) {
            bs8 bs8Var = new bs8();
            this.h0 = bs8Var;
            bs8Var.a = getUniqueId();
        }
        bs4 bs4Var = new bs4();
        bs4Var.b = 5;
        bs4Var.h = 8;
        bs4Var.g = 2;
        if (M() != null) {
            bs4Var.f = M().k1();
        }
        bs4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                bs4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i4, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.w0;
                if (pbModel == null && pbModel.l1() != null) {
                    this.d0.b(R(), bs4Var, agreeData, this.w0.l1().Q());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            bs4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            bs4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.d0.c(agreeData, i4, getUniqueId(), false);
        this.d0.d(agreeData, this.h0);
        pbModel = this.w0;
        if (pbModel == null) {
        }
    }

    public final boolean b5(View view2) {
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
        List<sv4> c4;
        int i4;
        boolean z20;
        sv4 sv4Var;
        sv4 sv4Var2;
        sv4 sv4Var3;
        sv4 sv4Var4;
        sv4 sv4Var5;
        sv4 sv4Var6;
        in inVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            l48 l48Var = this.E0;
            if (l48Var != null) {
                if (l48Var.K1()) {
                    return true;
                }
                this.E0.A0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (j48.y(view2)) {
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
                        this.E0.S3(this.G2, this.j1.t());
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
            if (postData.D() == 1 && j48.y(view2)) {
                this.E0.S3(this.G2, this.j1.t());
                return true;
            }
            jp4 jp4Var = this.y0;
            if (jp4Var == null) {
                return true;
            }
            if (jp4Var.e() && this.E2.M() != null && this.E2.M().equals(this.w0.g1())) {
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
            if (this.E2.D() == 1) {
                if (!z4) {
                    this.E0.T3(this.F2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.K0 == null) {
                wv4 wv4Var = new wv4(getContext());
                this.K0 = wv4Var;
                wv4Var.n(this.i2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (j48.y(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (j48.y(view2) && (inVar = this.j1) != null && !inVar.t()) {
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
                    arrayList.add(new sv4(1, getString(R.string.save_to_emotion), this.K0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new sv4(2, getString(R.string.save_to_local), this.K0));
                }
                if (!z7 && !z8) {
                    sv4 sv4Var7 = new sv4(3, getString(R.string.obfuscated_res_0x7f0f0462), this.K0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.E2);
                    sv4Var7.d.setTag(sparseArray3);
                    arrayList.add(sv4Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        sv4Var6 = new sv4(4, getString(R.string.remove_mark), this.K0);
                    } else {
                        sv4Var6 = new sv4(4, getString(R.string.obfuscated_res_0x7f0f0afc), this.K0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.E2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    sv4Var6.d.setTag(sparseArray4);
                    arrayList.add(sv4Var6);
                }
                if (this.mIsLogin) {
                    if (!f68.j(this.w0) && !z12 && z11) {
                        sv4 sv4Var8 = new sv4(5, getString(R.string.obfuscated_res_0x7f0f0ba1), this.K0);
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
                        sv4Var8.d.setTag(sparseArray5);
                        arrayList.add(sv4Var8);
                    } else {
                        if (j48.C(this.w0.l1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            sv4 sv4Var9 = new sv4(5, getString(R.string.report_text), this.K0);
                            sv4Var9.d.setTag(str);
                            arrayList.add(sv4Var9);
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
                        if (!f68.j(this.w0) && z18) {
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
                                sv4Var5 = new sv4(6, getString(R.string.obfuscated_res_0x7f0f04c1), this.K0);
                                sv4Var5.d.setTag(sparseArray6);
                                sv4Var2 = new sv4(7, getString(R.string.obfuscated_res_0x7f0f02ee), this.K0);
                                sv4Var2.d.setTag(sparseArray6);
                                sv4Var3 = sv4Var5;
                                sv4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        sv4Var5 = null;
                        sv4Var2 = new sv4(7, getString(R.string.obfuscated_res_0x7f0f02ee), this.K0);
                        sv4Var2.d.setTag(sparseArray6);
                        sv4Var3 = sv4Var5;
                        sv4Var = null;
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
                        if (this.w0.l1().Y() == 1002 && !z10) {
                            sv4Var4 = new sv4(6, getString(R.string.report_text), this.K0);
                        } else {
                            sv4Var4 = new sv4(6, getString(R.string.obfuscated_res_0x7f0f04c1), this.K0);
                        }
                        sv4Var4.d.setTag(sparseArray7);
                        if (z17) {
                            sv4Var = new sv4(13, getString(R.string.multi_delete), this.K0);
                            sv4Var3 = sv4Var4;
                        } else {
                            sv4Var3 = sv4Var4;
                            sv4Var = null;
                        }
                        sv4Var2 = null;
                    } else {
                        sv4Var = null;
                        sv4Var2 = null;
                        sv4Var3 = null;
                    }
                    if (sv4Var3 != null) {
                        arrayList.add(sv4Var3);
                    }
                    if (sv4Var != null) {
                        arrayList.add(sv4Var);
                    }
                    if (sv4Var2 != null) {
                        arrayList.add(sv4Var2);
                    }
                    f68.b(arrayList, this.K0, this.E2, this.w0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = f68.d(arrayList, this.E2.p(), sparseArray, this.K0);
                } else {
                    c4 = f68.c(arrayList, this.E2.p(), sparseArray, this.K0);
                }
                f68.m(c4, this.b);
                f68.f(c4);
                this.K0.o(f68.h(this.E2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.K0.k(c4, false);
                } else {
                    this.K0.k(c4, true);
                }
                uv4 uv4Var = new uv4(getPageContext(), this.K0);
                this.J0 = uv4Var;
                uv4Var.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.w0.b).param("fid", this.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.w0.I());
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

    public void c5(ForumManageModel.b bVar, l48 l48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048663, this, bVar, l48Var) == null) {
            List<PostData> list = this.w0.l1().V().a;
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
                l48Var.G1(this.w0.l1());
            }
        }
    }

    public final void e7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.E0.N3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            lv4 lv4Var = new lv4(this.e1.getPageActivity());
            if (!xi.isEmpty(str)) {
                lv4Var.setMessage(str);
            } else {
                lv4Var.setMessage(this.e1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0446, new g(this, userMuteAddAndDelCustomMessage));
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new h(this));
            lv4Var.create(this.e1).show();
        }
    }

    @Override // com.baidu.tieba.s78
    public void finish() {
        l48 l48Var;
        boolean z3;
        CardHListViewData q3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            l48 l48Var2 = this.E0;
            if (l48Var2 != null) {
                l48Var2.p0();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null && !this.w0.l1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.w0.l1().Q().getId();
                if (this.w0.isShareThread() && this.w0.l1().Q().originalThreadData != null) {
                    historyMessage.threadName = this.w0.l1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.w0.l1().Q().getTitle();
                }
                if (this.w0.isShareThread() && !s0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.w0.l1().l().getName();
                }
                ArrayList<PostData> H = this.w0.l1().H();
                l48 l48Var3 = this.E0;
                if (l48Var3 != null) {
                    i4 = l48Var3.K0();
                } else {
                    i4 = 0;
                }
                if (H != null && i4 >= 0 && i4 < H.size()) {
                    historyMessage.postID = H.get(i4).M();
                }
                historyMessage.isHostOnly = this.w0.O0();
                historyMessage.isSquence = this.w0.D1();
                historyMessage.isShareThread = this.w0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            o85 o85Var = this.T0;
            if (o85Var != null) {
                o85Var.D();
            }
            if (this.i && F5() != null) {
                F5().u0();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && (pbModel2.Q0() || this.w0.T0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.w0.F1());
                if (this.F0) {
                    if (this.H0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.w0.Z0());
                    }
                    if (this.G0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.w0.V0());
                    }
                }
                if (this.w0.l1() != null && System.currentTimeMillis() - this.o >= 40000 && (q3 = this.w0.l1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.p1);
                }
                this.a.setResult(-1, intent);
            }
            if (k7()) {
                if (this.w0 != null && (l48Var = this.E0) != null && l48Var.T0() != null) {
                    h08 l12 = this.w0.l1();
                    if (l12 != null) {
                        if (l12.X() != null) {
                            l12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            l12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!l12.t0() && !this.H && l12.h == null) {
                            a48 b4 = a48.b();
                            h08 m12 = this.w0.m1();
                            Parcelable onSaveInstanceState = this.E0.T0().onSaveInstanceState();
                            boolean D1 = this.w0.D1();
                            boolean O0 = this.w0.O0();
                            if (this.E0.b1() != null && this.E0.b1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.n(m12, onSaveInstanceState, D1, O0, z3);
                            if (this.o1 >= 0 || this.w0.H1() != null) {
                                a48.b().q(this.w0.H1());
                                a48.b().r(this.w0.I1());
                                a48.b().o(this.w0.e1());
                            }
                        }
                    }
                } else {
                    a48.b().m();
                }
                j7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        n68 n68Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            nq8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.w0.l1().m());
                statisticItem.param("tid", this.w0.F1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.E0 != null) {
                this.s = true;
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.w0.destory();
                if (this.w0.h1() != null) {
                    this.w0.h1().d();
                }
            }
            o85 o85Var = this.T0;
            if (o85Var != null) {
                o85Var.D();
            }
            ForumManageModel forumManageModel = this.z0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.T();
            }
            l48 l48Var = this.E0;
            if (l48Var != null) {
                l48Var.d2();
                n68 n68Var2 = this.E0.h;
                if (n68Var2 != null) {
                    n68Var2.y();
                }
            }
            lf5 lf5Var = this.t;
            if (lf5Var != null) {
                lf5Var.c();
            }
            q58 q58Var = this.e;
            if (q58Var != null) {
                q58Var.k();
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
            l48 l48Var2 = this.E0;
            if (l48Var2 != null) {
                l48Var2.p0();
            }
            if (this.X1 != null) {
                ah.a().removeCallbacks(this.X1);
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
            ik8.e().g();
            if (this.h1 != null) {
                ah.a().removeCallbacks(this.h1);
            }
            l48 l48Var3 = this.E0;
            if (l48Var3 != null && (n68Var = l48Var3.h) != null) {
                n68Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            o48 o48Var = this.I0;
            if (o48Var != null) {
                o48Var.j();
            }
            PushPermissionController pushPermissionController = this.t0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && pbModel2.y0() != null) {
                this.w0.y0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.W0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            l48 l48Var4 = this.E0;
            if (l48Var4 != null) {
                l48Var4.i4();
            }
            d68 d68Var = this.s0;
            if (d68Var != null) {
                d68Var.e();
            }
        }
    }

    public void r6() {
        PbModel pbModel;
        h08 l12;
        ThreadData Q;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        h08 h08Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048735, this) == null) && (pbModel = this.w0) != null && pbModel.l1() != null && (Q = (l12 = this.w0.l1()).Q()) != null && Q.getAuthor() != null) {
            this.E0.r1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q.getAuthor().getUserId());
            t38 t38Var = new t38();
            int Y = this.w0.l1().Y();
            if (Y != 1 && Y != 3) {
                t38Var.g = false;
            } else {
                t38Var.g = true;
                if (Q.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                t38Var.s = z3;
            }
            if (j48.z(this.w0.l1(), Y)) {
                t38Var.h = true;
                if (Q.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                t38Var.r = z8;
            } else {
                t38Var.h = false;
            }
            if (Y == 1002 && !equals) {
                t38Var.u = true;
            }
            t38Var.n = j48.J(Q.isBlocked(), l12.o0(), equals, Y, Q.isWorksInfo(), Q.isScoreThread());
            t38Var.e = j48.H(l12, equals, l12.o0(), this.w0.O());
            t38Var.i = U6();
            t38Var.f = j48.I(this.w0.l1(), equals, this.w0.O());
            if (equals && l12.X() != null && l12.X().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            t38Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                t38Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            t38Var.t = equals;
            t38Var.q = this.w0.D1();
            t38Var.b = true;
            t38Var.a = j48.C(this.w0.l1(), equals);
            if (equals) {
                this.E0.H1();
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            t38Var.p = z5;
            t38Var.j = true;
            t38Var.o = this.w0.O0();
            t38Var.d = true;
            if (Q.getThreadVideoInfo() == null) {
                t38Var.c = true;
            } else {
                t38Var.c = false;
            }
            if (l12.l0()) {
                t38Var.b = false;
                t38Var.d = false;
                t38Var.c = false;
                t38Var.g = false;
                t38Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !l12.l0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            t38Var.v = z6;
            if (this.E0 != null && (h08Var = this.w0.G) != null) {
                PostData Z = h08Var.Z();
                if (Z != null) {
                    z7 = Z.S;
                } else {
                    z7 = false;
                }
                t38Var.w = z7;
            }
            t38Var.m = true;
            if (Q.isBlocked()) {
                t38Var.n = false;
                t38Var.g = false;
                t38Var.h = false;
            }
            this.E0.h.F(t38Var);
        }
    }

    public void g5(lv4 lv4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048678, this, lv4Var, jSONArray) == null) {
            lv4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(lv4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                f5((SparseArray) lv4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText r7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048736, this, str, i4)) == null) {
            PbModel pbModel = this.w0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.l1() == null || str == null || i4 < 0) {
                return null;
            }
            h08 l12 = this.w0.l1();
            if (l12.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(l12.j());
                tbRichText = t5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> H = l12.H();
                T4(l12, H);
                return t5(H, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final void g6(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048679, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (V4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!X4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.X);
                        this.Y = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (F5().d1() != null && postData != null) {
                        if (postData.X() != null) {
                            str3 = postData.X().toString();
                        } else {
                            str3 = "";
                        }
                        F5().d1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.r().getName_show(), str3));
                    }
                    if (this.w0.l1() != null && this.w0.l1().l0()) {
                        ah.a().postDelayed(new j1(this, str, str2), 0L);
                        return;
                    }
                    if (this.Y0 == null) {
                        vt6 vt6Var = new vt6(getPageContext());
                        this.Y0 = vt6Var;
                        vt6Var.j(1);
                        this.Y0.i(new k1(this, str, str2));
                    }
                    PbModel pbModel = this.w0;
                    if (pbModel != null && pbModel.l1() != null && this.w0.l1().l() != null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.Y0.g(this.w0.l1().l().getId(), xg.g(this.w0.F1(), 0L));
                        return;
                    }
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void h5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(l48.m2, Integer.valueOf(l48.n2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                f5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void k5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048692, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                lv4 lv4Var = new lv4(getPageContext().getPageActivity());
                lv4Var.setMessage(string);
                lv4Var.setPositiveButton(R.string.dialog_known, new c2(this));
                lv4Var.setCancelable(true);
                lv4Var.create(getPageContext());
                lv4Var.show();
            } else if (bVar.d != 0) {
                this.E0.z0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> H = this.w0.l1().H();
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
                    this.w0.l1().Q().setReply_num(this.w0.l1().Q().getReply_num() - 1);
                    this.E0.G1(this.w0.l1());
                } else if (i5 == 0) {
                    a5();
                } else if (i5 == 2) {
                    ArrayList<PostData> H2 = this.w0.l1().H();
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
                        this.E0.G1(this.w0.l1());
                    }
                    c5(bVar, this.E0);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.T0.C(i4, i5, intent);
            if (F5().d1() != null) {
                F5().d1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                N5(i5, intent);
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
                                                            l48 l48Var = this.E0;
                                                            if (l48Var != null && l48Var.E0() != null) {
                                                                this.E0.E0().performClick();
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
                                                this.E0.u3(false);
                                                if (this.w0.l1() != null && this.w0.l1().Q() != null && this.w0.l1().Q().getPushStatusData() != null) {
                                                    this.w0.l1().Q().getPushStatusData().setStatus(2);
                                                    return;
                                                }
                                                return;
                                            }
                                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                                ci8.g().m(getPageContext());
                                                o7();
                                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
                                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                                    shareSuccessReplyToServerModel.G(str, intExtra, new j2(this));
                                                }
                                                if (Y5()) {
                                                    m7(true);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        View view5 = this.Q;
                                        if (view5 != null) {
                                            this.E0.K3(view5);
                                            return;
                                        }
                                        return;
                                    }
                                    intent.getLongExtra("KEY_FORUM_ID", 0L);
                                    intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                                    return;
                                }
                                Q5(intent);
                                return;
                            } else if (intent != null && this.w0 != null) {
                                S6(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                                return;
                            } else {
                                return;
                            }
                        }
                        ci8.g().m(getPageContext());
                        return;
                    }
                    a48.b().m();
                    this.v0.postDelayed(new h2(this), 1000L);
                    return;
                }
                j6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048713, this, layoutInflater, viewGroup, bundle)) == null) {
            this.E0 = new l48(this, this.k2, this.W1);
            wa6 wa6Var = new wa6(getActivity());
            this.d = wa6Var;
            wa6Var.i(U2);
            this.d.d(this.N2);
            this.E0.l3(this.u2);
            this.E0.k3(this.A2);
            this.E0.d3(this.x2);
            this.E0.e3(this.y2);
            this.E0.b3(dr4.c().g());
            this.E0.i3(this.C2);
            this.E0.o3(this.I2);
            this.E0.m3(this.J2);
            this.E0.j3(this.L2);
            this.E0.h3(this.w2);
            this.E0.l4(this.mIsLogin);
            this.E0.Y2(this.w0.R1());
            if (this.a.getIntent() != null) {
                this.E0.Z2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.E0.c1().setFromForumId(this.w0.getFromForumId());
            this.E0.Q2(this.T0.b());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.T0.c0(this.E0.f1());
            }
            this.E0.U2(this.h2);
            this.E0.X2(this.w0.T0());
            this.E0.n3(this.w0.k1());
            this.s0.f(this.E0, this.w0);
            if ("1".equals(M().showReplyPanel)) {
                this.E0.k2();
            }
            return this.E0.n1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        l48 l48Var;
        l48 l48Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.e1 = getPageContext();
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
                this.P2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.Q2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.R2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.O0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.P0 = intent.getStringExtra("high_light_post_id");
                this.Q0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (w5()) {
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
                this.p1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                gu4 gu4Var = new gu4();
                this.b0 = gu4Var;
                gu4Var.a(intent);
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
            e6(bundle);
            if (this.w0.l1() != null) {
                this.w0.l1().U0(this.O);
            }
            V5();
            if (intent != null && (l48Var2 = this.E0) != null) {
                l48Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new l0(this, intent);
                    }
                    ah.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.w0.l1() != null) {
                    this.w0.T2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            U5(bundle);
            q85 q85Var = new q85();
            this.S0 = q85Var;
            M6(q85Var);
            o85 o85Var = (o85) this.S0.a(getActivity());
            this.T0 = o85Var;
            o85Var.W(this.a.getPageContext());
            this.T0.f0(this.m2);
            this.T0.g0(this.Z0);
            this.T0.Y(1);
            this.T0.A(this.a.getPageContext(), bundle);
            this.T0.b().b(new w65(getActivity()));
            this.T0.b().D(true);
            P6(true);
            this.T0.J(this.w0.N0(), this.w0.F1(), this.w0.J0());
            registerListener(this.z1);
            if (!this.w0.Y0()) {
                this.T0.q(this.w0.F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.w0.T1()) {
                this.T0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                l48 l48Var3 = this.E0;
                if (l48Var3 != null) {
                    this.T0.c0(l48Var3.f1());
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
            cs8 cs8Var = new cs8("pb", cs8.d);
            this.R0 = cs8Var;
            cs8Var.d();
            registerListener(this.H1);
            registerListener(this.S1);
            this.w0.p2();
            registerListener(this.r2);
            registerListener(this.f2);
            registerListener(this.l2);
            registerListener(this.N1);
            registerListener(this.e2);
            registerListener(this.I1);
            l48 l48Var4 = this.E0;
            if (l48Var4 != null && l48Var4.m1() != null && this.E0.k1() != null) {
                q58 q58Var = new q58(getActivity(), this.E0.m1(), this.E0.k1(), this.E0.b1());
                this.e = q58Var;
                q58Var.t(this.R1);
            }
            if (this.c && (l48Var = this.E0) != null && l48Var.k1() != null) {
                this.E0.k1().setVisibility(8);
            }
            wy4 wy4Var = new wy4();
            this.f1 = wy4Var;
            wy4Var.a = 1000L;
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
            this.V1 = new g3(this.E0, this);
            this.w0.F0().K(this.V1);
            this.I0 = new o48();
            if (this.T0.s() != null) {
                this.I0.m(this.T0.s().i());
            }
            this.T0.V(this.a1);
            this.D0 = new ShareSuccessReplyToServerModel();
            P4(this.u1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.W0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new m0(this));
            o68 o68Var = new o68(getContext());
            this.x0 = o68Var;
            o68Var.b(getUniqueId());
            nq8.g().i(getUniqueId());
            qr4.b().l("3", "");
            this.t1 = new f46(getPageContext());
            this.s0 = new d68(this, getUniqueId(), this.E0, this.w0);
            this.t0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    public final TbRichText t5(ArrayList<PostData> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048740, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText X = arrayList.get(i5).X();
                    if (X != null && (I = X.I()) != null) {
                        int size = I.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (I.get(i7) != null && I.get(i7).getType() == 8) {
                                i6++;
                                if (!I.get(i7).M().H().equals(str) && !I.get(i7).M().I().equals(str)) {
                                    if (i6 > i4) {
                                        break;
                                    }
                                } else {
                                    int i8 = (int) yi.i(TbadkCoreApplication.getInst());
                                    int width = I.get(i7).M().getWidth() * i8;
                                    int height = I.get(i7).M().getHeight() * i8;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.B2 = i7;
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

    public final int u5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo M;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048745, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.D2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.I().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.I().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int i10 = (int) yi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.M().getWidth() * i10;
                        int height = tbRichTextData.M().getHeight() * i10;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.M().N()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = i08.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (M = tbRichTextData.M()) != null) {
                                        String H = M.H();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            H = M.I();
                                        } else {
                                            if (this.r) {
                                                i6 = 17;
                                            } else {
                                                i6 = 18;
                                            }
                                            imageUrlData.urlType = i6;
                                        }
                                        imageUrlData.imageUrl = H;
                                        imageUrlData.originalUrl = j48.o(tbRichTextData);
                                        imageUrlData.originalSize = j48.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = j48.l(tbRichTextData);
                                        imageUrlData.isLongPic = j48.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = xg.g(this.w0.F1(), -1L);
                                        imageUrlData.mIsReserver = this.w0.w1();
                                        imageUrlData.mIsSeeHost = this.w0.O0();
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

    public final void u6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048746, this, str, i4, eVar) != null) || eVar == null) {
            return;
        }
        h08 l12 = this.w0.l1();
        TbRichText r7 = r7(str, i4);
        if (r7 == null || (tbRichTextData = r7.I().get(this.B2)) == null) {
            return;
        }
        eVar.f = String.valueOf(r7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.M().N()) {
            eVar.h = false;
            String a4 = i08.a(tbRichTextData);
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
            imageUrlData.originalUrl = j48.o(tbRichTextData);
            imageUrlData.originalUrl = j48.o(tbRichTextData);
            imageUrlData.originalSize = j48.p(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = j48.l(tbRichTextData);
            imageUrlData.isLongPic = j48.k(tbRichTextData);
            imageUrlData.postId = r7.getPostId();
            imageUrlData.mIsReserver = this.w0.w1();
            imageUrlData.mIsSeeHost = this.w0.O0();
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
            imageUrlData.threadId = xg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = l12.H().size();
        this.D2 = false;
        eVar.j = -1;
        if (l12.j() != null) {
            i5 = u5(l12.j().X(), r7, i4, i4, eVar.a, eVar.b);
        } else {
            i5 = i4;
        }
        int i7 = i5;
        for (int i8 = 0; i8 < size; i8++) {
            PostData postData = l12.H().get(i8);
            if (postData.M() == null || l12.j() == null || l12.j().M() == null || !postData.M().equals(l12.j().M())) {
                i7 = u5(postData.X(), r7, i7, i4, eVar.a, eVar.b);
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

    public void v6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.l1() != null && this.w0.l1().l() != null) {
                if (V4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.w0.l1().l0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.E0.i0();
                    return;
                } else {
                    if (this.X0 == null) {
                        vt6 vt6Var = new vt6(getPageContext());
                        this.X0 = vt6Var;
                        vt6Var.j(0);
                        this.X0.i(new h1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.X0.g(this.w0.l1().l().getId(), xg.g(this.w0.F1(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
