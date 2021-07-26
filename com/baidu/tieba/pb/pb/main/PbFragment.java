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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
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
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.p0.b0.d;
import d.a.p0.d1.m.f;
import d.a.p0.i.a;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.c1;
import d.a.p0.s.s.a;
import d.a.p0.s.s.b;
import d.a.p0.s.s.l;
import d.a.q0.h2.i.c;
import d.a.q0.h2.k.e.d1.b;
import d.a.q0.h2.k.e.e0;
import d.a.q0.h2.k.e.q;
import d.a.q0.h2.p.e;
import d.a.q0.h3.j0.a;
import d.a.q0.i0.a;
import d.a.q0.i0.b;
import d.a.q0.u0.f2.a.c;
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
/* loaded from: classes4.dex */
public class PbFragment extends BaseFragment implements d.a.p0.d1.m.h, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.t, TbPageContextSupport, d.a.q0.h2.o.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k D2;
    public static final b.InterfaceC1461b E2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public d.a.q0.h2.k.e.t0 A0;
    public View.OnClickListener A1;
    public int A2;
    public long B;
    public boolean B0;
    public CustomMessageListener B1;
    public String B2;
    public int C;
    public boolean C0;
    public CustomMessageListener C1;
    public d.a.p0.s.q.u C2;
    public String D;
    public boolean D0;
    public CustomMessageListener D1;
    public d.a.d.e.k.b<TextView> E;
    public d.a.q0.h2.k.e.v0 E0;
    public SuggestEmotionModel.c E1;
    public d.a.d.e.k.b<TbImageView> F;
    public d.a.p0.s.s.j F0;
    public CustomMessageListener F1;
    public d.a.d.e.k.b<ImageView> G;
    public d.a.p0.s.s.l G0;
    public GetSugMatchWordsModel.b G1;
    public d.a.d.e.k.b<View> H;
    public String H0;
    public boolean H1;
    public d.a.d.e.k.b<LinearLayout> I;
    public boolean I0;
    public PraiseModel I1;
    public d.a.d.e.k.b<RelativeLayout> J;
    public boolean J0;
    public b.h J1;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public boolean L;
    public boolean L0;
    public d.a.p0.h0.i L1;
    public boolean M;
    public boolean M0;
    public CheckRealNameModel.b M1;
    public d.a.d.e.k.b<GifView> N;
    public d.a.q0.h3.h0.f N0;
    public d.a.q0.h2.i.c N1;
    public String O;
    public d.a.p0.x.w.g O0;
    public CustomMessageListener O1;
    public boolean P;
    public d.a.p0.x.w.e P0;
    public CustomMessageListener P1;
    public boolean Q;
    public boolean Q0;
    public CustomMessageListener Q1;
    public String R;
    public PermissionJudgePolicy R0;
    public CustomMessageListener R1;
    public d.a.q0.h2.k.e.c1.f.a S;
    public ReplyPrivacyCheckController S0;
    public CustomMessageListener S1;
    public LikeModel T;
    public d.a.q0.u0.f2.a.c T0;
    public a.e T1;
    public View U;
    public d.a.q0.u0.f2.a.c U0;
    public l.e U1;
    public View V;
    public EmotionImageData V0;
    public SortSwitchButton.f V1;
    public View W;
    public d.a.p0.x.w.c W0;
    public final View.OnClickListener W1;
    public View X;
    public d.a.p0.x.w.b X0;
    public CustomMessageListener X1;
    public String Y;
    public d.a.p0.x.w.b Y0;
    public final NewWriteModel.g Y1;
    public int Z;
    public int Z0;
    public NewWriteModel.g Z1;
    public boolean a0;
    public Object a1;
    public d.a.d.c.g.a a2;
    public int[] b0;
    public d.a.d.a.f b1;
    public final PbModel.g b2;
    public int c0;
    public d.a.p0.s.f0.c c1;
    public CustomMessageListener c2;
    public BdUniqueId d1;
    public HttpMessageListener d2;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f19309e;
    public Runnable e1;
    public final a.InterfaceC1202a e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19310f;
    public d.a.q0.h2.k.e.x0 f1;
    public final AbsListView.OnScrollListener f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19311g;
    public d.a.d.k.d.a g1;
    public final d.a.d.a.e g2;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.i0.b f19312h;
    public String h1;
    public final u2 h2;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.h2.k.e.d1.b f19313i;
    public int i0;
    public TbRichTextMemeInfo i1;
    public final f.g i2;
    public boolean j;
    public int j0;
    public boolean j1;
    public boolean j2;
    public boolean k;
    public d.a.p0.s.q.l1 k0;
    public int k1;
    public final BdListView.p k2;
    public boolean l;
    public BdUniqueId l0;
    public int l1;
    public int l2;
    public boolean m;
    public d.a.p0.s.b0.a m0;
    public List<s2> m1;
    public final TbRichTextView.z m2;
    public boolean n;
    public boolean n0;
    public int n1;
    public boolean n2;
    public VoiceManager o;
    public d.a.q0.h3.h0.e o0;
    public String o1;
    public PostData o2;
    public int p;
    public boolean p0;
    public d.a.q0.z.a p1;
    public final b.c p2;
    public d.a.p0.s.s.b q;
    public d.a.q0.h2.k.e.f1.a q0;
    public final s2 q1;
    public final b.c q2;
    public long r;
    public PbInterviewStatusView.f r0;
    public final e0.b r1;
    public final AdapterView.OnItemClickListener r2;
    public long s;
    public final Handler s0;
    public final CustomMessageListener s1;
    public final View.OnLongClickListener s2;
    public long t;
    public PbModel t0;
    public CustomMessageListener t1;
    public final View.OnClickListener t2;
    public long u;
    public d.a.q0.h2.k.f.a u0;
    public CustomMessageListener u1;
    public final ItemCardHelper.b u2;
    public long v;
    public d.a.p0.i.a v0;
    public CustomMessageListener v1;
    public final NoNetworkView.b v2;
    public boolean w;
    public ForumManageModel w0;
    public CustomMessageListener w1;
    public View.OnTouchListener w2;
    public boolean x;
    public d.a.p0.t.e.a x0;
    public CustomMessageListener x1;
    public a.b x2;
    public d.a.p0.o0.b y;
    public d.a.q0.h2.h.t y0;
    public CustomMessageListener y1;
    public final q.b y2;
    public long z;
    public ShareSuccessReplyToServerModel z0;
    public final CustomMessageListener z1;
    public int z2;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19314a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19314a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.f19314a.t0.o2((UserPendantData) customResponsedMessage.getData());
                if (this.f19314a.A0 != null && this.f19314a.t0 != null) {
                    this.f19314a.A0.d2(this.f19314a.t0.L0(), this.f19314a.t0.Z0(), this.f19314a.t0.V0(), this.f19314a.A0.R0());
                }
                if (this.f19314a.A0 == null || this.f19314a.A0.l0() == null) {
                    return;
                }
                this.f19314a.A0.l0().V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19315a;

        public a0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19315a = pbFragment;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f19315a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            if (this.f19315a.Q5(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f19315a.r6((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                            if (this.f19315a.A0.u1() && view.getId() == R.id.pb_head_user_info_root) {
                                if (view.getTag(R.id.tag_user_id) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                                }
                                if (this.f19315a.getEventController() != null && this.f19315a.getEventController().f57757b != null) {
                                    this.f19315a.getEventController().f57757b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f19315a.r6(sparseArray);
                        }
                    }
                    if (this.f19315a.P0 != null) {
                        this.f19315a.A0.r2(this.f19315a.P0.D());
                    }
                    this.f19315a.A0.j2();
                    this.f19315a.A0.a0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f19315a.isAdded()) {
                    this.f19315a.r4();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19316e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19317f;

        public a1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19317f = pbFragment;
            this.f19316e = metaData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19316e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19318e;

        public a2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19318e = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.f19318e;
                pbFragment.f19310f = true;
                return pbFragment.l4(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19319a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19319a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.f19319a.A0 == null) {
                return;
            }
            if (booleanValue) {
                this.f19319a.A0.q3();
            } else {
                this.f19319a.A0.d1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19320a;

        public b0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19320a = pbFragment;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f19320a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.f19320a;
                    pbFragment.H0 = pbFragment.H0.trim();
                    UtilHelper.callPhone(this.f19320a.getPageContext().getPageActivity(), this.f19320a.H0);
                    new d.a.q0.h2.k.e.d(this.f19320a.t0.b1(), this.f19320a.H0, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f19320a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    PbFragment pbFragment2 = this.f19320a;
                    pbFragment2.H0 = pbFragment2.H0.trim();
                    UtilHelper.smsPhone(this.f19320a.getPageContext().getPageActivity(), this.f19320a.H0);
                    new d.a.q0.h2.k.e.d(this.f19320a.t0.b1(), this.f19320a.H0, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    PbFragment pbFragment3 = this.f19320a;
                    pbFragment3.H0 = pbFragment3.H0.trim();
                    UtilHelper.startBaiDuBar(this.f19320a.getPageContext().getPageActivity(), this.f19320a.H0);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19322f;

        public b1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19322f = pbFragment;
            this.f19321e = metaData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19321e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f19322f.x0.m(!this.f19321e.hadConcerned(), this.f19321e.getPortrait(), this.f19321e.getUserId(), this.f19321e.isGod(), "6", this.f19322f.getPageContext().getUniqueId(), this.f19322f.t0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19323e;

        public b2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19323e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.j(this.f19323e.getContext(), this.f19323e.getUniqueId(), view, (ViewGroup) this.f19323e.getView());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19324a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19324a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f19324a.P0 != null) {
                this.f19324a.A0.r2(this.f19324a.P0.D());
            }
            this.f19324a.A0.Z2(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19325a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19325a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f19325a.d1) {
                this.f19325a.A0.b1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.q0.h2.h.e L0 = this.f19325a.t0.L0();
                if (L0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    L0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f19325a.c1.c(this.f19325a.b1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f19325a.b1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f19325a.o6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f19325a.j6();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.d.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f19325a.b1.getResources().getString(R.string.mute_fail);
                    }
                    this.f19325a.c1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements d.a.p0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19326a;

        public c1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19326a = pbFragment;
        }

        @Override // d.a.p0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.q0.h2.k.e.v0 v0Var = this.f19326a.E0;
                if (v0Var == null || v0Var.e() == null || !this.f19326a.E0.e().d()) {
                    return !this.f19326a.i4(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.f19326a;
                pbFragment.showToast(pbFragment.E0.e().c());
                if (this.f19326a.P0 != null && (this.f19326a.P0.C() || this.f19326a.P0.E())) {
                    this.f19326a.P0.A(false, this.f19326a.E0.h());
                }
                this.f19326a.E0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c2 implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19327a;

        public c2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19327a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.u(this.f19327a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f19327a.getView());
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.u(this.f19327a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f19327a.getView());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19328a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19328a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.q0.h2.e eVar = (d.a.q0.h2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f19328a.N5((d.a.q0.h2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f19328a.u4((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f19328a.M5(false, null);
                } else {
                    this.f19328a.M5(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19329a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f19329a.d1) {
                this.f19329a.A0.b1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f19329a.c1.c(this.f19329a.b1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.d.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f19329a.b1.getResources().getString(R.string.un_mute_fail);
                }
                this.f19329a.c1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19330e;

        public d1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19330e = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> E;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f19330e.t0 == null || this.f19330e.t0.L0() == null || this.f19330e.A0 == null || this.f19330e.A0.l0() == null) {
                return;
            }
            this.f19330e.A0.P1(absListView, i2, i3, i4);
            if (this.f19330e.f19313i != null) {
                this.f19330e.f19313i.q(absListView, i2, i3, i4);
            }
            if (!this.f19330e.t0.m1() || (E = this.f19330e.t0.L0().E()) == null || E.isEmpty()) {
                return;
            }
            int w = ((i2 + i3) - this.f19330e.A0.l0().w()) - 1;
            d.a.q0.h2.h.e L0 = this.f19330e.t0.L0();
            if (L0 == null) {
                return;
            }
            if (L0.C() != null && L0.C().C0()) {
                w--;
            }
            if (L0.D() != null && L0.D().C0()) {
                w--;
            }
            int size = E.size();
            if (w < 0 || w >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                PbFragment pbFragment = this.f19330e;
                if (!pbFragment.r5(pbFragment.Z0) && this.f19330e.r5(i2)) {
                    if (this.f19330e.A0 != null) {
                        this.f19330e.A0.a0();
                        if (this.f19330e.P0 != null && !this.f19330e.A0.p1()) {
                            this.f19330e.A0.r2(this.f19330e.P0.D());
                        }
                        if (!this.f19330e.L) {
                            this.f19330e.A0.j2();
                        }
                    }
                    if (!this.f19330e.x) {
                        this.f19330e.x = true;
                    }
                }
                if (this.f19330e.A0 != null) {
                    this.f19330e.A0.Q1(absListView, i2);
                }
                if (this.f19330e.f19313i != null) {
                    this.f19330e.f19313i.r(absListView, i2);
                }
                if (this.f19330e.y == null) {
                    this.f19330e.y = new d.a.p0.o0.b();
                    this.f19330e.y.a(1001);
                }
                if (i2 == 0) {
                    this.f19330e.y.e();
                } else {
                    this.f19330e.y.d();
                }
                this.f19330e.Z0 = i2;
                if (i2 == 0) {
                    this.f19330e.T5(false, null);
                    d.a.q0.g3.c.g().h(this.f19330e.getUniqueId(), true);
                    this.f19330e.d4(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19331e;

        public d2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19331e = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f19331e.k && z && !this.f19331e.t0.B0()) {
                    this.f19331e.O5();
                }
                PbFragment pbFragment = this.f19331e;
                pbFragment.setNetRefreshViewEmotionMarginTop(d.a.d.e.p.l.g(pbFragment.getContext(), R.dimen.ds360));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19332a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19332a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19332a.A0 == null || this.f19332a.A0.l0() == null) {
                return;
            }
            this.f19332a.A0.l0().V();
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19333a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19333a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f19333a.d1) {
                d.a.q0.s3.a aVar = (d.a.q0.s3.a) customResponsedMessage.getData();
                this.f19333a.A0.b1();
                SparseArray<Object> sparseArray = (SparseArray) this.f19333a.a1;
                DataRes dataRes = aVar.f62859a;
                if (aVar.f62861c == 0 && dataRes != null) {
                    int d2 = d.a.d.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (d.a.d.e.p.k.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    this.f19333a.k6(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f19333a.A0.V1(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements Comparator<d.a.p0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19334e;

        public e1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19334e = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.p0.u.a aVar, d.a.p0.u.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e2 implements d.a.d.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19335a;

        public e2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19335a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
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
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19335a.getPageContext().getPageActivity());
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

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19336a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19336a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                d.a.p0.d1.m.f.c(this.f19336a.getPageContext(), this.f19336a, aVar.f52414a, aVar.f52415b, aVar.f52416c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19337a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19337a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f19337a.A0.p1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.f19337a.r4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19338a;

        public f1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19338a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f2 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19339e;

        public f2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19339e = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.f19339e.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    View childAt = frameLayout.getChildAt(i2);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.f19339e.f19312h.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19340a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19340a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19340a.k) {
                return;
            }
            this.f19340a.q6();
        }
    }

    /* loaded from: classes4.dex */
    public static class g0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g1 extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19341a;

        public g1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19341a = pbFragment;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f19341a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.f19341a.w0.getLoadDataMode()) {
                        case 0:
                            this.f19341a.t0.i1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f19341a.u4(bVar, (bVar.f21301e != 1002 || bVar.f21302f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f19341a.A0.i0(1, dVar.f21304a, dVar.f21305b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.f19341a;
                            pbFragment.v4(pbFragment.w0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.f19341a.A0.i0(this.f19341a.w0.getLoadDataMode(), gVar.f21318a, gVar.f21319b, false);
                            this.f19341a.A0.R1(gVar.f21320c);
                            return;
                        default:
                            return;
                    }
                }
                this.f19341a.A0.i0(this.f19341a.w0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f19342a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19343b;

        public g2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19343b = pbFragment;
            this.f19342a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);
        }

        @Override // d.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || !e(i3) || this.f19343b.A0 == null || this.f19343b.f19313i == null) {
                return;
            }
            this.f19343b.f19313i.u(true);
            if (Math.abs(i3) > this.f19342a) {
                this.f19343b.f19313i.l();
            }
            if (this.f19343b.J4()) {
                this.f19343b.A0.c1();
                this.f19343b.A0.l2();
            }
        }

        @Override // d.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || !e(i3) || this.f19343b.A0 == null || this.f19343b.f19313i == null) {
                return;
            }
            this.f19343b.A0.o3();
            this.f19343b.f19313i.u(false);
            this.f19343b.f19313i.x();
        }

        @Override // d.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }

        public final boolean e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) ? Math.abs(f2) >= 1.0f : invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19344e;

        public h(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19344e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.f19344e;
                pbFragment.showToast(pbFragment.D);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19345a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19345a = pbFragment;
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
            this.f19345a.j1 = true;
        }
    }

    /* loaded from: classes4.dex */
    public class h1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19346e;

        public h1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19346e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class h2 implements b.InterfaceC1461b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h2() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.q0.i0.b.InterfaceC1461b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d.a.q0.h2.i.b.d();
                } else {
                    d.a.q0.h2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19347a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19347a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.s.q.j0)) {
                d.a.p0.s.q.j0 j0Var = (d.a.p0.s.q.j0) customResponsedMessage.getData();
                c1.a aVar = new c1.a();
                int i2 = j0Var.f53360a;
                String str = j0Var.f53361b;
                aVar.f53273a = j0Var.f53363d;
                d.a.q0.h2.h.e L0 = this.f19347a.t0.L0();
                if (L0 == null) {
                    return;
                }
                if (this.f19347a.t0.p0() != null && this.f19347a.t0.p0().getUserIdLong() == j0Var.p) {
                    this.f19347a.A0.c2(j0Var.l, this.f19347a.t0.L0(), this.f19347a.t0.Z0(), this.f19347a.t0.V0());
                }
                if (L0.E() == null || L0.E().size() < 1 || L0.E().get(0) == null) {
                    return;
                }
                long f2 = d.a.d.e.m.b.f(L0.E().get(0).E(), 0L);
                long f3 = d.a.d.e.m.b.f(this.f19347a.t0.b1(), 0L);
                if (f2 == j0Var.n && f3 == j0Var.m) {
                    d.a.p0.s.q.c1 D = L0.E().get(0).D();
                    if (D == null) {
                        D = new d.a.p0.s.q.c1();
                    }
                    ArrayList<c1.a> a2 = D.a();
                    if (a2 == null) {
                        a2 = new ArrayList<>();
                    }
                    a2.add(0, aVar);
                    D.e(D.b() + j0Var.l);
                    D.d(a2);
                    L0.E().get(0).k0(D);
                    this.f19347a.A0.l0().V();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19348e;

        public i0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19348e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19348e.g5();
                d.a.p0.s.q.a1 J0 = this.f19348e.t0.J0();
                int H0 = this.f19348e.A0.H0();
                if (H0 <= 0) {
                    this.f19348e.showToast(R.string.pb_page_error);
                } else if (J0 == null || H0 <= J0.h()) {
                    this.f19348e.A0.a0();
                    this.f19348e.t6();
                    this.f19348e.A0.N2();
                    if (d.a.d.e.p.j.z()) {
                        this.f19348e.t0.g2(this.f19348e.A0.H0());
                        if (this.f19348e.f19313i != null) {
                            this.f19348e.f19313i.x();
                        }
                    } else {
                        this.f19348e.showToast(R.string.neterror);
                    }
                    aVar.dismiss();
                } else {
                    this.f19348e.showToast(R.string.pb_page_error);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i1 implements u2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19349a;

        public i1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19349a = pbFragment;
        }
    }

    /* loaded from: classes4.dex */
    public class i2 implements q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19350a;

        public i2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19350a = pbFragment;
        }

        @Override // d.a.q0.h2.k.e.q.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i2 == 0) {
                        this.f19350a.showToast(R.string.upgrage_toast_dialog);
                    } else {
                        this.f19350a.showToast(R.string.neterror);
                    }
                } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                    this.f19350a.A0.Y(str);
                } else {
                    this.f19350a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19351a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19351a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19351a.t0 == null || this.f19351a.t0.L0() == null) {
                return;
            }
            this.f19351a.t0.L0().a();
            this.f19351a.t0.i1();
            if (this.f19351a.A0.l0() != null) {
                this.f19351a.A0.n1(this.f19351a.t0.L0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19352e;

        public j0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19352e = pbFragment;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f19352e.F0 != null) {
                    this.f19352e.F0.dismiss();
                }
                this.f19352e.w6(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f19352e.K5(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f19352e.K5(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f19352e.K5(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            this.f19352e.K5(view5);
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
                        if (this.f19352e.g1 == null || TextUtils.isEmpty(this.f19352e.h1)) {
                            return;
                        }
                        if (this.f19352e.i1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f19352e.h1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f52031a = this.f19352e.h1;
                            String str = "";
                            if (this.f19352e.i1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f19352e.i1.memeInfo.pck_id;
                            }
                            aVar.f52032b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f19352e.g1 = null;
                        this.f19352e.h1 = null;
                        return;
                    case 2:
                        if (this.f19352e.g1 == null || TextUtils.isEmpty(this.f19352e.h1)) {
                            return;
                        }
                        if (this.f19352e.R0 == null) {
                            this.f19352e.R0 = new PermissionJudgePolicy();
                        }
                        this.f19352e.R0.clearRequestPermissionList();
                        this.f19352e.R0.appendRequestPermission(this.f19352e.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f19352e.R0.startRequestPermission(this.f19352e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f19352e.f1 == null) {
                            PbFragment pbFragment = this.f19352e;
                            pbFragment.f1 = new d.a.q0.h2.k.e.x0(pbFragment.getPageContext());
                        }
                        this.f19352e.f1.b(this.f19352e.h1, this.f19352e.g1.n());
                        this.f19352e.g1 = null;
                        this.f19352e.h1 = null;
                        return;
                    case 3:
                        PbFragment pbFragment2 = this.f19352e;
                        PostData postData = pbFragment2.o2;
                        if (postData != null) {
                            postData.h0(pbFragment2.getPageContext().getPageActivity());
                            this.f19352e.o2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f19352e.checkUpIsLogin()) {
                            this.f19352e.B5(view);
                            if (this.f19352e.t0.L0().N() == null || this.f19352e.t0.L0().N().H() == null || this.f19352e.t0.L0().N().H().getUserId() == null || this.f19352e.v0 == null) {
                                return;
                            }
                            PbFragment pbFragment3 = this.f19352e;
                            int Y4 = pbFragment3.Y4(pbFragment3.t0.L0());
                            d.a.p0.s.q.b2 N = this.f19352e.t0.L0().N();
                            if (N.F1()) {
                                i3 = 2;
                            } else if (N.I1()) {
                                i3 = 3;
                            } else if (!N.G1()) {
                                i3 = N.H1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19352e.t0.f19512f).param("obj_locate", 2).param("obj_id", this.f19352e.t0.L0().N().H().getUserId()).param("obj_type", !this.f19352e.v0.e()).param("obj_source", Y4).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!d.a.d.e.p.j.z()) {
                            this.f19352e.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f19352e.e5((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f19352e.g4(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(R.id.tag_has_sub_post) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                            boolean isHost = this.f19352e.z().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f19352e.e6(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f19352e.A0.U1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f19352e.e6(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f19352e.A0.S1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!d.a.d.e.p.j.z()) {
                            this.f19352e.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f19352e.A0.S1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f19352e.g4(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f19352e.A0.W1(view);
                            return;
                        }
                    case 8:
                        if (this.f19352e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f19352e.j4(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f19352e.checkUpIsLogin() || this.f19352e.t0 == null || this.f19352e.t0.L0() == null) {
                            return;
                        }
                        this.f19352e.f19309e.showBlockDialog(d.a.q0.r3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j1 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19353e;

        public j1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19353e = pbFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19353e.J4()) {
                    this.f19353e.f19309e.finish();
                }
                if (!this.f19353e.t0.y1(true)) {
                    this.f19353e.A0.h0();
                } else {
                    TiebaStatic.eventStat(this.f19353e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j2 implements e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19354a;

        public j2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19354a = pbFragment;
        }

        @Override // d.a.q0.h2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f19354a.A0.v3(str);
        }

        @Override // d.a.q0.h2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19355a;

        public k(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19355a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f19355a.A0.s3(!this.f19355a.P);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19358g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19359h;

        public k0(PbFragment pbFragment, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19359h = pbFragment;
            this.f19356e = sparseArray;
            this.f19357f = i2;
            this.f19358g = z;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f19359h.q4(((Integer) this.f19356e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19356e.get(R.id.tag_del_post_id), this.f19357f, this.f19358g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19360e;

        public k1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19360e = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19360e.j2 && this.f19360e.J4()) {
                    this.f19360e.u5();
                }
                if (this.f19360e.mIsLogin) {
                    if (!this.f19360e.n0 && this.f19360e.A0 != null && this.f19360e.A0.S() && this.f19360e.t0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.f19360e.t0.b1());
                        statisticItem.param("fid", this.f19360e.t0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i2 = 5;
                        if (this.f19360e.t0.r0()) {
                            i2 = 4;
                        } else if (this.f19360e.t0.s0()) {
                            i2 = 3;
                        } else if (this.f19360e.t0.u0()) {
                            i2 = 1;
                        }
                        statisticItem.param("obj_type", i2);
                        TiebaStatic.log(statisticItem);
                        this.f19360e.n0 = true;
                    }
                    if (this.f19360e.t0.u1(false)) {
                        this.f19360e.A0.O2();
                        TiebaStatic.eventStat(this.f19360e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if (this.f19360e.q0 == null || !this.f19360e.q0.d()) {
                        if (this.f19360e.t0.L0() != null) {
                            this.f19360e.A0.f2();
                        }
                    } else {
                        this.f19360e.A0.O2();
                    }
                    this.f19360e.j2 = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19361e;

        public k2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19361e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f19361e.b1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f19361e.b1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19362a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19362a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19362a.t0 == null || this.f19362a.t0.L0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f19362a.n4(str);
            this.f19362a.t0.i1();
            if (!TextUtils.isEmpty(str) && this.f19362a.t0.L0().E() != null) {
                ArrayList<PostData> E = this.f19362a.t0.L0().E();
                d.a.q0.h3.h0.o oVar = null;
                Iterator<PostData> it = E.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof d.a.q0.h3.h0.o) {
                        d.a.q0.h3.h0.o oVar2 = (d.a.q0.h3.h0.o) next;
                        if (str.equals(oVar2.D0())) {
                            oVar = oVar2;
                            break;
                        }
                    }
                }
                if (oVar != null) {
                    E.remove(oVar);
                    if (this.f19362a.A0.l0() != null && this.f19362a.A0.l0().s() != null) {
                        this.f19362a.A0.l0().s().remove(oVar);
                    }
                    if (this.f19362a.A0.B0() != null && this.f19362a.A0.B0().getData() != null) {
                        this.f19362a.A0.B0().getData().remove(oVar);
                    }
                    if (this.f19362a.A0.l0() != null) {
                        this.f19362a.A0.l0().V();
                        return;
                    }
                }
            }
            if (this.f19362a.A0.l0() != null) {
                this.f19362a.A0.n1(this.f19362a.t0.L0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19363e;

        public l0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19363e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19364e;

        public l1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19364e = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19364e.t0 == null) {
                return;
            }
            this.f19364e.t0.LoadData();
        }
    }

    /* loaded from: classes4.dex */
    public class l2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19365e;

        public l2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19365e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19366a;

        public m(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19366a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(d.a.q0.h2.k.e.c1.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.c()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19367a;

        public m0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19367a = pbFragment;
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f19367a.P0 != null && this.f19367a.P0.a() != null) {
                    this.f19367a.P0.a().A(new d.a.p0.x.a(45, 27, null));
                }
                this.f19367a.A0.T();
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19368a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f19369e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m1 f19370f;

            public a(m1 m1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19370f = m1Var;
                this.f19369e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h2.j.c.a(this.f19370f.f19368a.getPageContext(), this.f19369e).show();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19368a = pbFragment;
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
                d.a.d.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19371e;

        public m2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19371e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19372a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19372a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue() || this.f19372a.A0 == null || this.f19372a.t0 == null) {
                return;
            }
            this.f19372a.A0.U(false);
            if (this.f19372a.t0.u1(false)) {
                this.f19372a.A0.O2();
            } else if (this.f19372a.t0.L0() != null) {
                this.f19372a.A0.f2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19373a;

        public n0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19373a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f19373a.A0.a0();
                boolean z = false;
                if (d.a.d.e.p.j.z()) {
                    if (this.f19373a.t0 != null && !this.f19373a.t0.isLoading) {
                        this.f19373a.t6();
                        this.f19373a.A0.N2();
                        z = true;
                        if (this.f19373a.t0.L0() != null && this.f19373a.t0.L0().f57442f != null && this.f19373a.t0.L0().f57442f.size() > i2) {
                            int intValue = this.f19373a.t0.L0().f57442f.get(i2).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f19373a.t0.c1()).param("fid", this.f19373a.t0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.f19373a.t0.m2(intValue)) {
                                this.f19373a.m = true;
                                this.f19373a.A0.B2(true);
                            }
                        }
                    }
                    return z;
                }
                this.f19373a.showToast(R.string.network_not_available);
                return false;
            }
            return invokeI.booleanValue;
        }

        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 == 2) {
                    return 1;
                }
                if (i2 == 0) {
                    return 2;
                }
                return i2 == 1 ? 3 : 0;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements d.a.p0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19374a;

        public n1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19374a = pbFragment;
        }

        @Override // d.a.p0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.q0.h2.k.e.v0 v0Var = this.f19374a.E0;
                if (v0Var == null || v0Var.g() == null || !this.f19374a.E0.g().d()) {
                    return !this.f19374a.i4(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.f19374a;
                pbFragment.showToast(pbFragment.E0.g().c());
                if (this.f19374a.A0 != null && this.f19374a.A0.K0() != null && this.f19374a.A0.K0().b() != null && this.f19374a.A0.K0().b().x()) {
                    this.f19374a.A0.K0().b().v(this.f19374a.E0.h());
                }
                this.f19374a.E0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class n2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f19375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19376f;

        public n2(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19376f = pbFragment;
            this.f19375e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19376f.A0.g3();
                MessageManager.getInstance().sendMessage(this.f19375e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19377a;

        public o(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19377a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                BdLog.e(str);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f19377a.A0 == null) {
                return;
            }
            this.f19377a.A0.U2(list);
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19379f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19380g;

        /* loaded from: classes4.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o0 f19381e;

            public a(o0 o0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19381e = o0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.q0.h2.k.e.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19381e.f19380g.E0) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f19381e.f19380g.E0.g().e()) {
                    this.f19381e.f19380g.E0.b(false);
                }
                this.f19381e.f19380g.E0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                }
            }
        }

        public o0(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19380g = pbFragment;
            this.f19378e = str;
            this.f19379f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = d.a.d.e.p.l.i(this.f19380g.f19309e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.d.e.p.l.g(this.f19380g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.d.e.p.l.g(this.f19380g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                PbFragment pbFragment = this.f19380g;
                boolean z = true;
                pbFragment.V4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
                if (this.f19380g.V4().K0() != null) {
                    this.f19380g.P0.a().setVisibility(8);
                    this.f19380g.V4().K0().n(this.f19378e, this.f19379f, this.f19380g.V4().N0(), (this.f19380g.t0 == null || this.f19380g.t0.L0() == null || this.f19380g.t0.L0().N() == null || !this.f19380g.t0.L0().N().J1()) ? false : false);
                    d.a.p0.x.w.h b2 = this.f19380g.V4().K0().b();
                    if (b2 != null && this.f19380g.t0 != null && this.f19380g.t0.L0() != null) {
                        b2.G(this.f19380g.t0.L0().d());
                        b2.a0(this.f19380g.t0.L0().N());
                    }
                    if (this.f19380g.E0.f() == null && this.f19380g.V4().K0().b().u() != null) {
                        this.f19380g.V4().K0().b().u().g(new a(this));
                        PbFragment pbFragment2 = this.f19380g;
                        pbFragment2.E0.n(pbFragment2.V4().K0().b().u().i());
                        this.f19380g.V4().K0().b().M(this.f19380g.Y0);
                    }
                }
                this.f19380g.V4().X0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19383f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f19384g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19385h;

        public o1(PbFragment pbFragment, MarkData markData, MarkData markData2, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19385h = pbFragment;
            this.f19382e = markData;
            this.f19383f = markData2;
            this.f19384g = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f19385h.v0 != null) {
                    if (this.f19385h.v0.e()) {
                        this.f19385h.v0.d();
                        this.f19385h.v0.h(false);
                    }
                    this.f19385h.v0.i(this.f19382e);
                    this.f19385h.v0.h(true);
                    this.f19385h.v0.a();
                }
                this.f19383f.setPostId(this.f19382e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19383f);
                this.f19385h.f19309e.setResult(-1, intent);
                this.f19384g.dismiss();
                this.f19385h.u6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19386e;

        public o2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19386e = pbFragment;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19387a;

        public p(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19387a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f19387a.H1 = false;
                if (this.f19387a.I1 == null) {
                    return;
                }
                d.a.q0.h2.h.e L0 = this.f19387a.t0.L0();
                if (L0.N().H0().getIsLike() == 1) {
                    this.f19387a.z6(0);
                } else {
                    this.f19387a.z6(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, L0.N()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f19387a.H1 = false;
                if (this.f19387a.I1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i2, str)) {
                    AntiHelper.u(this.f19387a.getPageContext().getPageActivity(), str);
                } else {
                    this.f19387a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19389b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19390c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p0 f19391e;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$p0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0231a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f19392e;

                public C0231a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f19392e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.q0.h2.k.e.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19392e.f19391e.f19390c.E0) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f19392e.f19391e.f19390c.E0.g().e()) {
                        this.f19392e.f19391e.f19390c.E0.b(false);
                    }
                    this.f19392e.f19391e.f19390c.E0.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            }

            public a(p0 p0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19391e = p0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = d.a.d.e.p.l.i(this.f19391e.f19390c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i2 = i3 / 2;
                        g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i4 = i3 - (i2 + g2);
                    PbFragment pbFragment = this.f19391e.f19390c;
                    boolean z = true;
                    pbFragment.V4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
                    if (this.f19391e.f19390c.V4().K0() != null) {
                        this.f19391e.f19390c.P0.a().setVisibility(8);
                        z = (this.f19391e.f19390c.t0 == null || this.f19391e.f19390c.t0.L0() == null || this.f19391e.f19390c.t0.L0().N() == null || !this.f19391e.f19390c.t0.L0().N().J1()) ? false : false;
                        d.a.q0.h2.k.e.u K0 = this.f19391e.f19390c.V4().K0();
                        p0 p0Var = this.f19391e;
                        K0.n(p0Var.f19388a, p0Var.f19389b, p0Var.f19390c.V4().N0(), z);
                        d.a.p0.x.w.h b2 = this.f19391e.f19390c.V4().K0().b();
                        if (b2 != null && this.f19391e.f19390c.t0 != null && this.f19391e.f19390c.t0.L0() != null) {
                            b2.G(this.f19391e.f19390c.t0.L0().d());
                            b2.a0(this.f19391e.f19390c.t0.L0().N());
                        }
                        if (this.f19391e.f19390c.E0.f() == null && this.f19391e.f19390c.V4().K0().b().u() != null) {
                            this.f19391e.f19390c.V4().K0().b().u().g(new C0231a(this));
                            PbFragment pbFragment2 = this.f19391e.f19390c;
                            pbFragment2.E0.n(pbFragment2.V4().K0().b().u().i());
                            this.f19391e.f19390c.V4().K0().b().M(this.f19391e.f19390c.Y0);
                        }
                    }
                    this.f19391e.f19390c.V4().X0();
                }
            }
        }

        public p0(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19390c = pbFragment;
            this.f19388a = str;
            this.f19389b = str2;
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                d.a.d.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f19394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19395g;

        public p1(PbFragment pbFragment, MarkData markData, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19395g = pbFragment;
            this.f19393e = markData;
            this.f19394f = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19393e);
                this.f19395g.f19309e.setResult(-1, intent);
                this.f19394f.dismiss();
                this.f19395g.u6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p2 extends d.a.p0.b1.f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19396a;

        public p2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19396a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return d.a.q0.h2.k.e.g1.b.c(this.f19396a.getContext(), this.f19396a.y4(), ShareSwitch.isOn() ? 1 : 6, this.f19396a.t0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19397a;

        public q(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19397a = pbFragment;
        }

        @Override // d.a.q0.h2.k.e.d1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f19397a.W5(z);
                if (this.f19397a.A0.y0() != null && z) {
                    this.f19397a.A0.s3(false);
                }
                this.f19397a.A0.M1(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19398e;

        /* loaded from: classes4.dex */
        public class a implements l.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.p0.s.s.j f19399e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f19400f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ q0 f19401g;

            public a(q0 q0Var, d.a.p0.s.s.j jVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q0Var, jVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19401g = q0Var;
                this.f19399e = jVar;
                this.f19400f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f19401g.f19398e.t0.Y0() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // d.a.p0.s.s.l.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
                boolean m2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, lVar, i2, view) != null) {
                    return;
                }
                this.f19399e.dismiss();
                int i3 = 3;
                if (this.f19401g.f19398e.t0.Y0() != 1 || i2 != 1) {
                    if (this.f19401g.f19398e.t0.Y0() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (this.f19401g.f19398e.t0.Y0() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19400f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (this.f19401g.f19398e.t0.L0().f57442f != null && this.f19401g.f19398e.t0.L0().f57442f.size() > i2) {
                        i2 = this.f19401g.f19398e.t0.L0().f57442f.get(i2).sort_type.intValue();
                    }
                    m2 = this.f19401g.f19398e.t0.m2(i2);
                    this.f19400f.setTag(Integer.valueOf(this.f19401g.f19398e.t0.X0()));
                    if (m2) {
                        return;
                    }
                    this.f19401g.f19398e.m = true;
                    this.f19401g.f19398e.A0.B2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19400f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f19401g.f19398e.t0.L0().f57442f != null) {
                    i2 = this.f19401g.f19398e.t0.L0().f57442f.get(i2).sort_type.intValue();
                }
                m2 = this.f19401g.f19398e.t0.m2(i2);
                this.f19400f.setTag(Integer.valueOf(this.f19401g.f19398e.t0.X0()));
                if (m2) {
                }
            }
        }

        public q0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19398e = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:853:0x1e88, code lost:
            if (r39.f19398e.A0.Q0.f58058c.a().getTop() <= ((r39.f19398e.A0.L0() == null || r39.f19398e.A0.L0().c() == null) ? 0 : r39.f19398e.A0.L0().c().getBottom())) goto L802;
         */
        /* JADX WARN: Code restructure failed: missing block: B:854:0x1e8a, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:856:0x1e93, code lost:
            if (r0 >= r39.f19398e.z4()) goto L802;
         */
        /* JADX WARN: Code restructure failed: missing block: B:878:0x1f3a, code lost:
            if ((r39.f19398e.A0.Q0.f58058c.a().getTop() - r39.f19398e.A0.f58016h.f57901a.getBottom()) < (r39.f19398e.A0.Q0.f58058c.f19552g.getHeight() + 10)) goto L802;
         */
        /* JADX WARN: Removed duplicated region for block: B:1121:0x27d9  */
        /* JADX WARN: Removed duplicated region for block: B:1122:0x27ee  */
        /* JADX WARN: Removed duplicated region for block: B:1125:0x2827  */
        /* JADX WARN: Removed duplicated region for block: B:291:0x096b  */
        /* JADX WARN: Removed duplicated region for block: B:292:0x0970  */
        /* JADX WARN: Removed duplicated region for block: B:295:0x097e  */
        /* JADX WARN: Removed duplicated region for block: B:330:0x0a35  */
        /* JADX WARN: Removed duplicated region for block: B:333:0x0a48  */
        /* JADX WARN: Removed duplicated region for block: B:336:0x0a5a  */
        /* JADX WARN: Removed duplicated region for block: B:338:0x0a62  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            d.a.p0.s.s.h hVar;
            d.a.p0.s.s.h hVar2;
            d.a.p0.s.s.h hVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            d.a.p0.s.s.h hVar4;
            d.a.p0.s.s.h hVar5;
            d.a.p0.s.s.h hVar6;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            d.a.p0.s.q.g2 g2Var;
            String b2;
            String[] strArr;
            d.a.q0.h2.h.e L0;
            int i5;
            int i6;
            boolean l2;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f19398e.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.f19398e.A0.F0()) {
                        if (this.f19398e.m) {
                            return;
                        }
                        if (this.f19398e.t0.u1(true)) {
                            this.f19398e.m = true;
                            this.f19398e.A0.O2();
                        }
                    } else if (view != this.f19398e.A0.f58016h.m()) {
                        if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().l()) {
                            if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().d()) {
                                if (view == this.f19398e.A0.f58016h.f57906f) {
                                    if (this.f19398e.A0.R(this.f19398e.t0.z0())) {
                                        this.f19398e.t6();
                                        return;
                                    }
                                    this.f19398e.n = false;
                                    this.f19398e.j = false;
                                    d.a.d.e.p.l.x(this.f19398e.f19309e, this.f19398e.A0.f58016h.f57906f);
                                    this.f19398e.f19309e.finish();
                                } else if (view != this.f19398e.A0.n0() && (this.f19398e.A0.f58016h.n() == null || (view != this.f19398e.A0.f58016h.n().m() && view != this.f19398e.A0.f58016h.n().n()))) {
                                    if (view == this.f19398e.A0.v0()) {
                                        if (this.f19398e.t0 != null) {
                                            d.a.p0.m.a.l(this.f19398e.getPageContext().getPageActivity(), this.f19398e.t0.L0().N().r1().b());
                                        }
                                    } else if (view != this.f19398e.A0.f58016h.f57903c) {
                                        if (view == this.f19398e.A0.f58016h.f57904d) {
                                            if (d.a.p0.b1.l.a()) {
                                                return;
                                            }
                                            if (this.f19398e.t0 != null && this.f19398e.t0.L0() != null) {
                                                ArrayList<PostData> E = this.f19398e.t0.L0().E();
                                                if ((E == null || E.size() <= 0) && this.f19398e.t0.Z0()) {
                                                    d.a.d.e.p.l.M(this.f19398e.getPageContext().getPageActivity(), this.f19398e.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f19398e.t0.b1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f19398e.t0.getForumId()));
                                                if (!this.f19398e.A0.z1()) {
                                                    this.f19398e.A0.j2();
                                                }
                                                this.f19398e.G5();
                                            } else {
                                                d.a.d.e.p.l.M(this.f19398e.getPageContext().getPageActivity(), this.f19398e.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                            if (d.a.d.e.p.j.z()) {
                                                this.f19398e.A0.y2(true);
                                                this.f19398e.A0.j2();
                                                if (this.f19398e.m) {
                                                    return;
                                                }
                                                this.f19398e.m = true;
                                                this.f19398e.A0.q3();
                                                this.f19398e.t6();
                                                this.f19398e.A0.N2();
                                                this.f19398e.t0.k2(this.f19398e.E4());
                                                TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.f19398e.showToast(R.string.network_not_available);
                                                return;
                                            }
                                        } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                            if ((this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().j()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                                if (this.f19398e.A0.f58016h.n() != null && view == this.f19398e.A0.f58016h.n().e()) {
                                                    this.f19398e.A0.f58016h.k();
                                                } else if (view.getId() == R.id.share_num_container) {
                                                    if (!this.f19398e.f4(11009)) {
                                                        return;
                                                    }
                                                    this.f19398e.i5(3);
                                                } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                    if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().k()) {
                                                        if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().r()) {
                                                            if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().q()) {
                                                                if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().o()) {
                                                                    if (this.f19398e.A0.y0() == view) {
                                                                        if (this.f19398e.A0.y0().getIndicateStatus()) {
                                                                            d.a.q0.h2.h.e L02 = this.f19398e.t0.L0();
                                                                            if (L02 != null && L02.N() != null && L02.N().f1() != null) {
                                                                                String d2 = L02.N().f1().d();
                                                                                if (StringUtils.isNull(d2)) {
                                                                                    d2 = L02.N().f1().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d2));
                                                                            }
                                                                        } else {
                                                                            d.a.q0.h3.j0.a.d("c10725", null);
                                                                        }
                                                                        this.f19398e.b5();
                                                                    } else if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().g()) {
                                                                        if (this.f19398e.A0.f58016h.n() != null && view == this.f19398e.A0.f58016h.n().f()) {
                                                                            if (d.a.d.e.p.j.z()) {
                                                                                SparseArray<Object> C0 = this.f19398e.A0.C0(this.f19398e.t0.L0(), this.f19398e.t0.Z0(), 1);
                                                                                if (C0 != null) {
                                                                                    if (StringUtils.isNull((String) C0.get(R.id.tag_del_multi_forum))) {
                                                                                        this.f19398e.A0.S1(((Integer) C0.get(R.id.tag_del_post_type)).intValue(), (String) C0.get(R.id.tag_del_post_id), ((Integer) C0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C0.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                    } else {
                                                                                        this.f19398e.A0.T1(((Integer) C0.get(R.id.tag_del_post_type)).intValue(), (String) C0.get(R.id.tag_del_post_id), ((Integer) C0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C0.get(R.id.tag_del_post_is_self)).booleanValue(), (String) C0.get(R.id.tag_del_multi_forum));
                                                                                    }
                                                                                }
                                                                                this.f19398e.A0.f58016h.k();
                                                                            } else {
                                                                                this.f19398e.showToast(R.string.network_not_available);
                                                                                return;
                                                                            }
                                                                        } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                            if (view.getId() == R.id.pb_post_reply_count) {
                                                                                if (this.f19398e.t0 == null) {
                                                                                    return;
                                                                                }
                                                                                StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                                statisticItem2.param("tid", this.f19398e.t0.b1());
                                                                                statisticItem2.param("fid", this.f19398e.t0.getForumId());
                                                                                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                statisticItem2.param("obj_locate", 5);
                                                                                TiebaStatic.log(statisticItem2);
                                                                                if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19398e.getActivity(), "pb_chakanhuifu"))) {
                                                                                    this.f19398e.V = view;
                                                                                    return;
                                                                                } else if (!this.f19398e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                    return;
                                                                                } else {
                                                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                    if (!(sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                    StatisticItem statisticItem3 = postData.j0;
                                                                                    if (statisticItem3 != null) {
                                                                                        StatisticItem copy = statisticItem3.copy();
                                                                                        copy.delete("obj_locate");
                                                                                        copy.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy);
                                                                                    }
                                                                                    if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    String b1 = this.f19398e.t0.b1();
                                                                                    String E2 = postData.E();
                                                                                    int U = this.f19398e.t0.L0() != null ? this.f19398e.t0.L0().U() : 0;
                                                                                    AbsPbActivity.e J5 = this.f19398e.J5(E2);
                                                                                    if (J5 == null) {
                                                                                        return;
                                                                                    }
                                                                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f19398e.getPageContext().getPageActivity()).createSubPbActivityConfig(b1, E2, "pb", true, false, null, false, null, U, postData.O(), this.f19398e.t0.L0().d(), false, postData.t().getIconInfo(), 5).addBigImageData(J5.f19261a, J5.f19262b, J5.f19267g, J5.j);
                                                                                    addBigImageData.setKeyPageStartFrom(this.f19398e.t0.K0());
                                                                                    addBigImageData.setFromFrsForumId(this.f19398e.t0.getFromForumId());
                                                                                    addBigImageData.setWorksInfoData(this.f19398e.t0.f1());
                                                                                    addBigImageData.setKeyFromForumId(this.f19398e.t0.getForumId());
                                                                                    addBigImageData.setTiebaPlusData(this.f19398e.t0.E(), this.f19398e.t0.A(), this.f19398e.t0.B(), this.f19398e.t0.z(), this.f19398e.t0.F());
                                                                                    addBigImageData.setBjhData(this.f19398e.t0.g0());
                                                                                    if (this.f19398e.t0.L0().p() != null) {
                                                                                        addBigImageData.setHasForumRule(this.f19398e.t0.L0().p().has_forum_rule.intValue());
                                                                                    }
                                                                                    if (this.f19398e.t0.L0().T() != null) {
                                                                                        addBigImageData.setIsManager(this.f19398e.t0.L0().T().getIs_manager());
                                                                                    }
                                                                                    if (this.f19398e.t0.L0().m().getDeletedReasonInfo() != null) {
                                                                                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.f19398e.t0.L0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.f19398e.t0.L0().m().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                    }
                                                                                    if (this.f19398e.t0.L0().m() != null) {
                                                                                        addBigImageData.setForumHeadUrl(this.f19398e.t0.L0().m().getImage_url());
                                                                                        addBigImageData.setUserLevel(this.f19398e.t0.L0().m().getUser_level());
                                                                                    }
                                                                                    if (this.f19398e.A0 != null) {
                                                                                        addBigImageData.setMainPostMaskVisibly(this.f19398e.A0.t0(this.f19398e.t0.J, this.f19398e.t0.Z0()).S || postData.S);
                                                                                    }
                                                                                    this.f19398e.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                }
                                                                            } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                if (this.f19398e.t0 == null) {
                                                                                    return;
                                                                                }
                                                                                if (view.getId() == R.id.pb_post_reply) {
                                                                                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                                    statisticItem4.param("tid", this.f19398e.t0.b1());
                                                                                    statisticItem4.param("fid", this.f19398e.t0.getForumId());
                                                                                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem4.param("obj_locate", 6);
                                                                                    TiebaStatic.log(statisticItem4);
                                                                                }
                                                                                if (view.getId() == R.id.post_info_commont_img) {
                                                                                    if (!DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19398e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                        this.f19398e.W = view;
                                                                                        return;
                                                                                    }
                                                                                } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19398e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                    this.f19398e.W = view;
                                                                                    return;
                                                                                }
                                                                                if (!this.f19398e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                    return;
                                                                                }
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (!(sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                                    return;
                                                                                }
                                                                                PostData postData2 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.j0) != null) {
                                                                                    StatisticItem copy2 = statisticItem.copy();
                                                                                    copy2.delete("obj_locate");
                                                                                    copy2.param("obj_locate", 8);
                                                                                    TiebaStatic.log(copy2);
                                                                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f19398e.t0.c1()).param("fid", this.f19398e.t0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                                                }
                                                                                if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null || this.f19398e.V4().J0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                                    return;
                                                                                }
                                                                                if (this.f19398e.V4().K0() != null) {
                                                                                    this.f19398e.V4().K0().c();
                                                                                }
                                                                                if (this.f19398e.p0 && postData2.M() != null && postData2.M().size() != 0) {
                                                                                    this.f19398e.s6(postData2, true);
                                                                                } else {
                                                                                    d.a.q0.h2.h.r rVar = new d.a.q0.h2.h.r();
                                                                                    rVar.A(this.f19398e.t0.L0().m());
                                                                                    rVar.E(this.f19398e.t0.L0().N());
                                                                                    rVar.C(postData2);
                                                                                    this.f19398e.V4().J0().R(rVar);
                                                                                    this.f19398e.V4().J0().setPostId(postData2.E());
                                                                                    this.f19398e.y5(view, postData2.t().getUserId(), "", postData2);
                                                                                    if (this.f19398e.P0 != null) {
                                                                                        this.f19398e.A0.r2(this.f19398e.P0.D());
                                                                                    }
                                                                                }
                                                                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                                if (view != this.f19398e.A0.x0()) {
                                                                                    if (view == this.f19398e.A0.f58016h.o()) {
                                                                                        this.f19398e.A0.X2();
                                                                                    } else if (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().p()) {
                                                                                        if (this.f19398e.A0.f58016h.n() != null && view == this.f19398e.A0.f58016h.n().h()) {
                                                                                            d.a.p0.t.c.i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                            if (tiebaPlusConfigData != null && (b2 = tiebaPlusConfigData.b(this.f19398e.t0.b1())) != null) {
                                                                                                UrlManager.getInstance().dealOneLink(this.f19398e.getPageContext(), new String[]{b2});
                                                                                                this.f19398e.A0.f58016h.k();
                                                                                            }
                                                                                        } else {
                                                                                            int id = view.getId();
                                                                                            if (id == R.id.pb_u9_text_view) {
                                                                                                if (!this.f19398e.checkUpIsLogin() || (g2Var = (d.a.p0.s.q.g2) view.getTag()) == null || StringUtils.isNull(g2Var.C0())) {
                                                                                                    return;
                                                                                                }
                                                                                                TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                UrlManager.getInstance().dealOneLink(this.f19398e.getPageContext(), new String[]{g2Var.C0()});
                                                                                            } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                                if (id == R.id.pb_act_btn) {
                                                                                                    if (this.f19398e.t0.L0() != null && this.f19398e.t0.L0().N() != null && this.f19398e.t0.L0().N().t() != null) {
                                                                                                        d.a.p0.m.a.l(this.f19398e.getActivity(), this.f19398e.t0.L0().N().t());
                                                                                                        if (this.f19398e.t0.L0().N().q() != 1) {
                                                                                                            if (this.f19398e.t0.L0().N().q() == 2) {
                                                                                                                TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.lottery_tail) {
                                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                        String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.f19398e.t0.L0().n()).param("tid", this.f19398e.t0.L0().P()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.f19398e.t0.L0().P().equals(str)) {
                                                                                                            this.f19398e.A0.R2(0);
                                                                                                        } else {
                                                                                                            this.f19398e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f19398e.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.pb_item_tail_content) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.f19398e.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                        String p = d.a.p0.s.d0.b.j().p("tail_link", "");
                                                                                                        if (!StringUtils.isNull(p)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            d.a.p0.m.a.o(view.getContext(), string, p, true, true, true);
                                                                                                        }
                                                                                                        this.f19398e.A0.j2();
                                                                                                    }
                                                                                                } else if (id == R.id.join_vote_tv) {
                                                                                                    if (view != null) {
                                                                                                        d.a.p0.m.a.l(this.f19398e.getActivity(), (String) view.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.f19398e.y4() == 1 && this.f19398e.t0 != null && this.f19398e.t0.L0() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.f19398e.t0.L0().n()).param("tid", this.f19398e.t0.L0().P()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.look_all_tv) {
                                                                                                    if (view != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        d.a.p0.m.a.l(this.f19398e.getActivity(), (String) view.getTag());
                                                                                                        if (this.f19398e.y4() == 1 && this.f19398e.t0 != null && this.f19398e.t0.L0() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.f19398e.t0.L0().n()).param("tid", this.f19398e.t0.L0().P()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.manga_prev_btn) {
                                                                                                    this.f19398e.x5();
                                                                                                } else if (id == R.id.manga_next_btn) {
                                                                                                    this.f19398e.u5();
                                                                                                } else if (id == R.id.yule_head_img_img) {
                                                                                                    if (this.f19398e.t0 != null && this.f19398e.t0.L0() != null && this.f19398e.t0.L0().z() != null) {
                                                                                                        d.a.q0.h2.h.e L03 = this.f19398e.t0.L0();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", L03.n()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.f19398e.getPageContext(), new String[]{L03.z().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.yule_head_img_all_rank) {
                                                                                                    if (this.f19398e.t0 != null && this.f19398e.t0.L0() != null && this.f19398e.t0.L0().z() != null) {
                                                                                                        d.a.q0.h2.h.e L04 = this.f19398e.t0.L0();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", L04.n()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.f19398e.getPageContext(), new String[]{L04.z().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.tv_pb_reply_more) {
                                                                                                    if (this.f19398e.k1 >= 0) {
                                                                                                        if (this.f19398e.t0 != null) {
                                                                                                            this.f19398e.t0.Q1();
                                                                                                        }
                                                                                                        if (this.f19398e.t0 == null || this.f19398e.A0.l0() == null) {
                                                                                                            i4 = 0;
                                                                                                        } else {
                                                                                                            i4 = 0;
                                                                                                            this.f19398e.A0.l0().a0(this.f19398e.t0.L0(), false);
                                                                                                        }
                                                                                                        this.f19398e.k1 = i4;
                                                                                                        if (this.f19398e.t0 != null) {
                                                                                                            this.f19398e.A0.B0().setSelection(this.f19398e.t0.E0());
                                                                                                            this.f19398e.t0.U1(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.qq_share_container) {
                                                                                                    if (!this.f19398e.f4(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.f19398e.i5(8);
                                                                                                } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                                    SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                                    if (sparseArray4 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.f19398e.r6(sparseArray4);
                                                                                                } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                                    if (this.f19398e.A0.B0() == null || this.f19398e.t0 == null || this.f19398e.t0.L0() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.f19398e.A0.B0().getFirstVisiblePosition();
                                                                                                    View childAt = this.f19398e.A0.B0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean l0 = this.f19398e.t0.L0().l0();
                                                                                                    boolean z3 = this.f19398e.A0.L0() != null && this.f19398e.A0.L0().g();
                                                                                                    boolean x1 = this.f19398e.A0.x1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!l0 || this.f19398e.A0.L0() == null || this.f19398e.A0.L0().c() == null) {
                                                                                                        i3 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (d.a.d.e.p.l.k(this.f19398e.getContext()) * 0.5625d)) - this.f19398e.A0.L0().e();
                                                                                                        i3 = k;
                                                                                                        z4 = firstVisiblePosition == 0 && (top == k || top == this.f19398e.A0.L0().c().getHeight() - this.f19398e.A0.L0().e());
                                                                                                    }
                                                                                                    this.f19398e.t4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.f19398e.t0.L0().N() != null && this.f19398e.t0.L0().N().Q0() <= 0) || (x1 && z4)) {
                                                                                                        if (!this.f19398e.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f19398e.I5();
                                                                                                        if (this.f19398e.t0.L0().N().H() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19398e.t0.f19512f).param("fid", this.f19398e.t0.L0().n()).param("obj_locate", 2).param("uid", this.f19398e.t0.L0().N().H().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i9 = (int) (d.a.d.e.p.l.i(this.f19398e.getContext()) * 0.6d);
                                                                                                        if (l0) {
                                                                                                            if (this.f19398e.A0.Q0 != null && this.f19398e.A0.Q0.f58058c != null && this.f19398e.A0.Q0.f58058c.a() != null) {
                                                                                                                if (this.f19398e.A0.Q0.f58058c.a().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.f19398e.A0.I0() != null) {
                                                                                                                z2 = this.f19398e.A0.I0().getVisibility() == 0;
                                                                                                                if (!z2 && this.f19398e.A0.Q0 != null && this.f19398e.A0.Q0.f58058c != null && this.f19398e.A0.Q0.f58058c.a() != null && this.f19398e.A0.Q0.f58058c.a().getParent() != null && this.f19398e.A0.f58016h != null && this.f19398e.A0.f58016h.f57901a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || x1) {
                                                                                                            this.f19398e.i0 = firstVisiblePosition;
                                                                                                            this.f19398e.j0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                                this.f19398e.A0.B0().setSelectionFromTop(0, i3 - i9);
                                                                                                                this.f19398e.A0.B0().smoothScrollBy(-i9, 500);
                                                                                                            } else {
                                                                                                                this.f19398e.A0.B0().E(0, i3, 500);
                                                                                                            }
                                                                                                        } else if (this.f19398e.i0 > 0) {
                                                                                                            if (this.f19398e.A0.B0().getChildAt(this.f19398e.i0) != null) {
                                                                                                                this.f19398e.A0.B0().E(this.f19398e.i0, this.f19398e.j0, 200);
                                                                                                            } else {
                                                                                                                this.f19398e.A0.B0().setSelectionFromTop(this.f19398e.i0, this.f19398e.j0 + i9);
                                                                                                                this.f19398e.A0.B0().smoothScrollBy(i9, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int z42 = this.f19398e.z4();
                                                                                                            if (this.f19398e.C4() != -1) {
                                                                                                                z42--;
                                                                                                            }
                                                                                                            int g2 = d.a.d.e.p.l.g(this.f19398e.getContext(), R.dimen.tbds100);
                                                                                                            if (z42 < 0) {
                                                                                                                z42 = (ListUtils.getCount(this.f19398e.A0.B0().getData()) - 1) + this.f19398e.A0.B0().getHeaderViewsCount();
                                                                                                                g2 = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!l0 || this.f19398e.A0.L0() == null) {
                                                                                                                    if (this.f19398e.A0.f58016h != null && this.f19398e.A0.f58016h.f57901a != null) {
                                                                                                                        fixedNavHeight = this.f19398e.A0.f58016h.f57901a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.f19398e.A0.Q0 != null || this.f19398e.A0.Q0.f58058c == null || this.f19398e.A0.Q0.f58058c.a() == null || this.f19398e.A0.Q0.f58058c.a().getParent() == null) {
                                                                                                                        this.f19398e.A0.B0().setSelectionFromTop(z42, g2 + i9);
                                                                                                                        this.f19398e.A0.B0().smoothScrollBy(i9, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.f19398e.A0.B0().E(z42, g2, 200);
                                                                                                                    } else {
                                                                                                                        this.f19398e.A0.B0().smoothScrollBy(this.f19398e.A0.Q0.f58058c.a().getTop() - ((int) (d.a.d.e.p.l.k(this.f19398e.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.f19398e.A0.L0().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (d.a.d.e.p.l.k(this.f19398e.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            g2 += fixedNavHeight;
                                                                                                            if (this.f19398e.A0.Q0 != null) {
                                                                                                            }
                                                                                                            this.f19398e.A0.B0().setSelectionFromTop(z42, g2 + i9);
                                                                                                            this.f19398e.A0.B0().smoothScrollBy(i9, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.f19398e.t0.L0().N() != null && this.f19398e.t0.L0().N().H() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19398e.t0.f19512f).param("fid", this.f19398e.t0.L0().n()).param("obj_locate", 2).param("uid", this.f19398e.t0.L0().N().H().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                                    if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null || this.f19398e.t0.L0().m() == null || d.a.d.e.p.k.isEmpty(this.f19398e.t0.L0().m().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.f19398e.t0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.f19398e.t0.n0()) || this.f19398e.t0.d0() == null) {
                                                                                                            this.f19398e.f19309e.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.f19398e.t0.d0().f57432b;
                                                                                                    } else {
                                                                                                        name = this.f19398e.t0.L0().m().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.f19398e.f19309e.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String n0 = this.f19398e.t0.n0();
                                                                                                    if (this.f19398e.t0.r0() && n0 != null && n0.equals(name)) {
                                                                                                        this.f19398e.f19309e.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19398e.getActivity()).createNormalCfg(this.f19398e.t0.L0().m().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                                    statisticItem5.param("tid", this.f19398e.t0.b1());
                                                                                                    statisticItem5.param("fid", this.f19398e.t0.getForumId());
                                                                                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.f19398e.t0.L0().N() != null) {
                                                                                                        statisticItem5.param("nid", this.f19398e.t0.L0().N().B0());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem5);
                                                                                                } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                                    if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.f19398e.t0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                                        statisticItem6.param("tid", this.f19398e.t0.b1());
                                                                                                        statisticItem6.param("fid", this.f19398e.t0.getForumId());
                                                                                                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem6.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem6);
                                                                                                    } else if (id == R.id.pb_thread_post_button) {
                                                                                                        if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        d.a.q0.h2.h.e L05 = this.f19398e.t0.L0();
                                                                                                        if (this.f19398e.y0 == null) {
                                                                                                            PbFragment pbFragment2 = this.f19398e;
                                                                                                            pbFragment2.y0 = new d.a.q0.h2.h.t(pbFragment2.getPageContext());
                                                                                                        }
                                                                                                        long f2 = d.a.d.e.m.b.f(L05.P(), 0L);
                                                                                                        long f3 = d.a.d.e.m.b.f(L05.n(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", f3).eventStat();
                                                                                                        PbFragment pbFragment3 = this.f19398e;
                                                                                                        pbFragment3.registerListener(pbFragment3.a2);
                                                                                                        this.f19398e.y0.a(f2, f3);
                                                                                                    } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                                        if (view.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                            if (!d.a.q0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                d.a.p0.m.a.l(this.f19398e.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.f19398e.t0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.f19398e.t0.b1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                                        if (!(view.getTag() instanceof d.a.p0.s.q.b2)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        d.a.p0.s.q.b2 b2Var = (d.a.p0.s.q.b2) view.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f19398e.getActivity()).createNormalCfg(b2Var.X(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", b2Var.R()).param("tid", b2Var.d0()).param("thread_type", b2Var.k1()).param(TiebaStatic.Params.IS_ZP, b2Var.w2() ? 1 : 0));
                                                                                                    } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                                        if (!(view.getTag() instanceof d.a.p0.s.q.b2) || !this.f19398e.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        d.a.p0.s.q.b2 b2Var2 = (d.a.p0.s.q.b2) view.getTag();
                                                                                                        if (this.f19398e.T != null) {
                                                                                                            this.f19398e.T.L(b2Var2.X(), String.valueOf(b2Var2.R()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", b2Var2.R()).param("tid", b2Var2.d0()).param("thread_type", b2Var2.k1()).param(TiebaStatic.Params.IS_ZP, b2Var2.w2() ? 1 : 0));
                                                                                                    } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.f19398e.t0.b1());
                                                                                                        statisticItem7.param("fid", this.f19398e.t0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                        PbFragment pbFragment4 = this.f19398e;
                                                                                                        pbFragment4.f19310f = false;
                                                                                                        pbFragment4.l4(view);
                                                                                                    }
                                                                                                } else if (!(view.getTag() instanceof d.a.p0.s.q.b2)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    d.a.p0.s.q.b2 b2Var3 = (d.a.p0.s.q.b2) view.getTag();
                                                                                                    if (this.f19398e.t0.K0() == 3 && this.f19398e.isSimpleForum() && this.f19398e.t0.L0() != null && ListUtils.isEmpty(this.f19398e.t0.L0().q())) {
                                                                                                        this.f19398e.f19309e.finish();
                                                                                                    } else {
                                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f19398e.getActivity()).createNormalCfg(b2Var3.X(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                                    }
                                                                                                    StatisticItem statisticItem8 = new StatisticItem("c13399");
                                                                                                    statisticItem8.param("tid", b2Var3.d0());
                                                                                                    statisticItem8.param("fid", b2Var3.R());
                                                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    statisticItem8.param("nid", b2Var3.B0());
                                                                                                    TiebaStatic.log(statisticItem8);
                                                                                                }
                                                                                            } else {
                                                                                                d.a.p0.s.s.h hVar7 = null;
                                                                                                if (!this.f19398e.checkUpIsLogin()) {
                                                                                                    return;
                                                                                                }
                                                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                if (view != null && view.getTag() != null) {
                                                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                    PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                                    if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                                        TiebaStatic.log(new StatisticItem("c12006").param("tid", this.f19398e.t0.f19512f));
                                                                                                    }
                                                                                                    if (this.f19398e.G0 == null) {
                                                                                                        PbFragment pbFragment5 = this.f19398e;
                                                                                                        pbFragment5.G0 = new d.a.p0.s.s.l(pbFragment5.getContext());
                                                                                                        this.f19398e.G0.n(this.f19398e.U1);
                                                                                                    }
                                                                                                    ArrayList arrayList = new ArrayList();
                                                                                                    this.f19398e.p5(view);
                                                                                                    if (this.f19398e.p5(view) && this.f19398e.g1 != null) {
                                                                                                        this.f19398e.g1.t();
                                                                                                    }
                                                                                                    if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                                        ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                                    }
                                                                                                    boolean booleanValue = sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                                                    boolean booleanValue2 = sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                                                    boolean booleanValue3 = sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                                                    boolean booleanValue4 = sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                                                    boolean booleanValue5 = sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                                                    String str2 = sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray5.get(R.id.tag_forbid_user_post_id) : null;
                                                                                                    if (postData3 != null) {
                                                                                                        if (postData3.K() != null && postData3.K().toString().length() > 0) {
                                                                                                            d.a.p0.s.s.h hVar8 = new d.a.p0.s.s.h(3, this.f19398e.getString(R.string.copy), this.f19398e.G0);
                                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                                            sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                            hVar8.f53561d.setTag(sparseArray6);
                                                                                                            arrayList.add(hVar8);
                                                                                                        }
                                                                                                        this.f19398e.o2 = postData3;
                                                                                                    }
                                                                                                    if (this.f19398e.t0.L0().s()) {
                                                                                                        String u = this.f19398e.t0.L0().u();
                                                                                                        if (postData3 != null && !d.a.d.e.p.k.isEmpty(u) && u.equals(postData3.E())) {
                                                                                                            z = true;
                                                                                                            if (!z) {
                                                                                                                hVar4 = new d.a.p0.s.s.h(4, this.f19398e.getString(R.string.remove_mark), this.f19398e.G0);
                                                                                                            } else {
                                                                                                                hVar4 = new d.a.p0.s.s.h(4, this.f19398e.getString(R.string.mark), this.f19398e.G0);
                                                                                                            }
                                                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                                                            sparseArray7.put(R.id.tag_clip_board, this.f19398e.o2);
                                                                                                            sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                            hVar4.f53561d.setTag(sparseArray7);
                                                                                                            arrayList.add(hVar4);
                                                                                                            if (this.f19398e.mIsLogin) {
                                                                                                                if (d.a.q0.h2.k.e.g1.a.h(this.f19398e.t0) || booleanValue3 || !booleanValue2) {
                                                                                                                    if (this.f19398e.s5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                        d.a.p0.s.s.h hVar9 = new d.a.p0.s.s.h(5, this.f19398e.getString(R.string.report_text), this.f19398e.G0);
                                                                                                                        hVar9.f53561d.setTag(str2);
                                                                                                                        arrayList.add(hVar9);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    d.a.p0.s.s.h hVar10 = new d.a.p0.s.s.h(5, this.f19398e.getString(R.string.mute_option), this.f19398e.G0);
                                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                                    sparseArray8.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                                    int i10 = R.id.tag_is_mem;
                                                                                                                    sparseArray8.put(i10, sparseArray5.get(i10));
                                                                                                                    int i11 = R.id.tag_user_mute_mute_userid;
                                                                                                                    sparseArray8.put(i11, sparseArray5.get(i11));
                                                                                                                    int i12 = R.id.tag_user_mute_mute_username;
                                                                                                                    sparseArray8.put(i12, sparseArray5.get(i12));
                                                                                                                    int i13 = R.id.tag_user_mute_mute_nameshow;
                                                                                                                    sparseArray8.put(i13, sparseArray5.get(i13));
                                                                                                                    int i14 = R.id.tag_user_mute_post_id;
                                                                                                                    sparseArray8.put(i14, sparseArray5.get(i14));
                                                                                                                    int i15 = R.id.tag_user_mute_thread_id;
                                                                                                                    sparseArray8.put(i15, sparseArray5.get(i15));
                                                                                                                    int i16 = R.id.tag_del_post_is_self;
                                                                                                                    sparseArray8.put(i16, sparseArray5.get(i16));
                                                                                                                    int i17 = R.id.tag_del_post_type;
                                                                                                                    sparseArray8.put(i17, sparseArray5.get(i17));
                                                                                                                    int i18 = R.id.tag_del_post_id;
                                                                                                                    sparseArray8.put(i18, sparseArray5.get(i18));
                                                                                                                    int i19 = R.id.tag_manage_user_identity;
                                                                                                                    sparseArray8.put(i19, sparseArray5.get(i19));
                                                                                                                    hVar4.f53561d.setTag(sparseArray8);
                                                                                                                    arrayList.add(hVar10);
                                                                                                                }
                                                                                                                if (booleanValue3) {
                                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                                                    int i20 = R.id.tag_manage_user_identity;
                                                                                                                    sparseArray9.put(i20, sparseArray5.get(i20));
                                                                                                                    int i21 = R.id.tag_forbid_user_name;
                                                                                                                    sparseArray9.put(i21, sparseArray5.get(i21));
                                                                                                                    int i22 = R.id.tag_forbid_user_name_show;
                                                                                                                    sparseArray9.put(i22, sparseArray5.get(i22));
                                                                                                                    int i23 = R.id.tag_forbid_user_portrait;
                                                                                                                    sparseArray9.put(i23, sparseArray5.get(i23));
                                                                                                                    sparseArray9.put(R.id.tag_forbid_user_post_id, str2);
                                                                                                                    if (booleanValue4) {
                                                                                                                        sparseArray9.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                                        int i24 = R.id.tag_is_mem;
                                                                                                                        sparseArray9.put(i24, sparseArray5.get(i24));
                                                                                                                        int i25 = R.id.tag_user_mute_mute_userid;
                                                                                                                        sparseArray9.put(i25, sparseArray5.get(i25));
                                                                                                                        int i26 = R.id.tag_user_mute_mute_username;
                                                                                                                        sparseArray9.put(i26, sparseArray5.get(i26));
                                                                                                                        int i27 = R.id.tag_user_mute_mute_nameshow;
                                                                                                                        sparseArray9.put(i27, sparseArray5.get(i27));
                                                                                                                        int i28 = R.id.tag_user_mute_post_id;
                                                                                                                        sparseArray9.put(i28, sparseArray5.get(i28));
                                                                                                                        int i29 = R.id.tag_user_mute_thread_id;
                                                                                                                        sparseArray9.put(i29, sparseArray5.get(i29));
                                                                                                                    } else {
                                                                                                                        sparseArray9.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                                                    }
                                                                                                                    if (booleanValue5) {
                                                                                                                        sparseArray9.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                                        int i30 = R.id.tag_del_post_id;
                                                                                                                        sparseArray9.put(i30, sparseArray5.get(i30));
                                                                                                                        int i31 = R.id.tag_del_post_type;
                                                                                                                        sparseArray9.put(i31, sparseArray5.get(i31));
                                                                                                                        int i32 = R.id.tag_has_sub_post;
                                                                                                                        sparseArray9.put(i32, sparseArray5.get(i32));
                                                                                                                        hVar7 = new d.a.p0.s.s.h(6, this.f19398e.getString(R.string.delete), this.f19398e.G0);
                                                                                                                        hVar7.f53561d.setTag(sparseArray9);
                                                                                                                    } else {
                                                                                                                        sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                                    }
                                                                                                                    hVar5 = new d.a.p0.s.s.h(7, this.f19398e.getString(R.string.bar_manager), this.f19398e.G0);
                                                                                                                    hVar5.f53561d.setTag(sparseArray9);
                                                                                                                } else if (booleanValue5) {
                                                                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                                                                    sparseArray10.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                                                    sparseArray10.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                                    int i33 = R.id.tag_manage_user_identity;
                                                                                                                    sparseArray10.put(i33, sparseArray5.get(i33));
                                                                                                                    sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                                    int i34 = R.id.tag_del_post_id;
                                                                                                                    sparseArray10.put(i34, sparseArray5.get(i34));
                                                                                                                    int i35 = R.id.tag_del_post_type;
                                                                                                                    sparseArray10.put(i35, sparseArray5.get(i35));
                                                                                                                    int i36 = R.id.tag_has_sub_post;
                                                                                                                    sparseArray10.put(i36, sparseArray5.get(i36));
                                                                                                                    if (this.f19398e.t0.L0().U() == 1002 && !booleanValue) {
                                                                                                                        hVar6 = new d.a.p0.s.s.h(6, this.f19398e.getString(R.string.report_text), this.f19398e.G0);
                                                                                                                    } else {
                                                                                                                        hVar6 = new d.a.p0.s.s.h(6, this.f19398e.getString(R.string.delete), this.f19398e.G0);
                                                                                                                    }
                                                                                                                    hVar6.f53561d.setTag(sparseArray10);
                                                                                                                    hVar7 = hVar6;
                                                                                                                    hVar5 = null;
                                                                                                                } else {
                                                                                                                    hVar5 = null;
                                                                                                                }
                                                                                                                if (hVar7 != null) {
                                                                                                                    arrayList.add(hVar7);
                                                                                                                }
                                                                                                                if (hVar5 != null) {
                                                                                                                    arrayList.add(hVar5);
                                                                                                                }
                                                                                                            }
                                                                                                            this.f19398e.G0.k(arrayList);
                                                                                                            this.f19398e.F0 = new d.a.p0.s.s.j(this.f19398e.getPageContext(), this.f19398e.G0);
                                                                                                            this.f19398e.F0.l();
                                                                                                        }
                                                                                                    }
                                                                                                    z = false;
                                                                                                    if (!z) {
                                                                                                    }
                                                                                                    SparseArray sparseArray72 = new SparseArray();
                                                                                                    sparseArray72.put(R.id.tag_clip_board, this.f19398e.o2);
                                                                                                    sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                    hVar4.f53561d.setTag(sparseArray72);
                                                                                                    arrayList.add(hVar4);
                                                                                                    if (this.f19398e.mIsLogin) {
                                                                                                    }
                                                                                                    this.f19398e.G0.k(arrayList);
                                                                                                    this.f19398e.F0 = new d.a.p0.s.s.j(this.f19398e.getPageContext(), this.f19398e.G0);
                                                                                                    this.f19398e.F0.l();
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        this.f19398e.A0.f58016h.l();
                                                                                        this.f19398e.A0.n3(this.f19398e.r2);
                                                                                    }
                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                    this.f19398e.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.f19398e.getPageContext().getPageActivity(), 24008, d.a.d.e.m.b.f(this.f19398e.t0.L0().n(), 0L), d.a.d.e.m.b.f(this.f19398e.t0.b1(), 0L), d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.f19398e.t0.L0().N().K0())));
                                                                                }
                                                                            } else {
                                                                                try {
                                                                                    sparseArray = (SparseArray) view.getTag();
                                                                                } catch (ClassCastException e2) {
                                                                                    e2.printStackTrace();
                                                                                    sparseArray = null;
                                                                                }
                                                                                PostData postData4 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                                if (postData4 == null) {
                                                                                    return;
                                                                                }
                                                                                if (this.f19398e.G0 == null) {
                                                                                    PbFragment pbFragment6 = this.f19398e;
                                                                                    pbFragment6.G0 = new d.a.p0.s.s.l(pbFragment6.getContext());
                                                                                    this.f19398e.G0.n(this.f19398e.U1);
                                                                                }
                                                                                ArrayList arrayList2 = new ArrayList();
                                                                                boolean z5 = this.f19398e.y().L0() != null && this.f19398e.y().L0().e0();
                                                                                if (view != null && sparseArray != null) {
                                                                                    boolean booleanValue6 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                                    boolean booleanValue7 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                                    boolean booleanValue8 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                                    boolean booleanValue9 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                                    boolean booleanValue10 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                                    String str3 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                                                                                    if (postData4.q() != null) {
                                                                                        boolean z6 = postData4.q().hasAgree;
                                                                                        int s = postData4.s();
                                                                                        if (z6 && s == 5) {
                                                                                            pbFragment = this.f19398e;
                                                                                            i2 = R.string.action_cancel_dislike;
                                                                                        } else {
                                                                                            pbFragment = this.f19398e;
                                                                                            i2 = R.string.action_dislike;
                                                                                        }
                                                                                        d.a.p0.s.s.h hVar11 = new d.a.p0.s.s.h(8, pbFragment.getString(i2), this.f19398e.G0);
                                                                                        SparseArray sparseArray11 = new SparseArray();
                                                                                        sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                        hVar11.f53561d.setTag(sparseArray11);
                                                                                        arrayList2.add(hVar11);
                                                                                    }
                                                                                    if (this.f19398e.mIsLogin) {
                                                                                        if (d.a.q0.h2.k.e.g1.a.h(this.f19398e.t0) || booleanValue8 || !booleanValue7) {
                                                                                            if ((this.f19398e.s5(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                d.a.p0.s.s.h hVar12 = new d.a.p0.s.s.h(5, this.f19398e.getString(R.string.report_text), this.f19398e.G0);
                                                                                                hVar12.f53561d.setTag(str3);
                                                                                                arrayList2.add(hVar12);
                                                                                            }
                                                                                        } else {
                                                                                            d.a.p0.s.s.h hVar13 = new d.a.p0.s.s.h(5, this.f19398e.getString(R.string.mute_option), this.f19398e.G0);
                                                                                            SparseArray sparseArray12 = new SparseArray();
                                                                                            sparseArray12.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                            int i37 = R.id.tag_is_mem;
                                                                                            sparseArray12.put(i37, sparseArray.get(i37));
                                                                                            int i38 = R.id.tag_user_mute_mute_userid;
                                                                                            sparseArray12.put(i38, sparseArray.get(i38));
                                                                                            int i39 = R.id.tag_user_mute_mute_username;
                                                                                            sparseArray12.put(i39, sparseArray.get(i39));
                                                                                            int i40 = R.id.tag_user_mute_mute_nameshow;
                                                                                            sparseArray12.put(i40, sparseArray.get(i40));
                                                                                            int i41 = R.id.tag_user_mute_post_id;
                                                                                            sparseArray12.put(i41, sparseArray.get(i41));
                                                                                            int i42 = R.id.tag_user_mute_thread_id;
                                                                                            sparseArray12.put(i42, sparseArray.get(i42));
                                                                                            int i43 = R.id.tag_del_post_is_self;
                                                                                            sparseArray12.put(i43, sparseArray.get(i43));
                                                                                            int i44 = R.id.tag_del_post_type;
                                                                                            sparseArray12.put(i44, sparseArray.get(i44));
                                                                                            int i45 = R.id.tag_del_post_id;
                                                                                            sparseArray12.put(i45, sparseArray.get(i45));
                                                                                            int i46 = R.id.tag_manage_user_identity;
                                                                                            sparseArray12.put(i46, sparseArray.get(i46));
                                                                                            hVar13.f53561d.setTag(sparseArray12);
                                                                                            arrayList2.add(hVar13);
                                                                                        }
                                                                                        if (booleanValue8) {
                                                                                            SparseArray sparseArray13 = new SparseArray();
                                                                                            sparseArray13.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                            int i47 = R.id.tag_manage_user_identity;
                                                                                            sparseArray13.put(i47, sparseArray.get(i47));
                                                                                            int i48 = R.id.tag_forbid_user_name;
                                                                                            sparseArray13.put(i48, sparseArray.get(i48));
                                                                                            int i49 = R.id.tag_forbid_user_name_show;
                                                                                            sparseArray13.put(i49, sparseArray.get(i49));
                                                                                            int i50 = R.id.tag_forbid_user_portrait;
                                                                                            sparseArray13.put(i50, sparseArray.get(i50));
                                                                                            sparseArray13.put(R.id.tag_forbid_user_post_id, str3);
                                                                                            if (booleanValue9) {
                                                                                                sparseArray13.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                                int i51 = R.id.tag_is_mem;
                                                                                                sparseArray13.put(i51, sparseArray.get(i51));
                                                                                                int i52 = R.id.tag_user_mute_mute_userid;
                                                                                                sparseArray13.put(i52, sparseArray.get(i52));
                                                                                                int i53 = R.id.tag_user_mute_mute_username;
                                                                                                sparseArray13.put(i53, sparseArray.get(i53));
                                                                                                int i54 = R.id.tag_user_mute_mute_nameshow;
                                                                                                sparseArray13.put(i54, sparseArray.get(i54));
                                                                                                int i55 = R.id.tag_user_mute_post_id;
                                                                                                sparseArray13.put(i55, sparseArray.get(i55));
                                                                                                int i56 = R.id.tag_user_mute_thread_id;
                                                                                                sparseArray13.put(i56, sparseArray.get(i56));
                                                                                            } else {
                                                                                                sparseArray13.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                            }
                                                                                            if (booleanValue10) {
                                                                                                sparseArray13.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                                sparseArray13.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue6));
                                                                                                int i57 = R.id.tag_del_post_id;
                                                                                                sparseArray13.put(i57, sparseArray.get(i57));
                                                                                                int i58 = R.id.tag_del_post_type;
                                                                                                sparseArray13.put(i58, sparseArray.get(i58));
                                                                                                int i59 = R.id.tag_has_sub_post;
                                                                                                sparseArray13.put(i59, sparseArray.get(i59));
                                                                                                hVar2 = new d.a.p0.s.s.h(6, this.f19398e.getString(R.string.delete), this.f19398e.G0);
                                                                                                hVar2.f53561d.setTag(sparseArray13);
                                                                                            } else {
                                                                                                sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                hVar2 = null;
                                                                                            }
                                                                                            hVar = new d.a.p0.s.s.h(7, this.f19398e.getString(R.string.bar_manager), this.f19398e.G0);
                                                                                            hVar.f53561d.setTag(sparseArray13);
                                                                                        } else if (booleanValue10) {
                                                                                            SparseArray sparseArray14 = new SparseArray();
                                                                                            sparseArray14.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                            int i60 = R.id.tag_manage_user_identity;
                                                                                            sparseArray14.put(i60, sparseArray.get(i60));
                                                                                            sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue6));
                                                                                            int i61 = R.id.tag_del_post_id;
                                                                                            sparseArray14.put(i61, sparseArray.get(i61));
                                                                                            int i62 = R.id.tag_del_post_type;
                                                                                            sparseArray14.put(i62, sparseArray.get(i62));
                                                                                            int i63 = R.id.tag_has_sub_post;
                                                                                            sparseArray14.put(i63, sparseArray.get(i63));
                                                                                            if (this.f19398e.t0.L0().U() == 1002 && !booleanValue6) {
                                                                                                hVar3 = new d.a.p0.s.s.h(6, this.f19398e.getString(R.string.report_text), this.f19398e.G0);
                                                                                            } else {
                                                                                                hVar3 = new d.a.p0.s.s.h(6, this.f19398e.getString(R.string.delete), this.f19398e.G0);
                                                                                            }
                                                                                            hVar3.f53561d.setTag(sparseArray14);
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
                                                                                    this.f19398e.G0.k(arrayList2);
                                                                                    this.f19398e.F0 = new d.a.p0.s.s.j(this.f19398e.getPageContext(), this.f19398e.G0);
                                                                                    this.f19398e.F0.l();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                                statisticItem9.param("tid", this.f19398e.t0.b1());
                                                                                statisticItem9.param("fid", this.f19398e.t0.getForumId());
                                                                                statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                statisticItem9.param("obj_locate", 4);
                                                                                TiebaStatic.log(statisticItem9);
                                                                            }
                                                                            if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19398e.getActivity(), "pb_chakanhuifu"))) {
                                                                                this.f19398e.V = view;
                                                                                return;
                                                                            } else if (this.f19398e.checkUpIsLogin()) {
                                                                                if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null) {
                                                                                    return;
                                                                                }
                                                                                this.f19398e.A0.a0();
                                                                                SparseArray sparseArray15 = (SparseArray) view.getTag();
                                                                                PostData postData5 = (PostData) sparseArray15.get(R.id.tag_load_sub_data);
                                                                                PostData postData6 = (PostData) sparseArray15.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray15.get(R.id.tag_load_sub_view);
                                                                                if (postData5 == null || view2 == null) {
                                                                                    return;
                                                                                }
                                                                                if (postData5.C() == 1) {
                                                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                                                }
                                                                                StatisticItem statisticItem10 = postData5.j0;
                                                                                if (statisticItem10 != null) {
                                                                                    StatisticItem copy3 = statisticItem10.copy();
                                                                                    copy3.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        copy3.param("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        copy3.param("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(copy3);
                                                                                }
                                                                                String b12 = this.f19398e.t0.b1();
                                                                                String E3 = postData5.E();
                                                                                String E4 = postData6 != null ? postData6.E() : "";
                                                                                int U2 = this.f19398e.t0.L0() != null ? this.f19398e.t0.L0().U() : 0;
                                                                                this.f19398e.t6();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    AbsPbActivity.e J52 = this.f19398e.J5(E3);
                                                                                    if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null || J52 == null) {
                                                                                        return;
                                                                                    }
                                                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f19398e.getPageContext().getPageActivity()).createSubPbActivityConfig(b12, E3, "pb", true, false, null, true, null, U2, postData5.O(), this.f19398e.t0.L0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(J52.f19261a, J52.f19262b, J52.f19267g, J52.j);
                                                                                    addBigImageData2.setKeyPageStartFrom(this.f19398e.t0.K0());
                                                                                    addBigImageData2.setFromFrsForumId(this.f19398e.t0.getFromForumId());
                                                                                    addBigImageData2.setWorksInfoData(this.f19398e.t0.f1());
                                                                                    addBigImageData2.setKeyFromForumId(this.f19398e.t0.getForumId());
                                                                                    addBigImageData2.setBjhData(this.f19398e.t0.g0());
                                                                                    addBigImageData2.setTiebaPlusData(this.f19398e.t0.E(), this.f19398e.t0.A(), this.f19398e.t0.B(), this.f19398e.t0.z(), this.f19398e.t0.F());
                                                                                    this.f19398e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    AbsPbActivity.e J53 = this.f19398e.J5(E3);
                                                                                    if (postData5 == null || this.f19398e.t0 == null || this.f19398e.t0.L0() == null || J53 == null) {
                                                                                        return;
                                                                                    }
                                                                                    SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f19398e.getPageContext().getPageActivity()).createSubPbActivityConfig(b12, E3, "pb", true, false, null, false, E4, U2, postData5.O(), this.f19398e.t0.L0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(J53.f19261a, J53.f19262b, J53.f19267g, J53.j);
                                                                                    if (!d.a.d.e.p.k.isEmpty(E4)) {
                                                                                        addBigImageData3.setHighLightPostId(E4);
                                                                                        addBigImageData3.setKeyIsUseSpid(true);
                                                                                    }
                                                                                    addBigImageData3.setKeyFromForumId(this.f19398e.t0.getForumId());
                                                                                    addBigImageData3.setTiebaPlusData(this.f19398e.t0.E(), this.f19398e.t0.A(), this.f19398e.t0.B(), this.f19398e.t0.z(), this.f19398e.t0.F());
                                                                                    addBigImageData3.setBjhData(this.f19398e.t0.g0());
                                                                                    addBigImageData3.setKeyPageStartFrom(this.f19398e.t0.K0());
                                                                                    addBigImageData3.setFromFrsForumId(this.f19398e.t0.getFromForumId());
                                                                                    addBigImageData3.setWorksInfoData(this.f19398e.t0.f1());
                                                                                    if (this.f19398e.A0 != null) {
                                                                                        addBigImageData3.setMainPostMaskVisibly(this.f19398e.A0.t0(this.f19398e.t0.J, this.f19398e.t0.Z0()).S || postData5.S);
                                                                                    }
                                                                                    this.f19398e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                }
                                                                            } else {
                                                                                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f19398e.t0.L0().n()));
                                                                                return;
                                                                            }
                                                                        }
                                                                    } else if (d.a.d.e.p.j.z()) {
                                                                        this.f19398e.A0.a0();
                                                                        SparseArray<Object> C02 = this.f19398e.A0.C0(this.f19398e.t0.L0(), this.f19398e.t0.Z0(), 1);
                                                                        if (C02 == null) {
                                                                            return;
                                                                        }
                                                                        this.f19398e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19398e.getPageContext().getPageActivity(), this.f19398e.t0.L0().m().getId(), this.f19398e.t0.L0().m().getName(), this.f19398e.t0.L0().N().d0(), String.valueOf(this.f19398e.t0.L0().T().getUserId()), (String) C02.get(R.id.tag_forbid_user_name), (String) C02.get(R.id.tag_forbid_user_name_show), (String) C02.get(R.id.tag_forbid_user_post_id), (String) C02.get(R.id.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        this.f19398e.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        this.f19398e.onChangeSkinType(skinType);
                                                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                    } else if (skinType == 0 || skinType == 4) {
                                                                        UtilHelper.showSkinChangeAnimation(this.f19398e.getActivity());
                                                                        this.f19398e.onChangeSkinType(skinType);
                                                                        UtilHelper.setNavigationBarBackground(this.f19398e.getActivity(), this.f19398e.getResources().getColor(R.color.CAM_X0201_1));
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                    }
                                                                    this.f19398e.A0.f58016h.l();
                                                                }
                                                            } else if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null || this.f19398e.t0.L0().N() == null) {
                                                                return;
                                                            } else {
                                                                this.f19398e.A0.f58016h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.f19398e;
                                                                pbFragment7.e5(pbFragment7.t0.L0().N().U());
                                                            }
                                                        } else {
                                                            this.f19398e.A0.a0();
                                                            if (d.a.d.e.p.j.z()) {
                                                                if (this.f19398e.m) {
                                                                    view.setTag(Integer.valueOf(this.f19398e.t0.X0()));
                                                                    return;
                                                                }
                                                                this.f19398e.t6();
                                                                this.f19398e.A0.N2();
                                                                d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f19398e.getPageContext());
                                                                if (this.f19398e.t0.L0().f57442f == null || this.f19398e.t0.L0().f57442f.size() <= 0) {
                                                                    strArr = new String[]{this.f19398e.getResources().getString(R.string.sort_type_new), this.f19398e.getResources().getString(R.string.sort_type_old)};
                                                                } else {
                                                                    strArr = new String[this.f19398e.t0.L0().f57442f.size()];
                                                                    for (int i64 = 0; i64 < this.f19398e.t0.L0().f57442f.size(); i64++) {
                                                                        strArr[i64] = this.f19398e.t0.L0().f57442f.get(i64).sort_name + this.f19398e.getResources().getString(R.string.sort_static);
                                                                    }
                                                                }
                                                                jVar.i(null, strArr, new a(this, jVar, view));
                                                                jVar.l();
                                                            } else {
                                                                this.f19398e.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.f19398e.A0.a0();
                                                        if (this.f19398e.y().L0().f57443g != 2) {
                                                            if (this.f19398e.t0.J0() != null) {
                                                                this.f19398e.A0.r3(this.f19398e.t0.J0(), this.f19398e.T1);
                                                            }
                                                            TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.f19398e.showToast(R.string.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.f19398e.checkUpIsLogin()) || (L0 = this.f19398e.t0.L0()) == null) {
                                                    return;
                                                } else {
                                                    d.a.p0.s.q.b2 N = L0.N();
                                                    if (N != null && N.H() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19398e.t0.f19512f).param("fid", L0.n()).param("obj_locate", 4).param("uid", N.H().getUserId()));
                                                    }
                                                    if (N != null) {
                                                        if (N.F1()) {
                                                            i5 = 2;
                                                        } else if (N.I1()) {
                                                            i5 = 3;
                                                        } else if (N.G1()) {
                                                            i5 = 4;
                                                        } else if (N.H1()) {
                                                            i5 = 5;
                                                        }
                                                        StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem11.param("tid", this.f19398e.t0.b1());
                                                        statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem11.param("fid", this.f19398e.t0.getForumId());
                                                        if (view.getId() != R.id.share_num_container) {
                                                            statisticItem11.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem11.param("obj_locate", 6);
                                                        }
                                                        statisticItem11.param("obj_name", i5);
                                                        statisticItem11.param("obj_type", 1);
                                                        if (N != null) {
                                                            if (N.F1()) {
                                                                statisticItem11.param("obj_type", 10);
                                                            } else if (N.I1()) {
                                                                statisticItem11.param("obj_type", 9);
                                                            } else if (N.H1()) {
                                                                statisticItem11.param("obj_type", 8);
                                                            } else if (N.G1()) {
                                                                statisticItem11.param("obj_type", 7);
                                                            } else if (N.v1) {
                                                                statisticItem11.param("obj_type", 6);
                                                            } else {
                                                                int i65 = N.Z;
                                                                if (i65 == 0) {
                                                                    statisticItem11.param("obj_type", 1);
                                                                } else if (i65 == 40) {
                                                                    statisticItem11.param("obj_type", 2);
                                                                } else if (i65 == 49) {
                                                                    statisticItem11.param("obj_type", 3);
                                                                } else if (i65 == 54) {
                                                                    statisticItem11.param("obj_type", 4);
                                                                } else {
                                                                    statisticItem11.param("obj_type", 5);
                                                                }
                                                            }
                                                            statisticItem11.param("card_type", N.M0());
                                                            statisticItem11.param("recom_source", N.T0);
                                                            statisticItem11.param("ab_tag", N.V0);
                                                            statisticItem11.param("weight", N.U0);
                                                            statisticItem11.param("extra", N.W0);
                                                            statisticItem11.param("nid", N.B0());
                                                            if (N.J() != null && !d.a.d.e.p.k.isEmpty(N.J().oriUgcVid)) {
                                                                statisticItem11.param(TiebaStatic.Params.OBJ_PARAM6, N.J().oriUgcVid);
                                                            }
                                                        }
                                                        if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem11.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.f19398e.z() != null) {
                                                            d.a.p0.l0.c.e(this.f19398e.z(), statisticItem11);
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                        if (d.a.d.e.p.l.D()) {
                                                            this.f19398e.showToast(R.string.neterror);
                                                            return;
                                                        } else if (L0 != null) {
                                                            ArrayList<PostData> E5 = this.f19398e.t0.L0().E();
                                                            if ((E5 != null && E5.size() > 0) || !this.f19398e.t0.Z0()) {
                                                                this.f19398e.A0.a0();
                                                                this.f19398e.t6();
                                                                if (L0.z() != null && !StringUtils.isNull(L0.z().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.f19398e.t0.L0().n()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.f19398e.getContext(), N)) {
                                                                    return;
                                                                }
                                                                if (this.f19398e.A0 != null) {
                                                                    this.f19398e.A0.c0();
                                                                    this.f19398e.A0.D3(L0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.f19398e.A0.g3();
                                                                    this.f19398e.t0.i0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view.getId() == R.id.pb_editor_tool_share) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                                    }
                                                                    this.f19398e.n6(i6);
                                                                }
                                                            } else {
                                                                d.a.d.e.p.l.M(this.f19398e.getPageContext().getPageActivity(), this.f19398e.getPageContext().getString(R.string.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            d.a.d.e.p.l.M(this.f19398e.getPageContext().getPageActivity(), this.f19398e.getPageContext().getString(R.string.pb_no_data_tips));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem112 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem112.param("tid", this.f19398e.t0.b1());
                                                    statisticItem112.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem112.param("fid", this.f19398e.t0.getForumId());
                                                    if (view.getId() != R.id.share_num_container) {
                                                    }
                                                    statisticItem112.param("obj_name", i5);
                                                    statisticItem112.param("obj_type", 1);
                                                    if (N != null) {
                                                    }
                                                    if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.f19398e.z() != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem112);
                                                    if (d.a.d.e.p.l.D()) {
                                                    }
                                                }
                                            } else if (d.a.d.e.p.j.z()) {
                                                this.f19398e.A0.a0();
                                                if (this.f19398e.A0.f58016h.n() != null && view == this.f19398e.A0.f58016h.n().j() && !this.f19398e.A0.z1()) {
                                                    this.f19398e.A0.j2();
                                                }
                                                if (!this.f19398e.m) {
                                                    this.f19398e.t6();
                                                    this.f19398e.A0.N2();
                                                    if (view.getId() == R.id.floor_owner_reply) {
                                                        l2 = this.f19398e.t0.l2(true, this.f19398e.E4());
                                                    } else {
                                                        l2 = view.getId() == R.id.reply_title ? this.f19398e.t0.l2(false, this.f19398e.E4()) : this.f19398e.t0.k2(this.f19398e.E4());
                                                    }
                                                    view.setTag(Boolean.valueOf(l2));
                                                    if (l2) {
                                                        i7 = 1;
                                                        this.f19398e.A0.y2(true);
                                                        this.f19398e.A0.q3();
                                                        this.f19398e.m = true;
                                                        this.f19398e.A0.B2(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.f19398e.showToast(R.string.network_not_available);
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (d.a.d.e.p.j.z()) {
                                            this.f19398e.A0.a0();
                                            if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19398e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f19398e.f4(11009) || this.f19398e.t0.e0(this.f19398e.A0.A0()) == null) {
                                                    return;
                                                }
                                                this.f19398e.A5();
                                                if (this.f19398e.t0.L0() != null && this.f19398e.t0.L0().N() != null && this.f19398e.t0.L0().N().H() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19398e.t0.f19512f).param("fid", this.f19398e.t0.L0().n()).param("obj_locate", 3).param("uid", this.f19398e.t0.L0().N().H().getUserId()));
                                                }
                                                if (this.f19398e.t0.L0().N() != null && this.f19398e.t0.L0().N().H() != null && this.f19398e.t0.L0().N().H().getUserId() != null && this.f19398e.v0 != null) {
                                                    PbFragment pbFragment8 = this.f19398e;
                                                    int Y4 = pbFragment8.Y4(pbFragment8.t0.L0());
                                                    d.a.p0.s.q.b2 N2 = this.f19398e.t0.L0().N();
                                                    if (N2.F1()) {
                                                        i8 = 2;
                                                    } else if (N2.I1()) {
                                                        i8 = 3;
                                                    } else if (N2.G1()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = N2.H1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19398e.t0.f19512f).param("obj_locate", 1).param("obj_id", this.f19398e.t0.L0().N().H().getUserId()).param("obj_type", !this.f19398e.v0.e()).param("obj_source", Y4).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.f19398e.X = view;
                                                return;
                                            }
                                        } else {
                                            this.f19398e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.f19398e.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.f19398e.t0.L0() != null && this.f19398e.t0.L0().N() != null && this.f19398e.t0.L0().N().s2() && this.f19398e.t0.L0().N().m1() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.f19398e.t0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.f19398e.t0.n0()) || this.f19398e.t0.d0() == null) {
                                                this.f19398e.f19309e.finish();
                                                return;
                                            }
                                            name2 = this.f19398e.t0.d0().f57432b;
                                        } else {
                                            name2 = this.f19398e.t0.L0().m().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.f19398e.f19309e.finish();
                                            return;
                                        }
                                        String n02 = this.f19398e.t0.n0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.f19398e.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.f19398e.t0.r0() && n02 != null && n02.equals(name2)) {
                                            this.f19398e.f19309e.finish();
                                        } else {
                                            this.f19398e.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (d.a.d.e.p.j.z()) {
                                    if (this.f19398e.t0.L0() == null || this.f19398e.w0.O()) {
                                        return;
                                    }
                                    this.f19398e.A0.a0();
                                    int i66 = (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().n()) ? (this.f19398e.A0.f58016h.n() == null || view != this.f19398e.A0.f58016h.n().m()) ? view == this.f19398e.A0.n0() ? 2 : 0 : this.f19398e.t0.L0().N().m0() == 1 ? 3 : 6 : this.f19398e.t0.L0().N().n0() == 1 ? 5 : 4;
                                    ForumData m = this.f19398e.t0.L0().m();
                                    String name3 = m.getName();
                                    String id2 = m.getId();
                                    String d0 = this.f19398e.t0.L0().N().d0();
                                    this.f19398e.A0.x3();
                                    this.f19398e.w0.S(id2, name3, d0, i66, this.f19398e.A0.o0());
                                } else {
                                    this.f19398e.showToast(R.string.network_not_available);
                                    return;
                                }
                            } else {
                                this.f19398e.A0.f58016h.l();
                                if (this.f19398e.t0 != null) {
                                    this.f19398e.p1.f(this.f19398e.t0.b1());
                                }
                                if (this.f19398e.t0 == null || !this.f19398e.t0.isPrivacy()) {
                                    this.f19398e.p1.b();
                                    int i67 = (TbSingleton.getInstance().mCanCallFans || this.f19398e.y() == null || this.f19398e.y().L0() == null || this.f19398e.y().L0().P() == null || !this.f19398e.y().L0().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.f19398e.y() != null && this.f19398e.y().L0() != null) {
                                        this.f19398e.p1.d(3, i67, this.f19398e.y().L0().P());
                                    }
                                } else {
                                    this.f19398e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                    if (this.f19398e.y() == null || this.f19398e.y().L0() == null) {
                                        return;
                                    }
                                    this.f19398e.p1.d(3, 3, this.f19398e.y().L0().P());
                                    return;
                                }
                            }
                        } else if (d.a.d.e.p.j.z()) {
                            this.f19398e.A0.a0();
                            this.f19398e.t6();
                            this.f19398e.A0.N2();
                            this.f19398e.A0.g3();
                            if (this.f19398e.A0.I0() != null) {
                                this.f19398e.A0.I0().setVisibility(8);
                            }
                            this.f19398e.t0.g2(1);
                            if (this.f19398e.f19313i != null) {
                                this.f19398e.f19313i.x();
                            }
                        } else {
                            this.f19398e.showToast(R.string.network_not_available);
                            return;
                        }
                    } else {
                        String str4 = (String) view.getTag(R.id.forum_name);
                        String str5 = (String) view.getTag(R.id.forum_id);
                        String str6 = (String) view.getTag(R.id.thread_id);
                        if (this.f19398e.T != null) {
                            this.f19398e.T.L(str4, str5);
                        }
                        d.a.q0.h2.k.e.g1.c.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), d.a.p0.l0.c.l(this.f19398e.getContext()).locatePage);
                    }
                    if (this.f19398e.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String D4 = this.f19398e.D4();
                        if (TextUtils.isEmpty(D4)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.f19398e.getPageContext(), new String[]{D4});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem12 = new StatisticItem("c13398");
                statisticItem12.param("tid", this.f19398e.t0.b1());
                statisticItem12.param("fid", this.f19398e.t0.getForumId());
                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem12.param("obj_locate", 1);
                TiebaStatic.log(statisticItem12);
                if (this.f19398e.A) {
                    this.f19398e.A = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.f19398e.t0 == null || this.f19398e.t0.L0() == null || this.f19398e.V4().J0() == null || postData7.t() == null || postData7.A() == 1 || !this.f19398e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f19398e.V4().K0() != null) {
                            this.f19398e.V4().K0().c();
                        }
                        d.a.q0.h2.h.r rVar2 = new d.a.q0.h2.h.r();
                        rVar2.A(this.f19398e.t0.L0().m());
                        rVar2.E(this.f19398e.t0.L0().N());
                        rVar2.C(postData7);
                        this.f19398e.V4().J0().R(rVar2);
                        this.f19398e.V4().J0().setPostId(postData7.E());
                        this.f19398e.y5(view, postData7.t().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        d.a.q0.h2.m.a.b(this.f19398e.t0.L0(), postData7, postData7.i0, 8, 1);
                        if (this.f19398e.P0 != null) {
                            this.f19398e.A0.r2(this.f19398e.P0.D());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q1 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f19403f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19404g;

        public q1(PbFragment pbFragment, MarkData markData, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19404g = pbFragment;
            this.f19402e = markData;
            this.f19403f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f19404g.A0 != null && this.f19404g.A0.V0() != null) {
                    this.f19404g.A0.V0().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.f19402e);
                    this.f19404g.f19309e.setResult(-1, intent);
                    this.f19403f.dismiss();
                    this.f19404g.u6();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q2 implements d.a.p0.b1.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19405a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19406b;

        public q2(PbFragment pbFragment, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19406b = pbFragment;
            this.f19405a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f19406b.getContext(), this.f19405a, shareItem, false));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19409g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19410h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19411i;

        public r(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19411i = pbFragment;
            this.f19407e = sparseArray;
            this.f19408f = z;
            this.f19409g = str;
            this.f19410h = str2;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f19411i.F0 != null) {
                    this.f19411i.F0.dismiss();
                }
                if (i2 == 0) {
                    this.f19411i.A0.S1(((Integer) this.f19407e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19407e.get(R.id.tag_del_post_id), ((Integer) this.f19407e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f19407e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f19407e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f19407e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f19407e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f19408f, this.f19409g, str, str2, str3, 1, this.f19410h, this.f19411i.d1);
                    userMuteAddAndDelCustomMessage.setTag(this.f19411i.d1);
                    this.f19411i.p6(this.f19408f, userMuteAddAndDelCustomMessage, this.f19410h, str, (String) this.f19407e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 implements d.a.p0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19412a;

        public r0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19412a = pbFragment;
        }

        @Override // d.a.p0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19412a.showProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r1 implements d.a.d.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19413a;

        public r1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19413a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
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
                    if (d.a.p0.s.k.c().g()) {
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
        @Override // d.a.d.e.k.c
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f19413a.getPageContext().getPageActivity());
                boolean g2 = d.a.p0.s.k.c().g();
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.I();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class r2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19414a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r2(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19414a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19414a.t0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f19414a.P0 != null) {
                this.f19414a.A0.r2(this.f19414a.P0.D());
            }
            this.f19414a.A0.j2();
            this.f19414a.A0.a0();
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19415a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19415a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12868c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.f19415a.getUniqueId() || AntiHelper.t(this.f19415a.getActivity(), updateAttentionMessage.getData().l, PbFragment.D2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f12866a) {
                    if (this.f19415a.A4().t() != null && this.f19415a.A4().t().getGodUserData() != null) {
                        this.f19415a.A4().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.f19415a.t0 == null || this.f19415a.t0.L0() == null || this.f19415a.t0.L0().N() == null || this.f19415a.t0.L0().N().H() == null) {
                        return;
                    }
                    this.f19415a.t0.L0().N().H().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19416a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f19416a.t0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f19416a.t0.f19512f)) {
                this.f19416a.m6((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s1 implements d.a.d.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19417a;

        public s1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19417a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
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
                if (d.a.p0.s.k.c().g()) {
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
        @Override // d.a.d.e.k.c
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f19417a.getPageContext().getPageActivity());
                boolean g2 = d.a.p0.s.k.c().g();
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
    }

    /* loaded from: classes4.dex */
    public interface s2 {
        boolean onBackPressed();
    }

    /* loaded from: classes4.dex */
    public class t extends d.a.p0.h0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19418c;

        public t(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19418c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.h0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f19418c.f19309e.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.s(this.f19418c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19419a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19420e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ t0 f19421f;

            public a(t0 t0Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19421f = t0Var;
                this.f19420e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19421f.f19419a.A0 == null || this.f19420e == null) {
                    return;
                }
                this.f19421f.f19419a.A0.y3();
                this.f19421f.f19419a.A0.X1(this.f19420e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(t0 t0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t0 f19422e;

            public c(t0 t0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19422e = t0Var;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19422e.f19419a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19422e.f19419a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public t0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19419a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.p0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19419a.t0.L0() != null) {
                        statisticItem.param("fid", this.f19419a.t0.L0().n());
                    }
                    statisticItem.param("tid", this.f19419a.t0.b1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f19419a.t6();
                this.f19419a.A0.L2(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.f19419a.m6(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.f19419a.c6(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.f19419a.t0.q0()) {
                            d.a.q0.h2.h.e L0 = this.f19419a.t0.L0();
                            if (L0 != null && L0.N() != null && L0.N().H() != null && (userId = L0.N().H().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f19419a.t0.j2()) {
                                this.f19419a.A0.N2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.f19419a.t0.j2()) {
                            this.f19419a.A0.N2();
                        }
                    } else if (floor != null) {
                        this.f19419a.A0.n1(this.f19419a.t0.L0());
                    }
                    if (this.f19419a.t0.t0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.f19419a.t0.b1()));
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.d.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.f19419a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.b4(z2);
                } else if (i2 == 220015) {
                    this.f19419a.showToast(str);
                    if (this.f19419a.P0.C() || this.f19419a.P0.E()) {
                        this.f19419a.P0.A(false, postWriteCallBackData);
                    }
                    this.f19419a.E0.k(postWriteCallBackData);
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19419a.S0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19419a.getActivity(), this.f19419a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19419a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f19419a.getActivity());
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19419a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19419a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (d.a.q0.r3.a.c(i2) || k0Var != null || i2 == 227001) {
                } else {
                    this.f19419a.b6(i2, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t1 implements d.a.d.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19423a;

        public t1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19423a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                ((PlayVoiceBntNew) view).l();
                return view;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).k();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f19423a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f19423a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).k();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface t2 {
        void a(Object obj);
    }

    /* loaded from: classes4.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f19424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19425f;

        public u(PbFragment pbFragment, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19425f = pbFragment;
            this.f19424e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.h2.k.e.t0 t0Var = this.f19425f.A0;
                t0Var.Q2(TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f19424e.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19426a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19427e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ u0 f19428f;

            public a(u0 u0Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {u0Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19428f = u0Var;
                this.f19427e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19428f.f19426a.A0 == null || this.f19427e == null) {
                    return;
                }
                this.f19428f.f19426a.A0.y3();
                this.f19428f.f19426a.A0.X1(this.f19427e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(u0 u0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {u0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u0 f19429e;

            public c(u0 u0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {u0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19429e = u0Var;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19429e.f19426a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19429e.f19426a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public u0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19426a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.p0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19426a.t0 != null && this.f19426a.t0.L0() != null) {
                        statisticItem.param("fid", this.f19426a.t0.L0().n());
                    }
                    if (this.f19426a.t0 != null) {
                        statisticItem.param("tid", this.f19426a.t0.b1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    d.a.q0.h2.k.e.v0 v0Var = this.f19426a.E0;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d.a.p0.t.h.b.a(this.f19426a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.d.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19426a.S0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19426a.getActivity(), this.f19426a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19426a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f19426a.getActivity());
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19426a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19426a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.f19426a;
                if (pbFragment.E0 == null) {
                    return;
                }
                if (pbFragment.A0 != null && this.f19426a.A0.K0() != null && this.f19426a.A0.K0().b() != null && this.f19426a.A0.K0().b().x()) {
                    this.f19426a.A0.K0().b().v(postWriteCallBackData);
                }
                this.f19426a.E0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u1 implements d.a.d.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19430a;

        public u1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19430a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
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
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f19430a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface u2 {
    }

    /* loaded from: classes4.dex */
    public class v implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19431e;

        public v(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19431e = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.f19431e.t0 != null && this.f19431e.t0.x0()) {
                    this.f19431e.z5();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class v0 extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19432a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(PbFragment pbFragment, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19432a = pbFragment;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView T0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.f19432a.f19309e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    d.a.d.e.p.l.L(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (this.f19432a.A0 == null || (T0 = this.f19432a.A0.T0()) == null || this.f19432a.A0.B0() == null) {
                        return;
                    }
                    this.f19432a.A0.B0().removeHeaderView(T0);
                    return;
                }
                d.a.d.e.p.l.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v1 implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19433a;

        public v1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19433a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            d.a.q0.h2.k.e.i l0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.f19433a.checkUpIsLogin()) {
                            this.f19433a.A0.J1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f19433a.t0.b1());
                    statisticItem.param("fid", this.f19433a.t0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.f19433a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.f19433a.t0.J.e0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view.getParent();
                            } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view.getParent().getParent();
                            }
                            int i4 = -1;
                            if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().A() == null) {
                                i3 = -1;
                            } else {
                                ArrayList<TbRichTextImageInfo> A = tbRichTextView.getRichText().A();
                                int i5 = 0;
                                int i6 = -1;
                                while (i5 < A.size()) {
                                    if (A.get(i5) != null) {
                                        arrayList.add(A.get(i5).B());
                                        if (i6 == i4 && str != null && (str.equals(A.get(i5).B()) || str.equals(A.get(i5).y()) || str.equals(A.get(i5).w()) || str.equals(A.get(i5).x()) || str.equals(A.get(i5).A()))) {
                                            i6 = i5;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = A.get(i5).B();
                                        imageUrlData.originalUrl = A.get(i5).B();
                                        imageUrlData.isLongPic = A.get(i5).E();
                                        concurrentHashMap.put(A.get(i5).B(), imageUrlData);
                                    }
                                    i5++;
                                    i4 = -1;
                                }
                                i3 = i6;
                            }
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            this.f19433a.w4(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.f19433a.t0.W0());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.f19433a.o5());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.f19433a.t0 != null) {
                                bVar.A(this.f19433a.t0.getFromForumId());
                                if (this.f19433a.t0.L0() != null) {
                                    bVar.N(this.f19433a.t0.L0().N());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.f19433a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.f19433a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.f19433a.H5(str, i2, eVar);
                        if (eVar.f19268h) {
                            TbRichText A6 = this.f19433a.A6(str, i2);
                            if (A6 != null && this.f19433a.l2 >= 0 && this.f19433a.l2 < A6.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a2 = d.a.q0.h2.h.f.a(A6.y().get(this.f19433a.l2));
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= eVar.f19261a.size()) {
                                        break;
                                    } else if (eVar.f19261a.get(i7).equals(a2)) {
                                        eVar.j = i7;
                                        arrayList2.add(a2);
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                                if (A6.getPostId() != 0 && (l0 = this.f19433a.A0.l0()) != null) {
                                    ArrayList<d.a.d.k.e.n> s = l0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<d.a.d.k.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            d.a.d.k.e.n next = it.next();
                                            if ((next instanceof PostData) && A6.getPostId() == d.a.d.e.m.b.f(((PostData) next).E(), 0L)) {
                                                d.a.q0.h2.m.a.b(this.f19433a.t0.L0(), (PostData) next, ((PostData) next).i0, A6.getPostId() == d.a.d.e.m.b.f(this.f19433a.t0.m0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f19262b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.f19433a.w4(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f19263c);
                                bVar2.y(eVar.f19264d);
                                bVar2.O(eVar.f19265e);
                                bVar2.C(eVar.f19267g);
                                bVar2.H(true);
                                bVar2.J(eVar.f19269i);
                                bVar2.F(this.f19433a.t0.W0());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.f19433a.o5());
                                bVar2.L(eVar.f19266f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.f19433a.t0 != null) {
                                    bVar2.A(this.f19433a.t0.getFromForumId());
                                    if (this.f19433a.t0.L0() != null) {
                                        bVar2.N(this.f19433a.t0.L0().N());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.f19433a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.f19433a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.f19261a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.f19262b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f19263c);
                        bVar3.y(eVar.f19264d);
                        bVar3.O(eVar.f19265e);
                        bVar3.C(eVar.f19267g);
                        bVar3.H(true);
                        bVar3.J(eVar.f19261a.get(0));
                        bVar3.F(this.f19433a.t0.W0());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.f19433a.o5());
                        bVar3.L(eVar.f19266f);
                        bVar3.D(false);
                        if (this.f19433a.t0 != null) {
                            bVar3.A(this.f19433a.t0.getFromForumId());
                            if (this.f19433a.t0.L0() != null) {
                                bVar3.N(this.f19433a.t0.L0().N());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.f19433a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.f19433a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean w = ((TbImageView) view).w();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.f19433a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f19433a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                    }
                    this.f19433a.U = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19434a;

        public w(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19434a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f19434a.P0.M(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f19434a.A0 != null && this.f19434a.A0.K0() != null && this.f19434a.A0.K0().b() != null) {
                    this.f19434a.A0.K0().b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.f19434a;
                    pbFragment.R5(pbFragment.V0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19435a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19436e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19437f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ w0 f19438g;

            public a(w0 w0Var, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19438g = w0Var;
                this.f19436e = i2;
                this.f19437f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19438g.f19435a.getListView() == null) {
                    return;
                }
                this.f19438g.f19435a.getListView().setSelectionFromTop(this.f19436e, this.f19437f);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19439e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f19440f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f19441g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ w0 f19442h;

            public b(w0 w0Var, int i2, boolean z, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19442h = w0Var;
                this.f19439e = i2;
                this.f19440f = z;
                this.f19441g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19439e == -1 || this.f19442h.f19435a.getListView() == null) {
                    return;
                }
                if (this.f19440f) {
                    this.f19442h.f19435a.A0.S2(this.f19439e, this.f19441g);
                } else {
                    this.f19442h.f19435a.A0.S2(this.f19439e - 1, this.f19441g);
                }
            }
        }

        public w0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19435a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && d.a.p0.o0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.f19435a.r : j;
                if (this.f19435a.s == 0) {
                    this.f19435a.s = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                d.a.p0.o0.h hVar = new d.a.p0.o0.h(i2, z, responsedMessage, this.f19435a.v, this.f19435a.u, this.f19435a.s, z2, 0L, 0L, j3);
                this.f19435a.u = 0L;
                this.f19435a.v = 0L;
                hVar.c();
                if (z2) {
                    j2 = j3;
                    hVar.B = j2;
                    hVar.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.f19435a.t0 == null || this.f19435a.t0.L0() == null || this.f19435a.t0.L0().N() == null) {
                    return;
                }
                int k1 = this.f19435a.t0.L0().N().k1();
                if (k1 == 0 || k1 == 40) {
                    if (!StringHelper.equals(this.f19435a.O, "from_personalize")) {
                        if (StringHelper.equals(this.f19435a.O, "from_frs")) {
                            d.a.p0.o0.h hVar2 = new d.a.p0.o0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(k1);
                            return;
                        }
                        return;
                    }
                    d.a.p0.o0.d dVar = new d.a.p0.o0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(k1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.q0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f19435a.A0.n1(eVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
            d.a.p0.x.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                if (!z || eVar == null || eVar.V() != null || ListUtils.getCount(eVar.E()) >= 1) {
                    this.f19435a.l = true;
                    this.f19435a.A0.M2();
                    if (eVar == null || !eVar.i0()) {
                        PbFragment pbFragment = this.f19435a;
                        pbFragment.hideLoadingView(pbFragment.A0.V0());
                    }
                    this.f19435a.A0.d1();
                    if (this.f19435a.L || this.f19435a.A0.z1()) {
                        this.f19435a.A0.X0();
                    } else if (!this.f19435a.A0.s1()) {
                        this.f19435a.A0.Z2(false);
                    }
                    if (this.f19435a.m) {
                        this.f19435a.m = false;
                    }
                    if (i5 == 0 && eVar != null) {
                        this.f19435a.I0 = true;
                    }
                    if (eVar != null) {
                        PbFragment pbFragment2 = this.f19435a;
                        pbFragment2.hideNetRefreshView(pbFragment2.A0.V0());
                        this.f19435a.A0.W2();
                    }
                    ArrayList<PostData> arrayList = null;
                    String N0 = null;
                    arrayList = null;
                    if (z && eVar != null) {
                        d.a.p0.s.q.b2 N = eVar.N();
                        if (N != null && N.r2()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.f19435a;
                            pbFragment3.X5(pbFragment3.O0);
                        }
                        this.f19435a.A0.K0().l(eVar);
                        this.f19435a.A0.f3();
                        if (N != null && N.K() != null) {
                            this.f19435a.y6(N.K());
                        }
                        if (this.f19435a.P0 != null) {
                            this.f19435a.A0.r2(this.f19435a.P0.D());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(eVar.T().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.T().getBimg_end_time());
                        if (eVar.E() != null && eVar.E().size() >= 1 && eVar.E().get(0) != null) {
                            this.f19435a.t0.V1(eVar.E().get(0).E());
                        } else if (eVar.V() != null) {
                            this.f19435a.t0.V1(eVar.V().E());
                        }
                        if (this.f19435a.P0 != null) {
                            this.f19435a.P0.N(eVar.d());
                            this.f19435a.P0.O(eVar.m(), eVar.T());
                            this.f19435a.P0.s0(N);
                            this.f19435a.P0.P(this.f19435a.t0.p0(), this.f19435a.t0.b1(), this.f19435a.t0.m0());
                            if (N != null) {
                                this.f19435a.P0.i0(N.c2());
                            }
                        }
                        if (this.f19435a.v0 != null) {
                            this.f19435a.v0.h(eVar.s());
                        }
                        if (eVar.t() == 1) {
                            this.f19435a.w = true;
                        } else {
                            this.f19435a.w = false;
                        }
                        if (eVar.e0()) {
                            this.f19435a.w = true;
                        }
                        this.f19435a.A0.s2(this.f19435a.w);
                        this.f19435a.A0.j3(eVar, i3, i4, this.f19435a.t0.Z0(), i5, this.f19435a.t0.v0());
                        this.f19435a.A0.u3(eVar, this.f19435a.t0.Z0());
                        this.f19435a.A0.A3(this.f19435a.t0.q0());
                        AntiData d2 = eVar.d();
                        if (d2 != null) {
                            this.f19435a.D = d2.getVoice_message();
                            if (!StringUtils.isNull(this.f19435a.D) && this.f19435a.P0 != null && this.f19435a.P0.a() != null && (m = this.f19435a.P0.a().m(6)) != null && !TextUtils.isEmpty(this.f19435a.D)) {
                                ((View) m).setOnClickListener(this.f19435a.A1);
                            }
                        }
                        if (this.f19435a.K0) {
                            this.f19435a.K0 = false;
                            int C4 = this.f19435a.C4();
                            if (!eVar.l0()) {
                                this.f19435a.A0.T2(C4);
                            } else {
                                d.a.d.e.m.e.a().post(new a(this, C4, (int) (d.a.d.e.p.l.k(this.f19435a.getContext()) * 0.5625d)));
                            }
                        }
                        if (!this.f19435a.a0 && !ListUtils.isEmpty(this.f19435a.t0.L0().E()) && !this.f19435a.t0.l1()) {
                            this.f19435a.a0 = true;
                            this.f19435a.d4(false);
                        }
                        if (this.f19435a.L0) {
                            this.f19435a.L0 = false;
                            int C42 = this.f19435a.C4();
                            boolean z2 = C42 != -1;
                            if (!z2) {
                                C42 = this.f19435a.z4();
                            }
                            if (this.f19435a.A0 != null) {
                                if (!eVar.l0()) {
                                    this.f19435a.A0.T2(C42);
                                } else {
                                    d.a.d.e.m.e.a().post(new b(this, C42, z2, (int) (d.a.d.e.p.l.k(this.f19435a.getContext()) * 0.5625d)));
                                    this.f19435a.A0.t2(true);
                                    this.f19435a.A0.Z2(false);
                                }
                            }
                        } else if (this.f19435a.M0) {
                            this.f19435a.M0 = false;
                            this.f19435a.A0.S2(0, 0);
                        } else {
                            this.f19435a.A0.e3();
                        }
                        this.f19435a.t0.t1(eVar.m(), this.f19435a.E1);
                        this.f19435a.t0.z1(this.f19435a.G1);
                        if (this.f19435a.S0 != null && N != null && N.H() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(N.H());
                            this.f19435a.S0.setLikeUserData(attentionHostData);
                        }
                        if (this.f19435a.t0 == null || !this.f19435a.t0.k1()) {
                            if (this.f19435a.A0 != null) {
                                N0 = this.f19435a.A0.N0();
                            }
                        } else {
                            N0 = this.f19435a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        }
                        if (!StringUtils.isNull(N0)) {
                            this.f19435a.P0.l0(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), N0));
                        }
                    } else if (str != null) {
                        if (this.f19435a.I0 || i5 != 1) {
                            this.f19435a.showToast(str);
                        } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                            if (i2 == 4) {
                                if (this.f19435a.t0.d0() != null && !StringUtils.isNull(this.f19435a.t0.d0().f57433c)) {
                                    this.f19435a.A0.C3(this.f19435a.t0.d0());
                                } else {
                                    PbFragment pbFragment4 = this.f19435a;
                                    pbFragment4.showNetRefreshView(pbFragment4.A0.V0(), this.f19435a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                    PbFragment pbFragment5 = this.f19435a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(d.a.d.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment pbFragment6 = this.f19435a;
                                pbFragment6.showNetRefreshView(pbFragment6.A0.V0(), this.f19435a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment7 = this.f19435a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(d.a.d.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                            }
                            this.f19435a.A0.X0();
                            this.f19435a.A0.W0();
                        }
                        if (i2 == 4 || i2 == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.f19435a.t0.b1());
                                jSONObject.put("fid", this.f19435a.t0.getForumId());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        }
                        if (i2 != 0) {
                            EnterForePvThread enterForePvThread = new EnterForePvThread();
                            enterForePvThread.setOpType("2");
                            enterForePvThread.start();
                        }
                        if (i2 != -1) {
                            if (this.f19435a.t0 != null && this.f19435a.t0.L0() != null) {
                                arrayList = this.f19435a.t0.L0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19435a.A0.o2(this.f19435a.getResources().getString(R.string.list_no_more_new));
                            } else {
                                if (this.f19435a.o5()) {
                                    this.f19435a.A0.p2(this.f19435a.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    this.f19435a.A0.p2(this.f19435a.getResources().getString(R.string.pb_no_replay));
                                }
                                this.f19435a.A0.n1(this.f19435a.t0.L0());
                            }
                        } else {
                            this.f19435a.A0.o2("");
                        }
                        this.f19435a.A0.g0();
                    }
                    if (eVar != null && eVar.m && this.f19435a.s == 0) {
                        this.f19435a.s = System.currentTimeMillis() - this.f19435a.r;
                    }
                    if (this.f19435a.y().Z0() && this.f19435a.y().L0().x().c() == 0 && !this.f19435a.y().j1()) {
                        return;
                    }
                    this.f19435a.Q0 = true;
                    return;
                }
                this.f19435a.t0.g2(1);
                if (this.f19435a.f19313i != null) {
                    this.f19435a.f19313i.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f19435a.t0 == null) {
                return;
            }
            if (this.f19435a.P0 == null || !this.f19435a.P0.z) {
                d.a.p0.x.w.d dVar = new d.a.p0.x.w.d();
                this.f19435a.X5(dVar);
                PbFragment pbFragment = this.f19435a;
                pbFragment.P0 = (d.a.p0.x.w.e) dVar.a(pbFragment.getContext());
                this.f19435a.P0.f0(this.f19435a.f19309e.getPageContext());
                this.f19435a.P0.o0(this.f19435a.Y1);
                this.f19435a.P0.p0(this.f19435a.W0);
                this.f19435a.P0.G(this.f19435a.f19309e.getPageContext(), this.f19435a.f19309e.getIntent() == null ? null : this.f19435a.f19309e.getIntent().getExtras());
                this.f19435a.P0.a().C(true);
                this.f19435a.A0.n2(this.f19435a.P0.a());
                if (!this.f19435a.t0.z0()) {
                    this.f19435a.P0.t(this.f19435a.t0.b1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.f19435a.P0.l0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.f19435a.t0.k1()) {
                    this.f19435a.P0.l0(this.f19435a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (this.f19435a.A0 != null) {
                    this.f19435a.P0.l0(this.f19435a.A0.N0());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w1 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19443a;

        public w1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19443a = pbFragment;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                PbFragment pbFragment = this.f19443a;
                PostData postData = pbFragment.o2;
                if (postData != null) {
                    if (i2 == 0) {
                        postData.h0(pbFragment.getPageContext().getPageActivity());
                        this.f19443a.o2 = null;
                    } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.f19443a;
                        pbFragment2.C5(pbFragment2.o2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19444a;

        public x(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19444a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) {
                this.f19444a.A0.b1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i2 == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.f19444a.n6(num.intValue());
                    } else if (i2 == 1990055) {
                        TiebaStatic.log("c12142");
                        d.a.q0.b1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.f19444a.getResources().getString(R.string.neterror);
                        }
                        this.f19444a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(PbFragment pbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19445a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f19445a.x6();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x1 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19446a;

        public x1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19446a = pbFragment;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f19446a.g1 == null || TextUtils.isEmpty(this.f19446a.h1)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f19446a.i1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f19446a.h1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f52031a = this.f19446a.h1;
                        String str = "";
                        if (this.f19446a.i1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f19446a.i1.memeInfo.pck_id;
                        }
                        aVar.f52032b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f19446a.R0 == null) {
                        this.f19446a.R0 = new PermissionJudgePolicy();
                    }
                    this.f19446a.R0.clearRequestPermissionList();
                    this.f19446a.R0.appendRequestPermission(this.f19446a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (this.f19446a.R0.startRequestPermission(this.f19446a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f19446a.f1 == null) {
                        PbFragment pbFragment = this.f19446a;
                        pbFragment.f1 = new d.a.q0.h2.k.e.x0(pbFragment.getPageContext());
                    }
                    this.f19446a.f1.b(this.f19446a.h1, this.f19446a.g1.n());
                }
                this.f19446a.g1 = null;
                this.f19446a.h1 = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19447a;

        public y(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19447a = pbFragment;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19448a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(PbFragment pbFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19448a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f19448a.A0 != null) {
                    PbFragment pbFragment = this.f19448a;
                    pbFragment.hideLoadingView(pbFragment.A0.V0());
                    this.f19448a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.f19448a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.f19448a.getString(R.string.block_user_success));
                            bdTopToast.j((ViewGroup) this.f19448a.getView());
                            this.f19448a.Y5(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f19448a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.f19448a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.f19448a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y1 implements s2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19449a;

        public y1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19449a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.s2
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f19449a.A0 != null && this.f19449a.A0.K0() != null) {
                    d.a.q0.h2.k.e.u K0 = this.f19449a.A0.K0();
                    if (K0.f()) {
                        K0.d();
                        return true;
                    }
                }
                if (this.f19449a.A0 == null || !this.f19449a.A0.B1()) {
                    return false;
                }
                this.f19449a.A0.f1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z implements t2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19450a;

        public z(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19450a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.t2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!d.a.d.e.p.j.z()) {
                    this.f19450a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f19450a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19450a.getPageContext().getPageActivity(), this.f19450a.t0.L0().m().getId(), this.f19450a.t0.L0().m().getName(), this.f19450a.t0.L0().N().d0(), String.valueOf(this.f19450a.t0.L0().T().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements a.InterfaceC1202a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19451a;

        public z0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19451a = pbFragment;
        }

        @Override // d.a.p0.i.a.InterfaceC1202a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f19451a.A0.M2();
                if (z) {
                    if (this.f19451a.v0 != null) {
                        this.f19451a.v0.h(z2);
                    }
                    this.f19451a.t0.i2(z2);
                    if (this.f19451a.t0.x0()) {
                        this.f19451a.z5();
                    } else {
                        this.f19451a.A0.n1(this.f19451a.t0.L0());
                    }
                    if (z2) {
                        if (this.f19451a.v0 != null) {
                            if (this.f19451a.v0.f() == null || this.f19451a.t0 == null || this.f19451a.t0.L0() == null || this.f19451a.t0.L0().N() == null || this.f19451a.t0.L0().N().H() == null) {
                                return;
                            }
                            MarkData f2 = this.f19451a.v0.f();
                            MetaData H = this.f19451a.t0.L0().N().H();
                            if (f2 != null && H != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), H.getUserId()) && !H.hadConcerned()) {
                                    this.f19451a.i6(H);
                                } else {
                                    this.f19451a.showToast(R.string.add_mark_on_pb);
                                    if (d.a.p0.t.h.a.e(this.f19451a.getContext(), 0)) {
                                        d.a.p0.t.h.a.g(this.f19451a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.f19451a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f19451a.a4();
                        return;
                    }
                    PbFragment pbFragment2 = this.f19451a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.f19451a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z1 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19452e;

        public z1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19452e = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19452e.t0 == null || this.f19452e.t0.U0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = this.f19452e;
            pbFragment.V5(pbFragment.T4(i2));
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
        D2 = new g0();
        E2 = new h2();
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
        this.f19310f = true;
        this.f19311g = false;
        this.k = false;
        this.l = false;
        this.n = true;
        this.p = 0;
        this.q = null;
        this.r = -1L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.x = false;
        this.y = null;
        this.z = 0L;
        this.A = false;
        this.B = 0L;
        this.C = 1;
        this.D = null;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = "";
        this.P = true;
        this.Q = false;
        this.R = "";
        this.Z = 3;
        this.b0 = new int[2];
        this.i0 = -1;
        this.j0 = -1;
        this.l0 = BdUniqueId.gen();
        this.n0 = false;
        this.p0 = d.a.p0.b.d.p0();
        this.r0 = new k(this);
        this.s0 = new Handler(new v(this));
        this.t0 = null;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = false;
        this.C0 = false;
        this.D0 = false;
        this.I0 = false;
        this.K0 = false;
        this.L0 = false;
        this.M0 = false;
        this.W0 = new r0(this);
        this.X0 = new c1(this);
        this.Y0 = new n1(this);
        this.Z0 = 0;
        this.j1 = false;
        this.k1 = 0;
        this.l1 = -1;
        this.n1 = 0;
        this.q1 = new y1(this);
        this.r1 = new j2(this);
        this.s1 = new r2(this, 2004016);
        this.t1 = new a(this, 2016485);
        this.u1 = new b(this, 2001269);
        this.v1 = new c(this, 2004008);
        this.w1 = new d(this, 2004007);
        this.x1 = new e(this, 2004005);
        this.y1 = new f(this, 2001332);
        this.z1 = new g(this, 2921391);
        this.A1 = new h(this);
        this.B1 = new i(this, 2001369);
        this.C1 = new j(this, 2016488);
        this.D1 = new l(this, 2016331);
        this.E1 = new m(this);
        this.F1 = new n(this, 2921509);
        this.G1 = new o(this);
        this.I1 = new PraiseModel(getPageContext(), new p(this));
        this.J1 = new q(this);
        this.K1 = new s(this, 2001115);
        this.L1 = new t(this);
        this.M1 = new x(this);
        this.N1 = new d.a.q0.h2.i.c(new a0(this));
        this.O1 = new c0(this, 2001427);
        this.P1 = new d0(this, 2001428);
        this.Q1 = new e0(this, 2001426);
        this.R1 = new f0(this, 2004021);
        this.S1 = new h0(this, 2921033);
        this.T1 = new i0(this);
        this.U1 = new j0(this);
        this.V1 = new n0(this);
        this.W1 = new q0(this);
        this.X1 = new s0(this, 2921480);
        this.Y1 = new t0(this);
        this.Z1 = new u0(this);
        this.a2 = new v0(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.b2 = new w0(this);
        this.c2 = new x0(this, 2016450);
        this.d2 = new y0(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.e2 = new z0(this);
        this.f2 = new d1(this);
        this.g2 = new g1(this);
        this.h2 = new i1(this);
        this.i2 = new j1(this);
        this.k2 = new k1(this);
        this.l2 = 0;
        this.m2 = new v1(this);
        this.n2 = false;
        this.o2 = null;
        this.p2 = new w1(this);
        this.q2 = new x1(this);
        this.r2 = new z1(this);
        this.s2 = new a2(this);
        this.t2 = new b2(this);
        this.u2 = new c2(this);
        this.v2 = new d2(this);
        this.w2 = new f2(this);
        this.x2 = new g2(this);
        this.y2 = new i2(this);
        this.z2 = -1;
        this.A2 = -1;
    }

    public static PbFragment E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public PostData A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            PbModel pbModel = this.t0;
            return t0Var.t0(pbModel.J, pbModel.Z0());
        }
        return (PostData) invokeV.objValue;
    }

    public final void A5() {
        MarkData e02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.v0 == null) {
            return;
        }
        if (this.t0.L0() != null && this.t0.L0().e0()) {
            e02 = this.t0.e0(0);
        } else {
            e02 = this.t0.e0(this.A0.A0());
        }
        if (e02 == null) {
            return;
        }
        if (e02.isApp() && (e02 = this.t0.e0(this.A0.A0() + 1)) == null) {
            return;
        }
        this.A0.N2();
        this.v0.i(e02);
        if (!this.v0.e()) {
            this.v0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.v0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final TbRichText A6(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i3)) == null) {
            PbModel pbModel = this.t0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.L0() == null || str == null || i3 < 0) {
                return null;
            }
            d.a.q0.h2.h.e L0 = this.t0.L0();
            if (L0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(L0.j());
                tbRichText = F4(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> E = L0.E();
                c4(L0, E);
                return F4(E, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public String B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.O : (String) invokeV.objValue;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            C5(postData);
        }
    }

    public int C4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (V4() != null && V4().B0() != null) {
                BdTypeListView B0 = V4().B0();
                List<d.a.d.k.e.n> data = B0.getData();
                int headerViewsCount = B0.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d.a.d.k.e.n nVar = data.get(i3);
                        if ((nVar instanceof d.a.q0.h2.h.o) && ((d.a.q0.h2.h.o) nVar).f57475f == d.a.q0.h2.h.o.m) {
                            return i3 + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void C5(PostData postData) {
        PostData A4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.E() != null && postData.E().equals(this.t0.G0())) {
            z2 = true;
        }
        MarkData F0 = this.t0.F0(postData);
        if (this.t0.L0() != null && this.t0.L0().e0() && (A4 = A4()) != null) {
            F0 = this.t0.F0(A4);
        }
        if (F0 == null) {
            return;
        }
        this.A0.N2();
        d.a.p0.i.a aVar = this.v0;
        if (aVar != null) {
            aVar.i(F0);
            if (!z2) {
                this.v0.a();
            } else {
                this.v0.d();
            }
        }
    }

    public final String D4() {
        InterceptResult invokeV;
        d.a.q0.h2.h.e L0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || (L0 = pbModel.L0()) == null) {
                return null;
            }
            return L0.S().f57502c;
        }
        return (String) invokeV.objValue;
    }

    public final boolean D5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p3 = d.a.p0.s.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    d.a.p0.m.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String E4() {
        InterceptResult invokeV;
        ArrayList<PostData> E;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.L0() == null || this.t0.L0().E() == null || (count = ListUtils.getCount((E = this.t0.L0().E()))) == 0) {
                return "";
            }
            if (this.t0.W0()) {
                Iterator<PostData> it = E.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int s02 = this.A0.s0();
            PostData postData = (PostData) ListUtils.getItem(E, s02);
            if (postData != null && postData.t() != null) {
                if (this.t0.s1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = s02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(E, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (this.t0.s1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = s02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(E, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (this.t0.s1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final TbRichText F4(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText K = arrayList.get(i4).K();
                    if (K != null && (y2 = K.y()) != null) {
                        int size = y2.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (y2.get(i6) != null && y2.get(i6).getType() == 8) {
                                i5++;
                                if (y2.get(i6).B().y().equals(str) || y2.get(i6).B().z().equals(str)) {
                                    int h3 = (int) d.a.d.e.p.l.h(TbadkCoreApplication.getInst());
                                    int width = y2.get(i6).B().getWidth() * h3;
                                    int height = y2.get(i6).B().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.l2 = i6;
                                    return K;
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

    public final void F5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!d.a.d.e.p.j.z()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.A0.a0();
            if (this.m) {
                return;
            }
            t6();
            this.A0.N2();
            if (this.t0.LoadData()) {
                this.A0.q3();
            }
        }
    }

    public final int G4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.n2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.y().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.y().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) d.a.d.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.B().getWidth() * h3;
                        int height = tbRichTextData.B().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.B().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a3 = d.a.q0.h2.h.f.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a3)) {
                                arrayList.add(a3);
                                if (tbRichTextData != null && (B = tbRichTextData.B()) != null) {
                                    String y2 = B.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y2 = B.z();
                                    } else {
                                        imageUrlData.urlType = this.w ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y2;
                                    imageUrlData.originalUrl = P4(tbRichTextData);
                                    imageUrlData.originalSize = Q4(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = K4(tbRichTextData);
                                    imageUrlData.isLongPic = I4(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = d.a.d.e.m.b.f(this.t0.b1(), -1L);
                                    imageUrlData.mIsReserver = this.t0.W0();
                                    imageUrlData.mIsSeeHost = this.t0.q0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a3, imageUrlData);
                                    }
                                }
                            }
                            if (!this.n2) {
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

    public void G5() {
        PbModel pbModel;
        d.a.q0.h2.h.e L0;
        d.a.p0.s.q.b2 N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbModel = this.t0) == null || pbModel.L0() == null || (N = (L0 = this.t0.L0()).N()) == null || N.H() == null) {
            return;
        }
        this.A0.Z0();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.H().getUserId());
        d.a.q0.h2.k.e.g0 g0Var = new d.a.q0.h2.k.e.g0();
        int U = this.t0.L0().U();
        if (U != 1 && U != 3) {
            g0Var.f57858g = false;
        } else {
            g0Var.f57858g = true;
            g0Var.r = N.n0() == 1;
        }
        if (q5(U)) {
            g0Var.f57859h = true;
            g0Var.q = N.m0() == 1;
        } else {
            g0Var.f57859h = false;
        }
        if (U == 1002 && !equals) {
            g0Var.t = true;
        }
        g0Var.f57856e = f6(equals);
        g0Var.f57860i = h6();
        g0Var.f57857f = g6(equals);
        g0Var.k = equals && L0.T() != null && L0.T().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            g0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().c();
        }
        g0Var.s = equals;
        g0Var.p = this.t0.Z0();
        g0Var.f57853b = true;
        g0Var.f57852a = s5(equals);
        if (equals) {
            this.A0.o1();
        }
        g0Var.o = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.n = this.t0.q0();
        g0Var.f57855d = true;
        if (N.m1() == null) {
            g0Var.f57854c = true;
        } else {
            g0Var.f57854c = false;
        }
        if (L0.e0()) {
            g0Var.f57853b = false;
            g0Var.f57855d = false;
            g0Var.f57854c = false;
            g0Var.f57858g = false;
            g0Var.f57859h = false;
        }
        g0Var.u = TbSingleton.getInstance().mShowCallFans && equals && !L0.e0();
        d.a.q0.h2.k.e.t0 t0Var = this.A0;
        if (t0Var != null) {
            PbModel pbModel2 = this.t0;
            PostData t02 = t0Var.t0(pbModel2.J, pbModel2.Z0());
            g0Var.v = t02 != null ? t02.S : false;
        }
        g0Var.m = true;
        if (d.a.p0.e1.b.e.d()) {
            g0Var.f57855d = false;
            g0Var.f57853b = false;
            g0Var.f57854c = false;
            g0Var.m = false;
        }
        this.A0.f58016h.F(g0Var);
    }

    @Override // d.a.q0.h2.o.b
    public PbFragment H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public PbInterviewStatusView.f H4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.r0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final void H5(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048592, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        d.a.q0.h2.h.e L0 = this.t0.L0();
        TbRichText A6 = A6(str, i3);
        if (A6 == null || (tbRichTextData = A6.y().get(this.l2)) == null) {
            return;
        }
        eVar.f19266f = String.valueOf(A6.getPostId());
        eVar.f19261a = new ArrayList<>();
        eVar.f19262b = new ConcurrentHashMap<>();
        if (!tbRichTextData.B().D()) {
            eVar.f19268h = false;
            String a3 = d.a.q0.h2.h.f.a(tbRichTextData);
            eVar.f19261a.add(a3);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = P4(tbRichTextData);
            imageUrlData.originalUrl = P4(tbRichTextData);
            imageUrlData.originalSize = Q4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = K4(tbRichTextData);
            imageUrlData.isLongPic = I4(tbRichTextData);
            imageUrlData.postId = A6.getPostId();
            imageUrlData.mIsReserver = this.t0.W0();
            imageUrlData.mIsSeeHost = this.t0.q0();
            eVar.f19262b.put(a3, imageUrlData);
            if (L0 != null) {
                if (L0.m() != null) {
                    eVar.f19263c = L0.m().getName();
                    eVar.f19264d = L0.m().getId();
                }
                if (L0.N() != null) {
                    eVar.f19265e = L0.N().d0();
                }
                eVar.f19267g = L0.t() == 1;
            }
            imageUrlData.threadId = d.a.d.e.m.b.f(eVar.f19265e, -1L);
            return;
        }
        eVar.f19268h = true;
        int size = L0.E().size();
        this.n2 = false;
        eVar.j = -1;
        int G4 = L0.j() != null ? G4(L0.j().K(), A6, i3, i3, eVar.f19261a, eVar.f19262b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = L0.E().get(i4);
            if (postData.E() == null || L0.j() == null || L0.j().E() == null || !postData.E().equals(L0.j().E())) {
                G4 = G4(postData.K(), A6, G4, i3, eVar.f19261a, eVar.f19262b);
            }
        }
        if (eVar.f19261a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19261a;
            eVar.f19269i = arrayList.get(arrayList.size() - 1);
        }
        if (L0 != null) {
            if (L0.m() != null) {
                eVar.f19263c = L0.m().getName();
                eVar.f19264d = L0.m().getId();
            }
            if (L0.N() != null) {
                eVar.f19265e = L0.N().d0();
            }
            eVar.f19267g = L0.t() == 1;
        }
        eVar.j = G4;
    }

    public final boolean I4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return false;
            }
            return tbRichTextData.B().E();
        }
        return invokeL.booleanValue;
    }

    public void I5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || !checkUpIsLogin() || (pbModel = this.t0) == null || pbModel.L0() == null || this.t0.L0().m() == null || e4()) {
            return;
        }
        if (this.t0.L0().e0()) {
            this.A0.T();
            return;
        }
        if (this.T0 == null) {
            d.a.q0.u0.f2.a.c cVar = new d.a.q0.u0.f2.a.c(getPageContext());
            this.T0 = cVar;
            cVar.k(0);
            this.T0.j(new m0(this));
        }
        this.T0.h(this.t0.L0().m().getId(), d.a.d.e.m.b.f(this.t0.b1(), 0L));
    }

    public boolean J4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (!this.f19311g && this.z2 == -1 && this.A2 == -1) ? false : true : invokeV.booleanValue;
    }

    public final AbsPbActivity.e J5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            String str2 = null;
            if (this.t0.L0() != null && this.t0.L0().E() != null && this.t0.L0().E().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.t0.L0().E().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.t0.L0().E().get(i3).E())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.t0.L0().E().get(i3);
                if (postData.K() != null && postData.K().y() != null) {
                    Iterator<TbRichTextData> it = postData.K().y().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.B() != null) {
                                str2 = next.B().y();
                            }
                        }
                    }
                    H5(str2, 0, eVar);
                    d.a.q0.h2.h.f.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final boolean K4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return false;
            }
            return tbRichTextData.B().F();
        }
        return invokeL.booleanValue;
    }

    public final void K5(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f19310f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public boolean L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public void L5(d.a.q0.h2.h.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, rVar) == null) {
            String E = rVar.i().E();
            List<PostData> list = this.t0.L0().S().f57500a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.E() == null || !postData.E().equals(E)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = rVar.k();
                    postData.u0(rVar.m());
                    if (postData.M() != null) {
                        postData.M().clear();
                        postData.M().addAll(k3);
                    }
                }
            }
            if (this.t0.v0()) {
                return;
            }
            this.A0.n1(this.t0.L0());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.d1.m.h
    /* renamed from: M4 */
    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var == null) {
                return null;
            }
            return t0Var.B0();
        }
        return (BdListView) invokeV.objValue;
    }

    public void M5(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048602, this, z2, markData) == null) {
            this.A0.M2();
            this.t0.i2(z2);
            d.a.p0.i.a aVar = this.v0;
            if (aVar != null) {
                aVar.h(z2);
                if (markData != null) {
                    this.v0.i(markData);
                }
            }
            if (this.t0.x0()) {
                z5();
            } else {
                this.A0.n1(this.t0.L0());
            }
        }
    }

    public int N4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.A2 : invokeV.intValue;
    }

    public void N5(d.a.q0.h2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, rVar) == null) || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> E3 = this.t0.L0().E();
        int i3 = 0;
        while (true) {
            z2 = true;
            if (i3 >= E3.size()) {
                break;
            }
            PostData postData = E3.get(i3);
            if (postData.E() == null || !postData.E().equals(E)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = rVar.k();
                postData.u0(rVar.m());
                if (postData.M() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.S() != null && next != null && next.t() != null && (metaData = postData.S().get(next.t().getUserId())) != null) {
                            next.g0(metaData);
                            next.o0(true);
                            next.z0(getPageContext(), this.t0.s1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k3.size() != postData.M().size();
                    if (postData.M() != null && postData.M().size() < 2) {
                        postData.M().clear();
                        postData.M().addAll(k3);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.e0();
                }
            }
        }
        if (!this.t0.v0() && z2) {
            this.A0.n1(this.t0.L0());
        }
        if (z2) {
            L5(rVar);
        }
    }

    public int O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.z2 : invokeV.intValue;
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            hideNetRefreshView(this.A0.V0());
            l6();
            if (this.t0.A1()) {
                this.A0.N2();
            }
            this.A0.W2();
        }
    }

    public final String P4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return null;
            }
            return tbRichTextData.B().A();
        }
        return (String) invokeL.objValue;
    }

    public void P5(s2 s2Var) {
        List<s2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, s2Var) == null) || s2Var == null || (list = this.m1) == null) {
            return;
        }
        list.remove(s2Var);
    }

    public final long Q4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return 0L;
            }
            return tbRichTextData.B().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final boolean Q5(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.w0 && !TextUtils.isEmpty(postData.u()) && d.a.p0.s.k.c().g()) {
                        return D5(postData.E());
                    }
                    if (checkUpIsLogin() && (pbModel = this.t0) != null && pbModel.L0() != null) {
                        if (V4().K0() != null) {
                            V4().K0().c();
                        }
                        d.a.q0.h2.h.r rVar = new d.a.q0.h2.h.r();
                        rVar.A(this.t0.L0().m());
                        rVar.E(this.t0.L0().N());
                        rVar.C(postData);
                        V4().J0().R(rVar);
                        V4().J0().setPostId(postData.E());
                        y5(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.a.p0.x.w.e eVar = this.P0;
                        if (eVar != null) {
                            this.A0.r2(eVar.D());
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

    public d.a.p0.x.w.e R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.P0 : (d.a.p0.x.w.e) invokeV.objValue;
    }

    public final void R5(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.S == null) {
            d.a.q0.h2.k.e.c1.f.a aVar = new d.a.q0.h2.k.e.c1.f.a(this.f19309e);
            this.S = aVar;
            aVar.n(this.W0);
            this.S.m(this.Y1);
        }
        this.S.k(emotionImageData, y(), y().L0());
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void S(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048613, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.p0.d1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.p0.d1.m.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (d.a.q0.h2.k.e.y0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.p0.d1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public d.a.q0.h2.k.e.d1.b S4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f19313i : (d.a.q0.h2.k.e.d1.b) invokeV.objValue;
    }

    public final void S5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (pbModel = this.t0) == null || pbModel.L0() == null || this.t0.L0().N() == null || !this.t0.L0().N().s2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final int T4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i3)) == null) {
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

    public final void T5(boolean z2, PostData postData) {
        d.a.p0.t.c.d adAdSense;
        d.a.q0.h2.k.e.t0 t0Var;
        d.a.q0.h2.k.e.i l02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048617, this, z2, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.h() || (t0Var = this.A0) == null || (l02 = t0Var.l0()) == null || (E = l02.E()) == null) {
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
            String E3 = next.E();
            i3++;
            if (z2) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f58625b = E3;
                    cVar.f58626c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(E3)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f58625b = E3;
                cVar2.f58626c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.L0() == null || this.t0.L0().m() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.t0.L0().m().getFirst_class();
                str2 = this.t0.L0().m().getSecond_class();
                str3 = this.t0.L0().m().getId();
                str4 = this.t0.b1();
                str = first_class;
            }
            d.a.q0.w2.x.v(z2, str, str2, str3, str4, arrayList, adAdSense.j());
        }
    }

    public d.a.q0.h2.k.e.f1.a U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.q0 : (d.a.q0.h2.k.e.f1.a) invokeV.objValue;
    }

    public final void U5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (pbModel = this.t0) == null || pbModel.L0() == null || this.t0.L0().N() == null || !this.t0.L0().N().s2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public d.a.q0.h2.k.e.t0 V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.A0 : (d.a.q0.h2.k.e.t0) invokeV.objValue;
    }

    public final void V5(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i3) == null) || this.t0 == null) {
            return;
        }
        l6();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.t0.f19512f);
        sendMessage(privacySettingMessage);
    }

    public d.a.p0.s.q.l1 W4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.k0 : (d.a.p0.s.q.l1) invokeV.objValue;
    }

    public void W5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            this.P = z2;
        }
    }

    public String X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public final void X5(d.a.p0.x.w.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, gVar) == null) || gVar == null || (pbModel = this.t0) == null) {
            return;
        }
        gVar.o(pbModel.n0());
        if (this.t0.L0() != null && this.t0.L0().m() != null) {
            gVar.n(this.t0.L0().m());
        }
        gVar.p("pb");
        gVar.q(this.t0);
    }

    public void Y3(s2 s2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, s2Var) == null) || s2Var == null) {
            return;
        }
        if (this.m1 == null) {
            this.m1 = new ArrayList();
        }
        if (this.m1.contains(s2Var)) {
            return;
        }
        this.m1.add(s2Var);
    }

    public final int Y4(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return 0;
            }
            if (eVar.N().k1() == 0) {
                return 1;
            }
            if (eVar.N().k1() == 54) {
                return 2;
            }
            return eVar.N().k1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void Y5(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i3) == null) || (pbModel = this.t0) == null) {
            return;
        }
        int U0 = pbModel.U0();
        if (i3 == 5) {
            this.t0.e2(2);
        } else if (i3 == 6) {
            this.t0.e2(3);
        } else if (i3 != 7) {
            this.t0.e2(1);
        } else {
            this.t0.e2(4);
        }
        int U02 = this.t0.U0();
        if (U0 == 4 || U02 == 4) {
            F5();
        }
    }

    public void Z3(s2 s2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, s2Var) == null) || s2Var == null) {
            return;
        }
        if (this.m1 == null) {
            this.m1 = new ArrayList();
        }
        if (this.m1.contains(s2Var)) {
            return;
        }
        this.m1.add(0, s2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.h2.o.b
    /* renamed from: Z4 */
    public VideoPbFragment v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public void Z5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.M = z2;
        }
    }

    @Override // d.a.q0.h2.o.b
    public PbModel.g a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.b2 : (PbModel.g) invokeV.objValue;
    }

    public final void a4() {
        PbModel pbModel;
        d.a.q0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (pbModel = this.t0) == null || (eVar = pbModel.J) == null || eVar.N() == null) {
            return;
        }
        d.a.p0.s.q.b2 N = this.t0.J.N();
        N.V0 = this.t0.Q0();
        N.U0 = this.t0.T0();
        N.T0 = this.t0.S0();
        N.W0 = this.t0.R0();
        N.D2 = this.t0.z0();
        if (N.R() == 0) {
            N.o3(d.a.d.e.m.b.f(this.t0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.p0.l0.c.i(getContext(), N, "c13562");
        TbPageTag l3 = d.a.p0.l0.c.l(getContext());
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

    public String a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public final void a6(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
            this.P0.g0(z2);
            this.P0.j0(z2);
            this.P0.q0(z2);
        }
    }

    public final void b4(boolean z2) {
        PbModel pbModel;
        d.a.q0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z2) == null) || (pbModel = this.t0) == null || (eVar = pbModel.J) == null || eVar.N() == null) {
            return;
        }
        d.a.p0.s.q.b2 N = this.t0.J.N();
        N.V0 = this.t0.Q0();
        N.U0 = this.t0.T0();
        N.T0 = this.t0.S0();
        N.W0 = this.t0.R0();
        if (N.R() == 0) {
            N.o3(d.a.d.e.m.b.f(this.t0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.p0.l0.c.i(getContext(), N, "c13563");
        TbPageTag l3 = d.a.p0.l0.c.l(getContext());
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
            if (z2) {
                i3.param("obj_type", 2);
            } else {
                i3.param("obj_type", 1);
            }
            d.a.p0.k0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.k) {
                this.Q = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.t0.L0() == null || this.t0.L0().N() == null || this.t0.L0().N().f1() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.t0.L0().N().f1().g(), this.t0.L0().N().f1().f(), this.t0.L0().N().f1().b(), this.t0.L0().N().f1().c(), this.t0.L0().N().n0(), this.t0.L0().N().m0())));
                this.f19309e.finish();
            }
        }
    }

    public final void b6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048638, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new f1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                o6(str);
            } else {
                this.A0.v3(str);
            }
        }
    }

    public final void c4(d.a.q0.h2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048639, this, eVar, arrayList) == null) || eVar == null || eVar.S() == null || eVar.S().f57500a == null || (list = eVar.S().f57500a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.E()) && !TextUtils.isEmpty(postData.E()) && next.E().equals(postData.E())) {
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

    public final void c5(int i3, Intent intent) {
        d.a.p0.x.n nVar;
        d.a.p0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048640, this, i3, intent) == null) {
            if (i3 == 0) {
                this.A0.Z0();
                this.A0.K0().c();
                this.A0.Z2(false);
            }
            this.A0.j2();
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
                    if (editorType != 1 || this.A0.K0() == null || this.A0.K0().b() == null) {
                        return;
                    }
                    d.a.p0.x.w.h b3 = this.A0.K0().b();
                    b3.a0(this.t0.L0().N());
                    b3.B(writeData);
                    b3.b0(pbEditorData.getVoiceModel());
                    d.a.p0.x.m n3 = b3.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new d.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b3.F();
                        return;
                    }
                    return;
                }
                this.P0.T();
                this.P0.u0(pbEditorData.getVoiceModel());
                this.P0.H(writeData);
                d.a.p0.x.m n4 = this.P0.a().n(6);
                if (n4 != null && (nVar = n4.k) != null) {
                    nVar.onAction(new d.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.P0.M(null, null);
                }
            }
        }
    }

    public final void c6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048641, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (V4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    d.a.p0.t.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    d.a.q0.h3.q0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.t0.z0()) {
            antiData.setBlock_forum_name(this.t0.L0().m().getName());
            antiData.setBlock_forum_id(this.t0.L0().m().getId());
            antiData.setUser_name(this.t0.L0().T().getUserName());
            antiData.setUser_id(this.t0.L0().T().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void d4(boolean z2) {
        d.a.q0.h2.k.e.t0 t0Var;
        int w2;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) || (t0Var = this.A0) == null || t0Var.B0() == null) {
            return;
        }
        int firstVisiblePosition = this.A0.B0().getFirstVisiblePosition();
        int lastVisiblePosition = this.A0.B0().getLastVisiblePosition();
        d.a.q0.h2.k.e.i l02 = this.A0.l0();
        if (l02 == null || this.t0.L0() == null) {
            return;
        }
        if (lastVisiblePosition <= l02.w()) {
            w2 = 0;
            w3 = 1;
        } else {
            w2 = firstVisiblePosition > l02.w() ? firstVisiblePosition - l02.w() : 0;
            w3 = (lastVisiblePosition - l02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w3 > w2) {
            while (w2 < w3) {
                if (this.A0.B0().G(w2) != null && (this.A0.B0().G(w2) instanceof PostData) && (postData = (PostData) this.A0.B0().G(w2)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.t0.L0().E(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.f0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().j(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                w2++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new e1(this));
            if (((d.a.p0.u.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                this.A0.y3();
                this.A0.X1((d.a.p0.u.a) ListUtils.getItem(arrayList, 0), 1);
            } else if (z2) {
            } else {
                this.A0.y3();
                this.A0.X1((d.a.p0.u.a) ListUtils.getItem(arrayList, 0), 0);
            }
        }
    }

    public void d5(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.d1);
            userMuteAddAndDelCustomMessage.setTag(this.d1);
            p6(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void d6(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            d.a.q0.h2.k.e.g1.b.j(this, j3, str, j4);
        }
    }

    public final boolean e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.L0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.t0.L0().N()) || AntiHelper.d(getPageContext(), this.t0.L0().d());
        }
        return invokeV.booleanValue;
    }

    public final void e5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.L0() != null && this.t0.L0().e0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.t0.b1(), str);
                d.a.p0.s.q.b2 N = this.t0.L0().N();
                if (N.F1()) {
                    format = format + "&channelid=33833";
                } else if (N.K1()) {
                    format = format + "&channelid=33842";
                } else if (N.I1()) {
                    format = format + "&channelid=33840";
                }
                t5(format);
                return;
            }
            this.u0.i(str);
        }
    }

    public final void e6(SparseArray<Object> sparseArray, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            d.a.q0.h2.k.e.g1.a.d(getActivity(), getPageContext(), new k0(this, sparseArray, i3, z2), new l0(this));
        }
    }

    public final boolean f4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void f5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, intent) == null) {
            d.a.q0.h2.k.e.g1.b.i(this, intent);
        }
    }

    public final boolean f6(boolean z2) {
        InterceptResult invokeZ;
        d.a.p0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z2)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.L0() == null) {
                return false;
            }
            d.a.q0.h2.h.e L0 = this.t0.L0();
            d.a.p0.s.q.b2 N = L0.N();
            if (N != null) {
                if (N.F1() || N.I1()) {
                    return false;
                }
                if (N.G1() || N.H1()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((N == null || N.H() == null || !N.H().isForumBusinessAccount() || d.a.q0.u0.v0.isOn()) && !this.t0.D()) {
                if (L0.m() == null || !L0.m().isBlockBawuDelete) {
                    if (L0.U() != 0) {
                        return L0.U() != 3;
                    }
                    List<d.a.p0.s.q.x1> q3 = L0.q();
                    if (ListUtils.getCount(q3) > 0) {
                        for (d.a.p0.s.q.x1 x1Var : q3) {
                            if (x1Var != null && (e0Var = x1Var.f53484g) != null && e0Var.f53305a && !e0Var.f53307c && ((i3 = e0Var.f53306b) == 1 || i3 == 2)) {
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
        return invokeZ.booleanValue;
    }

    @Override // d.a.q0.h2.o.b
    public void finish() {
        d.a.q0.h2.k.e.t0 t0Var;
        CardHListViewData r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            d.a.q0.h2.k.e.t0 t0Var2 = this.A0;
            if (t0Var2 != null) {
                t0Var2.a0();
            }
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.L0() != null && !this.t0.L0().e0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.t0.L0().N().d0();
                if (this.t0.isShareThread() && this.t0.L0().N().u1 != null) {
                    historyMessage.threadName = this.t0.L0().N().u1.f12278b;
                } else {
                    historyMessage.threadName = this.t0.L0().N().getTitle();
                }
                if (this.t0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.t0.L0().m().getName();
                }
                ArrayList<PostData> E = this.t0.L0().E();
                d.a.q0.h2.k.e.t0 t0Var3 = this.A0;
                int s02 = t0Var3 != null ? t0Var3.s0() : 0;
                if (E != null && s02 >= 0 && s02 < E.size()) {
                    historyMessage.postID = E.get(s02).E();
                }
                historyMessage.isHostOnly = this.t0.q0();
                historyMessage.isSquence = this.t0.Z0();
                historyMessage.isShareThread = this.t0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            d.a.p0.x.w.e eVar = this.P0;
            if (eVar != null) {
                eVar.J();
            }
            if (this.n && V4() != null) {
                V4().f0();
            }
            PbModel pbModel2 = this.t0;
            if (pbModel2 != null && (pbModel2.r0() || this.t0.u0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.t0.b1());
                if (this.B0) {
                    if (this.D0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.t0.A0());
                    }
                    if (this.C0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.t0.w0());
                    }
                }
                if (this.t0.L0() != null && System.currentTimeMillis() - this.t >= 40000 && (r3 = this.t0.L0().r()) != null && !ListUtils.isEmpty(r3.getDataList())) {
                    intent.putExtra("guess_like_data", r3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.l1);
                }
                this.f19309e.setResult(-1, intent);
            }
            if (v6()) {
                if (this.t0 != null && (t0Var = this.A0) != null && t0Var.B0() != null) {
                    d.a.q0.h2.h.e L0 = this.t0.L0();
                    if (L0 != null) {
                        if (L0.T() != null) {
                            L0.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!L0.i0() && !this.K && L0.f57444h == null) {
                            d.a.q0.h2.k.e.m0.b().n(this.t0.M0(), this.A0.B0().onSaveInstanceState(), this.t0.Z0(), this.t0.q0(), this.A0.I0() != null && this.A0.I0().getVisibility() == 0);
                            if (this.k1 >= 0 || this.t0.d1() != null) {
                                d.a.q0.h2.k.e.m0.b().q(this.t0.d1());
                                d.a.q0.h2.k.e.m0.b().r(this.t0.e1());
                                d.a.q0.h2.k.e.m0.b().o(this.t0.E0());
                            }
                        }
                    }
                } else {
                    d.a.q0.h2.k.e.m0.b().m();
                }
                u6();
            }
        }
    }

    public void g4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.A0.g3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = d.a.d.e.m.b.f(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = d.a.d.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.d1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.a1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void g5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || this.f19309e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f19309e.getCurrentFocus() == null) {
            return;
        }
        d.a.d.e.p.l.x(getPageContext().getPageActivity(), this.f19309e.getCurrentFocus());
    }

    public final boolean g6(boolean z2) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048654, this, z2)) == null) {
            if (z2 || (pbModel = this.t0) == null || pbModel.L0() == null || (this.t0.L0().m() != null && this.t0.L0().m().isBlockBawuDelete)) {
                return false;
            }
            d.a.q0.h2.h.e L0 = this.t0.L0();
            return ((L0.N() != null && L0.N().H() != null && L0.N().H().isForumBusinessAccount() && !d.a.q0.u0.v0.isOn()) || this.t0.D() || this.t0.L0().U() == 0 || this.t0.L0().U() == 3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public d.a.q0.h2.k.e.d1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.f19309e.getEventController() : (d.a.q0.h2.k.e.d1.a) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (this.N == null) {
                this.N = new d.a.d.e.k.b<>(new s1(this), 20, 0);
            }
            return this.N;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.G == null) {
                this.G = new d.a.d.e.k.b<>(new r1(this), 8, 0);
            }
            return this.G;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            d.a.d.e.k.b<RelativeLayout> bVar = new d.a.d.e.k.b<>(new u1(this), 10, 0);
            this.J = bVar;
            return bVar;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var == null) {
                return 0;
            }
            return t0Var.P0();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.E == null) {
                this.E = TbRichTextView.z(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.I == null) {
                this.I = new d.a.d.e.k.b<>(new e2(this), 15, 0);
            }
            return this.I;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.d.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this.F == null) {
                this.F = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.F;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.o : (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (this.H == null) {
                this.H = new d.a.d.e.k.b<>(new t1(this), 8, 0);
            }
            return this.H;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    public boolean h4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if ((this.t0.L0() != null && (this.t0.L0().e0() || ThreadCardUtils.isSelf(this.t0.L0().N()))) || this.S0 == null || this.t0.L0() == null || this.t0.L0().d() == null) {
                return true;
            }
            return this.S0.checkPrivacyBeforeInvokeEditor(this.t0.L0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void h5() {
        d.a.q0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (t0Var = this.A0) == null) {
            return;
        }
        t0Var.Z0();
        g5();
    }

    public final boolean h6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.Z0()) {
                return this.t0.J0() == null || this.t0.J0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048670, this, i3)) == null) {
            if (this.S0 == null || this.t0.L0() == null || ThreadCardUtils.isSelf(this.t0.L0().N()) || this.t0.L0().d() == null) {
                return true;
            }
            return this.S0.checkPrivacyBeforeSend(this.t0.L0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void i5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i3) == null) {
            d.a.p0.b1.i0.b(new p2(this), new q2(this, i3));
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

    public final void i6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, metaData) == null) || metaData == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.mark_like_cancel), new a1(this, metaData));
        aVar.setPositiveButton(getResources().getString(R.string.mark_like_confirm), new b1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r1();
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j4(AgreeData agreeData) {
        d.a.p0.k0.c k3;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048674, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.m0 == null) {
            this.m0 = new d.a.p0.s.b0.a();
        }
        if (this.o0 == null) {
            d.a.q0.h3.h0.e eVar = new d.a.q0.h3.h0.e();
            this.o0 = eVar;
            eVar.f58546a = getUniqueId();
        }
        d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
        fVar.f53311b = 5;
        fVar.f53317h = 8;
        fVar.f53316g = 2;
        if (y() != null) {
            fVar.f53315f = y().K0();
        }
        fVar.f53310a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f53318i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.m0.c(agreeData, i3, getUniqueId(), false);
                this.m0.d(agreeData, this.o0);
                pbModel = this.t0;
                if (pbModel != null || pbModel.L0() == null) {
                }
                this.m0.b(z(), fVar, agreeData, this.t0.L0().N());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f53318i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f53318i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.m0.c(agreeData, i3, getUniqueId(), false);
        this.m0.d(agreeData, this.o0);
        pbModel = this.t0;
        if (pbModel != null) {
        }
    }

    public final void j5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            d.a.p0.i.a c3 = d.a.p0.i.a.c(this.f19309e);
            this.v0 = c3;
            if (c3 != null) {
                c3.j(this.e2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f19309e);
            this.w0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.g2);
            this.x0 = new d.a.p0.t.e.a(getPageContext());
            this.I1.setUniqueId(getUniqueId());
            this.I1.registerListener();
        }
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new k2(this));
            aVar.setNegativeButton(R.string.cancel, new l2(this));
            aVar.create(this.b1).show();
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            if (this.t0.r0() || this.t0.u0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.t0.b1());
                this.f19309e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.t0.b1()));
            if (v6()) {
                this.f19309e.finish();
            }
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.T = likeModel;
            likeModel.setLoadDataCallBack(new y(this));
        }
    }

    public final void k6(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048679, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.p0.s.s.j jVar = this.F0;
            if (jVar != null && jVar.isShowing()) {
                this.F0.dismiss();
                this.F0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(getContext());
                lVar.n(new r(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.p0.s.s.h(0, getResources().getString(R.string.delete), lVar));
                }
                if (z2) {
                    arrayList.add(new d.a.p0.s.s.h(1, getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.p0.s.s.h(1, getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.p0.s.s.j jVar2 = new d.a.p0.s.s.j(getPageContext(), lVar);
                this.F0 = jVar2;
                jVar2.l();
            }
        }
    }

    public final boolean l4(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        List<d.a.p0.s.s.h> b3;
        d.a.p0.s.s.h hVar;
        d.a.p0.s.s.h hVar2;
        d.a.p0.s.s.h hVar3;
        d.a.p0.s.s.h hVar4;
        d.a.d.k.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                d.a.q0.h2.k.e.t0 t0Var = this.A0;
                if (t0Var != null) {
                    if (t0Var.r1()) {
                        return true;
                    }
                    this.A0.j0();
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e3) {
                    e3.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (p5(view)) {
                        if (view instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view;
                            this.g1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.h1 = url;
                            if (this.g1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.i1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.i1 = null;
                            }
                        } else if (view instanceof GifView) {
                            GifView gifView = (GifView) view;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.g1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.h1 = gifView.getBdImage().q();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.i1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.i1 = null;
                            }
                        } else if (view instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.g1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.h1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.i1 = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                } else {
                                    this.i1 = null;
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
                            this.A0.l3(this.q2, this.g1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                this.o2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && p5(view)) {
                    this.A0.l3(this.q2, this.g1.t());
                    return true;
                }
                d.a.p0.i.a aVar2 = this.v0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z4 = aVar2.e() && this.o2.E() != null && this.o2.E().equals(this.t0.G0());
                boolean z5 = y().L0() != null && y().L0().e0();
                if (this.o2.A() == 1) {
                    if (!z5) {
                        this.A0.m3(this.p2, z4, false);
                    }
                    return true;
                }
                if (this.G0 == null) {
                    d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(getContext());
                    this.G0 = lVar;
                    lVar.n(this.U1);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z6 = p5(view) && !z5;
                boolean z7 = (!p5(view) || (aVar = this.g1) == null || aVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z6) {
                    z3 = booleanValue6;
                    z2 = booleanValue5;
                    arrayList.add(new d.a.p0.s.s.h(1, getString(R.string.save_to_emotion), this.G0));
                } else {
                    z2 = booleanValue5;
                    z3 = booleanValue6;
                }
                if (z7) {
                    arrayList.add(new d.a.p0.s.s.h(2, getString(R.string.save_to_local), this.G0));
                }
                if (!z6 && !z7) {
                    d.a.p0.s.s.h hVar5 = new d.a.p0.s.s.h(3, getString(R.string.copy), this.G0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.o2);
                    hVar5.f53561d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                }
                if (!booleanValue && !z5) {
                    if (z4) {
                        hVar4 = new d.a.p0.s.s.h(4, getString(R.string.remove_mark), this.G0);
                    } else {
                        hVar4 = new d.a.p0.s.s.h(4, getString(R.string.mark), this.G0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.o2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    hVar4.f53561d.setTag(sparseArray4);
                    arrayList.add(hVar4);
                }
                if (this.mIsLogin && !this.p0) {
                    if (!d.a.q0.h2.k.e.g1.a.h(this.t0) && !booleanValue4 && booleanValue3) {
                        d.a.p0.s.s.h hVar6 = new d.a.p0.s.s.h(5, getString(R.string.mute_option), this.G0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i3 = R.id.tag_is_mem;
                        sparseArray5.put(i3, sparseArray.get(i3));
                        int i4 = R.id.tag_user_mute_mute_userid;
                        sparseArray5.put(i4, sparseArray.get(i4));
                        int i5 = R.id.tag_user_mute_mute_username;
                        sparseArray5.put(i5, sparseArray.get(i5));
                        int i6 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray5.put(i6, sparseArray.get(i6));
                        int i7 = R.id.tag_user_mute_post_id;
                        sparseArray5.put(i7, sparseArray.get(i7));
                        int i8 = R.id.tag_user_mute_thread_id;
                        sparseArray5.put(i8, sparseArray.get(i8));
                        int i9 = R.id.tag_del_post_is_self;
                        sparseArray5.put(i9, sparseArray.get(i9));
                        int i10 = R.id.tag_del_post_type;
                        sparseArray5.put(i10, sparseArray.get(i10));
                        int i11 = R.id.tag_del_post_id;
                        sparseArray5.put(i11, sparseArray.get(i11));
                        int i12 = R.id.tag_manage_user_identity;
                        sparseArray5.put(i12, sparseArray.get(i12));
                        hVar6.f53561d.setTag(sparseArray5);
                        arrayList.add(hVar6);
                    } else {
                        if ((s5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z5) {
                            d.a.p0.s.s.h hVar7 = new d.a.p0.s.s.h(5, getString(R.string.report_text), this.G0);
                            hVar7.f53561d.setTag(str);
                            arrayList.add(hVar7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        int i13 = R.id.tag_manage_user_identity;
                        sparseArray6.put(i13, sparseArray.get(i13));
                        int i14 = R.id.tag_forbid_user_name;
                        sparseArray6.put(i14, sparseArray.get(i14));
                        int i15 = R.id.tag_forbid_user_name_show;
                        sparseArray6.put(i15, sparseArray.get(i15));
                        int i16 = R.id.tag_forbid_user_portrait;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                        if (!d.a.q0.h2.k.e.g1.a.h(this.t0) && z2) {
                            sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            int i17 = R.id.tag_is_mem;
                            sparseArray6.put(i17, sparseArray.get(i17));
                            int i18 = R.id.tag_user_mute_mute_userid;
                            sparseArray6.put(i18, sparseArray.get(i18));
                            int i19 = R.id.tag_user_mute_mute_username;
                            sparseArray6.put(i19, sparseArray.get(i19));
                            int i20 = R.id.tag_user_mute_mute_nameshow;
                            sparseArray6.put(i20, sparseArray.get(i20));
                            int i21 = R.id.tag_user_mute_post_id;
                            sparseArray6.put(i21, sparseArray.get(i21));
                            int i22 = R.id.tag_user_mute_thread_id;
                            sparseArray6.put(i22, sparseArray.get(i22));
                        } else {
                            sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z3) {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                            int i23 = R.id.tag_del_post_id;
                            sparseArray6.put(i23, sparseArray.get(i23));
                            int i24 = R.id.tag_del_post_type;
                            sparseArray6.put(i24, sparseArray.get(i24));
                            int i25 = R.id.tag_has_sub_post;
                            sparseArray6.put(i25, sparseArray.get(i25));
                            hVar2 = new d.a.p0.s.s.h(6, getString(R.string.delete), this.G0);
                            hVar2.f53561d.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            hVar2 = null;
                        }
                        hVar = new d.a.p0.s.s.h(7, getString(R.string.bar_manager), this.G0);
                        hVar.f53561d.setTag(sparseArray6);
                    } else if (z3) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                        sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        int i26 = R.id.tag_manage_user_identity;
                        sparseArray7.put(i26, sparseArray.get(i26));
                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i27 = R.id.tag_del_post_id;
                        sparseArray7.put(i27, sparseArray.get(i27));
                        int i28 = R.id.tag_del_post_type;
                        sparseArray7.put(i28, sparseArray.get(i28));
                        int i29 = R.id.tag_has_sub_post;
                        sparseArray7.put(i29, sparseArray.get(i29));
                        if (this.t0.L0().U() == 1002 && !booleanValue2) {
                            hVar3 = new d.a.p0.s.s.h(6, getString(R.string.report_text), this.G0);
                        } else {
                            hVar3 = new d.a.p0.s.s.h(6, getString(R.string.delete), this.G0);
                        }
                        hVar3.f53561d.setTag(sparseArray7);
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
                    d.a.q0.h2.k.e.g1.a.a(arrayList, this.G0, this.o2, this.t0);
                }
                if (d.a.p0.b.d.L()) {
                    b3 = d.a.q0.h2.k.e.g1.a.c(arrayList, this.o2.q(), sparseArray, this.G0);
                } else {
                    b3 = d.a.q0.h2.k.e.g1.a.b(arrayList, this.o2.q(), sparseArray, this.G0);
                }
                d.a.q0.h2.k.e.g1.a.k(b3, this.f19310f);
                d.a.q0.h2.k.e.g1.a.e(b3);
                this.G0.o(d.a.q0.h2.k.e.g1.a.f(this.o2));
                if (d.a.p0.b.d.L()) {
                    this.G0.l(b3, false);
                } else {
                    this.G0.l(b3, true);
                }
                d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(getPageContext(), this.G0);
                this.F0 = jVar;
                jVar.l();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.t0.f19512f).param("fid", this.t0.getForumId()).param("uid", this.t0.L0().N().H().getUserId()).param("post_id", this.t0.y()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void l5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && this.q == null) {
            this.q = new d.a.p0.s.s.b(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
            d.a.p0.s.s.b bVar = this.q;
            bVar.j(strArr, new b0(this));
            bVar.g(b.C1227b.f53531a);
            bVar.h(17);
            bVar.c(getPageContext());
        }
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            showLoadingView(this.A0.V0(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
            View i3 = getLoadingView().i();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
            layoutParams.addRule(3, this.A0.U0().getId());
            i3.setLayoutParams(layoutParams);
        }
    }

    public void m4(ForumManageModel.b bVar, d.a.q0.h2.k.e.t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, bVar, t0Var) == null) {
            List<PostData> list = this.t0.L0().S().f57500a;
            int size = list.size();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).M().size()) {
                        break;
                    } else if (bVar.f21303g.equals(list.get(i3).M().get(i4).E())) {
                        list.get(i3).M().remove(i4);
                        list.get(i3).l();
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).n(bVar.f21303g);
            }
            if (z2) {
                t0Var.n1(this.t0.L0());
            }
        }
    }

    public boolean m5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                return pbModel.r0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && y() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                y().W(postWriteCallBackData.getPostId());
                int p02 = this.A0.p0();
                this.k1 = p02;
                this.t0.U1(p02, this.A0.w0());
            }
            this.A0.a0();
            this.E0.c();
            d.a.p0.x.w.e eVar = this.P0;
            if (eVar != null) {
                this.A0.r2(eVar.D());
            }
            this.A0.Z0();
            this.A0.Z2(true);
            this.t0.i1();
        }
    }

    public final void n4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048686, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.q0.h3.h0.o y2 = this.t0.L0().y();
        if (y2 != null && str.equals(y2.D0())) {
            if (y2.getAdvertAppInfo() != null) {
                y2.getAdvertAppInfo().Z3 = null;
            }
            this.t0.L0().b();
        }
        d.a.q0.h3.h0.o h02 = this.t0.h0();
        if (h02 == null || !str.equals(h02.D0())) {
            return;
        }
        this.t0.V();
    }

    public final boolean n5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            PostData c3 = d.a.q0.h2.h.f.c(this.t0.L0(), this.t0.Z0(), this.t0.V0());
            return (c3 == null || c3.t() == null || c3.t().getGodUserData() == null || c3.t().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void n6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i3) == null) {
            d.a.q0.h2.k.e.g1.b.m(this, y4(), i3);
        }
    }

    public void o4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048689, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(d.a.q0.h2.k.e.t0.Y1)).intValue();
            if (intValue == d.a.q0.h2.k.e.t0.Z1) {
                if (this.w0.O()) {
                    return;
                }
                this.A0.x3();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (jSONArray != null) {
                    this.w0.Q(StringHelper.JsonArrayToString(jSONArray));
                }
                this.w0.R(this.t0.L0().m().getId(), this.t0.L0().m().getName(), this.t0.L0().N().d0(), str, intValue3, intValue2, booleanValue, this.t0.L0().N().J());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == d.a.q0.h2.k.e.t0.a2 || intValue == d.a.q0.h2.k.e.t0.c2) {
                if (this.t0.j0() != null) {
                    this.t0.j0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == d.a.q0.h2.k.e.t0.a2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean o5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                return pbModel.q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, str) == null) {
            if (str == null) {
                str = "";
            }
            d.a.d.a.f fVar = this.b1;
            if (fVar == null) {
                return;
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new m2(this));
            aVar.create(this.b1).show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            this.b2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048693, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.P0.I(i3, i4, intent);
            d.a.q0.h2.k.e.c1.f.a aVar = this.S;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (V4().K0() != null) {
                V4().K0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                c5(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    A5();
                } else if (i3 == 13008) {
                    d.a.q0.h2.k.e.m0.b().m();
                    this.s0.postDelayed(new l1(this), 1000L);
                } else if (i3 == 13011) {
                    d.a.q0.v2.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.t0 == null) {
                        return;
                    }
                    d6(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    f5(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.V0 = emotionImageData;
                    if (i4(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        R5(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.U;
                    if (view != null) {
                        this.A0.d3(view);
                    }
                } else if (i3 == 24007) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        statisticItem.param("tid", intent.getStringExtra("tid"));
                        statisticItem.param("post_id", intent.getStringExtra("pid"));
                        statisticItem.param("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(statisticItem);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        d.a.q0.v2.a.g().m(getPageContext());
                        x6();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.z0;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra, new m1(this));
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
                        case 25055:
                            View view2 = this.V;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view3 = this.W;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            d.a.q0.h2.k.e.t0 t0Var = this.A0;
                            if (t0Var == null || t0Var.m0() == null) {
                                return;
                            }
                            this.A0.m0().performClick();
                            return;
                        case 25058:
                            View view4 = this.X;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.A0.P2(false);
                    if (this.t0.L0() == null || this.t0.L0().N() == null || this.t0.L0().N().K0() == null) {
                        return;
                    }
                    this.t0.L0().N().K0().setStatus(2);
                }
            }
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, context) == null) {
            super.onAttach(context);
            this.f19309e = (AbsPbActivity) context;
        }
    }

    public void onBackPressed() {
        List<s2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048696, this) == null) || (list = this.m1) == null || list.isEmpty()) {
            return;
        }
        int size = this.m1.size();
        while (true) {
            size--;
            if (size <= -1 || this.m1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048697, this, i3) == null) || this.Z == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.A0.G1(i3);
        d.a.p0.x.w.e eVar = this.P0;
        if (eVar != null && eVar.a() != null) {
            this.P0.a().w(i3);
        }
        if (this.A0.a() != null) {
            this.A0.a().c(getPageContext(), i3);
        }
        this.E0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.Z = i3;
        t6();
    }

    @Override // d.a.p0.s.s.a.e
    public void onClick(d.a.p0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, aVar) == null) {
            p4(aVar, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.C) {
                return;
            }
            this.C = i3;
            if (i3 == 2) {
                this.L = true;
            } else {
                this.L = false;
            }
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null) {
                t0Var.H1(configuration);
            }
            d.a.p0.s.s.j jVar = this.F0;
            if (jVar != null) {
                jVar.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.q0.h2.k.e.t0 t0Var;
        d.a.q0.h2.k.e.t0 t0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, bundle) == null) {
            this.t = System.currentTimeMillis();
            this.b1 = getPageContext();
            Intent intent = this.f19309e.getIntent();
            if (intent != null) {
                this.r = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.O = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.O)) {
                        this.O = data.getQueryParameter("from");
                    }
                }
                this.Y = intent.getStringExtra("st_type");
                "from_interview_live".equals(this.O);
                this.z2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.A2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.B2 = intent.getStringExtra("key_manga_title");
                this.K0 = intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.L0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.M0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (J4()) {
                    this.f19309e.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.R = stringExtra;
                this.R = d.a.d.e.p.k.isEmpty(stringExtra) ? "" : this.R;
                this.l1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                d.a.p0.s.q.l1 l1Var = new d.a.p0.s.q.l1();
                this.k0 = l1Var;
                l1Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.n1 = intExtra;
                if (intExtra == 0) {
                    this.n1 = intent.getIntExtra("key_start_from", 0);
                }
                this.o1 = intent.getStringExtra("last_tid");
            } else {
                this.r = System.currentTimeMillis();
            }
            this.v = this.t - this.r;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.p = 0;
            w5(bundle);
            if (this.t0.L0() != null) {
                this.t0.L0().F0(this.R);
            }
            k5();
            if (intent != null && (t0Var2 = this.A0) != null) {
                t0Var2.f58010b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.e1 == null) {
                        this.e1 = new u(this, intent);
                    }
                    d.a.d.e.m.e.a().postDelayed(this.e1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.t0.L0() != null) {
                    this.t0.c2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            j5(bundle);
            d.a.p0.x.w.g gVar = new d.a.p0.x.w.g();
            this.O0 = gVar;
            X5(gVar);
            d.a.p0.x.w.e eVar = (d.a.p0.x.w.e) this.O0.a(getActivity());
            this.P0 = eVar;
            eVar.f0(this.f19309e.getPageContext());
            this.P0.o0(this.Y1);
            this.P0.p0(this.W0);
            this.P0.h0(1);
            this.P0.G(this.f19309e.getPageContext(), bundle);
            this.P0.a().b(new d.a.p0.x.k(getActivity()));
            this.P0.a().C(true);
            a6(true);
            this.P0.P(this.t0.p0(), this.t0.b1(), this.t0.m0());
            registerListener(this.v1);
            if (!this.t0.z0()) {
                this.P0.t(this.t0.b1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.P0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.t0.k1()) {
                this.P0.l0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                d.a.q0.h2.k.e.t0 t0Var3 = this.A0;
                if (t0Var3 != null) {
                    this.P0.l0(t0Var3.N0());
                }
            }
            registerListener(this.u1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.t1);
            registerListener(this.R1);
            registerListener(this.d2);
            registerListener(this.s1);
            d.a.q0.h3.h0.f fVar = new d.a.q0.h3.h0.f("pb", d.a.q0.h3.h0.f.f58549d);
            this.N0 = fVar;
            fVar.d();
            registerListener(this.B1);
            registerListener(this.K1);
            this.t0.D1();
            registerListener(this.c2);
            registerListener(this.S1);
            registerListener(this.X1);
            registerListener(this.F1);
            d.a.q0.h2.k.e.t0 t0Var4 = this.A0;
            if (t0Var4 != null && t0Var4.U0() != null && this.A0.S0() != null) {
                d.a.q0.h2.k.e.d1.b bVar = new d.a.q0.h2.k.e.d1.b(getActivity(), this.A0.U0(), this.A0.S0(), this.A0.I0());
                this.f19313i = bVar;
                bVar.t(this.J1);
            }
            if (this.f19311g && (t0Var = this.A0) != null && t0Var.S0() != null) {
                this.A0.S0().setVisibility(8);
            }
            d.a.p0.s.f0.c cVar = new d.a.p0.s.f0.c();
            this.c1 = cVar;
            cVar.f52989a = 1000L;
            registerListener(this.Q1);
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.D1);
            registerListener(this.z1);
            this.C1.setSelfListener(true);
            this.C1.setTag(this.f19309e.getUniqueId());
            this.C1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.C1);
            registerResponsedEventListener(TipEvent.class, this.L1);
            this.d1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.d1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.d1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.t0.i0().A(this.M1);
            this.E0 = new d.a.q0.h2.k.e.v0();
            if (this.P0.w() != null) {
                this.E0.m(this.P0.w().i());
            }
            this.P0.e0(this.X0);
            this.z0 = new ShareSuccessReplyToServerModel();
            Y3(this.q1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.S0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new w(this));
            d.a.q0.h2.k.f.a aVar = new d.a.q0.h2.k.f.a(getContext());
            this.u0 = aVar;
            aVar.a(getUniqueId());
            d.a.q0.g3.c.g().i(getUniqueId());
            d.a.p0.s.o.a.b().l("3", "");
            this.p1 = new d.a.q0.z.a(getPageContext());
            this.q0 = new d.a.q0.h2.k.e.f1.a(this, getUniqueId(), this.A0, this.t0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && d.a.d.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.u = System.currentTimeMillis() - this.t;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048701, this, layoutInflater, viewGroup, bundle)) == null) {
            this.A0 = new d.a.q0.h2.k.e.t0(this, this.W1, this.N1);
            d.a.q0.i0.b bVar = new d.a.q0.i0.b(getActivity());
            this.f19312h = bVar;
            bVar.i(E2);
            this.f19312h.d(this.x2);
            this.A0.G2(this.f2);
            this.A0.F2(this.k2);
            this.A0.z2(this.i2);
            this.A0.x2(d.a.p0.s.k.c().g());
            this.A0.D2(this.m2);
            this.A0.J2(this.s2);
            this.A0.H2(this.t2);
            this.A0.E2(this.v2);
            this.A0.C2(this.h2);
            this.A0.B3(this.mIsLogin);
            if (this.f19309e.getIntent() != null) {
                this.A0.v2(this.f19309e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.A0.J0().setFromForumId(this.t0.getFromForumId());
            this.A0.n2(this.P0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.P0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.P0.l0(this.A0.N0());
            }
            this.A0.q2(new z(this));
            this.A0.u2(this.t0.u0());
            this.A0.I2(this.t0.K0());
            this.q0.f(this.A0, this.t0);
            return this.A0.V0();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.q0.h2.k.e.h1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            d.a.q0.g3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.t0.L0().n());
                statisticItem.param("tid", this.t0.b1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.x && this.A0 != null) {
                this.x = true;
                T5(false, null);
            }
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.t0.destory();
                if (this.t0.H0() != null) {
                    this.t0.H0().d();
                }
            }
            d.a.p0.x.w.e eVar = this.P0;
            if (eVar != null) {
                eVar.J();
            }
            ForumManageModel forumManageModel = this.w0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.T;
            if (likeModel != null) {
                likeModel.I();
            }
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null) {
                t0Var.I1();
                d.a.q0.h2.k.e.h1.c cVar2 = this.A0.f58016h;
                if (cVar2 != null) {
                    cVar2.y();
                }
            }
            d.a.p0.o0.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            d.a.q0.h2.k.e.d1.b bVar2 = this.f19313i;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.q0.h2.k.e.t0 t0Var2 = this.A0;
            if (t0Var2 != null) {
                t0Var2.a0();
            }
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().unRegisterListener(this.d1);
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            this.b1 = null;
            this.c1 = null;
            d.a.q0.w2.g0.a.e().g();
            if (this.e1 != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.e1);
            }
            d.a.q0.h2.k.e.c1.f.a aVar = this.S;
            if (aVar != null) {
                aVar.f();
            }
            d.a.q0.h2.k.e.t0 t0Var3 = this.A0;
            if (t0Var3 != null && (cVar = t0Var3.f58016h) != null) {
                cVar.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.z0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            d.a.q0.h2.k.e.v0 v0Var = this.E0;
            if (v0Var != null) {
                v0Var.j();
            }
            PbModel pbModel2 = this.t0;
            if (pbModel2 != null && pbModel2.b0() != null) {
                this.t0.b0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.S0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            d.a.q0.h2.k.e.t0 t0Var4 = this.A0;
            if (t0Var4 != null) {
                t0Var4.y3();
            }
            d.a.q0.h2.k.e.f1.a aVar2 = this.q0;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.l0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.d.k.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (d.a.d.k.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        d.a.q0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048705, this, i3, keyEvent)) == null) ? (keyEvent == null || (t0Var = this.A0) == null || !t0Var.K1(i3)) ? false : true : invokeIL.booleanValue;
    }

    @Override // d.a.p0.d1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048706, this, context, str) == null) {
            this.A = true;
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048707, this, context, str, z2) == null) {
            if (d.a.q0.h2.k.e.y0.c(str) && (pbModel = this.t0) != null && pbModel.b1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.t0.b1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    d.a.p0.u.l lVar = new d.a.p0.u.l();
                    lVar.f54114a = str;
                    lVar.f54115b = 3;
                    lVar.f54116c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
                }
            } else {
                d.a.q0.h2.k.e.y0.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            O5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.k = false;
            } else {
                this.k = true;
            }
            super.onPause();
            BdListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.p = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null) {
                t0Var.N1();
            }
            if (!this.t0.z0()) {
                this.P0.V(this.t0.b1());
            }
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                pbModel.C1();
            }
            d.a.p0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.y1);
            S5();
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048710, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.H0 = str;
        if (this.q == null) {
            l5();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            this.q.f(1).setVisibility(8);
        } else {
            this.q.f(1).setVisibility(0);
        }
        this.q.m();
        this.A = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.d.a.i
    public void onPreLoad(d.a.d.k.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            this.k = false;
            super.onResume();
            if (this.Q) {
                this.Q = false;
                b5();
            }
            if (n5()) {
                this.z = System.currentTimeMillis();
            } else {
                this.z = -1L;
            }
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null && t0Var.V0() != null) {
                if (!this.l) {
                    l6();
                } else {
                    hideLoadingView(this.A0.V0());
                }
                this.A0.O1();
            }
            if (this.p == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            d.a.q0.h2.k.e.t0 t0Var2 = this.A0;
            NoNetworkView a3 = t0Var2 != null ? t0Var2.a() : null;
            if (a3 != null && a3.getVisibility() == 0 && d.a.d.e.p.j.z()) {
                a3.e(false);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.y1);
            this.J0 = false;
            U5();
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.Q1);
            if (this.j1) {
                O5();
                this.j1 = false;
            }
            q6();
            ItemCardHelper.s(this.u2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.t0.R1(bundle);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.P0.L(bundle);
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048714, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onStop();
            if (this.z > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.z;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.z = 0L;
            }
            if (V4().K0() != null) {
                V4().K0().i();
            }
            d.a.q0.h2.k.e.h1.c cVar = this.A0.f58016h;
            if (cVar != null && !cVar.u()) {
                this.A0.f58016h.y();
            }
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.L0() != null && this.t0.L0().m() != null && this.t0.L0().N() != null) {
                d.a.p0.v.a.k().y(getPageContext().getPageActivity(), "pb", this.t0.L0().m().getId(), d.a.d.e.m.b.f(this.t0.L0().N().d0(), 0L));
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            d.a.q0.g3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048717, this, view, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) {
            super.onUserChanged(z2);
            this.A0.B3(z2);
            d.a.p0.s.s.j jVar = this.F0;
            if (jVar != null) {
                jVar.dismiss();
            }
            if (z2 && this.J0) {
                this.A0.O2();
                this.t0.u1(true);
            }
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048719, this, context, str) == null) {
            d.a.q0.h2.k.e.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048720, this, context, str) == null) {
        }
    }

    @Override // d.a.q0.h2.p.e.b
    public void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            this.J0 = z2;
        }
    }

    public void p4(d.a.p0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048722, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    o4((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean p5(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048723, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public final void p6(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048724, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.A0.g3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.b1.getPageActivity());
            if (d.a.d.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.b1.getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new n2(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new o2(this));
            aVar.create(this.b1).show();
        }
    }

    public void q4(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.a.q0.h2.k.e.t0.Y1, Integer.valueOf(d.a.q0.h2.k.e.t0.Z1));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                o4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean q5(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048726, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.t0.L0().T() != null && (forumToolAuth = this.t0.L0().T().getForumToolAuth()) != null) {
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

    public final void q6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || (pbModel = this.t0) == null || d.a.d.e.p.k.isEmpty(pbModel.b1())) {
            return;
        }
        d.a.p0.a.d.y().P(d.a.p0.a.c.W, d.a.d.e.m.b.f(this.t0.b1(), 0L));
    }

    public void r4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            TiebaStatic.log("c12181");
            d.a.q0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var == null || this.t0 == null) {
                return;
            }
            if ((t0Var != null && !t0Var.p1()) || this.t0.L0() == null || this.t0.L0().R() == null) {
                return;
            }
            d.a.q0.h2.k.e.t0 t0Var2 = this.A0;
            if (t0Var2 == null || t0Var2.r0() == null || !this.A0.r0().c()) {
                d.a.q0.h2.h.p R = this.t0.L0().R();
                if (checkUpIsLogin()) {
                    if ((!R.e() || R.b() != 2) && this.A0.l0() != null && this.A0.l0().z() != null) {
                        this.A0.l0().z().i0(this.t0.b1(), this.t0.getFromForumId());
                    }
                    if (System.currentTimeMillis() - this.B > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.B = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public final boolean r5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048729, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public final void r6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048730, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            s6(postData, false);
        }
    }

    public void s4() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048731, this) == null) || this.A0 == null || (pbModel = this.t0) == null) {
            return;
        }
        if ((pbModel.L0() == null && this.t0.L0().R() == null) || !checkUpIsLogin() || this.A0.l0() == null || this.A0.l0().z() == null) {
            return;
        }
        this.A0.l0().z().i0(this.t0.b1(), this.t0.getFromForumId());
    }

    public final boolean s5(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048732, this, z2)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.L0() != null) {
                return ((this.t0.L0().U() != 0) || this.t0.L0().N() == null || this.t0.L0().N().H() == null || TextUtils.equals(this.t0.L0().N().H().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void s6(PostData postData, boolean z2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048733, this, postData, z2) == null) || postData == null || (pbModel = this.t0) == null || pbModel.L0() == null || postData.A() == 1) {
            return;
        }
        String b12 = this.t0.b1();
        String E = postData.E();
        int U = this.t0.L0() != null ? this.t0.L0().U() : 0;
        AbsPbActivity.e J5 = J5(E);
        if (J5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(b12, E, "pb", true, false, null, false, null, U, postData.O(), this.t0.L0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(J5.f19261a, J5.f19262b, J5.f19267g, J5.j);
        addBigImageData.setKeyPageStartFrom(this.t0.K0());
        addBigImageData.setFromFrsForumId(this.t0.getFromForumId());
        addBigImageData.setWorksInfoData(this.t0.f1());
        addBigImageData.setKeyFromForumId(this.t0.getForumId());
        addBigImageData.setBjhData(this.t0.g0());
        addBigImageData.setIsOpenEditor(z2);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final void t4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048734, this, str) == null) || (pbModel = this.t0) == null || pbModel.L0() == null || this.t0.L0().N() == null || !this.t0.L0().N().r2()) {
            return;
        }
        d.a.p0.s.q.b2 N = this.t0.L0().N();
        int i3 = 0;
        if (N.F1()) {
            i3 = 1;
        } else if (N.I1()) {
            i3 = 2;
        } else if (N.G1()) {
            i3 = 3;
        } else if (N.H1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final void t5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void t6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.f19309e;
            if (absPbActivity != null) {
                absPbActivity.stopVoice();
            }
        }
    }

    public final void u4(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048737, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f21298b) ? bVar.f21298b : getString(R.string.delete_fail);
            int i3 = 0;
            if (bVar.f21299c == 1211066) {
                hideProgressBar();
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new h1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                this.A0.i0(0, bVar.f21297a, bVar.f21298b, z2);
            }
            if (bVar.f21297a) {
                int i4 = bVar.f21300d;
                if (i4 == 1) {
                    ArrayList<PostData> E = this.t0.L0().E();
                    int size = E.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f21303g.equals(E.get(i3).E())) {
                            E.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.t0.L0().N().U3(this.t0.L0().N().Q0() - 1);
                    this.A0.n1(this.t0.L0());
                } else if (i4 == 0) {
                    k4();
                } else if (i4 == 2) {
                    ArrayList<PostData> E3 = this.t0.L0().E();
                    int size2 = E3.size();
                    boolean z3 = false;
                    for (int i5 = 0; i5 < size2 && !z3; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= E3.get(i5).M().size()) {
                                break;
                            } else if (bVar.f21303g.equals(E3.get(i5).M().get(i6).E())) {
                                E3.get(i5).M().remove(i6);
                                E3.get(i5).l();
                                z3 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        E3.get(i5).n(bVar.f21303g);
                    }
                    if (z3) {
                        this.A0.n1(this.t0.L0());
                    }
                    m4(bVar, this.A0);
                }
            }
        }
    }

    public final void u5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || this.C2 == null) {
            return;
        }
        if (this.A2 == -1) {
            showToast(R.string.pb_manga_not_next_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.C2.a(), this.A2, 0)));
            this.f19309e.finish();
        }
    }

    public final void u6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048739, this) == null) || (absPbActivity = this.f19309e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void v4(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048741, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.A0.i0(this.w0.getLoadDataMode(), gVar.f21318a, gVar.f21319b, false);
        if (gVar.f21318a) {
            this.B0 = true;
            if (i3 == 2 || i3 == 3) {
                this.C0 = true;
                this.D0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.C0 = false;
                this.D0 = true;
            }
            if (i3 == 2) {
                this.t0.L0().N().F3(1);
                this.t0.X1(1);
            } else if (i3 == 3) {
                this.t0.L0().N().F3(0);
                this.t0.X1(0);
            } else if (i3 == 4) {
                this.t0.L0().N().G3(1);
                this.t0.Y1(1);
            } else if (i3 == 5) {
                this.t0.L0().N().G3(0);
                this.t0.Y1(0);
            }
            this.A0.E3(this.t0.L0(), this.t0.Z0());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f21319b)) {
            string = gVar.f21319b;
        } else {
            string = getString(R.string.operation_failed);
        }
        d.a.d.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public void v5(String str) {
        d.a.q0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048742, this, str) == null) || this.t0 == null || StringUtils.isNull(str) || (t0Var = this.A0) == null) {
            return;
        }
        t0Var.w2(true);
        this.t0.w1(str);
        this.K = true;
        this.A0.a0();
        this.A0.X0();
    }

    public final boolean v6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.L0() == null || !this.t0.L0().e0()) {
                if (this.t0.x0()) {
                    MarkData k02 = this.t0.k0();
                    if (k02 != null && this.t0.v0()) {
                        MarkData e02 = this.t0.e0(this.A0.s0());
                        if (e02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", k02);
                            this.f19309e.setResult(-1, intent);
                            return true;
                        } else if (e02.getPostId() != null && !e02.getPostId().equals(k02.getPostId())) {
                            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new o1(this, e02, k02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new p1(this, k02, aVar));
                            aVar.setOnCalcelListener(new q1(this, k02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", k02);
                            this.f19309e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.t0.L0() != null && this.t0.L0().E() != null && this.t0.L0().E().size() > 0 && this.t0.v0()) {
                    this.f19309e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void w4(Rect rect) {
        d.a.q0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048744, this, rect) == null) || rect == null || (t0Var = this.A0) == null || t0Var.U0() == null || rect.top > this.A0.U0().getHeight()) {
            return;
        }
        rect.top += this.A0.U0().getHeight() - rect.top;
    }

    public final void w5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, bundle) == null) {
            PbModel pbModel = this.f19309e.getPbModel();
            this.t0 = pbModel;
            if (pbModel.j0() != null) {
                this.t0.j0().c(this.y2);
            }
            if (this.t0.H0() != null) {
                this.t0.H0().f(this.r1);
            }
            if (StringUtils.isNull(this.t0.b1())) {
                this.f19309e.finish();
            } else if (!"from_tieba_kuang".equals(this.O) || this.O == null) {
            } else {
                this.t0.b2(6);
            }
        }
    }

    public final void w6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.t0.f19512f).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.q0.h2.k.e.g1.a.m(i3))));
        }
    }

    public AntiData x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.L0() == null) {
                return null;
            }
            return this.t0.L0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void x5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || this.C2 == null) {
            return;
        }
        if (this.z2 == -1) {
            showToast(R.string.pb_manga_not_prev_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.C2.a(), this.z2, 0)));
            this.f19309e.finish();
        }
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048749, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.t0.getForumId()) && this.t0.L0() != null && this.t0.L0().m() != null) {
            if (this.t0.L0().m().isLike() == 1) {
                this.t0.b0().A(this.t0.getForumId(), this.t0.b1());
            }
        }
    }

    @Override // d.a.q0.h2.o.b
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? this.t0 : (PbModel) invokeV.objValue;
    }

    public final int y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            if (this.t0.L0() == null || this.t0.L0().N() == null) {
                return -1;
            }
            return this.t0.L0().N().q();
        }
        return invokeV.intValue;
    }

    public final void y5(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048752, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || e4() || !h4()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.b0);
            this.c0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (V4().K0() != null && postData != null) {
            V4().K0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (this.t0.L0() != null && this.t0.L0().e0()) {
            d.a.d.e.m.e.a().postDelayed(new o0(this, str, str2), 0L);
            return;
        }
        if (this.U0 == null) {
            d.a.q0.u0.f2.a.c cVar = new d.a.q0.u0.f2.a.c(getPageContext());
            this.U0 = cVar;
            cVar.k(1);
            this.U0.j(new p0(this, str, str2));
        }
        PbModel pbModel = this.t0;
        if (pbModel == null || pbModel.L0() == null || this.t0.L0().m() == null) {
            return;
        }
        this.U0.h(this.t0.L0().m().getId(), d.a.d.e.m.b.f(this.t0.b1(), 0L));
    }

    public final void y6(d.a.p0.s.q.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048753, this, uVar) == null) || uVar == null) {
            return;
        }
        this.C2 = uVar;
        this.f19311g = true;
        this.A0.g2();
        this.A0.A2(this.B2);
    }

    @Override // d.a.q0.h2.o.b
    public AbsPbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? this.f19309e : (AbsPbActivity) invokeV.objValue;
    }

    public final int z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (V4() != null && V4().B0() != null) {
                BdTypeListView B0 = V4().B0();
                List<d.a.d.k.e.n> data = B0.getData();
                int headerViewsCount = B0.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d.a.d.k.e.n nVar = data.get(i3);
                        if ((nVar instanceof PostData) && nVar.getType() == PostData.u0) {
                            return i3 + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            d.a.q0.h2.h.e L0 = this.t0.L0();
            this.t0.i2(true);
            d.a.p0.i.a aVar = this.v0;
            if (aVar != null) {
                L0.w0(aVar.g());
            }
            this.A0.n1(L0);
        }
    }

    public final void z6(int i3) {
        PbModel pbModel;
        d.a.p0.s.q.b2 N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048757, this, i3) == null) || (pbModel = this.t0) == null || pbModel.L0() == null || (N = this.t0.L0().N()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData H0 = N.H0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (H0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    N.T3(praiseData);
                } else {
                    N.H0().getUser().add(0, metaData);
                    N.H0().setNum(N.H0().getNum() + 1);
                    N.H0().setIsLike(i3);
                }
            }
            if (N.H0() != null) {
                if (N.H0().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    StringHelper.numFormatOver10000(N.H0().getNum());
                }
            }
        } else if (N.H0() != null) {
            N.H0().setIsLike(i3);
            N.H0().setNum(N.H0().getNum() - 1);
            ArrayList<MetaData> user = N.H0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        N.H0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (N.H0().getNum() < 1) {
                getResources().getString(R.string.zan);
            } else {
                String str = N.H0().getNum() + "";
            }
        }
        if (this.t0.Z0()) {
            this.A0.l0().V();
        } else {
            this.A0.G3(this.t0.L0());
        }
    }
}
