package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.e1.n.f;
import c.a.o0.h.a;
import c.a.o0.r.t.a;
import c.a.p0.f1.i2.a.c;
import c.a.p0.s0.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
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
import com.google.android.material.appbar.AppBarLayout;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements c.a.o0.e1.n.i, VoiceManager.j, c.a.p0.w2.q.c, TbRichTextView.s, c.a.p0.w2.q.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int N1;
    public static final int O1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public final b.InterfaceC1370b A1;
    public View.OnClickListener B;
    public boolean B0;
    public NewWriteModel.g B1;
    public TextView C;
    public ReplyPrivacyCheckController C0;
    public c.a.o0.w.y.c C1;
    public TextView D;
    public c.a.p0.f1.i2.a.c D0;
    public final View.OnClickListener D1;
    public ImageView E;
    public c.a.p0.f1.i2.a.c E0;
    public View.OnClickListener E1;
    public TBSpecificationBtn F;
    public c.a.p0.w2.m.f.c1 F0;
    public final AdapterView.OnItemClickListener F1;
    public TbImageView G;
    public PermissionJudgePolicy G0;
    public CustomMessageListener G1;
    public View H;
    public c.a.o0.w.y.g H0;
    public CustomMessageListener H1;
    public ValueAnimator I;
    public c.a.o0.w.y.e I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public EditorTools J0;
    public final ItemCardHelper.c J1;
    public FallingView K;
    public c.a.p0.w2.m.f.x K0;
    public CustomMessageListener K1;
    public boolean L;
    public PbFakeFloorModel L0;
    public final View.OnLongClickListener L1;
    public View M;
    public c.a.p0.s0.b M0;
    public SortSwitchButton.f M1;
    public c.a.p0.w2.q.h.a N;
    public int[] N0;
    public c.a.o0.r.l0.c O;
    public int O0;
    public c.a.o0.h.a P;
    public int P0;
    public c.a.p0.w2.m.f.j1.f.a Q;
    public int Q0;
    public EmotionImageData R;
    public int R0;
    public c.a.o0.s.e.a S;
    public int S0;
    public ForumManageModel T;
    public boolean T0;
    public VoiceManager U;
    public boolean U0;
    public c.a.d.f.k.b<GifView> V;
    @NonNull
    public TiePlusEventController.f V0;
    public c.a.d.f.k.b<TextView> W;
    public FrameLayout W0;
    public c.a.d.f.k.b<ImageView> X;
    public RightFloatLayerView X0;
    public c.a.d.f.k.b<View> Y;
    public final PbModel.g Y0;
    public c.a.d.f.k.b<LinearLayout> Z;
    public final a.InterfaceC0810a Z0;
    public AbsPbActivity a;
    public c.a.o0.w.y.b a1;

    /* renamed from: b  reason: collision with root package name */
    public long f35138b;
    public final CustomMessageListener b1;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f35139c;
    public CustomMessageListener c1;

    /* renamed from: d  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f35140d;
    public final CustomMessageListener d1;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f35141e;
    public CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragmentAdapter f35142f;
    public HttpMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public View f35143g;
    public c.a.d.f.k.b<RelativeLayout> g0;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public View f35144h;
    public boolean h0;
    public CustomMessageListener h1;
    public AppBarLayout i;
    public LinearLayout i0;
    public CustomMessageListener i1;
    public VideoContainerLayout j;
    public View j0;
    public c.a.o0.w.y.b j1;
    public c.a.p0.w2.q.l.a k;
    public View k0;
    public final NewWriteModel.g k1;
    public c.a.p0.w2.q.f l;
    public LinearLayout l0;
    public View.OnClickListener l1;
    public NavigationBar m;
    public HeadImageView m0;
    public CustomMessageListener m1;
    public View n;
    public TextView n0;
    public int n1;
    public View o;
    public ImageView o0;
    public float o1;
    public View p;
    public ImageView p0;
    public float p1;
    public ImageView q;
    public ImageView q0;
    public boolean q1;
    public View r;
    public c.a.p0.w2.r.j r0;
    public boolean r1;
    public ImageView s;
    public TextView s0;
    public View.OnTouchListener s1;
    public c.a.p0.g0.a t;
    public TextView t0;
    public GestureDetector t1;
    public boolean u;
    public b2 u0;
    public GestureDetector.SimpleOnGestureListener u1;
    public View v;
    public String v0;
    public Runnable v1;
    public c.a.p0.w2.q.j.a w;
    public boolean w0;
    public ObjectAnimator w1;
    public View x;
    public String x0;
    public ObjectAnimator x1;
    public View y;
    public boolean y0;
    public final c.a.d.a.e y1;
    public View z;
    public boolean z0;
    public View.OnTouchListener z1;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.T0) {
                return;
            }
            this.a.M4();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements c.a.o0.c1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f35145b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35146c;

        public a0(AbsVideoPbFragment absVideoPbFragment, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35146c = absVideoPbFragment;
            this.a = i;
            this.f35145b = i2;
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
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f35146c.getContext(), this.f35145b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public a1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                c.a.p0.w2.q.h.a aVar = this.a.N;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!c.a.d.f.p.l.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                    return false;
                }
                if (this.a.w() != null && !this.a.w().isLoading) {
                    this.a.T4();
                    this.a.z4();
                    z = true;
                    if (this.a.w().S0() != null && this.a.w().S0().f19819f != null && this.a.w().S0().f19819f.size() > i) {
                        int intValue = this.a.w().S0().f19819f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.w().l1()).param("fid", this.a.w().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.w().H2(intValue)) {
                            this.a.L = true;
                        }
                    }
                }
                return z;
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
    public class a2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a2(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
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
                this.a.h4((c.a.p0.w2.i.u) fVar.a());
            } else if (type == 1) {
                this.a.L2((ForumManageModel.b) fVar.a(), false);
            } else if (type != 2) {
            } else {
                if (fVar.a() == null) {
                    this.a.f4(false, null);
                } else {
                    this.a.f4(true, (MarkData) fVar.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.b5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public b0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
            c.a.p0.w2.q.h.a aVar = this.a.N;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e7c, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    aVar.l0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e7c, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e65, 1);
                    this.a.N.B(sparseArray);
                } else if (booleanValue3) {
                    aVar.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public b1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
                if (this.a.I0 != null && this.a.I0.a() != null) {
                    this.a.I0.a().A(new c.a.o0.w.a(45, 27, null));
                }
                this.a.E2();
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
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoPbFragment absVideoPbFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.getView() != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.hideLoadingView(absVideoPbFragment.getView());
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
                            this.a.A4(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(errorString);
                        bdTopToast2.j((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public c0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.w() == null || this.a.w().b1() == i + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            absVideoPbFragment.o4(absVideoPbFragment.g3(i));
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public c1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.p0.w2.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, c.a.p0.w2.i.f fVar, String str, int i4) {
            String k3;
            c.a.o0.w.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fVar, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906c9));
                }
                this.a.y4();
                this.a.r3();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.G4(false);
                if (z && fVar != null) {
                    ThreadData O = fVar.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).s(fVar, i2);
                    this.a.a4(fVar);
                    this.a.I4(fVar);
                    this.a.g4(fVar);
                    this.a.d4(z, i, i2, i3, fVar, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.U().getBimg_end_time());
                    if (fVar.F() != null && fVar.F().size() >= 1 && fVar.F().get(0) != null) {
                        this.a.w().n2(fVar.F().get(0).G());
                    } else if (fVar.W() != null) {
                        this.a.w().n2(fVar.W().G());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(fVar.r());
                    }
                    AntiData d2 = fVar.d();
                    if (d2 != null) {
                        this.a.x0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.a.x0) && this.a.I0 != null && this.a.I0.a() != null && (m = this.a.I0.a().m(6)) != null && !TextUtils.isEmpty(this.a.x0)) {
                            ((View) m).setOnClickListener(this.a.l1);
                        }
                    }
                    if (this.a.C0 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.C0.setLikeUserData(attentionHostData);
                    }
                    this.a.B3(fVar);
                    if (this.a.w() != null && this.a.w().x1()) {
                        k3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd);
                    } else {
                        k3 = this.a.k3();
                    }
                    if (!StringUtils.isNull(k3)) {
                        this.a.I0.k0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), k3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.w().k1());
                            jSONObject.put("fid", this.a.w().getForumId());
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
                    if ((this.a.I3() && this.a.j3() == null) || this.a.S2() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.I3()) {
                        if (i != -1) {
                            if (this.a.w() != null && this.a.w().S0() != null) {
                                arrayList = this.a.w().S0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.j3().i1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                            } else if (this.a.j3().c1()) {
                                this.a.j3().j1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dae));
                            } else {
                                this.a.j3().j1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0daf));
                            }
                        } else {
                            this.a.j3().i1("");
                        }
                        this.a.j3().P0();
                    } else {
                        if (i != -1) {
                            if (this.a.w() != null && this.a.w().S0() != null) {
                                arrayList = this.a.w().S0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.S2().o1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                            } else if (this.a.S2().f1()) {
                                this.a.S2().p1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dae));
                            } else {
                                this.a.S2().p1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0daf));
                            }
                        } else {
                            this.a.S2().o1("");
                        }
                        this.a.S2().R0();
                    }
                }
                c.a.p0.z3.c.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.k4.a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                c.a.p0.k4.a aVar = (c.a.p0.k4.a) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
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
                    this.a.N.E0(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.N.k0(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
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
    public class d1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public d1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.N == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            c.a.p0.w2.q.h.a aVar = this.a.N;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.p0.w2.i.f S0 = this.a.w().S0();
                if (S0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b18));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b14);
                    }
                    this.a.N.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.d.f.p.m.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b15);
                    }
                    this.a.O.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.p0.a4.k0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.p0.a4.k0.e) || (eVar = (c.a.p0.a4.k0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f12234b) == null || agreeData.agreeType != 2 || this.a.r0 == null || this.a.w() == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || c.a.p0.w2.m.f.n1.b.k(this.a.w().k1())) {
                return;
            }
            this.a.r0.m(2);
            c.a.p0.w2.m.f.n1.b.b(this.a.w().k1());
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public e1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.j4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.N == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            c.a.p0.w2.q.h.a aVar = this.a.N;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1462));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.d.f.p.m.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1461);
                }
                this.a.O.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements Observer<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public f0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable ThreadData threadData) {
            c.a.p0.w2.q.l.a aVar;
            BdTypeRecyclerView i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null || (aVar = this.a.k) == null) {
                return;
            }
            if (aVar.b0() != null && this.a.k.b0().equals(threadData.getThreadVideoInfo().video_url)) {
                this.a.k.setData(threadData);
                return;
            }
            if (!c.a.d.f.p.m.isEmpty(this.a.k.b0())) {
                this.a.B0 = true;
                if (this.a.I3()) {
                    this.a.f35141e.setCurrentItem(0);
                } else {
                    this.a.f35141e.setCurrentItem(0);
                }
                if (!this.a.I3() && (i3 = this.a.i3()) != null) {
                    i3.scrollToPosition(0);
                }
            }
            if (this.a.l == null || !this.a.l.k()) {
                this.a.k4();
                this.a.w2(threadData);
            }
            this.a.E3();
            if (this.a.l != null && this.a.l.l()) {
                this.a.l.s();
            }
            boolean z = !StringHelper.equals(this.a.k.b0(), threadData.getThreadVideoInfo().video_url);
            this.a.k.setData(threadData);
            if (this.a.I3()) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.k.R0(absVideoPbFragment.f35141e.getCurrentItem() == 0);
            } else {
                this.a.k.R0(false);
            }
            if (z) {
                this.a.k.startPlay();
                this.a.k.u0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements c.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public f1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.o0.w.b
        public void onAction(c.a.o0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f11499c;
                if (obj instanceof c.a.o0.s.c.u) {
                    if (((c.a.o0.s.c.u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((c.a.o0.s.c.u) aVar.f11499c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.G0 == null) {
                            this.a.G0 = new PermissionJudgePolicy();
                        }
                        this.a.G0.clearRequestPermissionList();
                        this.a.G0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.G0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                            return;
                        }
                        this.a.I0.h((c.a.o0.s.c.u) aVar.f11499c);
                        this.a.I0.z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements c.a.o0.w.y.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public g(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.o0.w.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.w2.m.f.c1 c1Var = this.a.F0;
                if (c1Var == null || c1Var.g() == null || !this.a.F0.g().d()) {
                    return !this.a.D2(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.F0.g().c());
                if (this.a.K0 != null && this.a.K0.b() != null && this.a.K0.b().x()) {
                    this.a.K0.b().v(this.a.F0.h());
                }
                this.a.F0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.w2.i.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.c.f f35149b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35150c;

        public g0(AbsVideoPbFragment absVideoPbFragment, c.a.p0.w2.i.f fVar, c.a.o0.s.c.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35150c = absVideoPbFragment;
            this.a = fVar;
            this.f35149b = fVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a == null || this.f35149b == null || this.f35150c.X0 == null) {
                return;
            }
            this.f35150c.X0.g(this.f35149b);
            this.f35150c.X0.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public g1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.a.p0.w2.m.f.c1 c1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (c1Var = this.a.F0) == null || c1Var.e() == null) {
                return;
            }
            if (!this.a.F0.e().e()) {
                this.a.F0.a(false);
            }
            this.a.F0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.J0 == null || this.a.J0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f35151b;

            public a(h hVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35151b = hVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.a) == null) {
                    return;
                }
                this.f35151b.a.Y3(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
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
            public final /* synthetic */ h a;

            public c(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
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

        public h(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
                    if (this.a.w() != null && this.a.w().S0() != null) {
                        statisticItem.param("fid", this.a.w().S0().m());
                    }
                    statisticItem.param("tid", this.a.w().k1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.T4();
                this.a.x4(z, postWriteCallBackData);
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
                        if (this.a.I0.B() || this.a.I0.D()) {
                            this.a.I0.z(false, postWriteCallBackData);
                        }
                        this.a.F0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.C0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f045f), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (l0Var != null || i == 227001) {
                            return;
                        }
                        this.a.E4(i, antiData, str);
                        return;
                    } else {
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
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.w() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.w().b0(postWriteCallBackData.getPostId());
                    if (this.a.I3() && this.a.j3() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.R0 = absVideoPbFragment.j3().S0();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.S0 = absVideoPbFragment2.j3().T0();
                        this.a.w().m2(this.a.R0, this.a.S0);
                    } else if (this.a.S2() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.R0 = absVideoPbFragment3.S2().U0();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.S0 = absVideoPbFragment4.S2().V0();
                        this.a.w().m2(this.a.R0, this.a.S0);
                    }
                }
                if (this.a.f35141e != null) {
                    if (this.a.I3()) {
                        this.a.f35141e.setCurrentItem(1);
                    } else {
                        this.a.f35141e.setCurrentItem(0);
                    }
                }
                this.a.N.F();
                this.a.F0.c();
                if (this.a.I0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                    absVideoPbFragment5.s4(absVideoPbFragment5.I0.C());
                }
                this.a.p3();
                this.a.G4(true);
                this.a.w().t1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.F4(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.w().w0()) {
                        c.a.p0.w2.i.f S0 = this.a.w().S0();
                        if (S0 != null && S0.O() != null && S0.O().getAuthor() != null && (userId = S0.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.w().E2()) {
                            this.a.z4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.w().E2()) {
                        this.a.z4();
                    }
                } else if (floor != null) {
                    if (this.a.I3() && this.a.j3() != null) {
                        this.a.j3().b1();
                    } else if (this.a.S2() != null) {
                        this.a.S2().e1();
                    }
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.v2(z2, writeData != null ? writeData.getContent() : "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public h0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.a.f35141e.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f35152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35153c;

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
                c.a.p0.w2.m.f.c1 c1Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (c1Var = this.a.f35153c.F0) == null || c1Var.g() == null) {
                    return;
                }
                if (!this.a.f35153c.F0.g().e()) {
                    this.a.f35153c.F0.b(false);
                }
                this.a.f35153c.F0.g().l(false);
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

        public h1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35153c = absVideoPbFragment;
            this.a = str;
            this.f35152b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = c.a.d.f.p.n.i(this.f35153c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f2 = c.a.d.f.p.n.f(this.f35153c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f2 = c.a.d.f.p.n.f(this.f35153c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f2);
                AbsVideoPbFragment absVideoPbFragment = this.f35153c;
                boolean z = true;
                int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                if (absVideoPbFragment.i3() != null) {
                    this.f35153c.i3().smoothScrollBy(0, i4);
                }
                if (this.f35153c.K0 != null) {
                    this.f35153c.I0.a().setVisibility(8);
                    this.f35153c.K0.o(this.a, this.f35152b, this.f35153c.k3(), (this.f35153c.w() == null || this.f35153c.w().S0() == null || this.f35153c.w().S0().O() == null || !this.f35153c.w().S0().O().isBjh()) ? false : false);
                    this.f35153c.K0.l(this.f35153c.V2());
                    c.a.o0.w.y.h b2 = this.f35153c.K0.b();
                    if (b2 != null && this.f35153c.w() != null && this.f35153c.w().S0() != null) {
                        b2.G(this.f35153c.w().S0().d());
                        b2.b0(this.f35153c.w().S0().O());
                    }
                    if (this.f35153c.F0.f() == null && this.f35153c.K0.b().t() != null) {
                        this.f35153c.K0.b().t().f(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.f35153c;
                        absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().h());
                        this.f35153c.K0.b().M(this.f35153c.j1);
                    }
                }
                this.f35153c.n3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public i(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.x0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements Observer<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public i0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable ThreadData threadData) {
            c.a.p0.w2.q.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (aVar = this.a.k) == null) {
                return;
            }
            aVar.U0(threadData);
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f35154b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35155c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C1885a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C1885a(a aVar) {
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
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (c1Var = this.a.a.f35155c.F0) == null || c1Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.f35155c.F0.g().e()) {
                        this.a.a.f35155c.F0.b(false);
                    }
                    this.a.a.f35155c.F0.g().l(false);
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
                int f2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = c.a.d.f.p.n.i(this.a.f35155c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f2 = c.a.d.f.p.n.f(this.a.f35155c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = i2 / 2;
                        f2 = c.a.d.f.p.n.f(this.a.f35155c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i3 = i2 - (i + f2);
                    AbsVideoPbFragment absVideoPbFragment = this.a.f35155c;
                    boolean z = true;
                    int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                    if (absVideoPbFragment.i3() != null) {
                        this.a.f35155c.i3().smoothScrollBy(0, i4);
                    }
                    if (this.a.f35155c.K0 != null) {
                        this.a.f35155c.I0.a().setVisibility(8);
                        z = (this.a.f35155c.w() == null || this.a.f35155c.w().S0() == null || this.a.f35155c.w().S0().O() == null || !this.a.f35155c.w().S0().O().isBjh()) ? false : false;
                        c.a.p0.w2.m.f.x xVar = this.a.f35155c.K0;
                        i1 i1Var = this.a;
                        xVar.o(i1Var.a, i1Var.f35154b, i1Var.f35155c.k3(), z);
                        this.a.f35155c.K0.l(this.a.f35155c.V2());
                        c.a.o0.w.y.h b2 = this.a.f35155c.K0.b();
                        if (b2 != null && this.a.f35155c.w() != null && this.a.f35155c.w().S0() != null) {
                            b2.G(this.a.f35155c.w().S0().d());
                            b2.b0(this.a.f35155c.w().S0().O());
                        }
                        if (this.a.f35155c.F0.f() == null && this.a.f35155c.K0.b().t() != null) {
                            this.a.f35155c.K0.b().t().f(new C1885a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.f35155c;
                            absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().h());
                            this.a.f35155c.K0.b().M(this.a.f35155c.j1);
                        }
                    }
                    this.a.f35155c.n3();
                }
            }
        }

        public i1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35155c = absVideoPbFragment;
            this.a = str;
            this.f35154b = str2;
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
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.I0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.s4(absVideoPbFragment.I0.C());
            }
            this.a.G4(false);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements Observer<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public j0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable ThreadData threadData) {
            c.a.p0.w2.q.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (aVar = this.a.k) == null) {
                return;
            }
            aVar.T0(threadData);
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public j1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null && this.a.w() != null && this.a.w().S0() != null && this.a.w().S0().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.w().S0().l().getId()).param("fname", this.a.w().S0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.w().S0().Q()).param("obj_param1", this.a.w.k));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.m()).param("obj_type", 2).param("fid", this.a.w().S0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.w().S0().Q()));
                }
                this.a.O4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null) {
                        if (!this.a.w.f20522h) {
                            if (this.a.w.m != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), this.a.w.m.mSid, this.a.w.m.mSsid, this.a.w.m.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.M3(absVideoPbFragment.w.j, this.a.w.i);
                        }
                        if (this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.w().S0().l().getId()).param("fname", this.a.w().S0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.w().S0().Q()).param("obj_param1", this.a.w.k);
                        if (this.a.w().S0().O() != null) {
                            ThreadData O = this.a.w().S0().O();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
                            AlaInfoData threadAlaInfo = O.getThreadAlaInfo();
                            String str = TiebaStatic.YYValues.YY_LIVE;
                            if (threadAlaInfo == null || !O.getThreadAlaInfo().isLegalYYLiveData()) {
                                if (this.a.w.m != null) {
                                    TiebaStaticHelper.addYYParam(param, this.a.w.m);
                                    calculateLiveType = YYLiveUtil.calculateLiveType(this.a.w.m);
                                } else {
                                    str = "";
                                }
                            } else {
                                TiebaStaticHelper.addYYParam(param, O.getThreadAlaInfo().mYyExtData);
                            }
                            param.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                            param.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        TiebaStatic.log(param);
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.m()).param("obj_type", 2).param("fid", this.a.w().S0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.w().S0().Q()));
                String i = this.a.w.i();
                if (TextUtils.isEmpty(i)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(i) && !URLUtil.isHttpsUrl(i)) {
                    Uri parse = Uri.parse(i);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.a.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{i});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.a.t1 != null && this.a.t1.onTouchEvent(motionEvent);
                }
                if (this.a.n1 == 1) {
                    if (!this.a.r1) {
                        this.a.Q4();
                        UtilHelper.showStatusBar(this.a.x(), this.a.x().getRootView());
                        this.a.r1 = true;
                        c.a.d.f.m.e.a().removeCallbacks(this.a.v1);
                        c.a.d.f.m.e.a().postDelayed(this.a.v1, 3000L);
                    }
                } else if (this.a.n1 == 2 && (this.a.r1 || this.a.J3())) {
                    this.a.P4();
                    UtilHelper.hideStatusBar(this.a.x(), this.a.x().getRootView());
                    this.a.r1 = false;
                    c.a.p0.w2.q.l.a aVar = this.a.k;
                    if (aVar != null) {
                        aVar.S0(false);
                    }
                }
                this.a.n1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.v4(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35156b;

        public l1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35156b = absVideoPbFragment;
            this.a = layoutParams;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f35156b.a5(this.a);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public m(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.n1 = 0;
                this.a.o1 = 0.0f;
                this.a.p1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            c.a.p0.w2.q.l.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.a.o1 += f2;
                this.a.p1 += f3;
                if (this.a.n1 == 0 && !this.a.q1 && (aVar = this.a.k) != null && !aVar.isFullScreen()) {
                    int height = this.a.m.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.a.p1) <= Math.abs(this.a.o1) || this.a.p1 > (-height) / 5) {
                        if (Math.abs(this.a.p1) > Math.abs(this.a.o1) && this.a.p1 > 0.0f && f3 > 0.0f) {
                            this.a.n1 = 2;
                        }
                    } else {
                        this.a.n1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbViewModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35157b;

        public m0(AbsVideoPbFragment absVideoPbFragment, VideoPbViewModel videoPbViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, videoPbViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35157b = absVideoPbFragment;
            this.a = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f35157b.I3() && (this.a.m() || this.f35157b.w().j1() == 1)) {
                    this.f35157b.f35141e.setCurrentItem(1);
                } else if (this.a.m() || this.f35157b.w().j1() == 0) {
                    this.f35157b.f35141e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f35157b.I3() && (this.a.m() || this.f35157b.w().j1() == 1)) {
                    this.f35157b.f35141e.setCurrentItem(1);
                } else if (this.a.m() || this.f35157b.w().j1() == 0) {
                    this.f35157b.f35141e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f35158b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f35159c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35160d;

        public m1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35160d = absVideoPbFragment;
            this.a = layoutParams;
            this.f35158b = layoutParams2;
            this.f35159c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.N1);
                this.a.height = floatValue;
                this.f35158b.height = (this.f35159c - AbsVideoPbFragment.N1) + floatValue;
                this.f35160d.v.setLayoutParams(this.a);
                this.f35160d.i.setLayoutParams(this.f35158b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.r1 && !this.a.J3()) {
                this.a.P4();
                UtilHelper.hideStatusBar(this.a.x(), this.a.x().getRootView());
                this.a.r1 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.I0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.K0 != null && this.a.K0.b() != null) {
                    this.a.K0.b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.n4(absVideoPbFragment.R);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements a.InterfaceC0810a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.o0.h.a.InterfaceC0810a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.y4();
                if (z && this.a.w() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.w().D2(z2);
                    if (this.a.w().S0() != null && (O = this.a.w().S0().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.w().E0()) {
                        this.a.Q3();
                    } else if (this.a.I3()) {
                        if (this.a.T2() != null) {
                            this.a.T2().N0();
                        }
                        if (this.a.j3() != null) {
                            this.a.j3().b1();
                        }
                    } else if (this.a.S2() != null) {
                        this.a.S2().e1();
                    }
                    if (z2) {
                        if (this.a.P != null) {
                            if (this.a.P.f() == null || this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().O() == null || this.a.w().S0().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f2 = this.a.P.f();
                            MetaData author = this.a.w().S0().O().getAuthor();
                            if (f2 != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.N.A0(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00cd);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cc));
                            }
                        }
                        this.a.u2();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f80));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1486));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public o(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.w() != null) {
                    switch (this.a.T.getLoadDataMode()) {
                        case 0:
                            this.a.w().t1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.L2(bVar, (bVar.f36159e != 1002 || bVar.f36160f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.M2(1, dVar.a, dVar.f36163b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.N2(absVideoPbFragment.T.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.M2(absVideoPbFragment2.T.getLoadDataMode(), gVar.a, gVar.f36174b, false);
                            this.a.N.f0(gVar.f36175c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.M2(absVideoPbFragment3.T.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.f35139c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public o1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.v.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public p(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.a.M0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public p0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.f35139c, 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.f35139c, j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f35161b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f35162c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35163d;

        public p1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35163d = absVideoPbFragment;
            this.a = layoutParams;
            this.f35161b = layoutParams2;
            this.f35162c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.N1);
                this.a.height = floatValue;
                this.f35161b.height = this.f35162c + floatValue;
                this.f35163d.v.setLayoutParams(this.a);
                this.f35163d.i.setLayoutParams(this.f35161b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements b.InterfaceC1370b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public q(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class q0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public q0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                boolean z = true;
                if (i == 0) {
                    if (this.a.S2() != null) {
                        this.a.S2().i1(false);
                    } else if (this.a.I3() && this.a.j3() != null) {
                        this.a.j3().e1(false);
                    }
                    if (this.a.T2() != null) {
                        this.a.T2().S0(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.B4(absVideoPbFragment.T2().K0() == 0 ? 8 : 0);
                        this.a.i0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    c.a.p0.w2.q.l.a aVar = this.a.k;
                    if (aVar != null) {
                        aVar.R0(z);
                    }
                    this.a.j4();
                    if (this.a.w() != null && this.a.w().S0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.w().k1()).param("fid", this.a.w().S0().m()));
                    }
                } else {
                    if (this.a.T2() != null) {
                        this.a.T2().S0(false);
                    }
                    if (this.a.S2() != null) {
                        this.a.S2().i1(true);
                        int a1 = this.a.S2().a1();
                        int Y0 = this.a.S2().Y0();
                        if (a1 != 0) {
                            this.a.B4(8);
                            this.a.S2().s1(0);
                        } else if (Y0 != 0) {
                            this.a.S2().s1(8);
                            this.a.B4(0);
                        } else {
                            this.a.S2().s1(8);
                            this.a.B4(8);
                        }
                    } else if (this.a.j3() != null) {
                        this.a.j3().e1(true);
                        int Y02 = this.a.j3().Y0();
                        int W0 = this.a.j3().W0();
                        if (Y02 != 0) {
                            this.a.B4(8);
                            this.a.j3().m1(0);
                        } else if (W0 != 0) {
                            this.a.j3().m1(8);
                            this.a.B4(0);
                        } else {
                            this.a.j3().m1(8);
                            this.a.B4(8);
                        }
                        this.a.i0.setVisibility(0);
                    }
                    c.a.p0.w2.q.l.a aVar2 = this.a.k;
                    if (aVar2 != null) {
                        aVar2.R0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.w() != null && this.a.w().S0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.w().k1()).param("fid", this.a.w().S0().m()));
                    }
                }
                this.a.f35142f.d(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public q1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.Y4();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public r(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.s.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35164b;

        public r0(AbsVideoPbFragment absVideoPbFragment, c.a.o0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35164b = absVideoPbFragment;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.f35164b.X0.setHomePbFloatLastCloseTime();
                this.f35164b.s3();
                this.f35164b.X0.u(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public r1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ s f35165b;

            public a(s sVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35165b = sVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.a) == null) {
                    return;
                }
                this.f35165b.a.Y3(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
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
            public final /* synthetic */ s a;

            public c(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
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

        public s(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.o0.s.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.w() != null && this.a.w().S0() != null) {
                        statisticItem.param("fid", this.a.w().S0().m());
                    }
                    if (this.a.w() != null) {
                        statisticItem.param("tid", this.a.w().k1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.p0.w2.m.f.c1 c1Var = this.a.F0;
                    if (c1Var != null) {
                        c1Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.o0.s.h.c.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.C0;
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
                AbsVideoPbFragment absVideoPbFragment = this.a;
                if (absVideoPbFragment.F0 == null) {
                    return;
                }
                if (absVideoPbFragment.K0 != null && this.a.K0.b() != null && this.a.K0.b().x()) {
                    this.a.K0.b().v(postWriteCallBackData);
                }
                this.a.F0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements FallingView.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public s0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K4();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K.setTag(Boolean.FALSE);
                if (this.a.X0 == null) {
                    return;
                }
                this.a.X0.setAutoCompleteShown(false);
                if (this.a.X0.getVisibility() == 0) {
                    this.a.X0.setTag(this.a.K);
                    this.a.X0.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements c.a.d.f.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public s1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class t implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarkData f35166b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f35167c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35168d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35168d = absVideoPbFragment;
            this.a = markData;
            this.f35166b = markData2;
            this.f35167c = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f35168d.P != null) {
                    if (this.f35168d.P.e()) {
                        this.f35168d.P.d();
                        this.f35168d.P.h(false);
                    }
                    this.f35168d.P.i(this.a);
                    this.f35168d.P.h(true);
                    this.f35168d.P.a();
                }
                this.f35166b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f35166b);
                this.f35168d.a.setResult(-1, intent);
                this.f35167c.dismiss();
                this.f35168d.U4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public t0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.w().S0().Q()));
                        this.a.w.l = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.a.N4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements c.a.d.f.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public t1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f35169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35170c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35170c = absVideoPbFragment;
            this.a = markData;
            this.f35169b = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.f35170c.a.setResult(-1, intent);
                this.f35169b.dismiss();
                this.f35170c.U4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public u0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.K2(false);
                this.a.b4();
                if (this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().O() == null || this.a.w().S0().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.w().l1()).param("fid", this.a.w().S0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w().k1()).param("fid", this.a.w().S0().m()).param("obj_locate", 1).param("uid", this.a.w().S0().O().getAuthor().getUserId()));
                if (this.a.F3()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.w().getForumId());
                    statisticItem.param("tid", this.a.w().k1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.W2());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.V2());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements c.a.d.f.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public u1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class v implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public v(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h0 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.i0.getLayoutParams();
            layoutParams.height = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.a.i0.setLayoutParams(layoutParams);
            if (this.a.I3() && this.a.f35140d != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.f35140d.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.O1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.O1);
                }
                this.a.f35140d.setLayoutParams(layoutParams2);
                this.a.f35141e.setScrollable(true);
            }
            this.a.j4();
            if (this.a.T2() != null) {
                this.a.T2().N0();
            }
            if (this.a.S2() != null) {
                this.a.S2().e1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements c.a.d.f.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public v1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public w(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public w0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.q3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements c.a.d.f.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public w1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class x implements c.a.o0.w.y.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public x(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public x0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.j4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements Comparator<c.a.o0.t.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public x1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
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
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public y(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            String str2;
            int i2;
            int i3;
            String jumpUrlWithTid;
            boolean G2;
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.a.isAdded()) {
                Object tag = view.getTag(R.id.obfuscated_res_0x7f091e73);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view.setTag(R.id.obfuscated_res_0x7f091e73, null);
                } else if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.w().k1());
                    statisticItem2.param("fid", this.a.w().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.F3()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.w().getForumId());
                        statisticItem3.param("tid", this.a.w().k1());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.W2());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.V2());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (this.a.h0) {
                        this.a.h0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091e69);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.a.w() == null || this.a.w().S0() == null || this.a.L0 == null || postData.s() == null || postData.A() == 1 || !this.a.checkUpIsLogin()) {
                                return;
                            }
                            if (this.a.K0 != null) {
                                this.a.K0.c();
                            }
                            c.a.p0.w2.i.u uVar = new c.a.p0.w2.i.u();
                            uVar.A(this.a.w().S0().l());
                            uVar.E(this.a.w().S0().O());
                            uVar.C(postData);
                            this.a.L0.U(uVar);
                            this.a.L0.setPostId(postData.G());
                            this.a.P3(view, postData.s().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            c.a.p0.w2.o.a.b(this.a.w().S0(), postData, postData.h0, 8, 1);
                            if (this.a.I0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.s4(absVideoPbFragment.I0.C());
                            }
                        }
                    }
                } else {
                    if (view.getId() != R.id.obfuscated_res_0x7f09173e || this.a.getPageContext().getPageActivity() == null || this.a.w() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "post_id";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w().k1(), false, true);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w().k1(), true, false);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.w().getForumId());
                        statisticItem4.param("fname", this.a.w().s0());
                        statisticItem4.param("tid", this.a.w().k1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.I3() && this.a.j3() != null && this.a.j3().X0() != null && view == this.a.j3().X0()) || ((this.a.S2() != null && this.a.S2().Z0() != null && view == this.a.S2().Z0()) || view.getId() == R.id.obfuscated_res_0x7f0916e8)) {
                        if (!this.a.L && this.a.w().K1(true)) {
                            this.a.L = true;
                            if (this.a.I3()) {
                                if (this.a.j3() != null) {
                                    this.a.j3().l1();
                                    return;
                                }
                                return;
                            } else if (this.a.S2() != null) {
                                this.a.S2().r1();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    c.a.p0.w2.q.h.a aVar = this.a.N;
                    if (aVar != null && aVar.Q() != null && view == this.a.N.Q().g()) {
                        this.a.N.I();
                        return;
                    }
                    c.a.p0.w2.q.h.a aVar2 = this.a.N;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.a.N.Q().k()) && view.getId() != R.id.obfuscated_res_0x7f091635 && view.getId() != R.id.obfuscated_res_0x7f090260)) && view.getId() != R.id.obfuscated_res_0x7f0909e0 && view.getId() != R.id.obfuscated_res_0x7f091a6d) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        if (view == absVideoPbFragment2.p) {
                            if (absVideoPbFragment2.w() == null || this.a.w().S0() == null) {
                                return;
                            }
                            if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.a.w().S0().m());
                                statisticItem5.param("tid", this.a.w().k1());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            c.a.d.f.p.n.w(this.a.a, this.a.p);
                            this.a.a.finish();
                        } else if (view == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                            if (c.a.o0.c1.q.a()) {
                                return;
                            }
                            if (this.a.w() != null && this.a.w().S0() != null) {
                                ArrayList<PostData> F = this.a.w().S0().F();
                                if ((F == null || F.size() <= 0) && this.a.w().i1()) {
                                    c.a.d.f.p.n.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.w().k1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.w().getForumId()));
                                this.a.N.m0();
                                return;
                            }
                            c.a.d.f.p.n.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                        } else if (this.a.N.Q() != null && view == this.a.N.Q().m()) {
                            if (this.a.w() == null) {
                                return;
                            }
                            this.a.N.F();
                            if (c.a.d.f.p.l.z()) {
                                this.a.T4();
                                this.a.z4();
                                this.a.w().B2(1);
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                        } else {
                            c.a.p0.w2.q.h.a aVar3 = this.a.N;
                            if (aVar3 != null && aVar3.Q() != null && view == this.a.N.Q().k()) {
                                this.a.N.I();
                                return;
                            }
                            c.a.p0.w2.q.h.a aVar4 = this.a.N;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.a.N.Q().s()) || view.getId() == R.id.obfuscated_res_0x7f091725 || view.getId() == R.id.obfuscated_res_0x7f091723)) {
                                this.a.N.F();
                                if (c.a.d.f.p.l.z()) {
                                    if (!this.a.L) {
                                        this.a.T4();
                                        this.a.z4();
                                        this.a.N.J0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.a.w().g1()));
                                    return;
                                }
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                return;
                            }
                            c.a.p0.w2.q.h.a aVar5 = this.a.N;
                            if (aVar5 != null && aVar5.Q() != null && view == this.a.N.Q().r()) {
                                if (this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().O() == null) {
                                    return;
                                }
                                this.a.N.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                absVideoPbFragment3.N.U(absVideoPbFragment3.w().S0().O().getFirstPostId());
                            } else if (view.getId() == R.id.obfuscated_res_0x7f0916b4) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                c.a.p0.w2.q.h.a aVar6 = this.a.N;
                                if (aVar6 != null) {
                                    aVar6.w0(sparseArray);
                                }
                            } else {
                                c.a.p0.w2.q.h.a aVar7 = this.a.N;
                                if (aVar7 != null && aVar7.Q() != null && view == this.a.N.Q().p()) {
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
                                    this.a.N.J();
                                    return;
                                }
                                c.a.p0.w2.q.h.a aVar8 = this.a.N;
                                if (aVar8 != null && aVar8.Q() != null && view == this.a.N.Q().q()) {
                                    this.a.N.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    absVideoPbFragment4.N.G0(absVideoPbFragment4.F1);
                                    return;
                                }
                                c.a.p0.w2.q.h.a aVar9 = this.a.N;
                                if (aVar9 != null && aVar9.Q() != null && view == this.a.N.Q().j()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.w().k1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.N.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                c.a.p0.w2.q.h.a aVar10 = this.a.N;
                                if (aVar10 != null && (view == aVar10.M() || (this.a.N.Q() != null && (view == this.a.N.Q().n() || view == this.a.N.Q().o())))) {
                                    if (!c.a.d.f.p.l.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                        return;
                                    } else if ((this.a.w() == null && this.a.w().S0() == null) || this.a.T.R()) {
                                        return;
                                    } else {
                                        this.a.N.F();
                                        if (this.a.N.Q() != null && view == this.a.N.Q().o()) {
                                            i3 = this.a.w().S0().O().getIs_top() == 1 ? 5 : 4;
                                        } else if (this.a.N.Q() != null && view == this.a.N.Q().n()) {
                                            i3 = this.a.w().S0().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view == this.a.N.M() ? 2 : 0;
                                        }
                                        ForumData l = this.a.w().S0().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String id2 = this.a.w().S0().O().getId();
                                        this.a.showProgressBar();
                                        this.a.T.V(id, name, id2, i3, this.a.N.N());
                                        return;
                                    }
                                }
                                c.a.p0.w2.q.h.a aVar11 = this.a.N;
                                if (aVar11 != null && aVar11.Q() != null && view == this.a.N.Q().i()) {
                                    if (this.a.w() == null) {
                                        return;
                                    }
                                    if (!c.a.d.f.p.l.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                        return;
                                    }
                                    this.a.N.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> b3 = absVideoPbFragment5.b3(absVideoPbFragment5.w().S0(), this.a.w().i1(), 1);
                                    if (b3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.w().S0().l().getId(), this.a.w().S0().l().getName(), this.a.w().S0().O().getId(), String.valueOf(this.a.w().S0().U().getUserId()), (String) b3.get(R.id.obfuscated_res_0x7f091e76), (String) b3.get(R.id.obfuscated_res_0x7f091e77), (String) b3.get(R.id.obfuscated_res_0x7f091e79), (String) b3.get(R.id.obfuscated_res_0x7f091e78))));
                                    return;
                                }
                                c.a.p0.w2.q.h.a aVar12 = this.a.N;
                                if (aVar12 != null && aVar12.Q() != null && view == this.a.N.Q().c()) {
                                    if (!c.a.d.f.p.l.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> b32 = absVideoPbFragment6.b3(absVideoPbFragment6.w().S0(), this.a.w().i1(), 1);
                                    if (b32 != null) {
                                        this.a.N.j0(((Integer) b32.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) b32.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) b32.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) b32.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                                    }
                                    this.a.N.I();
                                    if (this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.w().S0().O();
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", O.getId());
                                    statisticItem6.param("fid", O.getFid());
                                    statisticItem6.param("fname", O.getForum_name());
                                    TiebaStatic.log(statisticItem6);
                                    StatisticItem statisticItem7 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem7.param("tid", O.getId());
                                    statisticItem7.param("fid", O.getFid());
                                    statisticItem7.param("fname", O.getForum_name());
                                    statisticItem7.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem7);
                                    return;
                                }
                                c.a.p0.w2.q.h.a aVar13 = this.a.N;
                                if (aVar13 != null && aVar13.Q() != null && view == this.a.N.Q().h()) {
                                    if (this.a.w() == null) {
                                        return;
                                    }
                                    if (!c.a.d.f.p.l.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                    SparseArray<Object> b33 = absVideoPbFragment7.b3(absVideoPbFragment7.w().S0(), this.a.w().i1(), 1);
                                    if (b33 != null) {
                                        if (StringUtils.isNull((String) b33.get(R.id.obfuscated_res_0x7f091e6a))) {
                                            this.a.N.g0(((Integer) b33.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) b33.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) b33.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) b33.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                                        } else {
                                            this.a.N.h0(((Integer) b33.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) b33.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) b33.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) b33.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue(), (String) b33.get(R.id.obfuscated_res_0x7f091e6a));
                                        }
                                    }
                                    this.a.N.I();
                                } else if (view.getId() != R.id.obfuscated_res_0x7f091dc6 && view.getId() != R.id.obfuscated_res_0x7f091dc4 && view.getId() != R.id.obfuscated_res_0x7f0916b6 && view.getId() != R.id.obfuscated_res_0x7f09155d && view.getId() != R.id.obfuscated_res_0x7f091715) {
                                    if (view.getId() != R.id.obfuscated_res_0x7f091713 && view.getId() != R.id.obfuscated_res_0x7f0918b2 && view.getId() != R.id.obfuscated_res_0x7f0916b0) {
                                        if (view.getId() != R.id.obfuscated_res_0x7f0916a3 && view.getId() != R.id.obfuscated_res_0x7f090678) {
                                            if (view.getId() == R.id.obfuscated_res_0x7f0916a9) {
                                                this.a.m3(true);
                                                return;
                                            } else if (view.getId() != R.id.obfuscated_res_0x7f0916a5 && view.getId() != R.id.obfuscated_res_0x7f091fac) {
                                                if (view.getId() == R.id.obfuscated_res_0x7f0921e9) {
                                                    if (this.a.R0 >= 0) {
                                                        if (this.a.w() != null) {
                                                            this.a.w().i2();
                                                        }
                                                        if (this.a.I3() && this.a.w() != null && this.a.j3() != null && this.a.j3().C0() != null) {
                                                            this.a.j3().C0().f(this.a.w().S0());
                                                        } else if (this.a.S2() != null && this.a.S2().C0() != null) {
                                                            this.a.S2().C0().q(this.a.w().S0());
                                                        }
                                                        this.a.R0 = 0;
                                                        this.a.S0 = Integer.MIN_VALUE;
                                                        if (this.a.I3() && this.a.w() != null && this.a.j3() != null) {
                                                            this.a.j3().h1(this.a.w().L0(), this.a.w().K0());
                                                            this.a.w().m2(0, 0);
                                                            return;
                                                        } else if (this.a.w() == null || this.a.S2() == null) {
                                                            return;
                                                        } else {
                                                            this.a.S2().m1(this.a.w().L0(), this.a.w().K0());
                                                            this.a.w().m2(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.a.w() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.a.w().k1());
                                                    statisticItem8.param("fid", this.a.w().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else if (view.getId() == R.id.obfuscated_res_0x7f0916de) {
                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f133a);
                                                        String q = c.a.o0.r.j0.b.k().q("tail_link", "");
                                                        if (!StringUtils.isNull(q)) {
                                                            TiebaStatic.log("c10056");
                                                            c.a.o0.l.a.q(view.getContext(), string, q, true, true, true);
                                                        }
                                                        this.a.j4();
                                                        return;
                                                    }
                                                    return;
                                                } else if (view.getId() == R.id.obfuscated_res_0x7f091007) {
                                                    this.a.j4();
                                                    return;
                                                } else if (this.a.N.Q() != null && view == this.a.N.Q().d()) {
                                                    this.a.N.F();
                                                    if (this.a.w() != null) {
                                                        this.a.t.f(this.a.w().k1());
                                                    }
                                                    if (this.a.w() == null || !this.a.w().isPrivacy()) {
                                                        this.a.t.b();
                                                        int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().Q() == null || !this.a.w().S0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                        if (this.a.w() == null || this.a.w().S0() == null) {
                                                            return;
                                                        }
                                                        this.a.t.d(3, i5, this.a.w().S0().Q());
                                                        return;
                                                    }
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ec9);
                                                    if (this.a.w().S0() != null) {
                                                        this.a.t.d(3, 3, this.a.w().S0().Q());
                                                        return;
                                                    }
                                                    return;
                                                } else if (view.getId() == R.id.obfuscated_res_0x7f0916b8 || view.getId() == R.id.obfuscated_res_0x7f09170d) {
                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                    statisticItem9.param("tid", this.a.w().k1());
                                                    statisticItem9.param("fid", this.a.w().getForumId());
                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem9.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem9);
                                                    if (this.a.F3()) {
                                                        StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem10.param("fid", this.a.w().getForumId());
                                                        statisticItem10.param("tid", this.a.w().k1());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param(str, this.a.W2());
                                                        statisticItem10.param("obj_source", 1);
                                                        statisticItem10.param("obj_type", 2);
                                                        statisticItem10.param("obj_locate", this.a.V2());
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    this.a.N.o0(false);
                                                    this.a.N.P().onLongClick(view);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                String str3 = str;
                                                if (this.a.w() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                    if (absVideoPbFragment8.N == null || absVideoPbFragment8.f35141e == null || this.a.w().S0() == null || this.a.w().S0().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    c.a.p0.w2.i.f S0 = this.a.w().S0();
                                                    int reply_num = S0.O().getReply_num();
                                                    int currentItem = this.a.f35141e.getCurrentItem();
                                                    if (reply_num == 0) {
                                                        if (this.a.I3() && currentItem == 0) {
                                                            this.a.f35141e.setCurrentItem(1);
                                                        }
                                                        this.a.K2(false);
                                                        this.a.b4();
                                                        return;
                                                    }
                                                    if (this.a.I3() && currentItem == 0) {
                                                        this.a.f35141e.setCurrentItem(1);
                                                        str2 = "obj_source";
                                                    } else if ((this.a.I3() && this.a.j3() == null) || this.a.S2() == null || this.a.i3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.w().k1()).param("fid", this.a.w().S0().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int i6 = (int) (c.a.d.f.p.n.i(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView i32 = this.a.i3();
                                                        if (i32 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = i32.canScrollVertically(1);
                                                        boolean canScrollVertically2 = i32.canScrollVertically(-1);
                                                        AppBarLayout appBarLayout = this.a.i;
                                                        str2 = "obj_source";
                                                        if (appBarLayout != null) {
                                                            appBarLayout.setExpanded(false, true);
                                                        }
                                                        if (i32.getLayoutManager() == null || !(i32.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) i32.getLayoutManager();
                                                        if (!canScrollVertically2 && canScrollVertically) {
                                                            if (this.a.P0 == -1 && this.a.Q0 == Integer.MIN_VALUE) {
                                                                return;
                                                            }
                                                            if (this.a.P0 <= 3 && (this.a.P0 != 3 || this.a.Q0 >= (-i6))) {
                                                                if (this.a.P0 < 2) {
                                                                    if (this.a.P0 != 1) {
                                                                        i32.smoothScrollBy(0, -this.a.Q0);
                                                                    } else {
                                                                        int i7 = i6 / 4;
                                                                        linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i7);
                                                                        i32.smoothScrollBy(0, i7);
                                                                    }
                                                                } else {
                                                                    int i8 = i6 / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i8);
                                                                    i32.smoothScrollBy(0, i8);
                                                                }
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i6);
                                                                i32.smoothScrollBy(0, i6);
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        } else {
                                                            int firstVisiblePosition = i32.getFirstVisiblePosition();
                                                            View childAt = i32.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.P0 = firstVisiblePosition;
                                                            this.a.Q0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i6) || i32.getCount() < 6)) {
                                                                i32.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                i32.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        }
                                                        TiebaStatic.log(param);
                                                        c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
                                                        StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                        statisticItem11.param("obj_type", i2);
                                                        statisticItem11.param("obj_locate", 4);
                                                        statisticItem11.param("tid", this.a.w().k1());
                                                        statisticItem11.param("nid", S0.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                    }
                                                    if (this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().O() == null || this.a.w().S0().O().getAuthor() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w().k1()).param("fid", this.a.w().S0().m()).param("obj_locate", 2).param("uid", this.a.w().S0().O().getAuthor().getUserId()));
                                                    if (this.a.F3()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem12.param("fid", this.a.w().getForumId());
                                                        statisticItem12.param("tid", this.a.w().k1());
                                                        statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem12.param(str3, this.a.W2());
                                                        statisticItem12.param(str2, 1);
                                                        statisticItem12.param("obj_type", 12);
                                                        statisticItem12.param("obj_locate", this.a.V2());
                                                        TiebaStatic.log(statisticItem12);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        String str4 = str;
                                        if (!c.a.d.f.p.l.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                        if (absVideoPbFragment9.N == null || absVideoPbFragment9.w() == null) {
                                            return;
                                        }
                                        if (this.a.I3() && this.a.j3() == null) {
                                            return;
                                        }
                                        if (this.a.I3() || this.a.S2() != null) {
                                            this.a.N.F();
                                            if (view.getId() != R.id.obfuscated_res_0x7f0916a3 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.B2(11009) || this.a.w() == null) {
                                                    return;
                                                }
                                                this.a.R3();
                                                if (this.a.w().S0() != null && this.a.w().S0().O() != null && this.a.w().S0().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.w().k1()).param("fid", this.a.w().S0().m()).param("obj_locate", 3).param("uid", this.a.w().S0().O().getAuthor().getUserId()));
                                                    if (this.a.F3()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.a.w().getForumId());
                                                        statisticItem13.param("tid", this.a.w().k1());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str4, this.a.W2());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.a.V2());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.a.w().S0().O() == null || this.a.w().S0().O().getAuthor() == null || this.a.w().S0().O().getAuthor().getUserId() == null || this.a.P == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                int S = absVideoPbFragment10.N.S(absVideoPbFragment10.w().S0());
                                                ThreadData O2 = this.a.w().S0().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.w().k1()).param("obj_locate", 1).param("obj_id", this.a.w().S0().O().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", S).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.z = view;
                                            return;
                                        }
                                        return;
                                    }
                                    String str5 = str;
                                    if (this.a.w() == null) {
                                        return;
                                    }
                                    if (view.getId() == R.id.obfuscated_res_0x7f091713) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.w().k1());
                                        statisticItem14.param("fid", this.a.w().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view.getId() == R.id.obfuscated_res_0x7f0918b2) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view;
                                            return;
                                        }
                                    } else if (view.getId() == R.id.obfuscated_res_0x7f091713 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.y = view;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2.get(R.id.obfuscated_res_0x7f091e85) instanceof PostData) {
                                            PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e85);
                                            if (view.getId() == R.id.obfuscated_res_0x7f091713 && (statisticItem = postData2.i0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view.getId() == R.id.obfuscated_res_0x7f0918b2 || view.getId() == R.id.obfuscated_res_0x7f0916b0) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.w().l1()).param("fid", this.a.w().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.w() == null || this.a.w().S0() == null || this.a.L0 == null || postData2.s() == null || postData2.A() == 1) {
                                                return;
                                            }
                                            if (this.a.K0 != null) {
                                                this.a.K0.c();
                                            }
                                            if (this.a.U0 && postData2.P() != null && postData2.P().size() != 0) {
                                                this.a.R4(postData2, null, true, false);
                                                return;
                                            }
                                            c.a.p0.w2.i.u uVar2 = new c.a.p0.w2.i.u();
                                            uVar2.A(this.a.w().S0().l());
                                            uVar2.E(this.a.w().S0().O());
                                            uVar2.C(postData2);
                                            this.a.L0.U(uVar2);
                                            this.a.L0.setPostId(postData2.G());
                                            this.a.P3(view, postData2.s().getUserId(), "", postData2);
                                            if (this.a.I0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                absVideoPbFragment11.s4(absVideoPbFragment11.I0.C());
                                            }
                                        }
                                    }
                                } else {
                                    String str6 = str;
                                    if (view.getId() == R.id.obfuscated_res_0x7f09155d) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.a.w().k1());
                                        statisticItem15.param("fid", this.a.w().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.a.F3()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.w().getForumId());
                                            statisticItem16.param("tid", this.a.w().k1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str6, this.a.W2());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.a.V2());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view.getId() == R.id.obfuscated_res_0x7f0916b6 || view.getId() == R.id.obfuscated_res_0x7f091715) && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        this.a.x = view;
                                        return;
                                    }
                                    if (view.getId() == R.id.obfuscated_res_0x7f0916b6 && this.a.F3()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.a.w().getForumId());
                                        statisticItem17.param("tid", this.a.w().k1());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str6, this.a.W2());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.a.V2());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.w().S0().m()));
                                    } else if (this.a.w() == null || this.a.w().S0() == null) {
                                    } else {
                                        c.a.p0.w2.q.h.a aVar14 = this.a.N;
                                        if (aVar14 != null) {
                                            aVar14.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e85);
                                        PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e86);
                                        if (postData3 == null) {
                                            return;
                                        }
                                        if (postData3.E() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData3.i0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view.getId() == R.id.obfuscated_res_0x7f09155d) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view.getId() == R.id.obfuscated_res_0x7f0916b6) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.a.T4();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.a.R4(postData3, postData4, false, true);
                                        } else {
                                            this.a.R4(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!c.a.d.f.p.l.z()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.a.N.F();
                        if (!this.a.L) {
                            this.a.T4();
                            this.a.z4();
                            if (view.getId() == R.id.obfuscated_res_0x7f091635) {
                                G2 = this.a.w().G2(true, this.a.W2());
                            } else {
                                G2 = view.getId() == R.id.obfuscated_res_0x7f090260 ? this.a.w().G2(false, this.a.W2()) : this.a.w().F2(this.a.W2());
                            }
                            view.setTag(Boolean.valueOf(G2));
                            if (G2) {
                                this.a.J4();
                                i4 = 1;
                                this.a.L = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                            return;
                        }
                        view.setTag(Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public y0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.L0.P(postData);
                if (this.a.S2() != null) {
                    this.a.S2().e1();
                } else if (this.a.I3() && this.a.j3() != null) {
                    this.a.j3().b1();
                }
                this.a.K0.c();
                this.a.J0.q();
                this.a.G4(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements c.a.o0.w.y.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public y1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.o0.w.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.w2.m.f.c1 c1Var = this.a.F0;
                if (c1Var == null || c1Var.e() == null || !this.a.F0.e().d()) {
                    return !this.a.D2(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.F0.e().c());
                if (this.a.I0 != null && (this.a.I0.B() || this.a.I0.D())) {
                    this.a.I0.z(false, this.a.F0.h());
                }
                this.a.F0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends c.a.o0.c1.k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35171b;

        public z(AbsVideoPbFragment absVideoPbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35171b = absVideoPbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel w = this.f35171b.w();
                if (w != null) {
                    w.p2(this.a);
                }
                return c.a.p0.w2.m.f.n1.b.d(this.f35171b.R2(), 2, w);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public z0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.a.N.o0(true);
                return this.a.N.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z1(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.w() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.I0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.s4(absVideoPbFragment.I0.C());
            }
            this.a.j4();
            this.a.N.F();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1317086303, "Lcom/baidu/tieba/pb/videopb/AbsVideoPbFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1317086303, "Lcom/baidu/tieba/pb/videopb/AbsVideoPbFragment;");
                return;
            }
        }
        N1 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        O1 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    }

    public AbsVideoPbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35138b = 0L;
        this.u = false;
        this.B = new k(this);
        this.L = false;
        this.P = null;
        this.S = null;
        this.T = null;
        this.h0 = false;
        this.k0 = null;
        this.n0 = null;
        this.w0 = false;
        this.x0 = null;
        this.y0 = false;
        this.z0 = false;
        this.A0 = false;
        this.B0 = false;
        this.N0 = new int[2];
        this.P0 = -1;
        this.Q0 = Integer.MIN_VALUE;
        this.R0 = 0;
        this.S0 = Integer.MIN_VALUE;
        this.T0 = false;
        this.U0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.V0 = new v(this);
        this.Y0 = new c1(this);
        this.Z0 = new n1(this);
        this.a1 = new y1(this);
        this.b1 = new z1(this, 2004016);
        this.c1 = new a2(this, 2004007);
        this.d1 = new a(this, 2921391);
        this.e1 = new b(this, 2016450);
        this.f1 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.g1 = new d(this, 2001426);
        this.h1 = new e(this, 2001427);
        this.i1 = new f(this, 2001428);
        this.j1 = new g(this);
        this.k1 = new h(this);
        this.l1 = new i(this);
        this.m1 = new j(this, 2004008);
        this.n1 = 0;
        this.r1 = true;
        this.s1 = new l(this);
        this.u1 = new m(this);
        this.v1 = new n(this);
        this.y1 = new o(this);
        this.z1 = new p(this);
        this.A1 = new q(this);
        this.B1 = new s(this);
        this.C1 = new x(this);
        this.D1 = new y(this);
        this.E1 = new b0(this);
        this.F1 = new c0(this);
        this.G1 = new d0(this, 2001332);
        this.H1 = new e0(this, 2016528);
        this.I1 = new o0(this, 2001440);
        this.J1 = new p0(this);
        this.K1 = new v0(this, 2921509);
        this.L1 = new z0(this);
        this.M1 = new a1(this);
        this.u0 = new b2(this, null);
    }

    public final boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel w2 = w();
            if (w2 == null || w2.S0() == null) {
                return false;
            }
            ThreadData O = w2.S0().O();
            w2.S0().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public void A3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.j();
        c.a.o0.w.y.e eVar = this.I0;
        if (eVar != null) {
            eVar.P();
        }
        n3();
    }

    public final void A4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || w() == null) {
            return;
        }
        int b12 = w().b1();
        if (i2 == 5) {
            w().x2(2);
        } else if (i2 == 6) {
            w().x2(3);
        } else if (i2 != 7) {
            w().x2(1);
        } else {
            w().x2(4);
        }
        int b13 = w().b1();
        if (b12 == 4 || b13 == 4) {
            V3();
        }
    }

    public final boolean B2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void B3(c.a.p0.w2.i.f fVar) {
        c.a.o0.s.c.f pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || this.W0 == null || fVar == null || fVar.g() == 3 || F3()) {
            return;
        }
        if (fVar.k0()) {
            pbAdFloatViewItemData = fVar.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
            if (!RightFloatLayerView.k()) {
                s3();
                return;
            }
            if (this.X0 == null) {
                this.X0 = RightFloatLayerLottieView.F(pbAdFloatViewItemData, getContext());
                this.W0.removeAllViews();
                this.W0.addView(this.X0);
            }
            if ((this.K.getTag() instanceof Boolean) && !((Boolean) this.K.getTag()).booleanValue()) {
                this.X0.setAutoCompleteShown(false);
                this.X0.setTag(this.K);
                this.X0.c();
            }
            if (pbAdFloatViewItemData.a()) {
                return;
            }
            this.X0.setData(pbAdFloatViewItemData);
            this.X0.setLogoListener(new g0(this, fVar, pbAdFloatViewItemData));
            this.X0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
            return;
        }
        s3();
    }

    public void B4(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (view = this.f35143g) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if ((w() != null && w().S0().g0()) || this.C0 == null || w() == null || w().S0() == null || ThreadCardUtils.isSelf(w().S0().O()) || w().S0().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeInvokeEditor(w().S0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f35140d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.f35140d.setContainerLayoutParams(layoutParams);
            this.f35140d.setRectPaintColor(R.color.CAM_X0302);
            this.f35140d.C(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.f35140d.setIndicatorOffset(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.f35140d.setIndicatorOvershot(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.f35140d.setIndicatorMarginBottom(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f35140d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void C4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.u = z2;
        }
    }

    public boolean D2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.C0 == null || w() == null || w().S0() == null || ThreadCardUtils.isSelf(w().S0().O()) || w().S0().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeSend(w().S0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.p0.s0.b bVar = new c.a.p0.s0.b(getActivity());
            this.M0 = bVar;
            bVar.i(this.A1);
            this.q1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            z3();
            this.i = (AppBarLayout) this.f35139c.findViewById(R.id.obfuscated_res_0x7f090297);
            this.f35143g = this.f35139c.findViewById(R.id.obfuscated_res_0x7f091746);
            this.W0 = (FrameLayout) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091ab2);
            this.j = (VideoContainerLayout) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091734);
            c.a.p0.w2.q.l.a aVar = new c.a.p0.w2.q.l.a(getContext(), this.j);
            this.k = aVar;
            aVar.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.X0(this);
            this.k.V0(x().getRootView());
            this.k.W0(this.o);
            ((RelativeLayout) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091c0a)).setMinimumHeight(((int) Math.ceil((c.a.d.f.p.n.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.f35140d = (NewPagerSlidingTabBaseStrip) this.f35139c.findViewById(R.id.obfuscated_res_0x7f09174a);
            this.v = this.f35139c.findViewById(R.id.obfuscated_res_0x7f091741);
            this.f35141e = (CustomViewPager) this.f35139c.findViewById(R.id.obfuscated_res_0x7f09174c);
            this.f35144h = this.f35139c.findViewById(R.id.obfuscated_res_0x7f091007);
            this.A = (MaskView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0913b5);
            this.f35144h.setOnClickListener(this.D1);
            C3();
            y3();
            u3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f35142f = videoPbFragmentAdapter;
            this.f35141e.setAdapter(videoPbFragmentAdapter);
            this.f35140d.setViewPager(this.f35141e);
            this.f35140d.setOnPageChangeListener(new q0(this));
            this.M = this.f35139c.findViewById(R.id.obfuscated_res_0x7f0923ee);
            this.K = (FallingView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f09096d);
            r4();
            this.K.setAnimationListener(new s0(this));
            w3();
            v3();
            if (!this.q1 && this.r1) {
                P4();
                UtilHelper.hideStatusBar(x(), x().getRootView());
                this.r1 = false;
            }
            if (I3()) {
                return;
            }
            this.f35140d.getLayoutParams().height = 0;
        }
    }

    public final void D4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            this.I0.f0(z2);
            this.I0.i0(z2);
            this.I0.p0(z2);
        }
    }

    public void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!checkUpIsLogin()) {
                if (w() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", w().getForumId()));
                }
            } else if (C2()) {
                c.a.o0.w.y.e eVar = this.I0;
                if (eVar != null && (eVar.B() || this.I0.D())) {
                    this.I0.z(false, null);
                    return;
                }
                if (this.J0 != null) {
                    A3();
                    this.u0.a = false;
                    if (this.J0.n(2) != null) {
                        c.a.p0.a4.j0.a.c(getPageContext(), (View) this.J0.n(2).k, false, null);
                    }
                }
                n3();
            }
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.l == null) {
            this.l = new c.a.p0.w2.q.f(getBaseFragmentActivity(), this.j);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? c.a.d.f.p.n.r(x()) : 0;
            Rect rect = new Rect(0, r2, c.a.d.f.p.n.k(getContext()), this.j.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.h(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (I3() && (videoPbViewModel.m() || w().j1() == 1)) {
                this.f35141e.setCurrentItem(1);
            } else if (videoPbViewModel.m() || w().j1() == 0) {
                this.f35141e.setCurrentItem(0);
            }
        }
    }

    public final void E4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                c.a.p0.w2.q.h.a aVar = this.N;
                if (aVar != null) {
                    aVar.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (w().y0() || w().B0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", w().k1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, w().k1()));
            if (V4()) {
                this.a.finish();
            }
        }
    }

    public abstract boolean F3();

    public final void F4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                c.a.o0.s.h.c.c(getPageContext(), postWriteCallBackData, 2);
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f10e5);
            }
            if (StringUtils.isNull(colorMsg)) {
                c.a.d.f.p.n.N(getPageContext().getPageActivity(), errorString);
                return;
            }
            String str = errorString + " " + preMsg + colorMsg;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0305));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, errorString.length() + preMsg.length() + 1, str.length(), 17);
            c.a.d.f.p.n.I(getPageContext().getPageActivity(), str, spannableString, 3000);
            return;
        }
        if (w() != null && !w().G0()) {
            antiData.setBlock_forum_name(w().S0().l().getName());
            antiData.setBlock_forum_id(w().S0().l().getId());
            antiData.setUser_name(w().S0().U().getUserName());
            antiData.setUser_id(w().S0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void G2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            List<PostData> list = w().S0().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).P().size()) {
                        break;
                    } else if (bVar.f36161g.equals(list.get(i2).P().get(i3).G())) {
                        list.get(i2).P().remove(i3);
                        list.get(i2).k();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).m(bVar.f36161g);
            }
            if (z2) {
                if (S2() != null) {
                    S2().e1();
                } else if (I3() && j3() != null) {
                    j3().b1();
                }
            }
        }
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            EditorTools editorTools = this.J0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void G4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) || this.k0 == null) {
            return;
        }
        s4(this.I0.C());
        if (this.w0) {
            H4(z2);
        } else {
            o3(z2);
        }
        Z3();
        c4();
    }

    public void H2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (w().o0() != null) {
                        w().o0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.T.R()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e7f) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e7f)).booleanValue() : false;
                if (jSONArray != null) {
                    this.T.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.T.U(w().S0().l().getId(), w().S0().l().getName(), w().S0().O().getId(), str, intValue3, intValue2, booleanValue, w().S0().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    public abstract boolean H3();

    public void H4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) || this.k0 == null || (textView = this.n0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0500);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0.a = true;
    }

    public void I2(c.a.o0.r.t.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (w() == null || w().S0() == null || w().S0().O() == null || w().S0().l() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    H2((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (F3() || w() == null || !w().F1()) ? false : true : invokeV.booleanValue;
    }

    public final void I4(c.a.p0.w2.i.f fVar) {
        c.a.p0.w2.q.j.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) || (G = fVar.G()) == null || G.l) {
            return;
        }
        x2(G);
    }

    public void J2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                H2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            c.a.p0.w2.q.l.a aVar = this.k;
            return aVar != null && aVar.M0();
        }
        return invokeV.booleanValue;
    }

    public void J4() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (view = this.M) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void K2(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) || (appBarLayout = this.i) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r1 : invokeV.booleanValue;
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            FallingView fallingView = this.K;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.K) {
                this.X0.setTag(null);
                this.X0.setAutoCompleteShown(true);
                this.X0.d();
            }
        }
    }

    public final void L2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048609, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f36156b) ? bVar.f36156b : getString(R.string.obfuscated_res_0x7f0f0493);
            int i2 = 0;
            if (bVar.f36157c == 1211066) {
                hideProgressBar();
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f04d4, new r(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                M2(0, bVar.a, bVar.f36156b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.f36158d;
                if (i3 == 1) {
                    ArrayList<PostData> F = w().S0().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f36161g.equals(F.get(i2).G())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    w().S0().O().setReply_num(w().S0().O().getReply_num() - 1);
                    if (S2() != null) {
                        S2().e1();
                    } else if (I3() && j3() != null) {
                        j3().b1();
                    }
                } else if (i3 == 0) {
                    F2();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = w().S0().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).P().size()) {
                                break;
                            } else if (bVar.f36161g.equals(F2.get(i4).P().get(i5).G())) {
                                F2.get(i4).P().remove(i5);
                                F2.get(i4).k();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).m(bVar.f36161g);
                    }
                    if (z3) {
                        if (S2() != null) {
                            S2().e1();
                        } else if (I3() && j3() != null) {
                            j3().b1();
                        }
                    }
                    G2(bVar);
                }
            }
        }
    }

    public boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.p0.w2.q.l.a aVar = this.k;
            if (aVar == null) {
                return false;
            }
            return aVar.N0();
        }
        return invokeV.booleanValue;
    }

    public final void L4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            c.a.p0.w2.q.k.a.c(x(), R2(), i2);
        }
    }

    public void M2(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f11f1));
            } else if (z3) {
                if (c.a.d.f.p.m.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                }
                showToast(str);
            }
        }
    }

    public final void M3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || w() == null || c.a.d.f.p.m.isEmpty(w().k1())) {
            return;
        }
        c.a.o0.a.d.y().R(c.a.o0.a.c.X, c.a.d.f.m.b.g(w().k1(), 0L));
    }

    public final void N2(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048615, this, i2, gVar) == null) || gVar == null || w() == null || w().S0() == null || w().S0().O() == null) {
            return;
        }
        M2(this.T.getLoadDataMode(), gVar.a, gVar.f36174b, false);
        if (gVar.a) {
            this.y0 = true;
            if (i2 == 2 || i2 == 3) {
                this.z0 = true;
                this.A0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.z0 = false;
                this.A0 = true;
            }
            if (i2 == 2) {
                w().S0().O().setIs_good(1);
                w().q2(1);
            } else if (i2 == 3) {
                w().S0().O().setIs_good(0);
                w().q2(0);
            } else if (i2 == 4) {
                w().S0().O().setIs_top(1);
                w().r2(1);
            } else if (i2 == 5) {
                w().S0().O().setIs_top(0);
                w().r2(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f36174b)) {
                string = gVar.f36174b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f0cd9);
            }
            c.a.d.f.p.n.N(getPageContext().getPageActivity(), string);
        }
        if (I3()) {
            if (w().S0().O() == null || T2() == null) {
                return;
            }
            T2().U0();
        } else if (w().S0().O() == null || S2() == null) {
        } else {
            S2().k1();
        }
    }

    public /* synthetic */ void N3() {
        String k3;
        if (w() != null && w().x1()) {
            k3 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd);
        } else {
            k3 = k3();
        }
        if (!StringUtils.isNull(k3) && w() != null && w().S0() != null) {
            k3 = TbSingleton.getInstance().getAdVertiComment(w().S0().k0(), w().S0().l0(), k3);
        }
        c.a.o0.w.y.e eVar = this.I0;
        if (eVar != null) {
            eVar.k0(k3);
        }
        TextView textView = this.n0;
        if (textView != null) {
            textView.setText(k3);
        }
        G4(false);
        K4();
    }

    public final void N4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            X4();
        }
    }

    public final String O2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0d95);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + "W";
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + "W";
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.m0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.m0.setImageResource(0);
                this.m0.J(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.m0.setImageResource(R.drawable.obfuscated_res_0x7f081200);
        }
    }

    public final void O4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.v.setAlpha(0.0f);
            this.v.setVisibility(0);
            Z4(layoutParams);
        }
    }

    public c.a.o0.s.e.a P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.S : (c.a.o0.s.e.a) invokeV.objValue;
    }

    public final void P3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048622, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || A2() || !C2()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.N0);
            this.O0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.K0 != null && postData != null) {
            this.K0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f98), postData.s().getName_show(), postData.N() != null ? postData.N().toString() : ""));
        }
        if (w() != null && w().S0() != null && w().S0().g0()) {
            c.a.d.f.m.e.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        if (this.E0 == null) {
            c.a.p0.f1.i2.a.c cVar = new c.a.p0.f1.i2.a.c(getPageContext());
            this.E0 = cVar;
            cVar.j(1);
            this.E0.i(new i1(this, str, str2));
        }
        if (w() == null || w().S0() == null || w().S0().l() == null) {
            return;
        }
        this.E0.g(w().S0().l().getId(), c.a.d.f.m.b.g(w().k1(), 0L));
    }

    public final void P4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.x1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.x1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.x1.start();
        }
    }

    public LinearLayout Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l0 : (LinearLayout) invokeV.objValue;
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || w() == null) {
            return;
        }
        c.a.p0.w2.i.f S0 = w().S0();
        w().D2(true);
        c.a.o0.h.a aVar = this.P;
        if (aVar != null) {
            S0.E0(aVar.g());
        }
        if (I3()) {
            if (T2() != null) {
                T2().N0();
            }
            if (j3() != null) {
                j3().b1();
            }
        } else if (S2() != null) {
            S2().e1();
        }
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.w1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.w1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.w1.start();
        }
    }

    public final int R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (w() == null || w().S0() == null || w().S0().O() == null) {
                return -1;
            }
            return w().S0().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || w() == null || w().S0() == null) {
            return;
        }
        if (I3() && j3() == null) {
            return;
        }
        if ((I3() || S2() != null) && this.P != null) {
            MarkData markData = null;
            if (w().S0() != null && w().S0().g0()) {
                markData = w().j0(0);
            } else {
                CustomViewPager customViewPager = this.f35141e;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = w().M0(U2(w().S0()));
                } else if (I3()) {
                    if (j3() != null) {
                        markData = w().j0(j3().U0());
                    }
                } else if (S2() != null) {
                    markData = w().j0(S2().W0());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && j3() != null && (markData = w().j0(j3().U0() + 1)) == null) {
                return;
            }
            z4();
            this.P.i(markData);
            if (!this.P.e()) {
                if (w() != null && !c.a.p0.w2.m.f.n1.b.k(w().k1())) {
                    this.r0.m(2);
                    c.a.p0.w2.m.f.n1.b.b(w().k1());
                }
                this.P.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.P.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void R4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        boolean z4;
        PostData U2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String k12 = w().k1();
            String G = postData.G();
            String G2 = postData2 != null ? postData2.G() : "";
            int V = w().S0() != null ? w().S0().V() : 0;
            if (j3() != null && j3().Z0() != null) {
                n2 = j3().Z0().n(G);
            } else if (S2() == null || S2().b1() == null) {
                return;
            } else {
                n2 = S2().b1().n(G);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || w() == null || w().S0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(k12, G, "pb", true, F3(), null, false, G2, V, postData.S(), w().S0().d(), false, postData.s().getIconInfo(), V2(), V2() == 1 || V2() == 2 || V2() == 3 || V2() == 4 || V2() == 5).addBigImageData(eVar.a, eVar.f34853b, eVar.f34858g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(G2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(w().getForumId());
            addBigImageData.setTiebaPlusData(w().H(), w().D(), w().E(), w().C(), w().I());
            addBigImageData.setBjhData(w().l0());
            addBigImageData.setKeyPageStartFrom(w().R0());
            addBigImageData.setFromFrsForumId(w().getFromForumId());
            addBigImageData.setWorksInfoData(w().p1());
            addBigImageData.setIsOpenEditor(z2);
            if (w().S0().o() != null) {
                addBigImageData.setHasForumRule(w().S0().o().has_forum_rule.intValue());
            }
            if (w().S0().U() != null) {
                addBigImageData.setIsManager(w().S0().U().getIs_manager());
            }
            if (w().S0().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(w().S0().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (w().S0().l() != null) {
                addBigImageData.setForumHeadUrl(w().S0().l().getImage_url());
                addBigImageData.setUserLevel(w().S0().l().getUser_level());
            }
            if (w() != null && (U2 = U2(w().S0())) != null) {
                if (!U2.Q && !postData.Q) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (F3() && this.a.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public DetailInfoAndReplyFragment S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f35142f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f35142f.b(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final boolean S3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q2 = c.a.o0.r.j0.b.k().q("bubble_link", "");
                if (StringUtils.isNull(q2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.o0.l.a.q(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0521), q2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void S4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.C();
    }

    public DetailInfoFragment T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f35142f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f35142f.b(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public boolean T3(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.p0.w2.q.l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048634, this, i2, keyEvent)) == null) {
            if (!this.q1 && (this.r1 || J3())) {
                P4();
                UtilHelper.hideStatusBar(x(), x().getRootView());
                this.r1 = false;
                c.a.p0.w2.q.l.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.S0(false);
                }
            }
            if (i2 == 4) {
                c.a.p0.w2.q.l.a aVar3 = this.k;
                if (aVar3 != null) {
                    return aVar3.onBackPress();
                }
                return false;
            } else if (i2 == 24) {
                c.a.p0.w2.q.l.a aVar4 = this.k;
                if (aVar4 != null) {
                    return aVar4.onVolumeUp();
                }
                return false;
            } else if (i2 != 25 || (aVar = this.k) == null) {
                return false;
            } else {
                return aVar.P0();
            }
        }
        return invokeIL.booleanValue;
    }

    public final void T4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (voiceManager = this.U) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // c.a.p0.w2.q.c
    public PbModel.g U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.Y0 : (PbModel.g) invokeV.objValue;
    }

    public PostData U2(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, fVar)) == null) {
            PostData postData = null;
            if (fVar == null) {
                return null;
            }
            if (fVar.W() != null) {
                return fVar.W();
            }
            if (!ListUtils.isEmpty(fVar.F())) {
                Iterator<PostData> it = fVar.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = fVar.j();
            }
            if (postData == null) {
                postData = h3(fVar);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void U3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
            this.f35144h.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void U4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public abstract int V2();

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (!c.a.d.f.p.l.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c16);
            } else if (this.N == null || w() == null) {
            } else {
                this.N.F();
                if (this.L) {
                    return;
                }
                T4();
                z4();
                if (w().loadData()) {
                    J4();
                }
            }
        }
    }

    public final boolean V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (w() == null) {
                return true;
            }
            if (w().S0() == null || !w().S0().g0()) {
                if (w().E0()) {
                    MarkData p02 = w().p0();
                    if (p02 != null && w().C0() && i3() != null) {
                        MarkData j02 = w().j0(i3().getFirstVisiblePosition());
                        if (j02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", p02);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (j02.getPostId() != null && !j02.getPostId().equals(p02.getPostId())) {
                            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getBaseFragmentActivity());
                            aVar.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025b));
                            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new t(this, j02, p02, aVar));
                            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new u(this, p02, aVar));
                            aVar.setOnCalcelListener(new w(this));
                            aVar.create(getBaseFragmentActivity().getPageContext());
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
                if (w().S0() != null && w().S0().F() != null && w().S0().F().size() > 0 && w().C0()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String W2() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (w() == null || w().S0() == null || w().S0().F() == null || (count = ListUtils.getCount((F = w().S0().F()))) == 0) {
                return "";
            }
            if (w().d1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.G();
                    }
                }
            }
            int i2 = 0;
            if (i3() != null) {
                if (I3()) {
                    if (j3() != null) {
                        i2 = j3().S0();
                    }
                } else if (S2() != null) {
                    i2 = S2().U0();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(F, i2);
            if (postData != null && postData.s() != null) {
                if (w().I1(postData.s().getUserId())) {
                    return postData.G();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (w().I1(postData2.s().getUserId())) {
                        return postData2.G();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (w().I1(postData3.s().getUserId())) {
                        return postData3.G();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void W3(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            if (i2 == 0) {
                c.a.p0.z3.c.g().h(getUniqueId(), false);
                if (i3() != null) {
                    z2(i3(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.X0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.X0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.X0) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void W4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            c.a.o0.w.y.e eVar = this.I0;
            if (eVar != null) {
                s4(eVar.C());
            }
            j4();
            this.N.F();
        }
    }

    public abstract int X2();

    public void X3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z2) == null) || x() == null) {
            return;
        }
        if (this.r1 && !TbSingleton.getInstance().isNotchScreen(x()) && !TbSingleton.getInstance().isCutoutScreen(x())) {
            P4();
            UtilHelper.hideStatusBar(x(), x().getRootView());
            this.r1 = false;
        }
        this.u0.f35147b = z2;
        Z3();
        c4();
    }

    public final void X4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.J = ofFloat;
            ofFloat.addUpdateListener(new k1(this));
            this.J.setDuration(200L);
            this.J.start();
            this.J.addListener(new l1(this, layoutParams));
        }
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public void Y3(c.a.o0.t.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048650, this, aVar, i2) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.A(aVar, getPageContext(), i2, false);
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new r1(this));
            this.I.start();
        }
    }

    public View.OnClickListener Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.D1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.u0.a()) {
            this.k.W(false);
            return;
        }
        c.a.p0.w2.q.l.a aVar = this.k;
        if (!F3() && !this.k.N0()) {
            z2 = true;
        }
        aVar.W(z2);
    }

    public final void Z4(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.addUpdateListener(new p1(this, layoutParams, layoutParams2, i2));
            this.I.setDuration(300L);
            this.I.start();
            this.I.addListener(new q1(this));
        }
    }

    public View.OnClickListener a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.E1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void a4(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, fVar) == null) || fVar == null) {
            return;
        }
        ThreadData O = fVar.O();
        if (O != null && O.isUgcThreadType()) {
            y2();
        } else {
            w4(this.H0);
        }
        c.a.o0.w.y.e eVar = this.I0;
        if (eVar != null) {
            s4(eVar.C());
            this.I0.M(fVar.d());
            this.I0.N(fVar.l(), fVar.U());
            this.I0.r0(O);
            if (w() != null) {
                this.I0.O(w().v0(), w().k1(), w().r0());
            }
            if (O != null) {
                this.I0.h0(O.isMutiForumThread());
            }
        }
    }

    public final void a5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.I = ofFloat;
            ofFloat.addUpdateListener(new m1(this, layoutParams, layoutParams2, i2));
            this.I.setDuration(300L);
            this.I.start();
            this.I.addListener(new o1(this));
        }
    }

    public SparseArray<Object> b3(c.a.p0.w2.i.f fVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData U2;
        c.a.o0.r.r.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (fVar == null || (U2 = U2(fVar)) == null) {
                return null;
            }
            String userId = U2.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e6b, U2.G());
                sparseArray.put(R.id.obfuscated_res_0x7f091e6d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(fVar.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
            } else if (i2 == 1) {
                if (U2.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e76, U2.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e77, U2.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e78, U2.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e79, U2.G());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e6b, U2.G());
                sparseArray.put(R.id.obfuscated_res_0x7f091e6d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(fVar.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
            }
            if (!z3) {
                List<c.a.o0.r.r.x1> p2 = fVar.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (c.a.o0.r.r.x1 x1Var : p2) {
                        if (x1Var != null && !StringUtils.isNull(x1Var.a()) && (e0Var = x1Var.f10996g) != null && e0Var.a && !e0Var.f10845c && ((i3 = e0Var.f10844b) == 1 || i3 == 2)) {
                            sb.append(c.a.d.f.p.m.cutString(x1Var.a(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f063c));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6a, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0486), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || !checkUpIsLogin() || w() == null || w().S0() == null || w().S0().l() == null || A2()) {
            return;
        }
        if (w().S0().g0()) {
            E2();
            return;
        }
        if (this.D0 == null) {
            c.a.p0.f1.i2.a.c cVar = new c.a.p0.f1.i2.a.c(getPageContext());
            this.D0 = cVar;
            cVar.j(0);
            this.D0.i(new b1(this));
        }
        this.D0.g(w().S0().l().getId(), c.a.d.f.m.b.g(w().k1(), 0L));
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || w() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.D(w().getForumId()) || w().S0() == null || w().S0().l() == null) {
            return;
        }
        if (w().S0().l().isLike() == 1) {
            w().g0().C(w().getForumId(), w().k1());
        }
    }

    public c.a.o0.h.a c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.P : (c.a.o0.h.a) invokeV.objValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048662, this) == null) || this.k == null || this.f35141e == null) {
            return;
        }
        boolean z2 = false;
        if (!I3()) {
            this.k.R0(false);
        } else if (this.f35141e.getCurrentItem() != 0) {
            this.k.R0(false);
        } else if (this.u0.a()) {
            this.k.R0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.k.R0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public void c5(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, fVar) == null) {
            if (fVar != null && AntiHelper.o(fVar.O())) {
                c.a.p0.w2.r.j jVar = this.r0;
                if (jVar != null) {
                    jVar.k(false);
                    this.r0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.q0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.q0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080926, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.p0.w2.r.j jVar2 = this.r0;
            if (jVar2 == null || !jVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.q0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080926, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public View.OnLongClickListener d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.L1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void d4(boolean z2, int i2, int i3, int i4, c.a.p0.w2.i.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f35142f.c()) {
                if (baseFragment instanceof c.a.p0.w2.q.b) {
                    ((c.a.p0.w2.q.b) baseFragment).u0(z2, i2, i3, i4, fVar, str, i5);
                }
            }
            u0(z2, i2, i3, i4, fVar, str, i5);
        }
    }

    public void d5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            DetailInfoAndReplyFragment S2 = S2();
            if (S2 != null && S2.C0() != null && S2.C0().f() != null && S2.C0().g() != null) {
                S2.C0().f().O0(z2);
                S2.C0().g().m0(z2);
            }
            MaskView maskView = this.A;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048667, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (c.a.o0.e1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.o0.e1.n.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (c.a.p0.w2.m.f.f1.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new c.a.o0.e1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public View.OnTouchListener e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.z1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void e4(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        c5(fVar);
        this.p0.setVisibility(fVar.g0() ? 8 : 0);
        if (fVar.r()) {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080922, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080921, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String O2 = O2(fVar.O().getReply_num());
        TextView textView = this.s0;
        if (textView != null) {
            textView.setText(O2);
        }
        TextView textView2 = this.t0;
        if (textView2 != null) {
            textView2.setText(O2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.O()));
    }

    public c.a.o0.w.y.e f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.I0 : (c.a.o0.w.y.e) invokeV.objValue;
    }

    public void f4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048671, this, z2, markData) == null) || w() == null) {
            return;
        }
        y4();
        w().D2(z2);
        c.a.o0.h.a aVar = this.P;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (w().E0()) {
            Q3();
        } else if (I3()) {
            if (T2() != null) {
                T2().N0();
            }
            if (j3() != null) {
                j3().b1();
            }
        } else if (S2() != null) {
            S2().e1();
        }
    }

    @Override // c.a.p0.w2.q.c
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            PbModel pbModel = this.a.getPbModel();
            if (pbModel != null && pbModel.S0() != null && !pbModel.S0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.S0().O().getId();
                if (pbModel.isShareThread() && pbModel.S0().O().originalThreadData != null) {
                    historyMessage.threadName = pbModel.S0().O().originalThreadData.f29822b;
                } else {
                    historyMessage.threadName = pbModel.S0().O().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.S0().l().getName();
                }
                ArrayList<PostData> F = pbModel.S0().F();
                int S0 = j3() != null ? j3().S0() : 0;
                if (F != null && S0 >= 0 && S0 < F.size()) {
                    historyMessage.postID = F.get(S0).G();
                }
                historyMessage.isHostOnly = pbModel.w0();
                historyMessage.isSquence = pbModel.i1();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.o0.w.y.e eVar = this.I0;
            if (eVar != null) {
                eVar.I();
            }
            if (pbModel != null && (pbModel.y0() || pbModel.B0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.k1());
                if (this.y0) {
                    if (this.A0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.H0());
                    }
                    if (this.z0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.D0());
                    }
                }
                if (pbModel.S0() != null && System.currentTimeMillis() - this.f35138b >= 40000 && (q2 = pbModel.S0().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (V4()) {
                if (pbModel != null) {
                    c.a.p0.w2.i.f S02 = pbModel.S0();
                    if (S02 != null) {
                        if (S02.U() != null) {
                            S02.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.B0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                c.a.p0.w2.m.f.s0.b().t(rect);
                            }
                            c.a.p0.w2.m.f.s0.b().s(this.f35141e.getCurrentItem());
                            BdTypeRecyclerView i3 = i3();
                            c.a.p0.w2.m.f.s0.b().n(pbModel.T0(), i3 != null ? i3.onSaveInstanceState() : null, pbModel.i1(), pbModel.w0(), false);
                        }
                    }
                } else {
                    c.a.p0.w2.m.f.s0.b().m();
                }
                U4();
            }
        }
    }

    public final int g3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048673, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    public void g4(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048674, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        String valueOf = String.valueOf(fVar.O().getReply_num());
        if (fVar.O().getReply_num() == 0) {
            valueOf = "";
        }
        this.f35140d.F(valueOf);
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (this.V == null) {
                this.V = new c.a.d.f.k.b<>(new t1(this), 20, 0);
            }
            return this.V;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.X == null) {
                this.X = new c.a.d.f.k.b<>(new s1(this), 8, 0);
            }
            return this.X;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            c.a.d.f.k.b<RelativeLayout> bVar = new c.a.d.f.k.b<>(new w1(this), 10, 0);
            this.g0 = bVar;
            return bVar;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (this.W == null) {
                this.W = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.W;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.Z == null) {
                this.Z = new c.a.d.f.k.b<>(new v1(this), 15, 0);
            }
            return this.Z;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.U == null) {
                this.U = VoiceManager.instance();
            }
            return this.U;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.Y == null) {
                this.Y = new c.a.d.f.k.b<>(new u1(this), 8, 0);
            }
            return this.Y;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public final PostData h3(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = fVar.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = fVar.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.n0(1);
            postData.r0(fVar.O().getFirstPostId());
            postData.D0(fVar.O().getTitle());
            postData.C0(fVar.O().getCreateTime());
            postData.l0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void h4(c.a.p0.w2.i.u uVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, uVar) == null) || w() == null || w().S0() == null || uVar.i() == null) {
            return;
        }
        String G = uVar.i().G();
        ArrayList<PostData> F = w().S0().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
            if (postData.G() == null || !postData.G().equals(G)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = uVar.k();
                postData.A0(uVar.m());
                if (postData.P() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.W() != null && next != null && next.s() != null && (metaData = postData.W().get(next.s().getUserId())) != null) {
                            next.l0(metaData);
                            next.u0(true);
                            next.G0(getPageContext(), w().I1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.P().size();
                    if (!postData.a0(true)) {
                        postData.P().clear();
                        postData.P().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.j0();
                }
            }
        }
        if (w().C0() || !z2) {
            return;
        }
        if (I3() && j3() != null) {
            j3().b1();
        } else if (S2() != null) {
            S2().e1();
        }
    }

    public BdTypeRecyclerView i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            Iterator<BaseFragment> it = this.f35142f.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).X0();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).V0();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || this.I0 == null || this.J0 == null) {
            return;
        }
        c.a.o0.w.y.a.a().c(0);
        this.I0.T();
        this.I0.R();
        if (this.I0.y() != null) {
            this.I0.y().setMaxImagesAllowed(this.I0.v ? 1 : 9);
        }
        this.I0.l0(SendView.f30532g);
        this.I0.j(SendView.f30532g);
        c.a.o0.w.h m2 = this.J0.m(23);
        c.a.o0.w.h m3 = this.J0.m(2);
        c.a.o0.w.h m4 = this.J0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.J0.invalidate();
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            c.a.o0.h.a c2 = c.a.o0.h.a.c(this.a);
            this.P = c2;
            if (c2 != null) {
                c2.j(this.Z0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.T = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y1);
            this.S = new c.a.o0.s.e.a(getPageContext());
            this.N = new c.a.p0.w2.q.h.a(this);
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            PbModel pbModel = this.a.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.H1();
        }
        return invokeV.booleanValue;
    }

    public ReplyFragment j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f35142f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f35142f.b(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            i4();
            p3();
            this.K0.c();
            G4(false);
        }
    }

    public String k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            if (!c.a.d.f.p.m.isEmpty(this.v0)) {
                return this.v0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(c.a.p0.w2.m.f.y0.b());
            this.v0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public final void l3(int i2, Intent intent) {
        c.a.o0.w.n nVar;
        c.a.p0.w2.m.f.x xVar;
        c.a.o0.w.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048697, this, i2, intent) == null) {
            if (i2 == 0) {
                p3();
                c.a.p0.w2.m.f.x xVar2 = this.K0;
                if (xVar2 != null) {
                    xVar2.c();
                }
                G4(false);
            }
            j4();
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
                if (editorType == 0) {
                    this.I0.S();
                    this.I0.t0(pbEditorData.getVoiceModel());
                    this.I0.G(writeData);
                    c.a.o0.w.m n2 = this.I0.a().n(6);
                    if (n2 != null && (nVar = n2.k) != null) {
                        nVar.onAction(new c.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.I0.L(null, null);
                    }
                } else if (editorType != 1 || (xVar = this.K0) == null || xVar.b() == null) {
                } else {
                    c.a.o0.w.y.h b3 = this.K0.b();
                    b3.b0(w().S0().O());
                    b3.B(writeData);
                    b3.c0(pbEditorData.getVoiceModel());
                    c.a.o0.w.m n3 = b3.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new c.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    public void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            this.P0 = -1;
            this.Q0 = Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3(boolean z2) {
        c.a.p0.w2.i.f S0;
        int i2;
        c.a.p0.w2.r.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) || w() == null || this.N == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (S0 = w().S0()) == null) {
            return;
        }
        ThreadData O = S0.O();
        if (O != null && O.getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", w().k1()).param("fid", S0.m()).param("obj_locate", 4).param("uid", O.getAuthor().getUserId()));
            if (F3()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", w().getForumId());
                statisticItem.param("tid", w().k1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", W2());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", V2());
                TiebaStatic.log(statisticItem);
            }
        }
        if (O != null) {
            if (O.isBJHArticleThreadType()) {
                i2 = 2;
            } else if (O.isBJHVideoThreadType()) {
                i2 = 3;
            } else if (O.isBJHNormalThreadType()) {
                i2 = 4;
            } else if (O.isBJHVideoDynamicThreadType()) {
                i2 = 5;
            }
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", w().k1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", w().getForumId());
            if (!z2) {
                statisticItem2.param("obj_locate", 6);
            } else {
                statisticItem2.param("obj_locate", 5);
            }
            statisticItem2.param("obj_name", i2);
            statisticItem2.param("obj_type", 2);
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    statisticItem2.param("obj_type", 10);
                } else if (O.isBJHVideoThreadType()) {
                    statisticItem2.param("obj_type", 9);
                } else if (O.isBJHVideoDynamicThreadType()) {
                    statisticItem2.param("obj_type", 8);
                } else if (O.isBJHNormalThreadType()) {
                    statisticItem2.param("obj_type", 7);
                } else if (O.isShareThread) {
                    statisticItem2.param("obj_type", 6);
                } else {
                    int i3 = O.threadType;
                    if (i3 == 0) {
                        statisticItem2.param("obj_type", 1);
                    } else if (i3 == 40) {
                        statisticItem2.param("obj_type", 2);
                    } else if (i3 == 49) {
                        statisticItem2.param("obj_type", 3);
                    } else if (i3 == 54) {
                        statisticItem2.param("obj_type", 4);
                    } else {
                        statisticItem2.param("obj_type", 5);
                    }
                }
                statisticItem2.param("nid", O.getNid());
                statisticItem2.param("card_type", O.getRecomCardType());
                statisticItem2.param("recom_source", O.mRecomSource);
                statisticItem2.param("ab_tag", O.mRecomAbTag);
                statisticItem2.param("weight", O.mRecomWeight);
                statisticItem2.param("extra", O.mRecomExtra);
                statisticItem2.param("nid", O.getNid());
                if (O.getBaijiahaoData() != null && !c.a.d.f.p.m.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                }
            }
            if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (x() != null) {
                c.a.o0.o0.c.e(x(), statisticItem2);
            }
            jVar = this.r0;
            if (jVar != null) {
                statisticItem2.param("obj_param1", jVar.f());
            }
            TiebaStatic.log(statisticItem2);
            if (c.a.d.f.p.n.C()) {
                showToast(R.string.obfuscated_res_0x7f0f0c15);
                return;
            } else if (w().S0() == null) {
                c.a.d.f.p.n.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                return;
            } else {
                ArrayList<PostData> F = S0.F();
                if ((F == null || F.size() <= 0) && w().i1()) {
                    c.a.d.f.p.n.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dad));
                    return;
                }
                this.N.F();
                T4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                c.a.p0.w2.r.j jVar2 = this.r0;
                if (jVar2 != null) {
                    jVar2.k(false);
                    c5(S0);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.r0.h()) {
                        this.r0.l(false);
                        t3(c.a.o0.s.g.f.a(), this.r0.f());
                        return;
                    }
                    L4(i4);
                    return;
                }
                this.N.B0();
                w().n0().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", w().k1());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", w().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (x() != null) {
        }
        jVar = this.r0;
        if (jVar != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (c.a.d.f.p.n.C()) {
        }
    }

    public boolean m4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f091e69);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && c.a.o0.r.l.c().g()) {
                        return S3(postData.G());
                    }
                    if (checkUpIsLogin() && w() != null && w().S0() != null) {
                        c.a.p0.w2.m.f.x xVar = this.K0;
                        if (xVar != null) {
                            xVar.c();
                        }
                        c.a.p0.w2.i.u uVar = new c.a.p0.w2.i.u();
                        uVar.A(w().S0().l());
                        uVar.E(w().S0().O());
                        uVar.C(postData);
                        this.L0.U(uVar);
                        this.L0.setPostId(postData.G());
                        P3(view, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.o0.w.y.e eVar = this.I0;
                        if (eVar != null) {
                            s4(eVar.C());
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

    public void n3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || this.k0 == null) {
            return;
        }
        this.j0.setVisibility(8);
        this.k0.setVisibility(8);
        this.u0.a = false;
        Z3();
        c4();
    }

    public final void n4(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            c.a.p0.w2.m.f.j1.f.a aVar = new c.a.p0.w2.m.f.j1.f.a(this.a);
            this.Q = aVar;
            aVar.n(this.C1);
            this.Q.m(this.k1);
        }
        this.Q.k(emotionImageData, w(), w().S0());
    }

    public void o3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) || this.k0 == null || this.n0 == null) {
            return;
        }
        if (w() != null && w().S0() != null) {
            this.n0.setText(TbSingleton.getInstance().getAdVertiComment(w().S0().k0(), w().S0().l0(), k3()));
        } else {
            this.n0.setText(k3());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0.a = true;
    }

    public final void o4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048704, this, i2) == null) || w() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(w().k1());
        sendMessage(privacySettingMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906c9));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            a4(videoPbViewModel.c());
            B3(videoPbViewModel.c());
            g4(videoPbViewModel.c());
            if (w() != null && w().S0() != null) {
                boolean C0 = w().C0();
                c.a.p0.w2.i.f S0 = w().S0();
                if (C0) {
                    PostData U2 = U2(S0);
                    if (S0.u() != null && !S0.u().equals(U2.G()) && this.f35141e != null) {
                        if (I3()) {
                            this.f35141e.setCurrentItem(1);
                        } else {
                            this.f35141e.setCurrentItem(0);
                        }
                    }
                }
            }
            videoPbViewModel.j().observe(this, new f0(this));
            videoPbViewModel.b().observe(this, new h0(this));
            videoPbViewModel.i().observe(this, new i0(this));
            videoPbViewModel.g().observe(this, new j0(this));
            videoPbViewModel.e().observe(this, new k0(this));
            videoPbViewModel.f().observe(this, new l0(this));
            this.a.getTiePlusEventController().d(this.V0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048706, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.I0.H(i2, i3, intent);
            c.a.p0.w2.m.f.j1.f.a aVar = this.Q;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            c.a.p0.w2.m.f.x xVar = this.K0;
            if (xVar != null) {
                xVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                l3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    R3();
                } else if (i2 == 13011) {
                    c.a.p0.k3.a.g().m(getPageContext());
                } else if (i2 != 25016 && i2 != 25023 && i2 != 24007 && i2 != 24008) {
                    switch (i2) {
                        case 25055:
                            View view = this.x;
                            if (view != null) {
                                view.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view2 = this.y;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            if (Q2() != null) {
                                Q2().performClick();
                                return;
                            }
                            return;
                        case 25058:
                            View view3 = this.z;
                            if (view3 != null) {
                                view3.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.R = emotionImageData;
                    if (D2(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        n4(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048707, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.h0 = true;
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f35139c);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.f35140d, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f35140d;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            c.a.p0.w2.m.f.c1 c1Var = this.F0;
            if (c1Var != null) {
                c1Var.i();
            }
            c.a.p0.w2.q.f fVar = this.l;
            if (fVar == null || !fVar.k()) {
                SkinManager.setBackgroundColor(this.f35139c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.J0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            c.a.p0.w2.m.f.x xVar = this.K0;
            if (xVar != null) {
                xVar.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            HeadImageView headImageView = this.m0;
            if (headImageView != null) {
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            }
            LinearLayout linearLayout = this.l0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.n.f(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (w() != null && w().E0()) {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080922, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080921, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.o0, R.drawable.obfuscated_res_0x7f080924, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.obfuscated_res_0x7f0808f2, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (w() != null) {
                c5(w().S0());
            }
            SkinManager.setBackgroundResource(this.f35143g, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.k0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n0, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.s0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (S2() != null) {
                S2().onChangeSkinType(i2);
            } else if (I3() && j3() != null) {
                j3().onChangeSkinType(i2);
            }
            if (T2() != null) {
                T2().onChangeSkinType(i2);
            }
            View view = this.H;
            if (view != null) {
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.n.f(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            T4();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            c.a.p0.w2.q.l.a aVar = this.k;
            if (aVar == null || aVar.N0()) {
                return;
            }
            if (!(this.k.isFullScreen() && configuration.orientation == 1) && (this.k.isFullScreen() || configuration.orientation != 2)) {
                return;
            }
            this.k.U(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            this.f35138b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            x3(bundle);
            getVoiceManager().onCreate(getPageContext());
            c.a.o0.r.l0.c cVar = new c.a.o0.r.l0.c();
            this.O = cVar;
            cVar.a = 1000L;
            if (this.N != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.N.D;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.N.D;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            registerListener(this.H1);
            this.t = new c.a.p0.g0.a(getPageContext());
            c.a.p0.z3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048712, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f35139c = (RelativeLayout) layoutInflater.inflate(X2(), viewGroup, false);
            D3();
            return this.f35139c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onDestroy();
            c.a.p0.z3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.H1);
            getVoiceManager().onDestory(getPageContext());
            c.a.p0.w2.r.j jVar = this.r0;
            if (jVar != null) {
                jVar.j();
            }
            ForumManageModel forumManageModel = this.T;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            c.a.p0.w2.q.l.a aVar = this.k;
            if (aVar != null) {
                aVar.O0();
            }
            c.a.p0.w2.m.f.j1.f.a aVar2 = this.Q;
            if (aVar2 != null) {
                aVar2.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.C0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (w() != null) {
                w().cancelLoadData();
                w().destory();
                if (w().O0() != null) {
                    w().O0().d();
                }
            }
            c.a.o0.w.y.e eVar = this.I0;
            if (eVar != null) {
                eVar.I();
            }
            this.O = null;
            S4();
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048714, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.h0 = true;
    }

    @Override // c.a.o0.e1.n.i
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048715, this, context, str, z2) == null) {
            if (c.a.p0.w2.m.f.f1.c(str) && w() != null && w().k1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", w().k1()));
            }
            if (z2) {
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
            this.h0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onPause();
            this.T0 = true;
            getVoiceManager().onPause(getPageContext());
            c.a.p0.w2.q.l.a aVar = this.k;
            if (aVar != null) {
                aVar.onBackground(true);
            }
            if (w() != null && !w().G0()) {
                this.I0.U(w().k1());
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            c.a.o0.a.d.y().G();
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048717, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N.p0(str);
        c.a.o0.r.t.c R = this.N.R();
        if (R == null) {
            this.N.W();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            R.f(1).setVisibility(8);
        } else {
            R.f(1).setVisibility(0);
        }
        R.m();
        this.h0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onResume();
            this.T0 = false;
            getVoiceManager().onResume(getPageContext());
            c.a.p0.w2.q.l.a aVar = this.k;
            if (aVar != null) {
                aVar.onBackground(false);
            }
            M4();
            registerListener(this.h1);
            registerListener(this.i1);
            registerListener(this.g1);
            registerListener(this.G1);
            ItemCardHelper.v(this.J1);
            MessageManager.getInstance().registerListener(this.I1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (w() != null) {
                w().j2(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
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
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            c.a.p0.z3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.I1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
            super.onUserChanged(z2);
            O3();
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048724, this, context, str) == null) {
            c.a.p0.w2.m.f.f1.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.h0 = true;
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048725, this, context, str) == null) {
        }
    }

    public void p3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.o();
    }

    public void p4(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048727, this, i2) == null) || (linearLayout = this.i0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || this.a.getCurrentFocus() == null) {
            return;
        }
        c.a.d.f.p.n.w(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void q4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, editorTools) == null) {
            this.J0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f0916a2);
            this.J0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.J0.getParent() == null) {
                this.f35139c.addView(this.J0, layoutParams);
            }
            this.J0.w(TbadkCoreApplication.getInst().getSkinType());
            this.J0.setActionListener(24, new f1(this));
            p3();
            this.I0.i(new g1(this));
        }
    }

    public void r3() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || (view = this.M) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.K.setFallingFeedbackListener(new FallingView.k() { // from class: c.a.p0.w2.q.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.k
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AbsVideoPbFragment.this.N3();
                    }
                }
            });
        }
    }

    public void s3() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || (rightFloatLayerView = this.X0) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void s4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048733, this, z2) == null) {
            this.w0 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f35142f;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f35141e) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    @Override // c.a.p0.w2.q.c
    public AbsVideoPbFragment t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public final void t3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048736, this, i2, i3) == null) {
            c.a.o0.c1.n0.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.L = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048739, this) == null) || w() == null || c.a.d.f.p.m.isEmpty(w().k1())) {
            return;
        }
        super.taskStart();
    }

    @Override // c.a.p0.w2.q.b
    public void u0(boolean z2, int i2, int i3, int i4, c.a.p0.w2.i.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048740, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || w() == null || w().S0() == null || w().S0().O() == null) {
            return;
        }
        ThreadData O = w().S0().O();
        O.mRecomAbTag = w().X0();
        O.mRecomWeight = w().a1();
        O.mRecomSource = w().Z0();
        O.mRecomExtra = w().Y0();
        O.isSubPb = w().G0();
        if (O.getFid() == 0) {
            O.setFid(c.a.d.f.m.b.g(w().getForumId(), 0L));
        }
        StatisticItem i2 = c.a.o0.o0.c.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            this.i0 = (LinearLayout) this.f35139c.findViewById(R.id.obfuscated_res_0x7f092358);
            this.j0 = this.f35139c.findViewById(R.id.obfuscated_res_0x7f0923b6);
            this.k0 = this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a4);
            c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07027b);
            HeadImageView headImageView = (HeadImageView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a8);
            this.m0 = headImageView;
            headImageView.setVisibility(0);
            this.m0.setIsRound(true);
            this.m0.setBorderWidth(c.a.d.f.p.n.f(getContext(), R.dimen.L_X01));
            this.m0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.m0.setPlaceHolder(0);
            O3();
            this.n0 = (TextView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a7);
            LinearLayout linearLayout = (LinearLayout) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a1);
            this.l0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a5);
            this.o0 = imageView;
            imageView.setOnClickListener(this.D1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a3);
            this.p0 = imageView2;
            imageView2.setOnClickListener(this.D1);
            if (booleanExtra) {
                this.p0.setVisibility(8);
            } else {
                this.p0.setVisibility(0);
            }
            if (H3()) {
                this.o0.setVisibility(0);
            } else {
                this.o0.setVisibility(8);
                this.p0.setPadding(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView3 = (ImageView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a9);
            this.q0 = imageView3;
            imageView3.setOnClickListener(this.D1);
            this.r0 = new c.a.p0.w2.r.j(this.q0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.r0.e();
            }
            if (w() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !c.a.p0.w2.m.f.n1.b.k(w().k1())) {
                this.r0.e();
                c.a.p0.w2.m.f.n1.b.b(w().k1());
            }
            TextView textView = (TextView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f0916a6);
            this.s0 = textView;
            textView.setVisibility(0);
            G4(false);
        }
    }

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z2) == null) {
            this.r1 = z2;
        }
    }

    public final void v2(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048744, this, z2, str) == null) || w() == null || w().S0() == null || w().S0().O() == null) {
            return;
        }
        ThreadData O = w().S0().O();
        O.mRecomAbTag = w().X0();
        O.mRecomWeight = w().a1();
        O.mRecomSource = w().Z0();
        O.mRecomExtra = w().Y0();
        if (O.getFid() == 0) {
            O.setFid(c.a.d.f.m.b.g(w().getForumId(), 0L));
        }
        StatisticItem i2 = c.a.o0.o0.c.i(getContext(), O, "c13563");
        TbPageTag l2 = c.a.o0.o0.c.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            if (O.isVideoThreadType()) {
                i2.param(TiebaStatic.Params.POST_CONTENT, c.a.o0.c1.o0.d(str) > 40 ? c.a.o0.c1.o0.n(str, 40) : str);
            }
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            c.a.o0.n0.c currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            if (V2() == 1) {
                i2.param("obj_locate", 4);
            } else if (V2() == 2) {
                i2.param("obj_locate", 5);
            } else if (V2() == 3) {
                i2.param("obj_locate", 2);
            } else if (V2() == 4) {
                i2.param("obj_locate", 3);
            } else if (V2() == 7) {
                i2.param("obj_locate", 7);
            } else {
                i2.param("obj_locate", 6);
            }
            i2.addParam("obj_type", 1);
            i2.addParam("tid", w().k1());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.addParam("fid", w().S0().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = c.a.o0.o0.c.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.addParam("obj_type", 2);
        } else {
            i3.addParam("obj_type", 1);
        }
        i3.param("tid", w().k1());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", w().S0().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = c.a.o0.o0.c.i(getContext(), O, "c14303");
        if (i4 != null) {
            if (V2() == 1) {
                i4.param("obj_locate", 1);
            } else if (V2() == 2) {
                i4.param("obj_locate", 2);
            } else if (V2() == 3) {
                i4.param("obj_locate", 3);
            } else if (V2() == 4) {
                i4.param("obj_locate", 4);
            }
            i4.param("tid", w().k1());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", w().S0().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            this.L0 = new PbFakeFloorModel(getPageContext());
            PbModel w2 = w();
            this.L0.R(w2.H(), w2.D(), w2.E(), w2.C(), w2.I());
            this.L0.setFromForumId(w2.getFromForumId());
            c.a.p0.w2.m.f.x xVar = new c.a.p0.w2.m.f.x(getPageContext(), this.L0, this.f35139c);
            this.K0 = xVar;
            xVar.k(new x0(this));
            this.K0.n(this.B1);
            this.L0.T(new y0(this));
        }
    }

    public abstract void v4(boolean z2);

    @Override // c.a.p0.w2.q.c
    public PbModel w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.a.getPbModel() : (PbModel) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w2(ThreadData threadData) {
        double d2;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect k02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, threadData) == null) {
            double k2 = c.a.d.f.p.n.k(getContext());
            double i3 = (2.0d * k2) / c.a.d.f.p.n.i(getContext());
            if (threadData != null && threadData.getThreadVideoInfo() != null) {
                int intValue = threadData.getThreadVideoInfo().video_width.intValue();
                int intValue2 = threadData.getThreadVideoInfo().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= i3) {
                        i3 = d2;
                    }
                    int ceil = (int) Math.ceil(k2 / i3);
                    int height = (w() != null || (k02 = w().k0()) == null) ? ceil : k02.height();
                    i2 = 0;
                    layoutParams = this.j.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, height);
                    } else {
                        i2 = layoutParams.height - height;
                        layoutParams.height = height;
                    }
                    this.j.setLayoutParams(layoutParams);
                    this.j.setMaxHeight(ceil);
                    this.j.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
                    this.j.setOriginHeight(height);
                    if (I3()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f35140d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, O1);
                        } else {
                            layoutParams3.height = O1;
                        }
                        this.f35140d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (I3()) {
                        ceil += O1;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ceil;
                    }
                    this.i.setLayoutParams(layoutParams2);
                    if (i2 == 0 && (this.i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.i.getLayoutParams()).getBehavior();
                        if (behavior instanceof VideoZoomBehavior) {
                            ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i2);
                            return;
                        }
                        return;
                    }
                }
            }
            d2 = 1.7777777777777777d;
            if (d2 > 1.7777777777777777d) {
            }
            if (d2 >= i3) {
            }
            int ceil2 = (int) Math.ceil(k2 / i3);
            if (w() != null) {
            }
            i2 = 0;
            layoutParams = this.j.getLayoutParams();
            if (layoutParams != null) {
            }
            this.j.setLayoutParams(layoutParams);
            this.j.setMaxHeight(ceil2);
            this.j.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
            this.j.setOriginHeight(height);
            if (I3()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (I3()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            q4(this.I0.a());
        }
    }

    public final void w4(c.a.o0.w.y.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, gVar) == null) || gVar == null || w() == null) {
            return;
        }
        gVar.p(w().s0());
        if (w().S0() != null && w().S0().l() != null) {
            gVar.o(w().S0().l());
        }
        gVar.q("pb");
        gVar.r(w());
    }

    @Override // c.a.p0.w2.q.c
    public AbsPbActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public final void x2(c.a.p0.w2.q.j.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048752, this, aVar) == null) && aVar != null && this.w == null) {
            this.w = aVar;
            this.C.setText(aVar.getTitle());
            this.D.setText(aVar.m());
            String k2 = aVar.k();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(k2)) {
                k2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0dcc);
            }
            tBSpecificationBtn.setText(k2);
            this.G.J(aVar.g(), 10, false);
            this.H.setVisibility(aVar.q() ? 0 : 8);
            c.a.d.f.m.e.a().postDelayed(new j1(this), aVar.e().longValue() * 1000);
        }
    }

    public final void x3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, bundle) == null) {
            c.a.o0.w.y.g gVar = new c.a.o0.w.y.g();
            this.H0 = gVar;
            w4(gVar);
            c.a.o0.w.y.e eVar = (c.a.o0.w.y.e) this.H0.a(getActivity());
            this.I0 = eVar;
            eVar.e0(this.a.getPageContext());
            this.I0.n0(this.k1);
            this.I0.o0(this.C1);
            this.I0.g0(1);
            this.I0.F(this.a.getPageContext(), bundle);
            this.I0.a().b(new c.a.o0.w.k(getActivity()));
            this.I0.a().C(true);
            D4(true);
            this.I0.O(w().v0(), w().k1(), w().r0());
            registerListener(this.c1);
            registerListener(this.e1);
            registerListener(this.m1);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.f1);
            registerListener(this.K1);
            if (!w().G0()) {
                this.I0.s(w().k1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (w().x1()) {
                this.I0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd));
            } else {
                this.I0.k0(k3());
            }
            this.F0 = new c.a.p0.w2.m.f.c1();
            if (this.I0.v() != null) {
                this.F0.m(this.I0.v().h());
            }
            this.I0.d0(this.a1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.C0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public void x4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048754, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            c.a.p0.w2.q.h.a aVar = this.N;
            if (aVar == null) {
                return;
            }
            if (z2) {
                aVar.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.G();
            } else {
                this.N.F();
            }
        }
    }

    @Override // c.a.p0.w2.q.c
    public PbFragment y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048756, this) == null) || w() == null || this.a == null) {
            return;
        }
        c.a.o0.w.y.e eVar = this.I0;
        if (eVar == null || !eVar.v) {
            c.a.o0.w.y.d dVar = new c.a.o0.w.y.d();
            w4(dVar);
            c.a.o0.w.y.e eVar2 = (c.a.o0.w.y.e) dVar.a(getContext());
            this.I0 = eVar2;
            eVar2.e0(this.a.getPageContext());
            this.I0.n0(this.k1);
            this.I0.o0(this.C1);
            this.I0.F(this.a.getPageContext(), this.a.getIntent() == null ? null : this.a.getIntent().getExtras());
            this.I0.a().C(true);
            q4(this.I0.a());
            if (!w().G0()) {
                this.I0.s(w().k1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (w().x1()) {
                this.I0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dbd));
            } else {
                this.I0.k0(k3());
            }
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            this.C = (TextView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091744);
            this.G = (TbImageView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091743);
            this.D = (TextView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091740);
            this.E = (ImageView) this.f35139c.findViewById(R.id.obfuscated_res_0x7f09173f);
            this.F = (TBSpecificationBtn) this.f35139c.findViewById(R.id.obfuscated_res_0x7f091742);
            this.H = this.f35139c.findViewById(R.id.obfuscated_res_0x7f0901ed);
            this.G.setRadius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new c.a.o0.r.l0.n.c());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (w() == null || w().S0() == null) {
                return;
            }
            I4(w().S0());
        }
    }

    public void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            hideProgressBar();
            if (I3() && j3() != null) {
                j3().P0();
                j3().Q0();
            } else if (S2() != null) {
                S2().R0();
                S2().S0();
            }
        }
    }

    public void z2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048759, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().C(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().C(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().C(firstVisiblePosition)) != null && postData.p() != null) {
                        postData.p().q(postData.A());
                        arrayList.add(postData.p());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x1(this));
                if (((c.a.o0.t.a) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    Y3((c.a.o0.t.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    Y3((c.a.o0.t.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f35139c.findViewById(R.id.obfuscated_res_0x7f092359);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802c8);
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.f35139c.findViewById(R.id.obfuscated_res_0x7f091da4);
            View findViewById = this.f35139c.findViewById(R.id.obfuscated_res_0x7f091daa);
            this.o = findViewById;
            if (this.q1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = c.a.d.f.p.n.r(x());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = c.a.d.f.p.n.r(x());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.D1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09246f);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f080624, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e6, this.D1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09150f);
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.rightMargin = f3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.r.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.t1 = new GestureDetector(getContext(), this.u1);
            this.m.setOnTouchListener(this.s1);
        }
    }

    public void z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            c.a.d.f.p.n.w(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    /* loaded from: classes5.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35147b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f35148c;

        public b2(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35148c = absVideoPbFragment;
            this.f35147b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a && this.f35147b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }
}
