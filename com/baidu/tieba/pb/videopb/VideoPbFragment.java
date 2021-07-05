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
import com.baidu.tieba.pb.pb.main.PbActivity;
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
import d.a.r0.b1.m.f;
import d.a.r0.h.a;
import d.a.r0.r.s.a;
import d.a.s0.h2.p.c;
import d.a.s0.i0.b;
import d.a.s0.u0.f2.a.c;
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
/* loaded from: classes5.dex */
public class VideoPbFragment extends BaseFragment implements d.a.r0.b1.m.h, VoiceManager.j, d.a.s0.h2.o.b, TbRichTextView.r, d.a.s0.h2.o.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q1 = 0;
    public static int R1 = 1;
    public static int S1 = 0;
    public static int T1 = 0;
    public static int U1 = 3;
    public static int V1 = 4;
    public static int W1 = 6;
    public static final int X1;
    public static final int Y1;
    public static final b.InterfaceC1500b Z1;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.h2.o.i.a A;
    public String A0;
    public ObjectAnimator A1;
    public View B;
    public boolean B0;
    public ObjectAnimator B1;
    public View C;
    public String C0;
    public final d.a.c.a.e C1;
    public View D;
    public boolean D0;
    public View.OnTouchListener D1;
    public MaskView E;
    public boolean E0;
    public NewWriteModel.g E1;
    public d.a.s0.h2.o.j.a F;
    public boolean F0;
    public d.a.r0.w.w.c F1;
    public View.OnClickListener G;
    public boolean G0;
    public final View.OnClickListener G1;
    public TextView H;
    public ReplyPrivacyCheckController H0;
    public View.OnClickListener H1;
    public TextView I;
    public d.a.s0.u0.f2.a.c I0;
    public final AdapterView.OnItemClickListener I1;
    public ImageView J;
    public d.a.s0.u0.f2.a.c J0;
    public CustomMessageListener J1;
    public TBSpecificationBtn K;
    public d.a.s0.h2.k.e.v0 K0;
    public CustomMessageListener K1;
    public TbImageView L;
    public PermissionJudgePolicy L0;
    public final ItemCardHelper.b L1;
    public View M;
    public d.a.r0.w.w.g M0;
    public Runnable M1;
    public ValueAnimator N;
    public d.a.r0.w.w.e N0;
    public CustomMessageListener N1;
    public ValueAnimator O;
    public EditorTools O0;
    public final View.OnLongClickListener O1;
    public FallingView P;
    public d.a.s0.h2.k.e.u P0;
    public SortSwitchButton.f P1;
    public TbImageView Q;
    public PbFakeFloorModel Q0;
    public boolean R;
    public d.a.s0.i0.b R0;
    public View S;
    public int[] S0;
    public d.a.s0.h2.o.g.a T;
    public int T0;
    public d.a.r0.r.f0.c U;
    public int U0;
    public d.a.r0.h.a V;
    public int V0;
    public d.a.s0.h2.k.e.b1.f.a W;
    public int W0;
    public EmotionImageData X;
    public int X0;
    public d.a.r0.s.e.a Y;
    public boolean Y0;
    public ForumManageModel Z;
    public boolean Z0;
    public VoiceManager a0;
    public RightFloatLayerView a1;
    public d.a.c.e.k.b<GifView> b0;
    public final CustomMessageListener b1;
    public d.a.c.e.k.b<TextView> c0;
    public final PbModel.g c1;
    public final a.InterfaceC1243a d1;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19644e;
    public d.a.r0.w.w.b e1;

    /* renamed from: f  reason: collision with root package name */
    public long f19645f;
    public final CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f19646g;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f19647h;
    public final CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f19648i;
    public d.a.c.e.k.b<ImageView> i0;
    public CustomMessageListener i1;
    public VideoPbFragmentAdapter j;
    public d.a.c.e.k.b<View> j0;
    public HttpMessageListener j1;
    public View k;
    public d.a.c.e.k.b<LinearLayout> k0;
    public CustomMessageListener k1;
    public View l;
    public d.a.c.e.k.b<RelativeLayout> l0;
    public CustomMessageListener l1;
    public AppBarLayout m;
    public boolean m0;
    public CustomMessageListener m1;
    public VideoContainerLayout n;
    public LinearLayout n0;
    public d.a.r0.w.w.b n1;
    public d.a.s0.h2.o.k.a o;
    public View o0;
    public final NewWriteModel.g o1;
    public d.a.s0.h2.o.e p;
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
    public d.a.s0.h2.p.h w0;
    public View.OnTouchListener w1;
    public d.a.s0.z.a x;
    public TextView x0;
    public GestureDetector x1;
    public boolean y;
    public TextView y0;
    public GestureDetector.SimpleOnGestureListener y1;
    public View z;
    public b2 z0;
    public Runnable z1;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19649a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19649a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19649a.Y0) {
                return;
            }
            this.f19649a.J4();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19650e;

        public a0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19650e = videoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19650e.y() == null || this.f19650e.y().M0() == i2 + 1) {
                return;
            }
            VideoPbFragment videoPbFragment = this.f19650e;
            videoPbFragment.o4(videoPbFragment.j3(i2));
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19651a;

        public a1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19651a = videoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                d.a.s0.h2.o.g.a aVar = this.f19651a.T;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!d.a.c.e.p.j.z()) {
                    this.f19651a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.f19651a.y() != null && !this.f19651a.y().isLoading) {
                    this.f19651a.R4();
                    this.f19651a.x4();
                    z = true;
                    if (this.f19651a.y().D0() != null && this.f19651a.y().D0().f60142f != null && this.f19651a.y().D0().f60142f.size() > i2) {
                        int intValue = this.f19651a.y().D0().f60142f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f19651a.y().U0()).param("fid", this.f19651a.y().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.f19651a.y().b2(intValue)) {
                            this.f19651a.R = true;
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

    /* loaded from: classes5.dex */
    public class a2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19652a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a2(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19652a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.s0.h2.e eVar = (d.a.s0.h2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f19652a.h4((d.a.s0.h2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f19652a.Q2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f19652a.f4(false, null);
                } else {
                    this.f19652a.f4(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19653a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19653a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f19653a.Z4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19654a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19654a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                d.a.r0.b1.m.f.c(this.f19654a.getPageContext(), this.f19654a, aVar.f55046a, aVar.f55047b, aVar.f55048c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19655a;

        public b1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19655a = videoPbFragment;
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f19655a.N0 != null && this.f19655a.N0.a() != null) {
                    this.f19655a.N0.a().A(new d.a.r0.w.a(45, 27, null));
                }
                this.f19655a.J2();
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19659a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoPbFragment videoPbFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f19659a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f19659a.getView() != null) {
                    VideoPbFragment videoPbFragment = this.f19659a;
                    videoPbFragment.hideLoadingView(videoPbFragment.getView());
                    this.f19659a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.f19659a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.f19659a.getString(R.string.block_user_success));
                            bdTopToast.j((ViewGroup) this.f19659a.getView());
                            this.f19659a.y4(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f19659a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.f19659a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.f19659a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements Observer<d.a.r0.r.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19660e;

        public c0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19660e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.r0.r.q.b2 b2Var) {
            BdTypeRecyclerView l3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var == null || b2Var.l1() == null) {
                return;
            }
            if (this.f19660e.o.c0() == null || !this.f19660e.o.c0().equals(b2Var.l1().video_url)) {
                if (!d.a.c.e.p.k.isEmpty(this.f19660e.o.c0())) {
                    this.f19660e.G0 = true;
                    if (this.f19660e.I3()) {
                        this.f19660e.f19648i.setCurrentItem(VideoPbFragment.Q1);
                    } else {
                        this.f19660e.f19648i.setCurrentItem(VideoPbFragment.S1);
                    }
                    if (!this.f19660e.I3() && (l3 = this.f19660e.l3()) != null) {
                        l3.scrollToPosition(0);
                    }
                }
                if (this.f19660e.p == null || !this.f19660e.p.k()) {
                    this.f19660e.k4();
                    this.f19660e.B2(b2Var);
                }
                this.f19660e.H3();
                if (this.f19660e.p != null && this.f19660e.p.l()) {
                    this.f19660e.p.s();
                }
                boolean z = !StringHelper.equals(this.f19660e.o.c0(), b2Var.l1().video_url);
                this.f19660e.o.setData(b2Var);
                if (this.f19660e.I3()) {
                    this.f19660e.o.W0(this.f19660e.f19648i.getCurrentItem() == 0);
                } else {
                    this.f19660e.o.W0(false);
                }
                if (z) {
                    this.f19660e.o.startPlay();
                    this.f19660e.o.z0();
                    return;
                }
                return;
            }
            this.f19660e.o.setData(b2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19661a;

        public c1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19661a = videoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.s0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
            String n3;
            d.a.r0.w.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                this.f19661a.w4();
                this.f19661a.u3();
                if (this.f19661a.R) {
                    this.f19661a.R = false;
                }
                this.f19661a.E4(false);
                if (z && eVar != null) {
                    d.a.r0.r.q.b2 N = eVar.N();
                    ((VideoPbViewModel) ViewModelProviders.of(this.f19661a.getActivity()).get(VideoPbViewModel.class)).s(eVar, i3);
                    this.f19661a.a4(eVar);
                    this.f19661a.G4(eVar);
                    this.f19661a.g4(eVar);
                    this.f19661a.d4(z, i2, i3, i4, eVar, str, i5);
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.T().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.T().getBimg_end_time());
                    if (this.f19661a.V != null) {
                        this.f19661a.V.h(eVar.s());
                    }
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        this.f19661a.C0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.f19661a.C0) && this.f19661a.N0 != null && this.f19661a.N0.a() != null && (m = this.f19661a.N0.a().m(6)) != null && !TextUtils.isEmpty(this.f19661a.C0)) {
                            ((View) m).setOnClickListener(this.f19661a.p1);
                        }
                    }
                    if (this.f19661a.H0 != null && N != null && N.H() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.H());
                        this.f19661a.H0.setLikeUserData(attentionHostData);
                    }
                    this.f19661a.E3(eVar);
                    if (this.f19661a.y() != null && this.f19661a.y().b1()) {
                        n3 = this.f19661a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        n3 = this.f19661a.n3();
                    }
                    if (!StringUtils.isNull(n3)) {
                        this.f19661a.N0.k0(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), n3));
                    }
                } else {
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.f19661a.y().T0());
                            jSONObject.put("fid", this.f19661a.y().getForumId());
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
                    if ((this.f19661a.I3() && this.f19661a.m3() == null) || this.f19661a.X2() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.f19661a.I3()) {
                        if (i2 != -1) {
                            if (this.f19661a.y() != null && this.f19661a.y().D0() != null) {
                                arrayList = this.f19661a.y().D0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19661a.m3().m1(this.f19661a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f19661a.m3().g1()) {
                                this.f19661a.m3().n1(this.f19661a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f19661a.m3().n1(this.f19661a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f19661a.m3().m1("");
                        }
                        this.f19661a.m3().T0();
                    } else {
                        if (i2 != -1) {
                            if (this.f19661a.y() != null && this.f19661a.y().D0() != null) {
                                arrayList = this.f19661a.y().D0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19661a.X2().s1(this.f19661a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f19661a.X2().j1()) {
                                this.f19661a.X2().t1(this.f19661a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f19661a.X2().t1(this.f19661a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f19661a.X2().s1("");
                        }
                        this.f19661a.X2().V0();
                    }
                }
                d.a.s0.g3.c.g().h(this.f19661a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19662a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19662a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f19662a.T != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f19662a.T.D) {
                d.a.s0.s3.a aVar = (d.a.s0.s3.a) customResponsedMessage.getData();
                this.f19662a.T.V();
                SparseArray<Object> sparseArray = (SparseArray) this.f19662a.T.O();
                DataRes dataRes = aVar.f65437a;
                if (aVar.f65439c == 0 && dataRes != null) {
                    int d2 = d.a.c.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (d.a.c.e.p.k.isEmpty(str)) {
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
                    this.f19662a.T.y0(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f19662a.T.i0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19663e;

        public d0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19663e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f19663e.f19648i.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19664a;

        public d1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19664a = videoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.r0.r.s.a aVar) {
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19665a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19665a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19665a.T == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.s0.h2.o.g.a aVar = this.f19665a.T;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.s0.h2.h.e D0 = this.f19665a.y().D0();
                if (D0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    D0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f19665a.U.c(this.f19665a.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f19665a.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f19665a.T.E0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f19665a.T.x0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f19665a.getResources().getString(R.string.mute_fail);
                    }
                    this.f19665a.U.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements Observer<d.a.r0.r.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19666e;

        public e0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19666e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.r0.r.q.b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
                this.f19666e.o.Z0(b2Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19667e;

        public e1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19667e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19667e.j4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19668a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19668a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19668a.T == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.s0.h2.o.g.a aVar = this.f19668a.T;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f19668a.U.c(this.f19668a.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f19668a.getResources().getString(R.string.un_mute_fail);
                }
                this.f19668a.U.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements Observer<d.a.r0.r.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19669e;

        public f0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19669e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.r0.r.q.b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
                this.f19669e.o.Y0(b2Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements d.a.r0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19670e;

        public f1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19670e = videoPbFragment;
        }

        @Override // d.a.r0.w.b
        public void onAction(d.a.r0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f56768c;
                if (obj instanceof d.a.r0.s.c.v) {
                    if (((d.a.r0.s.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((d.a.r0.s.c.v) aVar.f56768c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f19670e.L0 == null) {
                            this.f19670e.L0 = new PermissionJudgePolicy();
                        }
                        this.f19670e.L0.clearRequestPermissionList();
                        this.f19670e.L0.appendRequestPermission(this.f19670e.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f19670e.L0.startRequestPermission(this.f19670e.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f19670e.N0.h((d.a.r0.s.c.v) aVar.f56768c);
                        this.f19670e.N0.z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements d.a.r0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19671a;

        public g(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19671a = videoPbFragment;
        }

        @Override // d.a.r0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.h2.k.e.v0 v0Var = this.f19671a.K0;
                if (v0Var == null || v0Var.g() == null || !this.f19671a.K0.g().d()) {
                    return !this.f19671a.I2(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                VideoPbFragment videoPbFragment = this.f19671a;
                videoPbFragment.showToast(videoPbFragment.K0.g().c());
                if (this.f19671a.P0 != null && this.f19671a.P0.b() != null && this.f19671a.P0.b().v()) {
                    this.f19671a.P0.b().t(this.f19671a.K0.h());
                }
                this.f19671a.K0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19673f;

        public g0(VideoPbFragment videoPbFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19673f = videoPbFragment;
            this.f19672e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19673f.a1.k();
                if (!StringUtils.isNull(this.f19672e)) {
                    this.f19673f.N3(this.f19672e);
                }
                this.f19673f.v3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19674e;

        public g1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19674e = videoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.s0.h2.k.e.v0 v0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19674e.K0) == null || v0Var.e() == null) {
                return;
            }
            if (!this.f19674e.K0.e().e()) {
                this.f19674e.K0.a(false);
            }
            this.f19674e.K0.e().l(false);
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
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) != null) || this.f19674e.O0 == null || this.f19674e.O0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2) || TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19675a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19676e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f19677f;

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
                this.f19677f = hVar;
                this.f19676e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19676e == null) {
                    return;
                }
                this.f19677f.f19675a.Q4();
                this.f19677f.f19675a.Y3(this.f19676e.getmAdverSegmentData(), 2);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
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

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f19678e;

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
                this.f19678e = hVar;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19678e.f19675a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19678e.f19675a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public h(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19675a = videoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.r0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19675a.y() != null && this.f19675a.y().D0() != null) {
                        statisticItem.param("fid", this.f19675a.y().D0().n());
                    }
                    statisticItem.param("tid", this.f19675a.y().T0());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f19675a.R4();
                this.f19675a.v4(z, postWriteCallBackData);
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
                        this.f19675a.showToast(str);
                        if (this.f19675a.N0.B() || this.f19675a.N0.D()) {
                            this.f19675a.N0.z(false, postWriteCallBackData);
                        }
                        this.f19675a.K0.k(postWriteCallBackData);
                        return;
                    } else if (i2 == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.f19675a.H0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.f19675a.getActivity(), this.f19675a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.f19675a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f19675a.getActivity());
                        if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            aVar.setMessage(this.f19675a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            aVar.setMessage(postWriteCallBackData.getErrorString());
                        }
                        aVar.setNegativeButton(R.string.cancel, new b(this));
                        aVar.setPositiveButton(R.string.open_now, new c(this));
                        aVar.create(this.f19675a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (d.a.s0.r3.a.c(i2) || i0Var != null || i2 == 227001) {
                        return;
                    } else {
                        this.f19675a.C4(i2, antiData, str);
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.f19675a.y() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.f19675a.y().O(postWriteCallBackData.getPostId());
                    if (this.f19675a.I3() && this.f19675a.m3() != null) {
                        VideoPbFragment videoPbFragment = this.f19675a;
                        videoPbFragment.W0 = videoPbFragment.m3().W0();
                        VideoPbFragment videoPbFragment2 = this.f19675a;
                        videoPbFragment2.X0 = videoPbFragment2.m3().X0();
                        this.f19675a.y().L1(this.f19675a.W0, this.f19675a.X0);
                    } else if (this.f19675a.X2() != null) {
                        VideoPbFragment videoPbFragment3 = this.f19675a;
                        videoPbFragment3.W0 = videoPbFragment3.X2().Y0();
                        VideoPbFragment videoPbFragment4 = this.f19675a;
                        videoPbFragment4.X0 = videoPbFragment4.X2().Z0();
                        this.f19675a.y().L1(this.f19675a.W0, this.f19675a.X0);
                    }
                }
                if (this.f19675a.f19648i != null) {
                    if (this.f19675a.I3()) {
                        this.f19675a.f19648i.setCurrentItem(VideoPbFragment.R1);
                    } else {
                        this.f19675a.f19648i.setCurrentItem(VideoPbFragment.S1);
                    }
                }
                this.f19675a.T.F();
                this.f19675a.K0.c();
                if (this.f19675a.N0 != null) {
                    VideoPbFragment videoPbFragment5 = this.f19675a;
                    videoPbFragment5.r4(videoPbFragment5.N0.C());
                }
                this.f19675a.s3();
                this.f19675a.E4(true);
                this.f19675a.y().Z0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.f19675a.D4(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.f19675a.y().i0()) {
                        d.a.s0.h2.h.e D0 = this.f19675a.y().D0();
                        if (D0 != null && D0.N() != null && D0.N().H() != null && (userId = D0.N().H().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f19675a.y().Y1()) {
                            this.f19675a.x4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.f19675a.y().Y1()) {
                        this.f19675a.x4();
                    }
                } else if (floor != null) {
                    if (this.f19675a.I3() && this.f19675a.m3() != null) {
                        this.f19675a.m3().f1();
                    } else if (this.f19675a.X2() != null) {
                        this.f19675a.X2().i1();
                    }
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.c.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                VideoPbFragment videoPbFragment6 = this.f19675a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                videoPbFragment6.A2(z2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19679e;

        public h0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19679e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f19679e.c4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19680e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19681f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19682g;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h1 f19683e;

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
                this.f19683e = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.s0.h2.k.e.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19683e.f19682g.K0) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f19683e.f19682g.K0.g().e()) {
                    this.f19683e.f19682g.K0.b(false);
                }
                this.f19683e.f19682g.K0.g().l(false);
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

        public h1(VideoPbFragment videoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19682g = videoPbFragment;
            this.f19680e = str;
            this.f19681f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = d.a.c.e.p.l.i(this.f19682g.f19644e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.c.e.p.l.g(this.f19682g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.c.e.p.l.g(this.f19682g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                VideoPbFragment videoPbFragment = this.f19682g;
                boolean z = true;
                int i5 = (videoPbFragment.S0[1] + videoPbFragment.T0) - i4;
                if (videoPbFragment.l3() != null) {
                    this.f19682g.l3().smoothScrollBy(0, i5);
                }
                if (this.f19682g.P0 != null) {
                    this.f19682g.N0.a().setVisibility(8);
                    this.f19682g.P0.n(this.f19680e, this.f19681f, this.f19682g.n3(), (this.f19682g.y() == null || this.f19682g.y().D0() == null || this.f19682g.y().D0().N() == null || !this.f19682g.y().D0().N().I1()) ? false : false);
                    d.a.r0.w.w.h b2 = this.f19682g.P0.b();
                    if (b2 != null && this.f19682g.y() != null && this.f19682g.y().D0() != null) {
                        b2.E(this.f19682g.y().D0().d());
                        b2.X(this.f19682g.y().D0().N());
                    }
                    if (this.f19682g.K0.f() == null && this.f19682g.P0.b().s() != null) {
                        this.f19682g.P0.b().s().g(new a(this));
                        VideoPbFragment videoPbFragment2 = this.f19682g;
                        videoPbFragment2.K0.n(videoPbFragment2.P0.b().s().i());
                        this.f19682g.P0.b().K(this.f19682g.n1);
                    }
                }
                this.f19682g.q3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19684e;

        public i(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19684e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPbFragment videoPbFragment = this.f19684e;
                videoPbFragment.showToast(videoPbFragment.C0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19685e;

        public i0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19685e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f19685e.q.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19686a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19687b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19688c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i1 f19689e;

            /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0234a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f19690e;

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
                    this.f19690e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.s0.h2.k.e.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19690e.f19689e.f19688c.K0) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f19690e.f19689e.f19688c.K0.g().e()) {
                        this.f19690e.f19689e.f19688c.K0.b(false);
                    }
                    this.f19690e.f19689e.f19688c.K0.g().l(false);
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
                this.f19689e = i1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = d.a.c.e.p.l.i(this.f19689e.f19688c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = d.a.c.e.p.l.g(this.f19689e.f19688c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i2 = i3 / 2;
                        g2 = d.a.c.e.p.l.g(this.f19689e.f19688c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i4 = i3 - (i2 + g2);
                    VideoPbFragment videoPbFragment = this.f19689e.f19688c;
                    boolean z = true;
                    int i5 = (videoPbFragment.S0[1] + videoPbFragment.T0) - i4;
                    if (videoPbFragment.l3() != null) {
                        this.f19689e.f19688c.l3().smoothScrollBy(0, i5);
                    }
                    if (this.f19689e.f19688c.P0 != null) {
                        this.f19689e.f19688c.N0.a().setVisibility(8);
                        z = (this.f19689e.f19688c.y() == null || this.f19689e.f19688c.y().D0() == null || this.f19689e.f19688c.y().D0().N() == null || !this.f19689e.f19688c.y().D0().N().I1()) ? false : false;
                        d.a.s0.h2.k.e.u uVar = this.f19689e.f19688c.P0;
                        i1 i1Var = this.f19689e;
                        uVar.n(i1Var.f19686a, i1Var.f19687b, i1Var.f19688c.n3(), z);
                        d.a.r0.w.w.h b2 = this.f19689e.f19688c.P0.b();
                        if (b2 != null && this.f19689e.f19688c.y() != null && this.f19689e.f19688c.y().D0() != null) {
                            b2.E(this.f19689e.f19688c.y().D0().d());
                            b2.X(this.f19689e.f19688c.y().D0().N());
                        }
                        if (this.f19689e.f19688c.K0.f() == null && this.f19689e.f19688c.P0.b().s() != null) {
                            this.f19689e.f19688c.P0.b().s().g(new C0234a(this));
                            VideoPbFragment videoPbFragment2 = this.f19689e.f19688c;
                            videoPbFragment2.K0.n(videoPbFragment2.P0.b().s().i());
                            this.f19689e.f19688c.P0.b().K(this.f19689e.f19688c.n1);
                        }
                    }
                    this.f19689e.f19688c.q3();
                }
            }
        }

        public i1(VideoPbFragment videoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19688c = videoPbFragment;
            this.f19686a = str;
            this.f19687b = str2;
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                d.a.c.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19691a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19691a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f19691a.N0 != null) {
                VideoPbFragment videoPbFragment = this.f19691a;
                videoPbFragment.r4(videoPbFragment.N0.C());
            }
            this.f19691a.E4(false);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f19692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19693f;

        public j0(VideoPbFragment videoPbFragment, VideoPbViewModel videoPbViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, videoPbViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19693f = videoPbFragment;
            this.f19692e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (!d.a.r0.c1.b.e.d() && this.f19693f.I3() && (this.f19692e.m() || this.f19693f.y().S0() == VideoPbFragment.R1)) {
                    this.f19693f.f19648i.setCurrentItem(VideoPbFragment.R1);
                } else if (this.f19692e.m() || this.f19693f.y().S0() == VideoPbFragment.S1) {
                    this.f19693f.f19648i.setCurrentItem(VideoPbFragment.S1);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (!d.a.r0.c1.b.e.d() && this.f19693f.I3() && (this.f19692e.m() || this.f19693f.y().S0() == VideoPbFragment.R1)) {
                    this.f19693f.f19648i.setCurrentItem(VideoPbFragment.R1);
                } else if (this.f19692e.m() || this.f19693f.y().S0() == VideoPbFragment.S1) {
                    this.f19693f.f19648i.setCurrentItem(VideoPbFragment.S1);
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
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19694e;

        public j1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19694e = videoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19694e.A == null || this.f19694e.A.o()) {
                    if (this.f19694e.A != null && this.f19694e.y() != null && this.f19694e.y().D0() != null && this.f19694e.y().D0().m() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.f19694e.y().D0().m().getId()).param("fname", this.f19694e.y().D0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19694e.y().D0().P()).param("obj_param1", this.f19694e.A.o));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.f19694e.A.getTitle()).param("obj_name", this.f19694e.A.j()).param("obj_type", 2).param("fid", this.f19694e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19694e.y().D0().P()));
                }
                this.f19694e.M4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19695e;

        public k(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19695e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19695e.A == null || this.f19695e.A.o()) {
                    if (this.f19695e.A != null) {
                        if (!this.f19695e.A.l) {
                            if (this.f19695e.A.q != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.f19695e.getPageContext(), this.f19695e.A.q.mSid, this.f19695e.A.q.mSsid, this.f19695e.A.q.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            VideoPbFragment videoPbFragment = this.f19695e;
                            videoPbFragment.M3(videoPbFragment.A.n, this.f19695e.A.m);
                        }
                        if (this.f19695e.y() == null || this.f19695e.y().D0() == null || this.f19695e.y().D0().m() == null) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c13713").param("fid", this.f19695e.y().D0().m().getId()).param("fname", this.f19695e.y().D0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19695e.y().D0().P()).param("obj_param1", this.f19695e.A.o));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.f19695e.A.getTitle()).param("obj_name", this.f19695e.A.j()).param("obj_type", 2).param("fid", this.f19695e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19695e.y().D0().P()));
                String e2 = this.f19695e.A.e();
                if (TextUtils.isEmpty(e2)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(e2) && !URLUtil.isHttpsUrl(e2)) {
                    Uri parse = Uri.parse(e2);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.f19695e.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f19695e.getPageContext(), new String[]{e2});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19696a;

        public k0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19696a = videoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f19696a.N0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f19696a.P0 != null && this.f19696a.P0.b() != null) {
                    this.f19696a.P0.b().D();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    VideoPbFragment videoPbFragment = this.f19696a;
                    videoPbFragment.n4(videoPbFragment.X);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19697e;

        public k1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19697e = videoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19697e.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19698e;

        public l(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19698e = videoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.f19698e.x1 != null && this.f19698e.x1.onTouchEvent(motionEvent);
                }
                if (this.f19698e.r1 == 1) {
                    if (!this.f19698e.v1) {
                        this.f19698e.O4();
                        UtilHelper.showStatusBar(this.f19698e.z(), this.f19698e.z().getRootView());
                        this.f19698e.v1 = true;
                        d.a.c.e.m.e.a().removeCallbacks(this.f19698e.z1);
                        d.a.c.e.m.e.a().postDelayed(this.f19698e.z1, 3000L);
                    }
                } else if (this.f19698e.r1 == 2 && (this.f19698e.v1 || this.f19698e.J3())) {
                    this.f19698e.N4();
                    UtilHelper.hideStatusBar(this.f19698e.z(), this.f19698e.z().getRootView());
                    this.f19698e.v1 = false;
                    if (this.f19698e.o != null) {
                        this.f19698e.o.X0(false);
                    }
                }
                this.f19698e.r1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19699a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19699a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.h(this.f19699a.f19644e, this.f19699a.f19644e.getUniqueId(), (View) customResponsedMessage.getData(), this.f19699a.f19646g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19701f;

        public l1(VideoPbFragment videoPbFragment, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19701f = videoPbFragment;
            this.f19700e = layoutParams;
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
                this.f19701f.Y4(this.f19700e);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19702e;

        public m(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19702e = videoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f19702e.r1 = 0;
                this.f19702e.s1 = 0.0f;
                this.f19702e.t1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f19702e.s1 += f2;
                this.f19702e.t1 += f3;
                if (this.f19702e.r1 == 0 && !this.f19702e.u1 && this.f19702e.o != null && !this.f19702e.o.C()) {
                    int height = this.f19702e.q.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.f19702e.t1) <= Math.abs(this.f19702e.s1) || this.f19702e.t1 > (-height) / 5) {
                        if (Math.abs(this.f19702e.t1) > Math.abs(this.f19702e.s1) && this.f19702e.t1 > 0.0f && f3 > 0.0f) {
                            this.f19702e.r1 = 2;
                        }
                    } else {
                        this.f19702e.r1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19703a;

        public m0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19703a = videoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.q(this.f19703a.f19644e, ItemCardHelper.OrderTipStatus.FAIL, this.f19703a.f19646g);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.q(this.f19703a.f19644e, ItemCardHelper.OrderTipStatus.SUCCESS, this.f19703a.f19646g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19706g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19707h;

        public m1(VideoPbFragment videoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19707h = videoPbFragment;
            this.f19704e = layoutParams;
            this.f19705f = layoutParams2;
            this.f19706g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.X1);
                this.f19704e.height = floatValue;
                this.f19705f.height = (this.f19706g - VideoPbFragment.X1) + floatValue;
                this.f19707h.z.setLayoutParams(this.f19704e);
                this.f19707h.m.setLayoutParams(this.f19705f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19708e;

        public n(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19708e = videoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19708e.v1 && !this.f19708e.J3()) {
                this.f19708e.N4();
                UtilHelper.hideStatusBar(this.f19708e.z(), this.f19708e.z().getRootView());
                this.f19708e.v1 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19709e;

        public n0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19709e = videoPbFragment;
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
                    if (this.f19709e.X2() != null) {
                        this.f19709e.X2().m1(false);
                    } else if (this.f19709e.I3() && this.f19709e.m3() != null) {
                        this.f19709e.m3().i1(false);
                    }
                    if (this.f19709e.Y2() != null) {
                        this.f19709e.Y2().W0(true);
                        VideoPbFragment videoPbFragment = this.f19709e;
                        videoPbFragment.z4(videoPbFragment.Y2().O0() == 0 ? 8 : 0);
                        this.f19709e.n0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.f19709e.getActivity()).get(VideoPbViewModel.class);
                    this.f19709e.o.W0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false);
                    this.f19709e.j4();
                    if (this.f19709e.y() != null && this.f19709e.y().D0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.f19709e.y().T0()).param("fid", this.f19709e.y().D0().n()));
                    }
                } else {
                    if (this.f19709e.Y2() != null) {
                        this.f19709e.Y2().W0(false);
                    }
                    if (this.f19709e.X2() != null) {
                        this.f19709e.X2().m1(true);
                        int e1 = this.f19709e.X2().e1();
                        int c1 = this.f19709e.X2().c1();
                        if (e1 != 0) {
                            this.f19709e.z4(8);
                            this.f19709e.X2().w1(0);
                        } else if (c1 != 0) {
                            this.f19709e.X2().w1(8);
                            this.f19709e.z4(0);
                        } else {
                            this.f19709e.X2().w1(8);
                            this.f19709e.z4(8);
                        }
                    } else if (this.f19709e.m3() != null) {
                        this.f19709e.m3().i1(true);
                        int c12 = this.f19709e.m3().c1();
                        int a1 = this.f19709e.m3().a1();
                        if (c12 != 0) {
                            this.f19709e.z4(8);
                            this.f19709e.m3().q1(0);
                        } else if (a1 != 0) {
                            this.f19709e.m3().q1(8);
                            this.f19709e.z4(0);
                        } else {
                            this.f19709e.m3().q1(8);
                            this.f19709e.z4(8);
                        }
                        this.f19709e.n0.setVisibility(0);
                    }
                    this.f19709e.o.W0(false);
                    this.f19709e.m.setExpanded(false, true);
                    if (this.f19709e.y() != null && this.f19709e.y().D0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.f19709e.y().T0()).param("fid", this.f19709e.y().D0().n()));
                    }
                }
                this.f19709e.j.k(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements a.InterfaceC1243a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19710a;

        public n1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19710a = videoPbFragment;
        }

        @Override // d.a.r0.h.a.InterfaceC1243a
        public void a(boolean z, boolean z2, String str) {
            d.a.r0.r.q.b2 N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f19710a.w4();
                if (z && this.f19710a.y() != null) {
                    if (this.f19710a.V != null) {
                        this.f19710a.V.h(z2);
                    }
                    this.f19710a.y().X1(z2);
                    if (this.f19710a.y().D0() != null && (N = this.f19710a.y().D0().N()) != null) {
                        if (z2) {
                            N.J2++;
                        } else {
                            int i2 = N.J2;
                            if (i2 > 0) {
                                N.J2 = i2 - 1;
                            }
                        }
                    }
                    if (this.f19710a.y().p0()) {
                        this.f19710a.Q3();
                    } else if (this.f19710a.I3()) {
                        if (this.f19710a.Y2() != null) {
                            this.f19710a.Y2().R0();
                        }
                        if (this.f19710a.m3() != null) {
                            this.f19710a.m3().f1();
                        }
                    } else if (this.f19710a.X2() != null) {
                        this.f19710a.X2().i1();
                    }
                    if (z2) {
                        if (this.f19710a.V != null) {
                            if (this.f19710a.V.f() == null || this.f19710a.y() == null || this.f19710a.y().D0() == null || this.f19710a.y().D0().N() == null || this.f19710a.y().D0().N().H() == null) {
                                return;
                            }
                            MarkData f2 = this.f19710a.V.f();
                            MetaData H = this.f19710a.y().D0().N().H();
                            if (f2 != null && H != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), H.getUserId()) && !H.hadConcerned()) {
                                    this.f19710a.T.u0(H);
                                } else {
                                    this.f19710a.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                VideoPbFragment videoPbFragment = this.f19710a;
                                videoPbFragment.showToast(videoPbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f19710a.z2();
                        return;
                    }
                    VideoPbFragment videoPbFragment2 = this.f19710a;
                    videoPbFragment2.showToast(videoPbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPbFragment videoPbFragment3 = this.f19710a;
                videoPbFragment3.showToast(videoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19711a;

        public o(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19711a = videoPbFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.f19711a.y() != null) {
                    switch (this.f19711a.Z.getLoadDataMode()) {
                        case 0:
                            this.f19711a.y().Z0();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f19711a.Q2(bVar, (bVar.f21137e != 1002 || bVar.f21138f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f19711a.R2(1, dVar.f21140a, dVar.f21141b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            VideoPbFragment videoPbFragment = this.f19711a;
                            videoPbFragment.S2(videoPbFragment.Z.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            VideoPbFragment videoPbFragment2 = this.f19711a;
                            videoPbFragment2.R2(videoPbFragment2.Z.getLoadDataMode(), gVar.f21154a, gVar.f21155b, false);
                            this.f19711a.T.e0(gVar.f21156c);
                            return;
                        default:
                            return;
                    }
                }
                VideoPbFragment videoPbFragment3 = this.f19711a;
                videoPbFragment3.R2(videoPbFragment3.Z.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.t.a f19712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19713b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19714c;

        public o0(VideoPbFragment videoPbFragment, d.a.r0.t.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19714c = videoPbFragment;
            this.f19712a = aVar;
            this.f19713b = i2;
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
                this.f19714c.L4(this.f19712a, bitmap, this.f19713b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19715e;

        public o1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19715e = videoPbFragment;
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
                this.f19715e.z.setVisibility(8);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19716e;

        public p(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19716e = videoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f19716e.R0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements c.InterfaceC1490c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Random f19717a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19718b;

        public p0(VideoPbFragment videoPbFragment, Random random) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, random};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19718b = videoPbFragment;
            this.f19717a = random;
        }

        @Override // d.a.s0.h2.p.c.InterfaceC1490c
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f19717a.nextInt(2) * 0.1f) + 0.8f : invokeV.floatValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19720f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19721g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19722h;

        public p1(VideoPbFragment videoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19722h = videoPbFragment;
            this.f19719e = layoutParams;
            this.f19720f = layoutParams2;
            this.f19721g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.X1);
                this.f19719e.height = floatValue;
                this.f19720f.height = this.f19721g + floatValue;
                this.f19722h.z.setLayoutParams(this.f19719e);
                this.f19722h.m.setLayoutParams(this.f19720f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class q implements b.InterfaceC1500b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q() {
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

        @Override // d.a.s0.i0.b.InterfaceC1500b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d.a.s0.h2.i.b.d();
                } else {
                    d.a.s0.h2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.t.a f19723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19724f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19725g;

        public q0(VideoPbFragment videoPbFragment, d.a.r0.t.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19725g = videoPbFragment;
            this.f19723e = aVar;
            this.f19724f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = this.f19725g.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.c.e.p.k.getUrlEncode(this.f19723e.d())});
                TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f19724f).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19726e;

        public q1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19726e = videoPbFragment;
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
                this.f19726e.W4();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19727e;

        public r(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19727e = videoPbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19728e;

        public r0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19728e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19728e.a1.k();
                this.f19728e.v3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19729e;

        public r1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19729e = videoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19729e.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19730a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19731e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s f19732f;

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
                this.f19732f = sVar;
                this.f19731e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19731e == null) {
                    return;
                }
                this.f19732f.f19730a.Q4();
                this.f19732f.f19730a.Y3(this.f19731e.getmAdverSegmentData(), 2);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
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

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f19733e;

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
                this.f19733e = sVar;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19733e.f19730a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19733e.f19730a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public s(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19730a = videoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.r0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19730a.y() != null && this.f19730a.y().D0() != null) {
                        statisticItem.param("fid", this.f19730a.y().D0().n());
                    }
                    if (this.f19730a.y() != null) {
                        statisticItem.param("tid", this.f19730a.y().T0());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    d.a.s0.h2.k.e.v0 v0Var = this.f19730a.K0;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d.a.r0.s.h.b.a(this.f19730a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.c.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19730a.H0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19730a.getActivity(), this.f19730a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19730a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f19730a.getActivity());
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19730a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19730a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                VideoPbFragment videoPbFragment = this.f19730a;
                if (videoPbFragment.K0 == null) {
                    return;
                }
                if (videoPbFragment.P0 != null && this.f19730a.P0.b() != null && this.f19730a.P0.b().v()) {
                    this.f19730a.P0.b().t(postWriteCallBackData);
                }
                this.f19730a.K0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19734e;

        public s0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19734e = videoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19734e.Q == null) {
                return;
            }
            d.a.s0.h2.p.d.b(this.f19734e.Q);
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements d.a.c.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19735a;

        public s1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19735a = videoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
                    if (d.a.r0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f19735a.getPageContext().getPageActivity());
                boolean g2 = d.a.r0.r.k.c().g();
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

    /* loaded from: classes5.dex */
    public class t implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19737f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f19738g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19739h;

        public t(VideoPbFragment videoPbFragment, MarkData markData, MarkData markData2, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, markData, markData2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19739h = videoPbFragment;
            this.f19736e = markData;
            this.f19737f = markData2;
            this.f19738g = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f19739h.V != null) {
                    if (this.f19739h.V.e()) {
                        this.f19739h.V.d();
                        this.f19739h.V.h(false);
                    }
                    this.f19739h.V.i(this.f19736e);
                    this.f19739h.V.h(true);
                    this.f19739h.V.a();
                }
                this.f19737f.setPostId(this.f19736e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19737f);
                this.f19739h.f19644e.setResult(-1, intent);
                this.f19738g.dismiss();
                this.f19739h.S4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19740e;

        public t0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19740e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19740e.A == null || this.f19740e.A.o()) {
                    if (this.f19740e.A != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.f19740e.y().D0().P()));
                        this.f19740e.A.p = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.f19740e.K4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements d.a.c.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19741a;

        public t1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19741a = videoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
                if (d.a.r0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f19741a.getPageContext().getPageActivity());
                boolean g2 = d.a.r0.r.k.c().g();
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
                gifView.g0();
                gifView.c0();
                gifView.setImageDrawable(null);
                gifView.h0();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f19743f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19744g;

        public u(VideoPbFragment videoPbFragment, MarkData markData, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, markData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19744g = videoPbFragment;
            this.f19742e = markData;
            this.f19743f = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19742e);
                this.f19744g.f19644e.setResult(-1, intent);
                this.f19743f.dismiss();
                this.f19744g.S4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19745e;

        public u0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19745e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19745e.getActivity(), "pb_huitie"))) {
                this.f19745e.P2(false);
                this.f19745e.b4();
                if (this.f19745e.y() == null || this.f19745e.y().D0() == null || this.f19745e.y().D0().N() == null || this.f19745e.y().D0().N().H() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f19745e.y().U0()).param("fid", this.f19745e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19745e.y().T0()).param("fid", this.f19745e.y().D0().n()).param("obj_locate", 1).param("uid", this.f19745e.y().D0().N().H().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements d.a.c.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19746a;

        public u1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19746a = videoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                ((PlayVoiceBntNew) view).m();
                return view;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f19746a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f19746a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).l();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19747a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19747a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f19747a.v3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19748a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19748a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f19748a.n0.getLayoutParams();
            layoutParams.height = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.f19748a.n0.setLayoutParams(layoutParams);
            if (this.f19748a.I3() && this.f19748a.f19647h != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f19748a.f19647h.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = VideoPbFragment.Y1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, VideoPbFragment.Y1);
                }
                this.f19748a.f19647h.setLayoutParams(layoutParams2);
                this.f19748a.f19648i.setScrollable(true);
            }
            this.f19748a.j4();
            if (this.f19748a.Y2() != null) {
                this.f19748a.Y2().R0();
            }
            if (this.f19748a.X2() != null) {
                this.f19748a.X2().i1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements d.a.c.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19749a;

        public v1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19749a = videoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19749a.getPageContext().getPageActivity());
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

    /* loaded from: classes5.dex */
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19750e;

        public w(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19750e = videoPbFragment;
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19751e;

        public w0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19751e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19751e.t3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements d.a.c.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19752a;

        public w1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19752a = videoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f19752a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements d.a.r0.w.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19753a;

        public x(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19753a = videoPbFragment;
        }

        @Override // d.a.r0.w.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19753a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19754e;

        public x0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19754e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19754e.j4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements Comparator<d.a.r0.t.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19755e;

        public x1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19755e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.r0.t.a aVar, d.a.r0.t.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19756e;

        public y(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19756e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i2;
            int i3;
            int i4;
            boolean a2;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f19756e.isAdded()) {
                int i6 = 1;
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.f19756e.y().T0());
                    statisticItem2.param("fid", this.f19756e.y().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.f19756e.m0) {
                        this.f19756e.m0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.f19756e.y() == null || this.f19756e.y().D0() == null || this.f19756e.Q0 == null || postData.t() == null || postData.A() == 1 || !this.f19756e.checkUpIsLogin()) {
                                return;
                            }
                            if (this.f19756e.P0 != null) {
                                this.f19756e.P0.c();
                            }
                            d.a.s0.h2.h.r rVar = new d.a.s0.h2.h.r();
                            rVar.A(this.f19756e.y().D0().m());
                            rVar.E(this.f19756e.y().D0().N());
                            rVar.C(postData);
                            this.f19756e.Q0.I(rVar);
                            this.f19756e.Q0.setPostId(postData.E());
                            this.f19756e.P3(view, postData.t().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            d.a.s0.h2.m.a.b(this.f19756e.y().D0(), postData, postData.i0, 8, 1);
                            if (this.f19756e.N0 != null) {
                                VideoPbFragment videoPbFragment = this.f19756e;
                                videoPbFragment.r4(videoPbFragment.N0.C());
                            }
                        }
                    }
                } else if ((this.f19756e.I3() && this.f19756e.m3() != null && this.f19756e.m3().b1() != null && view == this.f19756e.m3().b1()) || ((this.f19756e.X2() != null && this.f19756e.X2().d1() != null && view == this.f19756e.X2().d1()) || view.getId() == R.id.pb_more)) {
                    if (!this.f19756e.R && this.f19756e.y().l1(true)) {
                        this.f19756e.R = true;
                        if (this.f19756e.I3()) {
                            if (this.f19756e.m3() != null) {
                                this.f19756e.m3().p1();
                            }
                        } else if (this.f19756e.X2() != null) {
                            this.f19756e.X2().v1();
                        }
                    }
                } else {
                    d.a.s0.h2.o.g.a aVar = this.f19756e.T;
                    if (aVar != null && aVar.Q() != null && view == this.f19756e.T.Q().e()) {
                        this.f19756e.T.I();
                        return;
                    }
                    d.a.s0.h2.o.g.a aVar2 = this.f19756e.T;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.f19756e.T.Q().i()) && view.getId() != R.id.owner_reply && view.getId() != R.id.all_reply)) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                        VideoPbFragment videoPbFragment2 = this.f19756e;
                        if (view == videoPbFragment2.t) {
                            if (videoPbFragment2.y() == null || this.f19756e.y().D0() == null) {
                                return;
                            }
                            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem3 = new StatisticItem("c13266");
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.f19756e.y().D0().n());
                                statisticItem3.param("tid", this.f19756e.y().T0());
                                statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem3);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            d.a.c.e.p.l.x(this.f19756e.f19644e, this.f19756e.t);
                            this.f19756e.f19644e.finish();
                        } else if (view == videoPbFragment2.v && videoPbFragment2.T != null) {
                            if (d.a.r0.z0.l.a()) {
                                return;
                            }
                            if (this.f19756e.y() != null && this.f19756e.y().D0() != null) {
                                ArrayList<PostData> E = this.f19756e.y().D0().E();
                                if ((E == null || E.size() <= 0) && this.f19756e.y().R0()) {
                                    d.a.c.e.p.l.M(this.f19756e.getPageContext().getPageActivity(), this.f19756e.getPageContext().getString(R.string.pb_no_data_tips));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f19756e.y().T0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f19756e.y().getForumId()));
                                this.f19756e.T.k0();
                                return;
                            }
                            d.a.c.e.p.l.M(this.f19756e.getPageContext().getPageActivity(), this.f19756e.getPageContext().getString(R.string.pb_no_data_tips));
                        } else if (this.f19756e.T.Q() != null && view == this.f19756e.T.Q().l()) {
                            if (this.f19756e.y() == null) {
                                return;
                            }
                            this.f19756e.T.F();
                            if (d.a.c.e.p.j.z()) {
                                this.f19756e.R4();
                                this.f19756e.x4();
                                this.f19756e.y().V1(1);
                                return;
                            }
                            this.f19756e.showToast(R.string.network_not_available);
                        } else {
                            d.a.s0.h2.o.g.a aVar3 = this.f19756e.T;
                            if (aVar3 != null && aVar3.Q() != null && view == this.f19756e.T.Q().i()) {
                                this.f19756e.T.I();
                                return;
                            }
                            d.a.s0.h2.o.g.a aVar4 = this.f19756e.T;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.f19756e.T.Q().r()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                                this.f19756e.T.F();
                                if (d.a.c.e.p.j.z()) {
                                    if (!this.f19756e.R) {
                                        this.f19756e.R4();
                                        this.f19756e.x4();
                                        this.f19756e.T.D0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.f19756e.y().P0()));
                                    return;
                                }
                                this.f19756e.showToast(R.string.network_not_available);
                                return;
                            }
                            d.a.s0.h2.o.g.a aVar5 = this.f19756e.T;
                            if (aVar5 != null && aVar5.Q() != null && view == this.f19756e.T.Q().q()) {
                                if (this.f19756e.y() == null || this.f19756e.y().D0() == null || this.f19756e.y().D0().N() == null) {
                                    return;
                                }
                                this.f19756e.T.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                VideoPbFragment videoPbFragment3 = this.f19756e;
                                videoPbFragment3.T.U(videoPbFragment3.y().D0().N().T());
                            } else if (view.getId() == R.id.pb_floor_feedback) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                d.a.s0.h2.o.g.a aVar6 = this.f19756e.T;
                                if (aVar6 != null) {
                                    aVar6.r0(sparseArray);
                                }
                            } else {
                                d.a.s0.h2.o.g.a aVar7 = this.f19756e.T;
                                if (aVar7 != null && aVar7.Q() != null && view == this.f19756e.T.Q().o()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    if (skinType == 1) {
                                        this.f19756e.onChangeSkinType(skinType);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                    } else if (skinType == 0 || skinType == 4) {
                                        UtilHelper.showSkinChangeAnimation(this.f19756e.getActivity());
                                        this.f19756e.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.f19756e.getActivity(), this.f19756e.getResources().getColor(R.color.CAM_X0201_1));
                                        TbadkCoreApplication.getInst().setSkinType(1);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                    }
                                    this.f19756e.T.J();
                                    return;
                                }
                                d.a.s0.h2.o.g.a aVar8 = this.f19756e.T;
                                if (aVar8 != null && aVar8.Q() != null && view == this.f19756e.T.Q().p()) {
                                    this.f19756e.T.J();
                                    VideoPbFragment videoPbFragment4 = this.f19756e;
                                    videoPbFragment4.T.A0(videoPbFragment4.I1);
                                    return;
                                }
                                d.a.s0.h2.o.g.a aVar9 = this.f19756e.T;
                                if (aVar9 != null && (view == aVar9.M() || (this.f19756e.T.Q() != null && (view == this.f19756e.T.Q().m() || view == this.f19756e.T.Q().n())))) {
                                    if (!d.a.c.e.p.j.z()) {
                                        this.f19756e.showToast(R.string.network_not_available);
                                        return;
                                    } else if ((this.f19756e.y() == null && this.f19756e.y().D0() == null) || this.f19756e.Z.O()) {
                                        return;
                                    } else {
                                        this.f19756e.T.F();
                                        if (this.f19756e.T.Q() != null && view == this.f19756e.T.Q().n()) {
                                            i4 = this.f19756e.y().D0().N().m0() == 1 ? 5 : 4;
                                        } else if (this.f19756e.T.Q() != null && view == this.f19756e.T.Q().m()) {
                                            i4 = this.f19756e.y().D0().N().l0() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view == this.f19756e.T.M() ? 2 : 0;
                                        }
                                        ForumData m = this.f19756e.y().D0().m();
                                        String name = m.getName();
                                        String id = m.getId();
                                        String c0 = this.f19756e.y().D0().N().c0();
                                        this.f19756e.showProgressBar();
                                        this.f19756e.Z.S(id, name, c0, i4, this.f19756e.T.N());
                                        return;
                                    }
                                }
                                d.a.s0.h2.o.g.a aVar10 = this.f19756e.T;
                                if (aVar10 != null && aVar10.Q() != null && view == this.f19756e.T.Q().h()) {
                                    if (this.f19756e.y() == null) {
                                        return;
                                    }
                                    if (!d.a.c.e.p.j.z()) {
                                        this.f19756e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.f19756e.T.F();
                                    VideoPbFragment videoPbFragment5 = this.f19756e;
                                    SparseArray<Object> e3 = videoPbFragment5.e3(videoPbFragment5.y().D0(), this.f19756e.y().R0(), 1);
                                    if (e3 == null) {
                                        return;
                                    }
                                    this.f19756e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19756e.getPageContext().getPageActivity(), this.f19756e.y().D0().m().getId(), this.f19756e.y().D0().m().getName(), this.f19756e.y().D0().N().c0(), String.valueOf(this.f19756e.y().D0().T().getUserId()), (String) e3.get(R.id.tag_forbid_user_name), (String) e3.get(R.id.tag_forbid_user_name_show), (String) e3.get(R.id.tag_forbid_user_post_id), (String) e3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                d.a.s0.h2.o.g.a aVar11 = this.f19756e.T;
                                if (aVar11 != null && aVar11.Q() != null && view == this.f19756e.T.Q().f()) {
                                    if (this.f19756e.y() == null) {
                                        return;
                                    }
                                    if (!d.a.c.e.p.j.z()) {
                                        this.f19756e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    VideoPbFragment videoPbFragment6 = this.f19756e;
                                    SparseArray<Object> e32 = videoPbFragment6.e3(videoPbFragment6.y().D0(), this.f19756e.y().R0(), 1);
                                    if (e32 != null) {
                                        if (StringUtils.isNull((String) e32.get(R.id.tag_del_multi_forum))) {
                                            this.f19756e.T.f0(((Integer) e32.get(R.id.tag_del_post_type)).intValue(), (String) e32.get(R.id.tag_del_post_id), ((Integer) e32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) e32.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.f19756e.T.g0(((Integer) e32.get(R.id.tag_del_post_type)).intValue(), (String) e32.get(R.id.tag_del_post_id), ((Integer) e32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) e32.get(R.id.tag_del_post_is_self)).booleanValue(), (String) e32.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.f19756e.T.I();
                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText && view.getId() != R.id.pb_post_reply_count) {
                                    if (view.getId() != R.id.pb_post_reply && view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                        if (view.getId() != R.id.pb_editor_tool_collection && view.getId() != R.id.collect_num_container) {
                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                this.f19756e.p3(true);
                                            } else if (view.getId() != R.id.pb_editor_tool_comment_icon && view.getId() != R.id.thread_info_commont_container) {
                                                if (view.getId() == R.id.tv_pb_reply_more) {
                                                    if (this.f19756e.W0 >= 0) {
                                                        if (this.f19756e.y() != null) {
                                                            this.f19756e.y().H1();
                                                        }
                                                        if (this.f19756e.I3() && this.f19756e.y() != null && this.f19756e.m3() != null && this.f19756e.m3().G0() != null) {
                                                            this.f19756e.m3().G0().f(this.f19756e.y().D0());
                                                        } else if (this.f19756e.X2() != null && this.f19756e.X2().G0() != null) {
                                                            this.f19756e.X2().G0().v(this.f19756e.y().D0());
                                                        }
                                                        this.f19756e.W0 = 0;
                                                        this.f19756e.X0 = Integer.MIN_VALUE;
                                                        if (this.f19756e.I3() && this.f19756e.y() != null && this.f19756e.m3() != null) {
                                                            this.f19756e.m3().l1(this.f19756e.y().w0(), this.f19756e.y().v0());
                                                            this.f19756e.y().L1(0, 0);
                                                        } else if (this.f19756e.y() == null || this.f19756e.X2() == null) {
                                                        } else {
                                                            this.f19756e.X2().q1(this.f19756e.y().w0(), this.f19756e.y().v0());
                                                            this.f19756e.y().L1(0, 0);
                                                        }
                                                    }
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.f19756e.y() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                    statisticItem4.param("tid", this.f19756e.y().T0());
                                                    statisticItem4.param("fid", this.f19756e.y().getForumId());
                                                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem4.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem4);
                                                } else if (view.getId() == R.id.pb_item_tail_content) {
                                                    if (ViewHelper.checkUpIsLogin(this.f19756e.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                        String p = d.a.r0.r.d0.b.j().p("tail_link", "");
                                                        if (!StringUtils.isNull(p)) {
                                                            TiebaStatic.log("c10056");
                                                            d.a.r0.l.a.o(view.getContext(), string, p, true, true, true);
                                                        }
                                                        this.f19756e.j4();
                                                    }
                                                } else if (view.getId() == R.id.keyboard_background_shadow) {
                                                    this.f19756e.j4();
                                                } else if (this.f19756e.T.Q() != null && view == this.f19756e.T.Q().d()) {
                                                    this.f19756e.T.F();
                                                    if (this.f19756e.y() != null) {
                                                        this.f19756e.x.f(this.f19756e.y().T0());
                                                    }
                                                    if (this.f19756e.y() == null || !this.f19756e.y().isPrivacy()) {
                                                        this.f19756e.x.b();
                                                        if (!TbSingleton.getInstance().mCanCallFans && this.f19756e.y() != null && this.f19756e.y().D0() != null && this.f19756e.y().D0().P() != null && this.f19756e.y().D0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
                                                            i6 = 2;
                                                        }
                                                        if (this.f19756e.y() == null || this.f19756e.y().D0() == null) {
                                                            return;
                                                        }
                                                        this.f19756e.x.d(3, i6, this.f19756e.y().D0().P());
                                                        return;
                                                    }
                                                    this.f19756e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                    if (this.f19756e.y().D0() != null) {
                                                        this.f19756e.x.d(3, 3, this.f19756e.y().D0().P());
                                                    }
                                                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                                                    StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                    statisticItem5.param("tid", this.f19756e.y().T0());
                                                    statisticItem5.param("fid", this.f19756e.y().getForumId());
                                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem5.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem5);
                                                    this.f19756e.T.m0(false);
                                                    this.f19756e.T.P().onLongClick(view);
                                                }
                                            } else if (this.f19756e.y() != null) {
                                                VideoPbFragment videoPbFragment7 = this.f19756e;
                                                if (videoPbFragment7.T == null || videoPbFragment7.f19648i == null || this.f19756e.y().D0() == null || this.f19756e.y().D0().N() == null || !this.f19756e.checkUpIsLogin()) {
                                                    return;
                                                }
                                                d.a.s0.h2.h.e D0 = this.f19756e.y().D0();
                                                int P0 = D0.N().P0();
                                                int currentItem = this.f19756e.f19648i.getCurrentItem();
                                                if (P0 == 0) {
                                                    if (this.f19756e.I3() && currentItem == VideoPbFragment.Q1) {
                                                        this.f19756e.f19648i.setCurrentItem(VideoPbFragment.R1);
                                                    }
                                                    this.f19756e.P2(false);
                                                    this.f19756e.b4();
                                                    return;
                                                }
                                                if (this.f19756e.I3() && currentItem == VideoPbFragment.Q1) {
                                                    this.f19756e.f19648i.setCurrentItem(VideoPbFragment.R1);
                                                } else if ((this.f19756e.I3() && this.f19756e.m3() == null) || this.f19756e.X2() == null || this.f19756e.l3() == null) {
                                                    return;
                                                } else {
                                                    StatisticItem param = new StatisticItem("c13403").param("tid", this.f19756e.y().T0()).param("fid", this.f19756e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    int i7 = (int) (d.a.c.e.p.l.i(this.f19756e.getContext()) * 0.6d);
                                                    BdTypeRecyclerView l3 = this.f19756e.l3();
                                                    if (l3 == null) {
                                                        return;
                                                    }
                                                    boolean canScrollVertically = l3.canScrollVertically(1);
                                                    boolean canScrollVertically2 = l3.canScrollVertically(-1);
                                                    if (this.f19756e.m != null) {
                                                        this.f19756e.m.setExpanded(false, true);
                                                    }
                                                    if (l3.getLayoutManager() == null || !(l3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                        return;
                                                    }
                                                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) l3.getLayoutManager();
                                                    if (!canScrollVertically2 && canScrollVertically) {
                                                        if (this.f19756e.U0 == -1 && this.f19756e.V0 == Integer.MIN_VALUE) {
                                                            return;
                                                        }
                                                        if (this.f19756e.U0 > 3 || (this.f19756e.U0 == 3 && this.f19756e.V0 < (-i7))) {
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19756e.U0, this.f19756e.V0 + i7);
                                                            l3.smoothScrollBy(0, i7);
                                                        } else if (this.f19756e.U0 >= 2) {
                                                            int i8 = i7 / 2;
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19756e.U0, this.f19756e.V0 + i8);
                                                            l3.smoothScrollBy(0, i8);
                                                        } else if (this.f19756e.U0 == 1) {
                                                            int i9 = i7 / 4;
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19756e.U0, this.f19756e.V0 + i9);
                                                            l3.smoothScrollBy(0, i9);
                                                        } else {
                                                            l3.smoothScrollBy(0, -this.f19756e.V0);
                                                        }
                                                        param.param("obj_locate", 2);
                                                        i3 = 1;
                                                    } else {
                                                        int firstVisiblePosition = l3.getFirstVisiblePosition();
                                                        View childAt = l3.getChildAt(0);
                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                        this.f19756e.U0 = firstVisiblePosition;
                                                        this.f19756e.V0 = top;
                                                        if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || l3.getCount() < 6)) {
                                                            l3.smoothScrollToPosition(0);
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                            l3.smoothScrollToPosition(0);
                                                        }
                                                        i3 = 1;
                                                        param.param("obj_locate", 1);
                                                    }
                                                    TiebaStatic.log(param);
                                                    d.a.r0.i0.c f2 = TbPageExtraHelper.f(view);
                                                    StatisticItem statisticItem6 = new StatisticItem("c12942");
                                                    statisticItem6.param("obj_type", i3);
                                                    statisticItem6.param("obj_locate", 4);
                                                    statisticItem6.param("tid", this.f19756e.y().T0());
                                                    statisticItem6.param("nid", D0.N().A0());
                                                    if (f2 != null) {
                                                        statisticItem6.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                    }
                                                    if (TbPageExtraHelper.m() != null) {
                                                        statisticItem6.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                    }
                                                    TiebaStatic.log(statisticItem6);
                                                }
                                                if (this.f19756e.y() == null || this.f19756e.y().D0() == null || this.f19756e.y().D0().N() == null || this.f19756e.y().D0().N().H() == null) {
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19756e.y().T0()).param("fid", this.f19756e.y().D0().n()).param("obj_locate", 2).param("uid", this.f19756e.y().D0().N().H().getUserId()));
                                            }
                                        } else if (!d.a.c.e.p.j.z()) {
                                            this.f19756e.showToast(R.string.network_not_available);
                                        } else {
                                            VideoPbFragment videoPbFragment8 = this.f19756e;
                                            if (videoPbFragment8.T == null || videoPbFragment8.y() == null) {
                                                return;
                                            }
                                            if (this.f19756e.I3() && this.f19756e.m3() == null) {
                                                return;
                                            }
                                            if (this.f19756e.I3() || this.f19756e.X2() != null) {
                                                this.f19756e.T.F();
                                                if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19756e.getActivity(), "pb_shoucang"))) {
                                                    if (!this.f19756e.G2(11009) || this.f19756e.y() == null) {
                                                        return;
                                                    }
                                                    this.f19756e.R3();
                                                    if (this.f19756e.y().D0() != null && this.f19756e.y().D0().N() != null && this.f19756e.y().D0().N().H() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19756e.y().T0()).param("fid", this.f19756e.y().D0().n()).param("obj_locate", 3).param("uid", this.f19756e.y().D0().N().H().getUserId()));
                                                    }
                                                    if (this.f19756e.y().D0().N() == null || this.f19756e.y().D0().N().H() == null || this.f19756e.y().D0().N().H().getUserId() == null || this.f19756e.V == null) {
                                                        return;
                                                    }
                                                    VideoPbFragment videoPbFragment9 = this.f19756e;
                                                    int S = videoPbFragment9.T.S(videoPbFragment9.y().D0());
                                                    d.a.r0.r.q.b2 N = this.f19756e.y().D0().N();
                                                    if (N.E1()) {
                                                        i2 = 2;
                                                    } else if (N.H1()) {
                                                        i2 = 3;
                                                    } else if (N.F1()) {
                                                        i2 = 4;
                                                    } else {
                                                        i2 = N.G1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19756e.y().T0()).param("obj_locate", 1).param("obj_id", this.f19756e.y().D0().N().H().getUserId()).param("obj_type", !this.f19756e.V.e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
                                                this.f19756e.D = view;
                                            }
                                        }
                                    } else if (this.f19756e.y() == null) {
                                    } else {
                                        if (view.getId() == R.id.pb_post_reply) {
                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                            statisticItem7.param("tid", this.f19756e.y().T0());
                                            statisticItem7.param("fid", this.f19756e.y().getForumId());
                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem7.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem7);
                                        }
                                        if (view.getId() == R.id.post_info_commont_img) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19756e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                this.f19756e.C = view;
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19756e.getActivity(), "pb_huifu_louzhonglou"))) {
                                            this.f19756e.C = view;
                                            return;
                                        }
                                        if (this.f19756e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.j0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f19756e.y().U0()).param("fid", this.f19756e.y().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.f19756e.y() == null || this.f19756e.y().D0() == null || this.f19756e.Q0 == null || postData2.t() == null || postData2.A() == 1) {
                                                    return;
                                                }
                                                if (this.f19756e.P0 != null) {
                                                    this.f19756e.P0.c();
                                                }
                                                if (this.f19756e.Z0 && postData2.M() != null && postData2.M().size() != 0) {
                                                    this.f19756e.P4(postData2, null, true, false);
                                                    return;
                                                }
                                                d.a.s0.h2.h.r rVar2 = new d.a.s0.h2.h.r();
                                                rVar2.A(this.f19756e.y().D0().m());
                                                rVar2.E(this.f19756e.y().D0().N());
                                                rVar2.C(postData2);
                                                this.f19756e.Q0.I(rVar2);
                                                this.f19756e.Q0.setPostId(postData2.E());
                                                this.f19756e.P3(view, postData2.t().getUserId(), "", postData2);
                                                if (this.f19756e.N0 != null) {
                                                    VideoPbFragment videoPbFragment10 = this.f19756e;
                                                    videoPbFragment10.r4(videoPbFragment10.N0.C());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                        statisticItem8.param("tid", this.f19756e.y().T0());
                                        statisticItem8.param("fid", this.f19756e.y().getForumId());
                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem8.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem8);
                                    }
                                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19756e.getActivity(), "pb_chakanhuifu"))) {
                                        this.f19756e.B = view;
                                    } else if (!this.f19756e.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f19756e.y().D0().n()));
                                    } else if (this.f19756e.y() == null || this.f19756e.y().D0() == null) {
                                    } else {
                                        d.a.s0.h2.o.g.a aVar12 = this.f19756e.T;
                                        if (aVar12 != null) {
                                            aVar12.F();
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
                                        StatisticItem statisticItem9 = postData3.j0;
                                        if (statisticItem9 != null) {
                                            StatisticItem copy2 = statisticItem9.copy();
                                            copy2.delete("obj_locate");
                                            if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.f19756e.R4();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.f19756e.P4(postData3, postData4, false, true);
                                        } else {
                                            this.f19756e.P4(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!d.a.c.e.p.j.z()) {
                        this.f19756e.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.f19756e.T.F();
                        if (!this.f19756e.R) {
                            this.f19756e.R4();
                            this.f19756e.x4();
                            if (view.getId() == R.id.owner_reply) {
                                a2 = this.f19756e.y().a2(true, this.f19756e.a3());
                            } else {
                                a2 = view.getId() == R.id.all_reply ? this.f19756e.y().a2(false, this.f19756e.a3()) : this.f19756e.y().Z1(this.f19756e.a3());
                            }
                            view.setTag(Boolean.valueOf(a2));
                            if (a2) {
                                this.f19756e.H4();
                                i5 = 1;
                                this.f19756e.R = true;
                            } else {
                                i5 = 1;
                            }
                            TiebaStatic.eventStat(this.f19756e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19757a;

        public y0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19757a = videoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19757a.Q0.E(postData);
                if (this.f19757a.X2() != null) {
                    this.f19757a.X2().i1();
                } else if (this.f19757a.I3() && this.f19757a.m3() != null) {
                    this.f19757a.m3().f1();
                }
                this.f19757a.P0.c();
                this.f19757a.O0.q();
                this.f19757a.E4(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements d.a.r0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19758a;

        public y1(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19758a = videoPbFragment;
        }

        @Override // d.a.r0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.h2.k.e.v0 v0Var = this.f19758a.K0;
                if (v0Var == null || v0Var.e() == null || !this.f19758a.K0.e().d()) {
                    return !this.f19758a.I2(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                VideoPbFragment videoPbFragment = this.f19758a;
                videoPbFragment.showToast(videoPbFragment.K0.e().c());
                if (this.f19758a.N0 != null && (this.f19758a.N0.B() || this.f19758a.N0.D())) {
                    this.f19758a.N0.z(false, this.f19758a.K0.h());
                }
                this.f19758a.K0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19759e;

        public z(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19759e = videoPbFragment;
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
            d.a.s0.h2.o.g.a aVar = this.f19759e.T;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.f19759e.T.B(sparseArray);
                        return;
                    }
                    aVar.j0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.f19759e.T.B(sparseArray);
                } else if (booleanValue3) {
                    aVar.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19760e;

        public z0(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19760e = videoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f19760e.T.m0(true);
                return this.f19760e.T.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19761a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z1(VideoPbFragment videoPbFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment, Integer.valueOf(i2)};
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
            this.f19761a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19761a.y() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f19761a.N0 != null) {
                VideoPbFragment videoPbFragment = this.f19761a;
                videoPbFragment.r4(videoPbFragment.N0.C());
            }
            this.f19761a.j4();
            this.f19761a.T.F();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-397295665, "Lcom/baidu/tieba/pb/videopb/VideoPbFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-397295665, "Lcom/baidu/tieba/pb/videopb/VideoPbFragment;");
                return;
            }
        }
        X1 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        Y1 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
        Z1 = new q();
    }

    public VideoPbFragment() {
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
        this.f19645f = 0L;
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
        this.Z0 = d.a.r0.b.d.W();
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
        this.E1 = new s(this);
        this.F1 = new x(this);
        this.G1 = new y(this);
        this.H1 = new z(this);
        this.I1 = new a0(this);
        this.J1 = new b0(this, 2001332);
        this.K1 = new l0(this, 2001440);
        this.L1 = new m0(this);
        this.M1 = new s0(this);
        this.N1 = new v0(this, 2921509);
        this.O1 = new z0(this);
        this.P1 = new a1(this);
        this.z0 = new b2(this, null);
    }

    public static VideoPbFragment T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? new VideoPbFragment() : (VideoPbFragment) invokeV.objValue;
    }

    public final void A2(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) || y() == null || y().D0() == null || y().D0().N() == null) {
            return;
        }
        d.a.r0.r.q.b2 N = y().D0().N();
        N.V0 = y().I0();
        N.U0 = y().L0();
        N.T0 = y().K0();
        N.W0 = y().J0();
        if (N.Q() == 0) {
            N.l3(d.a.c.e.m.b.f(y().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.r0.j0.c.i(getContext(), N, "c13563");
        TbPageTag l2 = d.a.r0.j0.c.l(getContext());
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
            d.a.r0.i0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = d.a.r0.j0.c.i(getContext(), N, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.param("obj_type", 2);
        } else {
            i3.param("obj_type", 1);
        }
        i3.param("tid", y().T0());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", y().D0().n());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.P = (FallingView) this.f19646g.findViewById(R.id.falling_view);
            TbImageView tbImageView = (TbImageView) this.f19646g.findViewById(R.id.falling_ad_view);
            this.Q = tbImageView;
            tbImageView.setPlaceHolder(2);
        }
    }

    public void A4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.y = z2;
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
    public final void B2(d.a.r0.r.q.b2 b2Var) {
        double d2;
        int ceil;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        Rect X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            double k2 = d.a.c.e.p.l.k(getContext());
            double i3 = (2.0d * k2) / d.a.c.e.p.l.i(getContext());
            if (b2Var != null && b2Var.l1() != null) {
                int intValue = b2Var.l1().video_width.intValue();
                int intValue2 = b2Var.l1().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= i3) {
                        i3 = d2;
                    }
                    ceil = (int) Math.ceil(k2 / i3);
                    int height = (y() != null || (X = y().X()) == null) ? ceil : X.height();
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
                    if (I3() && !d.a.r0.c1.b.e.d()) {
                        layoutParams3 = (RelativeLayout.LayoutParams) this.f19647h.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, Y1);
                        } else {
                            layoutParams3.height = Y1;
                        }
                        this.f19647h.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
                    if (I3() && !d.a.r0.c1.b.e.d()) {
                        ceil += Y1;
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
            if (I3()) {
                layoutParams3 = (RelativeLayout.LayoutParams) this.f19647h.getLayoutParams();
                if (layoutParams3 != null) {
                }
                this.f19647h.setLayoutParams(layoutParams3);
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
            if (I3()) {
                ceil += Y1;
            }
            if (layoutParams2 != null) {
            }
            this.m.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.H = (TextView) this.f19646g.findViewById(R.id.pb_video_mount_title);
            this.L = (TbImageView) this.f19646g.findViewById(R.id.pb_video_mount_pic);
            this.I = (TextView) this.f19646g.findViewById(R.id.pb_video_mount_desc);
            this.J = (ImageView) this.f19646g.findViewById(R.id.pb_video_mount_close);
            this.K = (TBSpecificationBtn) this.f19646g.findViewById(R.id.pb_video_mount_link);
            this.M = this.f19646g.findViewById(R.id.ala_live_point);
            this.L.setRadius(d.a.c.e.p.l.g(getContext(), R.dimen.tbds10));
            this.L.setConrers(15);
            this.K.setConfig(new d.a.r0.r.f0.m.c());
            this.J.setOnClickListener(new t0(this));
            this.K.setOnClickListener(this.G);
            this.z.setOnClickListener(this.G);
            if (y() == null || y().D0() == null) {
                return;
            }
            G4(y().D0());
        }
    }

    public final void B4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) {
            this.N0.f0(z2);
            this.N0.i0(z2);
            this.N0.p0(z2);
        }
    }

    @Override // d.a.s0.h2.o.b
    public PbFragment C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final void C2(d.a.s0.h2.o.i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) && aVar != null && this.A == null) {
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
            d.a.c.e.m.e.a().postDelayed(new j1(this), aVar.c().longValue() * 1000);
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f19646g.findViewById(R.id.video_pb_navigation_bar);
            this.q = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.q.hideBottomLine();
            this.q.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.q.getTopCoverBgView().setVisibility(0);
            this.r = this.f19646g.findViewById(R.id.statebar);
            View findViewById = this.f19646g.findViewById(R.id.status_bar_background);
            this.s = findViewById;
            if (this.u1) {
                ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
                layoutParams.height = d.a.c.e.p.l.r(z());
                this.r.setLayoutParams(layoutParams);
                this.r.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = d.a.c.e.p.l.r(z());
                this.s.setLayoutParams(layoutParams2);
                this.s.setVisibility(0);
            }
            View addSystemImageButton = this.q.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.G1);
            this.t = addSystemImageButton;
            this.u = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.q.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.G1);
            this.v = addCustomView;
            this.w = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.v.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.w, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.v.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.x1 = new GestureDetector(getContext(), this.y1);
            this.q.setOnTouchListener(this.w1);
        }
    }

    public final void C4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                d.a.s0.h2.o.g.a aVar = this.T;
                if (aVar != null) {
                    aVar.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || y() == null || this.f19644e == null) {
            return;
        }
        d.a.r0.w.w.e eVar = this.N0;
        if (eVar == null || !eVar.z) {
            d.a.r0.w.w.d dVar = new d.a.r0.w.w.d();
            u4(dVar);
            d.a.r0.w.w.e eVar2 = (d.a.r0.w.w.e) dVar.a(getContext());
            this.N0 = eVar2;
            eVar2.e0(this.f19644e.getPageContext());
            this.N0.n0(this.o1);
            this.N0.o0(this.F1);
            this.N0.F(this.f19644e.getPageContext(), this.f19644e.getIntent() == null ? null : this.f19644e.getIntent().getExtras());
            this.N0.a().C(true);
            q4(this.N0.a());
            if (!y().r0()) {
                this.N0.s(y().T0());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.N0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (y().b1()) {
                this.N0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.N0.k0(n3());
            }
        }
    }

    public void D3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.O0) == null) {
            return;
        }
        editorTools.j();
        d.a.r0.w.w.e eVar = this.N0;
        if (eVar != null) {
            eVar.P();
        }
        q3();
    }

    public final void D4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                d.a.r0.s.h.b.a(getPageContext(), postWriteCallBackData);
                return;
            } else {
                d.a.s0.h3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                return;
            }
        }
        if (y() != null && !y().r0()) {
            antiData.setBlock_forum_name(y().D0().m().getName());
            antiData.setBlock_forum_id(y().D0().m().getId());
            antiData.setUser_name(y().D0().T().getUserName());
            antiData.setUser_id(y().D0().T().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void E2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, bdTypeRecyclerView, z2) == null) {
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
                if (((d.a.r0.t.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                    Q4();
                    Y3((d.a.r0.t.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    Q4();
                    Y3((d.a.r0.t.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public void E3(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) || this.a1 == null || eVar == null || eVar.g() == 3) {
            return;
        }
        d.a.s0.h2.o.j.a aVar = new d.a.s0.h2.o.j.a();
        this.F = aVar;
        aVar.e(eVar.k() == null ? null : eVar.k().pbpage);
        this.F.d(TbSingleton.getInstance().getAdFloatViewData());
        v3();
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

    public void E4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) || this.p0 == null || d.a.r0.c1.b.e.d()) {
            return;
        }
        r4(this.N0.C());
        if (this.B0) {
            F4(z2);
        } else {
            r3(z2);
        }
        Z3();
        c4();
    }

    public final boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PbModel y2 = y();
            if (y2 == null || y2.D0() == null) {
                return false;
            }
            d.a.r0.r.q.b2 N = y2.D0().N();
            y2.D0().d();
            return AntiHelper.b(getPageContext(), N);
        }
        return invokeV.booleanValue;
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f19647h.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.f19647h.setContainerLayoutParams(layoutParams);
            this.f19647h.setRectPaintColor(R.color.CAM_X0302);
            this.f19647h.C(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.f19647h.setIndicatorOffset(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.f19647h.setIndicatorOvershot(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.f19647h.setIndicatorMarginBottom(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f19647h.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void F4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) || this.p0 == null || (textView = this.s0) == null) {
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
        this.z0.f19656a = true;
    }

    public final boolean G2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.s0.i0.b bVar = new d.a.s0.i0.b(getActivity());
            this.R0 = bVar;
            bVar.i(Z1);
            this.u1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            C3();
            this.m = (AppBarLayout) this.f19646g.findViewById(R.id.appbar_layout);
            this.k = this.f19646g.findViewById(R.id.pb_video_pager_shadow);
            this.a1 = (RightFloatLayerView) this.f19646g.findViewById(R.id.right_layer_view);
            registerListener(this.b1);
            this.n = (VideoContainerLayout) this.f19646g.findViewById(R.id.pb_video_container);
            d.a.s0.h2.o.k.a aVar = new d.a.s0.h2.o.k.a(getContext(), this.n);
            this.o = aVar;
            aVar.setStageType("2002");
            this.o.setUniqueId(getUniqueId());
            this.o.c1(this);
            this.o.a1(z().getRootView());
            this.o.b1(this.s);
            ((RelativeLayout) this.f19646g.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((d.a.c.e.p.l.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.f19647h = (NewPagerSlidingTabBaseStrip) this.f19646g.findViewById(R.id.pb_video_tab_strip);
            this.z = this.f19646g.findViewById(R.id.pb_video_mount_layout);
            this.f19648i = (CustomViewPager) this.f19646g.findViewById(R.id.pb_video_view_pager);
            this.l = this.f19646g.findViewById(R.id.keyboard_background_shadow);
            this.E = (MaskView) this.f19646g.findViewById(R.id.mask_view);
            this.l.setOnClickListener(this.G1);
            F3();
            B3();
            w3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.j = videoPbFragmentAdapter;
            this.f19648i.setAdapter(videoPbFragmentAdapter);
            this.f19647h.setViewPager(this.f19648i);
            this.f19647h.setOnPageChangeListener(new n0(this));
            this.S = this.f19646g.findViewById(R.id.viewstub_progress);
            y3();
            A3();
            x3();
            if (!this.u1 && this.v1) {
                N4();
                UtilHelper.hideStatusBar(z(), z().getRootView());
                this.v1 = false;
            }
            if (!I3() || d.a.r0.c1.b.e.d()) {
                this.f19647h.getLayoutParams().height = 0;
            }
            if (d.a.r0.c1.b.e.d()) {
                this.f19648i.setScrollable(false);
            }
        }
    }

    public final void G4(d.a.s0.h2.h.e eVar) {
        d.a.s0.h2.o.i.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) || (F = eVar.F()) == null || F.p) {
            return;
        }
        C2(F);
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if ((y() != null && y().D0().e0()) || this.H0 == null || y() == null || y().D0() == null || ThreadCardUtils.isSelf(y().D0().N()) || y().D0().d() == null) {
                return true;
            }
            return this.H0.checkPrivacyBeforeInvokeEditor(y().D0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.p == null) {
            this.p = new d.a.s0.h2.o.e(getBaseFragmentActivity(), this.n);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? d.a.c.e.p.l.r(z()) : 0;
            Rect rect = new Rect(0, r2, d.a.c.e.p.l.k(getContext()), this.n.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.p.r(videoPbViewModel.h(), rect);
            if (this.p.l()) {
                this.p.q(new j0(this, videoPbViewModel));
            } else if (!d.a.r0.c1.b.e.d() && I3() && (videoPbViewModel.m() || y().S0() == R1)) {
                this.f19648i.setCurrentItem(R1);
            } else if (videoPbViewModel.m() || y().S0() == S1) {
                this.f19648i.setCurrentItem(S1);
            }
        }
    }

    public void H4() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (view = this.S) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public boolean I2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            if (this.H0 == null || y() == null || y().D0() == null || ThreadCardUtils.isSelf(y().D0().N()) || y().D0().d() == null) {
                return true;
            }
            return this.H0.checkPrivacyBeforeSend(y().D0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? y() != null && y().g1() : invokeV.booleanValue;
    }

    public final void I4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            d.a.s0.h2.o.j.b.c(z(), W2(), i2);
        }
    }

    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (!checkUpIsLogin()) {
                if (y() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", y().getForumId()));
                }
            } else if (H2()) {
                d.a.r0.w.w.e eVar = this.N0;
                if (eVar != null && (eVar.B() || this.N0.D())) {
                    this.N0.z(false, null);
                    return;
                }
                if (this.O0 != null) {
                    D3();
                    this.z0.f19656a = false;
                    if (this.O0.n(2) != null) {
                        d.a.s0.h3.g0.a.c(getPageContext(), (View) this.O0.n(2).k, false, null);
                    }
                }
                q3();
            }
        }
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            d.a.s0.h2.o.k.a aVar = this.o;
            return aVar != null && aVar.R0();
        }
        return invokeV.booleanValue;
    }

    public final void J4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || y() == null || d.a.c.e.p.k.isEmpty(y().T0())) {
            return;
        }
        d.a.r0.a.d.y().P(d.a.r0.a.c.W, d.a.c.e.m.b.f(y().T0(), 0L));
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (y().j0() || y().m0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", y().T0());
                this.f19644e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, y().T0()));
            if (T4()) {
                this.f19644e.finish();
            }
        }
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v1 : invokeV.booleanValue;
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.z.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            V4();
        }
    }

    public void L2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            List<PostData> list = y().D0().S().f60195a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).M().size()) {
                        break;
                    } else if (bVar.f21139g.equals(list.get(i2).M().get(i3).E())) {
                        list.get(i2).M().remove(i3);
                        list.get(i2).l();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).n(bVar.f21139g);
            }
            if (z2) {
                if (X2() != null) {
                    X2().i1();
                } else if (I3() && m3() != null) {
                    m3().f1();
                }
            }
        }
    }

    public boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            d.a.s0.h2.o.k.a aVar = this.o;
            if (aVar == null) {
                return false;
            }
            return aVar.S0();
        }
        return invokeV.booleanValue;
    }

    public void L4(d.a.r0.t.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048612, this, aVar, bitmap, i2) == null) && d.a.s0.h2.k.e.r0.a(aVar, i2)) {
            Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new p0(this, random));
            bVar.q(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d.a.s0.h2.p.c l2 = bVar.l();
            this.P.f();
            this.P.a(l2, 22);
            d.a.c.e.m.e.a().postDelayed(this.M1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.Q;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new q0(this, aVar, i2));
            }
        }
    }

    public void M2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(T1)).intValue();
            if (intValue == U1) {
                if (this.Z.O()) {
                    return;
                }
                showProgressBar();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (jSONArray != null) {
                    this.Z.Q(StringHelper.JsonArrayToString(jSONArray));
                }
                this.Z.R(y().D0().m().getId(), y().D0().m().getName(), y().D0().N().c0(), str, intValue3, intValue2, booleanValue, y().D0().N().J());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == V1 || intValue == W1) {
                if (y().b0() != null) {
                    y().b0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == V1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void M3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void M4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (layoutParams = this.z.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.z.setAlpha(0.0f);
            this.z.setVisibility(0);
            X4(layoutParams);
        }
    }

    public void N2(d.a.r0.r.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (y() == null || y().D0() == null || y().D0().N() == null || y().D0().m() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    M2((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final void N3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.B1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
                this.B1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.B1.start();
        }
    }

    public void O2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(T1, Integer.valueOf(U1));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                M2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.r0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.r0.setImageResource(0);
                this.r0.M(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.r0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.A1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
                this.A1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.A1.start();
        }
    }

    public void P2(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) || (appBarLayout = this.m) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public final void P3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048623, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || F2() || !H2()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.S0);
            this.T0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.P0 != null && postData != null) {
            this.P0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (y() != null && y().D0() != null && y().D0().e0()) {
            d.a.c.e.m.e.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        if (this.J0 == null) {
            d.a.s0.u0.f2.a.c cVar = new d.a.s0.u0.f2.a.c(getPageContext());
            this.J0 = cVar;
            cVar.k(1);
            this.J0.j(new i1(this, str, str2));
        }
        if (y() == null || y().D0() == null || y().D0().m() == null) {
            return;
        }
        this.J0.h(y().D0().m().getId(), d.a.c.e.m.b.f(y().T0(), 0L));
    }

    public final void P4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        PbActivity.e n2;
        PostData Z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String T0 = y().T0();
            String E = postData.E();
            String E2 = postData2 != null ? postData2.E() : "";
            int U = y().D0() != null ? y().D0().U() : 0;
            if (m3() != null && m3().d1() != null) {
                n2 = m3().d1().n(E);
            } else if (X2() == null || X2().f1() == null) {
                return;
            } else {
                n2 = X2().f1().n(E);
            }
            PbActivity.e eVar = n2;
            if (postData == null || y() == null || y().D0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(T0, E, "pb", true, null, false, E2, U, postData.O(), y().D0().d(), false, postData.t().getIconInfo()).addBigImageData(eVar.f19136a, eVar.f19137b, eVar.f19142g, eVar.j);
            boolean z4 = true;
            if (z3) {
                addBigImageData.setHighLightPostId(E2);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(y().getForumId());
            addBigImageData.setBjhData(y().Y());
            addBigImageData.setKeyPageStartFrom(y().C0());
            addBigImageData.setFromFrsForumId(y().getFromForumId());
            addBigImageData.setIsOpenEditor(z2);
            if (y().D0().p() != null) {
                addBigImageData.setHasForumRule(y().D0().p().has_forum_rule.intValue());
            }
            if (y().D0().T() != null) {
                addBigImageData.setIsManager(y().D0().T().getIs_manager());
            }
            if (y().D0().m().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(y().D0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(y().D0().m().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (y().D0().m() != null) {
                addBigImageData.setForumHeadUrl(y().D0().m().getImage_url());
                addBigImageData.setUserLevel(y().D0().m().getUser_level());
            }
            if (y() != null && (Z2 = Z2(y().D0())) != null) {
                if (!Z2.S && !postData.S) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void Q2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048625, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f21134b) ? bVar.f21134b : getString(R.string.delete_fail);
            int i2 = 0;
            if (bVar.f21135c == 1211066) {
                hideProgressBar();
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new r(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                R2(0, bVar.f21133a, bVar.f21134b, z2);
            }
            if (bVar.f21133a) {
                int i3 = bVar.f21136d;
                if (i3 == 1) {
                    ArrayList<PostData> E = y().D0().E();
                    int size = E.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f21139g.equals(E.get(i2).E())) {
                            E.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    y().D0().N().R3(y().D0().N().P0() - 1);
                    if (X2() != null) {
                        X2().i1();
                    } else if (I3() && m3() != null) {
                        m3().f1();
                    }
                } else if (i3 == 0) {
                    K2();
                } else if (i3 == 2) {
                    ArrayList<PostData> E2 = y().D0().E();
                    int size2 = E2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= E2.get(i4).M().size()) {
                                break;
                            } else if (bVar.f21139g.equals(E2.get(i4).M().get(i5).E())) {
                                E2.get(i4).M().remove(i5);
                                E2.get(i4).l();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        E2.get(i4).n(bVar.f21139g);
                    }
                    if (z3) {
                        if (X2() != null) {
                            X2().i1();
                        } else if (I3() && m3() != null) {
                            m3().f1();
                        }
                    }
                    L2(bVar);
                }
            }
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || y() == null) {
            return;
        }
        d.a.s0.h2.h.e D0 = y().D0();
        y().X1(true);
        d.a.r0.h.a aVar = this.V;
        if (aVar != null) {
            D0.w0(aVar.g());
        }
        if (I3()) {
            if (Y2() != null) {
                Y2().R0();
            }
            if (m3() != null) {
                m3().f1();
            }
        } else if (X2() != null) {
            X2().i1();
        }
    }

    public void Q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            FallingView fallingView = this.P;
            if (fallingView != null) {
                fallingView.g();
            }
            if (this.Q != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.M1);
                this.Q.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.r
    public void R(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048628, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.r0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.r0.b1.m.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (d.a.s0.h2.k.e.y0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.r0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void R2(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.success));
            } else if (z3) {
                if (d.a.c.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                showToast(str);
            }
        }
    }

    public final void R3() {
        MarkData W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || y() == null || y().D0() == null) {
            return;
        }
        if (I3() && m3() == null) {
            return;
        }
        if ((I3() || X2() != null) && this.V != null) {
            if (y().D0() != null && y().D0().e0()) {
                W = y().W(0);
            } else {
                CustomViewPager customViewPager = this.f19648i;
                if (customViewPager != null && customViewPager.getCurrentItem() == Q1) {
                    W = y().x0(Z2(y().D0()));
                } else if (I3()) {
                    W = y().W(m3().Y0());
                } else {
                    W = y().W(X2().a1());
                }
            }
            if (W == null) {
                return;
            }
            if (W.isApp() && (W = y().W(m3().Y0() + 1)) == null) {
                return;
            }
            x4();
            this.V.i(W);
            if (!this.V.e()) {
                this.V.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.V.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void R4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (voiceManager = this.a0) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final void S2(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048632, this, i2, gVar) == null) || gVar == null || y() == null || y().D0() == null || y().D0().N() == null) {
            return;
        }
        R2(this.Z.getLoadDataMode(), gVar.f21154a, gVar.f21155b, false);
        if (gVar.f21154a) {
            this.D0 = true;
            if (i2 == 2 || i2 == 3) {
                this.E0 = true;
                this.F0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.E0 = false;
                this.F0 = true;
            }
            if (i2 == 2) {
                y().D0().N().C3(1);
                y().N1(1);
            } else if (i2 == 3) {
                y().D0().N().C3(0);
                y().N1(0);
            } else if (i2 == 4) {
                y().D0().N().D3(1);
                y().O1(1);
            } else if (i2 == 5) {
                y().D0().N().D3(0);
                y().O1(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f21155b)) {
                string = gVar.f21155b;
            } else {
                string = getString(R.string.operation_failed);
            }
            d.a.c.e.p.l.M(getPageContext().getPageActivity(), string);
        }
        if (I3()) {
            if (y().D0().N() == null || Y2() == null) {
                return;
            }
            Y2().Y0();
        } else if (y().D0().N() == null || X2() == null) {
        } else {
            X2().o1();
        }
    }

    public final boolean S3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p2 = d.a.r0.r.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    d.a.r0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void S4() {
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (pbActivity = this.f19644e) == null) {
            return;
        }
        pbActivity.superCloseActivity();
    }

    public final String T2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
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

    public final boolean T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (y() == null) {
                return true;
            }
            if (y().D0() == null || !y().D0().e0()) {
                if (y().p0()) {
                    MarkData c02 = y().c0();
                    if (c02 != null && y().n0() && l3() != null) {
                        MarkData W = y().W(l3().getFirstVisiblePosition());
                        if (W == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", c02);
                            this.f19644e.setResult(-1, intent);
                            return true;
                        } else if (W.getPostId() != null && !W.getPostId().equals(c02.getPostId())) {
                            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getBaseFragmentActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new t(this, W, c02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new u(this, c02, aVar));
                            aVar.setOnCalcelListener(new w(this));
                            aVar.create(getBaseFragmentActivity().getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", c02);
                            this.f19644e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (y().D0() != null && y().D0().E() != null && y().D0().E().size() > 0 && y().n0()) {
                    this.f19644e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public d.a.r0.s.e.a U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.Y : (d.a.r0.s.e.a) invokeV.objValue;
    }

    public void U3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
            this.l.setVisibility(z2 ? 0 : 8);
        }
    }

    public void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            d.a.r0.w.w.e eVar = this.N0;
            if (eVar != null) {
                r4(eVar.C());
            }
            j4();
            this.T.F();
        }
    }

    public LinearLayout V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.q0 : (LinearLayout) invokeV.objValue;
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (!d.a.c.e.p.j.z()) {
                showToast(R.string.network_not_available);
            } else if (this.T == null || y() == null) {
            } else {
                this.T.F();
                if (this.R) {
                    return;
                }
                R4();
                x4();
                if (y().LoadData()) {
                    H4();
                }
            }
        }
    }

    public final void V4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (layoutParams = this.z.getLayoutParams()) == null) {
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

    public final int W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (y() == null || y().D0() == null || y().D0().N() == null) {
                return -1;
            }
            return y().D0().N().q();
        }
        return invokeV.intValue;
    }

    public void W3(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            if (i2 == 0) {
                d.a.s0.g3.c.g().h(getUniqueId(), false);
                if (l3() != null) {
                    E2(l3(), true);
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

    public final void W4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.N = ofFloat;
            ofFloat.setDuration(300L);
            this.N.addUpdateListener(new r1(this));
            this.N.start();
        }
    }

    public DetailInfoAndReplyFragment X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.i(S1) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.j.i(S1);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public void X3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z2) == null) || z() == null) {
            return;
        }
        if (this.v1 && !TbSingleton.getInstance().isNotchScreen(z()) && !TbSingleton.getInstance().isCutoutScreen(z())) {
            N4();
            UtilHelper.hideStatusBar(z(), z().getRootView());
            this.v1 = false;
        }
        this.z0.f19657b = z2;
        Z3();
        c4();
    }

    public final void X4(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, layoutParams) == null) {
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

    @Override // d.a.s0.h2.o.b
    public PbModel.g Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.c1 : (PbModel.g) invokeV.objValue;
    }

    public DetailInfoFragment Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.i(Q1) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.j.i(Q1);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public void Y3(d.a.r0.t.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048651, this, aVar, i2) == null) && d.a.s0.h2.k.e.r0.a(aVar, i2)) {
            this.Q.M(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), getPageContext()).subscribe(new o0(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public final void Y4(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, layoutParams) == null) {
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

    public PostData Z2(d.a.s0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, eVar)) == null) {
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
                postData = k3(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || this.o == null) {
            return;
        }
        if (this.z0.a()) {
            this.o.X(false);
            return;
        }
        d.a.s0.h2.o.k.a aVar = this.o;
        aVar.X(!aVar.S0());
    }

    public final void Z4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || y() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(y().getForumId()) || y().D0() == null || y().D0().m() == null) {
            return;
        }
        if (y().D0().m().isLike() == 1) {
            y().T().A(y().getForumId(), y().T0());
        }
    }

    public final String a3() {
        InterceptResult invokeV;
        ArrayList<PostData> E;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (y() == null || y().D0() == null || y().D0().E() == null || (count = ListUtils.getCount((E = y().D0().E()))) == 0) {
                return "";
            }
            if (y().O0()) {
                Iterator<PostData> it = E.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int i2 = 0;
            if (l3() != null) {
                if (I3()) {
                    i2 = m3().W0();
                } else {
                    i2 = X2().Y0();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(E, i2);
            if (postData != null && postData.t() != null) {
                if (y().j1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(E, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (y().j1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(E, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (y().j1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void a4(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, eVar) == null) || eVar == null) {
            return;
        }
        d.a.r0.r.q.b2 N = eVar.N();
        if (N != null && N.p2()) {
            D2();
        } else {
            u4(this.M0);
        }
        d.a.r0.w.w.e eVar2 = this.N0;
        if (eVar2 != null) {
            r4(eVar2.C());
            this.N0.M(eVar.d());
            this.N0.N(eVar.m(), eVar.T());
            this.N0.r0(N);
            if (y() != null) {
                this.N0.O(y().h0(), y().T0(), y().e0());
            }
            if (N != null) {
                this.N0.h0(N.b2());
            }
        }
    }

    public void a5(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.N())) {
                d.a.s0.h2.p.h hVar = this.w0;
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
            d.a.s0.h2.p.h hVar2 = this.w0;
            if (hVar2 == null || !hVar2.e()) {
                ViewGroup.LayoutParams layoutParams2 = this.v0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.v0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.v0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || !checkUpIsLogin() || y() == null || y().D0() == null || y().D0().m() == null || F2()) {
            return;
        }
        if (y().D0().e0()) {
            J2();
            return;
        }
        if (this.I0 == null) {
            d.a.s0.u0.f2.a.c cVar = new d.a.s0.u0.f2.a.c(getPageContext());
            this.I0 = cVar;
            cVar.k(0);
            this.I0.j(new b1(this));
        }
        this.I0.h(y().D0().m().getId(), d.a.c.e.m.b.f(y().T0(), 0L));
    }

    public void b5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            DetailInfoAndReplyFragment X2 = X2();
            if (X2 != null && X2.G0() != null && X2.G0().l() != null && X2.G0().m() != null) {
                X2.G0().l().X0(z2);
                X2.G0().m().s0(z2);
            }
            MaskView maskView = this.E;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public View.OnClickListener c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.G1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || this.o == null || this.f19648i == null) {
            return;
        }
        boolean z2 = false;
        if (!I3()) {
            this.o.W0(false);
        } else if (this.f19648i.getCurrentItem() != 0) {
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

    public View.OnClickListener d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.H1 : (View.OnClickListener) invokeV.objValue;
    }

    public void d4(boolean z2, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.j.j()) {
                if (baseFragment instanceof d.a.s0.h2.o.a) {
                    ((d.a.s0.h2.o.a) baseFragment).z0(z2, i2, i3, i4, eVar, str, i5);
                }
            }
            z0(z2, i2, i3, i4, eVar, str, i5);
        }
    }

    public SparseArray<Object> e3(d.a.s0.h2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData Z2;
        d.a.r0.r.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048666, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (Z2 = Z2(eVar)) == null) {
                return null;
            }
            String userId = Z2.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, Z2.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (Z2.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, Z2.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, Z2.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, Z2.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, Z2.E());
                }
                sparseArray.put(R.id.tag_del_post_id, Z2.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<d.a.r0.r.q.x1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (d.a.r0.r.q.x1 x1Var : q2) {
                        if (x1Var != null && !StringUtils.isNull(x1Var.h()) && (e0Var = x1Var.f56101g) != null && e0Var.f55926a && !e0Var.f55928c && ((i3 = e0Var.f55927b) == 1 || i3 == 2)) {
                            sb.append(d.a.c.e.p.k.cutString(x1Var.h(), 12));
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

    public void e4(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048667, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        a5(eVar);
        this.u0.setVisibility(eVar.e0() ? 8 : 0);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String T2 = T2(eVar.N().P0());
        TextView textView = this.x0;
        if (textView != null) {
            textView.setText(T2);
        }
        TextView textView2 = this.y0;
        if (textView2 != null) {
            textView2.setText(T2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.N()));
    }

    public d.a.r0.h.a f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.V : (d.a.r0.h.a) invokeV.objValue;
    }

    public void f4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048669, this, z2, markData) == null) || y() == null) {
            return;
        }
        w4();
        y().X1(z2);
        d.a.r0.h.a aVar = this.V;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.V.i(markData);
            }
        }
        if (y().p0()) {
            Q3();
        } else if (I3()) {
            if (Y2() != null) {
                Y2().R0();
            }
            if (m3() != null) {
                m3().f1();
            }
        } else if (X2() != null) {
            X2().i1();
        }
    }

    @Override // d.a.s0.h2.o.b
    public void finish() {
        CardHListViewData r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            PbModel pbModel = this.f19644e.getPbModel();
            if (pbModel != null && pbModel.D0() != null && !pbModel.D0().e0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.D0().N().c0();
                if (pbModel.isShareThread() && pbModel.D0().N().u1 != null) {
                    historyMessage.threadName = pbModel.D0().N().u1.f12231b;
                } else {
                    historyMessage.threadName = pbModel.D0().N().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.D0().m().getName();
                }
                ArrayList<PostData> E = pbModel.D0().E();
                int W0 = m3() != null ? m3().W0() : 0;
                if (E != null && W0 >= 0 && W0 < E.size()) {
                    historyMessage.postID = E.get(W0).E();
                }
                historyMessage.isHostOnly = pbModel.i0();
                historyMessage.isSquence = pbModel.R0();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            d.a.r0.w.w.e eVar = this.N0;
            if (eVar != null) {
                eVar.I();
            }
            if (pbModel != null && (pbModel.j0() || pbModel.m0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.T0());
                if (this.D0) {
                    if (this.F0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.s0());
                    }
                    if (this.E0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.o0());
                    }
                }
                if (pbModel.D0() != null && System.currentTimeMillis() - this.f19645f >= 40000 && (r2 = pbModel.D0().r()) != null && !ListUtils.isEmpty(r2.getDataList())) {
                    intent.putExtra("guess_like_data", r2);
                }
                this.f19644e.setResult(-1, intent);
            }
            if (T4()) {
                if (pbModel != null) {
                    d.a.s0.h2.h.e D0 = pbModel.D0();
                    if (D0 != null) {
                        if (D0.T() != null) {
                            D0.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.G0) {
                            if (this.n != null) {
                                Rect rect = new Rect();
                                this.n.getGlobalVisibleRect(rect);
                                d.a.s0.h2.k.e.m0.b().t(rect);
                            }
                            d.a.s0.h2.k.e.m0.b().s(this.f19648i.getCurrentItem());
                            BdTypeRecyclerView l3 = l3();
                            d.a.s0.h2.k.e.m0.b().n(pbModel.E0(), l3 != null ? l3.onSaveInstanceState() : null, pbModel.R0(), pbModel.i0(), false);
                        }
                    }
                } else {
                    d.a.s0.h2.k.e.m0.b().m();
                }
                S4();
            }
        }
    }

    public View.OnLongClickListener g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.O1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void g4(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        String valueOf = String.valueOf(eVar.N().P0());
        if (eVar.N().P0() == 0) {
            valueOf = "";
        }
        this.f19647h.F(valueOf);
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (this.b0 == null) {
                this.b0 = new d.a.c.e.k.b<>(new t1(this), 20, 0);
            }
            return this.b0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (this.i0 == null) {
                this.i0 = new d.a.c.e.k.b<>(new s1(this), 8, 0);
            }
            return this.i0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new w1(this), 10, 0);
            this.l0 = bVar;
            return bVar;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (this.c0 == null) {
                this.c0 = TbRichTextView.y(getPageContext().getPageActivity(), 8);
            }
            return this.c0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            if (this.k0 == null) {
                this.k0 = new d.a.c.e.k.b<>(new v1(this), 15, 0);
            }
            return this.k0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            if (this.a0 == null) {
                this.a0 = VoiceManager.instance();
            }
            return this.a0;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (this.j0 == null) {
                this.j0 = new d.a.c.e.k.b<>(new u1(this), 8, 0);
            }
            return this.j0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    public View.OnTouchListener h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.D1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void h4(d.a.s0.h2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048684, this, rVar) == null) || y() == null || y().D0() == null || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> E2 = y().D0().E();
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
                            next.z0(getPageContext(), y().j1(metaData.getUserId()));
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
        if (y().n0() || !z2) {
            return;
        }
        if (I3() && m3() != null) {
            m3().f1();
        } else if (X2() != null) {
            X2().i1();
        }
    }

    public d.a.r0.w.w.e i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.N0 : (d.a.r0.w.w.e) invokeV.objValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || this.N0 == null || this.O0 == null) {
            return;
        }
        d.a.r0.w.w.a.a().c(0);
        this.N0.T();
        this.N0.R();
        if (this.N0.y() != null) {
            this.N0.y().setMaxImagesAllowed(this.N0.z ? 1 : 9);
        }
        this.N0.l0(SendView.k);
        this.N0.j(SendView.k);
        d.a.r0.w.h m2 = this.O0.m(23);
        d.a.r0.w.h m3 = this.O0.m(2);
        d.a.r0.w.h m4 = this.O0.m(5);
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

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            d.a.r0.h.a c2 = d.a.r0.h.a.c(this.f19644e);
            this.V = c2;
            if (c2 != null) {
                c2.j(this.d1);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f19644e);
            this.Z = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.C1);
            this.Y = new d.a.r0.s.e.a(getPageContext());
            this.T = new d.a.s0.h2.o.g.a(this);
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            PbModel pbModel = this.f19644e.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.i1();
        }
        return invokeV.booleanValue;
    }

    public final int j3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048689, this, i2)) == null) {
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

    public void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            i4();
            s3();
            this.P0.c();
            E4(false);
        }
    }

    public final PostData k3(d.a.s0.h2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null || eVar.N().H() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData H = eVar.N().H();
            String userId = H.getUserId();
            HashMap<String, MetaData> u12 = eVar.N().u1();
            if (u12 != null && (metaData = u12.get(userId)) != null && metaData.getUserId() != null) {
                H = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.N().T());
            postData.x0(eVar.N().getTitle());
            postData.w0(eVar.N().N());
            postData.g0(H);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.height = 0;
            this.z.setLayoutParams(layoutParams);
            this.z.setVisibility(8);
        }
    }

    public BdTypeRecyclerView l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            Iterator<BaseFragment> it = this.j.j().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).b1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).Z0();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.U0 = -1;
            this.V0 = Integer.MIN_VALUE;
        }
    }

    public ReplyFragment m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.i(R1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.j.i(R1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public boolean m4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && d.a.r0.r.k.c().g()) {
                        return S3(postData.E());
                    }
                    if (checkUpIsLogin() && y() != null && y().D0() != null) {
                        d.a.s0.h2.k.e.u uVar = this.P0;
                        if (uVar != null) {
                            uVar.c();
                        }
                        d.a.s0.h2.h.r rVar = new d.a.s0.h2.h.r();
                        rVar.A(y().D0().m());
                        rVar.E(y().D0().N());
                        rVar.C(postData);
                        this.Q0.I(rVar);
                        this.Q0.setPostId(postData.E());
                        P3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.a.r0.w.w.e eVar = this.N0;
                        if (eVar != null) {
                            r4(eVar.C());
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

    public String n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            if (!d.a.c.e.p.k.isEmpty(this.A0)) {
                return this.A0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(d.a.s0.h2.k.e.r0.b());
            this.A0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void n4(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048698, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.W == null) {
            d.a.s0.h2.k.e.b1.f.a aVar = new d.a.s0.h2.k.e.b1.f.a(this.f19644e);
            this.W = aVar;
            aVar.n(this.F1);
            this.W.m(this.o1);
        }
        this.W.k(emotionImageData, y(), y().D0());
    }

    public final void o3(int i2, Intent intent) {
        d.a.r0.w.n nVar;
        d.a.s0.h2.k.e.u uVar;
        d.a.r0.w.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048699, this, i2, intent) == null) {
            if (i2 == 0) {
                s3();
                d.a.s0.h2.k.e.u uVar2 = this.P0;
                if (uVar2 != null) {
                    uVar2.c();
                }
                E4(false);
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
                    this.N0.S();
                    this.N0.t0(pbEditorData.getVoiceModel());
                    this.N0.G(writeData);
                    d.a.r0.w.m n2 = this.N0.a().n(6);
                    if (n2 != null && (nVar = n2.k) != null) {
                        nVar.onAction(new d.a.r0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.N0.L(null, null);
                    }
                } else if (editorType != 1 || (uVar = this.P0) == null || uVar.b() == null) {
                } else {
                    d.a.r0.w.w.h b3 = this.P0.b();
                    b3.X(y().D0().N());
                    b3.z(writeData);
                    b3.Y(pbEditorData.getVoiceModel());
                    d.a.r0.w.m n3 = b3.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new d.a.r0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.D();
                    }
                }
            }
        }
    }

    public final void o4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048700, this, i2) == null) || y() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(y().T0());
        sendMessage(privacySettingMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            a4(videoPbViewModel.c());
            E3(videoPbViewModel.c());
            g4(videoPbViewModel.c());
            if (y() != null && y().D0() != null) {
                boolean n02 = y().n0();
                d.a.s0.h2.h.e D0 = y().D0();
                if (n02) {
                    PostData Z2 = Z2(D0);
                    if (D0.u() != null && !D0.u().equals(Z2.E()) && this.f19648i != null) {
                        if (I3()) {
                            this.f19648i.setCurrentItem(R1);
                        } else {
                            this.f19648i.setCurrentItem(S1);
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
        if (interceptable == null || interceptable.invokeIIL(1048702, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.N0.H(i2, i3, intent);
            d.a.s0.h2.k.e.b1.f.a aVar = this.W;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            d.a.s0.h2.k.e.u uVar = this.P0;
            if (uVar != null) {
                uVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                o3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    R3();
                } else if (i2 == 13011) {
                    d.a.s0.v2.a.g().m(getPageContext());
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
                            if (V2() != null) {
                                V2().performClick();
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
                    if (I2(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        n4(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048703, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.m0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, context) == null) {
            super.onAttach(context);
            this.f19644e = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f19644e);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f19646g);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.f19647h, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f19647h;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            d.a.s0.h2.k.e.v0 v0Var = this.K0;
            if (v0Var != null) {
                v0Var.i();
            }
            d.a.s0.h2.o.e eVar = this.p;
            if (eVar == null || !eVar.k()) {
                SkinManager.setBackgroundColor(this.f19646g, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.O0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            d.a.s0.h2.k.e.u uVar = this.P0;
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
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (y() != null && y().p0()) {
                WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.J, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (y() != null) {
                a5(y().D0());
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
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
            int i3 = R.color.CAM_X0207;
            SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
            if (X2() != null) {
                X2().onChangeSkinType(i2);
            } else if (I3() && m3() != null) {
                m3().onChangeSkinType(i2);
            }
            if (Y2() != null) {
                Y2().onChangeSkinType(i2);
            }
            View view = this.M;
            if (view != null) {
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            R4();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            d.a.s0.h2.o.k.a aVar = this.o;
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
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            this.f19645f = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            z3(bundle);
            getVoiceManager().onCreate(getPageContext());
            d.a.r0.r.f0.c cVar = new d.a.r0.r.f0.c();
            this.U = cVar;
            cVar.f55627a = 1000L;
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
            this.x = new d.a.s0.z.a(getPageContext());
            d.a.s0.g3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048708, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f19646g = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
            G3();
            return this.f19646g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            super.onDestroy();
            d.a.s0.g3.c.g().k(getUniqueId());
            getVoiceManager().onDestory(getPageContext());
            d.a.s0.h2.p.h hVar = this.w0;
            if (hVar != null) {
                hVar.g();
            }
            ForumManageModel forumManageModel = this.Z;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            d.a.s0.h2.o.k.a aVar = this.o;
            if (aVar != null) {
                aVar.T0();
            }
            d.a.s0.h2.k.e.b1.f.a aVar2 = this.W;
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
                if (y().z0() != null) {
                    y().z0().d();
                }
            }
            d.a.r0.w.w.e eVar = this.N0;
            if (eVar != null) {
                eVar.I();
            }
            this.U = null;
            Q4();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048710, this, i2, keyEvent)) == null) {
            if (!this.u1 && (this.v1 || J3())) {
                N4();
                UtilHelper.hideStatusBar(z(), z().getRootView());
                this.v1 = false;
                d.a.s0.h2.o.k.a aVar = this.o;
                if (aVar != null) {
                    aVar.X0(false);
                }
            }
            if (i2 == 4) {
                return this.o.D();
            }
            if (i2 == 24) {
                return this.o.e0();
            }
            if (i2 == 25) {
                return this.o.U0();
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // d.a.r0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048711, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.m0 = true;
    }

    @Override // d.a.r0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048712, this, context, str, z2) == null) {
            if (d.a.s0.h2.k.e.y0.c(str) && y() != null && y().T0() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", y().T0()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    d.a.r0.t.m mVar = new d.a.r0.t.m();
                    mVar.f56722a = str;
                    mVar.f56723b = 3;
                    mVar.f56724c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
                }
            } else {
                d.a.s0.h2.k.e.y0.a().e(getPageContext(), str);
            }
            this.m0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onPause();
            this.Y0 = true;
            getVoiceManager().onPause(getPageContext());
            this.o.r0(true);
            if (y() != null && !y().r0()) {
                this.N0.U(y().T0());
            }
            d.a.r0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.l1);
            MessageManager.getInstance().unRegisterListener(this.m1);
            MessageManager.getInstance().unRegisterListener(this.k1);
            MessageManager.getInstance().unRegisterListener(this.J1);
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048714, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.T.n0(str);
        d.a.r0.r.s.b R = this.T.R();
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
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onResume();
            this.Y0 = false;
            getVoiceManager().onResume(getPageContext());
            this.o.r0(false);
            J4();
            registerListener(this.l1);
            registerListener(this.m1);
            registerListener(this.k1);
            registerListener(this.J1);
            ItemCardHelper.p(this.L1);
            MessageManager.getInstance().registerListener(this.K1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (y() != null) {
                y().I1(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048717, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            d.a.s0.g3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.K1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z2) == null) {
            super.onUserChanged(z2);
            O3();
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048721, this, context, str) == null) {
            d.a.s0.h2.k.e.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.m0 = true;
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048722, this, context, str) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p3(boolean z2) {
        d.a.s0.h2.h.e D0;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) || y() == null || this.T == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (D0 = y().D0()) == null) {
            return;
        }
        d.a.r0.r.q.b2 N = D0.N();
        if (N != null && N.H() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", y().T0()).param("fid", D0.n()).param("obj_locate", 4).param("uid", N.H().getUserId()));
        }
        if (N != null) {
            if (N.E1()) {
                i2 = 2;
            } else if (N.H1()) {
                i2 = 3;
            } else if (N.F1()) {
                i2 = 4;
            } else if (N.G1()) {
                i2 = 5;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("tid", y().T0());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", y().getForumId());
            if (!z2) {
                statisticItem.param("obj_locate", 6);
            } else {
                statisticItem.param("obj_locate", 5);
            }
            statisticItem.param("obj_name", i2);
            statisticItem.param("obj_type", 2);
            if (N != null) {
                if (N.E1()) {
                    statisticItem.param("obj_type", 10);
                } else if (N.H1()) {
                    statisticItem.param("obj_type", 9);
                } else if (N.G1()) {
                    statisticItem.param("obj_type", 8);
                } else if (N.F1()) {
                    statisticItem.param("obj_type", 7);
                } else if (N.v1) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i3 = N.Z;
                    if (i3 == 0) {
                        statisticItem.param("obj_type", 1);
                    } else if (i3 == 40) {
                        statisticItem.param("obj_type", 2);
                    } else if (i3 == 49) {
                        statisticItem.param("obj_type", 3);
                    } else if (i3 == 54) {
                        statisticItem.param("obj_type", 4);
                    } else {
                        statisticItem.param("obj_type", 5);
                    }
                }
                statisticItem.param("nid", N.A0());
                statisticItem.param("card_type", N.L0());
                statisticItem.param("recom_source", N.T0);
                statisticItem.param("ab_tag", N.V0);
                statisticItem.param("weight", N.U0);
                statisticItem.param("extra", N.W0);
                statisticItem.param("nid", N.A0());
                if (N.J() != null && !d.a.c.e.p.k.isEmpty(N.J().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, N.J().oriUgcVid);
                }
            }
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (z() != null) {
                d.a.r0.j0.c.e(z(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
            if (d.a.c.e.p.l.D()) {
                showToast(R.string.neterror);
                return;
            } else if (y().D0() == null) {
                d.a.c.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> E = D0.E();
                if ((E == null || E.size() <= 0) && y().R0()) {
                    d.a.c.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                    return;
                }
                this.T.F();
                R4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), N)) {
                    return;
                }
                d.a.s0.h2.p.h hVar = this.w0;
                if (hVar != null) {
                    hVar.h(false);
                    a5(D0);
                }
                if (ShareSwitch.isOn()) {
                    I4(z2 ? 2 : 1);
                    return;
                }
                this.T.v0();
                y().a0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem2.param("tid", y().T0());
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("fid", y().getForumId());
        if (!z2) {
        }
        statisticItem2.param("obj_name", i2);
        statisticItem2.param("obj_type", 2);
        if (N != null) {
        }
        if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (z() != null) {
        }
        TiebaStatic.log(statisticItem2);
        if (d.a.c.e.p.l.D()) {
        }
    }

    public void p4(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048724, this, i2) == null) || (linearLayout = this.n0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048725, this) == null) || this.p0 == null) {
            return;
        }
        this.o0.setVisibility(8);
        this.p0.setVisibility(8);
        this.z0.f19656a = false;
        Z3();
        c4();
    }

    public void q4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, editorTools) == null) {
            this.O0 = editorTools;
            editorTools.setId(R.id.pb_editor);
            this.O0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.O0.getParent() == null) {
                this.f19646g.addView(this.O0, layoutParams);
            }
            this.O0.w(TbadkCoreApplication.getInst().getSkinType());
            this.O0.setActionListener(24, new f1(this));
            s3();
            this.N0.i(new g1(this));
        }
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048727, this, z2) == null) || this.p0 == null || this.s0 == null) {
            return;
        }
        if (y() != null && y().D0() != null) {
            this.s0.setText(TbSingleton.getInstance().getAdVertiComment(y().D0().g0(), y().D0().h0(), n3()));
        } else {
            this.s0.setText(n3());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.p0.startAnimation(alphaAnimation);
        }
        this.o0.setVisibility(0);
        this.p0.setVisibility(0);
        this.z0.f19656a = true;
    }

    public void r4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z2) == null) {
            this.B0 = z2;
        }
    }

    public void s3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048729, this) == null) || (editorTools = this.O0) == null) {
            return;
        }
        editorTools.o();
    }

    public void s4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) {
            this.R = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f19648i) == null) {
                return;
            }
            videoPbFragmentAdapter.k(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || this.f19644e.getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getPageContext().getPageActivity(), this.f19644e.getCurrentFocus());
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048733, this, z2) == null) {
            this.v1 = z2;
        }
    }

    public void u3() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048734, this) == null) || (view = this.S) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void u4(d.a.r0.w.w.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048735, this, gVar) == null) || gVar == null || y() == null) {
            return;
        }
        gVar.o(y().f0());
        if (y().D0() != null && y().D0().m() != null) {
            gVar.n(y().D0().m());
        }
        gVar.p("pb");
        gVar.q(y());
    }

    @Override // d.a.s0.h2.o.b
    public VideoPbFragment v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this : (VideoPbFragment) invokeV.objValue;
    }

    public void v3() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || (rightFloatLayerView = this.a1) == null) {
            return;
        }
        rightFloatLayerView.f();
    }

    public void v4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048738, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            d.a.s0.h2.o.g.a aVar = this.T;
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

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            this.n0 = (LinearLayout) this.f19646g.findViewById(R.id.video_pb_comment_container);
            this.o0 = this.f19646g.findViewById(R.id.view_comment_top_line);
            this.p0 = this.f19646g.findViewById(R.id.pb_editor_tool_comment);
            d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
            HeadImageView headImageView = (HeadImageView) this.f19646g.findViewById(R.id.pb_editor_tool_comment_user_image);
            this.r0 = headImageView;
            headImageView.setVisibility(0);
            this.r0.setIsRound(true);
            this.r0.setBorderWidth(d.a.c.e.p.l.g(getContext(), R.dimen.L_X01));
            this.r0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.r0.setPlaceHolder(0);
            O3();
            this.s0 = (TextView) this.f19646g.findViewById(R.id.pb_editor_tool_comment_reply_text);
            LinearLayout linearLayout = (LinearLayout) this.f19646g.findViewById(R.id.pb_editer_tool_comment_layout);
            this.q0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.f19646g.findViewById(R.id.pb_editor_tool_comment_icon);
            this.t0 = imageView;
            imageView.setOnClickListener(this.G1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f19646g.findViewById(R.id.pb_editor_tool_collection);
            this.u0 = imageView2;
            imageView2.setOnClickListener(this.G1);
            if (booleanExtra) {
                this.u0.setVisibility(8);
            } else {
                this.u0.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) this.f19646g.findViewById(R.id.pb_editor_tool_share);
            this.v0 = imageView3;
            imageView3.setOnClickListener(this.G1);
            d.a.s0.h2.p.h hVar = new d.a.s0.h2.p.h(this.v0);
            this.w0 = hVar;
            hVar.d();
            TextView textView = (TextView) this.f19646g.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.x0 = textView;
            textView.setVisibility(0);
            E4(false);
            if (d.a.r0.c1.b.e.d()) {
                ViewGroup.LayoutParams layoutParams = this.n0.getLayoutParams();
                layoutParams.height = 0;
                this.n0.setLayoutParams(layoutParams);
            }
        }
    }

    public void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            hideProgressBar();
            if (I3() && m3() != null) {
                m3().T0();
                m3().U0();
            } else if (X2() != null) {
                X2().V0();
                X2().W0();
            }
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.Q0 = new PbFakeFloorModel(getPageContext());
            d.a.s0.h2.k.e.u uVar = new d.a.s0.h2.k.e.u(getPageContext(), this.Q0, this.f19646g);
            this.P0 = uVar;
            uVar.k(new x0(this));
            this.P0.m(this.E1);
            this.Q0.H(new y0(this));
        }
    }

    public void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            d.a.c.e.p.l.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // d.a.s0.h2.o.b
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? this.f19644e.getPbModel() : (PbModel) invokeV.objValue;
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            q4(this.N0.a());
        }
    }

    public final void y4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048745, this, i2) == null) || y() == null) {
            return;
        }
        int M0 = y().M0();
        if (i2 == 5) {
            y().U1(2);
        } else if (i2 == 6) {
            y().U1(3);
        } else if (i2 != 7) {
            y().U1(1);
        } else {
            y().U1(4);
        }
        int M02 = y().M0();
        if (M0 == 4 || M02 == 4) {
            V3();
        }
    }

    @Override // d.a.s0.h2.o.b
    public PbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.f19644e : (PbActivity) invokeV.objValue;
    }

    @Override // d.a.s0.h2.o.a
    public void z0(boolean z2, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048747, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || y() == null || y().D0() == null || y().D0().N() == null) {
            return;
        }
        d.a.r0.r.q.b2 N = y().D0().N();
        N.V0 = y().I0();
        N.U0 = y().L0();
        N.T0 = y().K0();
        N.W0 = y().J0();
        N.D2 = y().r0();
        if (N.Q() == 0) {
            N.l3(d.a.c.e.m.b.f(y().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.r0.j0.c.i(getContext(), N, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void z3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, bundle) == null) {
            d.a.r0.w.w.g gVar = new d.a.r0.w.w.g();
            this.M0 = gVar;
            u4(gVar);
            d.a.r0.w.w.e eVar = (d.a.r0.w.w.e) this.M0.a(getActivity());
            this.N0 = eVar;
            eVar.e0(this.f19644e.getPageContext());
            this.N0.n0(this.o1);
            this.N0.o0(this.F1);
            this.N0.g0(1);
            this.N0.F(this.f19644e.getPageContext(), bundle);
            this.N0.a().b(new d.a.r0.w.k(getActivity()));
            this.N0.a().C(true);
            B4(true);
            this.N0.O(y().h0(), y().T0(), y().e0());
            registerListener(this.g1);
            registerListener(this.i1);
            registerListener(this.q1);
            registerListener(this.f1);
            registerListener(this.h1);
            registerListener(this.j1);
            registerListener(this.N1);
            if (!y().r0()) {
                this.N0.s(y().T0());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.N0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (y().b1()) {
                this.N0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.N0.k0(n3());
            }
            this.K0 = new d.a.s0.h2.k.e.v0();
            if (this.N0.v() != null) {
                this.K0.m(this.N0.v().i());
            }
            this.N0.d0(this.e1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.H0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new k0(this));
        }
    }

    public void z4(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048750, this, i2) == null) || (view = this.k) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    /* loaded from: classes5.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f19656a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19657b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19658c;

        public b2(VideoPbFragment videoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19658c = videoPbFragment;
            this.f19657b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f19656a && this.f19657b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(VideoPbFragment videoPbFragment, k kVar) {
            this(videoPbFragment);
        }
    }
}
