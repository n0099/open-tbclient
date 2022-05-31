package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
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
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
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
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a25;
import com.repackage.a85;
import com.repackage.a9;
import com.repackage.ag;
import com.repackage.ah8;
import com.repackage.am4;
import com.repackage.ap4;
import com.repackage.aq7;
import com.repackage.at7;
import com.repackage.ay4;
import com.repackage.b55;
import com.repackage.b9;
import com.repackage.bf8;
import com.repackage.bg;
import com.repackage.by4;
import com.repackage.c05;
import com.repackage.cj8;
import com.repackage.co8;
import com.repackage.cq7;
import com.repackage.ct4;
import com.repackage.cv7;
import com.repackage.dq4;
import com.repackage.dy4;
import com.repackage.e05;
import com.repackage.e75;
import com.repackage.ev7;
import com.repackage.ew7;
import com.repackage.f05;
import com.repackage.fh8;
import com.repackage.fq4;
import com.repackage.ft4;
import com.repackage.fv7;
import com.repackage.gs7;
import com.repackage.gt7;
import com.repackage.gv7;
import com.repackage.gz4;
import com.repackage.hd5;
import com.repackage.iu7;
import com.repackage.ix4;
import com.repackage.iz4;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.jn4;
import com.repackage.jv7;
import com.repackage.ki;
import com.repackage.kk4;
import com.repackage.kp7;
import com.repackage.kq4;
import com.repackage.ks7;
import com.repackage.ku4;
import com.repackage.kv4;
import com.repackage.kv7;
import com.repackage.lh4;
import com.repackage.li;
import com.repackage.lm4;
import com.repackage.lp7;
import com.repackage.lq7;
import com.repackage.lv5;
import com.repackage.lz4;
import com.repackage.mc5;
import com.repackage.mg;
import com.repackage.mh4;
import com.repackage.mq4;
import com.repackage.mq7;
import com.repackage.mu7;
import com.repackage.nn;
import com.repackage.np4;
import com.repackage.nq6;
import com.repackage.nu7;
import com.repackage.oo7;
import com.repackage.oq4;
import com.repackage.ot7;
import com.repackage.pc5;
import com.repackage.pk5;
import com.repackage.po4;
import com.repackage.pq7;
import com.repackage.pw7;
import com.repackage.q47;
import com.repackage.qb5;
import com.repackage.qg8;
import com.repackage.qo7;
import com.repackage.qt7;
import com.repackage.qu7;
import com.repackage.qx7;
import com.repackage.rc6;
import com.repackage.rg8;
import com.repackage.ro4;
import com.repackage.ru7;
import com.repackage.ry4;
import com.repackage.se5;
import com.repackage.sk4;
import com.repackage.st7;
import com.repackage.sz4;
import com.repackage.t68;
import com.repackage.tb5;
import com.repackage.tn4;
import com.repackage.tr7;
import com.repackage.tt7;
import com.repackage.u15;
import com.repackage.u75;
import com.repackage.um;
import com.repackage.um4;
import com.repackage.up4;
import com.repackage.us4;
import com.repackage.v15;
import com.repackage.v25;
import com.repackage.ve5;
import com.repackage.w15;
import com.repackage.w75;
import com.repackage.wa;
import com.repackage.ww4;
import com.repackage.x15;
import com.repackage.x16;
import com.repackage.xk6;
import com.repackage.xx4;
import com.repackage.y16;
import com.repackage.y57;
import com.repackage.y88;
import com.repackage.yn4;
import com.repackage.yp7;
import com.repackage.yr7;
import com.repackage.ys4;
import com.repackage.ys7;
import com.repackage.z15;
import com.repackage.z65;
import com.repackage.zn8;
import com.repackage.zx4;
import com.repackage.zz4;
import java.io.Serializable;
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
/* loaded from: classes3.dex */
public class PbFragment extends BaseFragment implements ve5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, dq4.e, TbRichTextView.s, TbPageContextSupport, pw7, qx7.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k O2;
    public static final y16.b P2;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<TextView> A;
    public ForumManageModel A0;
    public CustomMessageListener A1;
    public final fq4.c A2;
    public ag<TbImageView> B;
    public ix4 B0;
    public CustomMessageListener B1;
    public final fq4.c B2;
    public ag<ImageView> C;
    public cq7 C0;
    public CustomMessageListener C1;
    public final AdapterView.OnItemClickListener C2;
    public ag<View> D;
    public ShareSuccessReplyToServerModel D0;
    public CustomMessageListener D1;
    public final View.OnLongClickListener D2;
    public ag<TiebaPlusRecommendCard> E;
    public ot7 E0;
    public final CustomMessageListener E1;
    public final View.OnClickListener E2;
    public ag<LinearLayout> F;
    public boolean F0;
    public CustomMessageListener F1;
    public final ItemCardHelper.c F2;
    public ag<RelativeLayout> G;
    public boolean G0;
    public CustomMessageListener G1;
    public final NoNetworkView.b G2;
    public ag<ItemCardView> H;
    public boolean H0;
    public View.OnClickListener H1;
    public View.OnTouchListener H2;
    public boolean I;
    public qt7 I0;
    public CustomMessageListener I1;
    public x16.b I2;
    public boolean J;
    public mq4 J0;
    public CustomMessageListener J1;
    public final gs7.b J2;
    public boolean K;
    public oq4 K0;
    public CustomMessageListener K1;
    public int K2;
    public ag<GifView> L;
    public String L0;
    public SuggestEmotionModel.c L1;
    public int L2;
    public String M;
    public boolean M0;
    public CustomMessageListener M1;
    public String M2;
    public boolean N;
    public boolean N0;
    public CustomMessageListener N1;
    public jn4 N2;
    public boolean O;
    public boolean O0;
    public GetSugMatchWordsModel.b O1;
    public String P;
    public String P0;
    public boolean P1;
    public nu7 Q;
    public boolean Q0;
    public PraiseModel Q1;
    public LikeModel R;
    public rg8 R0;
    public ru7.h R1;
    public View S;
    public z15 S0;
    public CustomMessageListener S1;
    public View T;
    public x15 T0;
    public b55 T1;
    public View U;
    public boolean U0;
    public CheckRealNameModel.b U1;
    public View V;
    public PermissionJudgePolicy V0;
    public mq7 V1;
    public String W;
    public ReplyPrivacyCheckController W0;
    public CustomMessageListener W1;
    public int X;
    public xk6 X0;
    public CustomMessageListener X1;
    public boolean Y;
    public xk6 Y0;
    public CustomMessageListener Y1;
    public int[] Z;
    public EmotionImageData Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public v15 a1;
    public CustomMessageListener a2;
    public boolean b;
    public u15 b1;
    public CustomMessageListener b2;
    public boolean c;
    public u15 c1;
    public CustomMessageListener c2;
    public y16 d;
    public int d1;
    public dq4.e d2;
    public ru7 e;
    public Object e1;
    public oq4.e e2;
    public boolean f;
    public b9 f1;
    public SortSwitchButton.f f2;
    public boolean g;
    public int g0;
    public ct4 g1;
    public final View.OnClickListener g2;
    public boolean h;
    public int h0;
    public BdUniqueId h1;
    public CustomMessageListener h2;
    public boolean i;
    public int i0;
    public Runnable i1;
    public final NewWriteModel.e i2;
    public boolean j;
    public ap4 j0;
    public st7 j1;
    public NewWriteModel.e j2;
    public VoiceManager k;
    public BdUniqueId k0;
    public um k1;
    public wa k2;
    public int l;
    public us4 l0;
    public String l1;
    public final PbModel.h l2;
    public fq4 m;
    public boolean m0;
    public TbRichTextImageInfo m1;
    public CustomMessageListener m2;
    public long n;
    public boolean n0;
    public TbRichTextMemeInfo n1;
    public HttpMessageListener n2;
    public long o;
    public Object o0;
    public boolean o1;
    public final kk4.a o2;
    public long p;
    public qg8 p0;
    public int p1;
    public final AbsListView.OnScrollListener p2;
    public long q;
    public boolean q0;
    public int q1;
    public final a9 q2;
    public long r;
    public ay4 r0;
    public List<d3> r1;
    public final f3 r2;
    public boolean s;
    public boolean s0;
    public int s1;
    public final ft4.g s2;
    public boolean t;
    @NonNull
    public TiePlusEventController.f t0;
    public String t1;
    public final View.OnClickListener t2;
    public u75 u;
    public cv7 u0;
    public lv5 u1;
    public boolean u2;
    public long v;
    public PbInterviewStatusView.f v0;
    public final d3 v1;
    public final BdListView.p v2;
    public boolean w;
    public final Handler w0;
    public final ys7.b w1;
    public int w2;
    public long x;
    public PbModel x0;
    public final CustomMessageListener x1;
    public final TbRichTextView.y x2;
    public int y;
    public kv7 y0;
    public CustomMessageListener y1;
    public boolean y2;
    public String z;
    public kk4 z0;
    public CustomMessageListener z1;
    public PostData z2;

    /* loaded from: classes3.dex */
    public class a implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            this.a.E0.u3(list);
        }
    }

    /* loaded from: classes3.dex */
    public class a1 implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.u2 && this.a.N4()) {
                    this.a.B5();
                }
                if (this.a.mIsLogin) {
                    if (!this.a.m0 && this.a.E0 != null && this.a.E0.d0() && this.a.x0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.a.x0.h2());
                        statisticItem.param("fid", this.a.x0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.x0.u1()) {
                            i = 4;
                        } else if (this.a.x0.v1()) {
                            i = 3;
                        } else if (this.a.x0.x1()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.m0 = true;
                    }
                    if (this.a.x0.I2(false)) {
                        this.a.E0.q3();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.u0 == null || !this.a.x0.C2() || !this.a.u0.d()) && this.a.x0.P1() != null) {
                        this.a.E0.G2();
                    }
                    this.a.u2 = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a3 implements gs7.b {
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

        @Override // com.repackage.gs7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f14d6);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.E0.k0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.P1 = false;
                if (this.a.Q1 == null) {
                    return;
                }
                kp7 P1 = this.a.x0.P1();
                if (P1.O().getPraise().getIsLike() == 1) {
                    this.a.R6(0);
                } else {
                    this.a.R6(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, P1.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.P1 = false;
                if (this.a.Q1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b1 implements xk6.d {
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

        @Override // com.repackage.xk6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xk6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.T0 != null && this.a.T0.a() != null) {
                    this.a.T0.a().A(new sz4(45, 27, null));
                }
                this.a.E0.f0();
            }
        }

        @Override // com.repackage.xk6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x0 == null) {
                return;
            }
            this.a.x0.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class b3 implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    dq4Var.dismiss();
                    ((TbPageContext) this.a.f1).showToast(R.string.obfuscated_res_0x7f0f0702);
                    return;
                }
                TiebaStatic.log("c10025");
                dq4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.f1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public c(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.b.E0.L3();
                MessageManager.getInstance().sendMessage(this.a);
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements ru7.h {
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

        @Override // com.repackage.ru7.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.i6(z);
                if (this.a.E0.O0() != null && z) {
                    this.a.E0.a4(false);
                }
                this.a.E0.j2(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c1 implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.E0.m0();
                boolean z = false;
                if (ji.z()) {
                    if (this.a.x0 != null && !this.a.x0.isLoading) {
                        this.a.J6();
                        this.a.E0.p3();
                        z = true;
                        if (this.a.x0.P1() != null && this.a.x0.P1().f != null && this.a.x0.P1().f.size() > i) {
                            int intValue = this.a.x0.P1().f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.x0.i2()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.x0.G3(intValue)) {
                                this.a.i = true;
                                this.a.E0.d3(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
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

    /* loaded from: classes3.dex */
    public class c2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ c2 b;

            public a(c2 c2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = c2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    pq7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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
                mg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c3 implements ys7.b {
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

        @Override // com.repackage.ys7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.E0.d4(str);
        }

        @Override // com.repackage.ys7.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.E0.a4(!this.a.N);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d1 a;

            public a(d1 d1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = d1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                qt7 qt7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qt7Var = this.a.c.I0) == null || qt7Var.g() == null) {
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

        public d1(PbFragment pbFragment, String str, String str2) {
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
                int i2 = li.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = li.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = li.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.Z4().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                if (this.c.Z4().b1() != null) {
                    this.c.T0.a().setVisibility(8);
                    this.c.Z4().b1().o(this.a, this.b, this.c.Z4().e1(), (this.c.x0 == null || this.c.x0.P1() == null || this.c.x0.P1().O() == null || !this.c.x0.P1().O().isBjh()) ? false : false);
                    a25 b = this.c.Z4().b1().b();
                    if (b != null && this.c.x0 != null && this.c.x0.P1() != null) {
                        b.G(this.c.x0.P1().d());
                        b.c0(this.c.x0.P1().O());
                    }
                    if (this.c.I0.f() == null && this.c.Z4().b1().b().t() != null) {
                        this.c.Z4().b1().b().t().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.I0.n(pbFragment2.Z4().b1().b().t().i());
                        this.c.Z4().b1().b().M(this.c.c1);
                    }
                }
                this.c.Z4().o1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d2 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ dq4 c;
        public final /* synthetic */ PbFragment d;

        public d2(PbFragment pbFragment, MarkData markData, MarkData markData2, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, dq4Var};
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
            this.c = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
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
                this.d.K6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d3 {
        boolean onBackPressed();
    }

    /* loaded from: classes3.dex */
    public class e extends mc5<ShareItem> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mc5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return fv7.d(this.a.E4(), ShareSwitch.isOn() ? 1 : 6, this.a.x0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements oq4.e {
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

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                if (this.e.J0 != null) {
                    this.e.J0.dismiss();
                }
                if (i == 0) {
                    this.e.E0.q2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e56), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091ea7);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091ea9);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091ea8);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.h1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.h1);
                    this.e.F6(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091ea5));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e1 implements xk6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$e1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0223a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0223a(a aVar) {
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
                    qt7 qt7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qt7Var = this.a.a.c.I0) == null || qt7Var.g() == null) {
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

            public a(e1 e1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = e1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = li.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.Z4().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                    if (this.a.c.Z4().b1() != null) {
                        this.a.c.T0.a().setVisibility(8);
                        z = (this.a.c.x0 == null || this.a.c.x0.P1() == null || this.a.c.x0.P1().O() == null || !this.a.c.x0.P1().O().isBjh()) ? false : false;
                        ks7 b1 = this.a.c.Z4().b1();
                        e1 e1Var = this.a;
                        b1.o(e1Var.a, e1Var.b, e1Var.c.Z4().e1(), z);
                        a25 b = this.a.c.Z4().b1().b();
                        if (b != null && this.a.c.x0 != null && this.a.c.x0.P1() != null) {
                            b.G(this.a.c.x0.P1().d());
                            b.c0(this.a.c.x0.P1().O());
                        }
                        if (this.a.c.I0.f() == null && this.a.c.Z4().b1().b().t() != null) {
                            this.a.c.Z4().b1().b().t().g(new C0223a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.I0.n(pbFragment2.Z4().b1().b().t().i());
                            this.a.c.Z4().b1().b().M(this.a.c.c1);
                        }
                    }
                    this.a.c.Z4().o1();
                }
            }
        }

        public e1(PbFragment pbFragment, String str, String str2) {
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

        @Override // com.repackage.xk6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xk6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                mg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.xk6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e2 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ dq4 b;
        public final /* synthetic */ PbFragment c;

        public e2(PbFragment pbFragment, MarkData markData, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, dq4Var};
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
            this.b = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.K6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e3 {
        void a(Object obj);
    }

    /* loaded from: classes3.dex */
    public class f implements tb5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public f(PbFragment pbFragment, int i) {
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
        @Override // com.repackage.tb5
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.O2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.F4().s() != null && this.a.F4().s().getGodUserData() != null) {
                        this.a.F4().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.x0 == null || this.a.x0.P1() == null || this.a.x0.P1().O() == null || this.a.x0.P1().O().getAuthor() == null) {
                        return;
                    }
                    this.a.x0.P1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements oq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mq4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ f1 c;

            public a(f1 f1Var, mq4 mq4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var, mq4Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = f1Var;
                this.a = mq4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.x0.e2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.repackage.oq4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(oq4 oq4Var, int i, View view2) {
                boolean G3;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, oq4Var, i, view2) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.c.a.x0.e2() != 1 || i != 1) {
                    if (this.c.a.x0.e2() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.x0.e2() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f0916fe ? 1 : 0).param("obj_type", i2));
                    if (this.c.a.x0.P1().f != null && this.c.a.x0.P1().f.size() > i) {
                        i = this.c.a.x0.P1().f.get(i).sort_type.intValue();
                    }
                    G3 = this.c.a.x0.G3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.x0.d2()));
                    if (G3) {
                        return;
                    }
                    this.c.a.i = true;
                    this.c.a.E0.d3(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f0916fe ? 1 : 0).param("obj_type", i2));
                if (this.c.a.x0.P1().f != null) {
                    i = this.c.a.x0.P1().f.get(i).sort_type.intValue();
                }
                G3 = this.c.a.x0.G3(i);
                this.b.setTag(Integer.valueOf(this.c.a.x0.d2()));
                if (G3) {
                }
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

        /* JADX WARN: Code restructure failed: missing block: B:908:0x2163, code lost:
            if (r38.a.E0.b1.c.b().getTop() <= ((r38.a.E0.c1() == null || r38.a.E0.c1().c() == null) ? 0 : r38.a.E0.c1().c().getBottom())) goto L849;
         */
        /* JADX WARN: Code restructure failed: missing block: B:909:0x2165, code lost:
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:911:0x2172, code lost:
            if (r0 >= com.repackage.iu7.d(r38.a.Q4())) goto L849;
         */
        /* JADX WARN: Code restructure failed: missing block: B:933:0x2219, code lost:
            if ((r38.a.E0.b1.c.b().getTop() - r38.a.E0.h.a.getBottom()) < (r38.a.E0.b1.c.g.getHeight() + 10)) goto L849;
         */
        /* JADX WARN: Removed duplicated region for block: B:1179:0x2b01  */
        /* JADX WARN: Removed duplicated region for block: B:1180:0x2b17  */
        /* JADX WARN: Removed duplicated region for block: B:1183:0x2b53  */
        /* JADX WARN: Removed duplicated region for block: B:302:0x0a15  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x0a19  */
        /* JADX WARN: Removed duplicated region for block: B:306:0x0a26  */
        /* JADX WARN: Removed duplicated region for block: B:341:0x0ada  */
        /* JADX WARN: Removed duplicated region for block: B:344:0x0aef  */
        /* JADX WARN: Removed duplicated region for block: B:347:0x0b00  */
        /* JADX WARN: Removed duplicated region for block: B:350:0x0b18  */
        /* JADX WARN: Removed duplicated region for block: B:352:0x0b21  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            kq4 kq4Var;
            kq4 kq4Var2;
            kq4 kq4Var3;
            PbFragment pbFragment;
            int i;
            boolean z;
            kq4 kq4Var4;
            kq4 kq4Var5;
            kq4 kq4Var6;
            kq4 kq4Var7;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            up4 up4Var;
            String jumpUrlWithTid;
            String[] strArr;
            kp7 P1;
            int i4;
            int i5;
            boolean F3;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.E0.U0() && this.a.getPageContext().getPageActivity() != null && this.a.x0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.h2(), this.a.x0.x2(), this.a.x0.w2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.x0.getForumId());
                        statisticItem2.param("fname", this.a.x0.o1());
                        statisticItem2.param("tid", this.a.x0.h2());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.E0.W0()) {
                        if (this.a.i) {
                            return;
                        }
                        if (this.a.x0.I2(true)) {
                            this.a.i = true;
                            this.a.E0.q3();
                        }
                    } else if (view2 != this.a.E0.h.m()) {
                        if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().m()) {
                            int i7 = 3;
                            if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().e()) {
                                if (view2 == this.a.E0.h.f) {
                                    if (this.a.E0.c0(this.a.x0.C1())) {
                                        this.a.J6();
                                        return;
                                    }
                                    this.a.j = false;
                                    this.a.f = false;
                                    li.x(this.a.a, this.a.E0.h.f);
                                    this.a.a.finish();
                                } else if (view2 != this.a.E0.C0() && (this.a.E0.h.n() == null || (view2 != this.a.E0.h.n().n() && view2 != this.a.E0.h.n().o()))) {
                                    if (view2 == this.a.E0.K0()) {
                                        if (this.a.x0 != null) {
                                            sk4.o(this.a.getPageContext().getPageActivity(), this.a.x0.P1().O().getTopicData().b());
                                        }
                                    } else if (view2 != this.a.E0.h.c) {
                                        if (view2 == this.a.E0.h.d) {
                                            if (qb5.a()) {
                                                return;
                                            }
                                            if (this.a.x0 != null && this.a.x0.P1() != null) {
                                                ArrayList<PostData> F = this.a.x0.P1().F();
                                                if ((F == null || F.size() <= 0) && this.a.x0.f2()) {
                                                    li.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.x0.h2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x0.getForumId()));
                                                if (!this.a.E0.R1()) {
                                                    this.a.E0.L2();
                                                }
                                                this.a.Q5();
                                            } else {
                                                li.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0916a0) {
                                            if (ji.z()) {
                                                this.a.E0.Z2(true);
                                                this.a.E0.L2();
                                                if (this.a.i) {
                                                    return;
                                                }
                                                this.a.i = true;
                                                this.a.E0.V3();
                                                this.a.J6();
                                                this.a.E0.p3();
                                                this.a.x0.E3(this.a.I4());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                                return;
                                            }
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f09167c) {
                                            if ((this.a.E0.h.n() == null || view2 != this.a.E0.h.n().k()) && view2.getId() != R.id.obfuscated_res_0x7f0909cb && view2.getId() != R.id.obfuscated_res_0x7f091a5b) {
                                                if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().g()) {
                                                    this.a.E0.h.k();
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb6) {
                                                    if (!this.a.l4(11009)) {
                                                        return;
                                                    }
                                                    this.a.n5(3);
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091681) {
                                                    if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().l()) {
                                                        if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().t()) {
                                                            if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().s()) {
                                                                if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().q()) {
                                                                    if (this.a.E0.O0() == view2) {
                                                                        if (this.a.E0.O0().getIndicateStatus()) {
                                                                            kp7 P12 = this.a.x0.P1();
                                                                            if (P12 != null && P12.O() != null && P12.O().getTaskInfoData() != null) {
                                                                                String d = P12.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d)) {
                                                                                    d = P12.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                                            }
                                                                        } else {
                                                                            fh8.d("c10725", null);
                                                                        }
                                                                        this.a.f5();
                                                                    } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().i()) {
                                                                        if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().b()) {
                                                                            if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().h()) {
                                                                                if (ji.z()) {
                                                                                    SparseArray<Object> S0 = this.a.E0.S0(this.a.x0.P1(), this.a.x0.f2(), 1);
                                                                                    if (S0 != null) {
                                                                                        if (StringUtils.isNull((String) S0.get(R.id.obfuscated_res_0x7f091e55))) {
                                                                                            this.a.E0.q2(((Integer) S0.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091e56), ((Integer) S0.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                                                                                        } else {
                                                                                            this.a.E0.r2(((Integer) S0.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091e56), ((Integer) S0.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091e57)).booleanValue(), (String) S0.get(R.id.obfuscated_res_0x7f091e55));
                                                                                        }
                                                                                    }
                                                                                    this.a.E0.h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                                                                    return;
                                                                                }
                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091db5 && view2.getId() != R.id.obfuscated_res_0x7f091db3 && view2.getId() != R.id.obfuscated_res_0x7f091690 && view2.getId() != R.id.obfuscated_res_0x7f091534) {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0916f0) {
                                                                                    if (this.a.x0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.x0.h2());
                                                                                    statisticItem3.param("fid", this.a.x0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916f0 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.T = view2;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f091e70) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e70);
                                                                                        StatisticItem statisticItem4 = postData.i0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.x0 == null || this.a.x0.P1() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String h2 = this.a.x0.h2();
                                                                                        String I = postData.I();
                                                                                        int V = this.a.x0.P1() != null ? this.a.x0.P1().V() : 0;
                                                                                        AbsPbActivity.e U5 = this.a.U5(I);
                                                                                        if (U5 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, false, null, false, null, V, postData.U(), this.a.x0.P1().d(), false, postData.s().getIconInfo(), 5).addBigImageData(U5.a, U5.b, U5.g, U5.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.x0.O1());
                                                                                        addBigImageData.setFromFrsForumId(this.a.x0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.x0.m2());
                                                                                        addBigImageData.setKeyFromForumId(this.a.x0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.x0.H(), this.a.x0.D(), this.a.x0.E(), this.a.x0.C(), this.a.x0.I());
                                                                                        addBigImageData.setBjhData(this.a.x0.h1());
                                                                                        if (this.a.x0.P1().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.x0.P1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.x0.P1().U() != null) {
                                                                                            addBigImageData.setIsManager(this.a.x0.P1().U().getIs_manager());
                                                                                        }
                                                                                        if (this.a.x0.P1().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.x0.P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.x0.P1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.x0.P1().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.x0.P1().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.x0.P1().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.E0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.E0.I0(this.a.x0.G, this.a.x0.f2()).Q || postData.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0916ee || view2.getId() == R.id.obfuscated_res_0x7f0918b3 || view2.getId() == R.id.obfuscated_res_0x7f09168a) {
                                                                                    if (this.a.x0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916ee) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.x0.h2());
                                                                                        statisticItem5.param("fid", this.a.x0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918b3) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.U = view2;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0916ee && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.U = view2;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f091e70) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e70);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916ee && (statisticItem = postData2.i0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b3 || view2.getId() == R.id.obfuscated_res_0x7f09168a) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.x0.i2()).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.I()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.x0 == null || this.a.x0.P1() == null || this.a.Z4().a1() == null || postData2.s() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.Z4().b1() != null) {
                                                                                        this.a.Z4().b1().c();
                                                                                    }
                                                                                    if (this.a.q0 && postData2.R() != null && postData2.R().size() != 0) {
                                                                                        this.a.I6(postData2, true);
                                                                                    } else {
                                                                                        aq7 aq7Var = new aq7();
                                                                                        aq7Var.A(this.a.x0.P1().l());
                                                                                        aq7Var.E(this.a.x0.P1().O());
                                                                                        aq7Var.C(postData2);
                                                                                        this.a.Z4().a1().U(aq7Var);
                                                                                        this.a.Z4().a1().setPostId(postData2.I());
                                                                                        this.a.F5(view2, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.T0 != null) {
                                                                                            this.a.E0.T2(this.a.T0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f09168e) {
                                                                                    if (view2 != this.a.E0.M0()) {
                                                                                        if (view2 == this.a.E0.h.o()) {
                                                                                            this.a.E0.z3();
                                                                                        } else if (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().r()) {
                                                                                            if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().j()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.x0.h2())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.E0.h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f09170d) {
                                                                                                    if (!this.a.checkUpIsLogin() || (up4Var = (up4) view2.getTag()) == null || StringUtils.isNull(up4Var.M0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{up4Var.M0()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091a5e || id == R.id.obfuscated_res_0x7f0906f6 || id == R.id.obfuscated_res_0x7f091a5f || id == R.id.obfuscated_res_0x7f0906f7) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view2 != null && view2.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091e70);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091a5f || id == R.id.obfuscated_res_0x7f0906f7) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.x0.b));
                                                                                                        }
                                                                                                        if (this.a.K0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.K0 = new oq4(pbFragment2.getContext());
                                                                                                            this.a.K0.n(this.a.e2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.v5(view2);
                                                                                                        if (this.a.v5(view2) && this.a.k1 != null) {
                                                                                                            this.a.k1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f091e6d) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6d)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e57)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f091e64) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e64) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.P() != null && postData3.P().toString().length() > 0) {
                                                                                                                kq4 kq4Var8 = new kq4(3, this.a.getString(R.string.obfuscated_res_0x7f0f044a), this.a.K0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091e54, postData3);
                                                                                                                kq4Var8.d.setTag(sparseArray5);
                                                                                                                arrayList.add(kq4Var8);
                                                                                                            }
                                                                                                            this.a.z2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.x0.P1().r()) {
                                                                                                            String u = this.a.x0.P1().u();
                                                                                                            if (postData3 != null && !ki.isEmpty(u) && u.equals(postData3.I())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    kq4Var4 = new kq4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0fad), this.a.K0);
                                                                                                                } else {
                                                                                                                    kq4Var4 = new kq4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0a8e), this.a.K0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091e54, this.a.z2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091e6d, Boolean.FALSE);
                                                                                                                kq4Var4.d.setTag(sparseArray6);
                                                                                                                arrayList.add(kq4Var4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (ev7.h(this.a.x0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.z5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            kq4 kq4Var9 = new kq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fd0), this.a.K0);
                                                                                                                            kq4Var9.d.setTag(str);
                                                                                                                            arrayList.add(kq4Var9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        kq4 kq4Var10 = new kq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b2f), this.a.K0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6b, sparseArray4.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea6, sparseArray4.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea7, sparseArray4.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea5, sparseArray4.get(R.id.obfuscated_res_0x7f091ea5));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea8, sparseArray4.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea9, sparseArray4.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e57, sparseArray4.get(R.id.obfuscated_res_0x7f091e57));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e58, sparseArray4.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e56, sparseArray4.get(R.id.obfuscated_res_0x7f091e56));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e73, sparseArray4.get(R.id.obfuscated_res_0x7f091e73));
                                                                                                                        kq4Var4.d.setTag(sparseArray7);
                                                                                                                        arrayList.add(kq4Var10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e73, sparseArray4.get(R.id.obfuscated_res_0x7f091e73));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e61, sparseArray4.get(R.id.obfuscated_res_0x7f091e61));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e62, sparseArray4.get(R.id.obfuscated_res_0x7f091e62));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e63, sparseArray4.get(R.id.obfuscated_res_0x7f091e63));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e64, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e6b, sparseArray4.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea6, sparseArray4.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea7, sparseArray4.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea5, sparseArray4.get(R.id.obfuscated_res_0x7f091ea5));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea8, sparseArray4.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea9, sparseArray4.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e56, sparseArray4.get(R.id.obfuscated_res_0x7f091e56));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e58, sparseArray4.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e68, sparseArray4.get(R.id.obfuscated_res_0x7f091e68));
                                                                                                                            if (booleanValue6) {
                                                                                                                                kq4 kq4Var11 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.a.K0);
                                                                                                                                kq4Var11.d.setTag(sparseArray8);
                                                                                                                                kq4Var6 = kq4Var11;
                                                                                                                                kq4Var5 = new kq4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02db), this.a.K0);
                                                                                                                                kq4Var5.d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        kq4Var6 = null;
                                                                                                                        kq4Var5 = new kq4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02db), this.a.K0);
                                                                                                                        kq4Var5.d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e73, sparseArray4.get(R.id.obfuscated_res_0x7f091e73));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e56, sparseArray4.get(R.id.obfuscated_res_0x7f091e56));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e58, sparseArray4.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e68, sparseArray4.get(R.id.obfuscated_res_0x7f091e68));
                                                                                                                        if (this.a.x0.P1().V() == 1002 && !booleanValue) {
                                                                                                                            kq4Var7 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fd0), this.a.K0);
                                                                                                                        } else {
                                                                                                                            kq4Var7 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.a.K0);
                                                                                                                        }
                                                                                                                        kq4Var7.d.setTag(sparseArray9);
                                                                                                                        kq4Var6 = kq4Var7;
                                                                                                                        kq4Var5 = null;
                                                                                                                    } else {
                                                                                                                        kq4Var5 = null;
                                                                                                                        kq4Var6 = null;
                                                                                                                    }
                                                                                                                    if (kq4Var6 != null) {
                                                                                                                        arrayList.add(kq4Var6);
                                                                                                                    }
                                                                                                                    if (kq4Var5 != null) {
                                                                                                                        arrayList.add(kq4Var5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.a.K0.j(arrayList);
                                                                                                                this.a.J0 = new mq4(this.a.getPageContext(), this.a.K0);
                                                                                                                this.a.J0.m();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091e54, this.a.z2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091e6d, Boolean.FALSE);
                                                                                                        kq4Var4.d.setTag(sparseArray62);
                                                                                                        arrayList.add(kq4Var4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.K0.j(arrayList);
                                                                                                        this.a.J0 = new mq4(this.a.getPageContext(), this.a.K0);
                                                                                                        this.a.J0.m();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091661) {
                                                                                                    if (this.a.x0.P1() != null && this.a.x0.P1().O() != null && this.a.x0.P1().O().getActUrl() != null) {
                                                                                                        sk4.o(this.a.getActivity(), this.a.x0.P1().O().getActUrl());
                                                                                                        if (this.a.x0.P1().O().getActInfoType() != 1) {
                                                                                                            if (this.a.x0.P1().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09130f) {
                                                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f091e7f) instanceof String) {
                                                                                                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f091e7f);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.x0.P1().m()).param("tid", this.a.x0.P1().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.x0.P1().Q().equals(str2)) {
                                                                                                            this.a.E0.t3(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916b8) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1375);
                                                                                                        String q = ys4.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            sk4.s(view2.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.E0.L2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f090fc5) {
                                                                                                    if (view2 != null) {
                                                                                                        sk4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.E4() == 1 && this.a.x0 != null && this.a.x0.P1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.x0.P1().m()).param("tid", this.a.x0.P1().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091302) {
                                                                                                    if (view2 != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        sk4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        if (this.a.E4() == 1 && this.a.x0 != null && this.a.x0.P1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.x0.P1().m()).param("tid", this.a.x0.P1().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09135e) {
                                                                                                    this.a.E5();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09135d) {
                                                                                                    this.a.B5();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0924a0) {
                                                                                                    if (this.a.x0 != null && this.a.x0.P1() != null && this.a.x0.P1().A() != null) {
                                                                                                        kp7 P13 = this.a.x0.P1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", P13.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{P13.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09249d) {
                                                                                                    if (this.a.x0 != null && this.a.x0.P1() != null && this.a.x0.P1().A() != null) {
                                                                                                        kp7 P14 = this.a.x0.P1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", P14.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{P14.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0921ca) {
                                                                                                    if (this.a.p1 >= 0) {
                                                                                                        if (this.a.x0 != null) {
                                                                                                            this.a.x0.h3();
                                                                                                        }
                                                                                                        if (this.a.x0 == null || this.a.E0.A0() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            i3 = 0;
                                                                                                            this.a.E0.A0().g0(this.a.x0.P1(), false);
                                                                                                        }
                                                                                                        this.a.p1 = i3;
                                                                                                        if (this.a.x0 != null) {
                                                                                                            this.a.E0.R0().setSelection(this.a.x0.I1());
                                                                                                            this.a.x0.l3(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09198f) {
                                                                                                    if (!this.a.l4(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.n5(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091534) {
                                                                                                    SparseArray sparseArray10 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.H6(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09167e) {
                                                                                                    if (this.a.E0.R0() == null || this.a.x0 == null || this.a.x0.P1() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.E0.R0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.E0.R0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean r0 = this.a.x0.P1().r0();
                                                                                                    boolean z3 = this.a.E0.c1() != null && this.a.E0.c1().g();
                                                                                                    boolean P15 = this.a.E0.P1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!r0 || this.a.E0.c1() == null || this.a.E0.c1().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (li.k(this.a.getContext()) * 0.5625d)) - this.a.E0.c1().e();
                                                                                                        i2 = k;
                                                                                                        z4 = firstVisiblePosition == 0 && (top == k || top == this.a.E0.c1().c().getHeight() - this.a.E0.c1().e());
                                                                                                    }
                                                                                                    this.a.z4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.a.x0.P1().O() != null && this.a.x0.P1().O().getReply_num() <= 0) || (P15 && z4)) {
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.T5();
                                                                                                        if (this.a.x0.P1().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.P1().m()).param("obj_locate", 2).param("uid", this.a.x0.P1().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i8 = (int) (li.i(this.a.getContext()) * 0.6d);
                                                                                                        if (r0) {
                                                                                                            if (this.a.E0.b1 != null && this.a.E0.b1.c != null && this.a.E0.b1.c.b() != null) {
                                                                                                                if (this.a.E0.b1.c.b().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.a.E0.Z0() != null) {
                                                                                                                z2 = this.a.E0.Z0().getVisibility() == 0;
                                                                                                                if (!z2 && this.a.E0.b1 != null && this.a.E0.b1.c != null && this.a.E0.b1.c.b() != null && this.a.E0.b1.c.b().getParent() != null && this.a.E0.h != null && this.a.E0.h.a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || P15) {
                                                                                                            this.a.h0 = firstVisiblePosition;
                                                                                                            this.a.i0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i8))) {
                                                                                                                this.a.E0.R0().setSelectionFromTop(0, i2 - i8);
                                                                                                                this.a.E0.R0().smoothScrollBy(-i8, 500);
                                                                                                            } else {
                                                                                                                this.a.E0.R0().E(0, i2, 500);
                                                                                                            }
                                                                                                        } else if (this.a.h0 > 0) {
                                                                                                            if (this.a.E0.R0().getChildAt(this.a.h0) != null) {
                                                                                                                this.a.E0.R0().E(this.a.h0, this.a.i0, 200);
                                                                                                            } else {
                                                                                                                this.a.E0.R0().setSelectionFromTop(this.a.h0, this.a.i0 + i8);
                                                                                                                this.a.E0.R0().smoothScrollBy(i8, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int d2 = iu7.d(this.a.getListView());
                                                                                                            if (iu7.e(this.a.getListView()) != -1) {
                                                                                                                d2--;
                                                                                                            }
                                                                                                            int f = li.f(this.a.getContext(), R.dimen.tbds100);
                                                                                                            if (d2 < 0) {
                                                                                                                d2 = (ListUtils.getCount(this.a.E0.R0().getData()) - 1) + this.a.E0.R0().getHeaderViewsCount();
                                                                                                                f = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!r0 || this.a.E0.c1() == null) {
                                                                                                                    if (this.a.E0.h != null && this.a.E0.h.a != null) {
                                                                                                                        fixedNavHeight = this.a.E0.h.a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.a.E0.b1 != null || this.a.E0.b1.c == null || this.a.E0.b1.c.b() == null || this.a.E0.b1.c.b().getParent() == null) {
                                                                                                                        this.a.E0.R0().setSelectionFromTop(d2, f + i8);
                                                                                                                        this.a.E0.R0().smoothScrollBy(i8, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.a.E0.R0().E(d2, f, 200);
                                                                                                                    } else {
                                                                                                                        this.a.E0.R0().smoothScrollBy(this.a.E0.b1.c.b().getTop() - ((int) (li.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.E0.c1().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (li.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f += fixedNavHeight;
                                                                                                            if (this.a.E0.b1 != null) {
                                                                                                            }
                                                                                                            this.a.E0.R0().setSelectionFromTop(d2, f + i8);
                                                                                                            this.a.E0.R0().smoothScrollBy(i8, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.x0.P1().O() != null && this.a.x0.P1().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.P1().m()).param("obj_locate", 2).param("uid", this.a.x0.P1().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916dc || id == R.id.obfuscated_res_0x7f0916dd) {
                                                                                                    if (this.a.x0 == null || this.a.x0.P1() == null || this.a.x0.P1().l() == null || ki.isEmpty(this.a.x0.P1().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.x0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.x0.o1()) || this.a.x0.e1() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.x0.e1().b;
                                                                                                    } else {
                                                                                                        name = this.a.x0.P1().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String o1 = this.a.x0.o1();
                                                                                                    if (this.a.x0.u1() && o1 != null && o1.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.x0.P1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.x0.h2());
                                                                                                    statisticItem6.param("fid", this.a.x0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.x0.P1().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.x0.P1().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a49 && id != R.id.obfuscated_res_0x7f090a22 && id != R.id.obfuscated_res_0x7f090a24 && id != R.id.obfuscated_res_0x7f090a23) {
                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.x0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.x0.h2());
                                                                                                        statisticItem7.param("fid", this.a.x0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091703) {
                                                                                                        if (this.a.x0 == null || this.a.x0.P1() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        kp7 P16 = this.a.x0.P1();
                                                                                                        if (this.a.C0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.C0 = new cq7(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g = jg.g(P16.Q(), 0L);
                                                                                                        long g2 = jg.g(P16.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.k2);
                                                                                                        this.a.C0.a(g, g2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091726) {
                                                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                                                            if (!pk5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                sk4.o(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.x0.h2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090deb) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090de8) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                                                        if (this.a.R != null) {
                                                                                                            this.a.R.P(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091692 || id == R.id.obfuscated_res_0x7f0916e8) {
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.x0.h2());
                                                                                                        statisticItem8.param("fid", this.a.x0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.b = false;
                                                                                                        pbFragment5.r4(view2);
                                                                                                    }
                                                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                                                    if (this.a.x0.O1() == 3 && this.a.isSimpleForum() && this.a.x0.P1() != null && ListUtils.isEmpty(this.a.x0.P1().p())) {
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
                                                                                            }
                                                                                        } else {
                                                                                            this.a.E0.h.l();
                                                                                            this.a.E0.S3(this.a.C2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, jg.g(this.a.x0.P1().m(), 0L), jg.g(this.a.x0.h2(), 0L), jg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.x0.P1().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    } catch (ClassCastException e) {
                                                                                        e.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData4 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54);
                                                                                    if (postData4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.K0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.K0 = new oq4(pbFragment6.getContext());
                                                                                        this.a.K0.n(this.a.e2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.v().P1() != null && this.a.v().P1().g0();
                                                                                    if (view2 != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e64) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e64) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                                                                                        if (postData4.q() != null) {
                                                                                            boolean z6 = postData4.q().hasAgree;
                                                                                            int r = postData4.r();
                                                                                            if (z6 && r == 5) {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0085;
                                                                                            } else {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0087;
                                                                                            }
                                                                                            kq4 kq4Var12 = new kq4(8, pbFragment.getString(i), this.a.K0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(R.id.obfuscated_res_0x7f091e54, postData4);
                                                                                            kq4Var12.d.setTag(sparseArray11);
                                                                                            arrayList2.add(kq4Var12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (ev7.h(this.a.x0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.z5(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    kq4 kq4Var13 = new kq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fd0), this.a.K0);
                                                                                                    kq4Var13.d.setTag(str3);
                                                                                                    arrayList2.add(kq4Var13);
                                                                                                }
                                                                                            } else {
                                                                                                kq4 kq4Var14 = new kq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b2f), this.a.K0);
                                                                                                SparseArray sparseArray12 = new SparseArray();
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                                                                                                kq4Var14.d.setTag(sparseArray12);
                                                                                                arrayList2.add(kq4Var14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray13 = new SparseArray();
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e61, sparseArray.get(R.id.obfuscated_res_0x7f091e61));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e64, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                                                                                                    if (booleanValue12) {
                                                                                                        kq4 kq4Var15 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.a.K0);
                                                                                                        kq4Var15.d.setTag(sparseArray13);
                                                                                                        kq4Var2 = kq4Var15;
                                                                                                        kq4Var = new kq4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02db), this.a.K0);
                                                                                                        kq4Var.d.setTag(sparseArray13);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                                                                                                }
                                                                                                kq4Var2 = null;
                                                                                                kq4Var = new kq4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02db), this.a.K0);
                                                                                                kq4Var.d.setTag(sparseArray13);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                                                                                                if (this.a.x0.P1().V() == 1002 && !booleanValue7) {
                                                                                                    kq4Var3 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fd0), this.a.K0);
                                                                                                } else {
                                                                                                    kq4Var3 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.a.K0);
                                                                                                }
                                                                                                kq4Var3.d.setTag(sparseArray14);
                                                                                                kq4Var2 = kq4Var3;
                                                                                                kq4Var = null;
                                                                                            } else {
                                                                                                kq4Var = null;
                                                                                                kq4Var2 = null;
                                                                                            }
                                                                                            if (kq4Var2 != null) {
                                                                                                arrayList2.add(kq4Var2);
                                                                                            }
                                                                                            if (kq4Var != null) {
                                                                                                arrayList2.add(kq4Var);
                                                                                            }
                                                                                        }
                                                                                        this.a.K0.j(arrayList2);
                                                                                        this.a.J0 = new mq4(this.a.getPageContext(), this.a.K0);
                                                                                        this.a.J0.m();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091534) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.x0.h2());
                                                                                    statisticItem10.param("fid", this.a.x0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091690 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.T = view2;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.x0 == null || this.a.x0.P1() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.E0.m0();
                                                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                                                    PostData postData5 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091e70);
                                                                                    PostData postData6 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091e71);
                                                                                    View view3 = (View) sparseArray15.get(R.id.obfuscated_res_0x7f091e72);
                                                                                    if (postData5 == null || view3 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData5.E() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData5.i0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091534) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091690) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String h22 = this.a.x0.h2();
                                                                                    String I2 = postData5.I();
                                                                                    String I3 = postData6 != null ? postData6.I() : "";
                                                                                    int V2 = this.a.x0.P1() != null ? this.a.x0.P1().V() : 0;
                                                                                    this.a.J6();
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a5e) {
                                                                                        AbsPbActivity.e U52 = this.a.U5(I2);
                                                                                        if (this.a.x0 == null || this.a.x0.P1() == null || U52 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h22, I2, "pb", true, false, null, true, null, V2, postData5.U(), this.a.x0.P1().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(U52.a, U52.b, U52.g, U52.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.x0.O1());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.x0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.x0.m2());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.x0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.x0.h1());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.x0.H(), this.a.x0.D(), this.a.x0.E(), this.a.x0.C(), this.a.x0.I());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e U53 = this.a.U5(I2);
                                                                                        if (postData5 == null || this.a.x0 == null || this.a.x0.P1() == null || U53 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h22, I2, "pb", true, false, null, false, I3, V2, postData5.U(), this.a.x0.P1().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(U53.a, U53.b, U53.g, U53.j);
                                                                                        if (!ki.isEmpty(I3)) {
                                                                                            addBigImageData3.setHighLightPostId(I3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.x0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.x0.H(), this.a.x0.D(), this.a.x0.E(), this.a.x0.C(), this.a.x0.I());
                                                                                        addBigImageData3.setBjhData(this.a.x0.h1());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.x0.O1());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.x0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.x0.m2());
                                                                                        if (this.a.E0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.E0.I0(this.a.x0.G, this.a.x0.f2()).Q || postData5.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.x0.P1().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (ji.z()) {
                                                                            SparseArray<Object> S02 = this.a.E0.S0(this.a.x0.P1(), this.a.x0.f2(), 1);
                                                                            if (S02 != null) {
                                                                                this.a.E0.t2(((Integer) S02.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) S02.get(R.id.obfuscated_res_0x7f091e56), ((Integer) S02.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) S02.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                                                                            }
                                                                            this.a.E0.h.k();
                                                                            if (this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().O() != null) {
                                                                                ThreadData O = this.a.v().P1().O();
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
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                                                            return;
                                                                        }
                                                                    } else if (ji.z()) {
                                                                        this.a.E0.m0();
                                                                        SparseArray<Object> S03 = this.a.E0.S0(this.a.x0.P1(), this.a.x0.f2(), 1);
                                                                        if (S03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.P1().l().getId(), this.a.x0.P1().l().getName(), this.a.x0.P1().O().getId(), String.valueOf(this.a.x0.P1().U().getUserId()), (String) S03.get(R.id.obfuscated_res_0x7f091e61), (String) S03.get(R.id.obfuscated_res_0x7f091e62), (String) S03.get(R.id.obfuscated_res_0x7f091e64), (String) S03.get(R.id.obfuscated_res_0x7f091e63))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
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
                                                            } else if (this.a.x0 == null || this.a.x0.P1() == null || this.a.x0.P1().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.E0.h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.i5(pbFragment7.x0.P1().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.E0.m0();
                                                            if (ji.z()) {
                                                                if (this.a.i) {
                                                                    view2.setTag(Integer.valueOf(this.a.x0.d2()));
                                                                    return;
                                                                }
                                                                this.a.J6();
                                                                this.a.E0.p3();
                                                                mq4 mq4Var = new mq4(this.a.getPageContext());
                                                                if (this.a.x0.P1().f == null || this.a.x0.P1().f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11c0), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11c1)};
                                                                } else {
                                                                    strArr = new String[this.a.x0.P1().f.size()];
                                                                    for (int i9 = 0; i9 < this.a.x0.P1().f.size(); i9++) {
                                                                        strArr[i9] = this.a.x0.P1().f.get(i9).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11be);
                                                                    }
                                                                }
                                                                mq4Var.j(null, strArr, new a(this, mq4Var, view2));
                                                                mq4Var.m();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.E0.m0();
                                                        if (this.a.v().P1().g != 2) {
                                                            if (this.a.x0.N1() != null) {
                                                                this.a.E0.Z3(this.a.x0.N1(), this.a.d2);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f086c);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (P1 = this.a.x0.P1()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = P1.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", P1.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.isBJHArticleThreadType()) {
                                                            i4 = 2;
                                                        } else if (O2.isBJHVideoThreadType()) {
                                                            i4 = 3;
                                                        } else if (O2.isBJHNormalThreadType()) {
                                                            i4 = 4;
                                                        } else if (O2.isBJHVideoDynamicThreadType()) {
                                                            i4 = 5;
                                                        }
                                                        StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem14.param("tid", this.a.x0.h2());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.x0.getForumId());
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091cb6) {
                                                            statisticItem14.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem14.param("obj_locate", 6);
                                                        }
                                                        statisticItem14.param("obj_name", i4);
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
                                                                int i10 = O2.threadType;
                                                                if (i10 == 0) {
                                                                    statisticItem14.param("obj_type", 1);
                                                                } else if (i10 == 40) {
                                                                    statisticItem14.param("obj_type", 2);
                                                                } else if (i10 == 49) {
                                                                    statisticItem14.param("obj_type", 3);
                                                                } else if (i10 == 54) {
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
                                                            if (O2.getBaijiahaoData() != null && !ki.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.w() != null) {
                                                            e75.e(this.a.w(), statisticItem14);
                                                        }
                                                        if (this.a.E0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.E0.N0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (li.D()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                                                            return;
                                                        } else if (P1 != null) {
                                                            ArrayList<PostData> F2 = this.a.x0.P1().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.x0.f2()) {
                                                                this.a.E0.m0();
                                                                this.a.J6();
                                                                if (P1.A() != null && !StringUtils.isNull(P1.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.x0.P1().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.E0 != null) {
                                                                    this.a.E0.o0();
                                                                    this.a.E0.l4(P1);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.E0.L3();
                                                                    this.a.x0.j1().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091681) {
                                                                        i5 = 2;
                                                                    } else {
                                                                        i5 = view2.getId() == R.id.obfuscated_res_0x7f091cb6 ? 1 : 6;
                                                                    }
                                                                    if ((!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) || !this.a.E0.T1() || P1.j0()) {
                                                                        this.a.D6(i5);
                                                                    } else if (UbsABTestHelper.isPbSharePathTestA()) {
                                                                        this.a.D6(i5);
                                                                    } else if (xx4.c() > 0) {
                                                                        this.a.n6();
                                                                    } else {
                                                                        int N0 = this.a.E0.N0();
                                                                        this.a.E0.b0();
                                                                        this.a.m5(xx4.a(), N0);
                                                                    }
                                                                }
                                                            } else {
                                                                li.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                                                                return;
                                                            }
                                                        } else {
                                                            li.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                                                            return;
                                                        }
                                                    }
                                                    i4 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.x0.h2());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.x0.getForumId());
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091cb6) {
                                                    }
                                                    statisticItem142.param("obj_name", i4);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.w() != null) {
                                                    }
                                                    if (this.a.E0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (li.D()) {
                                                    }
                                                }
                                            } else if (ji.z()) {
                                                this.a.E0.m0();
                                                if (this.a.E0.h.n() != null && view2 == this.a.E0.h.n().k() && !this.a.E0.R1()) {
                                                    this.a.E0.L2();
                                                }
                                                if (!this.a.i) {
                                                    this.a.J6();
                                                    this.a.E0.p3();
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0909cb) {
                                                        F3 = this.a.x0.F3(true, this.a.I4());
                                                    } else {
                                                        F3 = view2.getId() == R.id.obfuscated_res_0x7f091a5b ? this.a.x0.F3(false, this.a.I4()) : this.a.x0.E3(this.a.I4());
                                                    }
                                                    view2.setTag(Boolean.valueOf(F3));
                                                    if (F3) {
                                                        i6 = 1;
                                                        this.a.E0.Z2(true);
                                                        this.a.E0.V3();
                                                        this.a.i = true;
                                                        this.a.E0.d3(true);
                                                    } else {
                                                        i6 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i6, new Object[0]);
                                                } else {
                                                    view2.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (ji.z()) {
                                            this.a.E0.m0();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f09167c || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.l4(11009) || this.a.x0.f1(this.a.E0.Q0()) == null) {
                                                    return;
                                                }
                                                this.a.I5();
                                                if (this.a.x0.P1() != null && this.a.x0.P1().O() != null && this.a.x0.P1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.x0.b).param("fid", this.a.x0.P1().m()).param("obj_locate", 3).param("uid", this.a.x0.P1().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.x0.P1().O() != null && this.a.x0.P1().O().getAuthor() != null && this.a.x0.P1().O().getAuthor().getUserId() != null && this.a.z0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int c5 = pbFragment8.c5(pbFragment8.x0.P1());
                                                    ThreadData O3 = this.a.x0.P1().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i7 = 2;
                                                    } else if (!O3.isBJHVideoThreadType()) {
                                                        if (O3.isBJHNormalThreadType()) {
                                                            i7 = 4;
                                                        } else {
                                                            i7 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 1).param("obj_id", this.a.x0.P1().O().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", c5).param("obj_param1", i7));
                                                }
                                            } else {
                                                this.a.V = view2;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.x0.P1() != null && this.a.x0.P1().O() != null && this.a.x0.P1().O().isVideoThreadType() && this.a.x0.P1().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.x0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.x0.o1()) || this.a.x0.e1() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.x0.e1().b;
                                        } else {
                                            name2 = this.a.x0.P1().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String o12 = this.a.x0.o1();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.x0.u1() && o12 != null && o12.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (ji.z()) {
                                    if (this.a.x0.P1() == null || this.a.A0.R()) {
                                        return;
                                    }
                                    this.a.E0.m0();
                                    int i11 = (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().o()) ? (this.a.E0.h.n() == null || view2 != this.a.E0.h.n().n()) ? view2 == this.a.E0.C0() ? 2 : 0 : this.a.x0.P1().O().getIs_good() == 1 ? 3 : 6 : this.a.x0.P1().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.x0.P1().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.x0.P1().O().getId();
                                    this.a.E0.e4();
                                    this.a.A0.V(id2, name3, id3, i11, this.a.E0.D0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                    return;
                                }
                            } else {
                                this.a.E0.h.l();
                                if (this.a.x0 != null) {
                                    this.a.u1.f(this.a.x0.h2());
                                }
                                if (this.a.x0 == null || !this.a.x0.isPrivacy()) {
                                    this.a.u1.b();
                                    int i12 = (TbSingleton.getInstance().mCanCallFans || this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().Q() == null || !this.a.v().P1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.v() != null && this.a.v().P1() != null) {
                                        this.a.u1.d(3, i12, this.a.v().P1().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0eee);
                                    if (this.a.v() == null || this.a.v().P1() == null) {
                                        return;
                                    }
                                    this.a.u1.d(3, 3, this.a.v().P1().Q());
                                    return;
                                }
                            }
                        } else if (ji.z()) {
                            this.a.E0.m0();
                            this.a.J6();
                            this.a.E0.p3();
                            this.a.E0.L3();
                            if (this.a.E0.Z0() != null) {
                                this.a.E0.Z0().setVisibility(8);
                            }
                            this.a.x0.A3(1);
                            if (this.a.e != null) {
                                this.a.e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                            return;
                        }
                    } else {
                        String str4 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a48);
                        String str5 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a33);
                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f091f95);
                        if (this.a.R != null) {
                            this.a.R.P(str4, str5);
                        }
                        TbPageTag l2 = e75.l(this.a.getContext());
                        gv7.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbe).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091a4e) {
                        String H4 = this.a.H4();
                        if (TextUtils.isEmpty(H4)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{H4});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.x0.h2());
                statisticItem15.param("fid", this.a.x0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                if (this.a.w) {
                    this.a.w = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091e54);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.a.x0 == null || this.a.x0.P1() == null || this.a.Z4().a1() == null || postData7.s() == null || postData7.A() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.Z4().b1() != null) {
                            this.a.Z4().b1().c();
                        }
                        aq7 aq7Var2 = new aq7();
                        aq7Var2.A(this.a.x0.P1().l());
                        aq7Var2.E(this.a.x0.P1().O());
                        aq7Var2.C(postData7);
                        this.a.Z4().a1().U(aq7Var2);
                        this.a.Z4().a1().setPostId(postData7.I());
                        this.a.F5(view2, postData7.s().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        ew7.b(this.a.x0.P1(), postData7, postData7.h0, 8, 1);
                        if (this.a.T0 != null) {
                            this.a.E0.T2(this.a.T0.C());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ dq4 b;
        public final /* synthetic */ PbFragment c;

        public f2(PbFragment pbFragment, MarkData markData, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, dq4Var};
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
            this.b = dq4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.E0 != null && this.c.E0.m1() != null) {
                    this.c.E0.m1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.K6();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f3 {
    }

    /* loaded from: classes3.dex */
    public class g extends mc5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public g(PbFragment pbFragment, int i) {
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
        @Override // com.repackage.mc5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel v = this.b.v();
                if (v != null) {
                    v.o3(this.a);
                }
                return fv7.d(this.b.E4(), 2, v);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g0 extends b55<TipEvent> {
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
        @Override // com.repackage.u45
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.c.a.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.x0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.x0.b)) {
                this.a.C6((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g2 implements u15 {
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

        @Override // com.repackage.u15
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qt7 qt7Var = this.a.I0;
                if (qt7Var == null || qt7Var.g() == null || !this.a.I0.g().d()) {
                    return !this.a.o4(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.I0.g().c());
                if (this.a.E0 != null && this.a.E0.b1() != null && this.a.E0.b1().b() != null && this.a.E0.b1().b().x()) {
                    this.a.E0.b1().b().v(this.a.I0.h());
                }
                this.a.I0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements tb5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public h(PbFragment pbFragment, int i, int i2) {
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
        @Override // com.repackage.tb5
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

    /* loaded from: classes3.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public h0(PbFragment pbFragment, Intent intent) {
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
                ot7 ot7Var = this.b.E0;
                ot7Var.s3("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ h1 b;

            public a(h1 h1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = h1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.E0 == null || this.a == null) {
                    return;
                }
                this.b.a.E0.x2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(h1 h1Var) {
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
                    }
                }
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h1 a;

            public c(h1 h1Var) {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ww4Var, writeData, antiData}) == null) {
                if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0.P1() != null) {
                        statisticItem.param("fid", this.a.x0.P1().m());
                    }
                    statisticItem.param("tid", this.a.x0.h2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (ki.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.J6();
                this.a.E0.n3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.T0.B() || this.a.T0.D()) {
                            this.a.T0.z(false, postWriteCallBackData);
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
                        if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0475), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        dq4 dq4Var = new dq4(this.a.getActivity());
                        if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                            dq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce8));
                        } else {
                            dq4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new c(this));
                        dq4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (zn8.d(i) || ww4Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.o6(i, antiData, str);
                        return;
                    }
                }
                this.a.C6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.p6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.x0.s1()) {
                        kp7 P1 = this.a.x0.P1();
                        if (P1 != null && P1.O() != null && P1.O().getAuthor() != null && (userId = P1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.x0.D3()) {
                            this.a.E0.p3();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.x0.D3()) {
                        this.a.E0.p3();
                    }
                } else if (floor != null) {
                    this.a.E0.F1(this.a.x0.P1());
                }
                if (this.a.x0.w1()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.x0.h2()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    mg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.h4(z2);
                if (writeData != null) {
                    ku4.b(writeData.getContent(), "1");
                }
                if (this.a.s5()) {
                    this.a.M6();
                }
                this.a.A6();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h2 implements bg<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
                    if (am4.c().g()) {
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
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = am4.c().g();
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
                    foreDrawableImageView.G();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.x0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.T0 != null) {
                this.a.E0.T2(this.a.T0.C());
            }
            this.a.E0.L2();
            this.a.E0.m0();
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.T0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.E0 != null && this.a.E0.b1() != null && this.a.E0.b1().b() != null) {
                    this.a.E0.b1().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.a;
                    pbFragment.d6(pbFragment.Z0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ i1 b;

            public a(i1 i1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = i1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.E0 == null || this.a == null) {
                    return;
                }
                this.b.a.E0.x2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(i1 i1Var) {
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
                    }
                }
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            public c(i1 i1Var) {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ww4Var, writeData, antiData}) == null) {
                if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.x0 != null && this.a.x0.P1() != null) {
                        statisticItem.param("fid", this.a.x0.P1().m());
                    }
                    if (this.a.x0 != null) {
                        statisticItem.param("tid", this.a.x0.h2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    qt7 qt7Var = this.a.I0;
                    if (qt7Var != null) {
                        qt7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        dy4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        ku4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        mg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.s5()) {
                        this.a.M6();
                    }
                    this.a.A6();
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
                    if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0475), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    dq4 dq4Var = new dq4(this.a.getActivity());
                    if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                        dq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce8));
                    } else {
                        dq4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                    dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new c(this));
                    dq4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.I0 == null) {
                    return;
                }
                if (pbFragment.E0 != null && this.a.E0.b1() != null && this.a.E0.b1().b() != null && this.a.E0.b1().b().x()) {
                    this.a.E0.b1().b().v(postWriteCallBackData);
                }
                this.a.I0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i2 implements bg<GifView> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
                if (am4.c().g()) {
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
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = am4.c().g();
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.x0.I3((UserPendantData) customResponsedMessage.getData());
                if (this.a.E0 != null && this.a.x0 != null) {
                    this.a.E0.E2(this.a.x0.P1(), this.a.x0.f2(), this.a.x0.Z1(), this.a.E0.i1());
                }
                if (this.a.E0 == null || this.a.E0.A0() == null) {
                    return;
                }
                this.a.E0.A0().Z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements CheckRealNameModel.b {
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

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                this.a.E0.s1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.a.D6(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        nq6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j1 extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(PbFragment pbFragment, int i, int i2) {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView k1;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    li.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f13d4);
                    if (this.a.E0 == null || (k1 = this.a.E0.k1()) == null || this.a.E0.R0() == null) {
                        return;
                    }
                    this.a.E0.R0().removeHeaderView(k1);
                    return;
                }
                li.O(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j2 implements bg<TiebaPlusRecommendCard> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.q();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
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
                tiebaPlusRecommendCard.q();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.E0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.E0.V3();
            } else {
                this.a.E0.u1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k0 extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k1 implements v15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.repackage.v15
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k2 implements bg<View> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.getVoiceManager());
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.T0 != null) {
                this.a.E0.T2(this.a.T0.C());
            }
            this.a.E0.D3(false);
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements e3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ji.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.x0.P1().l().getId(), this.a.x0.P1().l().getName(), this.a.x0.P1().O().getId(), String.valueOf(this.a.x0.P1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l1 implements PbModel.h {
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.a.n : j;
                if (this.a.o == 0) {
                    this.a.o = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                a85 a85Var = new a85(i, z, responsedMessage, this.a.r, this.a.q, this.a.o, z2, 0L, 0L, j3);
                this.a.q = 0L;
                this.a.r = 0L;
                a85Var.c();
                if (z2) {
                    j2 = j3;
                    a85Var.B = j2;
                    a85Var.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.x0 == null || this.a.x0.P1() == null || this.a.x0.P1().O() == null) {
                    return;
                }
                int threadType = this.a.x0.P1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.M, "from_personalize")) {
                        if (StringHelper.equals(this.a.M, "from_frs")) {
                            a85 a85Var2 = new a85();
                            a85Var2.a(1000);
                            a85Var2.D = j2;
                            a85Var2.d(threadType);
                            return;
                        }
                        return;
                    }
                    w75 w75Var = new w75();
                    w75Var.F = 1;
                    w75Var.a(1005);
                    w75Var.D = j2;
                    w75Var.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(kp7 kp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp7Var) == null) {
                this.a.E0.F1(kp7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, kp7 kp7Var, String str, int i4) {
            zz4 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), kp7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906b0));
                }
                if (!z || kp7Var == null || kp7Var.W() != null || ListUtils.getCount(kp7Var.F()) >= 1) {
                    if (!this.a.n0) {
                        this.a.n0 = true;
                    } else if (this.a.v() != null) {
                        this.a.v().W0();
                    }
                    this.a.h = true;
                    this.a.E0.o3();
                    if (kp7Var == null || !kp7Var.m0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.E0.m1());
                    }
                    this.a.E0.u1();
                    if (this.a.J || this.a.E0.R1()) {
                        this.a.E0.o1();
                    } else if (!this.a.E0.K1()) {
                        this.a.E0.D3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && kp7Var != null) {
                        this.a.M0 = true;
                    }
                    if (kp7Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.E0.m1());
                        this.a.E0.y3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String e1 = null;
                    arrayList = null;
                    if (z && kp7Var != null) {
                        ThreadData O = kp7Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.j6(pbFragment3.S0);
                        }
                        this.a.E0.b1().m(kp7Var);
                        this.a.E0.K3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.Q6(O.getCartoonThreadData());
                        }
                        if (this.a.T0 != null) {
                            this.a.E0.T2(this.a.T0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(kp7Var.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(kp7Var.U().getBimg_end_time());
                        if (kp7Var.F() != null && kp7Var.F().size() >= 1 && kp7Var.F().get(0) != null) {
                            this.a.x0.m3(kp7Var.F().get(0).I());
                        } else if (kp7Var.W() != null) {
                            this.a.x0.m3(kp7Var.W().I());
                        }
                        if (this.a.T0 != null) {
                            this.a.T0.M(kp7Var.d());
                            this.a.T0.N(kp7Var.l(), kp7Var.U());
                            this.a.T0.r0(O);
                            this.a.T0.O(this.a.x0.r1(), this.a.x0.h2(), this.a.x0.n1());
                            if (O != null) {
                                this.a.T0.h0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.z0 != null) {
                            this.a.z0.h(kp7Var.r());
                        }
                        if (kp7Var.s() == 1) {
                            this.a.s = true;
                        } else {
                            this.a.s = false;
                        }
                        if (kp7Var.g0()) {
                            this.a.s = true;
                        }
                        this.a.E0.U2(this.a.s);
                        if (this.a.u0.f.size() > 0) {
                            kp7Var.L0(this.a.u0.f);
                        }
                        this.a.E0.O3(kp7Var, i2, i3, this.a.x0.f2(), i4, this.a.x0.y1());
                        this.a.E0.c4(kp7Var, this.a.x0.f2());
                        this.a.E0.h4(this.a.x0.s1());
                        AntiData d = kp7Var.d();
                        if (d != null) {
                            this.a.z = d.getVoice_message();
                            if (!StringUtils.isNull(this.a.z) && this.a.T0 != null && this.a.T0.a() != null && (m = this.a.T0.a().m(6)) != null && !TextUtils.isEmpty(this.a.z)) {
                                ((View) m).setOnClickListener(this.a.H1);
                            }
                        }
                        if (!this.a.Y && !ListUtils.isEmpty(this.a.x0.P1().F()) && !this.a.x0.y2()) {
                            this.a.Y = true;
                            this.a.j4(false);
                        }
                        if (TextUtils.isEmpty(this.a.P0)) {
                            if (this.a.O0) {
                                this.a.O0 = false;
                                iu7.g(this.a.getListView());
                            } else if (this.a.Q0) {
                                this.a.Q0 = false;
                                iu7.j(this.a.getListView());
                            } else if (!TextUtils.isEmpty(this.a.x0.F1())) {
                                iu7.f(this.a.getListView(), this.a.x0.F1());
                                this.a.x0.G2();
                            } else {
                                this.a.E0.J3();
                            }
                        } else {
                            iu7.i(this.a.x0.O1(), this.a.getListView(), this.a.P0);
                            this.a.P0 = null;
                        }
                        this.a.x0.H2(kp7Var.l(), this.a.L1);
                        this.a.x0.N2(this.a.O1);
                        if (this.a.W0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.W0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.x0 == null || !this.a.x0.v2()) {
                            if (this.a.E0 != null) {
                                e1 = this.a.E0.e1();
                            }
                        } else {
                            e1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde);
                        }
                        if (!StringUtils.isNull(e1)) {
                            this.a.T0.k0(TbSingleton.getInstance().getAdVertiComment(kp7Var.k0(), kp7Var.l0(), e1));
                        }
                    } else if (str != null) {
                        if (this.a.M0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.x0.e1() != null && !StringUtils.isNull(this.a.x0.e1().c)) {
                                    this.a.E0.j4(this.a.x0.e1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.E0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c32, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(li.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702ad));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.E0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c32, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(li.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702ad));
                            }
                            this.a.E0.o1();
                            this.a.E0.n1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.x0.h2());
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
                            if (this.a.x0 != null && this.a.x0.P1() != null) {
                                arrayList = this.a.x0.P1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.E0.P2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f6));
                            } else {
                                if (this.a.u5()) {
                                    this.a.E0.Q2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcf));
                                } else {
                                    this.a.E0.Q2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd0));
                                }
                                this.a.E0.F1(this.a.x0.P1());
                            }
                        } else {
                            this.a.E0.P2("");
                        }
                        this.a.E0.u0();
                    }
                    if (kp7Var != null && kp7Var.m && this.a.o == 0) {
                        this.a.o = System.currentTimeMillis() - this.a.n;
                    }
                    if (!this.a.v().f2() || this.a.v().P1().y().c() != 0 || this.a.v().s2()) {
                        this.a.U0 = true;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).logOnPbDataSet(kp7Var != null ? kp7Var.g() : 0, this.a.E0);
                        return;
                    }
                    return;
                }
                this.a.x0.A3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.E0 != null) {
                    this.a.E0.W3();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.x0 == null) {
                return;
            }
            if (this.a.T0 == null || !this.a.T0.v) {
                w15 w15Var = new w15();
                this.a.j6(w15Var);
                PbFragment pbFragment = this.a;
                pbFragment.T0 = (x15) w15Var.a(pbFragment.getContext());
                this.a.T0.e0(this.a.a.getPageContext());
                this.a.T0.n0(this.a.i2);
                this.a.T0.o0(this.a.a1);
                this.a.T0.F(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.T0.a().C(true);
                this.a.E0.O2(this.a.T0.a());
                if (!this.a.x0.C1()) {
                    this.a.T0.s(this.a.x0.h2());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.T0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.x0.v2()) {
                    this.a.T0.k0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde));
                } else if (this.a.E0 != null) {
                    this.a.T0.k0(this.a.E0.e1());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l2 implements bg<RelativeLayout> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            qo7 qo7Var = (qo7) customResponsedMessage.getData();
            int type = qo7Var.getType();
            if (type == 0) {
                this.a.Y5((aq7) qo7Var.a());
            } else if (type == 1) {
                this.a.A4((ForumManageModel.b) qo7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (qo7Var.a() == null) {
                    this.a.X5(false, null);
                } else {
                    this.a.X5(true, (MarkData) qo7Var.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements mq7.a {
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

        @Override // com.repackage.mq7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.mq7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a78) {
                            if (this.a.c6(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09168f) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e67) instanceof SparseArray) {
                                this.a.H6((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091e67));
                            }
                        } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f0916e7) {
                            if (this.a.E0.M1() && view2.getId() == R.id.obfuscated_res_0x7f0916ad) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f091ea3) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f091ea3)));
                                }
                                if (this.a.getEventController() != null && this.a.getEventController().b != null) {
                                    this.a.getEventController().b.onClick(view2);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.H6(sparseArray);
                        }
                    }
                    if (this.a.T0 != null) {
                        this.a.E0.T2(this.a.T0.C());
                    }
                    this.a.E0.L2();
                    this.a.E0.m0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.mq7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.x4((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
                this.a.P6();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m2 implements bg<ItemCardView> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.E0 == null || this.a.E0.A0() == null) {
                return;
            }
            this.a.E0.A0().Z();
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements fq4.c {
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

        @Override // com.repackage.fq4.c
        public void a(fq4 fq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fq4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.L0 = pbFragment.L0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new tr7(this.a.x0.h2(), this.a.L0, "1").start();
                    fq4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.L0 = pbFragment2.L0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new tr7(this.a.x0.h2(), this.a.L0, "2").start();
                    fq4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.L0 = pbFragment3.L0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.L0);
                    fq4Var.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n1(PbFragment pbFragment, int i, boolean z) {
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
                    pbFragment.hideLoadingView(pbFragment.E0.m1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f031b));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.k6(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n2 implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            yr7 A0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.E0.g2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.x0.h2());
                    statisticItem.param("fid", this.a.x0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.x0.G.g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i3 = -1;
                            if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().C() == null) {
                                i2 = -1;
                            } else {
                                ArrayList<TbRichTextImageInfo> C = tbRichTextView.getRichText().C();
                                int i4 = 0;
                                int i5 = -1;
                                while (i4 < C.size()) {
                                    if (C.get(i4) != null) {
                                        arrayList.add(C.get(i4).E());
                                        if (i5 == i3 && str != null && (str.equals(C.get(i4).E()) || str.equals(C.get(i4).A()) || str.equals(C.get(i4).y()) || str.equals(C.get(i4).z()) || str.equals(C.get(i4).C()))) {
                                            i5 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = C.get(i4).E();
                                        imageUrlData.originalUrl = C.get(i4).E();
                                        imageUrlData.isLongPic = C.get(i4).H();
                                        concurrentHashMap.put(C.get(i4).E(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = -1;
                                }
                                i2 = i5;
                            }
                            Rect rect = new Rect();
                            view2.getGlobalVisibleRect(rect);
                            this.a.C4(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i2);
                            bVar.C(false);
                            bVar.F(this.a.x0.a2());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.a.u5());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view2));
                            if (this.a.x0 != null) {
                                bVar.A(this.a.x0.getFromForumId());
                                if (this.a.x0.P1() != null) {
                                    bVar.N(this.a.x0.P1().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.S5(str, i, eVar);
                        if (eVar.h) {
                            TbRichText S6 = this.a.S6(str, i);
                            if (S6 != null && this.a.w2 >= 0 && this.a.w2 < S6.A().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = lp7.a(S6.A().get(this.a.w2));
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
                                if (S6.getPostId() != 0 && (A0 = this.a.E0.A0()) != null) {
                                    ArrayList<jn> s = A0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<jn> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            jn next = it.next();
                                            if ((next instanceof PostData) && S6.getPostId() == jg.g(((PostData) next).I(), 0L)) {
                                                ew7.b(this.a.x0.P1(), (PostData) next, ((PostData) next).h0, S6.getPostId() == jg.g(this.a.x0.n1(), 0L) ? 1 : 8, 3);
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
                                this.a.C4(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.c);
                                bVar2.y(eVar.d);
                                bVar2.O(eVar.e);
                                bVar2.C(eVar.g);
                                bVar2.H(true);
                                bVar2.J(eVar.i);
                                bVar2.F(this.a.x0.a2());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.a.u5());
                                bVar2.L(eVar.f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                                if (this.a.x0 != null) {
                                    bVar2.A(this.a.x0.getFromForumId());
                                    if (this.a.x0.P1() != null) {
                                        bVar2.N(this.a.x0.P1().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.c);
                        bVar3.y(eVar.d);
                        bVar3.O(eVar.e);
                        bVar3.C(eVar.g);
                        bVar3.H(true);
                        bVar3.J(eVar.a.get(0));
                        bVar3.F(this.a.x0.a2());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.a.u5());
                        bVar3.L(eVar.f);
                        bVar3.D(false);
                        if (this.a.x0 != null) {
                            bVar3.A(this.a.x0.getFromForumId());
                            if (this.a.x0.P1() != null) {
                                bVar3.N(this.a.x0.P1().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
                    boolean x = ((TbImageView) view2).x();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, x)));
                    }
                    this.a.S = view2;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof se5.a)) {
                se5.a aVar = (se5.a) customResponsedMessage.getData();
                se5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.x0 != null && this.a.x0.A1()) {
                    this.a.G5();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o1 implements kk4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.repackage.kk4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.E0.o3();
                if (z) {
                    if (this.a.z0 != null) {
                        this.a.z0.h(z2);
                    }
                    this.a.x0.C3(z2);
                    if (this.a.x0.A1()) {
                        this.a.G5();
                    } else {
                        this.a.E0.F1(this.a.x0.P1());
                    }
                    if (z2) {
                        boolean j0 = this.a.x0.P1().j0();
                        if (this.a.z0 != null && !j0) {
                            if (this.a.z0.f() == null || this.a.x0 == null || this.a.x0.P1() == null || this.a.x0.P1().O() == null || this.a.x0.P1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.z0.f();
                            MetaData author = this.a.x0.P1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.w6(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                    this.a.B6();
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.f4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fad));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14cc));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o2 implements fq4.c {
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

        @Override // com.repackage.fq4.c
        public void a(fq4 fq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fq4Var, i, view2) == null) {
                if (fq4Var != null) {
                    fq4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.z2;
                if (postData != null) {
                    if (i == 0) {
                        postData.o0();
                        this.a.z2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.K5(pbFragment2.z2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g) {
                return;
            }
            this.a.G6();
        }
    }

    /* loaded from: classes3.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
                this.a.E0.s1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                kp7 P1 = this.a.x0.P1();
                if (P1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.c(this.a.f1.getResources().getString(R.string.obfuscated_res_0x7f0f0b30));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.f1.getResources().getString(R.string.obfuscated_res_0x7f0f0b2c);
                    }
                    this.a.E6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.x6();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ki.isEmpty(errorString2)) {
                        errorString2 = this.a.f1.getResources().getString(R.string.obfuscated_res_0x7f0f0b2d);
                    }
                    this.a.g1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public p1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p2 implements fq4.c {
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

        @Override // com.repackage.fq4.c
        public void a(fq4 fq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fq4Var, i, view2) == null) {
                if (fq4Var != null) {
                    fq4Var.e();
                }
                if (this.a.k1 == null || TextUtils.isEmpty(this.a.l1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.n1 == null) {
                        this.a.g4();
                    } else {
                        v25.a aVar = new v25.a();
                        aVar.a = this.a.l1;
                        String str = "";
                        if (this.a.n1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.n1.memeInfo.pck_id;
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
                    if (this.a.j1 == null) {
                        PbFragment pbFragment = this.a;
                        pbFragment.j1 = new st7(pbFragment.getPageContext());
                    }
                    this.a.j1.b(this.a.l1, this.a.k1.n());
                }
                this.a.k1 = null;
                this.a.l1 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0cb8));
                bdTopToast.j((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                this.a.E0.s1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.c(this.a.f1.getResources().getString(R.string.obfuscated_res_0x7f0f14a5));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ki.isEmpty(muteMessage)) {
                    muteMessage = this.a.f1.getResources().getString(R.string.obfuscated_res_0x7f0f14a4);
                }
                this.a.g1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q1 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public q1(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                dq4Var.dismiss();
                this.b.B0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.x0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.x0 == null || this.a.x0.Y1() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.h6(pbFragment.X4(i));
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin() && this.a.z0 != null && !this.a.z0.e()) {
                        this.a.I5();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.s5() || this.a.a == null || this.a.a.getPbModel() == null || !str.equals(this.a.a.getPbModel().getTopicId())) {
                    return;
                }
                this.a.N6(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.x0 == null || this.a.x0.P1() == null || this.a.E0 == null || this.a.E0.A0() == null) {
                return;
            }
            this.a.E0.n2(absListView, i, i2, i3);
            if (this.a.e != null) {
                this.a.e.q(absListView, i, i2, i3);
            }
            if (!this.a.x0.z2() || (F = this.a.x0.P1().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i + i2) - this.a.E0.A0().w()) - 1;
            kp7 P1 = this.a.x0.P1();
            if (P1 == null) {
                return;
            }
            if (P1.D() != null && P1.D().M0()) {
                w--;
            }
            if (P1.E() != null && P1.E().M0()) {
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
                if (!pbFragment.y5(pbFragment.d1) && this.a.y5(i)) {
                    if (this.a.E0 != null) {
                        this.a.s0 = true;
                        this.a.E0.m0();
                        if (this.a.T0 != null && !this.a.E0.H1()) {
                            this.a.E0.T2(this.a.T0.C());
                        }
                        if (!this.a.J) {
                            this.a.s0 = true;
                            this.a.E0.L2();
                        }
                    }
                    if (!this.a.t) {
                        this.a.t = true;
                    }
                }
                if (this.a.E0 != null) {
                    this.a.E0.o2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.u == null) {
                    this.a.u = new u75();
                    this.a.u.a(1001);
                }
                if (i == 0) {
                    this.a.u.e();
                    if (this.a.o0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.o0);
                        this.a.o0 = null;
                    }
                } else {
                    if (this.a.o0 == null) {
                        this.a.o0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.u.d();
                }
                this.a.d1 = i;
                if (i == 0) {
                    this.a.f6(false, null);
                    bf8.g().h(this.a.getUniqueId(), true);
                    this.a.j4(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r2 implements d3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.E0 != null && this.a.E0.b1() != null) {
                    ks7 b1 = this.a.E0.b1();
                    if (b1.f()) {
                        b1.d();
                        return true;
                    }
                }
                if (this.a.E0 == null || !this.a.E0.U1()) {
                    return false;
                }
                this.a.E0.w1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements TiePlusEventController.f {
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

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w = true;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof co8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                co8 co8Var = (co8) customResponsedMessage.getData();
                this.a.E0.s1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.e1;
                DataRes dataRes = co8Var.a;
                if (co8Var.c == 0 && dataRes != null) {
                    int e = jg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (ki.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea4, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea4, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e67)).intValue();
                if (intValue == 0) {
                    this.a.y6(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.E0.u2(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s1 implements Comparator<ry4> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ry4 ry4Var, ry4 ry4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ry4Var, ry4Var2)) == null) ? ry4Var.compareTo(ry4Var2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class s2 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.r4(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class t implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.z);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E0.H1() && (customResponsedMessage.getData() instanceof MotionEvent)) {
                MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
                this.a.x4((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t1 implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yn4)) {
                yn4 yn4Var = (yn4) customResponsedMessage.getData();
                ro4.a aVar = new ro4.a();
                int i = yn4Var.a;
                String str = yn4Var.b;
                aVar.a = yn4Var.d;
                kp7 P1 = this.a.x0.P1();
                if (P1 == null) {
                    return;
                }
                if (this.a.x0.r1() != null && this.a.x0.r1().getUserIdLong() == yn4Var.p) {
                    this.a.E0.D2(yn4Var.l, this.a.x0.P1(), this.a.x0.f2(), this.a.x0.Z1());
                }
                if (P1.F() == null || P1.F().size() < 1 || P1.F().get(0) == null) {
                    return;
                }
                long g = jg.g(P1.F().get(0).I(), 0L);
                long g2 = jg.g(this.a.x0.h2(), 0L);
                if (g == yn4Var.n && g2 == yn4Var.m) {
                    ro4 H = P1.F().get(0).H();
                    if (H == null) {
                        H = new ro4();
                    }
                    ArrayList<ro4.a> a = H.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    H.e(H.b() + yn4Var.l);
                    H.d(a);
                    P1.F().get(0).t0(H);
                    this.a.E0.A0().Z();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            qg8 qg8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof qg8) || (qg8Var = (qg8) customResponsedMessage.getData()) == null || (agreeData = qg8Var.b) == null) {
                return;
            }
            if (this.a.E0 != null) {
                this.a.E0.c2(qg8Var);
            }
            if (agreeData.agreeType != 2 || this.a.E0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || fv7.k(this.a.x0.b)) {
                return;
            }
            this.a.E0.Y3();
            fv7.b(this.a.x0.b);
        }
    }

    /* loaded from: classes3.dex */
    public class u1 extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.A0.getLoadDataMode()) {
                        case 0:
                            this.a.x0.q2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.A4(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.E0.w0(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.a;
                            pbFragment.B4(pbFragment.A0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.E0.w0(this.a.A0.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.E0.p2(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.E0.w0(this.a.A0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u2 implements ItemCardHelper.c {
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

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.getView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.getView(), j);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x0 == null || this.a.x0.P1() == null) {
                return;
            }
            this.a.x0.P1().a();
            this.a.x0.q2();
            if (this.a.E0.A0() != null) {
                this.a.E0.F1(this.a.x0.P1());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.o1 = true;
        }
    }

    /* loaded from: classes3.dex */
    public class v1 implements u15 {
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

        @Override // com.repackage.u15
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qt7 qt7Var = this.a.I0;
                if (qt7Var == null || qt7Var.e() == null || !this.a.I0.e().d()) {
                    return !this.a.o4(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.I0.e().c());
                if (this.a.T0 != null && (this.a.T0.B() || this.a.T0.D())) {
                    this.a.T0.z(false, this.a.I0.h());
                }
                this.a.I0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class v2 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.g && z && !this.a.x0.E1()) {
                    this.a.Z5();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(li.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ad));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x0 == null || this.a.x0.P1() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.t4(str);
            this.a.x0.q2();
            if (!TextUtils.isEmpty(str) && this.a.x0.P1().F() != null) {
                ArrayList<PostData> F = this.a.x0.P1().F();
                ah8 ah8Var = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof ah8) {
                        ah8 ah8Var2 = (ah8) next;
                        if (str.equals(ah8Var2.N0())) {
                            ah8Var = ah8Var2;
                            break;
                        }
                    }
                }
                if (ah8Var != null) {
                    F.remove(ah8Var);
                    if (this.a.E0.A0() != null && this.a.E0.A0().s() != null) {
                        this.a.E0.A0().s().remove(ah8Var);
                    }
                    if (this.a.E0.R0() != null && this.a.E0.R0().getData() != null) {
                        this.a.E0.R0().getData().remove(ah8Var);
                    }
                    if (this.a.E0.A0() != null) {
                        this.a.E0.A0().Z();
                        return;
                    }
                }
            }
            if (this.a.E0.A0() != null) {
                this.a.E0.F1(this.a.x0.P1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.k5();
                po4 N1 = this.a.x0.N1();
                int Y0 = this.a.E0.Y0();
                if (Y0 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0dd2);
                } else if (N1 == null || Y0 <= N1.h()) {
                    this.a.E0.m0();
                    this.a.J6();
                    this.a.E0.p3();
                    if (ji.z()) {
                        this.a.x0.A3(this.a.E0.Y0());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                    }
                    dq4Var.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0dd2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w1 implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || dq4Var == null) {
                return;
            }
            dq4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class w2 implements bg<LinearLayout> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091702);
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

    /* loaded from: classes3.dex */
    public class x implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
        public void a(mu7 mu7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mu7Var) == null) || mu7Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, mu7Var.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x0 implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                if (this.a.J0 != null) {
                    this.a.J0.dismiss();
                }
                this.a.O6(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091675);
                        this.a.V5(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091674);
                        this.a.V5(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091677);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.V5(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091677);
                        if (view6 != null) {
                            this.a.V5(view6);
                            AgreeView agreeView2 = (AgreeView) view6;
                            if (agreeView2.getImgAgree() != null) {
                                agreeView2.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.k1 == null || TextUtils.isEmpty(this.a.l1)) {
                            return;
                        }
                        if (this.a.n1 == null) {
                            this.a.g4();
                        } else {
                            v25.a aVar = new v25.a();
                            aVar.a = this.a.l1;
                            String str = "";
                            if (this.a.n1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.n1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.k1 = null;
                        this.a.l1 = null;
                        return;
                    case 2:
                        if (this.a.k1 == null || TextUtils.isEmpty(this.a.l1)) {
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
                        if (this.a.j1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.j1 = new st7(pbFragment.getPageContext());
                        }
                        this.a.j1.b(this.a.l1, this.a.k1.n());
                        this.a.k1 = null;
                        this.a.l1 = null;
                        return;
                    case 3:
                        PostData postData = this.a.z2;
                        if (postData != null) {
                            postData.o0();
                            this.a.z2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.J5(view2);
                            if (this.a.x0.P1().O() == null || this.a.x0.P1().O().getAuthor() == null || this.a.x0.P1().O().getAuthor().getUserId() == null || this.a.z0 == null) {
                                return;
                            }
                            PbFragment pbFragment2 = this.a;
                            int c5 = pbFragment2.c5(pbFragment2.x0.P1());
                            ThreadData O = this.a.x0.P1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.x0.b).param("obj_locate", 2).param("obj_id", this.a.x0.P1().O().getAuthor().getUserId()).param("obj_type", !this.a.z0.e()).param("obj_source", c5).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ji.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.i5((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e67, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e50, 2);
                                this.a.m4(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e58) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e56) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e73) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e68) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e57)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e73)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e68)).booleanValue();
                            boolean isHost = this.a.w().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.r6(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.E0.s2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e56), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.r6(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.E0.q2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e56), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ji.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e97)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e95)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.E0.q2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e56), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                                return;
                            }
                            return;
                        } else if (!booleanValue5) {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e50, 2);
                            }
                            this.a.E0.v2(view2);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e67, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e50, 2);
                            this.a.m4(sparseArray4);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.a.p4(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.x0 == null || this.a.x0.P1() == null) {
                            return;
                        }
                        this.a.a.showBlockDialog(zn8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x1 implements f3 {
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
    }

    /* loaded from: classes3.dex */
    public class x2 implements View.OnTouchListener {
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.E0 == null || this.a.x0 == null) {
                return;
            }
            this.a.E0.g0(false);
            if (this.a.x0.I2(false)) {
                this.a.E0.q3();
            } else if (this.a.x0.P1() != null) {
                this.a.E0.G2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public y0(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (dq4Var != null) {
                    dq4Var.dismiss();
                }
                this.d.w4(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e56), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y1 implements ft4.g {
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

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.N4()) {
                    this.a.a.finish();
                }
                if (!this.a.x0.M2(true)) {
                    this.a.E0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y2 implements x16.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.repackage.x16.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || !e(i2) || this.b.E0 == null || this.b.e == null) {
                return;
            }
            this.b.e.u(true);
            if (Math.abs(i2) > this.a) {
                this.b.e.l();
            }
            if (this.b.N4()) {
                this.b.E0.t1();
                this.b.E0.N2();
            }
        }

        @Override // com.repackage.x16.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.b.E0 == null || this.b.e == null) {
                return;
            }
            this.b.E0.T3();
            this.b.e.u(false);
            this.b.e.x();
        }

        @Override // com.repackage.x16.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.x16.b
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (this.a.s0) {
                this.a.s0 = false;
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.R5();
            } else {
                this.a.b6();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class z0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z0() {
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
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z1 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.N4()) {
                    this.a.a.finish();
                }
                if (!this.a.x0.M2(true)) {
                    this.a.E0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class z2 implements y16.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z2() {
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

        @Override // com.repackage.y16.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    lq7.d();
                } else {
                    lq7.c();
                }
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
        O2 = new z0();
        P2 = new z2();
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
        this.g = false;
        this.h = false;
        this.j = true;
        this.l = 0;
        this.m = null;
        this.n = -1L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.t = false;
        this.u = null;
        this.v = 0L;
        this.w = false;
        this.x = 0L;
        this.y = 1;
        this.z = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = "";
        this.N = true;
        this.O = false;
        this.P = "";
        this.X = 3;
        this.Z = new int[2];
        this.h0 = -1;
        this.i0 = -1;
        this.k0 = BdUniqueId.gen();
        this.m0 = false;
        this.q0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.t0 = new s(this);
        this.v0 = new d0(this);
        this.w0 = new Handler(new o0(this));
        this.x0 = null;
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
        this.a1 = new k1(this);
        this.b1 = new v1(this);
        this.c1 = new g2(this);
        this.d1 = 0;
        this.o1 = false;
        this.p1 = 0;
        this.q1 = -1;
        this.s1 = 0;
        this.v1 = new r2(this);
        this.w1 = new c3(this);
        this.x1 = new i(this, 2004016);
        this.y1 = new j(this, 2016485);
        this.z1 = new k(this, 2001269);
        this.A1 = new l(this, 2004008);
        this.B1 = new m(this, 2004007);
        this.C1 = new n(this, 2004005);
        this.D1 = new o(this, 2001332);
        this.E1 = new p(this, 2921391);
        this.F1 = new q(this, 2921606);
        this.G1 = new r(this, 2921658);
        this.H1 = new t(this);
        this.I1 = new u(this, 2001369);
        this.J1 = new v(this, 2016488);
        this.K1 = new w(this, 2016331);
        this.L1 = new x(this);
        this.M1 = new y(this, 2921509);
        this.N1 = new z(this, 2010045);
        this.O1 = new a0(this);
        this.Q1 = new PraiseModel(getPageContext(), new b0(this));
        this.R1 = new c0(this);
        this.S1 = new f0(this, 2001115);
        this.T1 = new g0(this);
        this.U1 = new j0(this);
        this.V1 = new mq7(new m0(this));
        this.W1 = new p0(this, 2001427);
        this.X1 = new q0(this, 2001428);
        this.Y1 = new r0(this, 2921634);
        this.Z1 = new s0(this, 2001426);
        this.a2 = new t0(this, 2004021);
        this.b2 = new u0(this, 2016528);
        this.c2 = new v0(this, 2921033);
        this.d2 = new w0(this);
        this.e2 = new x0(this);
        this.f2 = new c1(this);
        this.g2 = new f1(this);
        this.h2 = new g1(this, 2921480);
        this.i2 = new h1(this);
        this.j2 = new i1(this);
        this.k2 = new j1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.l2 = new l1(this);
        this.m2 = new m1(this, 2016450);
        this.n2 = new n1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.o2 = new o1(this);
        this.p2 = new r1(this);
        this.q2 = new u1(this);
        this.r2 = new x1(this);
        this.s2 = new y1(this);
        this.t2 = new z1(this);
        this.v2 = new a2(this);
        this.w2 = 0;
        this.x2 = new n2(this);
        this.y2 = false;
        this.z2 = null;
        this.A2 = new o2(this);
        this.B2 = new p2(this);
        this.C2 = new q2(this);
        this.D2 = new s2(this);
        this.E2 = new t2(this);
        this.F2 = new u2(this);
        this.G2 = new v2(this);
        this.H2 = new x2(this);
        this.I2 = new y2(this);
        this.J2 = new a3(this);
        this.K2 = -1;
        this.L2 = -1;
    }

    public static PbFragment M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final void A4(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04a9);
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                dq4 dq4Var = new dq4(getPageContext().getPageActivity());
                dq4Var.setMessage(string);
                dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e8, new w1(this));
                dq4Var.setCancelable(true);
                dq4Var.create(getPageContext());
                dq4Var.show();
            } else if (bVar.d != 0) {
                this.E0.w0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.x0.P1().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i3).I())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.x0.P1().O().setReply_num(this.x0.P1().O().getReply_num() - 1);
                    this.E0.F1(this.x0.P1());
                } else if (i4 == 0) {
                    q4();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.x0.P1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).R().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i5).R().get(i6).I())) {
                                F2.get(i5).R().remove(i6);
                                F2.get(i5).k();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).m(bVar.g);
                    }
                    if (z4) {
                        this.E0.F1(this.x0.P1());
                    }
                    s4(bVar, this.E0);
                }
            }
        }
    }

    public final void A5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void A6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && UbsABTestHelper.isPushOpenNewStyle() && by4.f(TbadkCoreApplication.getInst(), 0)) {
            this.r0 = by4.h(getPageContext(), "reply_pb", 0L);
        }
    }

    public final void B4(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.E0.w0(this.A0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.F0 = true;
            if (i3 == 2 || i3 == 3) {
                this.G0 = true;
                this.H0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.G0 = false;
                this.H0 = true;
            }
            if (i3 == 2) {
                this.x0.P1().O().setIs_good(1);
                this.x0.p3(1);
            } else if (i3 == 3) {
                this.x0.P1().O().setIs_good(0);
                this.x0.p3(0);
            } else if (i3 == 4) {
                this.x0.P1().O().setIs_top(1);
                this.x0.q3(1);
            } else if (i3 == 5) {
                this.x0.P1().O().setIs_top(0);
                this.x0.q3(0);
            }
            this.E0.m4(this.x0.P1(), this.x0.f2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0cf9);
        }
        li.O(getPageContext().getPageActivity(), string);
    }

    public final void B5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.N2 == null) {
            return;
        }
        if (this.L2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dcc);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.N2.a(), this.L2, 0)));
            this.a.finish();
        }
    }

    public final void B6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (UbsABTestHelper.isPushOpenNewStyle()) {
                if (!NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && by4.f(TbadkCoreApplication.getInst(), 0)) {
                    this.r0 = by4.h(getPageContext(), "collect", 0L);
                }
            } else if (zx4.g(getContext(), 0)) {
                zx4.i(getPageContext(), 6, 2000L);
            }
        }
    }

    public final void C4(Rect rect) {
        ot7 ot7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, rect) == null) || rect == null || (ot7Var = this.E0) == null || ot7Var.l1() == null || rect.top > this.E0.l1().getHeight()) {
            return;
        }
        rect.top += this.E0.l1().getHeight() - rect.top;
    }

    public void C5(String str) {
        ot7 ot7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.x0 == null || StringUtils.isNull(str) || (ot7Var = this.E0) == null) {
            return;
        }
        ot7Var.X2(true);
        this.x0.K2(str);
        this.I = true;
        this.E0.m0();
        this.E0.o1();
    }

    public final void C6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && v() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                v().X0(postWriteCallBackData.getPostId());
                int E0 = this.E0.E0();
                this.p1 = E0;
                this.x0.l3(E0, this.E0.L0());
            }
            this.E0.m0();
            this.I0.c();
            x15 x15Var = this.T0;
            if (x15Var != null) {
                this.E0.T2(x15Var.C());
            }
            this.E0.q1();
            this.E0.D3(true);
            this.x0.q2();
        }
    }

    public AntiData D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P1() == null) {
                return null;
            }
            return this.x0.P1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void D5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            PbModel pbModel = this.a.getPbModel();
            this.x0 = pbModel;
            if (pbModel != null) {
                if (pbModel.k1() != null) {
                    this.x0.k1().c(this.J2);
                }
                if (this.x0.L1() != null) {
                    this.x0.L1().f(this.w1);
                }
                if (StringUtils.isNull(this.x0.h2())) {
                    this.a.finish();
                } else if (!"from_tieba_kuang".equals(this.M) || this.M == null) {
                } else {
                    this.x0.t3(6);
                }
            }
        }
    }

    public final void D6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i3) == null) {
            fv7.o(this, E4(), i3);
        }
    }

    public final int E4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.x0.P1() == null || this.x0.P1().O() == null) {
                return -1;
            }
            return this.x0.P1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.N2 == null) {
            return;
        }
        if (this.K2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dcd);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.N2.a(), this.K2, 0)));
            this.a.finish();
        }
    }

    public final void E6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str == null) {
                str = "";
            }
            b9 b9Var = this.f1;
            if (b9Var == null) {
                return;
            }
            dq4 dq4Var = new dq4(b9Var.getPageActivity());
            dq4Var.setMessage(str);
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f098e, new b(this));
            dq4Var.create(this.f1).show();
        }
    }

    public PostData F4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ot7 ot7Var = this.E0;
            PbModel pbModel = this.x0;
            return ot7Var.I0(pbModel.G, pbModel.f2());
        }
        return (PostData) invokeV.objValue;
    }

    public final void F5(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048592, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || k4() || !n4()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.Z);
            this.g0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (Z4().b1() != null && postData != null) {
            Z4().b1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fc6), postData.s().getName_show(), postData.P() != null ? postData.P().toString() : ""));
        }
        if (this.x0.P1() != null && this.x0.P1().g0()) {
            mg.a().postDelayed(new d1(this, str, str2), 0L);
            return;
        }
        if (this.Y0 == null) {
            xk6 xk6Var = new xk6(getPageContext());
            this.Y0 = xk6Var;
            xk6Var.j(1);
            this.Y0.i(new e1(this, str, str2));
        }
        PbModel pbModel = this.x0;
        if (pbModel == null || pbModel.P1() == null || this.x0.P1().l() == null) {
            return;
        }
        this.Y0.g(this.x0.P1().l().getId(), jg.g(this.x0.h2(), 0L));
    }

    public final void F6(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.E0.L3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            dq4 dq4Var = new dq4(this.f1.getPageActivity());
            if (ki.isEmpty(str)) {
                dq4Var.setMessage(this.f1.getResources().getString(R.string.obfuscated_res_0x7f0f0317, str3));
            } else {
                dq4Var.setMessage(str);
            }
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new c(this, userMuteAddAndDelCustomMessage));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(this));
            dq4Var.create(this.f1).show();
        }
    }

    public String G4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            kp7 P1 = this.x0.P1();
            this.x0.C3(true);
            kk4 kk4Var = this.z0;
            if (kk4Var != null) {
                P1.E0(kk4Var.g());
            }
            this.E0.F1(P1);
        }
    }

    public final void G6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (pbModel = this.x0) == null || ki.isEmpty(pbModel.h2())) {
            return;
        }
        mh4.x().Q(lh4.X, jg.g(this.x0.h2(), 0L));
    }

    public final String H4() {
        InterceptResult invokeV;
        kp7 P1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || (P1 = pbModel.P1()) == null) {
                return null;
            }
            return P1.T().c;
        }
        return (String) invokeV.objValue;
    }

    public void H5() {
        ot7 ot7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (ot7Var = this.E0) == null) {
            return;
        }
        ot7Var.Z1();
    }

    public final void H6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091e54) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54)) != null) {
            I6(postData, false);
        }
    }

    public final String I4() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P1() == null || this.x0.P1().F() == null || (count = ListUtils.getCount((F = this.x0.P1().F()))) == 0) {
                return "";
            }
            if (this.x0.a2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.I();
                    }
                }
            }
            int H0 = this.E0.H0();
            PostData postData = (PostData) ListUtils.getItem(F, H0);
            if (postData != null && postData.s() != null) {
                if (this.x0.F2(postData.s().getUserId())) {
                    return postData.I();
                }
                for (int i3 = H0 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.x0.F2(postData2.s().getUserId())) {
                        return postData2.I();
                    }
                }
                for (int i4 = H0 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.x0.F2(postData3.s().getUserId())) {
                        return postData3.I();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void I5() {
        MarkData f12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.z0 == null) {
            return;
        }
        if (this.x0.P1() != null && this.x0.P1().g0()) {
            f12 = this.x0.f1(0);
        } else {
            f12 = this.x0.f1(this.E0.Q0());
        }
        if (f12 == null) {
            return;
        }
        if (f12.isApp() && (f12 = this.x0.f1(this.E0.Q0() + 1)) == null) {
            return;
        }
        this.E0.p3();
        this.z0.i(f12);
        if (!this.z0.e()) {
            if (this.E0 != null && this.x0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !fv7.k(this.x0.b)) {
                this.E0.Y3();
                fv7.b(this.x0.b);
            }
            this.z0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.z0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void I6(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, postData, z3) == null) || postData == null || (pbModel = this.x0) == null || pbModel.P1() == null || postData.A() == 1) {
            return;
        }
        String h22 = this.x0.h2();
        String I = postData.I();
        int V = this.x0.P1() != null ? this.x0.P1().V() : 0;
        AbsPbActivity.e U5 = U5(I);
        if (U5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(h22, I, "pb", true, false, null, false, null, V, postData.U(), this.x0.P1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(U5.a, U5.b, U5.g, U5.j);
        addBigImageData.setKeyPageStartFrom(this.x0.O1());
        addBigImageData.setFromFrsForumId(this.x0.getFromForumId());
        addBigImageData.setWorksInfoData(this.x0.m2());
        addBigImageData.setKeyFromForumId(this.x0.getForumId());
        addBigImageData.setBjhData(this.x0.h1());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText J4(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048603, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText P = arrayList.get(i4).P();
                    if (P != null && (A = P.A()) != null) {
                        int size = A.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (A.get(i6) != null && A.get(i6).getType() == 8) {
                                i5++;
                                if (A.get(i6).E().A().equals(str) || A.get(i6).E().B().equals(str)) {
                                    int h3 = (int) li.h(TbadkCoreApplication.getInst());
                                    int width = A.get(i6).E().getWidth() * h3;
                                    int height = A.get(i6).E().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.w2 = i6;
                                    return P;
                                } else if (i5 > i3) {
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

    public final void J5(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54)) == null) {
                return;
            }
            K5(postData);
        }
    }

    public final void J6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                absPbActivity.stopVoice();
            }
        }
    }

    public final int K4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.y2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.A().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.A().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) li.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.E().getWidth() * h3;
                        int height = tbRichTextData.E().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.E().G()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = lp7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (E = tbRichTextData.E()) != null) {
                                    String A = E.A();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        A = E.B();
                                    } else {
                                        imageUrlData.urlType = this.s ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = A;
                                    imageUrlData.originalUrl = T4(tbRichTextData);
                                    imageUrlData.originalSize = U4(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = O4(tbRichTextData);
                                    imageUrlData.isLongPic = M4(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = jg.g(this.x0.h2(), -1L);
                                    imageUrlData.mIsReserver = this.x0.a2();
                                    imageUrlData.mIsSeeHost = this.x0.s1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.y2) {
                                i5++;
                            }
                        }
                    }
                }
                return i5;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public void K5(PostData postData) {
        PostData F4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.I() != null && postData.I().equals(this.x0.K1())) {
            z3 = true;
        }
        MarkData J1 = this.x0.J1(postData);
        if (this.x0.P1() != null && this.x0.P1().g0() && (F4 = F4()) != null) {
            J1 = this.x0.J1(F4);
        }
        if (J1 == null) {
            return;
        }
        this.E0.p3();
        kk4 kk4Var = this.z0;
        if (kk4Var != null) {
            kk4Var.i(J1);
            if (!z3) {
                this.z0.a();
            } else {
                this.z0.d();
            }
        }
    }

    public final void K6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public PbInterviewStatusView.f L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final boolean L5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = ys4.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    sk4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0535), q3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean L6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.P1() == null || !this.x0.P1().g0()) {
                if (this.x0.A1()) {
                    MarkData l12 = this.x0.l1();
                    if (l12 != null && this.x0.y1()) {
                        MarkData f12 = this.x0.f1(this.E0.H0());
                        if (f12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", l12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (f12.getPostId() != null && !f12.getPostId().equals(l12.getPostId())) {
                            dq4 dq4Var = new dq4(getPageContext().getPageActivity());
                            dq4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025f));
                            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new d2(this, f12, l12, dq4Var));
                            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new e2(this, l12, dq4Var));
                            dq4Var.setOnCalcelListener(new f2(this, l12, dq4Var));
                            dq4Var.create(getPageContext());
                            dq4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", l12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.x0.P1() != null && this.x0.P1().F() != null && this.x0.P1().F().size() > 0 && this.x0.y1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean M4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().H();
        }
        return invokeL.booleanValue;
    }

    public final void M6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (absPbActivity = this.a) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.getPbModel().h2()).param("topic_id", this.a.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.getPbModel().l2()));
    }

    public boolean N4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (!this.c && this.K2 == -1 && this.L2 == -1) ? false : true : invokeV.booleanValue;
    }

    public void N5() {
        List<d3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (list = this.r1) == null || list.isEmpty()) {
            return;
        }
        int size = this.r1.size();
        while (true) {
            size--;
            if (size <= -1 || this.r1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    public final void N6(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.getPbModel().h2()).param("topic_id", this.a.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.getPbModel().l2()));
    }

    public final boolean O4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().I();
        }
        return invokeL.booleanValue;
    }

    public boolean O5(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ot7 ot7Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048618, this, i3, keyEvent)) == null) ? (keyEvent == null || (ot7Var = this.E0) == null || !ot7Var.h2(i3)) ? false : true : invokeIL.booleanValue;
    }

    public final void O6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.x0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(ev7.m(i3))));
        }
    }

    public boolean P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (!ji.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c34);
                return;
            }
            this.E0.m0();
            if (this.i) {
                return;
            }
            J6();
            this.E0.p3();
            if (this.x0.loadData()) {
                this.E0.V3();
            }
        }
    }

    public final void P6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.D(this.x0.getForumId()) && this.x0.P1() != null && this.x0.P1().l() != null) {
            if (this.x0.P1().l().isLike() == 1) {
                this.x0.c1().C(this.x0.getForumId(), this.x0.h2());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ve5
    /* renamed from: Q4 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            ot7 ot7Var = this.E0;
            if (ot7Var == null) {
                return null;
            }
            return ot7Var.R0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void Q5() {
        PbModel pbModel;
        kp7 P1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (pbModel = this.x0) == null || pbModel.P1() == null || (O = (P1 = this.x0.P1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.E0.q1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        at7 at7Var = new at7();
        int V = this.x0.P1().V();
        if (V != 1 && V != 3) {
            at7Var.g = false;
        } else {
            at7Var.g = true;
            at7Var.s = O.getIs_top() == 1;
        }
        if (w5(V)) {
            at7Var.h = true;
            at7Var.r = O.getIs_good() == 1;
        } else {
            at7Var.h = false;
        }
        if (V == 1002 && !equals) {
            at7Var.u = true;
        }
        at7Var.n = u6(O.isBlocked(), P1.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        at7Var.e = s6(equals, P1.i0());
        at7Var.i = v6();
        at7Var.f = t6(equals);
        at7Var.k = equals && P1.U() != null && P1.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            at7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        at7Var.t = equals;
        at7Var.q = this.x0.f2();
        at7Var.b = true;
        at7Var.a = z5(equals);
        if (equals) {
            this.E0.G1();
        }
        at7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        at7Var.j = true;
        at7Var.o = this.x0.s1();
        at7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            at7Var.c = true;
        } else {
            at7Var.c = false;
        }
        if (P1.g0()) {
            at7Var.b = false;
            at7Var.d = false;
            at7Var.c = false;
            at7Var.g = false;
            at7Var.h = false;
        }
        at7Var.v = TbSingleton.getInstance().mShowCallFans && equals && !P1.g0();
        ot7 ot7Var = this.E0;
        if (ot7Var != null) {
            PbModel pbModel2 = this.x0;
            PostData I0 = ot7Var.I0(pbModel2.G, pbModel2.f2());
            at7Var.w = I0 != null ? I0.Q : false;
        }
        at7Var.m = true;
        if (O.isBlocked()) {
            at7Var.n = false;
            at7Var.g = false;
            at7Var.h = false;
        }
        this.E0.h.E(at7Var);
    }

    public final void Q6(jn4 jn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, jn4Var) == null) || jn4Var == null) {
            return;
        }
        this.N2 = jn4Var;
        this.c = true;
        this.E0.I2();
        this.E0.c3(this.M2);
    }

    public int R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.L2 : invokeV.intValue;
    }

    public void R5() {
        ay4 ay4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (ay4Var = this.r0) == null) {
            return;
        }
        ay4Var.q();
    }

    public final void R6(int i3) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i3) == null) || (pbModel = this.x0) == null || pbModel.P1() == null || (O = this.x0.P1().O()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData praise = O.getPraise();
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
                    O.setPraise(praiseData);
                } else {
                    O.getPraise().getUser().add(0, metaData);
                    O.getPraise().setNum(O.getPraise().getNum() + 1);
                    O.getPraise().setIsLike(i3);
                }
            }
            if (O.getPraise() != null) {
                if (O.getPraise().getNum() < 1) {
                    getResources().getString(R.string.obfuscated_res_0x7f0f162b);
                } else {
                    StringHelper.numFormatOver10000(O.getPraise().getNum());
                }
            }
        } else if (O.getPraise() != null) {
            O.getPraise().setIsLike(i3);
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
                getResources().getString(R.string.obfuscated_res_0x7f0f162b);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.x0.f2()) {
            this.E0.A0().Z();
        } else {
            this.E0.o4(this.x0.P1());
        }
    }

    public int S4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.K2 : invokeV.intValue;
    }

    public final void S5(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048630, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        kp7 P1 = this.x0.P1();
        TbRichText S6 = S6(str, i3);
        if (S6 == null || (tbRichTextData = S6.A().get(this.w2)) == null) {
            return;
        }
        eVar.f = String.valueOf(S6.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.E().G()) {
            eVar.h = false;
            String a4 = lp7.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.s ? 17 : 18;
            }
            imageUrlData.originalUrl = T4(tbRichTextData);
            imageUrlData.originalUrl = T4(tbRichTextData);
            imageUrlData.originalSize = U4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = O4(tbRichTextData);
            imageUrlData.isLongPic = M4(tbRichTextData);
            imageUrlData.postId = S6.getPostId();
            imageUrlData.mIsReserver = this.x0.a2();
            imageUrlData.mIsSeeHost = this.x0.s1();
            eVar.b.put(a4, imageUrlData);
            if (P1 != null) {
                if (P1.l() != null) {
                    eVar.c = P1.l().getName();
                    eVar.d = P1.l().getId();
                }
                if (P1.O() != null) {
                    eVar.e = P1.O().getId();
                }
                eVar.g = P1.s() == 1;
            }
            imageUrlData.threadId = jg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = P1.F().size();
        this.y2 = false;
        eVar.j = -1;
        int K4 = P1.j() != null ? K4(P1.j().P(), S6, i3, i3, eVar.a, eVar.b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = P1.F().get(i4);
            if (postData.I() == null || P1.j() == null || P1.j().I() == null || !postData.I().equals(P1.j().I())) {
                K4 = K4(postData.P(), S6, K4, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (P1 != null) {
            if (P1.l() != null) {
                eVar.c = P1.l().getName();
                eVar.d = P1.l().getId();
            }
            if (P1.O() != null) {
                eVar.e = P1.O().getId();
            }
            eVar.g = P1.s() == 1;
        }
        eVar.j = K4;
    }

    public final TbRichText S6(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048631, this, str, i3)) == null) {
            PbModel pbModel = this.x0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.P1() == null || str == null || i3 < 0) {
                return null;
            }
            kp7 P1 = this.x0.P1();
            if (P1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P1.j());
                tbRichText = J4(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P1.F();
                i4(P1, F);
                return J4(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final String T4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return null;
            }
            return tbRichTextData.E().C();
        }
        return (String) invokeL.objValue;
    }

    public void T5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || !checkUpIsLogin() || (pbModel = this.x0) == null || pbModel.P1() == null || this.x0.P1().l() == null || k4()) {
            return;
        }
        if (this.x0.P1().g0()) {
            this.E0.f0();
            return;
        }
        if (this.X0 == null) {
            xk6 xk6Var = new xk6(getPageContext());
            this.X0 = xk6Var;
            xk6Var.j(0);
            this.X0.i(new b1(this));
        }
        this.X0.g(this.x0.P1().l().getId(), jg.g(this.x0.h2(), 0L));
    }

    public final long U4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return 0L;
            }
            return tbRichTextData.E().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final AbsPbActivity.e U5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            String str2 = null;
            if (this.x0.P1() != null && this.x0.P1().F() != null && this.x0.P1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.x0.P1().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.x0.P1().F().get(i3).I())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.x0.P1().F().get(i3);
                if (postData.P() != null && postData.P().A() != null) {
                    Iterator<TbRichTextData> it = postData.P().A().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.E() != null) {
                                str2 = next.E().A();
                            }
                        }
                    }
                    S5(str2, 0, eVar);
                    lp7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.repackage.pw7
    public PbModel.h V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.l2 : (PbModel.h) invokeV.objValue;
    }

    public x15 V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.T0 : (x15) invokeV.objValue;
    }

    public final void V5(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09170c, Integer.valueOf(this.b ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public ru7 W4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.e : (ru7) invokeV.objValue;
    }

    public void W5(aq7 aq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, aq7Var) == null) {
            String I = aq7Var.i().I();
            List<PostData> list = this.x0.P1().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.I() == null || !postData.I().equals(I)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = aq7Var.k();
                    postData.D0(aq7Var.m());
                    if (postData.R() != null) {
                        postData.R().clear();
                        postData.R().addAll(k3);
                    }
                }
            }
            if (this.x0.y1()) {
                return;
            }
            this.E0.F1(this.x0.P1());
        }
    }

    public final int X4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i3)) == null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return i3 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    public void X5(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048642, this, z3, markData) == null) {
            this.E0.o3();
            this.x0.C3(z3);
            kk4 kk4Var = this.z0;
            if (kk4Var != null) {
                kk4Var.h(z3);
                if (markData != null) {
                    this.z0.i(markData);
                }
            }
            if (this.x0.A1()) {
                G5();
            } else {
                this.E0.F1(this.x0.P1());
            }
        }
    }

    public cv7 Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.u0 : (cv7) invokeV.objValue;
    }

    public void Y5(aq7 aq7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, aq7Var) == null) || aq7Var.i() == null) {
            return;
        }
        String I = aq7Var.i().I();
        ArrayList<PostData> F = this.x0.P1().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.I() == null || !postData.I().equals(I)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = aq7Var.k();
                postData.D0(aq7Var.m());
                if (postData.R() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.Y() != null && next != null && next.s() != null && (metaData = postData.Y().get(next.s().getUserId())) != null) {
                            next.n0(metaData);
                            next.x0(true);
                            next.J0(getPageContext(), this.x0.F2(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.R().size();
                    if (!postData.c0(false)) {
                        postData.R().clear();
                        postData.R().addAll(k3);
                    }
                }
                if (postData.x() != null) {
                    postData.l0();
                }
            }
        }
        if (!this.x0.y1() && z3) {
            this.E0.F1(this.x0.P1());
        }
        if (z3) {
            W5(aq7Var);
        }
    }

    public ot7 Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.E0 : (ot7) invokeV.objValue;
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            hideNetRefreshView(this.E0.m1());
            z6();
            if (this.x0.O2()) {
                this.E0.p3();
            }
            this.E0.y3();
        }
    }

    public ap4 a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.j0 : (ap4) invokeV.objValue;
    }

    public void a6(d3 d3Var) {
        List<d3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048648, this, d3Var) == null) || d3Var == null || (list = this.r1) == null) {
            return;
        }
        list.remove(d3Var);
    }

    public String b5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void b6() {
        ay4 ay4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (ay4Var = this.r0) == null) {
            return;
        }
        ay4Var.v();
    }

    public final int c5(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null) {
                return 0;
            }
            if (kp7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (kp7Var.O().getThreadType() == 54) {
                return 2;
            }
            return kp7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final boolean c6(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091e54);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.z0 && !TextUtils.isEmpty(postData.u()) && am4.c().g()) {
                        return L5(postData.I());
                    }
                    if (checkUpIsLogin() && (pbModel = this.x0) != null && pbModel.P1() != null) {
                        if (Z4().b1() != null) {
                            Z4().b1().c();
                        }
                        aq7 aq7Var = new aq7();
                        aq7Var.A(this.x0.P1().l());
                        aq7Var.E(this.x0.P1().O());
                        aq7Var.C(postData);
                        Z4().a1().U(aq7Var);
                        Z4().a1().setPostId(postData.I());
                        F5(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        x15 x15Var = this.T0;
                        if (x15Var != null) {
                            this.E0.T2(x15Var.C());
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d4(d3 d3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048653, this, d3Var) == null) || d3Var == null) {
            return;
        }
        if (this.r1 == null) {
            this.r1 = new ArrayList();
        }
        if (this.r1.contains(d3Var)) {
            return;
        }
        this.r1.add(d3Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pw7
    /* renamed from: d5 */
    public VideoPbFragment s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public final void d6(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048655, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            nu7 nu7Var = new nu7(this.a);
            this.Q = nu7Var;
            nu7Var.n(this.a1);
            this.Q.m(this.i2);
        }
        this.Q.k(emotionImageData, v(), v().P1());
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048656, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (se5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), se5.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (tt7.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new hd5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void e4(d3 d3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, d3Var) == null) || d3Var == null) {
            return;
        }
        if (this.r1 == null) {
            this.r1 = new ArrayList();
        }
        if (this.r1.contains(d3Var)) {
            return;
        }
        this.r1.add(0, d3Var);
    }

    public String e5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public final void e6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || (pbModel = this.x0) == null || pbModel.P1() == null || this.x0.P1().O() == null || !this.x0.P1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void f4() {
        PbModel pbModel;
        kp7 kp7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || (pbModel = this.x0) == null || (kp7Var = pbModel.G) == null || kp7Var.O() == null) {
            return;
        }
        ThreadData O = this.x0.G.O();
        O.mRecomAbTag = this.x0.U1();
        O.mRecomWeight = this.x0.X1();
        O.mRecomSource = this.x0.W1();
        O.mRecomExtra = this.x0.V1();
        O.isSubPb = this.x0.C1();
        if (O.getFid() == 0) {
            O.setFid(jg.g(this.x0.getForumId(), 0L));
        }
        StatisticItem i3 = e75.i(getContext(), O, "c13562");
        TbPageTag l3 = e75.l(getContext());
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

    public void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            if (this.g) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.x0.P1() == null || this.x0.P1().O() == null || this.x0.P1().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.x0.P1().O().getTaskInfoData().g(), this.x0.P1().O().getTaskInfoData().f(), this.x0.P1().O().getTaskInfoData().b(), this.x0.P1().O().getTaskInfoData().c(), this.x0.P1().O().getIs_top(), this.x0.P1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void f6(boolean z3, PostData postData) {
        kv4 adAdSense;
        ot7 ot7Var;
        yr7 A0;
        ArrayList<PostData> E;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048662, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e() || (ot7Var = this.E0) == null || (A0 = ot7Var.A0()) == null || (E = A0.E()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PostData> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String I = next.I();
            if (z3) {
                if (next == postData) {
                    arrayList.add(new fh8.c());
                    break;
                }
            } else if (next.C == 1 && !TextUtils.isEmpty(I)) {
                next.C = 2;
                arrayList.add(new fh8.c());
            }
        }
        if (arrayList.size() <= 0 || (pbModel = this.x0) == null || pbModel.P1() == null || this.x0.P1().l() == null) {
            return;
        }
        this.x0.P1().l().getFirst_class();
        this.x0.P1().l().getSecond_class();
        this.x0.P1().l().getId();
        this.x0.h2();
    }

    @Override // com.repackage.pw7
    public void finish() {
        ot7 ot7Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            ot7 ot7Var2 = this.E0;
            if (ot7Var2 != null) {
                ot7Var2.m0();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P1() != null && !this.x0.P1().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.x0.P1().O().getId();
                if (this.x0.isShareThread() && this.x0.P1().O().originalThreadData != null) {
                    historyMessage.threadName = this.x0.P1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.x0.P1().O().getTitle();
                }
                if (this.x0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.x0.P1().l().getName();
                }
                ArrayList<PostData> F = this.x0.P1().F();
                ot7 ot7Var3 = this.E0;
                int H0 = ot7Var3 != null ? ot7Var3.H0() : 0;
                if (F != null && H0 >= 0 && H0 < F.size()) {
                    historyMessage.postID = F.get(H0).I();
                }
                historyMessage.isHostOnly = this.x0.s1();
                historyMessage.isSquence = this.x0.f2();
                historyMessage.isShareThread = this.x0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            x15 x15Var = this.T0;
            if (x15Var != null) {
                x15Var.I();
            }
            if (this.j && Z4() != null) {
                Z4().r0();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && (pbModel2.u1() || this.x0.x1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.x0.h2());
                if (this.F0) {
                    if (this.H0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.x0.D1());
                    }
                    if (this.G0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.x0.z1());
                    }
                }
                if (this.x0.P1() != null && System.currentTimeMillis() - this.p >= 40000 && (q3 = this.x0.P1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.q1);
                }
                this.a.setResult(-1, intent);
            }
            if (L6()) {
                if (this.x0 != null && (ot7Var = this.E0) != null && ot7Var.R0() != null) {
                    kp7 P1 = this.x0.P1();
                    if (P1 != null) {
                        if (P1.U() != null) {
                            P1.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!P1.m0() && !this.I && P1.h == null) {
                            gt7.b().n(this.x0.Q1(), this.E0.R0().onSaveInstanceState(), this.x0.f2(), this.x0.s1(), this.E0.Z0() != null && this.E0.Z0().getVisibility() == 0);
                            if (this.p1 >= 0 || this.x0.j2() != null) {
                                gt7.b().q(this.x0.j2());
                                gt7.b().r(this.x0.k2());
                                gt7.b().o(this.x0.I1());
                            }
                        }
                    }
                } else {
                    gt7.b().m();
                }
                K6();
            }
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            if (this.m1 != null) {
                v25.b bVar = new v25.b();
                bVar.a = this.m1.C();
                bVar.b = this.m1.A();
                bVar.c = String.valueOf(this.m1.D());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l1));
        }
    }

    public final void g5(int i3, Intent intent) {
        f05 f05Var;
        f05 f05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048665, this, i3, intent) == null) {
            if (i3 == 0) {
                this.E0.q1();
                this.E0.b1().c();
                this.E0.D3(false);
            }
            this.E0.L2();
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
                    if (editorType != 1 || this.E0.b1() == null || this.E0.b1().b() == null) {
                        return;
                    }
                    a25 b4 = this.E0.b1().b();
                    b4.c0(this.x0.P1().O());
                    b4.B(writeData);
                    b4.d0(pbEditorData.getVoiceModel());
                    e05 n3 = b4.a().n(6);
                    if (n3 != null && (f05Var2 = n3.m) != null) {
                        f05Var2.onAction(new sz4(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.T0.S();
                this.T0.t0(pbEditorData.getVoiceModel());
                this.T0.G(writeData);
                e05 n4 = this.T0.a().n(6);
                if (n4 != null && (f05Var = n4.m) != null) {
                    f05Var.onAction(new sz4(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.T0.L(null, null);
                }
            }
        }
    }

    public final void g6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || (pbModel = this.x0) == null || pbModel.P1() == null || this.x0.P1().O() == null || !this.x0.P1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public qu7 getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.a.getEventController() : (qu7) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.L == null) {
                this.L = new ag<>(new i2(this), 20, 0);
            }
            return this.L;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.C == null) {
                this.C = new ag<>(new h2(this), 8, 0);
            }
            return this.C;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (this.H == null) {
                this.H = new ag<>(new m2(this), 10, 0);
            }
            return this.H;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.repackage.ve5
    public ag<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new l2(this), 10, 0);
            this.G = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            ot7 ot7Var = this.E0;
            if (ot7Var == null) {
                return 0;
            }
            return ot7Var.g1();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ve5
    public ag<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.F == null) {
                this.F = new ag<>(new w2(this), 15, 0);
            }
            return this.F;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (this.E == null) {
                this.E = new ag<>(new j2(this), 5, 0);
            }
            return this.E;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (this.B == null) {
                this.B = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.B;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.k : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            if (this.D == null) {
                this.D = new ag<>(new k2(this), 8, 0);
            }
            return this.D;
        }
        return (ag) invokeV.objValue;
    }

    public final void h4(boolean z3) {
        PbModel pbModel;
        kp7 kp7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048681, this, z3) == null) || (pbModel = this.x0) == null || (kp7Var = pbModel.G) == null || kp7Var.O() == null) {
            return;
        }
        ThreadData O = this.x0.G.O();
        O.mRecomAbTag = this.x0.U1();
        O.mRecomWeight = this.x0.X1();
        O.mRecomSource = this.x0.W1();
        O.mRecomExtra = this.x0.V1();
        if (O.getFid() == 0) {
            O.setFid(jg.g(this.x0.getForumId(), 0L));
        }
        StatisticItem i3 = e75.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l3 = e75.l(getContext());
        if (l3 != null && "a008".equals(l3.locatePage)) {
            i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
        }
        if (l3 != null && "a002".equals(l3.locatePage)) {
            i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        if (i3 != null) {
            i3.param(TiebaStatic.Params.REPLY_TYPE, 1);
            z65 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i3);
        }
    }

    public void h5(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea7) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea9) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ea8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea8) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091ea4) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea4) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea5) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea5) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.h1);
            userMuteAddAndDelCustomMessage.setTag(this.h1);
            F6(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void h6(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048683, this, i3) == null) || this.x0 == null) {
            return;
        }
        z6();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.x0.b);
        sendMessage(privacySettingMessage);
    }

    public final void i4(kp7 kp7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048684, this, kp7Var, arrayList) == null) || kp7Var == null || kp7Var.T() == null || kp7Var.T().a == null || (list = kp7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.I()) && !TextUtils.isEmpty(postData.I()) && next.I().equals(postData.I())) {
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

    public final void i5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P1() != null && this.x0.P1().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.x0.h2(), str);
                ThreadData O = this.x0.P1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                A5(format);
                return;
            }
            this.y0.a(str);
        }
    }

    public void i6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z3) == null) {
            this.N = z3;
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.E2();
        }
        return invokeV.booleanValue;
    }

    public void j4(boolean z3) {
        ot7 ot7Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048688, this, z3) == null) || (ot7Var = this.E0) == null || ot7Var.R0() == null) {
            return;
        }
        int firstVisiblePosition = this.E0.R0().getFirstVisiblePosition();
        int lastVisiblePosition = this.E0.R0().getLastVisiblePosition();
        yr7 A0 = this.E0.A0();
        if (A0 == null || this.x0.P1() == null) {
            return;
        }
        if (lastVisiblePosition <= A0.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > A0.w() ? firstVisiblePosition - A0.w() : 0;
            w4 = (lastVisiblePosition - A0.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.E0.R0().G(w3) != null && (this.E0.R0().G(w3) instanceof PostData) && (postData = (PostData) this.E0.R0().G(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.x0.P1().F(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.m0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().q(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                w3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new s1(this));
            ry4 ry4Var = (ry4) ListUtils.getItem(arrayList, 0);
            if (ry4Var == null || ry4Var.e() != 1) {
                this.E0.x2(ry4Var, 1);
            } else if (z3) {
            } else {
                this.E0.x2(ry4Var, 0);
            }
        }
    }

    public final void j5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, intent) == null) {
            fv7.j(this, intent);
        }
    }

    public final void j6(z15 z15Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, z15Var) == null) || z15Var == null || (pbModel = this.x0) == null) {
            return;
        }
        z15Var.p(pbModel.o1());
        if (this.x0.P1() != null && this.x0.P1().l() != null) {
            z15Var.o(this.x0.P1().l());
        }
        z15Var.q("pb");
        z15Var.r(this.x0);
    }

    public final boolean k4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.x0.P1().O()) || AntiHelper.d(getPageContext(), this.x0.P1().d());
        }
        return invokeV.booleanValue;
    }

    public void k5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        li.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public final void k6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048693, this, i3) == null) || (pbModel = this.x0) == null) {
            return;
        }
        int Y1 = pbModel.Y1();
        if (i3 == 5) {
            this.x0.w3(2);
        } else if (i3 == 6) {
            this.x0.w3(3);
        } else if (i3 != 7) {
            this.x0.w3(1);
        } else {
            this.x0.w3(4);
        }
        int Y12 = this.x0.Y1();
        if (Y1 == 4 || Y12 == 4) {
            P5();
        }
    }

    public final boolean l4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048694, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void l5() {
        ot7 ot7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048695, this) == null) || (ot7Var = this.E0) == null) {
            return;
        }
        ot7Var.q1();
        k5();
    }

    public void l6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z3) == null) {
            this.K = z3;
        }
    }

    public void m4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.E0.L3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = jg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = jg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6), 0L);
            BdUniqueId bdUniqueId = this.h1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.e1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void m5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048698, this, i3, i4) == null) {
            pc5.b(new g(this, i4), new h(this, i4, i3));
        }
    }

    public final void m6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z3) == null) {
            this.T0.f0(z3);
            this.T0.i0(z3);
            this.T0.p0(z3);
        }
    }

    @Override // com.repackage.qx7.b
    public void n0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z3) == null) {
            this.N0 = z3;
        }
    }

    public boolean n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            if ((this.x0.P1() != null && (this.x0.P1().g0() || ThreadCardUtils.isSelf(this.x0.P1().O()))) || this.W0 == null || this.x0.P1() == null || this.x0.P1().d() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeInvokeEditor(this.x0.P1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void n5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i3) == null) {
            pc5.b(new e(this), new f(this, i3));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i3 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i3 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void n6() {
        PbModel pbModel;
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048703, this) == null) || (pbModel = this.x0) == null || pbModel.G == null) {
            return;
        }
        long c4 = xx4.c();
        if (c4 > 0 && (i3 = q47.o().i(String.valueOf(c4), 2)) != null) {
            MetaData metaData = new MetaData();
            metaData.setUserIdLong(c4);
            metaData.setUserName(i3.getGroup_name());
            metaData.setName_show(i3.getNameShow());
            metaData.setPortrait(i3.getGroup_head());
            metaData.setIsMyFriend(i3.getIsFriend() != 1 ? 0 : 1);
            y57 y57Var = new y57(getContext());
            y57Var.o(this.x0.G.O(), metaData);
            y57Var.p();
        }
    }

    public boolean o4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048704, this, i3)) == null) {
            if (this.W0 == null || this.x0.P1() == null || ThreadCardUtils.isSelf(this.x0.P1().O()) || this.x0.P1().d() == null) {
                return true;
            }
            return this.W0.checkPrivacyBeforeSend(this.x0.P1().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void o5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, bundle) == null) {
            kk4 c4 = kk4.c(this.a);
            this.z0 = c4;
            if (c4 != null) {
                c4.j(this.o2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.A0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.q2);
            this.B0 = new ix4(getPageContext());
            this.Q1.setUniqueId(getUniqueId());
            this.Q1.registerListener();
        }
    }

    public final void o6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048706, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new t1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                E6(str);
            } else {
                this.E0.d4(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906b0));
            this.l2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
            this.a.getTiePlusEventController().l(this.t0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048708, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.T0.H(i3, i4, intent);
            nu7 nu7Var = this.Q;
            if (nu7Var != null) {
                nu7Var.i(i3, i4, intent);
            }
            if (Z4().b1() != null) {
                Z4().b1().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                g5(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    I5();
                } else if (i3 == 13008) {
                    gt7.b().m();
                    this.w0.postDelayed(new b2(this), 1000L);
                } else if (i3 == 13011) {
                    t68.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.x0 == null) {
                        return;
                    }
                    q6(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    j5(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25033) {
                    View view2 = this.S;
                    if (view2 != null) {
                        this.E0.I3(view2);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        t68.g().m(getPageContext());
                        P6();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.w) != null) {
                            shareSuccessReplyToServerModel.y(str, intExtra, new c2(this));
                        }
                        if (s5()) {
                            N6(true);
                        }
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
                        case 25055:
                            View view3 = this.T;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view4 = this.U;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            ot7 ot7Var = this.E0;
                            if (ot7Var == null || ot7Var.B0() == null) {
                                return;
                            }
                            this.E0.B0().performClick();
                            return;
                        case 25058:
                            View view5 = this.V;
                            if (view5 != null) {
                                view5.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.E0.r3(false);
                    if (this.x0.P1() == null || this.x0.P1().O() == null || this.x0.P1().O().getPushStatusData() == null) {
                        return;
                    }
                    this.x0.P1().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // com.repackage.ve5
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.w = true;
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048711, this, i3) == null) || this.X == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.E0.d2(i3);
        x15 x15Var = this.T0;
        if (x15Var != null && x15Var.a() != null) {
            this.T0.a().w(i3);
        }
        if (this.E0.a() != null) {
            this.E0.a().c(getPageContext(), i3);
        }
        this.I0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.X = i3;
        J6();
        ay4 ay4Var = this.r0;
        if (ay4Var != null) {
            ay4Var.u();
        }
    }

    @Override // com.repackage.dq4.e
    public void onClick(dq4 dq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, dq4Var) == null) {
            v4(dq4Var, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.y) {
                return;
            }
            this.y = i3;
            if (i3 == 2) {
                this.J = true;
            } else {
                this.J = false;
            }
            ot7 ot7Var = this.E0;
            if (ot7Var != null) {
                ot7Var.e2(configuration);
            }
            mq4 mq4Var = this.J0;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ot7 ot7Var;
        ot7 ot7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            this.p = System.currentTimeMillis();
            this.f1 = getPageContext();
            Intent intent = this.a.getIntent();
            if (intent != null) {
                this.n = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.M = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.M)) {
                        this.M = data.getQueryParameter("from");
                    }
                }
                this.W = intent.getStringExtra("st_type");
                "from_interview_live".equals(this.M);
                this.K2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.L2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.M2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.O0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.P0 = intent.getStringExtra("high_light_post_id");
                this.Q0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (N4()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                this.P = ki.isEmpty(stringExtra) ? "" : this.P;
                this.q1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                ap4 ap4Var = new ap4();
                this.j0 = ap4Var;
                ap4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.s1 = intExtra;
                if (intExtra == 0) {
                    this.s1 = intent.getIntExtra("key_start_from", 0);
                }
                this.t1 = intent.getStringExtra("last_tid");
            } else {
                this.n = System.currentTimeMillis();
            }
            this.r = this.p - this.n;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.l = 0;
            D5(bundle);
            if (this.x0.P1() != null) {
                this.x0.P1().N0(this.P);
            }
            p5();
            if (intent != null && (ot7Var2 = this.E0) != null) {
                ot7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.i1 == null) {
                        this.i1 = new h0(this, intent);
                    }
                    mg.a().postDelayed(this.i1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.x0.P1() != null) {
                    this.x0.u3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            o5(bundle);
            z15 z15Var = new z15();
            this.S0 = z15Var;
            j6(z15Var);
            x15 x15Var = (x15) this.S0.a(getActivity());
            this.T0 = x15Var;
            x15Var.e0(this.a.getPageContext());
            this.T0.n0(this.i2);
            this.T0.o0(this.a1);
            this.T0.g0(1);
            this.T0.F(this.a.getPageContext(), bundle);
            this.T0.a().b(new c05(getActivity()));
            this.T0.a().C(true);
            m6(true);
            this.T0.O(this.x0.r1(), this.x0.h2(), this.x0.n1());
            registerListener(this.A1);
            if (!this.x0.C1()) {
                this.T0.s(this.x0.h2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.x0.v2()) {
                this.T0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde));
            } else {
                ot7 ot7Var3 = this.E0;
                if (ot7Var3 != null) {
                    this.T0.k0(ot7Var3.e1());
                }
            }
            registerListener(this.z1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.y1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.n2);
            registerListener(this.x1);
            rg8 rg8Var = new rg8("pb", rg8.d);
            this.R0 = rg8Var;
            rg8Var.d();
            registerListener(this.I1);
            registerListener(this.S1);
            this.x0.R2();
            registerListener(this.m2);
            registerListener(this.c2);
            registerListener(this.h2);
            registerListener(this.M1);
            registerListener(this.N1);
            ot7 ot7Var4 = this.E0;
            if (ot7Var4 != null && ot7Var4.l1() != null && this.E0.j1() != null) {
                ru7 ru7Var = new ru7(getActivity(), this.E0.l1(), this.E0.j1(), this.E0.Z0());
                this.e = ru7Var;
                ru7Var.t(this.R1);
            }
            if (this.c && (ot7Var = this.E0) != null && ot7Var.j1() != null) {
                this.E0.j1().setVisibility(8);
            }
            ct4 ct4Var = new ct4();
            this.g1 = ct4Var;
            ct4Var.a = 1000L;
            registerListener(this.Z1);
            registerListener(this.Y1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.K1);
            registerListener(this.E1);
            registerListener(this.F1);
            registerListener(this.G1);
            this.J1.setSelfListener(true);
            this.J1.setTag(this.a.getUniqueId());
            this.J1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.J1);
            registerResponsedEventListener(TipEvent.class, this.T1);
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
            this.x0.j1().C(this.U1);
            this.I0 = new qt7();
            if (this.T0.v() != null) {
                this.I0.m(this.T0.v().i());
            }
            this.T0.d0(this.b1);
            this.D0 = new ShareSuccessReplyToServerModel();
            d4(this.v1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.W0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new i0(this));
            kv7 kv7Var = new kv7(getContext());
            this.y0 = kv7Var;
            kv7Var.b(getUniqueId());
            bf8.g().i(getUniqueId());
            lm4.b().l("3", "");
            this.u1 = new lv5(getPageContext());
            this.u0 = new cv7(this, getUniqueId(), this.E0, this.x0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && ji.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.q = System.currentTimeMillis() - this.p;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048715, this, layoutInflater, viewGroup, bundle)) == null) {
            this.E0 = new ot7(this, this.g2, this.V1);
            y16 y16Var = new y16(getActivity());
            this.d = y16Var;
            y16Var.i(P2);
            this.d.d(this.I2);
            this.E0.i3(this.p2);
            this.E0.h3(this.v2);
            this.E0.a3(this.s2);
            this.E0.b3(this.t2);
            this.E0.Y2(am4.c().g());
            this.E0.f3(this.x2);
            this.E0.l3(this.D2);
            this.E0.j3(this.E2);
            this.E0.g3(this.G2);
            this.E0.e3(this.r2);
            this.E0.i4(this.mIsLogin);
            if (this.a.getIntent() != null) {
                this.E0.W2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.E0.a1().setFromForumId(this.x0.getFromForumId());
            this.E0.O2(this.T0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.T0.k0(this.E0.e1());
            }
            this.E0.S2(new l0(this));
            this.E0.V2(this.x0.x1());
            this.E0.k3(this.x0.O1());
            this.u0.f(this.E0, this.x0);
            return this.E0.m1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            bf8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.x0.P1().m());
                statisticItem.param("tid", this.x0.h2());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.t && this.E0 != null) {
                this.t = true;
                f6(false, null);
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.x0.destory();
                if (this.x0.L1() != null) {
                    this.x0.L1().d();
                }
            }
            x15 x15Var = this.T0;
            if (x15Var != null) {
                x15Var.I();
            }
            ForumManageModel forumManageModel = this.A0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.L();
            }
            ot7 ot7Var = this.E0;
            if (ot7Var != null) {
                ot7Var.f2();
                jv7 jv7Var2 = this.E0.h;
                if (jv7Var2 != null) {
                    jv7Var2.x();
                }
            }
            u75 u75Var = this.u;
            if (u75Var != null) {
                u75Var.c();
            }
            ru7 ru7Var = this.e;
            if (ru7Var != null) {
                ru7Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            ot7 ot7Var2 = this.E0;
            if (ot7Var2 != null) {
                ot7Var2.m0();
            }
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.k2);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            this.f1 = null;
            this.g1 = null;
            y88.e().g();
            if (this.i1 != null) {
                mg.a().removeCallbacks(this.i1);
            }
            nu7 nu7Var = this.Q;
            if (nu7Var != null) {
                nu7Var.f();
            }
            ot7 ot7Var3 = this.E0;
            if (ot7Var3 != null && (jv7Var = ot7Var3.h) != null) {
                jv7Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            qt7 qt7Var = this.I0;
            if (qt7Var != null) {
                qt7Var.j();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && pbModel2.c1() != null) {
                this.x0.c1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.W0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ot7 ot7Var4 = this.E0;
            if (ot7Var4 != null) {
                ot7Var4.f4();
            }
            cv7 cv7Var = this.u0;
            if (cv7Var != null) {
                cv7Var.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.k0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public nn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (nn) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048719, this, context, str) == null) {
            this.w = true;
        }
    }

    @Override // com.repackage.ve5
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048720, this, context, str, z3) == null) {
            if (tt7.c(str) && (pbModel = this.x0) != null && pbModel.h2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.x0.h2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    gz4 gz4Var = new gz4();
                    gz4Var.a = str;
                    gz4Var.b = 3;
                    gz4Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, gz4Var));
                }
            } else {
                tt7.a().e(getPageContext(), str);
            }
            this.w = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            Z5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.g = false;
            } else {
                this.g = true;
            }
            super.onPause();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.l = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            ot7 ot7Var = this.E0;
            if (ot7Var != null) {
                ot7Var.k2();
            }
            if (!this.x0.C1()) {
                this.T0.U(this.x0.h2());
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.Q2();
            }
            mh4.x().F();
            MessageManager.getInstance().unRegisterListener(this.D1);
            e6();
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
            ay4 ay4Var = this.r0;
            if (ay4Var != null) {
                ay4Var.q();
                this.r0.p();
            }
        }
    }

    @Override // com.repackage.ve5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048723, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.L0 = str;
        if (this.m == null) {
            q5();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            this.m.f(1).setVisibility(8);
        } else {
            this.m.f(1).setVisibility(0);
        }
        this.m.m();
        this.w = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.e9
    public void onPreLoad(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, nnVar) == null) {
            PreLoadImageHelper.load(nnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(nnVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            this.g = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                f5();
            }
            if (t5()) {
                this.v = System.currentTimeMillis();
            } else {
                this.v = -1L;
            }
            ot7 ot7Var = this.E0;
            if (ot7Var != null && ot7Var.m1() != null) {
                if (!this.h) {
                    z6();
                } else {
                    hideLoadingView(this.E0.m1());
                }
                this.E0.m2();
            }
            if (this.l == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            ot7 ot7Var2 = this.E0;
            NoNetworkView a4 = ot7Var2 != null ? ot7Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && ji.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.D1);
            this.N0 = false;
            g6();
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Z1);
            if (this.o1) {
                Z5();
                this.o1 = false;
            }
            G6();
            ItemCardHelper.v(this.F2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                lz4.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.x0.i3(bundle);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.T0.K(bundle);
        }
    }

    @Override // com.repackage.ve5
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048727, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            super.onStop();
            if (this.v > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.v;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.v = 0L;
            }
            if (Z4().b1() != null) {
                Z4().b1().i();
            }
            jv7 jv7Var = this.E0.h;
            if (jv7Var != null && !jv7Var.t()) {
                this.E0.h.x();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P1() != null && this.x0.P1().l() != null && this.x0.P1().O() != null) {
                iz4.j().x(getPageContext().getPageActivity(), "pb", this.x0.P1().l().getId(), jg.g(this.x0.P1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            bf8.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048730, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z3) == null) {
            super.onUserChanged(z3);
            this.E0.i4(z3);
            mq4 mq4Var = this.J0;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
            if (z3 && this.N0) {
                this.E0.q3();
                this.x0.I2(true);
            }
            if (this.E0.A0() != null) {
                this.E0.A0().c0(z3);
            }
        }
    }

    @Override // com.repackage.ve5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048732, this, context, str) == null) {
            tt7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.w = true;
        }
    }

    @Override // com.repackage.ve5
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048733, this, context, str) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p4(AgreeData agreeData) {
        z65 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048734, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l0 == null) {
            this.l0 = new us4();
        }
        if (this.p0 == null) {
            qg8 qg8Var = new qg8();
            this.p0 = qg8Var;
            qg8Var.a = getUniqueId();
        }
        um4 um4Var = new um4();
        um4Var.b = 5;
        um4Var.h = 8;
        um4Var.g = 2;
        if (v() != null) {
            um4Var.f = v().O1();
        }
        um4Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                um4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l0.c(agreeData, i3, getUniqueId(), false);
                this.l0.d(agreeData, this.p0);
                pbModel = this.x0;
                if (pbModel != null || pbModel.P1() == null) {
                }
                this.l0.b(w(), um4Var, agreeData, this.x0.P1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            um4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            um4Var.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.l0.c(agreeData, i3, getUniqueId(), false);
        this.l0.d(agreeData, this.p0);
        pbModel = this.x0;
        if (pbModel != null) {
        }
    }

    public final void p5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new k0(this));
        }
    }

    public final void p6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048736, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (Z4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    dy4.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    cj8.b(getFragmentActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.x0.C1()) {
            antiData.setBlock_forum_name(this.x0.P1().l().getName());
            antiData.setBlock_forum_id(this.x0.P1().l().getId());
            antiData.setUser_name(this.x0.P1().U().getUserName());
            antiData.setUser_id(this.x0.P1().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            if (this.x0.u1() || this.x0.x1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.x0.h2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.x0.h2()));
            if (L6()) {
                this.a.finish();
            }
        }
    }

    public final void q5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && this.m == null) {
            this.m = new fq4(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f036b), getPageContext().getString(R.string.obfuscated_res_0x7f0f11ba), getPageContext().getString(R.string.obfuscated_res_0x7f0f10c8)};
            fq4 fq4Var = this.m;
            fq4Var.j(strArr, new n0(this));
            fq4Var.g(fq4.b.obfuscated_res_0x7f1003a4);
            fq4Var.h(17);
            fq4Var.c(getPageContext());
        }
    }

    public final void q6(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048739, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            fv7.l(this, j3, str, j4);
        }
    }

    public final boolean r4(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<kq4> b4;
        kq4 kq4Var;
        kq4 kq4Var2;
        kq4 kq4Var3;
        kq4 kq4Var4;
        um umVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048740, this, view2)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                ot7 ot7Var = this.E0;
                if (ot7Var != null) {
                    if (ot7Var.J1()) {
                        return true;
                    }
                    this.E0.x0();
                }
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e4) {
                    e4.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (v5(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.k1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.l1 = url;
                            if (this.k1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8a) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8a) instanceof TbRichTextImageInfo)) {
                                this.m1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8a);
                            } else {
                                this.m1 = null;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextImageInfo)) {
                                this.n1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextImageInfo)) {
                                this.n1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
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
                                if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextImageInfo)) {
                                    this.n1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
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
                            this.E0.Q3(this.B2, this.k1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54);
                this.z2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && v5(view2)) {
                    this.E0.Q3(this.B2, this.k1.t());
                    return true;
                }
                kk4 kk4Var = this.z0;
                if (kk4Var == null) {
                    return true;
                }
                boolean z6 = kk4Var.e() && this.z2.I() != null && this.z2.I().equals(this.x0.K1());
                boolean z7 = v().P1() != null && v().P1().g0();
                boolean z8 = v().P1() != null && v().P1().j0();
                if (this.z2.A() == 1) {
                    if (!z7) {
                        this.E0.R3(this.A2, z6, false, z8);
                    }
                    return true;
                }
                if (this.K0 == null) {
                    oq4 oq4Var = new oq4(getContext());
                    this.K0 = oq4Var;
                    oq4Var.n(this.e2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 == null || sparseArray == null) {
                    return true;
                }
                boolean z9 = v5(view2) && !z7;
                boolean z10 = (!v5(view2) || (umVar = this.k1) == null || umVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e6d) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f091e64) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e64) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                if (z9) {
                    z5 = booleanValue7;
                    z4 = booleanValue6;
                    z3 = booleanValue5;
                    arrayList.add(new kq4(1, getString(R.string.obfuscated_res_0x7f0f1096), this.K0));
                } else {
                    z3 = booleanValue5;
                    z4 = booleanValue6;
                    z5 = booleanValue7;
                }
                if (z10) {
                    arrayList.add(new kq4(2, getString(R.string.obfuscated_res_0x7f0f1097), this.K0));
                }
                if (!z9 && !z10) {
                    kq4 kq4Var5 = new kq4(3, getString(R.string.obfuscated_res_0x7f0f044a), this.K0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e54, this.z2);
                    kq4Var5.d.setTag(sparseArray3);
                    arrayList.add(kq4Var5);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        kq4Var4 = new kq4(4, getString(R.string.obfuscated_res_0x7f0f0fad), this.K0);
                    } else {
                        kq4Var4 = new kq4(4, getString(R.string.obfuscated_res_0x7f0f0a8e), this.K0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e54, this.z2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, Boolean.FALSE);
                    kq4Var4.d.setTag(sparseArray4);
                    arrayList.add(kq4Var4);
                }
                if (this.mIsLogin && !this.q0) {
                    if (!ev7.h(this.x0) && !booleanValue4 && booleanValue3) {
                        kq4 kq4Var6 = new kq4(5, getString(R.string.obfuscated_res_0x7f0f0b2f), this.K0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                        kq4Var6.d.setTag(sparseArray5);
                        arrayList.add(kq4Var6);
                    } else {
                        if ((z5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            kq4 kq4Var7 = new kq4(5, getString(R.string.obfuscated_res_0x7f0f0fd0), this.K0);
                            kq4Var7.d.setTag(str);
                            arrayList.add(kq4Var7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e61, sparseArray.get(R.id.obfuscated_res_0x7f091e61));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e64, str);
                        if (!ev7.h(this.x0) && z3) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                        }
                        if (z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z5));
                            if (z5) {
                                kq4 kq4Var8 = new kq4(6, getString(R.string.obfuscated_res_0x7f0f04a4), this.K0);
                                kq4Var8.d.setTag(sparseArray6);
                                kq4Var2 = kq4Var8;
                                kq4Var = new kq4(7, getString(R.string.obfuscated_res_0x7f0f02db), this.K0);
                                kq4Var.d.setTag(sparseArray6);
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                        }
                        kq4Var2 = null;
                        kq4Var = new kq4(7, getString(R.string.obfuscated_res_0x7f0f02db), this.K0);
                        kq4Var.d.setTag(sparseArray6);
                    } else if (z4) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                        if (this.x0.P1().V() == 1002 && !booleanValue2) {
                            kq4Var3 = new kq4(6, getString(R.string.obfuscated_res_0x7f0f0fd0), this.K0);
                        } else {
                            kq4Var3 = new kq4(6, getString(R.string.obfuscated_res_0x7f0f04a4), this.K0);
                        }
                        kq4Var3.d.setTag(sparseArray7);
                        kq4Var2 = kq4Var3;
                        kq4Var = null;
                    } else {
                        kq4Var = null;
                        kq4Var2 = null;
                    }
                    if (kq4Var2 != null) {
                        arrayList.add(kq4Var2);
                    }
                    if (kq4Var != null) {
                        arrayList.add(kq4Var);
                    }
                    ev7.a(arrayList, this.K0, this.z2, this.x0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    b4 = ev7.c(arrayList, this.z2.q(), sparseArray, this.K0);
                } else {
                    b4 = ev7.b(arrayList, this.z2.q(), sparseArray, this.K0);
                }
                ev7.k(b4, this.b);
                ev7.e(b4);
                this.K0.o(ev7.f(this.z2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.K0.k(b4, false);
                } else {
                    this.K0.k(b4, true);
                }
                mq4 mq4Var = new mq4(getPageContext(), this.K0);
                this.J0 = mq4Var;
                mq4Var.m();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.x0.b).param("fid", this.x0.getForumId()).param("uid", this.x0.P1().O().getAuthor().getUserId()).param("post_id", this.x0.A()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean r5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.u1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048742, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            ev7.d(getActivity(), getPageContext(), new y0(this, sparseArray, i3, z3), new a1(this));
        }
    }

    public void s4(ForumManageModel.b bVar, ot7 ot7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048744, this, bVar, ot7Var) == null) {
            List<PostData> list = this.x0.P1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).R().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).R().get(i4).I())) {
                        list.get(i3).R().remove(i4);
                        list.get(i3).k();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).m(bVar.g);
            }
            if (z3) {
                ot7Var.F1(this.x0.P1());
            }
        }
    }

    public final boolean s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.getPbModel() == null || this.a.getPbModel().O1() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean s6(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        tn4 tn4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048746, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P1() == null) {
                return false;
            }
            kp7 P1 = this.x0.P1();
            ThreadData O = P1.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !rc6.isOn()) || this.x0.G() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (P1.l() == null || !P1.l().isBlockBawuDelete) {
                if (P1.O() == null || !P1.O().isBlocked()) {
                    if (P1.V() != 0) {
                        return P1.V() != 3;
                    }
                    List<np4> p3 = P1.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (np4 np4Var : p3) {
                            if (np4Var != null && (tn4Var = np4Var.g) != null && tn4Var.a && !tn4Var.c && ((i3 = tn4Var.b) == 1 || i3 == 2)) {
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

    public final void t4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048747, this, str) == null) || TextUtils.isEmpty(str) || (pbModel = this.x0) == null || pbModel.P1() == null) {
            return;
        }
        ah8 z3 = this.x0.P1().z();
        if (z3 != null && str.equals(z3.N0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().h = null;
            }
            this.x0.P1().b();
        }
        ah8 i12 = this.x0.i1();
        if (i12 == null || !str.equals(i12.N0())) {
            return;
        }
        this.x0.U0();
    }

    public final boolean t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            PostData c4 = lp7.c(this.x0.P1(), this.x0.f2(), this.x0.Z1());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean t6(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048749, this, z3)) == null) {
            if (z3 || (pbModel = this.x0) == null || pbModel.P1() == null || (this.x0.P1().l() != null && this.x0.P1().l().isBlockBawuDelete)) {
                return false;
            }
            kp7 P1 = this.x0.P1();
            if ((P1.O() == null || P1.O().getAuthor() == null || !P1.O().getAuthor().isForumBusinessAccount() || rc6.isOn()) && !this.x0.G()) {
                return ((P1.O() != null && P1.O().isBlocked()) || this.x0.P1().V() == 0 || this.x0.P1().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (pbModel = this.x0) == null || ki.isEmpty(pbModel.h2())) {
            return;
        }
        super.taskStart();
    }

    public void u4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048752, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(ot7.i2)).intValue();
            if (intValue == ot7.j2) {
                if (this.A0.R()) {
                    return;
                }
                this.E0.e4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e73)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e6a) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6a)).booleanValue() : false;
                if (jSONArray != null) {
                    this.A0.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.A0.U(this.x0.P1().l().getId(), this.x0.P1().l().getName(), this.x0.P1().O().getId(), str, intValue3, intValue2, booleanValue, this.x0.P1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == ot7.k2 || intValue == ot7.m2) {
                PbModel pbModel = this.x0;
                if (pbModel != null && pbModel.k1() != null) {
                    this.x0.k1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ot7.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.s1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean u6(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048754, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || x5(i3));
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.repackage.pw7
    public PbModel v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? this.x0 : (PbModel) invokeV.objValue;
    }

    public void v4(dq4 dq4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048756, this, dq4Var, jSONArray) == null) {
            dq4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (dq4Var.getYesButtonTag() instanceof SparseArray) {
                    u4((SparseArray) dq4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean v5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048757, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public final boolean v6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.f2()) {
                return this.x0.N1() == null || this.x0.N1().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.pw7
    public AbsPbActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public void w4(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048760, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e56, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z3));
            sparseArray.put(ot7.i2, Integer.valueOf(ot7.j2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                u4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean w5(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048761, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.x0.P1().U() != null && (forumToolAuth = this.x0.P1().U().getForumToolAuth()) != null) {
                for (int i4 = 0; i4 < forumToolAuth.size(); i4++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i4);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void w6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048762, this, metaData) == null) || metaData == null) {
            return;
        }
        dq4 dq4Var = new dq4(getActivity());
        dq4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0a90));
        dq4Var.setTitleShowCenter(true);
        dq4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0a91));
        dq4Var.setMessageShowCenter(true);
        dq4Var.setCancelable(false);
        dq4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a92), new p1(this, metaData));
        dq4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a93), new q1(this, metaData));
        dq4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void x4(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048763, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            ot7 ot7Var = this.E0;
            if (ot7Var == null || this.x0 == null) {
                return;
            }
            if ((ot7Var != null && !ot7Var.H1()) || this.x0.P1() == null || this.x0.P1().S() == null) {
                return;
            }
            ot7 ot7Var2 = this.E0;
            if (ot7Var2 == null || ot7Var2.G0() == null || !this.E0.G0().r()) {
                yp7 S = this.x0.P1().S();
                if (checkUpIsLogin()) {
                    if ((!S.f() || S.a() != 2) && this.E0.A0() != null && this.E0.A0().z() != null) {
                        this.E0.A0().z().c0(this.x0.h2(), this.x0.getFromForumId());
                    }
                    if (UbsABTestHelper.isShowLikeAnimation() && i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        oo7 oo7Var = new oo7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.x0;
                        oo7Var.k(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                    } else if (System.currentTimeMillis() - this.x > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.x = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public boolean x5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048764, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048765, this) == null) {
            dq4 dq4Var = new dq4(getPageContext().getPageActivity());
            dq4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b2e));
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new b3(this));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new a(this));
            dq4Var.create(this.f1).show();
        }
    }

    public void y4() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || this.E0 == null || (pbModel = this.x0) == null) {
            return;
        }
        if ((pbModel.P1() == null && this.x0.P1().S() == null) || !checkUpIsLogin() || this.E0.A0() == null || this.E0.A0().z() == null) {
            return;
        }
        this.E0.A0().z().c0(this.x0.h2(), this.x0.getFromForumId());
    }

    public final boolean y5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048767, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public final void y6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048768, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091ea6) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e50) instanceof Integer)) {
            mq4 mq4Var = this.J0;
            if (mq4Var != null && mq4Var.isShowing()) {
                this.J0.dismiss();
                this.J0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea4);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                oq4 oq4Var = new oq4(getContext());
                oq4Var.n(new e0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e50) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e50)).intValue() : -1) == 1) {
                    arrayList.add(new kq4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04a4), oq4Var));
                }
                if (z3) {
                    arrayList.add(new kq4(1, getResources().getString(R.string.obfuscated_res_0x7f0f14a3), oq4Var));
                } else {
                    arrayList.add(new kq4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b2b), oq4Var));
                }
                oq4Var.j(arrayList);
                mq4 mq4Var2 = new mq4(getPageContext(), oq4Var);
                this.J0 = mq4Var2;
                mq4Var2.m();
            }
        }
    }

    @Override // com.repackage.pw7
    public PbFragment z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public final void z4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048770, this, str) == null) || (pbModel = this.x0) == null || pbModel.P1() == null || this.x0.P1().O() == null || !this.x0.P1().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.x0.P1().O();
        int i3 = 0;
        if (O.isBJHArticleThreadType()) {
            i3 = 1;
        } else if (O.isBJHVideoThreadType()) {
            i3 = 2;
        } else if (O.isBJHNormalThreadType()) {
            i3 = 3;
        } else if (O.isBJHVideoDynamicThreadType()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final boolean z5(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048771, this, z3)) == null) {
            PbModel pbModel = this.x0;
            return (pbModel == null || pbModel.P1() == null || this.x0.P1().O() == null || this.x0.P1().O().getAuthor() == null || TextUtils.equals(this.x0.P1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            showLoadingView(this.E0.m1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702be));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.E0.l1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }
}
