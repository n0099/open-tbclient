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
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
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
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import c.a.o0.b0.d;
import c.a.o0.e1.n.f;
import c.a.o0.h.a;
import c.a.o0.r.l0.f;
import c.a.o0.r.r.b1;
import c.a.o0.r.t.a;
import c.a.o0.r.t.c;
import c.a.o0.r.t.l;
import c.a.p0.a4.m0.a;
import c.a.p0.f1.i2.a.c;
import c.a.p0.s0.a;
import c.a.p0.s0.b;
import c.a.p0.w2.j.c;
import c.a.p0.w2.m.f.k0;
import c.a.p0.w2.m.f.k1.b;
import c.a.p0.w2.m.f.t;
import c.a.p0.w2.r.g;
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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
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
/* loaded from: classes5.dex */
public class PbFragment extends BaseFragment implements c.a.o0.e1.n.i, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.s, TbPageContextSupport, c.a.p0.w2.q.c, g.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k K2;
    public static final b.InterfaceC1370b L2;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.f.k.b<TextView> A;
    public c.a.o0.s.e.a A0;
    public CustomMessageListener A1;
    public final View.OnClickListener A2;
    public c.a.d.f.k.b<TbImageView> B;
    public c.a.p0.w2.i.w B0;
    public CustomMessageListener B1;
    public final ItemCardHelper.c B2;
    public c.a.d.f.k.b<ImageView> C;
    public ShareSuccessReplyToServerModel C0;
    public final CustomMessageListener C1;
    public final NoNetworkView.b C2;
    public c.a.d.f.k.b<View> D;
    public c.a.p0.w2.m.f.a1 D0;
    public CustomMessageListener D1;
    public View.OnTouchListener D2;
    public c.a.d.f.k.b<TiebaPlusRecommendCard> E;
    public boolean E0;
    public CustomMessageListener E1;
    public a.b E2;
    public c.a.d.f.k.b<LinearLayout> F;
    public boolean F0;
    public View.OnClickListener F1;
    public final t.b F2;
    public c.a.d.f.k.b<RelativeLayout> G;
    public boolean G0;
    public CustomMessageListener G1;
    public int G2;
    public c.a.d.f.k.b<ItemCardView> H;
    public c.a.p0.w2.m.f.c1 H0;
    public CustomMessageListener H1;
    public int H2;
    public boolean I;
    public c.a.o0.r.t.j I0;
    public CustomMessageListener I1;
    public String I2;
    public boolean J;
    public c.a.o0.r.t.l J0;
    public SuggestEmotionModel.c J1;
    public c.a.o0.r.r.u J2;
    public boolean K;
    public String K0;
    public CustomMessageListener K1;
    public c.a.d.f.k.b<GifView> L;
    public boolean L0;
    public GetSugMatchWordsModel.b L1;
    public String M;
    public boolean M0;
    public boolean M1;
    public boolean N;
    public boolean N0;
    public PraiseModel N1;
    public boolean O;
    public String O0;
    public b.h O1;
    public String P;
    public boolean P0;
    public CustomMessageListener P1;
    public c.a.p0.w2.m.f.j1.f.a Q;
    public c.a.p0.a4.k0.f Q0;
    public c.a.o0.j0.i Q1;
    public LikeModel R;
    public c.a.o0.w.y.g R0;
    public CheckRealNameModel.b R1;
    public View S;
    public c.a.o0.w.y.e S0;
    public c.a.p0.w2.j.c S1;
    public View T;
    public boolean T0;
    public CustomMessageListener T1;
    public View U;
    public PermissionJudgePolicy U0;
    public CustomMessageListener U1;
    public View V;
    public ReplyPrivacyCheckController V0;
    public CustomMessageListener V1;
    public String W;
    public c.a.p0.f1.i2.a.c W0;
    public CustomMessageListener W1;
    public int X;
    public c.a.p0.f1.i2.a.c X0;
    public CustomMessageListener X1;
    public boolean Y;
    public EmotionImageData Y0;
    public CustomMessageListener Y1;
    public int[] Z;
    public c.a.o0.w.y.c Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public c.a.o0.w.y.b a1;
    public a.e a2;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34890b;
    public c.a.o0.w.y.b b1;
    public l.e b2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34891c;
    public int c1;
    public SortSwitchButton.f c2;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.s0.b f34892d;
    public Object d1;
    public final View.OnClickListener d2;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.w2.m.f.k1.b f34893e;
    public c.a.d.a.f e1;
    public CustomMessageListener e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34894f;
    public c.a.o0.r.l0.c f1;
    public final NewWriteModel.g f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34895g;
    public int g0;
    public BdUniqueId g1;
    public NewWriteModel.g g2;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34896h;
    public int h0;
    public Runnable h1;
    public c.a.d.c.g.a h2;
    public boolean i;
    public int i0;
    public c.a.p0.w2.m.f.e1 i1;
    public final PbModel.g i2;
    public boolean j;
    public c.a.o0.r.r.k1 j0;
    public c.a.d.o.d.a j1;
    public CustomMessageListener j2;
    public VoiceManager k;
    public BdUniqueId k0;
    public String k1;
    public HttpMessageListener k2;
    public int l;
    public c.a.o0.r.g0.a l0;
    public TbRichTextMemeInfo l1;
    public final a.InterfaceC0810a l2;
    public c.a.o0.r.t.c m;
    public boolean m0;
    public boolean m1;
    public final AbsListView.OnScrollListener m2;
    public long n;
    public boolean n0;
    public int n1;
    public final c.a.d.a.e n2;
    public long o;
    public Object o0;
    public int o1;
    public final d3 o2;
    public long p;
    public boolean p0;
    public List<b3> p1;
    public final f.g p2;
    public long q;
    public c.a.p0.a4.k0.e q0;
    public int q1;
    public boolean q2;
    public long r;
    public boolean r0;
    public String r1;
    public final BdListView.p r2;
    public boolean s;
    @NonNull
    public TiePlusEventController.f s0;
    public c.a.p0.g0.a s1;
    public int s2;
    public boolean t;
    public c.a.p0.w2.m.f.m1.a t0;
    public final b3 t1;
    public final TbRichTextView.y t2;
    public c.a.o0.r0.b u;
    public PbInterviewStatusView.f u0;
    public final k0.b u1;
    public boolean u2;
    public long v;
    public final Handler v0;
    public final CustomMessageListener v1;
    public PostData v2;
    public boolean w;
    public PbModel w0;
    public CustomMessageListener w1;
    public final c.InterfaceC0843c w2;
    public long x;
    public c.a.p0.w2.m.g.a x0;
    public CustomMessageListener x1;
    public final c.InterfaceC0843c x2;
    public int y;
    public c.a.o0.h.a y0;
    public CustomMessageListener y1;
    public final AdapterView.OnItemClickListener y2;
    public String z;
    public ForumManageModel z0;
    public CustomMessageListener z1;
    public final View.OnLongClickListener z2;

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34897b;

        public a(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
            this.f34897b = pbFragment;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f34897b.D0.p3();
                MessageManager.getInstance().sendMessage(this.a);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f34898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f34899c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f34900d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34901e;

        public a0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
            this.f34901e = pbFragment;
            this.a = sparseArray;
            this.f34898b = z;
            this.f34899c = str;
            this.f34900d = str2;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                if (this.f34901e.I0 != null) {
                    this.f34901e.I0.dismiss();
                }
                if (i == 0) {
                    this.f34901e.D0.a2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091ebb);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091ebd);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091ebc);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f34898b, this.f34899c, str, str2, str3, 1, this.f34900d, this.f34901e.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.f34901e.g1);
                    this.f34901e.s6(this.f34898b, userMuteAddAndDelCustomMessage, this.f34900d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091eb9));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34902b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34903c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a1 a;

            public a(a1 a1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.a.p0.w2.m.f.c1 c1Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (c1Var = this.a.f34903c.H0) == null || c1Var.g() == null) {
                    return;
                }
                if (!this.a.f34903c.H0.g().e()) {
                    this.a.f34903c.H0.b(false);
                }
                this.a.f34903c.H0.g().l(false);
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

        public a1(PbFragment pbFragment, String str, String str2) {
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
            this.f34903c = pbFragment;
            this.a = str;
            this.f34902b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = c.a.d.f.p.n.i(this.f34903c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f2 = c.a.d.f.p.n.f(this.f34903c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f2 = c.a.d.f.p.n.f(this.f34903c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f2);
                PbFragment pbFragment = this.f34903c;
                boolean z = true;
                pbFragment.S4().F0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                if (this.f34903c.S4().P0() != null) {
                    this.f34903c.S0.a().setVisibility(8);
                    this.f34903c.S4().P0().o(this.a, this.f34902b, this.f34903c.S4().S0(), (this.f34903c.w0 == null || this.f34903c.w0.S0() == null || this.f34903c.w0.S0().O() == null || !this.f34903c.w0.S0().O().isBjh()) ? false : false);
                    c.a.o0.w.y.h b2 = this.f34903c.S4().P0().b();
                    if (b2 != null && this.f34903c.w0 != null && this.f34903c.w0.S0() != null) {
                        b2.G(this.f34903c.w0.S0().d());
                        b2.b0(this.f34903c.w0.S0().O());
                    }
                    if (this.f34903c.H0.f() == null && this.f34903c.S4().P0().b().t() != null) {
                        this.f34903c.S4().P0().b().t().f(new a(this));
                        PbFragment pbFragment2 = this.f34903c;
                        pbFragment2.H0.n(pbFragment2.S4().P0().b().t().h());
                        this.f34903c.S4().P0().b().M(this.f34903c.b1);
                    }
                }
                this.f34903c.S4().c1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f34904b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34905c;

        public a2(PbFragment pbFragment, MarkData markData, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34905c = pbFragment;
            this.a = markData;
            this.f34904b = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.f34905c.a.setResult(-1, intent);
                this.f34904b.dismiss();
                this.f34905c.x6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements k0.b {
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

        @Override // c.a.p0.w2.m.f.k0.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.D0.G3(str);
        }

        @Override // c.a.p0.w2.m.f.k0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.D0.D3(!this.a.N);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34906b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34907c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$b1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C1882a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C1882a(a aVar) {
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
                    c.a.p0.w2.m.f.c1 c1Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (c1Var = this.a.a.f34907c.H0) == null || c1Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.f34907c.H0.g().e()) {
                        this.a.a.f34907c.H0.b(false);
                    }
                    this.a.a.f34907c.H0.g().l(false);
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

            public a(b1 b1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = b1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = c.a.d.f.p.n.i(this.a.f34907c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f2);
                    PbFragment pbFragment = this.a.f34907c;
                    boolean z = true;
                    pbFragment.S4().F0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                    if (this.a.f34907c.S4().P0() != null) {
                        this.a.f34907c.S0.a().setVisibility(8);
                        z = (this.a.f34907c.w0 == null || this.a.f34907c.w0.S0() == null || this.a.f34907c.w0.S0().O() == null || !this.a.f34907c.w0.S0().O().isBjh()) ? false : false;
                        c.a.p0.w2.m.f.x P0 = this.a.f34907c.S4().P0();
                        b1 b1Var = this.a;
                        P0.o(b1Var.a, b1Var.f34906b, b1Var.f34907c.S4().S0(), z);
                        c.a.o0.w.y.h b2 = this.a.f34907c.S4().P0().b();
                        if (b2 != null && this.a.f34907c.w0 != null && this.a.f34907c.w0.S0() != null) {
                            b2.G(this.a.f34907c.w0.S0().d());
                            b2.b0(this.a.f34907c.w0.S0().O());
                        }
                        if (this.a.f34907c.H0.f() == null && this.a.f34907c.S4().P0().b().t() != null) {
                            this.a.f34907c.S4().P0().b().t().f(new C1882a(this));
                            PbFragment pbFragment2 = this.a.f34907c;
                            pbFragment2.H0.n(pbFragment2.S4().P0().b().t().h());
                            this.a.f34907c.S4().P0().b().M(this.a.f34907c.b1);
                        }
                    }
                    this.a.f34907c.S4().c1();
                }
            }
        }

        public b1(PbFragment pbFragment, String str, String str2) {
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
            this.f34907c = pbFragment;
            this.a = str;
            this.f34906b = str2;
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.d.f.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f34908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34909c;

        public b2(PbFragment pbFragment, MarkData markData, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34909c = pbFragment;
            this.a = markData;
            this.f34908b = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f34909c.D0 != null && this.f34909c.D0.a1() != null) {
                    this.f34909c.D0.a1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.f34909c.a.setResult(-1, intent);
                    this.f34908b.dismiss();
                    this.f34909c.x6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public class c extends c.a.o0.c1.k0<ShareItem> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.p0.w2.m.f.n1.b.d(this.a.x4(), ShareSwitch.isOn() ? 1 : 6, this.a.w0);
            }
            return (ShareItem) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f30338c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.K2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.y4().s() != null && this.a.y4().s().getGodUserData() != null) {
                        this.a.y4().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.w0 == null || this.a.w0.S0() == null || this.a.w0.S0().O() == null || this.a.w0.S0().O().getAuthor() == null) {
                        return;
                    }
                    this.a.w0.S0().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements l.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.o0.r.t.j a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f34910b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c1 f34911c;

            public a(c1 c1Var, c.a.o0.r.t.j jVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var, jVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34911c = c1Var;
                this.a = jVar;
                this.f34910b = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f34911c.a.w0.h1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // c.a.o0.r.t.l.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
                boolean H2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, lVar, i, view) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.f34911c.a.w0.h1() != 1 || i != 1) {
                    if (this.f34911c.a.w0.h1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.f34911c.a.w0.h1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f34910b.getId() != R.id.obfuscated_res_0x7f091723 ? 1 : 0).param("obj_type", i2));
                    if (this.f34911c.a.w0.S0().f19819f != null && this.f34911c.a.w0.S0().f19819f.size() > i) {
                        i = this.f34911c.a.w0.S0().f19819f.get(i).sort_type.intValue();
                    }
                    H2 = this.f34911c.a.w0.H2(i);
                    this.f34910b.setTag(Integer.valueOf(this.f34911c.a.w0.g1()));
                    if (H2) {
                        return;
                    }
                    this.f34911c.a.i = true;
                    this.f34911c.a.D0.J2(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f34910b.getId() != R.id.obfuscated_res_0x7f091723 ? 1 : 0).param("obj_type", i2));
                if (this.f34911c.a.w0.S0().f19819f != null) {
                    i = this.f34911c.a.w0.S0().f19819f.get(i).sort_type.intValue();
                }
                H2 = this.f34911c.a.w0.H2(i);
                this.f34910b.setTag(Integer.valueOf(this.f34911c.a.w0.g1()));
                if (H2) {
                }
            }
        }

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

        /* JADX WARN: Code restructure failed: missing block: B:902:0x2145, code lost:
            if (r38.a.D0.U0.f20017c.b().getTop() <= ((r38.a.D0.Q0() == null || r38.a.D0.Q0().c() == null) ? 0 : r38.a.D0.Q0().c().getBottom())) goto L843;
         */
        /* JADX WARN: Code restructure failed: missing block: B:903:0x2147, code lost:
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:905:0x2154, code lost:
            if (r0 >= c.a.p0.w2.m.f.i1.k.c(r38.a.J4())) goto L843;
         */
        /* JADX WARN: Code restructure failed: missing block: B:927:0x21fb, code lost:
            if ((r38.a.D0.U0.f20017c.b().getTop() - r38.a.D0.f19993h.a.getBottom()) < (r38.a.D0.U0.f20017c.f34999g.getHeight() + 10)) goto L843;
         */
        /* JADX WARN: Removed duplicated region for block: B:1173:0x2ae3  */
        /* JADX WARN: Removed duplicated region for block: B:1174:0x2af9  */
        /* JADX WARN: Removed duplicated region for block: B:1177:0x2b35  */
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
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            c.a.o0.r.t.h hVar;
            c.a.o0.r.t.h hVar2;
            c.a.o0.r.t.h hVar3;
            PbFragment pbFragment;
            int i;
            boolean z;
            c.a.o0.r.t.h hVar4;
            c.a.o0.r.t.h hVar5;
            c.a.o0.r.t.h hVar6;
            c.a.o0.r.t.h hVar7;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            c.a.o0.r.r.d2 d2Var;
            String jumpUrlWithTid;
            String[] strArr;
            c.a.p0.w2.i.f S0;
            int i4;
            int i5;
            boolean G2;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.a.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.a.D0.I0() && this.a.getPageContext().getPageActivity() != null && this.a.w0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.k1(), this.a.w0.z1(), this.a.w0.y1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.w0.getForumId());
                        statisticItem2.param("fname", this.a.w0.s0());
                        statisticItem2.param("tid", this.a.w0.k1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view == this.a.D0.K0()) {
                        if (this.a.i) {
                            return;
                        }
                        if (this.a.w0.K1(true)) {
                            this.a.i = true;
                            this.a.D0.W2();
                        }
                    } else if (view != this.a.D0.f19993h.m()) {
                        if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().m()) {
                            int i7 = 3;
                            if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().d()) {
                                if (view == this.a.D0.f19993h.f20284f) {
                                    if (this.a.D0.T(this.a.w0.G0())) {
                                        this.a.w6();
                                        return;
                                    }
                                    this.a.j = false;
                                    this.a.f34894f = false;
                                    c.a.d.f.p.n.w(this.a.a, this.a.D0.f19993h.f20284f);
                                    this.a.a.finish();
                                } else if (view != this.a.D0.q0() && (this.a.D0.f19993h.n() == null || (view != this.a.D0.f19993h.n().n() && view != this.a.D0.f19993h.n().o()))) {
                                    if (view == this.a.D0.y0()) {
                                        if (this.a.w0 != null) {
                                            c.a.o0.l.a.m(this.a.getPageContext().getPageActivity(), this.a.w0.S0().O().getTopicData().b());
                                        }
                                    } else if (view != this.a.D0.f19993h.f20281c) {
                                        if (view == this.a.D0.f19993h.f20282d) {
                                            if (c.a.o0.c1.q.a()) {
                                                return;
                                            }
                                            if (this.a.w0 != null && this.a.w0.S0() != null) {
                                                ArrayList<PostData> F = this.a.w0.S0().F();
                                                if ((F == null || F.size() <= 0) && this.a.w0.i1()) {
                                                    c.a.d.f.p.n.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.w0.k1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.w0.getForumId()));
                                                if (!this.a.D0.F1()) {
                                                    this.a.D0.s2();
                                                }
                                                this.a.I5();
                                            } else {
                                                c.a.d.f.p.n.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                                                return;
                                            }
                                        } else if (view.getId() == R.id.obfuscated_res_0x7f0916c6) {
                                            if (c.a.d.f.p.l.z()) {
                                                this.a.D0.G2(true);
                                                this.a.D0.s2();
                                                if (this.a.i) {
                                                    return;
                                                }
                                                this.a.i = true;
                                                this.a.D0.z3();
                                                this.a.w6();
                                                this.a.D0.V2();
                                                this.a.w0.F2(this.a.B4());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                return;
                                            }
                                        } else if (view.getId() != R.id.obfuscated_res_0x7f0916a3) {
                                            if ((this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().k()) && view.getId() != R.id.obfuscated_res_0x7f0909e0 && view.getId() != R.id.obfuscated_res_0x7f091a6d) {
                                                if (this.a.D0.f19993h.n() != null && view == this.a.D0.f19993h.n().g()) {
                                                    this.a.D0.f19993h.k();
                                                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb) {
                                                    if (!this.a.e4(11009)) {
                                                        return;
                                                    }
                                                    this.a.g5(3);
                                                } else if (view.getId() != R.id.obfuscated_res_0x7f0916a9) {
                                                    if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().l()) {
                                                        if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().s()) {
                                                            if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().r()) {
                                                                if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().p()) {
                                                                    if (this.a.D0.C0() == view) {
                                                                        if (this.a.D0.C0().getIndicateStatus()) {
                                                                            c.a.p0.w2.i.f S02 = this.a.w0.S0();
                                                                            if (S02 != null && S02.O() != null && S02.O().getTaskInfoData() != null) {
                                                                                String d2 = S02.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d2)) {
                                                                                    d2 = S02.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d2));
                                                                            }
                                                                        } else {
                                                                            c.a.p0.a4.m0.a.d("c10725", null);
                                                                        }
                                                                        this.a.Y4();
                                                                    } else if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().i()) {
                                                                        if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().c()) {
                                                                            if (this.a.D0.f19993h.n() != null && view == this.a.D0.f19993h.n().h()) {
                                                                                if (c.a.d.f.p.l.z()) {
                                                                                    SparseArray<Object> G0 = this.a.D0.G0(this.a.w0.S0(), this.a.w0.i1(), 1);
                                                                                    if (G0 != null) {
                                                                                        if (StringUtils.isNull((String) G0.get(R.id.obfuscated_res_0x7f091e6a))) {
                                                                                            this.a.D0.a2(((Integer) G0.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) G0.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) G0.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) G0.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                                                                                        } else {
                                                                                            this.a.D0.b2(((Integer) G0.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) G0.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) G0.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) G0.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue(), (String) G0.get(R.id.obfuscated_res_0x7f091e6a));
                                                                                        }
                                                                                    }
                                                                                    this.a.D0.f19993h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() != R.id.obfuscated_res_0x7f091dc6 && view.getId() != R.id.obfuscated_res_0x7f091dc4 && view.getId() != R.id.obfuscated_res_0x7f0916b6 && view.getId() != R.id.obfuscated_res_0x7f09155d) {
                                                                                if (view.getId() == R.id.obfuscated_res_0x7f091715) {
                                                                                    if (this.a.w0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.w0.k1());
                                                                                    statisticItem3.param("fid", this.a.w0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view.getId() == R.id.obfuscated_res_0x7f091715 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.T = view;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f091e85) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e85);
                                                                                        StatisticItem statisticItem4 = postData.i0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.w0 == null || this.a.w0.S0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String k1 = this.a.w0.k1();
                                                                                        String G = postData.G();
                                                                                        int V = this.a.w0.S0() != null ? this.a.w0.S0().V() : 0;
                                                                                        AbsPbActivity.e L5 = this.a.L5(G);
                                                                                        if (L5 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(k1, G, "pb", true, false, null, false, null, V, postData.S(), this.a.w0.S0().d(), false, postData.s().getIconInfo(), 5).addBigImageData(L5.a, L5.f34853b, L5.f34858g, L5.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.w0.R0());
                                                                                        addBigImageData.setFromFrsForumId(this.a.w0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.w0.p1());
                                                                                        addBigImageData.setKeyFromForumId(this.a.w0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.w0.H(), this.a.w0.D(), this.a.w0.E(), this.a.w0.C(), this.a.w0.I());
                                                                                        addBigImageData.setBjhData(this.a.w0.l0());
                                                                                        if (this.a.w0.S0().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.w0.S0().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.w0.S0().U() != null) {
                                                                                            addBigImageData.setIsManager(this.a.w0.S0().U().getIs_manager());
                                                                                        }
                                                                                        if (this.a.w0.S0().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.w0.S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.w0.S0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.w0.S0().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.w0.S0().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.w0.S0().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.D0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.D0.w0(this.a.w0.G, this.a.w0.i1()).Q || postData.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view.getId() == R.id.obfuscated_res_0x7f091713 || view.getId() == R.id.obfuscated_res_0x7f0918b2 || view.getId() == R.id.obfuscated_res_0x7f0916b0) {
                                                                                    if (this.a.w0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view.getId() == R.id.obfuscated_res_0x7f091713) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.w0.k1());
                                                                                        statisticItem5.param("fid", this.a.w0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view.getId() == R.id.obfuscated_res_0x7f0918b2) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.U = view;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view.getId() == R.id.obfuscated_res_0x7f091713 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.U = view;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f091e85) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e85);
                                                                                    if (view.getId() == R.id.obfuscated_res_0x7f091713 && (statisticItem = postData2.i0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view.getId() == R.id.obfuscated_res_0x7f0918b2 || view.getId() == R.id.obfuscated_res_0x7f0916b0) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.w0.l1()).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.w0 == null || this.a.w0.S0() == null || this.a.S4().O0() == null || postData2.s() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.S4().P0() != null) {
                                                                                        this.a.S4().P0().c();
                                                                                    }
                                                                                    if (this.a.r0 && postData2.P() != null && postData2.P().size() != 0) {
                                                                                        this.a.v6(postData2, true);
                                                                                    } else {
                                                                                        c.a.p0.w2.i.u uVar = new c.a.p0.w2.i.u();
                                                                                        uVar.A(this.a.w0.S0().l());
                                                                                        uVar.E(this.a.w0.S0().O());
                                                                                        uVar.C(postData2);
                                                                                        this.a.S4().O0().U(uVar);
                                                                                        this.a.S4().O0().setPostId(postData2.G());
                                                                                        this.a.y5(view, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.S0 != null) {
                                                                                            this.a.D0.A2(this.a.S0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view.getId() != R.id.obfuscated_res_0x7f0916b4) {
                                                                                    if (view != this.a.D0.A0()) {
                                                                                        if (view == this.a.D0.f19993h.o()) {
                                                                                            this.a.D0.d3();
                                                                                        } else if (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().q()) {
                                                                                            if (this.a.D0.f19993h.n() != null && view == this.a.D0.f19993h.n().j()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.w0.k1())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.D0.f19993h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f091732) {
                                                                                                    if (!this.a.checkUpIsLogin() || (d2Var = (c.a.o0.r.r.d2) view.getTag()) == null || StringUtils.isNull(d2Var.J0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{d2Var.J0()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091a70 || id == R.id.obfuscated_res_0x7f09070d || id == R.id.obfuscated_res_0x7f091a71 || id == R.id.obfuscated_res_0x7f09070e) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view != null && view.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091e85);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091a71 || id == R.id.obfuscated_res_0x7f09070e) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.w0.f34970b));
                                                                                                        }
                                                                                                        if (this.a.J0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.J0 = new c.a.o0.r.t.l(pbFragment2.getContext());
                                                                                                            this.a.J0.n(this.a.b2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.o5(view);
                                                                                                        if (this.a.o5(view) && this.a.j1 != null) {
                                                                                                            this.a.j1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f091e82) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e82)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e79) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.N() != null && postData3.N().toString().length() > 0) {
                                                                                                                c.a.o0.r.t.h hVar8 = new c.a.o0.r.t.h(3, this.a.getString(R.string.obfuscated_res_0x7f0f0435), this.a.J0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091e69, postData3);
                                                                                                                hVar8.f11053d.setTag(sparseArray5);
                                                                                                                arrayList.add(hVar8);
                                                                                                            }
                                                                                                            this.a.v2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.w0.S0().r()) {
                                                                                                            String u = this.a.w0.S0().u();
                                                                                                            if (postData3 != null && !c.a.d.f.p.m.isEmpty(u) && u.equals(postData3.G())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    hVar4 = new c.a.o0.r.t.h(4, this.a.getString(R.string.obfuscated_res_0x7f0f0f80), this.a.J0);
                                                                                                                } else {
                                                                                                                    hVar4 = new c.a.o0.r.t.h(4, this.a.getString(R.string.obfuscated_res_0x7f0f0a7f), this.a.J0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091e69, this.a.v2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
                                                                                                                hVar4.f11053d.setTag(sparseArray6);
                                                                                                                arrayList.add(hVar4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (c.a.p0.w2.m.f.n1.a.h(this.a.w0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.s5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            c.a.o0.r.t.h hVar9 = new c.a.o0.r.t.h(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa2), this.a.J0);
                                                                                                                            hVar9.f11053d.setTag(str);
                                                                                                                            arrayList.add(hVar9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        c.a.o0.r.t.h hVar10 = new c.a.o0.r.t.h(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b17), this.a.J0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e80, sparseArray4.get(R.id.obfuscated_res_0x7f091e80));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091eba, sparseArray4.get(R.id.obfuscated_res_0x7f091eba));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ebb, sparseArray4.get(R.id.obfuscated_res_0x7f091ebb));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091eb9, sparseArray4.get(R.id.obfuscated_res_0x7f091eb9));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ebc, sparseArray4.get(R.id.obfuscated_res_0x7f091ebc));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ebd, sparseArray4.get(R.id.obfuscated_res_0x7f091ebd));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6c, sparseArray4.get(R.id.obfuscated_res_0x7f091e6c));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6d, sparseArray4.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6b, sparseArray4.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e88, sparseArray4.get(R.id.obfuscated_res_0x7f091e88));
                                                                                                                        hVar4.f11053d.setTag(sparseArray7);
                                                                                                                        arrayList.add(hVar10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e88, sparseArray4.get(R.id.obfuscated_res_0x7f091e88));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e76, sparseArray4.get(R.id.obfuscated_res_0x7f091e76));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e77, sparseArray4.get(R.id.obfuscated_res_0x7f091e77));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e78, sparseArray4.get(R.id.obfuscated_res_0x7f091e78));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e79, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e80, sparseArray4.get(R.id.obfuscated_res_0x7f091e80));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eba, sparseArray4.get(R.id.obfuscated_res_0x7f091eba));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ebb, sparseArray4.get(R.id.obfuscated_res_0x7f091ebb));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eb9, sparseArray4.get(R.id.obfuscated_res_0x7f091eb9));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ebc, sparseArray4.get(R.id.obfuscated_res_0x7f091ebc));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ebd, sparseArray4.get(R.id.obfuscated_res_0x7f091ebd));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e6b, sparseArray4.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e6d, sparseArray4.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e7d, sparseArray4.get(R.id.obfuscated_res_0x7f091e7d));
                                                                                                                            if (booleanValue6) {
                                                                                                                                c.a.o0.r.t.h hVar11 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f048e), this.a.J0);
                                                                                                                                hVar11.f11053d.setTag(sparseArray8);
                                                                                                                                hVar6 = hVar11;
                                                                                                                                hVar5 = new c.a.o0.r.t.h(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d3), this.a.J0);
                                                                                                                                hVar5.f11053d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        hVar6 = null;
                                                                                                                        hVar5 = new c.a.o0.r.t.h(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d3), this.a.J0);
                                                                                                                        hVar5.f11053d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e88, sparseArray4.get(R.id.obfuscated_res_0x7f091e88));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e6b, sparseArray4.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e6d, sparseArray4.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e7d, sparseArray4.get(R.id.obfuscated_res_0x7f091e7d));
                                                                                                                        if (this.a.w0.S0().V() == 1002 && !booleanValue) {
                                                                                                                            hVar7 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa2), this.a.J0);
                                                                                                                        } else {
                                                                                                                            hVar7 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f048e), this.a.J0);
                                                                                                                        }
                                                                                                                        hVar7.f11053d.setTag(sparseArray9);
                                                                                                                        hVar6 = hVar7;
                                                                                                                        hVar5 = null;
                                                                                                                    } else {
                                                                                                                        hVar5 = null;
                                                                                                                        hVar6 = null;
                                                                                                                    }
                                                                                                                    if (hVar6 != null) {
                                                                                                                        arrayList.add(hVar6);
                                                                                                                    }
                                                                                                                    if (hVar5 != null) {
                                                                                                                        arrayList.add(hVar5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.a.J0.j(arrayList);
                                                                                                                this.a.I0 = new c.a.o0.r.t.j(this.a.getPageContext(), this.a.J0);
                                                                                                                this.a.I0.m();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091e69, this.a.v2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
                                                                                                        hVar4.f11053d.setTag(sparseArray62);
                                                                                                        arrayList.add(hVar4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.J0.j(arrayList);
                                                                                                        this.a.I0 = new c.a.o0.r.t.j(this.a.getPageContext(), this.a.J0);
                                                                                                        this.a.I0.m();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09168a) {
                                                                                                    if (this.a.w0.S0() != null && this.a.w0.S0().O() != null && this.a.w0.S0().O().getActUrl() != null) {
                                                                                                        c.a.o0.l.a.m(this.a.getActivity(), this.a.w0.S0().O().getActUrl());
                                                                                                        if (this.a.w0.S0().O().getActInfoType() != 1) {
                                                                                                            if (this.a.w0.S0().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091349) {
                                                                                                    if (view.getTag(R.id.obfuscated_res_0x7f091e94) instanceof String) {
                                                                                                        String str2 = (String) view.getTag(R.id.obfuscated_res_0x7f091e94);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.w0.S0().m()).param("tid", this.a.w0.S0().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.w0.S0().Q().equals(str2)) {
                                                                                                            this.a.D0.Z2(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916de) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f133a);
                                                                                                        String q = c.a.o0.r.j0.b.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            c.a.o0.l.a.q(view.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.D0.s2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f090ffb) {
                                                                                                    if (view != null) {
                                                                                                        c.a.o0.l.a.m(this.a.getActivity(), (String) view.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.x4() == 1 && this.a.w0 != null && this.a.w0.S0() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.w0.S0().m()).param("tid", this.a.w0.S0().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09133c) {
                                                                                                    if (view != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        c.a.o0.l.a.m(this.a.getActivity(), (String) view.getTag());
                                                                                                        if (this.a.x4() == 1 && this.a.w0 != null && this.a.w0.S0() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.w0.S0().m()).param("tid", this.a.w0.S0().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091393) {
                                                                                                    this.a.x5();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091392) {
                                                                                                    this.a.u5();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0924c8) {
                                                                                                    if (this.a.w0 != null && this.a.w0.S0() != null && this.a.w0.S0().A() != null) {
                                                                                                        c.a.p0.w2.i.f S03 = this.a.w0.S0();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", S03.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S03.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0924c5) {
                                                                                                    if (this.a.w0 != null && this.a.w0.S0() != null && this.a.w0.S0().A() != null) {
                                                                                                        c.a.p0.w2.i.f S04 = this.a.w0.S0();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", S04.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{S04.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0921e9) {
                                                                                                    if (this.a.n1 >= 0) {
                                                                                                        if (this.a.w0 != null) {
                                                                                                            this.a.w0.i2();
                                                                                                        }
                                                                                                        if (this.a.w0 == null || this.a.D0.o0() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            i3 = 0;
                                                                                                            this.a.D0.o0().f0(this.a.w0.S0(), false);
                                                                                                        }
                                                                                                        this.a.n1 = i3;
                                                                                                        if (this.a.w0 != null) {
                                                                                                            this.a.D0.F0().setSelection(this.a.w0.L0());
                                                                                                            this.a.w0.m2(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091991) {
                                                                                                    if (!this.a.e4(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.g5(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09155d) {
                                                                                                    SparseArray sparseArray10 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.u6(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916a5) {
                                                                                                    if (this.a.D0.F0() == null || this.a.w0 == null || this.a.w0.S0() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.D0.F0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.D0.F0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean r0 = this.a.w0.S0().r0();
                                                                                                    boolean z3 = this.a.D0.Q0() != null && this.a.D0.Q0().g();
                                                                                                    boolean D1 = this.a.D0.D1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!r0 || this.a.D0.Q0() == null || this.a.D0.Q0().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (c.a.d.f.p.n.k(this.a.getContext()) * 0.5625d)) - this.a.D0.Q0().e();
                                                                                                        i2 = k;
                                                                                                        z4 = firstVisiblePosition == 0 && (top == k || top == this.a.D0.Q0().c().getHeight() - this.a.D0.Q0().e());
                                                                                                    }
                                                                                                    this.a.s4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.a.w0.S0().O() != null && this.a.w0.S0().O().getReply_num() <= 0) || (D1 && z4)) {
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.K5();
                                                                                                        if (this.a.w0.S0().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.f34970b).param("fid", this.a.w0.S0().m()).param("obj_locate", 2).param("uid", this.a.w0.S0().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i8 = (int) (c.a.d.f.p.n.i(this.a.getContext()) * 0.6d);
                                                                                                        if (r0) {
                                                                                                            if (this.a.D0.U0 != null && this.a.D0.U0.f20017c != null && this.a.D0.U0.f20017c.b() != null) {
                                                                                                                if (this.a.D0.U0.f20017c.b().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.a.D0.N0() != null) {
                                                                                                                z2 = this.a.D0.N0().getVisibility() == 0;
                                                                                                                if (!z2 && this.a.D0.U0 != null && this.a.D0.U0.f20017c != null && this.a.D0.U0.f20017c.b() != null && this.a.D0.U0.f20017c.b().getParent() != null && this.a.D0.f19993h != null && this.a.D0.f19993h.a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || D1) {
                                                                                                            this.a.h0 = firstVisiblePosition;
                                                                                                            this.a.i0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i8))) {
                                                                                                                this.a.D0.F0().setSelectionFromTop(0, i2 - i8);
                                                                                                                this.a.D0.F0().smoothScrollBy(-i8, 500);
                                                                                                            } else {
                                                                                                                this.a.D0.F0().E(0, i2, 500);
                                                                                                            }
                                                                                                        } else if (this.a.h0 > 0) {
                                                                                                            if (this.a.D0.F0().getChildAt(this.a.h0) != null) {
                                                                                                                this.a.D0.F0().E(this.a.h0, this.a.i0, 200);
                                                                                                            } else {
                                                                                                                this.a.D0.F0().setSelectionFromTop(this.a.h0, this.a.i0 + i8);
                                                                                                                this.a.D0.F0().smoothScrollBy(i8, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int c2 = c.a.p0.w2.m.f.i1.k.c(this.a.getListView());
                                                                                                            if (c.a.p0.w2.m.f.i1.k.d(this.a.getListView()) != -1) {
                                                                                                                c2--;
                                                                                                            }
                                                                                                            int f2 = c.a.d.f.p.n.f(this.a.getContext(), R.dimen.tbds100);
                                                                                                            if (c2 < 0) {
                                                                                                                c2 = (ListUtils.getCount(this.a.D0.F0().getData()) - 1) + this.a.D0.F0().getHeaderViewsCount();
                                                                                                                f2 = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!r0 || this.a.D0.Q0() == null) {
                                                                                                                    if (this.a.D0.f19993h != null && this.a.D0.f19993h.a != null) {
                                                                                                                        fixedNavHeight = this.a.D0.f19993h.a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.a.D0.U0 != null || this.a.D0.U0.f20017c == null || this.a.D0.U0.f20017c.b() == null || this.a.D0.U0.f20017c.b().getParent() == null) {
                                                                                                                        this.a.D0.F0().setSelectionFromTop(c2, f2 + i8);
                                                                                                                        this.a.D0.F0().smoothScrollBy(i8, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.a.D0.F0().E(c2, f2, 200);
                                                                                                                    } else {
                                                                                                                        this.a.D0.F0().smoothScrollBy(this.a.D0.U0.f20017c.b().getTop() - ((int) (c.a.d.f.p.n.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.D0.Q0().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (c.a.d.f.p.n.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f2 += fixedNavHeight;
                                                                                                            if (this.a.D0.U0 != null) {
                                                                                                            }
                                                                                                            this.a.D0.F0().setSelectionFromTop(c2, f2 + i8);
                                                                                                            this.a.D0.F0().smoothScrollBy(i8, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.w0.S0().O() != null && this.a.w0.S0().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.f34970b).param("fid", this.a.w0.S0().m()).param("obj_locate", 2).param("uid", this.a.w0.S0().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091701 || id == R.id.obfuscated_res_0x7f091702) {
                                                                                                    if (this.a.w0 == null || this.a.w0.S0() == null || this.a.w0.S0().l() == null || c.a.d.f.p.m.isEmpty(this.a.w0.S0().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.w0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.w0.s0()) || this.a.w0.i0() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.w0.i0().f19811b;
                                                                                                    } else {
                                                                                                        name = this.a.w0.S0().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String s0 = this.a.w0.s0();
                                                                                                    if (this.a.w0.y0() && s0 != null && s0.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.w0.S0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.w0.k1());
                                                                                                    statisticItem6.param("fid", this.a.w0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.w0.S0().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.w0.S0().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a68 && id != R.id.obfuscated_res_0x7f090a3a && id != R.id.obfuscated_res_0x7f090a3c && id != R.id.obfuscated_res_0x7f090a3b) {
                                                                                                    if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.w0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.w0.k1());
                                                                                                        statisticItem7.param("fid", this.a.w0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091728) {
                                                                                                        if (this.a.w0 == null || this.a.w0.S0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        c.a.p0.w2.i.f S05 = this.a.w0.S0();
                                                                                                        if (this.a.B0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.B0 = new c.a.p0.w2.i.w(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g2 = c.a.d.f.m.b.g(S05.Q(), 0L);
                                                                                                        long g3 = c.a.d.f.m.b.g(S05.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g3).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.h2);
                                                                                                        this.a.B0.a(g2, g3);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f09174b) {
                                                                                                        if (view.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                            if (!c.a.p0.b0.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                c.a.o0.l.a.m(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.w0.k1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e38) {
                                                                                                        if (!(view.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e35) {
                                                                                                        if (!(view.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view.getTag();
                                                                                                        if (this.a.R != null) {
                                                                                                            this.a.R.P(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0916b8 || id == R.id.obfuscated_res_0x7f09170d) {
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.w0.k1());
                                                                                                        statisticItem8.param("fid", this.a.w0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.f34890b = false;
                                                                                                        pbFragment5.k4(view);
                                                                                                    }
                                                                                                } else if (!(view.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view.getTag();
                                                                                                    if (this.a.w0.R0() == 3 && this.a.isSimpleForum() && this.a.w0.S0() != null && ListUtils.isEmpty(this.a.w0.S0().p())) {
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
                                                                                            this.a.D0.f19993h.l();
                                                                                            this.a.D0.w3(this.a.y2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, c.a.d.f.m.b.g(this.a.w0.S0().m(), 0L), c.a.d.f.m.b.g(this.a.w0.k1(), 0L), c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.w0.S0().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view.getTag();
                                                                                    } catch (ClassCastException e2) {
                                                                                        e2.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData4 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
                                                                                    if (postData4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.J0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.J0 = new c.a.o0.r.t.l(pbFragment6.getContext());
                                                                                        this.a.J0.n(this.a.b2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.w().S0() != null && this.a.w().S0().g0();
                                                                                    if (view != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
                                                                                        if (postData4.q() != null) {
                                                                                            boolean z6 = postData4.q().hasAgree;
                                                                                            int r = postData4.r();
                                                                                            if (z6 && r == 5) {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0083;
                                                                                            } else {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0085;
                                                                                            }
                                                                                            c.a.o0.r.t.h hVar12 = new c.a.o0.r.t.h(8, pbFragment.getString(i), this.a.J0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(R.id.obfuscated_res_0x7f091e69, postData4);
                                                                                            hVar12.f11053d.setTag(sparseArray11);
                                                                                            arrayList2.add(hVar12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (c.a.p0.w2.m.f.n1.a.h(this.a.w0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.s5(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    c.a.o0.r.t.h hVar13 = new c.a.o0.r.t.h(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa2), this.a.J0);
                                                                                                    hVar13.f11053d.setTag(str3);
                                                                                                    arrayList2.add(hVar13);
                                                                                                }
                                                                                            } else {
                                                                                                c.a.o0.r.t.h hVar14 = new c.a.o0.r.t.h(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b17), this.a.J0);
                                                                                                SparseArray sparseArray12 = new SparseArray();
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                                                                                                hVar14.f11053d.setTag(sparseArray12);
                                                                                                arrayList2.add(hVar14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray13 = new SparseArray();
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e79, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                                                                                                    if (booleanValue12) {
                                                                                                        c.a.o0.r.t.h hVar15 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f048e), this.a.J0);
                                                                                                        hVar15.f11053d.setTag(sparseArray13);
                                                                                                        hVar2 = hVar15;
                                                                                                        hVar = new c.a.o0.r.t.h(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d3), this.a.J0);
                                                                                                        hVar.f11053d.setTag(sparseArray13);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                                                                                                }
                                                                                                hVar2 = null;
                                                                                                hVar = new c.a.o0.r.t.h(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d3), this.a.J0);
                                                                                                hVar.f11053d.setTag(sparseArray13);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                                                                                                if (this.a.w0.S0().V() == 1002 && !booleanValue7) {
                                                                                                    hVar3 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa2), this.a.J0);
                                                                                                } else {
                                                                                                    hVar3 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f048e), this.a.J0);
                                                                                                }
                                                                                                hVar3.f11053d.setTag(sparseArray14);
                                                                                                hVar2 = hVar3;
                                                                                                hVar = null;
                                                                                            } else {
                                                                                                hVar = null;
                                                                                                hVar2 = null;
                                                                                            }
                                                                                            if (hVar2 != null) {
                                                                                                arrayList2.add(hVar2);
                                                                                            }
                                                                                            if (hVar != null) {
                                                                                                arrayList2.add(hVar);
                                                                                            }
                                                                                        }
                                                                                        this.a.J0.j(arrayList2);
                                                                                        this.a.I0 = new c.a.o0.r.t.j(this.a.getPageContext(), this.a.J0);
                                                                                        this.a.I0.m();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view.getId() == R.id.obfuscated_res_0x7f09155d) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.w0.k1());
                                                                                    statisticItem10.param("fid", this.a.w0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view.getId() == R.id.obfuscated_res_0x7f0916b6 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.T = view;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.w0 == null || this.a.w0.S0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.D0.d0();
                                                                                    SparseArray sparseArray15 = (SparseArray) view.getTag();
                                                                                    PostData postData5 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091e85);
                                                                                    PostData postData6 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091e86);
                                                                                    View view2 = (View) sparseArray15.get(R.id.obfuscated_res_0x7f091e87);
                                                                                    if (postData5 == null || view2 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData5.E() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData5.i0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view.getId() == R.id.obfuscated_res_0x7f09155d) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.obfuscated_res_0x7f0916b6) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String k12 = this.a.w0.k1();
                                                                                    String G3 = postData5.G();
                                                                                    String G4 = postData6 != null ? postData6.G() : "";
                                                                                    int V2 = this.a.w0.S0() != null ? this.a.w0.S0().V() : 0;
                                                                                    this.a.w6();
                                                                                    if (view.getId() == R.id.obfuscated_res_0x7f091a70) {
                                                                                        AbsPbActivity.e L52 = this.a.L5(G3);
                                                                                        if (this.a.w0 == null || this.a.w0.S0() == null || L52 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(k12, G3, "pb", true, false, null, true, null, V2, postData5.S(), this.a.w0.S0().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(L52.a, L52.f34853b, L52.f34858g, L52.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.w0.R0());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.w0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.w0.p1());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.w0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.w0.l0());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.w0.H(), this.a.w0.D(), this.a.w0.E(), this.a.w0.C(), this.a.w0.I());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e L53 = this.a.L5(G3);
                                                                                        if (postData5 == null || this.a.w0 == null || this.a.w0.S0() == null || L53 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(k12, G3, "pb", true, false, null, false, G4, V2, postData5.S(), this.a.w0.S0().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(L53.a, L53.f34853b, L53.f34858g, L53.j);
                                                                                        if (!c.a.d.f.p.m.isEmpty(G4)) {
                                                                                            addBigImageData3.setHighLightPostId(G4);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.w0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.w0.H(), this.a.w0.D(), this.a.w0.E(), this.a.w0.C(), this.a.w0.I());
                                                                                        addBigImageData3.setBjhData(this.a.w0.l0());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.w0.R0());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.w0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.w0.p1());
                                                                                        if (this.a.D0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.D0.w0(this.a.w0.G, this.a.w0.i1()).Q || postData5.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.w0.S0().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (c.a.d.f.p.l.z()) {
                                                                            SparseArray<Object> G02 = this.a.D0.G0(this.a.w0.S0(), this.a.w0.i1(), 1);
                                                                            if (G02 != null) {
                                                                                this.a.D0.d2(((Integer) G02.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) G02.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) G02.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) G02.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                                                                            }
                                                                            this.a.D0.f19993h.k();
                                                                            if (this.a.w() != null && this.a.w().S0() != null && this.a.w().S0().O() != null) {
                                                                                ThreadData O = this.a.w().S0().O();
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
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                                            return;
                                                                        }
                                                                    } else if (c.a.d.f.p.l.z()) {
                                                                        this.a.D0.d0();
                                                                        SparseArray<Object> G03 = this.a.D0.G0(this.a.w0.S0(), this.a.w0.i1(), 1);
                                                                        if (G03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.S0().l().getId(), this.a.w0.S0().l().getName(), this.a.w0.S0().O().getId(), String.valueOf(this.a.w0.S0().U().getUserId()), (String) G03.get(R.id.obfuscated_res_0x7f091e76), (String) G03.get(R.id.obfuscated_res_0x7f091e77), (String) G03.get(R.id.obfuscated_res_0x7f091e79), (String) G03.get(R.id.obfuscated_res_0x7f091e78))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
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
                                                                    this.a.D0.f19993h.l();
                                                                }
                                                            } else if (this.a.w0 == null || this.a.w0.S0() == null || this.a.w0.S0().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.D0.f19993h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.b5(pbFragment7.w0.S0().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.D0.d0();
                                                            if (c.a.d.f.p.l.z()) {
                                                                if (this.a.i) {
                                                                    view.setTag(Integer.valueOf(this.a.w0.g1()));
                                                                    return;
                                                                }
                                                                this.a.w6();
                                                                this.a.D0.V2();
                                                                c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.a.getPageContext());
                                                                if (this.a.w0.S0().f19819f == null || this.a.w0.S0().f19819f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f118a), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f118b)};
                                                                } else {
                                                                    strArr = new String[this.a.w0.S0().f19819f.size()];
                                                                    for (int i9 = 0; i9 < this.a.w0.S0().f19819f.size(); i9++) {
                                                                        strArr[i9] = this.a.w0.S0().f19819f.get(i9).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1188);
                                                                    }
                                                                }
                                                                jVar.j(null, strArr, new a(this, jVar, view));
                                                                jVar.m();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.D0.d0();
                                                        if (this.a.w().S0().f19820g != 2) {
                                                            if (this.a.w0.Q0() != null) {
                                                                this.a.D0.C3(this.a.w0.Q0(), this.a.a2);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f085e);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (S0 = this.a.w0.S0()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = S0.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.f34970b).param("fid", S0.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
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
                                                        statisticItem14.param("tid", this.a.w0.k1());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.w0.getForumId());
                                                        if (view.getId() != R.id.obfuscated_res_0x7f091ccb) {
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
                                                            if (O2.getBaijiahaoData() != null && !c.a.d.f.p.m.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.x() != null) {
                                                            c.a.o0.o0.c.e(this.a.x(), statisticItem14);
                                                        }
                                                        if (this.a.D0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.D0.B0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (c.a.d.f.p.n.C()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                                                            return;
                                                        } else if (S0 != null) {
                                                            ArrayList<PostData> F2 = this.a.w0.S0().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.w0.i1()) {
                                                                this.a.D0.d0();
                                                                this.a.w6();
                                                                if (S0.A() != null && !StringUtils.isNull(S0.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.w0.S0().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.D0 != null) {
                                                                    this.a.D0.f0();
                                                                    this.a.D0.N3(S0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.D0.p3();
                                                                    this.a.w0.n0().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view.getId() == R.id.obfuscated_res_0x7f0916a9) {
                                                                        i5 = 2;
                                                                    } else {
                                                                        i5 = view.getId() == R.id.obfuscated_res_0x7f091ccb ? 1 : 6;
                                                                    }
                                                                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.D0.H1() && !S0.j0()) {
                                                                        int B0 = this.a.D0.B0();
                                                                        this.a.D0.S();
                                                                        this.a.f5(c.a.o0.s.g.f.a(), B0);
                                                                    } else {
                                                                        this.a.q6(i5);
                                                                    }
                                                                }
                                                            } else {
                                                                c.a.d.f.p.n.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                                                                return;
                                                            }
                                                        } else {
                                                            c.a.d.f.p.n.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                                                            return;
                                                        }
                                                    }
                                                    i4 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.w0.k1());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.w0.getForumId());
                                                    if (view.getId() != R.id.obfuscated_res_0x7f091ccb) {
                                                    }
                                                    statisticItem142.param("obj_name", i4);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.x() != null) {
                                                    }
                                                    if (this.a.D0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (c.a.d.f.p.n.C()) {
                                                    }
                                                }
                                            } else if (c.a.d.f.p.l.z()) {
                                                this.a.D0.d0();
                                                if (this.a.D0.f19993h.n() != null && view == this.a.D0.f19993h.n().k() && !this.a.D0.F1()) {
                                                    this.a.D0.s2();
                                                }
                                                if (!this.a.i) {
                                                    this.a.w6();
                                                    this.a.D0.V2();
                                                    if (view.getId() == R.id.obfuscated_res_0x7f0909e0) {
                                                        G2 = this.a.w0.G2(true, this.a.B4());
                                                    } else {
                                                        G2 = view.getId() == R.id.obfuscated_res_0x7f091a6d ? this.a.w0.G2(false, this.a.B4()) : this.a.w0.F2(this.a.B4());
                                                    }
                                                    view.setTag(Boolean.valueOf(G2));
                                                    if (G2) {
                                                        i6 = 1;
                                                        this.a.D0.G2(true);
                                                        this.a.D0.z3();
                                                        this.a.i = true;
                                                        this.a.D0.J2(true);
                                                    } else {
                                                        i6 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i6, new Object[0]);
                                                } else {
                                                    view.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (c.a.d.f.p.l.z()) {
                                            this.a.D0.d0();
                                            if (view.getId() != R.id.obfuscated_res_0x7f0916a3 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.e4(11009) || this.a.w0.j0(this.a.D0.E0()) == null) {
                                                    return;
                                                }
                                                this.a.A5();
                                                if (this.a.w0.S0() != null && this.a.w0.S0().O() != null && this.a.w0.S0().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w0.f34970b).param("fid", this.a.w0.S0().m()).param("obj_locate", 3).param("uid", this.a.w0.S0().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.w0.S0().O() != null && this.a.w0.S0().O().getAuthor() != null && this.a.w0.S0().O().getAuthor().getUserId() != null && this.a.y0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int V4 = pbFragment8.V4(pbFragment8.w0.S0());
                                                    ThreadData O3 = this.a.w0.S0().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i7 = 2;
                                                    } else if (!O3.isBJHVideoThreadType()) {
                                                        if (O3.isBJHNormalThreadType()) {
                                                            i7 = 4;
                                                        } else {
                                                            i7 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w0.f34970b).param("obj_locate", 1).param("obj_id", this.a.w0.S0().O().getAuthor().getUserId()).param("obj_type", !this.a.y0.e()).param("obj_source", V4).param("obj_param1", i7));
                                                }
                                            } else {
                                                this.a.V = view;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.w0.S0() != null && this.a.w0.S0().O() != null && this.a.w0.S0().O().isVideoThreadType() && this.a.w0.S0().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.w0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.w0.s0()) || this.a.w0.i0() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.w0.i0().f19811b;
                                        } else {
                                            name2 = this.a.w0.S0().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String s02 = this.a.w0.s0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.w0.y0() && s02 != null && s02.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (c.a.d.f.p.l.z()) {
                                    if (this.a.w0.S0() == null || this.a.z0.R()) {
                                        return;
                                    }
                                    this.a.D0.d0();
                                    int i11 = (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().o()) ? (this.a.D0.f19993h.n() == null || view != this.a.D0.f19993h.n().n()) ? view == this.a.D0.q0() ? 2 : 0 : this.a.w0.S0().O().getIs_good() == 1 ? 3 : 6 : this.a.w0.S0().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.w0.S0().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.w0.S0().O().getId();
                                    this.a.D0.H3();
                                    this.a.z0.V(id2, name3, id3, i11, this.a.D0.r0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                    return;
                                }
                            } else {
                                this.a.D0.f19993h.l();
                                if (this.a.w0 != null) {
                                    this.a.s1.f(this.a.w0.k1());
                                }
                                if (this.a.w0 == null || !this.a.w0.isPrivacy()) {
                                    this.a.s1.b();
                                    int i12 = (TbSingleton.getInstance().mCanCallFans || this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().Q() == null || !this.a.w().S0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.w() != null && this.a.w().S0() != null) {
                                        this.a.s1.d(3, i12, this.a.w().S0().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ec9);
                                    if (this.a.w() == null || this.a.w().S0() == null) {
                                        return;
                                    }
                                    this.a.s1.d(3, 3, this.a.w().S0().Q());
                                    return;
                                }
                            }
                        } else if (c.a.d.f.p.l.z()) {
                            this.a.D0.d0();
                            this.a.w6();
                            this.a.D0.V2();
                            this.a.D0.p3();
                            if (this.a.D0.N0() != null) {
                                this.a.D0.N0().setVisibility(8);
                            }
                            this.a.w0.B2(1);
                            if (this.a.f34893e != null) {
                                this.a.f34893e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                            return;
                        }
                    } else {
                        String str4 = (String) view.getTag(R.id.obfuscated_res_0x7f090a67);
                        String str5 = (String) view.getTag(R.id.obfuscated_res_0x7f090a4b);
                        String str6 = (String) view.getTag(R.id.obfuscated_res_0x7f091fa8);
                        if (this.a.R != null) {
                            this.a.R.P(str4, str5);
                        }
                        TbPageTag l2 = c.a.o0.o0.c.l(this.a.getContext());
                        c.a.p0.w2.m.f.n1.c.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d9e).equals(view.getTag()) && view.getId() == R.id.obfuscated_res_0x7f091a5f) {
                        String A4 = this.a.A4();
                        if (TextUtils.isEmpty(A4)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{A4});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.w0.k1());
                statisticItem15.param("fid", this.a.w0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                if (this.a.w) {
                    this.a.w = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091e69);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.a.w0 == null || this.a.w0.S0() == null || this.a.S4().O0() == null || postData7.s() == null || postData7.A() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.S4().P0() != null) {
                            this.a.S4().P0().c();
                        }
                        c.a.p0.w2.i.u uVar2 = new c.a.p0.w2.i.u();
                        uVar2.A(this.a.w0.S0().l());
                        uVar2.E(this.a.w0.S0().O());
                        uVar2.C(postData7);
                        this.a.S4().O0().U(uVar2);
                        this.a.S4().O0().setPostId(postData7.G());
                        this.a.y5(view, postData7.s().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        c.a.p0.w2.o.a.b(this.a.w0.S0(), postData7, postData7.h0, 8, 1);
                        if (this.a.S0 != null) {
                            this.a.D0.A2(this.a.S0.C());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements c.a.d.f.k.c<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                    if (c.a.o0.r.l.c().g()) {
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
        @Override // c.a.d.f.k.c
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
                    foreDrawableImageView.N();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g2 = c.a.o0.r.l.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
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
                    foreDrawableImageView.N();
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
    public interface c3 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class d implements c.a.o0.c1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34912b;

        public d(PbFragment pbFragment, int i) {
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
            this.f34912b = pbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f34912b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends c.a.o0.j0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34913c;

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
            this.f34913c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.j0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f34913c.a.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.s(this.f34913c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.w0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.w0.f34970b)) {
                this.a.p6((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements c.a.d.f.k.c<GifView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                if (c.a.o0.r.l.c().g()) {
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.Y();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g2 = c.a.o0.r.l.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
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
                gifView.b0();
                gifView.Y();
                gifView.setImageDrawable(null);
                gifView.c0();
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
    public interface d3 {
    }

    /* loaded from: classes5.dex */
    public class e extends c.a.o0.c1.k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34914b;

        public e(PbFragment pbFragment, int i) {
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
            this.f34914b = pbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel w = this.f34914b.w();
                if (w != null) {
                    w.p2(this.a);
                }
                return c.a.p0.w2.m.f.n1.b.d(this.f34914b.x4(), 2, w);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34915b;

        public e0(PbFragment pbFragment, Intent intent) {
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
            this.f34915b = pbFragment;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.w2.m.f.a1 a1Var = this.f34915b.D0;
                a1Var.Y2("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e1 f34916b;

            public a(e1 e1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34916b = e1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34916b.a.D0 == null || this.a == null) {
                    return;
                }
                this.f34916b.a.D0.g2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e1 e1Var) {
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
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e1 a;

            public c(e1 e1Var) {
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

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.o0.s.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w0.S0() != null) {
                        statisticItem.param("fid", this.a.w0.S0().m());
                    }
                    statisticItem.param("tid", this.a.w0.k1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (c.a.d.f.p.m.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.w6();
                this.a.D0.T2(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.a.p6(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.e6(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.a.w0.w0()) {
                            c.a.p0.w2.i.f S0 = this.a.w0.S0();
                            if (S0 != null && S0.O() != null && S0.O().getAuthor() != null && (userId = S0.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.w0.E2()) {
                                this.a.D0.V2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.a.w0.E2()) {
                            this.a.D0.V2();
                        }
                    } else if (floor != null) {
                        this.a.D0.t1(this.a.w0.S0());
                    }
                    if (this.a.w0.A0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.w0.k1()));
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.a4(z2);
                    if (this.a.l5()) {
                        this.a.z6();
                    }
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.S0.B() || this.a.S0.D()) {
                        this.a.S0.z(false, postWriteCallBackData);
                    }
                    this.a.H0.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.V0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f045f), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cc7));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new b(this));
                    aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new c(this));
                    aVar.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (c.a.p0.j4.a.c(i) || l0Var != null || i == 227001) {
                } else {
                    this.a.d6(i, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements c.a.o0.w.y.b {
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

        @Override // c.a.o0.w.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.w2.m.f.c1 c1Var = this.a.H0;
                if (c1Var == null || c1Var.g() == null || !this.a.H0.g().d()) {
                    return !this.a.h4(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.H0.g().c());
                if (this.a.D0 != null && this.a.D0.P0() != null && this.a.D0.P0().b() != null && this.a.D0.P0().b().x()) {
                    this.a.D0.P0().b().v(this.a.H0.h());
                }
                this.a.H0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements c.a.o0.c1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f34917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34918c;

        public f(PbFragment pbFragment, int i, int i2) {
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
            this.f34918c = pbFragment;
            this.a = i;
            this.f34917b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f34918c.getContext(), this.f34917b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.S0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.D0 != null && this.a.D0.P0() != null && this.a.D0.P0().b() != null) {
                    this.a.D0.P0().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.a;
                    pbFragment.T5(pbFragment.Y0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f1 f34919b;

            public a(f1 f1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34919b = f1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34919b.a.D0 == null || this.a == null) {
                    return;
                }
                this.f34919b.a.D0.g2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(f1 f1Var) {
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
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f1 a;

            public c(f1 f1Var) {
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

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.o0.s.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w0 != null && this.a.w0.S0() != null) {
                        statisticItem.param("fid", this.a.w0.S0().m());
                    }
                    if (this.a.w0 != null) {
                        statisticItem.param("tid", this.a.w0.k1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.p0.w2.m.f.c1 c1Var = this.a.H0;
                    if (c1Var != null) {
                        c1Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.o0.s.h.c.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.l5()) {
                        this.a.z6();
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.V0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f045f), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cc7));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new b(this));
                    aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new c(this));
                    aVar.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.H0 == null) {
                    return;
                }
                if (pbFragment.D0 != null && this.a.D0.P0() != null && this.a.D0.P0().b() != null && this.a.D0.P0().b().x()) {
                    this.a.D0.P0().b().v(postWriteCallBackData);
                }
                this.a.H0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements c.a.d.f.k.c<TiebaPlusRecommendCard> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
            if (this.a.S0 != null) {
                this.a.D0.A2(this.a.S0.C());
            }
            this.a.D0.s2();
            this.a.D0.d0();
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements CheckRealNameModel.b {
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

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                this.a.D0.g1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.a.q6(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        c.a.p0.m1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(PbFragment pbFragment, int i, int i2) {
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

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView Y0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1396);
                    if (this.a.D0 == null || (Y0 = this.a.D0.Y0()) == null || this.a.D0.F0() == null) {
                        return;
                    }
                    this.a.D0.F0().removeHeaderView(Y0);
                    return;
                }
                c.a.d.f.p.n.N(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements c.a.d.f.k.c<View> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                ((PlayVoiceBntNew) view).o();
                return view;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).n();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.w0.J2((UserPendantData) customResponsedMessage.getData());
                if (this.a.D0 != null && this.a.w0 != null) {
                    this.a.D0.m2(this.a.w0.S0(), this.a.w0.i1(), this.a.w0.c1(), this.a.D0.W0());
                }
                if (this.a.D0 == null || this.a.D0.o0() == null) {
                    return;
                }
                this.a.D0.o0().Y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 extends c.a.d.a.e {
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

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements PbModel.g {
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.a.n : j;
                if (this.a.o == 0) {
                    this.a.o = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                c.a.o0.r0.h hVar = new c.a.o0.r0.h(i, z, responsedMessage, this.a.r, this.a.q, this.a.o, z2, 0L, 0L, j3);
                this.a.q = 0L;
                this.a.r = 0L;
                hVar.c();
                if (z2) {
                    j2 = j3;
                    hVar.B = j2;
                    hVar.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.w0 == null || this.a.w0.S0() == null || this.a.w0.S0().O() == null) {
                    return;
                }
                int threadType = this.a.w0.S0().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.M, "from_personalize")) {
                        if (StringHelper.equals(this.a.M, "from_frs")) {
                            c.a.o0.r0.h hVar2 = new c.a.o0.r0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(threadType);
                            return;
                        }
                        return;
                    }
                    c.a.o0.r0.d dVar = new c.a.o0.r0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.p0.w2.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.a.D0.t1(fVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, final c.a.p0.w2.i.f fVar, String str, int i4) {
            c.a.o0.w.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fVar, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906c9));
                }
                final int i5 = 1;
                if (!z || fVar == null || fVar.W() != null || ListUtils.getCount(fVar.F()) >= 1) {
                    if (!this.a.n0) {
                        this.a.n0 = true;
                    } else if (this.a.w() != null) {
                        this.a.w().a0();
                    }
                    this.a.f34896h = true;
                    this.a.D0.U2();
                    if (fVar == null || !fVar.m0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.D0.a1());
                    }
                    this.a.D0.i1();
                    if (this.a.J || this.a.D0.F1()) {
                        this.a.D0.c1();
                    } else if (!this.a.D0.y1()) {
                        this.a.D0.h3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && fVar != null) {
                        this.a.L0 = true;
                    }
                    if (fVar != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.D0.a1());
                        this.a.D0.c3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String S0 = null;
                    arrayList = null;
                    if (z && fVar != null) {
                        ThreadData O = fVar.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.Z5(pbFragment3.R0);
                        }
                        this.a.D0.P0().m(fVar);
                        this.a.D0.o3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.D6(O.getCartoonThreadData());
                        }
                        if (this.a.S0 != null) {
                            this.a.D0.A2(this.a.S0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(fVar.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.U().getBimg_end_time());
                        if (fVar.F() != null && fVar.F().size() >= 1 && fVar.F().get(0) != null) {
                            this.a.w0.n2(fVar.F().get(0).G());
                        } else if (fVar.W() != null) {
                            this.a.w0.n2(fVar.W().G());
                        }
                        if (this.a.S0 != null) {
                            this.a.S0.M(fVar.d());
                            this.a.S0.N(fVar.l(), fVar.U());
                            this.a.S0.r0(O);
                            this.a.S0.O(this.a.w0.v0(), this.a.w0.k1(), this.a.w0.r0());
                            if (O != null) {
                                this.a.S0.h0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.y0 != null) {
                            this.a.y0.h(fVar.r());
                        }
                        if (fVar.s() == 1) {
                            this.a.s = true;
                        } else {
                            this.a.s = false;
                        }
                        if (fVar.g0()) {
                            this.a.s = true;
                        }
                        this.a.D0.B2(this.a.s);
                        if (this.a.t0.f20245f.size() > 0) {
                            fVar.L0(this.a.t0.f20245f);
                        }
                        this.a.D0.s3(fVar, i2, i3, this.a.w0.i1(), i4, this.a.w0.C0());
                        this.a.D0.F3(fVar, this.a.w0.i1());
                        this.a.D0.K3(this.a.w0.w0());
                        AntiData d2 = fVar.d();
                        if (d2 != null) {
                            this.a.z = d2.getVoice_message();
                            if (!StringUtils.isNull(this.a.z) && this.a.S0 != null && this.a.S0.a() != null && (m = this.a.S0.a().m(6)) != null && !TextUtils.isEmpty(this.a.z)) {
                                ((View) m).setOnClickListener(this.a.F1);
                            }
                        }
                        if (!this.a.Y && !ListUtils.isEmpty(this.a.w0.S0().F()) && !this.a.w0.A1()) {
                            this.a.Y = true;
                            this.a.c4(false);
                        }
                        if (!TextUtils.isEmpty(this.a.O0)) {
                            c.a.p0.w2.m.f.i1.k.f(this.a.getListView(), this.a.O0);
                            this.a.O0 = null;
                        } else if (this.a.N0) {
                            this.a.N0 = false;
                            c.a.p0.w2.m.f.i1.k.e(this.a.getListView());
                        } else if (this.a.P0) {
                            this.a.P0 = false;
                            c.a.p0.w2.m.f.i1.k.g(this.a.getListView());
                        } else {
                            this.a.D0.n3();
                        }
                        this.a.w0.J1(fVar.l(), this.a.J1);
                        this.a.w0.P1(this.a.L1);
                        if (this.a.V0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.V0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.w0 == null || !this.a.w0.x1()) {
                            if (this.a.D0 != null) {
                                S0 = this.a.D0.S0();
                            }
                        } else {
                            S0 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd);
                        }
                        if (!StringUtils.isNull(S0)) {
                            this.a.S0.k0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), S0));
                        }
                    } else if (str != null) {
                        if (this.a.L0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.w0.i0() != null && !StringUtils.isNull(this.a.w0.i0().f19812c)) {
                                    this.a.D0.M3(this.a.w0.i0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.D0.a1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c14, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702a3));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.D0.a1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c14, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702a3));
                            }
                            this.a.D0.c1();
                            this.a.D0.b1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.w0.k1());
                                jSONObject.put("fid", this.a.w0.getForumId());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        }
                        if (i != 0) {
                            EnterForePvThread enterForePvThread = new EnterForePvThread();
                            enterForePvThread.setOpType("2");
                            enterForePvThread.start();
                        }
                        if (i != -1) {
                            if (this.a.w0 != null && this.a.w0.S0() != null) {
                                arrayList = this.a.w0.S0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.D0.w2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                            } else {
                                if (this.a.n5()) {
                                    this.a.D0.x2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dae));
                                } else {
                                    this.a.D0.x2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0daf));
                                }
                                this.a.D0.t1(this.a.w0.S0());
                            }
                        } else {
                            this.a.D0.w2("");
                        }
                        this.a.D0.j0();
                    }
                    if (fVar != null && fVar.m && this.a.o == 0) {
                        this.a.o = System.currentTimeMillis() - this.a.n;
                    }
                    if (!this.a.w().i1() || this.a.w().S0().y().c() != 0 || this.a.w().v1()) {
                        this.a.T0 = true;
                    }
                    if (this.a.p0 || this.a.a == null) {
                        return;
                    }
                    this.a.p0 = true;
                    if (this.a.w0 != null && this.a.w0.R0() == 7) {
                        i5 = 2;
                    } else if (this.a.w0 == null || !this.a.w0.w1()) {
                        i5 = 3;
                    }
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: c.a.p0.w2.m.f.a
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.os.MessageQueue.IdleHandler
                        public final boolean queueIdle() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PbFragment.h1.this.e(fVar, i5) : invokeV.booleanValue;
                        }
                    });
                    return;
                }
                this.a.w0.B2(1);
                if (this.a.f34893e != null) {
                    this.a.f34893e.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.w0 == null) {
                return;
            }
            if (this.a.S0 == null || !this.a.S0.v) {
                c.a.o0.w.y.d dVar = new c.a.o0.w.y.d();
                this.a.Z5(dVar);
                PbFragment pbFragment = this.a;
                pbFragment.S0 = (c.a.o0.w.y.e) dVar.a(pbFragment.getContext());
                this.a.S0.e0(this.a.a.getPageContext());
                this.a.S0.n0(this.a.f2);
                this.a.S0.o0(this.a.Z0);
                this.a.S0.F(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.S0.a().C(true);
                this.a.D0.v2(this.a.S0.a());
                if (!this.a.w0.G0()) {
                    this.a.S0.s(this.a.w0.k1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.S0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.w0.x1()) {
                    this.a.S0.k0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd));
                } else if (this.a.D0 != null) {
                    this.a.S0.k0(this.a.D0.S0());
                }
            }
        }

        public /* synthetic */ boolean e(c.a.p0.w2.i.f fVar, int i) {
            long currentTimeMillis = System.currentTimeMillis() - this.a.a.getCreateTime();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i).addParam("obj_locate", fVar != null ? fVar.g() : 0).addParam("obj_param1", currentTimeMillis);
            TiebaStatic.log(statisticItem);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements c.a.d.f.k.c<RelativeLayout> {
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
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.D0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.D0.z3();
            } else {
                this.a.D0.i1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements c3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.c3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.d.f.p.l.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w0.S0().l().getId(), this.a.w0.S0().l().getName(), this.a.w0.S0().O().getId(), String.valueOf(this.a.w0.S0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements c.a.o0.w.y.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // c.a.o0.w.y.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements c.a.d.f.k.c<ItemCardView> {
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
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.S0 != null) {
                this.a.D0.A2(this.a.S0.C());
            }
            this.a.D0.h3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements c.a {
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

        @Override // c.a.p0.w2.j.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.obfuscated_res_0x7f091a8a) {
                            if (this.a.S5(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.obfuscated_res_0x7f0916b5) {
                            if (view.getTag(R.id.obfuscated_res_0x7f091e7c) instanceof SparseArray) {
                                this.a.u6((SparseArray) view.getTag(R.id.obfuscated_res_0x7f091e7c));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.obfuscated_res_0x7f09170c) {
                            if (this.a.D0.A1() && view.getId() == R.id.obfuscated_res_0x7f0916d3) {
                                if (view.getTag(R.id.obfuscated_res_0x7f091eb7) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.obfuscated_res_0x7f091eb7)));
                                }
                                if (this.a.getEventController() != null && this.a.getEventController().f20180b != null) {
                                    this.a.getEventController().f20180b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.u6(sparseArray);
                        }
                    }
                    if (this.a.S0 != null) {
                        this.a.D0.A2(this.a.S0.C());
                    }
                    this.a.D0.s2();
                    this.a.D0.d0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.q4();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
                this.a.C6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c.a.p0.w2.m.f.l o0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.D0.R1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.w0.k1());
                    statisticItem.param("fid", this.a.w0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.obfuscated_res_0x7f091e9f) == null || !(view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.a.w0.G.g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view.getParent();
                            } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view.getParent().getParent();
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
                                        arrayList.add(C.get(i4).D());
                                        if (i5 == i3 && str != null && (str.equals(C.get(i4).D()) || str.equals(C.get(i4).A()) || str.equals(C.get(i4).y()) || str.equals(C.get(i4).z()) || str.equals(C.get(i4).C()))) {
                                            i5 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = C.get(i4).D();
                                        imageUrlData.originalUrl = C.get(i4).D();
                                        imageUrlData.isLongPic = C.get(i4).G();
                                        concurrentHashMap.put(C.get(i4).D(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = -1;
                                }
                                i2 = i5;
                            }
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            this.a.v4(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i2);
                            bVar.C(false);
                            bVar.F(this.a.w0.d1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.a.n5());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.a.w0 != null) {
                                bVar.A(this.a.w0.getFromForumId());
                                if (this.a.w0.S0() != null) {
                                    bVar.N(this.a.w0.S0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.J5(str, i, eVar);
                        if (eVar.f34859h) {
                            TbRichText F6 = this.a.F6(str, i);
                            if (F6 != null && this.a.s2 >= 0 && this.a.s2 < F6.A().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = c.a.p0.w2.i.g.a(F6.A().get(this.a.s2));
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
                                if (F6.getPostId() != 0 && (o0 = this.a.D0.o0()) != null) {
                                    ArrayList<c.a.d.o.e.n> s = o0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<c.a.d.o.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            c.a.d.o.e.n next = it.next();
                                            if ((next instanceof PostData) && F6.getPostId() == c.a.d.f.m.b.g(((PostData) next).G(), 0L)) {
                                                c.a.p0.w2.o.a.b(this.a.w0.S0(), (PostData) next, ((PostData) next).h0, F6.getPostId() == c.a.d.f.m.b.g(this.a.w0.r0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f34853b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.a.v4(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f34854c);
                                bVar2.y(eVar.f34855d);
                                bVar2.O(eVar.f34856e);
                                bVar2.C(eVar.f34858g);
                                bVar2.H(true);
                                bVar2.J(eVar.i);
                                bVar2.F(this.a.w0.d1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.a.n5());
                                bVar2.L(eVar.f34857f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.a.w0 != null) {
                                    bVar2.A(this.a.w0.getFromForumId());
                                    if (this.a.w0.S0() != null) {
                                        bVar2.N(this.a.w0.S0().O());
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
                            concurrentHashMap3.put(str3, eVar.f34853b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f34854c);
                        bVar3.y(eVar.f34855d);
                        bVar3.O(eVar.f34856e);
                        bVar3.C(eVar.f34858g);
                        bVar3.H(true);
                        bVar3.J(eVar.a.get(0));
                        bVar3.F(this.a.w0.d1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.a.n5());
                        bVar3.L(eVar.f34857f);
                        bVar3.D(false);
                        if (this.a.w0 != null) {
                            bVar3.A(this.a.w0.getFromForumId());
                            if (this.a.w0.S0() != null) {
                                bVar3.N(this.a.w0.S0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                    boolean w = ((TbImageView) view).w();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                    }
                    this.a.S = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.p0.w2.f fVar = (c.a.p0.w2.f) customResponsedMessage.getData();
            int type = fVar.getType();
            if (type == 0) {
                this.a.P5((c.a.p0.w2.i.u) fVar.a());
            } else if (type == 1) {
                this.a.t4((ForumManageModel.b) fVar.a(), false);
            } else if (type != 2) {
            } else {
                if (fVar.a() == null) {
                    this.a.O5(false, null);
                } else {
                    this.a.O5(true, (MarkData) fVar.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements c.InterfaceC0843c {
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

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.K0 = pbFragment.K0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.K0);
                    new c.a.p0.w2.m.f.g(this.a.w0.k1(), this.a.K0, "1").start();
                    cVar.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.K0 = pbFragment2.K0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.K0);
                    new c.a.p0.w2.m.f.g(this.a.w0.k1(), this.a.K0, "2").start();
                    cVar.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.K0 = pbFragment3.K0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.K0);
                    cVar.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(PbFragment pbFragment, int i, boolean z) {
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
                if (this.a.D0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.D0.a1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0313));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.a6(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements c.InterfaceC0843c {
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

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                if (cVar != null) {
                    cVar.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.v2;
                if (postData != null) {
                    if (i == 0) {
                        postData.m0();
                        this.a.v2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.C5(pbFragment2.v2);
                    }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.D0 == null || this.a.D0.o0() == null) {
                return;
            }
            this.a.D0.o0().Y();
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
                this.a.D0.g1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.p0.w2.i.f S0 = this.a.w0.S0();
                if (S0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.c(this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0b18));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0b14);
                    }
                    this.a.r6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.m6();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.d.f.p.m.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f0b15);
                    }
                    this.a.f1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements a.InterfaceC0810a {
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

        @Override // c.a.o0.h.a.InterfaceC0810a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.D0.U2();
                if (z) {
                    if (this.a.y0 != null) {
                        this.a.y0.h(z2);
                    }
                    this.a.w0.D2(z2);
                    if (this.a.w0.E0()) {
                        this.a.z5();
                    } else {
                        this.a.D0.t1(this.a.w0.S0());
                    }
                    if (z2) {
                        boolean j0 = this.a.w0.S0().j0();
                        if (this.a.y0 != null && !j0) {
                            if (this.a.y0.f() == null || this.a.w0 == null || this.a.w0.S0() == null || this.a.w0.S0().O() == null || this.a.w0.S0().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f2 = this.a.y0.f();
                            MetaData author = this.a.w0.S0().O().getAuthor();
                            if (f2 != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.l6(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00cd);
                                    if (c.a.o0.s.h.a.e(this.a.getContext(), 0)) {
                                        c.a.o0.s.h.a.g(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cc));
                            }
                        }
                        this.a.Z3();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f80));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1486));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements c.InterfaceC0843c {
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

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                if (cVar != null) {
                    cVar.e();
                }
                if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.l1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.k1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.a = this.a.k1;
                        String str = "";
                        if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.l1.memeInfo.pck_id;
                        }
                        aVar.f9865b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
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
                    if (this.a.i1 == null) {
                        PbFragment pbFragment = this.a;
                        pbFragment.i1 = new c.a.p0.w2.m.f.e1(pbFragment.getPageContext());
                    }
                    this.a.i1.b(this.a.k1, this.a.j1.n());
                }
                this.a.j1 = null;
                this.a.k1 = null;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                c.a.o0.e1.n.f.c(this.a.getPageContext(), this.a, aVar.a, aVar.f10185b, aVar.f10186c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.w0 != null && this.a.w0.E0()) {
                    this.a.z5();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34920b;

        public m1(PbFragment pbFragment, MetaData metaData) {
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
            this.f34920b = pbFragment;
            this.a = metaData;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.w0 == null || this.a.w0.b1() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.X5(pbFragment.Q4(i));
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f34895g) {
                return;
            }
            this.a.t6();
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
                this.a.D0.g1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.c(this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f1462));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.d.f.p.m.isEmpty(muteMessage)) {
                    muteMessage = this.a.e1.getResources().getString(R.string.obfuscated_res_0x7f0f1461);
                }
                this.a.f1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34921b;

        public n1(PbFragment pbFragment, MetaData metaData) {
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
            this.f34921b = pbFragment;
            this.a = metaData;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f34921b.A0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.f34921b.getPageContext().getUniqueId(), this.f34921b.w0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.f34890b = true;
                return pbFragment.k4(view);
            }
            return invokeL.booleanValue;
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0c99));
                bdTopToast.j((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
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
                if (!this.a.l5() || this.a.a == null || this.a.a.getPbModel() == null || !str.equals(this.a.a.getPbModel().getTopicId())) {
                    return;
                }
                this.a.A6(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.w0 == null || this.a.w0.S0() == null || this.a.D0 == null || this.a.D0.o0() == null) {
                return;
            }
            this.a.D0.X1(absListView, i, i2, i3);
            if (this.a.f34893e != null) {
                this.a.f34893e.q(absListView, i, i2, i3);
            }
            if (!this.a.w0.B1() || (F = this.a.w0.S0().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i + i2) - this.a.D0.o0().w()) - 1;
            c.a.p0.w2.i.f S0 = this.a.w0.S0();
            if (S0 == null) {
                return;
            }
            if (S0.D() != null && S0.D().J0()) {
                w--;
            }
            if (S0.E() != null && S0.E().J0()) {
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
                if (!pbFragment.r5(pbFragment.c1) && this.a.r5(i)) {
                    if (this.a.D0 != null) {
                        this.a.D0.d0();
                        if (this.a.S0 != null && !this.a.D0.v1()) {
                            this.a.D0.A2(this.a.S0.C());
                        }
                        if (!this.a.J) {
                            this.a.D0.s2();
                        }
                    }
                    if (!this.a.t) {
                        this.a.t = true;
                    }
                }
                if (this.a.D0 != null) {
                    this.a.D0.Y1(absListView, i);
                }
                if (this.a.f34893e != null) {
                    this.a.f34893e.r(absListView, i);
                }
                if (this.a.u == null) {
                    this.a.u = new c.a.o0.r0.b();
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
                this.a.c1 = i;
                if (i == 0) {
                    this.a.V5(false, null);
                    c.a.p0.z3.c.g().h(this.a.getUniqueId(), true);
                    this.a.c4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view, (ViewGroup) this.a.getView());
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin() && this.a.y0 != null && !this.a.y0.e()) {
                        this.a.A5();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.k4.a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                c.a.p0.k4.a aVar = (c.a.p0.k4.a) customResponsedMessage.getData();
                this.a.D0.g1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = aVar.a;
                if (aVar.f15970c == 0 && dataRes != null) {
                    int e2 = c.a.d.f.m.b.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e2 == 1;
                    if (c.a.d.f.p.m.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091eb8, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091eb8, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e7c)).intValue();
                if (intValue == 0) {
                    this.a.n6(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.D0.e2(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements Comparator<c.a.o0.t.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.o0.t.a aVar, c.a.o0.t.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements b3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.D0 != null && this.a.D0.P0() != null) {
                    c.a.p0.w2.m.f.x P0 = this.a.D0.P0();
                    if (P0.f()) {
                        P0.d();
                        return true;
                    }
                }
                if (this.a.D0 == null || !this.a.D0.I1()) {
                    return false;
                }
                this.a.D0.k1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public q(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.D0.v1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.q4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements ItemCardHelper.c {
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

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.z);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            c.a.p0.a4.k0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.p0.a4.k0.e) || (eVar = (c.a.p0.a4.k0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f12234b) == null || agreeData.agreeType != 2 || this.a.D0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || c.a.p0.w2.m.f.n1.b.k(this.a.w0.f34970b)) {
                return;
            }
            this.a.D0.B3();
            c.a.p0.w2.m.f.n1.b.b(this.a.w0.f34970b);
        }
    }

    /* loaded from: classes5.dex */
    public class r1 extends c.a.d.a.e {
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

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.z0.getLoadDataMode()) {
                        case 0:
                            this.a.w0.t1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.t4(bVar, (bVar.f36159e != 1002 || bVar.f36160f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.D0.l0(1, dVar.a, dVar.f36163b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.a;
                            pbFragment.u4(pbFragment.z0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.D0.l0(this.a.z0.getLoadDataMode(), gVar.a, gVar.f36174b, false);
                            this.a.D0.Z1(gVar.f36175c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.D0.l0(this.a.z0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r2 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f34895g && z && !this.a.w0.I0()) {
                    this.a.Q5();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702a3));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.o0.r.r.j0)) {
                c.a.o0.r.r.j0 j0Var = (c.a.o0.r.r.j0) customResponsedMessage.getData();
                b1.a aVar = new b1.a();
                int i = j0Var.a;
                String str = j0Var.f10890b;
                aVar.a = j0Var.f10892d;
                c.a.p0.w2.i.f S0 = this.a.w0.S0();
                if (S0 == null) {
                    return;
                }
                if (this.a.w0.v0() != null && this.a.w0.v0().getUserIdLong() == j0Var.p) {
                    this.a.D0.l2(j0Var.l, this.a.w0.S0(), this.a.w0.i1(), this.a.w0.c1());
                }
                if (S0.F() == null || S0.F().size() < 1 || S0.F().get(0) == null) {
                    return;
                }
                long g2 = c.a.d.f.m.b.g(S0.F().get(0).G(), 0L);
                long g3 = c.a.d.f.m.b.g(this.a.w0.k1(), 0L);
                if (g2 == j0Var.n && g3 == j0Var.m) {
                    c.a.o0.r.r.b1 F = S0.F().get(0).F();
                    if (F == null) {
                        F = new c.a.o0.r.r.b1();
                    }
                    ArrayList<b1.a> a = F.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    F.e(F.b() + j0Var.l);
                    F.d(a);
                    S0.F().get(0).q0(F);
                    this.a.D0.o0().Y();
                }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.m1 = true;
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class s2 implements c.a.d.f.k.c<LinearLayout> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091727);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w0 == null || this.a.w0.S0() == null) {
                return;
            }
            this.a.w0.S0().a();
            this.a.w0.t1();
            if (this.a.D0.o0() != null) {
                this.a.D0.t1(this.a.w0.S0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.d5();
                c.a.o0.r.r.z0 Q0 = this.a.w0.Q0();
                int M0 = this.a.D0.M0();
                if (M0 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0db1);
                } else if (Q0 == null || M0 <= Q0.h()) {
                    this.a.D0.d0();
                    this.a.w6();
                    this.a.D0.V2();
                    if (c.a.d.f.p.l.z()) {
                        this.a.w0.B2(this.a.D0.M0());
                        if (this.a.f34893e != null) {
                            this.a.f34893e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                    }
                    aVar.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0db1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements c.a.o0.w.y.b {
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

        @Override // c.a.o0.w.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.w2.m.f.c1 c1Var = this.a.H0;
                if (c1Var == null || c1Var.e() == null || !this.a.H0.e().d()) {
                    return !this.a.h4(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.H0.e().c());
                if (this.a.S0 != null && (this.a.S0.B() || this.a.S0.D())) {
                    this.a.S0.z(false, this.a.H0.h());
                }
                this.a.H0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class t2 implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.a.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i = 0; i < frameLayout.getChildCount(); i++) {
                    View childAt = frameLayout.getChildAt(i);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.a.f34892d.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w0 == null || this.a.w0.S0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.m4(str);
            this.a.w0.t1();
            if (!TextUtils.isEmpty(str) && this.a.w0.S0().F() != null) {
                ArrayList<PostData> F = this.a.w0.S0().F();
                c.a.p0.a4.k0.o oVar = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof c.a.p0.a4.k0.o) {
                        c.a.p0.a4.k0.o oVar2 = (c.a.p0.a4.k0.o) next;
                        if (str.equals(oVar2.K0())) {
                            oVar = oVar2;
                            break;
                        }
                    }
                }
                if (oVar != null) {
                    F.remove(oVar);
                    if (this.a.D0.o0() != null && this.a.D0.o0().s() != null) {
                        this.a.D0.o0().s().remove(oVar);
                    }
                    if (this.a.D0.F0() != null && this.a.D0.F0().getData() != null) {
                        this.a.D0.F0().getData().remove(oVar);
                    }
                    if (this.a.D0.o0() != null) {
                        this.a.D0.o0().Y();
                        return;
                    }
                }
            }
            if (this.a.D0.o0() != null) {
                this.a.D0.t1(this.a.w0.S0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                if (this.a.I0 != null) {
                    this.a.I0.dismiss();
                }
                this.a.B6(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f09169e);
                        this.a.M5(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f09169d);
                        this.a.M5(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f0916a0);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.a.M5(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f0916a0);
                        if (view5 != null) {
                            this.a.M5(view5);
                            AgreeView agreeView2 = (AgreeView) view5;
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
                        if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                            return;
                        }
                        if (this.a.l1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.k1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.a = this.a.k1;
                            String str = "";
                            if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.l1.memeInfo.pck_id;
                            }
                            aVar.f9865b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.j1 = null;
                        this.a.k1 = null;
                        return;
                    case 2:
                        if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                            return;
                        }
                        if (this.a.U0 == null) {
                            this.a.U0 = new PermissionJudgePolicy();
                        }
                        this.a.U0.clearRequestPermissionList();
                        this.a.U0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.U0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.i1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.i1 = new c.a.p0.w2.m.f.e1(pbFragment.getPageContext());
                        }
                        this.a.i1.b(this.a.k1, this.a.j1.n());
                        this.a.j1 = null;
                        this.a.k1 = null;
                        return;
                    case 3:
                        PostData postData = this.a.v2;
                        if (postData != null) {
                            postData.m0();
                            this.a.v2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.B5(view);
                            if (this.a.w0.S0().O() == null || this.a.w0.S0().O().getAuthor() == null || this.a.w0.S0().O().getAuthor().getUserId() == null || this.a.y0 == null) {
                                return;
                            }
                            PbFragment pbFragment2 = this.a;
                            int V4 = pbFragment2.V4(pbFragment2.w0.S0());
                            ThreadData O = this.a.w0.S0().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w0.f34970b).param("obj_locate", 2).param("obj_id", this.a.w0.S0().O().getAuthor().getUserId()).param("obj_type", !this.a.y0.e()).param("obj_source", V4).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.d.f.p.l.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.b5((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e7c, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e65, 2);
                                this.a.f4(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6d) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6b) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e88) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e7d) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e88)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e7d)).booleanValue();
                            boolean isHost = this.a.x().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.g6(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.D0.c2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e6b), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.g6(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.D0.a2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e6b), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.d.f.p.l.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.D0.a2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                                return;
                            }
                            return;
                        } else if (!booleanValue5) {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e65, 2);
                            }
                            this.a.D0.f2(view);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e7c, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e65, 2);
                            this.a.f4(sparseArray4);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.a.i4(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.w0 == null || this.a.w0.S0() == null) {
                            return;
                        }
                        this.a.a.showBlockDialog(c.a.p0.j4.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements d3 {
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
    }

    /* loaded from: classes5.dex */
    public class u2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34922b;

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
            this.f34922b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // c.a.p0.s0.a.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || !e(i2) || this.f34922b.D0 == null || this.f34922b.f34893e == null) {
                return;
            }
            this.f34922b.f34893e.u(true);
            if (Math.abs(i2) > this.a) {
                this.f34922b.f34893e.l();
            }
            if (this.f34922b.G4()) {
                this.f34922b.D0.h1();
                this.f34922b.D0.u2();
            }
        }

        @Override // c.a.p0.s0.a.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.f34922b.D0 == null || this.f34922b.f34893e == null) {
                return;
            }
            this.f34922b.D0.x3();
            this.f34922b.f34893e.u(false);
            this.f34922b.f34893e.x();
        }

        @Override // c.a.p0.s0.a.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // c.a.p0.s0.a.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public final boolean e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) ? Math.abs(f2) >= 1.0f : invokeF.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements SuggestEmotionModel.c {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(c.a.p0.w2.m.f.j1.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.c()));
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
    public class v0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f34923b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f34924c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34925d;

        public v0(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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
            this.f34925d = pbFragment;
            this.a = sparseArray;
            this.f34923b = i;
            this.f34924c = z;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f34925d.p4(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e6b), this.f34923b, this.f34924c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements f.g {
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

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.G4()) {
                    this.a.a.finish();
                }
                if (!this.a.w0.O1(true)) {
                    this.a.D0.k0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class v2 implements b.InterfaceC1370b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v2() {
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

        @Override // c.a.p0.s0.b.InterfaceC1370b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.p0.w2.j.b.d();
                } else {
                    c.a.p0.w2.j.b.c();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.D0 == null || this.a.w0 == null) {
                return;
            }
            this.a.D0.X(false);
            if (this.a.w0.K1(false)) {
                this.a.D0.W2();
            } else if (this.a.w0.S0() != null) {
                this.a.D0.o2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.q2 && this.a.G4()) {
                    this.a.u5();
                }
                if (this.a.mIsLogin) {
                    if (!this.a.m0 && this.a.D0 != null && this.a.D0.U() && this.a.w0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.a.w0.k1());
                        statisticItem.param("fid", this.a.w0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.w0.y0()) {
                            i = 4;
                        } else if (this.a.w0.z0()) {
                            i = 3;
                        } else if (this.a.w0.B0()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.m0 = true;
                    }
                    if (this.a.w0.K1(false)) {
                        this.a.D0.W2();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.t0 == null || !this.a.w0.E1() || !this.a.t0.d()) && this.a.w0.S0() != null) {
                        this.a.D0.o2();
                    }
                    this.a.q2 = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w2 implements t.b {
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

        @Override // c.a.p0.w2.m.f.t.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1490);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.D0.b0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements GetSugMatchWordsModel.b {
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.a.D0 == null) {
                return;
            }
            this.a.D0.a3(list);
        }
    }

    /* loaded from: classes5.dex */
    public static class x0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0() {
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
        public void onNavigationButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements Runnable {
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
    public class x2 implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.a.e1).showToast(R.string.obfuscated_res_0x7f0f06ed);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.e1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements PraiseModel.b {
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

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.M1 = false;
                if (this.a.N1 == null) {
                    return;
                }
                c.a.p0.w2.i.f S0 = this.a.w0.S0();
                if (S0.O().getPraise().getIsLike() == 1) {
                    this.a.E6(0);
                } else {
                    this.a.E6(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, S0.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.M1 = false;
                if (this.a.N1 == null || str == null) {
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

    /* loaded from: classes5.dex */
    public class y0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.S0 != null && this.a.S0.a() != null) {
                    this.a.S0.a().A(new c.a.o0.w.a(45, 27, null));
                }
                this.a.D0.W();
            }
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ y1 f34926b;

            public a(y1 y1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {y1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34926b = y1Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.w2.k.c.a(this.f34926b.a.getPageContext(), this.a).show();
                }
            }
        }

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
                c.a.d.f.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y2 implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements b.h {
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

        @Override // c.a.p0.w2.m.f.k1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.Y5(z);
                if (this.a.D0.C0() != null && z) {
                    this.a.D0.D3(false);
                }
                this.a.D0.U1(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.D0.d0();
                boolean z = false;
                if (c.a.d.f.p.l.z()) {
                    if (this.a.w0 != null && !this.a.w0.isLoading) {
                        this.a.w6();
                        this.a.D0.V2();
                        z = true;
                        if (this.a.w0.S0() != null && this.a.w0.S0().f19819f != null && this.a.w0.S0().f19819f.size() > i) {
                            int intValue = this.a.w0.S0().f19819f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.w0.l1()).param("fid", this.a.w0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.w0.H2(intValue)) {
                                this.a.i = true;
                                this.a.D0.J2(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
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
    public class z1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarkData f34927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f34928c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PbFragment f34929d;

        public z1(PbFragment pbFragment, MarkData markData, MarkData markData2, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34929d = pbFragment;
            this.a = markData;
            this.f34927b = markData2;
            this.f34928c = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f34929d.y0 != null) {
                    if (this.f34929d.y0.e()) {
                        this.f34929d.y0.d();
                        this.f34929d.y0.h(false);
                    }
                    this.f34929d.y0.i(this.a);
                    this.f34929d.y0.h(true);
                    this.f34929d.y0.a();
                }
                this.f34927b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f34927b);
                this.f34929d.a.setResult(-1, intent);
                this.f34928c.dismiss();
                this.f34929d.x6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z2 implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
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
        K2 = new x0();
        L2 = new v2();
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
        this.f34890b = true;
        this.f34891c = false;
        this.f34895g = false;
        this.f34896h = false;
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
        this.p0 = false;
        this.r0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.s0 = new q(this);
        this.u0 = new b0(this);
        this.v0 = new Handler(new m0(this));
        this.w0 = null;
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
        this.Z0 = new i1(this);
        this.a1 = new t1(this);
        this.b1 = new e2(this);
        this.c1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = -1;
        this.q1 = 0;
        this.t1 = new p2(this);
        this.u1 = new a3(this);
        this.v1 = new g(this, 2004016);
        this.w1 = new h(this, 2016485);
        this.x1 = new i(this, 2001269);
        this.y1 = new j(this, 2004008);
        this.z1 = new k(this, 2004007);
        this.A1 = new l(this, 2004005);
        this.B1 = new m(this, 2001332);
        this.C1 = new n(this, 2921391);
        this.D1 = new o(this, 2921606);
        this.E1 = new p(this, 2921658);
        this.F1 = new r(this);
        this.G1 = new s(this, 2001369);
        this.H1 = new t(this, 2016488);
        this.I1 = new u(this, 2016331);
        this.J1 = new v(this);
        this.K1 = new w(this, 2921509);
        this.L1 = new x(this);
        this.N1 = new PraiseModel(getPageContext(), new y(this));
        this.O1 = new z(this);
        this.P1 = new c0(this, 2001115);
        this.Q1 = new d0(this);
        this.R1 = new g0(this);
        this.S1 = new c.a.p0.w2.j.c(new j0(this));
        this.T1 = new l0(this, 2001427);
        this.U1 = new n0(this, 2001428);
        this.V1 = new o0(this, 2921634);
        this.W1 = new p0(this, 2001426);
        this.X1 = new q0(this, 2004021);
        this.Y1 = new r0(this, 2016528);
        this.Z1 = new s0(this, 2921033);
        this.a2 = new t0(this);
        this.b2 = new u0(this);
        this.c2 = new z0(this);
        this.d2 = new c1(this);
        this.e2 = new d1(this, 2921480);
        this.f2 = new e1(this);
        this.g2 = new f1(this);
        this.h2 = new g1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.i2 = new h1(this);
        this.j2 = new j1(this, 2016450);
        this.k2 = new k1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.l2 = new l1(this);
        this.m2 = new o1(this);
        this.n2 = new r1(this);
        this.o2 = new u1(this);
        this.p2 = new v1(this);
        this.r2 = new w1(this);
        this.s2 = 0;
        this.t2 = new j2(this);
        this.u2 = false;
        this.v2 = null;
        this.w2 = new k2(this);
        this.x2 = new l2(this);
        this.y2 = new m2(this);
        this.z2 = new n2(this);
        this.A2 = new o2(this);
        this.B2 = new q2(this);
        this.C2 = new r2(this);
        this.D2 = new t2(this);
        this.E2 = new u2(this);
        this.F2 = new w2(this);
        this.G2 = -1;
        this.H2 = -1;
    }

    public static PbFragment E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final String A4() {
        InterceptResult invokeV;
        c.a.p0.w2.i.f S0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || (S0 = pbModel.S0()) == null) {
                return null;
            }
            return S0.T().f19871c;
        }
        return (String) invokeV.objValue;
    }

    public final void A5() {
        MarkData j02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y0 == null) {
            return;
        }
        if (this.w0.S0() != null && this.w0.S0().g0()) {
            j02 = this.w0.j0(0);
        } else {
            j02 = this.w0.j0(this.D0.E0());
        }
        if (j02 == null) {
            return;
        }
        if (j02.isApp() && (j02 = this.w0.j0(this.D0.E0() + 1)) == null) {
            return;
        }
        this.D0.V2();
        this.y0.i(j02);
        if (!this.y0.e()) {
            if (this.D0 != null && this.w0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !c.a.p0.w2.m.f.n1.b.k(this.w0.f34970b)) {
                this.D0.B3();
                c.a.p0.w2.m.f.n1.b.b(this.w0.f34970b);
            }
            this.y0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.y0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void A6(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.getPbModel().k1()).param("topic_id", this.a.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.getPbModel().o1()));
    }

    public final String B4() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S0() == null || this.w0.S0().F() == null || (count = ListUtils.getCount((F = this.w0.S0().F()))) == 0) {
                return "";
            }
            if (this.w0.d1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.G();
                    }
                }
            }
            int v02 = this.D0.v0();
            PostData postData = (PostData) ListUtils.getItem(F, v02);
            if (postData != null && postData.s() != null) {
                if (this.w0.I1(postData.s().getUserId())) {
                    return postData.G();
                }
                for (int i3 = v02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.w0.I1(postData2.s().getUserId())) {
                        return postData2.G();
                    }
                }
                for (int i4 = v02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.w0.I1(postData3.s().getUserId())) {
                        return postData3.G();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void B5(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69)) == null) {
                return;
            }
            C5(postData);
        }
    }

    public final void B6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.w0.f34970b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.p0.w2.m.f.n1.a.m(i3))));
        }
    }

    public final TbRichText C4(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText N = arrayList.get(i4).N();
                    if (N != null && (A = N.A()) != null) {
                        int size = A.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (A.get(i6) != null && A.get(i6).getType() == 8) {
                                i5++;
                                if (A.get(i6).E().A().equals(str) || A.get(i6).E().B().equals(str)) {
                                    int h3 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                                    int width = A.get(i6).E().getWidth() * h3;
                                    int height = A.get(i6).E().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.s2 = i6;
                                    return N;
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

    public void C5(PostData postData) {
        PostData y4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.G() != null && postData.G().equals(this.w0.N0())) {
            z3 = true;
        }
        MarkData M0 = this.w0.M0(postData);
        if (this.w0.S0() != null && this.w0.S0().g0() && (y4 = y4()) != null) {
            M0 = this.w0.M0(y4);
        }
        if (M0 == null) {
            return;
        }
        this.D0.V2();
        c.a.o0.h.a aVar = this.y0;
        if (aVar != null) {
            aVar.i(M0);
            if (!z3) {
                this.y0.a();
            } else {
                this.y0.d();
            }
        }
    }

    public final void C6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.D(this.w0.getForumId()) && this.w0.S0() != null && this.w0.S0().l() != null) {
            if (this.w0.S0().l().isLike() == 1) {
                this.w0.g0().C(this.w0.getForumId(), this.w0.k1());
            }
        }
    }

    public final int D4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.u2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.A().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.A().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.E().getWidth() * h3;
                        int height = tbRichTextData.E().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.E().F()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = c.a.p0.w2.i.g.a(tbRichTextData);
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
                                    imageUrlData.originalUrl = M4(tbRichTextData);
                                    imageUrlData.originalSize = N4(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = H4(tbRichTextData);
                                    imageUrlData.isLongPic = F4(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = c.a.d.f.m.b.g(this.w0.k1(), -1L);
                                    imageUrlData.mIsReserver = this.w0.d1();
                                    imageUrlData.mIsSeeHost = this.w0.w0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.u2) {
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

    public final boolean D5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = c.a.o0.r.j0.b.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.o0.l.a.q(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0521), q3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void D6(c.a.o0.r.r.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, uVar) == null) || uVar == null) {
            return;
        }
        this.J2 = uVar;
        this.f34891c = true;
        this.D0.p2();
        this.D0.I2(this.I2);
    }

    public PbInterviewStatusView.f E4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final void E6(int i3) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i3) == null) || (pbModel = this.w0) == null || pbModel.S0() == null || (O = this.w0.S0().O()) == null) {
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
                    getResources().getString(R.string.obfuscated_res_0x7f0f15e0);
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
                getResources().getString(R.string.obfuscated_res_0x7f0f15e0);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.w0.i1()) {
            this.D0.o0().Y();
        } else {
            this.D0.Q3(this.w0.S0());
        }
    }

    public final boolean F4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().G();
        }
        return invokeL.booleanValue;
    }

    public void F5() {
        List<b3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (list = this.p1) == null || list.isEmpty()) {
            return;
        }
        int size = this.p1.size();
        while (true) {
            size--;
            if (size <= -1 || this.p1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    public final TbRichText F6(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i3)) == null) {
            PbModel pbModel = this.w0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S0() == null || str == null || i3 < 0) {
                return null;
            }
            c.a.p0.w2.i.f S0 = this.w0.S0();
            if (S0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S0.j());
                tbRichText = C4(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = S0.F();
                b4(S0, F);
                return C4(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public boolean G4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (!this.f34891c && this.G2 == -1 && this.H2 == -1) ? false : true : invokeV.booleanValue;
    }

    public boolean G5(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.p0.w2.m.f.a1 a1Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i3, keyEvent)) == null) ? (keyEvent == null || (a1Var = this.D0) == null || !a1Var.S1(i3)) ? false : true : invokeIL.booleanValue;
    }

    public final boolean H4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().H();
        }
        return invokeL.booleanValue;
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!c.a.d.f.p.l.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c16);
                return;
            }
            this.D0.d0();
            if (this.i) {
                return;
            }
            w6();
            this.D0.V2();
            if (this.w0.loadData()) {
                this.D0.z3();
            }
        }
    }

    public boolean I4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public void I5() {
        PbModel pbModel;
        c.a.p0.w2.i.f S0;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (pbModel = this.w0) == null || pbModel.S0() == null || (O = (S0 = this.w0.S0()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.D0.e1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        c.a.p0.w2.m.f.m0 m0Var = new c.a.p0.w2.m.f.m0();
        int V = this.w0.S0().V();
        if (V != 1 && V != 3) {
            m0Var.f20239g = false;
        } else {
            m0Var.f20239g = true;
            m0Var.s = O.getIs_top() == 1;
        }
        if (p5(V)) {
            m0Var.f20240h = true;
            m0Var.r = O.getIs_good() == 1;
        } else {
            m0Var.f20240h = false;
        }
        if (V == 1002 && !equals) {
            m0Var.u = true;
        }
        m0Var.n = j6(O.isBlocked(), S0.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        m0Var.f20237e = h6(equals, S0.i0());
        m0Var.i = k6();
        m0Var.f20238f = i6(equals);
        m0Var.k = equals && S0.U() != null && S0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            m0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        m0Var.t = equals;
        m0Var.q = this.w0.i1();
        m0Var.f20234b = true;
        m0Var.a = s5(equals);
        if (equals) {
            this.D0.u1();
        }
        m0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        m0Var.j = true;
        m0Var.o = this.w0.w0();
        m0Var.f20236d = true;
        if (O.getThreadVideoInfo() == null) {
            m0Var.f20235c = true;
        } else {
            m0Var.f20235c = false;
        }
        if (S0.g0()) {
            m0Var.f20234b = false;
            m0Var.f20236d = false;
            m0Var.f20235c = false;
            m0Var.f20239g = false;
            m0Var.f20240h = false;
        }
        m0Var.v = TbSingleton.getInstance().mShowCallFans && equals && !S0.g0();
        c.a.p0.w2.m.f.a1 a1Var = this.D0;
        if (a1Var != null) {
            PbModel pbModel2 = this.w0;
            PostData w02 = a1Var.w0(pbModel2.G, pbModel2.i1());
            m0Var.w = w02 != null ? w02.Q : false;
        }
        m0Var.m = true;
        if (O.isBlocked()) {
            m0Var.n = false;
            m0Var.f20239g = false;
            m0Var.f20240h = false;
        }
        this.D0.f19993h.E(m0Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.e1.n.i
    /* renamed from: J4 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var == null) {
                return null;
            }
            return a1Var.F0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void J5(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048600, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        c.a.p0.w2.i.f S0 = this.w0.S0();
        TbRichText F6 = F6(str, i3);
        if (F6 == null || (tbRichTextData = F6.A().get(this.s2)) == null) {
            return;
        }
        eVar.f34857f = String.valueOf(F6.getPostId());
        eVar.a = new ArrayList<>();
        eVar.f34853b = new ConcurrentHashMap<>();
        if (!tbRichTextData.E().F()) {
            eVar.f34859h = false;
            String a4 = c.a.p0.w2.i.g.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.s ? 17 : 18;
            }
            imageUrlData.originalUrl = M4(tbRichTextData);
            imageUrlData.originalUrl = M4(tbRichTextData);
            imageUrlData.originalSize = N4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = H4(tbRichTextData);
            imageUrlData.isLongPic = F4(tbRichTextData);
            imageUrlData.postId = F6.getPostId();
            imageUrlData.mIsReserver = this.w0.d1();
            imageUrlData.mIsSeeHost = this.w0.w0();
            eVar.f34853b.put(a4, imageUrlData);
            if (S0 != null) {
                if (S0.l() != null) {
                    eVar.f34854c = S0.l().getName();
                    eVar.f34855d = S0.l().getId();
                }
                if (S0.O() != null) {
                    eVar.f34856e = S0.O().getId();
                }
                eVar.f34858g = S0.s() == 1;
            }
            imageUrlData.threadId = c.a.d.f.m.b.g(eVar.f34856e, -1L);
            return;
        }
        eVar.f34859h = true;
        int size = S0.F().size();
        this.u2 = false;
        eVar.j = -1;
        int D4 = S0.j() != null ? D4(S0.j().N(), F6, i3, i3, eVar.a, eVar.f34853b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = S0.F().get(i4);
            if (postData.G() == null || S0.j() == null || S0.j().G() == null || !postData.G().equals(S0.j().G())) {
                D4 = D4(postData.N(), F6, D4, i3, eVar.a, eVar.f34853b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (S0 != null) {
            if (S0.l() != null) {
                eVar.f34854c = S0.l().getName();
                eVar.f34855d = S0.l().getId();
            }
            if (S0.O() != null) {
                eVar.f34856e = S0.O().getId();
            }
            eVar.f34858g = S0.s() == 1;
        }
        eVar.j = D4;
    }

    public int K4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.H2 : invokeV.intValue;
    }

    public void K5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || !checkUpIsLogin() || (pbModel = this.w0) == null || pbModel.S0() == null || this.w0.S0().l() == null || d4()) {
            return;
        }
        if (this.w0.S0().g0()) {
            this.D0.W();
            return;
        }
        if (this.W0 == null) {
            c.a.p0.f1.i2.a.c cVar = new c.a.p0.f1.i2.a.c(getPageContext());
            this.W0 = cVar;
            cVar.j(0);
            this.W0.i(new y0(this));
        }
        this.W0.g(this.w0.S0().l().getId(), c.a.d.f.m.b.g(this.w0.k1(), 0L));
    }

    public int L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.G2 : invokeV.intValue;
    }

    public final AbsPbActivity.e L5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            String str2 = null;
            if (this.w0.S0() != null && this.w0.S0().F() != null && this.w0.S0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.w0.S0().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.w0.S0().F().get(i3).G())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.w0.S0().F().get(i3);
                if (postData.N() != null && postData.N().A() != null) {
                    Iterator<TbRichTextData> it = postData.N().A().iterator();
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
                    J5(str2, 0, eVar);
                    c.a.p0.w2.i.g.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final String M4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return null;
            }
            return tbRichTextData.E().C();
        }
        return (String) invokeL.objValue;
    }

    public final void M5(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091731, Integer.valueOf(this.f34890b ? 2 : 3));
        view.setTag(sparseArray);
    }

    public final long N4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return 0L;
            }
            return tbRichTextData.E().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public void N5(c.a.p0.w2.i.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, uVar) == null) {
            String G = uVar.i().G();
            List<PostData> list = this.w0.S0().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.G() == null || !postData.G().equals(G)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = uVar.k();
                    postData.A0(uVar.m());
                    if (postData.P() != null) {
                        postData.P().clear();
                        postData.P().addAll(k3);
                    }
                }
            }
            if (this.w0.C0()) {
                return;
            }
            this.D0.t1(this.w0.S0());
        }
    }

    public c.a.o0.w.y.e O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.S0 : (c.a.o0.w.y.e) invokeV.objValue;
    }

    public void O5(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048610, this, z3, markData) == null) {
            this.D0.U2();
            this.w0.D2(z3);
            c.a.o0.h.a aVar = this.y0;
            if (aVar != null) {
                aVar.h(z3);
                if (markData != null) {
                    this.y0.i(markData);
                }
            }
            if (this.w0.E0()) {
                z5();
            } else {
                this.D0.t1(this.w0.S0());
            }
        }
    }

    public c.a.p0.w2.m.f.k1.b P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f34893e : (c.a.p0.w2.m.f.k1.b) invokeV.objValue;
    }

    public void P5(c.a.p0.w2.i.u uVar) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, uVar) == null) || uVar.i() == null) {
            return;
        }
        String G = uVar.i().G();
        ArrayList<PostData> F = this.w0.S0().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.G() == null || !postData.G().equals(G)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = uVar.k();
                postData.A0(uVar.m());
                if (postData.P() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.W() != null && next != null && next.s() != null && (metaData = postData.W().get(next.s().getUserId())) != null) {
                            next.l0(metaData);
                            next.u0(true);
                            next.G0(getPageContext(), this.w0.I1(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.P().size();
                    if (!postData.a0(false)) {
                        postData.P().clear();
                        postData.P().addAll(k3);
                    }
                }
                if (postData.x() != null) {
                    postData.j0();
                }
            }
        }
        if (!this.w0.C0() && z3) {
            this.D0.t1(this.w0.S0());
        }
        if (z3) {
            N5(uVar);
        }
    }

    public final int Q4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i3)) == null) {
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

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            hideNetRefreshView(this.D0.a1());
            o6();
            if (this.w0.Q1()) {
                this.D0.V2();
            }
            this.D0.c3();
        }
    }

    public c.a.p0.w2.m.f.m1.a R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.t0 : (c.a.p0.w2.m.f.m1.a) invokeV.objValue;
    }

    public void R5(b3 b3Var) {
        List<b3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, b3Var) == null) || b3Var == null || (list = this.p1) == null) {
            return;
        }
        list.remove(b3Var);
    }

    public c.a.p0.w2.m.f.a1 S4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.D0 : (c.a.p0.w2.m.f.a1) invokeV.objValue;
    }

    public final boolean S5(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f091e69);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.y0 && !TextUtils.isEmpty(postData.u()) && c.a.o0.r.l.c().g()) {
                        return D5(postData.G());
                    }
                    if (checkUpIsLogin() && (pbModel = this.w0) != null && pbModel.S0() != null) {
                        if (S4().P0() != null) {
                            S4().P0().c();
                        }
                        c.a.p0.w2.i.u uVar = new c.a.p0.w2.i.u();
                        uVar.A(this.w0.S0().l());
                        uVar.E(this.w0.S0().O());
                        uVar.C(postData);
                        S4().O0().U(uVar);
                        S4().O0().setPostId(postData.G());
                        y5(view, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.o0.w.y.e eVar = this.S0;
                        if (eVar != null) {
                            this.D0.A2(eVar.C());
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

    public c.a.o0.r.r.k1 T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.j0 : (c.a.o0.r.r.k1) invokeV.objValue;
    }

    public final void T5(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            c.a.p0.w2.m.f.j1.f.a aVar = new c.a.p0.w2.m.f.j1.f.a(this.a);
            this.Q = aVar;
            aVar.n(this.Z0);
            this.Q.m(this.f2);
        }
        this.Q.k(emotionImageData, w(), w().S0());
    }

    @Override // c.a.p0.w2.q.c
    public PbModel.g U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.i2 : (PbModel.g) invokeV.objValue;
    }

    public String U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public final void U5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (pbModel = this.w0) == null || pbModel.S0() == null || this.w0.S0().O() == null || !this.w0.S0().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final int V4(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().getThreadType() == 0) {
                return 1;
            }
            if (fVar.O().getThreadType() == 54) {
                return 2;
            }
            return fVar.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void V5(boolean z3, PostData postData) {
        c.a.o0.s.c.c adAdSense;
        c.a.p0.w2.m.f.a1 a1Var;
        c.a.p0.w2.m.f.l o02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048625, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g() || (a1Var = this.D0) == null || (o02 = a1Var.o0()) == null || (E = o02.E()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        Iterator<PostData> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostData next = it.next();
            String G = next.G();
            i3++;
            if (z3) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f12288b = G;
                    cVar.f12289c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.C == 1 && !TextUtils.isEmpty(G)) {
                next.C = 2;
                a.c cVar2 = new a.c();
                cVar2.f12288b = G;
                cVar2.f12289c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S0() == null || this.w0.S0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.w0.S0().l().getFirst_class();
                str2 = this.w0.S0().l().getSecond_class();
                str3 = this.w0.S0().l().getId();
                str4 = this.w0.k1();
                str = first_class;
            }
            c.a.p0.l3.a0.w(z3, str, str2, str3, str4, arrayList, adAdSense.i());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.w2.q.c
    /* renamed from: W4 */
    public VideoPbFragment t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public final void W5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (pbModel = this.w0) == null || pbModel.S0() == null || this.w0.S0().O() == null || !this.w0.S0().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public void X3(b3 b3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, b3Var) == null) || b3Var == null) {
            return;
        }
        if (this.p1 == null) {
            this.p1 = new ArrayList();
        }
        if (this.p1.contains(b3Var)) {
            return;
        }
        this.p1.add(b3Var);
    }

    public String X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public final void X5(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048630, this, i3) == null) || this.w0 == null) {
            return;
        }
        o6();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.w0.f34970b);
        sendMessage(privacySettingMessage);
    }

    public void Y3(b3 b3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, b3Var) == null) || b3Var == null) {
            return;
        }
        if (this.p1 == null) {
            this.p1 = new ArrayList();
        }
        if (this.p1.contains(b3Var)) {
            return;
        }
        this.p1.add(0, b3Var);
    }

    public void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.f34895g) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.w0.S0() == null || this.w0.S0().O() == null || this.w0.S0().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.w0.S0().O().getTaskInfoData().g(), this.w0.S0().O().getTaskInfoData().f(), this.w0.S0().O().getTaskInfoData().b(), this.w0.S0().O().getTaskInfoData().c(), this.w0.S0().O().getIs_top(), this.w0.S0().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public void Y5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z3) == null) {
            this.N = z3;
        }
    }

    public final void Z3() {
        PbModel pbModel;
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (pbModel = this.w0) == null || (fVar = pbModel.G) == null || fVar.O() == null) {
            return;
        }
        ThreadData O = this.w0.G.O();
        O.mRecomAbTag = this.w0.X0();
        O.mRecomWeight = this.w0.a1();
        O.mRecomSource = this.w0.Z0();
        O.mRecomExtra = this.w0.Y0();
        O.isSubPb = this.w0.G0();
        if (O.getFid() == 0) {
            O.setFid(c.a.d.f.m.b.g(this.w0.getForumId(), 0L));
        }
        StatisticItem i3 = c.a.o0.o0.c.i(getContext(), O, "c13562");
        TbPageTag l3 = c.a.o0.o0.c.l(getContext());
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

    public final void Z4(int i3, Intent intent) {
        c.a.o0.w.n nVar;
        c.a.o0.w.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048635, this, i3, intent) == null) {
            if (i3 == 0) {
                this.D0.e1();
                this.D0.P0().c();
                this.D0.h3(false);
            }
            this.D0.s2();
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
                    if (editorType != 1 || this.D0.P0() == null || this.D0.P0().b() == null) {
                        return;
                    }
                    c.a.o0.w.y.h b4 = this.D0.P0().b();
                    b4.b0(this.w0.S0().O());
                    b4.B(writeData);
                    b4.c0(pbEditorData.getVoiceModel());
                    c.a.o0.w.m n3 = b4.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new c.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.S0.S();
                this.S0.t0(pbEditorData.getVoiceModel());
                this.S0.G(writeData);
                c.a.o0.w.m n4 = this.S0.a().n(6);
                if (n4 != null && (nVar = n4.k) != null) {
                    nVar.onAction(new c.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.S0.L(null, null);
                }
            }
        }
    }

    public final void Z5(c.a.o0.w.y.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, gVar) == null) || gVar == null || (pbModel = this.w0) == null) {
            return;
        }
        gVar.p(pbModel.s0());
        if (this.w0.S0() != null && this.w0.S0().l() != null) {
            gVar.o(this.w0.S0().l());
        }
        gVar.q("pb");
        gVar.r(this.w0);
    }

    public final void a4(boolean z3) {
        PbModel pbModel;
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z3) == null) || (pbModel = this.w0) == null || (fVar = pbModel.G) == null || fVar.O() == null) {
            return;
        }
        ThreadData O = this.w0.G.O();
        O.mRecomAbTag = this.w0.X0();
        O.mRecomWeight = this.w0.a1();
        O.mRecomSource = this.w0.Z0();
        O.mRecomExtra = this.w0.Y0();
        if (O.getFid() == 0) {
            O.setFid(c.a.d.f.m.b.g(this.w0.getForumId(), 0L));
        }
        StatisticItem i3 = c.a.o0.o0.c.i(getContext(), O, "c13563");
        TbPageTag l3 = c.a.o0.o0.c.l(getContext());
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
            c.a.o0.n0.c currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i3);
        }
    }

    public void a5(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebb) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebb) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebd) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ebc) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebc) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091eb8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb8) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091eb9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb9) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.g1);
            userMuteAddAndDelCustomMessage.setTag(this.g1);
            s6(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void a6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i3) == null) || (pbModel = this.w0) == null) {
            return;
        }
        int b12 = pbModel.b1();
        if (i3 == 5) {
            this.w0.x2(2);
        } else if (i3 == 6) {
            this.w0.x2(3);
        } else if (i3 != 7) {
            this.w0.x2(1);
        } else {
            this.w0.x2(4);
        }
        int b13 = this.w0.b1();
        if (b12 == 4 || b13 == 4) {
            H5();
        }
    }

    public final void b4(c.a.p0.w2.i.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048640, this, fVar, arrayList) == null) || fVar == null || fVar.T() == null || fVar.T().a == null || (list = fVar.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.G()) && !TextUtils.isEmpty(postData.G()) && next.G().equals(postData.G())) {
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

    public final void b5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S0() != null && this.w0.S0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.w0.k1(), str);
                ThreadData O = this.w0.S0().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                t5(format);
                return;
            }
            this.x0.a(str);
        }
    }

    public void b6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z3) == null) {
            this.K = z3;
        }
    }

    public void c4(boolean z3) {
        c.a.p0.w2.m.f.a1 a1Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048643, this, z3) == null) || (a1Var = this.D0) == null || a1Var.F0() == null) {
            return;
        }
        int firstVisiblePosition = this.D0.F0().getFirstVisiblePosition();
        int lastVisiblePosition = this.D0.F0().getLastVisiblePosition();
        c.a.p0.w2.m.f.l o02 = this.D0.o0();
        if (o02 == null || this.w0.S0() == null) {
            return;
        }
        if (lastVisiblePosition <= o02.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > o02.w() ? firstVisiblePosition - o02.w() : 0;
            w4 = (lastVisiblePosition - o02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.D0.F0().G(w3) != null && (this.D0.F0().G(w3) instanceof PostData) && (postData = (PostData) this.D0.F0().G(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.w0.S0().F(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.k0(postData2.p());
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
            Collections.sort(arrayList, new p1(this));
            c.a.o0.t.a aVar = (c.a.o0.t.a) ListUtils.getItem(arrayList, 0);
            if (aVar == null || aVar.e() != 1) {
                this.D0.g2(aVar, 1);
            } else if (z3) {
            } else {
                this.D0.g2(aVar, 0);
            }
        }
    }

    public final void c5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, intent) == null) {
            c.a.p0.w2.m.f.n1.b.j(this, intent);
        }
    }

    public final void c6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z3) == null) {
            this.S0.f0(z3);
            this.S0.i0(z3);
            this.S0.p0(z3);
        }
    }

    public final boolean d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.w0.S0().O()) || AntiHelper.d(getPageContext(), this.w0.S0().d());
        }
        return invokeV.booleanValue;
    }

    public void d5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        c.a.d.f.p.n.w(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public final void d6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048648, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new q1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                r6(str);
            } else {
                this.D0.G3(str);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048649, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (c.a.o0.e1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.o0.e1.n.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (c.a.p0.w2.m.f.f1.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new c.a.o0.e1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final boolean e4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void e5() {
        c.a.p0.w2.m.f.a1 a1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || (a1Var = this.D0) == null) {
            return;
        }
        a1Var.e1();
        d5();
    }

    public final void e6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048652, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (S4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    c.a.o0.s.h.c.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    c.a.p0.a4.t0.h.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.w0.G0()) {
            antiData.setBlock_forum_name(this.w0.S0().l().getName());
            antiData.setBlock_forum_id(this.w0.S0().l().getId());
            antiData.setUser_name(this.w0.S0().U().getUserName());
            antiData.setUser_id(this.w0.S0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void f4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.D0.p3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.d.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.d.f.m.b.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091eba), 0L);
            BdUniqueId bdUniqueId = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.d1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void f5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048654, this, i3, i4) == null) {
            c.a.o0.c1.n0.b(new e(this, i4), new f(this, i4, i3));
        }
    }

    public final void f6(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            c.a.p0.w2.m.f.n1.b.l(this, j3, str, j4);
        }
    }

    @Override // c.a.p0.w2.q.c
    public void finish() {
        c.a.p0.w2.m.f.a1 a1Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            c.a.p0.w2.m.f.a1 a1Var2 = this.D0;
            if (a1Var2 != null) {
                a1Var2.d0();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S0() != null && !this.w0.S0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.w0.S0().O().getId();
                if (this.w0.isShareThread() && this.w0.S0().O().originalThreadData != null) {
                    historyMessage.threadName = this.w0.S0().O().originalThreadData.f29822b;
                } else {
                    historyMessage.threadName = this.w0.S0().O().getTitle();
                }
                if (this.w0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.w0.S0().l().getName();
                }
                ArrayList<PostData> F = this.w0.S0().F();
                c.a.p0.w2.m.f.a1 a1Var3 = this.D0;
                int v02 = a1Var3 != null ? a1Var3.v0() : 0;
                if (F != null && v02 >= 0 && v02 < F.size()) {
                    historyMessage.postID = F.get(v02).G();
                }
                historyMessage.isHostOnly = this.w0.w0();
                historyMessage.isSquence = this.w0.i1();
                historyMessage.isShareThread = this.w0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.o0.w.y.e eVar = this.S0;
            if (eVar != null) {
                eVar.I();
            }
            if (this.j && S4() != null) {
                S4().i0();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && (pbModel2.y0() || this.w0.B0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.w0.k1());
                if (this.E0) {
                    if (this.G0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.w0.H0());
                    }
                    if (this.F0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.w0.D0());
                    }
                }
                if (this.w0.S0() != null && System.currentTimeMillis() - this.p >= 40000 && (q3 = this.w0.S0().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.o1);
                }
                this.a.setResult(-1, intent);
            }
            if (y6()) {
                if (this.w0 != null && (a1Var = this.D0) != null && a1Var.F0() != null) {
                    c.a.p0.w2.i.f S0 = this.w0.S0();
                    if (S0 != null) {
                        if (S0.U() != null) {
                            S0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!S0.m0() && !this.I && S0.f19821h == null) {
                            c.a.p0.w2.m.f.s0.b().n(this.w0.T0(), this.D0.F0().onSaveInstanceState(), this.w0.i1(), this.w0.w0(), this.D0.N0() != null && this.D0.N0().getVisibility() == 0);
                            if (this.n1 >= 0 || this.w0.m1() != null) {
                                c.a.p0.w2.m.f.s0.b().q(this.w0.m1());
                                c.a.p0.w2.m.f.s0.b().r(this.w0.n1());
                                c.a.p0.w2.m.f.s0.b().o(this.w0.L0());
                            }
                        }
                    }
                } else {
                    c.a.p0.w2.m.f.s0.b().m();
                }
                x6();
            }
        }
    }

    public boolean g4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if ((this.w0.S0() != null && (this.w0.S0().g0() || ThreadCardUtils.isSelf(this.w0.S0().O()))) || this.V0 == null || this.w0.S0() == null || this.w0.S0().d() == null) {
                return true;
            }
            return this.V0.checkPrivacyBeforeInvokeEditor(this.w0.S0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void g5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i3) == null) {
            c.a.o0.c1.n0.b(new c(this), new d(this, i3));
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

    public final void g6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            c.a.p0.w2.m.f.n1.a.d(getActivity(), getPageContext(), new v0(this, sparseArray, i3, z3), new w0(this));
        }
    }

    public c.a.p0.w2.m.f.k1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.a.getEventController() : (c.a.p0.w2.m.f.k1.a) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (this.L == null) {
                this.L = new c.a.d.f.k.b<>(new d2(this), 20, 0);
            }
            return this.L;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.C == null) {
                this.C = new c.a.d.f.k.b<>(new c2(this), 8, 0);
            }
            return this.C;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.H == null) {
                this.H = new c.a.d.f.k.b<>(new i2(this), 10, 0);
            }
            return this.H;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            c.a.d.f.k.b<RelativeLayout> bVar = new c.a.d.f.k.b<>(new h2(this), 10, 0);
            this.G = bVar;
            return bVar;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var == null) {
                return 0;
            }
            return a1Var.U0();
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.F == null) {
                this.F = new c.a.d.f.k.b<>(new s2(this), 15, 0);
            }
            return this.F;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (this.E == null) {
                this.E = new c.a.d.f.k.b<>(new f2(this), 5, 0);
            }
            return this.E;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (this.B == null) {
                this.B = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.B;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.k : (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (this.D == null) {
                this.D = new c.a.d.f.k.b<>(new g2(this), 8, 0);
            }
            return this.D;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public boolean h4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i3)) == null) {
            if (this.V0 == null || this.w0.S0() == null || ThreadCardUtils.isSelf(this.w0.S0().O()) || this.w0.S0().d() == null) {
                return true;
            }
            return this.V0.checkPrivacyBeforeSend(this.w0.S0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void h5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            c.a.o0.h.a c4 = c.a.o0.h.a.c(this.a);
            this.y0 = c4;
            if (c4 != null) {
                c4.j(this.l2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.z0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.n2);
            this.A0 = new c.a.o0.s.e.a(getPageContext());
            this.N1.setUniqueId(getUniqueId());
            this.N1.registerListener();
        }
    }

    public final boolean h6(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        c.a.o0.r.r.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048676, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S0() == null) {
                return false;
            }
            c.a.p0.w2.i.f S0 = this.w0.S0();
            ThreadData O = S0.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !c.a.p0.f1.w0.isOn()) || this.w0.G() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (S0.l() == null || !S0.l().isBlockBawuDelete) {
                if (S0.O() == null || !S0.O().isBlocked()) {
                    if (S0.V() != 0) {
                        return S0.V() != 3;
                    }
                    List<c.a.o0.r.r.x1> p3 = S0.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (c.a.o0.r.r.x1 x1Var : p3) {
                            if (x1Var != null && (e0Var = x1Var.f10996g) != null && e0Var.a && !e0Var.f10845c && ((i3 = e0Var.f10844b) == 1 || i3 == 2)) {
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

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i4(AgreeData agreeData) {
        c.a.o0.n0.c currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048677, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l0 == null) {
            this.l0 = new c.a.o0.r.g0.a();
        }
        if (this.q0 == null) {
            c.a.p0.a4.k0.e eVar = new c.a.p0.a4.k0.e();
            this.q0 = eVar;
            eVar.a = getUniqueId();
        }
        c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
        fVar.f10852b = 5;
        fVar.f10858h = 8;
        fVar.f10857g = 2;
        if (w() != null) {
            fVar.f10856f = w().R0();
        }
        fVar.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l0.c(agreeData, i3, getUniqueId(), false);
                this.l0.d(agreeData, this.q0);
                pbModel = this.w0;
                if (pbModel != null || pbModel.S0() == null) {
                }
                this.l0.b(x(), fVar, agreeData, this.w0.S0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.l0.c(agreeData, i3, getUniqueId(), false);
        this.l0.d(agreeData, this.q0);
        pbModel = this.w0;
        if (pbModel != null) {
        }
    }

    public final void i5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new h0(this));
        }
    }

    public final boolean i6(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048679, this, z3)) == null) {
            if (z3 || (pbModel = this.w0) == null || pbModel.S0() == null || (this.w0.S0().l() != null && this.w0.S0().l().isBlockBawuDelete)) {
                return false;
            }
            c.a.p0.w2.i.f S0 = this.w0.S0();
            if ((S0.O() == null || S0.O().getAuthor() == null || !S0.O().getAuthor().isForumBusinessAccount() || c.a.p0.f1.w0.isOn()) && !this.w0.G()) {
                return ((S0.O() != null && S0.O().isBlocked()) || this.w0.S0().V() == 0 || this.w0.S0().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.H1();
        }
        return invokeV.booleanValue;
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            if (this.w0.y0() || this.w0.B0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.w0.k1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.w0.k1()));
            if (y6()) {
                this.a.finish();
            }
        }
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && this.m == null) {
            this.m = new c.a.o0.r.t.c(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f0361), getPageContext().getString(R.string.obfuscated_res_0x7f0f1184), getPageContext().getString(R.string.obfuscated_res_0x7f0f1099)};
            c.a.o0.r.t.c cVar = this.m;
            cVar.j(strArr, new k0(this));
            cVar.g(c.b.obfuscated_res_0x7f1003a3);
            cVar.h(17);
            cVar.c(getPageContext());
        }
    }

    public final boolean j6(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048683, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || q5(i3));
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.p0.w2.r.g.b
    public void k0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z3) == null) {
            this.M0 = z3;
        }
    }

    public final boolean k4(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<c.a.o0.r.t.h> b4;
        c.a.o0.r.t.h hVar;
        c.a.o0.r.t.h hVar2;
        c.a.o0.r.t.h hVar3;
        c.a.o0.r.t.h hVar4;
        c.a.d.o.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                c.a.p0.w2.m.f.a1 a1Var = this.D0;
                if (a1Var != null) {
                    if (a1Var.x1()) {
                        return true;
                    }
                    this.D0.m0();
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e3) {
                    e3.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (o5(view)) {
                        if (view instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view;
                            this.j1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.k1 = url;
                            if (this.j1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view.getTag(R.id.obfuscated_res_0x7f091e9f) != null && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                            } else {
                                this.l1 = null;
                            }
                        } else if (view instanceof GifView) {
                            GifView gifView = (GifView) view;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.j1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.k1 = gifView.getBdImage().q();
                            }
                            if (view.getTag(R.id.obfuscated_res_0x7f091e9f) != null && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                            } else {
                                this.l1 = null;
                            }
                        } else if (view instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.j1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.k1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view.getTag(R.id.obfuscated_res_0x7f091e9f) != null && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                                    this.l1 = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                                } else {
                                    this.l1 = null;
                                }
                            }
                        }
                        if (view.getParent() instanceof TbRichTextView) {
                            try {
                                sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                            } catch (ClassCastException e4) {
                                e4.printStackTrace();
                            }
                        } else if (view.getParent().getParent() instanceof TbRichTextView) {
                            try {
                                sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                            } catch (ClassCastException e5) {
                                e5.printStackTrace();
                            }
                        } else {
                            this.D0.u3(this.x2, this.j1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
                this.v2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && o5(view)) {
                    this.D0.u3(this.x2, this.j1.t());
                    return true;
                }
                c.a.o0.h.a aVar2 = this.y0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z6 = aVar2.e() && this.v2.G() != null && this.v2.G().equals(this.w0.N0());
                boolean z7 = w().S0() != null && w().S0().g0();
                boolean z8 = w().S0() != null && w().S0().j0();
                if (this.v2.A() == 1) {
                    if (!z7) {
                        this.D0.v3(this.w2, z6, false, z8);
                    }
                    return true;
                }
                if (this.J0 == null) {
                    c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(getContext());
                    this.J0 = lVar;
                    lVar.n(this.b2);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z9 = o5(view) && !z7;
                boolean z10 = (!o5(view) || (aVar = this.j1) == null || aVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e82) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e82)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
                if (z9) {
                    z3 = booleanValue7;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new c.a.o0.r.t.h(1, getString(R.string.obfuscated_res_0x7f0f1067), this.J0));
                } else {
                    z3 = booleanValue7;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z10) {
                    arrayList.add(new c.a.o0.r.t.h(2, getString(R.string.obfuscated_res_0x7f0f1068), this.J0));
                }
                if (!z9 && !z10) {
                    c.a.o0.r.t.h hVar5 = new c.a.o0.r.t.h(3, getString(R.string.obfuscated_res_0x7f0f0435), this.J0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e69, this.v2);
                    hVar5.f11053d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        hVar4 = new c.a.o0.r.t.h(4, getString(R.string.obfuscated_res_0x7f0f0f80), this.J0);
                    } else {
                        hVar4 = new c.a.o0.r.t.h(4, getString(R.string.obfuscated_res_0x7f0f0a7f), this.J0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e69, this.v2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
                    hVar4.f11053d.setTag(sparseArray4);
                    arrayList.add(hVar4);
                }
                if (this.mIsLogin && !this.r0) {
                    if (!c.a.p0.w2.m.f.n1.a.h(this.w0) && !booleanValue4 && booleanValue3) {
                        c.a.o0.r.t.h hVar6 = new c.a.o0.r.t.h(5, getString(R.string.obfuscated_res_0x7f0f0b17), this.J0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                        hVar6.f11053d.setTag(sparseArray5);
                        arrayList.add(hVar6);
                    } else {
                        if ((s5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            c.a.o0.r.t.h hVar7 = new c.a.o0.r.t.h(5, getString(R.string.obfuscated_res_0x7f0f0fa2), this.J0);
                            hVar7.f11053d.setTag(str);
                            arrayList.add(hVar7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e79, str);
                        if (!c.a.p0.w2.m.f.n1.a.h(this.w0) && z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e81, Boolean.valueOf(z3));
                            if (z3) {
                                c.a.o0.r.t.h hVar8 = new c.a.o0.r.t.h(6, getString(R.string.obfuscated_res_0x7f0f048e), this.J0);
                                hVar8.f11053d.setTag(sparseArray6);
                                hVar2 = hVar8;
                                hVar = new c.a.o0.r.t.h(7, getString(R.string.obfuscated_res_0x7f0f02d3), this.J0);
                                hVar.f11053d.setTag(sparseArray6);
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                        }
                        hVar2 = null;
                        hVar = new c.a.o0.r.t.h(7, getString(R.string.obfuscated_res_0x7f0f02d3), this.J0);
                        hVar.f11053d.setTag(sparseArray6);
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                        if (this.w0.S0().V() == 1002 && !booleanValue2) {
                            hVar3 = new c.a.o0.r.t.h(6, getString(R.string.obfuscated_res_0x7f0f0fa2), this.J0);
                        } else {
                            hVar3 = new c.a.o0.r.t.h(6, getString(R.string.obfuscated_res_0x7f0f048e), this.J0);
                        }
                        hVar3.f11053d.setTag(sparseArray7);
                        hVar2 = hVar3;
                        hVar = null;
                    } else {
                        hVar = null;
                        hVar2 = null;
                    }
                    if (hVar2 != null) {
                        arrayList.add(hVar2);
                    }
                    if (hVar != null) {
                        arrayList.add(hVar);
                    }
                    c.a.p0.w2.m.f.n1.a.a(arrayList, this.J0, this.v2, this.w0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    b4 = c.a.p0.w2.m.f.n1.a.c(arrayList, this.v2.q(), sparseArray, this.J0);
                } else {
                    b4 = c.a.p0.w2.m.f.n1.a.b(arrayList, this.v2.q(), sparseArray, this.J0);
                }
                c.a.p0.w2.m.f.n1.a.k(b4, this.f34890b);
                c.a.p0.w2.m.f.n1.a.e(b4);
                this.J0.o(c.a.p0.w2.m.f.n1.a.f(this.v2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.J0.k(b4, false);
                } else {
                    this.J0.k(b4, true);
                }
                c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(getPageContext(), this.J0);
                this.I0 = jVar;
                jVar.m();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.w0.f34970b).param("fid", this.w0.getForumId()).param("uid", this.w0.S0().O().getAuthor().getUserId()).param("post_id", this.w0.A()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean k5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                return pbModel.y0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean k6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.i1()) {
                return this.w0.Q0() == null || this.w0.Q0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l4(ForumManageModel.b bVar, c.a.p0.w2.m.f.a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, bVar, a1Var) == null) {
            List<PostData> list = this.w0.S0().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).P().size()) {
                        break;
                    } else if (bVar.f36161g.equals(list.get(i3).P().get(i4).G())) {
                        list.get(i3).P().remove(i4);
                        list.get(i3).k();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).m(bVar.f36161g);
            }
            if (z3) {
                a1Var.t1(this.w0.S0());
            }
        }
    }

    public final boolean l5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.getPbModel() == null || this.a.getPbModel().R0() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void l6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0a80));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0a81));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a82), new m1(this, metaData));
        aVar.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a83), new n1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void m4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.p0.a4.k0.o z3 = this.w0.S0().z();
        if (z3 != null && str.equals(z3.K0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().i = null;
            }
            this.w0.S0().b();
        }
        c.a.p0.a4.k0.o m02 = this.w0.m0();
        if (m02 == null || !str.equals(m02.K0())) {
            return;
        }
        this.w0.Y();
    }

    public final boolean m5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            PostData c4 = c.a.p0.w2.i.g.c(this.w0.S0(), this.w0.i1(), this.w0.c1());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b16));
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new x2(this));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new y2(this));
            aVar.create(this.e1).show();
        }
    }

    public void n4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(c.a.p0.w2.m.f.a1.Z1)).intValue();
            if (intValue == c.a.p0.w2.m.f.a1.a2) {
                if (this.z0.R()) {
                    return;
                }
                this.D0.H3();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e7f) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e7f)).booleanValue() : false;
                if (jSONArray != null) {
                    this.z0.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.z0.U(this.w0.S0().l().getId(), this.w0.S0().l().getName(), this.w0.S0().O().getId(), str, intValue3, intValue2, booleanValue, this.w0.S0().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == c.a.p0.w2.m.f.a1.b2 || intValue == c.a.p0.w2.m.f.a1.d2) {
                if (this.w0.o0() != null) {
                    this.w0.o0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == c.a.p0.w2.m.f.a1.b2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean n5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                return pbModel.w0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048696, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091eba) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof Integer)) {
            c.a.o0.r.t.j jVar = this.I0;
            if (jVar != null && jVar.isShowing()) {
                this.I0.dismiss();
                this.I0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb8);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eba);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(getContext());
                lVar.n(new a0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e65)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.o0.r.t.h(0, getResources().getString(R.string.obfuscated_res_0x7f0f048e), lVar));
                }
                if (z3) {
                    arrayList.add(new c.a.o0.r.t.h(1, getResources().getString(R.string.obfuscated_res_0x7f0f1460), lVar));
                } else {
                    arrayList.add(new c.a.o0.r.t.h(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b13), lVar));
                }
                lVar.j(arrayList);
                c.a.o0.r.t.j jVar2 = new c.a.o0.r.t.j(getPageContext(), lVar);
                this.I0 = jVar2;
                jVar2.m();
            }
        }
    }

    public void o4(c.a.o0.r.t.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048697, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    n4((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean o5(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public final void o6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            showLoadingView(this.D0.a1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b0));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.D0.Z0().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906c9));
            this.i2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
            this.a.getTiePlusEventController().d(this.s0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048701, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.S0.H(i3, i4, intent);
            c.a.p0.w2.m.f.j1.f.a aVar = this.Q;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (S4().P0() != null) {
                S4().P0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                Z4(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    A5();
                } else if (i3 == 13008) {
                    c.a.p0.w2.m.f.s0.b().m();
                    this.v0.postDelayed(new x1(this), 1000L);
                } else if (i3 == 13011) {
                    c.a.p0.k3.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.w0 == null) {
                        return;
                    }
                    f6(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    c5(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.Y0 = emotionImageData;
                    if (h4(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        T5(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.S;
                    if (view != null) {
                        this.D0.m3(view);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        c.a.p0.k3.a.g().m(getPageContext());
                        C6();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.t) != null) {
                            shareSuccessReplyToServerModel.y(str, intExtra, new y1(this));
                        }
                        if (l5()) {
                            A6(true);
                        }
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
                        case 25055:
                            View view2 = this.T;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view3 = this.U;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            c.a.p0.w2.m.f.a1 a1Var = this.D0;
                            if (a1Var == null || a1Var.p0() == null) {
                                return;
                            }
                            this.D0.p0().performClick();
                            return;
                        case 25058:
                            View view4 = this.V;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.D0.X2(false);
                    if (this.w0.S0() == null || this.w0.S0().O() == null || this.w0.S0().O().getPushStatusData() == null) {
                        return;
                    }
                    this.w0.S0().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048702, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.w = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048704, this, i3) == null) || this.X == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.D0.O1(i3);
        c.a.o0.w.y.e eVar = this.S0;
        if (eVar != null && eVar.a() != null) {
            this.S0.a().w(i3);
        }
        if (this.D0.a() != null) {
            this.D0.a().c(getPageContext(), i3);
        }
        this.H0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.X = i3;
        w6();
    }

    @Override // c.a.o0.r.t.a.e
    public void onClick(c.a.o0.r.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, aVar) == null) {
            o4(aVar, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, configuration) == null) {
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
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var != null) {
                a1Var.P1(configuration);
            }
            c.a.o0.r.t.j jVar = this.I0;
            if (jVar != null) {
                jVar.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        c.a.p0.w2.m.f.a1 a1Var;
        c.a.p0.w2.m.f.a1 a1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            this.p = System.currentTimeMillis();
            this.e1 = getPageContext();
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
                this.G2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.H2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.I2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.N0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.O0 = intent.getStringExtra("high_light_post_id");
                this.P0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (G4()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                this.P = c.a.d.f.p.m.isEmpty(stringExtra) ? "" : this.P;
                this.o1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                c.a.o0.r.r.k1 k1Var = new c.a.o0.r.r.k1();
                this.j0 = k1Var;
                k1Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.q1 = intExtra;
                if (intExtra == 0) {
                    this.q1 = intent.getIntExtra("key_start_from", 0);
                }
                this.r1 = intent.getStringExtra("last_tid");
            } else {
                this.n = System.currentTimeMillis();
            }
            this.r = this.p - this.n;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.l = 0;
            w5(bundle);
            if (this.w0.S0() != null) {
                this.w0.S0().N0(this.P);
            }
            i5();
            if (intent != null && (a1Var2 = this.D0) != null) {
                a1Var2.f19987b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new e0(this, intent);
                    }
                    c.a.d.f.m.e.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.w0.S0() != null) {
                    this.w0.v2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            h5(bundle);
            c.a.o0.w.y.g gVar = new c.a.o0.w.y.g();
            this.R0 = gVar;
            Z5(gVar);
            c.a.o0.w.y.e eVar = (c.a.o0.w.y.e) this.R0.a(getActivity());
            this.S0 = eVar;
            eVar.e0(this.a.getPageContext());
            this.S0.n0(this.f2);
            this.S0.o0(this.Z0);
            this.S0.g0(1);
            this.S0.F(this.a.getPageContext(), bundle);
            this.S0.a().b(new c.a.o0.w.k(getActivity()));
            this.S0.a().C(true);
            c6(true);
            this.S0.O(this.w0.v0(), this.w0.k1(), this.w0.r0());
            registerListener(this.y1);
            if (!this.w0.G0()) {
                this.S0.s(this.w0.k1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.w0.x1()) {
                this.S0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd));
            } else {
                c.a.p0.w2.m.f.a1 a1Var3 = this.D0;
                if (a1Var3 != null) {
                    this.S0.k0(a1Var3.S0());
                }
            }
            registerListener(this.x1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.w1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.k2);
            registerListener(this.v1);
            c.a.p0.a4.k0.f fVar = new c.a.p0.a4.k0.f("pb", c.a.p0.a4.k0.f.f12236d);
            this.Q0 = fVar;
            fVar.d();
            registerListener(this.G1);
            registerListener(this.P1);
            this.w0.T1();
            registerListener(this.j2);
            registerListener(this.Z1);
            registerListener(this.e2);
            registerListener(this.K1);
            c.a.p0.w2.m.f.a1 a1Var4 = this.D0;
            if (a1Var4 != null && a1Var4.Z0() != null && this.D0.X0() != null) {
                c.a.p0.w2.m.f.k1.b bVar = new c.a.p0.w2.m.f.k1.b(getActivity(), this.D0.Z0(), this.D0.X0(), this.D0.N0());
                this.f34893e = bVar;
                bVar.t(this.O1);
            }
            if (this.f34891c && (a1Var = this.D0) != null && a1Var.X0() != null) {
                this.D0.X0().setVisibility(8);
            }
            c.a.o0.r.l0.c cVar = new c.a.o0.r.l0.c();
            this.f1 = cVar;
            cVar.a = 1000L;
            registerListener(this.W1);
            registerListener(this.V1);
            registerListener(this.T1);
            registerListener(this.U1);
            registerListener(this.I1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.E1);
            this.H1.setSelfListener(true);
            this.H1.setTag(this.a.getUniqueId());
            this.H1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.H1);
            registerResponsedEventListener(TipEvent.class, this.Q1);
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
            this.w0.n0().C(this.R1);
            this.H0 = new c.a.p0.w2.m.f.c1();
            if (this.S0.v() != null) {
                this.H0.m(this.S0.v().h());
            }
            this.S0.d0(this.a1);
            this.C0 = new ShareSuccessReplyToServerModel();
            X3(this.t1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.V0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new f0(this));
            c.a.p0.w2.m.g.a aVar = new c.a.p0.w2.m.g.a(getContext());
            this.x0 = aVar;
            aVar.b(getUniqueId());
            c.a.p0.z3.c.g().i(getUniqueId());
            c.a.o0.r.p.a.b().l("3", "");
            this.s1 = new c.a.p0.g0.a(getPageContext());
            this.t0 = new c.a.p0.w2.m.f.m1.a(this, getUniqueId(), this.D0, this.w0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && c.a.d.f.p.l.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.q = System.currentTimeMillis() - this.p;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048708, this, layoutInflater, viewGroup, bundle)) == null) {
            this.D0 = new c.a.p0.w2.m.f.a1(this, this.d2, this.S1);
            c.a.p0.s0.b bVar = new c.a.p0.s0.b(getActivity());
            this.f34892d = bVar;
            bVar.i(L2);
            this.f34892d.d(this.E2);
            this.D0.O2(this.m2);
            this.D0.N2(this.r2);
            this.D0.H2(this.p2);
            this.D0.F2(c.a.o0.r.l.c().g());
            this.D0.L2(this.t2);
            this.D0.R2(this.z2);
            this.D0.P2(this.A2);
            this.D0.M2(this.C2);
            this.D0.K2(this.o2);
            this.D0.L3(this.mIsLogin);
            if (this.a.getIntent() != null) {
                this.D0.D2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.D0.O0().setFromForumId(this.w0.getFromForumId());
            this.D0.v2(this.S0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.S0.k0(this.D0.S0());
            }
            this.D0.z2(new i0(this));
            this.D0.C2(this.w0.B0());
            this.D0.Q2(this.w0.R0());
            this.t0.f(this.D0, this.w0);
            return this.D0.a1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        c.a.p0.w2.m.f.o1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            c.a.p0.z3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.w0.S0().m());
                statisticItem.param("tid", this.w0.k1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.t && this.D0 != null) {
                this.t = true;
                V5(false, null);
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.w0.destory();
                if (this.w0.O0() != null) {
                    this.w0.O0().d();
                }
            }
            c.a.o0.w.y.e eVar = this.S0;
            if (eVar != null) {
                eVar.I();
            }
            ForumManageModel forumManageModel = this.z0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.L();
            }
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var != null) {
                a1Var.Q1();
                c.a.p0.w2.m.f.o1.c cVar2 = this.D0.f19993h;
                if (cVar2 != null) {
                    cVar2.x();
                }
            }
            c.a.o0.r0.b bVar = this.u;
            if (bVar != null) {
                bVar.c();
            }
            c.a.p0.w2.m.f.k1.b bVar2 = this.f34893e;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.p0.w2.m.f.a1 a1Var2 = this.D0;
            if (a1Var2 != null) {
                a1Var2.d0();
            }
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.h2);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            this.e1 = null;
            this.f1 = null;
            c.a.p0.l3.k0.a.e().g();
            if (this.h1 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.h1);
            }
            c.a.p0.w2.m.f.j1.f.a aVar = this.Q;
            if (aVar != null) {
                aVar.f();
            }
            c.a.p0.w2.m.f.a1 a1Var3 = this.D0;
            if (a1Var3 != null && (cVar = a1Var3.f19993h) != null) {
                cVar.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.C0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            c.a.p0.w2.m.f.c1 c1Var = this.H0;
            if (c1Var != null) {
                c1Var.j();
            }
            PbModel pbModel2 = this.w0;
            if (pbModel2 != null && pbModel2.g0() != null) {
                this.w0.g0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.V0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            c.a.p0.w2.m.f.a1 a1Var4 = this.D0;
            if (a1Var4 != null) {
                a1Var4.I3();
            }
            c.a.p0.w2.m.f.m1.a aVar2 = this.t0;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.k0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.d.o.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (c.a.d.o.e.q) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048712, this, context, str) == null) {
            this.w = true;
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048713, this, context, str, z3) == null) {
            if (c.a.p0.w2.m.f.f1.c(str) && (pbModel = this.w0) != null && pbModel.k1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.w0.k1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    c.a.o0.t.p pVar = new c.a.o0.t.p();
                    pVar.a = str;
                    pVar.f11477b = 3;
                    pVar.f11478c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, pVar));
                }
            } else {
                c.a.p0.w2.m.f.f1.a().e(getPageContext(), str);
            }
            this.w = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            Q5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.f34895g = false;
            } else {
                this.f34895g = true;
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
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var != null) {
                a1Var.V1();
            }
            if (!this.w0.G0()) {
                this.S0.U(this.w0.k1());
            }
            PbModel pbModel = this.w0;
            if (pbModel != null) {
                pbModel.S1();
            }
            c.a.o0.a.d.y().G();
            MessageManager.getInstance().unRegisterListener(this.B1);
            U5();
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048716, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.K0 = str;
        if (this.m == null) {
            j5();
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.d.a.i
    public void onPreLoad(c.a.d.o.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            this.f34895g = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                Y4();
            }
            if (m5()) {
                this.v = System.currentTimeMillis();
            } else {
                this.v = -1L;
            }
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var != null && a1Var.a1() != null) {
                if (!this.f34896h) {
                    o6();
                } else {
                    hideLoadingView(this.D0.a1());
                }
                this.D0.W1();
            }
            if (this.l == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            c.a.p0.w2.m.f.a1 a1Var2 = this.D0;
            NoNetworkView a4 = a1Var2 != null ? a1Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && c.a.d.f.p.l.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.B1);
            this.M0 = false;
            W5();
            registerListener(this.T1);
            registerListener(this.U1);
            registerListener(this.W1);
            if (this.m1) {
                Q5();
                this.m1 = false;
            }
            t6();
            ItemCardHelper.v(this.B2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                c.a.o0.v.c.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.w0.j2(bundle);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.S0.K(bundle);
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048720, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            super.onStop();
            if (this.v > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.v;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.v = 0L;
            }
            if (S4().P0() != null) {
                S4().P0().i();
            }
            c.a.p0.w2.m.f.o1.c cVar = this.D0.f19993h;
            if (cVar != null && !cVar.t()) {
                this.D0.f19993h.x();
            }
            PbModel pbModel = this.w0;
            if (pbModel != null && pbModel.S0() != null && this.w0.S0().l() != null && this.w0.S0().O() != null) {
                c.a.o0.u.a.k().y(getPageContext().getPageActivity(), "pb", this.w0.S0().l().getId(), c.a.d.f.m.b.g(this.w0.S0().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            c.a.p0.z3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048723, this, view, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z3) == null) {
            super.onUserChanged(z3);
            this.D0.L3(z3);
            c.a.o0.r.t.j jVar = this.I0;
            if (jVar != null) {
                jVar.dismiss();
            }
            if (z3 && this.M0) {
                this.D0.W2();
                this.w0.K1(true);
            }
            if (this.D0.o0() != null) {
                this.D0.o0().b0(z3);
            }
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048725, this, context, str) == null) {
            c.a.p0.w2.m.f.f1.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.w = true;
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048726, this, context, str) == null) {
        }
    }

    public void p4(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048727, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z3));
            sparseArray.put(c.a.p0.w2.m.f.a1.Z1, Integer.valueOf(c.a.p0.w2.m.f.a1.a2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                n4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean p5(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048728, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.w0.S0().U() != null && (forumToolAuth = this.w0.S0().U().getForumToolAuth()) != null) {
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

    public final void p6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && w() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                w().b0(postWriteCallBackData.getPostId());
                int s02 = this.D0.s0();
                this.n1 = s02;
                this.w0.m2(s02, this.D0.z0());
            }
            this.D0.d0();
            this.H0.c();
            c.a.o0.w.y.e eVar = this.S0;
            if (eVar != null) {
                this.D0.A2(eVar.C());
            }
            this.D0.e1();
            this.D0.h3(true);
            this.w0.t1();
        }
    }

    public void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            TiebaStatic.log("c12181");
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            if (a1Var == null || this.w0 == null) {
                return;
            }
            if ((a1Var != null && !a1Var.v1()) || this.w0.S0() == null || this.w0.S0().S() == null) {
                return;
            }
            c.a.p0.w2.m.f.a1 a1Var2 = this.D0;
            if (a1Var2 == null || a1Var2.u0() == null || !this.D0.u0().o()) {
                c.a.p0.w2.i.s S = this.w0.S0().S();
                if (checkUpIsLogin()) {
                    if ((!S.f() || S.a() != 2) && this.D0.o0() != null && this.D0.o0().z() != null) {
                        this.D0.o0().z().c0(this.w0.k1(), this.w0.getFromForumId());
                    }
                    if (System.currentTimeMillis() - this.x > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.x = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public boolean q5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048731, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public final void q6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048732, this, i3) == null) {
            c.a.p0.w2.m.f.n1.b.o(this, x4(), i3);
        }
    }

    public void r4() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || this.D0 == null || (pbModel = this.w0) == null) {
            return;
        }
        if ((pbModel.S0() == null && this.w0.S0().S() == null) || !checkUpIsLogin() || this.D0.o0() == null || this.D0.o0().z() == null) {
            return;
        }
        this.D0.o0().z().c0(this.w0.k1(), this.w0.getFromForumId());
    }

    public final boolean r5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048734, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public final void r6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            if (str == null) {
                str = "";
            }
            c.a.d.a.f fVar = this.e1;
            if (fVar == null) {
                return;
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new z2(this));
            aVar.create(this.e1).show();
        }
    }

    public final void s4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048736, this, str) == null) || (pbModel = this.w0) == null || pbModel.S0() == null || this.w0.S0().O() == null || !this.w0.S0().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.w0.S0().O();
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

    public final boolean s5(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048737, this, z3)) == null) {
            PbModel pbModel = this.w0;
            return (pbModel == null || pbModel.S0() == null || this.w0.S0().O() == null || this.w0.S0().O().getAuthor() == null || TextUtils.equals(this.w0.S0().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void s6(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048738, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.D0.p3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.e1.getPageActivity());
            if (c.a.d.f.p.m.isEmpty(str)) {
                aVar.setMessage(this.e1.getResources().getString(R.string.obfuscated_res_0x7f0f030f, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new a(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new b(this));
            aVar.create(this.e1).show();
        }
    }

    public final void t4(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048740, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f36156b) ? bVar.f36156b : getString(R.string.obfuscated_res_0x7f0f0493);
            int i3 = 0;
            if (bVar.f36157c == 1211066) {
                hideProgressBar();
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f04d4, new s1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else if (bVar.f36158d != 0) {
                this.D0.l0(0, bVar.a, bVar.f36156b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.f36158d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.w0.S0().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f36161g.equals(F.get(i3).G())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.w0.S0().O().setReply_num(this.w0.S0().O().getReply_num() - 1);
                    this.D0.t1(this.w0.S0());
                } else if (i4 == 0) {
                    j4();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.w0.S0().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).P().size()) {
                                break;
                            } else if (bVar.f36161g.equals(F2.get(i5).P().get(i6).G())) {
                                F2.get(i5).P().remove(i6);
                                F2.get(i5).k();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).m(bVar.f36161g);
                    }
                    if (z4) {
                        this.D0.t1(this.w0.S0());
                    }
                    l4(bVar, this.D0);
                }
            }
        }
    }

    public final void t5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void t6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048742, this) == null) || (pbModel = this.w0) == null || c.a.d.f.p.m.isEmpty(pbModel.k1())) {
            return;
        }
        c.a.o0.a.d.y().R(c.a.o0.a.c.X, c.a.d.f.m.b.g(this.w0.k1(), 0L));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048744, this) == null) || (pbModel = this.w0) == null || c.a.d.f.p.m.isEmpty(pbModel.k1())) {
            return;
        }
        super.taskStart();
    }

    public final void u4(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048745, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.D0.l0(this.z0.getLoadDataMode(), gVar.a, gVar.f36174b, false);
        if (gVar.a) {
            this.E0 = true;
            if (i3 == 2 || i3 == 3) {
                this.F0 = true;
                this.G0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.F0 = false;
                this.G0 = true;
            }
            if (i3 == 2) {
                this.w0.S0().O().setIs_good(1);
                this.w0.q2(1);
            } else if (i3 == 3) {
                this.w0.S0().O().setIs_good(0);
                this.w0.q2(0);
            } else if (i3 == 4) {
                this.w0.S0().O().setIs_top(1);
                this.w0.r2(1);
            } else if (i3 == 5) {
                this.w0.S0().O().setIs_top(0);
                this.w0.r2(0);
            }
            this.D0.O3(this.w0.S0(), this.w0.i1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f36174b)) {
            string = gVar.f36174b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0cd9);
        }
        c.a.d.f.p.n.N(getPageContext().getPageActivity(), string);
    }

    public final void u5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048746, this) == null) || this.J2 == null) {
            return;
        }
        if (this.H2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dab);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.J2.a(), this.H2, 0)));
            this.a.finish();
        }
    }

    public final void u6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048747, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091e69) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69)) != null) {
            v6(postData, false);
        }
    }

    public final void v4(Rect rect) {
        c.a.p0.w2.m.f.a1 a1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048748, this, rect) == null) || rect == null || (a1Var = this.D0) == null || a1Var.Z0() == null || rect.top > this.D0.Z0().getHeight()) {
            return;
        }
        rect.top += this.D0.Z0().getHeight() - rect.top;
    }

    public void v5(String str) {
        c.a.p0.w2.m.f.a1 a1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048749, this, str) == null) || this.w0 == null || StringUtils.isNull(str) || (a1Var = this.D0) == null) {
            return;
        }
        a1Var.E2(true);
        this.w0.M1(str);
        this.I = true;
        this.D0.d0();
        this.D0.c1();
    }

    public final void v6(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048750, this, postData, z3) == null) || postData == null || (pbModel = this.w0) == null || pbModel.S0() == null || postData.A() == 1) {
            return;
        }
        String k12 = this.w0.k1();
        String G = postData.G();
        int V = this.w0.S0() != null ? this.w0.S0().V() : 0;
        AbsPbActivity.e L5 = L5(G);
        if (L5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(k12, G, "pb", true, false, null, false, null, V, postData.S(), this.w0.S0().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(L5.a, L5.f34853b, L5.f34858g, L5.j);
        addBigImageData.setKeyPageStartFrom(this.w0.R0());
        addBigImageData.setFromFrsForumId(this.w0.getFromForumId());
        addBigImageData.setWorksInfoData(this.w0.p1());
        addBigImageData.setKeyFromForumId(this.w0.getForumId());
        addBigImageData.setBjhData(this.w0.l0());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    @Override // c.a.p0.w2.q.c
    public PbModel w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.w0 : (PbModel) invokeV.objValue;
    }

    public AntiData w4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null || pbModel.S0() == null) {
                return null;
            }
            return this.w0.S0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void w5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, bundle) == null) {
            PbModel pbModel = this.a.getPbModel();
            this.w0 = pbModel;
            if (pbModel.o0() != null) {
                this.w0.o0().c(this.F2);
            }
            if (this.w0.O0() != null) {
                this.w0.O0().f(this.u1);
            }
            if (StringUtils.isNull(this.w0.k1())) {
                this.a.finish();
            } else if (!"from_tieba_kuang".equals(this.M) || this.M == null) {
            } else {
                this.w0.u2(6);
            }
        }
    }

    public final void w6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
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

    @Override // c.a.p0.w2.q.c
    public AbsPbActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public final int x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.w0.S0() == null || this.w0.S0().O() == null) {
                return -1;
            }
            return this.w0.S0().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void x5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048757, this) == null) || this.J2 == null) {
            return;
        }
        if (this.G2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dac);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.J2.a(), this.G2, 0)));
            this.a.finish();
        }
    }

    public final void x6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048758, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    @Override // c.a.p0.w2.q.c
    public PbFragment y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public PostData y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            c.a.p0.w2.m.f.a1 a1Var = this.D0;
            PbModel pbModel = this.w0;
            return a1Var.w0(pbModel.G, pbModel.i1());
        }
        return (PostData) invokeV.objValue;
    }

    public final void y5(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048761, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || d4() || !g4()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.Z);
            this.g0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (S4().P0() != null && postData != null) {
            S4().P0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f98), postData.s().getName_show(), postData.N() != null ? postData.N().toString() : ""));
        }
        if (this.w0.S0() != null && this.w0.S0().g0()) {
            c.a.d.f.m.e.a().postDelayed(new a1(this, str, str2), 0L);
            return;
        }
        if (this.X0 == null) {
            c.a.p0.f1.i2.a.c cVar = new c.a.p0.f1.i2.a.c(getPageContext());
            this.X0 = cVar;
            cVar.j(1);
            this.X0.i(new b1(this, str, str2));
        }
        PbModel pbModel = this.w0;
        if (pbModel == null || pbModel.S0() == null || this.w0.S0().l() == null) {
            return;
        }
        this.X0.g(this.w0.S0().l().getId(), c.a.d.f.m.b.g(this.w0.k1(), 0L));
    }

    public final boolean y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            PbModel pbModel = this.w0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.S0() == null || !this.w0.S0().g0()) {
                if (this.w0.E0()) {
                    MarkData p02 = this.w0.p0();
                    if (p02 != null && this.w0.C0()) {
                        MarkData j02 = this.w0.j0(this.D0.v0());
                        if (j02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", p02);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (j02.getPostId() != null && !j02.getPostId().equals(p02.getPostId())) {
                            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025b));
                            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new z1(this, j02, p02, aVar));
                            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new a2(this, p02, aVar));
                            aVar.setOnCalcelListener(new b2(this, p02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", p02);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.w0.S0() != null && this.w0.S0().F() != null && this.w0.S0().F().size() > 0 && this.w0.C0()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public final void z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            c.a.p0.w2.i.f S0 = this.w0.S0();
            this.w0.D2(true);
            c.a.o0.h.a aVar = this.y0;
            if (aVar != null) {
                S0.E0(aVar.g());
            }
            this.D0.t1(S0);
        }
    }

    public final void z6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (absPbActivity = this.a) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.getPbModel().k1()).param("topic_id", this.a.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.getPbModel().o1()));
    }
}
