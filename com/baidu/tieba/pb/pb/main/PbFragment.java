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
import b.a.q0.c0.d;
import b.a.q0.f1.n.f;
import b.a.q0.i.a;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.d1;
import b.a.q0.s.s.a;
import b.a.q0.s.s.b;
import b.a.q0.s.s.i;
import b.a.r0.k0.a;
import b.a.r0.k0.b;
import b.a.r0.k2.s.c;
import b.a.r0.k2.u.f.c0;
import b.a.r0.k2.u.f.c1.b;
import b.a.r0.k2.u.f.p;
import b.a.r0.k2.z.f;
import b.a.r0.l3.l0.a;
import b.a.r0.x0.q2.a.c;
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
import com.baidu.searchbox.fluency.BdTracesManager;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.PopupDialog;
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
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ItemCardView;
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
import com.baidu.tbadk.download.DownloadData;
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
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
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
/* loaded from: classes9.dex */
public class PbFragment extends BaseFragment implements b.a.q0.f1.n.i, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.t, TbPageContextSupport, b.a.r0.k2.y.b, f.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final AntiHelper.k A2;
    public static final b.InterfaceC0942b B2;
    public static final int CHECK_MUTE_FROM_DIALOG = 2;

    /* renamed from: CHECK_MUTE_FROM＿FLOOR  reason: contains not printable characters */
    public static final int f4CHECK_MUTE_FROMFLOOR = 1;
    public static final String GOD_CALL_URL = "http://tieba.baidu.com/mo/q/god/call/?";
    public static final String PHONE = "2";
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public ForumManageModel A0;
    public CustomMessageListener A1;
    public long B;
    public b.a.q0.t.e.a B0;
    public View.OnClickListener B1;
    public int C;
    public b.a.r0.k2.r.u C0;
    public CustomMessageListener C1;
    public String D;
    public ShareSuccessReplyToServerModel D0;
    public CustomMessageListener D1;
    public b.a.e.e.k.b<TextView> E;
    public b.a.r0.k2.u.f.s0 E0;
    public CustomMessageListener E1;
    public b.a.e.e.k.b<TbImageView> F;
    public boolean F0;
    public SuggestEmotionModel.c F1;
    public b.a.e.e.k.b<ImageView> G;
    public boolean G0;
    public CustomMessageListener G1;
    public b.a.e.e.k.b<View> H;
    public boolean H0;
    public GetSugMatchWordsModel.b H1;
    public b.a.e.e.k.b<TiebaPlusRecommendCard> I;
    public PopupDialog I0;
    public boolean I1;
    public b.a.e.e.k.b<LinearLayout> J;
    public b.a.q0.s.s.i J0;
    public PraiseModel J1;
    public b.a.e.e.k.b<RelativeLayout> K;
    public String K0;
    public b.h K1;
    public b.a.e.e.k.b<ItemCardView> L;
    public boolean L0;
    public CustomMessageListener L1;
    public boolean M;
    public boolean M0;
    public b.a.q0.j0.i M1;
    public boolean N;
    public boolean N0;
    public CheckRealNameModel.b N1;
    public boolean O;
    public String O0;
    public b.a.r0.k2.s.c O1;
    public b.a.e.e.k.b<GifView> P;
    public boolean P0;
    public CustomMessageListener P1;
    public String Q;
    public b.a.r0.l3.j0.f Q0;
    public CustomMessageListener Q1;
    public boolean R;
    public b.a.q0.x.x.g R0;
    public CustomMessageListener R1;
    public boolean S;
    public b.a.q0.x.x.e S0;
    public CustomMessageListener S1;
    public String T;
    public boolean T0;
    public CustomMessageListener T1;
    public b.a.r0.k2.u.f.b1.f.a U;
    public PermissionJudgePolicy U0;
    public CustomMessageListener U1;
    public LikeModel V;
    public b.a.r0.x0.q2.a.c V0;
    public i.e V1;
    public View W;
    public b.a.r0.x0.q2.a.c W0;
    public CustomMessageListener W1;
    public View X;
    public EmotionImageData X0;
    public final NewWriteModel.g X1;
    public View Y;
    public b.a.q0.x.x.c Y0;
    public b.a.e.c.g.a Y1;
    public View Z;
    public b.a.q0.x.x.b Z0;
    public final PbModel.g Z1;
    public String a0;
    public b.a.q0.x.x.b a1;
    public CustomMessageListener a2;
    public int b0;
    public int b1;
    public HttpMessageListener b2;
    public int bjhFrom;
    public boolean c0;
    public Object c1;
    public final a.InterfaceC0664a c2;
    public b.a.e.a.f d1;
    public final AbsListView.OnScrollListener d2;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f52221e;
    public b.a.q0.s.g0.c e1;
    public final b.a.e.a.e e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52222f;
    public BdUniqueId f1;
    public final c3 f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52223g;
    public Runnable g1;
    public final f.g g2;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.k0.b f52224h;
    public b.a.r0.k2.u.f.w0 h1;
    public boolean h2;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.k2.u.f.c1.b f52225i;
    public int[] i0;
    public b.a.e.l.d.a i1;
    public final BdListView.p i2;
    public boolean j;
    public int j0;
    public String j1;
    public int j2;
    public boolean k;
    public int k0;
    public TbRichTextMemeInfo k1;
    public final TbRichTextView.z k2;
    public boolean l;
    public int l0;
    public boolean l1;
    public boolean l2;
    public String lastTid;
    public boolean m;
    public b.a.q0.s.q.n1 m0;
    public int m1;
    public PostData m2;
    public final View.OnClickListener mCommonOnClickListener;
    public b.a.r0.k2.u.f.u0 mContentProcessController;
    public a.e mDialogClickListener;
    public CustomMessageListener mFirstFloorPraiseListener;
    public boolean mKeyboardIsVisible;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public View.OnTouchListener mOnTouchListener;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public boolean n;
    public b.a.q0.s.c0.a n0;
    public int n1;
    public final b.c n2;
    public VoiceManager o;
    public boolean o0;
    public List<a3> o1;
    public final b.c o2;
    public SortSwitchButton.f onSwitchChangeListener;
    public int p;
    public boolean p0;
    public b.a.r0.a0.a p1;
    public final AdapterView.OnItemClickListener p2;
    public b.a.q0.s.s.b q;
    public Object q0;
    public final a3 q1;
    public final View.OnLongClickListener q2;
    public long r;
    public b.a.r0.l3.j0.e r0;
    public final c0.b r1;
    public final View.OnClickListener r2;
    public long s;
    public boolean s0;
    public final CustomMessageListener s1;
    public final ItemCardHelper.c s2;
    public BdUniqueId sortSwitchId;
    public long t;
    @NonNull
    public TiePlusEventController.d t0;
    public CustomMessageListener t1;
    public final NoNetworkView.b t2;
    public long u;
    public b.a.r0.k2.u.f.e1.a u0;
    public CustomMessageListener u1;
    public a.b u2;
    public long v;
    public PbInterviewStatusView.f v0;
    public CustomMessageListener v1;
    public final p.b v2;
    public boolean w;
    public final Handler w0;
    public CustomMessageListener w1;
    public int w2;
    public boolean x;
    public PbModel x0;
    public CustomMessageListener x1;
    public int x2;
    public b.a.q0.q0.b y;
    public b.a.r0.k2.u.g.a y0;
    public CustomMessageListener y1;
    public String y2;
    public long z;
    public b.a.q0.i.a z0;
    public final CustomMessageListener z1;
    public b.a.q0.s.q.u z2;

    /* loaded from: classes9.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(PbFragment pbFragment) {
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
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a0 implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52226a;

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
            this.f52226a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f52226a.E0.x3(!this.f52226a.R);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52227e;

        /* loaded from: classes9.dex */
        public class a implements i.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopupDialog f52228e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f52229f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a1 f52230g;

            public a(a1 a1Var, PopupDialog popupDialog, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a1Var, popupDialog, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52230g = a1Var;
                this.f52228e = popupDialog;
                this.f52229f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f52230g.f52227e.x0.c1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // b.a.q0.s.s.i.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
                boolean v2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                    return;
                }
                this.f52228e.dismiss();
                int i3 = 3;
                if (this.f52230g.f52227e.x0.c1() != 1 || i2 != 1) {
                    if (this.f52230g.f52227e.x0.c1() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (this.f52230g.f52227e.x0.c1() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f52229f.getId() != b.a.r0.k2.i.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (this.f52230g.f52227e.x0.P0().f18762f != null && this.f52230g.f52227e.x0.P0().f18762f.size() > i2) {
                        i2 = this.f52230g.f52227e.x0.P0().f18762f.get(i2).sort_type.intValue();
                    }
                    v2 = this.f52230g.f52227e.x0.v2(i2);
                    this.f52229f.setTag(Integer.valueOf(this.f52230g.f52227e.x0.b1()));
                    if (v2) {
                        return;
                    }
                    this.f52230g.f52227e.m = true;
                    this.f52230g.f52227e.E0.E2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f52229f.getId() != b.a.r0.k2.i.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f52230g.f52227e.x0.P0().f18762f != null) {
                    i2 = this.f52230g.f52227e.x0.P0().f18762f.get(i2).sort_type.intValue();
                }
                v2 = this.f52230g.f52227e.x0.v2(i2);
                this.f52229f.setTag(Integer.valueOf(this.f52230g.f52227e.x0.b1()));
                if (v2) {
                }
            }
        }

        public a1(PbFragment pbFragment) {
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
            this.f52227e = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:899:0x2095, code lost:
            if (r39.f52227e.E0.S0.f19462c.getView().getTop() <= ((r39.f52227e.E0.P0() == null || r39.f52227e.E0.P0().c() == null) ? 0 : r39.f52227e.E0.P0().c().getBottom())) goto L840;
         */
        /* JADX WARN: Code restructure failed: missing block: B:900:0x2097, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:902:0x20a4, code lost:
            if (r0 >= b.a.r0.k2.u.f.a1.k.c(r39.f52227e.getListView())) goto L840;
         */
        /* JADX WARN: Code restructure failed: missing block: B:924:0x214b, code lost:
            if ((r39.f52227e.E0.S0.f19462c.getView().getTop() - r39.f52227e.E0.f19406h.f19282a.getBottom()) < (r39.f52227e.E0.S0.f19462c.mDivideLineTop.getHeight() + 10)) goto L840;
         */
        /* JADX WARN: Removed duplicated region for block: B:1171:0x2a05  */
        /* JADX WARN: Removed duplicated region for block: B:1172:0x2a1a  */
        /* JADX WARN: Removed duplicated region for block: B:1175:0x2a53  */
        /* JADX WARN: Removed duplicated region for block: B:301:0x09f0  */
        /* JADX WARN: Removed duplicated region for block: B:302:0x09f5  */
        /* JADX WARN: Removed duplicated region for block: B:305:0x0a03  */
        /* JADX WARN: Removed duplicated region for block: B:340:0x0aba  */
        /* JADX WARN: Removed duplicated region for block: B:343:0x0acd  */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0ade  */
        /* JADX WARN: Removed duplicated region for block: B:349:0x0af6  */
        /* JADX WARN: Removed duplicated region for block: B:351:0x0afe  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            b.a.q0.s.s.f fVar;
            b.a.q0.s.s.f fVar2;
            b.a.q0.s.s.f fVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            b.a.q0.s.s.f fVar4;
            b.a.q0.s.s.f fVar5;
            b.a.q0.s.s.f fVar6;
            b.a.q0.s.s.f fVar7;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            b.a.q0.s.q.i2 i2Var;
            String d2;
            String[] strArr;
            b.a.r0.k2.r.f P0;
            int i5;
            int i6;
            boolean u2;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f52227e.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.f52227e.E0.H0() && this.f52227e.getPageContext().getPageActivity() != null && this.f52227e.x0 != null) {
                        this.f52227e.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.f52227e.getPageContext().getPageActivity(), this.f52227e.x0.f1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.f52227e.x0.getForumId());
                        statisticItem2.param("fname", this.f52227e.x0.q0());
                        statisticItem2.param("tid", this.f52227e.x0.f1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view == this.f52227e.E0.J0()) {
                        if (this.f52227e.m) {
                            return;
                        }
                        if (this.f52227e.x0.B1(true)) {
                            this.f52227e.m = true;
                            this.f52227e.E0.R2();
                        }
                    } else if (view != this.f52227e.E0.f19406h.m()) {
                        if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().k()) {
                            if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().d()) {
                                if (view == this.f52227e.E0.f19406h.f19287f) {
                                    if (this.f52227e.E0.S(this.f52227e.x0.D0())) {
                                        this.f52227e.stopVoice();
                                        return;
                                    }
                                    this.f52227e.n = false;
                                    this.f52227e.j = false;
                                    b.a.e.e.p.l.x(this.f52227e.f52221e, this.f52227e.E0.f19406h.f19287f);
                                    this.f52227e.f52221e.finish();
                                } else if (view != this.f52227e.E0.p0() && (this.f52227e.E0.f19406h.n() == null || (view != this.f52227e.E0.f19406h.n().l() && view != this.f52227e.E0.f19406h.n().m()))) {
                                    if (view == this.f52227e.E0.x0()) {
                                        if (this.f52227e.x0 != null) {
                                            b.a.q0.m.a.l(this.f52227e.getPageContext().getPageActivity(), this.f52227e.x0.P0().O().w1().b());
                                        }
                                    } else if (view != this.f52227e.E0.f19406h.f19284c) {
                                        if (view == this.f52227e.E0.f19406h.f19285d) {
                                            if (b.a.q0.d1.o.a()) {
                                                return;
                                            }
                                            if (this.f52227e.x0 != null && this.f52227e.x0.P0() != null) {
                                                ArrayList<PostData> F = this.f52227e.x0.P0().F();
                                                if ((F == null || F.size() <= 0) && this.f52227e.x0.d1()) {
                                                    b.a.e.e.p.l.M(this.f52227e.getPageContext().getPageActivity(), this.f52227e.getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f52227e.x0.f1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f52227e.x0.getForumId()));
                                                if (!this.f52227e.E0.F1()) {
                                                    this.f52227e.E0.o2();
                                                }
                                                this.f52227e.openMore();
                                            } else {
                                                b.a.e.e.p.l.M(this.f52227e.getPageContext().getPageActivity(), this.f52227e.getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                                                return;
                                            }
                                        } else if (view.getId() == b.a.r0.k2.i.pb_god_user_tip_content) {
                                            if (b.a.e.e.p.j.z()) {
                                                this.f52227e.E0.B2(true);
                                                this.f52227e.E0.o2();
                                                if (this.f52227e.m) {
                                                    return;
                                                }
                                                this.f52227e.m = true;
                                                this.f52227e.E0.u3();
                                                this.f52227e.stopVoice();
                                                this.f52227e.E0.Q2();
                                                this.f52227e.x0.t2(this.f52227e.P2());
                                                TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                                return;
                                            }
                                        } else if (view.getId() != b.a.r0.k2.i.pb_editor_tool_collection) {
                                            if ((this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().i()) && view.getId() != b.a.r0.k2.i.floor_owner_reply && view.getId() != b.a.r0.k2.i.reply_title) {
                                                if (this.f52227e.E0.f19406h.n() != null && view == this.f52227e.E0.f19406h.n().e()) {
                                                    this.f52227e.E0.f19406h.k();
                                                } else if (view.getId() == b.a.r0.k2.i.share_num_container) {
                                                    if (!this.f52227e.E2(11009)) {
                                                        return;
                                                    }
                                                    this.f52227e.c3(3);
                                                } else if (view.getId() != b.a.r0.k2.i.pb_editor_tool_share) {
                                                    if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().j()) {
                                                        if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().q()) {
                                                            if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().p()) {
                                                                if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().n()) {
                                                                    if (this.f52227e.E0.B0() == view) {
                                                                        if (this.f52227e.E0.B0().getIndicateStatus()) {
                                                                            b.a.r0.k2.r.f P02 = this.f52227e.x0.P0();
                                                                            if (P02 != null && P02.O() != null && P02.O().j1() != null) {
                                                                                String d3 = P02.O().j1().d();
                                                                                if (StringUtils.isNull(d3)) {
                                                                                    d3 = P02.O().j1().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d3));
                                                                            }
                                                                        } else {
                                                                            b.a.r0.l3.l0.a.d("c10725", null);
                                                                        }
                                                                        this.f52227e.goInterviewLivePage();
                                                                    } else if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().g()) {
                                                                        if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().c()) {
                                                                            if (this.f52227e.E0.f19406h.n() != null && view == this.f52227e.E0.f19406h.n().f()) {
                                                                                if (b.a.e.e.p.j.z()) {
                                                                                    SparseArray<Object> F0 = this.f52227e.E0.F0(this.f52227e.x0.P0(), this.f52227e.x0.d1(), 1);
                                                                                    if (F0 != null) {
                                                                                        if (StringUtils.isNull((String) F0.get(b.a.r0.k2.i.tag_del_multi_forum))) {
                                                                                            this.f52227e.E0.W1(((Integer) F0.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) F0.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) F0.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) F0.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                                                                        } else {
                                                                                            this.f52227e.E0.X1(((Integer) F0.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) F0.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) F0.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) F0.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue(), (String) F0.get(b.a.r0.k2.i.tag_del_multi_forum));
                                                                                        }
                                                                                    }
                                                                                    this.f52227e.E0.f19406h.k();
                                                                                } else {
                                                                                    this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() != b.a.r0.k2.i.sub_pb_more && view.getId() != b.a.r0.k2.i.sub_pb_item && view.getId() != b.a.r0.k2.i.pb_floor_reply_more && view.getId() != b.a.r0.k2.i.new_sub_pb_list_richText) {
                                                                                if (view.getId() == b.a.r0.k2.i.pb_post_reply_count) {
                                                                                    if (this.f52227e.x0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.f52227e.x0.f1());
                                                                                    statisticItem3.param("fid", this.f52227e.x0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view.getId() == b.a.r0.k2.i.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52227e.getActivity(), "pb_chakanhuifu"))) {
                                                                                        this.f52227e.X = view;
                                                                                        return;
                                                                                    } else if (!this.f52227e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                        if (!(sparseArray2.get(b.a.r0.k2.i.tag_load_sub_data) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(b.a.r0.k2.i.tag_load_sub_data);
                                                                                        StatisticItem statisticItem4 = postData.l0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String f1 = this.f52227e.x0.f1();
                                                                                        String G = postData.G();
                                                                                        int V = this.f52227e.x0.P0() != null ? this.f52227e.x0.P0().V() : 0;
                                                                                        AbsPbActivity.e v3 = this.f52227e.v3(G);
                                                                                        if (v3 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f52227e.getPageContext().getPageActivity()).createSubPbActivityConfig(f1, G, "pb", true, false, null, false, null, V, postData.R(), this.f52227e.x0.P0().d(), false, postData.t().getIconInfo(), 5).addBigImageData(v3.f52184a, v3.f52185b, v3.f52190g, v3.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.f52227e.x0.O0());
                                                                                        addBigImageData.setFromFrsForumId(this.f52227e.x0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.f52227e.x0.k1());
                                                                                        addBigImageData.setKeyFromForumId(this.f52227e.x0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.f52227e.x0.F(), this.f52227e.x0.B(), this.f52227e.x0.C(), this.f52227e.x0.A(), this.f52227e.x0.G());
                                                                                        addBigImageData.setBjhData(this.f52227e.x0.j0());
                                                                                        if (this.f52227e.x0.P0().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.f52227e.x0.P0().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.f52227e.x0.P0().U() != null) {
                                                                                            addBigImageData.setIsManager(this.f52227e.x0.P0().U().getIs_manager());
                                                                                        }
                                                                                        if (this.f52227e.x0.P0().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.f52227e.x0.P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.f52227e.x0.P0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.f52227e.x0.P0().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.f52227e.x0.P0().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.f52227e.x0.P0().l().getUser_level());
                                                                                        }
                                                                                        if (this.f52227e.E0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.f52227e.E0.v0(this.f52227e.x0.J, this.f52227e.x0.d1()).U || postData.U);
                                                                                        }
                                                                                        this.f52227e.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view.getId() == b.a.r0.k2.i.pb_post_reply || view.getId() == b.a.r0.k2.i.post_info_commont_img || view.getId() == b.a.r0.k2.i.pb_floor_comment_container) {
                                                                                    if (this.f52227e.x0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view.getId() == b.a.r0.k2.i.pb_post_reply) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.f52227e.x0.f1());
                                                                                        statisticItem5.param("fid", this.f52227e.x0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view.getId() == b.a.r0.k2.i.post_info_commont_img) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52227e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                            this.f52227e.Y = view;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view.getId() == b.a.r0.k2.i.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52227e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                        this.f52227e.Y = view;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.f52227e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                    if (!(sparseArray3.get(b.a.r0.k2.i.tag_load_sub_data) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(b.a.r0.k2.i.tag_load_sub_data);
                                                                                    if (view.getId() == b.a.r0.k2.i.pb_post_reply && (statisticItem = postData2.l0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view.getId() == b.a.r0.k2.i.post_info_commont_img || view.getId() == b.a.r0.k2.i.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f52227e.x0.g1()).param("fid", this.f52227e.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null || this.f52227e.getPbView().N0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.f52227e.getPbView().O0() != null) {
                                                                                        this.f52227e.getPbView().O0().c();
                                                                                    }
                                                                                    if (this.f52227e.s0 && postData2.O() != null && postData2.O().size() != 0) {
                                                                                        this.f52227e.Y3(postData2, true);
                                                                                    } else {
                                                                                        b.a.r0.k2.r.s sVar = new b.a.r0.k2.r.s();
                                                                                        sVar.A(this.f52227e.x0.P0().l());
                                                                                        sVar.E(this.f52227e.x0.P0().O());
                                                                                        sVar.C(postData2);
                                                                                        this.f52227e.getPbView().N0().S(sVar);
                                                                                        this.f52227e.getPbView().N0().setPostId(postData2.G());
                                                                                        this.f52227e.o3(view, postData2.t().getUserId(), "", postData2);
                                                                                        if (this.f52227e.S0 != null) {
                                                                                            this.f52227e.E0.v2(this.f52227e.S0.D());
                                                                                        }
                                                                                    }
                                                                                } else if (view.getId() != b.a.r0.k2.i.pb_floor_feedback) {
                                                                                    if (view != this.f52227e.E0.z0()) {
                                                                                        if (view == this.f52227e.E0.f19406h.o()) {
                                                                                            this.f52227e.E0.Y2();
                                                                                        } else if (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().o()) {
                                                                                            if (this.f52227e.E0.f19406h.n() != null && view == this.f52227e.E0.f19406h.n().h()) {
                                                                                                b.a.q0.t.c.k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (d2 = tiebaPlusConfigData.d(this.f52227e.x0.f1())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.f52227e.getPageContext(), new String[]{d2});
                                                                                                    this.f52227e.E0.f19406h.k();
                                                                                                    b.a.q0.t.c.k0.a(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view.getId();
                                                                                                if (id == b.a.r0.k2.i.pb_u9_text_view) {
                                                                                                    if (!this.f52227e.checkUpIsLogin() || (i2Var = (b.a.q0.s.q.i2) view.getTag()) == null || StringUtils.isNull(i2Var.I0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.f52227e.getPageContext(), new String[]{i2Var.I0()});
                                                                                                } else if (id != b.a.r0.k2.i.replybtn && id != b.a.r0.k2.i.cover_reply_content && id != b.a.r0.k2.i.replybtn_top_right && id != b.a.r0.k2.i.cover_reply_content_top_right) {
                                                                                                    if (id == b.a.r0.k2.i.pb_act_btn) {
                                                                                                        if (this.f52227e.x0.P0() != null && this.f52227e.x0.P0().O() != null && this.f52227e.x0.P0().O().x() != null) {
                                                                                                            b.a.q0.m.a.l(this.f52227e.getActivity(), this.f52227e.x0.P0().O().x());
                                                                                                            if (this.f52227e.x0.P0().O().w() != 1) {
                                                                                                                if (this.f52227e.x0.P0().O().w() == 2) {
                                                                                                                    TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                                }
                                                                                                            } else {
                                                                                                                TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.lottery_tail) {
                                                                                                        if (view.getTag(b.a.r0.k2.i.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                            String str = (String) view.getTag(b.a.r0.k2.i.tag_pb_lottery_tail_link);
                                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.f52227e.x0.P0().m()).param("tid", this.f52227e.x0.P0().Q()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                            if (this.f52227e.x0.P0().Q().equals(str)) {
                                                                                                                this.f52227e.E0.U2(0);
                                                                                                            } else {
                                                                                                                this.f52227e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f52227e.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.pb_item_tail_content) {
                                                                                                        if (ViewHelper.checkUpIsLogin(this.f52227e.getPageContext().getPageActivity())) {
                                                                                                            String string = TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.tail_web_view_title);
                                                                                                            String p = b.a.q0.s.e0.b.j().p("tail_link", "");
                                                                                                            if (!StringUtils.isNull(p)) {
                                                                                                                TiebaStatic.log("c10056");
                                                                                                                b.a.q0.m.a.p(view.getContext(), string, p, true, true, true);
                                                                                                            }
                                                                                                            this.f52227e.E0.o2();
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.join_vote_tv) {
                                                                                                        if (view != null) {
                                                                                                            b.a.q0.m.a.l(this.f52227e.getActivity(), (String) view.getTag());
                                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                            if (this.f52227e.N2() == 1 && this.f52227e.x0 != null && this.f52227e.x0.P0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", this.f52227e.x0.P0().m()).param("tid", this.f52227e.x0.P0().Q()).param("uid", currentAccount));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.look_all_tv) {
                                                                                                        if (view != null) {
                                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                            b.a.q0.m.a.l(this.f52227e.getActivity(), (String) view.getTag());
                                                                                                            if (this.f52227e.N2() == 1 && this.f52227e.x0 != null && this.f52227e.x0.P0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", this.f52227e.x0.P0().m()).param("tid", this.f52227e.x0.P0().Q()).param("uid", currentAccount2));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.manga_prev_btn) {
                                                                                                        this.f52227e.n3();
                                                                                                    } else if (id == b.a.r0.k2.i.manga_next_btn) {
                                                                                                        this.f52227e.l3();
                                                                                                    } else if (id == b.a.r0.k2.i.yule_head_img_img) {
                                                                                                        if (this.f52227e.x0 != null && this.f52227e.x0.P0() != null && this.f52227e.x0.P0().A() != null) {
                                                                                                            b.a.r0.k2.r.f P03 = this.f52227e.x0.P0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", P03.m()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f52227e.getPageContext(), new String[]{P03.A().b()});
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.yule_head_img_all_rank) {
                                                                                                        if (this.f52227e.x0 != null && this.f52227e.x0.P0() != null && this.f52227e.x0.P0().A() != null) {
                                                                                                            b.a.r0.k2.r.f P04 = this.f52227e.x0.P0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", P04.m()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f52227e.getPageContext(), new String[]{P04.A().b()});
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.tv_pb_reply_more) {
                                                                                                        if (this.f52227e.m1 >= 0) {
                                                                                                            if (this.f52227e.x0 != null) {
                                                                                                                this.f52227e.x0.X1();
                                                                                                            }
                                                                                                            if (this.f52227e.x0 == null || this.f52227e.E0.n0() == null) {
                                                                                                                i4 = 0;
                                                                                                            } else {
                                                                                                                i4 = 0;
                                                                                                                this.f52227e.E0.n0().c0(this.f52227e.x0.P0(), false);
                                                                                                            }
                                                                                                            this.f52227e.m1 = i4;
                                                                                                            if (this.f52227e.x0 != null) {
                                                                                                                this.f52227e.E0.E0().setSelection(this.f52227e.x0.I0());
                                                                                                                this.f52227e.x0.b2(0, 0);
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.qq_share_container) {
                                                                                                        if (!this.f52227e.E2(11009)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f52227e.c3(8);
                                                                                                    } else if (id == b.a.r0.k2.i.new_sub_pb_list_richText) {
                                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                                        if (sparseArray4 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f52227e.X3(sparseArray4);
                                                                                                    } else if (id == b.a.r0.k2.i.pb_editor_tool_comment_icon) {
                                                                                                        if (this.f52227e.E0.E0() == null || this.f52227e.x0 == null || this.f52227e.x0.P0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        int firstVisiblePosition = this.f52227e.E0.E0().getFirstVisiblePosition();
                                                                                                        View childAt = this.f52227e.E0.E0().getChildAt(0);
                                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                                        boolean r0 = this.f52227e.x0.P0().r0();
                                                                                                        boolean z3 = this.f52227e.E0.P0() != null && this.f52227e.E0.P0().g();
                                                                                                        boolean D1 = this.f52227e.E0.D1();
                                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                        if (!r0 || this.f52227e.E0.P0() == null || this.f52227e.E0.P0().c() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            int k = ((int) (b.a.e.e.p.l.k(this.f52227e.getContext()) * 0.5625d)) - this.f52227e.E0.P0().e();
                                                                                                            i3 = k;
                                                                                                            z4 = firstVisiblePosition == 0 && (top == k || top == this.f52227e.E0.P0().c().getHeight() - this.f52227e.E0.P0().e());
                                                                                                        }
                                                                                                        this.f52227e.J2(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                        if ((this.f52227e.x0.P0().O() != null && this.f52227e.x0.P0().O().U0() <= 0) || (D1 && z4)) {
                                                                                                            if (!this.f52227e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            this.f52227e.processProfessionPermission();
                                                                                                            if (this.f52227e.x0.P0().O().J() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52227e.x0.f52416f).param("fid", this.f52227e.x0.P0().m()).param("obj_locate", 2).param("uid", this.f52227e.x0.P0().O().J().getUserId()));
                                                                                                            }
                                                                                                        } else {
                                                                                                            int i9 = (int) (b.a.e.e.p.l.i(this.f52227e.getContext()) * 0.6d);
                                                                                                            if (r0) {
                                                                                                                if (this.f52227e.E0.S0 != null && this.f52227e.E0.S0.f19462c != null && this.f52227e.E0.S0.f19462c.getView() != null) {
                                                                                                                    if (this.f52227e.E0.S0.f19462c.getView().getParent() != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            } else {
                                                                                                                if (this.f52227e.E0.M0() != null) {
                                                                                                                    z2 = this.f52227e.E0.M0().getVisibility() == 0;
                                                                                                                    if (!z2 && this.f52227e.E0.S0 != null && this.f52227e.E0.S0.f19462c != null && this.f52227e.E0.S0.f19462c.getView() != null && this.f52227e.E0.S0.f19462c.getView().getParent() != null && this.f52227e.E0.f19406h != null && this.f52227e.E0.f19406h.f19282a != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            }
                                                                                                            if (z2 || D1) {
                                                                                                                this.f52227e.k0 = firstVisiblePosition;
                                                                                                                this.f52227e.l0 = top;
                                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                                    this.f52227e.E0.E0().setSelectionFromTop(0, i3 - i9);
                                                                                                                    this.f52227e.E0.E0().smoothScrollBy(-i9, 500);
                                                                                                                } else {
                                                                                                                    this.f52227e.E0.E0().smoothScrollToPosition(0, i3, 500);
                                                                                                                }
                                                                                                            } else if (this.f52227e.k0 > 0) {
                                                                                                                if (this.f52227e.E0.E0().getChildAt(this.f52227e.k0) != null) {
                                                                                                                    this.f52227e.E0.E0().smoothScrollToPosition(this.f52227e.k0, this.f52227e.l0, 200);
                                                                                                                } else {
                                                                                                                    this.f52227e.E0.E0().setSelectionFromTop(this.f52227e.k0, this.f52227e.l0 + i9);
                                                                                                                    this.f52227e.E0.E0().smoothScrollBy(i9, 500);
                                                                                                                }
                                                                                                            } else {
                                                                                                                int c2 = b.a.r0.k2.u.f.a1.k.c(this.f52227e.getListView());
                                                                                                                if (b.a.r0.k2.u.f.a1.k.d(this.f52227e.getListView()) != -1) {
                                                                                                                    c2--;
                                                                                                                }
                                                                                                                int g2 = b.a.e.e.p.l.g(this.f52227e.getContext(), b.a.r0.k2.g.tbds100);
                                                                                                                if (c2 < 0) {
                                                                                                                    c2 = (ListUtils.getCount(this.f52227e.E0.E0().getData()) - 1) + this.f52227e.E0.E0().getHeaderViewsCount();
                                                                                                                    g2 = 0;
                                                                                                                }
                                                                                                                if (!z3) {
                                                                                                                    if (!r0 || this.f52227e.E0.P0() == null) {
                                                                                                                        if (this.f52227e.E0.f19406h != null && this.f52227e.E0.f19406h.f19282a != null) {
                                                                                                                            fixedNavHeight = this.f52227e.E0.f19406h.f19282a.getFixedNavHeight() - 10;
                                                                                                                        }
                                                                                                                        if (this.f52227e.E0.S0 != null || this.f52227e.E0.S0.f19462c == null || this.f52227e.E0.S0.f19462c.getView() == null || this.f52227e.E0.S0.f19462c.getView().getParent() == null) {
                                                                                                                            this.f52227e.E0.E0().setSelectionFromTop(c2, g2 + i9);
                                                                                                                            this.f52227e.E0.E0().smoothScrollBy(i9, 500);
                                                                                                                        } else if (!z3) {
                                                                                                                            this.f52227e.E0.E0().smoothScrollToPosition(c2, g2, 200);
                                                                                                                        } else {
                                                                                                                            this.f52227e.E0.E0().smoothScrollBy(this.f52227e.E0.S0.f19462c.getView().getTop() - ((int) (b.a.e.e.p.l.k(this.f52227e.getContext()) * 0.5625d)), 500);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        fixedNavHeight = this.f52227e.E0.P0().d();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = (int) (b.a.e.e.p.l.k(this.f52227e.getContext()) * 0.5625d);
                                                                                                                }
                                                                                                                g2 += fixedNavHeight;
                                                                                                                if (this.f52227e.E0.S0 != null) {
                                                                                                                }
                                                                                                                this.f52227e.E0.E0().setSelectionFromTop(c2, g2 + i9);
                                                                                                                this.f52227e.E0.E0().smoothScrollBy(i9, 500);
                                                                                                            }
                                                                                                        }
                                                                                                        if (this.f52227e.x0.P0().O() != null && this.f52227e.x0.P0().O().J() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52227e.x0.f52416f).param("fid", this.f52227e.x0.P0().m()).param("obj_locate", 2).param("uid", this.f52227e.x0.P0().O().J().getUserId()));
                                                                                                        }
                                                                                                    } else if (id == b.a.r0.k2.i.pb_nav_title_forum_image || id == b.a.r0.k2.i.pb_nav_title_forum_name) {
                                                                                                        if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null || this.f52227e.x0.P0().l() == null || b.a.e.e.p.k.isEmpty(this.f52227e.x0.P0().l().getName())) {
                                                                                                            return;
                                                                                                        }
                                                                                                        if (this.f52227e.x0.getErrorNo() == 4) {
                                                                                                            if (!StringUtils.isNull(this.f52227e.x0.q0()) || this.f52227e.x0.g0() == null) {
                                                                                                                this.f52227e.f52221e.finish();
                                                                                                                return;
                                                                                                            }
                                                                                                            name = this.f52227e.x0.g0().f18752b;
                                                                                                        } else {
                                                                                                            name = this.f52227e.x0.P0().l().getName();
                                                                                                        }
                                                                                                        if (StringUtils.isNull(name)) {
                                                                                                            this.f52227e.f52221e.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        String q0 = this.f52227e.x0.q0();
                                                                                                        if (this.f52227e.x0.v0() && q0 != null && q0.equals(name)) {
                                                                                                            this.f52227e.f52221e.finish();
                                                                                                        } else {
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f52227e.getActivity()).createNormalCfg(this.f52227e.x0.P0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                        }
                                                                                                        StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                        statisticItem6.param("tid", this.f52227e.x0.f1());
                                                                                                        statisticItem6.param("fid", this.f52227e.x0.getForumId());
                                                                                                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        if (this.f52227e.x0.P0().O() != null) {
                                                                                                            statisticItem6.param("nid", this.f52227e.x0.P0().O().F0());
                                                                                                        }
                                                                                                        TiebaStatic.log(statisticItem6);
                                                                                                    } else if (id != b.a.r0.k2.i.forum_name_text && id != b.a.r0.k2.i.forum_enter_button_one && id != b.a.r0.k2.i.forum_enter_button_two && id != b.a.r0.k2.i.forum_enter_button_three) {
                                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                            if (this.f52227e.x0 == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                            statisticItem7.param("tid", this.f52227e.x0.f1());
                                                                                                            statisticItem7.param("fid", this.f52227e.x0.getForumId());
                                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem7.param("obj_locate", 2);
                                                                                                            TiebaStatic.log(statisticItem7);
                                                                                                        } else if (id == b.a.r0.k2.i.pb_thread_post_button) {
                                                                                                            if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            b.a.r0.k2.r.f P05 = this.f52227e.x0.P0();
                                                                                                            if (this.f52227e.C0 == null) {
                                                                                                                PbFragment pbFragment2 = this.f52227e;
                                                                                                                pbFragment2.C0 = new b.a.r0.k2.r.u(pbFragment2.getPageContext());
                                                                                                            }
                                                                                                            long g3 = b.a.e.e.m.b.g(P05.Q(), 0L);
                                                                                                            long g4 = b.a.e.e.m.b.g(P05.m(), 0L);
                                                                                                            new StatisticItem("c13446").param("forum_id", g4).eventStat();
                                                                                                            PbFragment pbFragment3 = this.f52227e;
                                                                                                            pbFragment3.registerListener(pbFragment3.Y1);
                                                                                                            this.f52227e.C0.a(g3, g4);
                                                                                                        } else if (id == b.a.r0.k2.i.pb_video_thread_smart_app_layout) {
                                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                                if (!b.a.r0.v.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    b.a.q0.m.a.l(this.f52227e.getActivity(), smartApp.h5_url);
                                                                                                                }
                                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.f52227e.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM).param("tid", this.f52227e.x0.f1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                            }
                                                                                                        } else if (id == b.a.r0.k2.i.id_pb_business_promotion_wrapper) {
                                                                                                            if (!(view.getTag() instanceof b.a.q0.s.q.d2)) {
                                                                                                                return;
                                                                                                            }
                                                                                                            b.a.q0.s.q.d2 d2Var = (b.a.q0.s.q.d2) view.getTag();
                                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f52227e.getActivity()).createNormalCfg(d2Var.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", d2Var.T()).param("tid", d2Var.f0()).param("thread_type", d2Var.o1()).param(TiebaStatic.Params.IS_ZP, d2Var.I2() ? 1 : 0));
                                                                                                        } else if (id == b.a.r0.k2.i.id_pb_business_promotion_attention) {
                                                                                                            if (!(view.getTag() instanceof b.a.q0.s.q.d2) || !this.f52227e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            b.a.q0.s.q.d2 d2Var2 = (b.a.q0.s.q.d2) view.getTag();
                                                                                                            if (this.f52227e.V != null) {
                                                                                                                this.f52227e.V.L(d2Var2.Z(), String.valueOf(d2Var2.T()));
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", d2Var2.T()).param("tid", d2Var2.f0()).param("thread_type", d2Var2.o1()).param(TiebaStatic.Params.IS_ZP, d2Var2.I2() ? 1 : 0));
                                                                                                        } else if (id == b.a.r0.k2.i.pb_floor_right_top_feedback || id == b.a.r0.k2.i.pb_post_op_more) {
                                                                                                            StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                            statisticItem8.param("tid", this.f52227e.x0.f1());
                                                                                                            statisticItem8.param("fid", this.f52227e.x0.getForumId());
                                                                                                            statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem8.param("obj_locate", 7);
                                                                                                            TiebaStatic.log(statisticItem8);
                                                                                                            PbFragment pbFragment4 = this.f52227e;
                                                                                                            pbFragment4.f52222f = false;
                                                                                                            pbFragment4.H2(view);
                                                                                                        }
                                                                                                    } else if (!(view.getTag() instanceof b.a.q0.s.q.d2)) {
                                                                                                        return;
                                                                                                    } else {
                                                                                                        b.a.q0.s.q.d2 d2Var3 = (b.a.q0.s.q.d2) view.getTag();
                                                                                                        if (this.f52227e.x0.O0() == 3 && this.f52227e.isSimpleForum() && this.f52227e.x0.P0() != null && ListUtils.isEmpty(this.f52227e.x0.P0().p())) {
                                                                                                            this.f52227e.f52221e.finish();
                                                                                                        } else {
                                                                                                            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f52227e.getActivity()).createNormalCfg(d2Var3.Z(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg2.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                                        }
                                                                                                        StatisticItem statisticItem9 = new StatisticItem("c13399");
                                                                                                        statisticItem9.param("tid", d2Var3.f0());
                                                                                                        statisticItem9.param("fid", d2Var3.T());
                                                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem9.param("nid", d2Var3.F0());
                                                                                                        TiebaStatic.log(statisticItem9);
                                                                                                    }
                                                                                                } else if (!this.f52227e.checkUpIsLogin()) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view != null && view.getTag() != null) {
                                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray5.get(b.a.r0.k2.i.tag_load_sub_data);
                                                                                                        if (id == b.a.r0.k2.i.replybtn_top_right || id == b.a.r0.k2.i.cover_reply_content_top_right) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.f52227e.x0.f52416f));
                                                                                                        }
                                                                                                        if (this.f52227e.J0 == null) {
                                                                                                            PbFragment pbFragment5 = this.f52227e;
                                                                                                            pbFragment5.J0 = new b.a.q0.s.s.i(pbFragment5.getContext());
                                                                                                            this.f52227e.J0.m(this.f52227e.V1);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.f52227e.isImage(view);
                                                                                                        if (this.f52227e.isImage(view) && this.f52227e.i1 != null) {
                                                                                                            this.f52227e.i1.t();
                                                                                                        }
                                                                                                        if (sparseArray5.get(b.a.r0.k2.i.tag_is_subpb) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_is_subpb)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray5.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray5.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray5.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray5.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray5.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
                                                                                                        String str2 = sparseArray5.get(b.a.r0.k2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray5.get(b.a.r0.k2.i.tag_forbid_user_post_id) : null;
                                                                                                        boolean booleanValue6 = sparseArray5.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.M() != null && postData3.M().toString().length() > 0) {
                                                                                                                b.a.q0.s.s.f fVar8 = new b.a.q0.s.s.f(3, this.f52227e.getString(b.a.r0.k2.l.copy), this.f52227e.J0);
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(b.a.r0.k2.i.tag_clip_board, postData3);
                                                                                                                fVar8.f13556d.setTag(sparseArray6);
                                                                                                                arrayList.add(fVar8);
                                                                                                            }
                                                                                                            this.f52227e.m2 = postData3;
                                                                                                        }
                                                                                                        if (this.f52227e.x0.P0().r()) {
                                                                                                            String u = this.f52227e.x0.P0().u();
                                                                                                            if (postData3 != null && !b.a.e.e.p.k.isEmpty(u) && u.equals(postData3.G())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    fVar4 = new b.a.q0.s.s.f(4, this.f52227e.getString(b.a.r0.k2.l.remove_mark), this.f52227e.J0);
                                                                                                                } else {
                                                                                                                    fVar4 = new b.a.q0.s.s.f(4, this.f52227e.getString(b.a.r0.k2.l.mark), this.f52227e.J0);
                                                                                                                }
                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                sparseArray7.put(b.a.r0.k2.i.tag_clip_board, this.f52227e.m2);
                                                                                                                sparseArray7.put(b.a.r0.k2.i.tag_is_subpb, Boolean.FALSE);
                                                                                                                fVar4.f13556d.setTag(sparseArray7);
                                                                                                                arrayList.add(fVar4);
                                                                                                                if (this.f52227e.mIsLogin) {
                                                                                                                    if (b.a.r0.k2.u.f.f1.a.h(this.f52227e.x0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.f52227e.j3(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            b.a.q0.s.s.f fVar9 = new b.a.q0.s.s.f(5, this.f52227e.getString(b.a.r0.k2.l.report_text), this.f52227e.J0);
                                                                                                                            fVar9.f13556d.setTag(str2);
                                                                                                                            arrayList.add(fVar9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        b.a.q0.s.s.f fVar10 = new b.a.q0.s.s.f(5, this.f52227e.getString(b.a.r0.k2.l.mute_option), this.f52227e.J0);
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                                        int i10 = b.a.r0.k2.i.tag_is_mem;
                                                                                                                        sparseArray8.put(i10, sparseArray5.get(i10));
                                                                                                                        int i11 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                                                                                                                        sparseArray8.put(i11, sparseArray5.get(i11));
                                                                                                                        int i12 = b.a.r0.k2.i.tag_user_mute_mute_username;
                                                                                                                        sparseArray8.put(i12, sparseArray5.get(i12));
                                                                                                                        int i13 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                                                                                                                        sparseArray8.put(i13, sparseArray5.get(i13));
                                                                                                                        int i14 = b.a.r0.k2.i.tag_user_mute_post_id;
                                                                                                                        sparseArray8.put(i14, sparseArray5.get(i14));
                                                                                                                        int i15 = b.a.r0.k2.i.tag_user_mute_thread_id;
                                                                                                                        sparseArray8.put(i15, sparseArray5.get(i15));
                                                                                                                        int i16 = b.a.r0.k2.i.tag_del_post_is_self;
                                                                                                                        sparseArray8.put(i16, sparseArray5.get(i16));
                                                                                                                        int i17 = b.a.r0.k2.i.tag_del_post_type;
                                                                                                                        sparseArray8.put(i17, sparseArray5.get(i17));
                                                                                                                        int i18 = b.a.r0.k2.i.tag_del_post_id;
                                                                                                                        sparseArray8.put(i18, sparseArray5.get(i18));
                                                                                                                        int i19 = b.a.r0.k2.i.tag_manage_user_identity;
                                                                                                                        sparseArray8.put(i19, sparseArray5.get(i19));
                                                                                                                        fVar4.f13556d.setTag(sparseArray8);
                                                                                                                        arrayList.add(fVar10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                                                                                                                        int i20 = b.a.r0.k2.i.tag_manage_user_identity;
                                                                                                                        sparseArray9.put(i20, sparseArray5.get(i20));
                                                                                                                        int i21 = b.a.r0.k2.i.tag_forbid_user_name;
                                                                                                                        sparseArray9.put(i21, sparseArray5.get(i21));
                                                                                                                        int i22 = b.a.r0.k2.i.tag_forbid_user_name_show;
                                                                                                                        sparseArray9.put(i22, sparseArray5.get(i22));
                                                                                                                        int i23 = b.a.r0.k2.i.tag_forbid_user_portrait;
                                                                                                                        sparseArray9.put(i23, sparseArray5.get(i23));
                                                                                                                        sparseArray9.put(b.a.r0.k2.i.tag_forbid_user_post_id, str2);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray9.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                                            int i24 = b.a.r0.k2.i.tag_is_mem;
                                                                                                                            sparseArray9.put(i24, sparseArray5.get(i24));
                                                                                                                            int i25 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                                                                                                                            sparseArray9.put(i25, sparseArray5.get(i25));
                                                                                                                            int i26 = b.a.r0.k2.i.tag_user_mute_mute_username;
                                                                                                                            sparseArray9.put(i26, sparseArray5.get(i26));
                                                                                                                            int i27 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                                                                                                                            sparseArray9.put(i27, sparseArray5.get(i27));
                                                                                                                            int i28 = b.a.r0.k2.i.tag_user_mute_post_id;
                                                                                                                            sparseArray9.put(i28, sparseArray5.get(i28));
                                                                                                                            int i29 = b.a.r0.k2.i.tag_user_mute_thread_id;
                                                                                                                            sparseArray9.put(i29, sparseArray5.get(i29));
                                                                                                                        } else {
                                                                                                                            sparseArray9.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray9.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                                            sparseArray9.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                                            int i30 = b.a.r0.k2.i.tag_del_post_id;
                                                                                                                            sparseArray9.put(i30, sparseArray5.get(i30));
                                                                                                                            int i31 = b.a.r0.k2.i.tag_del_post_type;
                                                                                                                            sparseArray9.put(i31, sparseArray5.get(i31));
                                                                                                                            int i32 = b.a.r0.k2.i.tag_has_sub_post;
                                                                                                                            sparseArray9.put(i32, sparseArray5.get(i32));
                                                                                                                            if (booleanValue6) {
                                                                                                                                b.a.q0.s.s.f fVar11 = new b.a.q0.s.s.f(6, this.f52227e.getString(b.a.r0.k2.l.delete), this.f52227e.J0);
                                                                                                                                fVar11.f13556d.setTag(sparseArray9);
                                                                                                                                fVar6 = fVar11;
                                                                                                                                fVar5 = new b.a.q0.s.s.f(7, this.f52227e.getString(b.a.r0.k2.l.bar_manager), this.f52227e.J0);
                                                                                                                                fVar5.f13556d.setTag(sparseArray9);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray9.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        fVar6 = null;
                                                                                                                        fVar5 = new b.a.q0.s.s.f(7, this.f52227e.getString(b.a.r0.k2.l.bar_manager), this.f52227e.J0);
                                                                                                                        fVar5.f13556d.setTag(sparseArray9);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray10 = new SparseArray();
                                                                                                                        sparseArray10.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                                                                                                                        sparseArray10.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                                        sparseArray10.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                                        int i33 = b.a.r0.k2.i.tag_manage_user_identity;
                                                                                                                        sparseArray10.put(i33, sparseArray5.get(i33));
                                                                                                                        sparseArray10.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                                        int i34 = b.a.r0.k2.i.tag_del_post_id;
                                                                                                                        sparseArray10.put(i34, sparseArray5.get(i34));
                                                                                                                        int i35 = b.a.r0.k2.i.tag_del_post_type;
                                                                                                                        sparseArray10.put(i35, sparseArray5.get(i35));
                                                                                                                        int i36 = b.a.r0.k2.i.tag_has_sub_post;
                                                                                                                        sparseArray10.put(i36, sparseArray5.get(i36));
                                                                                                                        if (this.f52227e.x0.P0().V() == 1002 && !booleanValue) {
                                                                                                                            fVar7 = new b.a.q0.s.s.f(6, this.f52227e.getString(b.a.r0.k2.l.report_text), this.f52227e.J0);
                                                                                                                        } else {
                                                                                                                            fVar7 = new b.a.q0.s.s.f(6, this.f52227e.getString(b.a.r0.k2.l.delete), this.f52227e.J0);
                                                                                                                        }
                                                                                                                        fVar7.f13556d.setTag(sparseArray10);
                                                                                                                        fVar6 = fVar7;
                                                                                                                        fVar5 = null;
                                                                                                                    } else {
                                                                                                                        fVar5 = null;
                                                                                                                        fVar6 = null;
                                                                                                                    }
                                                                                                                    if (fVar6 != null) {
                                                                                                                        arrayList.add(fVar6);
                                                                                                                    }
                                                                                                                    if (fVar5 != null) {
                                                                                                                        arrayList.add(fVar5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.f52227e.J0.j(arrayList);
                                                                                                                this.f52227e.I0 = new PopupDialog(this.f52227e.getPageContext(), this.f52227e.J0);
                                                                                                                this.f52227e.I0.showDialog();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                                        sparseArray72.put(b.a.r0.k2.i.tag_clip_board, this.f52227e.m2);
                                                                                                        sparseArray72.put(b.a.r0.k2.i.tag_is_subpb, Boolean.FALSE);
                                                                                                        fVar4.f13556d.setTag(sparseArray72);
                                                                                                        arrayList.add(fVar4);
                                                                                                        if (this.f52227e.mIsLogin) {
                                                                                                        }
                                                                                                        this.f52227e.J0.j(arrayList);
                                                                                                        this.f52227e.I0 = new PopupDialog(this.f52227e.getPageContext(), this.f52227e.J0);
                                                                                                        this.f52227e.I0.showDialog();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            this.f52227e.E0.f19406h.l();
                                                                                            this.f52227e.E0.r3(this.f52227e.p2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.f52227e.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.f52227e.getPageContext().getPageActivity(), 24008, b.a.e.e.m.b.g(this.f52227e.x0.P0().m(), 0L), b.a.e.e.m.b.g(this.f52227e.x0.f1(), 0L), b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.f52227e.x0.P0().O().O0())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view.getTag();
                                                                                    } catch (ClassCastException e2) {
                                                                                        e2.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData4 = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
                                                                                    if (postData4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.f52227e.J0 == null) {
                                                                                        PbFragment pbFragment6 = this.f52227e;
                                                                                        pbFragment6.J0 = new b.a.q0.s.s.i(pbFragment6.getContext());
                                                                                        this.f52227e.J0.m(this.f52227e.V1);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.f52227e.getPbModel().P0() != null && this.f52227e.getPbModel().P0().g0();
                                                                                    if (view != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
                                                                                        if (postData4.q() != null) {
                                                                                            boolean z6 = postData4.q().hasAgree;
                                                                                            int s = postData4.s();
                                                                                            if (z6 && s == 5) {
                                                                                                pbFragment = this.f52227e;
                                                                                                i2 = b.a.r0.k2.l.action_cancel_dislike;
                                                                                            } else {
                                                                                                pbFragment = this.f52227e;
                                                                                                i2 = b.a.r0.k2.l.action_dislike;
                                                                                            }
                                                                                            b.a.q0.s.s.f fVar12 = new b.a.q0.s.s.f(8, pbFragment.getString(i2), this.f52227e.J0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(b.a.r0.k2.i.tag_clip_board, postData4);
                                                                                            fVar12.f13556d.setTag(sparseArray11);
                                                                                            arrayList2.add(fVar12);
                                                                                        }
                                                                                        if (this.f52227e.mIsLogin) {
                                                                                            if (b.a.r0.k2.u.f.f1.a.h(this.f52227e.x0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.f52227e.j3(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    b.a.q0.s.s.f fVar13 = new b.a.q0.s.s.f(5, this.f52227e.getString(b.a.r0.k2.l.report_text), this.f52227e.J0);
                                                                                                    fVar13.f13556d.setTag(str3);
                                                                                                    arrayList2.add(fVar13);
                                                                                                }
                                                                                            } else {
                                                                                                b.a.q0.s.s.f fVar14 = new b.a.q0.s.s.f(5, this.f52227e.getString(b.a.r0.k2.l.mute_option), this.f52227e.J0);
                                                                                                SparseArray sparseArray12 = new SparseArray();
                                                                                                sparseArray12.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                int i37 = b.a.r0.k2.i.tag_is_mem;
                                                                                                sparseArray12.put(i37, sparseArray.get(i37));
                                                                                                int i38 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                                                                                                sparseArray12.put(i38, sparseArray.get(i38));
                                                                                                int i39 = b.a.r0.k2.i.tag_user_mute_mute_username;
                                                                                                sparseArray12.put(i39, sparseArray.get(i39));
                                                                                                int i40 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                                                                                                sparseArray12.put(i40, sparseArray.get(i40));
                                                                                                int i41 = b.a.r0.k2.i.tag_user_mute_post_id;
                                                                                                sparseArray12.put(i41, sparseArray.get(i41));
                                                                                                int i42 = b.a.r0.k2.i.tag_user_mute_thread_id;
                                                                                                sparseArray12.put(i42, sparseArray.get(i42));
                                                                                                int i43 = b.a.r0.k2.i.tag_del_post_is_self;
                                                                                                sparseArray12.put(i43, sparseArray.get(i43));
                                                                                                int i44 = b.a.r0.k2.i.tag_del_post_type;
                                                                                                sparseArray12.put(i44, sparseArray.get(i44));
                                                                                                int i45 = b.a.r0.k2.i.tag_del_post_id;
                                                                                                sparseArray12.put(i45, sparseArray.get(i45));
                                                                                                int i46 = b.a.r0.k2.i.tag_manage_user_identity;
                                                                                                sparseArray12.put(i46, sparseArray.get(i46));
                                                                                                fVar14.f13556d.setTag(sparseArray12);
                                                                                                arrayList2.add(fVar14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray13 = new SparseArray();
                                                                                                sparseArray13.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                                                                                                int i47 = b.a.r0.k2.i.tag_manage_user_identity;
                                                                                                sparseArray13.put(i47, sparseArray.get(i47));
                                                                                                int i48 = b.a.r0.k2.i.tag_forbid_user_name;
                                                                                                sparseArray13.put(i48, sparseArray.get(i48));
                                                                                                int i49 = b.a.r0.k2.i.tag_forbid_user_name_show;
                                                                                                sparseArray13.put(i49, sparseArray.get(i49));
                                                                                                int i50 = b.a.r0.k2.i.tag_forbid_user_portrait;
                                                                                                sparseArray13.put(i50, sparseArray.get(i50));
                                                                                                sparseArray13.put(b.a.r0.k2.i.tag_forbid_user_post_id, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray13.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                    int i51 = b.a.r0.k2.i.tag_is_mem;
                                                                                                    sparseArray13.put(i51, sparseArray.get(i51));
                                                                                                    int i52 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                                                                                                    sparseArray13.put(i52, sparseArray.get(i52));
                                                                                                    int i53 = b.a.r0.k2.i.tag_user_mute_mute_username;
                                                                                                    sparseArray13.put(i53, sparseArray.get(i53));
                                                                                                    int i54 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                                                                                                    sparseArray13.put(i54, sparseArray.get(i54));
                                                                                                    int i55 = b.a.r0.k2.i.tag_user_mute_post_id;
                                                                                                    sparseArray13.put(i55, sparseArray.get(i55));
                                                                                                    int i56 = b.a.r0.k2.i.tag_user_mute_thread_id;
                                                                                                    sparseArray13.put(i56, sparseArray.get(i56));
                                                                                                } else {
                                                                                                    sparseArray13.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray13.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                    sparseArray13.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue7));
                                                                                                    int i57 = b.a.r0.k2.i.tag_del_post_id;
                                                                                                    sparseArray13.put(i57, sparseArray.get(i57));
                                                                                                    int i58 = b.a.r0.k2.i.tag_del_post_type;
                                                                                                    sparseArray13.put(i58, sparseArray.get(i58));
                                                                                                    int i59 = b.a.r0.k2.i.tag_has_sub_post;
                                                                                                    sparseArray13.put(i59, sparseArray.get(i59));
                                                                                                    if (booleanValue12) {
                                                                                                        b.a.q0.s.s.f fVar15 = new b.a.q0.s.s.f(6, this.f52227e.getString(b.a.r0.k2.l.delete), this.f52227e.J0);
                                                                                                        fVar15.f13556d.setTag(sparseArray13);
                                                                                                        fVar2 = fVar15;
                                                                                                        fVar = new b.a.q0.s.s.f(7, this.f52227e.getString(b.a.r0.k2.l.bar_manager), this.f52227e.J0);
                                                                                                        fVar.f13556d.setTag(sparseArray13);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray13.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
                                                                                                }
                                                                                                fVar2 = null;
                                                                                                fVar = new b.a.q0.s.s.f(7, this.f52227e.getString(b.a.r0.k2.l.bar_manager), this.f52227e.J0);
                                                                                                fVar.f13556d.setTag(sparseArray13);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                                                                                                sparseArray14.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                sparseArray14.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                int i60 = b.a.r0.k2.i.tag_manage_user_identity;
                                                                                                sparseArray14.put(i60, sparseArray.get(i60));
                                                                                                sparseArray14.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue7));
                                                                                                int i61 = b.a.r0.k2.i.tag_del_post_id;
                                                                                                sparseArray14.put(i61, sparseArray.get(i61));
                                                                                                int i62 = b.a.r0.k2.i.tag_del_post_type;
                                                                                                sparseArray14.put(i62, sparseArray.get(i62));
                                                                                                int i63 = b.a.r0.k2.i.tag_has_sub_post;
                                                                                                sparseArray14.put(i63, sparseArray.get(i63));
                                                                                                if (this.f52227e.x0.P0().V() == 1002 && !booleanValue7) {
                                                                                                    fVar3 = new b.a.q0.s.s.f(6, this.f52227e.getString(b.a.r0.k2.l.report_text), this.f52227e.J0);
                                                                                                } else {
                                                                                                    fVar3 = new b.a.q0.s.s.f(6, this.f52227e.getString(b.a.r0.k2.l.delete), this.f52227e.J0);
                                                                                                }
                                                                                                fVar3.f13556d.setTag(sparseArray14);
                                                                                                fVar2 = fVar3;
                                                                                                fVar = null;
                                                                                            } else {
                                                                                                fVar = null;
                                                                                                fVar2 = null;
                                                                                            }
                                                                                            if (fVar2 != null) {
                                                                                                arrayList2.add(fVar2);
                                                                                            }
                                                                                            if (fVar != null) {
                                                                                                arrayList2.add(fVar);
                                                                                            }
                                                                                        }
                                                                                        this.f52227e.J0.j(arrayList2);
                                                                                        this.f52227e.I0 = new PopupDialog(this.f52227e.getPageContext(), this.f52227e.J0);
                                                                                        this.f52227e.I0.showDialog();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view.getId() == b.a.r0.k2.i.new_sub_pb_list_richText) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.f52227e.x0.f1());
                                                                                    statisticItem10.param("fid", this.f52227e.x0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52227e.getActivity(), "pb_chakanhuifu"))) {
                                                                                    this.f52227e.X = view;
                                                                                    return;
                                                                                } else if (this.f52227e.checkUpIsLogin()) {
                                                                                    if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f52227e.E0.c0();
                                                                                    SparseArray sparseArray15 = (SparseArray) view.getTag();
                                                                                    PostData postData5 = (PostData) sparseArray15.get(b.a.r0.k2.i.tag_load_sub_data);
                                                                                    PostData postData6 = (PostData) sparseArray15.get(b.a.r0.k2.i.tag_load_sub_reply_data);
                                                                                    View view2 = (View) sparseArray15.get(b.a.r0.k2.i.tag_load_sub_view);
                                                                                    if (postData5 == null || view2 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData5.E() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData5.l0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view.getId() == b.a.r0.k2.i.new_sub_pb_list_richText) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String f12 = this.f52227e.x0.f1();
                                                                                    String G2 = postData5.G();
                                                                                    String G3 = postData6 != null ? postData6.G() : "";
                                                                                    int V2 = this.f52227e.x0.P0() != null ? this.f52227e.x0.P0().V() : 0;
                                                                                    this.f52227e.stopVoice();
                                                                                    if (view.getId() == b.a.r0.k2.i.replybtn) {
                                                                                        AbsPbActivity.e v32 = this.f52227e.v3(G2);
                                                                                        if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null || v32 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f52227e.getPageContext().getPageActivity()).createSubPbActivityConfig(f12, G2, "pb", true, false, null, true, null, V2, postData5.R(), this.f52227e.x0.P0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(v32.f52184a, v32.f52185b, v32.f52190g, v32.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.f52227e.x0.O0());
                                                                                        addBigImageData2.setFromFrsForumId(this.f52227e.x0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.f52227e.x0.k1());
                                                                                        addBigImageData2.setKeyFromForumId(this.f52227e.x0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.f52227e.x0.j0());
                                                                                        addBigImageData2.setTiebaPlusData(this.f52227e.x0.F(), this.f52227e.x0.B(), this.f52227e.x0.C(), this.f52227e.x0.A(), this.f52227e.x0.G());
                                                                                        this.f52227e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e v33 = this.f52227e.v3(G2);
                                                                                        if (postData5 == null || this.f52227e.x0 == null || this.f52227e.x0.P0() == null || v33 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f52227e.getPageContext().getPageActivity()).createSubPbActivityConfig(f12, G2, "pb", true, false, null, false, G3, V2, postData5.R(), this.f52227e.x0.P0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(v33.f52184a, v33.f52185b, v33.f52190g, v33.j);
                                                                                        if (!b.a.e.e.p.k.isEmpty(G3)) {
                                                                                            addBigImageData3.setHighLightPostId(G3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.f52227e.x0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.f52227e.x0.F(), this.f52227e.x0.B(), this.f52227e.x0.C(), this.f52227e.x0.A(), this.f52227e.x0.G());
                                                                                        addBigImageData3.setBjhData(this.f52227e.x0.j0());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.f52227e.x0.O0());
                                                                                        addBigImageData3.setFromFrsForumId(this.f52227e.x0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.f52227e.x0.k1());
                                                                                        if (this.f52227e.E0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.f52227e.E0.v0(this.f52227e.x0.J, this.f52227e.x0.d1()).U || postData5.U);
                                                                                        }
                                                                                        this.f52227e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f52227e.x0.P0().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (b.a.e.e.p.j.z()) {
                                                                            SparseArray<Object> F02 = this.f52227e.E0.F0(this.f52227e.x0.P0(), this.f52227e.x0.d1(), 1);
                                                                            if (F02 != null) {
                                                                                this.f52227e.E0.Z1(((Integer) F02.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) F02.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) F02.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) F02.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                                                            }
                                                                            this.f52227e.E0.f19406h.k();
                                                                            if (this.f52227e.getPbModel() != null && this.f52227e.getPbModel().P0() != null && this.f52227e.getPbModel().P0().O() != null) {
                                                                                b.a.q0.s.q.d2 O = this.f52227e.getPbModel().P0().O();
                                                                                StatisticItem statisticItem12 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                                                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem12.param("tid", O.f0());
                                                                                statisticItem12.param("fid", O.T());
                                                                                statisticItem12.param("fname", O.Z());
                                                                                TiebaStatic.log(statisticItem12);
                                                                                StatisticItem statisticItem13 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem13.param("tid", O.f0());
                                                                                statisticItem13.param("fid", O.T());
                                                                                statisticItem13.param("fname", O.Z());
                                                                                statisticItem13.param("obj_source", 3);
                                                                                TiebaStatic.log(statisticItem13);
                                                                            }
                                                                        } else {
                                                                            this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (b.a.e.e.p.j.z()) {
                                                                        this.f52227e.E0.c0();
                                                                        SparseArray<Object> F03 = this.f52227e.E0.F0(this.f52227e.x0.P0(), this.f52227e.x0.d1(), 1);
                                                                        if (F03 == null) {
                                                                            return;
                                                                        }
                                                                        this.f52227e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f52227e.getPageContext().getPageActivity(), this.f52227e.x0.P0().l().getId(), this.f52227e.x0.P0().l().getName(), this.f52227e.x0.P0().O().f0(), String.valueOf(this.f52227e.x0.P0().U().getUserId()), (String) F03.get(b.a.r0.k2.i.tag_forbid_user_name), (String) F03.get(b.a.r0.k2.i.tag_forbid_user_name_show), (String) F03.get(b.a.r0.k2.i.tag_forbid_user_post_id), (String) F03.get(b.a.r0.k2.i.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        this.f52227e.onChangeSkinType(skinType);
                                                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                    } else if (skinType == 0 || skinType == 4) {
                                                                        UtilHelper.showSkinChangeAnimation(this.f52227e.getActivity());
                                                                        this.f52227e.onChangeSkinType(skinType);
                                                                        UtilHelper.setNavigationBarBackground(this.f52227e.getActivity(), this.f52227e.getResources().getColor(b.a.r0.k2.f.CAM_X0201_1));
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                    }
                                                                    this.f52227e.E0.f19406h.l();
                                                                }
                                                            } else if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null || this.f52227e.x0.P0().O() == null) {
                                                                return;
                                                            } else {
                                                                this.f52227e.E0.f19406h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.f52227e;
                                                                pbFragment7.Z2(pbFragment7.x0.P0().O().W());
                                                            }
                                                        } else {
                                                            this.f52227e.E0.c0();
                                                            if (b.a.e.e.p.j.z()) {
                                                                if (this.f52227e.m) {
                                                                    view.setTag(Integer.valueOf(this.f52227e.x0.b1()));
                                                                    return;
                                                                }
                                                                this.f52227e.stopVoice();
                                                                this.f52227e.E0.Q2();
                                                                PopupDialog popupDialog = new PopupDialog(this.f52227e.getPageContext());
                                                                if (this.f52227e.x0.P0().f18762f == null || this.f52227e.x0.P0().f18762f.size() <= 0) {
                                                                    strArr = new String[]{this.f52227e.getResources().getString(b.a.r0.k2.l.sort_type_new), this.f52227e.getResources().getString(b.a.r0.k2.l.sort_type_old)};
                                                                } else {
                                                                    strArr = new String[this.f52227e.x0.P0().f18762f.size()];
                                                                    for (int i64 = 0; i64 < this.f52227e.x0.P0().f18762f.size(); i64++) {
                                                                        strArr[i64] = this.f52227e.x0.P0().f18762f.get(i64).sort_name + this.f52227e.getResources().getString(b.a.r0.k2.l.sort_static);
                                                                    }
                                                                }
                                                                popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog, view));
                                                                popupDialog.showDialog();
                                                            } else {
                                                                this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.f52227e.E0.c0();
                                                        if (this.f52227e.getPbModel().P0().f18763g != 2) {
                                                            if (this.f52227e.x0.N0() != null) {
                                                                this.f52227e.E0.w3(this.f52227e.x0.N0(), this.f52227e.mDialogClickListener);
                                                            }
                                                            TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.f52227e.showToast(b.a.r0.k2.l.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.f52227e.checkUpIsLogin()) || (P0 = this.f52227e.x0.P0()) == null) {
                                                    return;
                                                } else {
                                                    b.a.q0.s.q.d2 O2 = P0.O();
                                                    if (O2 != null && O2.J() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52227e.x0.f52416f).param("fid", P0.m()).param("obj_locate", 4).param("uid", O2.J().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.M1()) {
                                                            i5 = 2;
                                                        } else if (O2.P1()) {
                                                            i5 = 3;
                                                        } else if (O2.N1()) {
                                                            i5 = 4;
                                                        } else if (O2.O1()) {
                                                            i5 = 5;
                                                        }
                                                        StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem14.param("tid", this.f52227e.x0.f1());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.f52227e.x0.getForumId());
                                                        if (view.getId() != b.a.r0.k2.i.share_num_container) {
                                                            statisticItem14.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem14.param("obj_locate", 6);
                                                        }
                                                        statisticItem14.param("obj_name", i5);
                                                        statisticItem14.param("obj_type", 1);
                                                        if (O2 != null) {
                                                            if (O2.M1()) {
                                                                statisticItem14.param("obj_type", 10);
                                                            } else if (O2.P1()) {
                                                                statisticItem14.param("obj_type", 9);
                                                            } else if (O2.O1()) {
                                                                statisticItem14.param("obj_type", 8);
                                                            } else if (O2.N1()) {
                                                                statisticItem14.param("obj_type", 7);
                                                            } else if (O2.z1) {
                                                                statisticItem14.param("obj_type", 6);
                                                            } else {
                                                                int i65 = O2.i0;
                                                                if (i65 == 0) {
                                                                    statisticItem14.param("obj_type", 1);
                                                                } else if (i65 == 40) {
                                                                    statisticItem14.param("obj_type", 2);
                                                                } else if (i65 == 49) {
                                                                    statisticItem14.param("obj_type", 3);
                                                                } else if (i65 == 54) {
                                                                    statisticItem14.param("obj_type", 4);
                                                                } else {
                                                                    statisticItem14.param("obj_type", 5);
                                                                }
                                                            }
                                                            statisticItem14.param("card_type", O2.Q0());
                                                            statisticItem14.param("recom_source", O2.X0);
                                                            statisticItem14.param("ab_tag", O2.Z0);
                                                            statisticItem14.param("weight", O2.Y0);
                                                            statisticItem14.param("extra", O2.a1);
                                                            statisticItem14.param("nid", O2.F0());
                                                            if (O2.L() != null && !b.a.e.e.p.k.isEmpty(O2.L().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.L().oriUgcVid);
                                                            }
                                                        }
                                                        if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.f52227e.getPbActivity() != null) {
                                                            b.a.q0.n0.c.e(this.f52227e.getPbActivity(), statisticItem14);
                                                        }
                                                        if (this.f52227e.E0 != null) {
                                                            statisticItem14.param("obj_param1", this.f52227e.E0.A0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (b.a.e.e.p.l.D()) {
                                                            this.f52227e.showToast(b.a.r0.k2.l.neterror);
                                                            return;
                                                        } else if (P0 != null) {
                                                            ArrayList<PostData> F2 = this.f52227e.x0.P0().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.f52227e.x0.d1()) {
                                                                this.f52227e.E0.c0();
                                                                this.f52227e.stopVoice();
                                                                if (P0.A() != null && !StringUtils.isNull(P0.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.f52227e.x0.P0().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.f52227e.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.f52227e.E0 != null) {
                                                                    this.f52227e.E0.e0();
                                                                    this.f52227e.E0.H3(P0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.f52227e.E0.k3();
                                                                    this.f52227e.x0.l0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view.getId() == b.a.r0.k2.i.pb_editor_tool_share) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view.getId() == b.a.r0.k2.i.share_num_container ? 1 : 6;
                                                                    }
                                                                    if ((b.a.q0.b.d.S() || b.a.q0.b.d.T()) && this.f52227e.E0.H1()) {
                                                                        int A0 = this.f52227e.E0.A0();
                                                                        this.f52227e.E0.R();
                                                                        this.f52227e.b3(b.a.q0.t.g.f.a(), A0);
                                                                    } else {
                                                                        this.f52227e.T3(i6);
                                                                    }
                                                                }
                                                            } else {
                                                                b.a.e.e.p.l.M(this.f52227e.getPageContext().getPageActivity(), this.f52227e.getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            b.a.e.e.p.l.M(this.f52227e.getPageContext().getPageActivity(), this.f52227e.getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.f52227e.x0.f1());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.f52227e.x0.getForumId());
                                                    if (view.getId() != b.a.r0.k2.i.share_num_container) {
                                                    }
                                                    statisticItem142.param("obj_name", i5);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.f52227e.getPbActivity() != null) {
                                                    }
                                                    if (this.f52227e.E0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (b.a.e.e.p.l.D()) {
                                                    }
                                                }
                                            } else if (b.a.e.e.p.j.z()) {
                                                this.f52227e.E0.c0();
                                                if (this.f52227e.E0.f19406h.n() != null && view == this.f52227e.E0.f19406h.n().i() && !this.f52227e.E0.F1()) {
                                                    this.f52227e.E0.o2();
                                                }
                                                if (!this.f52227e.m) {
                                                    this.f52227e.stopVoice();
                                                    this.f52227e.E0.Q2();
                                                    if (view.getId() == b.a.r0.k2.i.floor_owner_reply) {
                                                        u2 = this.f52227e.x0.u2(true, this.f52227e.P2());
                                                    } else {
                                                        u2 = view.getId() == b.a.r0.k2.i.reply_title ? this.f52227e.x0.u2(false, this.f52227e.P2()) : this.f52227e.x0.t2(this.f52227e.P2());
                                                    }
                                                    view.setTag(Boolean.valueOf(u2));
                                                    if (u2) {
                                                        i7 = 1;
                                                        this.f52227e.E0.B2(true);
                                                        this.f52227e.E0.u3();
                                                        this.f52227e.m = true;
                                                        this.f52227e.E0.E2(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (b.a.e.e.p.j.z()) {
                                            this.f52227e.E0.c0();
                                            if (view.getId() != b.a.r0.k2.i.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52227e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f52227e.E2(11009) || this.f52227e.x0.h0(this.f52227e.E0.D0()) == null) {
                                                    return;
                                                }
                                                this.f52227e.q3();
                                                if (this.f52227e.x0.P0() != null && this.f52227e.x0.P0().O() != null && this.f52227e.x0.P0().O().J() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52227e.x0.f52416f).param("fid", this.f52227e.x0.P0().m()).param("obj_locate", 3).param("uid", this.f52227e.x0.P0().O().J().getUserId()));
                                                }
                                                if (this.f52227e.x0.P0().O() != null && this.f52227e.x0.P0().O().J() != null && this.f52227e.x0.P0().O().J().getUserId() != null && this.f52227e.z0 != null) {
                                                    PbFragment pbFragment8 = this.f52227e;
                                                    int X2 = pbFragment8.X2(pbFragment8.x0.P0());
                                                    b.a.q0.s.q.d2 O3 = this.f52227e.x0.P0().O();
                                                    if (O3.M1()) {
                                                        i8 = 2;
                                                    } else if (O3.P1()) {
                                                        i8 = 3;
                                                    } else if (O3.N1()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.O1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f52227e.x0.f52416f).param("obj_locate", 1).param("obj_id", this.f52227e.x0.P0().O().J().getUserId()).param("obj_type", !this.f52227e.z0.e()).param("obj_source", X2).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.f52227e.Z = view;
                                                return;
                                            }
                                        } else {
                                            this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.f52227e.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.f52227e.x0.P0() != null && this.f52227e.x0.P0().O() != null && this.f52227e.x0.P0().O().E2() && this.f52227e.x0.P0().O().q1() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.f52227e.x0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.f52227e.x0.q0()) || this.f52227e.x0.g0() == null) {
                                                this.f52227e.f52221e.finish();
                                                return;
                                            }
                                            name2 = this.f52227e.x0.g0().f18752b;
                                        } else {
                                            name2 = this.f52227e.x0.P0().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.f52227e.f52221e.finish();
                                            return;
                                        }
                                        String q02 = this.f52227e.x0.q0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.f52227e.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.f52227e.x0.v0() && q02 != null && q02.equals(name2)) {
                                            this.f52227e.f52221e.finish();
                                        } else {
                                            this.f52227e.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (b.a.e.e.p.j.z()) {
                                    if (this.f52227e.x0.P0() == null || this.f52227e.A0.P()) {
                                        return;
                                    }
                                    this.f52227e.E0.c0();
                                    int i66 = (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().m()) ? (this.f52227e.E0.f19406h.n() == null || view != this.f52227e.E0.f19406h.n().l()) ? view == this.f52227e.E0.p0() ? 2 : 0 : this.f52227e.x0.P0().O().q0() == 1 ? 3 : 6 : this.f52227e.x0.P0().O().r0() == 1 ? 5 : 4;
                                    ForumData l = this.f52227e.x0.P0().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String f0 = this.f52227e.x0.P0().O().f0();
                                    this.f52227e.E0.B3();
                                    this.f52227e.A0.T(id2, name3, f0, i66, this.f52227e.E0.q0());
                                } else {
                                    this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                                    return;
                                }
                            } else {
                                this.f52227e.E0.f19406h.l();
                                if (this.f52227e.x0 != null) {
                                    this.f52227e.p1.f(this.f52227e.x0.f1());
                                }
                                if (this.f52227e.x0 == null || !this.f52227e.x0.isPrivacy()) {
                                    this.f52227e.p1.b();
                                    int i67 = (TbSingleton.getInstance().mCanCallFans || this.f52227e.getPbModel() == null || this.f52227e.getPbModel().P0() == null || this.f52227e.getPbModel().P0().Q() == null || !this.f52227e.getPbModel().P0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.f52227e.getPbModel() != null && this.f52227e.getPbModel().P0() != null) {
                                        this.f52227e.p1.d(3, i67, this.f52227e.getPbModel().P0().Q());
                                    }
                                } else {
                                    this.f52227e.showToast(b.a.r0.k2.l.privacy_thread_can_not_use_call_fans);
                                    if (this.f52227e.getPbModel() == null || this.f52227e.getPbModel().P0() == null) {
                                        return;
                                    }
                                    this.f52227e.p1.d(3, 3, this.f52227e.getPbModel().P0().Q());
                                    return;
                                }
                            }
                        } else if (b.a.e.e.p.j.z()) {
                            this.f52227e.E0.c0();
                            this.f52227e.stopVoice();
                            this.f52227e.E0.Q2();
                            this.f52227e.E0.k3();
                            if (this.f52227e.E0.M0() != null) {
                                this.f52227e.E0.M0().setVisibility(8);
                            }
                            this.f52227e.x0.p2(1);
                            if (this.f52227e.f52225i != null) {
                                this.f52227e.f52225i.x();
                            }
                        } else {
                            this.f52227e.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                    } else {
                        String str4 = (String) view.getTag(b.a.r0.k2.i.forum_name);
                        String str5 = (String) view.getTag(b.a.r0.k2.i.forum_id);
                        String str6 = (String) view.getTag(b.a.r0.k2.i.thread_id);
                        if (this.f52227e.V != null) {
                            this.f52227e.V.L(str4, str5);
                        }
                        TbPageTag l2 = b.a.q0.n0.c.l(this.f52227e.getContext());
                        b.a.r0.k2.u.f.f1.c.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.f52227e.getPageContext().getString(b.a.r0.k2.l.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == b.a.r0.k2.i.reply_god_title_group) {
                        String O22 = this.f52227e.O2();
                        if (TextUtils.isEmpty(O22)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.f52227e.getPageContext(), new String[]{O22});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.f52227e.x0.f1());
                statisticItem15.param("fid", this.f52227e.x0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                if (this.f52227e.A) {
                    this.f52227e.A = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.f52227e.x0 == null || this.f52227e.x0.P0() == null || this.f52227e.getPbView().N0() == null || postData7.t() == null || postData7.A() == 1 || !this.f52227e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f52227e.getPbView().O0() != null) {
                            this.f52227e.getPbView().O0().c();
                        }
                        b.a.r0.k2.r.s sVar2 = new b.a.r0.k2.r.s();
                        sVar2.A(this.f52227e.x0.P0().l());
                        sVar2.E(this.f52227e.x0.P0().O());
                        sVar2.C(postData7);
                        this.f52227e.getPbView().N0().S(sVar2);
                        this.f52227e.getPbView().N0().setPostId(postData7.G());
                        this.f52227e.o3(view, postData7.t().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        b.a.r0.k2.w.a.b(this.f52227e.x0.P0(), postData7, postData7.k0, 8, 1);
                        if (this.f52227e.S0 != null) {
                            this.f52227e.E0.v2(this.f52227e.S0.D());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a2 implements b.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52231a;

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
            this.f52231a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
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
                    if (b.a.q0.s.k.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(b.a.r0.k2.h.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(b.a.r0.k2.f.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f52231a.getPageContext().getPageActivity());
                boolean g2 = b.a.q0.s.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(b.a.r0.k2.f.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(b.a.r0.k2.h.icon_click);
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(b.a.r0.k2.f.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface a3 {
        boolean onBackPressed();
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.q0.d1.i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52232a;

        public b(PbFragment pbFragment) {
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
            this.f52232a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.r0.k2.u.f.f1.b.d(this.f52232a.getContext(), this.f52232a.N2(), ShareSwitch.isOn() ? 1 : 6, this.f52232a.x0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b0 extends b.a.q0.j0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52233g;

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
            this.f52233g = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f52233g.f52221e.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.makeText(this.f52233g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52234a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(PbFragment pbFragment, int i2) {
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
            this.f52234a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f52234a.x0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f52234a.x0.f52416f)) {
                this.f52234a.S3((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b2 implements b.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52235a;

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
            this.f52235a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
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
                if (b.a.q0.s.k.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(b.a.r0.k2.h.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(b.a.r0.k2.f.common_color_10220);
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f52235a.getPageContext().getPageActivity());
                boolean g2 = b.a.q0.s.k.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(b.a.r0.k2.f.common_color_10220));
                if (g2) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(b.a.r0.k2.h.icon_click);
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
                gifView.release();
                gifView.onDestroy();
                gifView.setImageDrawable(null);
                gifView.resetDefaultNoImageDay();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(b.a.r0.k2.f.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b3 {
        void a(Object obj);
    }

    /* loaded from: classes9.dex */
    public class c implements b.a.q0.d1.q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52236a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52237b;

        public c(PbFragment pbFragment, int i2) {
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
            this.f52237b = pbFragment;
            this.f52236a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f52237b.getContext(), this.f52236a, shareItem, false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f52238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52239f;

        public c0(PbFragment pbFragment, Intent intent) {
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
            this.f52239f = pbFragment;
            this.f52238e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.r0.k2.u.f.s0 s0Var = this.f52239f.E0;
                s0Var.T2("@" + this.f52238e.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52240a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f52241e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c1 f52242f;

            public a(c1 c1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52242f = c1Var;
                this.f52241e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52242f.f52240a.E0 == null || this.f52241e == null) {
                    return;
                }
                this.f52242f.f52240a.E0.c2(this.f52241e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c1 c1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c1 f52243e;

            public c(c1 c1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52243e = c1Var;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f52243e.f52240a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f52243e.f52240a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52240a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b.a.q0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f52240a.x0.P0() != null) {
                        statisticItem.param("fid", this.f52240a.x0.P0().m());
                    }
                    statisticItem.param("tid", this.f52240a.x0.f1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (b.a.e.e.p.k.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.f52240a.stopVoice();
                this.f52240a.E0.O2(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.f52240a.S3(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.f52240a.H3(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.f52240a.x0.t0()) {
                            b.a.r0.k2.r.f P0 = this.f52240a.x0.P0();
                            if (P0 != null && P0.O() != null && P0.O().J() != null && (userId = P0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f52240a.x0.s2()) {
                                this.f52240a.E0.Q2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.f52240a.x0.s2()) {
                            this.f52240a.E0.Q2();
                        }
                    } else if (floor != null) {
                        this.f52240a.E0.t1(this.f52240a.x0.P0());
                    }
                    if (this.f52240a.x0.x0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.f52240a.x0.f1()));
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        b.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.f52240a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.B2(z2);
                    if (this.f52240a.g3()) {
                        this.f52240a.b4();
                    }
                } else if (i2 == 220015) {
                    this.f52240a.showToast(str);
                    if (this.f52240a.S0.C() || this.f52240a.S0.E()) {
                        this.f52240a.S0.A(false, postWriteCallBackData);
                    }
                    this.f52240a.mContentProcessController.k(postWriteCallBackData);
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f52240a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f52240a.getActivity(), this.f52240a.getActivity().getString(b.a.r0.k2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f52240a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f52240a.getActivity());
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f52240a.getActivity().getString(b.a.r0.k2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(b.a.r0.k2.l.cancel, new b(this));
                    aVar.setPositiveButton(b.a.r0.k2.l.open_now, new c(this));
                    aVar.create(this.f52240a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (b.a.r0.v3.a.c(i2) || m0Var != null || i2 == 227001) {
                } else {
                    this.f52240a.G3(i2, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c2 implements b.a.e.e.k.c<TiebaPlusRecommendCard> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52244a;

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
            this.f52244a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard c(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            h(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        public TiebaPlusRecommendCard e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.onSkinChanged();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.resetData();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public TiebaPlusRecommendCard d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TiebaPlusRecommendCard(this.f52244a.getPageContext().getPageActivity()) : (TiebaPlusRecommendCard) invokeV.objValue;
        }

        public TiebaPlusRecommendCard h(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.resetData();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface c3 {
    }

    /* loaded from: classes9.dex */
    public class d extends b.a.q0.d1.i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52245a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52246b;

        public d(PbFragment pbFragment, int i2) {
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
            this.f52246b = pbFragment;
            this.f52245a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f52246b.getPbModel();
                if (pbModel != null) {
                    pbModel.e2(this.f52245a);
                }
                return b.a.r0.k2.u.f.f1.b.d(this.f52246b.getContext(), this.f52246b.N2(), 2, pbModel);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52247a;

        public d0(PbFragment pbFragment) {
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
            this.f52247a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f52247a.S0.M(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f52247a.E0 != null && this.f52247a.E0.O0() != null && this.f52247a.E0.O0().b() != null) {
                    this.f52247a.E0.O0().b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.f52247a;
                    pbFragment.y3(pbFragment.X0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52248a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f52249e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d1 f52250f;

            public a(d1 d1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52250f = d1Var;
                this.f52249e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52250f.f52248a.E0 == null || this.f52249e == null) {
                    return;
                }
                this.f52250f.f52248a.E0.c2(this.f52249e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(d1 d1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d1 f52251e;

            public c(d1 d1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52251e = d1Var;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f52251e.f52248a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f52251e.f52248a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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
            this.f52248a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b.a.q0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f52248a.x0 != null && this.f52248a.x0.P0() != null) {
                        statisticItem.param("fid", this.f52248a.x0.P0().m());
                    }
                    if (this.f52248a.x0 != null) {
                        statisticItem.param("tid", this.f52248a.x0.f1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    b.a.r0.k2.u.f.u0 u0Var = this.f52248a.mContentProcessController;
                    if (u0Var != null) {
                        u0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        b.a.q0.t.h.b.a(this.f52248a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        b.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.f52248a.g3()) {
                        this.f52248a.b4();
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f52248a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f52248a.getActivity(), this.f52248a.getActivity().getString(b.a.r0.k2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f52248a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f52248a.getActivity());
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f52248a.getActivity().getString(b.a.r0.k2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(b.a.r0.k2.l.cancel, new b(this));
                    aVar.setPositiveButton(b.a.r0.k2.l.open_now, new c(this));
                    aVar.create(this.f52248a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.f52248a;
                if (pbFragment.mContentProcessController == null) {
                    return;
                }
                if (pbFragment.E0 != null && this.f52248a.E0.O0() != null && this.f52248a.E0.O0().b() != null && this.f52248a.E0.O0().b().x()) {
                    this.f52248a.E0.O0().b().v(postWriteCallBackData);
                }
                this.f52248a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d2 implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52252a;

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
            this.f52252a = pbFragment;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.k2.u.f.u0 u0Var = this.f52252a.mContentProcessController;
                if (u0Var == null || u0Var.g() == null || !this.f52252a.mContentProcessController.g().d()) {
                    return !this.f52252a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.f52252a;
                pbFragment.showToast(pbFragment.mContentProcessController.g().c());
                if (this.f52252a.E0 != null && this.f52252a.E0.O0() != null && this.f52252a.E0.O0().b() != null && this.f52252a.E0.O0().b().x()) {
                    this.f52252a.E0.O0().b().v(this.f52252a.mContentProcessController.h());
                }
                this.f52252a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements b.a.q0.d1.q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52253a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f52254b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52255c;

        public e(PbFragment pbFragment, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52255c = pbFragment;
            this.f52253a = i2;
            this.f52254b = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.f52253a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f52255c.getContext(), this.f52254b, shareItem, false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e0 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52256a;

        public e0(PbFragment pbFragment) {
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
            this.f52256a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) {
                this.f52256a.E0.g1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i2 == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.f52256a.T3(num.intValue());
                    } else if (i2 == 1990055) {
                        TiebaStatic.log("c12142");
                        b.a.r0.e1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.f52256a.getResources().getString(b.a.r0.k2.l.neterror);
                        }
                        this.f52256a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e1 extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52257a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(PbFragment pbFragment, int i2, int i3) {
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
            this.f52257a = pbFragment;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView X0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.f52257a.f52221e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), b.a.r0.k2.l.thread_distribute_success);
                    if (this.f52257a.E0 == null || (X0 = this.f52257a.E0.X0()) == null || this.f52257a.E0.E0() == null) {
                        return;
                    }
                    this.f52257a.E0.E0().removeHeaderView(X0);
                    return;
                }
                b.a.e.e.p.l.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e2 implements b.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52258a;

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
            this.f52258a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                ((PlayVoiceBntNew) view).resetLayoutParams();
                return view;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).reset();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f52258a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f52258a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(b.a.r0.k2.g.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).reset();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52259a;

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
            this.f52259a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52259a.x0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f52259a.S0 != null) {
                this.f52259a.E0.v2(this.f52259a.S0.D());
            }
            this.f52259a.E0.o2();
            this.f52259a.E0.c0();
        }
    }

    /* loaded from: classes9.dex */
    public class f0 extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f0(PbFragment pbFragment) {
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
                }
            }
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52260a;

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
            this.f52260a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && b.a.q0.q0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.f52260a.r : j;
                if (this.f52260a.s == 0) {
                    this.f52260a.s = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                b.a.q0.q0.h hVar = new b.a.q0.q0.h(i2, z, responsedMessage, this.f52260a.v, this.f52260a.u, this.f52260a.s, z2, 0L, 0L, j3);
                this.f52260a.u = 0L;
                this.f52260a.v = 0L;
                hVar.c();
                if (z2) {
                    j2 = j3;
                    hVar.B = j2;
                    hVar.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.f52260a.x0 == null || this.f52260a.x0.P0() == null || this.f52260a.x0.P0().O() == null) {
                    return;
                }
                int o1 = this.f52260a.x0.P0().O().o1();
                if (o1 == 0 || o1 == 40) {
                    if (!StringHelper.equals(this.f52260a.Q, "from_personalize")) {
                        if (StringHelper.equals(this.f52260a.Q, "from_frs")) {
                            b.a.q0.q0.h hVar2 = new b.a.q0.q0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(o1);
                            return;
                        }
                        return;
                    }
                    b.a.q0.q0.d dVar = new b.a.q0.q0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(o1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(b.a.r0.k2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.f52260a.E0.t1(fVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, b.a.r0.k2.r.f fVar, String str, int i5) {
            b.a.q0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
                if (!z || fVar == null || fVar.W() != null || ListUtils.getCount(fVar.F()) >= 1) {
                    if (!this.f52260a.p0) {
                        this.f52260a.p0 = true;
                    } else if (this.f52260a.getPbModel() != null) {
                        this.f52260a.getPbModel().X();
                    }
                    this.f52260a.l = true;
                    this.f52260a.E0.P2();
                    if (fVar == null || !fVar.m0()) {
                        PbFragment pbFragment = this.f52260a;
                        pbFragment.hideLoadingView(pbFragment.E0.a1());
                    }
                    this.f52260a.E0.i1();
                    if (this.f52260a.N || this.f52260a.E0.F1()) {
                        this.f52260a.E0.c1();
                    } else if (!this.f52260a.E0.y1()) {
                        this.f52260a.E0.c3(false);
                    }
                    if (this.f52260a.m) {
                        this.f52260a.m = false;
                    }
                    if (i5 == 0 && fVar != null) {
                        this.f52260a.L0 = true;
                    }
                    if (fVar != null) {
                        PbFragment pbFragment2 = this.f52260a;
                        pbFragment2.hideNetRefreshView(pbFragment2.E0.a1());
                        this.f52260a.E0.X2();
                    }
                    ArrayList<PostData> arrayList = null;
                    String R0 = null;
                    arrayList = null;
                    if (z && fVar != null) {
                        b.a.q0.s.q.d2 O = fVar.O();
                        if (O != null && O.D2()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.f52260a;
                            pbFragment3.D3(pbFragment3.R0);
                        }
                        this.f52260a.E0.O0().l(fVar);
                        this.f52260a.E0.j3();
                        if (O != null && O.M() != null) {
                            this.f52260a.f4(O.M());
                        }
                        if (this.f52260a.S0 != null) {
                            this.f52260a.E0.v2(this.f52260a.S0.D());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(fVar.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.U().getBimg_end_time());
                        if (fVar.F() != null && fVar.F().size() >= 1 && fVar.F().get(0) != null) {
                            this.f52260a.x0.c2(fVar.F().get(0).G());
                        } else if (fVar.W() != null) {
                            this.f52260a.x0.c2(fVar.W().G());
                        }
                        if (this.f52260a.S0 != null) {
                            this.f52260a.S0.N(fVar.d());
                            this.f52260a.S0.O(fVar.l(), fVar.U());
                            this.f52260a.S0.s0(O);
                            this.f52260a.S0.P(this.f52260a.x0.s0(), this.f52260a.x0.f1(), this.f52260a.x0.p0());
                            if (O != null) {
                                this.f52260a.S0.i0(O.l2());
                            }
                        }
                        if (this.f52260a.z0 != null) {
                            this.f52260a.z0.h(fVar.r());
                        }
                        if (fVar.s() == 1) {
                            this.f52260a.w = true;
                        } else {
                            this.f52260a.w = false;
                        }
                        if (fVar.g0()) {
                            this.f52260a.w = true;
                        }
                        this.f52260a.E0.w2(this.f52260a.w);
                        this.f52260a.E0.n3(fVar, i3, i4, this.f52260a.x0.d1(), i5, this.f52260a.x0.z0());
                        this.f52260a.E0.z3(fVar, this.f52260a.x0.d1());
                        this.f52260a.E0.E3(this.f52260a.x0.t0());
                        AntiData d2 = fVar.d();
                        if (d2 != null) {
                            this.f52260a.D = d2.getVoice_message();
                            if (!StringUtils.isNull(this.f52260a.D) && this.f52260a.S0 != null && this.f52260a.S0.a() != null && (findLauncherById = this.f52260a.S0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.f52260a.D)) {
                                ((View) findLauncherById).setOnClickListener(this.f52260a.B1);
                            }
                        }
                        if (!this.f52260a.c0 && !ListUtils.isEmpty(this.f52260a.x0.P0().F()) && !this.f52260a.x0.s1()) {
                            this.f52260a.c0 = true;
                            this.f52260a.checkEasterEgg(false);
                        }
                        if (!TextUtils.isEmpty(this.f52260a.O0)) {
                            b.a.r0.k2.u.f.a1.k.f(this.f52260a.getListView(), this.f52260a.O0);
                            this.f52260a.O0 = null;
                        } else if (this.f52260a.N0) {
                            this.f52260a.N0 = false;
                            b.a.r0.k2.u.f.a1.k.e(this.f52260a.getListView());
                        } else if (this.f52260a.P0) {
                            this.f52260a.P0 = false;
                            b.a.r0.k2.u.f.a1.k.g(this.f52260a.getListView());
                        } else {
                            this.f52260a.E0.i3();
                        }
                        this.f52260a.x0.A1(fVar.l(), this.f52260a.F1);
                        this.f52260a.x0.G1(this.f52260a.H1);
                        if (this.f52260a.mReplyPrivacyController != null && O != null && O.J() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.J());
                            this.f52260a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                        }
                        if (this.f52260a.x0 == null || !this.f52260a.x0.r1()) {
                            if (this.f52260a.E0 != null) {
                                R0 = this.f52260a.E0.R0();
                            }
                        } else {
                            R0 = this.f52260a.getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs);
                        }
                        if (!StringUtils.isNull(R0)) {
                            this.f52260a.S0.l0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), R0));
                        }
                    } else if (str != null) {
                        if (this.f52260a.L0 || i5 != 1) {
                            this.f52260a.showToast(str);
                        } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                            if (i2 == 4) {
                                if (this.f52260a.x0.g0() != null && !StringUtils.isNull(this.f52260a.x0.g0().f18753c)) {
                                    this.f52260a.E0.G3(this.f52260a.x0.g0());
                                } else {
                                    PbFragment pbFragment4 = this.f52260a;
                                    pbFragment4.showNetRefreshView(pbFragment4.E0.a1(), this.f52260a.getPageContext().getResources().getString(b.a.r0.k2.l.net_error_text, str, Integer.valueOf(i2)), true);
                                    PbFragment pbFragment5 = this.f52260a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(b.a.e.e.p.l.g(pbFragment5.getContext(), b.a.r0.k2.g.ds360));
                                }
                            } else {
                                PbFragment pbFragment6 = this.f52260a;
                                pbFragment6.showNetRefreshView(pbFragment6.E0.a1(), this.f52260a.getPageContext().getResources().getString(b.a.r0.k2.l.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment7 = this.f52260a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(b.a.e.e.p.l.g(pbFragment7.getContext(), b.a.r0.k2.g.ds360));
                            }
                            this.f52260a.E0.c1();
                            this.f52260a.E0.b1();
                        }
                        if (i2 == 4 || i2 == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.f52260a.x0.f1());
                                jSONObject.put("fid", this.f52260a.x0.getForumId());
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
                            if (this.f52260a.x0 != null && this.f52260a.x0.P0() != null) {
                                arrayList = this.f52260a.x0.P0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f52260a.E0.s2(this.f52260a.getResources().getString(b.a.r0.k2.l.list_no_more_new));
                            } else {
                                if (this.f52260a.isHostOnlyMode()) {
                                    this.f52260a.E0.t2(this.f52260a.getResources().getString(b.a.r0.k2.l.pb_no_host_reply));
                                } else {
                                    this.f52260a.E0.t2(this.f52260a.getResources().getString(b.a.r0.k2.l.pb_no_replay));
                                }
                                this.f52260a.E0.t1(this.f52260a.x0.P0());
                            }
                        } else {
                            this.f52260a.E0.s2("");
                        }
                        this.f52260a.E0.i0();
                    }
                    if (fVar != null && fVar.m && this.f52260a.s == 0) {
                        this.f52260a.s = System.currentTimeMillis() - this.f52260a.r;
                    }
                    if (this.f52260a.getPbModel().d1() && this.f52260a.getPbModel().P0().y().c() == 0 && !this.f52260a.getPbModel().q1()) {
                        return;
                    }
                    this.f52260a.T0 = true;
                    return;
                }
                this.f52260a.x0.p2(1);
                if (this.f52260a.f52225i != null) {
                    this.f52260a.f52225i.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f52260a.x0 == null) {
                return;
            }
            if (this.f52260a.S0 == null || !this.f52260a.S0.z) {
                b.a.q0.x.x.d dVar = new b.a.q0.x.x.d();
                this.f52260a.D3(dVar);
                PbFragment pbFragment = this.f52260a;
                pbFragment.S0 = (b.a.q0.x.x.e) dVar.a(pbFragment.getContext());
                this.f52260a.S0.f0(this.f52260a.f52221e.getPageContext());
                this.f52260a.S0.o0(this.f52260a.X1);
                this.f52260a.S0.p0(this.f52260a.Y0);
                this.f52260a.S0.G(this.f52260a.f52221e.getPageContext(), this.f52260a.f52221e.getIntent() == null ? null : this.f52260a.f52221e.getIntent().getExtras());
                this.f52260a.S0.a().showLinePositionBottom(true);
                this.f52260a.E0.r2(this.f52260a.S0.a());
                if (!this.f52260a.x0.D0()) {
                    this.f52260a.S0.s(this.f52260a.x0.f1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.f52260a.S0.l0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.f52260a.x0.r1()) {
                    this.f52260a.S0.l0(this.f52260a.getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs));
                } else if (this.f52260a.E0 != null) {
                    this.f52260a.S0.l0(this.f52260a.E0.R0());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f2 implements b.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52261a;

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
            this.f52261a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
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
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f52261a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52262a;

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
            this.f52262a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.f52262a.x0.x2((UserPendantData) customResponsedMessage.getData());
                if (this.f52262a.E0 != null && this.f52262a.x0 != null) {
                    this.f52262a.E0.i2(this.f52262a.x0.P0(), this.f52262a.x0.d1(), this.f52262a.x0.Z0(), this.f52262a.E0.V0());
                }
                if (this.f52262a.E0 == null || this.f52262a.E0.n0() == null) {
                    return;
                }
                this.f52262a.E0.n0().X();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g0 implements b3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52263a;

        public g0(PbFragment pbFragment) {
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
            this.f52263a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!b.a.e.e.p.j.z()) {
                    this.f52263a.showToast(b.a.r0.k2.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f52263a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f52263a.getPageContext().getPageActivity(), this.f52263a.x0.P0().l().getId(), this.f52263a.x0.P0().l().getName(), this.f52263a.x0.P0().O().f0(), String.valueOf(this.f52263a.x0.P0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52264a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(PbFragment pbFragment, int i2) {
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
            this.f52264a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f52264a.e4();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g2 implements b.a.e.e.k.c<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52265a;

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
            this.f52265a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ ItemCardView c(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            h(itemCardView2);
            return itemCardView2;
        }

        public ItemCardView e(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemCardView)) == null) {
                itemCardView.onChangeSkinType();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public ItemCardView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ItemCardView(this.f52265a.getPageContext().getPageActivity()) : (ItemCardView) invokeV.objValue;
        }

        public ItemCardView h(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, itemCardView)) == null) {
                itemCardView.reset();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52266a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PbFragment pbFragment, int i2) {
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
            this.f52266a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.f52266a.E0 == null) {
                return;
            }
            if (booleanValue) {
                this.f52266a.E0.u3();
            } else {
                this.f52266a.E0.i1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h0 implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52267a;

        public h0(PbFragment pbFragment) {
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
            this.f52267a = pbFragment;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f52267a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == b.a.r0.k2.i.richText) {
                            if (this.f52267a.richTextHandleSingleTap(view)) {
                                return true;
                            }
                        } else if (view.getId() == b.a.r0.k2.i.pb_floor_item_layout) {
                            if (view.getTag(b.a.r0.k2.i.tag_from) instanceof SparseArray) {
                                this.f52267a.X3((SparseArray) view.getTag(b.a.r0.k2.i.tag_from));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != b.a.r0.k2.i.pb_post_header_layout) {
                            if (this.f52267a.E0.A1() && view.getId() == b.a.r0.k2.i.pb_head_user_info_root) {
                                if (view.getTag(b.a.r0.k2.i.tag_user_id) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(b.a.r0.k2.i.tag_user_id)));
                                }
                                if (this.f52267a.getEventController() != null && this.f52267a.getEventController().f19142b != null) {
                                    this.f52267a.getEventController().f19142b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f52267a.X3(sparseArray);
                        }
                    }
                    if (this.f52267a.S0 != null) {
                        this.f52267a.E0.v2(this.f52267a.S0.D());
                    }
                    this.f52267a.E0.o2();
                    this.f52267a.E0.c0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f52267a.isAdded()) {
                    this.f52267a.doDoubleClick();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h1 implements b.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52268a;

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
            this.f52268a = pbFragment;
        }

        @Override // b.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52268a.showProgressBar();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h2 implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52269a;

        public h2(PbFragment pbFragment) {
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
            this.f52269a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            b.a.r0.k2.u.f.h n0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.f52269a.checkUpIsLogin()) {
                            this.f52269a.E0.N1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f52269a.x0.f1());
                    statisticItem.param("fid", this.f52269a.x0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.f52269a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) == null || !(view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.f52269a.x0.J.g0()) {
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
                            this.f52269a.M2(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.f52269a.x0.a1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.f52269a.isHostOnlyMode());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.f52269a.x0 != null) {
                                bVar.A(this.f52269a.x0.getFromForumId());
                                if (this.f52269a.x0.P0() != null) {
                                    bVar.N(this.f52269a.x0.P0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.f52269a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.f52269a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.f52269a.u3(str, i2, eVar);
                        if (eVar.f52191h) {
                            TbRichText h4 = this.f52269a.h4(str, i2);
                            if (h4 != null && this.f52269a.j2 >= 0 && this.f52269a.j2 < h4.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a2 = b.a.r0.k2.r.g.a(h4.y().get(this.f52269a.j2));
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= eVar.f52184a.size()) {
                                        break;
                                    } else if (eVar.f52184a.get(i7).equals(a2)) {
                                        eVar.j = i7;
                                        arrayList2.add(a2);
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                                if (h4.getPostId() != 0 && (n0 = this.f52269a.E0.n0()) != null) {
                                    ArrayList<b.a.e.l.e.n> s = n0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<b.a.e.l.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            b.a.e.l.e.n next = it.next();
                                            if ((next instanceof PostData) && h4.getPostId() == b.a.e.e.m.b.g(((PostData) next).G(), 0L)) {
                                                b.a.r0.k2.w.a.b(this.f52269a.x0.P0(), (PostData) next, ((PostData) next).k0, h4.getPostId() == b.a.e.e.m.b.g(this.f52269a.x0.p0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f52185b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.f52269a.M2(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f52186c);
                                bVar2.y(eVar.f52187d);
                                bVar2.O(eVar.f52188e);
                                bVar2.C(eVar.f52190g);
                                bVar2.H(true);
                                bVar2.J(eVar.f52192i);
                                bVar2.F(this.f52269a.x0.a1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.f52269a.isHostOnlyMode());
                                bVar2.L(eVar.f52189f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.f52269a.x0 != null) {
                                    bVar2.A(this.f52269a.x0.getFromForumId());
                                    if (this.f52269a.x0.P0() != null) {
                                        bVar2.N(this.f52269a.x0.P0().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.f52269a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.f52269a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.f52184a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.f52185b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f52186c);
                        bVar3.y(eVar.f52187d);
                        bVar3.O(eVar.f52188e);
                        bVar3.C(eVar.f52190g);
                        bVar3.H(true);
                        bVar3.J(eVar.f52184a.get(0));
                        bVar3.F(this.f52269a.x0.a1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.f52269a.isHostOnlyMode());
                        bVar3.L(eVar.f52189f);
                        bVar3.D(false);
                        if (this.f52269a.x0 != null) {
                            bVar3.A(this.f52269a.x0.getFromForumId());
                            if (this.f52269a.x0.P0() != null) {
                                bVar3.N(this.f52269a.x0.P0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.f52269a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.f52269a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.f52269a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f52269a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    this.f52269a.W = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52270a;

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
            this.f52270a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f52270a.S0 != null) {
                this.f52270a.E0.v2(this.f52270a.S0.D());
            }
            this.f52270a.E0.c3(false);
        }
    }

    /* loaded from: classes9.dex */
    public class i0 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52271a;

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
            this.f52271a = pbFragment;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f52271a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.f52271a;
                    pbFragment.K0 = pbFragment.K0.trim();
                    UtilHelper.callPhone(this.f52271a.getPageContext().getPageActivity(), this.f52271a.K0);
                    new b.a.r0.k2.u.f.c(this.f52271a.x0.f1(), this.f52271a.K0, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f52271a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    PbFragment pbFragment2 = this.f52271a;
                    pbFragment2.K0 = pbFragment2.K0.trim();
                    UtilHelper.smsPhone(this.f52271a.getPageContext().getPageActivity(), this.f52271a.K0);
                    new b.a.r0.k2.u.f.c(this.f52271a.x0.f1(), this.f52271a.K0, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    PbFragment pbFragment3 = this.f52271a;
                    pbFragment3.K0 = pbFragment3.K0.trim();
                    UtilHelper.startBaiDuBar(this.f52271a.getPageContext().getPageActivity(), this.f52271a.K0);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52272a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(PbFragment pbFragment, int i2, boolean z) {
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
            this.f52272a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f52272a.E0 != null) {
                    PbFragment pbFragment = this.f52272a;
                    pbFragment.hideLoadingView(pbFragment.E0.a1());
                    this.f52272a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            new BdTopToast(this.f52272a.getContext()).setIcon(true).setContent(this.f52272a.getString(b.a.r0.k2.l.block_user_success)).show((ViewGroup) this.f52272a.getView());
                            this.f52272a.E3(type);
                            return;
                        }
                        new BdTopToast(this.f52272a.getContext()).setIcon(false).setContent(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f52272a.getResources().getString(b.a.r0.k2.l.neterror) : httpResponsedMessage.getErrorString()).show((ViewGroup) this.f52272a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i2 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52273a;

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
            this.f52273a = pbFragment;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                PbFragment pbFragment = this.f52273a;
                PostData postData = pbFragment.m2;
                if (postData != null) {
                    if (i2 == 0) {
                        postData.l0(pbFragment.getPageContext().getPageActivity());
                        this.f52273a.m2 = null;
                    } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.f52273a;
                        pbFragment2.markFloor(pbFragment2.m2);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52274a;

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
            this.f52274a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            b.a.r0.k2.o oVar = (b.a.r0.k2.o) customResponsedMessage.getData();
            int type = oVar.getType();
            if (type == 0) {
                this.f52274a.refreshWrite((b.a.r0.k2.r.s) oVar.a());
            } else if (type == 1) {
                this.f52274a.K2((ForumManageModel.b) oVar.a(), false);
            } else if (type != 2) {
            } else {
                if (oVar.a() == null) {
                    this.f52274a.refreshMark(false, null);
                } else {
                    this.f52274a.refreshMark(true, (MarkData) oVar.a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52275a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(PbFragment pbFragment, int i2) {
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
            this.f52275a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f52275a.f1) {
                this.f52275a.E0.g1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                b.a.r0.k2.r.f P0 = this.f52275a.x0.P0();
                if (P0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f52275a.e1.c(this.f52275a.d1.getResources().getString(b.a.r0.k2.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f52275a.d1.getResources().getString(b.a.r0.k2.l.mute_error_beyond_limit);
                    }
                    this.f52275a.U3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f52275a.P3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (b.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f52275a.d1.getResources().getString(b.a.r0.k2.l.mute_fail);
                    }
                    this.f52275a.e1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j1 implements a.InterfaceC0664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52276a;

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
            this.f52276a = pbFragment;
        }

        @Override // b.a.q0.i.a.InterfaceC0664a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f52276a.E0.P2();
                if (z) {
                    if (this.f52276a.z0 != null) {
                        this.f52276a.z0.h(z2);
                    }
                    this.f52276a.x0.r2(z2);
                    if (this.f52276a.x0.B0()) {
                        this.f52276a.p3();
                    } else {
                        this.f52276a.E0.t1(this.f52276a.x0.P0());
                    }
                    if (z2) {
                        if (this.f52276a.z0 != null) {
                            if (this.f52276a.z0.f() == null || this.f52276a.x0 == null || this.f52276a.x0.P0() == null || this.f52276a.x0.P0().O() == null || this.f52276a.x0.P0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.f52276a.z0.f();
                            MetaData J = this.f52276a.x0.P0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.f52276a.O3(J);
                                } else {
                                    this.f52276a.showToast(b.a.r0.k2.l.add_mark_on_pb);
                                    if (b.a.q0.t.h.a.e(this.f52276a.getContext(), 0)) {
                                        b.a.q0.t.h.a.g(this.f52276a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.f52276a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(b.a.r0.k2.l.add_mark));
                            }
                        }
                        this.f52276a.A2();
                        return;
                    }
                    PbFragment pbFragment2 = this.f52276a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(b.a.r0.k2.l.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.f52276a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(b.a.r0.k2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j2 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52277a;

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
            this.f52277a = pbFragment;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f52277a.i1 == null || TextUtils.isEmpty(this.f52277a.j1)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f52277a.k1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f52277a.j1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f11986a = this.f52277a.j1;
                        String str = "";
                        if (this.f52277a.k1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f52277a.k1.memeInfo.pck_id;
                        }
                        aVar.f11987b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f52277a.U0 == null) {
                        this.f52277a.U0 = new PermissionJudgePolicy();
                    }
                    this.f52277a.U0.clearRequestPermissionList();
                    this.f52277a.U0.appendRequestPermission(this.f52277a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f52277a.U0.startRequestPermission(this.f52277a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f52277a.h1 == null) {
                        PbFragment pbFragment = this.f52277a;
                        pbFragment.h1 = new b.a.r0.k2.u.f.w0(pbFragment.getPageContext());
                    }
                    this.f52277a.h1.b(this.f52277a.j1, this.f52277a.i1.n());
                }
                this.f52277a.i1 = null;
                this.f52277a.j1 = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52278a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PbFragment pbFragment, int i2) {
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
            this.f52278a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52278a.E0 == null || this.f52278a.E0.n0() == null) {
                return;
            }
            this.f52278a.E0.n0().X();
        }
    }

    /* loaded from: classes9.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52279a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(PbFragment pbFragment, int i2) {
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
            this.f52279a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f52279a.f1) {
                this.f52279a.E0.g1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f52279a.e1.c(this.f52279a.d1.getResources().getString(b.a.r0.k2.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (b.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f52279a.d1.getResources().getString(b.a.r0.k2.l.un_mute_fail);
                }
                this.f52279a.e1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f52280e;

        public k1(PbFragment pbFragment, MetaData metaData) {
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
            this.f52280e = metaData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f52280e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k2 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52281e;

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
            this.f52281e = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f52281e.x0 == null || this.f52281e.x0.Y0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = this.f52281e;
            pbFragment.C3(pbFragment.W2(i2));
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52282a;

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
            this.f52282a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                b.a.q0.f1.n.f.c(this.f52282a.getPageContext(), this.f52282a, aVar.f12438a, aVar.f12439b, aVar.f12440c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52283e;

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
            this.f52283e = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.f52283e.x0 != null && this.f52283e.x0.B0()) {
                    this.f52283e.p3();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class l1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f52284e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52285f;

        public l1(PbFragment pbFragment, MetaData metaData) {
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
            this.f52285f = pbFragment;
            this.f52284e = metaData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f52284e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f52285f.B0.l(!this.f52284e.hadConcerned(), this.f52284e.getPortrait(), this.f52284e.getUserId(), this.f52284e.isGod(), "6", this.f52285f.getPageContext().getUniqueId(), this.f52285f.x0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52286e;

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
            this.f52286e = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.f52286e;
                pbFragment.f52222f = true;
                return pbFragment.H2(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52287a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PbFragment pbFragment, int i2) {
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
            this.f52287a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52287a.k) {
                return;
            }
            this.f52287a.W3();
        }
    }

    /* loaded from: classes9.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52288a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(PbFragment pbFragment, int i2) {
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
            this.f52288a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.f52288a.g3() || this.f52288a.f52221e == null || this.f52288a.f52221e.getPbModel() == null || !str.equals(this.f52288a.f52221e.getPbModel().getTopicId())) {
                    return;
                }
                this.f52288a.c4(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52289e;

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
            this.f52289e = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f52289e.x0 == null || this.f52289e.x0.P0() == null || this.f52289e.E0 == null || this.f52289e.E0.n0() == null) {
                return;
            }
            this.f52289e.E0.T1(absListView, i2, i3, i4);
            if (this.f52289e.f52225i != null) {
                this.f52289e.f52225i.q(absListView, i2, i3, i4);
            }
            if (!this.f52289e.x0.t1() || (F = this.f52289e.x0.P0().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i2 + i3) - this.f52289e.E0.n0().w()) - 1;
            b.a.r0.k2.r.f P0 = this.f52289e.x0.P0();
            if (P0 == null) {
                return;
            }
            if (P0.D() != null && P0.D().I0()) {
                w--;
            }
            if (P0.E() != null && P0.E().I0()) {
                w--;
            }
            int size = F.size();
            if (w < 0 || w >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                PbFragment pbFragment = this.f52289e;
                if (!pbFragment.i3(pbFragment.b1) && this.f52289e.i3(i2)) {
                    if (this.f52289e.E0 != null) {
                        this.f52289e.E0.c0();
                        if (this.f52289e.S0 != null && !this.f52289e.E0.v1()) {
                            this.f52289e.E0.v2(this.f52289e.S0.D());
                        }
                        if (!this.f52289e.N) {
                            this.f52289e.E0.o2();
                        }
                    }
                    if (!this.f52289e.x) {
                        this.f52289e.x = true;
                    }
                }
                if (this.f52289e.E0 != null) {
                    this.f52289e.E0.U1(absListView, i2);
                }
                if (this.f52289e.f52225i != null) {
                    this.f52289e.f52225i.r(absListView, i2);
                }
                if (this.f52289e.y == null) {
                    this.f52289e.y = new b.a.q0.q0.b();
                    this.f52289e.y.a(1001);
                }
                if (i2 == 0) {
                    this.f52289e.y.e();
                    if (this.f52289e.q0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.f52289e.q0);
                        this.f52289e.q0 = null;
                    }
                } else {
                    if (this.f52289e.q0 == null) {
                        this.f52289e.q0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.f52289e.y.d();
                }
                this.f52289e.b1 = i2;
                if (i2 == 0) {
                    this.f52289e.A3(false, null);
                    b.a.r0.k3.c.g().h(this.f52289e.getUniqueId(), true);
                    this.f52289e.checkEasterEgg(true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52290e;

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
            this.f52290e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.l(this.f52290e.getContext(), this.f52290e.getUniqueId(), view, (ViewGroup) this.f52290e.getView());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52291a;

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
            this.f52291a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.f52291a.getContext()).setIcon(false).setContent(this.f52291a.getString(b.a.r0.k2.l.novel_thread_mask_click_tip)).show((ViewGroup) this.f52291a.getView());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(PbFragment pbFragment, int i2) {
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
            this.f52292a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.w3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f52292a.f1) {
                b.a.r0.w3.a aVar = (b.a.r0.w3.a) customResponsedMessage.getData();
                this.f52292a.E0.g1();
                SparseArray<Object> sparseArray = (SparseArray) this.f52292a.c1;
                DataRes dataRes = aVar.f25388a;
                if (aVar.f25390c == 0 && dataRes != null) {
                    int e2 = b.a.e.e.m.b.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = e2 == 1;
                    if (b.a.e.e.p.k.isEmpty(str)) {
                        sparseArray.put(b.a.r0.k2.i.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(b.a.r0.k2.i.tag_user_mute_msg, str);
                    }
                    sparseArray.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_from)).intValue();
                if (intValue == 0) {
                    this.f52292a.Q3(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f52292a.E0.a2(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n1 implements Comparator<b.a.q0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b.a.q0.u.a aVar, b.a.q0.u.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class n2 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52293a;

        public n2(PbFragment pbFragment) {
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
            this.f52293a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.f52293a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f52293a.getView(), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f52293a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f52293a.getView(), 0L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52294e;

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
            this.f52294e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.f52294e;
                pbFragment.showToast(pbFragment.D);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52295a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(PbFragment pbFragment, int i2) {
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
            this.f52295a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f52295a.E0.v1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.f52295a.doDoubleClick();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o1(PbFragment pbFragment) {
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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o2 implements a3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52296a;

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
            this.f52296a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f52296a.E0 != null && this.f52296a.E0.O0() != null) {
                    b.a.r0.k2.u.f.t O0 = this.f52296a.E0.O0();
                    if (O0.f()) {
                        O0.d();
                        return true;
                    }
                }
                if (this.f52296a.E0 == null || !this.f52296a.E0.I1()) {
                    return false;
                }
                this.f52296a.E0.k1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class p implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52297a;

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
            this.f52297a = pbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52297a.A = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52298a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(PbFragment pbFragment, int i2) {
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
            this.f52298a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.r0.l3.j0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.r0.l3.j0.e) || (eVar = (b.a.r0.l3.j0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f20602b) == null || agreeData.agreeType != 2 || this.f52298a.E0 == null || !b.a.q0.b.d.T() || b.a.r0.k2.u.f.f1.b.k(this.f52298a.x0.f52416f)) {
                return;
            }
            this.f52298a.E0.v3();
            b.a.r0.k2.u.f.f1.b.b(this.f52298a.x0.f52416f);
        }
    }

    /* loaded from: classes9.dex */
    public class p1 extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52299a;

        public p1(PbFragment pbFragment) {
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
            this.f52299a = pbFragment;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f52299a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.f52299a.A0.getLoadDataMode()) {
                        case 0:
                            this.f52299a.x0.o1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f52299a.K2(bVar, (bVar.f54252e != 1002 || bVar.f54253f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f52299a.E0.k0(1, dVar.f54256a, dVar.f54257b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.f52299a;
                            pbFragment.L2(pbFragment.A0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.f52299a.E0.k0(this.f52299a.A0.getLoadDataMode(), gVar.f54270a, gVar.f54271b, false);
                            this.f52299a.E0.V1(gVar.f54272c);
                            return;
                        default:
                            return;
                    }
                }
                this.f52299a.E0.k0(this.f52299a.A0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52300e;

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
            this.f52300e = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f52300e.k && z && !this.f52300e.x0.F0()) {
                    this.f52300e.x3();
                }
                PbFragment pbFragment = this.f52300e;
                pbFragment.setNetRefreshViewEmotionMarginTop(b.a.e.e.p.l.g(pbFragment.getContext(), b.a.r0.k2.g.ds360));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52301a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PbFragment pbFragment, int i2) {
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
            this.f52301a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.q0.s.q.j0)) {
                b.a.q0.s.q.j0 j0Var = (b.a.q0.s.q.j0) customResponsedMessage.getData();
                d1.a aVar = new d1.a();
                int i2 = j0Var.f13358a;
                String str = j0Var.f13359b;
                aVar.f13270a = j0Var.f13361d;
                b.a.r0.k2.r.f P0 = this.f52301a.x0.P0();
                if (P0 == null) {
                    return;
                }
                if (this.f52301a.x0.s0() != null && this.f52301a.x0.s0().getUserIdLong() == j0Var.p) {
                    this.f52301a.E0.h2(j0Var.l, this.f52301a.x0.P0(), this.f52301a.x0.d1(), this.f52301a.x0.Z0());
                }
                if (P0.F() == null || P0.F().size() < 1 || P0.F().get(0) == null) {
                    return;
                }
                long g2 = b.a.e.e.m.b.g(P0.F().get(0).G(), 0L);
                long g3 = b.a.e.e.m.b.g(this.f52301a.x0.f1(), 0L);
                if (g2 == j0Var.n && g3 == j0Var.m) {
                    b.a.q0.s.q.d1 F = P0.F().get(0).F();
                    if (F == null) {
                        F = new b.a.q0.s.q.d1();
                    }
                    ArrayList<d1.a> a2 = F.a();
                    if (a2 == null) {
                        a2 = new ArrayList<>();
                    }
                    a2.add(0, aVar);
                    F.e(F.b() + j0Var.l);
                    F.d(a2);
                    P0.F().get(0).p0(F);
                    this.f52301a.E0.n0().X();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52302a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(PbFragment pbFragment, int i2) {
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
            this.f52302a = pbFragment;
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
            this.f52302a.l1 = true;
        }
    }

    /* loaded from: classes9.dex */
    public class q1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q1(PbFragment pbFragment) {
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
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class q2 implements b.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52303a;

        public q2(PbFragment pbFragment) {
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
            this.f52303a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
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
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f52303a.getPageContext().getPageActivity());
                linearLayout.setId(b.a.r0.k2.i.pb_text_voice_layout);
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

    /* loaded from: classes9.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52304a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PbFragment pbFragment, int i2) {
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
            this.f52304a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f52304a.x0 == null || this.f52304a.x0.P0() == null) {
                return;
            }
            this.f52304a.x0.P0().a();
            this.f52304a.x0.o1();
            if (this.f52304a.E0.n0() != null) {
                this.f52304a.E0.t1(this.f52304a.x0.P0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes9.dex */
    public class r0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52305e;

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
            this.f52305e = pbFragment;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f52305e.hideKeyBroad();
                b.a.q0.s.q.b1 N0 = this.f52305e.x0.N0();
                int L0 = this.f52305e.E0.L0();
                if (L0 <= 0) {
                    this.f52305e.showToast(b.a.r0.k2.l.pb_page_error);
                } else if (N0 == null || L0 <= N0.h()) {
                    this.f52305e.E0.c0();
                    this.f52305e.stopVoice();
                    this.f52305e.E0.Q2();
                    if (b.a.e.e.p.j.z()) {
                        this.f52305e.x0.p2(this.f52305e.E0.L0());
                        if (this.f52305e.f52225i != null) {
                            this.f52305e.f52225i.x();
                        }
                    } else {
                        this.f52305e.showToast(b.a.r0.k2.l.neterror);
                    }
                    aVar.dismiss();
                } else {
                    this.f52305e.showToast(b.a.r0.k2.l.pb_page_error);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r1 implements c3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r2 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52306e;

        public r2(PbFragment pbFragment) {
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
            this.f52306e = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.f52306e.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    View childAt = frameLayout.getChildAt(i2);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.f52306e.f52224h.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52307a;

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
            this.f52307a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f52307a.x0 == null || this.f52307a.x0.P0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f52307a.I2(str);
            this.f52307a.x0.o1();
            if (!TextUtils.isEmpty(str) && this.f52307a.x0.P0().F() != null) {
                ArrayList<PostData> F = this.f52307a.x0.P0().F();
                b.a.r0.l3.j0.p pVar = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof b.a.r0.l3.j0.p) {
                        b.a.r0.l3.j0.p pVar2 = (b.a.r0.l3.j0.p) next;
                        if (str.equals(pVar2.J0())) {
                            pVar = pVar2;
                            break;
                        }
                    }
                }
                if (pVar != null) {
                    F.remove(pVar);
                    if (this.f52307a.E0.n0() != null && this.f52307a.E0.n0().s() != null) {
                        this.f52307a.E0.n0().s().remove(pVar);
                    }
                    if (this.f52307a.E0.E0() != null && this.f52307a.E0.E0().getData() != null) {
                        this.f52307a.E0.E0().getData().remove(pVar);
                    }
                    if (this.f52307a.E0.n0() != null) {
                        this.f52307a.E0.n0().X();
                        return;
                    }
                }
            }
            if (this.f52307a.E0.n0() != null) {
                this.f52307a.E0.t1(this.f52307a.x0.P0());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52308e;

        public s0(PbFragment pbFragment) {
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
            this.f52308e = pbFragment;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f52308e.I0 != null) {
                    this.f52308e.I0.dismiss();
                }
                this.f52308e.d4(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_share);
                        this.f52308e.w3(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_reply);
                        this.f52308e.w3(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f52308e.w3(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            this.f52308e.w3(view5);
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
                        if (this.f52308e.i1 == null || TextUtils.isEmpty(this.f52308e.j1)) {
                            return;
                        }
                        if (this.f52308e.k1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f52308e.j1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f11986a = this.f52308e.j1;
                            String str = "";
                            if (this.f52308e.k1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f52308e.k1.memeInfo.pck_id;
                            }
                            aVar.f11987b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f52308e.i1 = null;
                        this.f52308e.j1 = null;
                        return;
                    case 2:
                        if (this.f52308e.i1 == null || TextUtils.isEmpty(this.f52308e.j1)) {
                            return;
                        }
                        if (this.f52308e.U0 == null) {
                            this.f52308e.U0 = new PermissionJudgePolicy();
                        }
                        this.f52308e.U0.clearRequestPermissionList();
                        this.f52308e.U0.appendRequestPermission(this.f52308e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f52308e.U0.startRequestPermission(this.f52308e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f52308e.h1 == null) {
                            PbFragment pbFragment = this.f52308e;
                            pbFragment.h1 = new b.a.r0.k2.u.f.w0(pbFragment.getPageContext());
                        }
                        this.f52308e.h1.b(this.f52308e.j1, this.f52308e.i1.n());
                        this.f52308e.i1 = null;
                        this.f52308e.j1 = null;
                        return;
                    case 3:
                        PbFragment pbFragment2 = this.f52308e;
                        PostData postData = pbFragment2.m2;
                        if (postData != null) {
                            postData.l0(pbFragment2.getPageContext().getPageActivity());
                            this.f52308e.m2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f52308e.checkUpIsLogin()) {
                            this.f52308e.r3(view);
                            if (this.f52308e.x0.P0().O() == null || this.f52308e.x0.P0().O().J() == null || this.f52308e.x0.P0().O().J().getUserId() == null || this.f52308e.z0 == null) {
                                return;
                            }
                            PbFragment pbFragment3 = this.f52308e;
                            int X2 = pbFragment3.X2(pbFragment3.x0.P0());
                            b.a.q0.s.q.d2 O = this.f52308e.x0.P0().O();
                            if (O.M1()) {
                                i3 = 2;
                            } else if (O.P1()) {
                                i3 = 3;
                            } else if (!O.N1()) {
                                i3 = O.O1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f52308e.x0.f52416f).param("obj_locate", 2).param("obj_id", this.f52308e.x0.P0().O().J().getUserId()).param("obj_type", !this.f52308e.z0.e()).param("obj_source", X2).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!b.a.e.e.p.j.z()) {
                            this.f52308e.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f52308e.Z2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(b.a.r0.k2.i.tag_from, 0);
                                sparseArray2.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                this.f52308e.checkMuteState(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer) && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_id) instanceof String) && (sparseArray3.get(b.a.r0.k2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(b.a.r0.k2.i.tag_has_sub_post) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(b.a.r0.k2.i.tag_has_sub_post)).booleanValue();
                            boolean isHost = this.f52308e.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f52308e.J3(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f52308e.E0.Y1(((Integer) sparseArray3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f52308e.J3(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f52308e.E0.W1(((Integer) sparseArray3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!b.a.e.e.p.j.z()) {
                            this.f52308e.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f52308e.E0.W1(((Integer) sparseArray4.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray4.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray4.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (!booleanValue5) {
                            if (booleanValue6) {
                                sparseArray4.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                            }
                            this.f52308e.E0.b2(view);
                            return;
                        } else {
                            sparseArray4.put(b.a.r0.k2.i.tag_from, 1);
                            sparseArray4.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                            this.f52308e.checkMuteState(sparseArray4);
                            return;
                        }
                    case 8:
                        if (this.f52308e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f52308e.F2(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f52308e.checkUpIsLogin() || this.f52308e.x0 == null || this.f52308e.x0.P0() == null) {
                            return;
                        }
                        this.f52308e.f52221e.showBlockDialog(b.a.r0.v3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s1 implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52309a;

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
            this.f52309a = pbFragment;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.k2.u.f.u0 u0Var = this.f52309a.mContentProcessController;
                if (u0Var == null || u0Var.e() == null || !this.f52309a.mContentProcessController.e().d()) {
                    return !this.f52309a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.f52309a;
                pbFragment.showToast(pbFragment.mContentProcessController.e().c());
                if (this.f52309a.S0 != null && (this.f52309a.S0.C() || this.f52309a.S0.E())) {
                    this.f52309a.S0.A(false, this.f52309a.mContentProcessController.h());
                }
                this.f52309a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class s2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f52310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52311b;

        public s2(PbFragment pbFragment) {
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
            this.f52311b = pbFragment;
            this.f52310a = (int) TbadkCoreApplication.getInst().getResources().getDimension(b.a.r0.k2.g.ds98);
        }

        @Override // b.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || !e(i3) || this.f52311b.E0 == null || this.f52311b.f52225i == null) {
                return;
            }
            this.f52311b.f52225i.u(true);
            if (Math.abs(i3) > this.f52310a) {
                this.f52311b.f52225i.l();
            }
            if (this.f52311b.getIsMangaThread()) {
                this.f52311b.E0.h1();
                this.f52311b.E0.q2();
            }
        }

        @Override // b.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || !e(i3) || this.f52311b.E0 == null || this.f52311b.f52225i == null) {
                return;
            }
            this.f52311b.E0.s3();
            this.f52311b.f52225i.u(false);
            this.f52311b.f52225i.x();
        }

        @Override // b.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.k0.a.b
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

    /* loaded from: classes9.dex */
    public class t implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(b.a.r0.k2.u.f.b1.e.a aVar) {
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

    /* loaded from: classes9.dex */
    public class t0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f52312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52313f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f52314g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52315h;

        public t0(PbFragment pbFragment, SparseArray sparseArray, int i2, boolean z) {
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
            this.f52315h = pbFragment;
            this.f52312e = sparseArray;
            this.f52313f = i2;
            this.f52314g = z;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f52315h.deleteThreadDirect(((Integer) this.f52312e.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) this.f52312e.get(b.a.r0.k2.i.tag_del_post_id), this.f52313f, this.f52314g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t1 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52316e;

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
            this.f52316e = pbFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f52316e.getIsMangaThread()) {
                    this.f52316e.f52221e.finish();
                }
                if (!this.f52316e.x0.F1(true)) {
                    this.f52316e.E0.j0();
                } else {
                    TiebaStatic.eventStat(this.f52316e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class t2 implements b.InterfaceC0942b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t2() {
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

        @Override // b.a.r0.k0.b.InterfaceC0942b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    b.a.r0.k2.s.b.d();
                } else {
                    b.a.r0.k2.s.b.c();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52317a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PbFragment pbFragment, int i2) {
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
            this.f52317a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.f52317a.E0 == null || this.f52317a.x0 == null) {
                return;
            }
            this.f52317a.E0.W(false);
            if (this.f52317a.x0.B1(false)) {
                this.f52317a.E0.R2();
            } else if (this.f52317a.x0.P0() != null) {
                this.f52317a.E0.k2();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u1 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52318e;

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
            this.f52318e = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52318e.h2 && this.f52318e.getIsMangaThread()) {
                    this.f52318e.l3();
                }
                if (this.f52318e.mIsLogin) {
                    if (!this.f52318e.o0 && this.f52318e.E0 != null && this.f52318e.E0.T() && this.f52318e.x0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.f52318e.x0.f1());
                        statisticItem.param("fid", this.f52318e.x0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i2 = 5;
                        if (this.f52318e.x0.v0()) {
                            i2 = 4;
                        } else if (this.f52318e.x0.w0()) {
                            i2 = 3;
                        } else if (this.f52318e.x0.y0()) {
                            i2 = 1;
                        }
                        statisticItem.param("obj_type", i2);
                        TiebaStatic.log(statisticItem);
                        this.f52318e.o0 = true;
                    }
                    if (this.f52318e.x0.B1(false)) {
                        this.f52318e.E0.R2();
                        TiebaStatic.eventStat(this.f52318e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if (this.f52318e.u0 == null || !this.f52318e.u0.d()) {
                        if (this.f52318e.x0.P0() != null) {
                            this.f52318e.E0.k2();
                        }
                    } else {
                        this.f52318e.E0.R2();
                    }
                    this.f52318e.h2 = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u2 implements p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52319a;

        public u2(PbFragment pbFragment) {
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
            this.f52319a = pbFragment;
        }

        @Override // b.a.r0.k2.u.f.p.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i2 == 0) {
                        this.f52319a.showToast(b.a.r0.k2.l.upgrage_toast_dialog);
                    } else {
                        this.f52319a.showToast(b.a.r0.k2.l.neterror);
                    }
                } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                    this.f52319a.E0.a0(str);
                } else {
                    this.f52319a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52320a;

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
            this.f52320a = pbFragment;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f52320a.E0 == null) {
                return;
            }
            this.f52320a.E0.V2(list);
        }
    }

    /* loaded from: classes9.dex */
    public class v0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52321a;

        public v0(PbFragment pbFragment) {
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
            this.f52321a = pbFragment;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f52321a.S0 != null && this.f52321a.S0.a() != null) {
                    this.f52321a.S0.a().sendAction(new b.a.q0.x.a(45, 27, null));
                }
                this.f52321a.E0.V();
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52322e;

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
            this.f52322e = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52322e.x0 == null) {
                return;
            }
            this.f52322e.x0.loadData();
        }
    }

    /* loaded from: classes9.dex */
    public class v2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52323e;

        public v2(PbFragment pbFragment) {
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
            this.f52323e = pbFragment;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f52323e.d1).showToast(b.a.r0.k2.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f52323e.d1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52324a;

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
            this.f52324a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f52324a.I1 = false;
                if (this.f52324a.J1 == null) {
                    return;
                }
                b.a.r0.k2.r.f P0 = this.f52324a.x0.P0();
                if (P0.O().L0().getIsLike() == 1) {
                    this.f52324a.g4(0);
                } else {
                    this.f52324a.g4(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, P0.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f52324a.I1 = false;
                if (this.f52324a.J1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i2, str)) {
                    AntiHelper.u(this.f52324a.getPageContext().getPageActivity(), str);
                } else {
                    this.f52324a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class w0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w0() {
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
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52325a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f52326e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ w1 f52327f;

            public a(w1 w1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52327f = w1Var;
                this.f52326e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.r0.k2.t.c.a(this.f52327f.f52325a.getPageContext(), this.f52326e).show();
                }
            }
        }

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
            this.f52325a = pbFragment;
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
                b.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w2(PbFragment pbFragment) {
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
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52328a;

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
            this.f52328a = pbFragment;
        }

        @Override // b.a.r0.k2.u.f.c1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f52328a.setNavigationBarShowFlag(z);
                if (this.f52328a.E0.B0() != null && z) {
                    this.f52328a.E0.x3(false);
                }
                this.f52328a.E0.Q1(z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x0 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52329a;

        public x0(PbFragment pbFragment) {
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
            this.f52329a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f52329a.E0.c0();
                boolean z = false;
                if (b.a.e.e.p.j.z()) {
                    if (this.f52329a.x0 != null && !this.f52329a.x0.isLoading) {
                        this.f52329a.stopVoice();
                        this.f52329a.E0.Q2();
                        z = true;
                        if (this.f52329a.x0.P0() != null && this.f52329a.x0.P0().f18762f != null && this.f52329a.x0.P0().f18762f.size() > i2) {
                            int intValue = this.f52329a.x0.P0().f18762f.get(i2).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f52329a.x0.g1()).param("fid", this.f52329a.x0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.f52329a.x0.v2(intValue)) {
                                this.f52329a.m = true;
                                this.f52329a.E0.E2(true);
                            }
                        }
                    }
                    return z;
                }
                this.f52329a.showToast(b.a.r0.k2.l.network_not_available);
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

    /* loaded from: classes9.dex */
    public class x1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f52330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f52331f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f52332g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52333h;

        public x1(PbFragment pbFragment, MarkData markData, MarkData markData2, b.a.q0.s.s.a aVar) {
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
            this.f52333h = pbFragment;
            this.f52330e = markData;
            this.f52331f = markData2;
            this.f52332g = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f52333h.z0 != null) {
                    if (this.f52333h.z0.e()) {
                        this.f52333h.z0.d();
                        this.f52333h.z0.h(false);
                    }
                    this.f52333h.z0.i(this.f52330e);
                    this.f52333h.z0.h(true);
                    this.f52333h.z0.a();
                }
                this.f52331f.setPostId(this.f52330e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f52331f);
                this.f52333h.f52221e.setResult(-1, intent);
                this.f52332g.dismiss();
                this.f52333h.Z3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x2(PbFragment pbFragment) {
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
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f52334e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f52335f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52336g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f52337h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52338i;

        public y(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
            this.f52338i = pbFragment;
            this.f52334e = sparseArray;
            this.f52335f = z;
            this.f52336g = str;
            this.f52337h = str2;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f52338i.I0 != null) {
                    this.f52338i.I0.dismiss();
                }
                if (i2 == 0) {
                    this.f52338i.E0.W1(((Integer) this.f52334e.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) this.f52334e.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) this.f52334e.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) this.f52334e.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f52334e.get(b.a.r0.k2.i.tag_user_mute_mute_username);
                    String str2 = (String) this.f52334e.get(b.a.r0.k2.i.tag_user_mute_thread_id);
                    String str3 = (String) this.f52334e.get(b.a.r0.k2.i.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f52335f, this.f52336g, str, str2, str3, 1, this.f52337h, this.f52338i.f1);
                    userMuteAddAndDelCustomMessage.setTag(this.f52338i.f1);
                    this.f52338i.V3(this.f52335f, userMuteAddAndDelCustomMessage, this.f52337h, str, (String) this.f52334e.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52341g;

        /* loaded from: classes9.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ y0 f52342e;

            public a(y0 y0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {y0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52342e = y0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.a.r0.k2.u.f.u0 u0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52342e.f52341g.mContentProcessController) == null || u0Var.g() == null) {
                    return;
                }
                if (!this.f52342e.f52341g.mContentProcessController.g().e()) {
                    this.f52342e.f52341g.mContentProcessController.b(false);
                }
                this.f52342e.f52341g.mContentProcessController.g().l(false);
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

        public y0(PbFragment pbFragment, String str, String str2) {
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
            this.f52341g = pbFragment;
            this.f52339e = str;
            this.f52340f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = b.a.e.e.p.l.i(this.f52341g.f52221e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = b.a.e.e.p.l.g(this.f52341g.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = b.a.e.e.p.l.g(this.f52341g.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                PbFragment pbFragment = this.f52341g;
                boolean z = true;
                pbFragment.getPbView().E0().smoothScrollBy((pbFragment.i0[1] + pbFragment.j0) - i4, 50);
                if (this.f52341g.getPbView().O0() != null) {
                    this.f52341g.S0.a().setVisibility(8);
                    this.f52341g.getPbView().O0().n(this.f52339e, this.f52340f, this.f52341g.getPbView().R0(), (this.f52341g.x0 == null || this.f52341g.x0.P0() == null || this.f52341g.x0.P0().O() == null || !this.f52341g.x0.P0().O().Q1()) ? false : false);
                    b.a.q0.x.x.h b2 = this.f52341g.getPbView().O0().b();
                    if (b2 != null && this.f52341g.x0 != null && this.f52341g.x0.P0() != null) {
                        b2.G(this.f52341g.x0.P0().d());
                        b2.b0(this.f52341g.x0.P0().O());
                    }
                    if (this.f52341g.mContentProcessController.f() == null && this.f52341g.getPbView().O0().b().t() != null) {
                        this.f52341g.getPbView().O0().b().t().f(new a(this));
                        PbFragment pbFragment2 = this.f52341g;
                        pbFragment2.mContentProcessController.n(pbFragment2.getPbView().O0().b().t().h());
                        this.f52341g.getPbView().O0().b().M(this.f52341g.a1);
                    }
                }
                this.f52341g.getPbView().c1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f52343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f52344f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52345g;

        public y1(PbFragment pbFragment, MarkData markData, b.a.q0.s.s.a aVar) {
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
            this.f52345g = pbFragment;
            this.f52343e = markData;
            this.f52344f = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f52343e);
                this.f52345g.f52221e.setResult(-1, intent);
                this.f52344f.dismiss();
                this.f52345g.Z3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f52346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52347f;

        public y2(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
            this.f52347f = pbFragment;
            this.f52346e = userMuteAddAndDelCustomMessage;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f52347f.E0.k3();
                MessageManager.getInstance().sendMessage(this.f52346e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52348a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PbFragment pbFragment, int i2) {
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
            this.f52348a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f45669c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.f52348a.getUniqueId() || AntiHelper.t(this.f52348a.getActivity(), updateAttentionMessage.getData().l, PbFragment.A2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f45667a) {
                    if (this.f52348a.getFirstPostData().t() != null && this.f52348a.getFirstPostData().t().getGodUserData() != null) {
                        this.f52348a.getFirstPostData().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.f52348a.x0 == null || this.f52348a.x0.P0() == null || this.f52348a.x0.P0().O() == null || this.f52348a.x0.P0().O().J() == null) {
                        return;
                    }
                    this.f52348a.x0.P0().O().J().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52349a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52350b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52351c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ z0 f52352e;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$z0$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1752a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f52353e;

                public C1752a(a aVar) {
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
                    this.f52353e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    b.a.r0.k2.u.f.u0 u0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52353e.f52352e.f52351c.mContentProcessController) == null || u0Var.g() == null) {
                        return;
                    }
                    if (!this.f52353e.f52352e.f52351c.mContentProcessController.g().e()) {
                        this.f52353e.f52352e.f52351c.mContentProcessController.b(false);
                    }
                    this.f52353e.f52352e.f52351c.mContentProcessController.g().l(false);
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

            public a(z0 z0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {z0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52352e = z0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = b.a.e.e.p.l.i(this.f52352e.f52351c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds410);
                    } else {
                        i2 = i3 / 2;
                        g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds410);
                    }
                    int i4 = i3 - (i2 + g2);
                    PbFragment pbFragment = this.f52352e.f52351c;
                    boolean z = true;
                    pbFragment.getPbView().E0().smoothScrollBy((pbFragment.i0[1] + pbFragment.j0) - i4, 50);
                    if (this.f52352e.f52351c.getPbView().O0() != null) {
                        this.f52352e.f52351c.S0.a().setVisibility(8);
                        z = (this.f52352e.f52351c.x0 == null || this.f52352e.f52351c.x0.P0() == null || this.f52352e.f52351c.x0.P0().O() == null || !this.f52352e.f52351c.x0.P0().O().Q1()) ? false : false;
                        b.a.r0.k2.u.f.t O0 = this.f52352e.f52351c.getPbView().O0();
                        z0 z0Var = this.f52352e;
                        O0.n(z0Var.f52349a, z0Var.f52350b, z0Var.f52351c.getPbView().R0(), z);
                        b.a.q0.x.x.h b2 = this.f52352e.f52351c.getPbView().O0().b();
                        if (b2 != null && this.f52352e.f52351c.x0 != null && this.f52352e.f52351c.x0.P0() != null) {
                            b2.G(this.f52352e.f52351c.x0.P0().d());
                            b2.b0(this.f52352e.f52351c.x0.P0().O());
                        }
                        if (this.f52352e.f52351c.mContentProcessController.f() == null && this.f52352e.f52351c.getPbView().O0().b().t() != null) {
                            this.f52352e.f52351c.getPbView().O0().b().t().f(new C1752a(this));
                            PbFragment pbFragment2 = this.f52352e.f52351c;
                            pbFragment2.mContentProcessController.n(pbFragment2.getPbView().O0().b().t().h());
                            this.f52352e.f52351c.getPbView().O0().b().M(this.f52352e.f52351c.a1);
                        }
                    }
                    this.f52352e.f52351c.getPbView().c1();
                }
            }
        }

        public z0(PbFragment pbFragment, String str, String str2) {
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
            this.f52351c = pbFragment;
            this.f52349a = str;
            this.f52350b = str2;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                b.a.e.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z1 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f52354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f52355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52356g;

        public z1(PbFragment pbFragment, MarkData markData, b.a.q0.s.s.a aVar) {
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
            this.f52356g = pbFragment;
            this.f52354e = markData;
            this.f52355f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f52356g.E0 != null && this.f52356g.E0.a1() != null) {
                    this.f52356g.E0.a1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.f52354e);
                    this.f52356g.f52221e.setResult(-1, intent);
                    this.f52355f.dismiss();
                    this.f52356g.Z3();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z2 implements c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f52357a;

        public z2(PbFragment pbFragment) {
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
            this.f52357a = pbFragment;
        }

        @Override // b.a.r0.k2.u.f.c0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f52357a.E0.A3(str);
        }

        @Override // b.a.r0.k2.u.f.c0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
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
        A2 = new w0();
        B2 = new t2();
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
        this.f52222f = true;
        this.f52223g = false;
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
        this.M = false;
        this.N = false;
        this.O = false;
        this.Q = "";
        this.R = true;
        this.S = false;
        this.T = "";
        this.b0 = 3;
        this.i0 = new int[2];
        this.k0 = -1;
        this.l0 = -1;
        this.sortSwitchId = BdUniqueId.gen();
        this.o0 = false;
        this.s0 = b.a.q0.b.d.m0();
        this.t0 = new p(this);
        this.v0 = new a0(this);
        this.w0 = new Handler(new l0(this));
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
        this.L0 = false;
        this.N0 = false;
        this.P0 = false;
        this.mKeyboardIsVisible = false;
        this.Y0 = new h1(this);
        this.Z0 = new s1(this);
        this.a1 = new d2(this);
        this.b1 = 0;
        this.l1 = false;
        this.m1 = 0;
        this.n1 = -1;
        this.bjhFrom = 0;
        this.q1 = new o2(this);
        this.r1 = new z2(this);
        this.s1 = new f(this, 2004016);
        this.t1 = new g(this, 2016485);
        this.u1 = new h(this, 2001269);
        this.v1 = new i(this, 2004008);
        this.w1 = new j(this, 2004007);
        this.x1 = new k(this, 2004005);
        this.y1 = new l(this, 2001332);
        this.z1 = new m(this, 2921391);
        this.A1 = new n(this, 2921606);
        this.B1 = new o(this);
        this.C1 = new q(this, 2001369);
        this.D1 = new r(this, 2016488);
        this.E1 = new s(this, 2016331);
        this.F1 = new t(this);
        this.G1 = new u(this, 2921509);
        this.H1 = new v(this);
        this.J1 = new PraiseModel(getPageContext(), new w(this));
        this.K1 = new x(this);
        this.L1 = new z(this, 2001115);
        this.M1 = new b0(this);
        this.N1 = new e0(this);
        this.O1 = new b.a.r0.k2.s.c(new h0(this));
        this.P1 = new j0(this, 2001427);
        this.Q1 = new k0(this, 2001428);
        this.R1 = new m0(this, 2921634);
        this.S1 = new n0(this, 2001426);
        this.mFirstFloorPraiseListener = new o0(this, 2004021);
        this.T1 = new p0(this, 2016528);
        this.U1 = new q0(this, 2921033);
        this.mDialogClickListener = new r0(this);
        this.V1 = new s0(this);
        this.onSwitchChangeListener = new x0(this);
        this.mCommonOnClickListener = new a1(this);
        this.W1 = new b1(this, 2921480);
        this.X1 = new c1(this);
        this.mOnFloorPostWriteNewCallback = new d1(this);
        this.Y1 = new e1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.Z1 = new f1(this);
        this.a2 = new g1(this, 2016450);
        this.b2 = new i1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.c2 = new j1(this);
        this.d2 = new m1(this);
        this.e2 = new p1(this);
        this.f2 = new r1(this);
        this.g2 = new t1(this);
        this.i2 = new u1(this);
        this.j2 = 0;
        this.k2 = new h2(this);
        this.l2 = false;
        this.m2 = null;
        this.n2 = new i2(this);
        this.o2 = new j2(this);
        this.p2 = new k2(this);
        this.q2 = new l2(this);
        this.r2 = new m2(this);
        this.s2 = new n2(this);
        this.t2 = new p2(this);
        this.mOnTouchListener = new r2(this);
        this.u2 = new s2(this);
        this.v2 = new u2(this);
        this.w2 = -1;
        this.x2 = -1;
    }

    public static PbFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65665, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final void A2() {
        PbModel pbModel;
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pbModel = this.x0) == null || (fVar = pbModel.J) == null || fVar.O() == null) {
            return;
        }
        b.a.q0.s.q.d2 O = this.x0.J.O();
        O.Z0 = this.x0.U0();
        O.Y0 = this.x0.X0();
        O.X0 = this.x0.W0();
        O.a1 = this.x0.V0();
        O.H2 = this.x0.D0();
        if (O.T() == 0) {
            O.E3(b.a.e.e.m.b.g(this.x0.getForumId(), 0L));
        }
        StatisticItem i3 = b.a.q0.n0.c.i(getContext(), O, "c13562");
        TbPageTag l3 = b.a.q0.n0.c.l(getContext());
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

    public final void A3(boolean z3, PostData postData) {
        b.a.q0.t.c.d adAdSense;
        b.a.r0.k2.u.f.s0 s0Var;
        b.a.r0.k2.u.f.h n02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g() || (s0Var = this.E0) == null || (n02 = s0Var.n0()) == null || (E = n02.E()) == null) {
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
                    cVar.f20680b = G;
                    cVar.f20681c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.G == 1 && !TextUtils.isEmpty(G)) {
                next.G = 2;
                a.c cVar2 = new a.c();
                cVar2.f20680b = G;
                cVar2.f20681c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P0() == null || this.x0.P0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.x0.P0().l().getFirst_class();
                str2 = this.x0.P0().l().getSecond_class();
                str3 = this.x0.P0().l().getId();
                str4 = this.x0.f1();
                str = first_class;
            }
            b.a.r0.z2.z.v(z3, str, str2, str3, str4, arrayList, adAdSense.i());
        }
    }

    public final void B2(boolean z3) {
        PbModel pbModel;
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z3) == null) || (pbModel = this.x0) == null || (fVar = pbModel.J) == null || fVar.O() == null) {
            return;
        }
        b.a.q0.s.q.d2 O = this.x0.J.O();
        O.Z0 = this.x0.U0();
        O.Y0 = this.x0.X0();
        O.X0 = this.x0.W0();
        O.a1 = this.x0.V0();
        if (O.T() == 0) {
            O.E3(b.a.e.e.m.b.g(this.x0.getForumId(), 0L));
        }
        StatisticItem i3 = b.a.q0.n0.c.i(getContext(), O, "c13563");
        TbPageTag l3 = b.a.q0.n0.c.l(getContext());
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
            b.a.q0.m0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public final void B3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pbModel = this.x0) == null || pbModel.P0() == null || this.x0.P0().O() == null || !this.x0.P0().O().E2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final void C2(b.a.r0.k2.r.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, fVar, arrayList) == null) || fVar == null || fVar.T() == null || fVar.T().f18820a == null || (list = fVar.T().f18820a) == null || arrayList == null) {
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

    public final void C3(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i3) == null) || this.x0 == null) {
            return;
        }
        R3();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.x0.f52416f);
        sendMessage(privacySettingMessage);
    }

    public final boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.x0.P0().O()) || AntiHelper.d(getPageContext(), this.x0.P0().d());
        }
        return invokeV.booleanValue;
    }

    public final void D3(b.a.q0.x.x.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || gVar == null || (pbModel = this.x0) == null) {
            return;
        }
        gVar.p(pbModel.q0());
        if (this.x0.P0() != null && this.x0.P0().l() != null) {
            gVar.o(this.x0.P0().l());
        }
        gVar.q("pb");
        gVar.r(this.x0);
    }

    public final boolean E2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void E3(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i3) == null) || (pbModel = this.x0) == null) {
            return;
        }
        int Y0 = pbModel.Y0();
        if (i3 == 5) {
            this.x0.m2(2);
        } else if (i3 == 6) {
            this.x0.m2(3);
        } else if (i3 != 7) {
            this.x0.m2(1);
        } else {
            this.x0.m2(4);
        }
        int Y02 = this.x0.Y0();
        if (Y0 == 4 || Y02 == 4) {
            t3();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F2(AgreeData agreeData) {
        b.a.q0.m0.c k3;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.n0 == null) {
            this.n0 = new b.a.q0.s.c0.a();
        }
        if (this.r0 == null) {
            b.a.r0.l3.j0.e eVar = new b.a.r0.l3.j0.e();
            this.r0 = eVar;
            eVar.f20601a = getUniqueId();
        }
        b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
        fVar.f13300b = 5;
        fVar.f13306h = 8;
        fVar.f13305g = 2;
        if (getPbModel() != null) {
            fVar.f13304f = getPbModel().O0();
        }
        fVar.f13299a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f13307i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.n0.c(agreeData, i3, getUniqueId(), false);
                this.n0.d(agreeData, this.r0);
                pbModel = this.x0;
                if (pbModel != null || pbModel.P0() == null) {
                }
                this.n0.b(getPbActivity(), fVar, agreeData, this.x0.P0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f13307i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f13307i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.n0.c(agreeData, i3, getUniqueId(), false);
        this.n0.d(agreeData, this.r0);
        pbModel = this.x0;
        if (pbModel != null) {
        }
    }

    public final void F3(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z3) == null) {
            this.S0.g0(z3);
            this.S0.j0(z3);
            this.S0.q0(z3);
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.x0.v0() || this.x0.y0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.x0.f1());
                this.f52221e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.x0.f1()));
            if (a4()) {
                this.f52221e.finish();
            }
        }
    }

    public final void G3(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new o1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                U3(str);
            } else {
                this.E0.A3(str);
            }
        }
    }

    public final boolean H2(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<b.a.q0.s.s.f> b4;
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        b.a.q0.s.s.f fVar3;
        b.a.q0.s.s.f fVar4;
        b.a.e.l.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                b.a.r0.k2.u.f.s0 s0Var = this.E0;
                if (s0Var != null) {
                    if (s0Var.x1()) {
                        return true;
                    }
                    this.E0.l0();
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e3) {
                    e3.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (isImage(view)) {
                        if (view instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view;
                            this.i1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.j1 = url;
                            if (this.i1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) != null && (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.k1 = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                            } else {
                                this.k1 = null;
                            }
                        } else if (view instanceof GifView) {
                            GifView gifView = (GifView) view;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.i1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.j1 = gifView.getBdImage().q();
                            }
                            if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) != null && (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.k1 = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                            } else {
                                this.k1 = null;
                            }
                        } else if (view instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.i1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.j1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) != null && (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.k1 = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                                } else {
                                    this.k1 = null;
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
                            this.E0.p3(this.o2, this.i1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
                this.m2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && isImage(view)) {
                    this.E0.p3(this.o2, this.i1.t());
                    return true;
                }
                b.a.q0.i.a aVar2 = this.z0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z6 = aVar2.e() && this.m2.G() != null && this.m2.G().equals(this.x0.K0());
                boolean z7 = getPbModel().P0() != null && getPbModel().P0().g0();
                boolean z8 = getPbModel().P0() != null && getPbModel().P0().j0();
                if (this.m2.A() == 1) {
                    if (!z7) {
                        this.E0.q3(this.n2, z6, false, z8);
                    }
                    return true;
                }
                if (this.J0 == null) {
                    b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(getContext());
                    this.J0 = iVar;
                    iVar.m(this.V1);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z9 = isImage(view) && !z7;
                boolean z10 = (!isImage(view) || (aVar = this.i1) == null || aVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_subpb)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
                String str = sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) : null;
                boolean booleanValue7 = sparseArray.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
                if (z9) {
                    z3 = booleanValue7;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new b.a.q0.s.s.f(1, getString(b.a.r0.k2.l.save_to_emotion), this.J0));
                } else {
                    z3 = booleanValue7;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z10) {
                    arrayList.add(new b.a.q0.s.s.f(2, getString(b.a.r0.k2.l.save_to_local), this.J0));
                }
                if (!z9 && !z10) {
                    b.a.q0.s.s.f fVar5 = new b.a.q0.s.s.f(3, getString(b.a.r0.k2.l.copy), this.J0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(b.a.r0.k2.i.tag_clip_board, this.m2);
                    fVar5.f13556d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        fVar4 = new b.a.q0.s.s.f(4, getString(b.a.r0.k2.l.remove_mark), this.J0);
                    } else {
                        fVar4 = new b.a.q0.s.s.f(4, getString(b.a.r0.k2.l.mark), this.J0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(b.a.r0.k2.i.tag_clip_board, this.m2);
                    sparseArray4.put(b.a.r0.k2.i.tag_is_subpb, Boolean.FALSE);
                    fVar4.f13556d.setTag(sparseArray4);
                    arrayList.add(fVar4);
                }
                if (this.mIsLogin && !this.s0) {
                    if (!b.a.r0.k2.u.f.f1.a.h(this.x0) && !booleanValue4 && booleanValue3) {
                        b.a.q0.s.s.f fVar6 = new b.a.q0.s.s.f(5, getString(b.a.r0.k2.l.mute_option), this.J0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i3 = b.a.r0.k2.i.tag_is_mem;
                        sparseArray5.put(i3, sparseArray.get(i3));
                        int i4 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                        sparseArray5.put(i4, sparseArray.get(i4));
                        int i5 = b.a.r0.k2.i.tag_user_mute_mute_username;
                        sparseArray5.put(i5, sparseArray.get(i5));
                        int i6 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                        sparseArray5.put(i6, sparseArray.get(i6));
                        int i7 = b.a.r0.k2.i.tag_user_mute_post_id;
                        sparseArray5.put(i7, sparseArray.get(i7));
                        int i8 = b.a.r0.k2.i.tag_user_mute_thread_id;
                        sparseArray5.put(i8, sparseArray.get(i8));
                        int i9 = b.a.r0.k2.i.tag_del_post_is_self;
                        sparseArray5.put(i9, sparseArray.get(i9));
                        int i10 = b.a.r0.k2.i.tag_del_post_type;
                        sparseArray5.put(i10, sparseArray.get(i10));
                        int i11 = b.a.r0.k2.i.tag_del_post_id;
                        sparseArray5.put(i11, sparseArray.get(i11));
                        int i12 = b.a.r0.k2.i.tag_manage_user_identity;
                        sparseArray5.put(i12, sparseArray.get(i12));
                        fVar6.f13556d.setTag(sparseArray5);
                        arrayList.add(fVar6);
                    } else {
                        if ((j3(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            b.a.q0.s.s.f fVar7 = new b.a.q0.s.s.f(5, getString(b.a.r0.k2.l.report_text), this.J0);
                            fVar7.f13556d.setTag(str);
                            arrayList.add(fVar7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                        int i13 = b.a.r0.k2.i.tag_manage_user_identity;
                        sparseArray6.put(i13, sparseArray.get(i13));
                        int i14 = b.a.r0.k2.i.tag_forbid_user_name;
                        sparseArray6.put(i14, sparseArray.get(i14));
                        int i15 = b.a.r0.k2.i.tag_forbid_user_name_show;
                        sparseArray6.put(i15, sparseArray.get(i15));
                        int i16 = b.a.r0.k2.i.tag_forbid_user_portrait;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        sparseArray6.put(b.a.r0.k2.i.tag_forbid_user_post_id, str);
                        if (!b.a.r0.k2.u.f.f1.a.h(this.x0) && z4) {
                            sparseArray6.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                            int i17 = b.a.r0.k2.i.tag_is_mem;
                            sparseArray6.put(i17, sparseArray.get(i17));
                            int i18 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                            sparseArray6.put(i18, sparseArray.get(i18));
                            int i19 = b.a.r0.k2.i.tag_user_mute_mute_username;
                            sparseArray6.put(i19, sparseArray.get(i19));
                            int i20 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                            sparseArray6.put(i20, sparseArray.get(i20));
                            int i21 = b.a.r0.k2.i.tag_user_mute_post_id;
                            sparseArray6.put(i21, sparseArray.get(i21));
                            int i22 = b.a.r0.k2.i.tag_user_mute_thread_id;
                            sparseArray6.put(i22, sparseArray.get(i22));
                        } else {
                            sparseArray6.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray6.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                            int i23 = b.a.r0.k2.i.tag_del_post_id;
                            sparseArray6.put(i23, sparseArray.get(i23));
                            int i24 = b.a.r0.k2.i.tag_del_post_type;
                            sparseArray6.put(i24, sparseArray.get(i24));
                            int i25 = b.a.r0.k2.i.tag_has_sub_post;
                            sparseArray6.put(i25, sparseArray.get(i25));
                            sparseArray6.put(b.a.r0.k2.i.tag_is_self_post, Boolean.valueOf(z3));
                            if (z3) {
                                b.a.q0.s.s.f fVar8 = new b.a.q0.s.s.f(6, getString(b.a.r0.k2.l.delete), this.J0);
                                fVar8.f13556d.setTag(sparseArray6);
                                fVar2 = fVar8;
                                fVar = new b.a.q0.s.s.f(7, getString(b.a.r0.k2.l.bar_manager), this.J0);
                                fVar.f13556d.setTag(sparseArray6);
                            }
                        } else {
                            sparseArray6.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
                        }
                        fVar2 = null;
                        fVar = new b.a.q0.s.s.f(7, getString(b.a.r0.k2.l.bar_manager), this.J0);
                        fVar.f13556d.setTag(sparseArray6);
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                        sparseArray7.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                        sparseArray7.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                        int i26 = b.a.r0.k2.i.tag_manage_user_identity;
                        sparseArray7.put(i26, sparseArray.get(i26));
                        sparseArray7.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i27 = b.a.r0.k2.i.tag_del_post_id;
                        sparseArray7.put(i27, sparseArray.get(i27));
                        int i28 = b.a.r0.k2.i.tag_del_post_type;
                        sparseArray7.put(i28, sparseArray.get(i28));
                        int i29 = b.a.r0.k2.i.tag_has_sub_post;
                        sparseArray7.put(i29, sparseArray.get(i29));
                        if (this.x0.P0().V() == 1002 && !booleanValue2) {
                            fVar3 = new b.a.q0.s.s.f(6, getString(b.a.r0.k2.l.report_text), this.J0);
                        } else {
                            fVar3 = new b.a.q0.s.s.f(6, getString(b.a.r0.k2.l.delete), this.J0);
                        }
                        fVar3.f13556d.setTag(sparseArray7);
                        fVar2 = fVar3;
                        fVar = null;
                    } else {
                        fVar = null;
                        fVar2 = null;
                    }
                    if (fVar2 != null) {
                        arrayList.add(fVar2);
                    }
                    if (fVar != null) {
                        arrayList.add(fVar);
                    }
                    b.a.r0.k2.u.f.f1.a.a(arrayList, this.J0, this.m2, this.x0);
                }
                if (b.a.q0.b.d.F()) {
                    b4 = b.a.r0.k2.u.f.f1.a.c(arrayList, this.m2.q(), sparseArray, this.J0);
                } else {
                    b4 = b.a.r0.k2.u.f.f1.a.b(arrayList, this.m2.q(), sparseArray, this.J0);
                }
                b.a.r0.k2.u.f.f1.a.k(b4, this.f52222f);
                b.a.r0.k2.u.f.f1.a.e(b4);
                this.J0.n(b.a.r0.k2.u.f.f1.a.f(this.m2));
                if (b.a.q0.b.d.F()) {
                    this.J0.k(b4, false);
                } else {
                    this.J0.k(b4, true);
                }
                PopupDialog popupDialog = new PopupDialog(getPageContext(), this.J0);
                this.I0 = popupDialog;
                popupDialog.showDialog();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.x0.f52416f).param("fid", this.x0.getForumId()).param("uid", this.x0.P0().O().J().getUserId()).param("post_id", this.x0.y()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H3(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (getPbView() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    b.a.q0.t.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    b.a.r0.l3.s0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.x0.D0()) {
            antiData.setBlock_forum_name(this.x0.P0().l().getName());
            antiData.setBlock_forum_id(this.x0.P0().l().getId());
            antiData.setUser_name(this.x0.P0().U().getUserName());
            antiData.setUser_id(this.x0.P0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void I2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.r0.l3.j0.p z3 = this.x0.P0().z();
        if (z3 != null && str.equals(z3.J0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().f4 = null;
            }
            this.x0.P0().b();
        }
        b.a.r0.l3.j0.p k02 = this.x0.k0();
        if (k02 == null || !str.equals(k02.J0())) {
            return;
        }
        this.x0.W();
    }

    public final void I3(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            b.a.r0.k2.u.f.f1.b.l(this, j3, str, j4);
        }
    }

    public final void J2(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (pbModel = this.x0) == null || pbModel.P0() == null || this.x0.P0().O() == null || !this.x0.P0().O().D2()) {
            return;
        }
        b.a.q0.s.q.d2 O = this.x0.P0().O();
        int i3 = 0;
        if (O.M1()) {
            i3 = 1;
        } else if (O.P1()) {
            i3 = 2;
        } else if (O.N1()) {
            i3 = 3;
        } else if (O.O1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final void J3(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            b.a.r0.k2.u.f.f1.a.d(getActivity(), getPageContext(), new t0(this, sparseArray, i3, z3), new u0(this));
        }
    }

    public final void K2(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048596, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f54249b) ? bVar.f54249b : getString(b.a.r0.k2.l.delete_fail);
            int i3 = 0;
            if (bVar.f54250c == 1211066) {
                hideProgressBar();
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(b.a.r0.k2.l.dialog_known, new q1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else if (bVar.f54251d != 0) {
                this.E0.k0(0, bVar.f54248a, bVar.f54249b, z3);
            }
            if (bVar.f54248a) {
                int i4 = bVar.f54251d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.x0.P0().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f54254g.equals(F.get(i3).G())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.x0.P0().O().n4(this.x0.P0().O().U0() - 1);
                    this.E0.t1(this.x0.P0());
                } else if (i4 == 0) {
                    G2();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.x0.P0().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).O().size()) {
                                break;
                            } else if (bVar.f54254g.equals(F2.get(i5).O().get(i6).G())) {
                                F2.get(i5).O().remove(i6);
                                F2.get(i5).l();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).n(bVar.f54254g);
                    }
                    if (z4) {
                        this.E0.t1(this.x0.P0());
                    }
                    delGodReplyFloor(bVar, this.E0);
                }
            }
        }
    }

    public final boolean K3(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        b.a.q0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            b.a.r0.k2.r.f P0 = this.x0.P0();
            b.a.q0.s.q.d2 O = P0.O();
            if (O != null) {
                if (O.M1() || O.P1()) {
                    return false;
                }
                if (O.N1() || O.O1()) {
                    return z3;
                }
            }
            if (z3) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !b.a.r0.x0.v0.isOn()) || this.x0.E() || O.I2() || O.s2() || z4) {
                return false;
            }
            if (P0.l() == null || !P0.l().isBlockBawuDelete) {
                if (P0.O() == null || !P0.O().S1()) {
                    if (P0.V() != 0) {
                        return P0.V() != 3;
                    }
                    List<b.a.q0.s.q.z1> p3 = P0.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (b.a.q0.s.q.z1 z1Var : p3) {
                            if (z1Var != null && (e0Var = z1Var.f13511g) != null && e0Var.f13285a && !e0Var.f13287c && ((i3 = e0Var.f13286b) == 1 || i3 == 2)) {
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

    public final void L2(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048598, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.E0.k0(this.A0.getLoadDataMode(), gVar.f54270a, gVar.f54271b, false);
        if (gVar.f54270a) {
            this.F0 = true;
            if (i3 == 2 || i3 == 3) {
                this.G0 = true;
                this.H0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.G0 = false;
                this.H0 = true;
            }
            if (i3 == 2) {
                this.x0.P0().O().X3(1);
                this.x0.f2(1);
            } else if (i3 == 3) {
                this.x0.P0().O().X3(0);
                this.x0.f2(0);
            } else if (i3 == 4) {
                this.x0.P0().O().Y3(1);
                this.x0.g2(1);
            } else if (i3 == 5) {
                this.x0.P0().O().Y3(0);
                this.x0.g2(0);
            }
            this.E0.I3(this.x0.P0(), this.x0.d1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f54271b)) {
            string = gVar.f54271b;
        } else {
            string = getString(b.a.r0.k2.l.operation_failed);
        }
        b.a.e.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public final boolean L3(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z3)) == null) {
            if (z3 || (pbModel = this.x0) == null || pbModel.P0() == null || (this.x0.P0().l() != null && this.x0.P0().l().isBlockBawuDelete)) {
                return false;
            }
            b.a.r0.k2.r.f P0 = this.x0.P0();
            if ((P0.O() == null || P0.O().J() == null || !P0.O().J().isForumBusinessAccount() || b.a.r0.x0.v0.isOn()) && !this.x0.E()) {
                return ((P0.O() != null && P0.O().S1()) || this.x0.P0().V() == 0 || this.x0.P0().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void M2(Rect rect) {
        b.a.r0.k2.u.f.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, rect) == null) || rect == null || (s0Var = this.E0) == null || s0Var.Y0() == null || rect.top > this.E0.Y0().getHeight()) {
            return;
        }
        rect.top += this.E0.Y0().getHeight() - rect.top;
    }

    public final boolean M3(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || isManagerCanBlockThread(i3));
        }
        return invokeCommon.booleanValue;
    }

    public final int N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.x0.P0() == null || this.x0.P0().O() == null) {
                return -1;
            }
            return this.x0.P0().O().w();
        }
        return invokeV.intValue;
    }

    public final boolean N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.d1()) {
                return this.x0.N0() == null || this.x0.N0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String O2() {
        InterceptResult invokeV;
        b.a.r0.k2.r.f P0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || (P0 = pbModel.P0()) == null) {
                return null;
            }
            return P0.T().f18822c;
        }
        return (String) invokeV.objValue;
    }

    public final void O3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, metaData) == null) || metaData == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getActivity());
        aVar.setTitle(getResources().getString(b.a.r0.k2.l.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(b.a.r0.k2.l.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(b.a.r0.k2.l.mark_like_cancel), new k1(this, metaData));
        aVar.setPositiveButton(getResources().getString(b.a.r0.k2.l.mark_like_confirm), new l1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final String P2() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P0() == null || this.x0.P0().F() == null || (count = ListUtils.getCount((F = this.x0.P0().F()))) == 0) {
                return "";
            }
            if (this.x0.a1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.G();
                    }
                }
            }
            int u02 = this.E0.u0();
            PostData postData = (PostData) ListUtils.getItem(F, u02);
            if (postData != null && postData.t() != null) {
                if (this.x0.z1(postData.t().getUserId())) {
                    return postData.G();
                }
                for (int i3 = u02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (this.x0.z1(postData2.t().getUserId())) {
                        return postData2.G();
                    }
                }
                for (int i4 = u02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (this.x0.z1(postData3.t().getUserId())) {
                        return postData3.G();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(b.a.r0.k2.l.mute_is_super_member_function));
            aVar.setPositiveButton(b.a.r0.k2.l.open_now, new v2(this));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new w2(this));
            aVar.create(this.d1).show();
        }
    }

    public final TbRichText Q2(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048608, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText M = arrayList.get(i4).M();
                    if (M != null && (y3 = M.y()) != null) {
                        int size = y3.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (y3.get(i6) != null && y3.get(i6).getType() == 8) {
                                i5++;
                                if (y3.get(i6).C().y().equals(str) || y3.get(i6).C().z().equals(str)) {
                                    int h3 = (int) b.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                                    int width = y3.get(i6).C().getWidth() * h3;
                                    int height = y3.get(i6).C().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.j2 = i6;
                                    return M;
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

    public final void Q3(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048609, this, z3, sparseArray) == null) && (sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.I0;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.I0.dismiss();
                this.I0 = null;
            }
            String str = (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(getContext());
                iVar.m(new y(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new b.a.q0.s.s.f(0, getResources().getString(b.a.r0.k2.l.delete), iVar));
                }
                if (z3) {
                    arrayList.add(new b.a.q0.s.s.f(1, getResources().getString(b.a.r0.k2.l.un_mute), iVar));
                } else {
                    arrayList.add(new b.a.q0.s.s.f(1, getResources().getString(b.a.r0.k2.l.mute), iVar));
                }
                iVar.j(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(getPageContext(), iVar);
                this.I0 = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public final int R2(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.l2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.y().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.y().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) b.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.C().getWidth() * h3;
                        int height = tbRichTextData.C().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.C().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = b.a.r0.k2.r.g.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                    String y3 = C.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y3 = C.z();
                                    } else {
                                        imageUrlData.urlType = this.w ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y3;
                                    imageUrlData.originalUrl = U2(tbRichTextData);
                                    imageUrlData.originalSize = V2(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = T2(tbRichTextData);
                                    imageUrlData.isLongPic = S2(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = b.a.e.e.m.b.g(this.x0.f1(), -1L);
                                    imageUrlData.mIsReserver = this.x0.a1();
                                    imageUrlData.mIsSeeHost = this.x0.t0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.l2) {
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

    public final void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            showLoadingView(this.E0.a1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.k2.g.ds400));
            View i3 = getLoadingView().i();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
            layoutParams.addRule(3, this.E0.Y0().getId());
            i3.setLayoutParams(layoutParams);
        }
    }

    public final boolean S2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().E();
        }
        return invokeL.booleanValue;
    }

    public final void S3(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && getPbModel() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                getPbModel().Y(postWriteCallBackData.getPostId());
                int r02 = this.E0.r0();
                this.m1 = r02;
                this.x0.b2(r02, this.E0.y0());
            }
            this.E0.c0();
            this.mContentProcessController.c();
            b.a.q0.x.x.e eVar = this.S0;
            if (eVar != null) {
                this.E0.v2(eVar.D());
            }
            this.E0.e1();
            this.E0.c3(true);
            this.x0.o1();
        }
    }

    public final boolean T2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return false;
            }
            return tbRichTextData.C().F();
        }
        return invokeL.booleanValue;
    }

    public final void T3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i3) == null) {
            b.a.r0.k2.u.f.f1.b.o(this, N2(), i3);
        }
    }

    public final String U2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return null;
            }
            return tbRichTextData.C().A();
        }
        return (String) invokeL.objValue;
    }

    public final void U3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (str == null) {
                str = "";
            }
            b.a.e.a.f fVar = this.d1;
            if (fVar == null) {
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(b.a.r0.k2.l.know, new x2(this));
            aVar.create(this.d1).show();
        }
    }

    public final long V2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.C() == null) {
                return 0L;
            }
            return tbRichTextData.C().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void V3(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.E0.k3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.d1.getPageActivity());
            if (b.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.d1.getResources().getString(b.a.r0.k2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(b.a.r0.k2.l.confirm, new y2(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new a(this));
            aVar.create(this.d1).show();
        }
    }

    public final int W2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i3)) == null) {
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

    public final void W3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (pbModel = this.x0) == null || b.a.e.e.p.k.isEmpty(pbModel.f1())) {
            return;
        }
        b.a.q0.a.d.y().P(b.a.q0.a.c.W, b.a.e.e.m.b.g(this.x0.f1(), 0L));
    }

    public final int X2(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().o1() == 0) {
                return 1;
            }
            if (fVar.O().o1() == 54) {
                return 2;
            }
            return fVar.O().o1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void X3(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(b.a.r0.k2.i.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) != null) {
            Y3(postData, false);
        }
    }

    public final void Y2(int i3, Intent intent) {
        b.a.q0.x.n nVar;
        b.a.q0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i3, intent) == null) {
            if (i3 == 0) {
                this.E0.e1();
                this.E0.O0().c();
                this.E0.c3(false);
            }
            this.E0.o2();
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
                    if (editorType != 1 || this.E0.O0() == null || this.E0.O0().b() == null) {
                        return;
                    }
                    b.a.q0.x.x.h b4 = this.E0.O0().b();
                    b4.b0(this.x0.P0().O());
                    b4.B(writeData);
                    b4.c0(pbEditorData.getVoiceModel());
                    b.a.q0.x.m findToolById = b4.a().findToolById(6);
                    if (findToolById != null && (nVar2 = findToolById.k) != null) {
                        nVar2.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.S0.T();
                this.S0.u0(pbEditorData.getVoiceModel());
                this.S0.H(writeData);
                b.a.q0.x.m findToolById2 = this.S0.a().findToolById(6);
                if (findToolById2 != null && (nVar = findToolById2.k) != null) {
                    nVar.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.S0.M(null, null);
                }
            }
        }
    }

    public final void Y3(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048625, this, postData, z3) == null) || postData == null || (pbModel = this.x0) == null || pbModel.P0() == null || postData.A() == 1) {
            return;
        }
        String f12 = this.x0.f1();
        String G = postData.G();
        int V = this.x0.P0() != null ? this.x0.P0().V() : 0;
        AbsPbActivity.e v3 = v3(G);
        if (v3 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(f12, G, "pb", true, false, null, false, null, V, postData.R(), this.x0.P0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(v3.f52184a, v3.f52185b, v3.f52190g, v3.j);
        addBigImageData.setKeyPageStartFrom(this.x0.O0());
        addBigImageData.setFromFrsForumId(this.x0.getFromForumId());
        addBigImageData.setWorksInfoData(this.x0.k1());
        addBigImageData.setKeyFromForumId(this.x0.getForumId());
        addBigImageData.setBjhData(this.x0.j0());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final void Z2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P0() != null && this.x0.P0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.x0.f1(), str);
                b.a.q0.s.q.d2 O = this.x0.P0().O();
                if (O.M1()) {
                    format = format + "&channelid=33833";
                } else if (O.R1()) {
                    format = format + "&channelid=33842";
                } else if (O.P1()) {
                    format = format + "&channelid=33840";
                }
                k3(format);
                return;
            }
            this.y0.a(str);
        }
    }

    public final void Z3() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absPbActivity = this.f52221e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void a3(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            b.a.r0.k2.u.f.f1.b.j(this, intent);
        }
    }

    public final boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.P0() == null || !this.x0.P0().g0()) {
                if (this.x0.B0()) {
                    MarkData n02 = this.x0.n0();
                    if (n02 != null && this.x0.z0()) {
                        MarkData h02 = this.x0.h0(this.E0.u0());
                        if (h02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", n02);
                            this.f52221e.setResult(-1, intent);
                            return true;
                        } else if (h02.getPostId() != null && !h02.getPostId().equals(n02.getPostId())) {
                            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(b.a.r0.k2.l.alert_update_mark));
                            aVar.setPositiveButton(b.a.r0.k2.l.confirm, new x1(this, h02, n02, aVar));
                            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new y1(this, n02, aVar));
                            aVar.setOnCalcelListener(new z1(this, n02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", n02);
                            this.f52221e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.x0.P0() != null && this.x0.P0().F() != null && this.x0.P0().F().size() > 0 && this.x0.z0()) {
                    this.f52221e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void addBackInterceptor(a3 a3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, a3Var) == null) || a3Var == null) {
            return;
        }
        if (this.o1 == null) {
            this.o1 = new ArrayList();
        }
        if (this.o1.contains(a3Var)) {
            return;
        }
        this.o1.add(a3Var);
    }

    public void addBackInterceptorAtFirst(a3 a3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, a3Var) == null) || a3Var == null) {
            return;
        }
        if (this.o1 == null) {
            this.o1 = new ArrayList();
        }
        if (this.o1.contains(a3Var)) {
            return;
        }
        this.o1.add(0, a3Var);
    }

    public final void b3(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048632, this, i3, i4) == null) {
            b.a.q0.d1.l0.b(new d(this, i4), new e(this, i4, i3));
        }
    }

    public final void b4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (absPbActivity = this.f52221e) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f52221e.getPbModel().f1()).param("topic_id", this.f52221e.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.f52221e.getPbModel().j1()));
    }

    public final void c3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i3) == null) {
            b.a.q0.d1.l0.b(new b(this), new c(this, i3));
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

    public final void c4(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048635, this, z3) == null) || (absPbActivity = this.f52221e) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f52221e.getPbModel().f1()).param("topic_id", this.f52221e.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.f52221e.getPbModel().j1()));
    }

    public void checkEasterEgg(boolean z3) {
        b.a.r0.k2.u.f.s0 s0Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z3) == null) || (s0Var = this.E0) == null || s0Var.E0() == null) {
            return;
        }
        int firstVisiblePosition = this.E0.E0().getFirstVisiblePosition();
        int lastVisiblePosition = this.E0.E0().getLastVisiblePosition();
        b.a.r0.k2.u.f.h n02 = this.E0.n0();
        if (n02 == null || this.x0.P0() == null) {
            return;
        }
        if (lastVisiblePosition <= n02.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > n02.w() ? firstVisiblePosition - n02.w() : 0;
            w4 = (lastVisiblePosition - n02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.E0.E0().getItem(w3) != null && (this.E0.E0().getItem(w3) instanceof PostData) && (postData = (PostData) this.E0.E0().getItem(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.x0.P0().F(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.j0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().p(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                w3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new n1(this));
            b.a.q0.u.a aVar = (b.a.q0.u.a) ListUtils.getItem(arrayList, 0);
            if (aVar == null || aVar.e() != 1) {
                this.E0.c2(aVar, 1);
            } else if (z3) {
            } else {
                this.E0.c2(aVar, 0);
            }
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.E0.k3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = b.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = b.a.e.e.m.b.g((String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.c1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if ((this.x0.P0() != null && (this.x0.P0().g0() || ThreadCardUtils.isSelf(this.x0.P0().O()))) || this.mReplyPrivacyController == null || this.x0.P0() == null || this.x0.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.x0.P0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i3)) == null) {
            if (this.mReplyPrivacyController == null || this.x0.P0() == null || ThreadCardUtils.isSelf(this.x0.P0().O()) || this.x0.P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.x0.P0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void d3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            b.a.q0.i.a c4 = b.a.q0.i.a.c(this.f52221e);
            this.z0 = c4;
            if (c4 != null) {
                c4.j(this.c2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f52221e);
            this.A0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.e2);
            this.B0 = new b.a.q0.t.e.a(getPageContext());
            this.J1.setUniqueId(getUniqueId());
            this.J1.registerListener();
        }
    }

    public final void d4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.x0.f52416f).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(b.a.r0.k2.u.f.f1.a.m(i3))));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048642, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (b.a.q0.f1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), b.a.q0.f1.n.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (b.a.r0.k2.u.f.x0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(b.a.r0.k2.h.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new b.a.q0.f1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void delGodReplyFloor(ForumManageModel.b bVar, b.a.r0.k2.u.f.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, bVar, s0Var) == null) {
            List<PostData> list = this.x0.P0().T().f18820a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).O().size()) {
                        break;
                    } else if (bVar.f54254g.equals(list.get(i3).O().get(i4).G())) {
                        list.get(i3).O().remove(i4);
                        list.get(i3).l();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).n(bVar.f54254g);
            }
            if (z3) {
                s0Var.t1(this.x0.P0());
            }
        }
    }

    public void deleteThread(b.a.q0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    deleteThread((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void deleteThreadDirect(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(b.a.r0.k2.u.f.s0.W1, Integer.valueOf(b.a.r0.k2.u.f.s0.X1));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                deleteThread(sparseArray, (JSONArray) null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void doDoubleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            TiebaStatic.log("c12181");
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var == null || this.x0 == null) {
                return;
            }
            if ((s0Var != null && !s0Var.v1()) || this.x0.P0() == null || this.x0.P0().S() == null) {
                return;
            }
            b.a.r0.k2.u.f.s0 s0Var2 = this.E0;
            if (s0Var2 == null || s0Var2.t0() == null || !this.E0.t0().isFalling()) {
                b.a.r0.k2.r.q S = this.x0.P0().S();
                if (checkUpIsLogin()) {
                    if ((!S.g() || S.a() != 2) && this.E0.n0() != null && this.E0.n0().z() != null) {
                        this.E0.n0().z().j0(this.x0.f1(), this.x0.getFromForumId());
                    }
                    if (System.currentTimeMillis() - this.B > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).startAnimation(false);
                        this.B = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void doPraiseClick() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || this.E0 == null || (pbModel = this.x0) == null) {
            return;
        }
        if ((pbModel.P0() == null && this.x0.P0().S() == null) || !checkUpIsLogin() || this.E0.n0() == null || this.E0.n0().z() == null) {
            return;
        }
        this.E0.n0().z().j0(this.x0.f1(), this.x0.getFromForumId());
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.V = likeModel;
            likeModel.setLoadDataCallBack(new f0(this));
        }
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.x0.getForumId()) && this.x0.P0() != null && this.x0.P0().l() != null) {
            if (this.x0.P0().l().isLike() == 1) {
                this.x0.e0().A(this.x0.getForumId(), this.x0.f1());
            }
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && this.q == null) {
            this.q = new b.a.q0.s.s.b(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(b.a.r0.k2.l.call_phone), getPageContext().getString(b.a.r0.k2.l.sms_phone), getPageContext().getString(b.a.r0.k2.l.search_in_baidu)};
            b.a.q0.s.s.b bVar = this.q;
            bVar.j(strArr, new i0(this));
            bVar.g(b.C0692b.f13536a);
            bVar.h(17);
            bVar.c(getPageContext());
        }
    }

    public final void f4(b.a.q0.s.q.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, uVar) == null) || uVar == null) {
            return;
        }
        this.z2 = uVar;
        this.f52223g = true;
        this.E0.l2();
        this.E0.D2(this.y2);
    }

    @Override // b.a.r0.k2.y.b
    public void finish() {
        b.a.r0.k2.u.f.s0 s0Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            b.a.r0.k2.u.f.s0 s0Var2 = this.E0;
            if (s0Var2 != null) {
                s0Var2.c0();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P0() != null && !this.x0.P0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.x0.P0().O().f0();
                if (this.x0.isShareThread() && this.x0.P0().O().y1 != null) {
                    historyMessage.threadName = this.x0.P0().O().y1.f45036b;
                } else {
                    historyMessage.threadName = this.x0.P0().O().getTitle();
                }
                if (this.x0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.x0.P0().l().getName();
                }
                ArrayList<PostData> F = this.x0.P0().F();
                b.a.r0.k2.u.f.s0 s0Var3 = this.E0;
                int u02 = s0Var3 != null ? s0Var3.u0() : 0;
                if (F != null && u02 >= 0 && u02 < F.size()) {
                    historyMessage.postID = F.get(u02).G();
                }
                historyMessage.isHostOnly = this.x0.t0();
                historyMessage.isSquence = this.x0.d1();
                historyMessage.isShareThread = this.x0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            b.a.q0.x.x.e eVar = this.S0;
            if (eVar != null) {
                eVar.J();
            }
            if (this.n && getPbView() != null) {
                getPbView().h0();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && (pbModel2.v0() || this.x0.y0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.x0.f1());
                if (this.F0) {
                    if (this.H0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.x0.E0());
                    }
                    if (this.G0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.x0.A0());
                    }
                }
                if (this.x0.P0() != null && System.currentTimeMillis() - this.t >= 40000 && (q3 = this.x0.P0().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.n1);
                }
                this.f52221e.setResult(-1, intent);
            }
            if (a4()) {
                if (this.x0 != null && (s0Var = this.E0) != null && s0Var.E0() != null) {
                    b.a.r0.k2.r.f P0 = this.x0.P0();
                    if (P0 != null) {
                        if (P0.U() != null) {
                            P0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!P0.m0() && !this.M && P0.f18764h == null) {
                            b.a.r0.k2.u.f.k0.b().n(this.x0.Q0(), this.E0.E0().onSaveInstanceState(), this.x0.d1(), this.x0.t0(), this.E0.M0() != null && this.E0.M0().getVisibility() == 0);
                            if (this.m1 >= 0 || this.x0.h1() != null) {
                                b.a.r0.k2.u.f.k0.b().q(this.x0.h1());
                                b.a.r0.k2.u.f.k0.b().r(this.x0.i1());
                                b.a.r0.k2.u.f.k0.b().o(this.x0.I0());
                            }
                        }
                    }
                } else {
                    b.a.r0.k2.u.f.k0.b().m();
                }
                Z3();
            }
        }
    }

    public final boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            AbsPbActivity absPbActivity = this.f52221e;
            return (absPbActivity == null || absPbActivity.getPbModel() == null || this.f52221e.getPbModel().O0() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void g4(int i3) {
        PbModel pbModel;
        b.a.q0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048655, this, i3) == null) || (pbModel = this.x0) == null || pbModel.P0() == null || (O = this.x0.P0().O()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData L0 = O.L0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (L0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    O.m4(praiseData);
                } else {
                    O.L0().getUser().add(0, metaData);
                    O.L0().setNum(O.L0().getNum() + 1);
                    O.L0().setIsLike(i3);
                }
            }
            if (O.L0() != null) {
                if (O.L0().getNum() < 1) {
                    getResources().getString(b.a.r0.k2.l.zan);
                } else {
                    StringHelper.numFormatOver10000(O.L0().getNum());
                }
            }
        } else if (O.L0() != null) {
            O.L0().setIsLike(i3);
            O.L0().setNum(O.L0().getNum() - 1);
            ArrayList<MetaData> user = O.L0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        O.L0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (O.L0().getNum() < 1) {
                getResources().getString(b.a.r0.k2.l.zan);
            } else {
                String str = O.L0().getNum() + "";
            }
        }
        if (this.x0.d1()) {
            this.E0.n0().X();
        } else {
            this.E0.K3(this.x0.P0());
        }
    }

    public AntiData getAntiData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null || pbModel.P0() == null) {
                return null;
            }
            return this.x0.P0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.f52221e.getEventController() : (b.a.r0.k2.u.f.c1.a) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            PbModel pbModel = this.x0;
            return s0Var.v0(pbModel.J, pbModel.d1());
        }
        return (PostData) invokeV.objValue;
    }

    public String getFromWhere() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.P == null) {
                this.P = new b.a.e.e.k.b<>(new b2(this), 20, 0);
            }
            return this.P;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (this.G == null) {
                this.G = new b.a.e.e.k.b<>(new a2(this), 8, 0);
            }
            return this.G;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public PbInterviewStatusView.f getInterviewStatusCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.v0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean getIsMangaThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? (!this.f52223g && this.w2 == -1 && this.x2 == -1) ? false : true : invokeV.booleanValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this.L == null) {
                this.L = new b.a.e.e.k.b<>(new g2(this), 10, 0);
            }
            return this.L;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public int getMangaNextChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.x2 : invokeV.intValue;
    }

    public int getMangaPrevChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.w2 : invokeV.intValue;
    }

    @Override // b.a.r0.k2.y.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.f52221e : (AbsPbActivity) invokeV.objValue;
    }

    public b.a.q0.x.x.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.S0 : (b.a.q0.x.x.e) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.Z1 : (PbModel.g) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.x0 : (PbModel) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.c1.b getPbNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.f52225i : (b.a.r0.k2.u.f.c1.b) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.e1.a getPbRecThreadController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.u0 : (b.a.r0.k2.u.f.e1.a) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.s0 getPbView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.E0 : (b.a.r0.k2.u.f.s0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public b.a.q0.s.q.n1 getRecomStatisticData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.m0 : (b.a.q0.s.q.n1) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            b.a.e.e.k.b<RelativeLayout> bVar = new b.a.e.e.k.b<>(new f2(this), 10, 0);
            this.K = bVar;
            return bVar;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var == null) {
                return 0;
            }
            return s0Var.T0();
        }
        return invokeV.intValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            if (this.E == null) {
                this.E = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.J == null) {
                this.J = new b.a.e.e.k.b<>(new q2(this), 15, 0);
            }
            return this.J;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.I == null) {
                this.I = new b.a.e.e.k.b<>(new c2(this), 5, 0);
            }
            return this.I;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public b.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            if (this.F == null) {
                this.F = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.F;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var == null) {
                return 0;
            }
            return s0Var.Z0();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.k2.y.b
    public VideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public String getVideoSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.o : (VoiceManager) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            if (this.H == null) {
                this.H = new b.a.e.e.k.b<>(new e2(this), 8, 0);
            }
            return this.H;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public void goInterviewLivePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            if (this.k) {
                this.S = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.x0.P0() == null || this.x0.P0().O() == null || this.x0.P0().O().j1() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.x0.P0().O().j1().g(), this.x0.P0().O().j1().f(), this.x0.P0().O().j1().b(), this.x0.P0().O().j1().c(), this.x0.P0().O().r0(), this.x0.P0().O().q0())));
                this.f52221e.finish();
            }
        }
    }

    public final boolean h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            PostData c4 = b.a.r0.k2.r.g.c(this.x0.P0(), this.x0.d1(), this.x0.Z0());
            return (c4 == null || c4.t() == null || c4.t().getGodUserData() == null || c4.t().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final TbRichText h4(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048696, this, str, i3)) == null) {
            PbModel pbModel = this.x0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.P0() == null || str == null || i3 < 0) {
                return null;
            }
            b.a.r0.k2.r.f P0 = this.x0.P0();
            if (P0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P0.j());
                tbRichText = Q2(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P0.F();
                C2(P0, F);
                return Q2(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void handleMuteClick(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.f1);
            userMuteAddAndDelCustomMessage.setTag(this.f1);
            V3(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || this.f52221e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f52221e.getCurrentFocus() == null) {
            return;
        }
        b.a.e.e.p.l.x(getPageContext().getPageActivity(), this.f52221e.getCurrentFocus());
    }

    public void hideKeyboardAndEditor() {
        b.a.r0.k2.u.f.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048699, this) == null) || (s0Var = this.E0) == null) {
            return;
        }
        s0Var.e1();
        hideKeyBroad();
    }

    public final boolean i3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048700, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public boolean isActivityPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                return pbModel.t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean isMakeGoodsShowing(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048705, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.x0.P0().U() != null && (forumToolAuth = this.x0.P0().U().getForumToolAuth()) != null) {
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

    public boolean isManagerCanBlockThread(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048706, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.y1();
        }
        return invokeV.booleanValue;
    }

    public final boolean j3(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048708, this, z3)) == null) {
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P0() != null) {
                return ((this.x0.P0().V() != 0) || this.x0.P0().O() == null || this.x0.P0().O().J() == null || TextUtils.equals(this.x0.P0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void k3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048710, this) == null) || this.z2 == null) {
            return;
        }
        if (this.x2 == -1) {
            showToast(b.a.r0.k2.l.pb_manga_not_next_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.z2.a(), this.x2, 0)));
            this.f52221e.finish();
        }
    }

    public void loadNextVideoPb(String str) {
        b.a.r0.k2.u.f.s0 s0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048711, this, str) == null) || this.x0 == null || StringUtils.isNull(str) || (s0Var = this.E0) == null) {
            return;
        }
        s0Var.z2(true);
        this.x0.D1(str);
        this.M = true;
        this.E0.c0();
        this.E0.c1();
    }

    public final void m3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            PbModel pbModel = this.f52221e.getPbModel();
            this.x0 = pbModel;
            if (pbModel.m0() != null) {
                this.x0.m0().c(this.v2);
            }
            if (this.x0.L0() != null) {
                this.x0.L0().f(this.r1);
            }
            if (StringUtils.isNull(this.x0.f1())) {
                this.f52221e.finish();
            } else if (!"from_tieba_kuang".equals(this.Q) || this.Q == null) {
            } else {
                this.x0.j2(6);
            }
        }
    }

    public void markFloor(PostData postData) {
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.G() != null && postData.G().equals(this.x0.K0())) {
            z3 = true;
        }
        MarkData J0 = this.x0.J0(postData);
        if (this.x0.P0() != null && this.x0.P0().g0() && (firstPostData = getFirstPostData()) != null) {
            J0 = this.x0.J0(firstPostData);
        }
        if (J0 == null) {
            return;
        }
        this.E0.Q2();
        b.a.q0.i.a aVar = this.z0;
        if (aVar != null) {
            aVar.i(J0);
            if (!z3) {
                this.z0.a();
            } else {
                this.z0.d();
            }
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048714, this) == null) || this.z2 == null) {
            return;
        }
        if (this.w2 == -1) {
            showToast(b.a.r0.k2.l.pb_manga_not_prev_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.z2.a(), this.w2, 0)));
            this.f52221e.finish();
        }
    }

    public final void o3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048715, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || D2() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.i0);
            this.j0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (getPbView().O0() != null && postData != null) {
            getPbView().O0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.reply_title), postData.t().getName_show(), postData.M() != null ? postData.M().toString() : ""));
        }
        if (this.x0.P0() != null && this.x0.P0().g0()) {
            b.a.e.e.m.e.a().postDelayed(new y0(this, str, str2), 0L);
            return;
        }
        if (this.W0 == null) {
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
            this.W0 = cVar;
            cVar.j(1);
            this.W0.i(new z0(this, str, str2));
        }
        PbModel pbModel = this.x0;
        if (pbModel == null || pbModel.P0() == null || this.x0.P0().l() == null) {
            return;
        }
        this.W0.g(this.x0.P0().l().getId(), b.a.e.e.m.b.g(this.x0.f1(), 0L));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(b.a.r0.k2.i.container));
            this.Z1.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).getFirstLoadData(), "", 1);
            this.f52221e.getTiePlusEventController().addEventAckedCallbackWeaked(this.t0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048717, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.S0.I(i3, i4, intent);
            b.a.r0.k2.u.f.b1.f.a aVar = this.U;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (getPbView().O0() != null) {
                getPbView().O0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                Y2(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    q3();
                } else if (i3 == 13008) {
                    b.a.r0.k2.u.f.k0.b().m();
                    this.w0.postDelayed(new v1(this), 1000L);
                } else if (i3 == 13011) {
                    b.a.r0.y2.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.x0 == null) {
                        return;
                    }
                    I3(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    a3(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.X0 = emotionImageData;
                    if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        y3(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.W;
                    if (view != null) {
                        this.E0.h3(view);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        b.a.r0.y2.a.g().m(getPageContext());
                        e4();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.t) != null) {
                            shareSuccessReplyToServerModel.w(str, intExtra, new w1(this));
                        }
                        if (g3()) {
                            c4(true);
                        }
                    }
                } else if (i3 != 24008) {
                    switch (i3) {
                        case 25055:
                            View view2 = this.X;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view3 = this.Y;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            b.a.r0.k2.u.f.s0 s0Var = this.E0;
                            if (s0Var == null || s0Var.o0() == null) {
                                return;
                            }
                            this.E0.o0().performClick();
                            return;
                        case 25058:
                            View view4 = this.Z;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    this.E0.S2(false);
                    if (this.x0.P0() == null || this.x0.P0().O() == null || this.x0.P0().O().O0() == null) {
                        return;
                    }
                    this.x0.P0().O().O0().setStatus(2);
                }
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048718, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, context) == null) {
            super.onAttach(context);
            this.f52221e = (AbsPbActivity) context;
        }
    }

    public void onBackPressed() {
        List<a3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (list = this.o1) == null || list.isEmpty()) {
            return;
        }
        int size = this.o1.size();
        while (true) {
            size--;
            if (size <= -1 || this.o1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048721, this, i3) == null) || this.b0 == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.E0.K1(i3);
        b.a.q0.x.x.e eVar = this.S0;
        if (eVar != null && eVar.a() != null) {
            this.S0.a().onChangeSkinType(i3);
        }
        if (this.E0.a() != null) {
            this.E0.a().onChangeSkinType(getPageContext(), i3);
        }
        this.mContentProcessController.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), b.a.r0.k2.f.CAM_X0201));
        this.b0 = i3;
        stopVoice();
    }

    @Override // b.a.q0.s.s.a.e
    public void onClick(b.a.q0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, aVar) == null) {
            deleteThread(aVar, (JSONArray) null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int i3 = configuration.orientation;
            if (i3 == this.C) {
                return;
            }
            this.C = i3;
            if (i3 == 2) {
                this.N = true;
            } else {
                this.N = false;
            }
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var != null) {
                s0Var.L1(configuration);
            }
            PopupDialog popupDialog = this.I0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        b.a.r0.k2.u.f.s0 s0Var;
        b.a.r0.k2.u.f.s0 s0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, bundle) == null) {
            this.t = System.currentTimeMillis();
            this.d1 = getPageContext();
            Intent intent = this.f52221e.getIntent();
            if (intent != null) {
                this.r = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.Q = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.Q)) {
                        this.Q = data.getQueryParameter("from");
                    }
                }
                this.a0 = intent.getStringExtra("st_type");
                "from_interview_live".equals(this.Q);
                this.w2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.x2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.y2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.N0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.O0 = intent.getStringExtra("high_light_post_id");
                this.P0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (getIsMangaThread()) {
                    this.f52221e.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.T = stringExtra;
                this.T = b.a.e.e.p.k.isEmpty(stringExtra) ? "" : this.T;
                this.n1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                b.a.q0.s.q.n1 n1Var = new b.a.q0.s.q.n1();
                this.m0 = n1Var;
                n1Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.bjhFrom = intExtra;
                if (intExtra == 0) {
                    this.bjhFrom = intent.getIntExtra("key_start_from", 0);
                }
                this.lastTid = intent.getStringExtra("last_tid");
            } else {
                this.r = System.currentTimeMillis();
            }
            this.v = this.t - this.r;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.p = 0;
            m3(bundle);
            if (this.x0.P0() != null) {
                this.x0.P0().N0(this.T);
            }
            e3();
            if (intent != null && (s0Var2 = this.E0) != null) {
                s0Var2.f19400b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.g1 == null) {
                        this.g1 = new c0(this, intent);
                    }
                    b.a.e.e.m.e.a().postDelayed(this.g1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.x0.P0() != null) {
                    this.x0.k2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            d3(bundle);
            b.a.q0.x.x.g gVar = new b.a.q0.x.x.g();
            this.R0 = gVar;
            D3(gVar);
            b.a.q0.x.x.e eVar = (b.a.q0.x.x.e) this.R0.a(getActivity());
            this.S0 = eVar;
            eVar.f0(this.f52221e.getPageContext());
            this.S0.o0(this.X1);
            this.S0.p0(this.Y0);
            this.S0.h0(1);
            this.S0.G(this.f52221e.getPageContext(), bundle);
            this.S0.a().addHideLauncher(new b.a.q0.x.k(getActivity()));
            this.S0.a().showLinePositionBottom(true);
            F3(true);
            this.S0.P(this.x0.s0(), this.x0.f1(), this.x0.p0());
            registerListener(this.v1);
            if (!this.x0.D0()) {
                this.S0.s(this.x0.f1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.x0.r1()) {
                this.S0.l0(getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs));
            } else {
                b.a.r0.k2.u.f.s0 s0Var3 = this.E0;
                if (s0Var3 != null) {
                    this.S0.l0(s0Var3.R0());
                }
            }
            registerListener(this.u1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.t1);
            registerListener(this.mFirstFloorPraiseListener);
            registerListener(this.T1);
            registerListener(this.b2);
            registerListener(this.s1);
            b.a.r0.l3.j0.f fVar = new b.a.r0.l3.j0.f("pb", b.a.r0.l3.j0.f.f20604d);
            this.Q0 = fVar;
            fVar.d();
            registerListener(this.C1);
            registerListener(this.L1);
            this.x0.K1();
            registerListener(this.a2);
            registerListener(this.U1);
            registerListener(this.W1);
            registerListener(this.G1);
            b.a.r0.k2.u.f.s0 s0Var4 = this.E0;
            if (s0Var4 != null && s0Var4.Y0() != null && this.E0.W0() != null) {
                b.a.r0.k2.u.f.c1.b bVar = new b.a.r0.k2.u.f.c1.b(getActivity(), this.E0.Y0(), this.E0.W0(), this.E0.M0());
                this.f52225i = bVar;
                bVar.t(this.K1);
            }
            if (this.f52223g && (s0Var = this.E0) != null && s0Var.W0() != null) {
                this.E0.W0().setVisibility(8);
            }
            b.a.q0.s.g0.c cVar = new b.a.q0.s.g0.c();
            this.e1 = cVar;
            cVar.f12958a = 1000L;
            registerListener(this.S1);
            registerListener(this.R1);
            registerListener(this.P1);
            registerListener(this.Q1);
            registerListener(this.E1);
            registerListener(this.z1);
            registerListener(this.A1);
            this.D1.setSelfListener(true);
            this.D1.setTag(this.f52221e.getUniqueId());
            this.D1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.D1);
            registerResponsedEventListener(TipEvent.class, this.M1);
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
            this.x0.l0().A(this.N1);
            this.mContentProcessController = new b.a.r0.k2.u.f.u0();
            if (this.S0.v() != null) {
                this.mContentProcessController.m(this.S0.v().h());
            }
            this.S0.e0(this.Z0);
            this.D0 = new ShareSuccessReplyToServerModel();
            addBackInterceptor(this.q1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new d0(this));
            b.a.r0.k2.u.g.a aVar = new b.a.r0.k2.u.g.a(getContext());
            this.y0 = aVar;
            aVar.b(getUniqueId());
            b.a.r0.k3.c.g().i(getUniqueId());
            b.a.q0.s.o.a.b().l("3", "");
            this.p1 = new b.a.r0.a0.a(getPageContext());
            this.u0 = new b.a.r0.k2.u.f.e1.a(this, getUniqueId(), this.E0, this.x0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && b.a.e.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.u = System.currentTimeMillis() - this.t;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048725, this, layoutInflater, viewGroup, bundle)) == null) {
            this.E0 = new b.a.r0.k2.u.f.s0(this, this.mCommonOnClickListener, this.O1);
            b.a.r0.k0.b bVar = new b.a.r0.k0.b(getActivity());
            this.f52224h = bVar;
            bVar.i(B2);
            this.f52224h.d(this.u2);
            this.E0.J2(this.d2);
            this.E0.I2(this.i2);
            this.E0.C2(this.g2);
            this.E0.A2(b.a.q0.s.k.c().g());
            this.E0.G2(this.k2);
            this.E0.M2(this.q2);
            this.E0.K2(this.r2);
            this.E0.H2(this.t2);
            this.E0.F2(this.f2);
            this.E0.F3(this.mIsLogin);
            if (this.f52221e.getIntent() != null) {
                this.E0.y2(this.f52221e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.E0.N0().setFromForumId(this.x0.getFromForumId());
            this.E0.r2(this.S0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.S0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.S0.l0(this.E0.R0());
            }
            this.E0.u2(new g0(this));
            this.E0.x2(this.x0.y0());
            this.E0.L2(this.x0.O0());
            this.u0.f(this.E0, this.x0);
            return this.E0.a1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        b.a.r0.k2.u.f.g1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            b.a.r0.k3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.x0.P0().m());
                statisticItem.param("tid", this.x0.f1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.x && this.E0 != null) {
                this.x = true;
                A3(false, null);
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.x0.destory();
                if (this.x0.L0() != null) {
                    this.x0.L0().d();
                }
            }
            b.a.q0.x.x.e eVar = this.S0;
            if (eVar != null) {
                eVar.J();
            }
            ForumManageModel forumManageModel = this.A0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.V;
            if (likeModel != null) {
                likeModel.I();
            }
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var != null) {
                s0Var.M1();
                b.a.r0.k2.u.f.g1.c cVar2 = this.E0.f19406h;
                if (cVar2 != null) {
                    cVar2.x();
                }
            }
            b.a.q0.q0.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            b.a.r0.k2.u.f.c1.b bVar2 = this.f52225i;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            b.a.r0.k2.u.f.s0 s0Var2 = this.E0;
            if (s0Var2 != null) {
                s0Var2.c0();
            }
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.mFirstFloorPraiseListener);
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.A1);
            this.d1 = null;
            this.e1 = null;
            b.a.r0.z2.j0.a.e().g();
            if (this.g1 != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.g1);
            }
            b.a.r0.k2.u.f.b1.f.a aVar = this.U;
            if (aVar != null) {
                aVar.f();
            }
            b.a.r0.k2.u.f.s0 s0Var3 = this.E0;
            if (s0Var3 != null && (cVar = s0Var3.f19406h) != null) {
                cVar.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.D0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            b.a.r0.k2.u.f.u0 u0Var = this.mContentProcessController;
            if (u0Var != null) {
                u0Var.j();
            }
            PbModel pbModel2 = this.x0;
            if (pbModel2 != null && pbModel2.e0() != null) {
                this.x0.e0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            b.a.r0.k2.u.f.s0 s0Var4 = this.E0;
            if (s0Var4 != null) {
                s0Var4.C3();
            }
            b.a.r0.k2.u.f.e1.a aVar2 = this.u0;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.sortSwitchId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public b.a.e.l.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (b.a.e.l.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        b.a.r0.k2.u.f.s0 s0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048729, this, i3, keyEvent)) == null) ? (keyEvent == null || (s0Var = this.E0) == null || !s0Var.O1(i3)) ? false : true : invokeIL.booleanValue;
    }

    @Override // b.a.q0.f1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048730, this, context, str) == null) {
            this.A = true;
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048731, this, context, str, z3) == null) {
            if (b.a.r0.k2.u.f.x0.c(str) && (pbModel = this.x0) != null && pbModel.f1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.x0.f1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    b.a.q0.u.n nVar = new b.a.q0.u.n();
                    nVar.f14159a = str;
                    nVar.f14160b = 3;
                    nVar.f14161c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, nVar));
                }
            } else {
                b.a.r0.k2.u.f.x0.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            x3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.k = false;
            } else {
                this.k = true;
            }
            super.onPause();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.p = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var != null) {
                s0Var.R1();
            }
            if (!this.x0.D0()) {
                this.S0.V(this.x0.f1());
            }
            PbModel pbModel = this.x0;
            if (pbModel != null) {
                pbModel.J1();
            }
            b.a.q0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.y1);
            z3();
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048734, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.K0 = str;
        if (this.q == null) {
            f3();
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

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.e.a.i
    public void onPreLoad(b.a.e.l.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            this.k = false;
            super.onResume();
            if (this.S) {
                this.S = false;
                goInterviewLivePage();
            }
            if (h3()) {
                this.z = System.currentTimeMillis();
            } else {
                this.z = -1L;
            }
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var != null && s0Var.a1() != null) {
                if (!this.l) {
                    R3();
                } else {
                    hideLoadingView(this.E0.a1());
                }
                this.E0.S1();
            }
            if (this.p == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            b.a.r0.k2.u.f.s0 s0Var2 = this.E0;
            NoNetworkView a4 = s0Var2 != null ? s0Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && b.a.e.e.p.j.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.y1);
            this.M0 = false;
            B3();
            registerListener(this.P1);
            registerListener(this.Q1);
            registerListener(this.S1);
            if (this.l1) {
                x3();
                this.l1 = false;
            }
            W3();
            ItemCardHelper.v(this.s2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                b.a.q0.w.c.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.x0.Y1(bundle);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.S0.L(bundle);
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048738, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            super.onStop();
            if (this.z > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.z;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.z = 0L;
            }
            if (getPbView().O0() != null) {
                getPbView().O0().i();
            }
            b.a.r0.k2.u.f.g1.c cVar = this.E0.f19406h;
            if (cVar != null && !cVar.t()) {
                this.E0.f19406h.x();
            }
            PbModel pbModel = this.x0;
            if (pbModel != null && pbModel.P0() != null && this.x0.P0().l() != null && this.x0.P0().O() != null) {
                b.a.q0.v.a.k().y(getPageContext().getPageActivity(), "pb", this.x0.P0().l().getId(), b.a.e.e.m.b.g(this.x0.P0().O().f0(), 0L));
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            b.a.r0.k3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048741, this, view, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z3) == null) {
            super.onUserChanged(z3);
            this.E0.F3(z3);
            PopupDialog popupDialog = this.I0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            if (z3 && this.M0) {
                this.E0.R2();
                this.x0.B1(true);
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048743, this, context, str) == null) {
            b.a.r0.k2.u.f.x0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048744, this, context, str) == null) {
        }
    }

    public void openMore() {
        PbModel pbModel;
        b.a.r0.k2.r.f P0;
        b.a.q0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || (pbModel = this.x0) == null || pbModel.P0() == null || (O = (P0 = this.x0.P0()).O()) == null || O.J() == null) {
            return;
        }
        this.E0.e1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        b.a.r0.k2.u.f.e0 e0Var = new b.a.r0.k2.u.f.e0();
        int V = this.x0.P0().V();
        if (V != 1 && V != 3) {
            e0Var.f19232g = false;
        } else {
            e0Var.f19232g = true;
            e0Var.s = O.r0() == 1;
        }
        if (isMakeGoodsShowing(V)) {
            e0Var.f19233h = true;
            e0Var.r = O.q0() == 1;
        } else {
            e0Var.f19233h = false;
        }
        if (V == 1002 && !equals) {
            e0Var.u = true;
        }
        e0Var.n = M3(O.S1(), P0.i0(), equals, V, O.I2(), O.s2());
        e0Var.f19230e = K3(equals, P0.i0());
        e0Var.f19234i = N3();
        e0Var.f19231f = L3(equals);
        e0Var.k = equals && P0.U() != null && P0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            e0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().f();
        }
        e0Var.t = equals;
        e0Var.q = this.x0.d1();
        e0Var.f19227b = true;
        e0Var.f19226a = j3(equals);
        if (equals) {
            this.E0.u1();
        }
        e0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        e0Var.j = true;
        e0Var.o = this.x0.t0();
        e0Var.f19229d = true;
        if (O.q1() == null) {
            e0Var.f19228c = true;
        } else {
            e0Var.f19228c = false;
        }
        if (P0.g0()) {
            e0Var.f19227b = false;
            e0Var.f19229d = false;
            e0Var.f19228c = false;
            e0Var.f19232g = false;
            e0Var.f19233h = false;
        }
        e0Var.v = TbSingleton.getInstance().mShowCallFans && equals && !P0.g0();
        b.a.r0.k2.u.f.s0 s0Var = this.E0;
        if (s0Var != null) {
            PbModel pbModel2 = this.x0;
            PostData v02 = s0Var.v0(pbModel2.J, pbModel2.d1());
            e0Var.w = v02 != null ? v02.U : false;
        }
        e0Var.m = true;
        if (b.a.q0.g1.b.c.d()) {
            e0Var.f19229d = false;
            e0Var.f19227b = false;
            e0Var.f19228c = false;
            e0Var.m = false;
        }
        if (O.S1()) {
            e0Var.n = false;
            e0Var.f19232g = false;
            e0Var.f19233h = false;
        }
        this.E0.f19406h.E(e0Var);
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            b.a.r0.k2.r.f P0 = this.x0.P0();
            this.x0.r2(true);
            b.a.q0.i.a aVar = this.z0;
            if (aVar != null) {
                P0.E0(aVar.g());
            }
            this.E0.t1(P0);
        }
    }

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || !checkUpIsLogin() || (pbModel = this.x0) == null || pbModel.P0() == null || this.x0.P0().l() == null || D2()) {
            return;
        }
        if (this.x0.P0().g0()) {
            this.E0.V();
            return;
        }
        if (this.V0 == null) {
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
            this.V0 = cVar;
            cVar.j(0);
            this.V0.i(new v0(this));
        }
        this.V0.g(this.x0.P0().l().getId(), b.a.e.e.m.b.g(this.x0.f1(), 0L));
    }

    public final void q3() {
        MarkData h02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || this.z0 == null) {
            return;
        }
        if (this.x0.P0() != null && this.x0.P0().g0()) {
            h02 = this.x0.h0(0);
        } else {
            h02 = this.x0.h0(this.E0.D0());
        }
        if (h02 == null) {
            return;
        }
        if (h02.isApp() && (h02 = this.x0.h0(this.E0.D0() + 1)) == null) {
            return;
        }
        this.E0.Q2();
        this.z0.i(h02);
        if (!this.z0.e()) {
            if (this.E0 != null && this.x0 != null && b.a.q0.b.d.T() && !b.a.r0.k2.u.f.f1.b.k(this.x0.f52416f)) {
                this.E0.v3();
                b.a.r0.k2.u.f.f1.b.b(this.x0.f52416f);
            }
            this.z0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.z0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void r3(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    public void refGodReplyFloor(b.a.r0.k2.r.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, sVar) == null) {
            String G = sVar.i().G();
            List<PostData> list = this.x0.P0().T().f18820a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.G() == null || !postData.G().equals(G)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = sVar.k();
                    postData.z0(sVar.m());
                    if (postData.O() != null) {
                        postData.O().clear();
                        postData.O().addAll(k3);
                    }
                }
            }
            if (this.x0.z0()) {
                return;
            }
            this.E0.t1(this.x0.P0());
        }
    }

    public void refreshMark(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048751, this, z3, markData) == null) {
            this.E0.P2();
            this.x0.r2(z3);
            b.a.q0.i.a aVar = this.z0;
            if (aVar != null) {
                aVar.h(z3);
                if (markData != null) {
                    this.z0.i(markData);
                }
            }
            if (this.x0.B0()) {
                p3();
            } else {
                this.E0.t1(this.x0.P0());
            }
        }
    }

    public void refreshWrite(b.a.r0.k2.r.s sVar) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048752, this, sVar) == null) || sVar.i() == null) {
            return;
        }
        String G = sVar.i().G();
        ArrayList<PostData> F = this.x0.P0().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.G() == null || !postData.G().equals(G)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = sVar.k();
                postData.z0(sVar.m());
                if (postData.O() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.V() != null && next != null && next.t() != null && (metaData = postData.V().get(next.t().getUserId())) != null) {
                            next.k0(metaData);
                            next.t0(true);
                            next.F0(getPageContext(), this.x0.z1(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.O().size();
                    if (!postData.Z(false)) {
                        postData.O().clear();
                        postData.O().addAll(k3);
                    }
                }
                if (postData.x() != null) {
                    postData.i0();
                }
            }
        }
        if (!this.x0.z0() && z3) {
            this.E0.t1(this.x0.P0());
        }
        if (z3) {
            refGodReplyFloor(sVar);
        }
    }

    public void removeBackInterceptor(a3 a3Var) {
        List<a3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048753, this, a3Var) == null) || a3Var == null || (list = this.o1) == null) {
            return;
        }
        list.remove(a3Var);
    }

    @Override // b.a.r0.k2.z.f.b
    public void resetLoadMoreFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z3) == null) {
            this.M0 = z3;
        }
    }

    public final boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048755, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.A0 && !TextUtils.isEmpty(postData.u()) && b.a.q0.s.k.c().g()) {
                        return s3(postData.G());
                    }
                    if (checkUpIsLogin() && (pbModel = this.x0) != null && pbModel.P0() != null) {
                        if (getPbView().O0() != null) {
                            getPbView().O0().c();
                        }
                        b.a.r0.k2.r.s sVar = new b.a.r0.k2.r.s();
                        sVar.A(this.x0.P0().l());
                        sVar.E(this.x0.P0().O());
                        sVar.C(postData);
                        getPbView().N0().S(sVar);
                        getPbView().N0().setPostId(postData.G());
                        o3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        b.a.q0.x.x.e eVar = this.S0;
                        if (eVar != null) {
                            this.E0.v2(eVar.D());
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

    public final boolean s3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048756, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p3 = b.a.q0.s.e0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    b.a.q0.m.a.p(getPageContext().getPageActivity(), getResources().getString(b.a.r0.k2.l.editor_privilege), p3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setNavigationBarShowFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z3) == null) {
            this.R = z3;
        }
    }

    public void setShowLinkGoodsMore(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048758, this, z3) == null) {
            this.O = z3;
        }
    }

    public final void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.f52221e;
            if (absPbActivity != null) {
                absPbActivity.stopVoice();
            }
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            if (!b.a.e.e.p.j.z()) {
                showToast(b.a.r0.k2.l.network_not_available);
                return;
            }
            this.E0.c0();
            if (this.m) {
                return;
            }
            stopVoice();
            this.E0.Q2();
            if (this.x0.loadData()) {
                this.E0.u3();
            }
        }
    }

    public final void u3(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048761, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        b.a.r0.k2.r.f P0 = this.x0.P0();
        TbRichText h4 = h4(str, i3);
        if (h4 == null || (tbRichTextData = h4.y().get(this.j2)) == null) {
            return;
        }
        eVar.f52189f = String.valueOf(h4.getPostId());
        eVar.f52184a = new ArrayList<>();
        eVar.f52185b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f52191h = false;
            String a4 = b.a.r0.k2.r.g.a(tbRichTextData);
            eVar.f52184a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = U2(tbRichTextData);
            imageUrlData.originalUrl = U2(tbRichTextData);
            imageUrlData.originalSize = V2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = T2(tbRichTextData);
            imageUrlData.isLongPic = S2(tbRichTextData);
            imageUrlData.postId = h4.getPostId();
            imageUrlData.mIsReserver = this.x0.a1();
            imageUrlData.mIsSeeHost = this.x0.t0();
            eVar.f52185b.put(a4, imageUrlData);
            if (P0 != null) {
                if (P0.l() != null) {
                    eVar.f52186c = P0.l().getName();
                    eVar.f52187d = P0.l().getId();
                }
                if (P0.O() != null) {
                    eVar.f52188e = P0.O().f0();
                }
                eVar.f52190g = P0.s() == 1;
            }
            imageUrlData.threadId = b.a.e.e.m.b.g(eVar.f52188e, -1L);
            return;
        }
        eVar.f52191h = true;
        int size = P0.F().size();
        this.l2 = false;
        eVar.j = -1;
        int R2 = P0.j() != null ? R2(P0.j().M(), h4, i3, i3, eVar.f52184a, eVar.f52185b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = P0.F().get(i4);
            if (postData.G() == null || P0.j() == null || P0.j().G() == null || !postData.G().equals(P0.j().G())) {
                R2 = R2(postData.M(), h4, R2, i3, eVar.f52184a, eVar.f52185b);
            }
        }
        if (eVar.f52184a.size() > 0) {
            ArrayList<String> arrayList = eVar.f52184a;
            eVar.f52192i = arrayList.get(arrayList.size() - 1);
        }
        if (P0 != null) {
            if (P0.l() != null) {
                eVar.f52186c = P0.l().getName();
                eVar.f52187d = P0.l().getId();
            }
            if (P0.O() != null) {
                eVar.f52188e = P0.O().f0();
            }
            eVar.f52190g = P0.s() == 1;
        }
        eVar.j = R2;
    }

    public final AbsPbActivity.e v3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048762, this, str)) == null) {
            String str2 = null;
            if (this.x0.P0() != null && this.x0.P0().F() != null && this.x0.P0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.x0.P0().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.x0.P0().F().get(i3).G())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.x0.P0().F().get(i3);
                if (postData.M() != null && postData.M().y() != null) {
                    Iterator<TbRichTextData> it = postData.M().y().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.C() != null) {
                                str2 = next.C().y();
                            }
                        }
                    }
                    u3(str2, 0, eVar);
                    b.a.r0.k2.r.g.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void w3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048763, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(b.a.r0.k2.i.pb_track_more_obj_source, Integer.valueOf(this.f52222f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            hideNetRefreshView(this.E0.a1());
            R3();
            if (this.x0.H1()) {
                this.E0.Q2();
            }
            this.E0.X2();
        }
    }

    public final void y3(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048765, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.U == null) {
            b.a.r0.k2.u.f.b1.f.a aVar = new b.a.r0.k2.u.f.b1.f.a(this.f52221e);
            this.U = aVar;
            aVar.n(this.Y0);
            this.U.m(this.X1);
        }
        this.U.k(emotionImageData, getPbModel(), getPbModel().P0());
    }

    public final void z3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || (pbModel = this.x0) == null || pbModel.P0() == null || this.x0.P0().O() == null || !this.x0.P0().O().E2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.q0.f1.n.i
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            b.a.r0.k2.u.f.s0 s0Var = this.E0;
            if (s0Var == null) {
                return null;
            }
            return s0Var.E0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(b.a.r0.k2.u.f.s0.W1)).intValue();
            if (intValue == b.a.r0.k2.u.f.s0.X1) {
                if (this.A0.P()) {
                    return;
                }
                this.E0.B3();
                String str = (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.A0.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.A0.S(this.x0.P0().l().getId(), this.x0.P0().l().getName(), this.x0.P0().O().f0(), str, intValue3, intValue2, booleanValue, this.x0.P0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == b.a.r0.k2.u.f.s0.Y1 || intValue == b.a.r0.k2.u.f.s0.a2) {
                if (this.x0.m0() != null) {
                    this.x0.m0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == b.a.r0.k2.u.f.s0.Y1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }
}
