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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.a29;
import com.baidu.tieba.a85;
import com.baidu.tieba.ab8;
import com.baidu.tieba.af8;
import com.baidu.tieba.au4;
import com.baidu.tieba.aw4;
import com.baidu.tieba.b29;
import com.baidu.tieba.b98;
import com.baidu.tieba.bb5;
import com.baidu.tieba.bc8;
import com.baidu.tieba.br4;
import com.baidu.tieba.bt5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ce8;
import com.baidu.tieba.cg8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cr4;
import com.baidu.tieba.cy4;
import com.baidu.tieba.dg8;
import com.baidu.tieba.dh;
import com.baidu.tieba.di8;
import com.baidu.tieba.dj;
import com.baidu.tieba.e15;
import com.baidu.tieba.ea5;
import com.baidu.tieba.eb5;
import com.baidu.tieba.ee8;
import com.baidu.tieba.ef8;
import com.baidu.tieba.ej;
import com.baidu.tieba.ez4;
import com.baidu.tieba.f95;
import com.baidu.tieba.fd8;
import com.baidu.tieba.fe8;
import com.baidu.tieba.ff8;
import com.baidu.tieba.g45;
import com.baidu.tieba.gc8;
import com.baidu.tieba.gh;
import com.baidu.tieba.h45;
import com.baidu.tieba.hd8;
import com.baidu.tieba.hh8;
import com.baidu.tieba.ho;
import com.baidu.tieba.hu5;
import com.baidu.tieba.j05;
import com.baidu.tieba.j29;
import com.baidu.tieba.j77;
import com.baidu.tieba.ja8;
import com.baidu.tieba.jo5;
import com.baidu.tieba.k55;
import com.baidu.tieba.kc6;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kp5;
import com.baidu.tieba.l05;
import com.baidu.tieba.l35;
import com.baidu.tieba.l95;
import com.baidu.tieba.la8;
import com.baidu.tieba.lb5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.lk5;
import com.baidu.tieba.m09;
import com.baidu.tieba.m95;
import com.baidu.tieba.mh5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n39;
import com.baidu.tieba.n95;
import com.baidu.tieba.na8;
import com.baidu.tieba.nd5;
import com.baidu.tieba.ne5;
import com.baidu.tieba.nk5;
import com.baidu.tieba.nq5;
import com.baidu.tieba.nw4;
import com.baidu.tieba.nx4;
import com.baidu.tieba.o99;
import com.baidu.tieba.oc8;
import com.baidu.tieba.od5;
import com.baidu.tieba.od8;
import com.baidu.tieba.on;
import com.baidu.tieba.oo5;
import com.baidu.tieba.op5;
import com.baidu.tieba.p29;
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
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pj5;
import com.baidu.tieba.q05;
import com.baidu.tieba.q95;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qz5;
import com.baidu.tieba.r99;
import com.baidu.tieba.rk5;
import com.baidu.tieba.s05;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sc8;
import com.baidu.tieba.sd5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sf8;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.t05;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tr8;
import com.baidu.tieba.ty4;
import com.baidu.tieba.u05;
import com.baidu.tieba.u35;
import com.baidu.tieba.uf8;
import com.baidu.tieba.ug;
import com.baidu.tieba.uj5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uw8;
import com.baidu.tieba.v98;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vf8;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vy4;
import com.baidu.tieba.w9;
import com.baidu.tieba.w98;
import com.baidu.tieba.wa5;
import com.baidu.tieba.wa8;
import com.baidu.tieba.wb;
import com.baidu.tieba.wb5;
import com.baidu.tieba.we8;
import com.baidu.tieba.wf8;
import com.baidu.tieba.x88;
import com.baidu.tieba.x9;
import com.baidu.tieba.xa8;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xd8;
import com.baidu.tieba.xf8;
import com.baidu.tieba.xg8;
import com.baidu.tieba.y17;
import com.baidu.tieba.y35;
import com.baidu.tieba.yi6;
import com.baidu.tieba.ys5;
import com.baidu.tieba.yw4;
import com.baidu.tieba.z88;
import com.baidu.tieba.zd8;
import com.baidu.tieba.zi6;
import com.baidu.tieba.zt8;
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
public class PbFragment extends BaseFragment implements bt5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, j05.e, TbRichTextView.u, TbPageContextSupport, hh8, di8.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k V2;
    public static final zi6.b W2;
    public transient /* synthetic */ FieldHolder $fh;
    public ug<TbImageView> A;
    public au4 A0;
    public CustomMessageListener A1;
    public final View.OnClickListener A2;
    public ug<ImageView> B;
    public ForumManageModel B0;
    public CustomMessageListener B1;
    public boolean B2;
    public ug<View> C;
    public p85 C0;
    public CustomMessageListener C1;
    public final BdListView.p C2;
    public ug<TiebaPlusRecommendCard> D;
    public na8 D0;
    public CustomMessageListener D1;
    public int D2;
    public ug<LinearLayout> E;
    public PollingModel E0;
    public CustomMessageListener E1;
    public final TbRichTextView.a0 E2;
    public ug<RelativeLayout> F;
    public ShareSuccessReplyToServerModel F0;
    public final CustomMessageListener F1;
    public boolean F2;
    public ug<ItemCardView> G;
    public zd8 G0;
    public CustomMessageListener G1;
    public PostData G2;
    public ug<FestivalTipView> H;
    public boolean H0;
    public CustomMessageListener H1;
    public final l05.c H2;
    public boolean I;
    public boolean I0;
    public View.OnClickListener I1;
    public final l05.c I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public final AdapterView.OnItemClickListener J2;
    public boolean K;
    public ce8 K0;
    public CustomMessageListener K1;
    public final View.OnLongClickListener K2;
    public ug<GifView> L;
    public s05 L0;
    public CustomMessageListener L1;
    public final View.OnClickListener L2;
    public String M;
    public u05 M0;
    public CustomMessageListener M1;
    public final ItemCardHelper.c M2;
    public boolean N;
    public String N0;
    public CustomMessageListener N1;
    public final NoNetworkView.b N2;
    public boolean O;
    public boolean O0;
    public SuggestEmotionModel.c O1;
    public View.OnTouchListener O2;
    public String P;
    public boolean P0;
    public CustomMessageListener P1;
    public yi6.b P2;
    public LikeModel Q;
    public boolean Q0;
    public GetSugMatchWordsModel.b Q1;
    public final oc8.b Q2;
    public View R;
    public String R0;
    public boolean R1;
    public int R2;
    public View S;
    public boolean S0;
    public PraiseModel S1;
    public int S2;
    public View T;
    public b29 T0;
    public ff8.h T1;
    public String T2;
    public View U;
    public qd5 U0;
    public CustomMessageListener U1;
    public nx4 U2;
    public String V;
    public od5 V0;
    public mh5 V1;
    public int W;
    public boolean W0;
    public mh5 W1;
    public boolean X;
    public PermissionJudgePolicy X0;
    public CheckRealNameModel.b X1;
    public int[] Y;
    public ReplyPrivacyCheckController Y0;
    public xa8 Y1;
    public int Z;
    public y17 Z0;
    public final Runnable Z1;
    public AbsPbActivity a;
    public int a0;
    public y17 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public ld5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public ez4 c0;
    public kd5 c1;
    public CustomMessageListener c2;
    public zi6 d;
    public BdUniqueId d0;
    public kd5 d1;
    public CustomMessageListener d2;
    public ff8 e;
    public l35 e0;
    public int e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public Object f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public x9 g1;
    public CustomMessageListener g2;
    public boolean h;
    public Object h0;
    public u35 h1;
    public CustomMessageListener h2;
    public boolean i;
    public a29 i0;
    public BdUniqueId i1;
    public j05.e i2;
    public VoiceManager j;
    public m95 j0;
    public Runnable j1;
    public i3 j2;
    public int k;
    public ee8 k1;
    public u05.f k2;
    public l05 l;
    public on l1;
    public SortSwitchButton.f l2;
    public long m;
    public String m1;
    public final View.OnClickListener m2;
    public long n;
    public TbRichTextImageInfo n1;
    public CustomMessageListener n2;
    public long o;
    public TbRichTextMemeInfo o1;
    public final NewWriteModel.d o2;
    public long p;
    public boolean p1;
    public Boolean p2;
    public long q;
    public int q1;
    public NewWriteModel.d q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public wb r2;
    public boolean s;
    public boolean s0;
    public List<g3> s1;
    public final PbModel.h s2;
    public lk5 t;
    @NonNull
    public TiePlusEventController.f t0;
    public int t1;
    public CustomMessageListener t2;
    public long u;
    public sf8 u0;
    public String u1;
    public HttpMessageListener u2;
    public boolean v;
    public PushPermissionController v0;
    public kc6 v1;
    public final au4.a v2;
    public long w;
    public PbInterviewStatusView.f w0;
    public final g3 w1;
    public final AbsListView.OnScrollListener w2;
    public int x;
    public final Handler x0;
    public final fd8.b x1;
    public final w9 x2;
    public String y;
    public PbModel y0;
    public final CustomMessageListener y1;
    public final j3 y2;
    public ug<TextView> z;
    public dg8 z0;
    public CustomMessageListener z1;
    public final y35.g z2;

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
    @Override // com.baidu.tieba.hh8
    /* renamed from: O5 */
    public VideoPbFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
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

    @Override // com.baidu.tieba.bt5
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

    @Override // com.baidu.tieba.hh8
    public PbFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class l1 implements y17.d {
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
            public final /* synthetic */ l1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$l1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0385a implements TextWatcher {
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

                public C0385a(a aVar) {
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
                    ce8 ce8Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ce8Var = this.a.a.c.K0) != null && ce8Var.g() != null) {
                        if (!this.a.a.c.K0.g().e()) {
                            this.a.a.c.K0.b(false);
                        }
                        this.a.a.c.K0.g().l(false);
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
                    int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                    if (pbFragment.G0 != null && this.a.c.G0.Z0() != null) {
                        this.a.c.G0.Z0().smoothScrollBy(i3, 50);
                    }
                    if (this.a.c.K5().j1() != null) {
                        this.a.c.V0.b().setVisibility(8);
                        z = (this.a.c.y0 == null || this.a.c.y0.l1() == null || this.a.c.y0.l1().Q() == null || !this.a.c.y0.l1().Q().isBjh()) ? false : false;
                        sc8 j1 = this.a.c.K5().j1();
                        l1 l1Var = this.a;
                        j1.t(l1Var.a, l1Var.b, l1Var.c.K5().l1(), z);
                        sd5 f = this.a.c.K5().j1().f();
                        if (f != null && this.a.c.y0 != null && this.a.c.y0.l1() != null) {
                            f.H(this.a.c.y0.l1().d());
                            f.d0(this.a.c.y0.l1().Q());
                        }
                        if (this.a.c.K0.f() == null && this.a.c.K5().j1().f().u() != null) {
                            this.a.c.K5().j1().f().u().g(new C0385a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.K0.n(pbFragment2.K5().j1().f().u().i());
                            this.a.c.K5().j1().f().N(this.a.c.d1);
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
                ce8 ce8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ce8Var = this.a.c.K0) != null && ce8Var.g() != null) {
                    if (!this.a.c.K0.g().e()) {
                        this.a.c.K0.b(false);
                    }
                    this.a.c.K0.g().l(false);
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
                    this.c.K5().j1().t(this.a, this.b, this.c.K5().l1(), (this.c.y0 == null || this.c.y0.l1() == null || this.c.y0.l1().Q() == null || !this.c.y0.l1().Q().isBjh()) ? false : false);
                    sd5 f = this.c.K5().j1().f();
                    if (f != null && this.c.y0 != null && this.c.y0.l1() != null) {
                        f.H(this.c.y0.l1().d());
                        f.d0(this.c.y0.l1().Q());
                    }
                    if (this.c.K0.f() == null && this.c.K5().j1().f().u() != null) {
                        this.c.K5().j1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.K0.n(pbFragment2.K5().j1().f().u().i());
                        this.c.K5().j1().f().N(this.c.d1);
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
                    ab8.a(this.b.a.getPageContext(), this.a).show();
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
                gh.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:786:0x1ebf, code lost:
            if (r9 == (r32.a.G0.k1().c().getHeight() - r32.a.G0.k1().e())) goto L832;
         */
        /* JADX WARN: Code restructure failed: missing block: B:824:0x2041, code lost:
            if (r32.a.G0.e1.c.getView().getTop() <= ((r32.a.G0.k1() == null || r32.a.G0.k1().c() == null) ? 0 : r32.a.G0.k1().c().getBottom())) goto L761;
         */
        /* JADX WARN: Code restructure failed: missing block: B:825:0x2043, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:827:0x2050, code lost:
            if (r0 >= com.baidu.tieba.we8.d(r32.a.E5())) goto L761;
         */
        /* JADX WARN: Code restructure failed: missing block: B:849:0x20f7, code lost:
            if ((r32.a.G0.e1.c.getView().getTop() - r32.a.G0.h.a.getBottom()) < (r32.a.G0.e1.c.g.getHeight() + 10)) goto L761;
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
            v98 l1;
            int i;
            int i2;
            PostData Z;
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
            int i4;
            boolean z2;
            int fixedNavHeight;
            int i5;
            int i6;
            zz4 zz4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.s0 && (view2 == this.a.G0.h.c || view2 == this.a.G0.h.d || view2.getId() == R.id.obfuscated_res_0x7f09196a || view2.getId() == R.id.obfuscated_res_0x7f090aa3 || view2.getId() == R.id.obfuscated_res_0x7f091d1b || view2.getId() == R.id.obfuscated_res_0x7f091907)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.G0.c1() && this.a.getPageContext().getPageActivity() != null && this.a.y0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.F1(), this.a.y0.Y1(), this.a.y0.X1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.y0.getForumId());
                        statisticItem2.param("fname", this.a.y0.K0());
                        statisticItem2.param("tid", this.a.y0.F1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.G0.e1()) {
                        if (this.a.h) {
                            return;
                        }
                        if (this.a.y0.j2(true)) {
                            this.a.h = true;
                            this.a.G0.A3();
                        }
                    } else if (view2 == this.a.G0.h.n()) {
                        String string = StringUtils.string(view2.getTag(R.id.forum_name));
                        String string2 = StringUtils.string(view2.getTag(R.id.forum_id));
                        String string3 = StringUtils.string(view2.getTag(R.id.thread_id));
                        if (this.a.Q != null) {
                            this.a.Q.Y(string, string2);
                        }
                        TbPageTag l = uj5.l(this.a.getContext());
                        xf8.a("c14278", string2, string3, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
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
                        this.a.y0.c3(1);
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().l()) {
                        if (view2 == this.a.G0.h.f) {
                            if (!this.a.G0.j0(this.a.y0.Y0())) {
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
                            } else if (this.a.y0.l1() == null || this.a.B0.Z()) {
                                return;
                            } else {
                                this.a.G0.v0();
                                int i9 = (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().u()) ? (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().t()) ? view2 == this.a.G0.L0() ? 2 : 0 : this.a.y0.l1().Q().getIs_good() == 1 ? 3 : 6 : this.a.y0.l1().Q().getIs_top() == 1 ? 5 : 4;
                                ForumData l2 = this.a.y0.l1().l();
                                String name3 = l2.getName();
                                String id = l2.getId();
                                String id2 = this.a.y0.l1().Q().getId();
                                this.a.G0.p4();
                                this.a.B0.d0(id, name3, id2, i9, this.a.G0.M0());
                            }
                        } else if (view2 == this.a.G0.S0()) {
                            if (this.a.y0 != null) {
                                BrowserHelper.p(this.a.getPageContext().getPageActivity(), this.a.y0.l1().Q().getTopicData().b());
                            }
                        } else if (view2 == this.a.G0.h.c) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            if (this.a.y0.l1() != null && this.a.y0.l1().Q() != null && this.a.y0.l1().Q().isVideoThreadType() && this.a.y0.l1().Q().getThreadVideoInfo() != null) {
                                TiebaStatic.log(new StatisticItem("c11922"));
                            }
                            if (this.a.y0.getErrorNo() == 4) {
                                if (!StringUtils.isNull(this.a.y0.K0()) || this.a.y0.A0() == null) {
                                    this.a.a.finish();
                                    return;
                                }
                                name2 = this.a.y0.A0().b;
                            } else {
                                name2 = this.a.y0.l1().l().getName();
                            }
                            if (StringUtils.isNull(name2)) {
                                this.a.a.finish();
                                return;
                            }
                            String K0 = this.a.y0.K0();
                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                            if (!this.a.y0.Q0() || K0 == null || !K0.equals(name2)) {
                                this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                            } else {
                                this.a.a.finish();
                            }
                        } else if (view2 == this.a.G0.h.d) {
                            if (jo5.a()) {
                                return;
                            }
                            if (this.a.y0 == null || this.a.y0.l1() == null) {
                                ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                                return;
                            }
                            ArrayList<PostData> H = this.a.y0.l1().H();
                            if ((H == null || H.size() <= 0) && this.a.y0.D1()) {
                                ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.y0.F1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y0.getForumId()));
                            if (!this.a.G0.Z1()) {
                                this.a.G0.U2();
                            }
                            this.a.v6();
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09192b) {
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
                            this.a.y0.g3(this.a.x5());
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091902) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.G0.v0();
                            if (view2.getId() != R.id.obfuscated_res_0x7f091902 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                if (!xd8.c(this.a.getPageContext(), 11009) || this.a.y0.B0(this.a.G0.Y0()) == null) {
                                    return;
                                }
                                this.a.o6();
                                if (this.a.y0.l1() != null && this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.l1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getAuthor() != null && this.a.y0.l1().Q().getAuthor().getUserId() != null && this.a.A0 != null) {
                                    int w = xd8.w(this.a.y0.l1());
                                    ThreadData Q = this.a.y0.l1().Q();
                                    if (Q.isBJHArticleThreadType()) {
                                        i8 = 2;
                                    } else if (Q.isBJHVideoThreadType()) {
                                        i8 = 3;
                                    } else if (Q.isBJHNormalThreadType()) {
                                        i8 = 4;
                                    } else {
                                        i8 = Q.isBJHVideoDynamicThreadType() ? 5 : 1;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 1).param("obj_id", this.a.y0.l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", w).param("obj_param1", i8));
                                }
                            } else {
                                this.a.U = view2;
                                return;
                            }
                        } else if ((this.a.G0.h.o() != null && view2 == this.a.G0.h.o().q()) || view2.getId() == R.id.obfuscated_res_0x7f090aa3 || view2.getId() == R.id.obfuscated_res_0x7f091d1b) {
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
                            boolean h3 = view2.getId() == R.id.obfuscated_res_0x7f090aa3 ? this.a.y0.h3(true, this.a.x5()) : view2.getId() == R.id.obfuscated_res_0x7f091d1b ? this.a.y0.h3(false, this.a.x5()) : this.a.y0.g3(this.a.x5());
                            view2.setTag(Boolean.valueOf(h3));
                            if (h3) {
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
                                if (!xd8.c(this.a.getPageContext(), 11009)) {
                                    return;
                                }
                                xd8.x(this.a.getContext(), 3, this.a.t5(), this.a.y0);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091907 || view2.getId() == R.id.share_more_container) {
                                if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (l1 = this.a.y0.l1()) == null) {
                                    return;
                                }
                                ThreadData Q2 = l1.Q();
                                if (Q2 != null && Q2.getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", l1.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                    statisticItem3.param("tid", this.a.y0.F1());
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
                                        uj5.e(this.a.N(), statisticItem3);
                                    }
                                    if (this.a.G0 != null) {
                                        statisticItem3.param("obj_param1", this.a.G0.V0());
                                    }
                                    TiebaStatic.log(statisticItem3);
                                    if (ej.F()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d08);
                                        return;
                                    } else if (l1 == null) {
                                        ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                                        return;
                                    } else {
                                        ArrayList<PostData> H2 = this.a.y0.l1().H();
                                        if ((H2 == null || H2.size() <= 0) && this.a.y0.D1()) {
                                            ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                                            return;
                                        }
                                        this.a.G0.v0();
                                        this.a.l7();
                                        if (l1.B() != null && !StringUtils.isNull(l1.B().a(), true)) {
                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.y0.l1().m()));
                                        }
                                        TiebaStatic.log(new StatisticItem("c11939"));
                                        if (AntiHelper.e(this.a.getContext(), Q2)) {
                                            return;
                                        }
                                        if (this.a.G0 != null) {
                                            this.a.G0.x0();
                                            this.a.G0.w4(l1);
                                        }
                                        if (ShareSwitch.isOn()) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091907) {
                                                i2 = 2;
                                            } else {
                                                i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                            }
                                            if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.G0.b2() && !l1.q0()) {
                                                if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                    if (f95.c() > 0) {
                                                        xd8.G(this.a.getContext(), this.a.y0.l1());
                                                    } else {
                                                        int V0 = this.a.G0.V0();
                                                        this.a.G0.i0();
                                                        this.a.Y5(f95.a(), V0);
                                                    }
                                                } else {
                                                    this.a.f7(i2);
                                                }
                                            } else {
                                                this.a.f7(i2);
                                            }
                                        } else {
                                            this.a.G0.V3();
                                            this.a.y0.F0().I(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                        }
                                    }
                                }
                                i = 1;
                                StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem32.param("tid", this.a.y0.F1());
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
                                            this.a.G0.h.l();
                                        } else if (this.a.G0.W0() == view2) {
                                            if (!this.a.G0.W0().getIndicateStatus()) {
                                                p29.d("c10725", null);
                                            } else {
                                                v98 l12 = this.a.y0.l1();
                                                if (l12 != null && l12.Q() != null && l12.Q().getTaskInfoData() != null) {
                                                    String d = l12.Q().getTaskInfoData().d();
                                                    if (StringUtils.isNull(d)) {
                                                        d = l12.Q().getTaskInfoData().g();
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
                                            SparseArray<Object> a1 = this.a.G0.a1(this.a.y0.l1(), this.a.y0.D1(), 1);
                                            if (a1 == null) {
                                                return;
                                            }
                                            this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.l1().l().getId(), this.a.y0.l1().l().getName(), this.a.y0.l1().Q().getId(), StringUtils.string(this.a.y0.l1().X().getUserId()), StringUtils.string(a1.get(R.id.tag_forbid_user_name)), StringUtils.string(a1.get(R.id.tag_forbid_user_name_show)), StringUtils.string(a1.get(R.id.tag_forbid_user_post_id)), StringUtils.string(a1.get(R.id.tag_forbid_user_portrait)))));
                                        } else if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().k()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> a12 = this.a.G0.a1(this.a.y0.l1(), this.a.y0.D1(), 1);
                                            if (a12 != null) {
                                                this.a.G0.A2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
                                            }
                                            this.a.G0.h.k();
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
                                        } else if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().n()) {
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> a13 = this.a.G0.a1(this.a.y0.l1(), this.a.y0.D1(), 1);
                                            if (a13 != null) {
                                                if (StringUtils.isNull((String) a13.get(R.id.tag_del_multi_forum))) {
                                                    this.a.G0.x2(((Integer) a13.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a13.get(R.id.tag_del_post_id)), ((Integer) a13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a13.get(R.id.tag_del_post_is_self)).booleanValue());
                                                } else {
                                                    this.a.G0.y2(((Integer) a13.get(R.id.tag_del_post_type)).intValue(), (String) a13.get(R.id.tag_del_post_id), ((Integer) a13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a13.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(a13.get(R.id.tag_del_multi_forum)));
                                                }
                                            }
                                            this.a.G0.h.k();
                                        } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0920e6 && view2.getId() != R.id.obfuscated_res_0x7f09191b && view2.getId() != R.id.obfuscated_res_0x7f0917a5) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f09197d) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f09197b && view2.getId() != R.id.obfuscated_res_0x7f091b5b && view2.getId() != R.id.obfuscated_res_0x7f091915) {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091919) {
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
                                                            pbFragment2.M0 = new u05(pbFragment2.getContext());
                                                            this.a.M0.p(this.a.k2);
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
                                                                q05 q05Var8 = new q05(8, pbFragment.getString(i3), this.a.M0);
                                                                SparseArray sparseArray2 = new SparseArray();
                                                                sparseArray2.put(R.id.tag_clip_board, postData);
                                                                q05Var8.d.setTag(sparseArray2);
                                                                arrayList.add(q05Var8);
                                                            }
                                                            if (this.a.mIsLogin) {
                                                                if (!uf8.j(this.a.y0) && !booleanValue3 && booleanValue2) {
                                                                    q05 q05Var9 = new q05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bea), this.a.M0);
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
                                                                } else if ((xd8.C(this.a.y0.l1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                                    q05 q05Var10 = new q05(5, this.a.getString(R.string.report_text), this.a.M0);
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
                                                                            q05 q05Var11 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
                                                                            q05Var11.d.setTag(sparseArray4);
                                                                            q05Var2 = q05Var11;
                                                                            q05Var = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
                                                                            q05Var.d.setTag(sparseArray4);
                                                                        }
                                                                    } else {
                                                                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                    }
                                                                    q05Var2 = null;
                                                                    q05Var = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
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
                                                                    if (this.a.y0.l1().Y() == 1002 && !booleanValue) {
                                                                        q05Var3 = new q05(6, this.a.getString(R.string.report_text), this.a.M0);
                                                                    } else {
                                                                        q05Var3 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
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
                                                            this.a.M0.k(arrayList);
                                                            this.a.L0 = new s05(this.a.getPageContext(), this.a.M0);
                                                            this.a.L0.k();
                                                        }
                                                    } else if (view2 == this.a.G0.U0()) {
                                                        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                            this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, dh.g(this.a.y0.l1().m(), 0L), dh.g(this.a.y0.F1(), 0L), dh.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.y0.l1().Q().getPushStatusData())));
                                                        }
                                                    } else if (view2 == this.a.G0.h.p()) {
                                                        this.a.G0.J3();
                                                    } else if (this.a.G0.h.o() == null || view2 != this.a.G0.h.o().w()) {
                                                        if (this.a.G0.h.o() != null && view2 == this.a.G0.h.o().p()) {
                                                            TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                            if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.y0.F1())) != null) {
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                this.a.G0.h.k();
                                                                TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                            }
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0907d7 && view2.getId() != R.id.obfuscated_res_0x7f090aa0) {
                                                            int id3 = view2.getId();
                                                            if (id3 == R.id.pb_u9_text_view) {
                                                                if (!this.a.checkUpIsLogin() || (zz4Var = (zz4) view2.getTag()) == null || StringUtils.isNull(zz4Var.p1())) {
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{zz4Var.p1()});
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091d1e || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
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
                                                                        pbFragment3.M0 = new u05(pbFragment3.getContext());
                                                                        this.a.M0.p(this.a.k2);
                                                                    }
                                                                    ArrayList arrayList2 = new ArrayList();
                                                                    xd8.y(view2);
                                                                    if (xd8.y(view2) && this.a.l1 != null) {
                                                                        this.a.l1.t();
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
                                                                            q05 q05Var12 = new q05(3, this.a.getString(R.string.obfuscated_res_0x7f0f0478), this.a.M0);
                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                            sparseArray7.put(R.id.tag_clip_board, postData2);
                                                                            q05Var12.d.setTag(sparseArray7);
                                                                            arrayList2.add(q05Var12);
                                                                        }
                                                                        this.a.G2 = postData2;
                                                                    }
                                                                    if (this.a.y0.l1().r()) {
                                                                        String v = this.a.y0.l1().v();
                                                                        if (postData2 != null && !dj.isEmpty(v) && v.equals(postData2.O())) {
                                                                            z = true;
                                                                            if (!z) {
                                                                                q05Var4 = new q05(4, this.a.getString(R.string.remove_mark), this.a.M0);
                                                                            } else {
                                                                                q05Var4 = new q05(4, this.a.getString(R.string.obfuscated_res_0x7f0f0b46), this.a.M0);
                                                                            }
                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                            sparseArray8.put(R.id.tag_clip_board, this.a.G2);
                                                                            sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                            q05Var4.d.setTag(sparseArray8);
                                                                            arrayList2.add(q05Var4);
                                                                            if (this.a.mIsLogin) {
                                                                                if (!uf8.j(this.a.y0) && !booleanValue9 && booleanValue8) {
                                                                                    q05 q05Var13 = new q05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0bea), this.a.M0);
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
                                                                                } else if (xd8.C(this.a.y0.l1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                    q05 q05Var14 = new q05(5, this.a.getString(R.string.report_text), this.a.M0);
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
                                                                                            q05 q05Var15 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
                                                                                            q05Var15.d.setTag(sparseArray10);
                                                                                            q05Var6 = q05Var15;
                                                                                            q05Var5 = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
                                                                                            q05Var5.d.setTag(sparseArray10);
                                                                                        }
                                                                                    } else {
                                                                                        sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                    }
                                                                                    q05Var6 = null;
                                                                                    q05Var5 = new q05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.a.M0);
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
                                                                                    if (this.a.y0.l1().Y() == 1002 && !booleanValue7) {
                                                                                        q05Var7 = new q05(6, this.a.getString(R.string.report_text), this.a.M0);
                                                                                    } else {
                                                                                        q05Var7 = new q05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04d8), this.a.M0);
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
                                                                            this.a.M0.k(arrayList2);
                                                                            this.a.L0 = new s05(this.a.getPageContext(), this.a.M0);
                                                                            this.a.L0.k();
                                                                        }
                                                                    }
                                                                    z = false;
                                                                    if (!z) {
                                                                    }
                                                                    SparseArray sparseArray82 = new SparseArray();
                                                                    sparseArray82.put(R.id.tag_clip_board, this.a.G2);
                                                                    sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                    q05Var4.d.setTag(sparseArray82);
                                                                    arrayList2.add(q05Var4);
                                                                    if (this.a.mIsLogin) {
                                                                    }
                                                                    this.a.M0.k(arrayList2);
                                                                    this.a.L0 = new s05(this.a.getPageContext(), this.a.M0);
                                                                    this.a.L0.k();
                                                                }
                                                            } else if (id3 == R.id.pb_act_btn) {
                                                                if (this.a.y0.l1() != null && this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getActUrl() != null) {
                                                                    BrowserHelper.p(this.a.getActivity(), this.a.y0.l1().Q().getActUrl());
                                                                    if (this.a.y0.l1().Q().getActInfoType() == 1) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    } else if (this.a.y0.l1().Q().getActInfoType() == 2) {
                                                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.lottery_tail) {
                                                                if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                    String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                    TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.y0.l1().m()).param("tid", this.a.y0.l1().S()).param("lotterytail", StringUtils.string(string4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                    if (!this.a.y0.l1().S().equals(string4)) {
                                                                        this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string4, (String) null, (String) null, (String) null)));
                                                                    } else {
                                                                        this.a.G0.D3(0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091945 || id3 == R.id.obfuscated_res_0x7f09190f) {
                                                                if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                    String string5 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                    String s = p35.m().s("tail_link", "");
                                                                    String string6 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                    if (!StringUtils.isNull(s)) {
                                                                        TiebaStatic.log("c10056");
                                                                        BrowserHelper.t(view2.getContext(), string5, UtilHelper.urlAddParam(s, "page_from=1&tailSkinId=" + string6), true, true, true);
                                                                    }
                                                                    this.a.G0.U2();
                                                                    TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string6));
                                                                }
                                                            } else if (id3 == R.id.join_vote_tv) {
                                                                if (view2 != null) {
                                                                    BrowserHelper.p(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                    if (this.a.t5() == 1 && this.a.y0 != null && this.a.y0.l1() != null) {
                                                                        xg8.u("c10397", this.a.y0.l1().m(), this.a.y0.l1().S(), currentAccount);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.look_all_tv) {
                                                                if (view2 != null) {
                                                                    String string7 = StringUtils.string(view2.getTag());
                                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                    BrowserHelper.p(this.a.getActivity(), string7);
                                                                    if (this.a.t5() == 1 && this.a.y0 != null && this.a.y0.l1() != null) {
                                                                        xg8.u("c10507", this.a.y0.l1().m(), this.a.y0.l1().S(), currentAccount2);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0915a3) {
                                                                this.a.k6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0915a2) {
                                                                this.a.h6();
                                                            } else if (id3 == R.id.obfuscated_res_0x7f092845) {
                                                                if (this.a.y0 != null && this.a.y0.l1() != null && this.a.y0.l1().B() != null) {
                                                                    v98 l13 = this.a.y0.l1();
                                                                    TiebaStatic.log(new StatisticItem("c11679").param("fid", l13.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{l13.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f092842) {
                                                                if (this.a.y0 != null && this.a.y0.l1() != null && this.a.y0.l1().B() != null) {
                                                                    v98 l14 = this.a.y0.l1();
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", l14.m()));
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{l14.B().b()});
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09252e) {
                                                                if (this.a.q1 >= 0) {
                                                                    if (this.a.y0 != null) {
                                                                        this.a.y0.J2();
                                                                    }
                                                                    if (this.a.y0 == null || this.a.G0.J0() == null) {
                                                                        i6 = 0;
                                                                    } else {
                                                                        i6 = 0;
                                                                        this.a.G0.J0().h0(this.a.y0.l1(), false);
                                                                    }
                                                                    this.a.q1 = i6;
                                                                    if (this.a.y0 != null) {
                                                                        if (this.a.G0.Z0() != null) {
                                                                            this.a.G0.Z0().setSelection(this.a.y0.e1());
                                                                        }
                                                                        this.a.y0.N2(0, 0);
                                                                    }
                                                                }
                                                            } else if (id3 == R.id.qq_share_container) {
                                                                if (!xd8.c(this.a.getPageContext(), 11009)) {
                                                                    return;
                                                                }
                                                                xd8.x(this.a.getContext(), 8, this.a.t5(), this.a.y0);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f0917a5) {
                                                                SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                if (sparseArray12 == null) {
                                                                    return;
                                                                }
                                                                this.a.j7(sparseArray12);
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091904) {
                                                                if (this.a.G0.Z0() == null || this.a.y0 == null || this.a.y0.l1() == null) {
                                                                    return;
                                                                }
                                                                int firstVisiblePosition = this.a.G0.Z0().getFirstVisiblePosition();
                                                                View childAt = this.a.G0.Z0().getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                boolean y0 = this.a.y0.l1().y0();
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
                                                                xd8.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.y0.l1());
                                                                if ((this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getReply_num() <= 0) || (X1 && z6)) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    if (!this.a.checkUpIsLogin()) {
                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                        return;
                                                                    }
                                                                    this.a.z6();
                                                                    if (this.a.y0.l1().Q().getAuthor() != null) {
                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                                                        int d2 = we8.d(this.a.getListView());
                                                                        if (we8.e(this.a.getListView()) != -1) {
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
                                                                if (this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091969 || id3 == R.id.obfuscated_res_0x7f09196a) {
                                                                if (this.a.y0 == null || this.a.y0.l1() == null || this.a.y0.l1().l() == null || dj.isEmpty(this.a.y0.l1().l().getName())) {
                                                                    return;
                                                                }
                                                                if (this.a.y0.getErrorNo() == 4) {
                                                                    if (!StringUtils.isNull(this.a.y0.K0()) || this.a.y0.A0() == null) {
                                                                        this.a.a.finish();
                                                                        return;
                                                                    }
                                                                    name = this.a.y0.A0().b;
                                                                } else {
                                                                    name = this.a.y0.l1().l().getName();
                                                                }
                                                                if (StringUtils.isNull(name)) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                String K02 = this.a.y0.K0();
                                                                if (!this.a.y0.Q0() || K02 == null || !K02.equals(name)) {
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.y0.l1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                } else {
                                                                    this.a.a.finish();
                                                                }
                                                                StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                statisticItem6.param("tid", this.a.y0.F1());
                                                                statisticItem6.param("fid", this.a.y0.getForumId());
                                                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                if (this.a.y0.l1().Q() != null) {
                                                                    statisticItem6.param("nid", this.a.y0.l1().Q().getNid());
                                                                }
                                                                TiebaStatic.log(statisticItem6);
                                                            } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                                if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                    if (this.a.y0 == null) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                    statisticItem7.param("tid", this.a.y0.F1());
                                                                    statisticItem7.param("fid", this.a.y0.getForumId());
                                                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem7.param("obj_locate", 2);
                                                                    TiebaStatic.log(statisticItem7);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091990) {
                                                                    if (this.a.y0 == null || this.a.y0.l1() == null) {
                                                                        return;
                                                                    }
                                                                    v98 l15 = this.a.y0.l1();
                                                                    if (this.a.D0 == null) {
                                                                        PbFragment pbFragment4 = this.a;
                                                                        pbFragment4.D0 = new na8(pbFragment4.getPageContext());
                                                                    }
                                                                    long g2 = dh.g(l15.S(), 0L);
                                                                    long g3 = dh.g(l15.m(), 0L);
                                                                    xg8.w("c13446", g3);
                                                                    PbFragment pbFragment5 = this.a;
                                                                    pbFragment5.registerListener(pbFragment5.r2);
                                                                    this.a.D0.a(g2, g3);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0919b5) {
                                                                    if (view2.getTag() instanceof SmartApp) {
                                                                        SmartApp smartApp = (SmartApp) view2.getTag();
                                                                        if (!qz5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                            if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                return;
                                                                            }
                                                                            BrowserHelper.p(this.a.getActivity(), smartApp.h5_url);
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.y0.F1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090f21) {
                                                                    if (!(view2.getTag() instanceof ThreadData)) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f090f1e) {
                                                                    if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                        return;
                                                                    }
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.Q != null) {
                                                                        this.a.Q.Y(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09191d || id3 == R.id.obfuscated_res_0x7f091975) {
                                                                    if (this.a.s0) {
                                                                        return;
                                                                    }
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.y0.F1());
                                                                    statisticItem8.param("fid", this.a.y0.getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                    if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                        xg8.s(6);
                                                                    }
                                                                    PbFragment pbFragment6 = this.a;
                                                                    pbFragment6.b = false;
                                                                    pbFragment6.g5(view2);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09254c) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        xg8.s(5);
                                                                    }
                                                                    this.a.N6(false);
                                                                    this.a.k7((PostData) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                }
                                                            } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                return;
                                                            } else {
                                                                ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                if (this.a.y0.k1() != 3 || !this.a.v0() || this.a.y0.l1() == null || !ListUtils.isEmpty(this.a.y0.l1().p())) {
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
                                                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907d8);
                                                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907d9);
                                                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090aa0);
                                                            if (postData3.v0()) {
                                                                postData3.W0(false);
                                                                vf8.e(postData3);
                                                            } else if (this.a.M() != null ? vf8.c(this.a.M().l1(), postData3) : false) {
                                                                postData3.W0(true);
                                                            }
                                                            SkinManager.setBackgroundColor(findViewById, postData3.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                            SkinManager.setViewTextColor(eMTextView, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                            WebPManager.setPureDrawable(imageView, postData3.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData3.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        }
                                                    } else {
                                                        this.a.G0.h.l();
                                                        this.a.G0.c4(this.a.J2);
                                                    }
                                                } else if (this.a.y0 == null) {
                                                    return;
                                                } else {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09197b) {
                                                        StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                        statisticItem10.param("tid", this.a.y0.F1());
                                                        statisticItem10.param("fid", this.a.y0.getForumId());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("obj_locate", 6);
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091b5b) {
                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                            this.a.T = view2;
                                                            return;
                                                        }
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09197b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
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
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09197b && (statisticItem = postData4.e0) != null) {
                                                        StatisticItem copy = statisticItem.copy();
                                                        copy.delete("obj_locate");
                                                        copy.param("obj_locate", 8);
                                                        TiebaStatic.log(copy);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091b5b || view2.getId() == R.id.obfuscated_res_0x7f091915) {
                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.y0.G1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.O()).param("obj_source", 1).param("obj_type", 3));
                                                    }
                                                    if (this.a.y0 == null || this.a.y0.l1() == null || this.a.K5().i1() == null || postData4.r() == null || postData4.F() == 1) {
                                                        return;
                                                    }
                                                    if (this.a.K5().j1() != null) {
                                                        this.a.K5().j1().g();
                                                    }
                                                    la8 la8Var = new la8();
                                                    la8Var.A(this.a.y0.l1().l());
                                                    la8Var.E(this.a.y0.l1().Q());
                                                    la8Var.C(postData4);
                                                    this.a.K5().i1().c0(la8Var);
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
                                                statisticItem11.param("tid", this.a.y0.F1());
                                                statisticItem11.param("fid", this.a.y0.getForumId());
                                                statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem11.param("obj_locate", 5);
                                                TiebaStatic.log(statisticItem11);
                                                if (view2.getId() != R.id.obfuscated_res_0x7f09197d || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
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
                                                    if (this.a.y0 == null || this.a.y0.l1() == null) {
                                                        return;
                                                    }
                                                    String F1 = this.a.y0.F1();
                                                    String O = postData5.O();
                                                    int Y = this.a.y0.l1() != null ? this.a.y0.l1().Y() : 0;
                                                    AbsPbActivity.e A6 = this.a.A6(O);
                                                    if (A6 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F1, O, "pb", true, false, null, false, null, Y, postData5.g0(), this.a.y0.l1().d(), false, postData5.r().getIconInfo(), 5).addBigImageData(A6.a, A6.b, A6.g, A6.j);
                                                    addBigImageData.setKeyPageStartFrom(this.a.y0.k1());
                                                    addBigImageData.setFromFrsForumId(this.a.y0.getFromForumId());
                                                    addBigImageData.setWorksInfoData(this.a.y0.K1());
                                                    addBigImageData.setKeyFromForumId(this.a.y0.getForumId());
                                                    addBigImageData.setTiebaPlusData(this.a.y0.P(), this.a.y0.L(), this.a.y0.M(), this.a.y0.K(), this.a.y0.Q());
                                                    addBigImageData.setBjhData(this.a.y0.D0());
                                                    if (this.a.y0.l1().o() != null) {
                                                        addBigImageData.setHasForumRule(this.a.y0.l1().o().has_forum_rule.intValue());
                                                    }
                                                    if (this.a.y0.l1().X() != null) {
                                                        addBigImageData.setIsManager(this.a.y0.l1().X().getIs_manager());
                                                    }
                                                    if (this.a.y0.l1().l().getDeletedReasonInfo() != null) {
                                                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.y0.l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.y0.l1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                    }
                                                    if (this.a.y0.l1().l() != null) {
                                                        addBigImageData.setForumHeadUrl(this.a.y0.l1().l().getImage_url());
                                                        addBigImageData.setUserLevel(this.a.y0.l1().l().getUser_level());
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
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0917a5) {
                                                StatisticItem statisticItem13 = new StatisticItem("c13398");
                                                statisticItem13.param("tid", this.a.y0.F1());
                                                statisticItem13.param("fid", this.a.y0.getForumId());
                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem13.param("obj_locate", 4);
                                                TiebaStatic.log(statisticItem13);
                                            }
                                            if (view2.getId() != R.id.obfuscated_res_0x7f09191b || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (!this.a.checkUpIsLogin()) {
                                                    xg8.r("c10517", this.a.y0.l1().m(), 3);
                                                    return;
                                                } else if (this.a.y0 == null || this.a.y0.l1() == null) {
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
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0917a5) {
                                                            copy3.param("obj_locate", 6);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09191b) {
                                                            copy3.param("obj_locate", 8);
                                                        }
                                                        TiebaStatic.log(copy3);
                                                    }
                                                    String F12 = this.a.y0.F1();
                                                    String O2 = postData6.O();
                                                    String O3 = postData7 != null ? postData7.O() : "";
                                                    int Y2 = this.a.y0.l1() != null ? this.a.y0.l1().Y() : 0;
                                                    this.a.l7();
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091d1e) {
                                                        TiebaStatic.log("c11742");
                                                        AbsPbActivity.e A62 = this.a.A6(O2);
                                                        if (postData6 == null || this.a.y0 == null || this.a.y0.l1() == null || A62 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F12, O2, "pb", true, false, null, false, O3, Y2, postData6.g0(), this.a.y0.l1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(A62.a, A62.b, A62.g, A62.j);
                                                        if (!dj.isEmpty(O3)) {
                                                            addBigImageData2.setHighLightPostId(O3);
                                                            addBigImageData2.setKeyIsUseSpid(true);
                                                        }
                                                        addBigImageData2.setKeyFromForumId(this.a.y0.getForumId());
                                                        addBigImageData2.setTiebaPlusData(this.a.y0.P(), this.a.y0.L(), this.a.y0.M(), this.a.y0.K(), this.a.y0.Q());
                                                        addBigImageData2.setBjhData(this.a.y0.D0());
                                                        addBigImageData2.setKeyPageStartFrom(this.a.y0.k1());
                                                        addBigImageData2.setFromFrsForumId(this.a.y0.getFromForumId());
                                                        addBigImageData2.setWorksInfoData(this.a.y0.K1());
                                                        if (this.a.G0 != null && this.a.y0.G != null && (Z = this.a.y0.G.Z()) != null) {
                                                            addBigImageData2.setMainPostMaskVisibly(Z.S || postData6.S);
                                                        }
                                                        if (this.a.y0.l1() != null && this.a.y0.l1().o() != null) {
                                                            addBigImageData2.setHasForumRule(this.a.y0.l1().o().has_forum_rule.intValue());
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    } else {
                                                        AbsPbActivity.e A63 = this.a.A6(O2);
                                                        if (this.a.y0 == null || this.a.y0.l1() == null || A63 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(F12, O2, "pb", true, false, null, true, null, Y2, postData6.g0(), this.a.y0.l1().d(), false, postData6.r().getIconInfo(), 5).addBigImageData(A63.a, A63.b, A63.g, A63.j);
                                                        addBigImageData3.setKeyPageStartFrom(this.a.y0.k1());
                                                        addBigImageData3.setFromFrsForumId(this.a.y0.getFromForumId());
                                                        addBigImageData3.setWorksInfoData(this.a.y0.K1());
                                                        addBigImageData3.setKeyFromForumId(this.a.y0.getForumId());
                                                        addBigImageData3.setBjhData(this.a.y0.D0());
                                                        addBigImageData3.setTiebaPlusData(this.a.y0.P(), this.a.y0.L(), this.a.y0.M(), this.a.y0.K(), this.a.y0.Q());
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                    }
                                                }
                                            } else {
                                                this.a.S = view2;
                                                return;
                                            }
                                        }
                                    } else if (this.a.y0 == null || this.a.y0.l1() == null || this.a.y0.l1().Q() == null) {
                                        return;
                                    } else {
                                        this.a.G0.h.k();
                                        TiebaStatic.log(new StatisticItem("c13062"));
                                        PbFragment pbFragment7 = this.a;
                                        pbFragment7.U5(pbFragment7.y0.l1().Q().getFirstPostId());
                                    }
                                } else {
                                    this.a.G0.v0();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.h) {
                                        view2.setTag(Integer.valueOf(this.a.y0.B1()));
                                        return;
                                    } else {
                                        this.a.l7();
                                        this.a.G0.z3();
                                        s05 s05Var = new s05(this.a.getPageContext());
                                        if (this.a.y0.l1().f == null || this.a.y0.l1().f.size() <= 0) {
                                            strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                        } else {
                                            strArr = new String[this.a.y0.l1().f.size()];
                                            for (int i12 = 0; i12 < this.a.y0.l1().f.size(); i12++) {
                                                strArr[i12] = this.a.y0.l1().f.get(i12).sort_name + this.a.getResources().getString(R.string.sort_static);
                                            }
                                        }
                                        s05Var.i(null, strArr, new a(this, s05Var, view2));
                                        s05Var.k();
                                    }
                                }
                            } else {
                                this.a.G0.v0();
                                if (this.a.M().l1().g == 2) {
                                    this.a.showToast(R.string.hot_sort_jump_hint);
                                    return;
                                }
                                if (this.a.y0.j1() != null) {
                                    this.a.G0.j4(this.a.y0.j1(), this.a.i2);
                                }
                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            }
                        } else {
                            this.a.G0.h.k();
                        }
                    } else {
                        this.a.G0.h.l();
                        if (this.a.y0 != null) {
                            this.a.v1.f(this.a.y0.F1());
                        }
                        if (this.a.y0 != null && this.a.y0.isPrivacy()) {
                            this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                            if (this.a.M() == null || this.a.M().l1() == null) {
                                return;
                            }
                            this.a.v1.d(3, 3, this.a.M().l1().S());
                            return;
                        }
                        this.a.v1.b();
                        int i13 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().S() == null || !this.a.M().l1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                        if (this.a.M() != null && this.a.M().l1() != null) {
                            this.a.v1.d(3, i13, this.a.M().l1().S());
                        }
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e9f).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091d0e) {
                        String w5 = this.a.w5();
                        if (TextUtils.isEmpty(w5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{w5});
                    }
                } else if (!this.a.s0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.y0.F1());
                    statisticItem15.param("fid", this.a.y0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                        xg8.s(2);
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
                        if (this.a.y0 != null && this.a.y0.l1() != null && this.a.K5().i1() != null && postData8.r() != null && postData8.F() != 1) {
                            if (!this.a.checkUpIsLogin()) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                return;
                            }
                            if (this.a.K5().j1() != null) {
                                this.a.K5().j1().g();
                            }
                            la8 la8Var2 = new la8();
                            la8Var2.A(this.a.y0.l1().l());
                            la8Var2.E(this.a.y0.l1().Q());
                            la8Var2.C(postData8);
                            this.a.K5().i1().c0(la8Var2);
                            this.a.K5().i1().setPostId(postData8.O());
                            this.a.l6(view2, postData8.r().getUserId(), "", postData8);
                            TiebaStatic.log("c11743");
                            xg8.b(this.a.y0.l1(), postData8, postData8.d0, 8, 1);
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
        public class a implements u05.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s05 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ m1 c;

            public a(m1 m1Var, s05 s05Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var, s05Var, view2};
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
                this.a = s05Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.y0.C1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.u05.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void J0(u05 u05Var, int i, View view2) {
                boolean i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i4 = 0;
                    if (this.c.a.y0.C1() != 1 || i != 1) {
                        if (this.c.a.y0.C1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.y0.C1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f09198b) {
                            i4 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i4).param("obj_type", i2));
                        if (this.c.a.y0.l1().f != null && this.c.a.y0.l1().f.size() > i) {
                            i = this.c.a.y0.l1().f.get(i).sort_type.intValue();
                        }
                        i3 = this.c.a.y0.i3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.y0.B1()));
                        if (i3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.G0.n3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f09198b) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i4).param("obj_type", i2));
                    if (this.c.a.y0.l1().f != null) {
                        i = this.c.a.y0.l1().f.get(i).sort_type.intValue();
                    }
                    i3 = this.c.a.y0.i3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.y0.B1()));
                    if (i3) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.G0 != null && this.a != null) {
                    this.b.a.G0.F2(this.a.getmAdverSegmentData(), 2);
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
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0.l1() != null) {
                        statisticItem.param("fid", this.a.y0.l1().m());
                    }
                    statisticItem.param("tid", this.a.y0.F1());
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
                    this.a.E0.n0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    gh.a().postDelayed(this.a.Z1, 300000L);
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
                        j05 j05Var = new j05(this.a.getActivity());
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            j05Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new b(this));
                        j05Var.setPositiveButton(R.string.open_now, new c(this));
                        j05Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (o99.d(i) || a85Var != null || i == 227001) {
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
                        this.a.G0.N1(this.a.y0.l1());
                    }
                } else if (this.a.y0.O0()) {
                    v98 l1 = this.a.y0.l1();
                    if (l1 != null && l1.Q() != null && l1.Q().getAuthor() != null && (userId = l1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.y0.f3()) {
                        this.a.G0.z3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.y0.f3()) {
                    this.a.G0.z3();
                }
                if (this.a.y0.S0()) {
                    xg8.p("c10369", this.a.y0.F1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.y0 != null) {
                    Context context = this.a.getContext();
                    v98 l12 = this.a.y0.l1();
                    String forumId = this.a.y0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    xd8.a(context, l12, forumId, z2, this.a.y0.q1(), this.a.y0.t1(), this.a.y0.s1(), this.a.y0.r1(), this.a.y0.x1(), this.a.y0.y1());
                }
                if (writeData != null) {
                    k55.b(writeData.getContent(), "1");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.G0 != null && this.a != null) {
                    this.b.a.G0.F2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0 != null && this.a.y0.l1() != null) {
                        statisticItem.param("fid", this.a.y0.l1().m());
                    }
                    if (this.a.y0 != null) {
                        statisticItem.param("tid", this.a.y0.F1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.C5()) {
                        this.a.N6(false);
                        z88.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12eb));
                    }
                    ce8 ce8Var = this.a.K0;
                    if (ce8Var != null) {
                        ce8Var.d();
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
                    j05 j05Var = new j05(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        j05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new b(this));
                    j05Var.setPositiveButton(R.string.open_now, new c(this));
                    j05Var.create(this.a.getPageContext()).show();
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
                g45 g45Var = new g45();
                g45Var.b = R.raw.lottie_bubble_breath_tip;
                g45Var.a = BreatheTipWidget.PointType.LOTTIE;
                g45Var.c = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                h45 h45Var = new h45();
                h45Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f0531);
                h45Var.b = this.a.a.getString(R.string.agree_tip_content);
                h45Var.e = R.drawable.pic_guidecard;
                h45Var.f = ej.g(this.a.a.getContext(), R.dimen.tbds156);
                h45Var.g = ej.g(this.a.a.getContext(), R.dimen.tbds489);
                h45Var.h = ej.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.G0.n1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.G0.n1()));
                breatheTipWidget.f(h45Var, g45Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    p35 m = p35.m();
                    m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    l95.a("c14828");
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
        public void b(v98 v98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v98Var) == null) {
                this.a.G0.N1(v98Var);
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
            rk5 rk5Var = new rk5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            rk5Var.c();
            if (z2) {
                j3 = j4;
                rk5Var.B = j3;
                rk5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.y0 != null && this.a.y0.l1() != null && this.a.y0.l1().Q() != null) {
                int threadType = this.a.y0.l1().Q().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        nk5 nk5Var = new nk5();
                        nk5Var.F = 1;
                        nk5Var.a(1005);
                        nk5Var.D = j3;
                        nk5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        rk5 rk5Var2 = new rk5();
                        rk5Var2.a(1000);
                        rk5Var2.D = j3;
                        rk5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, v98 v98Var, String str, int i4) {
            ArrayList<PostData> arrayList;
            int i5;
            sb5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), v98Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090718));
                }
                if (z && v98Var != null && v98Var.a0() == null && ListUtils.getCount(v98Var.H()) < 1) {
                    this.a.y0.c3(1);
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
                    this.a.M().s0();
                }
                this.a.g = true;
                if (this.a.G0 == null) {
                    return;
                }
                this.a.G0.y3();
                if (v98Var == null || !v98Var.t0()) {
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
                if (i4 == 0 && v98Var != null) {
                    this.a.O0 = true;
                }
                if (v98Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.G0.t1());
                    this.a.G0.I3();
                }
                String str2 = null;
                if (z && v98Var != null) {
                    ThreadData Q = v98Var.Q();
                    if (Q != null && Q.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.Q6(pbFragment3.U0);
                    }
                    this.a.G0.j1().r(v98Var);
                    this.a.G0.U3();
                    if (Q != null && Q.getCartoonThreadData() != null) {
                        this.a.s7(Q.getCartoonThreadData());
                    }
                    if (this.a.V0 != null) {
                        this.a.G0.c3(this.a.V0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(v98Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(v98Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(v98Var.X().getBimg_end_time());
                    if (v98Var.H() != null && v98Var.H().size() >= 1 && v98Var.H().get(0) != null) {
                        this.a.y0.O2(v98Var.H().get(0).O());
                    } else if (v98Var.a0() != null) {
                        this.a.y0.O2(v98Var.a0().O());
                    }
                    if (this.a.V0 != null) {
                        this.a.V0.H(v98Var.d());
                        this.a.V0.I(v98Var.l(), v98Var.X());
                        this.a.V0.k0(Q);
                        this.a.V0.J(this.a.y0.N0(), this.a.y0.F1(), this.a.y0.J0());
                        if (Q != null) {
                            this.a.V0.Z(Q.isMutiForumThread());
                        }
                    }
                    if (this.a.A0 != null) {
                        this.a.A0.h(v98Var.r());
                    }
                    if (v98Var.s() == 1) {
                        this.a.r = true;
                    } else {
                        this.a.r = false;
                    }
                    if (v98Var.l0()) {
                        this.a.r = true;
                    }
                    this.a.G0.d3(this.a.r);
                    if (this.a.u0.f.size() > 0) {
                        v98Var.S0(this.a.u0.f);
                    }
                    this.a.G0.Y3(v98Var, i2, i3, this.a.y0.D1(), i4, this.a.y0.U0());
                    this.a.G0.n4(v98Var, this.a.y0.D1());
                    this.a.G0.s4(this.a.y0.O0());
                    AntiData d = v98Var.d();
                    if (d != null) {
                        this.a.y = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.V0 != null && this.a.V0.b() != null && (o = this.a.V0.b().o(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) o).setOnClickListener(this.a.I1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.y0.l1().H()) && !this.a.y0.Z1()) {
                        this.a.X = true;
                        this.a.Z4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.R0)) {
                        we8.i(this.a.y0.k1(), this.a.getListView(), this.a.R0);
                        this.a.R0 = null;
                    } else if (this.a.Q0) {
                        this.a.Q0 = false;
                        we8.g(this.a.getListView());
                    } else if (this.a.S0) {
                        this.a.S0 = false;
                        we8.j(this.a.getListView());
                    } else if (!TextUtils.isEmpty(this.a.y0.b1())) {
                        we8.f(this.a.getListView(), this.a.y0.b1());
                        this.a.y0.h2();
                    } else {
                        this.a.G0.T3();
                    }
                    this.a.y0.i2(v98Var.l(), this.a.O1);
                    this.a.y0.o2(this.a.Q1);
                    if (this.a.Y0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.Y0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.y0 != null && this.a.y0.W1()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.G0 != null) {
                        str2 = this.a.G0.l1();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.V0.c0(TbSingleton.getInstance().getAdVertiComment(v98Var.r0(), v98Var.s0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.O0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.y0.A0() != null && !StringUtils.isNull(this.a.y0.A0().c)) {
                                    this.a.G0.u4(this.a.y0.A0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.G0.t1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    uw8.a("pb", false);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.G0.t1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                uw8.a("pb", false);
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
                            jSONObject.put("tid", this.a.y0.F1());
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
                        if (this.a.y0 != null && this.a.y0.l1() != null) {
                            arrayList = this.a.y0.l1().H();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                            this.a.G0.Y2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.f6()) {
                                this.a.G0.Z2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eaf));
                            } else {
                                this.a.G0.Z2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eb0));
                            }
                            this.a.G0.N1(this.a.y0.l1());
                        }
                    } else {
                        this.a.G0.Y2("");
                    }
                    this.a.G0.D0();
                }
                if (v98Var != null && v98Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (!this.a.M().D1() || this.a.M().l1().z().c() != 0 || this.a.M().T1()) {
                    this.a.W0 = true;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (v98Var != null) {
                        i5 = v98Var.g();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.Z1(i5, this.a.G0);
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
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.y0 == null) {
                return;
            }
            if (this.a.V0 != null && this.a.V0.t) {
                return;
            }
            nd5 nd5Var = new nd5();
            this.a.Q6(nd5Var);
            PbFragment pbFragment = this.a;
            pbFragment.V0 = (od5) nd5Var.a(pbFragment.getContext());
            this.a.V0.W(this.a.a.getPageContext());
            this.a.V0.f0(this.a.o2);
            this.a.V0.g0(this.a.b1);
            od5 od5Var = this.a.V0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            od5Var.A(pageContext, extras);
            this.a.V0.b().E(true);
            this.a.G0.X2(this.a.V0.b());
            if (!this.a.y0.Y0()) {
                this.a.V0.q(this.a.y0.F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.y0.W1()) {
                this.a.V0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.G0 != null) {
                this.a.V0.c0(this.a.G0.l1());
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
            j29 i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && this.a.y0.l1() != null) {
                String str = (String) customResponsedMessage.getData();
                j29 j29Var = null;
                if (!TextUtils.isEmpty(str) && this.a.y0.l1().H() != null) {
                    ArrayList<PostData> H = this.a.y0.l1().H();
                    Iterator<PostData> it = H.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (next instanceof j29) {
                            j29 j29Var2 = (j29) next;
                            if (str.equals(j29Var2.q1())) {
                                j29Var = j29Var2;
                                break;
                            }
                        }
                    }
                    if (j29Var != null) {
                        H.remove(j29Var);
                    }
                }
                if (this.a.G0.J0() != null && !ListUtils.isEmpty(this.a.G0.J0().t())) {
                    ArrayList<Cdo> t = this.a.G0.J0().t();
                    if (j29Var != null) {
                        i = j29Var;
                    } else {
                        i = xd8.i(this.a.y0.l1(), str);
                    }
                    xd8.e(t, i);
                }
                if (this.a.G0.Z0() != null && !ListUtils.isEmpty(this.a.G0.Z0().getData())) {
                    List<Cdo> data = this.a.G0.Z0().getData();
                    if (j29Var == null) {
                        j29Var = xd8.i(this.a.y0.l1(), str);
                    }
                    xd8.e(data, j29Var);
                }
                this.a.i5(str);
                this.a.y0.Q1();
                if (this.a.G0.J0() != null) {
                    this.a.G0.J0().Z();
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
                this.a.K5().r2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements Comparator<ea5> {
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
    public class b implements yi6.b {
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

        @Override // com.baidu.tieba.yi6.b
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

        @Override // com.baidu.tieba.yi6.b
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
                this.a.p1 = true;
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
    public static class c implements zi6.b {
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

        @Override // com.baidu.tieba.zi6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    wa8.d();
                } else {
                    wa8.c();
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
        public void a(af8 af8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, af8Var) != null) || af8Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, af8Var.c()));
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
    public class c2 extends w9 {
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
                        this.a.y0.Q1();
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
    public class d implements oc8.b {
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

        @Override // com.baidu.tieba.oc8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f15f7);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d08);
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
    public class d1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.a.W5();
                ty4 j1 = this.a.y0.j1();
                int g1 = this.a.G0.g1();
                if (g1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0eb2);
                } else if (j1 != null && g1 > j1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0eb2);
                } else {
                    this.a.G0.v0();
                    this.a.l7();
                    this.a.G0.z3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.y0.c3(this.a.G0.g1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d08);
                    }
                    j05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) && j05Var != null) {
                j05Var.dismiss();
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
                if (!this.a.f && z && !this.a.y0.a1()) {
                    this.a.G6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(ej.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
            }
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
                if (Build.VERSION.SDK_INT < 11) {
                    j05Var.dismiss();
                    ((TbPageContext) this.a.g1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                j05Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.g1.getPageActivity(), 2, true, 4);
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
                String valueOf = String.valueOf(this.a.y0.l1().X().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.l1().l().getId(), this.a.y0.l1().l().getName(), this.a.y0.l1().Q().getId(), valueOf, str, str3, str2, str4)));
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
    public class e3 implements vg<LinearLayout> {
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
            this.a.R1 = false;
            if (this.a.S1 != null && str != null) {
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
                this.a.R1 = false;
                if (this.a.S1 == null) {
                    return;
                }
                v98 l1 = this.a.y0.l1();
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
    public class f1 implements u05.f {
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

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
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
                                            if (this.a.l1 != null && !TextUtils.isEmpty(this.a.m1)) {
                                                if (this.a.o1 != null) {
                                                    ne5.a aVar = new ne5.a();
                                                    aVar.a = this.a.m1;
                                                    String str = "";
                                                    if (this.a.o1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.o1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.X4();
                                                }
                                                this.a.l1 = null;
                                                this.a.m1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.l1 != null && !TextUtils.isEmpty(this.a.m1)) {
                                                if (this.a.X0 == null) {
                                                    this.a.X0 = new PermissionJudgePolicy();
                                                }
                                                this.a.X0.clearRequestPermissionList();
                                                this.a.X0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.X0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.k1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.k1 = new ee8(pbFragment.getPageContext());
                                                }
                                                this.a.k1.b(this.a.m1, this.a.l1.n());
                                                this.a.l1 = null;
                                                this.a.m1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.G2;
                                            if (postData != null) {
                                                postData.H0();
                                                this.a.G2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.p6(view2);
                                            if (this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getAuthor() != null && this.a.y0.l1().Q().getAuthor().getUserId() != null && this.a.A0 != null) {
                                                int w = xd8.w(this.a.y0.l1());
                                                ThreadData Q = this.a.y0.l1().Q();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 2).param("obj_id", this.a.y0.l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", w).param("obj_param1", i2));
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
                                            if (postData2.p() == null) {
                                                return;
                                            }
                                            this.a.e5(postData2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.y0 != null && this.a.y0.l1() != null) {
                                                this.a.a.S1(o99.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.y0 != null && this.a.y0.l1() != null) {
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
    public class f2 implements y35.g {
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

        @Override // com.baidu.tieba.y35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.B5()) {
                    this.a.a.finish();
                }
                if (this.a.y0.n2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.G0.E0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f3 implements fd8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.fd8.b
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

        @Override // com.baidu.tieba.fd8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.G0.o4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
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
                this.a.G0.k4(!this.a.N);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                if (j05Var != null) {
                    j05Var.dismiss();
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
                if (this.a.y0.n2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.G0.E0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                this.b.G0.V3();
                MessageManager.getInstance().sendMessage(this.a);
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements ff8.h {
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

        @Override // com.baidu.tieba.ff8.h
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
    public class h1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
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
                if (this.a.B2 && this.a.B5()) {
                    this.a.h6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.f0 && this.a.G0 != null && this.a.G0.k0() && this.a.y0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.y0.F1());
                    statisticItem.param("fid", this.a.y0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.y0.Q0()) {
                        i = 4;
                    } else if (this.a.y0.R0()) {
                        i = 3;
                    } else if (this.a.y0.T0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.y0.j2(false)) {
                    this.a.G0.A3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if ((this.a.u0 == null || !this.a.y0.d2() || !this.a.u0.d()) && this.a.y0.l1() != null) {
                    this.a.G0.P2();
                }
                this.a.B2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<zd8> a;
        public WeakReference<PbFragment> b;

        public h3(zd8 zd8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zd8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(zd8Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                zd8 zd8Var = this.a.get();
                if (zd8Var != null) {
                    zd8Var.z1();
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
                        j77.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0d08);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements u05.f {
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

        @Override // com.baidu.tieba.u05.f
        public void J0(u05 u05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, u05Var, i, view2) == null) {
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
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.i1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.i1);
                    this.e.h7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements y17.d {
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
                    if (this.a.V0 != null && this.a.V0.b() != null) {
                        this.a.V0.b().C(new lb5(45, 27, null));
                    }
                    this.a.G0.m0();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y0 != null) {
                this.a.y0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends kp5<ShareItem> {
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
        @Override // com.baidu.tieba.kp5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.Q2(this.a);
                }
                return wf8.d(this.b.t5(), 2, M);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.V2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().r() != null && this.a.u5().r().getGodUserData() != null) {
                        this.a.u5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.y0 != null && this.a.y0.l1() != null && this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getAuthor() != null) {
                        this.a.y0.l1().Q().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
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
                    if (this.a.y0.l1() != null && this.a.y0.l1().f != null && this.a.y0.l1().f.size() > i) {
                        int intValue = this.a.y0.l1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.y0.G1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.y0.i3(intValue)) {
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
    public class j2 implements kd5 {
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

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ce8 ce8Var = this.a.K0;
                if (ce8Var != null && ce8Var.g() != null && this.a.K0.g().d()) {
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
    public class k0 extends mh5<TipEvent> {
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
    public class l implements oo5<ShareItem> {
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
    public class l0 extends mh5<TopToastEvent> {
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
        @Override // com.baidu.tieba.fh5
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
    public class l2 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ j05 c;
        public final /* synthetic */ PbFragment d;

        public l2(PbFragment pbFragment, MarkData markData, MarkData markData2, j05 j05Var) {
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
            this.a.y0.k3((UserPendantData) customResponsedMessage.getData());
            if (this.a.G0 != null && this.a.y0 != null) {
                this.a.G0.N2(this.a.y0.l1(), this.a.y0.D1(), this.a.y0.v1(), this.a.G0.p1());
            }
            if (this.a.G0 != null && this.a.G0.J0() != null) {
                this.a.G0.J0().Z();
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
            zd8 zd8Var = this.b.G0;
            zd8Var.C3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ j05 b;
        public final /* synthetic */ PbFragment c;

        public m2(PbFragment pbFragment, MarkData markData, j05 j05Var) {
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
                    this.a.V0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.G0 != null && this.a.G0.j1() != null && this.a.G0.j1().f() != null) {
                    this.a.G0.j1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements ld5 {
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

        @Override // com.baidu.tieba.ld5
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
        public final /* synthetic */ j05 b;
        public final /* synthetic */ PbFragment c;

        public n2(PbFragment pbFragment, MarkData markData, j05 j05Var) {
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
            if (this.a.V0 != null) {
                this.a.G0.c3(this.a.V0.y());
            }
            this.a.G0.N3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends w9 {
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

        @Override // com.baidu.tieba.w9
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.y0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.y0.b)) {
                return;
            }
            this.a.e7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements vg<ImageView> {
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
                b98 b98Var = (b98) customResponsedMessage.getData();
                int type = b98Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (b98Var.a() == null) {
                                this.a.E6(false, null);
                                return;
                            } else {
                                this.a.E6(true, (MarkData) b98Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.p5((ForumManageModel.b) b98Var.a(), false);
                    return;
                }
                this.a.F6((la8) b98Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements x88.d {
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

        @Override // com.baidu.tieba.x88.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements vg<GifView> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.G0 != null && this.a.G0.J0() != null) {
                this.a.G0.J0().Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements xa8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.xa8.a
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

        @Override // com.baidu.tieba.xa8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091d3c) {
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
                            if (postData.getType() != PostData.T0 && !TextUtils.isEmpty(postData.t()) && aw4.c().g()) {
                                return this.a.r6(postData);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09191a) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.j7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.G0.T1() && view2.getId() == R.id.obfuscated_res_0x7f091939) {
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

        @Override // com.baidu.tieba.xa8.a
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
    public class q2 implements vg<TiebaPlusRecommendCard> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ys5.a)) {
                ys5.a aVar = (ys5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.R5(aVar.b);
                }
                ys5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.y0 != null && this.a.y0.W0()) {
                    this.a.m6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r1 extends wb {
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
    public class r2 implements vg<View> {
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
    public class s0 implements l05.c {
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

        @Override // com.baidu.tieba.l05.c
        public void a(l05 l05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.N0 = pbFragment.N0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new bc8(this.a.y0.F1(), this.a.N0, "1").start();
                    l05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.N0 = pbFragment2.N0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new bc8(this.a.y0.F1(), this.a.N0, "2").start();
                    l05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.N0 = pbFragment3.N0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.N0);
                    l05Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements vg<RelativeLayout> {
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
    public class t2 implements vg<ItemCardView> {
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.A0 == null || this.a.A0.e()) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                this.a.G0.z1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                v98 l1 = this.a.y0.l1();
                if (l1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    l1.w().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.h1.d(this.a.g1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.g1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.g7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (dj.isEmpty(errorString2)) {
                        errorString2 = this.a.g1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.h1.c(errorString2);
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
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d08);
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
                if (this.a.G0 != null && this.a.G0.j1() != null) {
                    sc8 j1 = this.a.G0.j1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                this.a.G0.z1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.h1.d(this.a.g1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (dj.isEmpty(muteMessage)) {
                    muteMessage = this.a.g1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.h1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements au4.a {
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

        @Override // com.baidu.tieba.au4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.G0.y3();
                if (z) {
                    if (this.a.A0 != null) {
                        this.a.A0.h(z2);
                    }
                    this.a.y0.e3(z2);
                    if (!this.a.y0.W0()) {
                        this.a.G0.N1(this.a.y0.l1());
                    } else {
                        this.a.m6();
                    }
                    if (z2) {
                        boolean q0 = this.a.y0.l1().q0();
                        if (this.a.A0 != null && !q0) {
                            if (this.a.A0.f() != null && this.a.y0 != null && this.a.y0.l1() != null && this.a.y0.l1().Q() != null && this.a.y0.l1().Q().getAuthor() != null) {
                                MarkData f = this.a.A0.f();
                                MetaData author = this.a.y0.l1().Q().getAuthor();
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
            gc8 J0;
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
                    statisticItem.param("tid", this.a.y0.F1());
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
                        builder.I(this.a.y0.w1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.f6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.y0 != null) {
                            builder.D(this.a.y0.getFromForumId());
                            if (this.a.y0.l1() != null) {
                                builder.Q(this.a.y0.l1().Q());
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
                        builder2.I(this.a.y0.w1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.f6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.y0 != null) {
                            builder2.D(this.a.y0.getFromForumId());
                            if (this.a.y0.l1() != null) {
                                builder2.Q(this.a.y0.l1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText u7 = this.a.u7(str, i);
                        if (u7 != null && this.a.D2 >= 0 && this.a.D2 < u7.I().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = w98.a(u7.I().get(this.a.D2));
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
                                            if (u7.getPostId() == dh.g(this.a.y0.J0(), 0L)) {
                                                i8 = 1;
                                            }
                                            xg8.b(this.a.y0.l1(), (PostData) next, ((PostData) next).d0, i8, 3);
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
                            builder3.I(this.a.y0.w1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.f6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.y0 != null) {
                                builder3.D(this.a.y0.getFromForumId());
                                if (this.a.y0.l1() != null) {
                                    builder3.Q(this.a.y0.l1().Q());
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
                if (!this.a.d6() || this.a.a == null || this.a.a.H1() == null || !str.equals(this.a.a.H1().getTopicId())) {
                    return;
                }
                this.a.p7(false);
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
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements l05.c {
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

        @Override // com.baidu.tieba.l05.c
        public void a(l05 l05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l05Var, i, view2) == null) {
                if (l05Var != null) {
                    l05Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.G2;
                if (postData != null) {
                    if (i == 0) {
                        postData.H0();
                        this.a.G2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.q6(pbFragment2.G2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cy4)) {
                cy4 cy4Var = (cy4) customResponsedMessage.getData();
                vy4.a aVar = new vy4.a();
                int i = cy4Var.a;
                String str = cy4Var.b;
                aVar.a = cy4Var.d;
                v98 l1 = this.a.y0.l1();
                if (l1 == null) {
                    return;
                }
                if (this.a.y0.N0() != null && this.a.y0.N0().getUserIdLong() == cy4Var.p) {
                    this.a.G0.M2(cy4Var.l, this.a.y0.l1(), this.a.y0.D1(), this.a.y0.v1());
                }
                if (l1.H() != null && l1.H().size() >= 1 && l1.H().get(0) != null) {
                    long g = dh.g(l1.H().get(0).O(), 0L);
                    long g2 = dh.g(this.a.y0.F1(), 0L);
                    if (g == cy4Var.n && g2 == cy4Var.m) {
                        vy4 M = l1.H().get(0).M();
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
                        l1.H().get(0).N0(M);
                        this.a.G0.J0().Z();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof r99) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                r99 r99Var = (r99) customResponsedMessage.getData();
                this.a.G0.z1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.f1;
                DataRes dataRes = r99Var.a;
                boolean z = false;
                if (r99Var.c == 0 && dataRes != null) {
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
    public class x1 implements j05.e {
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

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                j05Var.dismiss();
                this.b.C0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.y0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x2 implements l05.c {
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

        @Override // com.baidu.tieba.l05.c
        public void a(l05 l05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, l05Var, i, view2) == null) {
                if (l05Var != null) {
                    l05Var.e();
                }
                if (this.a.l1 != null && !TextUtils.isEmpty(this.a.m1)) {
                    if (i == 0) {
                        if (this.a.o1 != null) {
                            ne5.a aVar = new ne5.a();
                            aVar.a = this.a.m1;
                            String str = "";
                            if (this.a.o1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.o1.memeInfo.pck_id;
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
                        if (this.a.k1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.k1 = new ee8(pbFragment.getPageContext());
                        }
                        this.a.k1.b(this.a.m1, this.a.l1.n());
                    }
                    this.a.l1 = null;
                    this.a.m1 = null;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hu5)) {
                hu5 hu5Var = (hu5) customResponsedMessage.getData();
                v98 l1 = this.a.y0.l1();
                if (l1 == null) {
                    return;
                }
                if (this.a.y0.l1() != null && this.a.y0.l1().Z().r() != null && this.a.y0.l1().Z().r().getPortrait() != null && this.a.y0.l1().Z().r().getPortrait().equals(hu5Var.a)) {
                    if (this.a.y0.l1().Z().r().getUserWorldCupData() != null) {
                        this.a.y0.l1().Z().r().getUserWorldCupData().d(hu5Var.b);
                    }
                    this.a.G0.N2(this.a.y0.l1(), this.a.y0.D1(), this.a.y0.v1(), this.a.G0.p1());
                }
                if (l1.H() != null && l1.H().size() >= 0) {
                    Iterator<PostData> it = l1.H().iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(hu5Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(hu5Var.b);
                        }
                    }
                    this.a.G0.J0().Z();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.G0.P1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.n5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements kd5 {
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

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ce8 ce8Var = this.a.K0;
                if (ce8Var != null && ce8Var.e() != null && this.a.K0.e().d()) {
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.y0 == null || this.a.y0.u1() == i + 1) {
                return;
            }
            this.a.M6(xd8.q(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && this.a.y0.l1() != null) {
                this.a.y0.l1().a();
                this.a.y0.Q1();
                if (this.a.G0.J0() != null) {
                    this.a.G0.N1(this.a.y0.l1());
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
            a29 a29Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a29) && (a29Var = (a29) customResponsedMessage.getData()) != null && (agreeData = a29Var.b) != null) {
                if (this.a.G0 != null) {
                    this.a.G0.h2(a29Var);
                }
                if (agreeData.agreeType == 2 && this.a.G0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !wf8.k(this.a.y0.b)) {
                    this.a.G0.i4();
                    wf8.b(this.a.y0.b);
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
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.y0 != null && this.a.y0.l1() != null && this.a.G0 != null && this.a.G0.J0() != null) {
                this.a.G0.u2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.y0.a2() && (H = this.a.y0.l1().H()) != null && !H.isEmpty()) {
                    int w = ((i + i2) - this.a.G0.J0().w()) - 1;
                    v98 l1 = this.a.y0.l1();
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
                if (!xd8.B(this.a.e1) && xd8.B(i)) {
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
                    this.a.t = new lk5();
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
                this.a.e1 = i;
                if (i == 0) {
                    m09.g().h(this.a.getUniqueId(), true);
                    this.a.Z4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z2 implements u05.d {
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

        @Override // com.baidu.tieba.u05.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.M0 != null) {
                this.a.M0.q(uf8.h(this.a.G2));
                ArrayList arrayList = new ArrayList();
                for (t05 t05Var : this.a.M0.g()) {
                    if (t05Var instanceof q05) {
                        arrayList.add((q05) t05Var);
                    }
                }
                uf8.f(arrayList);
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
        V2 = new c1();
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        W2 = new c();
    }

    public final void K6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (pbModel = this.y0) != null && pbModel.l1() != null && this.y0.l1().Q() != null && this.y0.l1().Q().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void L6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (pbModel = this.y0) != null && pbModel.l1() != null && this.y0.l1().Q() != null && this.y0.l1().Q().isVideoThreadType()) {
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
            if (pbModel == null || !pbModel.D1()) {
                return false;
            }
            if (this.y0.j1() != null && this.y0.j1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && n95.g(TbadkCoreApplication.getInst(), 0) && !this.G0.E2()) {
            this.j0 = n95.k(getPageContext(), "collect", 0L);
        }
    }

    public final void i7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbModel = this.y0) != null && !dj.isEmpty(pbModel.F1())) {
            cr4.w().P(br4.Z, dh.g(this.y0.F1(), 0L));
        }
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (this.y0.l1() != null && this.y0.l1().Q() != null) {
                return this.y0.l1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void t6() {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && (list = this.s1) != null && !list.isEmpty()) {
            int size = this.s1.size();
            while (true) {
                size--;
                if (size <= -1 || this.s1.get(size).onBackPressed()) {
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
        this.t0 = new v(this);
        this.w0 = new g0(this);
        this.x0 = new Handler(new r0(this));
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
        this.b1 = new n1(this);
        this.c1 = new y1(this);
        this.d1 = new j2(this);
        this.e1 = 0;
        this.p1 = false;
        this.q1 = 0;
        this.r1 = -1;
        this.t1 = 0;
        this.w1 = new u2(this);
        this.x1 = new f3(this);
        this.y1 = new k(this, 2004016);
        this.z1 = new m(this, 2016485);
        this.A1 = new n(this, 2001269);
        this.B1 = new o(this, 2004008);
        this.C1 = new p(this, 2004007);
        this.D1 = new q(this, 2004005);
        this.E1 = new r(this, 2001332);
        this.F1 = new s(this, 2921391);
        this.G1 = new t(this, 2921606);
        this.H1 = new u(this, 2921658);
        this.I1 = new w(this);
        this.J1 = new x(this, 2001369);
        this.K1 = new y(this, 2921787);
        this.L1 = new z(this, 2016488);
        this.M1 = new a0(this, 2016331);
        this.N1 = new b0(this, 2921746);
        this.O1 = new c0(this);
        this.P1 = new d0(this, 2010045);
        this.Q1 = new e0(this);
        this.S1 = new PraiseModel(getPageContext(), new f0(this));
        this.T1 = new h0(this);
        this.U1 = new j0(this, 2001115);
        this.V1 = new k0(this);
        this.W1 = new l0(this);
        this.Y1 = new xa8(new q0(this));
        this.Z1 = new t0(this);
        this.a2 = new u0(this, 2001427);
        this.b2 = new v0(this, 2001428);
        this.c2 = new w0(this, 2921634);
        this.d2 = new x0(this, 2001426);
        this.e2 = new y0(this, 2004021);
        this.f2 = new z0(this, 2016528);
        this.g2 = new a1(this, 2921724);
        this.h2 = new b1(this, 2921033);
        this.i2 = new d1(this);
        this.j2 = new e1(this);
        this.k2 = new f1(this);
        this.l2 = new j1(this);
        this.m2 = new m1(this);
        this.n2 = new o1(this, 2921480);
        this.o2 = new p1(this);
        this.p2 = Boolean.FALSE;
        this.q2 = new q1(this);
        this.r2 = new r1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.s2 = new s1(this);
        this.t2 = new t1(this, 2016450);
        this.u2 = new u1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.v2 = new v1(this);
        this.w2 = new z1(this);
        this.x2 = new c2(this);
        this.y2 = new e2(this);
        this.z2 = new f2(this);
        this.A2 = new g2(this);
        this.C2 = new h2(this);
        this.D2 = 0;
        this.E2 = new v2(this);
        this.F2 = false;
        this.G2 = null;
        this.H2 = new w2(this);
        this.I2 = new x2(this);
        this.J2 = new y2(this);
        this.K2 = new a3(this);
        this.L2 = new b3(this);
        this.M2 = new c3(this);
        this.N2 = new d3(this);
        this.O2 = new a(this);
        this.P2 = new b(this);
        this.Q2 = new d(this);
        this.R2 = -1;
        this.S2 = -1;
    }

    @Override // com.baidu.tieba.bt5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.bt5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
            fe8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    public final void Y5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048648, this, i4, i5) == null) {
            op5.b(new j(this, i5), new l(this, i5, i4));
        }
    }

    @Override // com.baidu.tieba.bt5
    public void g0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048675, this, context, str) == null) {
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048717, this, i4, keyEvent)) == null) {
            if (keyEvent == null || (zd8Var = this.G0) == null || !zd8Var.m2(i4)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void H6(g3 g3Var) {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, g3Var) == null) && g3Var != null && (list = this.s1) != null) {
            list.remove(g3Var);
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
            this.p2 = Boolean.valueOf(z3);
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

    public void U4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, g3Var) == null) && g3Var != null) {
            if (this.s1 == null) {
                this.s1 = new ArrayList();
            }
            if (!this.s1.contains(g3Var)) {
                this.s1.add(g3Var);
            }
        }
    }

    public void V4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, g3Var) == null) && g3Var != null) {
            if (this.s1 == null) {
                this.s1 = new ArrayList();
            }
            if (!this.s1.contains(g3Var)) {
                this.s1.add(0, g3Var);
            }
        }
    }

    public final void V5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, intent) == null) {
            wf8.j(this, intent);
        }
    }

    public final void f7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i4) == null) {
            wf8.n(this, t5(), i4);
        }
    }

    @Override // com.baidu.tieba.di8.b
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

    @Override // com.baidu.tieba.j05.e
    public void onClick(j05 j05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, j05Var) == null) {
            l5(j05Var, null);
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
            this.y0.K2(bundle);
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

    public final void s7(nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, nx4Var) == null) && nx4Var != null) {
            this.U2 = nx4Var;
            this.c = true;
            this.G0.R2();
            this.G0.m3(this.T2);
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

    @Override // com.baidu.tieba.bt5
    public ug<TiebaPlusRecommendCard> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.D == null) {
                this.D = new ug<>(new q2(this), 5, 0);
            }
            return this.D;
        }
        return (ug) invokeV.objValue;
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.c && this.R2 == -1 && this.S2 == -1) {
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
            m95 m95Var = this.j0;
            if (m95Var != null && m95Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bt5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            zd8 zd8Var = this.G0;
            if (zd8Var == null) {
                return 0;
            }
            return zd8Var.n1();
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
            return this.p2.booleanValue();
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
    @Override // com.baidu.tieba.bt5
    /* renamed from: E5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            zd8 zd8Var = this.G0;
            if (zd8Var == null) {
                return null;
            }
            return zd8Var.Z0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public ef8 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.F0();
        }
        return (ef8) invokeV.objValue;
    }

    public int F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.S2;
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

    @Override // com.baidu.tieba.hh8
    public PbModel.h G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.s2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.R2;
        }
        return invokeV.intValue;
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            hideNetRefreshView(this.G0.t1());
            b7();
            if (this.y0.p2()) {
                this.G0.z3();
            }
            this.G0.I3();
        }
    }

    public od5 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.V0;
        }
        return (od5) invokeV.objValue;
    }

    public ff8 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.e;
        }
        return (ff8) invokeV.objValue;
    }

    public void I6() {
        m95 m95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (m95Var = this.j0) != null) {
            m95Var.x();
        }
    }

    public sf8 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.u0;
        }
        return (sf8) invokeV.objValue;
    }

    public zd8 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.G0;
        }
        return (zd8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.y0;
        }
        return (PbModel) invokeV.objValue;
    }

    public ez4 M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.c0;
        }
        return (ez4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
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

    @Override // com.baidu.tieba.bt5
    public ug<RelativeLayout> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new s2(this), 10, 0);
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

    @Override // com.baidu.tieba.bt5
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

    @Override // com.baidu.tieba.bt5
    public ug<ImageView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.B == null) {
                this.B = new ug<>(new o2(this), 8, 0);
            }
            return this.B;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<View> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.C == null) {
                this.C = new ug<>(new r2(this), 8, 0);
            }
            return this.C;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
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
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (zd8Var = this.G0) != null) {
            zd8Var.x1();
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
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.Q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && n95.g(TbadkCoreApplication.getInst(), 0) && !this.G0.E2()) {
            this.j0 = n95.k(getPageContext(), "reply_pb", 0L);
        }
    }

    public final boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.H1() != null && this.a.H1().k1() == 17) {
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
                return pbModel.O0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<ItemCardView> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            if (this.G == null) {
                this.G = new ug<>(new t2(this), 10, 0);
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
            v98 l12 = this.y0.l1();
            this.y0.e3(true);
            au4 au4Var = this.A0;
            if (au4Var != null) {
                l12.L0(au4Var.g());
            }
            this.G0.N1(l12);
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
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048701, this) != null) || (zd8Var = this.G0) == null) {
            return;
        }
        zd8Var.e2();
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
            if (pbModel != null && pbModel.l1() != null) {
                return this.y0.l1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (pbModel = this.y0) != null && !dj.isEmpty(pbModel.F1())) {
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
            v98 v98Var = this.y0.G;
            if (v98Var != null) {
                return v98Var.Z();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.L == null) {
                this.L = new ug<>(new p2(this), 20, 0);
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
            return pbModel.f2();
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
        v98 l12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || (l12 = pbModel.l1()) == null) {
                return null;
            }
            return l12.V().c;
        }
        return (String) invokeV.objValue;
    }

    public void w6() {
        m95 m95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && (m95Var = this.j0) != null) {
            m95Var.q();
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.E == null) {
                this.E = new ug<>(new e3(this), 15, 0);
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
        Object[] objArr = (ys5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ys5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (fe8.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new nq5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
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
        if (interceptable == null || interceptable.invokeLLZ(1048639, this, context, str, z3) == null) {
            if (fe8.c(str) && (pbModel = this.y0) != null && pbModel.F1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.y0.F1()));
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
                fe8.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    public final AbsPbActivity.e A6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = null;
            if (this.y0.l1() != null && this.y0.l1().H() != null && this.y0.l1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.y0.l1().H().size()) {
                        if (str.equals(this.y0.l1().H().get(i4).O())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                PostData postData = this.y0.l1().H().get(i4);
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
                    w98.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void F6(la8 la8Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, la8Var) != null) || la8Var.i() == null) {
            return;
        }
        String O = la8Var.i().O();
        ArrayList<PostData> H = this.y0.l1().H();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= H.size()) {
                break;
            }
            PostData postData = H.get(i4);
            if (postData.O() != null && postData.O().equals(O)) {
                ArrayList<PostData> k3 = la8Var.k();
                postData.d1(la8Var.m());
                if (postData.d0() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.l0() != null && next != null && next.r() != null && (metaData = postData.l0().get(next.r().getUserId())) != null) {
                            next.G0(metaData);
                            next.T0(true);
                            next.m1(getPageContext(), this.y0.g2(metaData.getUserId()));
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
        if (!this.y0.U0() && z3) {
            this.G0.N1(this.y0.l1());
        }
        if (z3) {
            D6(la8Var);
        }
    }

    public void Z4(boolean z3) {
        zd8 zd8Var;
        int i4;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) && (zd8Var = this.G0) != null && zd8Var.Z0() != null) {
            int firstVisiblePosition = this.G0.Z0().getFirstVisiblePosition();
            int lastVisiblePosition = this.G0.Z0().getLastVisiblePosition();
            gc8 J0 = this.G0.J0();
            if (J0 != null && this.y0.l1() != null) {
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
                            PostData postData2 = (PostData) ListUtils.getItem(this.y0.l1().H(), postData.F() - 1);
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
                    ea5 ea5Var = (ea5) ListUtils.getItem(arrayList, 0);
                    if (ea5Var != null && ea5Var.e() == 1) {
                        if (!z3) {
                            this.G0.F2(ea5Var, 0);
                            return;
                        }
                        return;
                    }
                    this.G0.F2(ea5Var, 1);
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
            String s3 = p35.m().s("bubble_link", "");
            if (StringUtils.isNull(s3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = postData.i0().getJumpUrl();
            int packageId = postData.i0().getPackageId();
            int propsId = postData.i0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.p(getPageContext().getPageActivity(), n39.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
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

    public final void t7(int i4) {
        PbModel pbModel;
        ThreadData Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048740, this, i4) != null) || (pbModel = this.y0) == null || pbModel.l1() == null || (Q = this.y0.l1().Q()) == null) {
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
        if (this.y0.D1()) {
            this.G0.J0().Z();
        } else {
            this.G0.A4(this.y0.l1());
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
            x9 x9Var = this.g1;
            if (x9Var == null) {
                return;
            }
            j05 j05Var = new j05(x9Var.getPageActivity());
            j05Var.setMessage(str);
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a50, new g(this));
            j05Var.create(this.g1).show();
        }
    }

    public void i6(String str) {
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, str) == null) && this.y0 != null && !StringUtils.isNull(str) && (zd8Var = this.G0) != null) {
            zd8Var.h3(true);
            this.y0.l2(str);
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
            zd8 zd8Var = this.G0;
            if (zd8Var != null) {
                zd8Var.j2(configuration);
            }
            s05 s05Var = this.L0;
            if (s05Var != null) {
                s05Var.dismiss();
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
            s05 s05Var = this.L0;
            if (s05Var != null) {
                s05Var.dismiss();
            }
            if (z3 && this.P0) {
                this.G0.A3();
                this.y0.j2(true);
            }
            if (this.G0.J0() != null) {
                this.G0.J0().d0(z3);
            }
        }
    }

    public final void q7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048732, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.y0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(uf8.n(i4))));
        }
    }

    public final void r5(Rect rect) {
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048733, this, rect) == null) && rect != null && (zd8Var = this.G0) != null && zd8Var.s1() != null && rect.top <= this.G0.s1().getHeight()) {
            rect.top += this.G0.s1().getHeight() - rect.top;
        }
    }

    public void D6(la8 la8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, la8Var) == null) {
            String O = la8Var.i().O();
            List<PostData> list = this.y0.l1().V().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.O() != null && postData.O().equals(O)) {
                    ArrayList<PostData> k3 = la8Var.k();
                    postData.d1(la8Var.m());
                    if (postData.d0() != null) {
                        postData.d0().clear();
                        postData.d0().addAll(k3);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.y0.U0()) {
                this.G0.N1(this.y0.l1());
            }
        }
    }

    public final void U5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.l1() != null && this.y0.l1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.y0.F1(), str);
                ThreadData Q = this.y0.l1().Q();
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
        j05 j05Var = new j05(getActivity());
        j05Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b48));
        j05Var.setTitleShowCenter(true);
        j05Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b49));
        j05Var.setMessageShowCenter(true);
        j05Var.setCancelable(false);
        j05Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b4a), new w1(this, metaData));
        j05Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b4b), new x1(this, metaData));
        j05Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void e7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                M().t0(postWriteCallBackData.getPostId());
                int N0 = this.G0.N0();
                this.q1 = N0;
                this.y0.N2(N0, this.G0.T0());
            }
            this.G0.v0();
            this.K0.c();
            od5 od5Var = this.V0;
            if (od5Var != null) {
                this.G0.c3(od5Var.y());
            }
            this.G0.x1();
            this.G0.N3(true);
            this.y0.Q1();
        }
    }

    public final void i5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048684, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.y0) != null && pbModel.l1() != null) {
            j29 A = this.y0.l1().A();
            if (A != null && str.equals(A.q1())) {
                if (A.getAdvertAppInfo() != null) {
                    A.getAdvertAppInfo().h = null;
                }
                this.y0.l1().b();
            }
            j29 E0 = this.y0.E0();
            if (E0 != null && str.equals(E0.q1())) {
                this.y0.q0();
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
        od5 od5Var = this.V0;
        if (od5Var != null && od5Var.b() != null) {
            this.V0.b().y(i4);
        }
        if (this.G0.a() != null) {
            this.G0.a().d(getPageContext(), i4);
        }
        this.K0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.W = i4;
        l7();
        m95 m95Var = this.j0;
        if (m95Var != null) {
            m95Var.w();
        }
    }

    public void q6(PostData postData) {
        PostData u5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048731, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.O() != null && postData.O().equals(this.y0.g1())) {
            z3 = true;
        }
        MarkData f12 = this.y0.f1(postData);
        if (this.y0.l1() != null && this.y0.l1().l0() && (u5 = u5()) != null) {
            f12 = this.y0.f1(u5);
        }
        if (f12 == null) {
            return;
        }
        this.G0.z3();
        au4 au4Var = this.A0;
        if (au4Var != null) {
            au4Var.i(f12);
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
            this.y0.e3(z3);
            au4 au4Var = this.A0;
            if (au4Var != null) {
                au4Var.h(z3);
                if (markData != null) {
                    this.A0.i(markData);
                }
            }
            if (this.y0.W0()) {
                m6();
            } else {
                this.G0.N1(this.y0.l1());
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
            if (postData.getType() != PostData.T0 && !TextUtils.isEmpty(postData.t()) && aw4.c().g()) {
                return r6(postData);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.l1() != null) {
                if (K5().j1() != null) {
                    K5().j1().g();
                }
                la8 la8Var = new la8();
                la8Var.A(this.y0.l1().l());
                la8Var.E(this.y0.l1().Q());
                la8Var.C(postData);
                K5().i1().c0(la8Var);
                K5().i1().setPostId(postData.O());
                l6(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                od5 od5Var = this.V0;
                if (od5Var != null) {
                    this.G0.c3(od5Var.y());
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
                pollingModel.x0(e15.e);
            }
            this.E0.n0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            gh.a().postDelayed(this.Z1, 10000L);
        }
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (this.n1 != null) {
                ne5.b bVar = new ne5.b();
                bVar.a = this.n1.J();
                bVar.b = this.n1.H();
                bVar.c = String.valueOf(this.n1.K());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.m1));
        }
    }

    public final void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            j05 j05Var = new j05(getPageContext().getPageActivity());
            j05Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            j05Var.setPositiveButton(R.string.open_now, new e(this));
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new f(this));
            j05Var.create(this.g1).show();
        }
    }

    public final boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.l1() == null) {
                return false;
            }
            ThreadData Q = this.y0.l1().Q();
            AntiData d4 = this.y0.l1().d();
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
            View j4 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j4.getLayoutParams();
            layoutParams.addRule(3, this.G0.s1().getId());
            j4.setLayoutParams(layoutParams);
        }
    }

    public boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if ((this.y0.l1() != null && (this.y0.l1().l0() || ThreadCardUtils.isSelf(this.y0.l1().Q()))) || this.Y0 == null || this.y0.l1() == null || this.y0.l1().d() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.y0.l1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final boolean e6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            PostData c4 = w98.c(this.y0.l1(), this.y0.D1(), this.y0.v1());
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
            if (this.y0.Q0() || this.y0.T0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.y0.F1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.y0.F1()));
            if (n7()) {
                this.a.finish();
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && this.U2 != null) {
            if (this.S2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0eac);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.U2.a(), this.S2, 0)));
                this.a.finish();
            }
        }
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && this.U2 != null) {
            if (this.R2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0ead);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.U2.a(), this.R2, 0)));
                this.a.finish();
            }
        }
    }

    public void o5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && this.G0 != null && (pbModel = this.y0) != null && pbModel.l1() != null && this.y0.l1().U() != null && checkUpIsLogin() && this.G0.J0() != null && this.G0.J0().z() != null) {
            this.G0.J0().z().v(this.y0.F1(), this.y0.getFromForumId());
        }
    }

    public final void o7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && (absPbActivity = this.a) != null && absPbActivity.H1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.H1().F1()).param("topic_id", this.a.H1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.H1().J1()));
        }
    }

    public final void r7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048735, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(this.y0.getForumId()) && this.y0.l1() != null && this.y0.l1().l() != null) {
            boolean z3 = true;
            if (this.y0.l1().l().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.y0.y0().K(this.y0.getForumId(), this.y0.F1());
            }
        }
    }

    public void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.y0.l1() != null && this.y0.l1().Q() != null && this.y0.l1().Q().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.y0.l1().Q().getTaskInfoData().i(), this.y0.l1().Q().getTaskInfoData().g(), this.y0.l1().Q().getTaskInfoData().b(), this.y0.l1().Q().getTaskInfoData().c(), this.y0.l1().Q().getIs_top(), this.y0.l1().Q().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.l1() != null) {
                j29 A = this.y0.l1().A();
                if (A != null) {
                    if (A.getAdvertAppInfo() != null) {
                        A.getAdvertAppInfo().h = null;
                    }
                    this.y0.l1().b();
                }
                if (this.y0.E0() != null) {
                    this.y0.q0();
                }
                this.y0.Q1();
            }
            if (this.y0.l1().H() != null) {
                Iterator<PostData> it = this.y0.l1().H().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof j29) {
                        it.remove();
                    }
                }
            }
            if (this.G0.J0() != null && !ListUtils.isEmpty(this.G0.J0().t())) {
                xd8.d(this.G0.J0().t());
            }
            if (this.G0.Z0() != null && !ListUtils.isEmpty(this.G0.Z0().getData())) {
                xd8.d(this.G0.Z0().getData());
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
            if (pbModel.l1() != null && this.y0.l1().l0()) {
                return true;
            }
            if (this.y0.W0()) {
                MarkData H0 = this.y0.H0();
                if (H0 != null && this.y0.U0()) {
                    MarkData B0 = this.y0.B0(this.G0.Q0());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", H0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(H0.getPostId())) {
                        j05 j05Var = new j05(getPageContext().getPageActivity());
                        j05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045b, new l2(this, B0, H0, j05Var));
                        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new m2(this, H0, j05Var));
                        j05Var.setOnCalcelListener(new n2(this, H0, j05Var));
                        j05Var.create(getPageContext());
                        j05Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", H0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.y0.l1() != null && this.y0.l1().H() != null && this.y0.l1().H().size() > 0 && this.y0.U0()) {
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
            zd8 zd8Var = this.G0;
            if (zd8Var != null && zd8Var.t1() != null) {
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
            zd8 zd8Var2 = this.G0;
            if (zd8Var2 != null) {
                noNetworkView = zd8Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.E1);
            this.P0 = false;
            L6();
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.d2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.p1) {
                G6();
                this.p1 = false;
            }
            i7();
            ItemCardHelper.w(this.M2);
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
            cg8 cg8Var = this.G0.h;
            if (cg8Var != null && !cg8Var.v()) {
                this.G0.h.z();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.l1() != null && this.y0.l1().l() != null && this.y0.l1().Q() != null) {
                bb5.j().x(getPageContext().getPageActivity(), "pb", this.y0.l1().l().getId(), dh.g(this.y0.l1().Q().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            m09.g().h(getUniqueId(), false);
        }
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.l1() == null || this.y0.l1().H() == null || (count = ListUtils.getCount((H = this.y0.l1().H()))) == 0) {
                return "";
            }
            if (this.y0.w1()) {
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
                if (this.y0.g2(postData.r().getUserId())) {
                    return postData.O();
                }
                for (int i4 = Q0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i4);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (this.y0.g2(postData2.r().getUserId())) {
                        return postData2.O();
                    }
                }
                for (int i5 = Q0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i5);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (this.y0.g2(postData3.r().getUserId())) {
                        return postData3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void Q6(qd5 qd5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, qd5Var) == null) && qd5Var != null && (pbModel = this.y0) != null) {
            qd5Var.p(pbModel.K0());
            if (this.y0.l1() != null && this.y0.l1().l() != null) {
                qd5Var.o(this.y0.l1().l());
            }
            qd5Var.q("pb");
            qd5Var.r(this.y0);
        }
    }

    public final void R6(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i4) != null) || (pbModel = this.y0) == null) {
            return;
        }
        int u12 = pbModel.u1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.y0.Y2(1);
                } else {
                    this.y0.Y2(4);
                }
            } else {
                this.y0.Y2(3);
            }
        } else {
            this.y0.Y2(2);
        }
        int u13 = this.y0.u1();
        if (u12 == 4 || u13 == 4) {
            u6();
        }
    }

    public final void Z5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            au4 c4 = au4.c(this.a);
            this.A0 = c4;
            if (c4 != null) {
                c4.j(this.v2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.B0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x2);
            this.C0 = new p85(getPageContext());
            L5();
            this.S1.setUniqueId(getUniqueId());
            this.S1.registerListener();
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
            BdUniqueId bdUniqueId = this.i1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.f1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean d5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048664, this, i4)) == null) {
            if (this.Y0 != null && this.y0.l1() != null && !ThreadCardUtils.isSelf(this.y0.l1().Q()) && this.y0.l1().d() != null) {
                return this.Y0.checkPrivacyBeforeSend(this.y0.l1().d().replyPrivateFlag, i4);
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
                if (H1.G0() != null) {
                    this.y0.G0().c(this.Q2);
                }
                if (this.y0.h1() != null) {
                    this.y0.h1().f(this.x1);
                }
                if (StringUtils.isNull(this.y0.F1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.y0.V2(6);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090718));
            v98 d4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d();
            if (d4 != null) {
                this.s2.c(true, 0, 3, 0, d4, "", 1);
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
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.H1().F1()).param("topic_id", this.a.H1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.H1().J1()));
        }
    }

    public void x6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048755, this, animatorListener) == null) && this.G0 != null && (pbModel = this.y0) != null && pbModel.l1() != null && this.y0.l1().U() != null && checkUpIsLogin() && this.G0.J0() != null && this.G0.J0().z() != null) {
            this.G0.J0().z().F(animatorListener);
        }
    }

    public final void S5(int i4, Intent intent) {
        xb5 xb5Var;
        xb5 xb5Var2;
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
                    sd5 f4 = this.G0.j1().f();
                    f4.d0(this.y0.l1().Q());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    wb5 p3 = f4.b().p(6);
                    if (p3 != null && (xb5Var2 = p3.m) != null) {
                        xb5Var2.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
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
            wb5 p4 = this.V0.b().p(6);
            if (p4 != null && (xb5Var = p4.m) != null) {
                xb5Var.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
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
                            z88.e(getResources().getString(R.string.obfuscated_res_0x7f0f12eb));
                            return;
                        } else {
                            z88.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.y0.Y0()) {
                antiData.setBlock_forum_name(this.y0.l1().l().getName());
                antiData.setBlock_forum_id(this.y0.l1().l().getId());
                antiData.setUser_name(this.y0.l1().X().getUserName());
                antiData.setUser_id(this.y0.l1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void a7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048655, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            s05 s05Var = this.L0;
            if (s05Var != null && s05Var.isShowing()) {
                this.L0.dismiss();
                this.L0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            u05 u05Var = new u05(getContext());
            u05Var.p(new i0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new q05(0, getResources().getString(R.string.obfuscated_res_0x7f0f04d8), u05Var));
            }
            if (z3) {
                arrayList.add(new q05(1, getResources().getString(R.string.un_mute), u05Var));
            } else {
                arrayList.add(new q05(1, getResources().getString(R.string.obfuscated_res_0x7f0f0be6), u05Var));
            }
            u05Var.k(arrayList);
            s05 s05Var2 = new s05(getPageContext(), u05Var);
            this.L0 = s05Var2;
            s05Var2.k();
        }
    }

    public void k5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(zd8.o2)).intValue();
            if (intValue == zd8.p2) {
                if (this.B0.Z()) {
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
                    this.B0.b0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.B0.c0(this.y0.l1().l().getId(), this.y0.l1().l().getName(), this.y0.l1().Q().getId(), str, intValue3, intValue2, booleanValue, this.y0.l1().Q().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == zd8.q2 || intValue == zd8.s2) {
                PbModel pbModel = this.y0;
                if (pbModel != null && pbModel.G0() != null) {
                    this.y0.G0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == zd8.q2) {
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
            if (postData == null || (pbModel = this.y0) == null || pbModel.l1() == null || postData.F() == 1) {
                return;
            }
            String F1 = this.y0.F1();
            String O = postData.O();
            if (this.y0.l1() != null) {
                i4 = this.y0.l1().Y();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e A6 = A6(O);
            if (A6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo g02 = postData.g0();
            AntiData d4 = this.y0.l1().d();
            if (postData.r() != null) {
                arrayList = postData.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(F1, O, "pb", true, false, null, false, null, i4, g02, d4, false, arrayList, 5).addBigImageData(A6.a, A6.b, A6.g, A6.j);
            addBigImageData.setKeyPageStartFrom(this.y0.k1());
            addBigImageData.setFromFrsForumId(this.y0.getFromForumId());
            addBigImageData.setWorksInfoData(this.y0.K1());
            addBigImageData.setKeyFromForumId(this.y0.getForumId());
            addBigImageData.setBjhData(this.y0.D0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void n5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048700, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            zd8 zd8Var = this.G0;
            if (zd8Var != null && this.y0 != null) {
                if ((zd8Var == null || zd8Var.P1()) && this.y0.l1() != null && this.y0.l1().U() != null) {
                    zd8 zd8Var2 = this.G0;
                    if (zd8Var2 != null && zd8Var2.P0() != null && this.G0.P0().t()) {
                        return;
                    }
                    ja8 U = this.y0.l1().U();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!U.f() || U.a() != 2) && this.G0.J0() != null && this.G0.J0().z() != null) {
                        this.G0.J0().z().v(this.y0.F1(), this.y0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        x88 x88Var = new x88(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.y0;
                        x88Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        x88Var.l(new p0(this));
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.i1);
            userMuteAddAndDelCustomMessage.setTag(this.i1);
            h7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void U6(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048634, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new b2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                g7(str);
            } else {
                this.G0.o4(str);
            }
        }
    }

    @Override // com.baidu.tieba.bt5
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
        v98 v98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (pbModel = this.y0) != null && (v98Var = pbModel.G) != null && v98Var.Q() != null) {
            ThreadData Q = this.y0.G.Q();
            Q.mRecomAbTag = this.y0.q1();
            Q.mRecomWeight = this.y0.t1();
            Q.mRecomSource = this.y0.s1();
            Q.mRecomExtra = this.y0.r1();
            Q.isSubPb = this.y0.Y0();
            if (Q.getFid() == 0) {
                Q.setFid(dh.g(this.y0.getForumId(), 0L));
            }
            StatisticItem i4 = uj5.i(getContext(), Q, "c13562");
            TbPageTag l3 = uj5.l(getContext());
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
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && this.A0 != null) {
            if (this.y0.l1() != null && this.y0.l1().l0()) {
                B0 = this.y0.B0(0);
            } else {
                B0 = this.y0.B0(this.G0.Y0());
            }
            if (B0 == null) {
                return;
            }
            if (B0.isApp() && (B0 = this.y0.B0(this.G0.Y0() + 1)) == null) {
                return;
            }
            this.G0.z3();
            this.A0.i(B0);
            if (!this.A0.e()) {
                if (this.G0 != null && this.y0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !wf8.k(this.y0.b)) {
                    this.G0.i4();
                    wf8.b(this.y0.b);
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
            vf8.a();
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
            zd8 zd8Var = this.G0;
            if (zd8Var != null) {
                zd8Var.p2();
            }
            if (!this.y0.Y0()) {
                this.V0.N(this.y0.F1());
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.r2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            cr4.w().E();
            MessageManager.getInstance().unRegisterListener(this.E1);
            K6();
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            m95 m95Var = this.j0;
            if (m95Var != null) {
                m95Var.q();
                this.j0.p();
            }
        }
    }

    public final void W6(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            uf8.e(getActivity(), getPageContext(), new g1(this, sparseArray, i4, z3), new h1(this));
        }
    }

    public final void Y4(v98 v98Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048647, this, v98Var, arrayList) == null) && v98Var != null && v98Var.V() != null && v98Var.V().a != null && (list = v98Var.V().a) != null && arrayList != null) {
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
                this.y0.l1().Q().setIs_good(1);
                this.y0.R2(1);
            } else if (i4 == 3) {
                this.y0.l1().Q().setIs_good(0);
                this.y0.R2(0);
            } else if (i4 == 4) {
                this.y0.l1().Q().setIs_top(1);
                this.y0.S2(1);
            } else if (i4 == 5) {
                this.y0.l1().Q().setIs_top(0);
                this.y0.S2(0);
            }
            this.G0.x4(this.y0.l1(), this.y0.D1());
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
        this.l = new l05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        l05 l05Var = this.l;
        l05Var.j(strArr, new s0(this));
        l05Var.g(l05.b.a);
        l05Var.h(17);
        l05Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e5(AgreeData agreeData) {
        pj5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new l35();
        }
        if (this.i0 == null) {
            a29 a29Var = new a29();
            this.i0 = a29Var;
            a29Var.a = getUniqueId();
        }
        yw4 yw4Var = new yw4();
        yw4Var.b = 5;
        yw4Var.h = 8;
        yw4Var.g = 2;
        if (M() != null) {
            yw4Var.f = M().k1();
        }
        yw4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                yw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i4, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.y0;
                if (pbModel == null && pbModel.l1() != null) {
                    this.e0.b(N(), yw4Var, agreeData, this.y0.l1().Q());
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

    @Override // com.baidu.tieba.hh8
    public void finish() {
        zd8 zd8Var;
        boolean z3;
        CardHListViewData q3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            zd8 zd8Var2 = this.G0;
            if (zd8Var2 != null) {
                zd8Var2.v0();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.l1() != null && !this.y0.l1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.y0.l1().Q().getId();
                if (this.y0.isShareThread() && this.y0.l1().Q().originalThreadData != null) {
                    historyMessage.threadName = this.y0.l1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.y0.l1().Q().getTitle();
                }
                if (this.y0.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.y0.l1().l().getName();
                }
                ArrayList<PostData> H = this.y0.l1().H();
                zd8 zd8Var3 = this.G0;
                if (zd8Var3 != null) {
                    i4 = zd8Var3.Q0();
                } else {
                    i4 = 0;
                }
                if (H != null && i4 >= 0 && i4 < H.size()) {
                    historyMessage.postID = H.get(i4).O();
                }
                historyMessage.isHostOnly = this.y0.O0();
                historyMessage.isSquence = this.y0.D1();
                historyMessage.isShareThread = this.y0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            od5 od5Var = this.V0;
            if (od5Var != null) {
                od5Var.D();
            }
            if (this.i && K5() != null) {
                K5().A0();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && (pbModel2.Q0() || this.y0.T0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.y0.F1());
                if (this.H0) {
                    if (this.J0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.y0.Z0());
                    }
                    if (this.I0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.y0.V0());
                    }
                }
                if (this.y0.l1() != null && System.currentTimeMillis() - this.o >= 40000 && (q3 = this.y0.l1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.r1);
                }
                this.a.setResult(-1, intent);
            }
            if (n7()) {
                if (this.y0 != null && (zd8Var = this.G0) != null && zd8Var.Z0() != null) {
                    v98 l12 = this.y0.l1();
                    if (l12 != null) {
                        if (l12.X() != null) {
                            l12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            l12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!l12.t0() && !this.I && l12.h == null) {
                            od8 b4 = od8.b();
                            v98 m12 = this.y0.m1();
                            Parcelable onSaveInstanceState = this.G0.Z0().onSaveInstanceState();
                            boolean D1 = this.y0.D1();
                            boolean O0 = this.y0.O0();
                            if (this.G0.h1() != null && this.G0.h1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.n(m12, onSaveInstanceState, D1, O0, z3);
                            if (this.q1 >= 0 || this.y0.H1() != null) {
                                od8.b().q(this.y0.H1());
                                od8.b().r(this.y0.I1());
                                od8.b().o(this.y0.e1());
                            }
                        }
                    }
                } else {
                    od8.b().m();
                }
                m7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        cg8 cg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            m09.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.y0.l1().m());
                statisticItem.param("tid", this.y0.F1());
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
                if (this.y0.h1() != null) {
                    this.y0.h1().d();
                }
            }
            od5 od5Var = this.V0;
            if (od5Var != null) {
                od5Var.D();
            }
            ForumManageModel forumManageModel = this.B0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.U();
            }
            zd8 zd8Var = this.G0;
            if (zd8Var != null) {
                zd8Var.k2();
                cg8 cg8Var2 = this.G0.h;
                if (cg8Var2 != null) {
                    cg8Var2.z();
                }
            }
            lk5 lk5Var = this.t;
            if (lk5Var != null) {
                lk5Var.c();
            }
            ff8 ff8Var = this.e;
            if (ff8Var != null) {
                ff8Var.k();
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
            zd8 zd8Var2 = this.G0;
            if (zd8Var2 != null) {
                zd8Var2.v0();
            }
            if (this.Z1 != null) {
                gh.a().removeCallbacks(this.Z1);
            }
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.f2);
            MessageManager.getInstance().unRegisterListener(this.h2);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.r2);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.g2);
            this.g1 = null;
            this.h1 = null;
            zt8.e().g();
            if (this.j1 != null) {
                gh.a().removeCallbacks(this.j1);
            }
            zd8 zd8Var3 = this.G0;
            if (zd8Var3 != null && (cg8Var = zd8Var3.h) != null) {
                cg8Var.r();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            ce8 ce8Var = this.K0;
            if (ce8Var != null) {
                ce8Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && pbModel2.y0() != null) {
                this.y0.y0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            zd8 zd8Var4 = this.G0;
            if (zd8Var4 != null) {
                zd8Var4.q4();
            }
            sf8 sf8Var = this.u0;
            if (sf8Var != null) {
                sf8Var.e();
            }
        }
    }

    public void v6() {
        PbModel pbModel;
        v98 l12;
        ThreadData Q;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        v98 v98Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048751, this) == null) && (pbModel = this.y0) != null && pbModel.l1() != null && (Q = (l12 = this.y0.l1()).Q()) != null && Q.getAuthor() != null) {
            this.G0.x1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q.getAuthor().getUserId());
            hd8 hd8Var = new hd8();
            int Y = this.y0.l1().Y();
            if (Y != 1 && Y != 3) {
                hd8Var.g = false;
            } else {
                hd8Var.g = true;
                if (Q.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                hd8Var.s = z3;
            }
            if (xd8.z(this.y0.l1(), Y)) {
                hd8Var.h = true;
                if (Q.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                hd8Var.r = z8;
            } else {
                hd8Var.h = false;
            }
            if (Y == 1002 && !equals) {
                hd8Var.u = true;
            }
            hd8Var.n = xd8.J(Q.isBlocked(), l12.o0(), equals, Y, Q.isWorksInfo(), Q.isScoreThread());
            hd8Var.e = xd8.H(l12, equals, l12.o0(), this.y0.O());
            hd8Var.i = X6();
            hd8Var.f = xd8.I(this.y0.l1(), equals, this.y0.O());
            if (equals && l12.X() != null && l12.X().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            hd8Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                hd8Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            hd8Var.t = equals;
            hd8Var.q = this.y0.D1();
            hd8Var.b = true;
            hd8Var.a = xd8.C(this.y0.l1(), equals);
            if (equals) {
                this.G0.O1();
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            hd8Var.p = z5;
            hd8Var.j = true;
            hd8Var.o = this.y0.O0();
            hd8Var.d = true;
            if (Q.getThreadVideoInfo() == null) {
                hd8Var.c = true;
            } else {
                hd8Var.c = false;
            }
            if (l12.l0()) {
                hd8Var.b = false;
                hd8Var.d = false;
                hd8Var.c = false;
                hd8Var.g = false;
                hd8Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !l12.l0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            hd8Var.v = z6;
            if (this.G0 != null && (v98Var = this.y0.G) != null) {
                PostData Z = v98Var.Z();
                if (Z != null) {
                    z7 = Z.S;
                } else {
                    z7 = false;
                }
                hd8Var.w = z7;
            }
            hd8Var.m = true;
            if (Q.isBlocked()) {
                hd8Var.n = false;
                hd8Var.g = false;
                hd8Var.h = false;
            }
            this.G0.h.G(hd8Var);
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
        List<q05> c4;
        int i4;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            zd8 zd8Var = this.G0;
            if (zd8Var != null) {
                if (zd8Var.R1()) {
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
                if (xd8.y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.l1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.m1 = url;
                        if (this.l1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.n1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.n1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.o1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.l1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.m1 = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.o1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.l1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.m1 = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.o1 = null;
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
                        this.G0.a4(this.I2, this.l1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.G2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.F() == 1 && xd8.y(view2)) {
                this.G0.a4(this.I2, this.l1.t());
                return true;
            }
            au4 au4Var = this.A0;
            if (au4Var == null) {
                return true;
            }
            if (au4Var.e() && this.G2.O() != null && this.G2.O().equals(this.y0.g1())) {
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
            if (this.G2.F() == 1) {
                if (!z4) {
                    this.G0.b4(this.H2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.M0 == null) {
                u05 u05Var = new u05(getContext());
                this.M0 = u05Var;
                u05Var.p(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (xd8.y(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (xd8.y(view2) && (onVar = this.l1) != null && !onVar.t()) {
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
                    arrayList.add(new q05(1, getString(R.string.save_to_emotion), this.M0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new q05(2, getString(R.string.save_to_local), this.M0));
                }
                if (!z7 && !z8) {
                    q05 q05Var7 = new q05(3, getString(R.string.obfuscated_res_0x7f0f0478), this.M0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.G2);
                    q05Var7.d.setTag(sparseArray3);
                    arrayList.add(q05Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        q05Var6 = new q05(4, getString(R.string.remove_mark), this.M0);
                    } else {
                        q05Var6 = new q05(4, getString(R.string.obfuscated_res_0x7f0f0b46), this.M0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.G2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    q05Var6.d.setTag(sparseArray4);
                    arrayList.add(q05Var6);
                }
                if (this.mIsLogin) {
                    if (!uf8.j(this.y0) && !z12 && z11) {
                        q05 q05Var8 = new q05(5, getString(R.string.obfuscated_res_0x7f0f0bea), this.M0);
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
                        if (xd8.C(this.y0.l1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            q05 q05Var9 = new q05(5, getString(R.string.report_text), this.M0);
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
                        if (!uf8.j(this.y0) && z18) {
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
                                q05Var5 = new q05(6, getString(R.string.obfuscated_res_0x7f0f04d8), this.M0);
                                q05Var5.d.setTag(sparseArray6);
                                q05Var2 = new q05(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.M0);
                                q05Var2.d.setTag(sparseArray6);
                                q05Var3 = q05Var5;
                                q05Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        q05Var5 = null;
                        q05Var2 = new q05(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.M0);
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
                        if (this.y0.l1().Y() == 1002 && !z10) {
                            q05Var4 = new q05(6, getString(R.string.report_text), this.M0);
                        } else {
                            q05Var4 = new q05(6, getString(R.string.obfuscated_res_0x7f0f04d8), this.M0);
                        }
                        q05Var4.d.setTag(sparseArray7);
                        if (z17) {
                            q05Var = new q05(13, getString(R.string.multi_delete), this.M0);
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
                    uf8.b(arrayList, this.M0, this.G2, this.y0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = uf8.d(arrayList, this.G2.p(), sparseArray, this.M0);
                } else {
                    c4 = uf8.c(arrayList, this.G2.p(), sparseArray, this.M0);
                }
                uf8.m(c4, this.b);
                uf8.f(c4);
                this.M0.q(uf8.h(this.G2));
                this.M0.l(c4, !UbsABTestHelper.isPBPlanA());
                this.L0 = new s05(getPageContext(), this.M0);
                this.M0.o(new z2(this));
                this.L0.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.y0.b).param("fid", this.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.y0.I());
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

    public void h5(ForumManageModel.b bVar, zd8 zd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048681, this, bVar, zd8Var) == null) {
            List<PostData> list = this.y0.l1().V().a;
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
                zd8Var.N1(this.y0.l1());
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
            j05 j05Var = new j05(this.g1.getPageActivity());
            if (!dj.isEmpty(str)) {
                j05Var.setMessage(str);
            } else {
                j05Var.setMessage(this.g1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045b, new h(this, userMuteAddAndDelCustomMessage));
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new i(this));
            j05Var.create(this.g1).show();
        }
    }

    public void l5(j05 j05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, j05Var, jSONArray) == null) {
            j05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(j05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                k5((SparseArray) j05Var.getYesButtonTag(), jSONArray);
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
            if (pbModel == null || pbModel.l1() == null || str == null || i4 < 0) {
                return null;
            }
            v98 l12 = this.y0.l1();
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
                    if (this.y0.l1() != null && this.y0.l1().l0()) {
                        gh.a().postDelayed(new k1(this, str, str2), 0L);
                        return;
                    }
                    if (this.a1 == null) {
                        y17 y17Var = new y17(getPageContext());
                        this.a1 = y17Var;
                        y17Var.j(1);
                        this.a1.i(new l1(this, str, str2));
                    }
                    PbModel pbModel = this.y0;
                    if (pbModel != null && pbModel.l1() != null && this.y0.l1().l() != null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.a1.g(this.y0.l1().l().getId(), dh.g(this.y0.F1(), 0L));
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
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(zd8.o2, Integer.valueOf(zd8.p2));
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
                                                        zd8 zd8Var = this.G0;
                                                        if (zd8Var != null && zd8Var.K0() != null) {
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
                                            if (this.y0.l1() != null && this.y0.l1().Q() != null && this.y0.l1().Q().getPushStatusData() != null) {
                                                this.y0.l1().Q().getPushStatusData().setStatus(2);
                                                return;
                                            }
                                            return;
                                        }
                                        int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                        if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                            tr8.g().m(getPageContext());
                                            r7();
                                            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
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
                        tr8.g().m(getPageContext());
                        return;
                    }
                    od8.b().m();
                    this.x0.postDelayed(new i2(this), 1000L);
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
            this.G0 = new zd8(this, this.m2, this.Y1);
            zi6 zi6Var = new zi6(getActivity());
            this.d = zi6Var;
            zi6Var.i(W2);
            this.d.d(this.P2);
            this.G0.s3(this.w2);
            this.G0.r3(this.C2);
            this.G0.k3(this.z2);
            this.G0.l3(this.A2);
            this.G0.i3(aw4.c().g());
            this.G0.p3(this.E2);
            this.G0.v3(this.K2);
            this.G0.t3(this.L2);
            this.G0.q3(this.N2);
            this.G0.o3(this.y2);
            this.G0.t4(this.mIsLogin);
            this.G0.f3(this.y0.U1());
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
            this.G0.b3(this.j2);
            this.G0.e3(this.y0.T0());
            this.G0.u3(this.y0.k1());
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
        zd8 zd8Var;
        zd8 zd8Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.g1 = getPageContext();
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
                this.R2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.S2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.T2 = intent.getStringExtra("key_manga_title");
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
                this.r1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                ez4 ez4Var = new ez4();
                this.c0 = ez4Var;
                ez4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.t1 = intExtra;
                if (intExtra == 0) {
                    this.t1 = intent.getIntExtra("key_start_from", 0);
                }
                this.u1 = intent.getStringExtra("last_tid");
            } else {
                this.m = System.currentTimeMillis();
            }
            this.q = this.o - this.m;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.k = 0;
            j6(bundle);
            if (this.y0.l1() != null) {
                this.y0.l1().U0(this.P);
            }
            a6();
            if (intent != null && (zd8Var2 = this.G0) != null) {
                zd8Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.j1 == null) {
                        this.j1 = new m0(this, intent);
                    }
                    gh.a().postDelayed(this.j1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.y0.l1() != null) {
                    this.y0.W2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            Z5(bundle);
            qd5 qd5Var = new qd5();
            this.U0 = qd5Var;
            Q6(qd5Var);
            od5 od5Var = (od5) this.U0.a(getActivity());
            this.V0 = od5Var;
            od5Var.W(this.a.getPageContext());
            this.V0.f0(this.o2);
            this.V0.g0(this.b1);
            this.V0.Y(1);
            this.V0.A(this.a.getPageContext(), bundle);
            this.V0.b().b(new vb5(getActivity()));
            this.V0.b().E(true);
            T6(true);
            this.V0.J(this.y0.N0(), this.y0.F1(), this.y0.J0());
            registerListener(this.B1);
            if (!this.y0.Y0()) {
                this.V0.q(this.y0.F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.y0.W1()) {
                this.V0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                zd8 zd8Var3 = this.G0;
                if (zd8Var3 != null) {
                    this.V0.c0(zd8Var3.l1());
                }
            }
            registerListener(this.A1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.z1);
            registerListener(this.e2);
            registerListener(this.f2);
            registerListener(this.u2);
            registerListener(this.y1);
            b29 b29Var = new b29("pb", b29.d);
            this.T0 = b29Var;
            b29Var.d();
            registerListener(this.J1);
            registerListener(this.U1);
            this.y0.s2();
            registerListener(this.t2);
            registerListener(this.h2);
            registerListener(this.n2);
            registerListener(this.P1);
            registerListener(this.g2);
            registerListener(this.K1);
            zd8 zd8Var4 = this.G0;
            if (zd8Var4 != null && zd8Var4.s1() != null && this.G0.q1() != null) {
                ff8 ff8Var = new ff8(getActivity(), this.G0.s1(), this.G0.q1(), this.G0.h1());
                this.e = ff8Var;
                ff8Var.t(this.T1);
            }
            if (this.c && (zd8Var = this.G0) != null && zd8Var.q1() != null) {
                this.G0.q1().setVisibility(8);
            }
            u35 u35Var = new u35();
            this.h1 = u35Var;
            u35Var.a = 1000L;
            registerListener(this.d2);
            registerListener(this.c2);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.M1);
            registerListener(this.N1);
            registerListener(this.F1);
            registerListener(this.G1);
            registerListener(this.H1);
            this.L1.setSelfListener(true);
            this.L1.setTag(this.a.getUniqueId());
            this.L1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.L1);
            registerResponsedEventListener(TipEvent.class, this.V1);
            registerResponsedEventListener(TopToastEvent.class, this.W1);
            this.i1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.i1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.i1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.X1 = new h3(this.G0, this);
            this.y0.F0().K(this.X1);
            this.K0 = new ce8();
            if (this.V0.s() != null) {
                this.K0.m(this.V0.s().i());
            }
            this.V0.V(this.c1);
            this.F0 = new ShareSuccessReplyToServerModel();
            U4(this.w1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
            dg8 dg8Var = new dg8(getContext());
            this.z0 = dg8Var;
            dg8Var.b(getUniqueId());
            m09.g().i(getUniqueId());
            nw4.b().l("3", "");
            this.v1 = new kc6(getPageContext());
            this.u0 = new sf8(this, getUniqueId(), this.G0, this.y0);
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
                j05 j05Var = new j05(getPageContext().getPageActivity());
                j05Var.setMessage(string);
                j05Var.setPositiveButton(R.string.dialog_known, new d2(this));
                j05Var.setCancelable(true);
                j05Var.create(getPageContext());
                j05Var.show();
            } else if (bVar.d != 0) {
                this.G0.F0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> H = this.y0.l1().H();
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
                    this.y0.l1().Q().setReply_num(this.y0.l1().Q().getReply_num() - 1);
                    this.G0.N1(this.y0.l1());
                } else if (i5 == 0) {
                    f5();
                } else if (i5 == 2) {
                    ArrayList<PostData> H2 = this.y0.l1().H();
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
                        this.G0.N1(this.y0.l1());
                    }
                    h5(bVar, this.G0);
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
                                    int i8 = (int) ej.i(TbadkCoreApplication.getInst());
                                    int width = I.get(i7).O().getWidth() * i8;
                                    int height = I.get(i7).O().getHeight() * i8;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.D2 = i7;
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
        v98 l12 = this.y0.l1();
        TbRichText u7 = u7(str, i4);
        if (u7 == null || (tbRichTextData = u7.I().get(this.D2)) == null) {
            return;
        }
        eVar.f = String.valueOf(u7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.O().N()) {
            eVar.h = false;
            String a4 = w98.a(tbRichTextData);
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
            imageUrlData.originalUrl = xd8.o(tbRichTextData);
            imageUrlData.originalUrl = xd8.o(tbRichTextData);
            imageUrlData.originalSize = xd8.p(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = xd8.l(tbRichTextData);
            imageUrlData.isLongPic = xd8.k(tbRichTextData);
            imageUrlData.postId = u7.getPostId();
            imageUrlData.mIsReserver = this.y0.w1();
            imageUrlData.mIsSeeHost = this.y0.O0();
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
            imageUrlData.threadId = dh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = l12.H().size();
        this.F2 = false;
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
                this.F2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.I().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.I().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int i10 = (int) ej.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.O().getWidth() * i10;
                        int height = tbRichTextData.O().getHeight() * i10;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.O().N()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = w98.a(tbRichTextData);
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
                                        imageUrlData.originalUrl = xd8.o(tbRichTextData);
                                        imageUrlData.originalSize = xd8.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = xd8.l(tbRichTextData);
                                        imageUrlData.isLongPic = xd8.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = dh.g(this.y0.F1(), -1L);
                                        imageUrlData.mIsReserver = this.y0.w1();
                                        imageUrlData.mIsSeeHost = this.y0.O0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.F2) {
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
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.l1() != null && this.y0.l1().l() != null) {
                if (a5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.y0.l1().l0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.G0.m0();
                    return;
                } else {
                    if (this.Z0 == null) {
                        y17 y17Var = new y17(getPageContext());
                        this.Z0 = y17Var;
                        y17Var.j(0);
                        this.Z0.i(new i1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Z0.g(this.y0.l1().l().getId(), dh.g(this.y0.F1(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
