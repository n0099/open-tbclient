package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.a55;
import com.baidu.tieba.aj5;
import com.baidu.tieba.an8;
import com.baidu.tieba.bn8;
import com.baidu.tieba.bt4;
import com.baidu.tieba.bw6;
import com.baidu.tieba.bw7;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cy7;
import com.baidu.tieba.cz7;
import com.baidu.tieba.d35;
import com.baidu.tieba.dh;
import com.baidu.tieba.di5;
import com.baidu.tieba.dj;
import com.baidu.tieba.ds4;
import com.baidu.tieba.e18;
import com.baidu.tieba.ed8;
import com.baidu.tieba.ej;
import com.baidu.tieba.er4;
import com.baidu.tieba.eu4;
import com.baidu.tieba.f35;
import com.baidu.tieba.fh5;
import com.baidu.tieba.g16;
import com.baidu.tieba.g18;
import com.baidu.tieba.g75;
import com.baidu.tieba.gh;
import com.baidu.tieba.gy4;
import com.baidu.tieba.gy7;
import com.baidu.tieba.h18;
import com.baidu.tieba.h35;
import com.baidu.tieba.h55;
import com.baidu.tieba.h75;
import com.baidu.tieba.hi5;
import com.baidu.tieba.ho;
import com.baidu.tieba.hq4;
import com.baidu.tieba.hu8;
import com.baidu.tieba.hy4;
import com.baidu.tieba.i08;
import com.baidu.tieba.i18;
import com.baidu.tieba.i35;
import com.baidu.tieba.i75;
import com.baidu.tieba.i85;
import com.baidu.tieba.ih5;
import com.baidu.tieba.il5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.is4;
import com.baidu.tieba.j18;
import com.baidu.tieba.j28;
import com.baidu.tieba.j35;
import com.baidu.tieba.j75;
import com.baidu.tieba.ja7;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jn8;
import com.baidu.tieba.jv7;
import com.baidu.tieba.kf8;
import com.baidu.tieba.kt4;
import com.baidu.tieba.ku8;
import com.baidu.tieba.kv7;
import com.baidu.tieba.kw7;
import com.baidu.tieba.kx4;
import com.baidu.tieba.l05;
import com.baidu.tieba.l35;
import com.baidu.tieba.l75;
import com.baidu.tieba.ld5;
import com.baidu.tieba.ll5;
import com.baidu.tieba.ll8;
import com.baidu.tieba.lu7;
import com.baidu.tieba.lw7;
import com.baidu.tieba.lz4;
import com.baidu.tieba.m08;
import com.baidu.tieba.ma7;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mr5;
import com.baidu.tieba.n25;
import com.baidu.tieba.n75;
import com.baidu.tieba.nu4;
import com.baidu.tieba.nu7;
import com.baidu.tieba.nz7;
import com.baidu.tieba.o18;
import com.baidu.tieba.o55;
import com.baidu.tieba.oa5;
import com.baidu.tieba.oc5;
import com.baidu.tieba.on;
import com.baidu.tieba.ow7;
import com.baidu.tieba.ox4;
import com.baidu.tieba.p18;
import com.baidu.tieba.p38;
import com.baidu.tieba.pb;
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
import com.baidu.tieba.pn8;
import com.baidu.tieba.pu4;
import com.baidu.tieba.pu7;
import com.baidu.tieba.px7;
import com.baidu.tieba.q08;
import com.baidu.tieba.q9;
import com.baidu.tieba.qi6;
import com.baidu.tieba.ql4;
import com.baidu.tieba.qo4;
import com.baidu.tieba.qz7;
import com.baidu.tieba.r08;
import com.baidu.tieba.r55;
import com.baidu.tieba.r9;
import com.baidu.tieba.rl4;
import com.baidu.tieba.s45;
import com.baidu.tieba.s55;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sz7;
import com.baidu.tieba.t28;
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
import com.baidu.tieba.tc5;
import com.baidu.tieba.tq4;
import com.baidu.tieba.tr4;
import com.baidu.tieba.ty7;
import com.baidu.tieba.tz7;
import com.baidu.tieba.ub7;
import com.baidu.tieba.ug;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uu4;
import com.baidu.tieba.ux4;
import com.baidu.tieba.ux7;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vy7;
import com.baidu.tieba.w76;
import com.baidu.tieba.wu4;
import com.baidu.tieba.x45;
import com.baidu.tieba.x76;
import com.baidu.tieba.xt4;
import com.baidu.tieba.xv7;
import com.baidu.tieba.y15;
import com.baidu.tieba.yo4;
import com.baidu.tieba.yq6;
import com.baidu.tieba.yu4;
import com.baidu.tieba.yx4;
import com.baidu.tieba.z35;
import com.baidu.tieba.zs4;
import com.baidu.tieba.zv7;
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
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PbFragment extends BaseFragment implements ll5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, nu4.e, TbRichTextView.s, TbPageContextSupport, t28, p38.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k Q2;
    public static final x76.b R2;
    public transient /* synthetic */ FieldHolder $fh;
    public ug<TbImageView> A;
    public n25 A0;
    public CustomMessageListener A1;
    public boolean A2;
    public ug<ImageView> B;
    public bw7 B0;
    public CustomMessageListener B1;
    public PostData B2;
    public ug<View> C;
    public PollingModel C0;
    public CustomMessageListener C1;
    public final pu4.c C2;
    public ug<TiebaPlusRecommendCard> D;
    public ShareSuccessReplyToServerModel D0;
    public final CustomMessageListener D1;
    public final pu4.c D2;
    public ug<LinearLayout> E;
    public nz7 E0;
    public CustomMessageListener E1;
    public final AdapterView.OnItemClickListener E2;
    public ug<RelativeLayout> F;
    public boolean F0;
    public CustomMessageListener F1;
    public final View.OnLongClickListener F2;
    public ug<ItemCardView> G;
    public boolean G0;
    public View.OnClickListener G1;
    public final View.OnClickListener G2;
    public boolean H;
    public boolean H0;
    public CustomMessageListener H1;
    public final ItemCardHelper.c H2;
    public boolean I;
    public qz7 I0;
    public CustomMessageListener I1;
    public final NoNetworkView.b I2;
    public boolean J;
    public wu4 J0;
    public CustomMessageListener J1;
    public View.OnTouchListener J2;
    public ug<GifView> K;
    public yu4 K0;
    public SuggestEmotionModel.c K1;
    public w76.b K2;
    public String L;
    public String L0;
    public CustomMessageListener L1;
    public final cy7.b L2;
    public boolean M;
    public boolean M0;
    public CustomMessageListener M1;
    public int M2;
    public boolean N;
    public boolean N0;
    public GetSugMatchWordsModel.b N1;
    public int N2;
    public String O;
    public boolean O0;
    public boolean O1;
    public String O2;
    public LikeModel P;
    public String P0;
    public PraiseModel P1;
    public tr4 P2;
    public View Q;
    public boolean Q0;
    public r08.h Q1;
    public View R;
    public bn8 R0;
    public CustomMessageListener R1;
    public View S;
    public l75 S0;
    public oa5 S1;
    public View T;
    public j75 T0;
    public CheckRealNameModel.b T1;
    public String U;
    public boolean U0;
    public lw7 U1;
    public int V;
    public PermissionJudgePolicy V0;
    public final Runnable V1;
    public boolean W;
    public ReplyPrivacyCheckController W0;
    public CustomMessageListener W1;
    public int[] X;
    public yq6 X0;
    public CustomMessageListener X1;
    public int Y;
    public yq6 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public h75 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public g75 a1;
    public CustomMessageListener a2;
    public boolean b;
    public kt4 b0;
    public g75 b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public int c1;
    public CustomMessageListener c2;
    public x76 d;
    public kx4 d0;
    public Object d1;
    public CustomMessageListener d2;
    public r08 e;
    public boolean e0;
    public r9 e1;
    public nu4.e e2;
    public boolean f;
    public boolean f0;
    public ux4 f1;
    public yu4.e f2;
    public boolean g;
    public Object g0;
    public BdUniqueId g1;
    public SortSwitchButton.f g2;
    public boolean h;
    public an8 h0;
    public Runnable h1;
    public final View.OnClickListener h2;
    public boolean i;
    public boolean i0;
    public sz7 i1;
    public CustomMessageListener i2;
    public VoiceManager j;
    public i35 j0;
    public on j1;
    public final NewWriteModel.d j2;
    public int k;
    public String k1;
    public Boolean k2;
    public pu4 l;
    public TbRichTextImageInfo l1;
    public NewWriteModel.d l2;
    public long m;
    public TbRichTextMemeInfo m1;
    public pb m2;
    public long n;
    public boolean n1;
    public final PbModel.h n2;
    public long o;
    public int o1;
    public CustomMessageListener o2;
    public long p;
    public int p1;
    public HttpMessageListener p2;
    public long q;
    public boolean q0;
    public List<f3> q1;
    public final qo4.a q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public final AbsListView.OnScrollListener r2;
    public boolean s;
    @NonNull
    public TiePlusEventController.f s0;
    public String s1;
    public final q9 s2;
    public jd5 t;
    public e18 t0;
    public g16 t1;
    public final i3 t2;
    public long u;
    public PbInterviewStatusView.f u0;
    public final f3 u1;
    public final yx4.g u2;
    public boolean v;
    public final Handler v0;
    public final ty7.b v1;
    public final View.OnClickListener v2;
    public long w;
    public PbModel w0;
    public final CustomMessageListener w1;
    public boolean w2;
    public int x;
    public p18 x0;
    public CustomMessageListener x1;
    public final BdListView.p x2;
    public String y;
    public qo4 y0;
    public CustomMessageListener y1;
    public int y2;
    public ug<TextView> z;
    public ForumManageModel z0;
    public CustomMessageListener z1;
    public final TbRichTextView.y z2;

    /* loaded from: classes5.dex */
    public class a implements cy7.b {
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

        @Override // com.baidu.tieba.cy7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f14f0);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.E0 == null || this.a.w0 == null) {
                return;
            }
            this.a.E0.j0(false);
            if (this.a.w0.N2(false)) {
                this.a.E0.v3();
            } else if (this.a.w0.S1() != null) {
                this.a.E0.L2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.b6();
                zs4 Q1 = this.a.w0.Q1();
                int b1 = this.a.E0.b1();
                if (b1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0dfe);
                } else if (Q1 == null || b1 <= Q1.h()) {
                    this.a.E0.p0();
                    this.a.D7();
                    this.a.E0.u3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.w0.F3(this.a.E0.b1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                    }
                    nu4Var.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0dfe);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) || nu4Var == null) {
                return;
            }
            nu4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements vg<LinearLayout> {
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

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091881);
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

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    nu4Var.dismiss();
                    ((TbPageContext) this.a.e1).showToast(R.string.obfuscated_res_0x7f0f0720);
                    return;
                }
                TiebaStatic.log("c10025");
                nu4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.e1.getPageActivity(), 2, true, 4);
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (this.a.q0) {
                this.a.q0 = false;
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.J6();
            } else {
                this.a.U6();
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
        public void onNavigationButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nu4Var) == null) {
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
    public class c implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
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
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                BdLog.e(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.a.E0 == null) {
                return;
            }
            this.a.E0.z3(list);
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements yu4.e {
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

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                if (this.a.J0 != null) {
                    this.a.J0.dismiss();
                }
                this.a.I7(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ee);
                    this.a.O6(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    View view4 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f0917ed);
                    this.a.O6(view4);
                    if (view4 != null) {
                        if (sparseArray2 != null && (sparseArray2.get(R.id.obfuscated_res_0x7f092057) instanceof Boolean)) {
                            if (((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092057)).booleanValue()) {
                                this.a.a7(true);
                            } else {
                                this.a.a7(false);
                            }
                        }
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                    if (view5 != null) {
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.O6(view5);
                        if (agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                        }
                    }
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                    if (view6 != null) {
                        this.a.O6(view6);
                        AgreeView agreeView2 = (AgreeView) view6;
                        if (agreeView2.getImgAgree() != null) {
                            agreeView2.getImgAgree().performClick();
                        }
                    }
                } else if (i != 13) {
                    int i2 = 4;
                    switch (i) {
                        case 1:
                            if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                                return;
                            }
                            if (this.a.m1 == null) {
                                this.a.V4();
                            } else {
                                i85.a aVar = new i85.a();
                                aVar.a = this.a.k1;
                                String str = "";
                                if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.m1.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.j1 = null;
                            this.a.k1 = null;
                            return;
                        case 2:
                            if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                                return;
                            }
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
                                pbFragment.i1 = new sz7(pbFragment.getPageContext());
                            }
                            this.a.i1.b(this.a.k1, this.a.j1.n());
                            this.a.j1 = null;
                            this.a.k1 = null;
                            return;
                        case 3:
                            PostData postData = this.a.B2;
                            if (postData != null) {
                                postData.C0();
                                this.a.B2 = null;
                                return;
                            }
                            return;
                        case 4:
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            if (this.a.checkUpIsLogin()) {
                                this.a.B6(view2);
                                if (this.a.w0.S1().O() == null || this.a.w0.S1().O().getAuthor() == null || this.a.w0.S1().O().getAuthor().getUserId() == null || this.a.y0 == null) {
                                    return;
                                }
                                PbFragment pbFragment2 = this.a;
                                int T5 = pbFragment2.T5(pbFragment2.w0.S1());
                                ThreadData O = this.a.w0.S1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w0.b).param("obj_locate", 2).param("obj_id", this.a.w0.S1().O().getAuthor().getUserId()).param("obj_type", !this.a.y0.e()).param("obj_source", T5).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                return;
                            }
                            Object tag = view2.getTag();
                            if (tag instanceof String) {
                                TiebaStatic.log(new StatisticItem("c13079"));
                                this.a.Z5((String) tag);
                                return;
                            } else if (tag instanceof SparseArray) {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                if ((sparseArray3.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean) && ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092099)).booleanValue()) {
                                    sparseArray3.put(R.id.obfuscated_res_0x7f092050, 0);
                                    sparseArray3.put(R.id.obfuscated_res_0x7f092039, 2);
                                    this.a.b5(sparseArray3);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 != null && (sparseArray4.get(R.id.obfuscated_res_0x7f092041) instanceof Integer) && (sparseArray4.get(R.id.obfuscated_res_0x7f09203f) instanceof String) && (sparseArray4.get(R.id.obfuscated_res_0x7f09205d) instanceof Integer) && (sparseArray4.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean) && (sparseArray4.get(R.id.obfuscated_res_0x7f092051) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092040)).booleanValue();
                                int intValue = ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205d)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092051)).booleanValue();
                                boolean F = this.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                if (F) {
                                    if (!booleanValue2) {
                                        this.a.l7(sparseArray4, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.E0.v2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203f), intValue, booleanValue, null, F);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.l7(sparseArray4, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.E0.t2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203f), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                return;
                            }
                            SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                            if (sparseArray5 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092085)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092083)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092099)).booleanValue();
                            boolean booleanValue6 = sparseArray5.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092055)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.E0.t2(((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray5.get(R.id.obfuscated_res_0x7f09203f), ((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (!booleanValue5) {
                                if (booleanValue6) {
                                    sparseArray5.put(R.id.obfuscated_res_0x7f092039, 2);
                                }
                                this.a.E0.y2(view2);
                                return;
                            } else {
                                sparseArray5.put(R.id.obfuscated_res_0x7f092050, 1);
                                sparseArray5.put(R.id.obfuscated_res_0x7f092039, 2);
                                this.a.b5(sparseArray5);
                                return;
                            }
                        case 8:
                            if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d);
                                if (postData2.q() == null) {
                                    return;
                                }
                                this.a.e5(postData2.q());
                                return;
                            }
                            return;
                        case 9:
                            if (!this.a.checkUpIsLogin() || this.a.w0 == null || this.a.w0.S1() == null) {
                                return;
                            }
                            this.a.a.u1(hu8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else if (!this.a.checkUpIsLogin() || this.a.w0 == null || this.a.w0.S1() == null) {
                } else {
                    this.a.E0.s4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements yx4.g {
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

        @Override // com.baidu.tieba.yx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (!this.a.w0.R2(true)) {
                    this.a.E0.y0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c3 implements w76.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

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

        @Override // com.baidu.tieba.w76.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || !e(i2) || this.b.E0 == null || this.b.e == null) {
                return;
            }
            this.b.e.u(true);
            if (Math.abs(i2) > this.a) {
                this.b.e.l();
            }
            if (this.b.C5()) {
                this.b.E0.w1();
                this.b.E0.S2();
            }
        }

        @Override // com.baidu.tieba.w76.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.b.E0 == null || this.b.e == null) {
                return;
            }
            this.b.E0.X3();
            this.b.e.u(false);
            this.b.e.x();
        }

        @Override // com.baidu.tieba.w76.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.w76.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public final boolean e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) ? Math.abs(f) >= 1.0f : invokeF.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
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
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.O1 = false;
                if (this.a.P1 == null || str == null) {
                    return;
                }
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.O1 = false;
                if (this.a.P1 == null) {
                    return;
                }
                jv7 S1 = this.a.w0.S1();
                if (S1.O().getPraise().getIsLike() == 1) {
                    this.a.L7(0);
                } else {
                    this.a.L7(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, S1.O()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                if (nu4Var != null) {
                    nu4Var.dismiss();
                }
                this.d.l5(((Integer) this.a.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203f), this.b, this.c);
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
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (!this.a.w0.R2(true)) {
                    this.a.E0.y0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d3 implements x76.b {
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

        @Override // com.baidu.tieba.x76.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    kw7.d();
                } else {
                    kw7.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.b.E0.P3();
                MessageManager.getInstance().sendMessage(this.a);
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements r08.h {
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

        @Override // com.baidu.tieba.r08.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.c7(z);
                if (this.a.E0.R0() != null && z) {
                    this.a.E0.e4(false);
                }
                this.a.E0.k2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
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
                if (this.a.w2 && this.a.C5()) {
                    this.a.s6();
                }
                if (this.a.mIsLogin) {
                    if (!this.a.e0 && this.a.E0 != null && this.a.E0.g0() && this.a.w0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.a.w0.m2());
                        statisticItem.param("fid", this.a.w0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.w0.x1()) {
                            i = 4;
                        } else if (this.a.w0.y1()) {
                            i = 3;
                        } else if (this.a.w0.A1()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.e0 = true;
                    }
                    if (this.a.w0.N2(false)) {
                        this.a.E0.v3();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.t0 == null || !this.a.w0.H2() || !this.a.t0.d()) && this.a.w0.S1() != null) {
                        this.a.E0.L2();
                    }
                    this.a.w2 = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e3 implements ty7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.ty7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.E0.h4(str);
        }

        @Override // com.baidu.tieba.ty7.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
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
                this.a.E0.e4(!this.a.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements yq6.d {
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

        @Override // com.baidu.tieba.yq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    if (this.a.T0 != null && this.a.T0.a() != null) {
                        this.a.T0.a().A(new h55(45, 27, null));
                    }
                    this.a.E0.i0();
                }
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w0 == null) {
                return;
            }
            this.a.w0.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public interface f3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public class g extends di5<ShareItem> {
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
        @Override // com.baidu.tieba.di5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return i18.d(this.a.t5(), ShareSwitch.isOn() ? 1 : 6, this.a.w0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements yu4.e {
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

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                if (this.e.J0 != null) {
                    this.e.J0.dismiss();
                }
                if (i == 0) {
                    this.e.E0.t2(((Integer) this.a.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203f), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092096);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092098);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092097);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.g1);
                    this.e.z7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092094));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.E0.p0();
                boolean z = false;
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.w0 != null && !this.a.w0.isLoading) {
                        this.a.D7();
                        this.a.E0.u3();
                        z = true;
                        if (this.a.w0.S1() != null && this.a.w0.S1().f != null && this.a.w0.S1().f.size() > i) {
                            int intValue = this.a.w0.S1().f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.w0.n2()).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.w0.L3(intValue)) {
                                this.a.h = true;
                                this.a.E0.i3(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                return false;
            }
            return invokeI.booleanValue;
        }

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
    }

    /* loaded from: classes5.dex */
    public class g2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
                    ow7.a(this.b.a.getPageContext(), this.a).show();
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
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
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
    public static class g3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<nz7> a;
        public WeakReference<PbFragment> b;

        public g3(nz7 nz7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(nz7Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                nz7 nz7Var = this.a.get();
                if (nz7Var != null) {
                    nz7Var.v1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment == null || !CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    return;
                }
                if (i == 0) {
                    Integer num = 0;
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    }
                    pbFragment.x7(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    bw6.d();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                    }
                    pbFragment.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ih5<ShareItem> {
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
        @Override // com.baidu.tieba.ih5
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.Q2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.u5().s() != null && this.a.u5().s().getGodUserData() != null) {
                        this.a.u5().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.w0 == null || this.a.w0.S1() == null || this.a.w0.S1().O() == null || this.a.w0.S1().O().getAuthor() == null) {
                        return;
                    }
                    this.a.w0.S1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
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
                qz7 qz7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qz7Var = this.a.c.I0) == null || qz7Var.g() == null) {
                    return;
                }
                if (!this.a.c.I0.g().e()) {
                    this.a.c.I0.b(false);
                }
                this.a.c.I0.g().l(false);
            }

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
                int i2 = ej.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = ej.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = ej.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.P5().U0().smoothScrollBy((pbFragment.X[1] + pbFragment.Y) - i3, 50);
                if (this.c.P5().e1() != null) {
                    this.c.T0.a().setVisibility(8);
                    this.c.P5().e1().o(this.a, this.b, this.c.P5().h1(), (this.c.w0 == null || this.c.w0.S1() == null || this.c.w0.S1().O() == null || !this.c.w0.S1().O().isBjh()) ? false : false);
                    n75 b = this.c.P5().e1().b();
                    if (b != null && this.c.w0 != null && this.c.w0.S1() != null) {
                        b.H(this.c.w0.S1().d());
                        b.d0(this.c.w0.S1().O());
                    }
                    if (this.c.I0.f() == null && this.c.P5().e1().b().u() != null) {
                        this.c.P5().e1().b().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.I0.n(pbFragment2.P5().e1().b().u().i());
                        this.c.P5().e1().b().N(this.c.b1);
                    }
                }
                this.c.P5().r1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ nu4 c;
        public final /* synthetic */ PbFragment d;

        public h2(PbFragment pbFragment, MarkData markData, MarkData markData2, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, nu4Var};
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
            this.c = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
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
                this.d.E7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h3 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class i extends di5<ShareItem> {
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
        @Override // com.baidu.tieba.di5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.t3(this.a);
                }
                return i18.d(this.b.t5(), 2, K);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends oa5<TipEvent> {
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
        @Override // com.baidu.tieba.ha5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.c.a.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements yq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0377a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0377a(a aVar) {
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
                    qz7 qz7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qz7Var = this.a.a.c.I0) == null || qz7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.I0.g().e()) {
                        this.a.a.c.I0.b(false);
                    }
                    this.a.a.c.I0.g().l(false);
                }

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
                    int i2 = ej.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.P5().U0().smoothScrollBy((pbFragment.X[1] + pbFragment.Y) - i3, 50);
                    if (this.a.c.P5().e1() != null) {
                        this.a.c.T0.a().setVisibility(8);
                        z = (this.a.c.w0 == null || this.a.c.w0.S1() == null || this.a.c.w0.S1().O() == null || !this.a.c.w0.S1().O().isBjh()) ? false : false;
                        gy7 e1 = this.a.c.P5().e1();
                        i1 i1Var = this.a;
                        e1.o(i1Var.a, i1Var.b, i1Var.c.P5().h1(), z);
                        n75 b = this.a.c.P5().e1().b();
                        if (b != null && this.a.c.w0 != null && this.a.c.w0.S1() != null) {
                            b.H(this.a.c.w0.S1().d());
                            b.d0(this.a.c.w0.S1().O());
                        }
                        if (this.a.c.I0.f() == null && this.a.c.P5().e1().b().u() != null) {
                            this.a.c.P5().e1().b().u().g(new C0377a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.I0.n(pbFragment2.P5().e1().b().u().i());
                            this.a.c.P5().e1().b().N(this.a.c.b1);
                        }
                    }
                    this.a.c.P5().r1();
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

        @Override // com.baidu.tieba.yq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    gh.a().postDelayed(new a(this), 200L);
                }
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements g75 {
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

        @Override // com.baidu.tieba.g75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qz7 qz7Var = this.a.I0;
                if (qz7Var == null || qz7Var.g() == null || !this.a.I0.g().d()) {
                    return !this.a.d5(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.I0.g().c());
                if (this.a.E0 != null && this.a.E0.e1() != null && this.a.E0.e1().b() != null && this.a.E0.e1().b().y()) {
                    this.a.E0.e1().b().w(this.a.I0.h());
                }
                this.a.I0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface i3 {
    }

    /* loaded from: classes5.dex */
    public class j implements ih5<ShareItem> {
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
        @Override // com.baidu.tieba.ih5
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz7 nz7Var = this.b.E0;
                nz7Var.x3("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements yu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wu4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ j1 c;

            public a(j1 j1Var, wu4 wu4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, wu4Var, view2};
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
                this.a = wu4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.w0.j2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.yu4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void n0(yu4 yu4Var, int i, View view2) {
                boolean L3;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, yu4Var, i, view2) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.c.a.w0.j2() != 1 || i != 1) {
                    if (this.c.a.w0.j2() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.w0.j2() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09187d ? 1 : 0).param("obj_type", i2));
                    if (this.c.a.w0.S1().f != null && this.c.a.w0.S1().f.size() > i) {
                        i = this.c.a.w0.S1().f.get(i).sort_type.intValue();
                    }
                    L3 = this.c.a.w0.L3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.w0.i2()));
                    if (L3) {
                        return;
                    }
                    this.c.a.h = true;
                    this.c.a.E0.i3(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09187d ? 1 : 0).param("obj_type", i2));
                if (this.c.a.w0.S1().f != null) {
                    i = this.c.a.w0.S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.w0.L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.w0.i2()));
                if (L3) {
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

        /* JADX WARN: Code restructure failed: missing block: B:906:0x2175, code lost:
            if (r7 == (r32.a.E0.f1().c().getHeight() - r32.a.E0.f1().e())) goto L953;
         */
        /* JADX WARN: Code restructure failed: missing block: B:944:0x2301, code lost:
            if (r32.a.E0.d1.c.getView().getTop() <= ((r32.a.E0.f1() == null || r32.a.E0.f1().c() == null) ? 0 : r32.a.E0.f1().c().getBottom())) goto L882;
         */
        /* JADX WARN: Code restructure failed: missing block: B:945:0x2303, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:947:0x2310, code lost:
            if (r0 >= com.baidu.tieba.i08.d(r32.a.G5())) goto L882;
         */
        /* JADX WARN: Code restructure failed: missing block: B:969:0x23b7, code lost:
            if ((r32.a.E0.d1.c.getView().getTop() - r32.a.E0.h.a.getBottom()) < (r32.a.E0.d1.c.g.getHeight() + 10)) goto L882;
         */
        /* JADX WARN: Removed duplicated region for block: B:1238:0x2d4a  */
        /* JADX WARN: Removed duplicated region for block: B:1239:0x2d60  */
        /* JADX WARN: Removed duplicated region for block: B:1242:0x2d9c  */
        /* JADX WARN: Removed duplicated region for block: B:332:0x0b86  */
        /* JADX WARN: Removed duplicated region for block: B:333:0x0b8a  */
        /* JADX WARN: Removed duplicated region for block: B:336:0x0b98  */
        /* JADX WARN: Removed duplicated region for block: B:371:0x0c4f  */
        /* JADX WARN: Removed duplicated region for block: B:374:0x0c62  */
        /* JADX WARN: Removed duplicated region for block: B:377:0x0c73  */
        /* JADX WARN: Removed duplicated region for block: B:380:0x0c89  */
        /* JADX WARN: Removed duplicated region for block: B:382:0x0c92  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            uu4 uu4Var;
            uu4 uu4Var2;
            uu4 uu4Var3;
            PbFragment pbFragment;
            int i;
            boolean z;
            uu4 uu4Var4;
            uu4 uu4Var5;
            uu4 uu4Var6;
            uu4 uu4Var7;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            int i4;
            eu4 eu4Var;
            String jumpUrlWithTid;
            String[] strArr;
            jv7 S1;
            int i5;
            int i6;
            boolean K3;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.r0 && (view2 == this.a.E0.h.c || view2 == this.a.E0.h.d || view2.getId() == R.id.obfuscated_res_0x7f09185c || view2.getId() == R.id.obfuscated_res_0x7f090a0f || view2.getId() == R.id.obfuscated_res_0x7f091bfd || view2.getId() == R.id.obfuscated_res_0x7f0917fa)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.E0.X0() && this.a.getPageContext().getPageActivity() != null && this.a.w0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.m2(), this.a.w0.C2(), this.a.w0.B2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.w0.getForumId());
                        statisticItem2.param("fname", this.a.w0.r1());
                        statisticItem2.param("tid", this.a.w0.m2());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.E0.Z0()) {
                        if (this.a.h) {
                            return;
                        }
                        if (this.a.w0.N2(true)) {
                            this.a.h = true;
                            this.a.E0.v3();
                        }
                    } else if (view2 != this.a.E0.h.m()) {
                        if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().r()) {
                            if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().k()) {
                                if (view2 == this.a.E0.h.f) {
                                    if (this.a.E0.f0(this.a.w0.F1())) {
                                        this.a.D7();
                                        return;
                                    }
                                    this.a.i = false;
                                    ej.x(this.a.a, this.a.E0.h.f);
                                    this.a.a.finish();
                                } else if (view2 != this.a.E0.F0() && (this.a.E0.h.n() == null || (view2 != this.a.E0.h.n().s() && view2 != this.a.E0.h.n().t()))) {
                                    if (view2 == this.a.E0.N0()) {
                                        if (this.a.w0 != null) {
                                            yo4.o(this.a.getPageContext().getPageActivity(), this.a.w0.S1().O().getTopicData().b());
                                        }
                                    } else if (view2 != this.a.E0.h.c) {
                                        if (view2 == this.a.E0.h.d) {
                                            if (fh5.a()) {
                                                return;
                                            }
                                            if (this.a.w0 != null && this.a.w0.S1() != null) {
                                                ArrayList<PostData> F = this.a.w0.S1().F();
                                                if ((F == null || F.size() <= 0) && this.a.w0.k2()) {
                                                    ej.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.w0.m2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.w0.getForumId()));
                                                if (!this.a.E0.U1()) {
                                                    this.a.E0.Q2();
                                                }
                                                this.a.I6();
                                            } else {
                                                ej.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09181d) {
                                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.E0.e3(true);
                                                this.a.E0.Q2();
                                                if (this.a.h) {
                                                    return;
                                                }
                                                this.a.h = true;
                                                this.a.E0.Z3();
                                                this.a.D7();
                                                this.a.E0.u3();
                                                this.a.w0.J3(this.a.x5());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                                return;
                                            }
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0917f5) {
                                            if ((this.a.E0.h.n() == null || view2 != this.a.E0.h.n().p()) && view2.getId() != R.id.obfuscated_res_0x7f090a0f && view2.getId() != R.id.obfuscated_res_0x7f091bfd) {
                                                if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().l()) {
                                                    this.a.E0.h.k();
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e98) {
                                                    if (!this.a.a5(11009)) {
                                                        return;
                                                    }
                                                    this.a.e6(3);
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0917fa) {
                                                    if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().q()) {
                                                        if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().x()) {
                                                            if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().w()) {
                                                                if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().u()) {
                                                                    if (this.a.E0.R0() == view2) {
                                                                        if (this.a.E0.R0().getIndicateStatus()) {
                                                                            jv7 S12 = this.a.w0.S1();
                                                                            if (S12 != null && S12.O() != null && S12.O().getTaskInfoData() != null) {
                                                                                String d = S12.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d)) {
                                                                                    d = S12.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                                            }
                                                                        } else {
                                                                            pn8.d("c10725", null);
                                                                        }
                                                                        this.a.W5();
                                                                    } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().n()) {
                                                                        if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().j()) {
                                                                            if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().m()) {
                                                                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                                                                    SparseArray<Object> V0 = this.a.E0.V0(this.a.w0.S1(), this.a.w0.k2(), 1);
                                                                                    if (V0 != null) {
                                                                                        if (StringUtils.isNull((String) V0.get(R.id.obfuscated_res_0x7f09203e))) {
                                                                                            this.a.E0.t2(((Integer) V0.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) V0.get(R.id.obfuscated_res_0x7f09203f), ((Integer) V0.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) V0.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                                                                                        } else {
                                                                                            this.a.E0.u2(((Integer) V0.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) V0.get(R.id.obfuscated_res_0x7f09203f), ((Integer) V0.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) V0.get(R.id.obfuscated_res_0x7f092040)).booleanValue(), (String) V0.get(R.id.obfuscated_res_0x7f09203e));
                                                                                        }
                                                                                    }
                                                                                    this.a.E0.h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                                                                    return;
                                                                                }
                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091f9f && view2.getId() != R.id.obfuscated_res_0x7f091f9d && view2.getId() != R.id.obfuscated_res_0x7f09180d && view2.getId() != R.id.obfuscated_res_0x7f09169e) {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f09186f) {
                                                                                    if (this.a.w0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.w0.m2());
                                                                                    statisticItem3.param("fid", this.a.w0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09186f && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.R = view2;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f09205a);
                                                                                        StatisticItem statisticItem4 = postData.d0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.w0 == null || this.a.w0.S1() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String m2 = this.a.w0.m2();
                                                                                        String L = postData.L();
                                                                                        int W = this.a.w0.S1() != null ? this.a.w0.S1().W() : 0;
                                                                                        AbsPbActivity.e M6 = this.a.M6(L);
                                                                                        if (M6 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, L, "pb", true, false, null, false, null, W, postData.c0(), this.a.w0.S1().d(), false, postData.s().getIconInfo(), 5).addBigImageData(M6.a, M6.b, M6.g, M6.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.w0.R1());
                                                                                        addBigImageData.setFromFrsForumId(this.a.w0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.w0.r2());
                                                                                        addBigImageData.setKeyFromForumId(this.a.w0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.w0.I(), this.a.w0.E(), this.a.w0.F(), this.a.w0.D(), this.a.w0.J());
                                                                                        addBigImageData.setBjhData(this.a.w0.k1());
                                                                                        if (this.a.w0.S1().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.w0.S1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.w0.S1().V() != null) {
                                                                                            addBigImageData.setIsManager(this.a.w0.S1().V().getIs_manager());
                                                                                        }
                                                                                        if (this.a.w0.S1().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.w0.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.w0.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.w0.S1().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.w0.S1().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.w0.S1().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.E0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.E0.L0(this.a.w0.G, this.a.w0.k2()).R || postData.R);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f09186d || view2.getId() == R.id.obfuscated_res_0x7f091a43 || view2.getId() == R.id.obfuscated_res_0x7f091807) {
                                                                                    if (this.a.w0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09186d) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.w0.m2());
                                                                                        statisticItem5.param("fid", this.a.w0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a43) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.S = view2;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09186d && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.S = view2;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f09205a);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09186d && (statisticItem = postData2.d0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a43 || view2.getId() == R.id.obfuscated_res_0x7f091807) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.w0.n2()).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.L()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.w0 == null || this.a.w0.S1() == null || this.a.P5().d1() == null || postData2.s() == null || postData2.C() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.P5().e1() != null) {
                                                                                        this.a.P5().e1().c();
                                                                                    }
                                                                                    if (this.a.i0 && postData2.Z() != null && postData2.Z().size() != 0) {
                                                                                        this.a.C7(postData2, true);
                                                                                    } else {
                                                                                        zv7 zv7Var = new zv7();
                                                                                        zv7Var.A(this.a.w0.S1().l());
                                                                                        zv7Var.E(this.a.w0.S1().O());
                                                                                        zv7Var.C(postData2);
                                                                                        this.a.P5().d1().V(zv7Var);
                                                                                        this.a.P5().d1().setPostId(postData2.L());
                                                                                        this.a.w6(view2, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.T0 != null) {
                                                                                            this.a.E0.Y2(this.a.T0.y());
                                                                                        }
                                                                                    }
                                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f09180b) {
                                                                                    if (view2 != this.a.E0.P0()) {
                                                                                        if (view2 == this.a.E0.h.o()) {
                                                                                            this.a.E0.D3();
                                                                                        } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().v()) {
                                                                                            if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().o()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.w0.m2())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.E0.h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f090786 && view2.getId() != R.id.obfuscated_res_0x7f090a0c) {
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f09188d) {
                                                                                                    if (!this.a.checkUpIsLogin() || (eu4Var = (eu4) view2.getTag()) == null || StringUtils.isNull(eu4Var.j1())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{eu4Var.j1()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091c00 || id == R.id.obfuscated_res_0x7f09071b || id == R.id.obfuscated_res_0x7f091c01 || id == R.id.obfuscated_res_0x7f09071c) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view2 != null && view2.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f09205a);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091c01 || id == R.id.obfuscated_res_0x7f09071c) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.w0.b));
                                                                                                        }
                                                                                                        if (this.a.K0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.K0 = new yu4(pbFragment2.getContext());
                                                                                                            this.a.K0.n(this.a.f2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.m6(view2);
                                                                                                        if (this.a.m6(view2) && this.a.j1 != null) {
                                                                                                            this.a.j1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f092056) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092056)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092040)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f092085) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092085)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f092083) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092083)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f09204d) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f09204d) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092055)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.W() != null && postData3.W().toString().length() > 0) {
                                                                                                                uu4 uu4Var8 = new uu4(3, this.a.getString(R.string.obfuscated_res_0x7f0f0452), this.a.K0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f09203d, postData3);
                                                                                                                uu4Var8.d.setTag(sparseArray5);
                                                                                                                arrayList.add(uu4Var8);
                                                                                                            }
                                                                                                            this.a.B2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.w0.S1().r()) {
                                                                                                            String u = this.a.w0.S1().u();
                                                                                                            if (postData3 != null && !dj.isEmpty(u) && u.equals(postData3.L())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    uu4Var4 = new uu4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0ff2), this.a.K0);
                                                                                                                } else {
                                                                                                                    uu4Var4 = new uu4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0aaa), this.a.K0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f09203d, this.a.B2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
                                                                                                                uu4Var4.d.setTag(sparseArray6);
                                                                                                                arrayList.add(uu4Var4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (g18.i(this.a.w0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.q6(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            uu4 uu4Var9 = new uu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1017), this.a.K0);
                                                                                                                            uu4Var9.d.setTag(str);
                                                                                                                            arrayList.add(uu4Var9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        uu4 uu4Var10 = new uu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b4d), this.a.K0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092054, sparseArray4.get(R.id.obfuscated_res_0x7f092054));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092095, sparseArray4.get(R.id.obfuscated_res_0x7f092095));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092096, sparseArray4.get(R.id.obfuscated_res_0x7f092096));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092094, sparseArray4.get(R.id.obfuscated_res_0x7f092094));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092097, sparseArray4.get(R.id.obfuscated_res_0x7f092097));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092098, sparseArray4.get(R.id.obfuscated_res_0x7f092098));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092040, sparseArray4.get(R.id.obfuscated_res_0x7f092040));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f09203f, sparseArray4.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f09205d, sparseArray4.get(R.id.obfuscated_res_0x7f09205d));
                                                                                                                        uu4Var4.d.setTag(sparseArray7);
                                                                                                                        arrayList.add(uu4Var10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f09205d, sparseArray4.get(R.id.obfuscated_res_0x7f09205d));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f09204a, sparseArray4.get(R.id.obfuscated_res_0x7f09204a));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f09204b, sparseArray4.get(R.id.obfuscated_res_0x7f09204b));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f09204c, sparseArray4.get(R.id.obfuscated_res_0x7f09204c));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f09204d, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092054, sparseArray4.get(R.id.obfuscated_res_0x7f092054));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092095, sparseArray4.get(R.id.obfuscated_res_0x7f092095));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092096, sparseArray4.get(R.id.obfuscated_res_0x7f092096));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092094, sparseArray4.get(R.id.obfuscated_res_0x7f092094));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092097, sparseArray4.get(R.id.obfuscated_res_0x7f092097));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092098, sparseArray4.get(R.id.obfuscated_res_0x7f092098));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f09203f, sparseArray4.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092051, sparseArray4.get(R.id.obfuscated_res_0x7f092051));
                                                                                                                            if (booleanValue6) {
                                                                                                                                uu4 uu4Var11 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.a.K0);
                                                                                                                                uu4Var11.d.setTag(sparseArray8);
                                                                                                                                uu4Var6 = uu4Var11;
                                                                                                                                uu4Var5 = new uu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.K0);
                                                                                                                                uu4Var5.d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        uu4Var6 = null;
                                                                                                                        uu4Var5 = new uu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.K0);
                                                                                                                        uu4Var5.d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09205d, sparseArray4.get(R.id.obfuscated_res_0x7f09205d));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09203f, sparseArray4.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092051, sparseArray4.get(R.id.obfuscated_res_0x7f092051));
                                                                                                                        if (this.a.w0.S1().W() == 1002 && !booleanValue) {
                                                                                                                            uu4Var7 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1017), this.a.K0);
                                                                                                                        } else {
                                                                                                                            uu4Var7 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.a.K0);
                                                                                                                        }
                                                                                                                        uu4Var7.d.setTag(sparseArray9);
                                                                                                                        uu4Var6 = uu4Var7;
                                                                                                                        uu4Var5 = null;
                                                                                                                    } else {
                                                                                                                        uu4Var5 = null;
                                                                                                                        uu4Var6 = null;
                                                                                                                    }
                                                                                                                    if (uu4Var6 != null) {
                                                                                                                        arrayList.add(uu4Var6);
                                                                                                                    }
                                                                                                                    if (uu4Var5 != null) {
                                                                                                                        arrayList.add(uu4Var5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.a.K0.j(arrayList);
                                                                                                                this.a.J0 = new wu4(this.a.getPageContext(), this.a.K0);
                                                                                                                this.a.J0.k();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f09203d, this.a.B2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
                                                                                                        uu4Var4.d.setTag(sparseArray62);
                                                                                                        arrayList.add(uu4Var4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.K0.j(arrayList);
                                                                                                        this.a.J0 = new wu4(this.a.getPageContext(), this.a.K0);
                                                                                                        this.a.J0.k();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917d8) {
                                                                                                    if (this.a.w0.S1() != null && this.a.w0.S1().O() != null && this.a.w0.S1().O().getActUrl() != null) {
                                                                                                        yo4.o(this.a.getActivity(), this.a.w0.S1().O().getActUrl());
                                                                                                        if (this.a.w0.S1().O().getActInfoType() != 1) {
                                                                                                            if (this.a.w0.S1().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091452) {
                                                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f09206c) instanceof String) {
                                                                                                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f09206c);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.w0.S1().m()).param("tid", this.a.w0.S1().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.w0.S1().Q().equals(str2)) {
                                                                                                            this.a.E0.y3(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091837 || id == R.id.obfuscated_res_0x7f091802) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f138a);
                                                                                                        String q = ox4.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            yo4.s(view2.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.E0.Q2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09102f) {
                                                                                                    if (view2 != null) {
                                                                                                        yo4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.t5() == 1 && this.a.w0 != null && this.a.w0.S1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.w0.S1().m()).param("tid", this.a.w0.S1().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091445) {
                                                                                                    if (view2 != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        yo4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        if (this.a.t5() == 1 && this.a.w0 != null && this.a.w0.S1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.w0.S1().m()).param("tid", this.a.w0.S1().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0914a5) {
                                                                                                    this.a.v6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0914a4) {
                                                                                                    this.a.s6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0926ef) {
                                                                                                    if (this.a.w0 != null && this.a.w0.S1() != null && this.a.w0.S1().A() != null) {
                                                                                                        jv7 S13 = this.a.w0.S1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", S13.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S13.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0926ec) {
                                                                                                    if (this.a.w0 != null && this.a.w0.S1() != null && this.a.w0.S1().A() != null) {
                                                                                                        jv7 S14 = this.a.w0.S1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", S14.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S14.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0923de) {
                                                                                                    if (this.a.o1 >= 0) {
                                                                                                        if (this.a.w0 != null) {
                                                                                                            this.a.w0.m3();
                                                                                                        }
                                                                                                        if (this.a.w0 == null || this.a.E0.D0() == null) {
                                                                                                            i4 = 0;
                                                                                                        } else {
                                                                                                            i4 = 0;
                                                                                                            this.a.E0.D0().i0(this.a.w0.S1(), false);
                                                                                                        }
                                                                                                        this.a.o1 = i4;
                                                                                                        if (this.a.w0 != null) {
                                                                                                            this.a.E0.U0().setSelection(this.a.w0.L1());
                                                                                                            this.a.w0.q3(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091b25) {
                                                                                                    if (!this.a.a5(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.e6(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09169e) {
                                                                                                    SparseArray sparseArray10 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.B7(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917f7) {
                                                                                                    if (this.a.E0.U0() == null || this.a.w0 == null || this.a.w0.S1() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.E0.U0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.E0.U0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean u0 = this.a.w0.S1().u0();
                                                                                                    boolean z3 = this.a.E0.f1() != null && this.a.E0.f1().g();
                                                                                                    boolean S15 = this.a.E0.S1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!u0 || this.a.E0.f1() == null || this.a.E0.f1().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (ej.k(this.a.getContext()) * 0.5625d)) - this.a.E0.f1().e();
                                                                                                        if (firstVisiblePosition == 0) {
                                                                                                            if (top != k) {
                                                                                                                i3 = k;
                                                                                                            } else {
                                                                                                                i3 = k;
                                                                                                            }
                                                                                                            z4 = true;
                                                                                                            i2 = i3;
                                                                                                        } else {
                                                                                                            i3 = k;
                                                                                                        }
                                                                                                        z4 = false;
                                                                                                        i2 = i3;
                                                                                                    }
                                                                                                    int i9 = i2;
                                                                                                    this.a.o5(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.a.w0.S1().O() != null && this.a.w0.S1().O().getReply_num() <= 0) || (S15 && z4)) {
                                                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.L6();
                                                                                                        if (this.a.w0.S1().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", this.a.w0.S1().m()).param("obj_locate", 2).param("uid", this.a.w0.S1().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i10 = (int) (ej.i(this.a.getContext()) * 0.6d);
                                                                                                        if (u0) {
                                                                                                            if (this.a.E0.d1 != null && this.a.E0.d1.c != null && this.a.E0.d1.c.getView() != null) {
                                                                                                                if (this.a.E0.d1.c.getView().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.a.E0.c1() != null) {
                                                                                                                z2 = this.a.E0.c1().getVisibility() == 0;
                                                                                                                if (!z2 && this.a.E0.d1 != null && this.a.E0.d1.c != null && this.a.E0.d1.c.getView() != null && this.a.E0.d1.c.getView().getParent() != null && this.a.E0.h != null && this.a.E0.h.a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || S15) {
                                                                                                            this.a.Z = firstVisiblePosition;
                                                                                                            this.a.a0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i10))) {
                                                                                                                this.a.E0.U0().setSelectionFromTop(0, i9 - i10);
                                                                                                                this.a.E0.U0().smoothScrollBy(-i10, 500);
                                                                                                            } else {
                                                                                                                this.a.E0.U0().E(0, i9, 500);
                                                                                                            }
                                                                                                        } else if (this.a.Z > 0) {
                                                                                                            if (this.a.E0.U0().getChildAt(this.a.Z) != null) {
                                                                                                                this.a.E0.U0().E(this.a.Z, this.a.a0, 200);
                                                                                                            } else {
                                                                                                                this.a.E0.U0().setSelectionFromTop(this.a.Z, this.a.a0 + i10);
                                                                                                                this.a.E0.U0().smoothScrollBy(i10, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int d2 = i08.d(this.a.getListView());
                                                                                                            if (i08.e(this.a.getListView()) != -1) {
                                                                                                                d2--;
                                                                                                            }
                                                                                                            int f = ej.f(this.a.getContext(), R.dimen.tbds100);
                                                                                                            if (d2 < 0) {
                                                                                                                d2 = (ListUtils.getCount(this.a.E0.U0().getData()) - 1) + this.a.E0.U0().getHeaderViewsCount();
                                                                                                                f = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!u0 || this.a.E0.f1() == null) {
                                                                                                                    if (this.a.E0.h != null && this.a.E0.h.a != null) {
                                                                                                                        fixedNavHeight = this.a.E0.h.a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.a.E0.d1 != null || this.a.E0.d1.c == null || this.a.E0.d1.c.getView() == null || this.a.E0.d1.c.getView().getParent() == null) {
                                                                                                                        this.a.E0.U0().setSelectionFromTop(d2, f + i10);
                                                                                                                        this.a.E0.U0().smoothScrollBy(i10, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.a.E0.U0().E(d2, f, 200);
                                                                                                                    } else {
                                                                                                                        this.a.E0.U0().smoothScrollBy(this.a.E0.d1.c.getView().getTop() - ((int) (ej.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.E0.f1().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (ej.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f += fixedNavHeight;
                                                                                                            if (this.a.E0.d1 != null) {
                                                                                                            }
                                                                                                            this.a.E0.U0().setSelectionFromTop(d2, f + i10);
                                                                                                            this.a.E0.U0().smoothScrollBy(i10, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.w0.S1().O() != null && this.a.w0.S1().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", this.a.w0.S1().m()).param("obj_locate", 2).param("uid", this.a.w0.S1().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09185b || id == R.id.obfuscated_res_0x7f09185c) {
                                                                                                    if (this.a.w0 == null || this.a.w0.S1() == null || this.a.w0.S1().l() == null || dj.isEmpty(this.a.w0.S1().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.w0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.w0.r1()) || this.a.w0.h1() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.w0.h1().b;
                                                                                                    } else {
                                                                                                        name = this.a.w0.S1().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String r1 = this.a.w0.r1();
                                                                                                    if (this.a.w0.x1() && r1 != null && r1.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.w0.S1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.w0.m2());
                                                                                                    statisticItem6.param("fid", this.a.w0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.w0.S1().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.w0.S1().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a8f && id != R.id.obfuscated_res_0x7f090a68 && id != R.id.obfuscated_res_0x7f090a6a && id != R.id.obfuscated_res_0x7f090a69) {
                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.w0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.w0.m2());
                                                                                                        statisticItem7.param("fid", this.a.w0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091882) {
                                                                                                        if (this.a.w0 == null || this.a.w0.S1() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        jv7 S16 = this.a.w0.S1();
                                                                                                        if (this.a.B0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.B0 = new bw7(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g = dh.g(S16.Q(), 0L);
                                                                                                        long g2 = dh.g(S16.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.m2);
                                                                                                        this.a.B0.a(g, g2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0918a6) {
                                                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                                                            if (!mr5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                yo4.o(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.w0.m2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e49) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e46) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                                                        if (this.a.P != null) {
                                                                                                            this.a.P.Q(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f09180f || id == R.id.obfuscated_res_0x7f091867) {
                                                                                                        if (this.a.r0) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.w0.m2());
                                                                                                        statisticItem8.param("fid", this.a.w0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        SparseArray sparseArray11 = (SparseArray) view2.getTag();
                                                                                                        if (sparseArray11 != null && (sparseArray11.get(R.id.obfuscated_res_0x7f092057) instanceof Boolean) && ((Boolean) sparseArray11.get(R.id.obfuscated_res_0x7f092057)).booleanValue()) {
                                                                                                            j28.o(6);
                                                                                                        }
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.b = false;
                                                                                                        pbFragment5.g5(view2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0923fc) {
                                                                                                        if (view2.getTag(R.id.obfuscated_res_0x7f092057) instanceof Boolean) {
                                                                                                            j28.o(5);
                                                                                                        }
                                                                                                        this.a.a7(false);
                                                                                                        this.a.C7((PostData) view2.getTag(R.id.obfuscated_res_0x7f09206d), false);
                                                                                                    }
                                                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                                                    if (this.a.w0.R1() == 3 && this.a.u0() && this.a.w0.S1() != null && ListUtils.isEmpty(this.a.w0.S1().p())) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData3.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                                    }
                                                                                                    StatisticItem statisticItem9 = new StatisticItem("c13399");
                                                                                                    statisticItem9.param("tid", threadData3.getId());
                                                                                                    statisticItem9.param("fid", threadData3.getFid());
                                                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    statisticItem9.param("nid", threadData3.getNid());
                                                                                                    TiebaStatic.log(statisticItem9);
                                                                                                }
                                                                                            } else {
                                                                                                SparseArray sparseArray12 = (SparseArray) view2.getTag();
                                                                                                if (sparseArray12 == null || !(sparseArray12.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData)) {
                                                                                                    return;
                                                                                                }
                                                                                                PostData postData4 = (PostData) sparseArray12.get(R.id.obfuscated_res_0x7f09205a);
                                                                                                View view3 = (View) sparseArray12.get(R.id.obfuscated_res_0x7f09205c);
                                                                                                if (postData4 == null || view3 == null) {
                                                                                                    return;
                                                                                                }
                                                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090787);
                                                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090788);
                                                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a0c);
                                                                                                if (postData4.q0()) {
                                                                                                    postData4.Q0(false);
                                                                                                    h18.e(postData4);
                                                                                                } else if (this.a.K() != null ? h18.c(this.a.K().S1(), postData4) : false) {
                                                                                                    postData4.Q0(true);
                                                                                                }
                                                                                                SkinManager.setBackgroundColor(findViewById, postData4.q0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                                                SkinManager.setViewTextColor(eMTextView, postData4.q0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                                                WebPManager.setPureDrawable(imageView, postData4.q0() ? R.drawable.obfuscated_res_0x7f080984 : R.drawable.obfuscated_res_0x7f080983, postData4.q0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                                            }
                                                                                        } else {
                                                                                            this.a.E0.h.l();
                                                                                            this.a.E0.W3(this.a.E2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, dh.g(this.a.w0.S1().m(), 0L), dh.g(this.a.w0.m2(), 0L), dh.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.w0.S1().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    } catch (ClassCastException e) {
                                                                                        e.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData5 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d);
                                                                                    if (postData5 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.K0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.K0 = new yu4(pbFragment6.getContext());
                                                                                        this.a.K0.n(this.a.f2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.K().S1() != null && this.a.K().S1().i0();
                                                                                    if (view2 != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f092085) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092085)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f092083) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092083)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f09204d) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204d) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092055)).booleanValue() : false;
                                                                                        if (postData5.q() != null) {
                                                                                            boolean z6 = postData5.q().hasAgree;
                                                                                            int r = postData5.r();
                                                                                            if (z6 && r == 5) {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0085;
                                                                                            } else {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0087;
                                                                                            }
                                                                                            uu4 uu4Var12 = new uu4(8, pbFragment.getString(i), this.a.K0);
                                                                                            SparseArray sparseArray13 = new SparseArray();
                                                                                            sparseArray13.put(R.id.obfuscated_res_0x7f09203d, postData5);
                                                                                            uu4Var12.d.setTag(sparseArray13);
                                                                                            arrayList2.add(uu4Var12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (g18.i(this.a.w0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.q6(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    uu4 uu4Var13 = new uu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1017), this.a.K0);
                                                                                                    uu4Var13.d.setTag(str3);
                                                                                                    arrayList2.add(uu4Var13);
                                                                                                }
                                                                                            } else {
                                                                                                uu4 uu4Var14 = new uu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b4d), this.a.K0);
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                                                                                                uu4Var14.d.setTag(sparseArray14);
                                                                                                arrayList2.add(uu4Var14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray15 = new SparseArray();
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f09204d, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                                                                                                } else {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                                                                                                    if (booleanValue12) {
                                                                                                        uu4 uu4Var15 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.a.K0);
                                                                                                        uu4Var15.d.setTag(sparseArray15);
                                                                                                        uu4Var2 = uu4Var15;
                                                                                                        uu4Var = new uu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.K0);
                                                                                                        uu4Var.d.setTag(sparseArray15);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                                                                                                }
                                                                                                uu4Var2 = null;
                                                                                                uu4Var = new uu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.a.K0);
                                                                                                uu4Var.d.setTag(sparseArray15);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray16 = new SparseArray();
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                                                                                                if (this.a.w0.S1().W() == 1002 && !booleanValue7) {
                                                                                                    uu4Var3 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1017), this.a.K0);
                                                                                                } else {
                                                                                                    uu4Var3 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.a.K0);
                                                                                                }
                                                                                                uu4Var3.d.setTag(sparseArray16);
                                                                                                uu4Var2 = uu4Var3;
                                                                                                uu4Var = null;
                                                                                            } else {
                                                                                                uu4Var = null;
                                                                                                uu4Var2 = null;
                                                                                            }
                                                                                            if (uu4Var2 != null) {
                                                                                                arrayList2.add(uu4Var2);
                                                                                            }
                                                                                            if (uu4Var != null) {
                                                                                                arrayList2.add(uu4Var);
                                                                                            }
                                                                                        }
                                                                                        this.a.K0.j(arrayList2);
                                                                                        this.a.J0 = new wu4(this.a.getPageContext(), this.a.K0);
                                                                                        this.a.J0.k();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f09169e) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.w0.m2());
                                                                                    statisticItem10.param("fid", this.a.w0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f09180d && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.R = view2;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.w0 == null || this.a.w0.S1() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.E0.p0();
                                                                                    SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                                                    PostData postData6 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f09205a);
                                                                                    PostData postData7 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f09205b);
                                                                                    View view4 = (View) sparseArray17.get(R.id.obfuscated_res_0x7f09205c);
                                                                                    if (postData6 == null || view4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData6.G() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData6.d0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09169e) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09180d) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String m22 = this.a.w0.m2();
                                                                                    String L2 = postData6.L();
                                                                                    String L3 = postData7 != null ? postData7.L() : "";
                                                                                    int W2 = this.a.w0.S1() != null ? this.a.w0.S1().W() : 0;
                                                                                    this.a.D7();
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091c00) {
                                                                                        AbsPbActivity.e M62 = this.a.M6(L2);
                                                                                        if (this.a.w0 == null || this.a.w0.S1() == null || M62 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, L2, "pb", true, false, null, true, null, W2, postData6.c0(), this.a.w0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(M62.a, M62.b, M62.g, M62.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.w0.R1());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.w0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.w0.r2());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.w0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.w0.k1());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.w0.I(), this.a.w0.E(), this.a.w0.F(), this.a.w0.D(), this.a.w0.J());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e M63 = this.a.M6(L2);
                                                                                        if (postData6 == null || this.a.w0 == null || this.a.w0.S1() == null || M63 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m22, L2, "pb", true, false, null, false, L3, W2, postData6.c0(), this.a.w0.S1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(M63.a, M63.b, M63.g, M63.j);
                                                                                        if (!dj.isEmpty(L3)) {
                                                                                            addBigImageData3.setHighLightPostId(L3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.w0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.w0.I(), this.a.w0.E(), this.a.w0.F(), this.a.w0.D(), this.a.w0.J());
                                                                                        addBigImageData3.setBjhData(this.a.w0.k1());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.w0.R1());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.w0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.w0.r2());
                                                                                        if (this.a.E0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.E0.L0(this.a.w0.G, this.a.w0.k2()).R || postData6.R);
                                                                                        }
                                                                                        if (this.a.w0.S1() != null && this.a.w0.S1().o() != null) {
                                                                                            addBigImageData3.setHasForumRule(this.a.w0.S1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.w0.S1().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                                                                            SparseArray<Object> V02 = this.a.E0.V0(this.a.w0.S1(), this.a.w0.k2(), 1);
                                                                            if (V02 != null) {
                                                                                this.a.E0.w2(((Integer) V02.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) V02.get(R.id.obfuscated_res_0x7f09203f), ((Integer) V02.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) V02.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                                                                            }
                                                                            this.a.E0.h.k();
                                                                            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().O() != null) {
                                                                                ThreadData O = this.a.K().S1().O();
                                                                                StatisticItem statisticItem12 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                                                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem12.param("tid", O.getId());
                                                                                statisticItem12.param("fid", O.getFid());
                                                                                statisticItem12.param("fname", O.getForum_name());
                                                                                TiebaStatic.log(statisticItem12);
                                                                                StatisticItem statisticItem13 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem13.param("tid", O.getId());
                                                                                statisticItem13.param("fid", O.getFid());
                                                                                statisticItem13.param("fname", O.getForum_name());
                                                                                statisticItem13.param("obj_source", 3);
                                                                                TiebaStatic.log(statisticItem13);
                                                                            }
                                                                        } else {
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                                                            return;
                                                                        }
                                                                    } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                                                                        this.a.E0.p0();
                                                                        SparseArray<Object> V03 = this.a.E0.V0(this.a.w0.S1(), this.a.w0.k2(), 1);
                                                                        if (V03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.S1().l().getId(), this.a.w0.S1().l().getName(), this.a.w0.S1().O().getId(), String.valueOf(this.a.w0.S1().V().getUserId()), (String) V03.get(R.id.obfuscated_res_0x7f09204a), (String) V03.get(R.id.obfuscated_res_0x7f09204b), (String) V03.get(R.id.obfuscated_res_0x7f09204d), (String) V03.get(R.id.obfuscated_res_0x7f09204c))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                                                        return;
                                                                    }
                                                                } else {
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
                                                                }
                                                            } else if (this.a.w0 == null || this.a.w0.S1() == null || this.a.w0.S1().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.E0.h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.Z5(pbFragment7.w0.S1().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.E0.p0();
                                                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                                                if (this.a.h) {
                                                                    view2.setTag(Integer.valueOf(this.a.w0.i2()));
                                                                    return;
                                                                }
                                                                this.a.D7();
                                                                this.a.E0.u3();
                                                                wu4 wu4Var = new wu4(this.a.getPageContext());
                                                                if (this.a.w0.S1().f == null || this.a.w0.S1().f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11d2), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11d3)};
                                                                } else {
                                                                    strArr = new String[this.a.w0.S1().f.size()];
                                                                    for (int i11 = 0; i11 < this.a.w0.S1().f.size(); i11++) {
                                                                        strArr[i11] = this.a.w0.S1().f.get(i11).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11d0);
                                                                    }
                                                                }
                                                                wu4Var.i(null, strArr, new a(this, wu4Var, view2));
                                                                wu4Var.k();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.E0.p0();
                                                        if (this.a.K().S1().g != 2) {
                                                            if (this.a.w0.Q1() != null) {
                                                                this.a.E0.d4(this.a.w0.Q1(), this.a.e2);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0887);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (S1 = this.a.w0.S1()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = S1.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", S1.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.isBJHArticleThreadType()) {
                                                            i5 = 2;
                                                        } else if (O2.isBJHVideoThreadType()) {
                                                            i5 = 3;
                                                        } else if (O2.isBJHNormalThreadType()) {
                                                            i5 = 4;
                                                        } else if (O2.isBJHVideoDynamicThreadType()) {
                                                            i5 = 5;
                                                        }
                                                        StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem14.param("tid", this.a.w0.m2());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.w0.getForumId());
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091e98) {
                                                            statisticItem14.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem14.param("obj_locate", 6);
                                                        }
                                                        statisticItem14.param("obj_name", i5);
                                                        statisticItem14.param("obj_type", 1);
                                                        if (O2 != null) {
                                                            if (O2.isBJHArticleThreadType()) {
                                                                statisticItem14.param("obj_type", 10);
                                                            } else if (O2.isBJHVideoThreadType()) {
                                                                statisticItem14.param("obj_type", 9);
                                                            } else if (O2.isBJHVideoDynamicThreadType()) {
                                                                statisticItem14.param("obj_type", 8);
                                                            } else if (O2.isBJHNormalThreadType()) {
                                                                statisticItem14.param("obj_type", 7);
                                                            } else if (O2.isShareThread) {
                                                                statisticItem14.param("obj_type", 6);
                                                            } else {
                                                                int i12 = O2.threadType;
                                                                if (i12 == 0) {
                                                                    statisticItem14.param("obj_type", 1);
                                                                } else if (i12 == 40) {
                                                                    statisticItem14.param("obj_type", 2);
                                                                } else if (i12 == 49) {
                                                                    statisticItem14.param("obj_type", 3);
                                                                } else if (i12 == 54) {
                                                                    statisticItem14.param("obj_type", 4);
                                                                } else {
                                                                    statisticItem14.param("obj_type", 5);
                                                                }
                                                            }
                                                            statisticItem14.param("card_type", O2.getRecomCardType());
                                                            statisticItem14.param("recom_source", O2.mRecomSource);
                                                            statisticItem14.param("ab_tag", O2.mRecomAbTag);
                                                            statisticItem14.param("weight", O2.mRecomWeight);
                                                            statisticItem14.param("extra", O2.mRecomExtra);
                                                            statisticItem14.param("nid", O2.getNid());
                                                            if (O2.getBaijiahaoData() != null && !dj.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.P() != null) {
                                                            tc5.e(this.a.P(), statisticItem14);
                                                        }
                                                        if (this.a.E0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.E0.Q0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (ej.D()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                                                            return;
                                                        } else if (S1 != null) {
                                                            ArrayList<PostData> F2 = this.a.w0.S1().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.w0.k2()) {
                                                                this.a.E0.p0();
                                                                this.a.D7();
                                                                if (S1.A() != null && !StringUtils.isNull(S1.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.w0.S1().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.E0 != null) {
                                                                    this.a.E0.r0();
                                                                    this.a.E0.p4(S1);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.E0.P3();
                                                                    this.a.w0.m1().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0917fa) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view2.getId() == R.id.obfuscated_res_0x7f091e98 ? 1 : 6;
                                                                    }
                                                                    if ((!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) || !this.a.E0.W1() || S1.m0()) {
                                                                        this.a.x7(i6);
                                                                    } else if (UbsABTestHelper.isPbSharePathTestA()) {
                                                                        this.a.x7(i6);
                                                                    } else if (d35.c() > 0) {
                                                                        this.a.h7();
                                                                    } else {
                                                                        int Q0 = this.a.E0.Q0();
                                                                        this.a.E0.e0();
                                                                        this.a.d6(d35.a(), Q0);
                                                                    }
                                                                }
                                                            } else {
                                                                ej.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                                                                return;
                                                            }
                                                        } else {
                                                            ej.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.w0.m2());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.w0.getForumId());
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091e98) {
                                                    }
                                                    statisticItem142.param("obj_name", i5);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.P() != null) {
                                                    }
                                                    if (this.a.E0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (ej.D()) {
                                                    }
                                                }
                                            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.E0.p0();
                                                if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().p() && !this.a.E0.U1()) {
                                                    this.a.E0.Q2();
                                                }
                                                if (!this.a.h) {
                                                    this.a.D7();
                                                    this.a.E0.u3();
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f090a0f) {
                                                        K3 = this.a.w0.K3(true, this.a.x5());
                                                    } else {
                                                        K3 = view2.getId() == R.id.obfuscated_res_0x7f091bfd ? this.a.w0.K3(false, this.a.x5()) : this.a.w0.J3(this.a.x5());
                                                    }
                                                    view2.setTag(Boolean.valueOf(K3));
                                                    if (K3) {
                                                        i7 = 1;
                                                        this.a.E0.e3(true);
                                                        this.a.E0.Z3();
                                                        this.a.h = true;
                                                        this.a.E0.i3(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view2.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.E0.p0();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0917f5 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.a5(11009) || this.a.w0.i1(this.a.E0.T0()) == null) {
                                                    return;
                                                }
                                                this.a.A6();
                                                if (this.a.w0.S1() != null && this.a.w0.S1().O() != null && this.a.w0.S1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.b).param("fid", this.a.w0.S1().m()).param("obj_locate", 3).param("uid", this.a.w0.S1().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.w0.S1().O() != null && this.a.w0.S1().O().getAuthor() != null && this.a.w0.S1().O().getAuthor().getUserId() != null && this.a.y0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int T5 = pbFragment8.T5(pbFragment8.w0.S1());
                                                    ThreadData O3 = this.a.w0.S1().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i8 = 2;
                                                    } else if (O3.isBJHVideoThreadType()) {
                                                        i8 = 3;
                                                    } else if (O3.isBJHNormalThreadType()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w0.b).param("obj_locate", 1).param("obj_id", this.a.w0.S1().O().getAuthor().getUserId()).param("obj_type", !this.a.y0.e()).param("obj_source", T5).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.a.T = view2;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.w0.S1() != null && this.a.w0.S1().O() != null && this.a.w0.S1().O().isVideoThreadType() && this.a.w0.S1().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.w0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.w0.r1()) || this.a.w0.h1() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.w0.h1().b;
                                        } else {
                                            name2 = this.a.w0.S1().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String r12 = this.a.w0.r1();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.w0.x1() && r12 != null && r12.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    if (this.a.w0.S1() == null || this.a.z0.S()) {
                                        return;
                                    }
                                    this.a.E0.p0();
                                    int i13 = (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().t()) ? (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().s()) ? view2 == this.a.E0.F0() ? 2 : 0 : this.a.w0.S1().O().getIs_good() == 1 ? 3 : 6 : this.a.w0.S1().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.w0.S1().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.w0.S1().O().getId();
                                    this.a.E0.i4();
                                    this.a.z0.W(id2, name3, id3, i13, this.a.E0.G0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                    return;
                                }
                            } else {
                                this.a.E0.h.l();
                                if (this.a.w0 != null) {
                                    this.a.t1.f(this.a.w0.m2());
                                }
                                if (this.a.w0 == null || !this.a.w0.isPrivacy()) {
                                    this.a.t1.b();
                                    int i14 = (TbSingleton.getInstance().mCanCallFans || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().Q() == null || !this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.K() != null && this.a.K().S1() != null) {
                                        this.a.t1.d(3, i14, this.a.K().S1().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0f2d);
                                    if (this.a.K() == null || this.a.K().S1() == null) {
                                        return;
                                    }
                                    this.a.t1.d(3, 3, this.a.K().S1().Q());
                                    return;
                                }
                            }
                        } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.E0.p0();
                            this.a.D7();
                            this.a.E0.u3();
                            this.a.E0.P3();
                            if (this.a.E0.c1() != null) {
                                this.a.E0.c1().setVisibility(8);
                            }
                            this.a.w0.F3(1);
                            if (this.a.e != null) {
                                this.a.e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                            return;
                        }
                    } else {
                        String str4 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a8e);
                        String str5 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a79);
                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f092191);
                        if (this.a.P != null) {
                            this.a.P.Q(str4, str5);
                        }
                        TbPageTag l2 = tc5.l(this.a.getContext());
                        j18.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0deb).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091bf0) {
                        String w5 = this.a.w5();
                        if (TextUtils.isEmpty(w5)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{w5});
                    }
                } else if (!this.a.r0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.w0.m2());
                    statisticItem15.param("fid", this.a.w0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.obfuscated_res_0x7f092057) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.obfuscated_res_0x7f092057)).booleanValue()) {
                        j28.o(2);
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (this.a.v) {
                        this.a.v = false;
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f09203d);
                    if (!(obj instanceof PostData)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    PostData postData8 = (PostData) obj;
                    if (this.a.w0 != null && this.a.w0.S1() != null && this.a.P5().d1() != null && postData8.s() != null && postData8.C() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.P5().e1() != null) {
                            this.a.P5().e1().c();
                        }
                        zv7 zv7Var2 = new zv7();
                        zv7Var2.A(this.a.w0.S1().l());
                        zv7Var2.E(this.a.w0.S1().O());
                        zv7Var2.C(postData8);
                        this.a.P5().d1().V(zv7Var2);
                        this.a.P5().d1().setPostId(postData8.L());
                        this.a.w6(view2, postData8.s().getUserId(), "", postData8);
                        TiebaStatic.log("c11743");
                        j28.b(this.a.w0.S1(), postData8, postData8.c0, 8, 1);
                        if (this.a.T0 != null) {
                            this.a.E0.Y2(this.a.T0.y());
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ nu4 b;
        public final /* synthetic */ PbFragment c;

        public j2(PbFragment pbFragment, MarkData markData, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, nu4Var};
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
            this.b = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.E7();
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.w0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.T0 != null) {
                this.a.E0.Y2(this.a.T0.y());
            }
            this.a.E0.Q2();
            this.a.E0.p0();
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
                    this.a.T0.G(null, null);
                } else if (i != ReplyPrivacyCheckController.TYPE_FLOOR || this.a.E0 == null || this.a.E0.e1() == null || this.a.E0.e1().b() == null) {
                } else {
                    this.a.E0.e1().b().G();
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.w0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.w0.b)) {
                this.a.w7((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ nu4 b;
        public final /* synthetic */ PbFragment c;

        public k2(PbFragment pbFragment, MarkData markData, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, nu4Var};
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
            this.b = nu4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.E0 != null && this.c.E0.p1() != null) {
                    this.c.E0.p1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.E7();
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.w0.N3((UserPendantData) customResponsedMessage.getData());
                if (this.a.E0 != null && this.a.w0 != null) {
                    this.a.E0.J2(this.a.w0.S1(), this.a.w0.k2(), this.a.w0.c2(), this.a.E0.l1());
                }
                if (this.a.E0 == null || this.a.E0.D0() == null) {
                    return;
                }
                this.a.E0.D0().a0();
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.E0 == null || this.a == null) {
                    return;
                }
                this.b.a.E0.B2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w0.S1() != null) {
                        statisticItem.param("fid", this.a.w0.S1().m());
                    }
                    statisticItem.param("tid", this.a.w0.m2());
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
                this.a.D7();
                this.a.E0.s3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.C0 != null) {
                    this.a.C0.Q(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    gh.a().postDelayed(this.a.V1, 300000L);
                }
                boolean z2 = false;
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
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        nu4 nu4Var = new nu4(this.a.getActivity());
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            nu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                        } else {
                            nu4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
                        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new c(this));
                        nu4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (hu8.d(i) || y15Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.i7(i, antiData, str);
                        return;
                    }
                }
                this.a.w7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.j7(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.w0.v1()) {
                        jv7 S1 = this.a.w0.S1();
                        if (S1 != null && S1.O() != null && S1.O().getAuthor() != null && (userId = S1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.w0.I3()) {
                            this.a.E0.u3();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.w0.I3()) {
                        this.a.E0.u3();
                    }
                } else if (floor != null) {
                    this.a.E0.I1(this.a.w0.S1());
                }
                if (this.a.w0.z1()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.w0.m2()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.W4(z2);
                if (writeData != null) {
                    lz4.b(writeData.getContent(), "1");
                }
                if (this.a.j6()) {
                    this.a.G7();
                }
                this.a.u7();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements vg<ImageView> {
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

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (hq4.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = hq4.c().g();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.E0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.E0.Z3();
            } else {
                this.a.E0.x1();
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.S1().l().getId(), this.a.w0.S1().l().getName(), this.a.w0.S1().O().getId(), String.valueOf(this.a.w0.S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements h75 {
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

        @Override // com.baidu.tieba.h75
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements vg<GifView> {
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

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (hq4.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = hq4.c().g();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.T0 != null) {
                this.a.E0.Y2(this.a.T0.y());
            }
            this.a.E0.H3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements lu7.d {
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

        @Override // com.baidu.tieba.lu7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.E0 == null || this.a == null) {
                    return;
                }
                this.b.a.E0.B2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w0 != null && this.a.w0.S1() != null) {
                        statisticItem.param("fid", this.a.w0.S1().m());
                    }
                    if (this.a.w0 != null) {
                        statisticItem.param("tid", this.a.w0.m2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.E5()) {
                        this.a.a7(false);
                        nu7.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f122c));
                    }
                    qz7 qz7Var = this.a.I0;
                    if (qz7Var != null) {
                        qz7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        l35.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        lz4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.j6()) {
                        this.a.G7();
                    }
                    this.a.u7();
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.W0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nu4 nu4Var = new nu4(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        nu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                    } else {
                        nu4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
                    nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new c(this));
                    nu4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.I0 == null) {
                    return;
                }
                if (pbFragment.E0 != null && this.a.E0.e1() != null && this.a.E0.e1().b() != null && this.a.E0.e1().b().y()) {
                    this.a.E0.e1().b().w(postWriteCallBackData);
                }
                this.a.I0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements vg<TiebaPlusRecommendCard> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public TiebaPlusRecommendCard d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TiebaPlusRecommendCard(this.a.getPageContext().getPageActivity()) : (TiebaPlusRecommendCard) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            pu7 pu7Var = (pu7) customResponsedMessage.getData();
            int type = pu7Var.getType();
            if (type == 0) {
                this.a.R6((zv7) pu7Var.a());
            } else if (type == 1) {
                this.a.p5((ForumManageModel.b) pu7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (pu7Var.a() == null) {
                    this.a.Q6(false, null);
                } else {
                    this.a.Q6(true, (MarkData) pu7Var.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements lw7.a {
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

        @Override // com.baidu.tieba.lw7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091c1e) {
                            if (this.a.V6(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203d);
                            if (!(obj instanceof PostData)) {
                                return false;
                            }
                            PostData postData = (PostData) obj;
                            if (postData.getType() != PostData.O0 && !TextUtils.isEmpty(postData.t()) && hq4.c().g()) {
                                return this.a.D6(postData.L());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09180c) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f092050) instanceof SparseArray) {
                                this.a.B7((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f092050));
                            }
                        } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f091866) {
                            if (this.a.E0.P1() && view2.getId() == R.id.obfuscated_res_0x7f09182b) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f092092) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f092092)));
                                }
                                if (this.a.z0() != null && this.a.z0().b != null) {
                                    this.a.z0().b.onClick(view2);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.B7(sparseArray);
                        }
                    }
                    if (this.a.T0 != null) {
                        this.a.E0.Y2(this.a.T0.y());
                    }
                    this.a.E0.Q2();
                    this.a.E0.p0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.m5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o1 extends pb {
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView n1;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f13ea);
                    if (this.a.E0 == null || (n1 = this.a.E0.n1()) == null || this.a.E0.U0() == null) {
                        return;
                    }
                    this.a.E0.U0().removeHeaderView(n1);
                    return;
                }
                ej.N(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements vg<View> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).n();
                return view2;
            }
            return (View) invokeL.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.E0 == null || this.a.E0.D0() == null) {
                return;
            }
            this.a.E0.D0().a0();
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements pu4.c {
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

        @Override // com.baidu.tieba.pu4.c
        public void a(pu4 pu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pu4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.L0 = pbFragment.L0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new px7(this.a.w0.m2(), this.a.L0, "1").start();
                    pu4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.L0 = pbFragment2.L0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new px7(this.a.w0.m2(), this.a.L0, "2").start();
                    pu4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.L0 = pbFragment3.L0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.L0);
                    pu4Var.e();
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                gy4 gy4Var = new gy4();
                gy4Var.b = R.raw.obfuscated_res_0x7f110027;
                gy4Var.a = BreatheTipWidget.PointType.LOTTIE;
                gy4Var.c = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                hy4 hy4Var = new hy4();
                hy4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f0507);
                hy4Var.b = this.a.a.getString(R.string.obfuscated_res_0x7f0f00eb);
                hy4Var.e = R.drawable.pic_guidecard;
                hy4Var.f = ej.f(this.a.a.getContext(), R.dimen.tbds156);
                hy4Var.g = ej.f(this.a.a.getContext(), R.dimen.tbds489);
                hy4Var.h = ej.f(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.E0.j1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.E0.j1()));
                breatheTipWidget.f(hy4Var, gy4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    ox4 k = ox4.k();
                    k.u("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    h35.a("c14828");
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
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.a.m : j;
                if (this.a.n == 0) {
                    this.a.n = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                pd5 pd5Var = new pd5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j3);
                this.a.p = 0L;
                this.a.q = 0L;
                pd5Var.c();
                if (z2) {
                    j2 = j3;
                    pd5Var.B = j2;
                    pd5Var.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.w0 == null || this.a.w0.S1() == null || this.a.w0.S1().O() == null) {
                    return;
                }
                int threadType = this.a.w0.S1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.L, "from_personalize")) {
                        if (StringHelper.equals(this.a.L, "from_frs")) {
                            pd5 pd5Var2 = new pd5();
                            pd5Var2.a(1000);
                            pd5Var2.D = j2;
                            pd5Var2.d(threadType);
                            return;
                        }
                        return;
                    }
                    ld5 ld5Var = new ld5();
                    ld5Var.F = 1;
                    ld5Var.a(1005);
                    ld5Var.D = j2;
                    ld5Var.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv7Var) == null) {
                this.a.E0.I1(jv7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, jv7 jv7Var, String str, int i4) {
            o55 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jv7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906d3));
                }
                if (!z || jv7Var == null || jv7Var.X() != null || ListUtils.getCount(jv7Var.F()) >= 1) {
                    if (!this.a.f0) {
                        this.a.f0 = true;
                    } else if (this.a.K() != null) {
                        this.a.K().Z0();
                    }
                    this.a.g = true;
                    if (this.a.E0 == null) {
                        return;
                    }
                    this.a.E0.t3();
                    if (jv7Var == null || !jv7Var.p0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.E0.p1());
                    }
                    this.a.E0.x1();
                    if (this.a.I || this.a.E0.U1()) {
                        this.a.E0.r1();
                    } else if (!this.a.E0.N1()) {
                        this.a.E0.H3(false);
                    }
                    if (this.a.h) {
                        this.a.h = false;
                    }
                    if (i4 == 0 && jv7Var != null) {
                        this.a.M0 = true;
                    }
                    if (jv7Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.E0.p1());
                        this.a.E0.C3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String h1 = null;
                    arrayList = null;
                    if (z && jv7Var != null) {
                        ThreadData O = jv7Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.d7(pbFragment3.S0);
                        }
                        this.a.E0.e1().m(jv7Var);
                        this.a.E0.O3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.K7(O.getCartoonThreadData());
                        }
                        if (this.a.T0 != null) {
                            this.a.E0.Y2(this.a.T0.y());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(jv7Var.V().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(jv7Var.V().getDynamicUrl());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(jv7Var.V().getBimg_end_time());
                        if (jv7Var.F() != null && jv7Var.F().size() >= 1 && jv7Var.F().get(0) != null) {
                            this.a.w0.r3(jv7Var.F().get(0).L());
                        } else if (jv7Var.X() != null) {
                            this.a.w0.r3(jv7Var.X().L());
                        }
                        if (this.a.T0 != null) {
                            this.a.T0.H(jv7Var.d());
                            this.a.T0.I(jv7Var.l(), jv7Var.V());
                            this.a.T0.k0(O);
                            this.a.T0.J(this.a.w0.u1(), this.a.w0.m2(), this.a.w0.q1());
                            if (O != null) {
                                this.a.T0.Z(O.isMutiForumThread());
                            }
                        }
                        if (this.a.y0 != null) {
                            this.a.y0.h(jv7Var.r());
                        }
                        if (jv7Var.s() == 1) {
                            this.a.r = true;
                        } else {
                            this.a.r = false;
                        }
                        if (jv7Var.i0()) {
                            this.a.r = true;
                        }
                        this.a.E0.Z2(this.a.r);
                        if (this.a.t0.f.size() > 0) {
                            jv7Var.O0(this.a.t0.f);
                        }
                        this.a.E0.S3(jv7Var, i2, i3, this.a.w0.k2(), i4, this.a.w0.B1());
                        this.a.E0.g4(jv7Var, this.a.w0.k2());
                        this.a.E0.l4(this.a.w0.v1());
                        AntiData d = jv7Var.d();
                        if (d != null) {
                            this.a.y = d.getVoice_message();
                            if (!StringUtils.isNull(this.a.y) && this.a.T0 != null && this.a.T0.a() != null && (m = this.a.T0.a().m(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                                ((View) m).setOnClickListener(this.a.G1);
                            }
                        }
                        if (!this.a.W && !ListUtils.isEmpty(this.a.w0.S1().F()) && !this.a.w0.D2()) {
                            this.a.W = true;
                            this.a.Y4(false);
                        }
                        if (TextUtils.isEmpty(this.a.P0)) {
                            if (this.a.O0) {
                                this.a.O0 = false;
                                i08.g(this.a.getListView());
                            } else if (this.a.Q0) {
                                this.a.Q0 = false;
                                i08.j(this.a.getListView());
                            } else if (!TextUtils.isEmpty(this.a.w0.I1())) {
                                i08.f(this.a.getListView(), this.a.w0.I1());
                                this.a.w0.L2();
                            } else {
                                this.a.E0.N3();
                            }
                        } else {
                            i08.i(this.a.w0.R1(), this.a.getListView(), this.a.P0);
                            this.a.P0 = null;
                        }
                        this.a.w0.M2(jv7Var.l(), this.a.K1);
                        this.a.w0.S2(this.a.N1);
                        if (this.a.W0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.W0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.w0 == null || !this.a.w0.A2()) {
                            if (this.a.E0 != null) {
                                h1 = this.a.E0.h1();
                            }
                        } else {
                            h1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a);
                        }
                        if (!StringUtils.isNull(h1)) {
                            this.a.T0.c0(TbSingleton.getInstance().getAdVertiComment(jv7Var.n0(), jv7Var.o0(), h1));
                        }
                    } else if (str != null) {
                        if (this.a.M0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.w0.h1() != null && !StringUtils.isNull(this.a.w0.h1().c)) {
                                    this.a.E0.n4(this.a.w0.h1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.E0.p1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c58, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(ej.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.E0.p1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c58, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(ej.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                            }
                            this.a.E0.r1();
                            this.a.E0.q1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.w0.m2());
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
                            if (this.a.w0 != null && this.a.w0.S1() != null) {
                                arrayList = this.a.w0.S1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).C() != 1)) {
                                this.a.E0.U2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a02));
                            } else {
                                if (this.a.l6()) {
                                    this.a.E0.V2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dfb));
                                } else {
                                    this.a.E0.V2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dfc));
                                }
                                this.a.E0.I1(this.a.w0.S1());
                            }
                        } else {
                            this.a.E0.U2("");
                        }
                        this.a.E0.x0();
                    }
                    if (jv7Var != null && jv7Var.m && this.a.n == 0) {
                        this.a.n = System.currentTimeMillis() - this.a.m;
                    }
                    if (!this.a.K().k2() || this.a.K().S1().y().c() != 0 || this.a.K().x2()) {
                        this.a.U0 = true;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).B1(jv7Var != null ? jv7Var.g() : 0, this.a.E0);
                    }
                    e();
                    return;
                }
                this.a.w0.F3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.E0 != null) {
                    this.a.E0.a4();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.w0 == null) {
                return;
            }
            if (this.a.T0 == null || !this.a.T0.t) {
                i75 i75Var = new i75();
                this.a.d7(i75Var);
                PbFragment pbFragment = this.a;
                pbFragment.T0 = (j75) i75Var.a(pbFragment.getContext());
                this.a.T0.W(this.a.a.getPageContext());
                this.a.T0.f0(this.a.j2);
                this.a.T0.g0(this.a.Z0);
                this.a.T0.A(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.T0.a().C(true);
                this.a.E0.T2(this.a.T0.a());
                if (!this.a.w0.F1()) {
                    this.a.T0.q(this.a.w0.m2());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.T0.c0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.w0.A2()) {
                    this.a.T0.c0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a));
                } else if (this.a.E0 != null) {
                    this.a.T0.c0(this.a.E0.h1());
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ox4 k = ox4.k();
                if (k.h("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    return;
                }
                gh.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements vg<RelativeLayout> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof il5.a)) {
                il5.a aVar = (il5.a) customResponsedMessage.getData();
                il5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
                if (message.what == 2 && this.a.w0 != null && this.a.w0.D1()) {
                    this.a.y6();
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.J7();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements vg<ItemCardView> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ItemCardView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ItemCardView(this.a.getPageContext().getPageActivity()) : (ItemCardView) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f) {
                return;
            }
            this.a.A7();
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.E0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.E0.p1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.h(true);
                            bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0327));
                            bdTopToast.i((ViewGroup) this.a.getView());
                            this.a.e7(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c59) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.h(false);
                        bdTopToast2.g(string);
                        bdTopToast2.i((ViewGroup) this.a.getView());
                    }
                }
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            ux7 D0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.E0.h2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.w0.m2());
                    statisticItem.param("fid", this.a.w0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
                        boolean w = ((TbImageView) view2).w();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                        }
                        this.a.Q = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.K6(str, i, eVar);
                    if (this.a.w0.G.i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i3 = -1;
                        if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().D() == null) {
                            i2 = -1;
                        } else {
                            ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                            int i4 = 0;
                            int i5 = -1;
                            while (i4 < D.size()) {
                                if (D.get(i4) != null) {
                                    arrayList.add(D.get(i4).F());
                                    if (i5 == i3 && str != null && (str.equals(D.get(i4).F()) || str.equals(D.get(i4).B()) || str.equals(D.get(i4).z()) || str.equals(D.get(i4).A()) || str.equals(D.get(i4).D()))) {
                                        i5 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = D.get(i4).F();
                                    imageUrlData.originalUrl = D.get(i4).F();
                                    imageUrlData.isLongPic = D.get(i4).I();
                                    concurrentHashMap.put(D.get(i4).F(), imageUrlData);
                                }
                                i4++;
                                i3 = -1;
                            }
                            i2 = i5;
                        }
                        Rect rect = new Rect();
                        view2.getGlobalVisibleRect(rect);
                        this.a.r5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i2);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.w0.d2());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.l6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.w0 != null) {
                            builder.D(this.a.w0.getFromForumId());
                            if (this.a.w0.S1() != null) {
                                builder.Q(this.a.w0.S1().O());
                            }
                        }
                        ImageViewerConfig x = builder.x(this.a.getPageContext().getPageActivity());
                        x.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText M7 = this.a.M7(str, i);
                        if (M7 != null && this.a.y2 >= 0 && this.a.y2 < M7.B().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = kv7.a(M7.B().get(this.a.y2));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i6).equals(a)) {
                                    eVar.j = i6;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (M7.getPostId() != 0 && (D0 = this.a.E0.D0()) != null) {
                                ArrayList<Cdo> t = D0.t();
                                if (ListUtils.getCount(t) > 0) {
                                    Iterator<Cdo> it = t.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Cdo next = it.next();
                                        if ((next instanceof PostData) && M7.getPostId() == dh.g(((PostData) next).L(), 0L)) {
                                            j28.b(this.a.w0.S1(), (PostData) next, ((PostData) next).c0, M7.getPostId() == dh.g(this.a.w0.q1(), 0L) ? 1 : 8, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.b.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view2.getGlobalVisibleRect(rect2);
                            this.a.r5(rect2);
                            ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                            builder2.A(arrayList2);
                            builder2.C(eVar.c);
                            builder2.B(eVar.d);
                            builder2.R(eVar.e);
                            builder2.F(eVar.g);
                            builder2.K(true);
                            builder2.M(eVar.i);
                            builder2.I(this.a.w0.d2());
                            builder2.y(concurrentHashMap2);
                            builder2.N(false);
                            builder2.J(this.a.l6());
                            builder2.O(eVar.f);
                            builder2.z(eVar.f);
                            builder2.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.w0 != null) {
                                builder2.D(this.a.w0.getFromForumId());
                                if (this.a.w0.S1() != null) {
                                    builder2.Q(this.a.w0.S1().O());
                                }
                            }
                            ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                            x2.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                        builder3.A(arrayList3);
                        builder3.C(eVar.c);
                        builder3.B(eVar.d);
                        builder3.R(eVar.e);
                        builder3.F(eVar.g);
                        builder3.K(true);
                        builder3.M(eVar.a.get(0));
                        builder3.I(this.a.w0.d2());
                        builder3.y(concurrentHashMap3);
                        builder3.N(false);
                        builder3.J(this.a.l6());
                        builder3.O(eVar.f);
                        builder3.z(eVar.f);
                        builder3.G(false);
                        if (this.a.w0 != null) {
                            builder3.D(this.a.w0.getFromForumId());
                            if (this.a.w0.S1() != null) {
                                builder3.Q(this.a.w0.S1().O());
                            }
                        }
                        ImageViewerConfig x3 = builder3.x(this.a.getPageContext().getPageActivity());
                        x3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0ce0));
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.E0.v1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                jv7 S1 = this.a.w0.S1();
                if (S1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0b4e));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0b4a);
                    }
                    this.a.y7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.r7();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (dj.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0b4b);
                    }
                    this.a.f1.c(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements qo4.a {
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

        @Override // com.baidu.tieba.qo4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.E0.t3();
                if (z) {
                    if (this.a.y0 != null) {
                        this.a.y0.h(z2);
                    }
                    this.a.w0.H3(z2);
                    if (this.a.w0.D1()) {
                        this.a.y6();
                    } else {
                        this.a.E0.I1(this.a.w0.S1());
                    }
                    if (z2) {
                        boolean m0 = this.a.w0.S1().m0();
                        if (this.a.y0 != null && !m0) {
                            if (this.a.y0.f() == null || this.a.w0 == null || this.a.w0.S1() == null || this.a.w0.S1().O() == null || this.a.w0.S1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.y0.f();
                            MetaData author = this.a.w0.S1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.q7(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                    this.a.v7();
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                            }
                        }
                        this.a.U4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff2));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14e6));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements pu4.c {
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

        @Override // com.baidu.tieba.pu4.c
        public void a(pu4 pu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pu4Var, i, view2) == null) {
                if (pu4Var != null) {
                    pu4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.B2;
                if (postData != null) {
                    if (i == 0) {
                        postData.C0();
                        this.a.B2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.C6(pbFragment2.B2);
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin() && this.a.y0 != null && !this.a.y0.e()) {
                        this.a.A6();
                    }
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.E0.v1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.d(this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f14bf));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (dj.isEmpty(muteMessage)) {
                    muteMessage = this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f14be);
                }
                this.a.f1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                nu4Var.dismiss();
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
                if (this.a.E0 != null && this.a.E0.e1() != null) {
                    gy7 e1 = this.a.E0.e1();
                    if (e1.f()) {
                        e1.d();
                        return true;
                    }
                }
                if (this.a.E0 == null || !this.a.E0.X1()) {
                    return false;
                }
                this.a.E0.z1();
                return true;
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v = true;
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
                if (!this.a.j6() || this.a.a == null || this.a.a.j1() == null || !str.equals(this.a.a.j1().getTopicId())) {
                    return;
                }
                this.a.H7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                nu4Var.dismiss();
                this.b.A0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.w0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u2 implements pu4.c {
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

        @Override // com.baidu.tieba.pu4.c
        public void a(pu4 pu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pu4Var, i, view2) == null) {
                if (pu4Var != null) {
                    pu4Var.e();
                }
                if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.m1 == null) {
                        this.a.V4();
                    } else {
                        i85.a aVar = new i85.a();
                        aVar.a = this.a.k1;
                        String str = "";
                        if (this.a.m1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.m1.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
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
                        pbFragment.i1 = new sz7(pbFragment.getPageContext());
                    }
                    this.a.i1.b(this.a.k1, this.a.j1.n());
                }
                this.a.j1 = null;
                this.a.k1 = null;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ku8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                ku8 ku8Var = (ku8) customResponsedMessage.getData();
                this.a.E0.v1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = ku8Var.a;
                if (ku8Var.c == 0 && dataRes != null) {
                    int e = dh.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (dj.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092050)).intValue();
                if (intValue == 0) {
                    this.a.s7(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.E0.x2(sparseArray, r3);
                }
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
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.w0 == null || this.a.w0.S1() == null || this.a.E0 == null || this.a.E0.D0() == null) {
                return;
            }
            this.a.E0.q2(absListView, i, i2, i3);
            if (this.a.e != null) {
                this.a.e.q(absListView, i, i2, i3);
            }
            if (!this.a.w0.E2() || (F = this.a.w0.S1().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i + i2) - this.a.E0.D0().w()) - 1;
            jv7 S1 = this.a.w0.S1();
            if (S1 == null) {
                return;
            }
            if (S1.D() != null && S1.D().j1()) {
                w--;
            }
            if (S1.E() != null && S1.E().j1()) {
                w--;
            }
            int size = F.size();
            if (w < 0 || w >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                PbFragment pbFragment = this.a;
                if (!pbFragment.p6(pbFragment.c1) && this.a.p6(i)) {
                    if (this.a.E0 != null) {
                        this.a.q0 = true;
                        this.a.E0.p0();
                        if (this.a.T0 != null && !this.a.E0.K1()) {
                            this.a.E0.Y2(this.a.T0.y());
                        }
                        if (!this.a.I) {
                            this.a.q0 = true;
                            this.a.E0.Q2();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.E0 != null) {
                    this.a.E0.r2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new jd5();
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
                    this.a.X6(false, null);
                    ll8.g().h(this.a.getUniqueId(), true);
                    this.a.Y4(true);
                }
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.w0 == null || this.a.w0.b2() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.Z6(pbFragment.N5(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof is4)) {
                is4 is4Var = (is4) customResponsedMessage.getData();
                bt4.a aVar = new bt4.a();
                int i = is4Var.a;
                String str = is4Var.b;
                aVar.a = is4Var.d;
                jv7 S1 = this.a.w0.S1();
                if (S1 == null) {
                    return;
                }
                if (this.a.w0.u1() != null && this.a.w0.u1().getUserIdLong() == is4Var.p) {
                    this.a.E0.I2(is4Var.l, this.a.w0.S1(), this.a.w0.k2(), this.a.w0.c2());
                }
                if (S1.F() == null || S1.F().size() < 1 || S1.F().get(0) == null) {
                    return;
                }
                long g = dh.g(S1.F().get(0).L(), 0L);
                long g2 = dh.g(this.a.w0.m2(), 0L);
                if (g == is4Var.n && g2 == is4Var.m) {
                    bt4 J = S1.F().get(0).J();
                    if (J == null) {
                        J = new bt4();
                    }
                    ArrayList<bt4.a> a = J.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    J.e(J.b() + is4Var.l);
                    J.d(a);
                    S1.F().get(0).H0(J);
                    this.a.E0.D0().a0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E0.K1() && (customResponsedMessage.getData() instanceof MotionEvent)) {
                MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
                this.a.m5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements Comparator<z35> {
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
        public int compare(z35 z35Var, z35 z35Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z35Var, z35Var2)) == null) ? z35Var.compareTo(z35Var2) : invokeLL.intValue;
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
                return pbFragment.g5(view2);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w0 == null || this.a.w0.S1() == null) {
                return;
            }
            this.a.w0.S1().a();
            this.a.w0.v2();
            if (this.a.E0.D0() != null) {
                this.a.E0.I1(this.a.w0.S1());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
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
            an8 an8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof an8) || (an8Var = (an8) customResponsedMessage.getData()) == null || (agreeData = an8Var.b) == null) {
                return;
            }
            if (this.a.E0 != null) {
                this.a.E0.d2(an8Var);
            }
            if (agreeData.agreeType != 2 || this.a.E0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || i18.k(this.a.w0.b)) {
                return;
            }
            this.a.E0.c4();
            i18.b(this.a.w0.b);
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements g75 {
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

        @Override // com.baidu.tieba.g75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qz7 qz7Var = this.a.I0;
                if (qz7Var == null || qz7Var.e() == null || !this.a.I0.e().d()) {
                    return !this.a.d5(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.I0.e().c());
                if (this.a.T0 != null && (this.a.T0.x() || this.a.T0.z())) {
                    this.a.T0.w(false, this.a.I0.h());
                }
                this.a.I0.a(true);
                return true;
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w0 == null || this.a.w0.S1() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.i5(str);
            this.a.w0.v2();
            if (!TextUtils.isEmpty(str) && this.a.w0.S1().F() != null) {
                ArrayList<PostData> F = this.a.w0.S1().F();
                jn8 jn8Var = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof jn8) {
                        jn8 jn8Var2 = (jn8) next;
                        if (str.equals(jn8Var2.k1())) {
                            jn8Var = jn8Var2;
                            break;
                        }
                    }
                }
                if (jn8Var != null) {
                    F.remove(jn8Var);
                    if (this.a.E0.D0() != null && this.a.E0.D0().t() != null) {
                        this.a.E0.D0().t().remove(jn8Var);
                    }
                    if (this.a.E0.U0() != null && this.a.E0.U0().getData() != null) {
                        this.a.E0.U0().getData().remove(jn8Var);
                    }
                    if (this.a.E0.D0() != null) {
                        this.a.E0.D0().a0();
                        return;
                    }
                }
            }
            if (this.a.E0.D0() != null) {
                this.a.E0.I1(this.a.w0.S1());
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.P5() == null) {
                return;
            }
            this.a.P5().n2();
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
        public void onNavigationButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nu4Var) == null) {
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
        public void a(m08 m08Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, m08Var) == null) || m08Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, m08Var.c()));
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.n1 = true;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.z0.getLoadDataMode()) {
                        case 0:
                            this.a.w0.v2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.p5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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
                            pbFragment.q5(pbFragment.z0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.E0.z0(this.a.z0.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.E0.s2(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.E0.z0(this.a.z0.getLoadDataMode(), false, null, false);
            }
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
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.w0.H1()) {
                    this.a.S6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(ej.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
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
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/god/call/?";
        R2 = new d3();
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
        this.i0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.s0 = new u(this);
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
        this.I1 = new x(this, 2016488);
        this.J1 = new y(this, 2016331);
        this.K1 = new z(this);
        this.L1 = new a0(this, 2921509);
        this.M1 = new b0(this, 2010045);
        this.N1 = new c0(this);
        this.P1 = new PraiseModel(getPageContext(), new d0(this));
        this.Q1 = new e0(this);
        this.R1 = new h0(this, 2001115);
        this.S1 = new i0(this);
        this.U1 = new lw7(new o0(this));
        this.V1 = new r0(this);
        this.W1 = new s0(this, 2001427);
        this.X1 = new t0(this, 2001428);
        this.Y1 = new u0(this, 2921634);
        this.Z1 = new v0(this, 2001426);
        this.a2 = new w0(this, 2004021);
        this.b2 = new x0(this, 2016528);
        this.c2 = new y0(this, 2921724);
        this.d2 = new z0(this, 2921033);
        this.e2 = new a1(this);
        this.f2 = new c1(this);
        this.g2 = new g1(this);
        this.h2 = new j1(this);
        this.i2 = new k1(this, 2921480);
        this.j2 = new l1(this);
        this.k2 = Boolean.FALSE;
        this.l2 = new n1(this);
        this.m2 = new o1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.n2 = new p1(this);
        this.o2 = new q1(this, 2016450);
        this.p2 = new r1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.q2 = new s1(this);
        this.r2 = new v1(this);
        this.s2 = new z1(this);
        this.t2 = new b2(this);
        this.u2 = new c2(this);
        this.v2 = new d2(this);
        this.x2 = new e2(this);
        this.y2 = 0;
        this.z2 = new r2(this);
        this.A2 = false;
        this.B2 = null;
        this.C2 = new s2(this);
        this.D2 = new u2(this);
        this.E2 = new v2(this);
        this.F2 = new w2(this);
        this.G2 = new x2(this);
        this.H2 = new y2(this);
        this.I2 = new z2(this);
        this.J2 = new b3(this);
        this.K2 = new c3(this);
        this.L2 = new a(this);
        this.M2 = -1;
        this.N2 = -1;
    }

    public static PbFragment E6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public PbInterviewStatusView.f A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.u0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final void A6() {
        MarkData i12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y0 == null) {
            return;
        }
        if (this.w0.S1() != null && this.w0.S1().i0()) {
            i12 = this.w0.i1(0);
        } else {
            i12 = this.w0.i1(this.E0.T0());
        }
        if (i12 == null) {
            return;
        }
        if (i12.isApp() && (i12 = this.w0.i1(this.E0.T0() + 1)) == null) {
            return;
        }
        this.E0.u3();
        this.y0.i(i12);
        if (!this.y0.e()) {
            if (this.E0 != null && this.w0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !i18.k(this.w0.b)) {
                this.E0.c4();
                i18.b(this.w0.b);
            }
            this.y0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.y0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void A7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pbModel = this.w0) == null || dj.isEmpty(pbModel.m2())) {
            return;
        }
        rl4.w().P(ql4.Z, dh.g(this.w0.m2(), 0L));
    }

    @Override // com.baidu.tieba.t28
    public PbModel.h B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n2 : (PbModel.h) invokeV.objValue;
    }

    public final boolean B5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final void B6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d)) == null) {
                return;
            }
            C6(postData);
        }
    }

    public final void B7(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f09203d) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d)) != null) {
            C7(postData, false);
        }
    }

    public boolean C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (!this.c && this.M2 == -1 && this.N2 == -1) ? false : true : invokeV.booleanValue;
    }

    public void C6(PostData postData) {
        PostData u5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.L() != null && postData.L().equals(this.w0.N1())) {
            z3 = true;
        }
        MarkData M1 = this.w0.M1(postData);
        if (this.w0.S1() != null && this.w0.S1().i0() && (u5 = u5()) != null) {
            M1 = this.w0.M1(u5);
        }
        if (M1 == null) {
            return;
        }
        this.E0.u3();
        qo4 qo4Var = this.y0;
        if (qo4Var != null) {
            qo4Var.i(M1);
            if (!z3) {
                this.y0.a();
            } else {
                this.y0.d();
            }
        }
    }

    public final void C7(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, postData, z3) == null) {
            a7(false);
            if (postData == null || (pbModel = this.w0) == null || pbModel.S1() == null || postData.C() == 1) {
                return;
            }
            String m22 = this.w0.m2();
            String L = postData.L();
            int W = this.w0.S1() != null ? this.w0.S1().W() : 0;
            AbsPbActivity.e M6 = M6(L);
            if (M6 == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(m22, L, "pb", true, false, null, false, null, W, postData.c0(), this.w0.S1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(M6.a, M6.b, M6.g, M6.j);
            addBigImageData.setKeyPageStartFrom(this.w0.R1());
            addBigImageData.setFromFrsForumId(this.w0.getFromForumId());
            addBigImageData.setWorksInfoData(this.w0.r2());
            addBigImageData.setKeyFromForumId(this.w0.getForumId());
            addBigImageData.setBjhData(this.w0.k1());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    @Override // com.baidu.tieba.ll5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            nz7 nz7Var = this.E0;
            if (nz7Var == null) {
                return 0;
            }
            return nz7Var.j1();
        }
        return invokeV.intValue;
    }

    public final boolean D5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public final boolean D6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = ox4.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return true;
                }
                yo4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f054a), q3 + "?props_id=" + str, true, true, true);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void D7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (voiceManager = this.j) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public boolean E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k2.booleanValue() : invokeV.booleanValue;
    }

    public final void E7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.v1();
    }

    public boolean F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public void F6() {
        List<f3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (list = this.q1) == null || list.isEmpty()) {
            return;
        }
        int size = this.q1.size();
        while (true) {
            size--;
            if (size <= -1 || this.q1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    public final boolean F7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.S1() == null || !this.w0.S1().i0()) {
                if (this.w0.D1()) {
                    MarkData o12 = this.w0.o1();
                    if (o12 != null && this.w0.B1()) {
                        MarkData i12 = this.w0.i1(this.E0.K0());
                        if (i12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", o12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (i12.getPostId() != null && !i12.getPostId().equals(o12.getPostId())) {
                            nu4 nu4Var = new nu4(getPageContext().getPageActivity());
                            nu4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0269));
                            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new h2(this, i12, o12, nu4Var));
                            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new j2(this, o12, nu4Var));
                            nu4Var.setOnCalcelListener(new k2(this, o12, nu4Var));
                            nu4Var.create(getPageContext());
                            nu4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", o12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.w0.S1() != null && this.w0.S1().F() != null && this.w0.S1().F().size() > 0 && this.w0.B1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ll5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ll5
    /* renamed from: G5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            nz7 nz7Var = this.E0;
            if (nz7Var == null) {
                return null;
            }
            return nz7Var.U0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean G6(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i4, keyEvent)) == null) ? (keyEvent == null || (nz7Var = this.E0) == null || !nz7Var.i2(i4)) ? false : true : invokeIL.booleanValue;
    }

    public final void G7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (absPbActivity = this.a) == null || absPbActivity.j1() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.j1().m2()).param("topic_id", this.a.j1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.j1().q2()));
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ug<TbImageView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ug) invokeV.objValue;
    }

    public int H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.N2 : invokeV.intValue;
    }

    public final void H6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c5a);
                return;
            }
            this.E0.p0();
            if (this.h) {
                return;
            }
            D7();
            this.E0.u3();
            if (this.w0.loadData()) {
                this.E0.Z3();
            }
        }
    }

    public final void H7(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.j1() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.j1().m2()).param("topic_id", this.a.j1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.j1().q2()));
    }

    @Override // com.baidu.tieba.ll5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            tz7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    public int I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M2 : invokeV.intValue;
    }

    public void I6() {
        PbModel pbModel;
        jv7 S1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (pbModel = this.w0) == null || pbModel.S1() == null || (O = (S1 = this.w0.S1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.E0.t1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        vy7 vy7Var = new vy7();
        int W = this.w0.S1().W();
        if (W != 1 && W != 3) {
            vy7Var.g = false;
        } else {
            vy7Var.g = true;
            vy7Var.s = O.getIs_top() == 1;
        }
        if (n6(W)) {
            vy7Var.h = true;
            vy7Var.r = O.getIs_good() == 1;
        } else {
            vy7Var.h = false;
        }
        if (W == 1002 && !equals) {
            vy7Var.u = true;
        }
        vy7Var.n = o7(O.isBlocked(), S1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        vy7Var.e = m7(equals, S1.k0());
        vy7Var.i = p7();
        vy7Var.f = n7(equals);
        vy7Var.k = equals && S1.V() != null && S1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            vy7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        vy7Var.t = equals;
        vy7Var.q = this.w0.k2();
        vy7Var.b = true;
        vy7Var.a = q6(equals);
        if (equals) {
            this.E0.J1();
        }
        vy7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        vy7Var.j = true;
        vy7Var.o = this.w0.v1();
        vy7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            vy7Var.c = true;
        } else {
            vy7Var.c = false;
        }
        if (S1.i0()) {
            vy7Var.b = false;
            vy7Var.d = false;
            vy7Var.c = false;
            vy7Var.g = false;
            vy7Var.h = false;
        }
        vy7Var.v = TbSingleton.getInstance().mShowCallFans && equals && !S1.i0();
        nz7 nz7Var = this.E0;
        if (nz7Var != null) {
            PbModel pbModel2 = this.w0;
            PostData L0 = nz7Var.L0(pbModel2.G, pbModel2.k2());
            vy7Var.w = L0 != null ? L0.R : false;
        }
        vy7Var.m = true;
        if (O.isBlocked()) {
            vy7Var.n = false;
            vy7Var.g = false;
            vy7Var.h = false;
        }
        this.E0.h.F(vy7Var);
    }

    public final void I7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.w0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(g18.m(i4))));
        }
    }

    public final String J5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public void J6() {
        i35 i35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (i35Var = this.j0) == null) {
            return;
        }
        i35Var.q();
    }

    public final void J7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.w0.getForumId()) && this.w0.S1() != null && this.w0.S1().l() != null) {
            if (this.w0.S1().l().isLike() == 1) {
                this.w0.f1().D(this.w0.getForumId(), this.w0.m2());
            }
        }
    }

    @Override // com.baidu.tieba.t28
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.w0 : (PbModel) invokeV.objValue;
    }

    public final long K5(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void K6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048613, this, str, i4, eVar) == null) || eVar == null) {
            return;
        }
        jv7 S1 = this.w0.S1();
        TbRichText M7 = M7(str, i4);
        if (M7 == null || (tbRichTextData = M7.B().get(this.y2)) == null) {
            return;
        }
        eVar.f = String.valueOf(M7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a4 = kv7.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.r ? 17 : 18;
            }
            imageUrlData.originalUrl = J5(tbRichTextData);
            imageUrlData.originalUrl = J5(tbRichTextData);
            imageUrlData.originalSize = K5(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = D5(tbRichTextData);
            imageUrlData.isLongPic = B5(tbRichTextData);
            imageUrlData.postId = M7.getPostId();
            imageUrlData.mIsReserver = this.w0.d2();
            imageUrlData.mIsSeeHost = this.w0.v1();
            eVar.b.put(a4, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.O() != null) {
                    eVar.e = S1.O().getId();
                }
                eVar.g = S1.s() == 1;
            }
            imageUrlData.threadId = dh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.F().size();
        this.A2 = false;
        eVar.j = -1;
        int z5 = S1.j() != null ? z5(S1.j().W(), M7, i4, i4, eVar.a, eVar.b) : i4;
        for (int i5 = 0; i5 < size; i5++) {
            PostData postData = S1.F().get(i5);
            if (postData.L() == null || S1.j() == null || S1.j().L() == null || !postData.L().equals(S1.j().L())) {
                z5 = z5(postData.W(), M7, z5, i4, eVar.a, eVar.b);
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
            if (S1.O() != null) {
                eVar.e = S1.O().getId();
            }
            eVar.g = S1.s() == 1;
        }
        eVar.j = z5;
    }

    public final void K7(tr4 tr4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, tr4Var) == null) || tr4Var == null) {
            return;
        }
        this.P2 = tr4Var;
        this.c = true;
        this.E0.N2();
        this.E0.h3(this.O2);
    }

    @Override // com.baidu.tieba.ll5
    public ug<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new p2(this), 10, 0);
            this.F = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public j75 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.T0 : (j75) invokeV.objValue;
    }

    public void L6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S1() != null && this.w0.S1().l() != null) {
                if (Z4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.w0.S1().i0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.E0.i0();
                    return;
                } else {
                    if (this.X0 == null) {
                        yq6 yq6Var = new yq6(getPageContext());
                        this.X0 = yq6Var;
                        yq6Var.j(0);
                        this.X0.i(new f1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.X0.g(this.w0.S1().l().getId(), dh.g(this.w0.m2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void L7(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i4) == null) || (pbModel = this.w0) == null || pbModel.S1() == null || (O = this.w0.S1().O()) == null) {
            return;
        }
        if (i4 == 1) {
            PraiseData praise = O.getPraise();
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
                    O.setPraise(praiseData);
                } else {
                    O.getPraise().getUser().add(0, metaData);
                    O.getPraise().setNum(O.getPraise().getNum() + 1);
                    O.getPraise().setIsLike(i4);
                }
            }
            if (O.getPraise() != null) {
                if (O.getPraise().getNum() < 1) {
                    getResources().getString(R.string.obfuscated_res_0x7f0f1663);
                } else {
                    StringHelper.numFormatOver10000(O.getPraise().getNum());
                }
            }
        } else if (O.getPraise() != null) {
            O.getPraise().setIsLike(i4);
            O.getPraise().setNum(O.getPraise().getNum() - 1);
            ArrayList<MetaData> user = O.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        O.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
            if (O.getPraise().getNum() < 1) {
                getResources().getString(R.string.obfuscated_res_0x7f0f1663);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.w0.k2()) {
            this.E0.D0().a0();
        } else {
            this.E0.t4(this.w0.S1());
        }
    }

    public r08 M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.e : (r08) invokeV.objValue;
    }

    public final AbsPbActivity.e M6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            String str2 = null;
            if (this.w0.S1() != null && this.w0.S1().F() != null && this.w0.S1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 >= this.w0.S1().F().size()) {
                        i4 = 0;
                        break;
                    } else if (str.equals(this.w0.S1().F().get(i4).L())) {
                        break;
                    } else {
                        i4++;
                    }
                }
                PostData postData = this.w0.S1().F().get(i4);
                if (postData.W() != null && postData.W().B() != null) {
                    Iterator<TbRichTextData> it = postData.W().B().iterator();
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
                    K6(str2, 0, eVar);
                    kv7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final TbRichText M7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048621, this, str, i4)) == null) {
            PbModel pbModel = this.w0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i4 < 0) {
                return null;
            }
            jv7 S1 = this.w0.S1();
            if (S1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S1.j());
                tbRichText = y5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = S1.F();
                X4(S1, F);
                return y5(F, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ll5
    public ug<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.B == null) {
                this.B = new ug<>(new l2(this), 8, 0);
            }
            return this.B;
        }
        return (ug) invokeV.objValue;
    }

    public final int N5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i4)) == null) {
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

    public boolean N6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            i35 i35Var = this.j0;
            return i35Var != null && i35Var.t();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ll5
    public ug<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.C == null) {
                this.C = new ug<>(new o2(this), 8, 0);
            }
            return this.C;
        }
        return (ug) invokeV.objValue;
    }

    public e18 O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.t0 : (e18) invokeV.objValue;
    }

    public final void O6(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09188c, Integer.valueOf(this.b ? 2 : 3));
        view2.setTag(sparseArray);
    }

    @Override // com.baidu.tieba.t28
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public nz7 P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.E0 : (nz7) invokeV.objValue;
    }

    public void P6(zv7 zv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, zv7Var) == null) {
            String L = zv7Var.i().L();
            List<PostData> list = this.w0.S1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.L() == null || !postData.L().equals(L)) {
                    i4++;
                } else {
                    ArrayList<PostData> k3 = zv7Var.k();
                    postData.X0(zv7Var.m());
                    if (postData.Z() != null) {
                        postData.Z().clear();
                        postData.Z().addAll(k3);
                    }
                }
            }
            if (this.w0.B1()) {
                return;
            }
            this.E0.I1(this.w0.S1());
        }
    }

    @Override // com.baidu.tieba.ll5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, context, str) == null) {
        }
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.C0 == null) {
                this.C0 = new PollingModel(getPageContext(), getUniqueId());
            }
            this.C0.Q(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            gh.a().postDelayed(this.V1, 10000L);
        }
    }

    public void Q6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048633, this, z3, markData) == null) {
            this.E0.t3();
            this.w0.H3(z3);
            qo4 qo4Var = this.y0;
            if (qo4Var != null) {
                qo4Var.h(z3);
                if (markData != null) {
                    this.y0.i(markData);
                }
            }
            if (this.w0.D1()) {
                y6();
            } else {
                this.E0.I1(this.w0.S1());
            }
        }
    }

    @Override // com.baidu.tieba.ll5
    public void R(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048634, this, context, str, z3) == null) {
            if (tz7.c(str) && (pbModel = this.w0) != null && pbModel.m2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.w0.m2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    s45 s45Var = new s45();
                    s45Var.a = str;
                    s45Var.b = 3;
                    s45Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, s45Var));
                }
            } else {
                tz7.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    public kt4 R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.b0 : (kt4) invokeV.objValue;
    }

    public void R6(zv7 zv7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, zv7Var) == null) || zv7Var.i() == null) {
            return;
        }
        String L = zv7Var.i().L();
        ArrayList<PostData> F = this.w0.S1().F();
        int i4 = 0;
        while (true) {
            if (i4 >= F.size()) {
                break;
            }
            PostData postData = F.get(i4);
            if (postData.L() == null || !postData.L().equals(L)) {
                i4++;
            } else {
                ArrayList<PostData> k3 = zv7Var.k();
                postData.X0(zv7Var.m());
                if (postData.Z() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.g0() != null && next != null && next.s() != null && (metaData = postData.g0().get(next.s().getUserId())) != null) {
                            next.B0(metaData);
                            next.N0(true);
                            next.g1(getPageContext(), this.w0.K2(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.Z().size();
                    if (!postData.n0(false)) {
                        postData.Z().clear();
                        postData.Z().addAll(k3);
                    }
                }
                if (postData.z() != null) {
                    postData.z0();
                }
            }
        }
        if (!this.w0.B1() && z3) {
            this.E0.I1(this.w0.S1());
        }
        if (z3) {
            P6(zv7Var);
        }
    }

    public void S4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, f3Var) == null) || f3Var == null) {
            return;
        }
        if (this.q1 == null) {
            this.q1 = new ArrayList();
        }
        if (this.q1.contains(f3Var)) {
            return;
        }
        this.q1.add(f3Var);
    }

    public String S5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public final void S6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            hideNetRefreshView(this.E0.p1());
            t7();
            if (this.w0.T2()) {
                this.E0.u3();
            }
            this.E0.C3();
        }
    }

    public void T4(f3 f3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, f3Var) == null) || f3Var == null) {
            return;
        }
        if (this.q1 == null) {
            this.q1 = new ArrayList();
        }
        if (this.q1.contains(f3Var)) {
            return;
        }
        this.q1.add(0, f3Var);
    }

    public final int T5(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.O() == null) {
                return 0;
            }
            if (jv7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (jv7Var.O().getThreadType() == 54) {
                return 2;
            }
            return jv7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T6(f3 f3Var) {
        List<f3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, f3Var) == null) || f3Var == null || (list = this.q1) == null) {
            return;
        }
        list.remove(f3Var);
    }

    public final void U4() {
        PbModel pbModel;
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (pbModel = this.w0) == null || (jv7Var = pbModel.G) == null || jv7Var.O() == null) {
            return;
        }
        ThreadData O = this.w0.G.O();
        O.mRecomAbTag = this.w0.X1();
        O.mRecomWeight = this.w0.a2();
        O.mRecomSource = this.w0.Z1();
        O.mRecomExtra = this.w0.Y1();
        O.isSubPb = this.w0.F1();
        if (O.getFid() == 0) {
            O.setFid(dh.g(this.w0.getForumId(), 0L));
        }
        StatisticItem i4 = tc5.i(getContext(), O, "c13562");
        TbPageTag l3 = tc5.l(getContext());
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t28
    /* renamed from: U5 */
    public VideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public void U6() {
        i35 i35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (i35Var = this.j0) == null) {
            return;
        }
        i35Var.x();
    }

    @Override // com.baidu.tieba.ll5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048646, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.L0 = str;
        if (this.l == null) {
            h6();
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

    @Override // com.baidu.tieba.p38.b
    public void V0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z3) == null) {
            this.N0 = z3;
        }
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            if (this.l1 != null) {
                i85.b bVar = new i85.b();
                bVar.a = this.l1.D();
                bVar.b = this.l1.B();
                bVar.c = String.valueOf(this.l1.E());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.k1));
        }
    }

    public String V5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.O : (String) invokeV.objValue;
    }

    public final boolean V6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203d);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.O0 && !TextUtils.isEmpty(postData.t()) && hq4.c().g()) {
                        return D6(postData.L());
                    }
                    if (!checkUpIsLogin()) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return true;
                    }
                    PbModel pbModel = this.w0;
                    if (pbModel != null && pbModel.S1() != null) {
                        if (P5().e1() != null) {
                            P5().e1().c();
                        }
                        zv7 zv7Var = new zv7();
                        zv7Var.A(this.w0.S1().l());
                        zv7Var.E(this.w0.S1().O());
                        zv7Var.C(postData);
                        P5().d1().V(zv7Var);
                        P5().d1().setPostId(postData.L());
                        w6(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        j75 j75Var = this.T0;
                        if (j75Var != null) {
                            this.E0.Y2(j75Var.y());
                        }
                        return true;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W4(boolean z3) {
        PbModel pbModel;
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048651, this, z3) == null) || (pbModel = this.w0) == null || (jv7Var = pbModel.G) == null || jv7Var.O() == null) {
            return;
        }
        ThreadData O = this.w0.G.O();
        O.mRecomAbTag = this.w0.X1();
        O.mRecomWeight = this.w0.a2();
        O.mRecomSource = this.w0.Z1();
        O.mRecomExtra = this.w0.Y1();
        if (O.getFid() == 0) {
            O.setFid(dh.g(this.w0.getForumId(), 0L));
        }
        StatisticItem i4 = tc5.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l3 = tc5.l(getContext());
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
            oc5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i4);
        }
        if (z3) {
            return;
        }
        x6();
    }

    public void W5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.w0.S1() == null || this.w0.S1().O() == null || this.w0.S1().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.w0.S1().O().getTaskInfoData().g(), this.w0.S1().O().getTaskInfoData().f(), this.w0.S1().O().getTaskInfoData().b(), this.w0.S1().O().getTaskInfoData().c(), this.w0.S1().O().getIs_top(), this.w0.S1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void W6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (pbModel = this.w0) == null || pbModel.S1() == null || this.w0.S1().O() == null || !this.w0.S1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void X4(jv7 jv7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048654, this, jv7Var, arrayList) == null) || jv7Var == null || jv7Var.T() == null || jv7Var.T().a == null || (list = jv7Var.T().a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.L()) && !TextUtils.isEmpty(postData.L()) && next.L().equals(postData.L())) {
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

    public final void X5(int i4, Intent intent) {
        t55 t55Var;
        t55 t55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048655, this, i4, intent) == null) {
            if (i4 == 0) {
                this.E0.t1();
                this.E0.e1().c();
                this.E0.H3(false);
            }
            this.E0.Q2();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                int editorType = pbEditorData.getEditorType();
                if (editorType != 0) {
                    if (editorType != 1 || this.E0.e1() == null || this.E0.e1().b() == null) {
                        return;
                    }
                    n75 b4 = this.E0.e1().b();
                    b4.d0(this.w0.S1().O());
                    b4.C(writeData);
                    b4.e0(pbEditorData.getVoiceModel());
                    s55 n3 = b4.a().n(6);
                    if (n3 != null && (t55Var2 = n3.m) != null) {
                        t55Var2.B(new h55(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        b4.G();
                        return;
                    }
                    return;
                }
                this.T0.L();
                this.T0.m0(pbEditorData.getVoiceModel());
                this.T0.B(writeData);
                s55 n4 = this.T0.a().n(6);
                if (n4 != null && (t55Var = n4.m) != null) {
                    t55Var.B(new h55(52, 0, pbEditorData.getVoiceModel()));
                }
                this.T0.h0(pbEditorData.isShowCustomFigure());
                if (i4 == -1) {
                    this.T0.G(null, null);
                }
            }
        }
    }

    public final void X6(boolean z3, PostData postData) {
        l05 adAdSense;
        nz7 nz7Var;
        ux7 D0;
        ArrayList<PostData> E;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048656, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e() || (nz7Var = this.E0) == null || (D0 = nz7Var.D0()) == null || (E = D0.E()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PostData> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String L = next.L();
            if (z3) {
                if (next == postData) {
                    arrayList.add(new pn8.c());
                    break;
                }
            } else if (next.D == 1 && !TextUtils.isEmpty(L)) {
                next.D = 2;
                arrayList.add(new pn8.c());
            }
        }
        if (arrayList.size() <= 0 || (pbModel = this.w0) == null || pbModel.S1() == null || this.w0.S1().l() == null) {
            return;
        }
        this.w0.S1().l().getFirst_class();
        this.w0.S1().l().getSecond_class();
        this.w0.S1().l().getId();
        this.w0.m2();
    }

    @Override // com.baidu.tieba.ll5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, context, str) == null) {
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (ug) invokeV.objValue;
    }

    public void Y4(boolean z3) {
        nz7 nz7Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048659, this, z3) == null) || (nz7Var = this.E0) == null || nz7Var.U0() == null) {
            return;
        }
        int firstVisiblePosition = this.E0.U0().getFirstVisiblePosition();
        int lastVisiblePosition = this.E0.U0().getLastVisiblePosition();
        ux7 D0 = this.E0.D0();
        if (D0 == null || this.w0.S1() == null) {
            return;
        }
        if (lastVisiblePosition <= D0.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > D0.w() ? firstVisiblePosition - D0.w() : 0;
            w4 = (lastVisiblePosition - D0.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.E0.U0().G(w3) != null && (this.E0.U0().G(w3) instanceof PostData) && (postData = (PostData) this.E0.U0().G(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.w0.S1().F(), postData.C() - 1);
                    if (postData.o() == null && postData2 != null) {
                        postData.A0(postData2.o());
                    }
                    if (postData.o() != null) {
                        postData.o().q(postData.C());
                        arrayList.add(postData.o());
                    }
                }
                w3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new w1(this));
            z35 z35Var = (z35) ListUtils.getItem(arrayList, 0);
            if (z35Var == null || z35Var.e() != 1) {
                this.E0.B2(z35Var, 1);
            } else if (z3) {
            } else {
                this.E0.B2(z35Var, 0);
            }
        }
    }

    public void Y5(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092096) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092098) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092097) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092093) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092094) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.g1);
            userMuteAddAndDelCustomMessage.setTag(this.g1);
            z7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void Y6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || (pbModel = this.w0) == null || pbModel.S1() == null || this.w0.S1().O() == null || !this.w0.S1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final boolean Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.w0.S1().O()) || AntiHelper.d(getPageContext(), this.w0.S1().d());
        }
        return invokeV.booleanValue;
    }

    public final void Z5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S1() != null && this.w0.S1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.w0.m2(), str);
                ThreadData O = this.w0.S1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                r6(format);
                return;
            }
            this.x0.a(str);
        }
    }

    public final void Z6(int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048664, this, i4) == null) || this.w0 == null) {
            return;
        }
        t7();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
        privacySettingMessage.setTid(this.w0.b);
        sendMessage(privacySettingMessage);
    }

    public final boolean a5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048665, this, i4)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i4)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void a6(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, intent) == null) {
            i18.j(this, intent);
        }
    }

    public void a7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z3) == null) {
            this.k2 = Boolean.valueOf(z3);
        }
    }

    public void b5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.E0.P3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = dh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = dh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092095), 0L);
            BdUniqueId bdUniqueId = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.d1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void b6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        ej.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void b7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z3) == null) {
            this.r0 = z3;
        }
    }

    public boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if ((this.w0.S1() != null && (this.w0.S1().i0() || ThreadCardUtils.isSelf(this.w0.S1().O()))) || this.W0 == null || this.w0.S1() == null || this.w0.S1().d() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeInvokeEditor(this.w0.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void c6() {
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || (nz7Var = this.E0) == null) {
            return;
        }
        nz7Var.t1();
        b6();
    }

    public void c7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z3) == null) {
            this.M = z3;
        }
    }

    public boolean d5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i4)) == null) {
            if (this.W0 == null || this.w0.S1() == null || ThreadCardUtils.isSelf(this.w0.S1().O()) || this.w0.S1().d() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeSend(this.w0.S1().d().replyPrivateFlag, i4);
        }
        return invokeI.booleanValue;
    }

    public final void d6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048675, this, i4, i5) == null) {
            hi5.b(new i(this, i5), new j(this, i5, i4));
        }
    }

    public final void d7(l75 l75Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, l75Var) == null) || l75Var == null || (pbModel = this.w0) == null) {
            return;
        }
        l75Var.p(pbModel.r1());
        if (this.w0.S1() != null && this.w0.S1().l() != null) {
            l75Var.o(this.w0.S1().l());
        }
        l75Var.q("pb");
        l75Var.r(this.w0);
    }

    @Override // com.baidu.tieba.ll5
    public ug<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (this.G == null) {
                this.G = new ug<>(new q2(this), 10, 0);
            }
            return this.G;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e5(AgreeData agreeData) {
        oc5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048679, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new kx4();
        }
        if (this.h0 == null) {
            an8 an8Var = new an8();
            this.h0 = an8Var;
            an8Var.a = getUniqueId();
        }
        er4 er4Var = new er4();
        er4Var.b = 5;
        er4Var.h = 8;
        er4Var.g = 2;
        if (K() != null) {
            er4Var.f = K().R1();
        }
        er4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                er4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i4, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.w0;
                if (pbModel != null || pbModel.S1() == null) {
                }
                this.d0.b(P(), er4Var, agreeData, this.w0.S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            er4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            er4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.d0.c(agreeData, i4, getUniqueId(), false);
        this.d0.d(agreeData, this.h0);
        pbModel = this.w0;
        if (pbModel != null) {
        }
    }

    public final void e6(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i4) == null) {
            hi5.b(new g(this), new h(this, i4));
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

    public final void e7(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048681, this, i4) == null) || (pbModel = this.w0) == null) {
            return;
        }
        int b22 = pbModel.b2();
        if (i4 == 5) {
            this.w0.B3(2);
        } else if (i4 == 6) {
            this.w0.B3(3);
        } else if (i4 != 7) {
            this.w0.B3(1);
        } else {
            this.w0.B3(4);
        }
        int b23 = this.w0.b2();
        if (b22 == 4 || b23 == 4) {
            H6();
        }
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            if (this.w0.x1() || this.w0.A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.w0.m2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.w0.m2()));
            if (F7()) {
                this.a.finish();
            }
        }
    }

    public final void f6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, bundle) == null) {
            qo4 c4 = qo4.c(this.a);
            this.y0 = c4;
            if (c4 != null) {
                c4.j(this.q2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.z0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.s2);
            this.A0 = new n25(getPageContext());
            Q5();
            this.P1.setUniqueId(getUniqueId());
            this.P1.registerListener();
        }
    }

    public void f7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z3) == null) {
            this.J = z3;
        }
    }

    @Override // com.baidu.tieba.t28
    public void finish() {
        nz7 nz7Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            nz7 nz7Var2 = this.E0;
            if (nz7Var2 != null) {
                nz7Var2.p0();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S1() != null && !this.w0.S1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.w0.S1().O().getId();
                if (this.w0.isShareThread() && this.w0.S1().O().originalThreadData != null) {
                    historyMessage.threadName = this.w0.S1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.w0.S1().O().getTitle();
                }
                if (this.w0.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.w0.S1().l().getName();
                }
                ArrayList<PostData> F = this.w0.S1().F();
                nz7 nz7Var3 = this.E0;
                int K0 = nz7Var3 != null ? nz7Var3.K0() : 0;
                if (F != null && K0 >= 0 && K0 < F.size()) {
                    historyMessage.postID = F.get(K0).L();
                }
                historyMessage.isHostOnly = this.w0.v1();
                historyMessage.isSquence = this.w0.k2();
                historyMessage.isShareThread = this.w0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            j75 j75Var = this.T0;
            if (j75Var != null) {
                j75Var.D();
            }
            if (this.i && P5() != null) {
                P5().u0();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && (pbModel2.x1() || this.w0.A1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.w0.m2());
                if (this.F0) {
                    if (this.H0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.w0.G1());
                    }
                    if (this.G0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.w0.C1());
                    }
                }
                if (this.w0.S1() != null && System.currentTimeMillis() - this.o >= 40000 && (q3 = this.w0.S1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.p1);
                }
                this.a.setResult(-1, intent);
            }
            if (F7()) {
                if (this.w0 != null && (nz7Var = this.E0) != null && nz7Var.U0() != null) {
                    jv7 S1 = this.w0.S1();
                    if (S1 != null) {
                        if (S1.V() != null) {
                            S1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            S1.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!S1.p0() && !this.H && S1.h == null) {
                            cz7.b().n(this.w0.T1(), this.E0.U0().onSaveInstanceState(), this.w0.k2(), this.w0.v1(), this.E0.c1() != null && this.E0.c1().getVisibility() == 0);
                            if (this.o1 >= 0 || this.w0.o2() != null) {
                                cz7.b().q(this.w0.o2());
                                cz7.b().r(this.w0.p2());
                                cz7.b().o(this.w0.L1());
                            }
                        }
                    }
                } else {
                    cz7.b().m();
                }
                E7();
            }
        }
    }

    @Override // com.baidu.tieba.ll5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048686, this, context, str) == null) {
        }
    }

    public final boolean g5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<uu4> c4;
        uu4 uu4Var;
        uu4 uu4Var2;
        uu4 uu4Var3;
        uu4 uu4Var4;
        uu4 uu4Var5;
        uu4 uu4Var6;
        on onVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, view2)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                nz7 nz7Var = this.E0;
                if (nz7Var != null) {
                    if (nz7Var.M1()) {
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
                    if (m6(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.j1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.k1 = url;
                            if (this.j1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
                            } else {
                                this.l1 = null;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextImageInfo)) {
                                this.m1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextImageInfo)) {
                                this.m1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
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
                                if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextImageInfo)) {
                                    this.m1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
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
                            this.E0.U3(this.D2, this.j1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d);
                this.B2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.C() == 1 && m6(view2)) {
                    this.E0.U3(this.D2, this.j1.t());
                    return true;
                }
                qo4 qo4Var = this.y0;
                if (qo4Var == null) {
                    return true;
                }
                boolean z6 = qo4Var.e() && this.B2.L() != null && this.B2.L().equals(this.w0.N1());
                boolean z7 = K().S1() != null && K().S1().i0();
                boolean z8 = K().S1() != null && K().S1().m0();
                boolean z9 = K().S1() != null && K().S1().l0();
                if (this.B2.C() == 1) {
                    if (!z7) {
                        this.E0.V3(this.C2, z6, false, z8, z9);
                    }
                    return true;
                }
                if (this.K0 == null) {
                    yu4 yu4Var = new yu4(getContext());
                    this.K0 = yu4Var;
                    yu4Var.n(this.f2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 == null || sparseArray == null) {
                    return true;
                }
                boolean z10 = m6(view2) && !z7;
                boolean z11 = (!m6(view2) || (onVar = this.j1) == null || onVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092056) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092056)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092085) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092085)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092083) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092083)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f09204d) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204d) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092055)).booleanValue() : false;
                boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f09205e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205e)).booleanValue() : false;
                if (z10) {
                    z3 = booleanValue8;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new uu4(1, getString(R.string.obfuscated_res_0x7f0f10af), this.K0));
                } else {
                    z3 = booleanValue8;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z11) {
                    arrayList.add(new uu4(2, getString(R.string.obfuscated_res_0x7f0f10b0), this.K0));
                }
                if (!z10 && !z11) {
                    uu4 uu4Var7 = new uu4(3, getString(R.string.obfuscated_res_0x7f0f0452), this.K0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203d, this.B2);
                    uu4Var7.d.setTag(sparseArray3);
                    arrayList.add(uu4Var7);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        uu4Var6 = new uu4(4, getString(R.string.obfuscated_res_0x7f0f0ff2), this.K0);
                    } else {
                        uu4Var6 = new uu4(4, getString(R.string.obfuscated_res_0x7f0f0aaa), this.K0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f09203d, this.B2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
                    uu4Var6.d.setTag(sparseArray4);
                    arrayList.add(uu4Var6);
                }
                if (this.mIsLogin && !this.i0) {
                    if (!g18.i(this.w0) && !booleanValue4 && booleanValue3) {
                        uu4 uu4Var8 = new uu4(5, getString(R.string.obfuscated_res_0x7f0f0b4d), this.K0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                        uu4Var8.d.setTag(sparseArray5);
                        arrayList.add(uu4Var8);
                    } else {
                        if ((q6(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            uu4 uu4Var9 = new uu4(5, getString(R.string.obfuscated_res_0x7f0f1017), this.K0);
                            uu4Var9.d.setTag(str);
                            arrayList.add(uu4Var9);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204d, str);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09205e, sparseArray.get(R.id.obfuscated_res_0x7f09205e));
                        if (!g18.i(this.w0) && z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(booleanValue7));
                            if (booleanValue7) {
                                uu4Var5 = new uu4(6, getString(R.string.obfuscated_res_0x7f0f04b0), this.K0);
                                uu4Var5.d.setTag(sparseArray6);
                                uu4Var2 = new uu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.K0);
                                uu4Var2.d.setTag(sparseArray6);
                                uu4Var3 = uu4Var5;
                                uu4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                        }
                        uu4Var5 = null;
                        uu4Var2 = new uu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.K0);
                        uu4Var2.d.setTag(sparseArray6);
                        uu4Var3 = uu4Var5;
                        uu4Var = null;
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray7.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                        if (this.w0.S1().W() == 1002 && !booleanValue2) {
                            uu4Var4 = new uu4(6, getString(R.string.obfuscated_res_0x7f0f1017), this.K0);
                        } else {
                            uu4Var4 = new uu4(6, getString(R.string.obfuscated_res_0x7f0f04b0), this.K0);
                        }
                        uu4Var4.d.setTag(sparseArray7);
                        if (z3) {
                            uu4Var = new uu4(13, getString(R.string.obfuscated_res_0x7f0f0b3d), this.K0);
                            uu4Var3 = uu4Var4;
                        } else {
                            uu4Var3 = uu4Var4;
                            uu4Var = null;
                        }
                        uu4Var2 = null;
                    } else {
                        uu4Var = null;
                        uu4Var2 = null;
                        uu4Var3 = null;
                    }
                    if (uu4Var3 != null) {
                        arrayList.add(uu4Var3);
                    }
                    if (uu4Var != null) {
                        arrayList.add(uu4Var);
                    }
                    if (uu4Var2 != null) {
                        arrayList.add(uu4Var2);
                    }
                    g18.b(arrayList, this.K0, this.B2, this.w0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = g18.d(arrayList, this.B2.q(), sparseArray, this.K0);
                } else {
                    c4 = g18.c(arrayList, this.B2.q(), sparseArray, this.K0);
                }
                g18.l(c4, this.b);
                g18.f(c4);
                this.K0.o(g18.g(this.B2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.K0.k(c4, false);
                } else {
                    this.K0.k(c4, true);
                }
                wu4 wu4Var = new wu4(getPageContext(), this.K0);
                this.J0 = wu4Var;
                wu4Var.k();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.w0.b).param("fid", this.w0.getForumId()).param("uid", this.w0.S1().O().getAuthor().getUserId()).param("post_id", this.w0.B()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new l0(this));
        }
    }

    public final void g7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z3) == null) {
            this.T0.X(z3);
            this.T0.a0(z3);
            this.T0.i0(z3);
        }
    }

    public void h5(ForumManageModel.b bVar, nz7 nz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048691, this, bVar, nz7Var) == null) {
            List<PostData> list = this.w0.S1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).Z().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).Z().get(i5).L())) {
                        list.get(i4).Z().remove(i5);
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
                nz7Var.I1(this.w0.S1());
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048692, this) == null) && this.l == null) {
            this.l = new pu4(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), getPageContext().getString(R.string.obfuscated_res_0x7f0f11cc), getPageContext().getString(R.string.obfuscated_res_0x7f0f10e1)};
            pu4 pu4Var = this.l;
            pu4Var.j(strArr, new p0(this));
            pu4Var.g(pu4.b.obfuscated_res_0x7f1003ad);
            pu4Var.h(17);
            pu4Var.c(getPageContext());
        }
    }

    public final void h7() {
        PbModel pbModel;
        ImMessageCenterPojo i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || (pbModel = this.w0) == null || pbModel.G == null) {
            return;
        }
        long c4 = d35.c();
        if (c4 <= 0 || (i4 = ma7.o().i(String.valueOf(c4), 2)) == null || ja7.a(getContext())) {
            return;
        }
        MetaData metaData = new MetaData();
        metaData.setUserIdLong(c4);
        metaData.setUserName(i4.getGroup_name());
        metaData.setName_show(i4.getNameShow());
        metaData.setPortrait(i4.getGroup_head());
        metaData.setIsMyFriend(i4.getIsFriend() != 1 ? 0 : 1);
        ub7 ub7Var = new ub7(getContext());
        ub7Var.o(this.w0.G.O(), metaData);
        ub7Var.p();
    }

    public final void i5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, str) == null) || TextUtils.isEmpty(str) || (pbModel = this.w0) == null || pbModel.S1() == null) {
            return;
        }
        jn8 z3 = this.w0.S1().z();
        if (z3 != null && str.equals(z3.k1())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().h = null;
            }
            this.w0.S1().b();
        }
        jn8 l12 = this.w0.l1();
        if (l12 == null || !str.equals(l12.k1())) {
            return;
        }
        this.w0.X0();
    }

    public boolean i6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                return pbModel.x1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i7(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048696, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new y1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                y7(str);
            } else {
                this.E0.h4(str);
            }
        }
    }

    public void j5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048697, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(nz7.k2)).intValue();
            if (intValue == nz7.l2) {
                if (this.z0.S()) {
                    return;
                }
                this.E0.i4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092041)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092053) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092053)).booleanValue() : false;
                if (jSONArray != null) {
                    this.z0.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.z0.V(this.w0.S1().l().getId(), this.w0.S1().l().getName(), this.w0.S1().O().getId(), str, intValue3, intValue2, booleanValue, this.w0.S1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == nz7.m2 || intValue == nz7.o2) {
                PbModel pbModel = this.w0;
                if (pbModel != null && pbModel.n1() != null) {
                    this.w0.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == nz7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final boolean j6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.j1() == null || this.a.j1().R1() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j7(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048699, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (P5() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                String questionMsg = postWriteCallBackData.getQuestionMsg();
                String questionExp = postWriteCallBackData.getQuestionExp();
                if (postWriteCallBackData.getIconStampData() != null) {
                    l35.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else if (postWriteCallBackData.getToast() != null) {
                    return;
                } else {
                    if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                        nu7.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                        return;
                    } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                        nu7.f(errorString + " " + preMsg, colorMsg);
                        return;
                    } else if (StringUtils.isNull(errorString)) {
                        nu7.e(getResources().getString(R.string.obfuscated_res_0x7f0f122c));
                        return;
                    } else {
                        nu7.e(errorString);
                        return;
                    }
                }
            }
            return;
        }
        if (!this.w0.F1()) {
            antiData.setBlock_forum_name(this.w0.S1().l().getName());
            antiData.setBlock_forum_id(this.w0.S1().l().getId());
            antiData.setUser_name(this.w0.S1().V().getUserName());
            antiData.setUser_id(this.w0.S1().V().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    @Override // com.baidu.tieba.t28
    public PbFragment k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public void k5(nu4 nu4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048701, this, nu4Var, jSONArray) == null) {
            nu4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (nu4Var.getYesButtonTag() instanceof SparseArray) {
                    j5((SparseArray) nu4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean k6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            PostData c4 = kv7.c(this.w0.S1(), this.w0.k2(), this.w0.c2());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void k7(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            i18.l(this, j3, str, j4);
        }
    }

    public void l5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048704, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(i5));
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z3));
            sparseArray.put(nz7.k2, Integer.valueOf(nz7.l2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                j5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean l6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l7(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048706, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            g18.e(getActivity(), getPageContext(), new d1(this, sparseArray, i4, z3), new e1(this));
        }
    }

    public void m5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048707, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            nz7 nz7Var = this.E0;
            if (nz7Var == null || this.w0 == null) {
                return;
            }
            if ((nz7Var != null && !nz7Var.K1()) || this.w0.S1() == null || this.w0.S1().S() == null) {
                return;
            }
            nz7 nz7Var2 = this.E0;
            if (nz7Var2 == null || nz7Var2.J0() == null || !this.E0.J0().t()) {
                xv7 S = this.w0.S1().S();
                if (checkUpIsLogin()) {
                    if ((!S.f() || S.a() != 2) && this.E0.D0() != null && this.E0.D0().z() != null) {
                        this.E0.D0().z().v(this.w0.m2(), this.w0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        lu7 lu7Var = new lu7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.w0;
                        lu7Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        lu7Var.l(new n0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public boolean m6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public final boolean m7(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        ds4 ds4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048709, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            jv7 S1 = this.w0.S1();
            ThreadData O = S1.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z3;
                }
            }
            if (z3) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !qi6.isOn()) || this.w0.H() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (S1.l() == null || !S1.l().isBlockBawuDelete) {
                if (S1.O() == null || !S1.O().isBlocked()) {
                    if (S1.W() != 0) {
                        return S1.W() != 3;
                    }
                    List<xt4> p3 = S1.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (xt4 xt4Var : p3) {
                            if (xt4Var != null && (ds4Var = xt4Var.g) != null && ds4Var.a && !ds4Var.c && ((i4 = ds4Var.b) == 1 || i4 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void n5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048710, this) == null) || this.E0 == null || (pbModel = this.w0) == null || pbModel.S1() == null || this.w0.S1().S() == null || !checkUpIsLogin() || this.E0.D0() == null || this.E0.D0().z() == null) {
            return;
        }
        this.E0.D0().z().v(this.w0.m2(), this.w0.getFromForumId());
    }

    public boolean n6(int i4) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i4)) == null) {
            if (i4 == 1) {
                return true;
            }
            if (this.w0.S1().V() != null && (forumToolAuth = this.w0.S1().V().getForumToolAuth()) != null) {
                for (int i5 = 0; i5 < forumToolAuth.size(); i5++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i5);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean n7(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048712, this, z3)) == null) {
            if (z3 || (pbModel = this.w0) == null || pbModel.S1() == null || (this.w0.S1().l() != null && this.w0.S1().l().isBlockBawuDelete)) {
                return false;
            }
            jv7 S1 = this.w0.S1();
            if ((S1.O() == null || S1.O().getAuthor() == null || !S1.O().getAuthor().isForumBusinessAccount() || qi6.isOn()) && !this.w0.H()) {
                return ((S1.O() != null && S1.O().isBlocked()) || this.w0.S1().W() == 0 || this.w0.S1().W() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void o5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, str) == null) || (pbModel = this.w0) == null || pbModel.S1() == null || this.w0.S1().O() == null || !this.w0.S1().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.w0.S1().O();
        int i4 = 0;
        if (O.isBJHArticleThreadType()) {
            i4 = 1;
        } else if (O.isBJHVideoThreadType()) {
            i4 = 2;
        } else if (O.isBJHNormalThreadType()) {
            i4 = 3;
        } else if (O.isBJHVideoDynamicThreadType()) {
            i4 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i4);
        TiebaStatic.log(statisticItem);
    }

    public boolean o6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048714, this, i4)) == null) ? i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 : invokeI.booleanValue;
    }

    public final boolean o7(boolean z3, boolean z4, boolean z5, int i4, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048715, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || o6(i4));
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906d3));
            this.n2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
            this.a.l1().k(this.s0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048717, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.T0.C(i4, i5, intent);
            if (P5().e1() != null) {
                P5().e1().g(i4, i5, intent);
            }
            if (i4 == 25035) {
                X5(i5, intent);
            }
            if (i5 == -1) {
                if (i4 == 11009) {
                    A6();
                } else if (i4 == 13008) {
                    cz7.b().m();
                    this.v0.postDelayed(new f2(this), 1000L);
                } else if (i4 == 13011) {
                    ed8.g().m(getPageContext());
                } else if (i4 == 23003) {
                    if (intent == null || this.w0 == null) {
                        return;
                    }
                    k7(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i4 == 23007) {
                    a6(intent);
                } else if (i4 == 25012) {
                    intent.getLongExtra("KEY_FORUM_ID", 0L);
                    intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                } else if (i4 == 25033) {
                    View view2 = this.Q;
                    if (view2 != null) {
                        this.E0.M3(view2);
                    }
                } else if (i4 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ed8.g().m(getPageContext());
                        J7();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                            shareSuccessReplyToServerModel.z(str, intExtra, new g2(this));
                        }
                        if (j6()) {
                            H7(true);
                        }
                    }
                } else if (i4 != 24008) {
                    switch (i4) {
                        case 25055:
                            View view3 = this.R;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view4 = this.S;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            nz7 nz7Var = this.E0;
                            if (nz7Var == null || nz7Var.E0() == null) {
                                return;
                            }
                            this.E0.E0().performClick();
                            return;
                        case 25058:
                            View view5 = this.T;
                            if (view5 != null) {
                                view5.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.E0.w3(false);
                    if (this.w0.S1() == null || this.w0.S1().O() == null || this.w0.S1().O().getPushStatusData() == null) {
                        return;
                    }
                    this.w0.S1().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048719, this, i4) == null) || this.V == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.E0.e2(i4);
        j75 j75Var = this.T0;
        if (j75Var != null && j75Var.a() != null) {
            this.T0.a().w(i4);
        }
        if (this.E0.a() != null) {
            this.E0.a().d(getPageContext(), i4);
        }
        this.I0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201));
        this.V = i4;
        D7();
        i35 i35Var = this.j0;
        if (i35Var != null) {
            i35Var.w();
        }
    }

    @Override // com.baidu.tieba.nu4.e
    public void onClick(nu4 nu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, nu4Var) == null) {
            k5(nu4Var, null);
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
            nz7 nz7Var = this.E0;
            if (nz7Var != null) {
                nz7Var.f2(configuration);
            }
            wu4 wu4Var = this.J0;
            if (wu4Var != null) {
                wu4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        nz7 nz7Var;
        nz7 nz7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
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
                this.M2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.N2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.O2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.O0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.P0 = intent.getStringExtra("high_light_post_id");
                this.Q0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (C5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O = stringExtra;
                this.O = dj.isEmpty(stringExtra) ? "" : this.O;
                this.p1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                kt4 kt4Var = new kt4();
                this.b0 = kt4Var;
                kt4Var.a(intent);
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
            u6(bundle);
            if (this.w0.S1() != null) {
                this.w0.S1().Q0(this.O);
            }
            g6();
            if (intent != null && (nz7Var2 = this.E0) != null) {
                nz7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new j0(this, intent);
                    }
                    gh.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.w0.S1() != null) {
                    this.w0.z3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            f6(bundle);
            l75 l75Var = new l75();
            this.S0 = l75Var;
            d7(l75Var);
            j75 j75Var = (j75) this.S0.a(getActivity());
            this.T0 = j75Var;
            j75Var.W(this.a.getPageContext());
            this.T0.f0(this.j2);
            this.T0.g0(this.Z0);
            this.T0.Y(1);
            this.T0.A(this.a.getPageContext(), bundle);
            this.T0.a().b(new r55(getActivity()));
            this.T0.a().C(true);
            g7(true);
            this.T0.J(this.w0.u1(), this.w0.m2(), this.w0.q1());
            registerListener(this.z1);
            if (!this.w0.F1()) {
                this.T0.q(this.w0.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.w0.A2()) {
                this.T0.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a));
            } else {
                nz7 nz7Var3 = this.E0;
                if (nz7Var3 != null) {
                    this.T0.c0(nz7Var3.h1());
                }
            }
            registerListener(this.y1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.x1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.p2);
            registerListener(this.w1);
            bn8 bn8Var = new bn8("pb", bn8.d);
            this.R0 = bn8Var;
            bn8Var.d();
            registerListener(this.H1);
            registerListener(this.R1);
            this.w0.W2();
            registerListener(this.o2);
            registerListener(this.d2);
            registerListener(this.i2);
            registerListener(this.L1);
            registerListener(this.M1);
            registerListener(this.c2);
            nz7 nz7Var4 = this.E0;
            if (nz7Var4 != null && nz7Var4.o1() != null && this.E0.m1() != null) {
                r08 r08Var = new r08(getActivity(), this.E0.o1(), this.E0.m1(), this.E0.c1());
                this.e = r08Var;
                r08Var.t(this.Q1);
            }
            if (this.c && (nz7Var = this.E0) != null && nz7Var.m1() != null) {
                this.E0.m1().setVisibility(8);
            }
            ux4 ux4Var = new ux4();
            this.f1 = ux4Var;
            ux4Var.a = 1000L;
            registerListener(this.Z1);
            registerListener(this.Y1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.J1);
            registerListener(this.D1);
            registerListener(this.E1);
            registerListener(this.F1);
            this.I1.setSelfListener(true);
            this.I1.setTag(this.a.getUniqueId());
            this.I1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.I1);
            registerResponsedEventListener(TipEvent.class, this.S1);
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
            this.T1 = new g3(this.E0, this);
            this.w0.m1().D(this.T1);
            this.I0 = new qz7();
            if (this.T0.s() != null) {
                this.I0.m(this.T0.s().i());
            }
            this.T0.V(this.a1);
            this.D0 = new ShareSuccessReplyToServerModel();
            S4(this.u1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.W0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new k0(this));
            p18 p18Var = new p18(getContext());
            this.x0 = p18Var;
            p18Var.b(getUniqueId());
            ll8.g().i(getUniqueId());
            tq4.b().l("3", "");
            this.t1 = new g16(getPageContext());
            this.t0 = new e18(this, getUniqueId(), this.E0, this.w0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048723, this, layoutInflater, viewGroup, bundle)) == null) {
            this.E0 = new nz7(this, this.h2, this.U1);
            x76 x76Var = new x76(getActivity());
            this.d = x76Var;
            x76Var.i(R2);
            this.d.d(this.K2);
            this.E0.n3(this.r2);
            this.E0.m3(this.x2);
            this.E0.f3(this.u2);
            this.E0.g3(this.v2);
            this.E0.d3(hq4.c().g());
            this.E0.k3(this.z2);
            this.E0.q3(this.F2);
            this.E0.o3(this.G2);
            this.E0.l3(this.I2);
            this.E0.j3(this.t2);
            this.E0.m4(this.mIsLogin);
            if (this.a.getIntent() != null) {
                this.E0.b3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.E0.d1().setFromForumId(this.w0.getFromForumId());
            this.E0.T2(this.T0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.T0.c0(this.E0.h1());
            }
            this.E0.X2(new m0(this));
            this.E0.a3(this.w0.A1());
            this.E0.p3(this.w0.R1());
            this.t0.f(this.E0, this.w0);
            if ("1".equals(K().showReplyPanel)) {
                this.E0.n2();
            }
            return this.E0.p1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        o18 o18Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            ll8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.w0.S1().m());
                statisticItem.param("tid", this.w0.m2());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.E0 != null) {
                this.s = true;
                X6(false, null);
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.w0.destory();
                if (this.w0.O1() != null) {
                    this.w0.O1().d();
                }
            }
            j75 j75Var = this.T0;
            if (j75Var != null) {
                j75Var.D();
            }
            ForumManageModel forumManageModel = this.z0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.M();
            }
            nz7 nz7Var = this.E0;
            if (nz7Var != null) {
                nz7Var.g2();
                o18 o18Var2 = this.E0.h;
                if (o18Var2 != null) {
                    o18Var2.y();
                }
            }
            jd5 jd5Var = this.t;
            if (jd5Var != null) {
                jd5Var.c();
            }
            r08 r08Var = this.e;
            if (r08Var != null) {
                r08Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            nz7 nz7Var2 = this.E0;
            if (nz7Var2 != null) {
                nz7Var2.p0();
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
            MessageManager.getInstance().unRegisterListener(this.m2);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.c2);
            this.e1 = null;
            this.f1 = null;
            kf8.e().g();
            if (this.h1 != null) {
                gh.a().removeCallbacks(this.h1);
            }
            nz7 nz7Var3 = this.E0;
            if (nz7Var3 != null && (o18Var = nz7Var3.h) != null) {
                o18Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            qz7 qz7Var = this.I0;
            if (qz7Var != null) {
                qz7Var.j();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && pbModel2.f1() != null) {
                this.w0.f1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.W0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            nz7 nz7Var4 = this.E0;
            if (nz7Var4 != null) {
                nz7Var4.j4();
            }
            e18 e18Var = this.t0;
            if (e18Var != null) {
                e18Var.e();
            }
        }
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
    public ho onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            S6();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            this.f = true;
            super.onPause();
            h18.a();
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
            nz7 nz7Var = this.E0;
            if (nz7Var != null) {
                nz7Var.l2();
            }
            if (!this.w0.F1()) {
                this.T0.N(this.w0.m2());
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.V2();
            }
            rl4.w().E();
            MessageManager.getInstance().unRegisterListener(this.C1);
            W6();
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
            i35 i35Var = this.j0;
            if (i35Var != null) {
                i35Var.q();
                this.j0.p();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.v9
    public void onPreLoad(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, hoVar) == null) {
            PreLoadImageHelper.load(hoVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(hoVar, getUniqueId(), this);
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
                W5();
            }
            if (k6()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            nz7 nz7Var = this.E0;
            if (nz7Var != null && nz7Var.p1() != null) {
                if (!this.g) {
                    t7();
                } else {
                    hideLoadingView(this.E0.p1());
                }
                this.E0.o2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            nz7 nz7Var2 = this.E0;
            NoNetworkView a4 = nz7Var2 != null ? nz7Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.C1);
            this.N0 = false;
            Y6();
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Z1);
            if (this.n1) {
                S6();
                this.n1 = false;
            }
            A7();
            ItemCardHelper.v(this.H2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                a55.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.w0.n3(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.T0.F(bundle);
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
            if (P5().e1() != null) {
                P5().e1().i();
            }
            o18 o18Var = this.E0.h;
            if (o18Var != null && !o18Var.u()) {
                this.E0.h.y();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S1() != null && this.w0.S1().l() != null && this.w0.S1().O() != null) {
                x45.j().x(getPageContext().getPageActivity(), "pb", this.w0.S1().l().getId(), dh.g(this.w0.S1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            ll8.g().h(getUniqueId(), false);
        }
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
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z3) == null) {
            super.onUserChanged(z3);
            this.E0.m4(z3);
            wu4 wu4Var = this.J0;
            if (wu4Var != null) {
                wu4Var.dismiss();
            }
            if (z3 && this.N0) {
                this.E0.v3();
                this.w0.N2(true);
            }
            if (this.E0.D0() != null) {
                this.E0.D0().e0(z3);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void p0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048736, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (il5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), il5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (tz7.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new aj5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void p5(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048737, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b5);
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                nu4 nu4Var = new nu4(getPageContext().getPageActivity());
                nu4Var.setMessage(string);
                nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04f3, new a2(this));
                nu4Var.setCancelable(true);
                nu4Var.create(getPageContext());
                nu4Var.show();
            } else if (bVar.d != 0) {
                this.E0.z0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> F = this.w0.S1().F();
                    int size = F.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i4).L())) {
                            F.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.w0.S1().O().setReply_num(this.w0.S1().O().getReply_num() - 1);
                    this.E0.I1(this.w0.S1());
                } else if (i5 == 0) {
                    f5();
                } else if (i5 == 2) {
                    ArrayList<PostData> F2 = this.w0.S1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= F2.get(i6).Z().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i6).Z().get(i7).L())) {
                                F2.get(i6).Z().remove(i7);
                                F2.get(i6).k();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        F2.get(i6).l(bVar.g);
                    }
                    if (z4) {
                        this.E0.I1(this.w0.S1());
                    }
                    h5(bVar, this.E0);
                }
            }
        }
    }

    public final boolean p6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048738, this, i4)) == null) ? i4 == 2 || i4 == 1 : invokeI.booleanValue;
    }

    public final boolean p7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.k2()) {
                return this.w0.Q1() == null || this.w0.Q1().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.r0 : invokeV.booleanValue;
    }

    public final void q5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048741, this, i4, gVar) == null) || gVar == null) {
            return;
        }
        this.E0.z0(this.z0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.F0 = true;
            if (i4 == 2 || i4 == 3) {
                this.G0 = true;
                this.H0 = false;
            } else if (i4 == 4 || i4 == 5) {
                this.G0 = false;
                this.H0 = true;
            }
            if (i4 == 2) {
                this.w0.S1().O().setIs_good(1);
                this.w0.u3(1);
            } else if (i4 == 3) {
                this.w0.S1().O().setIs_good(0);
                this.w0.u3(0);
            } else if (i4 == 4) {
                this.w0.S1().O().setIs_top(1);
                this.w0.v3(1);
            } else if (i4 == 5) {
                this.w0.S1().O().setIs_top(0);
                this.w0.v3(0);
            }
            this.E0.q4(this.w0.S1(), this.w0.k2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0d22);
        }
        ej.N(getPageContext().getPageActivity(), string);
    }

    public final boolean q6(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048742, this, z3)) == null) {
            PbModel pbModel = this.w0;
            return (pbModel == null || pbModel.S1() == null || this.w0.S1().O() == null || this.w0.S1().O().getAuthor() == null || TextUtils.equals(this.w0.S1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void q7(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048743, this, metaData) == null) || metaData == null) {
            return;
        }
        nu4 nu4Var = new nu4(getActivity());
        nu4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0aac));
        nu4Var.setTitleShowCenter(true);
        nu4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0aad));
        nu4Var.setMessageShowCenter(true);
        nu4Var.setCancelable(false);
        nu4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0aae), new t1(this, metaData));
        nu4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0aaf), new u1(this, metaData));
        nu4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void r5(Rect rect) {
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048744, this, rect) == null) || rect == null || (nz7Var = this.E0) == null || nz7Var.o1() == null || rect.top > this.E0.o1().getHeight()) {
            return;
        }
        rect.top += this.E0.o1().getHeight() - rect.top;
    }

    public final void r6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void r7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            nu4 nu4Var = new nu4(getPageContext().getPageActivity());
            nu4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b4c));
            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b(this));
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c(this));
            nu4Var.create(this.e1).show();
        }
    }

    public AntiData s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S1() == null) {
                return null;
            }
            return this.w0.S1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void s6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || this.P2 == null) {
            return;
        }
        if (this.N2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0df8);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.P2.a(), this.N2, 0)));
            this.a.finish();
        }
    }

    public final void s7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048749, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092039) instanceof Integer)) {
            wu4 wu4Var = this.J0;
            if (wu4Var != null && wu4Var.isShowing()) {
                this.J0.dismiss();
                this.J0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092093);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092095);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue()) {
                yu4 yu4Var = new yu4(getContext());
                yu4Var.n(new g0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f092039) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092039)).intValue() : -1) == 1) {
                    arrayList.add(new uu4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04b0), yu4Var));
                }
                if (z3) {
                    arrayList.add(new uu4(1, getResources().getString(R.string.obfuscated_res_0x7f0f14bd), yu4Var));
                } else {
                    arrayList.add(new uu4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b49), yu4Var));
                }
                yu4Var.j(arrayList);
                wu4 wu4Var2 = new wu4(getPageContext(), yu4Var);
                this.J0 = wu4Var2;
                wu4Var2.k();
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? this.j : (VoiceManager) invokeV.objValue;
    }

    public final int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            if (this.w0.S1() == null || this.w0.S1().O() == null) {
                return -1;
            }
            return this.w0.S1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public void t6(String str) {
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048752, this, str) == null) || this.w0 == null || StringUtils.isNull(str) || (nz7Var = this.E0) == null) {
            return;
        }
        nz7Var.c3(true);
        this.w0.P2(str);
        this.H = true;
        this.E0.p0();
        this.E0.r1();
    }

    public final void t7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            showLoadingView(this.E0.p1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.E0.o1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048755, this) == null) || (pbModel = this.w0) == null || dj.isEmpty(pbModel.m2())) {
            return;
        }
        super.taskStart();
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public PostData u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            nz7 nz7Var = this.E0;
            PbModel pbModel = this.w0;
            return nz7Var.L0(pbModel.G, pbModel.k2());
        }
        return (PostData) invokeV.objValue;
    }

    public final void u6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, bundle) == null) {
            PbModel j12 = this.a.j1();
            this.w0 = j12;
            if (j12 != null) {
                if (j12.n1() != null) {
                    this.w0.n1().c(this.L2);
                }
                if (this.w0.O1() != null) {
                    this.w0.O1().f(this.v1);
                }
                if (StringUtils.isNull(this.w0.m2())) {
                    this.a.finish();
                } else if (!"from_tieba_kuang".equals(this.L) || this.L == null) {
                } else {
                    this.w0.y3(6);
                }
            }
        }
    }

    public final void u7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048759, this) == null) && UbsABTestHelper.isPushOpenNewStyle() && j35.g(TbadkCoreApplication.getInst(), 0) && !this.E0.A2()) {
            this.j0 = j35.i(getPageContext(), "reply_pb", 0L);
        }
    }

    public String v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    public final void v6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048761, this) == null) || this.P2 == null) {
            return;
        }
        if (this.M2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0df9);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.P2.a(), this.M2, 0)));
            this.a.finish();
        }
    }

    public final void v7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            if (UbsABTestHelper.isPushOpenNewStyle()) {
                if (NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !j35.g(TbadkCoreApplication.getInst(), 0) || this.E0.A2()) {
                    return;
                }
                this.j0 = j35.i(getPageContext(), "collect", 0L);
            } else if (f35.g(getContext(), 0)) {
                f35.i(getPageContext(), 6, 2000L);
            }
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            if (this.K == null) {
                this.K = new ug<>(new m2(this), 20, 0);
            }
            return this.K;
        }
        return (ug) invokeV.objValue;
    }

    public final String w5() {
        InterceptResult invokeV;
        jv7 S1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || (S1 = pbModel.S1()) == null) {
                return null;
            }
            return S1.T().c;
        }
        return (String) invokeV.objValue;
    }

    public final void w6(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048765, this, view2, str, str2, postData) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (Z4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!c5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.X);
                        this.Y = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (P5().e1() != null && postData != null) {
                        P5().e1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100d), postData.s().getName_show(), postData.W() != null ? postData.W().toString() : ""));
                    }
                    if (this.w0.S1() != null && this.w0.S1().i0()) {
                        gh.a().postDelayed(new h1(this, str, str2), 0L);
                        return;
                    }
                    if (this.Y0 == null) {
                        yq6 yq6Var = new yq6(getPageContext());
                        this.Y0 = yq6Var;
                        yq6Var.j(1);
                        this.Y0.i(new i1(this, str, str2));
                    }
                    PbModel pbModel = this.w0;
                    if (pbModel == null || pbModel.S1() == null || this.w0.S1().l() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Y0.g(this.w0.S1().l().getId(), dh.g(this.w0.m2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void w7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                K().a1(postWriteCallBackData.getPostId());
                int H0 = this.E0.H0();
                this.o1 = H0;
                this.w0.q3(H0, this.E0.O0());
            }
            this.E0.p0();
            this.I0.c();
            j75 j75Var = this.T0;
            if (j75Var != null) {
                this.E0.Y2(j75Var.y());
            }
            this.E0.t1();
            this.E0.H3(true);
            this.w0.v2();
        }
    }

    public final String x5() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S1() == null || this.w0.S1().F() == null || (count = ListUtils.getCount((F = this.w0.S1().F()))) == 0) {
                return "";
            }
            if (this.w0.d2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.C() == 1) {
                        return next.L();
                    }
                }
            }
            int K0 = this.E0.K0();
            PostData postData = (PostData) ListUtils.getItem(F, K0);
            if (postData != null && postData.s() != null) {
                if (this.w0.K2(postData.s().getUserId())) {
                    return postData.L();
                }
                for (int i4 = K0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i4);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.w0.K2(postData2.s().getUserId())) {
                        return postData2.L();
                    }
                }
                for (int i5 = K0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i5);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.w0.K2(postData3.s().getUserId())) {
                        return postData3.L();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void x6() {
        PbModel pbModel;
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (pbModel = this.w0) == null || (jv7Var = pbModel.G) == null || jv7Var.O() == null || !this.w0.G.O().isQuestionThread()) {
            return;
        }
        ThreadData O = this.w0.G.O();
        String e22 = this.w0.e2();
        int i4 = 3;
        if ("3".equals(this.w0.f2())) {
            i4 = 1;
        } else if ("question_answer_invite".equals(e22)) {
            i4 = 2;
        }
        TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i4));
    }

    public final void x7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048769, this, i4) == null) {
            i18.o(this, t5(), i4);
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) {
            if (this.D == null) {
                this.D = new ug<>(new n2(this), 5, 0);
            }
            return this.D;
        }
        return (ug) invokeV.objValue;
    }

    public final TbRichText y5(ArrayList<PostData> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048771, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText W = arrayList.get(i5).W();
                    if (W != null && (B = W.B()) != null) {
                        int size = B.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (B.get(i7) != null && B.get(i7).getType() == 8) {
                                i6++;
                                if (B.get(i7).F().B().equals(str) || B.get(i7).F().C().equals(str)) {
                                    int h4 = (int) ej.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i7).F().getWidth() * h4;
                                    int height = B.get(i7).F().getHeight() * h4;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.y2 = i7;
                                    return W;
                                } else if (i6 > i4) {
                                    break;
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

    public final void y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            jv7 S1 = this.w0.S1();
            this.w0.H3(true);
            qo4 qo4Var = this.y0;
            if (qo4Var != null) {
                S1.H0(qo4Var.g());
            }
            this.E0.I1(S1);
        }
    }

    public final void y7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            if (str == null) {
                str = "";
            }
            r9 r9Var = this.e1;
            if (r9Var == null) {
                return;
            }
            nu4 nu4Var = new nu4(r9Var.getPageActivity());
            nu4Var.setMessage(str);
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new d(this));
            nu4Var.create(this.e1).show();
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            if (this.E == null) {
                this.E = new ug<>(new a3(this), 15, 0);
            }
            return this.E;
        }
        return (ug) invokeV.objValue;
    }

    public q08 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.a.z0() : (q08) invokeV.objValue;
    }

    public final int z5(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048776, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.A2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i6 = i4;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int h4 = (int) ej.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h4;
                        int height = tbRichTextData.F().getHeight() * h4;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i7 <= i5) {
                                    i6--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = kv7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                    String B = F.B();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        B = F.C();
                                    } else {
                                        imageUrlData.urlType = this.r ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = B;
                                    imageUrlData.originalUrl = J5(tbRichTextData);
                                    imageUrlData.originalSize = K5(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = D5(tbRichTextData);
                                    imageUrlData.isLongPic = B5(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = dh.g(this.w0.m2(), -1L);
                                    imageUrlData.mIsReserver = this.w0.d2();
                                    imageUrlData.mIsSeeHost = this.w0.v1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.A2) {
                                i6++;
                            }
                        }
                    }
                }
                return i6;
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public void z6() {
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048777, this) == null) || (nz7Var = this.E0) == null) {
            return;
        }
        nz7Var.a2();
    }

    public final void z7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048778, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.E0.P3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            nu4 nu4Var = new nu4(this.e1.getPageActivity());
            if (dj.isEmpty(str)) {
                nu4Var.setMessage(this.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            } else {
                nu4Var.setMessage(str);
            }
            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new e(this, userMuteAddAndDelCustomMessage));
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new f(this));
            nu4Var.create(this.e1).show();
        }
    }
}
