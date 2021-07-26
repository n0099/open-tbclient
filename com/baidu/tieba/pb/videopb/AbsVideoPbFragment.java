package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
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
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.appbar.AppBarLayout;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.p0.d1.m.f;
import d.a.p0.i.a;
import d.a.p0.s.s.a;
import d.a.q0.h2.p.c;
import d.a.q0.i0.b;
import d.a.q0.u0.f2.a.c;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes4.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements d.a.p0.d1.m.h, VoiceManager.j, d.a.q0.h2.o.b, TbRichTextView.t, d.a.q0.h2.o.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int R1;
    public static final int S1;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.h2.o.i.a A;
    public String A0;
    public ObjectAnimator A1;
    public View B;
    public boolean B0;
    public ObjectAnimator B1;
    public View C;
    public String C0;
    public final d.a.d.a.e C1;
    public View D;
    public boolean D0;
    public View.OnTouchListener D1;
    public MaskView E;
    public boolean E0;
    public final b.InterfaceC1461b E1;
    public d.a.q0.h2.o.j.a F;
    public boolean F0;
    public NewWriteModel.g F1;
    public View.OnClickListener G;
    public boolean G0;
    public d.a.p0.x.w.c G1;
    public TextView H;
    public ReplyPrivacyCheckController H0;
    public final View.OnClickListener H1;
    public TextView I;
    public d.a.q0.u0.f2.a.c I0;
    public View.OnClickListener I1;
    public ImageView J;
    public d.a.q0.u0.f2.a.c J0;
    public final AdapterView.OnItemClickListener J1;
    public TBSpecificationBtn K;
    public d.a.q0.h2.k.e.v0 K0;
    public CustomMessageListener K1;
    public TbImageView L;
    public PermissionJudgePolicy L0;
    public CustomMessageListener L1;
    public View M;
    public d.a.p0.x.w.g M0;
    public final ItemCardHelper.b M1;
    public ValueAnimator N;
    public d.a.p0.x.w.e N0;
    public Runnable N1;
    public ValueAnimator O;
    public EditorTools O0;
    public CustomMessageListener O1;
    public FallingView P;
    public d.a.q0.h2.k.e.u P0;
    public final View.OnLongClickListener P1;
    public TbImageView Q;
    public PbFakeFloorModel Q0;
    public SortSwitchButton.f Q1;
    public boolean R;
    public d.a.q0.i0.b R0;
    public View S;
    public int[] S0;
    public d.a.q0.h2.o.g.a T;
    public int T0;
    public d.a.p0.s.f0.c U;
    public int U0;
    public d.a.p0.i.a V;
    public int V0;
    public d.a.q0.h2.k.e.c1.f.a W;
    public int W0;
    public EmotionImageData X;
    public int X0;
    public d.a.p0.t.e.a Y;
    public boolean Y0;
    public ForumManageModel Z;
    public boolean Z0;
    public VoiceManager a0;
    public RightFloatLayerView a1;
    public d.a.d.e.k.b<GifView> b0;
    public final CustomMessageListener b1;
    public d.a.d.e.k.b<TextView> c0;
    public final PbModel.g c1;
    public final a.InterfaceC1202a d1;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f19776e;
    public d.a.p0.x.w.b e1;

    /* renamed from: f  reason: collision with root package name */
    public long f19777f;
    public final CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f19778g;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f19779h;
    public final CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f19780i;
    public d.a.d.e.k.b<ImageView> i0;
    public CustomMessageListener i1;
    public VideoPbFragmentAdapter j;
    public d.a.d.e.k.b<View> j0;
    public HttpMessageListener j1;
    public View k;
    public d.a.d.e.k.b<LinearLayout> k0;
    public CustomMessageListener k1;
    public View l;
    public d.a.d.e.k.b<RelativeLayout> l0;
    public CustomMessageListener l1;
    public AppBarLayout m;
    public boolean m0;
    public CustomMessageListener m1;
    public VideoContainerLayout n;
    public LinearLayout n0;
    public d.a.p0.x.w.b n1;
    public d.a.q0.h2.o.k.a o;
    public View o0;
    public final NewWriteModel.g o1;
    public d.a.q0.h2.o.e p;
    public View p0;
    public View.OnClickListener p1;
    public NavigationBar q;
    public LinearLayout q0;
    public CustomMessageListener q1;
    public View r;
    public HeadImageView r0;
    public int r1;
    public View s;
    public TextView s0;
    public float s1;
    public View t;
    public ImageView t0;
    public float t1;
    public ImageView u;
    public ImageView u0;
    public boolean u1;
    public View v;
    public ImageView v0;
    public boolean v1;
    public ImageView w;
    public d.a.q0.h2.p.h w0;
    public View.OnTouchListener w1;
    public d.a.q0.z.a x;
    public TextView x0;
    public GestureDetector x1;
    public boolean y;
    public TextView y0;
    public GestureDetector.SimpleOnGestureListener y1;
    public View z;
    public b2 z0;
    public Runnable z1;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19781a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19781a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19781a.Y0) {
                return;
            }
            this.f19781a.P4();
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19782e;

        public a0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19782e = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19782e.y() == null || this.f19782e.y().U0() == i2 + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.f19782e;
            absVideoPbFragment.t4(absVideoPbFragment.o3(i2));
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19783a;

        public a1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19783a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                d.a.q0.h2.o.g.a aVar = this.f19783a.T;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!d.a.d.e.p.j.z()) {
                    this.f19783a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.f19783a.y() != null && !this.f19783a.y().isLoading) {
                    this.f19783a.X4();
                    this.f19783a.D4();
                    z = true;
                    if (this.f19783a.y().L0() != null && this.f19783a.y().L0().f57442f != null && this.f19783a.y().L0().f57442f.size() > i2) {
                        int intValue = this.f19783a.y().L0().f57442f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f19783a.y().c1()).param("fid", this.f19783a.y().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.f19783a.y().m2(intValue)) {
                            this.f19783a.R = true;
                        }
                    }
                }
                return z;
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
    public class a2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19784a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a2(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19784a = absVideoPbFragment;
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
                this.f19784a.m4((d.a.q0.h2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f19784a.T2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f19784a.k4(false, null);
                } else {
                    this.f19784a.k4(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19785a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19785a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f19785a.f5();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19786a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19786a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                d.a.p0.d1.m.f.c(this.f19786a.getPageContext(), this.f19786a, aVar.f52414a, aVar.f52415b, aVar.f52416c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19787a;

        public b1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19787a = absVideoPbFragment;
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
                if (this.f19787a.N0 != null && this.f19787a.N0.a() != null) {
                    this.f19787a.N0.a().A(new d.a.p0.x.a(45, 27, null));
                }
                this.f19787a.M2();
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
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19791a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoPbFragment absVideoPbFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f19791a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f19791a.getView() != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.f19791a;
                    absVideoPbFragment.hideLoadingView(absVideoPbFragment.getView());
                    this.f19791a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.f19791a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.f19791a.getString(R.string.block_user_success));
                            bdTopToast.j((ViewGroup) this.f19791a.getView());
                            this.f19791a.E4(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.f19791a.getResources().getString(R.string.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        BdTopToast bdTopToast2 = new BdTopToast(this.f19791a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(errorString);
                        bdTopToast2.j((ViewGroup) this.f19791a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements Observer<d.a.p0.s.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19792e;

        public c0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19792e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.p0.s.q.b2 b2Var) {
            d.a.q0.h2.o.k.a aVar;
            BdTypeRecyclerView q3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var == null || b2Var.m1() == null || (aVar = this.f19792e.o) == null) {
                return;
            }
            if (aVar.c0() != null && this.f19792e.o.c0().equals(b2Var.m1().video_url)) {
                this.f19792e.o.setData(b2Var);
                return;
            }
            if (!d.a.d.e.p.k.isEmpty(this.f19792e.o.c0())) {
                this.f19792e.G0 = true;
                if (this.f19792e.O3()) {
                    this.f19792e.f19780i.setCurrentItem(0);
                } else {
                    this.f19792e.f19780i.setCurrentItem(0);
                }
                if (!this.f19792e.O3() && (q3 = this.f19792e.q3()) != null) {
                    q3.scrollToPosition(0);
                }
            }
            if (this.f19792e.p == null || !this.f19792e.p.k()) {
                this.f19792e.p4();
                this.f19792e.E2(b2Var);
            }
            this.f19792e.M3();
            if (this.f19792e.p != null && this.f19792e.p.l()) {
                this.f19792e.p.s();
            }
            boolean z = !StringHelper.equals(this.f19792e.o.c0(), b2Var.m1().video_url);
            this.f19792e.o.setData(b2Var);
            if (this.f19792e.O3()) {
                AbsVideoPbFragment absVideoPbFragment = this.f19792e;
                absVideoPbFragment.o.W0(absVideoPbFragment.f19780i.getCurrentItem() == 0);
            } else {
                this.f19792e.o.W0(false);
            }
            if (z) {
                this.f19792e.o.startPlay();
                this.f19792e.o.z0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19793a;

        public c1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19793a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.q0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
            String s3;
            d.a.p0.x.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                this.f19793a.C4();
                this.f19793a.z3();
                if (this.f19793a.R) {
                    this.f19793a.R = false;
                }
                this.f19793a.K4(false);
                if (z && eVar != null) {
                    d.a.p0.s.q.b2 N = eVar.N();
                    ((VideoPbViewModel) ViewModelProviders.of(this.f19793a.getActivity()).get(VideoPbViewModel.class)).s(eVar, i3);
                    this.f19793a.f4(eVar);
                    this.f19793a.M4(eVar);
                    this.f19793a.l4(eVar);
                    this.f19793a.i4(z, i2, i3, i4, eVar, str, i5);
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.T().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.T().getBimg_end_time());
                    if (eVar.E() != null && eVar.E().size() >= 1 && eVar.E().get(0) != null) {
                        this.f19793a.y().V1(eVar.E().get(0).E());
                    } else if (eVar.V() != null) {
                        this.f19793a.y().V1(eVar.V().E());
                    }
                    if (this.f19793a.V != null) {
                        this.f19793a.V.h(eVar.s());
                    }
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        this.f19793a.C0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.f19793a.C0) && this.f19793a.N0 != null && this.f19793a.N0.a() != null && (m = this.f19793a.N0.a().m(6)) != null && !TextUtils.isEmpty(this.f19793a.C0)) {
                            ((View) m).setOnClickListener(this.f19793a.p1);
                        }
                    }
                    if (this.f19793a.H0 != null && N != null && N.H() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.H());
                        this.f19793a.H0.setLikeUserData(attentionHostData);
                    }
                    this.f19793a.J3(eVar);
                    if (this.f19793a.y() != null && this.f19793a.y().k1()) {
                        s3 = this.f19793a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        s3 = this.f19793a.s3();
                    }
                    if (!StringUtils.isNull(s3)) {
                        this.f19793a.N0.l0(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), s3));
                    }
                } else {
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.f19793a.y().b1());
                            jSONObject.put("fid", this.f19793a.y().getForumId());
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
                    if ((this.f19793a.O3() && this.f19793a.r3() == null) || this.f19793a.a3() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.f19793a.O3()) {
                        if (i2 != -1) {
                            if (this.f19793a.y() != null && this.f19793a.y().L0() != null) {
                                arrayList = this.f19793a.y().L0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19793a.r3().s1(this.f19793a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f19793a.r3().m1()) {
                                this.f19793a.r3().t1(this.f19793a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f19793a.r3().t1(this.f19793a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f19793a.r3().s1("");
                        }
                        this.f19793a.r3().Z0();
                    } else {
                        if (i2 != -1) {
                            if (this.f19793a.y() != null && this.f19793a.y().L0() != null) {
                                arrayList = this.f19793a.y().L0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19793a.a3().y1(this.f19793a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f19793a.a3().p1()) {
                                this.f19793a.a3().z1(this.f19793a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f19793a.a3().z1(this.f19793a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f19793a.a3().y1("");
                        }
                        this.f19793a.a3().b1();
                    }
                }
                d.a.q0.g3.c.g().h(this.f19793a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19794a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19794a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f19794a.T != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f19794a.T.D) {
                d.a.q0.s3.a aVar = (d.a.q0.s3.a) customResponsedMessage.getData();
                this.f19794a.T.V();
                SparseArray<Object> sparseArray = (SparseArray) this.f19794a.T.O();
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
                    this.f19794a.T.y0(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f19794a.T.i0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19795e;

        public d0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19795e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f19795e.f19780i.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19796a;

        public d1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19796a = absVideoPbFragment;
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
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19797a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19797a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19797a.T == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.q0.h2.o.g.a aVar = this.f19797a.T;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.q0.h2.h.e L0 = this.f19797a.y().L0();
                if (L0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    L0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f19797a.U.c(this.f19797a.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f19797a.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f19797a.T.E0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f19797a.T.x0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.d.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f19797a.getResources().getString(R.string.mute_fail);
                    }
                    this.f19797a.U.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements Observer<d.a.p0.s.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19798e;

        public e0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19798e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.p0.s.q.b2 b2Var) {
            d.a.q0.h2.o.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || (aVar = this.f19798e.o) == null) {
                return;
            }
            aVar.Z0(b2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19799e;

        public e1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19799e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19799e.o4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19800a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19800a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19800a.T == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.q0.h2.o.g.a aVar = this.f19800a.T;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f19800a.U.c(this.f19800a.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.d.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f19800a.getResources().getString(R.string.un_mute_fail);
                }
                this.f19800a.U.b(muteMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements Observer<d.a.p0.s.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19801e;

        public f0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19801e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.p0.s.q.b2 b2Var) {
            d.a.q0.h2.o.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || (aVar = this.f19801e.o) == null) {
                return;
            }
            aVar.Y0(b2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class f1 implements d.a.p0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19802e;

        public f1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19802e = absVideoPbFragment;
        }

        @Override // d.a.p0.x.b
        public void onAction(d.a.p0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f54160c;
                if (obj instanceof d.a.p0.t.c.v) {
                    if (((d.a.p0.t.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((d.a.p0.t.c.v) aVar.f54160c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f19802e.L0 == null) {
                            this.f19802e.L0 = new PermissionJudgePolicy();
                        }
                        this.f19802e.L0.clearRequestPermissionList();
                        this.f19802e.L0.appendRequestPermission(this.f19802e.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f19802e.L0.startRequestPermission(this.f19802e.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f19802e.N0.h((d.a.p0.t.c.v) aVar.f54160c);
                        this.f19802e.N0.A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.p0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19803a;

        public g(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19803a = absVideoPbFragment;
        }

        @Override // d.a.p0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.q0.h2.k.e.v0 v0Var = this.f19803a.K0;
                if (v0Var == null || v0Var.g() == null || !this.f19803a.K0.g().d()) {
                    return !this.f19803a.L2(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.f19803a;
                absVideoPbFragment.showToast(absVideoPbFragment.K0.g().c());
                if (this.f19803a.P0 != null && this.f19803a.P0.b() != null && this.f19803a.P0.b().x()) {
                    this.f19803a.P0.b().v(this.f19803a.K0.h());
                }
                this.f19803a.K0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19805f;

        public g0(AbsVideoPbFragment absVideoPbFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19805f = absVideoPbFragment;
            this.f19804e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19805f.a1.k();
                if (!StringUtils.isNull(this.f19804e)) {
                    this.f19805f.T3(this.f19804e);
                }
                this.f19805f.A3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19806e;

        public g1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19806e = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.q0.h2.k.e.v0 v0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19806e.K0) == null || v0Var.e() == null) {
                return;
            }
            if (!this.f19806e.K0.e().e()) {
                this.f19806e.K0.a(false);
            }
            this.f19806e.K0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) != null) || this.f19806e.O0 == null || this.f19806e.O0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2) || TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19807a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19808e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f19809f;

            public a(h hVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19809f = hVar;
                this.f19808e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19808e == null) {
                    return;
                }
                this.f19809f.f19807a.W4();
                this.f19809f.f19807a.d4(this.f19808e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes4.dex */
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
            public final /* synthetic */ h f19810e;

            public c(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19810e = hVar;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19810e.f19807a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19810e.f19807a.getActivity(), 0, 26, 2)));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19807a = absVideoPbFragment;
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
                    if (this.f19807a.y() != null && this.f19807a.y().L0() != null) {
                        statisticItem.param("fid", this.f19807a.y().L0().n());
                    }
                    statisticItem.param("tid", this.f19807a.y().b1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f19807a.X4();
                this.f19807a.B4(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (!z) {
                    if (i2 == 220015) {
                        this.f19807a.showToast(str);
                        if (this.f19807a.N0.C() || this.f19807a.N0.E()) {
                            this.f19807a.N0.A(false, postWriteCallBackData);
                        }
                        this.f19807a.K0.k(postWriteCallBackData);
                        return;
                    } else if (i2 == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.f19807a.H0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.f19807a.getActivity(), this.f19807a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.f19807a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (k0Var != null || i2 == 227001) {
                            return;
                        }
                        this.f19807a.I4(i2, antiData, str);
                        return;
                    } else {
                        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f19807a.getActivity());
                        if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            aVar.setMessage(this.f19807a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            aVar.setMessage(postWriteCallBackData.getErrorString());
                        }
                        aVar.setNegativeButton(R.string.cancel, new b(this));
                        aVar.setPositiveButton(R.string.open_now, new c(this));
                        aVar.create(this.f19807a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.f19807a.y() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.f19807a.y().W(postWriteCallBackData.getPostId());
                    if (this.f19807a.O3() && this.f19807a.r3() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.f19807a;
                        absVideoPbFragment.W0 = absVideoPbFragment.r3().c1();
                        AbsVideoPbFragment absVideoPbFragment2 = this.f19807a;
                        absVideoPbFragment2.X0 = absVideoPbFragment2.r3().d1();
                        this.f19807a.y().U1(this.f19807a.W0, this.f19807a.X0);
                    } else if (this.f19807a.a3() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.f19807a;
                        absVideoPbFragment3.W0 = absVideoPbFragment3.a3().e1();
                        AbsVideoPbFragment absVideoPbFragment4 = this.f19807a;
                        absVideoPbFragment4.X0 = absVideoPbFragment4.a3().f1();
                        this.f19807a.y().U1(this.f19807a.W0, this.f19807a.X0);
                    }
                }
                if (this.f19807a.f19780i != null) {
                    if (this.f19807a.O3()) {
                        this.f19807a.f19780i.setCurrentItem(1);
                    } else {
                        this.f19807a.f19780i.setCurrentItem(0);
                    }
                }
                this.f19807a.T.F();
                this.f19807a.K0.c();
                if (this.f19807a.N0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.f19807a;
                    absVideoPbFragment5.w4(absVideoPbFragment5.N0.D());
                }
                this.f19807a.x3();
                this.f19807a.K4(true);
                this.f19807a.y().i1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.f19807a.J4(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.f19807a.y().q0()) {
                        d.a.q0.h2.h.e L0 = this.f19807a.y().L0();
                        if (L0 != null && L0.N() != null && L0.N().H() != null && (userId = L0.N().H().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f19807a.y().j2()) {
                            this.f19807a.D4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.f19807a.y().j2()) {
                        this.f19807a.D4();
                    }
                } else if (floor != null) {
                    if (this.f19807a.O3() && this.f19807a.r3() != null) {
                        this.f19807a.r3().l1();
                    } else if (this.f19807a.a3() != null) {
                        this.f19807a.a3().o1();
                    }
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.d.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.f19807a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.D2(z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19811e;

        public h0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19811e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f19811e.h4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19814g;

        /* loaded from: classes4.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h1 f19815e;

            public a(h1 h1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19815e = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.q0.h2.k.e.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19815e.f19814g.K0) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f19815e.f19814g.K0.g().e()) {
                    this.f19815e.f19814g.K0.b(false);
                }
                this.f19815e.f19814g.K0.g().l(false);
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

        public h1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19814g = absVideoPbFragment;
            this.f19812e = str;
            this.f19813f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = d.a.d.e.p.l.i(this.f19814g.f19776e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.d.e.p.l.g(this.f19814g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.d.e.p.l.g(this.f19814g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                AbsVideoPbFragment absVideoPbFragment = this.f19814g;
                boolean z = true;
                int i5 = (absVideoPbFragment.S0[1] + absVideoPbFragment.T0) - i4;
                if (absVideoPbFragment.q3() != null) {
                    this.f19814g.q3().smoothScrollBy(0, i5);
                }
                if (this.f19814g.P0 != null) {
                    this.f19814g.N0.a().setVisibility(8);
                    this.f19814g.P0.n(this.f19812e, this.f19813f, this.f19814g.s3(), (this.f19814g.y() == null || this.f19814g.y().L0() == null || this.f19814g.y().L0().N() == null || !this.f19814g.y().L0().N().J1()) ? false : false);
                    d.a.p0.x.w.h b2 = this.f19814g.P0.b();
                    if (b2 != null && this.f19814g.y() != null && this.f19814g.y().L0() != null) {
                        b2.G(this.f19814g.y().L0().d());
                        b2.a0(this.f19814g.y().L0().N());
                    }
                    if (this.f19814g.K0.f() == null && this.f19814g.P0.b().u() != null) {
                        this.f19814g.P0.b().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.f19814g;
                        absVideoPbFragment2.K0.n(absVideoPbFragment2.P0.b().u().i());
                        this.f19814g.P0.b().M(this.f19814g.n1);
                    }
                }
                this.f19814g.v3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19816e;

        public i(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19816e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.f19816e;
                absVideoPbFragment.showToast(absVideoPbFragment.C0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19817e;

        public i0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19817e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f19817e.z4(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19818a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19819b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19820c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i1 f19821e;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0234a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f19822e;

                public C0234a(a aVar) {
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
                    this.f19822e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.q0.h2.k.e.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19822e.f19821e.f19820c.K0) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f19822e.f19821e.f19820c.K0.g().e()) {
                        this.f19822e.f19821e.f19820c.K0.b(false);
                    }
                    this.f19822e.f19821e.f19820c.K0.g().l(false);
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

            public a(i1 i1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19821e = i1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = d.a.d.e.p.l.i(this.f19821e.f19820c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = d.a.d.e.p.l.g(this.f19821e.f19820c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i2 = i3 / 2;
                        g2 = d.a.d.e.p.l.g(this.f19821e.f19820c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i4 = i3 - (i2 + g2);
                    AbsVideoPbFragment absVideoPbFragment = this.f19821e.f19820c;
                    boolean z = true;
                    int i5 = (absVideoPbFragment.S0[1] + absVideoPbFragment.T0) - i4;
                    if (absVideoPbFragment.q3() != null) {
                        this.f19821e.f19820c.q3().smoothScrollBy(0, i5);
                    }
                    if (this.f19821e.f19820c.P0 != null) {
                        this.f19821e.f19820c.N0.a().setVisibility(8);
                        z = (this.f19821e.f19820c.y() == null || this.f19821e.f19820c.y().L0() == null || this.f19821e.f19820c.y().L0().N() == null || !this.f19821e.f19820c.y().L0().N().J1()) ? false : false;
                        d.a.q0.h2.k.e.u uVar = this.f19821e.f19820c.P0;
                        i1 i1Var = this.f19821e;
                        uVar.n(i1Var.f19818a, i1Var.f19819b, i1Var.f19820c.s3(), z);
                        d.a.p0.x.w.h b2 = this.f19821e.f19820c.P0.b();
                        if (b2 != null && this.f19821e.f19820c.y() != null && this.f19821e.f19820c.y().L0() != null) {
                            b2.G(this.f19821e.f19820c.y().L0().d());
                            b2.a0(this.f19821e.f19820c.y().L0().N());
                        }
                        if (this.f19821e.f19820c.K0.f() == null && this.f19821e.f19820c.P0.b().u() != null) {
                            this.f19821e.f19820c.P0.b().u().g(new C0234a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.f19821e.f19820c;
                            absVideoPbFragment2.K0.n(absVideoPbFragment2.P0.b().u().i());
                            this.f19821e.f19820c.P0.b().M(this.f19821e.f19820c.n1);
                        }
                    }
                    this.f19821e.f19820c.v3();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19820c = absVideoPbFragment;
            this.f19818a = str;
            this.f19819b = str2;
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
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19823a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19823a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f19823a.N0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.f19823a;
                absVideoPbFragment.w4(absVideoPbFragment.N0.D());
            }
            this.f19823a.K4(false);
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f19824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19825f;

        public j0(AbsVideoPbFragment absVideoPbFragment, VideoPbViewModel videoPbViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, videoPbViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19825f = absVideoPbFragment;
            this.f19824e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (!d.a.p0.e1.b.e.d() && this.f19825f.O3() && (this.f19824e.m() || this.f19825f.y().a1() == 1)) {
                    this.f19825f.f19780i.setCurrentItem(1);
                } else if (this.f19824e.m() || this.f19825f.y().a1() == 0) {
                    this.f19825f.f19780i.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (!d.a.p0.e1.b.e.d() && this.f19825f.O3() && (this.f19824e.m() || this.f19825f.y().a1() == 1)) {
                    this.f19825f.f19780i.setCurrentItem(1);
                } else if (this.f19824e.m() || this.f19825f.y().a1() == 0) {
                    this.f19825f.f19780i.setCurrentItem(0);
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

    /* loaded from: classes4.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19826e;

        public j1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19826e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19826e.A == null || this.f19826e.A.o()) {
                    if (this.f19826e.A != null && this.f19826e.y() != null && this.f19826e.y().L0() != null && this.f19826e.y().L0().m() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.f19826e.y().L0().m().getId()).param("fname", this.f19826e.y().L0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19826e.y().L0().P()).param("obj_param1", this.f19826e.A.o));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.f19826e.A.getTitle()).param("obj_name", this.f19826e.A.j()).param("obj_type", 2).param("fid", this.f19826e.y().L0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19826e.y().L0().P()));
                }
                this.f19826e.S4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19827e;

        public k(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19827e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19827e.A == null || this.f19827e.A.o()) {
                    if (this.f19827e.A != null) {
                        if (!this.f19827e.A.l) {
                            if (this.f19827e.A.q != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.f19827e.getPageContext(), this.f19827e.A.q.mSid, this.f19827e.A.q.mSsid, this.f19827e.A.q.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.f19827e;
                            absVideoPbFragment.S3(absVideoPbFragment.A.n, this.f19827e.A.m);
                        }
                        if (this.f19827e.y() == null || this.f19827e.y().L0() == null || this.f19827e.y().L0().m() == null) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c13713").param("fid", this.f19827e.y().L0().m().getId()).param("fname", this.f19827e.y().L0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19827e.y().L0().P()).param("obj_param1", this.f19827e.A.o));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.f19827e.A.getTitle()).param("obj_name", this.f19827e.A.j()).param("obj_type", 2).param("fid", this.f19827e.y().L0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19827e.y().L0().P()));
                String e2 = this.f19827e.A.e();
                if (TextUtils.isEmpty(e2)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(e2) && !URLUtil.isHttpsUrl(e2)) {
                    Uri parse = Uri.parse(e2);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.f19827e.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f19827e.getPageContext(), new String[]{e2});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19828a;

        public k0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19828a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f19828a.N0.M(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f19828a.P0 != null && this.f19828a.P0.b() != null) {
                    this.f19828a.P0.b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.f19828a;
                    absVideoPbFragment.s4(absVideoPbFragment.X);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19829e;

        public k1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19829e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19829e.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19830e;

        public l(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19830e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.f19830e.x1 != null && this.f19830e.x1.onTouchEvent(motionEvent);
                }
                if (this.f19830e.r1 == 1) {
                    if (!this.f19830e.v1) {
                        this.f19830e.U4();
                        UtilHelper.showStatusBar(this.f19830e.z(), this.f19830e.z().getRootView());
                        this.f19830e.v1 = true;
                        d.a.d.e.m.e.a().removeCallbacks(this.f19830e.z1);
                        d.a.d.e.m.e.a().postDelayed(this.f19830e.z1, 3000L);
                    }
                } else if (this.f19830e.r1 == 2 && (this.f19830e.v1 || this.f19830e.P3())) {
                    this.f19830e.T4();
                    UtilHelper.hideStatusBar(this.f19830e.z(), this.f19830e.z().getRootView());
                    this.f19830e.v1 = false;
                    d.a.q0.h2.o.k.a aVar = this.f19830e.o;
                    if (aVar != null) {
                        aVar.X0(false);
                    }
                }
                this.f19830e.r1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19831a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19831a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.j(this.f19831a.f19776e, this.f19831a.f19776e.getUniqueId(), (View) customResponsedMessage.getData(), this.f19831a.f19778g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19833f;

        public l1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19833f = absVideoPbFragment;
            this.f19832e = layoutParams;
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
                this.f19833f.e5(this.f19832e);
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

    /* loaded from: classes4.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19834e;

        public m(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19834e = absVideoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f19834e.r1 = 0;
                this.f19834e.s1 = 0.0f;
                this.f19834e.t1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            d.a.q0.h2.o.k.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f19834e.s1 += f2;
                this.f19834e.t1 += f3;
                if (this.f19834e.r1 == 0 && !this.f19834e.u1 && (aVar = this.f19834e.o) != null && !aVar.C()) {
                    int height = this.f19834e.q.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.f19834e.t1) <= Math.abs(this.f19834e.s1) || this.f19834e.t1 > (-height) / 5) {
                        if (Math.abs(this.f19834e.t1) > Math.abs(this.f19834e.s1) && this.f19834e.t1 > 0.0f && f3 > 0.0f) {
                            this.f19834e.r1 = 2;
                        }
                    } else {
                        this.f19834e.r1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19835a;

        public m0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19835a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.u(this.f19835a.f19776e, ItemCardHelper.OrderTipStatus.FAIL, this.f19835a.f19778g);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.u(this.f19835a.f19776e, ItemCardHelper.OrderTipStatus.SUCCESS, this.f19835a.f19778g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19838g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19839h;

        public m1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19839h = absVideoPbFragment;
            this.f19836e = layoutParams;
            this.f19837f = layoutParams2;
            this.f19838g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.R1);
                this.f19836e.height = floatValue;
                this.f19837f.height = (this.f19838g - AbsVideoPbFragment.R1) + floatValue;
                this.f19839h.z.setLayoutParams(this.f19836e);
                this.f19839h.m.setLayoutParams(this.f19837f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19840e;

        public n(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19840e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19840e.v1 && !this.f19840e.P3()) {
                this.f19840e.T4();
                UtilHelper.hideStatusBar(this.f19840e.z(), this.f19840e.z().getRootView());
                this.f19840e.v1 = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19841e;

        public n0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19841e = absVideoPbFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                boolean z = true;
                if (i2 == 0) {
                    if (this.f19841e.a3() != null) {
                        this.f19841e.a3().s1(false);
                    } else if (this.f19841e.O3() && this.f19841e.r3() != null) {
                        this.f19841e.r3().o1(false);
                    }
                    if (this.f19841e.b3() != null) {
                        this.f19841e.b3().c1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.f19841e;
                        absVideoPbFragment.F4(absVideoPbFragment.b3().U0() == 0 ? 8 : 0);
                        this.f19841e.n0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.f19841e.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    d.a.q0.h2.o.k.a aVar = this.f19841e.o;
                    if (aVar != null) {
                        aVar.W0(z);
                    }
                    this.f19841e.o4();
                    if (this.f19841e.y() != null && this.f19841e.y().L0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.f19841e.y().b1()).param("fid", this.f19841e.y().L0().n()));
                    }
                } else {
                    if (this.f19841e.b3() != null) {
                        this.f19841e.b3().c1(false);
                    }
                    if (this.f19841e.a3() != null) {
                        this.f19841e.a3().s1(true);
                        int k1 = this.f19841e.a3().k1();
                        int i1 = this.f19841e.a3().i1();
                        if (k1 != 0) {
                            this.f19841e.F4(8);
                            this.f19841e.a3().C1(0);
                        } else if (i1 != 0) {
                            this.f19841e.a3().C1(8);
                            this.f19841e.F4(0);
                        } else {
                            this.f19841e.a3().C1(8);
                            this.f19841e.F4(8);
                        }
                    } else if (this.f19841e.r3() != null) {
                        this.f19841e.r3().o1(true);
                        int i12 = this.f19841e.r3().i1();
                        int g1 = this.f19841e.r3().g1();
                        if (i12 != 0) {
                            this.f19841e.F4(8);
                            this.f19841e.r3().w1(0);
                        } else if (g1 != 0) {
                            this.f19841e.r3().w1(8);
                            this.f19841e.F4(0);
                        } else {
                            this.f19841e.r3().w1(8);
                            this.f19841e.F4(8);
                        }
                        this.f19841e.n0.setVisibility(0);
                    }
                    d.a.q0.h2.o.k.a aVar2 = this.f19841e.o;
                    if (aVar2 != null) {
                        aVar2.W0(false);
                    }
                    this.f19841e.m.setExpanded(false, true);
                    if (this.f19841e.y() != null && this.f19841e.y().L0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.f19841e.y().b1()).param("fid", this.f19841e.y().L0().n()));
                    }
                }
                this.f19841e.j.d(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements a.InterfaceC1202a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19842a;

        public n1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19842a = absVideoPbFragment;
        }

        @Override // d.a.p0.i.a.InterfaceC1202a
        public void a(boolean z, boolean z2, String str) {
            d.a.p0.s.q.b2 N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f19842a.C4();
                if (z && this.f19842a.y() != null) {
                    if (this.f19842a.V != null) {
                        this.f19842a.V.h(z2);
                    }
                    this.f19842a.y().i2(z2);
                    if (this.f19842a.y().L0() != null && (N = this.f19842a.y().L0().N()) != null) {
                        if (z2) {
                            N.J2++;
                        } else {
                            int i2 = N.J2;
                            if (i2 > 0) {
                                N.J2 = i2 - 1;
                            }
                        }
                    }
                    if (this.f19842a.y().x0()) {
                        this.f19842a.W3();
                    } else if (this.f19842a.O3()) {
                        if (this.f19842a.b3() != null) {
                            this.f19842a.b3().X0();
                        }
                        if (this.f19842a.r3() != null) {
                            this.f19842a.r3().l1();
                        }
                    } else if (this.f19842a.a3() != null) {
                        this.f19842a.a3().o1();
                    }
                    if (z2) {
                        if (this.f19842a.V != null) {
                            if (this.f19842a.V.f() == null || this.f19842a.y() == null || this.f19842a.y().L0() == null || this.f19842a.y().L0().N() == null || this.f19842a.y().L0().N().H() == null) {
                                return;
                            }
                            MarkData f2 = this.f19842a.V.f();
                            MetaData H = this.f19842a.y().L0().N().H();
                            if (f2 != null && H != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), H.getUserId()) && !H.hadConcerned()) {
                                    this.f19842a.T.u0(H);
                                } else {
                                    this.f19842a.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.f19842a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f19842a.C2();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.f19842a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.f19842a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19843a;

        public o(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19843a = absVideoPbFragment;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.f19843a.y() != null) {
                    switch (this.f19843a.Z.getLoadDataMode()) {
                        case 0:
                            this.f19843a.y().i1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f19843a.T2(bVar, (bVar.f21301e != 1002 || bVar.f21302f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f19843a.U2(1, dVar.f21304a, dVar.f21305b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.f19843a;
                            absVideoPbFragment.V2(absVideoPbFragment.Z.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.f19843a;
                            absVideoPbFragment2.U2(absVideoPbFragment2.Z.getLoadDataMode(), gVar.f21318a, gVar.f21319b, false);
                            this.f19843a.T.e0(gVar.f21320c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.f19843a;
                absVideoPbFragment3.U2(absVideoPbFragment3.Z.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u.a f19844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19845b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19846c;

        public o0(AbsVideoPbFragment absVideoPbFragment, d.a.p0.u.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19846c = absVideoPbFragment;
            this.f19844a = aVar;
            this.f19845b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.f19846c.R4(this.f19844a, bitmap, this.f19845b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19847e;

        public o1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19847e = absVideoPbFragment;
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
                this.f19847e.z.setVisibility(8);
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

    /* loaded from: classes4.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19848e;

        public p(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19848e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f19848e.R0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements c.InterfaceC1452c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Random f19849a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19850b;

        public p0(AbsVideoPbFragment absVideoPbFragment, Random random) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, random};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19850b = absVideoPbFragment;
            this.f19849a = random;
        }

        @Override // d.a.q0.h2.p.c.InterfaceC1452c
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f19849a.nextInt(2) * 0.1f) + 0.8f : invokeV.floatValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19853g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19854h;

        public p1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19854h = absVideoPbFragment;
            this.f19851e = layoutParams;
            this.f19852f = layoutParams2;
            this.f19853g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.R1);
                this.f19851e.height = floatValue;
                this.f19852f.height = this.f19853g + floatValue;
                this.f19854h.z.setLayoutParams(this.f19851e);
                this.f19854h.m.setLayoutParams(this.f19852f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements b.InterfaceC1461b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19855a;

        public q(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19855a = absVideoPbFragment;
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
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u.a f19856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19857f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19858g;

        public q0(AbsVideoPbFragment absVideoPbFragment, d.a.p0.u.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19858g = absVideoPbFragment;
            this.f19856e = aVar;
            this.f19857f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = this.f19858g.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.d.e.p.k.getUrlEncode(this.f19856e.d())});
                TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f19857f).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19859e;

        public q1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19859e = absVideoPbFragment;
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
                this.f19859e.c5();
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

    /* loaded from: classes4.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19860e;

        public r(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19860e = absVideoPbFragment;
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
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19861e;

        public r0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19861e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19861e.a1.k();
                this.f19861e.A3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19862e;

        public r1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19862e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19862e.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19863a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19864e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s f19865f;

            public a(s sVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19865f = sVar;
                this.f19864e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19864e == null) {
                    return;
                }
                this.f19865f.f19863a.W4();
                this.f19865f.f19863a.d4(this.f19864e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes4.dex */
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
            public final /* synthetic */ s f19866e;

            public c(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19866e = sVar;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19866e.f19863a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19866e.f19863a.getActivity(), 0, 26, 2)));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19863a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.p0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19863a.y() != null && this.f19863a.y().L0() != null) {
                        statisticItem.param("fid", this.f19863a.y().L0().n());
                    }
                    if (this.f19863a.y() != null) {
                        statisticItem.param("tid", this.f19863a.y().b1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    d.a.q0.h2.k.e.v0 v0Var = this.f19863a.K0;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d.a.p0.t.h.b.a(this.f19863a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.d.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19863a.H0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19863a.getActivity(), this.f19863a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19863a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f19863a.getActivity());
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19863a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19863a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment = this.f19863a;
                if (absVideoPbFragment.K0 == null) {
                    return;
                }
                if (absVideoPbFragment.P0 != null && this.f19863a.P0.b() != null && this.f19863a.P0.b().x()) {
                    this.f19863a.P0.b().v(postWriteCallBackData);
                }
                this.f19863a.K0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19867e;

        public s0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19867e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19867e.Q == null) {
                return;
            }
            d.a.q0.h2.p.d.b(this.f19867e.Q);
        }
    }

    /* loaded from: classes4.dex */
    public class s1 implements d.a.d.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19868a;

        public s1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19868a = absVideoPbFragment;
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
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f19868a.getPageContext().getPageActivity());
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
    public class t implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19870f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f19871g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19872h;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19872h = absVideoPbFragment;
            this.f19869e = markData;
            this.f19870f = markData2;
            this.f19871g = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f19872h.V != null) {
                    if (this.f19872h.V.e()) {
                        this.f19872h.V.d();
                        this.f19872h.V.h(false);
                    }
                    this.f19872h.V.i(this.f19869e);
                    this.f19872h.V.h(true);
                    this.f19872h.V.a();
                }
                this.f19870f.setPostId(this.f19869e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19870f);
                this.f19872h.f19776e.setResult(-1, intent);
                this.f19871g.dismiss();
                this.f19872h.Y4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19873e;

        public t0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19873e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19873e.A == null || this.f19873e.A.o()) {
                    if (this.f19873e.A != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.f19873e.y().L0().P()));
                        this.f19873e.A.p = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.f19873e.Q4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t1 implements d.a.d.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19874a;

        public t1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19874a = absVideoPbFragment;
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
                GifView gifView = new GifView(this.f19874a.getPageContext().getPageActivity());
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
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f19876f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19877g;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19877g = absVideoPbFragment;
            this.f19875e = markData;
            this.f19876f = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19875e);
                this.f19877g.f19776e.setResult(-1, intent);
                this.f19876f.dismiss();
                this.f19877g.Y4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19878e;

        public u0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19878e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19878e.getActivity(), "pb_huitie"))) {
                this.f19878e.S2(false);
                this.f19878e.g4();
                if (this.f19878e.y() == null || this.f19878e.y().L0() == null || this.f19878e.y().L0().N() == null || this.f19878e.y().L0().N().H() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f19878e.y().c1()).param("fid", this.f19878e.y().L0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19878e.y().b1()).param("fid", this.f19878e.y().L0().n()).param("obj_locate", 1).param("uid", this.f19878e.y().L0().N().H().getUserId()));
                if (this.f19878e.N3()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.f19878e.y().getForumId());
                    statisticItem.param("tid", this.f19878e.y().b1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.f19878e.e3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.f19878e.d3());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u1 implements d.a.d.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19879a;

        public u1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19879a = absVideoPbFragment;
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
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f19879a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f19879a.getVoiceManager());
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
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19880a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19880a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f19880a.A3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19881a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19881a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f19881a.n0.getLayoutParams();
            layoutParams.height = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.f19881a.n0.setLayoutParams(layoutParams);
            if (this.f19881a.O3() && this.f19881a.f19779h != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f19881a.f19779h.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.S1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.S1);
                }
                this.f19881a.f19779h.setLayoutParams(layoutParams2);
                this.f19881a.f19780i.setScrollable(true);
            }
            this.f19881a.o4();
            if (this.f19881a.b3() != null) {
                this.f19881a.b3().X0();
            }
            if (this.f19881a.a3() != null) {
                this.f19881a.a3().o1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v1 implements d.a.d.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19882a;

        public v1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19882a = absVideoPbFragment;
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
                LinearLayout linearLayout = new LinearLayout(this.f19882a.getPageContext().getPageActivity());
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
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19883e;

        public w(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19883e = absVideoPbFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19884e;

        public w0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19884e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19884e.y3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w1 implements d.a.d.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19885a;

        public w1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19885a = absVideoPbFragment;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f19885a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class x implements d.a.p0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19886a;

        public x(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19886a = absVideoPbFragment;
        }

        @Override // d.a.p0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19886a.showProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19887e;

        public x0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19887e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19887e.o4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x1 implements Comparator<d.a.p0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19888e;

        public x1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19888e = absVideoPbFragment;
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
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19889e;

        public y(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19889e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i2;
            StatisticItem statisticItem2;
            int top;
            String str;
            int i3;
            int i4;
            String b2;
            boolean l2;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f19889e.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                    statisticItem3.param("tid", this.f19889e.y().b1());
                    statisticItem3.param("fid", this.f19889e.y().getForumId());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                    if (this.f19889e.N3()) {
                        StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem4.param("fid", this.f19889e.y().getForumId());
                        statisticItem4.param("tid", this.f19889e.y().b1());
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("post_id", this.f19889e.e3());
                        statisticItem4.param("obj_source", 1);
                        statisticItem4.param("obj_type", 3);
                        statisticItem4.param("obj_locate", this.f19889e.d3());
                        TiebaStatic.log(statisticItem4);
                    }
                    if (this.f19889e.m0) {
                        this.f19889e.m0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.f19889e.y() == null || this.f19889e.y().L0() == null || this.f19889e.Q0 == null || postData.t() == null || postData.A() == 1 || !this.f19889e.checkUpIsLogin()) {
                                return;
                            }
                            if (this.f19889e.P0 != null) {
                                this.f19889e.P0.c();
                            }
                            d.a.q0.h2.h.r rVar = new d.a.q0.h2.h.r();
                            rVar.A(this.f19889e.y().L0().m());
                            rVar.E(this.f19889e.y().L0().N());
                            rVar.C(postData);
                            this.f19889e.Q0.R(rVar);
                            this.f19889e.Q0.setPostId(postData.E());
                            this.f19889e.V3(view, postData.t().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            d.a.q0.h2.m.a.b(this.f19889e.y().L0(), postData, postData.i0, 8, 1);
                            if (this.f19889e.N0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.f19889e;
                                absVideoPbFragment.w4(absVideoPbFragment.N0.D());
                            }
                        }
                    }
                } else if ((this.f19889e.O3() && this.f19889e.r3() != null && this.f19889e.r3().h1() != null && view == this.f19889e.r3().h1()) || ((this.f19889e.a3() != null && this.f19889e.a3().j1() != null && view == this.f19889e.a3().j1()) || view.getId() == R.id.pb_more)) {
                    if (!this.f19889e.R && this.f19889e.y().u1(true)) {
                        this.f19889e.R = true;
                        if (this.f19889e.O3()) {
                            if (this.f19889e.r3() != null) {
                                this.f19889e.r3().v1();
                            }
                        } else if (this.f19889e.a3() != null) {
                            this.f19889e.a3().B1();
                        }
                    }
                } else {
                    d.a.q0.h2.o.g.a aVar = this.f19889e.T;
                    if (aVar != null && aVar.Q() != null && view == this.f19889e.T.Q().e()) {
                        this.f19889e.T.I();
                        return;
                    }
                    d.a.q0.h2.o.g.a aVar2 = this.f19889e.T;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.f19889e.T.Q().j()) && view.getId() != R.id.owner_reply && view.getId() != R.id.all_reply)) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.f19889e;
                        if (view == absVideoPbFragment2.t) {
                            if (absVideoPbFragment2.y() == null || this.f19889e.y().L0() == null) {
                                return;
                            }
                            if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.f19889e.y().L0().n());
                                statisticItem5.param("tid", this.f19889e.y().b1());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            d.a.d.e.p.l.x(this.f19889e.f19776e, this.f19889e.t);
                            this.f19889e.f19776e.finish();
                        } else if (view == absVideoPbFragment2.v && absVideoPbFragment2.T != null) {
                            if (d.a.p0.b1.l.a()) {
                                return;
                            }
                            if (this.f19889e.y() != null && this.f19889e.y().L0() != null) {
                                ArrayList<PostData> E = this.f19889e.y().L0().E();
                                if ((E == null || E.size() <= 0) && this.f19889e.y().Z0()) {
                                    d.a.d.e.p.l.M(this.f19889e.getPageContext().getPageActivity(), this.f19889e.getPageContext().getString(R.string.pb_no_data_tips));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f19889e.y().b1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f19889e.y().getForumId()));
                                this.f19889e.T.k0();
                                return;
                            }
                            d.a.d.e.p.l.M(this.f19889e.getPageContext().getPageActivity(), this.f19889e.getPageContext().getString(R.string.pb_no_data_tips));
                        } else if (this.f19889e.T.Q() != null && view == this.f19889e.T.Q().l()) {
                            if (this.f19889e.y() == null) {
                                return;
                            }
                            this.f19889e.T.F();
                            if (d.a.d.e.p.j.z()) {
                                this.f19889e.X4();
                                this.f19889e.D4();
                                this.f19889e.y().g2(1);
                                return;
                            }
                            this.f19889e.showToast(R.string.network_not_available);
                        } else {
                            d.a.q0.h2.o.g.a aVar3 = this.f19889e.T;
                            if (aVar3 != null && aVar3.Q() != null && view == this.f19889e.T.Q().j()) {
                                this.f19889e.T.I();
                                return;
                            }
                            d.a.q0.h2.o.g.a aVar4 = this.f19889e.T;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.f19889e.T.Q().r()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                                this.f19889e.T.F();
                                if (d.a.d.e.p.j.z()) {
                                    if (!this.f19889e.R) {
                                        this.f19889e.X4();
                                        this.f19889e.D4();
                                        this.f19889e.T.D0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.f19889e.y().X0()));
                                    return;
                                }
                                this.f19889e.showToast(R.string.network_not_available);
                                return;
                            }
                            d.a.q0.h2.o.g.a aVar5 = this.f19889e.T;
                            if (aVar5 != null && aVar5.Q() != null && view == this.f19889e.T.Q().q()) {
                                if (this.f19889e.y() == null || this.f19889e.y().L0() == null || this.f19889e.y().L0().N() == null) {
                                    return;
                                }
                                this.f19889e.T.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.f19889e;
                                absVideoPbFragment3.T.U(absVideoPbFragment3.y().L0().N().U());
                            } else if (view.getId() == R.id.pb_floor_feedback) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                d.a.q0.h2.o.g.a aVar6 = this.f19889e.T;
                                if (aVar6 != null) {
                                    aVar6.r0(sparseArray);
                                }
                            } else {
                                d.a.q0.h2.o.g.a aVar7 = this.f19889e.T;
                                if (aVar7 != null && aVar7.Q() != null && view == this.f19889e.T.Q().o()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    if (skinType == 1) {
                                        this.f19889e.onChangeSkinType(skinType);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                    } else if (skinType == 0 || skinType == 4) {
                                        UtilHelper.showSkinChangeAnimation(this.f19889e.getActivity());
                                        this.f19889e.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.f19889e.getActivity(), this.f19889e.getResources().getColor(R.color.CAM_X0201_1));
                                        TbadkCoreApplication.getInst().setSkinType(1);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                    }
                                    this.f19889e.T.J();
                                    return;
                                }
                                d.a.q0.h2.o.g.a aVar8 = this.f19889e.T;
                                if (aVar8 != null && aVar8.Q() != null && view == this.f19889e.T.Q().p()) {
                                    this.f19889e.T.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.f19889e;
                                    absVideoPbFragment4.T.A0(absVideoPbFragment4.J1);
                                    return;
                                }
                                d.a.q0.h2.o.g.a aVar9 = this.f19889e.T;
                                if (aVar9 != null && aVar9.Q() != null && view == this.f19889e.T.Q().h()) {
                                    d.a.p0.t.c.i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (b2 = tiebaPlusConfigData.b(this.f19889e.y().b1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.f19889e.getPageContext(), new String[]{b2});
                                    this.f19889e.T.I();
                                    return;
                                }
                                d.a.q0.h2.o.g.a aVar10 = this.f19889e.T;
                                if (aVar10 != null && (view == aVar10.M() || (this.f19889e.T.Q() != null && (view == this.f19889e.T.Q().m() || view == this.f19889e.T.Q().n())))) {
                                    if (!d.a.d.e.p.j.z()) {
                                        this.f19889e.showToast(R.string.network_not_available);
                                        return;
                                    } else if ((this.f19889e.y() == null && this.f19889e.y().L0() == null) || this.f19889e.Z.O()) {
                                        return;
                                    } else {
                                        this.f19889e.T.F();
                                        if (this.f19889e.T.Q() != null && view == this.f19889e.T.Q().n()) {
                                            i4 = this.f19889e.y().L0().N().n0() == 1 ? 5 : 4;
                                        } else if (this.f19889e.T.Q() != null && view == this.f19889e.T.Q().m()) {
                                            i4 = this.f19889e.y().L0().N().m0() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view == this.f19889e.T.M() ? 2 : 0;
                                        }
                                        ForumData m = this.f19889e.y().L0().m();
                                        String name = m.getName();
                                        String id = m.getId();
                                        String d0 = this.f19889e.y().L0().N().d0();
                                        this.f19889e.showProgressBar();
                                        this.f19889e.Z.S(id, name, d0, i4, this.f19889e.T.N());
                                        return;
                                    }
                                }
                                d.a.q0.h2.o.g.a aVar11 = this.f19889e.T;
                                if (aVar11 != null && aVar11.Q() != null && view == this.f19889e.T.Q().g()) {
                                    if (this.f19889e.y() == null) {
                                        return;
                                    }
                                    if (!d.a.d.e.p.j.z()) {
                                        this.f19889e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.f19889e.T.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.f19889e;
                                    SparseArray<Object> j3 = absVideoPbFragment5.j3(absVideoPbFragment5.y().L0(), this.f19889e.y().Z0(), 1);
                                    if (j3 == null) {
                                        return;
                                    }
                                    this.f19889e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19889e.getPageContext().getPageActivity(), this.f19889e.y().L0().m().getId(), this.f19889e.y().L0().m().getName(), this.f19889e.y().L0().N().d0(), String.valueOf(this.f19889e.y().L0().T().getUserId()), (String) j3.get(R.id.tag_forbid_user_name), (String) j3.get(R.id.tag_forbid_user_name_show), (String) j3.get(R.id.tag_forbid_user_post_id), (String) j3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                d.a.q0.h2.o.g.a aVar12 = this.f19889e.T;
                                if (aVar12 != null && aVar12.Q() != null && view == this.f19889e.T.Q().f()) {
                                    if (this.f19889e.y() == null) {
                                        return;
                                    }
                                    if (!d.a.d.e.p.j.z()) {
                                        this.f19889e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.f19889e;
                                    SparseArray<Object> j32 = absVideoPbFragment6.j3(absVideoPbFragment6.y().L0(), this.f19889e.y().Z0(), 1);
                                    if (j32 != null) {
                                        if (StringUtils.isNull((String) j32.get(R.id.tag_del_multi_forum))) {
                                            this.f19889e.T.f0(((Integer) j32.get(R.id.tag_del_post_type)).intValue(), (String) j32.get(R.id.tag_del_post_id), ((Integer) j32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) j32.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.f19889e.T.g0(((Integer) j32.get(R.id.tag_del_post_type)).intValue(), (String) j32.get(R.id.tag_del_post_id), ((Integer) j32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) j32.get(R.id.tag_del_post_is_self)).booleanValue(), (String) j32.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.f19889e.T.I();
                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText && view.getId() != R.id.pb_post_reply_count) {
                                    if (view.getId() != R.id.pb_post_reply && view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                        if (view.getId() != R.id.pb_editor_tool_collection && view.getId() != R.id.collect_num_container) {
                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                this.f19889e.u3(true);
                                            } else if (view.getId() != R.id.pb_editor_tool_comment_icon && view.getId() != R.id.thread_info_commont_container) {
                                                if (view.getId() == R.id.tv_pb_reply_more) {
                                                    if (this.f19889e.W0 >= 0) {
                                                        if (this.f19889e.y() != null) {
                                                            this.f19889e.y().Q1();
                                                        }
                                                        if (this.f19889e.O3() && this.f19889e.y() != null && this.f19889e.r3() != null && this.f19889e.r3().M0() != null) {
                                                            this.f19889e.r3().M0().f(this.f19889e.y().L0());
                                                        } else if (this.f19889e.a3() != null && this.f19889e.a3().M0() != null) {
                                                            this.f19889e.a3().M0().q(this.f19889e.y().L0());
                                                        }
                                                        this.f19889e.W0 = 0;
                                                        this.f19889e.X0 = Integer.MIN_VALUE;
                                                        if (this.f19889e.O3() && this.f19889e.y() != null && this.f19889e.r3() != null) {
                                                            this.f19889e.r3().r1(this.f19889e.y().E0(), this.f19889e.y().D0());
                                                            this.f19889e.y().U1(0, 0);
                                                        } else if (this.f19889e.y() == null || this.f19889e.a3() == null) {
                                                        } else {
                                                            this.f19889e.a3().w1(this.f19889e.y().E0(), this.f19889e.y().D0());
                                                            this.f19889e.y().U1(0, 0);
                                                        }
                                                    }
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.f19889e.y() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                    statisticItem6.param("tid", this.f19889e.y().b1());
                                                    statisticItem6.param("fid", this.f19889e.y().getForumId());
                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem6.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem6);
                                                } else if (view.getId() == R.id.pb_item_tail_content) {
                                                    if (ViewHelper.checkUpIsLogin(this.f19889e.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                        String p = d.a.p0.s.d0.b.j().p("tail_link", "");
                                                        if (!StringUtils.isNull(p)) {
                                                            TiebaStatic.log("c10056");
                                                            d.a.p0.m.a.o(view.getContext(), string, p, true, true, true);
                                                        }
                                                        this.f19889e.o4();
                                                    }
                                                } else if (view.getId() == R.id.keyboard_background_shadow) {
                                                    this.f19889e.o4();
                                                } else if (this.f19889e.T.Q() != null && view == this.f19889e.T.Q().d()) {
                                                    this.f19889e.T.F();
                                                    if (this.f19889e.y() != null) {
                                                        this.f19889e.x.f(this.f19889e.y().b1());
                                                    }
                                                    if (this.f19889e.y() == null || !this.f19889e.y().isPrivacy()) {
                                                        this.f19889e.x.b();
                                                        int i6 = (TbSingleton.getInstance().mCanCallFans || this.f19889e.y() == null || this.f19889e.y().L0() == null || this.f19889e.y().L0().P() == null || !this.f19889e.y().L0().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                        if (this.f19889e.y() == null || this.f19889e.y().L0() == null) {
                                                            return;
                                                        }
                                                        this.f19889e.x.d(3, i6, this.f19889e.y().L0().P());
                                                        return;
                                                    }
                                                    this.f19889e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                    if (this.f19889e.y().L0() != null) {
                                                        this.f19889e.x.d(3, 3, this.f19889e.y().L0().P());
                                                    }
                                                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                                                    StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                    statisticItem7.param("tid", this.f19889e.y().b1());
                                                    statisticItem7.param("fid", this.f19889e.y().getForumId());
                                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem7.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem7);
                                                    if (this.f19889e.N3()) {
                                                        StatisticItem statisticItem8 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem8.param("fid", this.f19889e.y().getForumId());
                                                        statisticItem8.param("tid", this.f19889e.y().b1());
                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem8.param("post_id", this.f19889e.e3());
                                                        statisticItem8.param("obj_source", 1);
                                                        statisticItem8.param("obj_type", 2);
                                                        statisticItem8.param("obj_locate", this.f19889e.d3());
                                                        TiebaStatic.log(statisticItem8);
                                                    }
                                                    this.f19889e.T.m0(false);
                                                    this.f19889e.T.P().onLongClick(view);
                                                }
                                            } else if (this.f19889e.y() != null) {
                                                AbsVideoPbFragment absVideoPbFragment7 = this.f19889e;
                                                if (absVideoPbFragment7.T == null || absVideoPbFragment7.f19780i == null || this.f19889e.y().L0() == null || this.f19889e.y().L0().N() == null || !this.f19889e.checkUpIsLogin()) {
                                                    return;
                                                }
                                                d.a.q0.h2.h.e L0 = this.f19889e.y().L0();
                                                int Q0 = L0.N().Q0();
                                                int currentItem = this.f19889e.f19780i.getCurrentItem();
                                                if (Q0 == 0) {
                                                    if (this.f19889e.O3() && currentItem == 0) {
                                                        this.f19889e.f19780i.setCurrentItem(1);
                                                    }
                                                    this.f19889e.S2(false);
                                                    this.f19889e.g4();
                                                    return;
                                                }
                                                if (this.f19889e.O3() && currentItem == 0) {
                                                    this.f19889e.f19780i.setCurrentItem(1);
                                                    str = "obj_source";
                                                } else if ((this.f19889e.O3() && this.f19889e.r3() == null) || this.f19889e.a3() == null || this.f19889e.q3() == null) {
                                                    return;
                                                } else {
                                                    StatisticItem param = new StatisticItem("c13403").param("tid", this.f19889e.y().b1()).param("fid", this.f19889e.y().L0().n()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    int i7 = (int) (d.a.d.e.p.l.i(this.f19889e.getContext()) * 0.6d);
                                                    BdTypeRecyclerView q3 = this.f19889e.q3();
                                                    if (q3 == null) {
                                                        return;
                                                    }
                                                    boolean canScrollVertically = q3.canScrollVertically(1);
                                                    boolean canScrollVertically2 = q3.canScrollVertically(-1);
                                                    AppBarLayout appBarLayout = this.f19889e.m;
                                                    if (appBarLayout != null) {
                                                        appBarLayout.setExpanded(false, true);
                                                    }
                                                    if (q3.getLayoutManager() == null || !(q3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                        return;
                                                    }
                                                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) q3.getLayoutManager();
                                                    if (!canScrollVertically2 && canScrollVertically) {
                                                        if (this.f19889e.U0 == -1 && this.f19889e.V0 == Integer.MIN_VALUE) {
                                                            return;
                                                        }
                                                        if (this.f19889e.U0 <= 3 && (this.f19889e.U0 != 3 || this.f19889e.V0 >= (-i7))) {
                                                            if (this.f19889e.U0 < 2) {
                                                                if (this.f19889e.U0 != 1) {
                                                                    q3.smoothScrollBy(0, -this.f19889e.V0);
                                                                } else {
                                                                    int i8 = i7 / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.f19889e.U0, this.f19889e.V0 + i8);
                                                                    q3.smoothScrollBy(0, i8);
                                                                }
                                                            } else {
                                                                int i9 = i7 / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.f19889e.U0, this.f19889e.V0 + i9);
                                                                q3.smoothScrollBy(0, i9);
                                                            }
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19889e.U0, this.f19889e.V0 + i7);
                                                            q3.smoothScrollBy(0, i7);
                                                        }
                                                        statisticItem2 = param;
                                                        statisticItem2.param("obj_locate", 2);
                                                        str = "obj_source";
                                                        i3 = 1;
                                                    } else {
                                                        statisticItem2 = param;
                                                        int firstVisiblePosition = q3.getFirstVisiblePosition();
                                                        View childAt = q3.getChildAt(0);
                                                        if (childAt == null) {
                                                            str = "obj_source";
                                                            top = 0;
                                                        } else {
                                                            top = childAt.getTop();
                                                            str = "obj_source";
                                                        }
                                                        this.f19889e.U0 = firstVisiblePosition;
                                                        this.f19889e.V0 = top;
                                                        if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || q3.getCount() < 6)) {
                                                            q3.smoothScrollToPosition(0);
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                            q3.smoothScrollToPosition(0);
                                                        }
                                                        i3 = 1;
                                                        statisticItem2.param("obj_locate", 1);
                                                    }
                                                    TiebaStatic.log(statisticItem2);
                                                    d.a.p0.k0.c f2 = TbPageExtraHelper.f(view);
                                                    StatisticItem statisticItem9 = new StatisticItem("c12942");
                                                    statisticItem9.param("obj_type", i3);
                                                    statisticItem9.param("obj_locate", 4);
                                                    statisticItem9.param("tid", this.f19889e.y().b1());
                                                    statisticItem9.param("nid", L0.N().B0());
                                                    if (f2 != null) {
                                                        statisticItem9.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                    }
                                                    if (TbPageExtraHelper.m() != null) {
                                                        statisticItem9.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                    }
                                                    TiebaStatic.log(statisticItem9);
                                                }
                                                if (this.f19889e.y() == null || this.f19889e.y().L0() == null || this.f19889e.y().L0().N() == null || this.f19889e.y().L0().N().H() == null) {
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19889e.y().b1()).param("fid", this.f19889e.y().L0().n()).param("obj_locate", 2).param("uid", this.f19889e.y().L0().N().H().getUserId()));
                                                if (this.f19889e.N3()) {
                                                    StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem10.param("fid", this.f19889e.y().getForumId());
                                                    statisticItem10.param("tid", this.f19889e.y().b1());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("post_id", this.f19889e.e3());
                                                    statisticItem10.param(str, 1);
                                                    statisticItem10.param("obj_type", 12);
                                                    statisticItem10.param("obj_locate", this.f19889e.d3());
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                            }
                                        } else if (!d.a.d.e.p.j.z()) {
                                            this.f19889e.showToast(R.string.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment8 = this.f19889e;
                                            if (absVideoPbFragment8.T == null || absVideoPbFragment8.y() == null) {
                                                return;
                                            }
                                            if (this.f19889e.O3() && this.f19889e.r3() == null) {
                                                return;
                                            }
                                            if (this.f19889e.O3() || this.f19889e.a3() != null) {
                                                this.f19889e.T.F();
                                                if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19889e.getActivity(), "pb_shoucang"))) {
                                                    if (!this.f19889e.J2(11009) || this.f19889e.y() == null) {
                                                        return;
                                                    }
                                                    this.f19889e.X3();
                                                    if (this.f19889e.y().L0() != null && this.f19889e.y().L0().N() != null && this.f19889e.y().L0().N().H() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19889e.y().b1()).param("fid", this.f19889e.y().L0().n()).param("obj_locate", 3).param("uid", this.f19889e.y().L0().N().H().getUserId()));
                                                        if (this.f19889e.N3()) {
                                                            StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem11.param("fid", this.f19889e.y().getForumId());
                                                            statisticItem11.param("tid", this.f19889e.y().b1());
                                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem11.param("post_id", this.f19889e.e3());
                                                            statisticItem11.param("obj_source", 1);
                                                            statisticItem11.param("obj_type", 13);
                                                            statisticItem11.param("obj_locate", this.f19889e.d3());
                                                            TiebaStatic.log(statisticItem11);
                                                        }
                                                    }
                                                    if (this.f19889e.y().L0().N() == null || this.f19889e.y().L0().N().H() == null || this.f19889e.y().L0().N().H().getUserId() == null || this.f19889e.V == null) {
                                                        return;
                                                    }
                                                    AbsVideoPbFragment absVideoPbFragment9 = this.f19889e;
                                                    int S = absVideoPbFragment9.T.S(absVideoPbFragment9.y().L0());
                                                    d.a.p0.s.q.b2 N = this.f19889e.y().L0().N();
                                                    if (N.F1()) {
                                                        i2 = 2;
                                                    } else if (N.I1()) {
                                                        i2 = 3;
                                                    } else if (N.G1()) {
                                                        i2 = 4;
                                                    } else {
                                                        i2 = N.H1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19889e.y().b1()).param("obj_locate", 1).param("obj_id", this.f19889e.y().L0().N().H().getUserId()).param("obj_type", !this.f19889e.V.e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
                                                this.f19889e.D = view;
                                            }
                                        }
                                    } else if (this.f19889e.y() == null) {
                                    } else {
                                        if (view.getId() == R.id.pb_post_reply) {
                                            StatisticItem statisticItem12 = new StatisticItem("c13398");
                                            statisticItem12.param("tid", this.f19889e.y().b1());
                                            statisticItem12.param("fid", this.f19889e.y().getForumId());
                                            statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem12.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem12);
                                        }
                                        if (view.getId() == R.id.post_info_commont_img) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19889e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                this.f19889e.C = view;
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19889e.getActivity(), "pb_huifu_louzhonglou"))) {
                                            this.f19889e.C = view;
                                            return;
                                        }
                                        if (this.f19889e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.j0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f19889e.y().c1()).param("fid", this.f19889e.y().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.f19889e.y() == null || this.f19889e.y().L0() == null || this.f19889e.Q0 == null || postData2.t() == null || postData2.A() == 1) {
                                                    return;
                                                }
                                                if (this.f19889e.P0 != null) {
                                                    this.f19889e.P0.c();
                                                }
                                                if (this.f19889e.Z0 && postData2.M() != null && postData2.M().size() != 0) {
                                                    this.f19889e.V4(postData2, null, true, false);
                                                    return;
                                                }
                                                d.a.q0.h2.h.r rVar2 = new d.a.q0.h2.h.r();
                                                rVar2.A(this.f19889e.y().L0().m());
                                                rVar2.E(this.f19889e.y().L0().N());
                                                rVar2.C(postData2);
                                                this.f19889e.Q0.R(rVar2);
                                                this.f19889e.Q0.setPostId(postData2.E());
                                                this.f19889e.V3(view, postData2.t().getUserId(), "", postData2);
                                                if (this.f19889e.N0 != null) {
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.f19889e;
                                                    absVideoPbFragment10.w4(absVideoPbFragment10.N0.D());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                        StatisticItem statisticItem13 = new StatisticItem("c13398");
                                        statisticItem13.param("tid", this.f19889e.y().b1());
                                        statisticItem13.param("fid", this.f19889e.y().getForumId());
                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem13.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem13);
                                        if (this.f19889e.N3()) {
                                            StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem14.param("fid", this.f19889e.y().getForumId());
                                            statisticItem14.param("tid", this.f19889e.y().b1());
                                            statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem14.param("post_id", this.f19889e.e3());
                                            statisticItem14.param("obj_source", 1);
                                            statisticItem14.param("obj_type", 8);
                                            statisticItem14.param("obj_locate", this.f19889e.d3());
                                            TiebaStatic.log(statisticItem14);
                                        }
                                    }
                                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new d.a.p0.s.q.s0(this.f19889e.getActivity(), "pb_chakanhuifu"))) {
                                        this.f19889e.B = view;
                                        return;
                                    }
                                    if (view.getId() == R.id.pb_floor_reply_more && this.f19889e.N3()) {
                                        StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem15.param("fid", this.f19889e.y().getForumId());
                                        statisticItem15.param("tid", this.f19889e.y().b1());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("post_id", this.f19889e.e3());
                                        statisticItem15.param("obj_source", 1);
                                        statisticItem15.param("obj_type", 9);
                                        statisticItem15.param("obj_locate", this.f19889e.d3());
                                        TiebaStatic.log(statisticItem15);
                                    }
                                    if (!this.f19889e.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f19889e.y().L0().n()));
                                    } else if (this.f19889e.y() == null || this.f19889e.y().L0() == null) {
                                    } else {
                                        d.a.q0.h2.o.g.a aVar13 = this.f19889e.T;
                                        if (aVar13 != null) {
                                            aVar13.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                        PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_reply_data);
                                        if (postData3 == null) {
                                            return;
                                        }
                                        if (postData3.C() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem16 = postData3.j0;
                                        if (statisticItem16 != null) {
                                            StatisticItem copy2 = statisticItem16.copy();
                                            copy2.delete("obj_locate");
                                            if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.f19889e.X4();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.f19889e.V4(postData3, postData4, false, true);
                                        } else {
                                            this.f19889e.V4(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!d.a.d.e.p.j.z()) {
                        this.f19889e.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.f19889e.T.F();
                        if (!this.f19889e.R) {
                            this.f19889e.X4();
                            this.f19889e.D4();
                            if (view.getId() == R.id.owner_reply) {
                                l2 = this.f19889e.y().l2(true, this.f19889e.e3());
                            } else {
                                l2 = view.getId() == R.id.all_reply ? this.f19889e.y().l2(false, this.f19889e.e3()) : this.f19889e.y().k2(this.f19889e.e3());
                            }
                            view.setTag(Boolean.valueOf(l2));
                            if (l2) {
                                this.f19889e.N4();
                                i5 = 1;
                                this.f19889e.R = true;
                            } else {
                                i5 = 1;
                            }
                            TiebaStatic.eventStat(this.f19889e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                            return;
                        }
                        view.setTag(Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19890a;

        public y0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19890a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19890a.Q0.M(postData);
                if (this.f19890a.a3() != null) {
                    this.f19890a.a3().o1();
                } else if (this.f19890a.O3() && this.f19890a.r3() != null) {
                    this.f19890a.r3().l1();
                }
                this.f19890a.P0.c();
                this.f19890a.O0.q();
                this.f19890a.K4(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y1 implements d.a.p0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19891a;

        public y1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19891a = absVideoPbFragment;
        }

        @Override // d.a.p0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.q0.h2.k.e.v0 v0Var = this.f19891a.K0;
                if (v0Var == null || v0Var.e() == null || !this.f19891a.K0.e().d()) {
                    return !this.f19891a.L2(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.f19891a;
                absVideoPbFragment.showToast(absVideoPbFragment.K0.e().c());
                if (this.f19891a.N0 != null && (this.f19891a.N0.C() || this.f19891a.N0.E())) {
                    this.f19891a.N0.A(false, this.f19891a.K0.h());
                }
                this.f19891a.K0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19892e;

        public z(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19892e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            d.a.q0.h2.o.g.a aVar = this.f19892e.T;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.f19892e.T.B(sparseArray);
                        return;
                    }
                    aVar.j0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.f19892e.T.B(sparseArray);
                } else if (booleanValue3) {
                    aVar.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19893e;

        public z0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19893e = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f19893e.T.m0(true);
                return this.f19893e.T.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z1(AbsVideoPbFragment absVideoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
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
            this.f19894a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19894a.y() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f19894a.N0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.f19894a;
                absVideoPbFragment.w4(absVideoPbFragment.N0.D());
            }
            this.f19894a.o4();
            this.f19894a.T.F();
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
        R1 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        S1 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
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
        this.f19777f = 0L;
        this.y = false;
        this.G = new k(this);
        this.R = false;
        this.V = null;
        this.Y = null;
        this.Z = null;
        this.m0 = false;
        this.p0 = null;
        this.s0 = null;
        this.B0 = false;
        this.C0 = null;
        this.D0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.S0 = new int[2];
        this.U0 = -1;
        this.V0 = Integer.MIN_VALUE;
        this.W0 = 0;
        this.X0 = Integer.MIN_VALUE;
        this.Y0 = false;
        this.Z0 = d.a.p0.b.d.p0();
        this.b1 = new v(this, 2921552);
        this.c1 = new c1(this);
        this.d1 = new n1(this);
        this.e1 = new y1(this);
        this.f1 = new z1(this, 2004016);
        this.g1 = new a2(this, 2004007);
        this.h1 = new a(this, 2921391);
        this.i1 = new b(this, 2016450);
        this.j1 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.k1 = new d(this, 2001426);
        this.l1 = new e(this, 2001427);
        this.m1 = new f(this, 2001428);
        this.n1 = new g(this);
        this.o1 = new h(this);
        this.p1 = new i(this);
        this.q1 = new j(this, 2004008);
        this.r1 = 0;
        this.v1 = true;
        this.w1 = new l(this);
        this.y1 = new m(this);
        this.z1 = new n(this);
        this.C1 = new o(this);
        this.D1 = new p(this);
        this.E1 = new q(this);
        this.F1 = new s(this);
        this.G1 = new x(this);
        this.H1 = new y(this);
        this.I1 = new z(this);
        this.J1 = new a0(this);
        this.K1 = new b0(this, 2001332);
        this.L1 = new l0(this, 2001440);
        this.M1 = new m0(this);
        this.N1 = new s0(this);
        this.O1 = new v0(this, 2921509);
        this.P1 = new z0(this);
        this.Q1 = new a1(this);
        this.z0 = new b2(this, null);
    }

    public void A3() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (rightFloatLayerView = this.a1) == null) {
            return;
        }
        rightFloatLayerView.f();
    }

    public final void A4(d.a.p0.x.w.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null || y() == null) {
            return;
        }
        gVar.o(y().n0());
        if (y().L0() != null && y().L0().m() != null) {
            gVar.n(y().L0().m());
        }
        gVar.p("pb");
        gVar.q(y());
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n0 = (LinearLayout) this.f19778g.findViewById(R.id.video_pb_comment_container);
            this.o0 = this.f19778g.findViewById(R.id.view_comment_top_line);
            this.p0 = this.f19778g.findViewById(R.id.pb_editor_tool_comment);
            d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
            HeadImageView headImageView = (HeadImageView) this.f19778g.findViewById(R.id.pb_editor_tool_comment_user_image);
            this.r0 = headImageView;
            headImageView.setVisibility(0);
            this.r0.setIsRound(true);
            this.r0.setBorderWidth(d.a.d.e.p.l.g(getContext(), R.dimen.L_X01));
            this.r0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.r0.setPlaceHolder(0);
            U3();
            this.s0 = (TextView) this.f19778g.findViewById(R.id.pb_editor_tool_comment_reply_text);
            LinearLayout linearLayout = (LinearLayout) this.f19778g.findViewById(R.id.pb_editer_tool_comment_layout);
            this.q0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.f19778g.findViewById(R.id.pb_editor_tool_comment_icon);
            this.t0 = imageView;
            imageView.setOnClickListener(this.H1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f19778g.findViewById(R.id.pb_editor_tool_collection);
            this.u0 = imageView2;
            imageView2.setOnClickListener(this.H1);
            if (booleanExtra) {
                this.u0.setVisibility(8);
            } else {
                this.u0.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) this.f19778g.findViewById(R.id.pb_editor_tool_share);
            this.v0 = imageView3;
            imageView3.setOnClickListener(this.H1);
            d.a.q0.h2.p.h hVar = new d.a.q0.h2.p.h(this.v0);
            this.w0 = hVar;
            hVar.d();
            TextView textView = (TextView) this.f19778g.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.x0 = textView;
            textView.setVisibility(0);
            K4(false);
            if (d.a.p0.e1.b.e.d()) {
                ViewGroup.LayoutParams layoutParams = this.n0.getLayoutParams();
                layoutParams.height = 0;
                this.n0.setLayoutParams(layoutParams);
            }
        }
    }

    public void B4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            d.a.q0.h2.o.g.a aVar = this.T;
            if (aVar == null) {
                return;
            }
            if (z2) {
                aVar.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.T.G();
            } else {
                this.T.F();
            }
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || y() == null || y().L0() == null || y().L0().N() == null) {
            return;
        }
        d.a.p0.s.q.b2 N = y().L0().N();
        N.V0 = y().Q0();
        N.U0 = y().T0();
        N.T0 = y().S0();
        N.W0 = y().R0();
        N.D2 = y().z0();
        if (N.R() == 0) {
            N.o3(d.a.d.e.m.b.f(y().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.p0.l0.c.i(getContext(), N, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.Q0 = new PbFakeFloorModel(getPageContext());
            PbModel y2 = y();
            this.Q0.O(y2.E(), y2.A(), y2.B(), y2.z(), y2.F());
            this.Q0.setFromForumId(y2.getFromForumId());
            d.a.q0.h2.k.e.u uVar = new d.a.q0.h2.k.e.u(getPageContext(), this.Q0, this.f19778g);
            this.P0 = uVar;
            uVar.k(new x0(this));
            this.P0.m(this.F1);
            this.Q0.Q(new y0(this));
        }
    }

    public void C4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideProgressBar();
            if (O3() && r3() != null) {
                r3().Z0();
                r3().a1();
            } else if (a3() != null) {
                a3().b1();
                a3().c1();
            }
        }
    }

    @Override // d.a.q0.h2.o.a
    public void D0(boolean z2, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public final void D2(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) || y() == null || y().L0() == null || y().L0().N() == null) {
            return;
        }
        d.a.p0.s.q.b2 N = y().L0().N();
        N.V0 = y().Q0();
        N.U0 = y().T0();
        N.T0 = y().S0();
        N.W0 = y().R0();
        if (N.R() == 0) {
            N.o3(d.a.d.e.m.b.f(y().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.p0.l0.c.i(getContext(), N, "c13563");
        TbPageTag l2 = d.a.p0.l0.c.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.param("obj_type", 2);
            } else {
                i2.param("obj_type", 1);
            }
            d.a.p0.k0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i2);
        }
        if (i2 != null) {
            if (d3() == 1) {
                i2.param("obj_locate", 4);
            } else if (d3() == 2) {
                i2.param("obj_locate", 5);
            } else if (d3() == 3) {
                i2.param("obj_locate", 2);
            } else if (d3() == 4) {
                i2.param("obj_locate", 3);
            } else {
                i2.param("obj_locate", 6);
            }
            i2.param("obj_type", 1);
            i2.param("tid", y().b1());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.param("fid", y().L0().n());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = d.a.p0.l0.c.i(getContext(), N, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.param("obj_type", 2);
        } else {
            i3.param("obj_type", 1);
        }
        i3.param("tid", y().b1());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", y().L0().n());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = d.a.p0.l0.c.i(getContext(), N, "c14303");
        if (i4 != null) {
            if (d3() == 1) {
                i4.param("obj_locate", 1);
            } else if (d3() == 2) {
                i4.param("obj_locate", 2);
            } else if (d3() == 3) {
                i4.param("obj_locate", 3);
            } else if (d3() == 4) {
                i4.param("obj_locate", 4);
            }
            i3.param("tid", y().b1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", y().L0().n());
            i3.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            v4(this.N0.a());
        }
    }

    public void D4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.d.e.p.l.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E2(d.a.p0.s.q.b2 b2Var) {
        double d2;
        int ceil;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        Rect f02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b2Var) == null) {
            double k2 = d.a.d.e.p.l.k(getContext());
            double i3 = (2.0d * k2) / d.a.d.e.p.l.i(getContext());
            if (b2Var != null && b2Var.m1() != null) {
                int intValue = b2Var.m1().video_width.intValue();
                int intValue2 = b2Var.m1().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= i3) {
                        i3 = d2;
                    }
                    ceil = (int) Math.ceil(k2 / i3);
                    int height = (y() != null || (f02 = y().f0()) == null) ? ceil : f02.height();
                    i2 = 0;
                    layoutParams = this.n.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, height);
                    } else {
                        i2 = layoutParams.height - height;
                        layoutParams.height = height;
                    }
                    this.n.setLayoutParams(layoutParams);
                    this.n.setMaxHeight(ceil);
                    this.n.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
                    this.n.setOriginHeight(height);
                    if (O3() && !d.a.p0.e1.b.e.d()) {
                        layoutParams3 = (RelativeLayout.LayoutParams) this.f19779h.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, S1);
                        } else {
                            layoutParams3.height = S1;
                        }
                        this.f19779h.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
                    if (O3() && !d.a.p0.e1.b.e.d()) {
                        ceil += S1;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ceil;
                    }
                    this.m.setLayoutParams(layoutParams2);
                    if (i2 == 0 && (this.m.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.m.getLayoutParams()).getBehavior();
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
            ceil = (int) Math.ceil(k2 / i3);
            if (y() != null) {
            }
            i2 = 0;
            layoutParams = this.n.getLayoutParams();
            if (layoutParams != null) {
            }
            this.n.setLayoutParams(layoutParams);
            this.n.setMaxHeight(ceil);
            this.n.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
            this.n.setOriginHeight(height);
            if (O3()) {
                layoutParams3 = (RelativeLayout.LayoutParams) this.f19779h.getLayoutParams();
                if (layoutParams3 != null) {
                }
                this.f19779h.setLayoutParams(layoutParams3);
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
            if (O3()) {
                ceil += S1;
            }
            if (layoutParams2 != null) {
            }
            this.m.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void E3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            d.a.p0.x.w.g gVar = new d.a.p0.x.w.g();
            this.M0 = gVar;
            A4(gVar);
            d.a.p0.x.w.e eVar = (d.a.p0.x.w.e) this.M0.a(getActivity());
            this.N0 = eVar;
            eVar.f0(this.f19776e.getPageContext());
            this.N0.o0(this.o1);
            this.N0.p0(this.G1);
            this.N0.h0(1);
            this.N0.G(this.f19776e.getPageContext(), bundle);
            this.N0.a().b(new d.a.p0.x.k(getActivity()));
            this.N0.a().C(true);
            H4(true);
            this.N0.P(y().p0(), y().b1(), y().m0());
            registerListener(this.g1);
            registerListener(this.i1);
            registerListener(this.q1);
            registerListener(this.f1);
            registerListener(this.h1);
            registerListener(this.j1);
            registerListener(this.O1);
            if (!y().z0()) {
                this.N0.t(y().b1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.N0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (y().k1()) {
                this.N0.l0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.N0.l0(s3());
            }
            this.K0 = new d.a.q0.h2.k.e.v0();
            if (this.N0.w() != null) {
                this.K0.m(this.N0.w().i());
            }
            this.N0.e0(this.e1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.H0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new k0(this));
        }
    }

    public final void E4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || y() == null) {
            return;
        }
        int U0 = y().U0();
        if (i2 == 5) {
            y().e2(2);
        } else if (i2 == 6) {
            y().e2(3);
        } else if (i2 != 7) {
            y().e2(1);
        } else {
            y().e2(4);
        }
        int U02 = y().U0();
        if (U0 == 4 || U02 == 4) {
            a4();
        }
    }

    public final void F2(d.a.q0.h2.o.i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) && aVar != null && this.A == null) {
            this.A = aVar;
            this.H.setText(aVar.getTitle());
            this.I.setText(aVar.j());
            String h2 = aVar.h();
            TBSpecificationBtn tBSpecificationBtn = this.K;
            if (TextUtils.isEmpty(h2)) {
                h2 = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(h2);
            this.L.M(aVar.d(), 10, false);
            this.M.setVisibility(aVar.o() ? 0 : 8);
            d.a.d.e.m.e.a().postDelayed(new j1(this), aVar.c().longValue() * 1000);
        }
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.P = (FallingView) this.f19778g.findViewById(R.id.falling_view);
            TbImageView tbImageView = (TbImageView) this.f19778g.findViewById(R.id.falling_ad_view);
            this.Q = tbImageView;
            tbImageView.setPlaceHolder(2);
        }
    }

    public void F4(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (view = this.k) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || y() == null || this.f19776e == null) {
            return;
        }
        d.a.p0.x.w.e eVar = this.N0;
        if (eVar == null || !eVar.z) {
            d.a.p0.x.w.d dVar = new d.a.p0.x.w.d();
            A4(dVar);
            d.a.p0.x.w.e eVar2 = (d.a.p0.x.w.e) dVar.a(getContext());
            this.N0 = eVar2;
            eVar2.f0(this.f19776e.getPageContext());
            this.N0.o0(this.o1);
            this.N0.p0(this.G1);
            this.N0.G(this.f19776e.getPageContext(), this.f19776e.getIntent() == null ? null : this.f19776e.getIntent().getExtras());
            this.N0.a().C(true);
            v4(this.N0.a());
            if (!y().z0()) {
                this.N0.t(y().b1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.N0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (y().k1()) {
                this.N0.l0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.N0.l0(s3());
            }
        }
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.H = (TextView) this.f19778g.findViewById(R.id.pb_video_mount_title);
            this.L = (TbImageView) this.f19778g.findViewById(R.id.pb_video_mount_pic);
            this.I = (TextView) this.f19778g.findViewById(R.id.pb_video_mount_desc);
            this.J = (ImageView) this.f19778g.findViewById(R.id.pb_video_mount_close);
            this.K = (TBSpecificationBtn) this.f19778g.findViewById(R.id.pb_video_mount_link);
            this.M = this.f19778g.findViewById(R.id.ala_live_point);
            this.L.setRadius(d.a.d.e.p.l.g(getContext(), R.dimen.tbds10));
            this.L.setConrers(15);
            this.K.setConfig(new d.a.p0.s.f0.n.c());
            this.J.setOnClickListener(new t0(this));
            this.K.setOnClickListener(this.G);
            this.z.setOnClickListener(this.G);
            if (y() == null || y().L0() == null) {
                return;
            }
            M4(y().L0());
        }
    }

    public void G4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            this.y = z2;
        }
    }

    @Override // d.a.q0.h2.o.b
    public PbFragment H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public void H2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().B(firstVisiblePosition)) != null && postData.p() != null) {
                        postData.p().j(postData.A());
                        arrayList.add(postData.p());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x1(this));
                if (((d.a.p0.u.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                    W4();
                    d4((d.a.p0.u.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    W4();
                    d4((d.a.p0.u.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f19778g.findViewById(R.id.video_pb_navigation_bar);
            this.q = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.q.hideBottomLine();
            this.q.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.q.getTopCoverBgView().setVisibility(0);
            this.r = this.f19778g.findViewById(R.id.statebar);
            View findViewById = this.f19778g.findViewById(R.id.status_bar_background);
            this.s = findViewById;
            if (this.u1) {
                ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
                layoutParams.height = d.a.d.e.p.l.r(z());
                this.r.setLayoutParams(layoutParams);
                this.r.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = d.a.d.e.p.l.r(z());
                this.s.setLayoutParams(layoutParams2);
                this.s.setVisibility(0);
            }
            View addSystemImageButton = this.q.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.H1);
            this.t = addSystemImageButton;
            this.u = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.q.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.H1);
            this.v = addCustomView;
            this.w = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.v.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.w, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.v.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.x1 = new GestureDetector(getContext(), this.y1);
            this.q.setOnTouchListener(this.w1);
        }
    }

    public final void H4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.N0.g0(z2);
            this.N0.j0(z2);
            this.N0.q0(z2);
        }
    }

    public final boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel y2 = y();
            if (y2 == null || y2.L0() == null) {
                return false;
            }
            d.a.p0.s.q.b2 N = y2.L0().N();
            y2.L0().d();
            return AntiHelper.b(getPageContext(), N);
        }
        return invokeV.booleanValue;
    }

    public void I3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (editorTools = this.O0) == null) {
            return;
        }
        editorTools.j();
        d.a.p0.x.w.e eVar = this.N0;
        if (eVar != null) {
            eVar.Q();
        }
        v3();
    }

    public final void I4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048602, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                d.a.q0.h2.o.g.a aVar = this.T;
                if (aVar != null) {
                    aVar.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final boolean J2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void J3(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, eVar) == null) || this.a1 == null || eVar == null || eVar.g() == 3 || N3()) {
            return;
        }
        d.a.q0.h2.o.j.a aVar = new d.a.q0.h2.o.j.a();
        this.F = aVar;
        aVar.e(eVar.k() == null ? null : eVar.k().pbpage);
        this.F.d(TbSingleton.getInstance().getAdFloatViewData());
        A3();
        if (this.a1.n()) {
            String a3 = this.F.a(eVar.g0());
            if (StringUtils.isNull(a3)) {
                return;
            }
            this.a1.setData(a3);
            TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
            this.a1.setLogoListener(new g0(this, this.F.b(eVar.g0())));
            this.a1.setFeedBackListener(new r0(this));
        }
    }

    public final void J4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
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
        if (y() != null && !y().z0()) {
            antiData.setBlock_forum_name(y().L0().m().getName());
            antiData.setBlock_forum_id(y().L0().m().getId());
            antiData.setUser_name(y().L0().T().getUserName());
            antiData.setUser_id(y().L0().T().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public boolean K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if ((y() != null && y().L0().e0()) || this.H0 == null || y() == null || y().L0() == null || ThreadCardUtils.isSelf(y().L0().N()) || y().L0().d() == null) {
                return true;
            }
            return this.H0.checkPrivacyBeforeInvokeEditor(y().L0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f19779h.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.f19779h.setContainerLayoutParams(layoutParams);
            this.f19779h.setRectPaintColor(R.color.CAM_X0302);
            this.f19779h.C(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.f19779h.setIndicatorOffset(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.f19779h.setIndicatorOvershot(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.f19779h.setIndicatorMarginBottom(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f19779h.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) || this.p0 == null || d.a.p0.e1.b.e.d()) {
            return;
        }
        w4(this.N0.D());
        if (this.B0) {
            L4(z2);
        } else {
            w3(z2);
        }
        e4();
        h4();
    }

    public boolean L2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            if (this.H0 == null || y() == null || y().L0() == null || ThreadCardUtils.isSelf(y().L0().N()) || y().L0().d() == null) {
                return true;
            }
            return this.H0.checkPrivacyBeforeSend(y().L0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            d.a.q0.i0.b bVar = new d.a.q0.i0.b(getActivity());
            this.R0 = bVar;
            bVar.i(this.E1);
            this.u1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            H3();
            this.m = (AppBarLayout) this.f19778g.findViewById(R.id.appbar_layout);
            this.k = this.f19778g.findViewById(R.id.pb_video_pager_shadow);
            this.a1 = (RightFloatLayerView) this.f19778g.findViewById(R.id.right_layer_view);
            registerListener(this.b1);
            this.n = (VideoContainerLayout) this.f19778g.findViewById(R.id.pb_video_container);
            d.a.q0.h2.o.k.a aVar = new d.a.q0.h2.o.k.a(getContext(), this.n);
            this.o = aVar;
            aVar.setStageType("2002");
            this.o.setUniqueId(getUniqueId());
            this.o.c1(this);
            this.o.a1(z().getRootView());
            this.o.b1(this.s);
            ((RelativeLayout) this.f19778g.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((d.a.d.e.p.l.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.f19779h = (NewPagerSlidingTabBaseStrip) this.f19778g.findViewById(R.id.pb_video_tab_strip);
            this.z = this.f19778g.findViewById(R.id.pb_video_mount_layout);
            this.f19780i = (CustomViewPager) this.f19778g.findViewById(R.id.pb_video_view_pager);
            this.l = this.f19778g.findViewById(R.id.keyboard_background_shadow);
            this.E = (MaskView) this.f19778g.findViewById(R.id.mask_view);
            this.l.setOnClickListener(this.H1);
            K3();
            G3();
            B3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.j = videoPbFragmentAdapter;
            this.f19780i.setAdapter(videoPbFragmentAdapter);
            this.f19779h.setViewPager(this.f19780i);
            this.f19779h.setOnPageChangeListener(new n0(this));
            this.S = this.f19778g.findViewById(R.id.viewstub_progress);
            D3();
            F3();
            C3();
            if (!this.u1 && this.v1) {
                T4();
                UtilHelper.hideStatusBar(z(), z().getRootView());
                this.v1 = false;
            }
            if (!O3() || d.a.p0.e1.b.e.d()) {
                this.f19779h.getLayoutParams().height = 0;
            }
            if (d.a.p0.e1.b.e.d()) {
                this.f19780i.setScrollable(false);
            }
        }
    }

    public void L4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) || this.p0 == null || (textView = this.s0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.p0.startAnimation(alphaAnimation);
        }
        this.o0.setVisibility(0);
        this.p0.setVisibility(0);
        this.z0.f19788a = true;
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (!checkUpIsLogin()) {
                if (y() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", y().getForumId()));
                }
            } else if (K2()) {
                d.a.p0.x.w.e eVar = this.N0;
                if (eVar != null && (eVar.C() || this.N0.E())) {
                    this.N0.A(false, null);
                    return;
                }
                if (this.O0 != null) {
                    I3();
                    this.z0.f19788a = false;
                    if (this.O0.n(2) != null) {
                        d.a.q0.h3.g0.a.c(getPageContext(), (View) this.O0.n(2).k, false, null);
                    }
                }
                v3();
            }
        }
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.p == null) {
            this.p = new d.a.q0.h2.o.e(getBaseFragmentActivity(), this.n);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? d.a.d.e.p.l.r(z()) : 0;
            Rect rect = new Rect(0, r2, d.a.d.e.p.l.k(getContext()), this.n.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.p.r(videoPbViewModel.h(), rect);
            if (this.p.l()) {
                this.p.q(new j0(this, videoPbViewModel));
            } else if (!d.a.p0.e1.b.e.d() && O3() && (videoPbViewModel.m() || y().a1() == 1)) {
                this.f19780i.setCurrentItem(1);
            } else if (videoPbViewModel.m() || y().a1() == 0) {
                this.f19780i.setCurrentItem(0);
            }
        }
    }

    public final void M4(d.a.q0.h2.h.e eVar) {
        d.a.q0.h2.o.i.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, eVar) == null) || (F = eVar.F()) == null || F.p) {
            return;
        }
        F2(F);
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (y().r0() || y().u0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", y().b1());
                this.f19776e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, y().b1()));
            if (Z4()) {
                this.f19776e.finish();
            }
        }
    }

    public abstract boolean N3();

    public void N4() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (view = this.S) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void O2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bVar) == null) {
            List<PostData> list = y().L0().S().f57500a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).M().size()) {
                        break;
                    } else if (bVar.f21303g.equals(list.get(i2).M().get(i3).E())) {
                        list.get(i2).M().remove(i3);
                        list.get(i2).l();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).n(bVar.f21303g);
            }
            if (z2) {
                if (a3() != null) {
                    a3().o1();
                } else if (O3() && r3() != null) {
                    r3().l1();
                }
            }
        }
    }

    public boolean O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? (N3() || y() == null || !y().p1()) ? false : true : invokeV.booleanValue;
    }

    public final void O4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            d.a.q0.h2.o.j.b.c(z(), Z2(), i2);
        }
    }

    public void P2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (y().j0() != null) {
                        y().j0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.Z.O()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (jSONArray != null) {
                    this.Z.Q(StringHelper.JsonArrayToString(jSONArray));
                }
                this.Z.R(y().L0().m().getId(), y().L0().m().getName(), y().L0().N().d0(), str, intValue3, intValue2, booleanValue, y().L0().N().J());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    public final boolean P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            d.a.q0.h2.o.k.a aVar = this.o;
            return aVar != null && aVar.R0();
        }
        return invokeV.booleanValue;
    }

    public final void P4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || y() == null || d.a.d.e.p.k.isEmpty(y().b1())) {
            return;
        }
        d.a.p0.a.d.y().P(d.a.p0.a.c.W, d.a.d.e.m.b.f(y().b1(), 0L));
    }

    public void Q2(d.a.p0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (y() == null || y().L0() == null || y().L0().N() == null || y().L0().m() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    P2((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.v1 : invokeV.booleanValue;
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || this.z.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            b5();
        }
    }

    public void R2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                P2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            d.a.q0.h2.o.k.a aVar = this.o;
            if (aVar == null) {
                return false;
            }
            return aVar.S0();
        }
        return invokeV.booleanValue;
    }

    public void R4(d.a.p0.u.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048629, this, aVar, bitmap, i2) == null) && d.a.q0.h2.k.e.r0.a(aVar, i2)) {
            Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new p0(this, random));
            bVar.q(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d.a.q0.h2.p.c l2 = bVar.l();
            this.P.f();
            this.P.a(l2, 22);
            d.a.d.e.m.e.a().postDelayed(this.N1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.Q;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new q0(this, aVar, i2));
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void S(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048630, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.p0.d1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.p0.d1.m.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (d.a.q0.h2.k.e.y0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.p0.d1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void S2(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) || (appBarLayout = this.m) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public final void S3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void S4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (layoutParams = this.z.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.z.setAlpha(0.0f);
            this.z.setVisibility(0);
            d5(layoutParams);
        }
    }

    public final void T2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048634, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f21298b) ? bVar.f21298b : getString(R.string.delete_fail);
            int i2 = 0;
            if (bVar.f21299c == 1211066) {
                hideProgressBar();
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new r(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                U2(0, bVar.f21297a, bVar.f21298b, z2);
            }
            if (bVar.f21297a) {
                int i3 = bVar.f21300d;
                if (i3 == 1) {
                    ArrayList<PostData> E = y().L0().E();
                    int size = E.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f21303g.equals(E.get(i2).E())) {
                            E.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    y().L0().N().U3(y().L0().N().Q0() - 1);
                    if (a3() != null) {
                        a3().o1();
                    } else if (O3() && r3() != null) {
                        r3().l1();
                    }
                } else if (i3 == 0) {
                    N2();
                } else if (i3 == 2) {
                    ArrayList<PostData> E2 = y().L0().E();
                    int size2 = E2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= E2.get(i4).M().size()) {
                                break;
                            } else if (bVar.f21303g.equals(E2.get(i4).M().get(i5).E())) {
                                E2.get(i4).M().remove(i5);
                                E2.get(i4).l();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        E2.get(i4).n(bVar.f21303g);
                    }
                    if (z3) {
                        if (a3() != null) {
                            a3().o1();
                        } else if (O3() && r3() != null) {
                            r3().l1();
                        }
                    }
                    O2(bVar);
                }
            }
        }
    }

    public final void T3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (this.B1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
                this.B1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.B1.start();
        }
    }

    public void U2(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.success));
            } else if (z3) {
                if (d.a.d.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                showToast(str);
            }
        }
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.r0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.r0.setImageResource(0);
                this.r0.M(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.r0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.A1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
                this.A1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.A1.start();
        }
    }

    public final void V2(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048640, this, i2, gVar) == null) || gVar == null || y() == null || y().L0() == null || y().L0().N() == null) {
            return;
        }
        U2(this.Z.getLoadDataMode(), gVar.f21318a, gVar.f21319b, false);
        if (gVar.f21318a) {
            this.D0 = true;
            if (i2 == 2 || i2 == 3) {
                this.E0 = true;
                this.F0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.E0 = false;
                this.F0 = true;
            }
            if (i2 == 2) {
                y().L0().N().F3(1);
                y().X1(1);
            } else if (i2 == 3) {
                y().L0().N().F3(0);
                y().X1(0);
            } else if (i2 == 4) {
                y().L0().N().G3(1);
                y().Y1(1);
            } else if (i2 == 5) {
                y().L0().N().G3(0);
                y().Y1(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f21319b)) {
                string = gVar.f21319b;
            } else {
                string = getString(R.string.operation_failed);
            }
            d.a.d.e.p.l.M(getPageContext().getPageActivity(), string);
        }
        if (O3()) {
            if (y().L0().N() == null || b3() == null) {
                return;
            }
            b3().e1();
        } else if (y().L0().N() == null || a3() == null) {
        } else {
            a3().u1();
        }
    }

    public final void V3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048641, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || I2() || !K2()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.S0);
            this.T0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.P0 != null && postData != null) {
            this.P0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (y() != null && y().L0() != null && y().L0().e0()) {
            d.a.d.e.m.e.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        if (this.J0 == null) {
            d.a.q0.u0.f2.a.c cVar = new d.a.q0.u0.f2.a.c(getPageContext());
            this.J0 = cVar;
            cVar.k(1);
            this.J0.j(new i1(this, str, str2));
        }
        if (y() == null || y().L0() == null || y().L0().m() == null) {
            return;
        }
        this.J0.h(y().L0().m().getId(), d.a.d.e.m.b.f(y().b1(), 0L));
    }

    public final void V4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        PostData c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String b12 = y().b1();
            String E = postData.E();
            String E2 = postData2 != null ? postData2.E() : "";
            int U = y().L0() != null ? y().L0().U() : 0;
            if (r3() != null && r3().j1() != null) {
                n2 = r3().j1().n(E);
            } else if (a3() == null || a3().l1() == null) {
                return;
            } else {
                n2 = a3().l1().n(E);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || y() == null || y().L0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(b12, E, "pb", true, N3(), null, false, E2, U, postData.O(), y().L0().d(), false, postData.t().getIconInfo(), d3()).addBigImageData(eVar.f19261a, eVar.f19262b, eVar.f19267g, eVar.j);
            boolean z4 = true;
            if (z3) {
                addBigImageData.setHighLightPostId(E2);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(y().getForumId());
            addBigImageData.setTiebaPlusData(y().E(), y().A(), y().B(), y().z(), y().F());
            addBigImageData.setBjhData(y().g0());
            addBigImageData.setKeyPageStartFrom(y().K0());
            addBigImageData.setFromFrsForumId(y().getFromForumId());
            addBigImageData.setWorksInfoData(y().f1());
            addBigImageData.setIsOpenEditor(z2);
            if (y().L0().p() != null) {
                addBigImageData.setHasForumRule(y().L0().p().has_forum_rule.intValue());
            }
            if (y().L0().T() != null) {
                addBigImageData.setIsManager(y().L0().T().getIs_manager());
            }
            if (y().L0().m().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(y().L0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(y().L0().m().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (y().L0().m() != null) {
                addBigImageData.setForumHeadUrl(y().L0().m().getImage_url());
                addBigImageData.setUserLevel(y().L0().m().getUser_level());
            }
            if (y() != null && (c3 = c3(y().L0())) != null) {
                if (!c3.S && !postData.S) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (N3() && this.f19776e.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.f19776e.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final String W2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.pb_comment_red_dot_no_reply);
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

    public final void W3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || y() == null) {
            return;
        }
        d.a.q0.h2.h.e L0 = y().L0();
        y().i2(true);
        d.a.p0.i.a aVar = this.V;
        if (aVar != null) {
            L0.w0(aVar.g());
        }
        if (O3()) {
            if (b3() != null) {
                b3().X0();
            }
            if (r3() != null) {
                r3().l1();
            }
        } else if (a3() != null) {
            a3().o1();
        }
    }

    public void W4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            FallingView fallingView = this.P;
            if (fallingView != null) {
                fallingView.g();
            }
            if (this.Q != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.N1);
                this.Q.setVisibility(8);
            }
        }
    }

    public d.a.p0.t.e.a X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.Y : (d.a.p0.t.e.a) invokeV.objValue;
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || y() == null || y().L0() == null) {
            return;
        }
        if (O3() && r3() == null) {
            return;
        }
        if ((O3() || a3() != null) && this.V != null) {
            MarkData markData = null;
            if (y().L0() != null && y().L0().e0()) {
                markData = y().e0(0);
            } else {
                CustomViewPager customViewPager = this.f19780i;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = y().F0(c3(y().L0()));
                } else if (O3()) {
                    if (r3() != null) {
                        markData = y().e0(r3().e1());
                    }
                } else if (a3() != null) {
                    markData = y().e0(a3().g1());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && r3() != null && (markData = y().e0(r3().e1() + 1)) == null) {
                return;
            }
            D4();
            this.V.i(markData);
            if (!this.V.e()) {
                this.V.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.V.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void X4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (voiceManager = this.a0) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public LinearLayout Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.q0 : (LinearLayout) invokeV.objValue;
    }

    public final boolean Y3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p2 = d.a.p0.s.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    d.a.p0.m.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void Y4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || (absPbActivity = this.f19776e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final int Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (y() == null || y().L0() == null || y().L0().N() == null) {
                return -1;
            }
            return y().L0().N().q();
        }
        return invokeV.intValue;
    }

    public void Z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z2) == null) {
            this.l.setVisibility(z2 ? 0 : 8);
        }
    }

    public final boolean Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (y() == null) {
                return true;
            }
            if (y().L0() == null || !y().L0().e0()) {
                if (y().x0()) {
                    MarkData k02 = y().k0();
                    if (k02 != null && y().v0() && q3() != null) {
                        MarkData e02 = y().e0(q3().getFirstVisiblePosition());
                        if (e02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", k02);
                            this.f19776e.setResult(-1, intent);
                            return true;
                        } else if (e02.getPostId() != null && !e02.getPostId().equals(k02.getPostId())) {
                            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getBaseFragmentActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new t(this, e02, k02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new u(this, k02, aVar));
                            aVar.setOnCalcelListener(new w(this));
                            aVar.create(getBaseFragmentActivity().getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", k02);
                            this.f19776e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (y().L0() != null && y().L0().E() != null && y().L0().E().size() > 0 && y().v0()) {
                    this.f19776e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.h2.o.b
    public PbModel.g a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.c1 : (PbModel.g) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.j.b(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (!d.a.d.e.p.j.z()) {
                showToast(R.string.network_not_available);
            } else if (this.T == null || y() == null) {
            } else {
                this.T.F();
                if (this.R) {
                    return;
                }
                X4();
                D4();
                if (y().LoadData()) {
                    N4();
                }
            }
        }
    }

    public void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            d.a.p0.x.w.e eVar = this.N0;
            if (eVar != null) {
                w4(eVar.D());
            }
            o4();
            this.T.F();
        }
    }

    public DetailInfoFragment b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.j.b(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public void b4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            if (i2 == 0) {
                d.a.q0.g3.c.g().h(getUniqueId(), false);
                if (q3() != null) {
                    H2(q3(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.a1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.a1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.a1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public final void b5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || (layoutParams = this.z.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.O;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.O = ofFloat;
            ofFloat.addUpdateListener(new k1(this));
            this.O.setDuration(200L);
            this.O.start();
            this.O.addListener(new l1(this, layoutParams));
        }
    }

    public PostData c3(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, eVar)) == null) {
            PostData postData = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.V() != null) {
                return eVar.V();
            }
            if (!ListUtils.isEmpty(eVar.E())) {
                Iterator<PostData> it = eVar.E().iterator();
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
                postData = eVar.j();
            }
            if (postData == null) {
                postData = p3(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void c4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048663, this, z2) == null) || z() == null) {
            return;
        }
        if (this.v1 && !TbSingleton.getInstance().isNotchScreen(z()) && !TbSingleton.getInstance().isCutoutScreen(z())) {
            T4();
            UtilHelper.hideStatusBar(z(), z().getRootView());
            this.v1 = false;
        }
        this.z0.f19789b = z2;
        e4();
        h4();
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.N = ofFloat;
            ofFloat.setDuration(300L);
            this.N.addUpdateListener(new r1(this));
            this.N.start();
        }
    }

    public abstract int d3();

    public void d4(d.a.p0.u.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048666, this, aVar, i2) == null) && d.a.q0.h2.k.e.r0.a(aVar, i2)) {
            this.Q.M(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), getPageContext()).subscribe(new o0(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public final void d5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.N = ofFloat;
            ofFloat.addUpdateListener(new p1(this, layoutParams, layoutParams2, i2));
            this.N.setDuration(300L);
            this.N.start();
            this.N.addListener(new q1(this));
        }
    }

    public final String e3() {
        InterceptResult invokeV;
        ArrayList<PostData> E;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (y() == null || y().L0() == null || y().L0().E() == null || (count = ListUtils.getCount((E = y().L0().E()))) == 0) {
                return "";
            }
            if (y().W0()) {
                Iterator<PostData> it = E.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int i2 = 0;
            if (q3() != null) {
                if (O3()) {
                    if (r3() != null) {
                        i2 = r3().c1();
                    }
                } else if (a3() != null) {
                    i2 = a3().e1();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(E, i2);
            if (postData != null && postData.t() != null) {
                if (y().s1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(E, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (y().s1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(E, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (y().s1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || this.o == null) {
            return;
        }
        boolean z2 = false;
        if (this.z0.a()) {
            this.o.X(false);
            return;
        }
        d.a.q0.h2.o.k.a aVar = this.o;
        if (!N3() && !this.o.S0()) {
            z2 = true;
        }
        aVar.X(z2);
    }

    public final void e5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.N = ofFloat;
            ofFloat.addUpdateListener(new m1(this, layoutParams, layoutParams2, i2));
            this.N.setDuration(300L);
            this.N.start();
            this.N.addListener(new o1(this));
        }
    }

    public abstract int f3();

    public final void f4(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, eVar) == null) || eVar == null) {
            return;
        }
        d.a.p0.s.q.b2 N = eVar.N();
        if (N != null && N.r2()) {
            G2();
        } else {
            A4(this.M0);
        }
        d.a.p0.x.w.e eVar2 = this.N0;
        if (eVar2 != null) {
            w4(eVar2.D());
            this.N0.N(eVar.d());
            this.N0.O(eVar.m(), eVar.T());
            this.N0.s0(N);
            if (y() != null) {
                this.N0.P(y().p0(), y().b1(), y().m0());
            }
            if (N != null) {
                this.N0.i0(N.c2());
            }
        }
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || y() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(y().getForumId()) || y().L0() == null || y().L0().m() == null) {
            return;
        }
        if (y().L0().m().isLike() == 1) {
            y().b0().A(y().getForumId(), y().b1());
        }
    }

    @Override // d.a.q0.h2.o.b
    public void finish() {
        CardHListViewData r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            PbModel pbModel = this.f19776e.getPbModel();
            if (pbModel != null && pbModel.L0() != null && !pbModel.L0().e0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.L0().N().d0();
                if (pbModel.isShareThread() && pbModel.L0().N().u1 != null) {
                    historyMessage.threadName = pbModel.L0().N().u1.f12278b;
                } else {
                    historyMessage.threadName = pbModel.L0().N().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.L0().m().getName();
                }
                ArrayList<PostData> E = pbModel.L0().E();
                int c12 = r3() != null ? r3().c1() : 0;
                if (E != null && c12 >= 0 && c12 < E.size()) {
                    historyMessage.postID = E.get(c12).E();
                }
                historyMessage.isHostOnly = pbModel.q0();
                historyMessage.isSquence = pbModel.Z0();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            d.a.p0.x.w.e eVar = this.N0;
            if (eVar != null) {
                eVar.J();
            }
            if (pbModel != null && (pbModel.r0() || pbModel.u0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.b1());
                if (this.D0) {
                    if (this.F0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.A0());
                    }
                    if (this.E0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.w0());
                    }
                }
                if (pbModel.L0() != null && System.currentTimeMillis() - this.f19777f >= 40000 && (r2 = pbModel.L0().r()) != null && !ListUtils.isEmpty(r2.getDataList())) {
                    intent.putExtra("guess_like_data", r2);
                }
                this.f19776e.setResult(-1, intent);
            }
            if (Z4()) {
                if (pbModel != null) {
                    d.a.q0.h2.h.e L0 = pbModel.L0();
                    if (L0 != null) {
                        if (L0.T() != null) {
                            L0.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.G0) {
                            if (this.n != null) {
                                Rect rect = new Rect();
                                this.n.getGlobalVisibleRect(rect);
                                d.a.q0.h2.k.e.m0.b().t(rect);
                            }
                            d.a.q0.h2.k.e.m0.b().s(this.f19780i.getCurrentItem());
                            BdTypeRecyclerView q3 = q3();
                            d.a.q0.h2.k.e.m0.b().n(pbModel.M0(), q3 != null ? q3.onSaveInstanceState() : null, pbModel.Z0(), pbModel.q0(), false);
                        }
                    }
                } else {
                    d.a.q0.h2.k.e.m0.b().m();
                }
                Y4();
            }
        }
    }

    public boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || !checkUpIsLogin() || y() == null || y().L0() == null || y().L0().m() == null || I2()) {
            return;
        }
        if (y().L0().e0()) {
            M2();
            return;
        }
        if (this.I0 == null) {
            d.a.q0.u0.f2.a.c cVar = new d.a.q0.u0.f2.a.c(getPageContext());
            this.I0 = cVar;
            cVar.k(0);
            this.I0.j(new b1(this));
        }
        this.I0.h(y().L0().m().getId(), d.a.d.e.m.b.f(y().b1(), 0L));
    }

    public void g5(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.N())) {
                d.a.q0.h2.p.h hVar = this.w0;
                if (hVar != null) {
                    hVar.h(false);
                    this.w0.g();
                }
                ViewGroup.LayoutParams layoutParams = this.v0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.v0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.v0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            d.a.q0.h2.p.h hVar2 = this.w0;
            if (hVar2 == null || !hVar2.e()) {
                ViewGroup.LayoutParams layoutParams2 = this.v0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.v0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.v0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (this.b0 == null) {
                this.b0 = new d.a.d.e.k.b<>(new t1(this), 20, 0);
            }
            return this.b0;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (this.i0 == null) {
                this.i0 = new d.a.d.e.k.b<>(new s1(this), 8, 0);
            }
            return this.i0;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            d.a.d.e.k.b<RelativeLayout> bVar = new d.a.d.e.k.b<>(new w1(this), 10, 0);
            this.l0 = bVar;
            return bVar;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            if (this.c0 == null) {
                this.c0 = TbRichTextView.z(getPageContext().getPageActivity(), 8);
            }
            return this.c0;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.k0 == null) {
                this.k0 = new d.a.d.e.k.b<>(new v1(this), 15, 0);
            }
            return this.k0;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.a0 == null) {
                this.a0 = VoiceManager.instance();
            }
            return this.a0;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.p0.d1.m.h
    public d.a.d.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            if (this.j0 == null) {
                this.j0 = new d.a.d.e.k.b<>(new u1(this), 8, 0);
            }
            return this.j0;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    public View.OnClickListener h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.H1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048689, this) == null) || this.o == null || this.f19780i == null) {
            return;
        }
        boolean z2 = false;
        if (!O3()) {
            this.o.W0(false);
        } else if (this.f19780i.getCurrentItem() != 0) {
            this.o.W0(false);
        } else if (this.z0.a()) {
            this.o.W0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.o.W0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public void h5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048690, this, z2) == null) {
            DetailInfoAndReplyFragment a3 = a3();
            if (a3 != null && a3.M0() != null && a3.M0().f() != null && a3.M0().g() != null) {
                a3.M0().f().X0(z2);
                a3.M0().g().r0(z2);
            }
            MaskView maskView = this.E;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public View.OnClickListener i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.I1 : (View.OnClickListener) invokeV.objValue;
    }

    public void i4(boolean z2, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048692, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.j.c()) {
                if (baseFragment instanceof d.a.q0.h2.o.a) {
                    ((d.a.q0.h2.o.a) baseFragment).D0(z2, i2, i3, i4, eVar, str, i5);
                }
            }
            D0(z2, i2, i3, i4, eVar, str, i5);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            d.a.p0.i.a c2 = d.a.p0.i.a.c(this.f19776e);
            this.V = c2;
            if (c2 != null) {
                c2.j(this.d1);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f19776e);
            this.Z = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.C1);
            this.Y = new d.a.p0.t.e.a(getPageContext());
            this.T = new d.a.q0.h2.o.g.a(this);
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            PbModel pbModel = this.f19776e.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.r1();
        }
        return invokeV.booleanValue;
    }

    public SparseArray<Object> j3(d.a.q0.h2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData c3;
        d.a.p0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048695, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (c3 = c3(eVar)) == null) {
                return null;
            }
            String userId = c3.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, c3.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (c3.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c3.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c3.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c3.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c3.E());
                }
                sparseArray.put(R.id.tag_del_post_id, c3.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<d.a.p0.s.q.x1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (d.a.p0.s.q.x1 x1Var : q2) {
                        if (x1Var != null && !StringUtils.isNull(x1Var.g()) && (e0Var = x1Var.f53484g) != null && e0Var.f53305a && !e0Var.f53307c && ((i3 = e0Var.f53306b) == 1 || i3 == 2)) {
                            sb.append(d.a.d.e.p.k.cutString(x1Var.g(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void j4(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048696, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        g5(eVar);
        this.u0.setVisibility(eVar.e0() ? 8 : 0);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String W2 = W2(eVar.N().Q0());
        TextView textView = this.x0;
        if (textView != null) {
            textView.setText(W2);
        }
        TextView textView2 = this.y0;
        if (textView2 != null) {
            textView2.setText(W2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.N()));
    }

    public d.a.p0.i.a k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.V : (d.a.p0.i.a) invokeV.objValue;
    }

    public void k4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048698, this, z2, markData) == null) || y() == null) {
            return;
        }
        C4();
        y().i2(z2);
        d.a.p0.i.a aVar = this.V;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.V.i(markData);
            }
        }
        if (y().x0()) {
            W3();
        } else if (O3()) {
            if (b3() != null) {
                b3().X0();
            }
            if (r3() != null) {
                r3().l1();
            }
        } else if (a3() != null) {
            a3().o1();
        }
    }

    public View.OnLongClickListener l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.P1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void l4(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048700, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        String valueOf = String.valueOf(eVar.N().Q0());
        if (eVar.N().Q0() == 0) {
            valueOf = "";
        }
        this.f19779h.F(valueOf);
    }

    public View.OnTouchListener m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.D1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void m4(d.a.q0.h2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, rVar) == null) || y() == null || y().L0() == null || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> E2 = y().L0().E();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= E2.size()) {
                break;
            }
            PostData postData = E2.get(i2);
            if (postData.E() == null || !postData.E().equals(E)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = rVar.k();
                postData.u0(rVar.m());
                if (postData.M() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.S() != null && next != null && next.t() != null && (metaData = postData.S().get(next.t().getUserId())) != null) {
                            next.g0(metaData);
                            next.o0(true);
                            next.z0(getPageContext(), y().s1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.M().size();
                    if (postData.M() != null && postData.M().size() < 2) {
                        postData.M().clear();
                        postData.M().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.e0();
                }
            }
        }
        if (y().v0() || !z2) {
            return;
        }
        if (O3() && r3() != null) {
            r3().l1();
        } else if (a3() != null) {
            a3().o1();
        }
    }

    public d.a.p0.x.w.e n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.N0 : (d.a.p0.x.w.e) invokeV.objValue;
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || this.N0 == null || this.O0 == null) {
            return;
        }
        d.a.p0.x.w.a.a().c(0);
        this.N0.U();
        this.N0.S();
        if (this.N0.z() != null) {
            this.N0.z().setMaxImagesAllowed(this.N0.z ? 1 : 9);
        }
        this.N0.m0(SendView.k);
        this.N0.j(SendView.k);
        d.a.p0.x.h m2 = this.O0.m(23);
        d.a.p0.x.h m3 = this.O0.m(2);
        d.a.p0.x.h m4 = this.O0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.O0.invalidate();
    }

    public final int o3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048705, this, i2)) == null) {
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

    public void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            n4();
            x3();
            this.P0.c();
            K4(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            f4(videoPbViewModel.c());
            J3(videoPbViewModel.c());
            l4(videoPbViewModel.c());
            if (y() != null && y().L0() != null) {
                boolean v02 = y().v0();
                d.a.q0.h2.h.e L0 = y().L0();
                if (v02) {
                    PostData c3 = c3(L0);
                    if (L0.u() != null && !L0.u().equals(c3.E()) && this.f19780i != null) {
                        if (O3()) {
                            this.f19780i.setCurrentItem(1);
                        } else {
                            this.f19780i.setCurrentItem(0);
                        }
                    }
                }
            }
            videoPbViewModel.j().observe(this, new c0(this));
            videoPbViewModel.b().observe(this, new d0(this));
            videoPbViewModel.i().observe(this, new e0(this));
            videoPbViewModel.g().observe(this, new f0(this));
            videoPbViewModel.e().observe(this, new h0(this));
            videoPbViewModel.f().observe(this, new i0(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048708, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.N0.I(i2, i3, intent);
            d.a.q0.h2.k.e.c1.f.a aVar = this.W;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            d.a.q0.h2.k.e.u uVar = this.P0;
            if (uVar != null) {
                uVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                t3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    X3();
                } else if (i2 == 13011) {
                    d.a.q0.v2.a.g().m(getPageContext());
                } else if (i2 != 25016 && i2 != 25023 && i2 != 24007 && i2 != 24008) {
                    switch (i2) {
                        case 25055:
                            View view = this.B;
                            if (view != null) {
                                view.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view2 = this.C;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            if (Y2() != null) {
                                Y2().performClick();
                                return;
                            }
                            return;
                        case 25058:
                            View view3 = this.D;
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
                    this.X = emotionImageData;
                    if (L2(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        s4(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.m0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, context) == null) {
            super.onAttach(context);
            this.f19776e = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f19776e);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f19778g);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.f19779h, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f19779h;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            d.a.q0.h2.k.e.v0 v0Var = this.K0;
            if (v0Var != null) {
                v0Var.i();
            }
            d.a.q0.h2.o.e eVar = this.p;
            if (eVar == null || !eVar.k()) {
                SkinManager.setBackgroundColor(this.f19778g, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.O0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            d.a.q0.h2.k.e.u uVar = this.P0;
            if (uVar != null) {
                uVar.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.a1;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            HeadImageView headImageView = this.r0;
            if (headImageView != null) {
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            }
            LinearLayout linearLayout = this.q0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (y() != null && y().x0()) {
                WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.J, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (y() != null) {
                g5(y().L0());
            }
            SkinManager.setBackgroundResource(this.k, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s0, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.y0, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.x0, R.color.CAM_X0107);
            TextView textView = this.x0;
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
            int i3 = R.color.CAM_X0207;
            SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
            if (a3() != null) {
                a3().onChangeSkinType(i2);
            } else if (O3() && r3() != null) {
                r3().onChangeSkinType(i2);
            }
            if (b3() != null) {
                b3().onChangeSkinType(i2);
            }
            View view = this.M;
            if (view != null) {
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            X4();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            d.a.q0.h2.o.k.a aVar = this.o;
            if (aVar == null || aVar.S0()) {
                return;
            }
            if (!(this.o.C() && configuration.orientation == 1) && (this.o.C() || configuration.orientation != 2)) {
                return;
            }
            this.o.U(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, bundle) == null) {
            this.f19777f = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            E3(bundle);
            getVoiceManager().onCreate(getPageContext());
            d.a.p0.s.f0.c cVar = new d.a.p0.s.f0.c();
            this.U = cVar;
            cVar.f52989a = 1000L;
            if (this.T != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.T.D;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.T.D;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            this.x = new d.a.q0.z.a(getPageContext());
            d.a.q0.g3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048714, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f19778g = (RelativeLayout) layoutInflater.inflate(f3(), viewGroup, false);
            L3();
            return this.f19778g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onDestroy();
            d.a.q0.g3.c.g().k(getUniqueId());
            getVoiceManager().onDestory(getPageContext());
            d.a.q0.h2.p.h hVar = this.w0;
            if (hVar != null) {
                hVar.g();
            }
            ForumManageModel forumManageModel = this.Z;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            d.a.q0.h2.o.k.a aVar = this.o;
            if (aVar != null) {
                aVar.T0();
            }
            d.a.q0.h2.k.e.c1.f.a aVar2 = this.W;
            if (aVar2 != null) {
                aVar2.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.H0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (y() != null) {
                y().cancelLoadData();
                y().destory();
                if (y().H0() != null) {
                    y().H0().d();
                }
            }
            d.a.p0.x.w.e eVar = this.N0;
            if (eVar != null) {
                eVar.J();
            }
            this.U = null;
            W4();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        d.a.q0.h2.o.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048716, this, i2, keyEvent)) == null) {
            if (!this.u1 && (this.v1 || P3())) {
                T4();
                UtilHelper.hideStatusBar(z(), z().getRootView());
                this.v1 = false;
                d.a.q0.h2.o.k.a aVar2 = this.o;
                if (aVar2 != null) {
                    aVar2.X0(false);
                }
            }
            if (i2 == 4) {
                d.a.q0.h2.o.k.a aVar3 = this.o;
                if (aVar3 != null) {
                    return aVar3.D();
                }
                return false;
            } else if (i2 == 24) {
                d.a.q0.h2.o.k.a aVar4 = this.o;
                if (aVar4 != null) {
                    return aVar4.h0();
                }
                return false;
            } else if (i2 != 25 || (aVar = this.o) == null) {
                return false;
            } else {
                return aVar.U0();
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // d.a.p0.d1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048717, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.m0 = true;
    }

    @Override // d.a.p0.d1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048718, this, context, str, z2) == null) {
            if (d.a.q0.h2.k.e.y0.c(str) && y() != null && y().b1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", y().b1()));
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
            this.m0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            super.onPause();
            this.Y0 = true;
            getVoiceManager().onPause(getPageContext());
            d.a.q0.h2.o.k.a aVar = this.o;
            if (aVar != null) {
                aVar.v0(true);
            }
            if (y() != null && !y().z0()) {
                this.N0.V(y().b1());
            }
            d.a.p0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.l1);
            MessageManager.getInstance().unRegisterListener(this.m1);
            MessageManager.getInstance().unRegisterListener(this.k1);
            MessageManager.getInstance().unRegisterListener(this.K1);
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048720, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.T.n0(str);
        d.a.p0.s.s.b R = this.T.R();
        if (R == null) {
            this.T.W();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            R.f(1).setVisibility(8);
        } else {
            R.f(1).setVisibility(0);
        }
        R.m();
        this.m0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            super.onResume();
            this.Y0 = false;
            getVoiceManager().onResume(getPageContext());
            d.a.q0.h2.o.k.a aVar = this.o;
            if (aVar != null) {
                aVar.v0(false);
            }
            P4();
            registerListener(this.l1);
            registerListener(this.m1);
            registerListener(this.k1);
            registerListener(this.K1);
            ItemCardHelper.s(this.M1);
            MessageManager.getInstance().registerListener(this.L1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (y() != null) {
                y().R1(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048723, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            d.a.q0.g3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.L1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z2) == null) {
            super.onUserChanged(z2);
            U3();
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048727, this, context, str) == null) {
            d.a.q0.h2.k.e.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.m0 = true;
        }
    }

    @Override // d.a.p0.d1.m.h
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048728, this, context, str) == null) {
        }
    }

    public final PostData p3(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048729, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null || eVar.N().H() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData H = eVar.N().H();
            String userId = H.getUserId();
            HashMap<String, MetaData> v12 = eVar.N().v1();
            if (v12 != null && (metaData = v12.get(userId)) != null && metaData.getUserId() != null) {
                H = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.N().U());
            postData.x0(eVar.N().getTitle());
            postData.w0(eVar.N().N());
            postData.g0(H);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.height = 0;
            this.z.setLayoutParams(layoutParams);
            this.z.setVisibility(8);
        }
    }

    public BdTypeRecyclerView q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            Iterator<BaseFragment> it = this.j.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).h1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).f1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            this.U0 = -1;
            this.V0 = Integer.MIN_VALUE;
        }
    }

    public ReplyFragment r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.j.b(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public boolean r4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048734, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && d.a.p0.s.k.c().g()) {
                        return Y3(postData.E());
                    }
                    if (checkUpIsLogin() && y() != null && y().L0() != null) {
                        d.a.q0.h2.k.e.u uVar = this.P0;
                        if (uVar != null) {
                            uVar.c();
                        }
                        d.a.q0.h2.h.r rVar = new d.a.q0.h2.h.r();
                        rVar.A(y().L0().m());
                        rVar.E(y().L0().N());
                        rVar.C(postData);
                        this.Q0.R(rVar);
                        this.Q0.setPostId(postData.E());
                        V3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.a.p0.x.w.e eVar = this.N0;
                        if (eVar != null) {
                            w4(eVar.D());
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

    public String s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            if (!d.a.d.e.p.k.isEmpty(this.A0)) {
                return this.A0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(d.a.q0.h2.k.e.r0.b());
            this.A0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void s4(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048736, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.W == null) {
            d.a.q0.h2.k.e.c1.f.a aVar = new d.a.q0.h2.k.e.c1.f.a(this.f19776e);
            this.W = aVar;
            aVar.n(this.G1);
            this.W.m(this.o1);
        }
        this.W.k(emotionImageData, y(), y().L0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f19780i) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public final void t3(int i2, Intent intent) {
        d.a.p0.x.n nVar;
        d.a.q0.h2.k.e.u uVar;
        d.a.p0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048738, this, i2, intent) == null) {
            if (i2 == 0) {
                x3();
                d.a.q0.h2.k.e.u uVar2 = this.P0;
                if (uVar2 != null) {
                    uVar2.c();
                }
                K4(false);
            }
            o4();
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
                    this.N0.T();
                    this.N0.u0(pbEditorData.getVoiceModel());
                    this.N0.H(writeData);
                    d.a.p0.x.m n2 = this.N0.a().n(6);
                    if (n2 != null && (nVar = n2.k) != null) {
                        nVar.onAction(new d.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.N0.M(null, null);
                    }
                } else if (editorType != 1 || (uVar = this.P0) == null || uVar.b() == null) {
                } else {
                    d.a.p0.x.w.h b3 = this.P0.b();
                    b3.a0(y().L0().N());
                    b3.B(writeData);
                    b3.b0(pbEditorData.getVoiceModel());
                    d.a.p0.x.m n3 = b3.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new d.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    public final void t4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048739, this, i2) == null) || y() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(y().b1());
        sendMessage(privacySettingMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u3(boolean z2) {
        d.a.q0.h2.h.e L0;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048740, this, z2) == null) || y() == null || this.T == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (L0 = y().L0()) == null) {
            return;
        }
        d.a.p0.s.q.b2 N = L0.N();
        if (N != null && N.H() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", y().b1()).param("fid", L0.n()).param("obj_locate", 4).param("uid", N.H().getUserId()));
            if (N3()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", y().getForumId());
                statisticItem.param("tid", y().b1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", e3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", d3());
                TiebaStatic.log(statisticItem);
            }
        }
        if (N != null) {
            if (N.F1()) {
                i2 = 2;
            } else if (N.I1()) {
                i2 = 3;
            } else if (N.G1()) {
                i2 = 4;
            } else if (N.H1()) {
                i2 = 5;
            }
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", y().b1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", y().getForumId());
            if (!z2) {
                statisticItem2.param("obj_locate", 6);
            } else {
                statisticItem2.param("obj_locate", 5);
            }
            statisticItem2.param("obj_name", i2);
            statisticItem2.param("obj_type", 2);
            if (N != null) {
                if (N.F1()) {
                    statisticItem2.param("obj_type", 10);
                } else if (N.I1()) {
                    statisticItem2.param("obj_type", 9);
                } else if (N.H1()) {
                    statisticItem2.param("obj_type", 8);
                } else if (N.G1()) {
                    statisticItem2.param("obj_type", 7);
                } else if (N.v1) {
                    statisticItem2.param("obj_type", 6);
                } else {
                    int i3 = N.Z;
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
                statisticItem2.param("nid", N.B0());
                statisticItem2.param("card_type", N.M0());
                statisticItem2.param("recom_source", N.T0);
                statisticItem2.param("ab_tag", N.V0);
                statisticItem2.param("weight", N.U0);
                statisticItem2.param("extra", N.W0);
                statisticItem2.param("nid", N.B0());
                if (N.J() != null && !d.a.d.e.p.k.isEmpty(N.J().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, N.J().oriUgcVid);
                }
            }
            if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (z() != null) {
                d.a.p0.l0.c.e(z(), statisticItem2);
            }
            TiebaStatic.log(statisticItem2);
            if (d.a.d.e.p.l.D()) {
                showToast(R.string.neterror);
                return;
            } else if (y().L0() == null) {
                d.a.d.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> E = L0.E();
                if ((E == null || E.size() <= 0) && y().Z0()) {
                    d.a.d.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                    return;
                }
                this.T.F();
                X4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), N)) {
                    return;
                }
                d.a.q0.h2.p.h hVar = this.w0;
                if (hVar != null) {
                    hVar.h(false);
                    g5(L0);
                }
                if (ShareSwitch.isOn()) {
                    O4(z2 ? 2 : 1);
                    return;
                }
                this.T.v0();
                y().i0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", y().b1());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", y().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (N != null) {
        }
        if (!d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (z() != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (d.a.d.e.p.l.D()) {
        }
    }

    public void u4(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048741, this, i2) == null) || (linearLayout = this.n0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    @Override // d.a.q0.h2.o.b
    public AbsVideoPbFragment v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || this.p0 == null) {
            return;
        }
        this.o0.setVisibility(8);
        this.p0.setVisibility(8);
        this.z0.f19788a = false;
        e4();
        h4();
    }

    public void v4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, editorTools) == null) {
            this.O0 = editorTools;
            editorTools.setId(R.id.pb_editor);
            this.O0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.O0.getParent() == null) {
                this.f19778g.addView(this.O0, layoutParams);
            }
            this.O0.w(TbadkCoreApplication.getInst().getSkinType());
            this.O0.setActionListener(24, new f1(this));
            x3();
            this.N0.i(new g1(this));
        }
    }

    public void w3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) || this.p0 == null || this.s0 == null) {
            return;
        }
        if (y() != null && y().L0() != null) {
            this.s0.setText(TbSingleton.getInstance().getAdVertiComment(y().L0().g0(), y().L0().h0(), s3()));
        } else {
            this.s0.setText(s3());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.p0.startAnimation(alphaAnimation);
        }
        this.o0.setVisibility(0);
        this.p0.setVisibility(0);
        this.z0.f19788a = true;
    }

    public void w4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) {
            this.B0 = z2;
        }
    }

    public void x3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || (editorTools = this.O0) == null) {
            return;
        }
        editorTools.o();
    }

    public void x4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z2) == null) {
            this.R = z2;
        }
    }

    @Override // d.a.q0.h2.o.b
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this.f19776e.getPbModel() : (PbModel) invokeV.objValue;
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048750, this) == null) || this.f19776e.getCurrentFocus() == null) {
            return;
        }
        d.a.d.e.p.l.x(getPageContext().getPageActivity(), this.f19776e.getCurrentFocus());
    }

    public void y4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z2) == null) {
            this.v1 = z2;
        }
    }

    @Override // d.a.q0.h2.o.b
    public AbsPbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.f19776e : (AbsPbActivity) invokeV.objValue;
    }

    public void z3() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048753, this) == null) || (view = this.S) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public abstract void z4(boolean z2);

    /* loaded from: classes4.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f19788a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19789b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f19790c;

        public b2(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19790c = absVideoPbFragment;
            this.f19789b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f19788a && this.f19789b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }
}
