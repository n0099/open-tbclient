package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
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
import com.baidu.tieba.a28;
import com.baidu.tieba.a48;
import com.baidu.tieba.av4;
import com.baidu.tieba.av7;
import com.baidu.tieba.ay4;
import com.baidu.tieba.ay7;
import com.baidu.tieba.b08;
import com.baidu.tieba.b18;
import com.baidu.tieba.b55;
import com.baidu.tieba.bt4;
import com.baidu.tieba.c18;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cc7;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d08;
import com.baidu.tieba.d86;
import com.baidu.tieba.dt4;
import com.baidu.tieba.e08;
import com.baidu.tieba.e25;
import com.baidu.tieba.e38;
import com.baidu.tieba.e55;
import com.baidu.tieba.e86;
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.eo;
import com.baidu.tieba.er6;
import com.baidu.tieba.ey4;
import com.baidu.tieba.ez7;
import com.baidu.tieba.f45;
import com.baidu.tieba.fj;
import com.baidu.tieba.fs4;
import com.baidu.tieba.fy7;
import com.baidu.tieba.gr4;
import com.baidu.tieba.gu4;
import com.baidu.tieba.gz7;
import com.baidu.tieba.hh;
import com.baidu.tieba.hj5;
import com.baidu.tieba.hn8;
import com.baidu.tieba.ii5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.in8;
import com.baidu.tieba.io;
import com.baidu.tieba.iw6;
import com.baidu.tieba.iw7;
import com.baidu.tieba.j35;
import com.baidu.tieba.jq4;
import com.baidu.tieba.k75;
import com.baidu.tieba.ks4;
import com.baidu.tieba.kw7;
import com.baidu.tieba.l55;
import com.baidu.tieba.l75;
import com.baidu.tieba.lh5;
import com.baidu.tieba.m75;
import com.baidu.tieba.m85;
import com.baidu.tieba.mi5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mt4;
import com.baidu.tieba.mw7;
import com.baidu.tieba.my4;
import com.baidu.tieba.n16;
import com.baidu.tieba.n35;
import com.baidu.tieba.n75;
import com.baidu.tieba.ny4;
import com.baidu.tieba.ny7;
import com.baidu.tieba.nz7;
import com.baidu.tieba.o35;
import com.baidu.tieba.od8;
import com.baidu.tieba.oh5;
import com.baidu.tieba.p18;
import com.baidu.tieba.p35;
import com.baidu.tieba.p75;
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
import com.baidu.tieba.pd5;
import com.baidu.tieba.pl5;
import com.baidu.tieba.pn;
import com.baidu.tieba.pu4;
import com.baidu.tieba.q05;
import com.baidu.tieba.q9;
import com.baidu.tieba.qb;
import com.baidu.tieba.qn8;
import com.baidu.tieba.qx4;
import com.baidu.tieba.qz4;
import com.baidu.tieba.r18;
import com.baidu.tieba.r35;
import com.baidu.tieba.r75;
import com.baidu.tieba.r9;
import com.baidu.tieba.ra7;
import com.baidu.tieba.rd5;
import com.baidu.tieba.rl4;
import com.baidu.tieba.ro4;
import com.baidu.tieba.ru4;
import com.baidu.tieba.ru8;
import com.baidu.tieba.ry7;
import com.baidu.tieba.s18;
import com.baidu.tieba.s55;
import com.baidu.tieba.sa5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sl4;
import com.baidu.tieba.sl5;
import com.baidu.tieba.sl8;
import com.baidu.tieba.t08;
import com.baidu.tieba.t18;
import com.baidu.tieba.t25;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tc5;
import com.baidu.tieba.tr5;
import com.baidu.tieba.u18;
import com.baidu.tieba.u28;
import com.baidu.tieba.ua7;
import com.baidu.tieba.uf8;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uu8;
import com.baidu.tieba.uv7;
import com.baidu.tieba.ux4;
import com.baidu.tieba.v55;
import com.baidu.tieba.vd5;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vq4;
import com.baidu.tieba.vr4;
import com.baidu.tieba.vv7;
import com.baidu.tieba.vw7;
import com.baidu.tieba.w55;
import com.baidu.tieba.wg;
import com.baidu.tieba.wn8;
import com.baidu.tieba.wu4;
import com.baidu.tieba.wu7;
import com.baidu.tieba.ww7;
import com.baidu.tieba.x08;
import com.baidu.tieba.x45;
import com.baidu.tieba.x55;
import com.baidu.tieba.xi6;
import com.baidu.tieba.yc5;
import com.baidu.tieba.yu4;
import com.baidu.tieba.yu7;
import com.baidu.tieba.yz7;
import com.baidu.tieba.z18;
import com.baidu.tieba.zo4;
import com.baidu.tieba.zt4;
import com.baidu.tieba.zu4;
import com.baidu.tieba.zw7;
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
import tbclient.ForumToolPerm;
import tbclient.PbPage.PbSortType;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class PbFragment extends BaseFragment implements sl5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, pu4.e, TbRichTextView.s, TbPageContextSupport, e38, a48.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k P2;
    public static final e86.b Q2;
    public transient /* synthetic */ FieldHolder $fh;
    public vg A;
    public mw7 A0;
    public CustomMessageListener A1;
    public PostData A2;
    public vg B;
    public PollingModel B0;
    public CustomMessageListener B1;
    public final ru4.c B2;
    public vg C;
    public ShareSuccessReplyToServerModel C0;
    public final CustomMessageListener C1;
    public final ru4.c C2;
    public vg D;
    public yz7 D0;
    public CustomMessageListener D1;
    public final AdapterView.OnItemClickListener D2;
    public vg E;
    public boolean E0;
    public CustomMessageListener E1;
    public final View.OnLongClickListener E2;
    public vg F;
    public boolean F0;
    public View.OnClickListener F1;
    public final View.OnClickListener F2;
    public vg G;
    public boolean G0;
    public CustomMessageListener G1;
    public final ItemCardHelper.c G2;
    public boolean H;
    public b08 H0;
    public CustomMessageListener H1;
    public final NoNetworkView.b H2;
    public boolean I;
    public yu4 I0;
    public CustomMessageListener I1;
    public View.OnTouchListener I2;
    public boolean J;
    public av4 J0;
    public SuggestEmotionModel.c J1;
    public d86.b J2;
    public vg K;
    public String K0;
    public CustomMessageListener K1;
    public final ny7.b K2;
    public String L;
    public boolean L0;
    public CustomMessageListener L1;
    public int L2;
    public boolean M;
    public boolean M0;
    public GetSugMatchWordsModel.b M1;
    public int M2;
    public boolean N;
    public boolean N0;
    public boolean N1;
    public String N2;
    public String O;
    public String O0;
    public PraiseModel O1;
    public vr4 O2;
    public LikeModel P;
    public boolean P0;
    public c18.h P1;
    public View Q;
    public in8 Q0;
    public CustomMessageListener Q1;
    public View R;
    public p75 R0;
    public sa5 R1;
    public View S;
    public n75 S0;
    public CheckRealNameModel.b S1;
    public View T;
    public boolean T0;
    public ww7 T1;
    public String U;
    public PermissionJudgePolicy U0;
    public final Runnable U1;
    public int V;
    public ReplyPrivacyCheckController V0;
    public CustomMessageListener V1;
    public boolean W;
    public er6 W0;
    public CustomMessageListener W1;
    public int[] X;
    public er6 X0;
    public CustomMessageListener X1;
    public int Y;
    public l75 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public k75 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public k75 a1;
    public CustomMessageListener a2;
    public boolean b;
    public mt4 b0;
    public int b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public Object c1;
    public CustomMessageListener c2;
    public e86 d;
    public qx4 d0;
    public r9 d1;
    public pu4.e d2;
    public c18 e;
    public boolean e0;
    public ay4 e1;
    public av4.e e2;
    public boolean f;
    public boolean f0;
    public BdUniqueId f1;
    public SortSwitchButton.f f2;
    public boolean g;
    public Object g0;
    public Runnable g1;
    public final View.OnClickListener g2;
    public boolean h;
    public hn8 h0;
    public d08 h1;
    public CustomMessageListener h2;
    public boolean i;
    public o35 i0;
    public pn i1;
    public final NewWriteModel.d i2;
    public VoiceManager j;
    public boolean j0;
    public String j1;
    public Boolean j2;
    public int k;
    public TbRichTextImageInfo k1;
    public NewWriteModel.d k2;
    public ru4 l;
    public TbRichTextMemeInfo l1;
    public qb l2;
    public long m;
    public boolean m1;
    public final PbModel.h m2;
    public long n;
    public int n1;
    public CustomMessageListener n2;
    public long o;
    public int o1;
    public HttpMessageListener o2;
    public long p;
    public List p1;
    public final ro4.a p2;
    public long q;
    public boolean q0;
    public int q1;
    public final AbsListView.OnScrollListener q2;
    public boolean r;
    public TiePlusEventController.f r0;
    public String r1;
    public final q9 r2;
    public boolean s;
    public p18 s0;
    public n16 s1;
    public final i3 s2;
    public pd5 t;
    public PbInterviewStatusView.f t0;
    public final f3 t1;
    public final ey4.g t2;
    public long u;
    public final Handler u0;
    public final ez7.b u1;
    public final View.OnClickListener u2;
    public boolean v;
    public PbModel v0;
    public final CustomMessageListener v1;
    public boolean v2;
    public long w;
    public a28 w0;
    public CustomMessageListener w1;
    public final BdListView.p w2;
    public int x;
    public ro4 x0;
    public CustomMessageListener x1;
    public int x2;
    public String y;
    public ForumManageModel y0;
    public CustomMessageListener y1;
    public final TbRichTextView.y y2;
    public vg z;
    public t25 z0;
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

    public final int M5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i4)) == null) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return i4 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.sl5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, context, str) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.e38
    /* renamed from: T5 */
    public VideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i d1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public void f1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048682, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.e38
    public PbFragment k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public boolean n6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i4)) == null) ? i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 : invokeI.booleanValue;
    }

    public final boolean o6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048714, this, i4)) == null) ? i4 == 2 || i4 == 1 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048734, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class i1 implements er6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        @Override // com.baidu.tieba.er6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.er6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0367a implements TextWatcher {
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

                public C0367a(a aVar) {
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
                    b08 b08Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (b08Var = this.a.a.c.H0) != null && b08Var.g() != null) {
                        if (!this.a.a.c.H0.g().e()) {
                            this.a.a.c.H0.b(false);
                        }
                        this.a.a.c.H0.g().l(false);
                    }
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

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = fj.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.O5().T0().smoothScrollBy((pbFragment.X[1] + pbFragment.Y) - i3, 50);
                    if (this.a.c.O5().d1() != null) {
                        this.a.c.S0.b().setVisibility(8);
                        z = (this.a.c.v0 == null || this.a.c.v0.S1() == null || this.a.c.v0.S1().P() == null || !this.a.c.v0.S1().P().isBjh()) ? false : false;
                        ry7 d1 = this.a.c.O5().d1();
                        i1 i1Var = this.a;
                        d1.o(i1Var.a, i1Var.b, i1Var.c.O5().f1(), z);
                        r75 b = this.a.c.O5().d1().b();
                        if (b != null && this.a.c.v0 != null && this.a.c.v0.S1() != null) {
                            b.H(this.a.c.v0.S1().d());
                            b.d0(this.a.c.v0.S1().P());
                        }
                        if (this.a.c.H0.f() == null && this.a.c.O5().d1().b().u() != null) {
                            this.a.c.O5().d1().b().u().g(new C0367a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.H0.n(pbFragment2.O5().d1().b().u().i());
                            this.a.c.O5().d1().b().N(this.a.c.a1);
                        }
                    }
                    this.a.c.O5().p1();
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

        @Override // com.baidu.tieba.er6.d
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
                hh.a().postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ g2 b;

            public a(g2 g2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = g2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    zw7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                hh.a().postDelayed(new a(this, customDialogData), 1000L);
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
                b08 b08Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (b08Var = this.a.c.H0) != null && b08Var.g() != null) {
                    if (!this.a.c.H0.g().e()) {
                        this.a.c.H0.b(false);
                    }
                    this.a.c.H0.g().l(false);
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
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = fj.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = fj.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = fj.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.O5().T0().smoothScrollBy((pbFragment.X[1] + pbFragment.Y) - i3, 50);
                if (this.c.O5().d1() != null) {
                    this.c.S0.b().setVisibility(8);
                    this.c.O5().d1().o(this.a, this.b, this.c.O5().f1(), (this.c.v0 == null || this.c.v0.S1() == null || this.c.v0.S1().P() == null || !this.c.v0.S1().P().isBjh()) ? false : false);
                    r75 b = this.c.O5().d1().b();
                    if (b != null && this.c.v0 != null && this.c.v0.S1() != null) {
                        b.H(this.c.v0.S1().d());
                        b.d0(this.c.v0.S1().P());
                    }
                    if (this.c.H0.f() == null && this.c.O5().d1().b().u() != null) {
                        this.c.O5().d1().b().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.H0.n(pbFragment2.O5().d1().b().u().i());
                        this.c.O5().d1().b().N(this.c.a1);
                    }
                }
                this.c.O5().p1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:783:0x1e5c, code lost:
            if (r7 == (r32.a.D0.e1().c().getHeight() - r32.a.D0.e1().e())) goto L829;
         */
        /* JADX WARN: Code restructure failed: missing block: B:821:0x1fe8, code lost:
            if (r32.a.D0.d1.c.getView().getTop() <= ((r32.a.D0.e1() == null || r32.a.D0.e1().c() == null) ? 0 : r32.a.D0.e1().c().getBottom())) goto L758;
         */
        /* JADX WARN: Code restructure failed: missing block: B:822:0x1fea, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:824:0x1ff7, code lost:
            if (r0 >= com.baidu.tieba.t08.d(r32.a.F5())) goto L758;
         */
        /* JADX WARN: Code restructure failed: missing block: B:846:0x209e, code lost:
            if ((r32.a.D0.d1.c.getView().getTop() - r32.a.D0.h.a.getBottom()) < (r32.a.D0.d1.c.g.getHeight() + 10)) goto L758;
         */
        /* JADX WARN: Removed duplicated region for block: B:1115:0x2a31  */
        /* JADX WARN: Removed duplicated region for block: B:1116:0x2a47  */
        /* JADX WARN: Removed duplicated region for block: B:1119:0x2a83  */
        /* JADX WARN: Removed duplicated region for block: B:1361:0x3433  */
        /* JADX WARN: Removed duplicated region for block: B:1362:0x3438  */
        /* JADX WARN: Removed duplicated region for block: B:1365:0x3447  */
        /* JADX WARN: Removed duplicated region for block: B:1399:0x34f5  */
        /* JADX WARN: Removed duplicated region for block: B:1402:0x3504  */
        /* JADX WARN: Removed duplicated region for block: B:1405:0x3517  */
        /* JADX WARN: Removed duplicated region for block: B:1408:0x3528  */
        /* JADX WARN: Removed duplicated region for block: B:1411:0x353e  */
        /* JADX WARN: Removed duplicated region for block: B:1413:0x3547  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            uv7 S1;
            int i;
            int i2;
            PostData Y;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            wu4 wu4Var;
            wu4 wu4Var2;
            wu4 wu4Var3;
            PbFragment pbFragment;
            int i3;
            boolean z;
            wu4 wu4Var4;
            wu4 wu4Var5;
            wu4 wu4Var6;
            wu4 wu4Var7;
            String name;
            int i4;
            boolean z2;
            int fixedNavHeight;
            int i5;
            int i6;
            gu4 gu4Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.q0 && (view2 == this.a.D0.h.c || view2 == this.a.D0.h.d || view2.getId() == R.id.obfuscated_res_0x7f09184e || view2.getId() == R.id.obfuscated_res_0x7f090a19 || view2.getId() == R.id.obfuscated_res_0x7f091bf9 || view2.getId() == R.id.obfuscated_res_0x7f0917ec)) {
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
                        String str = (String) view2.getTag(R.id.obfuscated_res_0x7f090a98);
                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a83);
                        String str3 = (String) view2.getTag(R.id.obfuscated_res_0x7f09218d);
                        if (this.a.P != null) {
                            this.a.P.Q(str, str2);
                        }
                        TbPageTag l = yc5.l(this.a.getContext());
                        u18.a("c14278", str2, str3, TbadkCoreApplication.getCurrentAccount(), l != null ? l.locatePage : "");
                    } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().r()) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                            return;
                        }
                        this.a.D0.p0();
                        this.a.C7();
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
                                this.a.C7();
                                return;
                            }
                            this.a.i = false;
                            fj.x(this.a.a, this.a.D0.h.f);
                            this.a.a.finish();
                        } else if (view2 == this.a.D0.F0() || (this.a.D0.h.n() != null && (view2 == this.a.D0.h.n().s() || view2 == this.a.D0.h.n().t()))) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                return;
                            } else if (this.a.v0.S1() == null || this.a.y0.S()) {
                                return;
                            } else {
                                this.a.D0.p0();
                                int i9 = (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().t()) ? (this.a.D0.h.n() == null || view2 != this.a.D0.h.n().s()) ? view2 == this.a.D0.F0() ? 2 : 0 : this.a.v0.S1().P().getIs_good() == 1 ? 3 : 6 : this.a.v0.S1().P().getIs_top() == 1 ? 5 : 4;
                                ForumData l2 = this.a.v0.S1().l();
                                String name3 = l2.getName();
                                String id = l2.getId();
                                String id2 = this.a.v0.S1().P().getId();
                                this.a.D0.g4();
                                this.a.y0.W(id, name3, id2, i9, this.a.D0.G0());
                            }
                        } else if (view2 == this.a.D0.M0()) {
                            if (this.a.v0 != null) {
                                zo4.o(this.a.getPageContext().getPageActivity(), this.a.v0.S1().P().getTopicData().b());
                            }
                        } else if (view2 == this.a.D0.h.c) {
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            if (this.a.v0.S1() != null && this.a.v0.S1().P() != null && this.a.v0.S1().P().isVideoThreadType() && this.a.v0.S1().P().getThreadVideoInfo() != null) {
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
                            if (lh5.a()) {
                                return;
                            }
                            if (this.a.v0 == null || this.a.v0.S1() == null) {
                                fj.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0b));
                                return;
                            }
                            ArrayList G = this.a.v0.S1().G();
                            if ((G == null || G.size() <= 0) && this.a.v0.k2()) {
                                fj.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0b));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.v0.m2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.v0.getForumId()));
                            if (!this.a.D0.R1()) {
                                this.a.D0.N2();
                            }
                            this.a.H6();
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09180f) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                return;
                            }
                            this.a.D0.c3(true);
                            this.a.D0.N2();
                            if (this.a.h) {
                                return;
                            }
                            this.a.h = true;
                            this.a.D0.X3();
                            this.a.C7();
                            this.a.D0.s3();
                            this.a.v0.J3(this.a.w5());
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917e7) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                return;
                            }
                            this.a.D0.p0();
                            if (view2.getId() != R.id.obfuscated_res_0x7f0917e7 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                if (!this.a.Z4(11009) || this.a.v0.i1(this.a.D0.S0()) == null) {
                                    return;
                                }
                                this.a.z6();
                                if (this.a.v0.S1() != null && this.a.v0.S1().P() != null && this.a.v0.S1().P().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.S1().m()).param("obj_locate", 3).param("uid", this.a.v0.S1().P().getAuthor().getUserId()));
                                }
                                if (this.a.v0.S1().P() != null && this.a.v0.S1().P().getAuthor() != null && this.a.v0.S1().P().getAuthor().getUserId() != null && this.a.x0 != null) {
                                    PbFragment pbFragment2 = this.a;
                                    int S5 = pbFragment2.S5(pbFragment2.v0.S1());
                                    ThreadData P = this.a.v0.S1().P();
                                    if (P.isBJHArticleThreadType()) {
                                        i8 = 2;
                                    } else if (P.isBJHVideoThreadType()) {
                                        i8 = 3;
                                    } else if (P.isBJHNormalThreadType()) {
                                        i8 = 4;
                                    } else {
                                        i8 = P.isBJHVideoDynamicThreadType() ? 5 : 1;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v0.b).param("obj_locate", 1).param("obj_id", this.a.v0.S1().P().getAuthor().getUserId()).param("obj_type", !this.a.x0.e()).param("obj_source", S5).param("obj_param1", i8));
                                }
                            } else {
                                this.a.T = view2;
                                return;
                            }
                        } else if ((this.a.D0.h.n() != null && view2 == this.a.D0.h.n().p()) || view2.getId() == R.id.obfuscated_res_0x7f090a19 || view2.getId() == R.id.obfuscated_res_0x7f091bf9) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
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
                            this.a.C7();
                            this.a.D0.s3();
                            boolean K3 = view2.getId() == R.id.obfuscated_res_0x7f090a19 ? this.a.v0.K3(true, this.a.w5()) : view2.getId() == R.id.obfuscated_res_0x7f091bf9 ? this.a.v0.K3(false, this.a.w5()) : this.a.v0.J3(this.a.w5());
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
                            if (view2.getId() != R.id.obfuscated_res_0x7f091e97) {
                                if (view2.getId() == R.id.obfuscated_res_0x7f0917ec || view2.getId() == R.id.obfuscated_res_0x7f091e92) {
                                    if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (S1 = this.a.v0.S1()) == null) {
                                        return;
                                    }
                                    ThreadData P2 = S1.P();
                                    if (P2 != null && P2.getAuthor() != null) {
                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", S1.m()).param("obj_locate", 4).param("uid", P2.getAuthor().getUserId()));
                                    }
                                    if (P2 != null) {
                                        if (P2.isBJHArticleThreadType()) {
                                            i = 2;
                                        } else if (P2.isBJHVideoThreadType()) {
                                            i = 3;
                                        } else if (P2.isBJHNormalThreadType()) {
                                            i = 4;
                                        } else if (P2.isBJHVideoDynamicThreadType()) {
                                            i = 5;
                                        }
                                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                        statisticItem3.param("tid", this.a.v0.m2());
                                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem3.param("fid", this.a.v0.getForumId());
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091e97) {
                                            statisticItem3.param("obj_locate", 5);
                                        } else {
                                            statisticItem3.param("obj_locate", 6);
                                        }
                                        statisticItem3.param("obj_name", i);
                                        statisticItem3.param("obj_type", 1);
                                        if (P2 != null) {
                                            if (P2.isBJHArticleThreadType()) {
                                                statisticItem3.param("obj_type", 10);
                                            } else if (P2.isBJHVideoThreadType()) {
                                                statisticItem3.param("obj_type", 9);
                                            } else if (P2.isBJHVideoDynamicThreadType()) {
                                                statisticItem3.param("obj_type", 8);
                                            } else if (P2.isBJHNormalThreadType()) {
                                                statisticItem3.param("obj_type", 7);
                                            } else if (P2.isShareThread) {
                                                statisticItem3.param("obj_type", 6);
                                            } else {
                                                int i10 = P2.threadType;
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
                                                    statisticItem3.param("card_type", P2.getRecomCardType());
                                                    statisticItem3.param("recom_source", P2.mRecomSource);
                                                    statisticItem3.param("ab_tag", P2.mRecomAbTag);
                                                    statisticItem3.param("weight", P2.mRecomWeight);
                                                    statisticItem3.param("extra", P2.mRecomExtra);
                                                    statisticItem3.param("nid", P2.getNid());
                                                    if (P2.getBaijiahaoData() != null && !ej.isEmpty(P2.getBaijiahaoData().oriUgcVid)) {
                                                        statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, P2.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                            }
                                            statisticItem3.param("card_type", P2.getRecomCardType());
                                            statisticItem3.param("recom_source", P2.mRecomSource);
                                            statisticItem3.param("ab_tag", P2.mRecomAbTag);
                                            statisticItem3.param("weight", P2.mRecomWeight);
                                            statisticItem3.param("extra", P2.mRecomExtra);
                                            statisticItem3.param("nid", P2.getNid());
                                            if (P2.getBaijiahaoData() != null) {
                                                statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, P2.getBaijiahaoData().oriUgcVid);
                                            }
                                        }
                                        if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                            statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                        }
                                        if (this.a.P() != null) {
                                            yc5.e(this.a.P(), statisticItem3);
                                        }
                                        if (this.a.D0 != null) {
                                            statisticItem3.param("obj_param1", this.a.D0.P0());
                                        }
                                        TiebaStatic.log(statisticItem3);
                                        if (fj.D()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c68);
                                            return;
                                        } else if (S1 == null) {
                                            fj.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0b));
                                            return;
                                        } else {
                                            ArrayList G2 = this.a.v0.S1().G();
                                            if ((G2 == null || G2.size() <= 0) && this.a.v0.k2()) {
                                                fj.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0b));
                                                return;
                                            }
                                            this.a.D0.p0();
                                            this.a.C7();
                                            if (S1.A() != null && !StringUtils.isNull(S1.A().a(), true)) {
                                                TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.v0.S1().m()));
                                            }
                                            TiebaStatic.log(new StatisticItem("c11939"));
                                            if (AntiHelper.e(this.a.getContext(), P2)) {
                                                return;
                                            }
                                            if (this.a.D0 != null) {
                                                this.a.D0.r0();
                                                this.a.D0.n4(S1);
                                            }
                                            if (ShareSwitch.isOn()) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0917ec) {
                                                    i2 = 2;
                                                } else {
                                                    i2 = view2.getId() == R.id.obfuscated_res_0x7f091e97 ? 1 : 6;
                                                }
                                                if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.D0.T1() && !S1.p0()) {
                                                    if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                        if (j35.c() > 0) {
                                                            this.a.g7();
                                                        } else {
                                                            int P0 = this.a.D0.P0();
                                                            this.a.D0.e0();
                                                            this.a.c6(j35.a(), P0);
                                                        }
                                                    } else {
                                                        this.a.w7(i2);
                                                    }
                                                } else {
                                                    this.a.w7(i2);
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
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091e97) {
                                    }
                                    statisticItem32.param("obj_name", i);
                                    statisticItem32.param("obj_type", 1);
                                    if (P2 != null) {
                                    }
                                    if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    }
                                    if (this.a.P() != null) {
                                    }
                                    if (this.a.D0 != null) {
                                    }
                                    TiebaStatic.log(statisticItem32);
                                    if (fj.D()) {
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
                                                    wn8.d("c10725", null);
                                                } else {
                                                    uv7 S12 = this.a.v0.S1();
                                                    if (S12 != null && S12.P() != null && S12.P().getTaskInfoData() != null) {
                                                        String d = S12.P().getTaskInfoData().d();
                                                        if (StringUtils.isNull(d)) {
                                                            d = S12.P().getTaskInfoData().f();
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                    }
                                                }
                                                this.a.V5();
                                            } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().n()) {
                                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                    return;
                                                }
                                                this.a.D0.p0();
                                                SparseArray U0 = this.a.D0.U0(this.a.v0.S1(), this.a.v0.k2(), 1);
                                                if (U0 == null) {
                                                    return;
                                                }
                                                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.S1().l().getId(), this.a.v0.S1().l().getName(), this.a.v0.S1().P().getId(), String.valueOf(this.a.v0.S1().W().getUserId()), (String) U0.get(R.id.obfuscated_res_0x7f092049), (String) U0.get(R.id.obfuscated_res_0x7f09204a), (String) U0.get(R.id.obfuscated_res_0x7f09204c), (String) U0.get(R.id.obfuscated_res_0x7f09204b))));
                                            } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().j()) {
                                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                    return;
                                                }
                                                SparseArray U02 = this.a.D0.U0(this.a.v0.S1(), this.a.v0.k2(), 1);
                                                if (U02 != null) {
                                                    this.a.D0.t2(((Integer) U02.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) U02.get(R.id.obfuscated_res_0x7f09203e), ((Integer) U02.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) U02.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                                                }
                                                this.a.D0.h.k();
                                                if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().P() != null) {
                                                    ThreadData P3 = this.a.K().S1().P();
                                                    StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                    statisticItem4.param("tid", P3.getId());
                                                    statisticItem4.param("fid", P3.getFid());
                                                    statisticItem4.param("fname", P3.getForum_name());
                                                    TiebaStatic.log(statisticItem4);
                                                    StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                    statisticItem5.param("tid", P3.getId());
                                                    statisticItem5.param("fid", P3.getFid());
                                                    statisticItem5.param("fname", P3.getForum_name());
                                                    statisticItem5.param("obj_source", 3);
                                                    TiebaStatic.log(statisticItem5);
                                                }
                                            } else if (this.a.D0.h.n() != null && view2 == this.a.D0.h.n().m()) {
                                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                    return;
                                                }
                                                SparseArray U03 = this.a.D0.U0(this.a.v0.S1(), this.a.v0.k2(), 1);
                                                if (U03 != null) {
                                                    if (StringUtils.isNull((String) U03.get(R.id.obfuscated_res_0x7f09203d))) {
                                                        this.a.D0.q2(((Integer) U03.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) U03.get(R.id.obfuscated_res_0x7f09203e), ((Integer) U03.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) U03.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                                                    } else {
                                                        this.a.D0.r2(((Integer) U03.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) U03.get(R.id.obfuscated_res_0x7f09203e), ((Integer) U03.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) U03.get(R.id.obfuscated_res_0x7f09203f)).booleanValue(), (String) U03.get(R.id.obfuscated_res_0x7f09203d));
                                                    }
                                                }
                                                this.a.D0.h.k();
                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091f9e && view2.getId() != R.id.obfuscated_res_0x7f091f9c && view2.getId() != R.id.obfuscated_res_0x7f0917ff && view2.getId() != R.id.obfuscated_res_0x7f091690) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091861) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f09185f && view2.getId() != R.id.obfuscated_res_0x7f091a3f && view2.getId() != R.id.obfuscated_res_0x7f0917f9) {
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0917fd) {
                                                            try {
                                                                sparseArray = (SparseArray) view2.getTag();
                                                            } catch (ClassCastException e) {
                                                                e.printStackTrace();
                                                                sparseArray = null;
                                                            }
                                                            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
                                                            if (postData == null) {
                                                                return;
                                                            }
                                                            if (this.a.J0 == null) {
                                                                PbFragment pbFragment3 = this.a;
                                                                pbFragment3.J0 = new av4(pbFragment3.getContext());
                                                                this.a.J0.n(this.a.e2);
                                                            }
                                                            ArrayList arrayList = new ArrayList();
                                                            boolean z3 = this.a.K().S1() != null && this.a.K().S1().k0();
                                                            if (view2 != null && sparseArray != null) {
                                                                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue() : false;
                                                                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue() : false;
                                                                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue() : false;
                                                                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue() : false;
                                                                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue() : false;
                                                                String str4 = sparseArray.get(R.id.obfuscated_res_0x7f09204c) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204c) : null;
                                                                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092054)).booleanValue() : false;
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
                                                                    wu4 wu4Var8 = new wu4(8, pbFragment.getString(i3), this.a.J0);
                                                                    SparseArray sparseArray2 = new SparseArray();
                                                                    sparseArray2.put(R.id.obfuscated_res_0x7f09203c, postData);
                                                                    wu4Var8.d.setTag(sparseArray2);
                                                                    arrayList.add(wu4Var8);
                                                                }
                                                                if (this.a.mIsLogin) {
                                                                    if (!r18.i(this.a.v0) && !booleanValue3 && booleanValue2) {
                                                                        wu4 wu4Var9 = new wu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b5c), this.a.J0);
                                                                        SparseArray sparseArray3 = new SparseArray();
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                                                                        sparseArray3.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                                                                        wu4Var9.d.setTag(sparseArray3);
                                                                        arrayList.add(wu4Var9);
                                                                    } else if ((this.a.p6(booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                                        wu4 wu4Var10 = new wu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1029), this.a.J0);
                                                                        wu4Var10.d.setTag(str4);
                                                                        arrayList.add(wu4Var10);
                                                                    }
                                                                    if (booleanValue3) {
                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                                                                        sparseArray4.put(R.id.obfuscated_res_0x7f09204c, str4);
                                                                        if (booleanValue4) {
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                                                                        } else {
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                                                                        }
                                                                        if (booleanValue5) {
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(booleanValue));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                                                                            if (booleanValue6) {
                                                                                wu4 wu4Var11 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.a.J0);
                                                                                wu4Var11.d.setTag(sparseArray4);
                                                                                wu4Var2 = wu4Var11;
                                                                                wu4Var = new wu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.J0);
                                                                                wu4Var.d.setTag(sparseArray4);
                                                                            }
                                                                        } else {
                                                                            sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                                                                        }
                                                                        wu4Var2 = null;
                                                                        wu4Var = new wu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.J0);
                                                                        wu4Var.d.setTag(sparseArray4);
                                                                    } else if (booleanValue5) {
                                                                        SparseArray sparseArray5 = new SparseArray();
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(booleanValue));
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                                                        sparseArray5.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                                                                        if (this.a.v0.S1().X() == 1002 && !booleanValue) {
                                                                            wu4Var3 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1029), this.a.J0);
                                                                        } else {
                                                                            wu4Var3 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.a.J0);
                                                                        }
                                                                        wu4Var3.d.setTag(sparseArray5);
                                                                        wu4Var2 = wu4Var3;
                                                                        wu4Var = null;
                                                                    } else {
                                                                        wu4Var = null;
                                                                        wu4Var2 = null;
                                                                    }
                                                                    if (wu4Var2 != null) {
                                                                        arrayList.add(wu4Var2);
                                                                    }
                                                                    if (wu4Var != null) {
                                                                        arrayList.add(wu4Var);
                                                                    }
                                                                }
                                                                this.a.J0.j(arrayList);
                                                                this.a.I0 = new yu4(this.a.getPageContext(), this.a.J0);
                                                                this.a.I0.k();
                                                            }
                                                        } else if (view2 == this.a.D0.O0()) {
                                                            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, eh.g(this.a.v0.S1().m(), 0L), eh.g(this.a.v0.m2(), 0L), eh.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.v0.S1().P().getPushStatusData())));
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
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09078f && view2.getId() != R.id.obfuscated_res_0x7f090a16) {
                                                                int id3 = view2.getId();
                                                                if (id3 == R.id.obfuscated_res_0x7f091880) {
                                                                    if (!this.a.checkUpIsLogin() || (gu4Var = (gu4) view2.getTag()) == null || StringUtils.isNull(gu4Var.k1())) {
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{gu4Var.k1()});
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091bfc || id3 == R.id.obfuscated_res_0x7f090724 || id3 == R.id.obfuscated_res_0x7f091bfd || id3 == R.id.obfuscated_res_0x7f090725) {
                                                                    if (!this.a.checkUpIsLogin()) {
                                                                        return;
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                    if (view2 != null && view2.getTag() != null) {
                                                                        SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                        PostData postData2 = (PostData) sparseArray6.get(R.id.obfuscated_res_0x7f092059);
                                                                        if (id3 == R.id.obfuscated_res_0x7f091bfd || id3 == R.id.obfuscated_res_0x7f090725) {
                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.v0.b));
                                                                        }
                                                                        if (this.a.J0 == null) {
                                                                            PbFragment pbFragment4 = this.a;
                                                                            pbFragment4.J0 = new av4(pbFragment4.getContext());
                                                                            this.a.J0.n(this.a.e2);
                                                                        }
                                                                        ArrayList arrayList2 = new ArrayList();
                                                                        this.a.l6(view2);
                                                                        if (this.a.l6(view2) && this.a.i1 != null) {
                                                                            this.a.i1.t();
                                                                        }
                                                                        if (sparseArray6.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean) {
                                                                            ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092055)).booleanValue();
                                                                        }
                                                                        boolean booleanValue7 = sparseArray6.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f09203f)).booleanValue() : false;
                                                                        boolean booleanValue8 = sparseArray6.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092098)).booleanValue() : false;
                                                                        boolean booleanValue9 = sparseArray6.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092084)).booleanValue() : false;
                                                                        boolean booleanValue10 = sparseArray6.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092098)).booleanValue() : false;
                                                                        boolean booleanValue11 = sparseArray6.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092082)).booleanValue() : false;
                                                                        String str5 = sparseArray6.get(R.id.obfuscated_res_0x7f09204c) instanceof String ? (String) sparseArray6.get(R.id.obfuscated_res_0x7f09204c) : null;
                                                                        boolean booleanValue12 = sparseArray6.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f092054)).booleanValue() : false;
                                                                        if (postData2 != null) {
                                                                            if (postData2.X() != null && postData2.X().toString().length() > 0) {
                                                                                wu4 wu4Var12 = new wu4(3, this.a.getString(R.string.obfuscated_res_0x7f0f0459), this.a.J0);
                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                sparseArray7.put(R.id.obfuscated_res_0x7f09203c, postData2);
                                                                                wu4Var12.d.setTag(sparseArray7);
                                                                                arrayList2.add(wu4Var12);
                                                                            }
                                                                            this.a.A2 = postData2;
                                                                        }
                                                                        if (this.a.v0.S1().r()) {
                                                                            String u = this.a.v0.S1().u();
                                                                            if (postData2 != null && !ej.isEmpty(u) && u.equals(postData2.M())) {
                                                                                z = true;
                                                                                if (!z) {
                                                                                    wu4Var4 = new wu4(4, this.a.getString(R.string.obfuscated_res_0x7f0f1004), this.a.J0);
                                                                                } else {
                                                                                    wu4Var4 = new wu4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0ab8), this.a.J0);
                                                                                }
                                                                                SparseArray sparseArray8 = new SparseArray();
                                                                                sparseArray8.put(R.id.obfuscated_res_0x7f09203c, this.a.A2);
                                                                                sparseArray8.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
                                                                                wu4Var4.d.setTag(sparseArray8);
                                                                                arrayList2.add(wu4Var4);
                                                                                if (this.a.mIsLogin) {
                                                                                    if (!r18.i(this.a.v0) && !booleanValue9 && booleanValue8) {
                                                                                        wu4 wu4Var13 = new wu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b5c), this.a.J0);
                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092053, sparseArray6.get(R.id.obfuscated_res_0x7f092053));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092094, sparseArray6.get(R.id.obfuscated_res_0x7f092094));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092095, sparseArray6.get(R.id.obfuscated_res_0x7f092095));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092093, sparseArray6.get(R.id.obfuscated_res_0x7f092093));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092096, sparseArray6.get(R.id.obfuscated_res_0x7f092096));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092097, sparseArray6.get(R.id.obfuscated_res_0x7f092097));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09203f, sparseArray6.get(R.id.obfuscated_res_0x7f09203f));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092040, sparseArray6.get(R.id.obfuscated_res_0x7f092040));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09203e, sparseArray6.get(R.id.obfuscated_res_0x7f09203e));
                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09205c, sparseArray6.get(R.id.obfuscated_res_0x7f09205c));
                                                                                        wu4Var4.d.setTag(sparseArray9);
                                                                                        arrayList2.add(wu4Var13);
                                                                                    } else if (this.a.p6(booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                        wu4 wu4Var14 = new wu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1029), this.a.J0);
                                                                                        wu4Var14.d.setTag(str5);
                                                                                        arrayList2.add(wu4Var14);
                                                                                    }
                                                                                    if (booleanValue9) {
                                                                                        SparseArray sparseArray10 = new SparseArray();
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f09205c, sparseArray6.get(R.id.obfuscated_res_0x7f09205c));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f092049, sparseArray6.get(R.id.obfuscated_res_0x7f092049));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f09204a, sparseArray6.get(R.id.obfuscated_res_0x7f09204a));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f09204b, sparseArray6.get(R.id.obfuscated_res_0x7f09204b));
                                                                                        sparseArray10.put(R.id.obfuscated_res_0x7f09204c, str5);
                                                                                        if (booleanValue10) {
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092053, sparseArray6.get(R.id.obfuscated_res_0x7f092053));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092094, sparseArray6.get(R.id.obfuscated_res_0x7f092094));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092095, sparseArray6.get(R.id.obfuscated_res_0x7f092095));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092093, sparseArray6.get(R.id.obfuscated_res_0x7f092093));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092096, sparseArray6.get(R.id.obfuscated_res_0x7f092096));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092097, sparseArray6.get(R.id.obfuscated_res_0x7f092097));
                                                                                        } else {
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                                                                                        }
                                                                                        if (booleanValue11) {
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(booleanValue7));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f09203e, sparseArray6.get(R.id.obfuscated_res_0x7f09203e));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092040, sparseArray6.get(R.id.obfuscated_res_0x7f092040));
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092050, sparseArray6.get(R.id.obfuscated_res_0x7f092050));
                                                                                            if (booleanValue12) {
                                                                                                wu4 wu4Var15 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.a.J0);
                                                                                                wu4Var15.d.setTag(sparseArray10);
                                                                                                wu4Var6 = wu4Var15;
                                                                                                wu4Var5 = new wu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.J0);
                                                                                                wu4Var5.d.setTag(sparseArray10);
                                                                                            }
                                                                                        } else {
                                                                                            sparseArray10.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                                                                                        }
                                                                                        wu4Var6 = null;
                                                                                        wu4Var5 = new wu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.J0);
                                                                                        wu4Var5.d.setTag(sparseArray10);
                                                                                    } else if (booleanValue11) {
                                                                                        SparseArray sparseArray11 = new SparseArray();
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f09205c, sparseArray6.get(R.id.obfuscated_res_0x7f09205c));
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(booleanValue7));
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f09203e, sparseArray6.get(R.id.obfuscated_res_0x7f09203e));
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f092040, sparseArray6.get(R.id.obfuscated_res_0x7f092040));
                                                                                        sparseArray11.put(R.id.obfuscated_res_0x7f092050, sparseArray6.get(R.id.obfuscated_res_0x7f092050));
                                                                                        if (this.a.v0.S1().X() == 1002 && !booleanValue7) {
                                                                                            wu4Var7 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1029), this.a.J0);
                                                                                        } else {
                                                                                            wu4Var7 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.a.J0);
                                                                                        }
                                                                                        wu4Var7.d.setTag(sparseArray11);
                                                                                        wu4Var6 = wu4Var7;
                                                                                        wu4Var5 = null;
                                                                                    } else {
                                                                                        wu4Var5 = null;
                                                                                        wu4Var6 = null;
                                                                                    }
                                                                                    if (wu4Var6 != null) {
                                                                                        arrayList2.add(wu4Var6);
                                                                                    }
                                                                                    if (wu4Var5 != null) {
                                                                                        arrayList2.add(wu4Var5);
                                                                                    }
                                                                                }
                                                                                this.a.J0.j(arrayList2);
                                                                                this.a.I0 = new yu4(this.a.getPageContext(), this.a.J0);
                                                                                this.a.I0.k();
                                                                            }
                                                                        }
                                                                        z = false;
                                                                        if (!z) {
                                                                        }
                                                                        SparseArray sparseArray82 = new SparseArray();
                                                                        sparseArray82.put(R.id.obfuscated_res_0x7f09203c, this.a.A2);
                                                                        sparseArray82.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
                                                                        wu4Var4.d.setTag(sparseArray82);
                                                                        arrayList2.add(wu4Var4);
                                                                        if (this.a.mIsLogin) {
                                                                        }
                                                                        this.a.J0.j(arrayList2);
                                                                        this.a.I0 = new yu4(this.a.getPageContext(), this.a.J0);
                                                                        this.a.I0.k();
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0917ca) {
                                                                    if (this.a.v0.S1() != null && this.a.v0.S1().P() != null && this.a.v0.S1().P().getActUrl() != null) {
                                                                        zo4.o(this.a.getActivity(), this.a.v0.S1().P().getActUrl());
                                                                        if (this.a.v0.S1().P().getActInfoType() == 1) {
                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                        } else if (this.a.v0.S1().P().getActInfoType() == 2) {
                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        }
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091444) {
                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f09206b) instanceof String) {
                                                                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f09206b);
                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.v0.S1().m()).param("tid", this.a.v0.S1().R()).param("lotterytail", StringUtils.string(str6, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                        if (!this.a.v0.S1().R().equals(str6)) {
                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str6, (String) null, (String) null, (String) null)));
                                                                        } else {
                                                                            this.a.D0.w3(0);
                                                                        }
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091829 || id3 == R.id.obfuscated_res_0x7f0917f4) {
                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f139e);
                                                                        String q = ux4.k().q("tail_link", "");
                                                                        if (!StringUtils.isNull(q)) {
                                                                            TiebaStatic.log("c10056");
                                                                            zo4.s(view2.getContext(), string, q, true, true, true);
                                                                        }
                                                                        this.a.D0.N2();
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091023) {
                                                                    if (view2 != null) {
                                                                        zo4.o(this.a.getActivity(), (String) view2.getTag());
                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                        if (this.a.s5() == 1 && this.a.v0 != null && this.a.v0.S1() != null) {
                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.v0.S1().m()).param("tid", this.a.v0.S1().R()).param("uid", currentAccount));
                                                                        }
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091437) {
                                                                    if (view2 != null) {
                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                        zo4.o(this.a.getActivity(), (String) view2.getTag());
                                                                        if (this.a.s5() == 1 && this.a.v0 != null && this.a.v0.S1() != null) {
                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.v0.S1().m()).param("tid", this.a.v0.S1().R()).param("uid", currentAccount2));
                                                                        }
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091497) {
                                                                    this.a.u6();
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091496) {
                                                                    this.a.r6();
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0926d3) {
                                                                    if (this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().A() != null) {
                                                                        uv7 S13 = this.a.v0.S1();
                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", S13.m()));
                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S13.A().b()});
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0926d0) {
                                                                    if (this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().A() != null) {
                                                                        uv7 S14 = this.a.v0.S1();
                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", S14.m()));
                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S14.A().b()});
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0923c9) {
                                                                    if (this.a.n1 >= 0) {
                                                                        if (this.a.v0 != null) {
                                                                            this.a.v0.m3();
                                                                        }
                                                                        if (this.a.v0 == null || this.a.D0.D0() == null) {
                                                                            i6 = 0;
                                                                        } else {
                                                                            i6 = 0;
                                                                            this.a.D0.D0().i0(this.a.v0.S1(), false);
                                                                        }
                                                                        this.a.n1 = i6;
                                                                        if (this.a.v0 != null) {
                                                                            this.a.D0.T0().setSelection(this.a.v0.L1());
                                                                            this.a.v0.q3(0, 0);
                                                                        }
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091b21) {
                                                                    if (!this.a.Z4(11009)) {
                                                                        return;
                                                                    }
                                                                    this.a.d6(8);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f091690) {
                                                                    SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                    if (sparseArray12 == null) {
                                                                        return;
                                                                    }
                                                                    this.a.A7(sparseArray12);
                                                                } else if (id3 == R.id.obfuscated_res_0x7f0917e9) {
                                                                    if (this.a.D0.T0() == null || this.a.v0 == null || this.a.v0.S1() == null) {
                                                                        return;
                                                                    }
                                                                    int firstVisiblePosition = this.a.D0.T0().getFirstVisiblePosition();
                                                                    View childAt = this.a.D0.T0().getChildAt(0);
                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                    boolean x0 = this.a.v0.S1().x0();
                                                                    boolean z5 = this.a.D0.e1() != null && this.a.D0.e1().g();
                                                                    boolean P1 = this.a.D0.P1();
                                                                    boolean z6 = firstVisiblePosition == 0 && top == 0;
                                                                    if (!x0 || this.a.D0.e1() == null || this.a.D0.e1().c() == null) {
                                                                        i4 = 0;
                                                                    } else {
                                                                        int k = ((int) (fj.k(this.a.getContext()) * 0.5625d)) - this.a.D0.e1().e();
                                                                        if (firstVisiblePosition == 0) {
                                                                            if (top != k) {
                                                                                i5 = k;
                                                                            } else {
                                                                                i5 = k;
                                                                            }
                                                                            z6 = true;
                                                                            i4 = i5;
                                                                        } else {
                                                                            i5 = k;
                                                                        }
                                                                        z6 = false;
                                                                        i4 = i5;
                                                                    }
                                                                    int i11 = i4;
                                                                    this.a.n5(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                    if ((this.a.v0.S1().P() != null && this.a.v0.S1().P().getReply_num() <= 0) || (P1 && z6)) {
                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                        if (!this.a.checkUpIsLogin()) {
                                                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                            return;
                                                                        }
                                                                        this.a.K6();
                                                                        if (this.a.v0.S1().P().getAuthor() != null) {
                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.S1().m()).param("obj_locate", 2).param("uid", this.a.v0.S1().P().getAuthor().getUserId()));
                                                                        }
                                                                    } else {
                                                                        int i12 = (int) (fj.i(this.a.getContext()) * 0.6d);
                                                                        if (x0) {
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
                                                                                int d2 = t08.d(this.a.getListView());
                                                                                if (t08.e(this.a.getListView()) != -1) {
                                                                                    d2--;
                                                                                }
                                                                                int f = fj.f(this.a.getContext(), R.dimen.tbds100);
                                                                                if (d2 < 0) {
                                                                                    d2 = (ListUtils.getCount(this.a.D0.T0().getData()) - 1) + this.a.D0.T0().getHeaderViewsCount();
                                                                                    f = 0;
                                                                                }
                                                                                if (z5) {
                                                                                    fixedNavHeight = (int) (fj.k(this.a.getContext()) * 0.5625d);
                                                                                } else if (!x0 || this.a.D0.e1() == null) {
                                                                                    if (this.a.D0.h != null && this.a.D0.h.a != null) {
                                                                                        fixedNavHeight = this.a.D0.h.a.getFixedNavHeight() - 10;
                                                                                    }
                                                                                    if (this.a.D0.d1 != null || this.a.D0.d1.c == null || this.a.D0.d1.c.getView() == null || this.a.D0.d1.c.getView().getParent() == null) {
                                                                                        this.a.D0.T0().setSelectionFromTop(d2, f + i12);
                                                                                        this.a.D0.T0().smoothScrollBy(i12, 500);
                                                                                    } else if (z5) {
                                                                                        this.a.D0.T0().smoothScrollBy(this.a.D0.d1.c.getView().getTop() - ((int) (fj.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                    } else {
                                                                                        this.a.D0.T0().E(d2, f, 200);
                                                                                    }
                                                                                } else {
                                                                                    fixedNavHeight = this.a.D0.e1().d();
                                                                                }
                                                                                f += fixedNavHeight;
                                                                                if (this.a.D0.d1 != null) {
                                                                                }
                                                                                this.a.D0.T0().setSelectionFromTop(d2, f + i12);
                                                                                this.a.D0.T0().smoothScrollBy(i12, 500);
                                                                            } else if (this.a.D0.T0().getChildAt(this.a.Z) != null) {
                                                                                this.a.D0.T0().E(this.a.Z, this.a.a0, 200);
                                                                            } else {
                                                                                this.a.D0.T0().setSelectionFromTop(this.a.Z, this.a.a0 + i12);
                                                                                this.a.D0.T0().smoothScrollBy(i12, 500);
                                                                            }
                                                                        } else {
                                                                            this.a.Z = firstVisiblePosition;
                                                                            this.a.a0 = top;
                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i12))) {
                                                                                this.a.D0.T0().setSelectionFromTop(0, i11 - i12);
                                                                                this.a.D0.T0().smoothScrollBy(-i12, 500);
                                                                            } else {
                                                                                this.a.D0.T0().E(0, i11, 500);
                                                                            }
                                                                        }
                                                                    }
                                                                    if (this.a.v0.S1().P() != null && this.a.v0.S1().P().getAuthor() != null) {
                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.S1().m()).param("obj_locate", 2).param("uid", this.a.v0.S1().P().getAuthor().getUserId()));
                                                                    }
                                                                } else if (id3 == R.id.obfuscated_res_0x7f09184d || id3 == R.id.obfuscated_res_0x7f09184e) {
                                                                    if (this.a.v0 == null || this.a.v0.S1() == null || this.a.v0.S1().l() == null || ej.isEmpty(this.a.v0.S1().l().getName())) {
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
                                                                    if (this.a.v0.S1().P() != null) {
                                                                        statisticItem6.param("nid", this.a.v0.S1().P().getNid());
                                                                    }
                                                                    TiebaStatic.log(statisticItem6);
                                                                } else if (id3 != R.id.obfuscated_res_0x7f090a99 && id3 != R.id.obfuscated_res_0x7f090a72 && id3 != R.id.obfuscated_res_0x7f090a74 && id3 != R.id.obfuscated_res_0x7f090a73) {
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
                                                                    } else if (id3 == R.id.obfuscated_res_0x7f091875) {
                                                                        if (this.a.v0 == null || this.a.v0.S1() == null) {
                                                                            return;
                                                                        }
                                                                        uv7 S15 = this.a.v0.S1();
                                                                        if (this.a.A0 == null) {
                                                                            PbFragment pbFragment5 = this.a;
                                                                            pbFragment5.A0 = new mw7(pbFragment5.getPageContext());
                                                                        }
                                                                        long g = eh.g(S15.R(), 0L);
                                                                        long g2 = eh.g(S15.m(), 0L);
                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                        PbFragment pbFragment6 = this.a;
                                                                        pbFragment6.registerListener(pbFragment6.l2);
                                                                        this.a.A0.a(g, g2);
                                                                    } else if (id3 == R.id.obfuscated_res_0x7f091899) {
                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                            if (!tr5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                    return;
                                                                                }
                                                                                zo4.o(this.a.getActivity(), smartApp.h5_url);
                                                                            }
                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.v0.m2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                        }
                                                                    } else if (id3 == R.id.obfuscated_res_0x7f090e3d) {
                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                            return;
                                                                        }
                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                        createNormalCfg2.setCallFrom(14);
                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    } else if (id3 == R.id.obfuscated_res_0x7f090e3a) {
                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                            return;
                                                                        }
                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                        if (this.a.P != null) {
                                                                            this.a.P.Q(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                        }
                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    } else if (id3 == R.id.obfuscated_res_0x7f091801 || id3 == R.id.obfuscated_res_0x7f091859) {
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
                                                                        if (sparseArray13 != null && (sparseArray13.get(R.id.obfuscated_res_0x7f092056) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.obfuscated_res_0x7f092056)).booleanValue()) {
                                                                            u28.o(6);
                                                                        }
                                                                        PbFragment pbFragment7 = this.a;
                                                                        pbFragment7.b = false;
                                                                        pbFragment7.f5(view2);
                                                                    } else if (id3 == R.id.obfuscated_res_0x7f0923e7) {
                                                                        if (view2.getTag(R.id.obfuscated_res_0x7f092056) instanceof Boolean) {
                                                                            u28.o(5);
                                                                        }
                                                                        this.a.Z6(false);
                                                                        this.a.B7((PostData) view2.getTag(R.id.obfuscated_res_0x7f09206c), false);
                                                                    }
                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                    return;
                                                                } else {
                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                    if (this.a.v0.R1() != 3 || !this.a.u0() || this.a.v0.S1() == null || !ListUtils.isEmpty(this.a.v0.S1().p())) {
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
                                                                if (sparseArray14 == null || !(sparseArray14.get(R.id.obfuscated_res_0x7f092059) instanceof PostData)) {
                                                                    return;
                                                                }
                                                                PostData postData3 = (PostData) sparseArray14.get(R.id.obfuscated_res_0x7f092059);
                                                                View view3 = (View) sparseArray14.get(R.id.obfuscated_res_0x7f09205b);
                                                                if (postData3 == null || view3 == null) {
                                                                    return;
                                                                }
                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090790);
                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090791);
                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a16);
                                                                if (postData3.r0()) {
                                                                    postData3.R0(false);
                                                                    s18.e(postData3);
                                                                } else if (this.a.K() != null ? s18.c(this.a.K().S1(), postData3) : false) {
                                                                    postData3.R0(true);
                                                                }
                                                                SkinManager.setBackgroundColor(findViewById, postData3.r0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                SkinManager.setViewTextColor(eMTextView, postData3.r0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                WebPManager.setPureDrawable(imageView, postData3.r0() ? R.drawable.obfuscated_res_0x7f080984 : R.drawable.obfuscated_res_0x7f080983, postData3.r0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                            }
                                                        } else {
                                                            this.a.D0.h.l();
                                                            this.a.D0.U3(this.a.D2);
                                                        }
                                                    } else if (this.a.v0 == null) {
                                                        return;
                                                    } else {
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09185f) {
                                                            StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                            statisticItem10.param("tid", this.a.v0.m2());
                                                            statisticItem10.param("fid", this.a.v0.getForumId());
                                                            statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem10.param("obj_locate", 6);
                                                            TiebaStatic.log(statisticItem10);
                                                        }
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a3f) {
                                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                this.a.S = view2;
                                                                return;
                                                            }
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09185f && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                            this.a.S = view2;
                                                            return;
                                                        }
                                                        if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                            return;
                                                        }
                                                        SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                        if (!(sparseArray15.get(R.id.obfuscated_res_0x7f092059) instanceof PostData)) {
                                                            return;
                                                        }
                                                        PostData postData4 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f092059);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09185f && (statisticItem = postData4.d0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a3f || view2.getId() == R.id.obfuscated_res_0x7f0917f9) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.v0.n2()).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.M()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.v0 == null || this.a.v0.S1() == null || this.a.O5().c1() == null || postData4.s() == null || postData4.D() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.O5().d1() != null) {
                                                            this.a.O5().d1().c();
                                                        }
                                                        kw7 kw7Var = new kw7();
                                                        kw7Var.A(this.a.v0.S1().l());
                                                        kw7Var.E(this.a.v0.S1().P());
                                                        kw7Var.C(postData4);
                                                        this.a.O5().c1().V(kw7Var);
                                                        this.a.O5().c1().setPostId(postData4.M());
                                                        this.a.v6(view2, postData4.s().getUserId(), "", postData4);
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
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091861 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                        if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                            return;
                                                        }
                                                        SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                        if (!(sparseArray16.get(R.id.obfuscated_res_0x7f092059) instanceof PostData)) {
                                                            return;
                                                        }
                                                        PostData postData5 = (PostData) sparseArray16.get(R.id.obfuscated_res_0x7f092059);
                                                        StatisticItem statisticItem12 = postData5.d0;
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
                                                        int X = this.a.v0.S1() != null ? this.a.v0.S1().X() : 0;
                                                        AbsPbActivity.e L6 = this.a.L6(M);
                                                        if (L6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, false, null, false, null, X, postData5.d0(), this.a.v0.S1().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(L6.a, L6.b, L6.g, L6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.v0.R1());
                                                        addBigImageData.setFromFrsForumId(this.a.v0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.v0.r2());
                                                        addBigImageData.setKeyFromForumId(this.a.v0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.v0.I(), this.a.v0.E(), this.a.v0.F(), this.a.v0.D(), this.a.v0.J());
                                                        addBigImageData.setBjhData(this.a.v0.k1());
                                                        if (this.a.v0.S1().o() != null) {
                                                            addBigImageData.setHasForumRule(this.a.v0.S1().o().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.v0.S1().W() != null) {
                                                            addBigImageData.setIsManager(this.a.v0.S1().W().getIs_manager());
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
                                                            addBigImageData.setMainPostMaskVisibly(this.a.v0.G.Y().R || postData5.R);
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                    } else {
                                                        this.a.R = view2;
                                                        return;
                                                    }
                                                }
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091690) {
                                                    StatisticItem statisticItem13 = new StatisticItem("c13398");
                                                    statisticItem13.param("tid", this.a.v0.m2());
                                                    statisticItem13.param("fid", this.a.v0.getForumId());
                                                    statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem13.param("obj_locate", 4);
                                                    TiebaStatic.log(statisticItem13);
                                                }
                                                if (view2.getId() != R.id.obfuscated_res_0x7f0917ff || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                    if (!this.a.checkUpIsLogin()) {
                                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.v0.S1().m()));
                                                        return;
                                                    } else if (this.a.v0 == null || this.a.v0.S1() == null) {
                                                        return;
                                                    } else {
                                                        this.a.D0.p0();
                                                        SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                        PostData postData6 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f092059);
                                                        PostData postData7 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f09205a);
                                                        View view4 = (View) sparseArray17.get(R.id.obfuscated_res_0x7f09205b);
                                                        if (postData6 == null || view4 == null) {
                                                            return;
                                                        }
                                                        if (postData6.H() == 1) {
                                                            TiebaStatic.log(new StatisticItem("c12630"));
                                                        }
                                                        StatisticItem statisticItem14 = postData6.d0;
                                                        if (statisticItem14 != null) {
                                                            StatisticItem copy3 = statisticItem14.copy();
                                                            copy3.delete("obj_locate");
                                                            if (view2.getId() == R.id.obfuscated_res_0x7f091690) {
                                                                copy3.param("obj_locate", 6);
                                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0917ff) {
                                                                copy3.param("obj_locate", 8);
                                                            }
                                                            TiebaStatic.log(copy3);
                                                        }
                                                        String m22 = this.a.v0.m2();
                                                        String M2 = postData6.M();
                                                        String M3 = postData7 != null ? postData7.M() : "";
                                                        int X2 = this.a.v0.S1() != null ? this.a.v0.S1().X() : 0;
                                                        this.a.C7();
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091bfc) {
                                                            TiebaStatic.log("c11742");
                                                            AbsPbActivity.e L62 = this.a.L6(M2);
                                                            if (postData6 == null || this.a.v0 == null || this.a.v0.S1() == null || L62 == null) {
                                                                return;
                                                            }
                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, M2, "pb", true, false, null, false, M3, X2, postData6.d0(), this.a.v0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(L62.a, L62.b, L62.g, L62.j);
                                                            if (!ej.isEmpty(M3)) {
                                                                addBigImageData2.setHighLightPostId(M3);
                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                            }
                                                            addBigImageData2.setKeyFromForumId(this.a.v0.getForumId());
                                                            addBigImageData2.setTiebaPlusData(this.a.v0.I(), this.a.v0.E(), this.a.v0.F(), this.a.v0.D(), this.a.v0.J());
                                                            addBigImageData2.setBjhData(this.a.v0.k1());
                                                            addBigImageData2.setKeyPageStartFrom(this.a.v0.R1());
                                                            addBigImageData2.setFromFrsForumId(this.a.v0.getFromForumId());
                                                            addBigImageData2.setWorksInfoData(this.a.v0.r2());
                                                            if (this.a.D0 != null && this.a.v0.G != null && (Y = this.a.v0.G.Y()) != null) {
                                                                addBigImageData2.setMainPostMaskVisibly(Y.R || postData6.R);
                                                            }
                                                            if (this.a.v0.S1() != null && this.a.v0.S1().o() != null) {
                                                                addBigImageData2.setHasForumRule(this.a.v0.S1().o().has_forum_rule.intValue());
                                                            }
                                                            this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                        } else {
                                                            AbsPbActivity.e L63 = this.a.L6(M2);
                                                            if (this.a.v0 == null || this.a.v0.S1() == null || L63 == null) {
                                                                return;
                                                            }
                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, M2, "pb", true, false, null, true, null, X2, postData6.d0(), this.a.v0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(L63.a, L63.b, L63.g, L63.j);
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
                                        } else if (this.a.v0 == null || this.a.v0.S1() == null || this.a.v0.S1().P() == null) {
                                            return;
                                        } else {
                                            this.a.D0.h.k();
                                            TiebaStatic.log(new StatisticItem("c13062"));
                                            PbFragment pbFragment8 = this.a;
                                            pbFragment8.Y5(pbFragment8.v0.S1().P().getFirstPostId());
                                        }
                                    } else {
                                        this.a.D0.p0();
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                            return;
                                        } else if (this.a.h) {
                                            view2.setTag(Integer.valueOf(this.a.v0.i2()));
                                            return;
                                        } else {
                                            this.a.C7();
                                            this.a.D0.s3();
                                            yu4 yu4Var = new yu4(this.a.getPageContext());
                                            if (this.a.v0.S1().f == null || this.a.v0.S1().f.size() <= 0) {
                                                strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11e6), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11e7)};
                                            } else {
                                                strArr = new String[this.a.v0.S1().f.size()];
                                                for (int i13 = 0; i13 < this.a.v0.S1().f.size(); i13++) {
                                                    strArr[i13] = ((PbSortType) this.a.v0.S1().f.get(i13)).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11e4);
                                                }
                                            }
                                            yu4Var.i(null, strArr, new a(this, yu4Var, view2));
                                            yu4Var.k();
                                        }
                                    }
                                } else {
                                    this.a.D0.p0();
                                    if (this.a.K().S1().g == 2) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0893);
                                        return;
                                    }
                                    if (this.a.v0.Q1() != null) {
                                        this.a.D0.b4(this.a.v0.Q1(), this.a.d2);
                                    }
                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                }
                            } else if (!this.a.Z4(11009)) {
                                return;
                            } else {
                                this.a.d6(3);
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
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0f3f);
                            if (this.a.K() == null || this.a.K().S1() == null) {
                                return;
                            }
                            this.a.s1.d(3, 3, this.a.K().S1().R());
                            return;
                        }
                        this.a.s1.b();
                        int i14 = (TbSingleton.getInstance().mCanCallFans || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().R() == null || !this.a.K().S1().R().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                        if (this.a.K() != null && this.a.K().S1() != null) {
                            this.a.s1.d(3, i14, this.a.K().S1().R());
                        }
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfc).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091bec) {
                        String v5 = this.a.v5();
                        if (TextUtils.isEmpty(v5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{v5});
                    }
                } else if (!this.a.q0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.v0.m2());
                    statisticItem15.param("fid", this.a.v0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.obfuscated_res_0x7f092056) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.obfuscated_res_0x7f092056)).booleanValue()) {
                        u28.o(2);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (!this.a.v) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f09203c);
                        if (!(obj instanceof PostData)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        PostData postData8 = (PostData) obj;
                        if (this.a.v0 != null && this.a.v0.S1() != null && this.a.O5().c1() != null && postData8.s() != null && postData8.D() != 1) {
                            if (!this.a.checkUpIsLogin()) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                return;
                            }
                            if (this.a.O5().d1() != null) {
                                this.a.O5().d1().c();
                            }
                            kw7 kw7Var2 = new kw7();
                            kw7Var2.A(this.a.v0.S1().l());
                            kw7Var2.E(this.a.v0.S1().P());
                            kw7Var2.C(postData8);
                            this.a.O5().c1().V(kw7Var2);
                            this.a.O5().c1().setPostId(postData8.M());
                            this.a.v6(view2, postData8.s().getUserId(), "", postData8);
                            TiebaStatic.log("c11743");
                            u28.b(this.a.v0.S1(), postData8, postData8.c0, 8, 1);
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
        public class a implements av4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yu4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ j1 c;

            public a(j1 j1Var, yu4 yu4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, yu4Var, view2};
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
                this.a = yu4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.v0.j2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.av4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void n0(av4 av4Var, int i, View view2) {
                boolean L3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
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
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091870) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.v0.S1().f != null && this.c.a.v0.S1().f.size() > i) {
                            i = ((PbSortType) this.c.a.v0.S1().f.get(i)).sort_type.intValue();
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
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091870) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.v0.S1().f != null) {
                        i = ((PbSortType) this.c.a.v0.S1().f.get(i)).sort_type.intValue();
                    }
                    L3 = this.c.a.v0.L3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.v0.i2()));
                    if (L3) {
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
    public class l1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D0 != null && this.a != null) {
                    this.b.a.D0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, e25 e25Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, e25Var, writeData, antiData}) == null) {
                if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v0.S1() != null) {
                        statisticItem.param("fid", this.a.v0.S1().m());
                    }
                    statisticItem.param("tid", this.a.v0.m2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (ej.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.C7();
                this.a.D0.q3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.B0 != null) {
                    this.a.B0.M(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    hh.a().postDelayed(this.a.U1, 300000L);
                }
                boolean z2 = false;
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
                        if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0488), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        pu4 pu4Var = new pu4(this.a.getActivity());
                        if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                            pu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d22));
                        } else {
                            pu4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
                        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new c(this));
                        pu4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ru8.d(i) || e25Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.h7(i, antiData, str);
                        return;
                    }
                }
                this.a.v7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.i7(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.D0.G1(this.a.v0.S1());
                    }
                } else if (this.a.v0.v1()) {
                    uv7 S1 = this.a.v0.S1();
                    if (S1 != null && S1.P() != null && S1.P().getAuthor() != null && (userId = S1.P().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.v0.I3()) {
                        this.a.D0.s3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.v0.I3()) {
                    this.a.D0.s3();
                }
                if (this.a.v0.z1()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.v0.m2()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    hh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.V4(z2);
                if (writeData != null) {
                    qz4.b(writeData.getContent(), "1");
                }
                if (this.a.i6()) {
                    this.a.F7();
                }
                this.a.t7();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D0 != null && this.a != null) {
                    this.b.a.D0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, e25 e25Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, e25Var, writeData, antiData}) == null) {
                if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
                    if (this.a.D5()) {
                        this.a.Z6(false);
                        yu7.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1240));
                    }
                    b08 b08Var = this.a.H0;
                    if (b08Var != null) {
                        b08Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        r35.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        qz4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        hh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.i6()) {
                        this.a.F7();
                    }
                    this.a.t7();
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
                    if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0488), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    pu4 pu4Var = new pu4(this.a.getActivity());
                    if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                        pu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d22));
                    } else {
                        pu4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
                    pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new c(this));
                    pu4Var.create(this.a.getPageContext()).show();
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
                my4 my4Var = new my4();
                my4Var.b = R.raw.obfuscated_res_0x7f110027;
                my4Var.a = BreatheTipWidget.PointType.LOTTIE;
                my4Var.c = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                ny4 ny4Var = new ny4();
                ny4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f050f);
                ny4Var.b = this.a.a.getString(R.string.obfuscated_res_0x7f0f00eb);
                ny4Var.e = R.drawable.pic_guidecard;
                ny4Var.f = fj.f(this.a.a.getContext(), R.dimen.tbds156);
                ny4Var.g = fj.f(this.a.a.getContext(), R.dimen.tbds489);
                ny4Var.h = fj.f(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.D0.h1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.D0.h1()));
                breatheTipWidget.f(ny4Var, my4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    ux4 k = ux4.k();
                    k.u("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    n35.a("c14828");
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
        public void b(uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uv7Var) == null) {
                this.a.D0.G1(uv7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage responsedMessage, boolean z2, long j) {
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
            vd5 vd5Var = new vd5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            vd5Var.c();
            if (z2) {
                j3 = j4;
                vd5Var.B = j3;
                vd5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().P() != null) {
                int threadType = this.a.v0.S1().P().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.L, "from_personalize")) {
                        rd5 rd5Var = new rd5();
                        rd5Var.F = 1;
                        rd5Var.a(1005);
                        rd5Var.D = j3;
                        rd5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.L, "from_frs")) {
                        vd5 vd5Var2 = new vd5();
                        vd5Var2.a(1000);
                        vd5Var2.D = j3;
                        vd5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, uv7 uv7Var, String str, int i4) {
            int i5;
            s55 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), uv7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906dc));
                }
                if (z && uv7Var != null && uv7Var.Z() == null && ListUtils.getCount(uv7Var.G()) < 1) {
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
                if (uv7Var == null || !uv7Var.s0()) {
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
                if (i4 == 0 && uv7Var != null) {
                    this.a.L0 = true;
                }
                if (uv7Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.D0.n1());
                    this.a.D0.A3();
                }
                ArrayList arrayList = null;
                String f1 = null;
                arrayList = null;
                if (z && uv7Var != null) {
                    ThreadData P = uv7Var.P();
                    if (P != null && P.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.c7(pbFragment3.R0);
                    }
                    this.a.D0.d1().m(uv7Var);
                    this.a.D0.M3();
                    if (P != null && P.getCartoonThreadData() != null) {
                        this.a.J7(P.getCartoonThreadData());
                    }
                    if (this.a.S0 != null) {
                        this.a.D0.V2(this.a.S0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(uv7Var.W().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(uv7Var.W().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(uv7Var.W().getBimg_end_time());
                    if (uv7Var.G() != null && uv7Var.G().size() >= 1 && uv7Var.G().get(0) != null) {
                        this.a.v0.r3(((PostData) uv7Var.G().get(0)).M());
                    } else if (uv7Var.Z() != null) {
                        this.a.v0.r3(uv7Var.Z().M());
                    }
                    if (this.a.S0 != null) {
                        this.a.S0.H(uv7Var.d());
                        this.a.S0.I(uv7Var.l(), uv7Var.W());
                        this.a.S0.k0(P);
                        this.a.S0.J(this.a.v0.u1(), this.a.v0.m2(), this.a.v0.q1());
                        if (P != null) {
                            this.a.S0.Z(P.isMutiForumThread());
                        }
                    }
                    if (this.a.x0 != null) {
                        this.a.x0.h(uv7Var.r());
                    }
                    if (uv7Var.s() == 1) {
                        this.a.r = true;
                    } else {
                        this.a.r = false;
                    }
                    if (uv7Var.k0()) {
                        this.a.r = true;
                    }
                    this.a.D0.W2(this.a.r);
                    if (this.a.s0.f.size() > 0) {
                        uv7Var.R0(this.a.s0.f);
                    }
                    this.a.D0.Q3(uv7Var, i2, i3, this.a.v0.k2(), i4, this.a.v0.B1());
                    this.a.D0.e4(uv7Var, this.a.v0.k2());
                    this.a.D0.j4(this.a.v0.v1());
                    AntiData d = uv7Var.d();
                    if (d != null) {
                        this.a.y = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.S0 != null && this.a.S0.b() != null && (m = this.a.S0.b().m(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) m).setOnClickListener(this.a.F1);
                        }
                    }
                    if (!this.a.W && !ListUtils.isEmpty(this.a.v0.S1().G()) && !this.a.v0.D2()) {
                        this.a.W = true;
                        this.a.X4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.O0)) {
                        t08.i(this.a.v0.R1(), this.a.getListView(), this.a.O0);
                        this.a.O0 = null;
                    } else if (!this.a.N0) {
                        if (!this.a.P0) {
                            if (!TextUtils.isEmpty(this.a.v0.I1())) {
                                t08.f(this.a.getListView(), this.a.v0.I1());
                                this.a.v0.L2();
                            } else {
                                this.a.D0.L3();
                            }
                        } else {
                            this.a.P0 = false;
                            t08.j(this.a.getListView());
                        }
                    } else {
                        this.a.N0 = false;
                        t08.g(this.a.getListView());
                    }
                    this.a.v0.M2(uv7Var.l(), this.a.J1);
                    this.a.v0.S2(this.a.M1);
                    if (this.a.V0 != null && P != null && P.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(P.getAuthor());
                        this.a.V0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.v0 != null && this.a.v0.A2()) {
                        f1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1b);
                    } else if (this.a.D0 != null) {
                        f1 = this.a.D0.f1();
                    }
                    if (!StringUtils.isNull(f1)) {
                        this.a.S0.c0(TbSingleton.getInstance().getAdVertiComment(uv7Var.q0(), uv7Var.r0(), f1));
                    }
                } else if (str != null) {
                    if (!this.a.L0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.v0.h1() != null && !StringUtils.isNull(this.a.v0.h1().c)) {
                                    this.a.D0.l4(this.a.v0.h1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.D0.n1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c67, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(fj.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.D0.n1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c67, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(fj.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
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
                            arrayList = this.a.v0.S1().G();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || ((PostData) arrayList.get(0)).D() != 1)) {
                            this.a.D0.R2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a0f));
                        } else {
                            if (this.a.k6()) {
                                this.a.D0.S2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e0c));
                            } else {
                                this.a.D0.S2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e0d));
                            }
                            this.a.D0.G1(this.a.v0.S1());
                        }
                    } else {
                        this.a.D0.R2("");
                    }
                    this.a.D0.x0();
                }
                if (uv7Var != null && uv7Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (!this.a.K().k2() || this.a.K().S1().y().c() != 0 || this.a.K().x2()) {
                    this.a.T0 = true;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (uv7Var != null) {
                        i5 = uv7Var.g();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.B1(i5, this.a.D0);
                }
                int l = ux4.k().l(ux4.o("key_reaction_guide_show_number_pb"), 0);
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
            m75 m75Var = new m75();
            this.a.c7(m75Var);
            PbFragment pbFragment = this.a;
            pbFragment.S0 = (n75) m75Var.a(pbFragment.getContext());
            this.a.S0.W(this.a.a.getPageContext());
            this.a.S0.f0(this.a.i2);
            this.a.S0.g0(this.a.Y0);
            n75 n75Var = this.a.S0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            n75Var.A(pageContext, extras);
            this.a.S0.b().C(true);
            this.a.D0.Q2(this.a.S0.b());
            if (!this.a.v0.F1()) {
                this.a.S0.q(this.a.v0.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.S0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.v0.A2()) {
                this.a.S0.c0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1b));
            } else if (this.a.D0 != null) {
                this.a.S0.c0(this.a.D0.f1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ux4 k = ux4.k();
                if (!k.h("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    hh.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ny7.b {
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

        @Override // com.baidu.tieba.ny7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1509);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c68);
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.D0 != null && this.a.v0 != null) {
                this.a.D0.j0(false);
                if (this.a.v0.N2(false)) {
                    this.a.D0.t3();
                } else if (this.a.v0.S1() != null) {
                    this.a.D0.I2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.a6();
                bt4 Q1 = this.a.v0.Q1();
                int a1 = this.a.D0.a1();
                if (a1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e0f);
                } else if (Q1 != null && a1 > Q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e0f);
                } else {
                    this.a.D0.p0();
                    this.a.C7();
                    this.a.D0.s3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.v0.F3(this.a.D0.a1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c68);
                    }
                    pu4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) && pu4Var != null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements wg {
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            LinearLayout linearLayout = (LinearLayout) obj;
            e(linearLayout);
            return linearLayout;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            LinearLayout linearLayout = (LinearLayout) obj;
            h(linearLayout);
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091874);
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
    public class b implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    pu4Var.dismiss();
                    ((TbPageContext) this.a.d1).showToast(R.string.obfuscated_res_0x7f0f072c);
                    return;
                }
                TiebaStatic.log("c10025");
                pu4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.d1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!this.a.j0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.I6();
                        return;
                    } else {
                        this.a.T6();
                        return;
                    }
                }
                this.a.j0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b1 implements AntiHelper.k {
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
        public void onNavigationButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements i3 {
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
    public class c implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
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
        public void onSuccess(List list) {
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
    public class c1 implements av4.e {
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

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                if (this.a.I0 != null) {
                    this.a.I0.dismiss();
                }
                this.a.H7(i);
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
                                                    m85.a aVar = new m85.a();
                                                    aVar.a = this.a.j1;
                                                    String str = "";
                                                    if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.l1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.U4();
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
                                                    pbFragment.h1 = new d08(pbFragment.getPageContext());
                                                }
                                                this.a.h1.b(this.a.j1, this.a.i1.n());
                                                this.a.i1 = null;
                                                this.a.j1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.A2;
                                            if (postData != null) {
                                                postData.D0();
                                                this.a.A2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.A6(view2);
                                            if (this.a.v0.S1().P() != null && this.a.v0.S1().P().getAuthor() != null && this.a.v0.S1().P().getAuthor().getUserId() != null && this.a.x0 != null) {
                                                PbFragment pbFragment2 = this.a;
                                                int S5 = pbFragment2.S5(pbFragment2.v0.S1());
                                                ThreadData P = this.a.v0.S1().P();
                                                if (P.isBJHArticleThreadType()) {
                                                    i2 = 2;
                                                } else if (P.isBJHVideoThreadType()) {
                                                    i2 = 3;
                                                } else if (!P.isBJHNormalThreadType()) {
                                                    if (P.isBJHVideoDynamicThreadType()) {
                                                        i2 = 5;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v0.b).param("obj_locate", 2).param("obj_id", this.a.v0.S1().P().getAuthor().getUserId()).param("obj_type", !this.a.x0.e()).param("obj_source", S5).param("obj_param1", i2));
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                return;
                                            }
                                            Object tag = view2.getTag();
                                            if (tag instanceof String) {
                                                TiebaStatic.log(new StatisticItem("c13079"));
                                                this.a.Y5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f09204f, 0);
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f092038, 2);
                                                    this.a.a5(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092040) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203e) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09205c) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f092050) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09205c)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092050)).booleanValue();
                                                boolean F = this.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                                if (F) {
                                                    if (booleanValue2) {
                                                        this.a.D0.s2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203e), intValue, booleanValue, null, F);
                                                        return;
                                                    } else {
                                                        this.a.k7(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.D0.q2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203e), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.k7(sparseArray3, intValue, booleanValue);
                                                    return;
                                                }
                                            }
                                            return;
                                        case 7:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                return;
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                                            if (sparseArray4.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092054)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f09204f, 1);
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092038, 2);
                                                    this.a.a5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092038, 2);
                                                }
                                                this.a.D0.v2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.D0.q2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
                                            if (postData2.q() == null) {
                                                return;
                                            }
                                            this.a.d5(postData2.q());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.v0 != null && this.a.v0.S1() != null) {
                                                this.a.a.t1(ru8.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.v0 != null && this.a.v0.S1() != null) {
                                    this.a.D0.q4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.N6(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e2);
                        if (view4 != null) {
                            AgreeView agreeView2 = (AgreeView) view4;
                            this.a.N6(view4);
                            if (agreeView2.getImgDisagree() != null) {
                                agreeView2.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SparseArray sparseArray5 = (SparseArray) view2.getTag();
                    View view5 = (View) sparseArray5.get(R.id.obfuscated_res_0x7f0917df);
                    this.a.N6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.obfuscated_res_0x7f092056) instanceof Boolean)) {
                            if (((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092056)).booleanValue()) {
                                this.a.Z6(true);
                            } else {
                                this.a.Z6(false);
                            }
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e0);
                this.a.N6(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements ey4.g {
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

        @Override // com.baidu.tieba.ey4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.B5()) {
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
    public class c3 implements d86.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.d86.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.d86.b
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

        @Override // com.baidu.tieba.d86.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.D0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.B5()) {
                    this.b.D0.u1();
                    this.b.D0.P2();
                }
            }
        }

        @Override // com.baidu.tieba.d86.b
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
    public class d implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
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
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.N1 = false;
            if (this.a.O1 != null && str != null) {
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
            this.a.N1 = false;
            if (this.a.O1 == null) {
                return;
            }
            uv7 S1 = this.a.v0.S1();
            if (S1.P().getPraise().getIsLike() == 1) {
                this.a.K7(0);
            } else {
                this.a.K7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, S1.P()));
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public d1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                if (pu4Var != null) {
                    pu4Var.dismiss();
                }
                this.d.k5(((Integer) this.a.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203e), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.B5()) {
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
    public final class d3 implements e86.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d3() {
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

        @Override // com.baidu.tieba.e86.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    vw7.d();
                } else {
                    vw7.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public e(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.b.D0.N3();
                MessageManager.getInstance().sendMessage(this.a);
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements c18.h {
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

        @Override // com.baidu.tieba.c18.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.b7(z);
                if (this.a.D0.Q0() != null && z) {
                    this.a.D0.c4(false);
                }
                this.a.D0.h2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.v2 && this.a.B5()) {
                    this.a.r6();
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
                this.a.v2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements ez7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.ez7.b
        public void onSuccess(List list) {
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

        @Override // com.baidu.tieba.ez7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.D0.f4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
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
    public class f1 implements er6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.er6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.er6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

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

        @Override // com.baidu.tieba.er6.d
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
                        this.a.S0.b().A(new l55(45, 27, null));
                    }
                    this.a.D0.i0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.v0 != null) {
                this.a.v0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends ii5 {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ii5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ShareSwitch.isOn()) {
                    i = 1;
                } else {
                    i = 6;
                }
                return t18.d(this.a.s5(), i, this.a.v0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements av4.e {
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

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                if (this.e.I0 != null) {
                    this.e.I0.dismiss();
                }
                if (i == 0) {
                    this.e.D0.q2(((Integer) this.a.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203e), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092095);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092097);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092096);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.f1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.f1);
                    this.e.y7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092093));
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
                this.a.D0.p0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                    return false;
                }
                if (this.a.v0 != null && !this.a.v0.isLoading) {
                    this.a.C7();
                    this.a.D0.s3();
                    z = true;
                    if (this.a.v0.S1() != null && this.a.v0.S1().f != null && this.a.v0.S1().f.size() > i) {
                        int intValue = ((PbSortType) this.a.v0.S1().f.get(i)).sort_type.intValue();
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
    public class g3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference a;
        public WeakReference b;

        public g3(yz7 yz7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference(yz7Var);
            this.b = new WeakReference(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                yz7 yz7Var = (yz7) this.a.get();
                if (yz7Var != null) {
                    yz7Var.t1();
                }
                PbFragment pbFragment = (PbFragment) this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.w7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        iw6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements oh5 {
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
        @Override // com.baidu.tieba.oh5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.getContext(), this.a, shareItem, false));
            }
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && ((UpdateAttentionMessage.a) updateAttentionMessage.getData()).c != null) {
                if (((UpdateAttentionMessage.a) updateAttentionMessage.getData()).i != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), ((UpdateAttentionMessage.a) updateAttentionMessage.getData()).i, PbFragment.P2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (((UpdateAttentionMessage.a) updateAttentionMessage.getData()).a) {
                    if (this.a.t5().s() != null && this.a.t5().s().getGodUserData() != null) {
                        this.a.t5().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().P() != null && this.a.v0.S1().P().getAuthor() != null) {
                        this.a.v0.S1().P().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ pu4 c;
        public final /* synthetic */ PbFragment d;

        public h2(PbFragment pbFragment, MarkData markData, MarkData markData2, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, pu4Var};
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
            this.c = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
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
                this.d.D7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends ii5 {
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
        @Override // com.baidu.tieba.ii5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.t3(this.a);
                }
                return t18.d(this.b.s5(), 2, K);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends sa5 {
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
        @Override // com.baidu.tieba.la5
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
    public class i2 implements k75 {
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

        @Override // com.baidu.tieba.k75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b08 b08Var = this.a.H0;
                if (b08Var != null && b08Var.g() != null && this.a.H0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.H0.g().c());
                    if (this.a.D0 != null && this.a.D0.d1() != null && this.a.D0.d1().b() != null && this.a.D0.d1().b().y()) {
                        this.a.D0.d1().b().w(this.a.H0.h());
                    }
                    this.a.H0.b(true);
                    return true;
                } else if (!this.a.c5(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements oh5 {
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
        @Override // com.baidu.tieba.oh5
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
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public j0(PbFragment pbFragment, Intent intent) {
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
            yz7 yz7Var = this.b.D0;
            yz7Var.v3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ pu4 b;
        public final /* synthetic */ PbFragment c;

        public j2(PbFragment pbFragment, MarkData markData, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, pu4Var};
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
            this.b = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.D7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
    public class k0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.v0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.v0.b)) {
                return;
            }
            this.a.v7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ pu4 b;
        public final /* synthetic */ PbFragment c;

        public k2(PbFragment pbFragment, MarkData markData, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, pu4Var};
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
            this.b = pu4Var;
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
                    this.c.D7();
                }
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData)) {
                return;
            }
            this.a.v0.N3((UserPendantData) customResponsedMessage.getData());
            if (this.a.D0 != null && this.a.v0 != null) {
                this.a.D0.G2(this.a.v0.S1(), this.a.v0.k2(), this.a.v0.c2(), this.a.D0.j1());
            }
            if (this.a.D0 != null && this.a.D0.D0() != null) {
                this.a.D0.D0().a0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements wg {
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            ImageView imageView = (ImageView) obj;
            e(imageView);
            return imageView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            ImageView imageView = (ImageView) obj;
            h(imageView);
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
                    foreDrawableImageView.P();
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
                    if (jq4.c().g()) {
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
                    foreDrawableImageView.P();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.G();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = jq4.c().g();
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
    public class m0 implements h3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.v0.S1().W().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.S1().l().getId(), this.a.v0.S1().l().getName(), this.a.v0.S1().P().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements l75 {
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

        @Override // com.baidu.tieba.l75
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements wg {
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            GifView gifView = (GifView) obj;
            e(gifView);
            return gifView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            GifView gifView = (GifView) obj;
            h(gifView);
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.c0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.f0();
                gifView.c0();
                gifView.setImageDrawable(null);
                gifView.g0();
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
                if (jq4.c().g()) {
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
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = jq4.c().g();
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
    public class n0 implements wu7.d {
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

        @Override // com.baidu.tieba.wu7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements wg {
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard = (TiebaPlusRecommendCard) obj;
            e(tiebaPlusRecommendCard);
            return tiebaPlusRecommendCard;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard = (TiebaPlusRecommendCard) obj;
            h(tiebaPlusRecommendCard);
            return tiebaPlusRecommendCard;
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
        @Override // com.baidu.tieba.wg
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
        @Override // com.baidu.tieba.wg
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                av7 av7Var = (av7) customResponsedMessage.getData();
                int type = av7Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (av7Var.a() == null) {
                                this.a.P6(false, null);
                                return;
                            } else {
                                this.a.P6(true, (MarkData) av7Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.o5((ForumManageModel.b) av7Var.a(), false);
                    return;
                }
                this.a.Q6((kw7) av7Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements ww7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.ww7.a
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

        @Override // com.baidu.tieba.ww7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091c1a) {
                        if (this.a.U6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                        if (!(view2.getTag() instanceof SparseArray)) {
                            return false;
                        }
                        Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203c);
                        if (!(obj instanceof PostData)) {
                            return false;
                        }
                        PostData postData = (PostData) obj;
                        if (postData.getType() != PostData.O0 && !TextUtils.isEmpty(postData.v()) && jq4.c().g()) {
                            return this.a.C6(postData.M());
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0917fe) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f09204f) instanceof SparseArray) {
                            this.a.A7((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09204f));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f091858) {
                        if (this.a.D0.M1() && view2.getId() == R.id.obfuscated_res_0x7f09181d) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f092091) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f092091)));
                            }
                            if (this.a.z0() != null && this.a.z0().b != null) {
                                this.a.z0().b.onClick(view2);
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
                        this.a.A7(sparseArray);
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

        @Override // com.baidu.tieba.ww7.a
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
    public class o1 extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            PbThreadPostView l1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f13fe);
                        if (this.a.D0 != null && (l1 = this.a.D0.l1()) != null && this.a.D0.T0() != null) {
                            this.a.D0.T0().removeHeaderView(l1);
                            return;
                        }
                        return;
                    }
                    fj.N(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements wg {
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            View view2 = (View) obj;
            e(view2);
            return view2;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            View view2 = (View) obj;
            h(view2);
            return view2;
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
        @Override // com.baidu.tieba.wg
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
        @Override // com.baidu.tieba.wg
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.D0 != null && this.a.D0.D0() != null) {
                this.a.D0.D0().a0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ru4.c {
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

        @Override // com.baidu.tieba.ru4.c
        public void a(ru4 ru4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, ru4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.K0 = pbFragment.K0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.K0);
                    new ay7(this.a.v0.m2(), this.a.K0, "1").start();
                    ru4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.K0 = pbFragment2.K0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.K0);
                    new ay7(this.a.v0.m2(), this.a.K0, "2").start();
                    ru4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.K0 = pbFragment3.K0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.K0);
                    ru4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            RelativeLayout relativeLayout = (RelativeLayout) obj;
            e(relativeLayout);
            return relativeLayout;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            RelativeLayout relativeLayout = (RelativeLayout) obj;
            h(relativeLayout);
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pl5.a)) {
                pl5.a aVar = (pl5.a) customResponsedMessage.getData();
                pl5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                    this.a.x6();
                }
                return false;
            }
            return invokeL.booleanValue;
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof CustomResponsedMessage) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.I7();
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            ItemCardView itemCardView = (ItemCardView) obj;
            e(itemCardView);
            return itemCardView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            ItemCardView itemCardView = (ItemCardView) obj;
            h(itemCardView);
            return itemCardView;
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
        @Override // com.baidu.tieba.wg
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.z7();
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
                    bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0327));
                    bdTopToast.i((ViewGroup) this.a.getView());
                    this.a.d7(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
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
    public class r2 implements TbRichTextView.y {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            fy7 D0;
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
                        boolean x = ((TbImageView) view2).x();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, x)));
                        }
                        this.a.Q = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.J6(str, i, eVar);
                    if (this.a.v0.G.k0()) {
                        ArrayList arrayList = new ArrayList();
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
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
                        this.a.q5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.v0.d2());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.k6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.v0 != null) {
                            builder.D(this.a.v0.getFromForumId());
                            if (this.a.v0.S1() != null) {
                                builder.Q(this.a.v0.S1().P());
                            }
                        }
                        ImageViewerConfig x2 = builder.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
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
                        builder2.M((String) eVar.a.get(0));
                        builder2.I(this.a.v0.d2());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.k6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.v0 != null) {
                            builder2.D(this.a.v0.getFromForumId());
                            if (this.a.v0.S1() != null) {
                                builder2.Q(this.a.v0.S1().P());
                            }
                        }
                        ImageViewerConfig x3 = builder2.x(this.a.getPageContext().getPageActivity());
                        x3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText L7 = this.a.L7(str, i);
                        if (L7 != null && this.a.x2 >= 0 && this.a.x2 < L7.B().size()) {
                            ArrayList arrayList3 = new ArrayList();
                            String a = vv7.a(L7.B().get(this.a.x2));
                            int i7 = 0;
                            while (true) {
                                if (i7 >= eVar.a.size()) {
                                    break;
                                } else if (((String) eVar.a.get(i7)).equals(a)) {
                                    eVar.j = i7;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (L7.getPostId() != 0 && (D0 = this.a.D0.D0()) != null) {
                                ArrayList t = D0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        eo eoVar = (eo) it.next();
                                        if ((eoVar instanceof PostData) && L7.getPostId() == eh.g(((PostData) eoVar).M(), 0L)) {
                                            int i8 = 8;
                                            if (L7.getPostId() == eh.g(this.a.v0.q1(), 0L)) {
                                                i8 = 1;
                                            }
                                            u28.b(this.a.v0.S1(), (PostData) eoVar, ((PostData) eoVar).c0, i8, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                            if (!ListUtils.isEmpty(arrayList3)) {
                                String str3 = (String) arrayList3.get(0);
                                concurrentHashMap3.put(str3, eVar.b.get(str3));
                            }
                            Rect rect2 = new Rect();
                            view2.getGlobalVisibleRect(rect2);
                            this.a.q5(rect2);
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
                            builder3.J(this.a.k6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.v0 != null) {
                                builder3.D(this.a.v0.getFromForumId());
                                if (this.a.v0.S1() != null) {
                                    builder3.Q(this.a.v0.S1().P());
                                }
                            }
                            ImageViewerConfig x4 = builder3.x(this.a.getPageContext().getPageActivity());
                            x4.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x4));
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0cf1));
                bdTopToast.i((ViewGroup) this.a.getView());
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.D0.t1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                uv7 S1 = this.a.v0.S1();
                if (S1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.d(this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b5d));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b59);
                    }
                    this.a.x7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ej.isEmpty(errorString2)) {
                        errorString2 = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b5a);
                    }
                    this.a.e1.c(errorString2);
                } else {
                    this.a.q7();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements ro4.a {
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

        @Override // com.baidu.tieba.ro4.a
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
                        this.a.x6();
                    }
                    if (z2) {
                        boolean p0 = this.a.v0.S1().p0();
                        if (this.a.x0 != null && !p0) {
                            if (this.a.x0.f() != null && this.a.v0 != null && this.a.v0.S1() != null && this.a.v0.S1().P() != null && this.a.v0.S1().P().getAuthor() != null) {
                                MarkData f = this.a.x0.f();
                                MetaData author = this.a.v0.S1().P().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                        this.a.u7();
                                    } else {
                                        this.a.p7(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.T4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14ff));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements ru4.c {
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

        @Override // com.baidu.tieba.ru4.c
        public void a(ru4 ru4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, ru4Var, i, view2) == null) {
                if (ru4Var != null) {
                    ru4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.A2;
                if (postData != null) {
                    if (i == 0) {
                        postData.D0();
                        this.a.A2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.B6(pbFragment2.A2);
                    }
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
                this.a.z6();
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.D0.t1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.d(this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f14d8));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ej.isEmpty(muteMessage)) {
                    muteMessage = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f14d7);
                }
                this.a.e1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                pu4Var.dismiss();
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
                    ry7 d1 = this.a.D0.d1();
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.i6() || this.a.a == null || this.a.a.i1() == null || !str.equals(this.a.a.i1().getTopicId())) {
                    return;
                }
                this.a.G7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                pu4Var.dismiss();
                this.b.z0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.v0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u2 implements ru4.c {
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

        @Override // com.baidu.tieba.ru4.c
        public void a(ru4 ru4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, ru4Var, i, view2) == null) {
                if (ru4Var != null) {
                    ru4Var.e();
                }
                if (this.a.i1 != null && !TextUtils.isEmpty(this.a.j1)) {
                    if (i == 0) {
                        if (this.a.l1 != null) {
                            m85.a aVar = new m85.a();
                            aVar.a = this.a.j1;
                            String str = "";
                            if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.l1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.U4();
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
                            pbFragment.h1 = new d08(pbFragment.getPageContext());
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof uu8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                uu8 uu8Var = (uu8) customResponsedMessage.getData();
                this.a.D0.t1();
                SparseArray sparseArray = (SparseArray) this.a.c1;
                DataRes dataRes = uu8Var.a;
                boolean z = false;
                if (uu8Var.c == 0 && dataRes != null) {
                    int e = eh.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (ej.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092092, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f092092, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09204f)).intValue();
                if (intValue != 0) {
                    if (intValue == 1) {
                        this.a.D0.u2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.r7(z, sparseArray);
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
            ArrayList G;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.v0 != null && this.a.v0.S1() != null && this.a.D0 != null && this.a.D0.D0() != null) {
                this.a.D0.n2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.v0.E2() && (G = this.a.v0.S1().G()) != null && !G.isEmpty()) {
                    int w = ((i + i2) - this.a.D0.D0().w()) - 1;
                    uv7 S1 = this.a.v0.S1();
                    if (S1 == null) {
                        return;
                    }
                    if (S1.D() != null && S1.D().k1()) {
                        w--;
                    }
                    if (S1.E() != null && S1.E().k1()) {
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
                PbFragment pbFragment = this.a;
                if (!pbFragment.o6(pbFragment.b1) && this.a.o6(i)) {
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
                    this.a.t = new pd5();
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
                if (i != 0) {
                    return;
                }
                this.a.W6(false, null);
                sl8.g().h(this.a.getUniqueId(), true);
                this.a.X4(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.v0 != null && this.a.v0.b2() != i + 1) {
                PbFragment pbFragment = this.a;
                pbFragment.Y6(pbFragment.M5(i));
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ks4)) {
                ks4 ks4Var = (ks4) customResponsedMessage.getData();
                dt4.a aVar = new dt4.a();
                int i = ks4Var.a;
                String str = ks4Var.b;
                aVar.a = ks4Var.d;
                uv7 S1 = this.a.v0.S1();
                if (S1 == null) {
                    return;
                }
                if (this.a.v0.u1() != null && this.a.v0.u1().getUserIdLong() == ks4Var.p) {
                    this.a.D0.F2(ks4Var.l, this.a.v0.S1(), this.a.v0.k2(), this.a.v0.c2());
                }
                if (S1.G() != null && S1.G().size() >= 1 && S1.G().get(0) != null) {
                    long g = eh.g(((PostData) S1.G().get(0)).M(), 0L);
                    long g2 = eh.g(this.a.v0.m2(), 0L);
                    if (g == ks4Var.n && g2 == ks4Var.m) {
                        dt4 K = ((PostData) S1.G().get(0)).K();
                        if (K == null) {
                            K = new dt4();
                        }
                        ArrayList<dt4.a> a = K.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        K.e(K.b() + ks4Var.l);
                        K.d(a);
                        ((PostData) S1.G().get(0)).I0(K);
                        this.a.D0.D0().a0();
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.D0.I1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.l5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements Comparator {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f45 f45Var, f45 f45Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f45Var, f45Var2)) == null) {
                return f45Var.compareTo(f45Var2);
            }
            return invokeLL.intValue;
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            hn8 hn8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hn8) && (hn8Var = (hn8) customResponsedMessage.getData()) != null && (agreeData = hn8Var.b) != null) {
                if (this.a.D0 != null) {
                    this.a.D0.a2(hn8Var);
                }
                if (agreeData.agreeType == 2 && this.a.D0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !t18.k(this.a.v0.b)) {
                    this.a.D0.a4();
                    t18.b(this.a.v0.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements k75 {
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

        @Override // com.baidu.tieba.k75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b08 b08Var = this.a.H0;
                if (b08Var != null && b08Var.e() != null && this.a.H0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.H0.e().c());
                    if (this.a.S0 != null && (this.a.S0.x() || this.a.S0.z())) {
                        this.a.S0.w(false, this.a.H0.h());
                    }
                    this.a.H0.a(true);
                    return true;
                } else if (this.a.c5(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.v0 != null && this.a.v0.S1() != null) {
                String str = (String) customResponsedMessage.getData();
                this.a.h5(str);
                this.a.v0.v2();
                if (!TextUtils.isEmpty(str) && this.a.v0.S1().G() != null) {
                    ArrayList G = this.a.v0.S1().G();
                    qn8 qn8Var = null;
                    Iterator it = G.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData postData = (PostData) it.next();
                        if (postData instanceof qn8) {
                            qn8 qn8Var2 = (qn8) postData;
                            if (str.equals(qn8Var2.l1())) {
                                qn8Var = qn8Var2;
                                break;
                            }
                        }
                    }
                    if (qn8Var != null) {
                        G.remove(qn8Var);
                        if (this.a.D0.D0() != null && this.a.D0.D0().t() != null) {
                            this.a.D0.D0().t().remove(qn8Var);
                        }
                        if (this.a.D0.T0() != null && this.a.D0.T0().getData() != null) {
                            this.a.D0.T0().getData().remove(qn8Var);
                        }
                        if (this.a.D0.D0() != null) {
                            this.a.D0.D0().a0();
                            return;
                        }
                    }
                }
                if (this.a.D0.D0() != null) {
                    this.a.D0.G1(this.a.v0.S1());
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.O5() != null) {
                this.a.O5().k2();
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
        public void onNavigationButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pu4Var) == null) {
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
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.getView(), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.getView(), 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
        public void a(x08 x08Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, x08Var) != null) || x08Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, x08Var.c()));
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
    public class z1 extends q9 {
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
                        this.a.o5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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
                        pbFragment.p5(pbFragment.y0.getLoadDataMode(), (ForumManageModel.g) obj);
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
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.v0.H1()) {
                    this.a.R6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(fj.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
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
        P2 = new b1();
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        Q2 = new d3();
    }

    public void E6() {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (list = this.p1) != null && !list.isEmpty()) {
            int size = this.p1.size();
            while (true) {
                size--;
                if (size <= -1 || ((f3) this.p1.get(size)).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c69);
                return;
            }
            this.D0.p0();
            if (this.h) {
                return;
            }
            C7();
            this.D0.s3();
            if (this.v0.loadData()) {
                this.D0.X3();
            }
        }
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.B0 == null) {
                this.B0 = new PollingModel(getPageContext(), getUniqueId());
            }
            this.B0.M(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            hh.a().postDelayed(this.U1, 10000L);
        }
    }

    public final void V6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().P() != null && this.v0.S1().P().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void X6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().P() != null && this.v0.S1().P().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void a6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            fj.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean o7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
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

    public final int s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.v0.S1() != null && this.v0.S1().P() != null) {
                return this.v0.S1().P().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void u7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048759, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && p35.g(TbadkCoreApplication.getInst(), 0) && !this.D0.x2()) {
            this.i0 = p35.i(getPageContext(), "collect", 0L);
        }
    }

    public final void z7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (pbModel = this.v0) != null && !ej.isEmpty(pbModel.m2())) {
            sl4.w().P(rl4.Z, eh.g(this.v0.m2(), 0L));
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
        this.H1 = new x(this, 2016488);
        this.I1 = new y(this, 2016331);
        this.J1 = new z(this);
        this.K1 = new a0(this, 2921509);
        this.L1 = new b0(this, 2010045);
        this.M1 = new c0(this);
        this.O1 = new PraiseModel(getPageContext(), new d0(this));
        this.P1 = new e0(this);
        this.Q1 = new h0(this, 2001115);
        this.R1 = new i0(this);
        this.T1 = new ww7(new o0(this));
        this.U1 = new r0(this);
        this.V1 = new s0(this, 2001427);
        this.W1 = new t0(this, 2001428);
        this.X1 = new u0(this, 2921634);
        this.Y1 = new v0(this, 2001426);
        this.Z1 = new w0(this, 2004021);
        this.a2 = new x0(this, 2016528);
        this.b2 = new y0(this, 2921724);
        this.c2 = new z0(this, 2921033);
        this.d2 = new a1(this);
        this.e2 = new c1(this);
        this.f2 = new g1(this);
        this.g2 = new j1(this);
        this.h2 = new k1(this, 2921480);
        this.i2 = new l1(this);
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
        this.u2 = new d2(this);
        this.w2 = new e2(this);
        this.x2 = 0;
        this.y2 = new r2(this);
        this.z2 = false;
        this.A2 = null;
        this.B2 = new s2(this);
        this.C2 = new u2(this);
        this.D2 = new v2(this);
        this.E2 = new w2(this);
        this.F2 = new x2(this);
        this.G2 = new y2(this);
        this.H2 = new z2(this);
        this.I2 = new b3(this);
        this.J2 = new c3(this);
        this.K2 = new a(this);
        this.L2 = -1;
        this.M2 = -1;
    }

    public final boolean A5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final void A6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null) {
                return;
            }
            B6(postData);
        }
    }

    public final boolean C5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public final String I5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public final long J5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void J7(vr4 vr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, vr4Var) == null) && vr4Var != null) {
            this.O2 = vr4Var;
            this.c = true;
            this.D0.K2();
            this.D0.f3(this.N2);
        }
    }

    public void R4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, f3Var) == null) && f3Var != null) {
            if (this.p1 == null) {
                this.p1 = new ArrayList();
            }
            if (!this.p1.contains(f3Var)) {
                this.p1.add(f3Var);
            }
        }
    }

    public void S4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, f3Var) == null) && f3Var != null) {
            if (this.p1 == null) {
                this.p1 = new ArrayList();
            }
            if (!this.p1.contains(f3Var)) {
                this.p1.add(0, f3Var);
            }
        }
    }

    public void S6(f3 f3Var) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, f3Var) == null) && f3Var != null && (list = this.p1) != null) {
            list.remove(f3Var);
        }
    }

    @Override // com.baidu.tieba.a48.b
    public void V0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z3) == null) {
            this.M0 = z3;
        }
    }

    public final void Y6(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048661, this, i4) == null) && this.v0 != null) {
            s7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.v0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public final void Z5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, intent) == null) {
            t18.j(this, intent);
        }
    }

    public void Z6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z3) == null) {
            this.j2 = Boolean.valueOf(z3);
        }
    }

    public void a7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z3) == null) {
            this.q0 = z3;
        }
    }

    public void b7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z3) == null) {
            this.M = z3;
        }
    }

    public void e7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z3) == null) {
            this.J = z3;
        }
    }

    public final void f7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z3) == null) {
            this.S0.X(z3);
            this.S0.a0(z3);
            this.S0.i0(z3);
        }
    }

    public boolean l6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048705, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.pu4.e
    public void onClick(pu4 pu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, pu4Var) == null) {
            j5(pu4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.v9
    public void onPreLoad(io ioVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, ioVar) == null) {
            PreLoadImageHelper.load(ioVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(ioVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v0.n3(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.S0.F(bundle);
        }
    }

    public final void q6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void w7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048766, this, i4) == null) {
            t18.o(this, s5(), i4);
        }
    }

    public boolean F6(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        yz7 yz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i4, keyEvent)) == null) {
            if (keyEvent == null || (yz7Var = this.D0) == null || !yz7Var.f2(i4)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.sl5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.sl5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            e08.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.sl5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, context, str) == null) {
            this.v = true;
        }
    }

    public final void c6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048672, this, i4, i5) == null) {
            mi5.b(new i(this, i5), new j(this, i5, i4));
        }
    }

    public final void j7(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048699, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            t18.l(this, j3, str, j4);
        }
    }

    public static PbFragment D6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e38
    public PbModel.h B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.c && this.L2 == -1 && this.M2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void C7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.sl5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            yz7 yz7Var = this.D0;
            if (yz7Var == null) {
                return 0;
            }
            return yz7Var.h1();
        }
        return invokeV.intValue;
    }

    public boolean D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void D7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.u1();
        }
    }

    public boolean E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sl5
    /* renamed from: F5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            yz7 yz7Var = this.D0;
            if (yz7Var == null) {
                return null;
            }
            return yz7Var.T0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.M2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public vg H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (vg) invokeV.objValue;
    }

    public int H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.L2;
        }
        return invokeV.intValue;
    }

    public void I6() {
        o35 o35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (o35Var = this.i0) != null) {
            o35Var.q();
        }
    }

    @Override // com.baidu.tieba.e38
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.v0;
        }
        return (PbModel) invokeV.objValue;
    }

    public n75 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.S0;
        }
        return (n75) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            vg vgVar = new vg(new p2(this), 10, 0);
            this.F = vgVar;
            return vgVar;
        }
        return (vg) invokeV.objValue;
    }

    public c18 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.e;
        }
        return (c18) invokeV.objValue;
    }

    public boolean M6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            o35 o35Var = this.i0;
            if (o35Var != null && o35Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.B == null) {
                this.B = new vg(new l2(this), 8, 0);
            }
            return this.B;
        }
        return (vg) invokeV.objValue;
    }

    public p18 N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.s0;
        }
        return (p18) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.C == null) {
                this.C = new vg(new o2(this), 8, 0);
            }
            return this.C;
        }
        return (vg) invokeV.objValue;
    }

    public yz7 O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.D0;
        }
        return (yz7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e38
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public mt4 Q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.b0;
        }
        return (mt4) invokeV.objValue;
    }

    public String R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            hideNetRefreshView(this.D0.n1());
            s7();
            if (this.v0.T2()) {
                this.D0.s3();
            }
            this.D0.A3();
        }
    }

    public void T6() {
        o35 o35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (o35Var = this.i0) != null) {
            o35Var.x();
        }
    }

    public String U5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (vg) invokeV.objValue;
    }

    public void b6() {
        yz7 yz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (yz7Var = this.D0) != null) {
            yz7Var.r1();
            a6();
        }
    }

    @Override // com.baidu.tieba.sl5
    public vg e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (this.G == null) {
                this.G = new vg(new q2(this), 10, 0);
            }
            return this.G;
        }
        return (vg) invokeV.objValue;
    }

    public final void f6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new l0(this));
        }
    }

    public boolean h6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.x1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.i1() != null && this.a.i1().R1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.c0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public io onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (io) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            R6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return this.q0;
        }
        return invokeV.booleanValue;
    }

    public AntiData r5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null) {
                return this.v0.S1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public PostData t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            uv7 uv7Var = this.v0.G;
            if (uv7Var != null) {
                return uv7Var.Y();
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public final void t7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && p35.g(TbadkCoreApplication.getInst(), 0) && !this.D0.x2()) {
            this.i0 = p35.i(getPageContext(), "reply_pb", 0L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && (pbModel = this.v0) != null && !ej.isEmpty(pbModel.m2())) {
            super.taskStart();
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public String u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public final String v5() {
        InterceptResult invokeV;
        uv7 S1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || (S1 = pbModel.S1()) == null) {
                return null;
            }
            return S1.U().c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            if (this.K == null) {
                this.K = new vg(new m2(this), 20, 0);
            }
            return this.K;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            if (this.D == null) {
                this.D = new vg(new n2(this), 5, 0);
            }
            return this.D;
        }
        return (vg) invokeV.objValue;
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048769, this) == null) {
            uv7 S1 = this.v0.S1();
            this.v0.H3(true);
            ro4 ro4Var = this.x0;
            if (ro4Var != null) {
                S1.K0(ro4Var.g());
            }
            this.D0.G1(S1);
        }
    }

    public void y6() {
        yz7 yz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048772, this) != null) || (yz7Var = this.D0) == null) {
            return;
        }
        yz7Var.X1();
    }

    @Override // com.baidu.tieba.sl5
    public vg z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            if (this.E == null) {
                this.E = new vg(new a3(this), 15, 0);
            }
            return this.E;
        }
        return (vg) invokeV.objValue;
    }

    public b18 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            return this.a.z0();
        }
        return (b18) invokeV.objValue;
    }

    public PbInterviewStatusView.f z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            return this.t0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final void A7(SparseArray sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f09203c) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null) {
            return;
        }
        B7(postData, false);
    }

    public final void H7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.v0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(r18.m(i4))));
        }
    }

    public final void N6(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, view2) != null) || view2 == null) {
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
        sparseArray.put(R.id.obfuscated_res_0x7f09187f, Integer.valueOf(i4));
        view2.setTag(sparseArray);
    }

    public final int S5(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, uv7Var)) == null) {
            if (uv7Var != null && uv7Var.P() != null) {
                if (uv7Var.P().getThreadType() == 0) {
                    return 1;
                }
                if (uv7Var.P().getThreadType() == 54) {
                    return 2;
                }
                if (uv7Var.P().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final boolean Z4(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048662, this, i4)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i4)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void d6(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i4) == null) {
            mi5.b(new g(this), new h(this, i4));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i4 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i4 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, configuration) == null) {
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
            yz7 yz7Var = this.D0;
            if (yz7Var != null) {
                yz7Var.c2(configuration);
            }
            yu4 yu4Var = this.I0;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z3) == null) {
            super.onUserChanged(z3);
            this.D0.k4(z3);
            yu4 yu4Var = this.I0;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
            if (z3 && this.M0) {
                this.D0.t3();
                this.v0.N2(true);
            }
            if (this.D0.D0() != null) {
                this.D0.D0().e0(z3);
            }
        }
    }

    public final void q5(Rect rect) {
        yz7 yz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048741, this, rect) == null) && rect != null && (yz7Var = this.D0) != null && yz7Var.m1() != null && rect.top <= this.D0.m1().getHeight()) {
            rect.top += this.D0.m1().getHeight() - rect.top;
        }
    }

    public void s6(String str) {
        yz7 yz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048748, this, str) == null) && this.v0 != null && !StringUtils.isNull(str) && (yz7Var = this.D0) != null) {
            yz7Var.a3(true);
            this.v0.P2(str);
            this.H = true;
            this.D0.p0();
            this.D0.p1();
        }
    }

    public final void x7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, str) == null) {
            if (str == null) {
                str = "";
            }
            r9 r9Var = this.d1;
            if (r9Var == null) {
                return;
            }
            pu4 pu4Var = new pu4(r9Var.getPageActivity());
            pu4Var.setMessage(str);
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09c4, new d(this));
            pu4Var.create(this.d1).show();
        }
    }

    public void B6(PostData postData) {
        PostData t5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, postData) != null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.M() != null && postData.M().equals(this.v0.N1())) {
            z3 = true;
        }
        MarkData M1 = this.v0.M1(postData);
        if (this.v0.S1() != null && this.v0.S1().k0() && (t5 = t5()) != null) {
            M1 = this.v0.M1(t5);
        }
        if (M1 == null) {
            return;
        }
        this.D0.s3();
        ro4 ro4Var = this.x0;
        if (ro4Var != null) {
            ro4Var.i(M1);
            if (!z3) {
                this.x0.a();
            } else {
                this.x0.d();
            }
        }
    }

    public void O6(kw7 kw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, kw7Var) == null) {
            String M = kw7Var.i().M();
            List list = this.v0.S1().U().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = (PostData) list.get(i4);
                if (postData.M() != null && postData.M().equals(M)) {
                    ArrayList k3 = kw7Var.k();
                    postData.Y0(kw7Var.m());
                    if (postData.a0() != null) {
                        postData.a0().clear();
                        postData.a0().addAll(k3);
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

    public final void Y5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && this.v0.S1().k0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.v0.m2(), str);
                ThreadData P = this.v0.S1().P();
                if (P.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (P.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (P.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                q6(format);
                return;
            }
            this.w0.a(str);
        }
    }

    public final void h5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048691, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.v0) != null && pbModel.S1() != null) {
            qn8 z3 = this.v0.S1().z();
            if (z3 != null && str.equals(z3.l1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.v0.S1().b();
            }
            qn8 l12 = this.v0.l1();
            if (l12 != null && str.equals(l12.l1())) {
                this.v0.X0();
            }
        }
    }

    public final void n5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048710, this, str) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().P() != null && this.v0.S1().P().isUgcThreadType()) {
            ThreadData P = this.v0.S1().P();
            int i4 = 0;
            if (P.isBJHArticleThreadType()) {
                i4 = 1;
            } else if (P.isBJHVideoThreadType()) {
                i4 = 2;
            } else if (P.isBJHNormalThreadType()) {
                i4 = 3;
            } else if (P.isBJHVideoDynamicThreadType()) {
                i4 = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i4);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048719, this, i4) != null) || this.V == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.D0.b2(i4);
        n75 n75Var = this.S0;
        if (n75Var != null && n75Var.b() != null) {
            this.S0.b().w(i4);
        }
        if (this.D0.a() != null) {
            this.D0.a().d(getPageContext(), i4);
        }
        this.H0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.V = i4;
        C7();
        o35 o35Var = this.i0;
        if (o35Var != null) {
            o35Var.w();
        }
    }

    public final void p7(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048739, this, metaData) != null) || metaData == null) {
            return;
        }
        pu4 pu4Var = new pu4(getActivity());
        pu4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0aba));
        pu4Var.setTitleShowCenter(true);
        pu4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0abb));
        pu4Var.setMessageShowCenter(true);
        pu4Var.setCancelable(false);
        pu4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0abc), new t1(this, metaData));
        pu4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0abd), new u1(this, metaData));
        pu4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void v7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                K().a1(postWriteCallBackData.getPostId());
                int H0 = this.D0.H0();
                this.n1 = H0;
                this.v0.q3(H0, this.D0.N0());
            }
            this.D0.p0();
            this.H0.c();
            n75 n75Var = this.S0;
            if (n75Var != null) {
                this.D0.V2(n75Var.y());
            }
            this.D0.r1();
            this.D0.F3(true);
            this.v0.v2();
        }
    }

    public final void B7(PostData postData, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, postData, z3) == null) {
            Z6(false);
            if (postData == null || (pbModel = this.v0) == null || pbModel.S1() == null || postData.D() == 1) {
                return;
            }
            String m22 = this.v0.m2();
            String M = postData.M();
            if (this.v0.S1() != null) {
                i4 = this.v0.S1().X();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e L6 = L6(M);
            if (L6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo d02 = postData.d0();
            AntiData d4 = this.v0.S1().d();
            if (postData.s() != null) {
                arrayList = postData.s().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(m22, M, "pb", true, false, null, false, null, i4, d02, d4, false, arrayList, 5).addBigImageData(L6.a, L6.b, L6.g, L6.j);
            addBigImageData.setKeyPageStartFrom(this.v0.R1());
            addBigImageData.setFromFrsForumId(this.v0.getFromForumId());
            addBigImageData.setWorksInfoData(this.v0.r2());
            addBigImageData.setKeyFromForumId(this.v0.getForumId());
            addBigImageData.setBjhData(this.v0.k1());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void W5(int i4, Intent intent) {
        x55 x55Var;
        x55 x55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048652, this, i4, intent) == null) {
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
                    r75 b4 = this.D0.d1().b();
                    b4.d0(this.v0.S1().P());
                    b4.C(writeData);
                    b4.e0(pbEditorData.getVoiceModel());
                    w55 n3 = b4.b().n(6);
                    if (n3 != null && (x55Var2 = n3.m) != null) {
                        x55Var2.B(new l55(52, 0, pbEditorData.getVoiceModel()));
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
            w55 n4 = this.S0.b().n(6);
            if (n4 != null && (x55Var = n4.m) != null) {
                x55Var.B(new l55(52, 0, pbEditorData.getVoiceModel()));
            }
            this.S0.h0(pbEditorData.isShowCustomFigure());
            if (i4 == -1) {
                this.S0.G(null, null);
            }
        }
    }

    public void i5(SparseArray sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(yz7.k2)).intValue();
            if (intValue == yz7.l2) {
                if (this.y0.S()) {
                    return;
                }
                this.D0.g4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue();
                if (sparseArray.get(R.id.obfuscated_res_0x7f092052) != null) {
                    z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092052)).booleanValue();
                } else {
                    z3 = false;
                }
                if (jSONArray != null) {
                    this.y0.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.y0.V(this.v0.S1().l().getId(), this.v0.S1().l().getName(), this.v0.S1().P().getId(), str, intValue3, intValue2, booleanValue, this.v0.S1().P().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == yz7.m2 || intValue == yz7.o2) {
                PbModel pbModel = this.v0;
                if (pbModel != null && pbModel.n1() != null) {
                    this.v0.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == yz7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void i7(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048696, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (O5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        r35.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            yu7.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            yu7.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            yu7.e(getResources().getString(R.string.obfuscated_res_0x7f0f1240));
                            return;
                        } else {
                            yu7.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.v0.F1()) {
                antiData.setBlock_forum_name(this.v0.S1().l().getName());
                antiData.setBlock_forum_id(this.v0.S1().l().getId());
                antiData.setUser_name(this.v0.S1().W().getUserName());
                antiData.setUser_id(this.v0.S1().W().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public void l5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048704, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            yz7 yz7Var = this.D0;
            if (yz7Var != null && this.v0 != null) {
                if ((yz7Var == null || yz7Var.I1()) && this.v0.S1() != null && this.v0.S1().T() != null) {
                    yz7 yz7Var2 = this.D0;
                    if (yz7Var2 != null && yz7Var2.J0() != null && this.D0.J0().t()) {
                        return;
                    }
                    iw7 T = this.v0.S1().T();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!T.f() || T.a() != 2) && this.D0.D0() != null && this.D0.D0().z() != null) {
                        this.D0.D0().z().v(this.v0.m2(), this.v0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        wu7 wu7Var = new wu7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.v0;
                        wu7Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        wu7Var.l(new n0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public final boolean l7(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        fs4 fs4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048706, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            uv7 S1 = this.v0.S1();
            ThreadData P = S1.P();
            if (P != null) {
                if (P.isBJHArticleThreadType() || P.isBJHVideoThreadType()) {
                    return false;
                }
                if (P.isBJHNormalThreadType() || P.isBJHVideoDynamicThreadType()) {
                    return z3;
                }
            }
            if (z3) {
                return true;
            }
            if ((P != null && P.getAuthor() != null && P.getAuthor().isForumBusinessAccount() && !xi6.isOn()) || this.v0.H() || P.isWorksInfo() || P.isScoreThread() || z4) {
                return false;
            }
            if (S1.l() != null && S1.l().isBlockBawuDelete) {
                return false;
            }
            if (S1.P() != null && S1.P().isBlocked()) {
                return false;
            }
            if (S1.X() != 0) {
                if (S1.X() == 3) {
                    return false;
                }
                return true;
            }
            List<zt4> p3 = S1.p();
            if (ListUtils.getCount(p3) <= 0) {
                return false;
            }
            for (zt4 zt4Var : p3) {
                if (zt4Var != null && (fs4Var = zt4Var.f) != null && fs4Var.a && !fs4Var.c && ((i4 = fs4Var.b) == 1 || i4 == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void r7(boolean z3, SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048746, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092038) instanceof Integer)) {
            yu4 yu4Var = this.I0;
            if (yu4Var != null && yu4Var.isShowing()) {
                this.I0.dismiss();
                this.I0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092092);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092094);
            if (!((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                return;
            }
            av4 av4Var = new av4(getContext());
            av4Var.n(new g0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092038) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092038)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new wu4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04b8), av4Var));
            }
            if (z3) {
                arrayList.add(new wu4(1, getResources().getString(R.string.obfuscated_res_0x7f0f14d6), av4Var));
            } else {
                arrayList.add(new wu4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b58), av4Var));
            }
            av4Var.j(arrayList);
            yu4 yu4Var2 = new yu4(getPageContext(), av4Var);
            this.I0 = yu4Var2;
            yu4Var2.k();
        }
    }

    public final boolean C6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String q3 = ux4.k().q("bubble_link", "");
            if (StringUtils.isNull(q3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            zo4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0552), q3 + "?props_id=" + str, true, true, true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void V4(boolean z3) {
        PbModel pbModel;
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048648, this, z3) == null) && (pbModel = this.v0) != null && (uv7Var = pbModel.G) != null && uv7Var.P() != null) {
            ThreadData P = this.v0.G.P();
            P.mRecomAbTag = this.v0.X1();
            P.mRecomWeight = this.v0.a2();
            P.mRecomSource = this.v0.Z1();
            P.mRecomExtra = this.v0.Y1();
            if (P.getFid() == 0) {
                P.setFid(eh.g(this.v0.getForumId(), 0L));
            }
            StatisticItem i4 = yc5.i(getContext(), P, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l3 = yc5.l(getContext());
            if (l3 != null && "a008".equals(l3.locatePage)) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l3 != null && "a002".equals(l3.locatePage)) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i4 != null) {
                i4.param(TiebaStatic.Params.REPLY_TYPE, 1);
                tc5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i4);
            }
            if (!z3) {
                w6();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d5(AgreeData agreeData) {
        tc5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048675, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new qx4();
        }
        if (this.h0 == null) {
            hn8 hn8Var = new hn8();
            this.h0 = hn8Var;
            hn8Var.a = getUniqueId();
        }
        gr4 gr4Var = new gr4();
        gr4Var.b = 5;
        gr4Var.h = 8;
        gr4Var.g = 2;
        if (K() != null) {
            gr4Var.f = K().R1();
        }
        gr4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                gr4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i4, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.v0;
                if (pbModel == null && pbModel.S1() != null) {
                    this.d0.b(P(), gr4Var, agreeData, this.v0.S1().P());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            gr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            gr4Var.i = 1;
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

    public final boolean m7(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048709, this, z3)) == null) {
            if (z3 || (pbModel = this.v0) == null || pbModel.S1() == null || (this.v0.S1().l() != null && this.v0.S1().l().isBlockBawuDelete)) {
                return false;
            }
            uv7 S1 = this.v0.S1();
            if ((S1.P() != null && S1.P().getAuthor() != null && S1.P().getAuthor().isForumBusinessAccount() && !xi6.isOn()) || this.v0.H()) {
                return false;
            }
            if ((S1.P() != null && S1.P().isBlocked()) || this.v0.S1().X() == 0 || this.v0.S1().X() == 3) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean E7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.S1() != null && this.v0.S1().k0()) {
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
                        pu4 pu4Var = new pu4(getPageContext().getPageActivity());
                        pu4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0269));
                        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043d, new h2(this, i12, o12, pu4Var));
                        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new j2(this, o12, pu4Var));
                        pu4Var.setOnCalcelListener(new k2(this, o12, pu4Var));
                        pu4Var.create(getPageContext());
                        pu4Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", o12);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (this.v0.S1() != null && this.v0.S1().G() != null && this.v0.S1().G().size() > 0 && this.v0.B1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.v0.S1() != null && this.v0.S1().P() != null && this.v0.S1().P().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.v0.S1().P().getTaskInfoData().g(), this.v0.S1().P().getTaskInfoData().f(), this.v0.S1().P().getTaskInfoData().b(), this.v0.S1().P().getTaskInfoData().c(), this.v0.S1().P().getIs_top(), this.v0.S1().P().getIs_good())));
                this.a.finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            this.f = false;
            super.onResume();
            if (this.N) {
                this.N = false;
                V5();
            }
            if (j6()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            yz7 yz7Var = this.D0;
            if (yz7Var != null && yz7Var.n1() != null) {
                if (!this.g) {
                    s7();
                } else {
                    hideLoadingView(this.D0.n1());
                }
                this.D0.l2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            yz7 yz7Var2 = this.D0;
            if (yz7Var2 != null) {
                noNetworkView = yz7Var2.a();
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
            X6();
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.Y1);
            if (this.m1) {
                R6();
                this.m1 = false;
            }
            z7();
            ItemCardHelper.v(this.G2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                e55.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            super.onStop();
            if (this.u > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.u;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.u = 0L;
            }
            if (O5().d1() != null) {
                O5().d1().i();
            }
            z18 z18Var = this.D0.h;
            if (z18Var != null && !z18Var.u()) {
                this.D0.h.y();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && this.v0.S1().l() != null && this.v0.S1().P() != null) {
                b55.j().x(getPageContext().getPageActivity(), "pb", this.v0.S1().l().getId(), eh.g(this.v0.S1().P().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            sl8.g().h(getUniqueId(), false);
        }
    }

    public final String w5() {
        InterceptResult invokeV;
        ArrayList G;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.S1() == null || this.v0.S1().G() == null || (count = ListUtils.getCount((G = this.v0.S1().G()))) == 0) {
                return "";
            }
            if (this.v0.d2()) {
                Iterator it = G.iterator();
                while (it.hasNext()) {
                    PostData postData = (PostData) it.next();
                    if (postData != null && postData.D() == 1) {
                        return postData.M();
                    }
                }
            }
            int K0 = this.D0.K0();
            PostData postData2 = (PostData) ListUtils.getItem(G, K0);
            if (postData2 != null && postData2.s() != null) {
                if (this.v0.K2(postData2.s().getUserId())) {
                    return postData2.M();
                }
                for (int i4 = K0 - 1; i4 != 0; i4--) {
                    PostData postData3 = (PostData) ListUtils.getItem(G, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.v0.K2(postData3.s().getUserId())) {
                        return postData3.M();
                    }
                }
                for (int i5 = K0 + 1; i5 < count; i5++) {
                    PostData postData4 = (PostData) ListUtils.getItem(G, i5);
                    if (postData4 == null || postData4.s() == null || postData4.s().getUserId() == null) {
                        break;
                    } else if (this.v0.K2(postData4.s().getUserId())) {
                        return postData4.M();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void F7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (absPbActivity = this.a) != null && absPbActivity.i1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.i1().m2()).param("topic_id", this.a.i1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.i1().q2()));
        }
    }

    public final void I7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.v0.getForumId()) && this.v0.S1() != null && this.v0.S1().l() != null) {
            boolean z3 = true;
            if (this.v0.S1().l().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.v0.f1().D(this.v0.getForumId(), this.v0.m2());
            }
        }
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (this.k1 != null) {
                m85.b bVar = new m85.b();
                bVar.a = this.k1.D();
                bVar.b = this.k1.B();
                bVar.c = String.valueOf(this.k1.E());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.j1));
        }
    }

    public final boolean Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            ThreadData P = this.v0.S1().P();
            AntiData d4 = this.v0.S1().d();
            if (!AntiHelper.b(getPageContext(), P) && !AntiHelper.d(getPageContext(), d4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if ((this.v0.S1() != null && (this.v0.S1().k0() || ThreadCardUtils.isSelf(this.v0.S1().P()))) || this.V0 == null || this.v0.S1() == null || this.v0.S1().d() == null) {
                return true;
            }
            return this.V0.checkPrivacyBeforeInvokeEditor(this.v0.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            if (this.v0.x1() || this.v0.A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.v0.m2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.v0.m2()));
            if (E7()) {
                this.a.finish();
            }
        }
    }

    public final boolean j6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            PostData c4 = vv7.c(this.v0.S1(), this.v0.k2(), this.v0.c2());
            if (c4 != null && c4.s() != null && c4.s().getGodUserData() != null && c4.s().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && this.D0 != null && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().T() != null && checkUpIsLogin() && this.D0.D0() != null && this.D0.D0().z() != null) {
            this.D0.D0().z().v(this.v0.m2(), this.v0.getFromForumId());
        }
    }

    public final void q7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            pu4 pu4Var = new pu4(getPageContext().getPageActivity());
            pu4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b5b));
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new b(this));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c(this));
            pu4Var.create(this.d1).show();
        }
    }

    public final void r6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048745, this) == null) && this.O2 != null) {
            if (this.M2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e09);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.O2.a(), this.M2, 0)));
                this.a.finish();
            }
        }
    }

    public final void s7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            showLoadingView(this.D0.n1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.D0.m1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048758, this) == null) && this.O2 != null) {
            if (this.L2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0e0a);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.O2.a(), this.L2, 0)));
                this.a.finish();
            }
        }
    }

    public final void G7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.i1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.i1().m2()).param("topic_id", this.a.i1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.i1().q2()));
        }
    }

    public void a5(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.D0.N3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = eh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = eh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092094), 0L);
            BdUniqueId bdUniqueId = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.c1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean c5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048671, this, i4)) == null) {
            if (this.V0 != null && this.v0.S1() != null && !ThreadCardUtils.isSelf(this.v0.S1().P()) && this.v0.S1().d() != null) {
                return this.V0.checkPrivacyBeforeSend(this.v0.S1().d().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void c7(p75 p75Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048673, this, p75Var) == null) && p75Var != null && (pbModel = this.v0) != null) {
            p75Var.p(pbModel.r1());
            if (this.v0.S1() != null && this.v0.S1().l() != null) {
                p75Var.o(this.v0.S1().l());
            }
            p75Var.q("pb");
            p75Var.r(this.v0);
        }
    }

    public final void d7(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048677, this, i4) != null) || (pbModel = this.v0) == null) {
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
            G6();
        }
    }

    public final void e6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bundle) == null) {
            ro4 c4 = ro4.c(this.a);
            this.x0 = c4;
            if (c4 != null) {
                c4.j(this.p2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.y0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.r2);
            this.z0 = new t25(getPageContext());
            P5();
            this.O1.setUniqueId(getUniqueId());
            this.O1.registerListener();
        }
    }

    public boolean m6(int i4) {
        InterceptResult invokeI;
        List forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048708, this, i4)) == null) {
            if (i4 == 1) {
                return true;
            }
            if (this.v0.S1().W() != null && (forumToolAuth = this.v0.S1().W().getForumToolAuth()) != null) {
                for (int i5 = 0; i5 < forumToolAuth.size(); i5++) {
                    ForumToolPerm forumToolPerm = (ForumToolPerm) forumToolAuth.get(i5);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906dc));
            uv7 d4 = ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d();
            if (d4 != null) {
                this.m2.c(true, 0, 3, 0, d4, "", 1);
            }
            this.a.k1().k(this.r0);
        }
    }

    public final boolean p6(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048738, this, z3)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.S1() == null || this.v0.S1().P() == null || this.v0.S1().P().getAuthor() == null || TextUtils.equals(this.v0.S1().P().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void t6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, bundle) == null) {
            PbModel i12 = this.a.i1();
            this.v0 = i12;
            if (i12 != null) {
                if (i12.n1() != null) {
                    this.v0.n1().c(this.K2);
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

    public void H6() {
        PbModel pbModel;
        uv7 S1;
        ThreadData P;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        uv7 uv7Var;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (pbModel = this.v0) != null && pbModel.S1() != null && (P = (S1 = this.v0.S1()).P()) != null && P.getAuthor() != null) {
            this.D0.r1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), P.getAuthor().getUserId());
            gz7 gz7Var = new gz7();
            int X = this.v0.S1().X();
            if (X != 1 && X != 3) {
                gz7Var.g = false;
            } else {
                gz7Var.g = true;
                if (P.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                gz7Var.s = z3;
            }
            if (m6(X)) {
                gz7Var.h = true;
                if (P.getIs_good() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                gz7Var.r = z8;
            } else {
                gz7Var.h = false;
            }
            if (X == 1002 && !equals) {
                gz7Var.u = true;
            }
            gz7Var.n = n7(P.isBlocked(), S1.n0(), equals, X, P.isWorksInfo(), P.isScoreThread());
            gz7Var.e = l7(equals, S1.n0());
            gz7Var.i = o7();
            gz7Var.f = m7(equals);
            if (equals && S1.W() != null && S1.W().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            gz7Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                gz7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            gz7Var.t = equals;
            gz7Var.q = this.v0.k2();
            gz7Var.b = true;
            gz7Var.a = p6(equals);
            if (equals) {
                this.D0.H1();
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            gz7Var.p = z5;
            gz7Var.j = true;
            gz7Var.o = this.v0.v1();
            gz7Var.d = true;
            if (P.getThreadVideoInfo() == null) {
                gz7Var.c = true;
            } else {
                gz7Var.c = false;
            }
            if (S1.k0()) {
                gz7Var.b = false;
                gz7Var.d = false;
                gz7Var.c = false;
                gz7Var.g = false;
                gz7Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !S1.k0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            gz7Var.v = z6;
            if (this.D0 != null && (uv7Var = this.v0.G) != null) {
                PostData Y = uv7Var.Y();
                if (Y != null) {
                    z7 = Y.R;
                } else {
                    z7 = false;
                }
                gz7Var.w = z7;
            }
            gz7Var.m = true;
            if (P.isBlocked()) {
                gz7Var.n = false;
                gz7Var.g = false;
                gz7Var.h = false;
            }
            this.D0.h.F(gz7Var);
        }
    }

    public void K6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && this.v0.S1().l() != null) {
                if (Y4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.v0.S1().k0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.D0.i0();
                    return;
                } else {
                    if (this.W0 == null) {
                        er6 er6Var = new er6(getPageContext());
                        this.W0 = er6Var;
                        er6Var.j(0);
                        this.W0.i(new f1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.W0.g(this.v0.S1().l().getId(), eh.g(this.v0.m2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void J6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048609, this, str, i4, eVar) != null) || eVar == null) {
            return;
        }
        uv7 S1 = this.v0.S1();
        TbRichText L7 = L7(str, i4);
        if (L7 == null || (tbRichTextData = L7.B().get(this.x2)) == null) {
            return;
        }
        eVar.f = String.valueOf(L7.getPostId());
        eVar.a = new ArrayList();
        eVar.b = new ConcurrentHashMap();
        boolean z3 = false;
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a4 = vv7.a(tbRichTextData);
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
            imageUrlData.originalUrl = I5(tbRichTextData);
            imageUrlData.originalUrl = I5(tbRichTextData);
            imageUrlData.originalSize = J5(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = C5(tbRichTextData);
            imageUrlData.isLongPic = A5(tbRichTextData);
            imageUrlData.postId = L7.getPostId();
            imageUrlData.mIsReserver = this.v0.d2();
            imageUrlData.mIsSeeHost = this.v0.v1();
            eVar.b.put(a4, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.P() != null) {
                    eVar.e = S1.P().getId();
                }
                if (S1.s() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = eh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.G().size();
        this.z2 = false;
        eVar.j = -1;
        if (S1.j() != null) {
            i5 = y5(S1.j().X(), L7, i4, i4, eVar.a, eVar.b);
        } else {
            i5 = i4;
        }
        int i7 = i5;
        for (int i8 = 0; i8 < size; i8++) {
            PostData postData = (PostData) S1.G().get(i8);
            if (postData.M() == null || S1.j() == null || S1.j().M() == null || !postData.M().equals(S1.j().M())) {
                i7 = y5(postData.X(), L7, i7, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList arrayList = eVar.a;
            eVar.i = (String) arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.P() != null) {
                eVar.e = S1.P().getId();
            }
            if (S1.s() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i7;
    }

    public final void K7(int i4) {
        PbModel pbModel;
        ThreadData P;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048614, this, i4) != null) || (pbModel = this.v0) == null || pbModel.S1() == null || (P = this.v0.S1().P()) == null) {
            return;
        }
        if (i4 == 1) {
            PraiseData praise = P.getPraise();
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
                    P.setPraise(praiseData);
                } else {
                    P.getPraise().getUser().add(0, metaData);
                    P.getPraise().setNum(P.getPraise().getNum() + 1);
                    P.getPraise().setIsLike(i4);
                }
            }
            if (P.getPraise() != null) {
                if (P.getPraise().getNum() < 1) {
                    getResources().getString(R.string.obfuscated_res_0x7f0f1683);
                } else {
                    StringHelper.numFormatOver10000(P.getPraise().getNum());
                }
            }
        } else if (P.getPraise() != null) {
            P.getPraise().setIsLike(i4);
            P.getPraise().setNum(P.getPraise().getNum() - 1);
            ArrayList<MetaData> user = P.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        P.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
            if (P.getPraise().getNum() < 1) {
                getResources().getString(R.string.obfuscated_res_0x7f0f1683);
            } else {
                String str = P.getPraise().getNum() + "";
            }
        }
        if (this.v0.k2()) {
            this.D0.D0().a0();
        } else {
            this.D0.r4(this.v0.S1());
        }
    }

    public final boolean U6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203c);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (postData.getType() != PostData.O0 && !TextUtils.isEmpty(postData.v()) && jq4.c().g()) {
                return C6(postData.M());
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null) {
                if (O5().d1() != null) {
                    O5().d1().c();
                }
                kw7 kw7Var = new kw7();
                kw7Var.A(this.v0.S1().l());
                kw7Var.E(this.v0.S1().P());
                kw7Var.C(postData);
                O5().c1().V(kw7Var);
                O5().c1().setPostId(postData.M());
                v6(view2, postData.s().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                n75 n75Var = this.S0;
                if (n75Var != null) {
                    this.D0.V2(n75Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final AbsPbActivity.e L6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            String str2 = null;
            if (this.v0.S1() != null && this.v0.S1().G() != null && this.v0.S1().G().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.v0.S1().G().size()) {
                        if (str.equals(((PostData) this.v0.S1().G().get(i4)).M())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                PostData postData = (PostData) this.v0.S1().G().get(i4);
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
                    J6(str2, 0, eVar);
                    vv7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void Q6(kw7 kw7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048632, this, kw7Var) != null) || kw7Var.i() == null) {
            return;
        }
        String M = kw7Var.i().M();
        ArrayList G = this.v0.S1().G();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= G.size()) {
                break;
            }
            PostData postData = (PostData) G.get(i4);
            if (postData.M() != null && postData.M().equals(M)) {
                ArrayList k3 = kw7Var.k();
                postData.Y0(kw7Var.m());
                if (postData.a0() != null && k3 != null) {
                    Iterator it = k3.iterator();
                    while (it.hasNext()) {
                        PostData postData2 = (PostData) it.next();
                        if (postData.h0() != null && postData2 != null && postData2.s() != null && (metaData = postData.h0().get(postData2.s().getUserId())) != null) {
                            postData2.C0(metaData);
                            postData2.O0(true);
                            postData2.h1(getPageContext(), this.v0.K2(metaData.getUserId()));
                        }
                    }
                    if (k3.size() == postData.a0().size()) {
                        z3 = false;
                    }
                    if (!postData.o0(false)) {
                        postData.a0().clear();
                        postData.a0().addAll(k3);
                    }
                }
                if (postData.A() != null) {
                    postData.A0();
                }
            } else {
                i4++;
            }
        }
        if (!this.v0.B1() && z3) {
            this.D0.G1(this.v0.S1());
        }
        if (z3) {
            O6(kw7Var);
        }
    }

    public void X4(boolean z3) {
        yz7 yz7Var;
        int i4;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z3) == null) && (yz7Var = this.D0) != null && yz7Var.T0() != null) {
            int firstVisiblePosition = this.D0.T0().getFirstVisiblePosition();
            int lastVisiblePosition = this.D0.T0().getLastVisiblePosition();
            fy7 D0 = this.D0.D0();
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
                            PostData postData2 = (PostData) ListUtils.getItem(this.v0.S1().G(), postData.D() - 1);
                            if (postData.o() == null && postData2 != null) {
                                postData.B0(postData2.o());
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
                    Collections.sort(arrayList, new w1(this));
                    f45 f45Var = (f45) ListUtils.getItem(arrayList, 0);
                    if (f45Var != null && f45Var.e() == 1) {
                        if (!z3) {
                            this.D0.y2(f45Var, 0);
                            return;
                        }
                        return;
                    }
                    this.D0.y2(f45Var, 1);
                }
            }
        }
    }

    public final TbRichText L7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048618, this, str, i4)) == null) {
            PbModel pbModel = this.v0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i4 < 0) {
                return null;
            }
            uv7 S1 = this.v0.S1();
            if (S1.j() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(S1.j());
                tbRichText = x5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList G = S1.G();
                W4(S1, G);
                return x5(G, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void j5(pu4 pu4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048697, this, pu4Var, jSONArray) == null) {
            pu4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(pu4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                i5((SparseArray) pu4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void P6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048629, this, z3, markData) == null) {
            this.D0.r3();
            this.v0.H3(z3);
            ro4 ro4Var = this.x0;
            if (ro4Var != null) {
                ro4Var.h(z3);
                if (markData != null) {
                    this.x0.i(markData);
                }
            }
            if (this.v0.D1()) {
                x6();
            } else {
                this.D0.G1(this.v0.S1());
            }
        }
    }

    @Override // com.baidu.tieba.sl5
    public void R(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048633, this, context, str, z3) == null) {
            if (e08.c(str) && (pbModel = this.v0) != null && pbModel.m2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.v0.m2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    x45 x45Var = new x45();
                    x45Var.a = str;
                    x45Var.b = 3;
                    x45Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, x45Var));
                }
            } else {
                e08.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void p0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048736, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (pl5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), pl5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (e08.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new hj5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void T4() {
        PbModel pbModel;
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (pbModel = this.v0) != null && (uv7Var = pbModel.G) != null && uv7Var.P() != null) {
            ThreadData P = this.v0.G.P();
            P.mRecomAbTag = this.v0.X1();
            P.mRecomWeight = this.v0.a2();
            P.mRecomSource = this.v0.Z1();
            P.mRecomExtra = this.v0.Y1();
            P.isSubPb = this.v0.F1();
            if (P.getFid() == 0) {
                P.setFid(eh.g(this.v0.getForumId(), 0L));
            }
            StatisticItem i4 = yc5.i(getContext(), P, "c13562");
            TbPageTag l3 = yc5.l(getContext());
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            this.f = true;
            super.onPause();
            s18.a();
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
            yz7 yz7Var = this.D0;
            if (yz7Var != null) {
                yz7Var.i2();
            }
            if (!this.v0.F1()) {
                this.S0.N(this.v0.m2());
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.V2();
            }
            sl4.w().E();
            MessageManager.getInstance().unRegisterListener(this.B1);
            V6();
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
            o35 o35Var = this.i0;
            if (o35Var != null) {
                o35Var.q();
                this.i0.p();
            }
        }
    }

    public final void z6() {
        MarkData i12;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048777, this) == null) && this.x0 != null) {
            if (this.v0.S1() != null && this.v0.S1().k0()) {
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
                if (this.D0 != null && this.v0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !t18.k(this.v0.b)) {
                    this.D0.a4();
                    t18.b(this.v0.b);
                }
                this.x0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.x0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.sl5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048646, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.K0 = str;
            if (this.l == null) {
                g6();
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

    public final void h7(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048693, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new y1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                x7(str);
            } else {
                this.D0.f4(str);
            }
        }
    }

    public final void W4(uv7 uv7Var, ArrayList arrayList) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048651, this, uv7Var, arrayList) == null) && uv7Var != null && uv7Var.U() != null && uv7Var.U().a != null && (list = uv7Var.U().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData postData = (PostData) it.next();
                    if (postData != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData2 = (PostData) it2.next();
                            if (postData2 != null && !TextUtils.isEmpty(postData.M()) && !TextUtils.isEmpty(postData2.M()) && postData.M().equals(postData2.M())) {
                                arrayList2.add(postData2);
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

    public final void W6(boolean z3, PostData postData) {
        q05 adAdSense;
        yz7 yz7Var;
        fy7 D0;
        ArrayList E;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048653, this, z3, postData) != null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e() || (yz7Var = this.D0) == null || (D0 = yz7Var.D0()) == null || (E = D0.E()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData postData2 = (PostData) it.next();
            String M = postData2.M();
            if (z3) {
                if (postData2 == postData) {
                    arrayList.add(new wn8.c());
                    break;
                }
            } else if (postData2.D == 1 && !TextUtils.isEmpty(M)) {
                postData2.D = 2;
                arrayList.add(new wn8.c());
            }
        }
        if (arrayList.size() > 0 && (pbModel = this.v0) != null && pbModel.S1() != null && this.v0.S1().l() != null) {
            this.v0.S1().l().getFirst_class();
            this.v0.S1().l().getSecond_class();
            this.v0.S1().l().getId();
            this.v0.m2();
        }
    }

    public final void p5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048737, this, i4, gVar) != null) || gVar == null) {
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
                this.v0.S1().P().setIs_good(1);
                this.v0.u3(1);
            } else if (i4 == 3) {
                this.v0.S1().P().setIs_good(0);
                this.v0.u3(0);
            } else if (i4 == 4) {
                this.v0.S1().P().setIs_top(1);
                this.v0.v3(1);
            } else if (i4 == 5) {
                this.v0.S1().P().setIs_top(0);
                this.v0.v3(0);
            }
            this.D0.o4(this.v0.S1(), this.v0.k2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0d33);
        }
        fj.N(getPageContext().getPageActivity(), string);
    }

    public void X5(boolean z3, String str, SparseArray sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092095);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092097);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092096);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092092) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092092);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092093);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.f1);
            userMuteAddAndDelCustomMessage.setTag(this.f1);
            y7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
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
        List<? extends zu4> c4;
        int i4;
        boolean z20;
        wu4 wu4Var;
        wu4 wu4Var2;
        wu4 wu4Var3;
        wu4 wu4Var4;
        wu4 wu4Var5;
        wu4 wu4Var6;
        pn pnVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                return true;
            }
            yz7 yz7Var = this.D0;
            if (yz7Var != null) {
                if (yz7Var.K1()) {
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
                if (l6(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.i1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.j1 = url;
                        if (this.i1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092077) != null && (view2.getTag(R.id.obfuscated_res_0x7f092077) instanceof TbRichTextImageInfo)) {
                            this.k1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f092077);
                        } else {
                            this.k1 = null;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
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
                        this.D0.S3(this.C2, this.i1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
            this.A2 = postData;
            if (postData == null) {
                return true;
            }
            if (postData.D() == 1 && l6(view2)) {
                this.D0.S3(this.C2, this.i1.t());
                return true;
            }
            ro4 ro4Var = this.x0;
            if (ro4Var == null) {
                return true;
            }
            if (ro4Var.e() && this.A2.M() != null && this.A2.M().equals(this.v0.N1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (K().S1() != null && K().S1().k0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (K().S1() != null && K().S1().p0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (K().S1() != null && K().S1().o0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.A2.D() == 1) {
                if (!z4) {
                    this.D0.T3(this.B2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.J0 == null) {
                av4 av4Var = new av4(getContext());
                this.J0 = av4Var;
                av4Var.n(this.e2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (l6(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (l6(view2) && (pnVar = this.i1) != null && !pnVar.t()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092055)).booleanValue();
                } else {
                    z9 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean) {
                    z10 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                } else {
                    z10 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                    z11 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                } else {
                    z11 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean) {
                    z12 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
                } else {
                    z12 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                    z13 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                } else {
                    z13 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean) {
                    z14 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                } else {
                    z14 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f09204c) instanceof String) {
                    str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09204c);
                } else {
                    str = null;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean) {
                    z15 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092054)).booleanValue();
                } else {
                    z15 = false;
                }
                boolean z21 = z15;
                if (sparseArray.get(R.id.obfuscated_res_0x7f09205d) instanceof Boolean) {
                    z16 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).booleanValue();
                } else {
                    z16 = false;
                }
                if (z7) {
                    z17 = z16;
                    z19 = z14;
                    z18 = z13;
                    arrayList.add(new wu4(1, getString(R.string.obfuscated_res_0x7f0f10c1), this.J0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new wu4(2, getString(R.string.obfuscated_res_0x7f0f10c2), this.J0));
                }
                if (!z7 && !z8) {
                    wu4 wu4Var7 = new wu4(3, getString(R.string.obfuscated_res_0x7f0f0459), this.J0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203c, this.A2);
                    wu4Var7.d.setTag(sparseArray3);
                    arrayList.add(wu4Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        wu4Var6 = new wu4(4, getString(R.string.obfuscated_res_0x7f0f1004), this.J0);
                    } else {
                        wu4Var6 = new wu4(4, getString(R.string.obfuscated_res_0x7f0f0ab8), this.J0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f09203c, this.A2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
                    wu4Var6.d.setTag(sparseArray4);
                    arrayList.add(wu4Var6);
                }
                if (this.mIsLogin) {
                    if (!r18.i(this.v0) && !z12 && z11) {
                        wu4 wu4Var8 = new wu4(5, getString(R.string.obfuscated_res_0x7f0f0b5c), this.J0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                        wu4Var8.d.setTag(sparseArray5);
                        arrayList.add(wu4Var8);
                    } else {
                        if (p6(z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            wu4 wu4Var9 = new wu4(5, getString(R.string.obfuscated_res_0x7f0f1029), this.J0);
                            wu4Var9.d.setTag(str);
                            arrayList.add(wu4Var9);
                        }
                    }
                    if (z12) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204c, str);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                        if (!r18.i(this.v0) && z18) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                        }
                        if (z19) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z10));
                            sparseArray6.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z21));
                            if (z21) {
                                wu4Var5 = new wu4(6, getString(R.string.obfuscated_res_0x7f0f04b8), this.J0);
                                wu4Var5.d.setTag(sparseArray6);
                                wu4Var2 = new wu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.J0);
                                wu4Var2.d.setTag(sparseArray6);
                                wu4Var3 = wu4Var5;
                                wu4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                        }
                        wu4Var5 = null;
                        wu4Var2 = new wu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.J0);
                        wu4Var2.d.setTag(sparseArray6);
                        wu4Var3 = wu4Var5;
                        wu4Var = null;
                    } else if (z19) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                        sparseArray7.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z10));
                        sparseArray7.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                        if (this.v0.S1().X() == 1002 && !z10) {
                            wu4Var4 = new wu4(6, getString(R.string.obfuscated_res_0x7f0f1029), this.J0);
                        } else {
                            wu4Var4 = new wu4(6, getString(R.string.obfuscated_res_0x7f0f04b8), this.J0);
                        }
                        wu4Var4.d.setTag(sparseArray7);
                        if (z17) {
                            wu4Var = new wu4(13, getString(R.string.obfuscated_res_0x7f0f0b4c), this.J0);
                            wu4Var3 = wu4Var4;
                        } else {
                            wu4Var3 = wu4Var4;
                            wu4Var = null;
                        }
                        wu4Var2 = null;
                    } else {
                        wu4Var = null;
                        wu4Var2 = null;
                        wu4Var3 = null;
                    }
                    if (wu4Var3 != null) {
                        arrayList.add(wu4Var3);
                    }
                    if (wu4Var != null) {
                        arrayList.add(wu4Var);
                    }
                    if (wu4Var2 != null) {
                        arrayList.add(wu4Var2);
                    }
                    r18.b(arrayList, this.J0, this.A2, this.v0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = r18.d(arrayList, this.A2.q(), sparseArray, this.J0);
                } else {
                    c4 = r18.c(arrayList, this.A2.q(), sparseArray, this.J0);
                }
                r18.l(c4, this.b);
                r18.f(c4);
                this.J0.o(r18.g(this.A2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.J0.k(c4, false);
                } else {
                    this.J0.k(c4, true);
                }
                yu4 yu4Var = new yu4(getPageContext(), this.J0);
                this.I0 = yu4Var;
                yu4Var.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.v0.b).param("fid", this.v0.getForumId()).param("uid", this.v0.S1().P().getAuthor().getUserId()).param("post_id", this.v0.B());
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

    @Override // com.baidu.tieba.e38
    public void finish() {
        yz7 yz7Var;
        boolean z3;
        CardHListViewData q3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            yz7 yz7Var2 = this.D0;
            if (yz7Var2 != null) {
                yz7Var2.p0();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.S1() != null && !this.v0.S1().k0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.v0.S1().P().getId();
                if (this.v0.isShareThread() && this.v0.S1().P().originalThreadData != null) {
                    historyMessage.threadName = this.v0.S1().P().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.v0.S1().P().getTitle();
                }
                if (this.v0.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.v0.S1().l().getName();
                }
                ArrayList G = this.v0.S1().G();
                yz7 yz7Var3 = this.D0;
                if (yz7Var3 != null) {
                    i4 = yz7Var3.K0();
                } else {
                    i4 = 0;
                }
                if (G != null && i4 >= 0 && i4 < G.size()) {
                    historyMessage.postID = ((PostData) G.get(i4)).M();
                }
                historyMessage.isHostOnly = this.v0.v1();
                historyMessage.isSquence = this.v0.k2();
                historyMessage.isShareThread = this.v0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            n75 n75Var = this.S0;
            if (n75Var != null) {
                n75Var.D();
            }
            if (this.i && O5() != null) {
                O5().u0();
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
            if (E7()) {
                if (this.v0 != null && (yz7Var = this.D0) != null && yz7Var.T0() != null) {
                    uv7 S1 = this.v0.S1();
                    if (S1 != null) {
                        if (S1.W() != null) {
                            S1.W().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            S1.W().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!S1.s0() && !this.H && S1.h == null) {
                            nz7 b4 = nz7.b();
                            uv7 T1 = this.v0.T1();
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
                                nz7.b().q(this.v0.o2());
                                nz7.b().r(this.v0.p2());
                                nz7.b().o(this.v0.L1());
                            }
                        }
                    }
                } else {
                    nz7.b().m();
                }
                D7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            sl8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
                W6(false, null);
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.v0.destory();
                if (this.v0.O1() != null) {
                    this.v0.O1().d();
                }
            }
            n75 n75Var = this.S0;
            if (n75Var != null) {
                n75Var.D();
            }
            ForumManageModel forumManageModel = this.y0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.M();
            }
            yz7 yz7Var = this.D0;
            if (yz7Var != null) {
                yz7Var.d2();
                z18 z18Var2 = this.D0.h;
                if (z18Var2 != null) {
                    z18Var2.y();
                }
            }
            pd5 pd5Var = this.t;
            if (pd5Var != null) {
                pd5Var.c();
            }
            c18 c18Var = this.e;
            if (c18Var != null) {
                c18Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            yz7 yz7Var2 = this.D0;
            if (yz7Var2 != null) {
                yz7Var2.p0();
            }
            if (this.U1 != null) {
                hh.a().removeCallbacks(this.U1);
            }
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.l2);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            this.d1 = null;
            this.e1 = null;
            uf8.e().g();
            if (this.g1 != null) {
                hh.a().removeCallbacks(this.g1);
            }
            yz7 yz7Var3 = this.D0;
            if (yz7Var3 != null && (z18Var = yz7Var3.h) != null) {
                z18Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            b08 b08Var = this.H0;
            if (b08Var != null) {
                b08Var.j();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && pbModel2.f1() != null) {
                this.v0.f1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.V0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            yz7 yz7Var4 = this.D0;
            if (yz7Var4 != null) {
                yz7Var4.h4();
            }
            p18 p18Var = this.s0;
            if (p18Var != null) {
                p18Var.e();
            }
        }
    }

    public void g5(ForumManageModel.b bVar, yz7 yz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048687, this, bVar, yz7Var) == null) {
            List list = this.v0.S1().U().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= ((PostData) list.get(i4)).a0().size()) {
                        break;
                    } else if (bVar.g.equals(((PostData) list.get(i4)).a0().get(i5).M())) {
                        ((PostData) list.get(i4)).a0().remove(i5);
                        ((PostData) list.get(i4)).k();
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                ((PostData) list.get(i4)).l(bVar.g);
            }
            if (z3) {
                yz7Var.G1(this.v0.S1());
            }
        }
    }

    public final void g6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048688, this) != null) || this.l != null) {
            return;
        }
        this.l = new ru4(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), getPageContext().getString(R.string.obfuscated_res_0x7f0f11e0), getPageContext().getString(R.string.obfuscated_res_0x7f0f10f3)};
        ru4 ru4Var = this.l;
        ru4Var.j(strArr, new p0(this));
        ru4Var.g(ru4.b.obfuscated_res_0x7f1003ad);
        ru4Var.h(17);
        ru4Var.c(getPageContext());
    }

    public final void g7() {
        PbModel pbModel;
        ImMessageCenterPojo i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && (pbModel = this.v0) != null && pbModel.G != null) {
            long c4 = j35.c();
            if (c4 <= 0 || (i4 = ua7.o().i(String.valueOf(c4), 2)) == null || ra7.a(getContext())) {
                return;
            }
            MetaData metaData = new MetaData();
            metaData.setUserIdLong(c4);
            metaData.setUserName(i4.getGroup_name());
            metaData.setName_show(i4.getNameShow());
            metaData.setPortrait(i4.getGroup_head());
            int i5 = 1;
            if (i4.getIsFriend() != 1) {
                i5 = 0;
            }
            metaData.setIsMyFriend(i5);
            cc7 cc7Var = new cc7(getContext());
            cc7Var.o(this.v0.G.P(), metaData);
            cc7Var.p();
        }
    }

    public final void w6() {
        PbModel pbModel;
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && (pbModel = this.v0) != null && (uv7Var = pbModel.G) != null && uv7Var.P() != null && this.v0.G.P().isQuestionThread()) {
            ThreadData P = this.v0.G.P();
            String e22 = this.v0.e2();
            int i4 = 3;
            if ("3".equals(this.v0.f2())) {
                i4 = 1;
            } else if ("question_answer_invite".equals(e22)) {
                i4 = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", P.getId()).param("fid", P.getFid()).param("obj_source", i4));
        }
    }

    public void k5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048701, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i5));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
            sparseArray.put(yz7.k2, Integer.valueOf(yz7.l2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                i5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void k7(SparseArray sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            r18.e(getActivity(), getPageContext(), new d1(this, sparseArray, i4, z3), new e1(this));
        }
    }

    public final boolean n7(boolean z3, boolean z4, boolean z5, int i4, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048712, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            if (!z4 || (!z5 && !n6(i4))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void o5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048713, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f04bd);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                pu4 pu4Var = new pu4(getPageContext().getPageActivity());
                pu4Var.setMessage(string);
                pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04fb, new a2(this));
                pu4Var.setCancelable(true);
                pu4Var.create(getPageContext());
                pu4Var.show();
            } else if (bVar.d != 0) {
                this.D0.z0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList G = this.v0.S1().G();
                    int size = G.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(((PostData) G.get(i4)).M())) {
                            G.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.v0.S1().P().setReply_num(this.v0.S1().P().getReply_num() - 1);
                    this.D0.G1(this.v0.S1());
                } else if (i5 == 0) {
                    e5();
                } else if (i5 == 2) {
                    ArrayList G2 = this.v0.S1().G();
                    int size2 = G2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= ((PostData) G2.get(i6)).a0().size()) {
                                break;
                            } else if (bVar.g.equals(((PostData) G2.get(i6)).a0().get(i7).M())) {
                                ((PostData) G2.get(i6)).a0().remove(i7);
                                ((PostData) G2.get(i6)).k();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        ((PostData) G2.get(i6)).l(bVar.g);
                    }
                    if (z4) {
                        this.D0.G1(this.v0.S1());
                    }
                    g5(bVar, this.D0);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048717, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.S0.C(i4, i5, intent);
            if (O5().d1() != null) {
                O5().d1().g(i4, i5, intent);
            }
            if (i4 == 25035) {
                W5(i5, intent);
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
                                                            yz7 yz7Var = this.D0;
                                                            if (yz7Var != null && yz7Var.E0() != null) {
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
                                                if (this.v0.S1() != null && this.v0.S1().P() != null && this.v0.S1().P().getPushStatusData() != null) {
                                                    this.v0.S1().P().getPushStatusData().setStatus(2);
                                                    return;
                                                }
                                                return;
                                            }
                                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                                od8.g().m(getPageContext());
                                                I7();
                                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
                                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                                    shareSuccessReplyToServerModel.z(str, intExtra, new g2(this));
                                                }
                                                if (i6()) {
                                                    G7(true);
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
                                Z5(intent);
                                return;
                            } else if (intent != null && this.v0 != null) {
                                j7(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                                return;
                            } else {
                                return;
                            }
                        }
                        od8.g().m(getPageContext());
                        return;
                    }
                    nz7.b().m();
                    this.u0.postDelayed(new f2(this), 1000L);
                    return;
                }
                z6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048723, this, layoutInflater, viewGroup, bundle)) == null) {
            this.D0 = new yz7(this, this.g2, this.T1);
            e86 e86Var = new e86(getActivity());
            this.d = e86Var;
            e86Var.i(Q2);
            this.d.d(this.J2);
            this.D0.l3(this.q2);
            this.D0.k3(this.w2);
            this.D0.d3(this.t2);
            this.D0.e3(this.u2);
            this.D0.b3(jq4.c().g());
            this.D0.i3(this.y2);
            this.D0.o3(this.E2);
            this.D0.m3(this.F2);
            this.D0.j3(this.H2);
            this.D0.h3(this.s2);
            this.D0.k4(this.mIsLogin);
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
            this.D0.U2(new m0(this));
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
        yz7 yz7Var;
        yz7 yz7Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
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
                this.L2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.M2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.N2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.N0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.O0 = intent.getStringExtra("high_light_post_id");
                this.P0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (B5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O = stringExtra;
                if (ej.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.O;
                }
                this.O = str;
                this.o1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                mt4 mt4Var = new mt4();
                this.b0 = mt4Var;
                mt4Var.a(intent);
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
            t6(bundle);
            if (this.v0.S1() != null) {
                this.v0.S1().T0(this.O);
            }
            f6();
            if (intent != null && (yz7Var2 = this.D0) != null) {
                yz7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.g1 == null) {
                        this.g1 = new j0(this, intent);
                    }
                    hh.a().postDelayed(this.g1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.v0.S1() != null) {
                    this.v0.z3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            e6(bundle);
            p75 p75Var = new p75();
            this.R0 = p75Var;
            c7(p75Var);
            n75 n75Var = (n75) this.R0.a(getActivity());
            this.S0 = n75Var;
            n75Var.W(this.a.getPageContext());
            this.S0.f0(this.i2);
            this.S0.g0(this.Y0);
            this.S0.Y(1);
            this.S0.A(this.a.getPageContext(), bundle);
            this.S0.b().b(new v55(getActivity()));
            this.S0.b().C(true);
            f7(true);
            this.S0.J(this.v0.u1(), this.v0.m2(), this.v0.q1());
            registerListener(this.y1);
            if (!this.v0.F1()) {
                this.S0.q(this.v0.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.v0.A2()) {
                this.S0.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1b));
            } else {
                yz7 yz7Var3 = this.D0;
                if (yz7Var3 != null) {
                    this.S0.c0(yz7Var3.f1());
                }
            }
            registerListener(this.x1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.w1);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.o2);
            registerListener(this.v1);
            in8 in8Var = new in8("pb", in8.d);
            this.Q0 = in8Var;
            in8Var.d();
            registerListener(this.G1);
            registerListener(this.Q1);
            this.v0.W2();
            registerListener(this.n2);
            registerListener(this.c2);
            registerListener(this.h2);
            registerListener(this.K1);
            registerListener(this.L1);
            registerListener(this.b2);
            yz7 yz7Var4 = this.D0;
            if (yz7Var4 != null && yz7Var4.m1() != null && this.D0.k1() != null) {
                c18 c18Var = new c18(getActivity(), this.D0.m1(), this.D0.k1(), this.D0.b1());
                this.e = c18Var;
                c18Var.t(this.P1);
            }
            if (this.c && (yz7Var = this.D0) != null && yz7Var.k1() != null) {
                this.D0.k1().setVisibility(8);
            }
            ay4 ay4Var = new ay4();
            this.e1 = ay4Var;
            ay4Var.a = 1000L;
            registerListener(this.Y1);
            registerListener(this.X1);
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.I1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.E1);
            this.H1.setSelfListener(true);
            this.H1.setTag(this.a.getUniqueId());
            this.H1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.H1);
            registerResponsedEventListener(TipEvent.class, this.R1);
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
            this.S1 = new g3(this.D0, this);
            this.v0.m1().D(this.S1);
            this.H0 = new b08();
            if (this.S0.s() != null) {
                this.H0.m(this.S0.s().i());
            }
            this.S0.V(this.Z0);
            this.C0 = new ShareSuccessReplyToServerModel();
            R4(this.t1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.V0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new k0(this));
            a28 a28Var = new a28(getContext());
            this.w0 = a28Var;
            a28Var.b(getUniqueId());
            sl8.g().i(getUniqueId());
            vq4.b().l("3", "");
            this.s1 = new n16(getPageContext());
            this.s0 = new p18(this, getUniqueId(), this.D0, this.v0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    public final void v6(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048761, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (Y4()) {
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
                    if (O5().d1() != null && postData != null) {
                        if (postData.X() != null) {
                            str3 = postData.X().toString();
                        } else {
                            str3 = "";
                        }
                        O5().d1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f101f), postData.s().getName_show(), str3));
                    }
                    if (this.v0.S1() != null && this.v0.S1().k0()) {
                        hh.a().postDelayed(new h1(this, str, str2), 0L);
                        return;
                    }
                    if (this.X0 == null) {
                        er6 er6Var = new er6(getPageContext());
                        this.X0 = er6Var;
                        er6Var.j(1);
                        this.X0.i(new i1(this, str, str2));
                    }
                    PbModel pbModel = this.v0;
                    if (pbModel != null && pbModel.S1() != null && this.v0.S1().l() != null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.X0.g(this.v0.S1().l().getId(), eh.g(this.v0.m2(), 0L));
                        return;
                    }
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final TbRichText x5(ArrayList arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048768, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText X = ((PostData) arrayList.get(i5)).X();
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
                                    int h4 = (int) fj.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i7).F().getWidth() * h4;
                                    int height = B.get(i7).F().getHeight() * h4;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.x2 = i7;
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

    public final int y5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList arrayList, ConcurrentHashMap concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo F;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048771, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.z2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int h4 = (int) fj.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h4;
                        int height = tbRichTextData.F().getHeight() * h4;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.F().H()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = vv7.a(tbRichTextData);
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
                                        imageUrlData.originalUrl = I5(tbRichTextData);
                                        imageUrlData.originalSize = J5(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = C5(tbRichTextData);
                                        imageUrlData.isLongPic = A5(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = eh.g(this.v0.m2(), -1L);
                                        imageUrlData.mIsReserver = this.v0.d2();
                                        imageUrlData.mIsSeeHost = this.v0.v1();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.z2) {
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

    public final void y7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048773, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.D0.N3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            pu4 pu4Var = new pu4(this.d1.getPageActivity());
            if (!ej.isEmpty(str)) {
                pu4Var.setMessage(str);
            } else {
                pu4Var.setMessage(this.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            }
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043d, new e(this, userMuteAddAndDelCustomMessage));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new f(this));
            pu4Var.create(this.d1).show();
        }
    }
}
